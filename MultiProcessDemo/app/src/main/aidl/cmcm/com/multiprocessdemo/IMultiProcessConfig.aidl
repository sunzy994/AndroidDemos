// IMultiProcessConfig.aidl
package cmcm.com.multiprocessdemo;

import cmcm.com.multiprocessdemo.OnConfigChangeListener;

interface IMultiProcessConfig  {

         String getString(String key, String defValue);
         List<String> getStringList(String key, inout List<String> defValues);
         int getInt(String key, int defValue);
         long getLong(String key, long defValue);
         float getFloat(String key, float defValue);
         boolean getBoolean(String key, boolean defValue);
         boolean contains(String key);
         void registerOnSharedPreferenceChangeListener(inout OnConfigChangeListener listener);
         void unregisterOnSharedPreferenceChangeListener(inout OnConfigChangeListener listener);
         void putString(String key, String value);
         void putStringList(String key, in List<String> values);
         void putInt(String key, int value);
         void putLong(String key, long value);
         void putFloat(String key, float value);
         void putBoolean(String key, boolean value);

}
