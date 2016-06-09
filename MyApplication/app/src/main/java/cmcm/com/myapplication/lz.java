package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.duapps.ad.b.a;

public final class lz
  implements Runnable
{
  public a a;
  public lv b;
  public mi c;
  private Context d;
  private mc e;
  private volatile boolean f = false;
  private String g;
  private Handler h = new ma(this, Looper.getMainLooper());

  public lz(Context paramContext, mi parammi, a parama, lv paramlv, mc parammc)
  {
    this.d = paramContext;
    this.c = parammi;
    this.a = parama;
    this.b = paramlv;
    if (parammi != null)
      parammi.c = false;
    this.e = parammc;
  }

  private void a(String paramString)
  {
    if (!np.b(this.d))
    {
      this.f = false;
      if (this.c != null)
        this.c.c = false;
      return;
    }
    this.f = true;
    this.g = paramString;
    this.h.sendEmptyMessage(100);
  }

  public final void run()
  {
    int i = 1;
    mv.c("InMobiDataExecutor", " started");
    if (this.f);
    while (true)
    {
      return;
      this.f = true;
      if ((this.b == lv.a) && (!this.a.r));
      while (i != 0)
      {
        a(this.a.a(this.b));
        return;
        if ((this.b == lv.b) && (!this.a.s))
        {
          if (!this.a.r)
            a(this.a.b());
        }
        else
          i = 0;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lz
 * JD-Core Version:    0.6.2
 */