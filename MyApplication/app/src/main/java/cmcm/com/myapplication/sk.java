package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class sk extends Drawable
  implements Animatable, Runnable
{
  private static final String d = "GameSDK." + sk.class.getSimpleName();
  final int a;
  final float[] b;
  final List<Animator> c;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int[] n;
  private final Paint o;
  private long p = -1L;
  private long q;
  private boolean r = false;

  public sk(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.g = paramInt1;
    this.i = paramInt2;
    this.a = paramArrayOfInt.length;
    this.n = new int[this.a];
    System.arraycopy(paramArrayOfInt, 0, this.n, 0, this.a);
    this.m = paramInt3;
    this.l = paramInt3;
    this.k = paramInt4;
    this.j = paramInt4;
    this.h = (this.g << 1);
    this.e = (this.a * this.h + (this.a - 1) * this.i + this.l + this.m);
    this.f = (this.h + this.k + this.j);
    this.o = new Paint(1);
    this.o.setStyle(Style.FILL);
    float f1 = this.f / 2.0F;
    this.b = new float[this.a];
    Arrays.fill(this.b, f1);
    this.c = new ArrayList(this.a);
    paramInt1 = 0;
    while (paramInt1 < this.a)
    {
      paramArrayOfInt = ValueAnimator.ofFloat(new float[] { this.g + f1, f1 - this.h, this.g + f1 });
      paramArrayOfInt.setDuration(800L);
      paramArrayOfInt.setRepeatCount(-1);
      paramArrayOfInt.setStartDelay(50L + paramInt1 * 100L);
      paramArrayOfInt.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          sk.this.b[sk.this.c.indexOf(paramAnonymousValueAnimator)] = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          sk.this.invalidateSelf();
        }
      });
      paramArrayOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
      this.c.add(paramArrayOfInt);
      paramInt1 += 1;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    this.q = System.currentTimeMillis();
    if (this.p < 0L)
      this.p = this.q;
    int i1 = 0;
    while (i1 < this.a)
    {
      int i2 = this.l;
      int i3 = this.g;
      int i4 = this.h;
      int i5 = this.i;
      this.o.setColor(this.n[i1]);
      paramCanvas.save();
      paramCanvas.drawCircle(i2 + i3 + (i4 + i5) * i1, this.b[i1], this.g, this.o);
      paramCanvas.restore();
      i1 += 1;
    }
  }

  public int getIntrinsicHeight()
  {
    return this.f;
  }

  public int getIntrinsicWidth()
  {
    return this.e;
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean isRunning()
  {
    return this.r;
  }

  public void run()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
      ((Animator)localIterator.next()).start();
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void start()
  {
    if (!this.r)
    {
      this.r = true;
      run();
    }
  }

  public void stop()
  {
    if (this.r)
    {
      this.r = false;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((Animator)localIterator.next()).end();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sk
 * JD-Core Version:    0.6.2
 */