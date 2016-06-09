package com.oppo.launcher.graphic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

public class MaskBitmapUtilities
{
  private static final String TAG = "MaskBitmapUtilities";
  private static MaskBitmapUtilities mMaskBitmapUtilities = null;
  private Options mOpt;

  static
  {
    System.loadLibrary("coloros_launcher_graphic");
    nativeInit();
  }

  public static MaskBitmapUtilities getInstance()
  {
    if (mMaskBitmapUtilities == null)
      mMaskBitmapUtilities = new MaskBitmapUtilities();
    return mMaskBitmapUtilities;
  }

  private static final native void nativeInit();

  private Bitmap readBitmap(Context paramContext, int paramInt)
  {
    this.mOpt = new Options();
    this.mOpt.inPreferredConfig = Config.ARGB_8888;
    this.mOpt.inMutable = true;
    InputStream localInputStream = paramContext.getResources().openRawResource(paramInt);
    Context localContext = null;
    try
    {
      paramContext = BitmapFactory.decodeStream(localInputStream, null, this.mOpt);
      localContext = paramContext;
      if (localInputStream != null);
      try
      {
        localInputStream.close();
        localContext = paramContext;
        return localContext;
      }
      catch (IOException localIOException1)
      {
        Log.e("MaskBitmapUtilities", "readBitmap() is close error !!!");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      do
        Log.e("MaskBitmapUtilities", "readBitmap() Failed !!!");
      while (localInputStream == null);
      try
      {
        localInputStream.close();
        return null;
      }
      catch (IOException paramContext)
      {
        Log.e("MaskBitmapUtilities", "readBitmap() is close error !!!");
        return null;
      }
    }
    finally
    {
      if (localInputStream == null);
    }
    try
    {
      localInputStream.close();
      throw paramContext;
    }
    catch (IOException localIOException2)
    {
      while (true)
        Log.e("MaskBitmapUtilities", "readBitmap() is close error !!!");
    }
  }

  public native Bitmap cutAndScaleBitmap(Bitmap paramBitmap);

  public native int[] getBitmapBrightness(Bitmap paramBitmap, int paramInt);

  public native int[] getBitmapBrightness(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);

  public int getBitmapBrightnessValue(Bitmap paramBitmap)
  {
    return getBitmapBrightnessValue(paramBitmap, 1);
  }

  public native int getBitmapBrightnessValue(Bitmap paramBitmap, int paramInt);

  public int getBitmapBrightnessValue(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getBitmapBrightnessValue(paramBitmap, 1, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public native int getBitmapBrightnessValue(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);

  public native void releaseResouce();

  public native Bitmap scaleAndMaskBitmap(Context paramContext, int paramInt);

  public native Bitmap scaleAndMaskBitmap(Bitmap paramBitmap);

  public native void setCutAndScalePram(int paramInt1, int paramInt2);

  public native void setMaskBitmap(Context paramContext, int paramInt);

  public native void setMaskBitmap(Bitmap paramBitmap);
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.graphic.MaskBitmapUtilities
 * JD-Core Version:    0.6.2
 */