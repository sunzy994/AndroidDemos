package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.SwipeApplication;
import java.io.File;

public class afd extends atk
{
  public afd(atm paramatm, boolean paramBoolean)
  {
    super(paramatm, paramBoolean);
  }

  public static void a(Context paramContext, long paramLong)
  {
    arj.a(new Runnable() {
      public void run() {
        if (!arl.i(afd.this)) ;
        while ((!abd.e()) || (vs.c(afd.this, "slot_res_task_triggered", false)) || (yb.o()))
          return;
        new afd(new atl() {
          public boolean m_() {
            return new File(afd.e(), "slot_machine.png").exists();
          }
        }
                , false).d();
      }
    }
            , paramLong);
  }

  private static String g()
  {
    return aro.d() + "/files/slot_machine_res/";
  }

  public String a()
  {
    return aro.d() + "/files/slot_machine_res.zip";
  }

  public String b()
  {
    return g();
  }

  public String c()
  {
    return "http://res.lazyswipe.cn/picture/slot_machine_res.zip";
  }

  public void d()
  {
    super.d();
    vs.b(SwipeApplication.c(), "slot_res_task_triggered", true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afd
 * JD-Core Version:    0.6.2
 */