package cmcm.com.wakelockdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "my_action";

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            long serviceStartTime = getSharedPreferences("service_config", Context.MODE_PRIVATE).getLong("service_start_time", 0L)/1000;
            long currentTime = System.currentTimeMillis()/1000;
            long timeElapsed = currentTime - serviceStartTime;
            long serviceRunningTime = intent.getIntExtra("running_seconds", 0);
            mTv.setText(String.format("Service start time: %s\nCurrent time: %s\nTime elapsed: %ss\nService running: %ss\n",
                    serviceStartTime, currentTime, timeElapsed, serviceRunningTime));
        }
    };

    private boolean mRegisterd = false;

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);

        mTv = (TextView)findViewById(R.id.tv);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!mRegisterd){
            mRegisterd = true;
            IntentFilter filter = new IntentFilter(ACTION);
            registerReceiver(mReceiver, filter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mRegisterd){
            mRegisterd = false;
            unregisterReceiver(mReceiver);
        }
    }
}
