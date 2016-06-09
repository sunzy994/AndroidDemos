package cmcm.com.shortcutdemo;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/**
 * Created by sunzy on 16-4-21.
 * research com.nick.kitkatlauncher on samsung
 */
public class Samsung {

    public Samsung(Context context){
        this.context = context;
    }

    private Context context;

    //add shortcut action
    public static final String INSTALL_SHORTCUT_ACTION = "com.android.launcher.action.INSTALL_SHORTCUT";

    private void createOnetapShortcut() {
        Intent shortcut = new Intent(INSTALL_SHORTCUT_ACTION);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Onkey Boost");
        // if(TextUtils.equals(LauncherUtil.getInst().getCurrentLauncherName(false), "com.nick.kitkatlauncher")){
        shortcut.setComponent(new ComponentName("com.nick.kitkatlauncher", "com.android.launcher3.InstallShortcutReceiver"));
        //}
        shortcut.putExtra("duplicate", true);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, R.drawable.boost_tag_onetap_shortcut));
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(context, Main2Activity.class));
        context.sendBroadcast(shortcut);
    }

    public boolean checkShortcutIsExists(String launcherPkg, String shortcutIntent) {
        // top 10 launchers which we had analyzed
        if (isSupportedLauncher(launcherPkg)) {
            Logger.v("isSupportedLauncher!");
            return checkSupportLauncher(launcherPkg, shortcutIntent);
        }

        // launchers which we have read permission
        return checkReadPermissionLauncher(launcherPkg, shortcutIntent);
    }

    public static boolean isSupportedLauncher(String launcherName) {
        if (!TextUtils.isEmpty(launcherName)) {

            if (launcherName.startsWith("com.sec.android.app.")
                    || launcherName.startsWith("com.android.launcher2")
                    || launcherName.startsWith("com.android.launcher")
                    || launcherName.startsWith("com.miui.home")
                    || launcherName.startsWith("com.motorola.blur.")
                    || launcherName.startsWith("com.lge.launcher2")
                    || launcherName.startsWith("com.miui.mihome2")) {
                return true;
            }
        }

        return false;
    }

    private boolean checkSupportLauncher(String launcher, String shortcutIntent) {

        int ver = android.os.Build.VERSION.SDK_INT;
        String AUTHORITY = null;

        if (isSupportedLauncher(launcher)) {
            AUTHORITY = parseFirstAUTHORITY(context, launcher);
        }

        if (TextUtils.isEmpty(AUTHORITY)) {
            if (ver < 8) {
                AUTHORITY = "com.android.launcher.settings";
            } else {
                AUTHORITY = "com.android.launcher2.settings";
            }
        }

        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
                + "/favorites?notify=true");
        return checkUriExist(CONTENT_URI, shortcutIntent);
    }

    private boolean checkReadPermissionLauncher(String launcher, String shortcutIntent) {
        Logger.v("check read permission launcher!");
        int ver = android.os.Build.VERSION.SDK_INT;
        String AUTHORITY = parseFirstAUTHORITY2(context, launcher);
        if (TextUtils.isEmpty(AUTHORITY)) {
            if (ver < 8) {
                AUTHORITY = "com.android.launcher.settings";
            } else {
                AUTHORITY = "com.android.launcher2.settings";
            }
        }

        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
                + "/favorites?notify=true");
        return checkUriExist(CONTENT_URI, shortcutIntent);
    }

    private String parseFirstAUTHORITY(Context c, String launcherPkg) {
        ProviderInfo[] providers = getProviderInfo(c, launcherPkg);
        if(providers != null && providers.length > 0) {
            return providers[0].authority;
        } else {
            return null;
        }
    }

    public ProviderInfo[] getProviderInfo(Context context, String packagename) {
        PackageInfo pi;
        ProviderInfo[] providers = null;
        try {
            pi = context.getPackageManager().getPackageInfo(packagename, PackageManager.GET_PROVIDERS);
            providers = pi.providers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providers;
    }

    /**
     * 判定权限是否满足，找到第一个满足权限的provider
     * */
    private String parseFirstAUTHORITY2(Context c, String launcherPkg) {
        ProviderInfo[] providers = getProviderInfo(c, launcherPkg);
        ProviderInfo provider = parseFirstAUTHORITYFromProviderInfo(providers);
        if (provider != null)
            return provider.authority;
        return null;
    }

    public static ProviderInfo parseFirstAUTHORITYFromProviderInfo(ProviderInfo[] providers) {
        if(providers != null && providers.length > 0) {
            for (int idx = 0; idx < providers.length; ++idx) {
                ProviderInfo info = providers[idx];
                Logger.v("provider, auth = " + info.authority + ", perm = " + info.readPermission + ", perm group = " + info.grantUriPermissions);
                if (providers[idx]!=null && !TextUtils.isEmpty(providers[idx].readPermission) &&
                        isRightPermission(providers[idx].readPermission)) {
                    return providers[idx];
                }
            }
        }
        return null;
    }

    final static String[] LAUNCHER_READ_PERMISSION = new String[] {
            "com.android.launcher.permission.READ_SETTINGS",
            "com.android.launcher3.permission.READ_SETTINGS"};

    private static boolean isRightPermission(String readPermission) {
        if (LAUNCHER_READ_PERMISSION != null) {
            for (String idx : LAUNCHER_READ_PERMISSION) {
                if (idx.equals(readPermission)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkUriExist(Uri uri, String shortcutIntent) {
        Logger.v("querying uri = " + uri + ", shortcutIntent = " + shortcutIntent);
        boolean isInstallShortcut = false;
        final ContentResolver cr = context.getContentResolver();
        Cursor cursor = null;
        // yhy 修改，利用Intent和IconRes判断快键方式是否存在可能更靠谱一点，避免中英文切换后找不到快捷方式
        try {
            //cursor = cr.query(uri, null, "intent like ? ", new String[] { "%" + shortcutIntent + "%" }, null);
            cursor = cr.query(uri, null, null,null,null);
            Logger.v("cursor = " + cursor);
            for (int i = 0;i < cursor.getColumnCount();i++){
                Logger.v("column name = " + cursor.getColumnName(i));
            }
            cursor.moveToFirst();
            do {
                //#Intent;component=cmcm.com.shortcutdemo/.Main2Activity;end 多了一个斜线
                Logger.v("intent = " + cursor.getString(cursor.getColumnIndex("intent")));
            } while (cursor.moveToNext());
            if (cursor != null && cursor.getCount() > 0) {
                isInstallShortcut = true;
            }
        } catch (Exception e) {
            Logger.wtf(e);
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }

        return isInstallShortcut;
    }


}
