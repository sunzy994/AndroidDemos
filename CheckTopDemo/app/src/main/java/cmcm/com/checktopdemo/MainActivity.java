package cmcm.com.checktopdemo;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("ResourceType")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    getMoveToFgComponent1();
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e1) {

                    }
                    Log.v("sunzy", "running...");
                }
            }
        }).start();
    }

    public void getMoveToFgComponent1(){
        try {
            List<ActivityManager.RunningAppProcessInfo> localObject1 = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
            Field field = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
            Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((List)localObject1).iterator();
            while (iterator.hasNext()) {
                ActivityManager.RunningAppProcessInfo processInfo = iterator.next();
                if (processInfo.importance == 100) {
                    int i = (processInfo).importanceReasonCode;
                    if (i == 0)
                        try {
                            if (field.getInt(processInfo) == 2) {
                                Log.v("sunzy", processInfo.pkgList[0]);
                                processInfo.
                            }
                        } catch (Throwable localThrowable) {
                            Log.v("sunzy", "Failed to get the foreground package", localThrowable);
                        }
                }
            }
        } catch (Throwable paramContext) {
            Log.v("sunzy", "Failed to get the foreground package", paramContext);
        }
    }

    public void getMoveToFgComponent2() {
        List<ActivityManager.RunningTaskInfo> taskRunnings = ((ActivityManager)getSystemService(ACTIVITY_SERVICE)).getRunningTasks(1);
        if ( taskRunnings != null && taskRunnings.size() > 0 ){
            ActivityManager.RunningTaskInfo runningTask = taskRunnings.get(0);
            if(runningTask != null){
                ComponentName topActivity = runningTask.topActivity;
                if(topActivity != null){
                    String packageName = topActivity.getPackageName();
                    Log.v("sunzy", "package = " + packageName);
                }
            }
        }

    }

    public void getMoveToFgComponent3(){
        long endTime = System.currentTimeMillis();
        long beginTime = endTime - 2000L;
        UsageStatsManager usageManager = (UsageStatsManager) getSystemService(USAGE_STATS_SERVICE);
        UsageEvents events = usageManager.queryEvents(beginTime, endTime);
        String pkgName = null;
        String clsName = null;
            UsageEvents.Event e = new UsageEvents.Event();
        while (events.hasNextEvent()){
            events.getNextEvent(e);
            if (e.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND) {
                pkgName = e.getPackageName();
                clsName = e.getClassName();
                Log.v("sunzy", "package = " + pkgName);
            }
        }
    }

    private static final String PKG_USAGE_SETTING_ACTION = "android.settings.USAGE_ACCESS_SETTINGS";

    private static UsageStatsManager sUsageManager = null;
    private static AppOpsManager sOpsManager = null;

    private static final String USAGE_STATS_SERVICE = "usagestats";


}
