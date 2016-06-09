package cmcm.com.myapplication;

import android.view.KeyEvent;

class dv
{
  public static int a(int paramInt)
  {
    return KeyEvent.normalizeMetaState(paramInt);
  }

  public static boolean a(int paramInt1, int paramInt2)
  {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }

  public static boolean b(int paramInt)
  {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.6.2
 */