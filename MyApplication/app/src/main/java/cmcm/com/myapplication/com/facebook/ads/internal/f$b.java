package cmcm.com.myapplication.com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

final class f$b
  implements ServiceConnection
{
  private AtomicBoolean a = new AtomicBoolean(false);
  private final BlockingQueue<IBinder> b = new LinkedBlockingDeque();

  public IBinder a()
  {
    if (this.a.compareAndSet(true, true))
      throw new IllegalStateException("Binder already consumed");
    return (IBinder)this.b.take();
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.b.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName)
    {
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.f.b
 * JD-Core Version:    0.6.2
 */