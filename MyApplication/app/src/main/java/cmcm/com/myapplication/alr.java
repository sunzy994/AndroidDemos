package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.notification.NotificationData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class alr
  implements Runnable
{
  private static int a;
  private final Context b;

  alr(Context paramContext)
  {
    this.b = paramContext;
  }

  public void run()
  {
    alo.f = true;
    Object localObject2;
    aao localaao;
    while (true)
    {
      try
      {
        ??? = this.b.getContentResolver();
        Object localObject3 = xj.a;
        if (alo.o == null)
          break label214;
        l = alo.o.e;
        localObject3 = ((ContentResolver)???).call((Uri)localObject3, "getNotificationNumber", String.valueOf(l), null);
        if (localObject3 != null)
          synchronized (alo.b)
          {
            alo.e.clear();
            localObject5 = ((Bundle)localObject3).getStringArrayList("extra_param_1");
            if (localObject5 == null)
              break;
            localObject5 = ((List)localObject5).iterator();
            if (!((Iterator)localObject5).hasNext())
              break;
            String[] arrayOfString = ((String)((Iterator)localObject5).next()).split(",");
            alo.e.put(arrayOfString[0], Integer.valueOf(arrayOfString[1]));
          }
      }
      catch (Throwable localThrowable)
      {
      }
      localObject2 = yb.getInstance();
      if ((localObject2 != null) && (((yb)localObject2).isShown()) && (!((yb)localObject2).f()))
      {
        localObject2 = ((yb)localObject2).getItemLayer();
        if (localObject2 != null)
        {
          localaao = ((xu)localObject2).getTab();
          if ((localaao instanceof aag))
          {
            localaao.g();
            localaao.a((SwipeApplication)this.b.getApplicationContext());
            alo.d.obtainMessage(1, new WeakReference(localObject2)).sendToTarget();
          }
        }
      }
      alo.f = false;
      return;
      label214: long l = 0L;
    }
    Object localObject5 = (NotificationData)localaao.getParcelable("extra_param_2");
    alx.a((NotificationData) localObject5);
    int i = localaao.getInt("extra_param_3");
    if (localObject5 != null)
    {
      alo.o = (NotificationData)localObject5;
      alo.d(((NotificationData)localObject5).l);
      if (a != i)
        a = i;
    }
    while (true)
    {
      break;
      if (a != i)
      {
        a = i;
        alo.f();
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alr
 * JD-Core Version:    0.6.2
 */