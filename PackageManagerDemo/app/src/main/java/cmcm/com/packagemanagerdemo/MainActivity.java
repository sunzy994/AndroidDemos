package cmcm.com.packagemanagerdemo;

import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Process;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<PackageInfo> list =  getPackageManager().getPackagesHoldingPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
//        for (PackageInfo info : list){
//            Log.v("sunzy", "pkg = " + info.packageName);
//        }
        try {
            Process process = Runtime.getRuntime().exec("pm list packages");
            process.waitFor();
            InputStream is = process.getInputStream();
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String string = new String(bytes);
            Log.v("sunzy", string);
        } catch (Exception e){
            Log.wtf("sunzy", e);
        }

    }
}
