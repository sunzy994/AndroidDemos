package cmcm.com.myapplication;

import android.app.Notification;
import android.os.Bundle;

class bp
{
  public static Bundle a(Notification paramNotification)
  {
    return paramNotification.extras;
  }

  public static String b(Notification paramNotification)
  {
    return paramNotification.extras.getString("android.support.groupKey");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.6.2
 */