package cmcm.com.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class atc
{
  private static int c = 0;
  private static final List<atc> d = new ArrayList();
  private static final Object e = new Object();
  private final Context a;
  private final String b;
  private ath f = null;
  private final Notification g;
  private final int h;
  private boolean i = false;
  private final atd j;
  private final atf k = new atf(this, null);
  private final Handler l = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              if (!atc.c(atc.this))
              {
                atc.e(atc.this).contentView.setProgressBar(2131755234, 100, atc.d(atc.this).a(), false);
                arm.a(atc.f(atc.this), atc.g(atc.this), atc.e(atc.this));
                aso.a(atc.f(atc.this), 2131230916);
              }
              if (atc.h(atc.this).hasMessages(2))
                atc.h(atc.this).removeMessages(2);
              atc.h(atc.this).sendEmptyMessageDelayed(2, 1000L);
              return;
              atc.h(atc.this).post(atc.i(atc.this));
            }
            while ((atc.j(atc.this) == null) || (!(atc.j(atc.this) instanceof ate)) || (atc.this.b()));
            ((ate)atc.j(atc.this)).b(atc.d(atc.this).a());
            return;
            atc.k(atc.this);
            atc.this.b(atc.this);
            if (!atc.c(atc.this))
              aso.a(atc.f(atc.this), 2131230915);
          }
          while (atc.j(atc.this) == null);
          atc.j(atc.this).b();
          return;
          atc.k(atc.this);
          atc.this.b(atc.this);
          i = paramAnonymousMessage.getData().getInt("errorNo");
        }
        while (atc.j(atc.this) == null);
        atc.j(atc.this).a(i);
        return;
        atc.k(atc.this);
        return;
        atc.this.b(atc.this);
        atc.k(atc.this);
      }
      while ((atc.j(atc.this) == null) || (!(atc.j(atc.this) instanceof ate)));
      ((ate)atc.j(atc.this)).c();
    }
  };

  public atc(Context paramContext, String paramString1, File paramFile, String paramString2, String paramString3, atg paramatg, atd paramatd)
  {
    this.a = paramContext;
    this.j = paramatd;
    this.b = paramString1;
    this.f = new ath(paramContext, paramFile, paramString2, paramString3, this.l, paramatg);
    this.h = ((int)(Math.random() * 2147483647.0D));
    this.g = new Notification(17301633, paramString1, System.currentTimeMillis());
    this.g.contentView = new RemoteViews(paramContext.getPackageName(), 2130968632);
    this.g.contentView.setCharSequence(2131755233, "setText", paramString1);
    this.g.flags |= 2;
  }

  private void c()
  {
    this.l.removeCallbacks(this.k);
    this.l.removeMessages(2);
    if (!this.i)
      arm.a(this.a, this.h);
  }

  public void a()
  {
    this.f.start();
    a(this);
    if (this.j != null)
      this.j.r_();
  }

  public void a(Intent paramIntent)
  {
    if (this.i)
      return;
    c += 1;
    if (c >= 100)
      c = 0;
    this.g.contentIntent = PendingIntent.getActivity(this.a, c, paramIntent, 134217728);
  }

  protected void a(atc paramatc)
  {
    synchronized (e)
    {
      d.add(paramatc);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  protected void b(atc paramatc)
  {
    synchronized (e)
    {
      d.remove(paramatc);
      if (d.size() == 0);
      return;
    }
  }

  public boolean b()
  {
    return this.f.b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atc
 * JD-Core Version:    0.6.2
 */