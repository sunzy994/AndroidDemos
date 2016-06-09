package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

public class acx extends aue
{
  private final Paint a;
  private final Paint b = new Paint();
  private final Paint c;
  private boolean d;
  private int e;
  private final int f;
  private final int g;
  private int h;
  private final int i;
  private int j;
  private final int k;
  private final Rect l;
  private final Point m;
  private Bitmap n;
  private final Path o = new Path();
  private final RectF p = new RectF();
  private int q;
  private float r;
  private boolean s;
  private int t = 255;
  private int u = 51;
  private int v = 255;
  private boolean w;

  acx(Context paramContext)
  {
    this.b.setTextAlign(Align.CENTER);
    this.b.setTextSize(asq.a(12.0F));
    this.b.setTypeface(Typeface.create("sans-serif-light", 0));
    this.b.setFlags(7);
    this.c = new Paint();
    this.c.setStyle(Style.FILL);
    this.c.setFlags(7);
    this.a = new Paint();
    this.a.setStyle(Style.FILL);
    this.a.setFlags(7);
    this.f = (acw.c / 2);
    this.g = asq.a(2.0F);
    this.h = 0;
    this.i = asq.a(1.5F);
    this.k = asq.a(1.5F);
    this.j = (acw.c * 2 / 3);
    this.m = new Point();
    this.l = new Rect();
    a();
  }

  private void a(Canvas paramCanvas)
  {
    if (!this.s)
      return;
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    paramCanvas.save();
    if (!this.d)
      paramCanvas.translate(acw.d, 0.0F);
    paramCanvas.clipPath(this.o);
    this.p.set(this.q - this.f, this.m.y - this.f, this.q + this.f, this.m.y + this.f);
    paramCanvas.drawArc(this.p, 90.0F, -this.r, true, this.c);
    paramCanvas.drawArc(this.p, 270.0F, -this.r, true, this.c);
    paramCanvas.restore();
    paramCanvas.setDrawFilter(localDrawFilter);
  }

  private int f()
  {
    if (i())
      return this.t;
    return 255;
  }

  private int g()
  {
    if (i())
      return this.u;
    return 51;
  }

  private int h()
  {
    if (i())
      return this.v;
    return 255;
  }

  private boolean i()
  {
    return this.e < 70;
  }

  protected void a()
  {
    int i1 = ari.a((int) (aqr.b() * 100.0F), 0, 99);
    if (this.e != i1)
    {
      this.e = i1;
      invalidateSelf();
    }
  }

  void a(int paramInt)
  {
    this.h = paramInt;
    invalidateSelf();
  }

  void a(final AnimatorListener paramAnimatorListener)
  {
    int i1;
    ValueAnimator localValueAnimator;
    if (this.d)
    {
      i1 = 0;
      localValueAnimator = ValueAnimator.ofInt(new int[] { i1, this.m.x });
      localValueAnimator.setDuration(180L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          acx.a(acx.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          acx.this.invalidateSelf();
        }
      });
      localValueAnimator.start();
      if (!this.d)
        break label128;
    }
    label128: for (float f1 = -180.0F; ; f1 = 180.0F)
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, f1 });
      localValueAnimator.setDuration(330L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          acx.a(acx.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          acx.this.invalidateSelf();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (paramAnimatorListener != null)
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          acx.a(acx.this, true);
          if (paramAnimatorListener != null)
            paramAnimatorListener.onAnimationStart(paramAnonymousAnimator);
        }
      });
      localValueAnimator.start();
      return;
      i1 = acw.b;
      break;
    }
  }

  void a(Bitmap paramBitmap)
  {
    this.n = paramBitmap;
    invalidateSelf();
  }

  protected void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    Point localPoint = this.m;
    int i1;
    int i2;
    int i3;
    int i4;
    if (this.d)
    {
      i1 = acw.f;
      localPoint.x = i1;
      this.m.y = (this.f + acw.e);
      this.o.reset();
      this.o.addCircle(this.m.x, this.m.y, this.f, Direction.CW);
      i1 = asq.a(12.0F);
      i2 = asq.a(4.0F);
      i3 = (acw.c - i1) / 2;
      i4 = (acw.c + i1) / 2;
      if (!this.d)
        break label151;
      this.l.set(i2, i3, i1 + i2, i4);
    }
    while (true)
    {
      invalidateSelf();
      return;
      i1 = acw.b - acw.f;
      break;
      label151: this.l.set(acw.b - i1 - i2, i3, acw.b - i2, i4);
    }
  }

  int b()
  {
    if (this.e < 70)
      return asq.a(54192, f());
    if (this.e < 80)
      return -16590;
    if (this.e < 90)
      return -36807;
    return -378818;
  }

  void b(final AnimatorListener paramAnimatorListener)
  {
    int i1;
    ValueAnimator localValueAnimator;
    if (this.d)
    {
      i1 = 0;
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.m.x, i1 });
      localValueAnimator.setDuration(180L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          acx.a(acx.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          acx.this.invalidateSelf();
        }
      });
      localValueAnimator.start();
      if (!this.d)
        break label128;
    }
    label128: for (float f1 = -180.0F; ; f1 = 180.0F)
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, 0.0F });
      localValueAnimator.setDuration(330L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          acx.a(acx.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          acx.this.invalidateSelf();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          acx.a(acx.this, false);
          if (paramAnimatorListener != null)
            paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramAnimatorListener != null)
            paramAnimatorListener.onAnimationStart(paramAnonymousAnimator);
        }
      });
      localValueAnimator.start();
      return;
      i1 = acw.b;
      break;
    }
  }

  void b(boolean paramBoolean)
  {
    this.w = paramBoolean;
    invalidateSelf();
  }

  int c()
  {
    return this.e;
  }

  void d()
  {
    if (!i())
      return;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 86 });
    localValueAnimator.setDuration(230L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        acx.b(acx.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        acx.this.invalidateSelf();
      }
    });
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { 51, 24 });
    localValueAnimator.setDuration(230L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        acx.c(acx.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        acx.this.invalidateSelf();
      }
    });
    localValueAnimator.start();
    localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 86 });
    localValueAnimator.setDuration(230L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        acx.d(acx.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        acx.this.invalidateSelf();
      }
    });
    localValueAnimator.start();
  }

  public void draw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    if ((this.w) && (this.n != null))
    {
      Bitmap localBitmap = this.n;
      if (this.d);
      while (true)
      {
        paramCanvas.drawBitmap(localBitmap, f1, (getIntrinsicHeight() - this.n.getHeight()) / 2, null);
        return;
        f1 = getIntrinsicWidth() - this.n.getWidth();
      }
    }
    paramCanvas.save();
    this.c.setColor(b());
    this.b.setColor(asq.a(16711422, h()));
    this.a.setColor(asq.a(0, g()));
    a(paramCanvas);
    if (this.d)
    {
      paramCanvas.translate(0.0F, acw.e);
      if (!this.s)
        paramCanvas.drawCircle(acw.f, this.f, this.f, this.a);
      if (!this.s)
      {
        paramCanvas.save();
        paramCanvas.translate(0.0F, -acw.e);
        paramCanvas.clipPath(this.o);
        paramCanvas.drawRect(0.0F, 0.0F, this.g + this.h, acw.c + acw.e, this.c);
        paramCanvas.restore();
      }
      if (atw.b(this.n))
        paramCanvas.drawBitmap(this.n, null, this.l, null);
      while (true)
      {
        paramCanvas.translate(0.0F, -acw.e);
        paramCanvas.restore();
        return;
        paramCanvas.drawText(String.valueOf(this.e), acw.b / 2 - this.k, this.j - acw.e, this.b);
      }
    }
    paramCanvas.translate(acw.d, acw.e);
    if (!this.s)
      paramCanvas.drawCircle(acw.b - acw.f, this.f, this.f, this.a);
    if (!this.s)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -acw.e);
      paramCanvas.clipPath(this.o);
      paramCanvas.drawRect(acw.b - this.i - this.h, 0.0F, acw.b, acw.c + acw.e, this.c);
      paramCanvas.restore();
    }
    if (atw.b(this.n))
      paramCanvas.drawBitmap(this.n, null, this.l, null);
    while (true)
    {
      paramCanvas.translate(-acw.d, -acw.e);
      break;
      paramCanvas.drawText(String.valueOf(this.e), acw.b / 2 + this.k, this.j - acw.e, this.b);
    }
  }

  void e()
  {
    this.t = 255;
    this.v = 255;
    this.u = 51;
    invalidateSelf();
  }

  public int getIntrinsicHeight()
  {
    return acw.c + acw.e + acw.e;
  }

  public int getIntrinsicWidth()
  {
    return acw.b + acw.d;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    Rect localRect = new Rect();
    this.b.getTextBounds("0", 0, 1, localRect);
    this.j = (paramRect.top + (paramRect.height() - localRect.height()) / 2 - localRect.top);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acx
 * JD-Core Version:    0.6.2
 */