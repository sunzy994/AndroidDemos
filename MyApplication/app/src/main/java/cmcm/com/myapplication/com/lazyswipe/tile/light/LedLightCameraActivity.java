package cmcm.com.myapplication.com.lazyswipe.tile.light;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import asp;

public class LedLightCameraActivity extends Activity
  implements Callback
{
  public static SurfaceView a;
  private static LedLightCameraActivity b = null;
  private static boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private final Handler f = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
      }
      LedLightCameraActivity.a(LedLightCameraActivity.this);
    }
  };

  public static boolean a()
  {
    if (b != null)
    {
      b.d = true;
      b.d();
      return true;
    }
    return false;
  }

  public static void b()
  {
    c = true;
    if (b != null)
      b.d();
  }

  public static void c()
  {
    c = false;
  }

  private void d()
  {
    if (c)
      finish();
    if ((this.e) && (this.d))
      this.f.sendEmptyMessage(1);
  }

  private void e()
  {
    if (a != null)
    {
      a.getHolder().removeCallback(this);
      a = null;
    }
    moveTaskToBack(true);
    finish();
    b = null;
    a = null;
    aoj.a = true;
    c = false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setLayoutParams(new LayoutParams(-1, -1));
    setContentView((View)localObject);
    paramBundle = new FrameLayout(this);
    paramBundle.setLayoutParams(new LayoutParams(1, 1));
    ((LinearLayout)localObject).addView(paramBundle);
    if (a == null)
    {
      asp.c("Swipe.Light", "LedLightCameraActivity onCreate find mSurfaceView null");
      finish();
      return;
    }
    localObject = a.getHolder();
    if (localObject == null)
    {
      asp.c("Swipe.Light", "LedLightCameraActivity onCreate find holder null");
      finish();
      return;
    }
    ((SurfaceHolder)localObject).addCallback(this);
    paramBundle.addView(a, 0);
    if (c)
    {
      b = null;
      finish();
      return;
    }
    c = false;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    b = null;
    a = null;
    aoj.a = true;
    c = false;
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.e = true;
    d();
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.light.LedLightCameraActivity
 * JD-Core Version:    0.6.2
 */