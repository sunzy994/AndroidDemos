package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.lazyswipe.features.weather.bean.AirQuality;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import com.lazyswipe.features.weather.bean.WeatherForecast;
import com.lazyswipe.features.weather.detail.WeatherPopupView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class akx extends ScrollView
  implements alg, OnClickListener
{
  protected static final String a = "Swipe." + akx.class.getSimpleName();
  private TextView A;
  private View B;
  private TextView C;
  private TextView D;
  private final String E;
  private final String F;
  private final String G;
  private final String H;
  private aks I;
  private WeatherForecast J;
  private boolean K;
  private boolean L = true;
  private Runnable M;
  private final List<Integer> N = new ArrayList();
  private ArrayList<ala> O;
  private WeatherPopupView P;
  private boolean Q = false;
  private final int R;
  private final azt S = new azt()
  {
    public CharSequence a(int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 2)
        return null;
      Object localObject1 = akd.c(akx.this.b);
      Object localObject2 = akd.b(akx.this.b);
      if (((Date)localObject1).after((Date)localObject2));
      while (true)
      {
        localObject2 = "HH:mm";
        if (((Date)localObject1).getDate() != new Date().getDate())
          localObject2 = "MM-dd HH:mm";
        return akx.this.b.getString(2131231206, new Object[] { new SimpleDateFormat((String)localObject2).format((Date)localObject1) });
        localObject1 = localObject2;
      }
    }
  };
  private final boolean T;
  private final Runnable U = new Runnable()
  {
    public void run()
    {
      akx.f(akx.this).a(akx.this.getScrollY(), akx.this);
      akx.this.e();
    }
  };
  private final ViewTreeObserver.OnScrollChangedListener V = new ViewTreeObserver.OnScrollChangedListener()
  {
    public void onScrollChanged()
    {
      if (akx.g(akx.this))
      {
        akx.this.i.removeCallbacks(akx.h(akx.this));
        akx.this.i.postDelayed(akx.h(akx.this), 100L);
      }
    }
  };
  public final Context b;
  public boolean c = false;
  public atq d;
  public ViewGroup e = null;
  public View f = null;
  public View g = null;
  public View h = null;
  public final Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      }
      do
      {
        return;
        paramAnonymousMessage = (atv)paramAnonymousMessage.obj;
      }
      while (paramAnonymousMessage == null);
      if (paramAnonymousMessage.a().equals(paramAnonymousMessage.f().getTag()))
      {
        akx.a(akx.this, (ImageView)paramAnonymousMessage.f(), paramAnonymousMessage.e);
        return;
      }
      atw.a(paramAnonymousMessage.e);
    }
  };
  private final Calendar j = Calendar.getInstance();
  private final int k = this.j.get(6);
  private City l;
  private View m;
  private TextView n;
  private TextView o;
  private TextView p;
  private ImageView q;
  private TextView r;
  private akz s;
  private View t;
  private LinearLayout u;
  private LinearLayout v;
  private boolean w;
  private View x;
  private TextView y;
  private TextView z;

  public akx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.E = paramContext.getString(2131230896);
    this.F = paramContext.getString(2131230894);
    this.G = paramContext.getString(2131230895);
    this.H = paramContext.getString(2131230893);
    this.b = paramContext;
    this.K = vs.Q(paramContext);
    this.R = asq.a(32.0F);
    this.T = abd.a(getContext(), 11);
  }

  private CharSequence a(akw paramakw, int paramInt)
  {
    this.j.setTime(paramakw.a());
    paramInt = this.j.get(6) - this.k;
    if (paramInt == -1)
      return DateFormat.format(this.E, this.j);
    if (paramInt == 0)
      return DateFormat.format(this.F, this.j);
    if (paramInt == 1)
      return DateFormat.format(this.G, this.j);
    return DateFormat.format(this.H, this.j);
  }

  private void a(aks paramaks)
  {
    this.x.setVisibility(0);
    if (paramaks == null)
    {
      findViewById(2131755562).setVisibility(8);
      this.B.setVisibility(8);
    }
    while (true)
    {
      if ((this.c) && (this.f != null))
      {
        if (!this.T)
          break;
        f();
        this.f.setVisibility(0);
      }
      return;
      label97: int i1;
      if ((TextUtils.isEmpty(paramaks.f)) || (TextUtils.isEmpty(paramaks.g)))
      {
        findViewById(2131755562).setVisibility(8);
        if ((TextUtils.isEmpty(paramaks.i)) || (TextUtils.isEmpty(paramaks.h)))
          break label389;
        i1 = getResources().getIdentifier("clockweather_wind_" + paramaks.i.toLowerCase(), "string", "com.lazyswipe");
        if (i1 <= 0)
          break label377;
        this.B.setVisibility(0);
        this.C.setText(i1);
        this.D.setText(String.format("%s%s", new Object[] { paramaks.h, paramaks.j }));
      }
      while (true)
      {
        i1 = paramaks.k + 10;
        int i2 = getResources().getIdentifier("clockweather_uv_" + i1, "string", "com.lazyswipe");
        if (i2 <= 0)
          break label401;
        this.A.setText(i2);
        getResources().getIdentifier("clockweather_uv_desc_" + i1, "string", "com.lazyswipe");
        break;
        findViewById(2131755562).setVisibility(0);
        this.z.setText(String.format("%s%%", new Object[] { paramaks.g }));
        this.y.setText(String.format("%s%s", new Object[] { paramaks.c(this.b), getContext().getString(2131231202) }));
        break label97;
        label377: this.B.setVisibility(8);
        continue;
        label389: this.B.setVisibility(8);
      }
      label401: this.A.setText(2131230823);
    }
    this.f.setVisibility(8);
  }

  private void a(final View paramView, float paramFloat1, float paramFloat2, int paramInt, final Runnable paramRunnable)
  {
    paramView.animate().cancel();
    if (paramInt <= 0)
    {
      paramView.setAlpha(paramFloat2);
      if (paramRunnable != null)
        paramView.post(paramRunnable);
      return;
    }
    paramView.setAlpha(paramFloat1);
    if (paramRunnable == null)
    {
      paramView.animate().setDuration(paramInt).alpha(paramFloat2);
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.animate().setDuration(paramInt).alpha(paramFloat2).setListener(new AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramView.post(paramRunnable);
          paramView.animate().setListener(null);
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      return;
    }
    paramView.animate().setDuration(paramInt).alpha(paramFloat2).withEndAction(paramRunnable);
  }

  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramImageView.getScaleType() != ScaleType.FIT_XY)
      paramImageView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
    paramImageView.setScaleType(ScaleType.CENTER_CROP);
    paramImageView.setImageBitmap(paramBitmap);
  }

  private void a(AirQuality paramAirQuality)
  {
    if (paramAirQuality == null)
    {
      this.r.setText("");
      this.r.setVisibility(8);
      this.o.setText(this.o.getText());
    }
    do
    {
      return;
      this.r.setVisibility(0);
      String str2 = paramAirQuality.a(getContext());
      String str1 = str2;
      if (!str2.contains(getResources().getString(2131231180)))
        str1 = getResources().getString(2131231179) + str2;
      this.r.setText(str1);
      this.r.setTextColor(-13421773);
    }
    while (this.r.getBackground() == null);
    if (!TextUtils.isEmpty(paramAirQuality.a()));
    while (true)
    {
      try
      {
        i1 = Integer.decode(paramAirQuality.a()).intValue();
        if (i1 != 0)
        {
          this.r.setTextColor(paramAirQuality.b());
          this.r.getBackground().setColorFilter(i1 | 0xFF000000, PorterDuff.Mode.SRC_IN);
          this.r.invalidate();
          return;
        }
      }
      catch (Exception localException)
      {
        i1 = 0;
        continue;
        this.r.getBackground().setColorFilter(null);
        continue;
      }
      int i1 = 0;
    }
  }

  private Animation b(int paramInt)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.25F, 1, 0.0F);
    ((Animation)localObject).setDuration(222L);
    ((Animation)localObject).setStartOffset(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(222L);
    ((Animation)localObject).setStartOffset(paramInt);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }

  private void c()
  {
    this.s = ((akz)findViewById(2131755556));
    this.n = ((TextView)findViewById(2131755552));
    this.o = ((TextView)findViewById(2131755355));
    this.p = ((TextView)findViewById(2131755549));
    this.q = ((ImageView)findViewById(2131755551));
    this.r = ((TextView)findViewById(2131755354));
    this.t = findViewById(2131755553);
    this.u = ((LinearLayout)findViewById(2131755554));
    this.v = ((LinearLayout)findViewById(2131755555));
    this.m = findViewById(2131755548);
    this.x = findViewById(2131755557);
    this.z = ((TextView)findViewById(2131755564));
    this.y = ((TextView)findViewById(2131755563));
    this.B = findViewById(2131755566);
    this.C = ((TextView)findViewById(2131755568));
    this.D = ((TextView)findViewById(2131755569));
    this.A = ((TextView)findViewById(2131755565));
    this.u.setLayoutAnimation(new LayoutAnimationController(b(0), 0.25F));
    this.v.setLayoutAnimation(new LayoutAnimationController(b(27), 0.25F));
    Typeface localTypeface = Typeface.createFromAsset(getContext().getAssets(), akc.a());
    if (localTypeface != null)
      this.p.setTypeface(localTypeface);
    this.m.setOnClickListener(this);
    this.p.setOnClickListener(this);
    findViewById(2131755550).setOnClickListener(this);
    setOnClickListener(this);
    if (aqs.d())
      this.r.getLayoutParams().height = asq.a(23.0F);
  }

  private void h()
  {
    this.u.setVisibility(4);
    this.v.setVisibility(4);
    this.s.setVisibility(4);
    this.t.postDelayed(new Runnable()
    {
      public void run()
      {
        akx.a(akx.this).setVisibility(0);
        akx.a(akx.this).scheduleLayoutAnimation();
        akx.b(akx.this).setVisibility(0);
        akx.b(akx.this).scheduleLayoutAnimation();
        akx.c(akx.this).setVisibility(0);
      }
    }
    , 416L);
  }

  private void i()
  {
    if ((this.J == null) && (this.I == null))
    {
      setNodataInfo(true);
      return;
    }
    Object localObject1 = new Date();
    Object localObject4 = this.b.getResources();
    int i1;
    Object localObject3;
    Object localObject2;
    if (this.I != null)
    {
      i1 = this.I.d;
      localObject3 = this.I.a(this.b);
      localObject2 = this.I.b(this.b);
      localObject1 = this.I.c();
    }
    while (true)
    {
      if (i1 == -1)
      {
        setNodataInfo(true);
        return;
        localObject1 = akc.a(this.J, (Date)localObject1, 0);
        if (localObject1 == null)
          break label989;
        localObject2 = ((akw)localObject1).e(this.b);
        i1 = ((akw)localObject1).e();
        localObject3 = akc.a(this.b, i1);
        localObject1 = null;
        continue;
      }
      this.n.setVisibility(8);
      this.t.setVisibility(0);
      this.o.setVisibility(0);
      this.o.setText((CharSequence)localObject3);
      label217: Object localObject5;
      label291: int i2;
      int i3;
      int i4;
      int i5;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
        if (((String)localObject2).charAt(0) == '-')
        {
          this.p.setPadding(0, 0, 0, 0);
          localObject2 = (String)localObject2 + ((Resources)localObject4).getString(2131231202);
          this.p.setText((CharSequence)localObject2);
          this.p.setVisibility(0);
          this.q.setImageResource(akc.a(this.b, i1, akc.a(new Date())).intValue());
          a((AirQuality)localObject1);
          a(this.I);
          if (this.J == null)
            break;
          localObject5 = akc.a(this.J, this.J.a());
          if (localObject5 == null)
            break;
          i2 = Math.min(6, ((List)localObject5).size());
          this.O = new ArrayList(i2);
          this.u.removeAllViews();
          this.v.removeAllViews();
          i3 = aqs.ac();
          i4 = ((Resources)localObject4).getDimensionPixelSize(2131296312);
          i5 = ((Resources)localObject4).getDimensionPixelSize(2131296312);
          this.M = new Runnable()
          {
            public void run()
            {
              if (!akx.d(akx.this))
              {
                akx.a(akx.this, true);
                return;
              }
              akx.e(akx.this);
            }
          };
          i1 = 0;
          label414: if (i1 >= i2)
            break label831;
          localObject4 = (akw)((List)localObject5).get(i1);
        }
      try
      {
        localObject2 = ((akw)localObject4).a(this.b);
        localObject1 = ((akw)localObject4).b(this.b);
        boolean bool;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool)
          {
            label477: i1 += 1;
            break label414;
            localObject3 = new Rect();
            localObject5 = this.p.getPaint();
            Typeface localTypeface = Typeface.createFromAsset(getContext().getAssets(), akc.a());
            if (localTypeface != null)
              ((TextPaint)localObject5).setTypeface(localTypeface);
            ((TextPaint)localObject5).getTextBounds(((Resources)localObject4).getString(2131231202), 0, 1, (Rect)localObject3);
            this.p.setPadding(((Rect)localObject3).width(), 0, 0, 0);
            break label217;
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            break label291;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        label831: label983: label986: 
        while (true)
        {
          label612: int i6 = Integer.parseInt((String)localObject2);
          int i7 = Integer.parseInt((String)localObject1);
          localObject1 = ((akw)localObject4).c(this.b);
          localObject2 = ((akw)localObject4).d(this.b);
          if (!((akw)localObject4).b());
          for (bool = true; ; bool = false)
          {
            localObject1 = new ala(i6, i7, (String)localObject1, (String)localObject2, bool);
            localObject2 = new TextView(this.b);
            ((TextView)localObject2).setTextColor(-1);
            ((TextView)localObject2).setTextSize(1, 13.0F);
            ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setLineSpacing(0.0F, 1.2F);
            ((TextView)localObject2).setText(a((akw)localObject4, i1));
            localObject3 = akr.a(this.b, ((akw)localObject4).c(), false, i3 - i4 - i5, i2);
            this.v.addView((View)localObject3);
            this.O.add(localObject1);
            this.u.addView((View)localObject2);
            break;
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool)
              break label986;
            localObject1 = localObject2;
            break label612;
          }
          if (this.v.getChildCount() > 0)
            k();
          float f3;
          float f2;
          if (Math.max(Math.max(this.O.size(), this.u.getChildCount()), this.v.getChildCount()) > 0)
          {
            localObject1 = this.O.iterator();
            float f1 = -2.147484E+09F;
            f3 = 2.147484E+09F;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ala)((Iterator)localObject1).next();
              f2 = f3;
              if (((ala)localObject2).b < f3)
                f2 = ((ala)localObject2).b;
              if (((ala)localObject2).a <= f1)
                break label983;
              f1 = ((ala)localObject2).a;
            }
          }
          while (true)
          {
            f3 = f2;
            break;
            this.s.setData(this.O);
            h();
            a(this.m, 0.0F, 1.0F, 1200, null);
            return;
          }
        }
        label989: localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        i1 = -1;
      }
      catch (Exception localException)
      {
        break label477;
      }
    }
  }

  private void j()
  {
    try
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    int i2;
    Object localObject;
    if (this.K)
    {
      i2 = this.v.getChildCount();
      this.N.clear();
      i1 = 0;
      while (i1 < i2)
      {
        this.N.add(Integer.valueOf(i1));
        i1 += 1;
      }
      localObject = this.N.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i1 = ((Integer)((Iterator)localObject).next()).intValue();
        View localView = this.v.getChildAt(i1);
        if ((localView == null) || (!(localView instanceof akr)))
          ((Iterator)localObject).remove();
      }
      if (this.N.size() > 0);
    }
    else
    {
      return;
    }
    boolean bool;
    if (this.N.size() < 3)
    {
      bool = true;
      label144: this.L = bool;
      localObject = new Random(System.currentTimeMillis());
      i1 = ((Random)localObject).nextInt(this.N.size());
      i2 = ((Integer)this.N.remove(i1)).intValue();
      if (this.N.size() <= 0)
        break label353;
    }
    label353: for (int i1 = ((Integer)this.N.get(((Random)localObject).nextInt(this.N.size()))).intValue(); ; i1 = -1)
    {
      if (!((akr)this.v.getChildAt(i2)).b())
        ((akr)this.v.getChildAt(i2)).setStartDelay(1000);
      ((akr)this.v.getChildAt(i2)).setCallback(this.M);
      if (i1 == -1)
        break;
      if (!((akr)this.v.getChildAt(i1)).b())
        ((akr)this.v.getChildAt(i1)).setStartDelay(1000);
      ((akr)this.v.getChildAt(i1)).setCallback(this.M);
      return;
      bool = false;
      break label144;
    }
  }

  private void l()
  {
    this.e = ((ViewGroup)findViewById(2131755561));
    this.g = findViewById(2131755149);
    this.h = findViewById(2131755151);
    this.f = findViewById(2131755558);
    ((ProgressBar)this.g.findViewById(2131755150)).setIndeterminateDrawable(new tn(getContext()));
    ((TextView)findViewById(2131755559)).setText(2131230736);
    ((TextView)findViewById(2131755560)).setText(2131231217);
    this.f.setVisibility(0);
    a(0);
    this.h.setOnClickListener(this);
  }

  private void m()
  {
    if (this.P != null)
      this.P.e();
  }

  private void setNodataInfo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.n.setVisibility(0);
      this.n.setText(String.format("%s\n%s", new Object[] { this.b.getString(2131230808), this.b.getString(2131231177) }));
      a(null);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      this.x.setVisibility(8);
      this.t.setVisibility(8);
      this.o.setVisibility(8);
    }
  }

  public void a()
  {
    if (!arl.i(this.b))
    {
      m();
      aso.a(this.b, 2131230800);
      return;
    }
    ake localake = this.P.getWeatherServiceClient();
    if ((localake != null) && (localake.f()))
    {
      localake.l();
      this.w = true;
      return;
    }
    m();
    aso.a(this.b, 2131230809);
  }

  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = aqs.ac();
      this.e.getLayoutParams().height = ((int)(paramInt * 416.0F / 796.0F));
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.e.getLayoutParams().height = -2;
        return;
      }
    }
    while (paramInt != 2);
    this.e.getLayoutParams().height = this.e.getHeight();
  }

  public void a(WeatherCondition paramWeatherCondition)
  {
    WeatherForecast localWeatherForecast = null;
    if (paramWeatherCondition != null)
      localWeatherForecast = paramWeatherCondition.a(this.b, true);
    if (localWeatherForecast != null)
    {
      List localList = akc.a(localWeatherForecast, localWeatherForecast.a());
      if ((localList != null) && (localList.size() != 0))
      {
        this.I = paramWeatherCondition.e();
        this.J = localWeatherForecast;
      }
    }
    i();
    if (this.w)
    {
      this.w = false;
      m();
    }
  }

  public void b()
  {
    this.Q = true;
    j();
    if ((this.O != null) && (this.O.size() > 0))
      this.P.a(((ala)this.O.get(0)).a, ((ala)this.O.get(0)).b, ((ala)this.O.get(this.O.size() - 1)).a, ((ala)this.O.get(this.O.size() - 1)).b, this);
  }

  public void d()
  {
    this.Q = false;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
  }

  public void g()
  {
  }

  public akz getChart()
  {
    return this.s;
  }

  public City getCity()
  {
    return this.l;
  }

  public azt getPTRTextGetter()
  {
    return this.S;
  }

  public String getTitle()
  {
    if (this.l == null)
      return "";
    return this.l.a();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.m);
    while (paramView != this.h)
      return;
    f();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c();
    if (this.T)
      l();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.s instanceof aky)) && (findViewById(2131755547).getMeasuredHeight() != paramInt4 - paramInt2 - this.R))
    {
      findViewById(2131755547).measure(MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
      findViewById(2131755547).getLayoutParams().height = (paramInt4 - paramInt2 - this.R);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (((this.s instanceof aky)) && (findViewById(2131755547).getLayoutParams().height == 0))
      if (MeasureSpec.getMode(paramInt2) != 1073741824)
        break label67;
    label67: for (int i1 = MeasureSpec.getSize(paramInt2); ; i1 = aqs.ad())
    {
      findViewById(2131755547).getLayoutParams().height = (i1 - this.R);
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.V != null) && (this.Q))
      this.V.onScrollChanged();
  }

  public void setBitmapLoader(atq paramatq)
  {
    this.d = paramatq;
  }

  public void setCity(City paramCity)
  {
    this.l = paramCity;
  }

  public void setRefreshing(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i1 = 0;
      while (i1 < 6)
      {
        this.u.setVisibility(4);
        ImageView localImageView = (ImageView)this.v.getChildAt(i1);
        if (localImageView != null)
          localImageView.setImageResource(2130837575);
        i1 += 1;
      }
    }
  }

  public void setWeatherPopupView(WeatherPopupView paramWeatherPopupView)
  {
    this.P = paramWeatherPopupView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akx
 * JD-Core Version:    0.6.2
 */