package com.oppo.launcher;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;

public class ForeignPackage
{
  private static final String TAG = "ForeignPackage";
  public static final String WEATHER_WIDGET_PACKAGE_NAME = "com.coloros.widget.smallweather";
  private Context mContext;
  private Context mForeignCtx;
  private String packageName;

  public ForeignPackage(Context paramContext1, String paramString, Context paramContext2)
    throws PackageManager.NameNotFoundException
  {
    this.mContext = paramContext1;
    this.packageName = paramString;
    this.mForeignCtx = paramContext2;
  }

  public Context getContext()
  {
    return this.mForeignCtx;
  }

  public View getLayout(int paramInt, ViewGroup paramViewGroup)
    throws Exception
  {
    return ((LayoutInflater)this.mForeignCtx.getSystemService("layout_inflater")).inflate(paramInt, paramViewGroup);
  }

  public View getLayout(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
    throws Exception
  {
    ClassLoader localClassLoader = this.mForeignCtx.getClassLoader();
    try
    {
      Field localField = ClassLoader.class.getDeclaredField("parent");
      localField.setAccessible(true);
      localField.set(localClassLoader, this.mContext.getClassLoader());
      return ((LayoutInflater)this.mForeignCtx.getSystemService("layout_inflater")).inflate(paramInt, paramViewGroup);
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("ForeignPackage", "getLayout --- e = " + localException);
    }
  }

  public String getPackagename()
  {
    return this.packageName;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ForeignPackage
 * JD-Core Version:    0.6.2
 */