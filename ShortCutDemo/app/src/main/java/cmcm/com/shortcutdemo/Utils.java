package cmcm.com.shortcutdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by sunzy on 16-4-21.
 */
public class Utils {

    public static String getCurrentLockedLauncherPkg(Context context) {
        if (null == context) {
            return null;
        }

        PackageManager pm = context.getPackageManager();
        if (null == pm) {
            return null;
        }

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = null;
        try {
            resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        } catch (Exception e) {
            e.printStackTrace();
            resolveInfo = null;

            /*
            * Caused by: android.os.TransactionTooLargeException
            * dumpkey=627781351
            */
        }

        if (null == resolveInfo || null == resolveInfo.activityInfo || null == resolveInfo.activityInfo.packageName) {
            return null;
        }

        ///< 多个launcher的情况下，没有设置默认的launcher，那么获取到的数据为android，故过滤掉
        if (resolveInfo.activityInfo.packageName.equals("android")) {
            return null;
        }

        return resolveInfo.activityInfo.packageName;
    }

    public static void printPermissionInfo(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            List<PermissionGroupInfo> groupList = pm.getAllPermissionGroups(0);
            groupList.add(null); // ungrouped permissions
            Method protectionToString = PermissionInfo.class.getDeclaredMethod("protectionToString",
                    int.class);
            for (PermissionGroupInfo group : groupList) {
                try {
                    String name = group == null ? null : group.name;
                    Logger.v("group: " + group.name);
                    List<PermissionInfo> permissionInfos = pm.queryPermissionsByGroup(name, 0);
                    for (PermissionInfo permissionInfo : permissionInfos) {
                        String protection = (String) protectionToString.invoke(permissionInfo,
                                permissionInfo.protectionLevel);
                        Logger.v(permissionInfo.name + " " + protection);
                    }
                } catch (PackageManager.NameNotFoundException ignored) {
                }
            }
        } catch (Exception e){
            Log.wtf(Logger.TAG, e);
        }
    }
}
