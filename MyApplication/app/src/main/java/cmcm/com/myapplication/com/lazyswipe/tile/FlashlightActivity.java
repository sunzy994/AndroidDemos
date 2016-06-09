package cmcm.com.myapplication.com.lazyswipe.tile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import aph;
import asq;

public class FlashlightActivity extends aph
  implements Callback
{
  private WakeLock i;
  private Handler j;

  private void h()
  {
    if (this.i == null)
    {
      this.i = ((PowerManager)getSystemService("power")).newWakeLock(6, getClass().getCanonicalName());
      this.i.acquire();
    }
  }

  private void i()
  {
    if ((this.i != null) && (this.i.isHeld()))
    {
      this.i.release();
      this.i = null;
    }
  }

  public void g()
  {
    this.j = new Handler(this);
    Object localObject = getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    ((Window)localObject).setFlags(128, 128);
    localObject = new FrameLayout(this);
    ((FrameLayout)localObject).setBackgroundColor(-1);
    ((FrameLayout)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setContentView((View)localObject);
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing())
      return true;
    switch (paramMessage.what)
    {
    default:
      return false;
    case 1:
    }
    if (!asq.a(getApplicationContext(), FlashlightActivity.class))
    {
      this.j.sendEmptyMessageDelayed(1, 200L);
      return true;
    }
    paramMessage = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramMessage.getAttributes();
    localLayoutParams.screenBrightness = 1.0F;
    paramMessage.setAttributes(localLayoutParams);
    return true;
  }

  public void onBackPressed()
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g();
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
    case 4:
    }
    while (true)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      finish();
    }
  }

  protected void onPause()
  {
    super.onPause();
    i();
  }

  protected void onResume()
  {
    super.onResume();
    h();
    this.j.sendEmptyMessageDelayed(1, 200L);
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.FlashlightActivity
 * JD-Core Version:    0.6.2
 */