package cmcm.com.multiprocessdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.*;

import java.util.List;

/**
 * Created by sunzy on 16-3-28.
 */
public class MultiProcessConfigImpl extends IMultiProcessConfig.Stub {

    private SharedPreferences mSharePreference;

    public MultiProcessConfigImpl(){
        mSharePreference = MyApplication.getAppContext().getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key, String defValue) throws RemoteException {
        return mSharePreference.getString(key, defValue);
    }

    @Override
    public List<String> getStringList(String key, List<String> defValues) throws RemoteException {
        //TODO implement it later
        return null;
    }

    @Override
    public int getInt(String key, int defValue) throws RemoteException {
        return mSharePreference.getInt(key, defValue);
    }

    @Override
    public long getLong(String key, long defValue) throws RemoteException {
        return mSharePreference.getLong(key, defValue);
    }

    @Override
    public float getFloat(String key, float defValue) throws RemoteException {
        return mSharePreference.getFloat(key, defValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) throws RemoteException {
        return mSharePreference.getBoolean(key, defValue);
    }

    @Override
    public boolean contains(String key) throws RemoteException {
        return mSharePreference.contains(key);
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnConfigChangeListener listener) throws RemoteException {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnConfigChangeListener listener) throws RemoteException {

    }

    @Override
    public void putString(String key, String value) throws RemoteException {
        mSharePreference.edit().putString(key, value).commit();
    }

    @Override
    public void putStringList(String key, List<String> values) throws RemoteException {
        //TODO
    }

    @Override
    public void putInt(String key, int value) throws RemoteException {
        mSharePreference.edit().putInt(key, value).commit();
    }

    @Override
    public void putLong(String key, long value) throws RemoteException {
        mSharePreference.edit().putLong(key, value).commit();
    }

    @Override
    public void putFloat(String key, float value) throws RemoteException {
        mSharePreference.edit().putFloat(key, value).commit();
    }

    @Override
    public void putBoolean(String key, boolean value) throws RemoteException {
        mSharePreference.edit().putBoolean(key, value).commit();
    }
}
