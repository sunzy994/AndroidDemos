package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.lazyswipe.notification.NotificationData;

public class yx extends yw
  implements alh, ali
{
  protected Drawable a;
  private final int b;
  private final Context c;
  private final String i;
  private String j;

  public yx(Context paramContext, String paramString, int paramInt)
  {
    this.c = paramContext;
    this.i = paramString;
    this.b = paramInt;
    if (paramString.length() <= 1)
      this.j = asl.g(paramContext);
  }

  private void b(NotificationData paramNotificationData)
  {
    if (this.j != null)
    {
      Context localContext = this.c;
      if (paramNotificationData != null);
      for (long l = paramNotificationData.q; ; l = 0L)
      {
        alo.a(localContext, 0L, l);
        return;
      }
    }
    if (paramNotificationData == null)
    {
      alo.b(this.c, this.i, true);
      return;
    }
    alo.a(this.c, paramNotificationData);
  }

  public CharSequence a()
  {
    Context localContext = this.c;
    if (this.j != null);
    for (String str = this.j; ; str = this.i)
      return asq.a(localContext, str, null);
  }

  public void a(Context paramContext, NotificationData paramNotificationData)
  {
    vy.c(this.i);
    if (this.j != null)
    {
      vv.a().a("进入消息应用");
      String str = paramNotificationData.i;
      alo.a(paramContext, 0L, paramNotificationData.q);
      if (str != null)
      {
        asl.a(paramContext, str);
        return;
      }
      asl.h(paramContext);
      return;
    }
    vv.a().a("进入消息应用");
    if (("com.whatsapp".equals(this.i)) || ("com.tencent.mm".equals(this.i)) || ("com.viber.voip".equals(this.i)) || ("org.telegram.messenger".equals(this.i)))
      vv.a().a("WhatsApp", "r", 0);
    if (paramNotificationData == null)
    {
      asq.j(paramContext, this.i);
      g();
      return;
    }
    arm.b(this.c, paramNotificationData);
    b(paramNotificationData);
  }

  public void a(NotificationData paramNotificationData)
  {
    b(paramNotificationData);
  }

  public Drawable c(Context paramContext)
  {
    if (!atw.c(this.a))
      if (this.j == null)
        break label39;
    label39: for (paramContext = this.j; ; paramContext = this.i)
    {
      this.a = aid.a(this.c, paramContext);
      return this.a;
    }
  }

  public boolean c()
  {
    return false;
  }

  public boolean d(final Context paramContext)
  {
    vy.a(paramContext, "C0", "");
    vv.a().a("点击消息");
    if ("com.snapchat.android".equals(this.i))
    {
      yb.p();
      arj.a(new Runnable()
      {
        public void run()
        {
          NotificationData localNotificationData = alo.b(paramContext, yx.a(yx.this));
          yx.this.a(paramContext, localNotificationData);
        }
      });
    }
    while (true)
    {
      return false;
      yb.a(this.h, this);
    }
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public String f()
  {
    return this.i;
  }

  public void g()
  {
    b(null);
  }

  public int s()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yx
 * JD-Core Version:    0.6.2
 */