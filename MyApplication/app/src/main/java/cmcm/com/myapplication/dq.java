package cmcm.com.myapplication;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class dq
{
  static final du a = new dr();

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new dt();
      return;
    }
  }

  public static boolean a(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent.getMetaState());
  }

  public static boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dq
 * JD-Core Version:    0.6.2
 */