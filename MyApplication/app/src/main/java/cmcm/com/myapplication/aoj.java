package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.lazyswipe.tile.light.LedLightCameraActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class aoj extends aoi
  implements PreviewCallback, Callback
{
  public static boolean a = false;
  private Camera b;
  private boolean c = false;
  private SurfaceView d;
  private FrameLayout e;
  private Size f;
  private int g = 0;
  private String h;
  private String i;
  private String j;
  private final Context k;
  private aok l;

  public aoj(Context paramContext)
  {
    this.k = paramContext;
  }

  private boolean f()
  {
    if (this.b == null)
      return false;
    this.b.setPreviewCallback(this);
    Parameters localParameters = this.b.getParameters();
    if (this.g > 0)
      localParameters.setPreviewFrameRate(this.g);
    localParameters.setPreviewSize(this.f.width, this.f.height);
    localParameters.setFlashMode(this.j);
    localParameters.setFocusMode("infinity");
    try
    {
      this.b.setParameters(localParameters);
      this.b.startPreview();
      this.l = new aok(this.k, this.b);
      if (g())
        h();
      return true;
    }
    catch (Exception localException2)
    {
      while (true)
      {
        asp.c("Swipe.Light", "Failed to set camera parameters [flash mode=" + this.j + ",focus mode=" + "infinity" + ",preview size=" + this.f.width + "*" + this.f.height + "]. " + "Try again with focus mode " + this.h);
        localParameters.setFocusMode(this.h);
        try
        {
          this.b.setParameters(localParameters);
        }
        catch (Exception localException1)
        {
          asp.c("Swipe.Light", "Failed to set camera parameters again");
        }
      }
    }
  }

  private boolean g()
  {
    return !aqs.j();
  }

  private void h()
  {
    this.d = new SurfaceView(this.k);
    this.d.setBackgroundColor(0);
    this.d.getHolder().setType(3);
    this.d.getHolder().setSizeFromLayout();
    this.d.getHolder().addCallback(this);
    LedLightCameraActivity.c();
    LedLightCameraActivity.a = this.d;
    Intent localIntent = new Intent(this.k, LedLightCameraActivity.class);
    localIntent.addFlags(1048576);
    localIntent.addFlags(268435456);
    this.k.startActivity(localIntent);
  }

  private void i()
  {
    if (this.d == null)
      return;
    if (this.e != null)
      this.e.removeView(this.d);
    this.d.getHolder().removeCallback(this);
    this.d = null;
  }

  private boolean j()
  {
    return false;
  }

  public void a(FrameLayout paramFrameLayout)
  {
    i();
    this.e = paramFrameLayout;
  }

  public boolean a()
  {
    label358: label361: 
    while (true)
      try
      {
        if (j())
          return false;
        this.b = Camera.open();
        if (this.b == null)
        {
          asp.c("Swipe.Light", "light camera is not available cannot get a camera");
          return false;
        }
        Object localObject = this.b.getParameters();
        List localList = ((Parameters)localObject).getSupportedFlashModes();
        if (localList == null)
          return false;
        this.j = ((String) asq.a(localList, new String[]{"torch", "on"}));
        localList.clear();
        if (this.j == null)
        {
          this.b.release();
          this.b = null;
          asp.c("Swipe.Light", "light camera is not available have no led");
          return false;
        }
        this.i = ((Parameters)localObject).getFlashMode();
        ((Parameters)localObject).setFlashMode(this.j);
        this.h = ((Parameters)localObject).getFocusMode();
        this.g = ((Parameters)localObject).getPreviewFrameRate();
        localList = ((Parameters)localObject).getSupportedPreviewFrameRates();
        if (localList == null)
        {
          asp.c("Swipe.Light", "light camera is not available have no frameRates");
          this.b.release();
          this.b = null;
          return false;
        }
        localList.clear();
        localList = ((Parameters)localObject).getSupportedPreviewSizes();
        if (localList == null)
        {
          asp.b("Swipe.Light", "getSupportedPreviewSizes returned NULL!");
          localList = ((Parameters)localObject).getSupportedPictureSizes();
          if (localList == null)
          {
            asp.b("Swipe.Light", "getSupportedPictureSizes returned NULL!");
            this.b.release();
            this.b = null;
            return false;
          }
          this.f = ((Parameters)localObject).getPictureSize();
          int m = this.f.height;
          localObject = localList.iterator();
          if (((Iterator)localObject).hasNext())
          {
            Size localSize = (Size)((Iterator)localObject).next();
            if (localSize.height >= m)
              break label358;
            this.f = localSize;
            m = this.f.height;
            break label361;
          }
        }
        else
        {
          this.f = ((Parameters)localObject).getPreviewSize();
          continue;
        }
        localList.clear();
        a = false;
        this.b.setPreviewCallback(this);
        return true;
      }
      catch (Exception localException)
      {
        asp.b("Swipe.Light", "light camera is not available with: ", localException);
        if (this.b != null)
        {
          this.b.release();
          this.b = null;
        }
        return false;
      }
  }

  public boolean b()
  {
    return this.c;
  }

  public void c()
  {
    if ((this.c) && (!aqs.u()))
      e();
    if (this.d != null)
      i();
    LedLightCameraActivity.b();
    if (this.b != null)
      this.b.setPreviewCallback(null);
    try
    {
      this.b.setPreviewDisplay(null);
      this.b.release();
      this.b = null;
      this.d = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        asp.b("Swipe.Light", "mCamera setPreviewDisplay exception", localIOException);
        this.b.release();
        this.b = null;
      }
    }
    finally
    {
      this.b.release();
      this.b = null;
    }
  }

  public void d()
  {
    if (!this.c)
      this.c = f();
  }

  public void e()
  {
    if (this.c);
    try
    {
      Parameters localParameters = this.b.getParameters();
      localParameters.setFlashMode(this.i);
      this.b.setParameters(localParameters);
      label31: if (this.l != null)
      {
        this.l.b();
        this.l = null;
      }
      this.b.stopPreview();
      this.c = false;
      a = false;
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }

  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (LedLightCameraActivity.a())
      this.b.setPreviewCallback(null);
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.b.setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      asp.b("Swipe.Light", "mCamera setPreviewDisplay exception", paramSurfaceHolder);
    }
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoj
 * JD-Core Version:    0.6.2
 */