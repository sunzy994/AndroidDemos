package cmcm.com.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.lazyswipe.SettingsService;

public class vf extends Service
{
  private static final String a = "Swipe." + SettingsService.class.getSimpleName();
  private auq b;

  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("action.START_IMAGE_DOWNLOADER".equals(paramIntent.getAction())))
      return this.b;
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.b = new auq(this);
    this.b.a();
  }

  public void onDestroy()
  {
    this.b.b();
    super.onDestroy();
  }

  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }

  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.b.a(paramInt);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vf
 * JD-Core Version:    0.6.2
 */