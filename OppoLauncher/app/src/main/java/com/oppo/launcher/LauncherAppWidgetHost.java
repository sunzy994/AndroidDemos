package com.oppo.launcher;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

public class LauncherAppWidgetHost extends AppWidgetHost
{
  public LauncherAppWidgetHost(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  protected AppWidgetHostView onCreateView(Context paramContext, int paramInt, AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    return new LauncherAppWidgetHostView(paramContext);
  }

  public void stopListening()
  {
    super.stopListening();
    clearViews();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherAppWidgetHost
 * JD-Core Version:    0.6.2
 */