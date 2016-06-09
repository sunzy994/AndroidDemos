package cmcm.com.shortcutdemo;

import android.*;
import android.Manifest;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                KitkatShortcutUtils.createOnetapShortcut(MainActivity.this, "一键减速", R.drawable.boost_tag_onetap_shortcut, new Intent(MainActivity.this, Main2Activity.class));
//            }
//        });

        ActivityCompat.requestPermissions(this, new String[]{"com.huawei.android.launcher.permission.READ_SETTINGS"}, 2);
        Log.e("sunzy", "dddddddddddddddddddddddddddddddddddddd");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Logger.v(permissions[0] + " : " + grantResults[0]);
        Huawei huawei = new Huawei(this);
        // meitu.createOnetapShortcut2();
        boolean isCreated =  huawei.checkShortcutIsExists(new Intent(MainActivity.this, Main2Activity.class).getClass().getCanonicalName());
        Logger.v("createOnetapShortcut2 isCreated = " + isCreated);
    }


}
