package cmcm.com.myapplication;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.lazyswipe.features.guide.NewGuide;

public final class yd
{
  private static int a = 3;

  public static int a()
  {
    if (NewGuide.i())
      return 170;
    return 60;
  }

  private static Animation a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean);
    for (float f = 0.0F; ; f = 1.0F)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, f, 1, 1.0F);
      localScaleAnimation.setDuration(paramInt1);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setStartOffset(paramInt2);
      return localScaleAnimation;
    }
  }

  private static Animation a(float paramFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(paramFloat, 1.0F, paramInt1, paramInt2, paramBoolean);
  }

  private static Animation a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(1.0F, 0.0F, paramInt2, a() * 2 + paramInt1, paramBoolean);
  }

  public static Animation a(int paramInt, yl paramyl1, yl paramyl2)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(a());
    localAlphaAnimation.setStartOffset(a() * 2);
    localAnimationSet.addAnimation(localAlphaAnimation);
    int i = paramyl2.a;
    int j = paramyl1.a;
    int k = paramyl2.b;
    int m = paramyl1.b;
    paramyl1 = new TranslateAnimation(0.0F, i - j, 0.0F, -(k - m));
    paramyl1.setDuration(a() * 3);
    paramyl1.setInterpolator(new ye(true));
    localAnimationSet.addAnimation(paramyl1);
    localAnimationSet.setStartOffset(b() * paramInt);
    return localAnimationSet;
  }

  public static Animation a(int paramInt, yl paramyl1, yl paramyl2, boolean paramBoolean)
  {
    long l2 = 0L;
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(a(b(), false));
    float f1 = paramyl2.a - paramyl1.a;
    float f2 = paramyl2.b - paramyl1.b;
    paramyl1 = new TranslateAnimation(-f1, 0.0F, f2, 0.0F);
    if (paramBoolean)
    {
      l1 = 0L;
      paramyl1.setDuration(l1);
      paramyl1.setInterpolator(new ye());
      localAnimationSet.addAnimation(paramyl1);
      if (!paramBoolean)
        break label129;
    }
    label129: for (long l1 = l2; ; l1 = a() * 2 + b() * paramInt)
    {
      localAnimationSet.setStartOffset(l1);
      return localAnimationSet;
      l1 = a() * 4;
      break;
    }
  }

  public static Animation a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean);
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F); ; localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F))
    {
      localAlphaAnimation.setDuration(paramInt);
      return localAlphaAnimation;
    }
  }

  public static Animation a(boolean paramBoolean)
  {
    return a(0.0F, a() * 4, 0, paramBoolean);
  }

  public static void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0)
      i = 1;
    a = i;
  }

  public static int b()
  {
    return a() / 10;
  }

  private static Animation b(int paramInt, boolean paramBoolean)
  {
    return a(paramInt, a(), paramBoolean);
  }

  public static Animation b(boolean paramBoolean)
  {
    return a(0.0F, a() * 2, 0, paramBoolean);
  }

  public static Animation c()
  {
    Animation localAnimation = e(false);
    localAnimation.setFillAfter(true);
    return localAnimation;
  }

  public static Animation c(boolean paramBoolean)
  {
    return a(0, a() * 2, paramBoolean);
  }

  public static Animation d()
  {
    Animation localAnimation = e(true);
    localAnimation.setStartOffset(a() * 4);
    localAnimation.setFillAfter(true);
    return localAnimation;
  }

  public static Animation d(boolean paramBoolean)
  {
    return b(a(), paramBoolean);
  }

  public static Animation e(boolean paramBoolean)
  {
    return a(a(), paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yd
 * JD-Core Version:    0.6.2
 */