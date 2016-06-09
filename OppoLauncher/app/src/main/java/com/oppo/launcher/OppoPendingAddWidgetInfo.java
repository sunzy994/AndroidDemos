package com.oppo.launcher;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import java.text.Collator;
import java.util.Comparator;

public class OppoPendingAddWidgetInfo extends PendingAddWidgetInfo
{
  public Drawable mDrawable = null;
  int recordDayFirst = -1;
  int recordDaySecond = -1;

  public OppoPendingAddWidgetInfo(AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    super(paramAppWidgetProviderInfo, null, null);
  }

  public static class DisplayNameComparator
    implements Comparator<AppWidgetProviderInfo>
  {
    private final Collator sCollator = Collator.getInstance();

    public final int compare(AppWidgetProviderInfo paramAppWidgetProviderInfo1, AppWidgetProviderInfo paramAppWidgetProviderInfo2)
    {
      return this.sCollator.compare(paramAppWidgetProviderInfo1.provider.getClassName(), paramAppWidgetProviderInfo2.provider.getClassName());
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.OppoPendingAddWidgetInfo
 * JD-Core Version:    0.6.2
 */