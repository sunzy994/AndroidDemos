package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lazyswipe.features.boostplus.AdCoverImageView;
import com.lazyswipe.features.boostplus.BoostPlusCleaningPanel;
import com.lazyswipe.features.boostplus.CoverImageView;
import java.io.File;

public class acj
  implements Callback, OnClickListener, att
{
  private static final String a = "Swipe." + acj.class.getSimpleName();
  private final abr A = new abr()
  {
    public void a(abq paramAnonymousabq)
    {
    }

    public void a(abq paramAnonymousabq, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean);
      do
      {
        return;
        acj.a(acj.this, false);
        acj.b(acj.this, paramAnonymousabq);
      }
      while (acj.b(acj.this) == null);
      acj.b(acj.this, acj.c(acj.this), paramAnonymousabq);
    }

    public void a(abq paramAnonymousabq, boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString)
    {
      acj.a(acj.this, false);
      acj.e(acj.this);
      if ((acj.b(acj.this) != null) && (acj.b(acj.this).findViewById(2131755153) != null))
        acj.b(acj.this).findViewById(2131755153).setVisibility(8);
    }
  };
  private final Context b;
  private BoostPlusCleaningPanel c;
  private final atq d;
  private boolean e = false;
  private final boolean f = false;
  private final Handler g = new Handler(this);
  private View h = null;
  private View i = null;
  private ViewGroup j = null;
  private final aba k;
  private abq l;
  private View m = null;
  private final abr n = new abr()
  {
    public void a(abq paramAnonymousabq)
    {
    }

    public void a(abq paramAnonymousabq, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean);
      do
      {
        return;
        acj.a(acj.this, paramAnonymousabq);
      }
      while (acj.b(acj.this) == null);
      acj.a(acj.this, acj.c(acj.this), paramAnonymousabq);
    }

    public void a(abq paramAnonymousabq, boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString)
    {
      acj.d(acj.this);
    }
  };
  private View o;
  private boolean p = false;
  private View q = null;
  private View r = null;
  private ViewGroup s = null;
  private abw t = null;
  private boolean u = false;
  private View v = null;
  private ViewGroup w = null;
  private final aba x;
  private abq y;
  private View z = null;

  public acj(Context paramContext)
  {
    this.b = paramContext;
    this.d = atq.a(paramContext, aro.b(paramContext).getAbsolutePath(), this);
    this.k = new aba(paramContext, 6);
    this.k.a(this.n);
    this.x = new aba(paramContext, 6, 4, null);
    this.x.a(this.A);
  }

  private void a(final abw paramabw)
  {
    q();
    a(this.s, 1);
    this.o = asr.a(this.b, 2130968589, this.s, false);
    ((TextView) asr.a(this.o, 2131755079)).setText(paramabw.c());
    ((TextView) asr.a(this.o, 2131755080)).setText(paramabw.d());
    if (this.o.findViewById(2131755076) != null)
      this.o.findViewById(2131755076).setVisibility(8);
    ((TextView) asr.a(this.o, 2131755081)).setText(2131231221);
    a((ImageView) asr.a(this.o, 2131755075), paramabw.e(), false);
    a((ImageView) asr.a(this.o, 2131755064), paramabw.a(), false);
    this.o.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        acj.b(acj.this).b();
        paramAnonymousView = new Intent("android.intent.action.VIEW");
        paramAnonymousView.addCategory("android.intent.category.DEFAULT");
        paramAnonymousView.addCategory("android.intent.category.BROWSABLE");
        paramAnonymousView.setData(Uri.parse(paramabw.b()));
        paramAnonymousView.putExtra("com.android.browser.application_id", "com.lazyswipe");
        asq.d(acj.c(acj.this), paramAnonymousView);
      }
    });
    p();
  }

  private void a(Context paramContext)
  {
    if (!arl.i(paramContext))
      return;
    b(paramContext);
  }

  private void a(Context paramContext, abq paramabq)
  {
    l();
    a(this.j, 1);
    this.m = LayoutInflater.from(paramContext).inflate(2130968588, null);
    ((TextView)this.m.findViewById(2131755079)).setText(paramabq.d());
    ((TextView)this.m.findViewById(2131755080)).setText(paramabq.e());
    ((TextView)this.m.findViewById(2131755081)).setText(paramabq.c());
    ((TextView)this.m.findViewById(2131755081)).setText(paramabq.c());
    a((AdCoverImageView)this.m.findViewById(2131755075), paramabq.i(), false);
    a((ImageView)this.m.findViewById(2131755064), paramabq.g(), false);
    paramabq.a(this.m, new Runnable()
    {
      public void run()
      {
        acj.b(acj.this).b();
      }
    });
    n();
  }

  private void a(View paramView, int paramInt)
  {
    if (paramInt == 0)
      paramView.getLayoutParams().height = ((int)(0.5226131F * aqs.ae()));
    do
    {
      return;
      if (paramInt == 1)
      {
        paramView.getLayoutParams().height = -2;
        return;
      }
    }
    while (paramInt != 2);
    paramView.getLayoutParams().height = paramView.getHeight();
  }

  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramImageView.getScaleType() != ScaleType.FIT_XY)
      paramImageView.startAnimation(AnimationUtils.loadAnimation(this.b, 17432576));
    if ((paramImageView instanceof CoverImageView))
      ((CoverImageView)paramImageView).a(paramBitmap, true);
    while (true)
    {
      paramImageView.setScaleType(ScaleType.CENTER_CROP);
      return;
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  private void a(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    try
    {
      paramImageView.setTag(paramString);
      paramString = (atv)this.d.a(new atv(paramImageView, paramString, this.g, 1));
      if (paramString != null)
      {
        paramString.b();
        return;
      }
      a(paramImageView, paramBoolean);
      return;
    }
    catch (Exception paramImageView)
    {
    }
  }

  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    Resources localResources = this.b.getResources();
    if (paramBoolean);
    for (int i1 = 2130837608; ; i1 = 2130837743)
    {
      paramImageView.setImageDrawable(localResources.getDrawable(i1));
      paramImageView.setScaleType(ScaleType.CENTER_INSIDE);
      return;
    }
  }

  private void b(Context paramContext)
  {
    j();
    this.k.b();
  }

  private void b(Context paramContext, abq paramabq)
  {
    s();
    this.z = LayoutInflater.from(paramContext).inflate(2130968590, null);
    ((TextView)this.z.findViewById(2131755079)).setText(paramabq.d());
    ((TextView)this.z.findViewById(2131755080)).setText(paramabq.e());
    ((TextView)this.z.findViewById(2131755081)).setText(paramabq.c());
    this.z.findViewById(2131755076).setVisibility(8);
    ((TextView)this.z.findViewById(2131755081)).setText(paramabq.c());
    a((ImageView)this.z.findViewById(2131755064), paramabq.g(), false);
    paramabq.a(this.z, new Runnable()
    {
      public void run()
      {
        acj.b(acj.this).b();
      }
    });
    u();
  }

  private void c(Context paramContext)
  {
    if (!arl.i(paramContext))
      return;
    d(paramContext);
  }

  private void d(Context paramContext)
  {
    r();
    this.x.b();
    this.u = true;
  }

  private void j()
  {
    if (this.h != null)
      this.h.setVisibility(0);
    if (this.i != null)
      this.i.setVisibility(8);
  }

  private void k()
  {
    if (this.h != null)
      this.h.setVisibility(8);
    if (this.i != null)
      this.i.setVisibility(0);
  }

  private void l()
  {
    if (this.h != null)
      this.h.setVisibility(8);
    if (this.i != null)
      this.i.setVisibility(8);
  }

  private void m()
  {
    View localView = this.c.findViewById(2131755148);
    this.h = localView.findViewById(2131755149);
    this.i = localView.findViewById(2131755151);
    this.j = ((ViewGroup)localView.findViewById(2131755152));
    ((ProgressBar)this.h.findViewById(2131755150)).setIndeterminateDrawable(new tn(this.b));
    this.i.setOnClickListener(this);
  }

  private void n()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.m.getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(this.m);
      label23: this.j.addView(this.m);
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }

  private void o()
  {
    View localView = this.c.findViewById(2131755155);
    this.r = localView.findViewById(2131755149);
    this.q = localView.findViewById(2131755151);
    this.s = ((ViewGroup)localView.findViewById(2131755152));
    ((ProgressBar)this.r.findViewById(2131755150)).setIndeterminateDrawable(new tn(this.b));
    this.q.setOnClickListener(this);
  }

  private void p()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.o.getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(this.o);
      label23: this.s.addView(this.o);
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }

  private void q()
  {
    if (this.r != null)
      this.r.setVisibility(8);
    if (this.q != null)
      this.q.setVisibility(8);
  }

  private void r()
  {
    if (this.v != null)
      this.v.setVisibility(0);
  }

  private void s()
  {
    if (this.v != null)
      this.v.setVisibility(8);
  }

  private void t()
  {
    View localView = this.c.findViewById(2131755153);
    this.v = localView.findViewById(2131755149);
    this.w = ((ViewGroup)localView.findViewById(2131755152));
    ((ProgressBar)this.v.findViewById(2131755150)).setIndeterminateDrawable(new tn(this.b));
  }

  private void u()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.z.getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(this.z);
      label23: this.w.addView(this.z);
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }

  public void a()
  {
    if (abd.a(this.b, 6))
    {
      this.e = true;
      d();
      h();
      f();
    }
  }

  public void a(atr paramatr)
  {
  }

  public void a(BoostPlusCleaningPanel paramBoostPlusCleaningPanel)
  {
    this.c = paramBoostPlusCleaningPanel;
    m();
    t();
    o();
    a(this.j, 0);
    a(this.s, 0);
    if (this.l != null)
      a(this.b, this.l);
    if (this.t != null)
      a(this.t);
    if (this.y != null)
      b(this.b, this.y);
  }

  public void b(atr paramatr)
  {
  }

  public boolean b()
  {
    return this.e;
  }

  public void c()
  {
    try
    {
      if (this.l != null)
        this.g.postDelayed(new Runnable()
        {
          public void run()
          {
            acj.a(acj.this).m();
          }
        }
        , 3000L);
      atq.a(this.d);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void d()
  {
    if (abd.a())
      a(this.b);
  }

  public View e()
  {
    if (this.c != null)
      return this.c.findViewById(2131755148);
    return null;
  }

  public void f()
  {
  }

  public View g()
  {
    if (this.c != null)
      return this.c.findViewById(2131755155);
    return null;
  }

  public void h()
  {
    if (abd.a(this.b, 6))
      c(this.b);
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    }
    while (true)
    {
      return true;
      paramMessage = (atv)paramMessage.obj;
      if (paramMessage != null)
        if (paramMessage.a().equals(paramMessage.f().getTag()))
          a((ImageView)paramMessage.f(), paramMessage.e);
        else
          atw.a(paramMessage.e);
    }
  }

  public View i()
  {
    if (((this.z != null) || (this.u)) && (this.c != null))
      return this.c.findViewById(2131755153);
    return null;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.i)
      a(this.b);
    while (paramView != this.q)
      return;
    f();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acj
 * JD-Core Version:    0.6.2
 */