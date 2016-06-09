package com.oppo.launcher;

import android.appwidget.AppWidgetProviderInfo;
import android.os.Parcelable;

public class PendingAddWidgetInfo extends PendingAddItemInfo
{
  Parcelable configurationData;
  public int icon;
  AppWidgetProviderInfo mAppWidgetProviderInfo;
  String mimeType;
  public int minHeight;
  int minResizeHeight;
  int minResizeWidth;
  public int minWidth;
  public int previewImage;

  public PendingAddWidgetInfo(AppWidgetProviderInfo paramAppWidgetProviderInfo, String paramString, Parcelable paramParcelable)
  {
    this.itemType = 5;
    this.mAppWidgetProviderInfo = paramAppWidgetProviderInfo;
    this.componentName = paramAppWidgetProviderInfo.provider;
    this.minWidth = paramAppWidgetProviderInfo.minWidth;
    this.minHeight = paramAppWidgetProviderInfo.minHeight;
    this.minResizeWidth = paramAppWidgetProviderInfo.minResizeWidth;
    this.minResizeHeight = paramAppWidgetProviderInfo.minResizeHeight;
    this.previewImage = paramAppWidgetProviderInfo.previewImage;
    this.icon = paramAppWidgetProviderInfo.icon;
    if ((paramString != null) && (paramParcelable != null))
    {
      this.mimeType = paramString;
      this.configurationData = paramParcelable;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.PendingAddWidgetInfo
 * JD-Core Version:    0.6.2
 */