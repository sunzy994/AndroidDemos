package cmcm.com.myapplication.com.lazyswipe.tile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import aph;
import com.lazyswipe.SwipeService;

public class BrightnessTileActivity extends aph
  implements Callback
{
  private static final String i = "Swipe." + BrightnessTileActivity.class.getSimpleName();
  private Handler j;

  public void a(int paramInt)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramInt < 0);
    for (float f = -1.0F; ; f = paramInt / 255.0F)
    {
      localLayoutParams.screenBrightness = f;
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    finish();
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = new Handler(this);
    try
    {
      if (SwipeService.i().j())
      {
        Log.i(i, "Start with a fullscreen theme");
        setTheme(16973841);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.j.removeMessages(0);
  }

  protected void onResume()
  {
    super.onResume();
    this.j.sendEmptyMessageDelayed(0, 400L);
    Bundle localBundle = getIntent().getExtras();
    int k = localBundle.getInt("mode");
    int m = localBundle.getInt("value");
    boolean bool = localBundle.getBoolean("set_value_of_automode");
    Settings.System.putInt(getContentResolver(), "screen_brightness_mode", k);
    if (k != 1)
    {
      Settings.System.putInt(getContentResolver(), "screen_brightness", m);
      a(m);
    }
    while (true)
    {
      sendBroadcast(new Intent("com.lazyswipe.action.BRIGHTNESS_CHANGED"));
      return;
      if (bool)
      {
        Settings.System.putInt(getContentResolver(), "screen_brightness", m);
        a(m);
      }
      else
      {
        a(-1);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.BrightnessTileActivity
 * JD-Core Version:    0.6.2
 */