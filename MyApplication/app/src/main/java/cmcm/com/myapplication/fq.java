package cmcm.com.myapplication;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class fq
{
  public static float a(View paramView)
  {
    return paramView.getAlpha();
  }

  static long a()
  {
    return ValueAnimator.getFrameDelay();
  }

  public static void a(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }

  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(paramBoolean);
  }

  public static int b(View paramView)
  {
    return paramView.getLayerType();
  }

  public static void b(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }

  public static float c(View paramView)
  {
    return paramView.getTranslationX();
  }

  public static void c(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }

  public static float d(View paramView)
  {
    return paramView.getTranslationY();
  }

  public static void d(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }

  public static float e(View paramView)
  {
    return paramView.getScaleX();
  }

  public static void e(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     fq
 * JD-Core Version:    0.6.2
 */