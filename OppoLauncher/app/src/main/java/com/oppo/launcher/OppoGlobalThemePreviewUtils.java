package com.oppo.launcher;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xmlpull.v1.XmlPullParserException;

public class OppoGlobalThemePreviewUtils
{
  private String TAG = "OppoGlobalThemePreviewUtils";
  private Context mContext;
  private Drawable mCurrentGlobalThemeWidgetThumbnail;
  private String mCurrentPackageName;
  private DexClassLoader mDexClassLoader;
  private Context mRemoteContext;
  private String mWidgetPluginPath;

  public OppoGlobalThemePreviewUtils(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public Drawable getCurrentGlobalThemeWidgetThumbnail()
  {
    initResources();
    return this.mCurrentGlobalThemeWidgetThumbnail;
  }

  public PackageInfo getPackageInfo()
  {
    return this.mContext.getPackageManager().getPackageArchiveInfo(this.mWidgetPluginPath, 4);
  }

  public void initResources()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.globaltheme.provider/widget"), null, "widgetbelongsto=?", new String[] { this.mCurrentPackageName }, null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.getCount() > 0)
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          localCursor.moveToFirst();
          localObject1 = localCursor;
          localObject3 = localCursor;
          this.mWidgetPluginPath = localCursor.getString(localCursor.getColumnIndex("widgetpluginpath"));
          localObject1 = localCursor;
          localObject3 = localCursor;
          loadGlobalThemeWidget();
        }
      }
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        localCursor.close();
      }
      return;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      Log.e(this.TAG, "initResources: Read database(globaltheme.provider:widget) failed!!! ");
      return;
    }
    finally
    {
      Object localObject4;
      if (localObject4 != null)
        localObject4.close();
    }
  }

  public boolean isOppoGlobalThemeWidget(String paramString)
  {
    boolean bool2 = false;
    this.mCurrentPackageName = paramString;
    Object localObject = null;
    paramString = null;
    try
    {
      Cursor localCursor = this.mContext.getContentResolver().query(Uri.parse("content://com.oppo.globaltheme.provider/widget"), null, "widgetbelongsto=?", new String[] { this.mCurrentPackageName }, null);
      if (localCursor != null)
      {
        paramString = localCursor;
        localObject = localCursor;
        int i = localCursor.getCount();
        if (i <= 0);
      }
      for (boolean bool1 = true; ; bool1 = false)
      {
        bool2 = bool1;
        if (localCursor != null)
        {
          localCursor.close();
          bool2 = bool1;
        }
        return bool2;
      }
    }
    catch (Exception localException)
    {
      str = paramString;
      Log.e(this.TAG, "isOppoGlobalThemeWidget: Read database(globaltheme.provider:widget) failed!!! ");
      return false;
    }
    finally
    {
      String str;
      if (str != null)
        str.close();
    }
    throw paramString;
  }

  public void loadGlobalThemeWidget()
  {
    this.mDexClassLoader = new DexClassLoader(this.mWidgetPluginPath, this.mContext.getCacheDir().getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
    this.mRemoteContext = new PluginContextWrapper(this.mContext, 0, this.mWidgetPluginPath, this.mDexClassLoader);
    loadPluginInfo();
  }

  public void loadPluginInfo()
  {
    Object localObject = getPackageInfo();
    int i;
    try
    {
      i = this.mRemoteContext.getResources().getIdentifier("widget_info", "xml", ((PackageInfo)localObject).packageName);
      localObject = this.mRemoteContext.getResources().getXml(i);
      if (localObject != null)
        break label62;
      throw new XmlPullParserException("null");
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "initResources: Parse xml(widget_info) failed!!! ");
    }
    return;
    while (true)
    {
      label62: i = localException.next();
      if (i == 1)
        break;
      if (i == 2)
      {
        i = localException.getAttributeResourceValue(localException.getAttributeNamespace(0), "widgetThumbnail", -1);
        this.mCurrentGlobalThemeWidgetThumbnail = this.mRemoteContext.getResources().getDrawable(i);
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.OppoGlobalThemePreviewUtils
 * JD-Core Version:    0.6.2
 */