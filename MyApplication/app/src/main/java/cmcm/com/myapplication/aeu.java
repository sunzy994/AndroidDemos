package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.leap.dice.DiceAdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aeu
  implements OnClickListener, OnTouchListener
{
  private final Context a;
  private final aew b;
  private final View c;
  private final DiceAdView d;
  private final FrameLayout e;
  private final View f;
  private final List<View> g = new ArrayList();
  private final View h;
  private final TextView i;
  private boolean j;
  private aev k;
  private float l;
  private float m;
  private int n;
  private boolean o;
  private boolean p;
  private RectF[] q;

  public aeu(Context paramContext, aew paramaew)
  {
    this.a = paramContext;
    this.b = paramaew;
    this.c = LayoutInflater.from(paramContext).inflate(2130968642, null, false);
    this.h = this.c.findViewById(2131755262);
    this.e = ((FrameLayout)this.c.findViewById(2131755260));
    this.d = ((DiceAdView)this.c.findViewById(2131755116));
    this.d.setDiceView(this.b);
    this.f = this.c.findViewById(2131755259);
    this.f.setOnTouchListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.c.setVisibility(8);
    this.i = ((TextView)this.c.findViewById(2131755261));
    if (!vj.g)
      this.i.setMinHeight(this.c.getHeight() / 3);
    this.i.setOnClickListener(this);
  }

  private void k()
  {
    this.e.setVisibility(0);
    this.e.setTranslationY(aqs.ad() - this.d.getY());
    this.e.animate().translationY(0.0F).setDuration(500L);
  }

  public View a()
  {
    return (View)this.d.getParent();
  }

  public void a(final afa paramafa, Bitmap paramBitmap)
  {
    vv.a().a("显示壁纸");
    paramafa = new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        aeu.a(aeu.this, new aev(aeu.this, null));
        aeu.c(aeu.this).a(aeu.b(aeu.this), paramafa);
      }
    };
    this.d.setActionOnClickListener(paramafa);
    a(paramBitmap, this.a.getString(2131231060), paramafa);
    this.d.a();
    this.d.setOnClickListener(null);
  }

  public void a(Configuration paramConfiguration)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (aeu.a(aeu.this) != null)
          aeu.a(aeu.this).d();
      }
    });
  }

  public void a(Bitmap paramBitmap, String paramString, OnClickListener paramOnClickListener)
  {
    a(false);
    this.d.a(paramBitmap, paramString);
    this.d.setOnClickListener(paramOnClickListener);
  }

  public void a(final Runnable paramRunnable)
  {
    this.j = false;
    asv.b(this.c.animate().alpha(0.0F).setDuration(300L), new Runnable() {
      public void run() {
        asv.b(aeu.d(aeu.this).animate(), null);
        aeu.d(aeu.this).setVisibility(8);
        if (paramRunnable != null)
          paramRunnable.run();
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      this.d.getCoverContainer().removeView(localView);
    }
    this.g.clear();
    this.d.a(paramBoolean);
    this.d.setOnTouchListener(null);
  }

  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    this.j = true;
    this.h.setOnClickListener(this);
    this.c.setVisibility(0);
    this.c.animate().alpha(1.0F).setDuration(300L);
    if (paramBoolean)
    {
      this.i.setVisibility(8);
      this.d.setVisibility(0);
    }
    while (true)
    {
      k();
      this.h.setTranslationY(aqs.ad() - this.h.getY() - c().getY());
      this.h.animate().translationY(0.0F).setStartDelay(450L).setDuration(350L);
      if (paramRunnable != null)
        c().postDelayed(paramRunnable, 800L);
      return;
      d();
      this.d.setVisibility(4);
    }
  }

  public void a(RectF[] paramArrayOfRectF)
  {
    this.q = paramArrayOfRectF;
    this.n = ViewConfiguration.get(SwipeApplication.c()).getScaledTouchSlop();
  }

  public View b()
  {
    return this.d;
  }

  public View c()
  {
    return this.c;
  }

  public void d()
  {
    this.i.setVisibility(0);
  }

  public boolean e()
  {
    return this.j;
  }

  public void f()
  {
    if (this.k != null)
      this.k.a();
    this.d.getAdViewHolder().a();
  }

  public View g()
  {
    return this.e;
  }

  public View h()
  {
    return this.d.getCoverView();
  }

  public boolean i()
  {
    return this.d.b();
  }

  public abg j()
  {
    return this.d.getAdViewHolder();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
      if (this.b != null)
        this.b.a();
    do
    {
      do
      {
        do
        {
          return;
          if (paramView != this.i)
            break;
        }
        while (this.b == null);
        this.b.a();
        return;
        if ((!this.o) && (!this.p))
          break;
      }
      while (this.b == null);
      this.b.a();
      return;
    }
    while ((paramView != this.f) || (this.b == null));
    this.b.d();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null);
    while (true)
    {
      return false;
      if (this.q != null)
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        default:
          return false;
        case 0:
          this.o = false;
          this.p = false;
          this.l = paramMotionEvent.getX();
          this.m = paramMotionEvent.getY();
          return false;
        case 1:
        }
        int i1 = (int)Math.abs(paramMotionEvent.getX() - this.l);
        int i2 = (int)Math.abs(paramMotionEvent.getY() - this.m);
        if ((i1 > this.n) || (i2 > this.n))
        {
          this.p = true;
          return false;
        }
        paramView = this.q;
        i2 = paramView.length;
        i1 = 0;
        while (i1 < i2)
        {
          Object localObject = paramView[i1];
          if ((localObject.contains(this.l, this.m)) && (localObject.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
          {
            this.o = true;
            return false;
          }
          i1 += 1;
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aeu
 * JD-Core Version:    0.6.2
 */