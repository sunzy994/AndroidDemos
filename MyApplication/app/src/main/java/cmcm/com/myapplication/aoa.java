package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.lazyswipe.features.boostplus.BoostActivity;
import com.lazyswipe.features.cleaner.CleaningView;

public abstract class aoa
{
  public static int a;
  private static final String b = "Swipe." + aoa.class.getSimpleName();
  private static long c;
  private static long d = -1L;
  private static boolean e = false;

  protected static boolean a()
  {
    switch (a)
    {
    default:
      return false;
    case 0:
      return aoe.b();
    case 1:
    }
    return CleaningView.a();
  }

  public static boolean a(Context paramContext, int paramInt, aob paramaob)
  {
    a = paramInt;
    amk.c(paramContext, false);
    if (a())
      return false;
    d = System.currentTimeMillis();
    b(paramContext);
    aaq.b().a(paramContext);
    paramaob.a(d);
    c = aqr.c(paramContext);
    asj.a(d);
    return false;
  }

  private static void b(Context paramContext)
  {
    boolean bool2 = false;
    long l1 = vs.a(paramContext, "boost_time_1", -1L);
    long l2 = vs.a(paramContext, "boost_time_2", -1L);
    long l3 = System.currentTimeMillis();
    if (!BoostActivity.g())
      e = false;
    do
    {
      return;
      if (amk.a(paramContext))
      {
        e = false;
        return;
      }
      boolean bool1 = bool2;
      if (l3 - l1 < 2100000L)
      {
        bool1 = bool2;
        if (l3 - l2 < 2100000L)
          bool1 = true;
      }
      e = bool1;
      vs.b(paramContext, "boost_time_2", l3);
    }
    while (l2 <= 0L);
    vs.b(paramContext, "boost_time_1", l2);
  }

  private static View c(Context paramContext)
  {
    vy.b(paramContext, "B31");
    vw.a(paramContext, "B31");
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramContext).inflate(2130968617, null);
    localViewGroup.setMinimumWidth(Math.min(Math.min(vj.e, vj.f) * 5 / 6, asq.a(300.0F)));
    localViewGroup.setOnClickListener(new OnClickListener()
    {
      // ERROR //
      public void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: invokestatic 30	yb:p	()V
        //   3: invokestatic 36	com/lazyswipe/view/FloatTip:d	()Z
        //   6: pop
        //   7: new 38	android/content/Intent
        //   10: dup
        //   11: aload_0
        //   12: getfield 17	aoa$1:a	Landroid/content/Context;
        //   15: ldc 40
        //   17: invokespecial 43	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   20: astore_1
        //   21: aload_1
        //   22: ldc 44
        //   24: invokevirtual 48	android/content/Intent:addFlags	(I)Landroid/content/Intent;
        //   27: pop
        //   28: aload_0
        //   29: getfield 17	aoa$1:a	Landroid/content/Context;
        //   32: aload_1
        //   33: invokestatic 53	asq:d	(Landroid/content/Context;Landroid/content/Intent;)Z
        //   36: pop
        //   37: aload_0
        //   38: getfield 17	aoa$1:a	Landroid/content/Context;
        //   41: ldc 55
        //   43: invokestatic 61	vy:b	(Landroid/content/Context;Ljava/lang/String;)V
        //   46: aload_0
        //   47: getfield 17	aoa$1:a	Landroid/content/Context;
        //   50: ldc 55
        //   52: invokestatic 65	vw:a	(Landroid/content/Context;Ljava/lang/String;)V
        //   55: return
        //   56: astore_1
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: return
        //
        // Exception table:
        //   from	to	target	type
        //   0	55	56	finally
        //   0	55	59	java/lang/Exception
      }
    });
    return localViewGroup;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoa
 * JD-Core Version:    0.6.2
 */