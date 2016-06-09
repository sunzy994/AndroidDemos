package cmcm.com.multiprocessdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunzy on 16-3-28.
 */
public class MultiProcessConfig {

    private static MultiProcessConfig sInstance;
    private Context mContext;
    private IMultiProcessConfig mConfig;
    private CountDownLatch mLatch;
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mConfig = IMultiProcessConfig.Stub.asInterface(service);
            Log.v("sunzy", "connected!");
            //mLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mConfig = null;
        }
    };

    private MultiProcessConfig(){
        mContext = MyApplication.getAppContext();
        Intent intent = new Intent(mContext, MyService.class);
        mContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//        mLatch = new CountDownLatch(1);
//        try {
//            mLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static MultiProcessConfig getsInstance(){
        if(sInstance == null){
            sInstance = new MultiProcessConfig();
        }
        return sInstance;
    }

    
    public Map<String, ?> getAll() {
        return null;
    }

    public String getString(String key, String defValue) {
        try {
            return mConfig.getString(key, defValue);
        } catch (Exception e){
        }
        return defValue;
    }

    public Set<String> getStringSet(String key, Set<String> defValues) {
//        try {
//            return mConfig.getString(key, defValue);
//        } catch (Exception e){
//        }
//        return defValue;
        return null;
    }

    
    public int getInt(String key, int defValue) {
        try {
            return mConfig.getInt(key, defValue);
        } catch (Exception e){
        }
        return defValue;
    }

    
    public long getLong(String key, long defValue) {
        try {
            return mConfig.getLong(key, defValue);
        } catch (Exception e){
        }
        return defValue;
    }

    
    public float getFloat(String key, float defValue) {
        try {
            return mConfig.getFloat(key, defValue);
        } catch (Exception e){
        }
        return defValue;
    }

    
    public boolean getBoolean(String key, boolean defValue) {
        try {
            return mConfig.getBoolean(key, defValue);
        } catch (Exception e){
        }
        return defValue;
    }

    
    public boolean contains(String key) {
        try {
            return mConfig.contains(key);
        } catch (Exception e){
        }
        return false;
    }

    
    public void registerOnConfigChangeListener(OnConfigChangeListener listener) {

    }

    
    public void unregisterOnConfigChangeListener(OnConfigChangeListener listener) {

    }

    public void putString(String key, String value) {
        try {
            mConfig.putString(key, value);
        } catch (Exception e){
        }
    }


    public void putStringList(String key, List<String> values) {
        try {
            mConfig.putStringList(key, values);
        } catch (Exception e){
        }
    }


    public void putInt(String key, int value) {
        try {
            mConfig.putInt(key, value);
        } catch (Exception e){
        }
    }


    public void putLong(String key, long value) {
        try {
            mConfig.putLong(key, value);
        } catch (Exception e){
        }
    }


    public void putFloat(String key, float value) {
        try {
            mConfig.putFloat(key, value);
        } catch (Exception e){
        }
    }


    public void putBoolean(String key, boolean value) {
        try {
            mConfig.putBoolean(key, value);
        } catch (Exception e){
        }
    }

}
