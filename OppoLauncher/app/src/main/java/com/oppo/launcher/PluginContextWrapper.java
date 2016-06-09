package com.oppo.launcher;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.ContextThemeWrapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PluginContextWrapper extends ContextThemeWrapper
{
  private static final String TAG = PluginContextWrapper.class.getSimpleName();
  private AssetManager mAssetManager = null;
  private ClassLoader mClassLoader;
  private Context mContext;
  private Resources mResources = null;

  public PluginContextWrapper(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    super(paramContext, paramInt);
    this.mClassLoader = paramClassLoader;
    this.mAssetManager = initAssetManager(paramString);
    this.mResources = initResources(paramContext, this.mAssetManager);
    this.mContext = paramContext;
  }

  private AssetManager initAssetManager(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localObject1 = localAssetManager;
      localObject2 = localAssetManager;
      localObject3 = localAssetManager;
      localObject4 = localAssetManager;
      AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      return localAssetManager;
    }
    catch (InstantiationException paramString)
    {
      Log.e(TAG, "initAssetManager --- e = " + paramString);
      return localObject1;
    }
    catch (IllegalAccessException paramString)
    {
      Log.e(TAG, "initAssetManager --- e = " + paramString);
      return localObject2;
    }
    catch (NoSuchMethodException paramString)
    {
      Log.e(TAG, "initAssetManager --- e = " + paramString);
      return localObject3;
    }
    catch (InvocationTargetException paramString)
    {
      Log.e(TAG, "initAssetManager --- e = " + paramString);
    }
    return localObject4;
  }

  private Resources initResources(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }

  public AssetManager getAssets()
  {
    return this.mAssetManager;
  }

  public ClassLoader getClassLoader()
  {
    if (this.mClassLoader != null)
      return this.mClassLoader;
    return super.getClassLoader();
  }

  public ContentResolver getContentResolver()
  {
    return this.mContext.getContentResolver();
  }

  public Resources getResources()
  {
    return this.mResources;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.PluginContextWrapper
 * JD-Core Version:    0.6.2
 */