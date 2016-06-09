package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import acl;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqr;
import aqs;
import asq;

public class BoostPlusPlaneLayout extends RelativeLayout
{
  private boolean A = false;
  private boolean B = false;
  private final Paint C = new Paint(6);
  private final int D;
  private long E;
  private boolean F;
  private boolean G;
  private int H;
  private int I;
  private int J;
  private int K;
  long a = 0L;
  private boolean b = true;
  private boolean c;
  private final Point d = new Point();
  private final Point e = new Point();
  private int f;
  private int g;
  private long h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private TextView n;
  private final int o = 2250;
  private final int p = aqs.ac();
  private int q = aqs.ad() - aqs.ak() - aqs.r(getContext());
  private int r = 0;
  private final Paint s = new Paint(6);
  private Path t = new Path();
  private final float u = 0.245192F;
  private final int v = this.q - asq.a(125.0F);
  private int w = (int)(this.v - this.p * 0.0F);
  private int x;
  private final int y = 450;
  private long z = 0L;

  public BoostPlusPlaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.s.setStyle(Style.FILL);
    this.s.setColor(-1315861);
    this.C.setStyle(Style.STROKE);
    this.C.setStrokeCap(Cap.ROUND);
    this.C.setStrokeWidth(asq.a(1.0F));
    this.C.setColor(-856953877);
    this.D = 500;
    this.E = 0L;
    this.F = false;
    this.G = false;
    this.H = 0;
    this.I = 0;
    this.J = 0;
    this.K = 0;
  }

  private void b()
  {
    this.F = true;
    this.E = 0L;
    this.H = getHeight();
    this.I = ((int)this.l.getTranslationY());
    this.K = asq.a(290.0F);
    this.J = asq.a(40.0F);
    invalidate();
  }

  private boolean b(Canvas paramCanvas)
  {
    if (!this.A)
      return false;
    long l1 = SystemClock.uptimeMillis();
    float f1 = 0.0F;
    if (this.z == 0L)
      this.z = l1;
    while (true)
    {
      if (!this.B)
        setPlaneLayoutHeight((int)(this.q - (this.q - this.x) * f1));
      if ((this.B) || (f1 < 1.0F))
        break;
      this.B = true;
      a();
      return true;
      if (l1 - this.z > 450L)
        f1 = 1.0F;
      else
        f1 = ((float)l1 - (float)this.z) / 450.0F;
    }
    if (!this.B);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean c(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    if (!this.F)
      return false;
    if (this.G)
    {
      paramCanvas.translate(0.0F, f1 * (this.J - this.I));
      return true;
    }
    if ((this.F) && (this.E == 0L))
      this.E = SystemClock.uptimeMillis();
    float f2 = ((float)SystemClock.uptimeMillis() - (float)this.E) / 500.0F;
    if (f2 >= 1.0F)
      this.G = true;
    while (true)
    {
      setPlaneLayoutHeight((int)(this.H + (this.K - this.H) * f1));
      invalidate();
      break;
      f1 = f2;
    }
  }

  void a()
  {
    Object localObject = new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.64D)
          return (1.0F - (1.0F - paramAnonymousFloat / 0.68F) * (1.0F - paramAnonymousFloat / 0.68F)) * 0.98F;
        return 0.976609F + 0.06497501F * (paramAnonymousFloat - 0.64F);
      }
    };
    int i1 = (int)(this.q * 0.23F);
    this.l.setX(-this.l.getMeasuredWidth());
    this.l.setY(i1);
    this.l.setVisibility(0);
    int i2 = (int)(this.l.getMeasuredWidth() + this.p * 0.45F);
    this.l.animate().xBy(i2).yBy(-i2 * 0.245192F).setInterpolator((TimeInterpolator)localObject).setDuration(2250L);
    int i3 = this.p;
    i2 = (int)(-this.p * 0.46F);
    this.i.setX(i3);
    this.i.setY(i1 - this.p * 0.245192F + asq.a(3.0F));
    this.i.setVisibility(0);
    this.i.animate().xBy(i2).yBy(-i2 * 0.245192F).setInterpolator((TimeInterpolator)localObject).setDuration(2250L);
    i3 = this.p + asq.a(75.0F);
    this.j.setX(i3);
    this.j.setY(i1 - i3 * 0.245192F + asq.a(35.0F));
    this.j.setVisibility(0);
    this.j.animate().xBy(i2).yBy(-i2 * 0.245192F).setInterpolator((TimeInterpolator)localObject).setDuration(2250L);
    i3 = this.p + asq.a(30.0F);
    this.k.setX(i3);
    this.k.setY(i1 - i3 * 0.245192F + asq.a(119.0F));
    this.k.setVisibility(0);
    this.k.animate().xBy(i2).yBy(-i2 * 0.245192F).setInterpolator((TimeInterpolator)localObject).setDuration(2250L);
    if (this.a <= 0L)
      this.a = Math.abs((aqr.c(getContext()) - this.h) / 1024L);
    this.n.setText(getContext().getString(2131231188, new Object[] { acl.a(this.a) }));
    this.m.setY(this.q * 0.465F + asq.a(120.0F));
    this.m.setVisibility(0);
    this.m.animate().y(this.q * 0.465F).setInterpolator((TimeInterpolator)localObject).setDuration(2250L);
    i1 = -asq.a(76.0F);
    i2 = (int)(this.q * 0.375F);
    this.d.set(i1, i2);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, (int)(this.p * 0.46D - i1) });
    localValueAnimator.setDuration(2250L);
    localValueAnimator.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BoostPlusPlaneLayout.a(BoostPlusPlaneLayout.this, Integer.parseInt(paramAnonymousValueAnimator.getAnimatedValue().toString()));
        BoostPlusPlaneLayout.this.invalidate();
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (BoostPlusPlaneLayout.a(BoostPlusPlaneLayout.this))
          BoostPlusPlaneLayout.b(BoostPlusPlaneLayout.this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        BoostPlusPlaneLayout.a(BoostPlusPlaneLayout.this, true);
      }
    });
    localValueAnimator.start();
    i1 = asq.a(35.0F);
    i2 = (int)(this.q * 0.35F);
    this.e.set(i1, i2);
    localObject = ValueAnimator.ofInt(new int[] { 0, asq.a(85.0F) });
    ((ValueAnimator)localObject).setDuration(1000L);
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setStartDelay(500L);
    ((ValueAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BoostPlusPlaneLayout.b(BoostPlusPlaneLayout.this, Integer.parseInt(paramAnonymousValueAnimator.getAnimatedValue().toString()));
        BoostPlusPlaneLayout.this.invalidate();
      }
    });
    ((ValueAnimator)localObject).start();
  }

  void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.x = paramInt2;
  }

  void a(long paramLong)
  {
    this.a += paramLong;
  }

  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.A = true;
    this.z = 0L;
    invalidate();
  }

  boolean a(Canvas paramCanvas)
  {
    if (!this.c)
      return false;
    int i1 = this.d.x;
    int i2 = this.f;
    int i3 = (int)(this.d.y - this.f * 0.245192F);
    paramCanvas.drawLine(this.d.x, this.d.y, i1 + i2, i3, this.C);
    i1 = this.e.x;
    i2 = this.g;
    i3 = (int)(this.e.y - this.g * 0.245192F);
    paramCanvas.drawLine(this.e.x, this.e.y, i1 + i2, i3, this.C);
    return false;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool1 = c(paramCanvas);
    boolean bool2 = b(paramCanvas);
    super.dispatchDraw(paramCanvas);
    if ((bool2 | a(paramCanvas)))
      invalidate();
    if (bool1)
      paramCanvas.restore();
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.i = findViewById(2131755127);
    this.j = findViewById(2131755129);
    this.k = findViewById(2131755131);
    this.l = findViewById(2131755133);
    this.m = findViewById(2131755135);
    this.n = ((TextView)findViewById(2131755136));
    this.h = aqr.c(getContext());
  }

  void setPlaneLayoutHeight(int paramInt)
  {
    if (getLayoutParams().height == paramInt)
      return;
    getLayoutParams().height = paramInt;
    requestLayout();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.BoostPlusPlaneLayout
 * JD-Core Version:    0.6.2
 */