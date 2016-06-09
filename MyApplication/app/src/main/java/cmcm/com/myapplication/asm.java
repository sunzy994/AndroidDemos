package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Looper;

public abstract class asm
{
  private static final String a = "Swipe." + asm.class.getSimpleName();
  private final asn b = new asn(this, null);
  protected final Handler e = new Handler(Looper.getMainLooper());

  protected abstract long g();

  public abstract void h();

  protected void p()
  {
    if (g() > 0L)
    {
      this.e.removeCallbacks(this.b);
      this.e.postDelayed(this.b, g());
    }
  }

  protected void q()
  {
    this.e.removeCallbacks(this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asm
 * JD-Core Version:    0.6.2
 */