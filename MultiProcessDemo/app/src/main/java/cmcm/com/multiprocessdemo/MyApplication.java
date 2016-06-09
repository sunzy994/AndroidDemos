package cmcm.com.multiprocessdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by sunzy on 16-3-28.
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        MultiProcessConfig.getsInstance();
    }

    public static Context getAppContext(){
        return mContext;
    }
}
