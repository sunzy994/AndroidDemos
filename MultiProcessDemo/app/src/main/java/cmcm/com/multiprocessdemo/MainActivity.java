package cmcm.com.multiprocessdemo;

import android.content.Intent;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.fab).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(this, Main2Activity.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("sunzy", "string test = " + MultiProcessConfig.getsInstance().getString("string_test", "unkown"));
        MultiProcessConfig.getsInstance().putString("string_test", "activity1");
    }
}
