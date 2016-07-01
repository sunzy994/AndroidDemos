package cmcm.com.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("sunzy", "is broadcast in main thread = " + (Looper.getMainLooper() == Looper.myLooper()));
            abortBroadcast();
            setResult();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter("action_demo");
        registerReceiver(mReceiver, filter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.v("sunzy", "is in main thread = " + (Looper.getMainLooper() == Looper.myLooper()));
                sendBroadcast(new Intent("action_demo"));
                sendOrderedBroadcast();
            }
        }).start();
    }
}
