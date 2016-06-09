package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Looper;

public abstract class qt extends Handler
{
  private Runnable a = new Runnable()
  {
    public void run()
    {
      qt.this.b();
    }
  };

  public qt(Looper paramLooper)
  {
    super(paramLooper);
  }

  public void a()
  {
    removeCallbacks(this.a);
  }

  public void a(long paramLong)
  {
    postDelayed(this.a, paramLong);
  }

  public abstract void b();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qt
 * JD-Core Version:    0.6.2
 */