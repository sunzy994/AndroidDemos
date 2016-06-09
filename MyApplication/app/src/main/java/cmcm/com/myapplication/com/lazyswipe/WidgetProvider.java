package cmcm.com.myapplication.com.lazyswipe;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider
{
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext.getApplicationContext(), 1, new Intent("com.lazyswipe.action.OPEN_FROM_WIDGET"), 0);
      RemoteViews localRemoteViews = new RemoteViews("com.lazyswipe", 2130968765);
      localRemoteViews.setOnClickPendingIntent(2131755544, localPendingIntent);
      paramAppWidgetManager.updateAppWidget(k, localRemoteViews);
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.WidgetProvider
 * JD-Core Version:    0.6.2
 */