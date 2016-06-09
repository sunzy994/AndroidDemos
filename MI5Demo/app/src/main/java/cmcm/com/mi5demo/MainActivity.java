package cmcm.com.mi5demo;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            goToPkgUsageSetting();
        } catch (Exception e){
            Log.wtf("sunzy", e);
        }
    }

    public void goToPkgUsageSetting() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        Intent it = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        //it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
    }
}
