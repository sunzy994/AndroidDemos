package cmcm.com.myapplication;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bo
  implements ah, ai
{
  private Builder a;
  private final Bundle b;
  private List<Bundle> c = new ArrayList();

  public bo(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2)
  {
    paramContext = new Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    boolean bool;
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool = true;
      paramContext = paramContext.setOngoing(bool);
      if ((paramNotification.flags & 0x8) == 0)
        break label337;
      bool = true;
      label123: paramContext = paramContext.setOnlyAlertOnce(bool);
      if ((paramNotification.flags & 0x10) == 0)
        break label343;
      bool = true;
      label143: paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0)
        break label349;
      bool = true;
      label202: this.a = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
      this.b = new Bundle();
      if (paramBundle != null)
        this.b.putAll(paramBundle);
      if (paramBoolean3)
        this.b.putBoolean("android.support.localOnly", true);
      if (paramString1 != null)
      {
        this.b.putString("android.support.groupKey", paramString1);
        if (!paramBoolean4)
          break label355;
        this.b.putBoolean("android.support.isGroupSummary", true);
      }
    }
    while (true)
    {
      if (paramString2 != null)
        this.b.putString("android.support.sortKey", paramString2);
      return;
      bool = false;
      break;
      label337: bool = false;
      break label123;
      label343: bool = false;
      break label143;
      label349: bool = false;
      break label202;
      label355: this.b.putBoolean("android.support.useSideChannel", true);
    }
  }

  public Builder a()
  {
    return this.a;
  }

  public void a(bh parambh)
  {
    this.c.add(bn.a(this.a, parambh));
  }

  public Notification b()
  {
    Notification localNotification = this.a.build();
    Object localObject = bn.a(localNotification);
    Bundle localBundle = new Bundle(this.b);
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Bundle)localObject).containsKey(str))
        localBundle.remove(str);
    }
    ((Bundle)localObject).putAll(localBundle);
    localObject = bn.a(this.c);
    if (localObject != null)
      bn.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
    return localNotification;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.6.2
 */