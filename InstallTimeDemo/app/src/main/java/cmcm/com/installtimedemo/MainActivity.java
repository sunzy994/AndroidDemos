package cmcm.com.installtimedemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("sunzy", "isOverInstallTimeDay = " + isOverInstallTimeDay(this, TimeUnit.DAYS.toMillis(1)));
    }

    public static boolean isOverInstallTimeDay(Context ctx,long intervalTime){
        boolean isOverInstallTimeTwoDay = false;
        if(null == ctx){
            return isOverInstallTimeTwoDay;
        }
        try {
            PackageManager packageManager = ctx.getPackageManager();
            PackageInfo pkgInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
            long firstInstallTime =  safeGetFirstInstallTime(pkgInfo);
            if(System.currentTimeMillis() - firstInstallTime >= intervalTime){
                isOverInstallTimeTwoDay = true;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  isOverInstallTimeTwoDay;
    }

    public static long safeGetFirstInstallTime(final PackageInfo packageInfo) {
        long time = 0;
        try {
            Field firstInstallTime = packageInfo.getClass().getField("firstInstallTime");
            firstInstallTime.setAccessible(true);
            time = firstInstallTime.getLong(packageInfo);
        } catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return time;
    }
}
