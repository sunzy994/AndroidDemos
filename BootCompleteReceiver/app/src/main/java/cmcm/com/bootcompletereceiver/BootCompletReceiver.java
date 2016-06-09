package cmcm.com.bootcompletereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sunzy on 16-3-22.
 */
public class BootCompletReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("sunzy", "boot complete receiver: boot complete!");
        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);
    }

}
