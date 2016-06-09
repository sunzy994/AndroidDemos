package cmcm.com.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class bj
{
  public static Notification a(Notification paramNotification, Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    paramNotification.setLatestEventInfo(paramContext, paramCharSequence1, paramCharSequence2, paramPendingIntent1);
    paramNotification.fullScreenIntent = paramPendingIntent2;
    return paramNotification;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bj
 * JD-Core Version:    0.6.2
 */