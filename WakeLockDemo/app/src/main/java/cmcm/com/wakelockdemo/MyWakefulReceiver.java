package cmcm.com.wakelockdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by sunzy on 16-3-21.
 */
public class MyWakefulReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        MyLogger.log("WakefulBroadcastReceiver on receive.");
        // Start the service, keeping the device awake while the service is
        // launching. This is the Intent to deliver to the service.
//        Intent service = new Intent(context, MyIntentService.class);
//        startWakefulService(context, service);
    }
}
