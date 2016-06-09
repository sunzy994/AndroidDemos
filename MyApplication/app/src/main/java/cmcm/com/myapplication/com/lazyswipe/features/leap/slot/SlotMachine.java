package cmcm.com.myapplication.com.lazyswipe.features.leap.slot;

import abe;
import afc;
import afd;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqs;
import aqt;
import aqw;
import ari;
import aso;
import asq;
import atk;
import atm;
import atw;
import avz;
import com.lazyswipe.ui.EmptyActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tj;
import tk;
import vj;
import vs;
import yb;
import ye;

public class SlotMachine extends FrameLayout
  implements OnClickListener, OnTouchListener, atm
{
  static final String a = "Swipe." + SlotMachine.class.getSimpleName();
  private static boolean s;
  private int A;
  private int B;
  private int C;
  private boolean D;
  private int E;
  private int F;
  private final Rect G = new Rect();
  private final afc[] H = new afc[9];
  private final afc[] I = new afc[9];
  private boolean J = true;
  private final Runnable K = new Runnable()
  {
    public void run()
    {
      int i = 0;
      if (i < 9)
      {
        if (SlotMachine.e(SlotMachine.this));
        for (int j = i; ; j = 9 - i)
        {
          j *= 200;
          SlotMachine.f(SlotMachine.this)[i].a(j);
          SlotMachine.g(SlotMachine.this)[i].a(j);
          i += 1;
          break;
        }
      }
      SlotMachine localSlotMachine = SlotMachine.this;
      if (!SlotMachine.e(SlotMachine.this));
      for (boolean bool = true; ; bool = false)
      {
        SlotMachine.c(localSlotMachine, bool);
        SlotMachine.h(SlotMachine.this).removeCallbacks(this);
        SlotMachine.h(SlotMachine.this).postDelayed(this, 2000L);
        return;
      }
    }
  };
  private final Map<String, Bitmap> L = new HashMap(26);
  private boolean M;
  private final atk N = new afd(this, true);
  boolean b;
  private ViewGroup c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private TextView i;
  private TextView j;
  private SlotRoller k;
  private SlotRoller l;
  private SlotRoller m;
  private SlotResultArea n;
  private boolean o;
  private ViewGroup p;
  private WeakReference<View> q;
  private tj r;
  private final Handler t = new Handler();
  private int u;
  private int v;
  private float w;
  private int x;
  private boolean y;
  private float z;

  public SlotMachine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static int a(Context paramContext)
  {
    paramContext = vs.a(paramContext, "cccc", "");
    if (TextUtils.isEmpty(paramContext))
      return 100;
    try
    {
      int i1 = Integer.parseInt(aqw.a(paramContext, aqw.a()));
      return i1;
    }
    catch (Exception paramContext)
    {
    }
    return 100;
  }

  public static SlotMachine a(ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup.getContext();
    if (vj.g)
      EmptyActivity.a((Context)localObject, 1);
    for (s = true; ; s = false)
    {
      View localView = new View((Context)localObject);
      localView.setBackgroundColor(-2013265920);
      localView.setClickable(true);
      paramViewGroup.addView(localView, new LayoutParams(-1, -1));
      localObject = (SlotMachine)LayoutInflater.from((Context)localObject).inflate(2130968743, null);
      LayoutParams localLayoutParams = new LayoutParams(((SlotMachine)localObject).u, ((SlotMachine)localObject).v);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = paramViewGroup.getResources().getDimensionPixelOffset(2131296391);
      paramViewGroup.addView((View)localObject, localLayoutParams);
      ((SlotMachine)localObject).p = paramViewGroup;
      ((SlotMachine)localObject).q = new WeakReference(localView);
      return localObject;
    }
  }

  private void a(int paramInt)
  {
    this.j.setText(String.valueOf(a(getContext())));
    this.i.clearAnimation();
    if (paramInt == 0)
    {
      this.i.setText("");
      return;
    }
    int i1 = Math.abs(paramInt);
    TextView localTextView = this.i;
    Object localObject;
    if (paramInt > 0)
    {
      localObject = "+" + i1;
      localTextView.setText((CharSequence)localObject);
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(250L);
      if (paramInt <= 0)
        break label158;
    }
    label158: for (paramInt = -1; ; paramInt = 3)
    {
      ((AlphaAnimation)localObject).setRepeatCount(paramInt);
      ((AlphaAnimation)localObject).setRepeatMode(2);
      ((AlphaAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      this.i.startAnimation((Animation)localObject);
      return;
      localObject = "-" + i1;
      break;
    }
  }

  private void a(int paramInt, String paramString)
  {
    ((ImageView)findViewById(paramInt)).setImageBitmap(a(paramString));
  }

  private void a(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = "slot_screen_slots";
      this.d.setImageBitmap(a((String)localObject));
      this.d.clearAnimation();
      localObject = new AlphaAnimation(0.0F, 1.0F);
      if (!paramBoolean)
        break label101;
    }
    label101: for (long l1 = 220L; ; l1 = 550L)
    {
      ((AlphaAnimation)localObject).setDuration(l1);
      ((AlphaAnimation)localObject).setRepeatCount(-1);
      ((AlphaAnimation)localObject).setRepeatMode(2);
      ((AlphaAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      this.d.startAnimation((Animation)localObject);
      return;
      if (this.D)
      {
        localObject = "slot_screen_win";
        break;
      }
      localObject = "slot_screen_gold";
      break;
    }
  }

  private File b(String paramString)
  {
    return new File(this.N.b(), paramString + ".png");
  }

  private void b(int paramInt)
  {
    try
    {
      String str = aqw.b(String.valueOf(paramInt), aqw.a());
      vs.b(getContext(), "cccc", str);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void b(final boolean paramBoolean)
  {
    this.h.setVisibility(8);
    this.D = false;
    this.E = 0;
    final boolean bool = v();
    ValueAnimator localValueAnimator;
    if (bool)
    {
      this.o = true;
      u();
      a(-10);
      a(false);
      if (this.z != 0.0F)
        break label149;
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 120.0F }).setDuration(450L);
      localValueAnimator.setInterpolator(new CycleInterpolator(0.5F));
    }
    while (true)
    {
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          SlotMachine.a(SlotMachine.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          SlotMachine.a(SlotMachine.this);
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (bool)
            SlotMachine.b(SlotMachine.this, paramBoolean);
        }
      });
      localValueAnimator.start();
      return;
      this.n.c();
      r();
      a(0);
      this.o = false;
      break;
      label149: localValueAnimator = ValueAnimator.ofFloat(new float[] { this.z, 0.0F }).setDuration(250L);
      localValueAnimator.setInterpolator(new DecelerateInterpolator(0.5F));
    }
  }

  private void c(boolean paramBoolean)
  {
    q();
    this.k.a(this.A, 0);
    this.l.a(this.B, ari.c(770, 830));
    this.m.a(this.C, ari.c(1570, 1630));
    this.F = 3;
    if (this.D)
    {
      y();
      return;
    }
    d(paramBoolean);
  }

  private void d(boolean paramBoolean)
  {
    this.n.a(paramBoolean);
  }

  private void m()
  {
    int i1 = aqs.ae();
    int i2 = getResources().getDimensionPixelOffset(2131296391);
    int i3 = aqs.af();
    float f1 = ari.b(i1 / this.u, (i3 - i2) / this.v);
    if ((f1 > 0.0F) && (f1 < 1.0F))
    {
      setPivotX(this.u / 2);
      setPivotY(0.0F);
      setScaleX(f1);
      setScaleY(f1);
    }
  }

  private void n()
  {
    this.g.setRotationX(this.z);
    float f1 = ari.a(this.z);
    int i1 = this.f.getMeasuredHeight() / 2;
    int i2 = (int)(this.g.getMeasuredHeight() * (1.0D - Math.cos(f1)));
    if (this.z <= 90.0F);
    for (f1 = ari.a(0.0F, 0.0F, 90.0F, i1, this.z); ; f1 = ari.a(90.0F, i1, 180.0F, 0.0F, this.z))
    {
      this.f.setTranslationY((int)(f1 + i2));
      return;
    }
  }

  private void o()
  {
    this.c.animate().translationY(0.0F).setDuration(600L).setInterpolator(new ye()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SlotMachine.a(SlotMachine.this, true);
      }
    });
  }

  private void p()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.e.startAnimation(localAlphaAnimation);
  }

  private void q()
  {
    int i1 = ari.c(1, 1000);
    if ((1 <= i1) && (i1 <= 50))
    {
      this.C = 5;
      this.B = 5;
      this.A = 5;
      this.D = true;
      this.E = 70;
    }
    while (true)
    {
      int i2 = vs.a(getContext(), "slot_play_times", 0);
      vs.b(getContext(), "slot_play_times", i2 + 1);
      if (this.D)
      {
        i2 = vs.a(getContext(), "slot_win_times", 0);
        vs.b(getContext(), "slot_win_times", i2 + 1);
      }
      Log.i(a, "retrieveResult(). mIsWin = " + this.D + ", mWinCoin = " + this.E + ", random = " + i1);
      return;
      if ((51 <= i1) && (i1 <= 75))
      {
        this.C = 4;
        this.B = 4;
        this.A = 4;
        this.D = true;
        this.E = 100;
      }
      else if ((76 <= i1) && (i1 <= 95))
      {
        this.C = 2;
        this.B = 2;
        this.A = 2;
        this.D = true;
        this.E = 120;
      }
      else if ((96 <= i1) && (i1 <= 105))
      {
        this.C = 3;
        this.B = 3;
        this.A = 3;
        this.D = true;
        this.E = 160;
      }
      else if ((106 <= i1) && (i1 <= 110))
      {
        this.C = 7;
        this.B = 7;
        this.A = 7;
        this.D = true;
        this.E = 200;
      }
      else if ((111 <= i1) && (i1 <= 112))
      {
        this.C = 1;
        this.B = 1;
        this.A = 1;
        this.D = true;
        this.E = 500;
      }
      else if (i1 == 113)
      {
        this.C = 6;
        this.B = 6;
        this.A = 6;
        this.D = true;
        this.E = 1000;
      }
      else
      {
        do
        {
          this.A = ari.c(1, 8);
          this.B = ari.c(1, 8);
          this.C = ari.c(1, 8);
        }
        while ((this.A == this.B) && (this.A == this.C));
        this.D = false;
        this.E = 0;
      }
    }
  }

  private void r()
  {
    if (this.D)
    {
      a(this.E);
      this.h.setAlpha(0.0F);
      this.h.setVisibility(0);
      this.h.animate().alpha(1.0F).setDuration(350L).setInterpolator(new AccelerateInterpolator());
    }
    this.n.a();
  }

  private void s()
  {
    int i1 = 0;
    while (i1 < 9)
    {
      this.H[i1] = new afc(getContext(), this, this.c, true, i1);
      this.I[i1] = new afc(getContext(), this, this.c, false, i1);
      i1 += 1;
    }
  }

  private void t()
  {
    this.t.removeCallbacks(this.K);
    this.t.post(this.K);
  }

  private void u()
  {
    b(Math.max(0, a(getContext()) - 10));
    vs.b(getContext(), "last_play_slot_time", System.currentTimeMillis());
  }

  private boolean v()
  {
    return a(getContext()) >= 10;
  }

  private void w()
  {
    b(a(getContext()) + this.E);
  }

  private void x()
  {
    long l1 = vs.a(getContext(), "last_play_slot_time", 0L);
    if ((a(getContext()) < 100) && (System.currentTimeMillis() - l1 > 3600000L))
      b(100);
  }

  private void y()
  {
    w();
    this.n.a(this.E);
    new Thread(new Runnable()
    {
      public void run()
      {
        asq.a(4000L);
        SlotMachine.this.i();
      }
    }).start();
  }

  public Bitmap a(String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.L.get(paramString);
    if (atw.b(localBitmap))
      return localBitmap;
    try
    {
      localBitmap = this.N.a(paramString);
      this.L.put(paramString, localBitmap);
      return localBitmap;
    }
    catch (Exception paramString)
    {
    }
    return null;
  }

  public void a(File paramFile)
  {
  }

  public boolean a()
  {
    b();
    return true;
  }

  public void b()
  {
    try
    {
      this.p.removeView(this);
      this.p.removeView((View)this.q.get());
      this.q.clear();
      this.q = null;
      if (s)
      {
        EmptyActivity.a(getContext());
        s = false;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView == this.n)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.G);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if (paramView == this.n)
      paramCanvas.restore();
    return bool;
  }

  public void h()
  {
    abe.a();
    if (yb.getInstance() != null)
      yb.getInstance().c(false);
    asq.t(getContext());
  }

  void i()
  {
    post(new Runnable()
    {
      public void run()
      {
        SlotMachine.b(SlotMachine.this).a(0);
        SlotMachine.c(SlotMachine.this).a(ari.c(770, 830));
        SlotMachine.d(SlotMachine.this).a(ari.c(1570, 1630));
      }
    });
  }

  void j()
  {
    this.F -= 1;
    if (this.F == 0)
    {
      a(true);
      r();
      this.o = false;
    }
  }

  public void k()
  {
    if (this.M)
      return;
    this.M = true;
    this.N.d();
  }

  void l()
  {
    Iterator localIterator = this.L.values().iterator();
    while (localIterator.hasNext())
      atw.a((Bitmap)localIterator.next());
    this.L.clear();
  }

  public boolean m_()
  {
    return (b("slot_machine").exists()) && (b("slot_handle_ball").exists()) && (b("slot_roller_1").exists()) && (b("slot_screen_slots").exists()) && (b("slot_paper_bottom").exists()) && (b("slot_paper_top").exists());
  }

  public void n_()
  {
    int i1 = 0;
    vs.b(getContext(), "slot_res_loaded", true);
    this.M = false;
    a(2131755479, "slot_machine");
    a(2131755480, "slot_jackpot_light");
    a(2131755481, "slot_screen_slots");
    a(2131755482, "slot_handle_bar");
    a(2131755483, "slot_handle_ball");
    a(2131755486, "slot_win");
    o();
    p();
    t();
    this.b = true;
    this.k.a();
    this.n.d();
    while (i1 < 9)
    {
      this.H[i1].a();
      this.I[i1].a();
      i1 += 1;
    }
  }

  public void o_()
  {
    this.M = false;
    this.b = false;
    aso.a(getContext(), 2131230761);
    b();
  }

  public void onClick(View paramView)
  {
    if ((paramView == this) && (this.h.getVisibility() == 0))
      this.h.setVisibility(8);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aqt.a(this.r);
    this.t.removeCallbacks(this.K);
    this.d.clearAnimation();
    this.e.clearAnimation();
    this.i.clearAnimation();
    l();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((ViewGroup)findViewById(2131755475));
    this.d = ((ImageView)findViewById(2131755481));
    this.e = ((ImageView)findViewById(2131755480));
    this.f = ((ImageView)findViewById(2131755483));
    this.g = ((ImageView)findViewById(2131755482));
    this.f.setOnTouchListener(this);
    this.h = ((ImageView)findViewById(2131755486));
    this.i = ((TextView)findViewById(2131755484));
    this.j = ((TextView)findViewById(2131755485));
    this.n = ((SlotResultArea)findViewById(2131755474));
    this.n.setContainer(this);
    this.k = ((SlotRoller)findViewById(2131755476));
    this.l = ((SlotRoller)findViewById(2131755477));
    this.m = ((SlotRoller)findViewById(2131755478));
    int i1 = ari.c(1, 8);
    this.k.a(i1, this);
    this.l.a(i1, this);
    this.m.a(i1, this);
    Resources localResources = getResources();
    this.u = localResources.getDimensionPixelOffset(2131296394);
    this.v = localResources.getDimensionPixelOffset(2131296390);
    this.x = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    s();
    k();
    this.G.set(0, asq.a(280.0F), this.u, this.v);
    m();
    setOnClickListener(this);
    x();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.u, this.v);
    this.g.setPivotY(this.g.getMeasuredHeight());
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != this.f);
    while (this.o)
      return false;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return true;
      this.y = true;
      this.z = 0.0F;
      this.w = paramMotionEvent.getRawY();
      continue;
      if (paramMotionEvent.getRawY() - this.w > this.x)
      {
        float f1 = paramMotionEvent.getRawY();
        float f2 = this.w;
        float f3 = this.g.getMeasuredHeight() * 2;
        this.z = ari.a(0.0F, 0.0F, f3, 180.0F, ari.a(f1 - f2, 0.0F, f3));
        n();
        continue;
        if (this.y)
          b(false);
        this.y = false;
        continue;
        this.y = false;
      }
    }
  }

  public void p_()
  {
    this.r = new avz(getContext()).a(getResources().getDrawable(2130837771)).a(null).g(2131230736).h(-285212673).b();
  }

  public void q_()
  {
    aqt.a(this.r);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.slot.SlotMachine
 * JD-Core Version:    0.6.2
 */