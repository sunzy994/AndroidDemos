package cmcm.com.myapplication.com.lazyswipe.fan;

import ahw;
import ahx;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import aof;
import apd;
import asq;
import aty;
import aub;
import aug;
import auw;
import vg;
import wk;
import yb;
import yd;
import yf;
import yg;
import yh;
import yj;
import yl;
import yw;

public class FanItem extends auw
  implements OnLongClickListener, aof
{
  public static final String a = null;
  public static final ColorFilter b = new ColorMatrixColorFilter(new float[] { 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  public static final aty g = new aty();
  private static final String h = "Swipe." + FanItem.class.getSimpleName();
  private boolean A = false;
  private final Rect B = new Rect();
  private final Rect C = new Rect();
  private final Point D = new Point();
  private int E;
  private int F;
  private int G;
  private int H;
  private boolean I = false;
  private yh J;
  private Animator K;
  private boolean L;
  private boolean M = false;
  private boolean N = false;
  private boolean O = false;
  public final int c;
  public yl d;
  public yl e;
  public boolean f = false;
  private int i;
  private final Rect j = new Rect();
  private final int k;
  private final int o;
  private final boolean p;
  private Drawable q;
  private Drawable r;
  private final yf s;
  private ColorFilter t;
  private ColorFilter u;
  private boolean v;
  private boolean w;
  private OnLongClickListener x;
  private OnClickListener y;
  private boolean z = false;

  public FanItem(Context paramContext)
  {
    this(paramContext, null);
  }

  public FanItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext.getResources().getDimensionPixelSize(2131296335);
    this.k = getResources().getDimensionPixelSize(2131296336);
    this.o = (this.k >> 1);
    boolean bool1 = bool2;
    if (yb.getInstance() != null)
    {
      bool1 = bool2;
      if (yb.getInstance().n())
        bool1 = true;
    }
    this.p = bool1;
    this.s = getDecor();
    try
    {
      this.E = ViewConfiguration.getLongPressTimeout();
      return;
    }
    catch (Exception paramContext)
    {
      this.E = 500;
    }
  }

  public static float a(float paramFloat)
  {
    return paramFloat;
  }

  private void a(int paramInt)
  {
    if (this.J == null)
      this.J = new yh(this, null);
    postDelayed(this.J, paramInt);
  }

  private void a(int paramInt1, int paramInt2, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (yb.getInstance() == null)
      return;
    int n = yb.getInstance().getCenterOffset();
    boolean bool = yb.getInstance().n();
    int m;
    if (bool)
    {
      m = vg.a;
      paramLayoutParams.gravity = (m | 0x50);
      if (!bool)
        break label87;
      paramLayoutParams.rightMargin = 0;
      paramLayoutParams.leftMargin = (paramInt1 - this.o + n);
    }
    while (true)
    {
      paramLayoutParams.bottomMargin = (paramInt2 - this.o + n);
      return;
      m = vg.b;
      break;
      label87: paramLayoutParams.leftMargin = 0;
      paramLayoutParams.rightMargin = (-paramInt1 - this.o + n);
    }
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    return (Math.abs(paramInt1 - this.F) > this.H) || (Math.abs(paramInt2 - this.G) > this.H);
  }

  public static float b(float paramFloat)
  {
    if (paramFloat < 0.0F)
      return 0.0F;
    if (paramFloat < 0.75D)
      return 1.333F * paramFloat;
    return 1.0F;
  }

  private void c(float paramFloat)
  {
    if ((getLayoutParams() == null) || (this.d == null) || (this.e == null) || (yb.getInstance() == null))
      return;
    a((int)(this.d.a + (this.e.a - this.d.a) * paramFloat), (int)(this.d.b + (this.e.b - this.d.b) * paramFloat), (FrameLayout.LayoutParams)getLayoutParams());
    paramFloat = a(paramFloat);
    setScaleX(paramFloat);
    setScaleY(paramFloat);
  }

  private void d(boolean paramBoolean)
  {
    if (!this.N);
    while ((!paramBoolean) && (!this.f))
      return;
    this.O = paramBoolean;
    if (this.K != null)
    {
      this.m = 0.0F;
      this.K.cancel();
    }
    u();
  }

  private Drawable o()
  {
    int m = getIconSize();
    if ((this.q == null) && (this.r == null))
      return null;
    if ((this.q != null) && (this.r == null))
    {
      this.q.setBounds(0, 0, m, m);
      return this.q;
    }
    if (this.q == null)
    {
      this.r.setBounds(0, 0, m, m);
      return this.r;
    }
    aug localaug = new aug(this.r, this.q, m);
    localaug.setBounds(0, 0, m, m);
    return localaug;
  }

  private void p()
  {
    yf.a(this.s);
  }

  private void r()
  {
    yf.b(this.s);
  }

  private void s()
  {
    this.L = true;
    if (this.y == null)
      return;
    post(new Runnable()
    {
      public void run()
      {
        FanItem.a(FanItem.this).onClick(FanItem.this);
      }
    });
  }

  private void t()
  {
    if (this.J != null)
      removeCallbacks(this.J);
  }

  private void u()
  {
    Object localObject = (yw)getTag();
    if ((localObject == null) || (!((yw)localObject).r()))
      return;
    ValueAnimator localValueAnimator;
    long l;
    if (this.O)
    {
      localObject = new float[2];
      Object tmp32_31 = localObject;
      tmp32_31[0] = 0.0F;
      Object tmp36_32 = tmp32_31;
      tmp36_32[1] = 0.4F;
      tmp36_32;
      localValueAnimator = ValueAnimator.ofFloat((float[])localObject);
      if (!this.O)
        break label141;
      l = 200L;
      label59: localValueAnimator.setDuration(l);
      if (!this.O)
        break label148;
    }
    label141: label148: for (localObject = new DecelerateInterpolator(1.5F); ; localObject = new AccelerateInterpolator(1.5F))
    {
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          FanItem.this.m = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FanItem.a(FanItem.this, null);
          if (FanItem.c(FanItem.this))
          {
            FanItem.c(FanItem.this, false);
            FanItem.this.k();
          }
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (FanItem.d(FanItem.this))
            if (FanItem.e(FanItem.this) != null)
              FanItem.e(FanItem.this).setColorFilter(FanItem.b);
          while (true)
          {
            FanItem.this.invalidate();
            return;
            if (FanItem.f(FanItem.this) != null)
            {
              FanItem.g(FanItem.this).setColorFilter(FanItem.b);
              continue;
              if (FanItem.e(FanItem.this) != null)
                FanItem.e(FanItem.this).setColorFilter(null);
              if (FanItem.h(FanItem.this) != null)
                FanItem.i(FanItem.this).setColorFilter(null);
            }
          }
        }
      });
      this.K = localValueAnimator;
      localValueAnimator.start();
      return;
      localObject = new float[2];
      tmp127_126 = localObject;
      tmp127_126[0] = 0.4F;
      tmp133_127 = tmp127_126;
      tmp133_127[1] = 0.0F;
      tmp133_127;
      break;
      l = 250L;
      break label59;
    }
  }

  protected FrameLayout.LayoutParams a(int paramInt, yl paramyl, boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams1;
    if (!paramBoolean)
    {
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 != null);
    }
    else
    {
      localLayoutParams1 = new FrameLayout.LayoutParams(this.k, -2);
    }
    this.i = paramInt;
    if (yb.getInstance() != null)
    {
      localLayoutParams1.width = this.k;
      localLayoutParams1.height = -2;
      a(paramyl.a, paramyl.b, localLayoutParams1);
    }
    return localLayoutParams1;
  }

  public void a()
  {
    setText(getText() + "◢");
    setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.v = true;
  }

  public void a(boolean paramBoolean)
  {
    this.s.a(paramBoolean);
  }

  public void a(boolean paramBoolean, yg paramyg)
  {
    this.s.a(paramBoolean, paramyg);
  }

  public boolean a(Canvas paramCanvas)
  {
    try
    {
      draw(paramCanvas);
      return true;
    }
    catch (Exception paramCanvas)
    {
    }
    return false;
  }

  public void b(boolean paramBoolean)
  {
    super.clearAnimation();
    if (paramBoolean)
      k();
  }

  public boolean b()
  {
    return this.w;
  }

  public void c()
  {
    a(false);
  }

  public void c(boolean paramBoolean)
  {
    if (!yw.g);
    FrameLayout.LayoutParams localLayoutParams;
    float f2;
    do
    {
      do
        return;
      while ((getTag() == null) || (!(getTag() instanceof yw)) || (getLayoutParams() == null) || (getAnimation() != null));
      localObject = (yw)getTag();
      if ((((yw)localObject).e == -100.0F) || (((yw)localObject).f == -100.0F) || (paramBoolean))
        break label201;
      localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if (!this.p)
        break;
      f1 = localLayoutParams.leftMargin;
      f2 = localLayoutParams.bottomMargin;
    }
    while ((f1 == ((yw)localObject).e) && (f2 == ((yw)localObject).f));
    if (this.p);
    for (float f1 = ((yw)localObject).e - f1; ; f1 -= ((yw)localObject).e)
    {
      localObject = new TranslateAnimation(f1, 0.0F, f2 - ((yw)localObject).f, 0.0F);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setFillBefore(true);
      setAnimation((Animation)localObject);
      return;
      f1 = localLayoutParams.rightMargin;
      break;
    }
    label201: Object localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setFillBefore(true);
    setAnimation((Animation)localObject);
  }

  public void clearAnimation()
  {
    b(true);
  }

  public void d()
  {
    a(false, null);
  }

  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    try
    {
      boolean bool = super.dispatchDragEvent(paramDragEvent);
      return bool;
    }
    catch (Throwable paramDragEvent)
    {
    }
    return false;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
    }
    return false;
  }

  protected void drawableStateChanged()
  {
    if ((this.K != null) && (this.K.isRunning()))
      return;
    if ((this.u != null) && (this.l != null))
    {
      int[] arrayOfInt = getDrawableState();
      int n = arrayOfInt.length;
      int m = 0;
      while (m < n)
      {
        if (arrayOfInt[m] == 16842919)
        {
          this.l.setColorFilter(this.u);
          invalidate();
          return;
        }
        m += 1;
      }
      if (this.t == null)
        this.l.clearColorFilter();
      while (true)
      {
        invalidate();
        return;
        this.l.setColorFilter(this.t);
      }
    }
    super.drawableStateChanged();
  }

  public boolean e()
  {
    boolean bool = this.z;
    this.z = false;
    return bool;
  }

  public boolean f()
  {
    boolean bool = this.A;
    this.A = false;
    return bool;
  }

  public boolean g()
  {
    return true;
  }

  public float getBaseScale()
  {
    return 1.0F;
  }

  public yf getDecor()
  {
    return new yf(this);
  }

  public int[] getIconPosition()
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    int m = (int)(getIconRect().width() * getScaleX());
    return new int[] { (int)(arrayOfInt[0] + (getMeasuredWidth() - getIconSize()) * getScaleX() / 2.0F), (int)(arrayOfInt[1] + getPaddingTop() * getScaleY()), m };
  }

  public Rect getIconRect()
  {
    return this.j;
  }

  public int getIconSize()
  {
    return this.c;
  }

  protected CharSequence getMeasuredText()
  {
    Object localObject = getText();
    if (this.n != TextUtils.TruncateAt.MIDDLE)
      return super.getMeasuredText();
    if (((!(localObject instanceof String)) && (((String)localObject).endsWith("◢"))) || (((CharSequence)localObject).length() < 3))
      return super.getMeasuredText();
    try
    {
      localObject = ((String)localObject).substring(0, ((CharSequence)localObject).length() - 2) + " ";
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return super.getMeasuredText();
  }

  public Point getTouchDownPoint()
  {
    return this.D;
  }

  public boolean h()
  {
    return this.v;
  }

  public void i()
  {
    if ((this.d == null) || (this.e == null));
    while (yb.getInstance() == null)
      return;
    yb localyb = yb.getInstance();
    final float f1 = yb.getInstance().getHandTrackRatio();
    f1 = localyb.getHandTracker().a(f1);
    if (localyb.getHandTracker().c())
    {
      postDelayed(new Runnable()
      {
        public void run()
        {
          FanItem.a(FanItem.this, f1);
          if ((FanItem.this.getParent() instanceof ViewGroup))
            FanItem.this.getParent().requestLayout();
        }
      }
      , this.i * yd.b());
      return;
    }
    c(f1);
  }

  public void j()
  {
    setScaleX(1.0F);
    setScaleY(1.0F);
  }

  public void k()
  {
    if (this.K != null)
    {
      this.K.cancel();
      this.K = null;
    }
    this.m = 0.0F;
    if (this.r != null)
      this.r.setColorFilter(null);
    while (true)
    {
      invalidate();
      return;
      if (this.l != null)
        this.l.setColorFilter(null);
    }
  }

  public void l()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setRepeatCount(2);
    localAlphaAnimation.setRepeatMode(2);
    startAnimation(localAlphaAnimation);
  }

  public void m()
  {
    if (!yw.g);
    while ((getTag() == null) || (!(getTag() instanceof yw)))
      return;
    yw localyw = (yw)getTag();
    if (getLayoutParams() == null)
    {
      localyw.e = -1.0F;
      localyw.f = -1.0F;
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    if (this.p);
    for (float f1 = localLayoutParams.leftMargin; ; f1 = localLayoutParams.rightMargin)
    {
      localyw.e = f1;
      localyw.f = localLayoutParams.bottomMargin;
      return;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.l != null) && ((this.l instanceof Animatable)))
      ((Animatable)this.l).start();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    t();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      paramCanvas.save();
      this.s.a(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception paramCanvas)
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.H = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.l != null)
    {
      Rect localRect = this.l.getBounds();
      paramInt1 = asq.a(4.0F);
      this.j.set((getWidth() - localRect.width()) / 2, localRect.top, (getWidth() + localRect.width()) / 2, localRect.bottom - paramInt1);
      this.C.set(0, localRect.bottom - paramInt1, getWidth(), getHeight());
      return;
    }
    this.j.set(0, 0, 0, 0);
    this.C.set(0, 0, getWidth(), getHeight());
  }

  public boolean onLongClick(View paramView)
  {
    if (this.x != null)
      return this.x.onLongClick(this);
    return false;
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.p);
    for (float f1 = 0.0F; ; f1 = getMeasuredWidth())
    {
      setPivotX(f1);
      setPivotY(getMeasuredHeight());
      return;
    }
  }

  protected boolean onSetAlpha(int paramInt)
  {
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (paramMotionEvent == null)
      return false;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while ((!this.f) && (!this.v))
    {
      return super.onTouchEvent(paramMotionEvent);
      this.D.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      d(true);
      continue;
      d(false);
      continue;
      clearAnimation();
      this.m = 0.0F;
      this.M = false;
      invalidate();
    }
    if (!g())
      return super.onTouchEvent(paramMotionEvent);
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default:
    case 0:
    case 1:
    case 3:
    case 2:
    }
    while (true)
    {
      label184: return true;
      this.F = m;
      this.G = n;
      this.I = false;
      t();
      if (this.f)
      {
        if (this.B.contains(m, n))
          this.z = true;
        while (true)
        {
          return true;
          a(90);
        }
      }
      if (!this.v)
        break;
      if (this.C.contains(m, n))
      {
        this.A = true;
        m = ahx.b(getContext()).k();
        setTextColor(Color.argb(127, Color.red(m), Color.green(m), Color.blue(m)));
      }
      a(this.E);
      return true;
      t();
      if (this.z)
        if ((this.B.contains(m, n)) && (!this.I))
        {
          this.z = true;
          s();
        }
      while (true)
      {
        setTextColor(ahx.b(getContext()).k());
        break label184;
        this.z = false;
        continue;
        if (this.v)
        {
          if ((a(m, n)) || (this.I))
            break;
          boolean bool1 = bool2;
          if (this.A)
          {
            bool1 = bool2;
            if (this.C.contains(m, n))
              bool1 = true;
          }
          this.A = bool1;
          s();
        }
      }
      if (a(m, n))
        t();
    }
  }

  public boolean performClick()
  {
    this.L = true;
    return super.performClick();
  }

  public boolean performLongClick()
  {
    b(false);
    this.M = true;
    sendAccessibilityEvent(2);
    if (onLongClick(this))
      performHapticFeedback(0);
    return true;
  }

  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      p();
      return;
    }
    r();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.t = paramColorFilter;
    this.l.setColorFilter(this.t);
    invalidate();
  }

  public void setIcon(int paramInt)
  {
    setIcon(getContext().getResources().getDrawable(paramInt));
  }

  public void setIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      setIconImage(null);
      this.q = null;
      return;
    }
    if (((paramDrawable instanceof BitmapDrawable)) && (!(paramDrawable instanceof aub)))
      paramDrawable = new BitmapDrawable(getResources(), ((BitmapDrawable)paramDrawable).getBitmap());
    while (true)
    {
      Object localObject = paramDrawable;
      if ((paramDrawable instanceof apd))
      {
        localObject = paramDrawable;
        if (!(paramDrawable instanceof aub))
          localObject = new apd(getResources(), ((apd)paramDrawable).a());
      }
      this.q = ((Drawable)localObject);
      setIconImage(o());
      return;
    }
  }

  public void setIcon(wk paramwk)
  {
    g.a(getResources(), this, paramwk);
  }

  public void setIconBackground(Drawable paramDrawable)
  {
    this.r = paramDrawable;
    setIconImage(o());
  }

  public void setIconPressAnimationEnable(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }

  public void setNeedSplitEvent(boolean paramBoolean)
  {
  }

  public void setOnClickListener(OnClickListener paramOnClickListener)
  {
    this.y = paramOnClickListener;
    super.setOnClickListener(paramOnClickListener);
  }

  public void setOnLongClickListener(OnLongClickListener paramOnLongClickListener)
  {
    this.x = paramOnLongClickListener;
    super.setOnLongClickListener(paramOnLongClickListener);
  }

  public void setPressedEffect(ColorFilter paramColorFilter)
  {
    this.u = paramColorFilter;
  }

  public void setText(CharSequence paramCharSequence)
  {
    super.setText(paramCharSequence);
    setEllipsize(TextUtils.TruncateAt.END);
    this.v = false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.FanItem
 * JD-Core Version:    0.6.2
 */