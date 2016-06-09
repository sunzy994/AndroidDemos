package cmcm.com.myapplication.com.lazyswipe.features.guide;

import ade;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import asq;
import atw;

public class GuideBackground extends RelativeLayout
{
  static final float[][] c = { { f1, f2, f3 }, arrayOfFloat, { f4, f5, f6 }, { f7, f8, f9 }, { f10, f11, f12 } };
  private static final String d = "Swipe." + GuideBackground.class.getSimpleName();
  private static final float[] t = { a(345), a(1480) };
  private static final float[] u = { a(609), a(1340) };
  protected int a;
  protected int b;
  private View e;
  private ImageView f;
  private ImageView g;
  private Bitmap h;
  private Bitmap i;
  private int[] j;
  private float[] k;
  private int l;
  private float[][] m = c;
  private int n;
  private final Paint o = new Paint();
  private final Paint p = new Paint();
  private float[] q = t;
  private float[] r = u;
  private Path s;

  static
  {
    float f1 = a(185);
    float f2 = a(601);
    float f3 = a(7);
    float[] arrayOfFloat = { a(177), a(1485), a(7) };
    float f4 = a(401);
    float f5 = a(1509);
    float f6 = a(4);
    float f7 = a(837);
    float f8 = a(1481);
    float f9 = a(7);
    float f10 = a(713);
    float f11 = a(1509);
    float f12 = a(4);
  }

  public GuideBackground(Context paramContext)
  {
    super(paramContext);
  }

  public GuideBackground(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static float a(int paramInt)
  {
    return asq.a(paramInt / 3);
  }

  private void d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 190, 0 });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        GuideBackground.a(GuideBackground.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        GuideBackground.b(GuideBackground.this).setAlpha(GuideBackground.a(GuideBackground.this));
        GuideBackground.c(GuideBackground.this).setAlpha(GuideBackground.a(GuideBackground.this));
        GuideBackground.this.invalidate();
      }
    });
    localValueAnimator.start();
  }

  public void a()
  {
    this.e.setAlpha(1.0F);
    this.f.setAlpha(1.0F);
    this.g.setAlpha(1.0F);
    c();
  }

  public void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramBoolean)
    {
      this.f.animate().alpha(1.0F).setDuration(500L).setListener(null);
      this.g.animate().alpha(1.0F).setDuration(500L).setListener(null);
      c();
    }
    this.e.animate().alpha(1.0F).setDuration(500L).setListener(paramAnimatorListener);
  }

  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.q = paramArrayOfFloat1;
    this.r = paramArrayOfFloat2;
    this.p.setColor(-1);
    this.p.setFlags(7);
    this.p.setStyle(Style.FILL);
    paramArrayOfFloat1 = new LinearGradient(this.q[0], this.q[1], this.r[0], this.r[1], -1140850689, 872415231, Shader.TileMode.CLAMP);
    this.p.setShader(paramArrayOfFloat1);
    this.s = new Path();
    int i1 = asq.a(2.5F);
    this.s.moveTo(this.q[0] + i1, this.q[1] + i1);
    paramArrayOfFloat1 = this.s;
    float f1 = this.q[0];
    float f2 = i1;
    float f3 = this.q[1];
    float f4 = i1;
    float f5 = this.q[0];
    float f6 = i1;
    float f7 = this.q[1];
    paramArrayOfFloat1.arcTo(new RectF(f1 - f2, f3 - f4, f5 + f6, i1 + f7), 45.0F, 180.0F, true);
    this.s.lineTo(this.r[0], this.r[1]);
    this.s.close();
  }

  public void a(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this.j = paramArrayOfInt;
    this.k = paramArrayOfFloat;
    this.e.setBackgroundDrawable(new ade(this.j, this.k, null));
  }

  public void b()
  {
    int i1 = (int)((this.a - this.h.getWidth()) / 2 * 0.8F);
    int i2 = (this.a - this.i.getWidth()) / 2;
    this.f.animate().alpha(0.0F).translationX(i1).setDuration(750L);
    this.g.animate().alpha(0.0F).translationX(i2).setDuration(750L);
    d();
  }

  public void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 190 });
    localValueAnimator.setDuration(700L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        GuideBackground.a(GuideBackground.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        GuideBackground.b(GuideBackground.this).setAlpha(GuideBackground.a(GuideBackground.this));
        GuideBackground.c(GuideBackground.this).setAlpha(GuideBackground.a(GuideBackground.this));
        GuideBackground.this.invalidate();
      }
    });
    localValueAnimator.start();
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.n > 0)
    {
      int i1 = 0;
      while (i1 < this.m.length)
      {
        paramCanvas.drawCircle(this.m[i1][0], this.m[i1][1], this.m[i1][2], this.o);
        i1 += 1;
      }
      i1 = asq.a(3.0F);
      this.o.setAlpha(70);
      paramCanvas.drawCircle(this.q[0], this.q[1], i1, this.o);
      this.o.setAlpha(this.n);
      paramCanvas.drawPath(this.s, this.p);
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    atw.a(this.h);
    atw.a(this.i);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.e = findViewById(2131755277);
    this.f = ((ImageView)findViewById(2131755278));
    this.g = ((ImageView)findViewById(2131755279));
    try
    {
      this.h = atw.a(getResources(), 2130837853);
      this.f.setImageBitmap(this.h);
      try
      {
        label68: this.i = atw.a(getResources(), 2130837854);
        this.g.setImageBitmap(this.i);
        label93: this.o.setColor(-1);
        this.o.setFlags(7);
        this.o.setStyle(Style.FILL);
        a(t, u);
        return;
      }
      catch (Throwable localThrowable1)
      {
        break label93;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label68;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h != null)
      this.f.layout((getWidth() - this.h.getWidth()) / 2, getHeight() - this.l - this.h.getHeight(), (getWidth() + this.h.getWidth()) / 2, getHeight() - this.l);
    if (this.i != null)
      this.g.layout((getWidth() - this.i.getWidth()) / 2, getHeight() - this.l - this.i.getHeight(), (getWidth() + this.i.getWidth()) / 2, getHeight() - this.l);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.h != null)
      this.f.measure(this.h.getWidth(), this.h.getHeight());
    if (this.i != null)
      this.g.measure(this.i.getWidth(), this.i.getHeight());
    this.a = getWidth();
    this.b = getHeight();
  }

  public void setHillBottom(int paramInt)
  {
    this.l = paramInt;
  }

  public void setStarsPosition(float[][] paramArrayOfFloat)
  {
    this.m = paramArrayOfFloat;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.GuideBackground
 * JD-Core Version:    0.6.2
 */