package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.util.List;

final class ln
  implements ll
{
  ln(lm paramlm, String paramString, ls paramls, long paramLong, int paramInt)
  {
  }

  private void a(int paramInt)
  {
    nr.a(lm.a(this.e), lm.e(this.e), paramInt, SystemClock.elapsedRealtime() - this.c);
    mv.c("FbCache", "Refresh result: id = " + this.b.k() + "; code = " + paramInt);
    if (this.d > 0)
    {
      lm.f(this.e).obtainMessage(2, this.d - 1, 0).sendToTarget();
      return;
    }
    this.e.b = false;
    mv.c("FbCache", "Refresh result: DONE for geeen count");
  }

  public final void a()
  {
    mv.c("FbCache", "onAdLoaded: id=" + this.a);
    na.a(lm.a(this.e));
    na.b(lm.a(this.e));
    synchronized (lm.b(this.e))
    {
      lm.b(this.e).add(this.b);
      a(200);
      return;
    }
  }

  public final void a(int paramInt, String paramString)
  {
    mv.c("FbCache", "onError: code=" + paramInt + "; msg=" + paramString);
    this.e.a = true;
    a(paramInt);
  }

  public final void b()
  {
    if (lm.c(this.e) != null)
      lm.d(this.e).a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ln
 * JD-Core Version:    0.6.2
 */