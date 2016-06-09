package cmcm.com.myapplication.com.lazyswipe;

import akf;
import android.content.Intent;
import android.os.IBinder;
import vf;

public class SettingsService extends vf
{
  private akf a;

  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    if ("action.START_WEATHER_SERVICE".equals(paramIntent.getAction()))
      return this.a;
    return super.onBind(paramIntent);
  }

  public void onCreate()
  {
    super.onCreate();
    this.a = new akf(this);
    this.a.h();
  }

  public void onDestroy()
  {
    this.a.i();
    super.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.a.a(paramIntent, paramInt1, paramInt2);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.a.a(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.SettingsService
 * JD-Core Version:    0.6.2
 */