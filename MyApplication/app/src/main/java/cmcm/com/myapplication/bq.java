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
import java.util.List;

public class bq
  implements ah, ai
{
  private Builder a;
  private Bundle b;
  private List<Bundle> c = new ArrayList();

  public bq(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, ArrayList<String> paramArrayList, Bundle paramBundle, String paramString1, boolean paramBoolean5, String paramString2)
  {
    paramContext = new Builder(paramContext).setWhen(paramNotification.when).setShowWhen(paramBoolean2).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      paramBoolean2 = true;
      paramContext = paramContext.setOngoing(paramBoolean2);
      if ((paramNotification.flags & 0x8) == 0)
        break label380;
      paramBoolean2 = true;
      label128: paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
      if ((paramNotification.flags & 0x10) == 0)
        break label386;
      paramBoolean2 = true;
      label148: paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0)
        break label392;
      paramBoolean2 = true;
      label207: this.a = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
      this.b = new Bundle();
      if (paramBundle != null)
        this.b.putAll(paramBundle);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
        this.b.putStringArray("android.people", (String[])paramArrayList.toArray(new String[paramArrayList.size()]));
      if (paramBoolean4)
        this.b.putBoolean("android.support.localOnly", true);
      if (paramString1 != null)
      {
        this.b.putString("android.support.groupKey", paramString1);
        if (!paramBoolean5)
          break label398;
        this.b.putBoolean("android.support.isGroupSummary", true);
      }
    }
    while (true)
    {
      if (paramString2 != null)
        this.b.putString("android.support.sortKey", paramString2);
      return;
      paramBoolean2 = false;
      break;
      label380: paramBoolean2 = false;
      break label128;
      label386: paramBoolean2 = false;
      break label148;
      label392: paramBoolean2 = false;
      break label207;
      label398: this.b.putBoolean("android.support.useSideChannel", true);
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
    SparseArray localSparseArray = bn.a(this.c);
    if (localSparseArray != null)
      this.b.putSparseParcelableArray("android.support.actionExtras", localSparseArray);
    this.a.setExtras(this.b);
    return this.a.build();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.6.2
 */