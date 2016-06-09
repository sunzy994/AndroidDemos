package cmcm.com.myapplication;

import android.view.animation.Interpolator;

public class ye
  implements Interpolator
{
  private boolean a = false;

  public ye()
  {
    this(false);
  }

  public ye(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  private float a(float paramFloat)
  {
    return (3.1F * paramFloat * paramFloat - 6.9F * paramFloat + 4.8F) * paramFloat;
  }

  public float getInterpolation(float paramFloat)
  {
    if (!this.a)
      return a(paramFloat);
    return 1.0F - a(1.0F - paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ye
 * JD-Core Version:    0.6.2
 */