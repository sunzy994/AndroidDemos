package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class eh
{
  static final em a = new ei();

  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      a = new el();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      a = new ek();
      return;
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      a = new ej();
      return;
    }
  }

  public static int a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }

  public static int a(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.a(paramMotionEvent, paramInt);
  }

  public static int b(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }

  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.b(paramMotionEvent, paramInt);
  }

  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.c(paramMotionEvent, paramInt);
  }

  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.d(paramMotionEvent, paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     eh
 * JD-Core Version:    0.6.2
 */