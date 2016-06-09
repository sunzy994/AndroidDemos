package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.lazyswipe.features.boostplus.BoostActivity;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.search.SearchWebActivity;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherForecast;
import com.lazyswipe.features.weather.detail.WeatherPopupView;
import com.lazyswipe.ui.CleanerSettingsActivity;
import java.lang.ref.WeakReference;
import java.util.Date;

public class acy extends FrameLayout
  implements ajw, OnClickListener
{
  private static final String a = "Swipe." + acy.class.getSimpleName();
  private Point b;
  private int c = asq.a(12.0F);
  private int d = asq.a(24.0F);
  private int e = asq.a(20.0F);
  private boolean f;
  private WeakReference<acw> g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private View l;
  private View m;
  private boolean n;
  private boolean o = true;
  private ake p;
  private boolean q;
  private aks r;
  private WeatherForecast s;
  private BroadcastReceiver t = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent == null) || (paramAnonymousIntent.getAction() == null));
      while (!"BROADCAST_ACTION_HOME_KEY".equals(paramAnonymousIntent.getAction()))
        return;
      acy.this.a(true);
    }
  };

  public acy(Context paramContext)
  {
    super(paramContext);
  }

  public static acy a(acw paramacw)
  {
    acy localacy = new acy(paramacw.getContext());
    localacy.g = new WeakReference(paramacw);
    localacy.b();
    return localacy;
  }

  private TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setTextColor(16777215);
    localTextView.setTextSize(12.7F);
    localTextView.setMaxLines(1);
    localTextView.setOnClickListener(this);
    localTextView.setCompoundDrawablePadding(asq.a(8.0F));
    localTextView.setGravity(17);
    localTextView.setAlpha(0.0F);
    paramString = new aug(atw.a(paramInt1, this.e), getResources().getDrawable(paramInt2), this.e * 2);
    float f1;
    double d1;
    if (this.f)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramString, null, null, null);
      paramString = new LayoutParams(-2, -2);
      f1 = ari.a(paramInt3);
      paramInt1 = asq.a(115.0F);
      if (!this.f)
        break label233;
      paramString.gravity = 51;
      paramString.topMargin = (vj.f / 2 - (int)(paramInt1 * Math.sin(f1)) - this.e);
      d1 = paramInt1;
      paramString.leftMargin = ((int)(Math.cos(f1) * d1) + this.c + this.d - this.e);
    }
    while (true)
    {
      addView(localTextView, paramString);
      return localTextView;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString, null);
      break;
      label233: paramString.gravity = 53;
      paramString.topMargin = (vj.f / 2 - (int)(paramInt1 * Math.sin(f1)) - this.e);
      d1 = paramInt1;
      paramString.rightMargin = ((int)(Math.cos(f1) * d1) + this.c + this.d - this.e);
    }
  }

  private void a(final TextView paramTextView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    localValueAnimator.setDuration(150L).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramTextView.setTextColor(Color.argb(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 255, 255, 255));
      }
    });
    localValueAnimator.start();
  }

  private void a(final TextView paramTextView, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.setDuration(90L).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramTextView.setTextColor(Color.argb(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 255, 255, 255));
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = paramTextView.animate();
        if (acy.f(acy.this));
        for (float f = acy.g(acy.this) + acy.h(acy.this) - acy.i(acy.this); ; f = vj.e - acy.g(acy.this) - acy.h(acy.this) + acy.i(acy.this) - paramTextView.getWidth())
        {
          paramAnonymousAnimator.x(f).y(vj.f / 2 - acy.i(acy.this)).setDuration(200L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              acy.5.this.a.setAlpha(0.0F);
              acy.j(acy.this);
            }
          });
          return;
        }
      }
    });
    localValueAnimator.start();
  }

  private void a(final TextView paramTextView, long paramLong)
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        TextView localTextView = paramTextView;
        if (acy.f(acy.this));
        for (float f = acy.g(acy.this) + acy.h(acy.this) - acy.i(acy.this); ; f = vj.e - acy.g(acy.this) - acy.h(acy.this) + acy.i(acy.this) - paramTextView.getWidth())
        {
          localTextView.setX(f);
          paramTextView.setY(vj.f / 2 - acy.i(acy.this));
          paramTextView.setAlpha(1.0F);
          paramTextView.animate().translationX(0.0F).translationY(0.0F).setDuration(250L).setInterpolator(new ye()).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              acy.this.postDelayed(new Runnable()
              {
                public void run()
                {
                  acy.a(acy.this, acy.2.this.a);
                }
              }
              , 40L);
            }
          });
          return;
        }
      }
    }
    , paramLong);
  }

  private void b()
  {
    try
    {
      this.b = ((acw)this.g.get()).getCenterPoint();
      this.f = ((acw)this.g.get()).u();
      label34: this.m = new View(getContext());
      this.m.setBackgroundColor(-503316480);
      this.m.setLayerType(2, null);
      this.m.setAlpha(0.0F);
      addView(this.m, -1, -1);
      this.h = a(getResources().getString(2131231172), -53931, 2130837690, 53);
      this.i = a(getResources().getString(2131231193), -13587101, 2130837553, 19);
      this.k = a(getResources().getString(2131230947), -16745729, 2130837554, -19);
      this.j = a(getResources().getString(2131230948), -157913, 2130837555, -53);
      this.l = c();
      setOnClickListener(this);
      WindowManager.LayoutParams localLayoutParams = ast.a(getContext());
      ast.a(getContext(), this, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }

  private ImageView c()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ScaleType.CENTER_INSIDE);
    localImageView.setBackgroundDrawable(atw.a(-1, this.d));
    localImageView.setImageResource(2130837723);
    localImageView.setOnClickListener(this);
    localImageView.setAlpha(0.0F);
    LayoutParams localLayoutParams = new LayoutParams(this.d * 2, this.d * 2);
    if (this.f)
    {
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = (vj.f / 2 - this.d);
      localLayoutParams.leftMargin = this.c;
    }
    while (true)
    {
      addView(localImageView, localLayoutParams);
      return localImageView;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = (vj.f / 2 - this.d);
      localLayoutParams.rightMargin = this.c;
    }
  }

  private void d()
  {
    if ((this.g != null) && (this.g.get() != null))
      ((acw)this.g.get()).animate().alpha(0.0F).setDuration(50L);
    this.m.animate().alpha(1.0F).setDuration(150L);
    View localView = this.l;
    int i2 = this.b.x;
    if (this.f);
    for (int i1 = this.d + this.c; ; i1 = vj.e - this.d - this.c)
    {
      localView.setTranslationX(i2 - i1);
      this.l.setTranslationY(this.b.y - vj.f / 2);
      this.l.setPivotX(this.d);
      this.l.setPivotY(this.d);
      this.l.setScaleX(0.8F);
      this.l.setScaleY(0.8F);
      this.l.setAlpha(0.1F);
      this.l.setRotation(45.0F);
      this.l.animate().alpha(1.0F).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setDuration(getCenterCircleDuration()).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          acy.a(acy.this).animate().rotation(0.0F).setDuration(150L).setListener(null);
          acy.a(acy.this, acy.b(acy.this), 0L);
          acy.a(acy.this, acy.c(acy.this), 30L);
          acy.a(acy.this, acy.d(acy.this), 60L);
          acy.a(acy.this, acy.e(acy.this), 90L);
        }
      });
      return;
    }
  }

  private void e()
  {
    this.l.animate().rotation(45.0F).setDuration(150L).setListener(null);
    a(this.j, 0);
    a(this.k, 30);
    a(this.i, 60);
    a(this.h, 90);
  }

  private void f()
  {
    this.m.animate().alpha(0.0F).setDuration(150L);
    int i2 = getCenterCircleDuration();
    ViewPropertyAnimator localViewPropertyAnimator = this.l.animate();
    int i3 = this.b.x;
    if (this.f);
    for (int i1 = this.d + this.c; ; i1 = vj.e - this.d - this.c)
    {
      localViewPropertyAnimator.translationX(i3 - i1).translationY(this.b.y - vj.f / 2).alpha(0.0F).scaleX(0.8F).scaleY(0.8F).setDuration(i2).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          acy.this.a(false);
        }
      });
      postDelayed(new Runnable()
      {
        public void run()
        {
          if (acy.k(acy.this).get() != null);
          try
          {
            ((acw)acy.k(acy.this).get()).animate().setDuration(100L).alpha(1.0F).setListener(null);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      }
      , i2 - 33);
      return;
    }
  }

  private int getCenterCircleDuration()
  {
    return (int)(Math.abs(this.b.y - vj.f * 0.5F) / (vj.f * 0.5F) * 125.0F + 125.0F);
  }

  public void a()
  {
  }

  public void a(aks paramaks, WeatherForecast paramWeatherForecast)
  {
    if ((WeatherPopupView.getInstance() != null) && (this.p != null))
      WeatherPopupView.getInstance().a();
    if (!this.n)
      return;
    if ("1".equals(vs.a(getContext(), "key_pop_weather_detail", "0")))
    {
      this.h.setText(2131231172);
      return;
    }
    this.r = paramaks;
    this.s = paramWeatherForecast;
    Object localObject = getContext();
    Resources localResources;
    int i1;
    if (paramaks != null)
    {
      paramWeatherForecast = this.h;
      localObject = paramaks.b((Context)localObject);
      localResources = getResources();
      if (vs.R(getContext()));
      for (i1 = 2131231204; ; i1 = 2131231205)
      {
        paramWeatherForecast.setText(String.format("%s%s, %s", new Object[] { localObject, localResources.getString(i1), paramaks.a(getContext()) }));
        return;
      }
    }
    paramaks = akc.a(paramWeatherForecast, new Date(), 0);
    if ((paramaks != null) && (paramaks.a() != null))
    {
      paramWeatherForecast = this.h;
      localObject = paramaks.e((Context)localObject);
      localResources = getResources();
      if (vs.R(getContext()));
      for (i1 = 2131231204; ; i1 = 2131231205)
      {
        paramWeatherForecast.setText(String.format("%s%s, %s", new Object[] { localObject, localResources.getString(i1), paramaks.c(getContext()) }));
        return;
      }
    }
    this.h.setText(2131231172);
  }

  public void a(Time paramTime)
  {
  }

  public void a(City paramCity)
  {
    if (paramCity == null)
    {
      this.q = false;
      return;
    }
    this.q = true;
  }

  void a(boolean paramBoolean)
  {
    ast.a(getContext(), this);
    if ((paramBoolean) && (this.g.get() != null));
    try
    {
      ((acw)this.g.get()).animate().setDuration(100L).alpha(1.0F).setListener(null);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      e();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.n = true;
    d();
    try
    {
      this.p = new ake(getContext(), this);
      this.p.c();
      IntentFilter localIntentFilter = new IntentFilter("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.t, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onClick(View paramView)
  {
    if (paramView == this.i)
    {
      a(true);
      if (BoostActivity.g())
      {
        paramView = new Intent(getContext(), BoostActivity.class);
        paramView.addFlags(67108864);
      }
    }
    do
    {
      do
      {
        asq.d(getContext(), paramView);
        do
          return;
        while (this.g.get() == null);
        try
        {
          ((acw)this.g.get()).f_();
          return;
        }
        catch (Throwable paramView)
        {
          return;
        }
        if (paramView == this.k)
        {
          SearchWebActivity.a(getContext(), "", 3);
          a(true);
          return;
        }
        if (paramView == this.j)
        {
          paramView = new Intent(getContext(), CleanerSettingsActivity.class);
          paramView.addFlags(67108864);
          asq.d(getContext(), paramView);
          a(true);
          return;
        }
        if (paramView != this.h)
          break;
        vy.b(getContext(), "B51");
      }
      while (this.p == null);
      if (this.q)
      {
        this.o = false;
        a(true);
        paramView = ast.a(getContext());
        paramView.flags &= -9;
        paramView.flags |= 256;
        WeatherPopupView.a(getContext(), this.p, paramView, 3, true);
        return;
      }
      CityQueryView.a(getContext());
      return;
    }
    while ((paramView != this) && (paramView != this.l));
    e();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.n = false;
    this.m.setLayerType(0, null);
    if (this.o)
      this.p.d();
    try
    {
      ci.a(getContext()).a(this.t);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acy
 * JD-Core Version:    0.6.2
 */