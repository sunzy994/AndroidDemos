package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import com.holaverse.charging.model.Battery;
import com.holaverse.charging.view.AdEventLayout;
import com.holaverse.charging.view.AdView;
import com.holaverse.charging.view.BubblesView;
import com.holaverse.charging.view.DigitalClock;
import com.holaverse.charging.view.FlashTextView;
import com.holaverse.charging.view.WaveView;

public class uu extends FrameLayout
  implements OnClickListener, un, us
{
  public static int a;
  private int A;
  private float B;
  private float C;
  private VelocityTracker D;
  private Scroller E;
  private GestureDetector F;
  private int G;
  private int H;
  private int I;
  private int J;
  private ValueAnimator K;
  private boolean L;
  private um M;
  private int N;
  private int O;
  private boolean P;
  private Runnable Q = new Runnable()
  {
    public void run()
    {
      uu.a(uu.this, true);
      uu.g(uu.this, uu.p(uu.this) + 1);
      uu.this.setPercent(uu.p(uu.this));
      if (uu.p(uu.this) < uu.q(uu.this))
      {
        uu.this.post(this);
        return;
      }
      uu.a(uu.this, false);
    }
  };
  private uw R;
  public ViewGroup b;
  public View c;
  public View d;
  protected ViewGroup e;
  public WaveView f;
  public LinearLayout g;
  public View h;
  protected boolean i;
  private View j;
  private boolean k;
  private int l;
  private AdView m;
  private TextView n;
  private BubblesView o;
  private TextView p;
  private View q;
  private View r;
  private View s;
  private FlashTextView t;
  private int u;
  private int v = 0;
  private uv w;
  private int x;
  private DigitalClock y;
  private int z;

  public uu(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public uu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public uu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a = ul.a(getContext(), 320.0F);
    this.u = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.E = new Scroller(getContext());
    this.D = VelocityTracker.obtain();
    this.F = new GestureDetector(getContext(), new SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        uu.a(uu.this, (int)paramAnonymousMotionEvent.getX());
        uu.b(uu.this, (int)paramAnonymousMotionEvent.getY());
        uu.c(uu.this, -1);
        AdEventLayout.a = false;
        AdEventLayout.b = null;
        if ((uu.a(uu.this) != null) && (!uu.a(uu.this).isFinished()))
          uu.a(uu.this).abortAnimation();
        uu.d(uu.this, (int)(paramAnonymousMotionEvent.getX() - uu.this.e.getLeft()));
        uu.e(uu.this, (int)(paramAnonymousMotionEvent.getY() - uu.b(uu.this).getTop()));
        uu.f(uu.this, uu.b(uu.this).getScrollY());
        return super.onDown(paramAnonymousMotionEvent);
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        uu.m(uu.this).computeCurrentVelocity(1000);
        if (uu.d(uu.this) == 1)
          if (paramAnonymousFloat2 > 0.0F)
          {
            i = uu.i(uu.this);
            uu.a(uu.this).startScroll(0, uu.b(uu.this).getScrollY(), 0, i - uu.b(uu.this).getScrollY(), (int)(uu.n(uu.this) * 1000.0F));
          }
        while (paramAnonymousFloat1 <= 0.0F)
          while (true)
          {
            uu.this.invalidate();
            return super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
            i = uu.h(uu.this);
          }
        if (paramAnonymousFloat1 > 0.0F);
        for (int i = uu.this.getWidth(); ; i = 0)
        {
          uu.a(uu.this).startScroll((int)uu.this.e.getTranslationX(), 0, (int)(i - uu.this.e.getTranslationX()), 0, (int)(uu.o(uu.this) * 1000.0F));
          break;
        }
      }

      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = Math.abs(paramAnonymousFloat2);
        float f2 = Math.abs(paramAnonymousFloat1);
        uu.c(uu.this);
        int i;
        if ((!AdEventLayout.a) || ((AdEventLayout.b != null) && (!AdEventLayout.b.booleanValue())))
        {
          if (f1 < f2)
            break label182;
          i = 1;
          if (uu.d(uu.this) == -1)
          {
            uu localuu = uu.this;
            if (i == 0)
              break label194;
            if (!uu.e(uu.this))
              break label188;
            i = 1;
            label87: uu.c(localuu, i);
          }
        }
        if (uu.d(uu.this) == 1)
        {
          i = -(int)(paramAnonymousMotionEvent2.getY() - uu.f(uu.this));
          int j = uu.g(uu.this);
          i = Math.min(uu.h(uu.this), Math.max(i + j, uu.i(uu.this)));
          uu.b(uu.this).scrollTo(0, i);
        }
        while (true)
        {
          return super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          label182: i = 0;
          break;
          label188: i = -1;
          break label87;
          label194: i = 0;
          break label87;
          if ((uu.d(uu.this) == 0) && (paramAnonymousMotionEvent2.getX() - uu.j(uu.this) > uu.k(uu.this)))
            uu.this.e.setTranslationX(Math.max(0, (int)paramAnonymousMotionEvent2.getX() - uu.l(uu.this) - uu.this.e.getLeft()));
        }
      }
    });
  }

  private String a(long paramLong)
  {
    long l1 = paramLong / 1000L / 60L;
    paramLong = l1 % 60L;
    l1 /= 60L;
    if (l1 > 0L)
      return l1 + getContext().getString(tz.avai_time_hour) + paramLong + getContext().getString(tz.avai_time_minute);
    return paramLong + getContext().getString(tz.avai_time_minute);
  }

  private void e()
  {
    this.m.scrollTo(0, this.I);
  }

  private void f()
  {
    this.C = (this.e.getTranslationX() / getWidth());
    this.B = (1.0F - Math.abs((this.m.getScrollY() - this.I) / (this.J - this.I)));
    if (this.x == 1)
      a(this.B);
    do
    {
      do
        return;
      while (this.x != 0);
      if (getBackground() != null)
        getBackground().setAlpha((int)(255.0F * (1.0F - this.C)));
    }
    while ((this.C != 1.0F) || (this.w == null));
    this.w.onClose(this);
  }

  private void g()
  {
    this.L = true;
    if (this.K == null)
    {
      this.K = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.K.setDuration(1000L);
      this.K.setInterpolator(new DecelerateInterpolator(1.2F));
      this.K.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (uu.s(uu.this) != null)
            uu.s(uu.this).setAlpha(f * 0.5F + 0.3F);
        }
      });
      this.K.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (uu.t(uu.this))
          {
            uu.u(uu.this).setStartDelay(3000L);
            uu.u(uu.this).start();
          }
        }
      });
      this.K.setRepeatCount(-1);
      this.K.setRepeatMode(2);
    }
    if (!this.K.isStarted())
      this.K.start();
  }

  private void h()
  {
    this.L = false;
    if (this.K != null)
      this.K.cancel();
  }

  public void a()
  {
    this.f.b();
    this.y.b();
    this.t.b();
    h();
  }

  public void a(float paramFloat)
  {
    int i6 = this.n.getWidth();
    int i1 = this.n.getHeight();
    int i3 = this.n.getLeft();
    int i4 = i6 / 2;
    int i5 = this.n.getTop() + i1 / 2;
    this.c.getBackground().setAlpha((int)(255.0F * paramFloat));
    float f1 = Math.max(0.5F, paramFloat);
    this.n.setScaleX(f1);
    this.n.setScaleY(f1);
    int i2 = this.y.getTop();
    i6 = (int)(i6 * 0.5F) / 2;
    int i7 = this.m.getPaddingLeft();
    i1 = (int)(i1 * 0.5F);
    i2 = i2 + i1 / 2 + this.m.getPaddingTop();
    this.n.setTranslationX((i3 + i4 - (i6 + i7)) * (paramFloat - 1.0F));
    this.n.setTranslationY((paramFloat - 1.0F) * (i5 - i2));
    this.d.setScaleX(f1);
    this.d.setScaleY(f1);
    this.d.setTranslationY((paramFloat - 1.0F) * i5);
    View localView = this.d;
    if (paramFloat < 0.5F);
    for (f1 = 0.0F; ; f1 = paramFloat)
    {
      localView.setAlpha(f1);
      i3 = this.p.getWidth();
      i4 = this.p.getHeight();
      i5 = this.p.getLeft();
      i6 = this.p.getWidth() / 2;
      i7 = this.p.getTop();
      int i8 = this.p.getHeight();
      this.p.setTranslationX((i5 + i6 - this.m.getPaddingLeft() - i3 / 2) * (paramFloat - 1.0F));
      this.p.setTranslationY((i7 + i8 - i2 - i1 / 2 - this.m.getPaddingTop() - i4) * (paramFloat - 1.0F));
      return;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    ul.b(getContext(), 5000);
    if (paramInt1 + paramInt2 > 0);
    for (int i1 = 0; ; i1 = 4)
    {
      setMessageLayerVisibility(i1);
      this.g.removeAllViews();
      if (paramInt1 > 0)
        a(ul.a(), paramInt1);
      if (paramInt2 > 0)
        a(ul.b(), paramInt2);
      return;
    }
  }

  public void a(Intent paramIntent, int paramInt)
  {
    uy localuy = new uy(getContext());
    localuy.a(paramIntent);
    localuy.setCount(paramInt);
    paramInt = ul.a(getContext(), 10.0F);
    localuy.setPadding(paramInt, paramInt, paramInt, paramInt);
    paramIntent = new LinearLayout.LayoutParams((int)(paramInt * 4.8D), (int)(paramInt * 4.8D));
    paramIntent.setMargins(paramInt >> 1, paramInt >> 1, paramInt >> 1, paramInt >> 1);
    localuy.setOnClickListener(this);
    this.g.addView(localuy, paramIntent);
  }

  public void a(final Battery paramBattery)
  {
    post(new Runnable()
    {
      public void run()
      {
        float f = paramBattery.a / paramBattery.b;
        if (!uu.v(uu.this))
        {
          if (!uu.this.i)
            break label281;
          uu.g(uu.this, 0);
          uu.h(uu.this, paramBattery.a);
          uu.this.removeCallbacks(uu.w(uu.this));
          uu.this.post(uu.w(uu.this));
          uu.this.f.a(f, true);
          uu.a(uu.this, true);
          uu.this.i = false;
        }
        while (true)
        {
          uu.this.setModel(paramBattery);
          int j = uu.x(uu.this).getHeight();
          int i = (int)(j * 0.08F);
          j = (int)(f * (j - i - i));
          uo.a(paramBattery.e + " ----" + paramBattery.f);
          uu.x(uu.this).setTranslationY(uu.x(uu.this).getHeight() - i - j);
          if (!paramBattery.a())
            break;
          switch (paramBattery.f)
          {
          default:
            return;
            label281: uu.this.setPercent(paramBattery.a);
            uu.this.f.a(f, false);
          case 3:
          case 0:
          case 1:
          case 2:
          }
        }
        uu.y(uu.this).setText(tz.charge_finish);
        return;
        uu.y(uu.this).setText(tz.remaining);
        String str = uu.a(uu.this, paramBattery.e);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(new ForegroundColorSpan(-6881501), 0, str.length(), 33);
        uu.y(uu.this).append(" ");
        uu.y(uu.this).append(localSpannableString);
        return;
        uu.y(uu.this).setText("");
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    if (this.m.getScrollY() != this.I)
    {
      this.x = 1;
      this.E.startScroll(0, this.m.getScrollY(), 0, this.I - this.m.getScrollY(), 1000);
    }
    if (!paramBoolean)
      return;
    postDelayed(new Runnable()
    {
      public void run()
      {
        if (uu.r(uu.this) != null)
          uu.r(uu.this).onClose(uu.this);
      }
    }
    , 1000L);
  }

  public void b()
  {
    this.y.a();
    this.f.a();
    this.t.a();
    if (this.j != null)
      g();
  }

  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    ViewGroup localViewGroup = this.b;
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 4)
    {
      localViewGroup.setVisibility(i1);
      return;
    }
  }

  public void c()
  {
    uo.a("onPowerConnected in CharingView");
    post(new Runnable()
    {
      public void run()
      {
        ul.b(uu.this.getContext(), 5000);
        uu.x(uu.this).setVisibility(0);
      }
    });
  }

  public void computeScroll()
  {
    f();
    if (this.E.computeScrollOffset())
    {
      if (this.x != 0)
        break label41;
      this.e.setTranslationX(this.E.getCurrX());
    }
    while (true)
    {
      invalidate();
      return;
      label41: if (this.x == 1)
        this.m.scrollTo(0, this.E.getCurrY());
    }
  }

  public void d()
  {
    uo.a("onPowerDisConnected in CharingView");
    post(new Runnable()
    {
      public void run()
      {
        uu.x(uu.this).setVisibility(4);
      }
    });
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.M = new um(getContext(), new Handler(), this);
    this.M.a();
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == ty.setting_menu)
    {
      this.h.setVisibility(8);
      if ((paramView instanceof uy))
      {
        paramView = ((uy)paramView).getAction();
        if (!paramView.equals(ul.a().getAction()))
          break label111;
        uq.d(getContext());
      }
    }
    label111: 
    while (!paramView.equals(ul.b().getAction()))
    {
      return;
      if (i1 == ty.charging_setting)
      {
        this.h.setVisibility(0);
        break;
      }
      if (i1 != ty.menu_item_setting)
        break;
      this.h.setVisibility(8);
      if (this.R == null)
        break;
      this.R.a(i1);
      break;
    }
    try
    {
      paramView = new Intent();
      paramView.setAction("android.intent.action.CALL_BUTTON");
      paramView.setFlags(268435456);
      getContext().startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.M != null)
      this.M.b();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((WaveView)findViewById(ty.wave_view));
    this.f.a(-16733441, -12861441);
    this.m = ((AdView)findViewById(ty.ad));
    this.g = ((LinearLayout)findViewById(ty.message_layer));
    this.q = findViewById(ty.tip_layer);
    this.d = findViewById(ty.step_view);
    this.b = ((ViewGroup)findViewById(ty.ad_container));
    this.m.a(this, (AdEventLayout)findViewById(ty.ad_event_layout));
    this.e = ((ViewGroup)findViewById(ty.unlock_layer));
    this.n = ((TextView)findViewById(ty.tip_percent));
    this.o = ((BubblesView)findViewById(ty.bubbles));
    this.y = ((DigitalClock)findViewById(ty.time_label));
    this.c = findViewById(ty.unlock_label);
    this.p = ((TextView)findViewById(ty.tip_message));
    this.r = findViewById(ty.charging_setting);
    this.h = findViewById(ty.setting_menu);
    this.s = findViewById(ty.menu_item_setting);
    this.t = ((FlashTextView)findViewById(ty.tip_unlock));
    Typeface localTypeface = Typeface.create("sans-serif-light", 0);
    if (localTypeface != null)
    {
      this.n.setTypeface(localTypeface);
      this.y.setTypeface(localTypeface);
      this.p.setTypeface(localTypeface);
    }
    this.k = false;
    this.r.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.E.isFinished())
      return super.onInterceptTouchEvent(paramMotionEvent);
    this.D.addMovement(paramMotionEvent);
    this.F.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return super.onInterceptTouchEvent(paramMotionEvent);
    case 1:
    case 3:
    }
    int i1;
    if (this.x == 1)
      if (this.E.isFinished())
      {
        if (paramMotionEvent.getY() <= getHeight() / 2)
          break label149;
        i1 = this.J;
        label108: this.E.startScroll(0, this.m.getScrollY(), 0, i1 - this.m.getScrollY(), (int)(this.B * 1000.0F));
      }
    while (true)
    {
      invalidate();
      break;
      label149: i1 = this.I;
      break label108;
      if ((this.x == 0) && (this.E.isFinished()))
        this.E.startScroll((int)this.e.getTranslationX(), 0, -(int)this.e.getTranslationX(), 0, (int)(this.C * 1000.0F));
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f2;
    float f3;
    if ((this.I == 0) && (this.J == 0))
    {
      f2 = getHeight() - this.c.getHeight();
      f3 = a;
      if (!this.i)
        break label127;
      f1 = 0.33F;
      this.I = (-(int)(f2 - f1 * f3));
      f2 = getHeight() - this.c.getHeight();
      f3 = a;
      if (this.g.getVisibility() != 0)
        break label135;
    }
    label135: for (float f1 = 0.9F; ; f1 = 1.0F)
    {
      this.J = (-(int)(f2 - f1 * f3));
      e();
      return;
      label127: f1 = 0.4F;
      break;
    }
  }

  public void setDelegate(uv paramuv)
  {
    this.w = paramuv;
  }

  public void setMessageLayerVisibility(int paramInt)
  {
    this.g.setVisibility(paramInt);
  }

  public void setModel(Battery paramBattery)
  {
    if (this.l == paramBattery.f);
    while (true)
    {
      return;
      h();
      this.l = paramBattery.f;
      switch (paramBattery.f)
      {
      default:
      case 3:
      case 2:
      case 1:
      case 0:
      case -1:
      }
      while ((paramBattery.a()) && (this.j != null))
      {
        g();
        return;
        findViewById(ty.step1).setAlpha(1.0F);
        findViewById(ty.model_divider_1).setAlpha(1.0F);
        findViewById(ty.step2).setAlpha(1.0F);
        findViewById(ty.model_divider_2).setAlpha(1.0F);
        findViewById(ty.step3).setAlpha(1.0F);
        this.j = null;
        continue;
        findViewById(ty.step1).setAlpha(1.0F);
        findViewById(ty.model_divider_1).setAlpha(1.0F);
        findViewById(ty.step2).setAlpha(1.0F);
        findViewById(ty.model_divider_2).setAlpha(1.0F);
        findViewById(ty.step3).setAlpha(1.0F);
        this.j = findViewById(ty.step3);
        this.j.setAlpha(0.5F);
        continue;
        findViewById(ty.step1).setAlpha(1.0F);
        findViewById(ty.model_divider_1).setAlpha(1.0F);
        this.j = findViewById(ty.step2);
        this.j.setAlpha(0.5F);
        findViewById(ty.model_divider_2).setAlpha(0.3F);
        findViewById(ty.step3).setAlpha(0.3F);
        continue;
        this.j = findViewById(ty.step1);
        this.j.setAlpha(0.5F);
        findViewById(ty.model_divider_1).setAlpha(0.3F);
        findViewById(ty.step2).setAlpha(0.3F);
        findViewById(ty.model_divider_2).setAlpha(0.3F);
        findViewById(ty.step3).setAlpha(0.3F);
        continue;
        findViewById(ty.step1).setAlpha(0.3F);
        findViewById(ty.model_divider_1).setAlpha(0.3F);
        findViewById(ty.step2).setAlpha(0.3F);
        findViewById(ty.model_divider_2).setAlpha(0.3F);
        findViewById(ty.step3).setAlpha(0.3F);
      }
    }
  }

  public void setNeedBoost(boolean paramBoolean)
  {
    this.i = paramBoolean;
    requestLayout();
  }

  public void setOnMenuItemClickLisener(uw paramuw)
  {
    this.R = paramuw;
  }

  public void setPercent(int paramInt)
  {
    String str = paramInt + "%";
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new RelativeSizeSpan(0.4F), str.length() - 1, str.length(), 17);
    localSpannableString.setSpan(new StyleSpan(2), str.length() - 1, str.length(), 17);
    this.n.setText(localSpannableString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uu
 * JD-Core Version:    0.6.2
 */