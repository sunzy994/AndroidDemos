package cmcm.com.myapplication;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class aom extends aoi
  implements AutoFocusCallback, Callback
{
  private Camera a;
  private boolean b = false;
  private final Handler c = new Handler(this);

  public aom(Context paramContext)
  {
  }

  private void e()
  {
    if (this.a != null)
    {
      Parameters localParameters = this.a.getParameters();
      localParameters.setFlashMode("on");
      this.a.setParameters(localParameters);
      this.a.cancelAutoFocus();
      this.a.stopPreview();
      this.a.startPreview();
      localParameters.setFlashMode("on");
      this.a.setParameters(localParameters);
      this.c.sendEmptyMessageDelayed(1, 100L);
    }
  }

  private void f()
  {
    if (!this.b)
    {
      this.a = Camera.open();
      Parameters localParameters = this.a.getParameters();
      localParameters.setFlashMode("on");
      this.a.startPreview();
      this.a.stopPreview();
      this.a.setParameters(localParameters);
      this.a.startPreview();
      this.a.autoFocus(this);
      this.b = true;
    }
  }

  private void g()
  {
    if (!this.b)
    {
      this.a = Camera.open();
      Parameters localParameters = this.a.getParameters();
      localParameters.setFlashMode("on");
      this.a.cancelAutoFocus();
      this.a.startPreview();
      this.a.stopPreview();
      this.a.setParameters(localParameters);
      this.a.startPreview();
      this.a.autoFocus(this);
      this.c.sendEmptyMessageDelayed(0, 100L);
      this.b = true;
    }
  }

  public boolean a()
  {
    return true;
  }

  public boolean b()
  {
    return this.b;
  }

  public void c()
  {
    if (this.a != null)
    {
      if (aqs.r())
        e();
    }
    else
      return;
    this.a.release();
    this.a = null;
  }

  public void d()
  {
    if ((aqs.s()) || (aqs.x()) || (aqs.i()))
    {
      f();
      return;
    }
    g();
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return true;
      if (this.a != null)
      {
        paramMessage = this.a.getParameters();
        paramMessage.setFlashMode("off");
        this.a.setParameters(paramMessage);
        continue;
        this.a.autoFocus(this);
        paramMessage = this.a.getParameters();
        paramMessage.setFlashMode("on");
        this.a.setParameters(paramMessage);
        this.a.stopPreview();
        this.a.release();
        this.a = null;
        this.b = false;
      }
    }
  }

  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if ((paramCamera != null) && (this.b) && ((aqs.q()) || (aqs.r())))
      paramCamera.autoFocus(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aom
 * JD-Core Version:    0.6.2
 */