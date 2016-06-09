package cmcm.com.shortcutdemo;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashSet;

/**
 * Created by sunzy on 16-4-21.
 */
public class Meitu {

    public Meitu(Context context){
        this.context = context;
    }

    private Context context;

    //add shortcut action
    public static final String INSTALL_SHORTCUT_ACTION = "com.android.launcher.action.INSTALL_SHORTCUT";

    public void createOnetapShortcut() {
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

    public boolean checkShortcutIsExists(String shortcutIntent) {

        Logger.v("launcher = " + Utils.getCurrentLockedLauncherPkg(context));
        // top 10 launchers which we had analyzed
        if (isSupportedLauncher(Utils.getCurrentLockedLauncherPkg(context))) {
            Logger.v("isSupportedLauncher!");
            return checkSupportLauncher(Utils.getCurrentLockedLauncherPkg(context), shortcutIntent);
        }

        // launchers which we have read permission
        return checkReadPermissionLauncher(Utils.getCurrentLockedLauncherPkg(context), shortcutIntent);
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
        for (int idx = 0; idx < providers.length; ++idx) {
            ProviderInfo info = providers[idx];
            Logger.v("provider, auth = " + info.authority + ", perm = " + info.readPermission);
        }
        return providers;
    }

    /**
     * 判定权限是否满足，找到第一个满足权限的provider
     * */
    private String parseFirstAUTHORITY2(Context c, String launcherPkg) {
        ProviderInfo[] providers = getProviderInfo(c, launcherPkg);
        ProviderInfo provider = parseFirstAUTHORITYFromProviderInfo(providers);
        Logger.v("provider = " + provider);
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
            "com.android.launcher3.permission.READ_SETTINGS",
            "com.oppo.launcher.permission.READ_SETTINGS",
            "com.huawei.android.launcher.permission.READ_SETTINGS",
            "com.bbk.launcher2.permission.READ_SETTINGS"};

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
        //uri = Uri.parse("content://com.oppo.launcher.settings/singledesktopitems?notify=true");
        uri = Uri.parse("content://com.android.launcher3.settings/favorites?notify=true");
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
                Logger.v("pkg = " + cursor.getString(cursor.getColumnIndex("title")));
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


    public void createOnetapShortcut2(){
        HashSet<Integer> screen2 = new HashSet();
        HashSet<Integer> screen3 = new HashSet();
        Uri uri = Uri.parse("content://com.bbk.launcher2.settings/favorites?notify=true");
        Cursor cursor = context.getContentResolver().query(uri, new String[]{"_id", "screen", "cellX", "cellY"}, null, null, null);
        int id = 0;
        while (cursor.moveToNext()){
            if(cursor.getInt(cursor.getColumnIndex("screen")) == 2){
                screen2.add(cursor.getInt(cursor.getColumnIndex("cellY")) * 4 + cursor.getInt(cursor.getColumnIndex("cellX")));
            } else if(cursor.getInt(cursor.getColumnIndex("screen")) == 3) {
                screen3.add(cursor.getInt(cursor.getColumnIndex("cellY")) * 4 + cursor.getInt(cursor.getColumnIndex("cellX")));
            }
            if(cursor.getInt(cursor.getColumnIndex("_id")) > id){
                id = cursor.getInt(cursor.getColumnIndex("_id"));
            }
        }
        cursor.close();
        id++;
        int screen = 0, cellX = 0, cellY = 0;
        for (int i = 8;i<19;i++){
            if(!screen2.contains(i)){
                screen = 2;
                cellX = i % 4;
                cellY = i / 4;
                break;
            }
        }
        if(screen == 0){
            for (int i = 0;i<20;i++){
                if(!screen3.contains(i)){
                    screen = 3;
                    cellX = i % 4;
                    cellY = i / 4;
                    break;
                }
            }
        }
        if(screen == 0){
            for (int i = 0;i<20;i++){
                if(!screen3.contains(i)){
                    screen = 4;
                    cellX = i % 4;
                    cellY = i / 4;
                    break;
                }
            }
        }

        Logger.v("id = " + id + ", screen = " + screen + ", x = " + cellX + ", y = " + cellY);

        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("title", "nimei");
        values.put("intent", "ok");
        values.put("container", -100);
        values.put("itemType", 1);
        values.put("appWidgetId", -1);
        values.put("iconType", 0);
        values.put("iconPackage", context.getPackageName());
        values.put("iconResource", "cmcm.com.shortcutdemo:drawable/boost_tag_onetap_shortcut");
        values.put("screen", screen);
        values.put("cellX", cellX);
        values.put("cellY", cellY);
        values.put("spanX", 1);
        values.put("spanY", 1);
        uri = context.getContentResolver().insert(uri, values);
        Logger.v("uri = " + uri);
    }

}
