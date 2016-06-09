package com.oppo.launcher;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class OppoAppWidgetProviderInfo extends AppWidgetProviderInfo
{
  private static final boolean DEBUG = false;
  public static final String SERVICE_META_DATA = "android.appwidget.provider";
  private static final String TAG = "OppoAppWidgetProviderInfo";
  private Context mForeignCtx = null;

  public OppoAppWidgetProviderInfo(Context paramContext, ComponentName paramComponentName)
    throws XmlPullParserException, IOException, NameNotFoundException
  {
    Object localObject3 = paramContext.getPackageManager();
    ActivityInfo localActivityInfo = ((PackageManager)localObject3).getReceiverInfo(paramComponentName, 128);
    this.provider = paramComponentName;
    Object localObject1 = null;
    XmlResourceParser localXmlResourceParser = null;
    paramComponentName = null;
    this.label = (localActivityInfo.loadLabel(paramContext.getPackageManager()) + "");
    this.icon = localActivityInfo.getIconResource();
    this.mForeignCtx = paramContext.createPackageContext(this.provider.getPackageName(), 3);
    paramContext = localXmlResourceParser;
    try
    {
      localXmlResourceParser = localActivityInfo.loadXmlMetaData((PackageManager)localObject3, "android.appwidget.provider");
      if (localXmlResourceParser == null)
      {
        paramComponentName = localXmlResourceParser;
        localObject1 = localXmlResourceParser;
        paramContext = localXmlResourceParser;
        throw new XmlPullParserException("null");
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      paramContext = paramComponentName;
      Log.e("OppoAppWidgetProviderInfo", "OppoAppWidgetProviderInfo first --- e = " + localXmlPullParserException);
      return;
      while (true)
      {
        paramComponentName = localXmlResourceParser;
        localObject2 = localXmlResourceParser;
        paramContext = localXmlResourceParser;
        int i = localXmlResourceParser.next();
        if (i == 1)
          break;
        if (i == 2)
        {
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          localObject3 = localXmlResourceParser.getAttributeNamespace(0);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          i = localXmlResourceParser.getAttributeResourceValue((String)localObject3, "minWidth", -1);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.minWidth = ((int)this.mForeignCtx.getResources().getDimension(i));
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          i = localXmlResourceParser.getAttributeResourceValue((String)localObject3, "minHeight", -1);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.minHeight = ((int)this.mForeignCtx.getResources().getDimension(i));
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.minResizeWidth = parseAttributeDimension(localXmlResourceParser, (String)localObject3, "minResizeWidth", this.mForeignCtx.getResources(), this.minWidth);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.minResizeHeight = parseAttributeDimension(localXmlResourceParser, (String)localObject3, "minResizeHeight", this.mForeignCtx.getResources(), this.minHeight);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.updatePeriodMillis = localXmlResourceParser.getAttributeResourceValue((String)localObject3, "updatePeriodMillis", -1);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.initialLayout = localXmlResourceParser.getAttributeResourceValue((String)localObject3, "initialLayout", -1);
          paramComponentName = localXmlResourceParser;
          localObject2 = localXmlResourceParser;
          paramContext = localXmlResourceParser;
          this.previewImage = localXmlResourceParser.getAttributeResourceValue((String)localObject3, "previewImage", -1);
        }
      }
    }
    catch (IOException paramComponentName)
    {
      Object localObject2;
      paramContext = localObject2;
      Log.e("OppoAppWidgetProviderInfo", "OppoAppWidgetProviderInfo second --- e = " + paramComponentName);
      return;
      return;
    }
    finally
    {
      if (paramContext != null)
        paramContext.close();
    }
    throw paramComponentName;
  }

  public OppoAppWidgetProviderInfo(Context paramContext, ResolveInfo paramResolveInfo)
    throws XmlPullParserException, IOException, NameNotFoundException
  {
    this(paramContext, new ComponentName(paramResolveInfo.activityInfo.processName, paramResolveInfo.activityInfo.name));
  }

  private int parseAttributeDimension(XmlResourceParser paramXmlResourceParser, String paramString1, String paramString2, Resources paramResources, int paramInt)
  {
    int i = paramXmlResourceParser.getAttributeResourceValue(paramString1, paramString2, 0);
    if (i == 0)
      return paramInt;
    return paramResources.getDimensionPixelSize(i);
  }

  public Context getForeinContext()
  {
    return this.mForeignCtx;
  }

  public String toString()
  {
    return "OppoAppWidgetProviderInfo(provider=" + this.provider + ")";
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.OppoAppWidgetProviderInfo
 * JD-Core Version:    0.6.2
 */