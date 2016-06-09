package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class is extends Drawable
  implements Animatable
{
  private static final Interpolator b = new LinearInterpolator();
  private static final Interpolator c = new ii();
  boolean a;
  private final int[] d = { -16777216 };
  private final ArrayList<Animation> e = new ArrayList();
  private final it f;
  private float g;
  private Resources h;
  private View i;
  private Animation j;
  private float k;
  private double l;
  private double m;
  private final Callback n = new Callback()
  {
    public void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      is.this.invalidateSelf();
    }

    public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      is.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }

    public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      is.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };

  public is(Context paramContext, View paramView)
  {
    this.i = paramView;
    this.h = paramContext.getResources();
    this.f = new it(this.n);
    this.f.a(this.d);
    a(1);
    b();
  }

  private float a(it paramit)
  {
    return (float)Math.toRadians(paramit.d() / (6.283185307179586D * paramit.j()));
  }

  private int a(float paramFloat, int paramInt1, int paramInt2)
  {
    int i3 = Integer.valueOf(paramInt1).intValue();
    paramInt1 = i3 >> 24 & 0xFF;
    int i1 = i3 >> 16 & 0xFF;
    int i2 = i3 >> 8 & 0xFF;
    i3 &= 255;
    paramInt2 = Integer.valueOf(paramInt2).intValue();
    int i4 = (int)(((paramInt2 >> 24 & 0xFF) - paramInt1) * paramFloat);
    int i5 = (int)(((paramInt2 >> 16 & 0xFF) - i1) * paramFloat);
    int i6 = (int)(((paramInt2 >> 8 & 0xFF) - i2) * paramFloat);
    return i3 + (int)(((paramInt2 & 0xFF) - i3) * paramFloat) | (paramInt1 + i4 << 24 | i1 + i5 << 16 | i6 + i2 << 8);
  }

  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    it localit = this.f;
    float f1 = this.h.getDisplayMetrics().density;
    this.l = (f1 * paramDouble1);
    this.m = (f1 * paramDouble2);
    localit.a((float)paramDouble4 * f1);
    localit.a(f1 * paramDouble3);
    localit.c(0);
    localit.a(paramFloat1 * f1, f1 * paramFloat2);
    localit.a((int)this.l, (int)this.m);
  }

  private void a(float paramFloat, it paramit)
  {
    if (paramFloat > 0.75F)
      paramit.b(a((paramFloat - 0.75F) / 0.25F, paramit.h(), paramit.a()));
  }

  private void b()
  {
    final it localit = this.f;
    Animation local1 = new Animation()
    {
      public void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        if (is.this.a)
        {
          is.a(is.this, paramAnonymousFloat, localit);
          return;
        }
        float f1 = is.a(is.this, localit);
        float f2 = localit.g();
        float f4 = localit.f();
        float f3 = localit.k();
        is.b(is.this, paramAnonymousFloat, localit);
        if (paramAnonymousFloat <= 0.5F)
        {
          float f5 = paramAnonymousFloat / 0.5F;
          f5 = is.a().getInterpolation(f5);
          localit.b(f4 + f5 * (0.8F - f1));
        }
        if (paramAnonymousFloat > 0.5F)
        {
          f4 = (paramAnonymousFloat - 0.5F) / 0.5F;
          f4 = is.a().getInterpolation(f4);
          localit.c((0.8F - f1) * f4 + f2);
        }
        localit.d(0.25F * paramAnonymousFloat + f3);
        f1 = is.a(is.this) / 5.0F;
        is.this.c(216.0F * paramAnonymousFloat + 1080.0F * f1);
      }
    };
    local1.setRepeatCount(-1);
    local1.setRepeatMode(1);
    local1.setInterpolator(b);
    local1.setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        localit.l();
        localit.b();
        localit.b(localit.i());
        if (is.this.a)
        {
          is.this.a = false;
          paramAnonymousAnimation.setDuration(1332L);
          localit.a(false);
          return;
        }
        is.a(is.this, (is.a(is.this) + 1.0F) % 5.0F);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        is.a(is.this, 0.0F);
      }
    });
    this.j = local1;
  }

  private void b(float paramFloat, it paramit)
  {
    a(paramFloat, paramit);
    float f1 = (float)(Math.floor(paramit.k() / 0.8F) + 1.0D);
    float f2 = a(paramit);
    float f3 = paramit.f();
    paramit.b((paramit.g() - f2 - paramit.f()) * paramFloat + f3);
    paramit.c(paramit.g());
    f2 = paramit.k();
    paramit.d((f1 - paramit.k()) * paramFloat + f2);
  }

  public void a(float paramFloat)
  {
    this.f.e(paramFloat);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.f.b(paramFloat1);
    this.f.c(paramFloat2);
  }

  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      a(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    }
    a(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }

  public void a(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
  }

  public void a(int[] paramArrayOfInt)
  {
    this.f.a(paramArrayOfInt);
    this.f.c(0);
  }

  public void b(float paramFloat)
  {
    this.f.d(paramFloat);
  }

  public void b(int paramInt)
  {
    this.f.a(paramInt);
  }

  void c(float paramFloat)
  {
    this.g = paramFloat;
    invalidateSelf();
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.g, localRect.exactCenterX(), localRect.exactCenterY());
    this.f.a(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }

  public int getAlpha()
  {
    return this.f.c();
  }

  public int getIntrinsicHeight()
  {
    return (int)this.m;
  }

  public int getIntrinsicWidth()
  {
    return (int)this.l;
  }

  public int getOpacity()
  {
    return -3;
  }

  public boolean isRunning()
  {
    ArrayList localArrayList = this.e;
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Animation localAnimation = (Animation)localArrayList.get(i1);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded()))
        return true;
      i1 += 1;
    }
    return false;
  }

  public void setAlpha(int paramInt)
  {
    this.f.d(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f.a(paramColorFilter);
  }

  public void start()
  {
    this.j.reset();
    this.f.l();
    if (this.f.i() != this.f.e())
    {
      this.a = true;
      this.j.setDuration(666L);
      this.i.startAnimation(this.j);
      return;
    }
    this.f.c(0);
    this.f.m();
    this.j.setDuration(1332L);
    this.i.startAnimation(this.j);
  }

  public void stop()
  {
    this.i.clearAnimation();
    c(0.0F);
    this.f.a(false);
    this.f.c(0);
    this.f.m();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     is
 * JD-Core Version:    0.6.2
 */