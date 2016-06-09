package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

public abstract interface SVSD
{
  public abstract IBinder onBind(Intent paramIntent);

  public abstract void onConfigurationChanged(Configuration paramConfiguration);

  public abstract void onCreate();

  public abstract void onDestroy();

  public abstract void onLowMemory();

  public abstract void onRebind(Intent paramIntent);

  public abstract int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);

  public abstract void onTaskRemoved(Intent paramIntent);

  public abstract void onTrimMemory(int paramInt);

  public abstract boolean onUnbind(Intent paramIntent);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.SVSD
 * JD-Core Version:    0.6.2
 */