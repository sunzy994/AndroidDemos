package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

public class avf extends View
  implements AnimatorListener, Callback
{
  private static final String a = "Swipe." + avf.class.getSimpleName();
  private int A;
  private Paint B = new Paint();
  private Point C = new Point();
  private Point D = new Point();
  private Bitmap E;
  private Bitmap F;
  private avg G;
  private boolean H;
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private float k = 0.0F;
  private final RectF l = new RectF();
  private final RectF m = new RectF();
  private Paint n;
  private int o;
  private int p;
  private float q;
  private float r;
  private float s;
  private boolean t;
  private boolean u;
  private boolean v;
  private long w;
  private Handler x;
  private int y;
  private final boolean z = true;

  public avf(Context paramContext)
  {
    this(paramContext, null);
  }

  public avf(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public avf(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  private int a(double paramDouble)
  {
    int i2 = -1;
    int i3 = (int)Math.round(e() * paramDouble);
    int i1 = i3;
    if (i3 < 0)
      if (this.d <= 0)
        break label62;
    label62: for (i1 = 0; i1 > this.c; i1 = -1)
    {
      i1 = i2;
      if (this.d < this.c)
        i1 = this.c;
      return i1;
    }
    return i1;
  }

  private int a(int paramInt, boolean paramBoolean)
  {
    return (int)this.r;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    int i1 = 0;
    this.x = new Handler(this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, vl.CustomSeekBarStyle, paramInt, 2131427384);
    if (paramAttributeSet != null);
    while (true)
    {
      try
      {
        this.e = paramAttributeSet.getDimensionPixelSize(4, 0);
        this.b = atw.a(ahx.b(getContext()).i(), getResources().getDimensionPixelSize(2131296344));
        paramInt = this.b.getIntrinsicHeight() >> this.y + 1;
        int i2 = this.b.getIntrinsicWidth() >> this.y + 1;
        this.b.setBounds(-i2, -paramInt, i2, paramInt);
        this.c = paramAttributeSet.getInteger(0, 100);
        this.d = paramAttributeSet.getInteger(1, 0);
        i2 = paramAttributeSet.getColor(5, 0);
        this.f = paramAttributeSet.getInt(6, 0);
        this.g = paramAttributeSet.getInt(7, 360);
        this.i = paramAttributeSet.getBoolean(8, false);
        this.j = true;
        this.r = paramAttributeSet.getDimension(3, 0.0F);
        this.s = (paramContext.getResources().getDimension(2131296335) / 2.0F);
        paramAttributeSet.recycle();
        if (this.d > this.c)
        {
          paramInt = this.c;
          this.d = paramInt;
          if (this.d >= 0)
            break label462;
          paramInt = 0;
          this.d = paramInt;
          if (this.g <= 360)
            break label470;
          paramInt = 360;
          this.g = paramInt;
          if (this.g >= 0)
            break label478;
          paramInt = 0;
          this.g = paramInt;
          if (this.f <= 360)
            break label486;
          paramInt = 0;
          this.f = paramInt;
          if (this.f >= 0)
            break label494;
          paramInt = i1;
          this.f = paramInt;
          this.k = (this.d / this.c * this.g);
          this.n = new Paint();
          this.n.setColor(i2);
          this.n.setAntiAlias(true);
          this.n.setStyle(Style.STROKE);
          this.n.setStrokeWidth(this.e);
          if (this.i)
            this.n.setStrokeCap(Cap.ROUND);
          this.y = asq.a(2.0F);
          this.B = new Paint(atw.b);
          this.B.setColor(-1);
          this.B.setTextSize(asq.a(40.0F));
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      paramInt = this.d;
      continue;
      label462: paramInt = this.d;
      continue;
      label470: paramInt = this.g;
      continue;
      label478: paramInt = this.g;
      continue;
      label486: paramInt = this.f;
      continue;
      label494: paramInt = this.f;
    }
  }

  private void a(Canvas paramCanvas)
  {
    if ((!atw.b(this.E)) || (!atw.b(this.F)))
      return;
    paramCanvas.drawBitmap(this.E, this.C.x, this.C.y, null);
    paramCanvas.drawBitmap(this.F, this.D.x, this.D.y, null);
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (this.t)
    {
      f1 = 0.0F;
      paramFloat1 -= f1;
      paramFloat2 -= this.r;
      paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (paramFloat1 >= this.q)
        break label87;
    }
    label87: for (boolean bool1 = true; ; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (Math.abs(paramFloat1 - this.r) > this.s)
          bool2 = true;
      }
      else
      {
        return bool2;
        f1 = this.r;
        break;
      }
      return false;
    }
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool = a(f1, f2);
    if ((this.H) && (bool))
      return false;
    setPressed(true);
    b(a(b(f1, f2)), true);
    return true;
  }

  private double b(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (this.t)
    {
      f1 = paramFloat2 - this.r;
      paramFloat2 = paramFloat1;
      paramFloat1 = f1;
    }
    while (true)
    {
      double d2 = Math.toDegrees(Math.atan2(paramFloat1, paramFloat2) + 1.570796326794897D - Math.toRadians(this.h));
      double d1 = d2;
      if (d2 < 0.0D)
        d1 = d2 + 360.0D;
      d2 = d1;
      if (!this.t)
        d2 = d1 - 180.0D;
      return d2 - this.f;
      f1 = paramFloat1 - this.r;
      paramFloat1 = this.r - paramFloat2;
      paramFloat2 = f1;
    }
  }

  private void b(int paramInt, boolean paramBoolean)
  {
    c(paramInt, paramBoolean);
  }

  private void c()
  {
    if (this.G != null)
      this.G.a(this);
  }

  private void c(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1);
    int i1;
    do
    {
      return;
      if (paramInt <= this.c)
        break;
      paramInt = this.c;
      i1 = paramInt;
      if (!paramBoolean)
        i1 = this.c - paramInt;
    }
    while (this.d == i1);
    if (this.G != null)
      if (!paramBoolean)
        break label114;
    label114: for (paramInt = this.c - i1; ; paramInt = i1)
    {
      this.G.a(this, paramInt, paramBoolean);
      this.d = i1;
      this.k = (i1 / this.c * this.g);
      f();
      invalidate();
      return;
      if (paramInt < 0)
      {
        paramInt = 0;
        break;
      }
      break;
    }
  }

  private void d()
  {
    if (this.G != null)
      this.G.b(this);
  }

  private float e()
  {
    return this.c / this.g;
  }

  private void f()
  {
    int i1 = (int)(this.f + this.k + this.h - 90.0F);
    this.o = ((int)(this.r * Math.cos(Math.toRadians(i1)) + 0.5D));
    double d1 = this.r;
    this.p = ((int)(Math.sin(Math.toRadians(i1)) * d1 + 0.5D));
  }

  public void a()
  {
    if (this.u)
    {
      if (!this.v)
        return;
      animate().cancel();
    }
    this.v = false;
    setVisibility(0);
    animate().alpha(1.0F).setListener(this);
  }

  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.E = paramBitmap1;
    this.F = paramBitmap2;
  }

  public void b()
  {
    if (this.u)
    {
      if (this.v)
        return;
      animate().cancel();
    }
    this.v = true;
    setAutoDismiss(0L);
    animate().alpha(0.0F).setListener(this);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.b != null) && (this.b.isStateful()))
    {
      int[] arrayOfInt = getDrawableState();
      this.b.setState(arrayOfInt);
    }
    invalidate();
  }

  public int getArcRotation()
  {
    return this.h;
  }

  public int getArcWidth()
  {
    return this.e;
  }

  public avg getOnSeekBarChangeListener()
  {
    return this.G;
  }

  public float getRadius()
  {
    return this.r;
  }

  public int getStartAngle()
  {
    return this.f;
  }

  public int getSweepAngle()
  {
    return this.g;
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      animate().alpha(0.0F).setListener(this);
      return true;
    }
    return false;
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.u = false;
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    this.u = false;
    if (getAlpha() < 0.1F)
      setVisibility(4);
  }

  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.u = true;
  }

  public void onAnimationStart(Animator paramAnimator)
  {
    this.u = true;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    if ((localLayoutParams.gravity & vj.a) == vj.a);
    for (boolean bool = true; ; bool = false)
    {
      this.t = bool;
      localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131296344), 0, 0);
      return;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = this.m;
    float f2 = this.A;
    if (this.t)
    {
      f1 = this.g;
      paramCanvas.drawArc(localRectF, f2, f1, false, this.n);
      a(paramCanvas);
      if (!this.t)
        break label106;
      f2 = this.o;
    }
    for (float f1 = this.r + this.p - this.y; ; f1 = this.r + this.p - this.y)
    {
      paramCanvas.translate(f2, f1);
      this.b.draw(paramCanvas);
      paramCanvas.translate(-f2, -f1);
      return;
      f1 = -this.g;
      break;
      label106: f2 = this.r - this.o;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, true);
    paramInt2 = a(paramInt2, false);
    int i1 = Math.min(paramInt1, paramInt2) - getPaddingLeft() - getPaddingRight();
    int i2 = paramInt2 / 2 - i1 / 2;
    int i3 = paramInt1 / 2 - i1 / 2;
    this.l.set(i3, i2, i3 + i1, i2 + i1);
    float f3;
    float f4;
    float f5;
    float f1;
    label172: float f6;
    if (this.t)
    {
      this.m.set(i3 - this.r, i2, i3 + i1, i1 + i2 + this.r);
      this.A = (this.h - 90 + this.f);
      f3 = this.m.centerX();
      f4 = this.m.centerY();
      f5 = this.A;
      if (!this.t)
        break label521;
      f1 = -3.0F;
      f6 = this.A;
      if (!this.t)
        break label529;
    }
    label521: label529: for (float f2 = this.g + 3.0F; ; f2 = -this.g - 3.0F)
    {
      double d2 = Math.toRadians(f5 + f1);
      double d1 = Math.toRadians(f2 + f6);
      this.C.x = ((int)(f3 + Math.cos(d2) * this.r));
      Point localPoint = this.C;
      double d3 = f4;
      localPoint.y = ((int)(Math.sin(d2) * this.r + d3));
      this.D.x = ((int)(f3 + Math.cos(d1) * this.r));
      localPoint = this.D;
      d2 = f4;
      localPoint.y = ((int)(Math.sin(d1) * this.r + d2));
      if (atw.b(this.E))
      {
        localPoint = this.C;
        localPoint.x -= this.E.getWidth() / 2;
        localPoint = this.C;
        localPoint.y -= this.E.getHeight() / 2;
      }
      if (atw.b(this.F))
      {
        localPoint = this.D;
        localPoint.x -= this.F.getWidth() / 2;
        localPoint = this.D;
        localPoint.y -= this.F.getHeight() / 2;
      }
      f();
      setTouchInSide(this.j);
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      this.m.set(i3, i2, i3 + i1 + this.r, i1 + i2 + this.r);
      this.A = (this.h - 90 - this.f);
      break;
      f1 = 3.0F;
      break label172;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.H = false;
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
      bool = true;
      do
      {
        return bool;
        this.H = true;
        this.x.removeMessages(1);
      }
      while (!a(paramMotionEvent));
      c();
      continue;
      a(paramMotionEvent);
      continue;
      d();
      setPressed(false);
      if (this.w > 0L)
        this.x.sendEmptyMessageDelayed(1, this.w);
    }
  }

  public void setArcRotation(int paramInt)
  {
    this.h = paramInt;
    f();
  }

  public void setArcWidth(int paramInt)
  {
    this.e = paramInt;
    this.n.setStrokeWidth(paramInt);
  }

  public void setAutoDismiss(long paramLong)
  {
    this.w = paramLong;
    if (this.w > 0L)
    {
      this.x.sendEmptyMessageDelayed(1, this.w);
      return;
    }
    this.x.removeMessages(1);
  }

  public void setGravity(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int i1;
    if (localLayoutParams != null)
    {
      if (!paramBoolean)
        break label38;
      i1 = vj.a;
      i1 |= 80;
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams))
        break label45;
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = i1;
    }
    label38: label45: 
    while (!(localLayoutParams instanceof FrameLayout.LayoutParams))
    {
      return;
      i1 = vj.b;
      break;
    }
    ((FrameLayout.LayoutParams)localLayoutParams).gravity = i1;
  }

  public void setOnSeekBarChangeListener(avg paramavg)
  {
    this.G = paramavg;
  }

  public void setProgress(int paramInt)
  {
    this.x.removeMessages(1);
    c(paramInt, false);
  }

  public void setRadius(float paramFloat)
  {
    if (this.r != paramFloat)
    {
      this.r = paramFloat;
      setTouchInSide(this.j);
    }
  }

  public void setRoundedEdges(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.i)
    {
      this.n.setStrokeCap(Cap.ROUND);
      return;
    }
    this.n.setStrokeCap(Cap.SQUARE);
  }

  public void setStartAngle(int paramInt)
  {
    this.f = paramInt;
    f();
  }

  public void setSweepAngle(int paramInt)
  {
    this.g = paramInt;
    f();
  }

  public void setTouchInSide(boolean paramBoolean)
  {
    int i1 = this.b.getIntrinsicHeight();
    int i2 = this.b.getIntrinsicWidth();
    this.j = paramBoolean;
    if (this.j)
    {
      this.q = (this.r / 4.0F);
      return;
    }
    this.q = (this.r - Math.min(i2 >> 1, i1 >> 1));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avf
 * JD-Core Version:    0.6.2
 */