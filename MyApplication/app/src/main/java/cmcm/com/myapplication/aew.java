package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class aew extends FrameLayout
{
  private static final String a = "Swipe." + aew.class.getSimpleName();
  private final aex b;
  private final aet c;
  private boolean d;
  private final aeu e;
  private final View f;
  private final float g = 0.7F;
  private final Handler h = new Handler();
  private yb i;
  private final SensorManager j;
  private final SensorEventListener k = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
    {
    }

    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      paramAnonymousSensorEvent = paramAnonymousSensorEvent.values;
      float f1 = paramAnonymousSensorEvent[0];
      float f2 = paramAnonymousSensorEvent[1];
      float f3 = paramAnonymousSensorEvent[2];
      if ((Math.abs(f1) > 19) || (Math.abs(f2) > 19) || (Math.abs(f3) > 19))
      {
        asq.a(aew.this.getContext(), 100L);
        aew.this.post(new Runnable()
        {
          public void run()
          {
            aew.this.a();
          }
        });
        aew.e(aew.this);
      }
    }
  };

  public aew(Context paramContext)
  {
    super(paramContext);
    setClickable(true);
    this.b = new aex(paramContext);
    this.f = new View(getContext());
    addView(this.f, -1, -1);
    this.f.setBackgroundDrawable(this.b);
    this.b.a(getPaddingLeft(), getPaddingTop() + aqs.ak(), getPaddingRight(), getPaddingBottom());
    this.f.setPadding(getPaddingLeft(), getPaddingTop() + aqs.ak(), getPaddingRight(), getPaddingBottom());
    this.e = new aeu(getContext(), this);
    addView(this.e.c());
    this.c = new aet(getContext(), this);
    this.j = ((SensorManager)paramContext.getSystemService("sensor"));
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f.setBackgroundDrawable(this.b);
    this.b.i();
    this.b.a(0.7F);
    this.c.a(paramBoolean1, paramBoolean2);
  }

  private void b(boolean paramBoolean)
  {
    int m;
    float f1;
    if (vj.g)
    {
      int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
      if (this.e.i())
      {
        localView = this.e.h();
        if (localView != null)
          break label165;
      }
      label165: for (n = 0; ; n = localView.getWidth())
      {
        m = n;
        if (n <= 0)
          m = localView.getMeasuredWidth();
        n = m;
        if (m <= 0)
        {
          n = m;
          if (localView != null)
          {
            n = m;
            if (localView.getLayoutParams() != null)
            {
              n = m;
              if (localView.getLayoutParams().width > 0)
              {
                n = m;
                if (localView.getLayoutParams().width < getMeasuredWidth())
                  n = localView.getLayoutParams().width;
              }
            }
          }
        }
        f1 = (i1 - n) / 2 / i1;
        this.b.a(f1, false);
        return;
        localView = this.e.b();
        break;
      }
    }
    View localView = this.e.g();
    if (localView == null);
    for (int n = 0; ; n = localView.getMeasuredHeight())
    {
      m = n;
      if (n <= 0)
        m = localView.getHeight();
      n = m;
      if (m <= 0)
      {
        n = m;
        if (localView != null)
        {
          n = m;
          if (localView.getLayoutParams() != null)
          {
            n = m;
            if (localView.getLayoutParams().height > 0)
            {
              n = m;
              if (localView.getLayoutParams().height < getMeasuredHeight())
                n = localView.getLayoutParams().height;
            }
          }
        }
      }
      m = getHeight() - getPaddingTop() - getPaddingBottom();
      f1 = (m - n) / 2 / m;
      this.b.a(f1, true);
      return;
    }
  }

  private void g()
  {
    try
    {
      this.j.registerListener(this.k, this.j.getDefaultSensor(1), 3);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void h()
  {
    try
    {
      this.j.unregisterListener(this.k);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a()
  {
    this.e.a(new Runnable()
    {
      public void run()
      {
        aew.a(aew.this).f();
        aew.a(aew.this, false, false);
      }
    });
  }

  public void a(yb paramyb)
  {
    this.i = paramyb;
    a(true);
    this.i.addView(this, new LayoutParams(-1, -1));
  }

  public void a(boolean paramBoolean)
  {
    a(true, paramBoolean);
  }

  public void a(final boolean paramBoolean, final Runnable paramRunnable)
  {
    this.e.c().setVisibility(4);
    this.e.g().setVisibility(4);
    if (!paramBoolean)
      this.e.d();
    postDelayed(new Runnable()
    {
      public void run()
      {
        aew.a(aew.this, paramBoolean);
        aew.b(aew.this).a(new aep()
        {
          public void a()
          {
            aew.a(aew.this).a(aew.b(aew.this).a());
            aew.a(aew.this).a(aew.2.this.a, aew.2.this.b);
            aew.d(aew.this).postDelayed(new Runnable()
            {
              public void run()
              {
                aew.c(aew.this);
              }
            }
            , 500L);
          }
        });
      }
    }
    , 30L);
  }

  public boolean b()
  {
    return !this.d;
  }

  public void c()
  {
    yb.p();
  }

  public void d()
  {
  }

  public void e()
  {
    if (this.i != null)
    {
      this.i.removeView(this);
      this.i = null;
    }
  }

  public boolean f()
  {
    e();
    return true;
  }

  public aeu getAdView()
  {
    return this.e;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.d = true;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.e.a(paramConfiguration);
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d = false;
    if (this.b.h())
      this.b.j();
    this.e.f();
    this.c.b();
    this.b.k();
    h();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aew
 * JD-Core Version:    0.6.2
 */