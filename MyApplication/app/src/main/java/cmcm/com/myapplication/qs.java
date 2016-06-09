package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class qs
{
  private static final String a = qs.class.getSimpleName();

  public static int a(float paramFloat1, float paramFloat2)
  {
    return Math.round(paramFloat2 * paramFloat1);
  }

  public static int a(Context paramContext, float paramFloat)
  {
    return a(paramContext.getResources().getDisplayMetrics().density, paramFloat);
  }

  public static int a(Resources paramResources, float paramFloat)
  {
    return a(paramResources.getDisplayMetrics(), paramFloat);
  }

  public static int a(DisplayMetrics paramDisplayMetrics, float paramFloat)
  {
    return a(paramDisplayMetrics.density, paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qs
 * JD-Core Version:    0.6.2
 */