package cmcm.com.myapplication.com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

public class MultiProcessFlag
{
  private static boolean a;
  private static boolean b;

  public static boolean isMultiProcess()
  {
    return a;
  }

  public static void setMultiProcess(boolean paramBoolean)
  {
    if (!b)
    {
      b = true;
      a = paramBoolean;
      return;
    }
    GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.ads.cfg.MultiProcessFlag
 * JD-Core Version:    0.6.2
 */