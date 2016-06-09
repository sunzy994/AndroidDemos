package cmcm.com.shortcutdemo;

import android.util.Log;

/**
 * Created by sunzy on 16-4-21.
 */
public class Logger {
    public static final String TAG = "MainActivity";
    public static void v(String msg){
        Log.e(TAG, msg);
    }

    public static void wtf(Throwable t){
        Log.wtf(TAG, t);
    }
}
