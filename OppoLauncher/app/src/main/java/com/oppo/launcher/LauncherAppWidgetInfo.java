package com.oppo.launcher;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;

public class LauncherAppWidgetInfo extends ItemInfo
{
  static final int NO_ID = -1;
  static final int OPPO_WIDGET_ID = -150;
  public int appWidgetId = -1;
  LauncherAppWidgetHostView hostView = null;
  int minHeight = -1;
  int minWidth = -1;
  private String packageName = null;
  private AppWidgetProviderInfo provider;
  ComponentName providerName;

  LauncherAppWidgetInfo(int paramInt)
  {
    this.itemType = 5;
    this.appWidgetId = paramInt;
  }

  LauncherAppWidgetInfo(ComponentName paramComponentName)
  {
    this.itemType = 5;
    this.providerName = paramComponentName;
    this.appWidgetId = -150;
    this.spanX = -1;
    this.spanY = -1;
  }

  public String getAppWidgetClassName()
  {
    return this.className;
  }

  public String getAppWidgetPackageName()
  {
    return this.packageName;
  }

  public AppWidgetProviderInfo getProvider()
  {
    return this.provider;
  }

  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    paramContentValues.put("appWidgetId", Integer.valueOf(this.appWidgetId));
    if (this.appWidgetId == -150)
    {
      paramContentValues.put("intent", this.providerName.flattenToString());
      return;
    }
    paramContentValues.put("intent", getAppWidgetPackageName());
    paramContentValues.put("packageName", getAppWidgetPackageName());
  }

  public void setAppWidgetClassName(String paramString)
  {
    this.className = paramString;
  }

  public void setAppWidgetPackageName(String paramString, Context paramContext)
  {
    this.packageName = paramString;
  }

  public void setProvider(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    this.provider = paramAppWidgetProviderInfo;
  }

  public String toString()
  {
    return "AppWidget(id=" + Integer.toString(this.appWidgetId) + ")" + ", provider = " + this.providerName + super.toString();
  }

  void unbind()
  {
    super.unbind();
    this.hostView = null;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherAppWidgetInfo
 * JD-Core Version:    0.6.2
 */