package cmcm.com.myapplication.com.lazyswipe.tile;

import acw;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.Window;
import android.view.WindowManager;
import aqs;
import ari;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MirrorActivity extends Activity
  implements Callback
{
  private static final String a = "Swipe." + MirrorActivity.class.getSimpleName();
  private Camera b;
  private MirrorSurfaceView c;
  private SurfaceHolder d;
  private boolean e;

  private Size a(Parameters paramParameters)
  {
    Size localSize1 = paramParameters.getPreviewSize();
    paramParameters = paramParameters.getSupportedPreviewSizes();
    if (paramParameters == null)
      return localSize1;
    paramParameters = new ArrayList(paramParameters);
    Collections.sort(paramParameters, new Comparator()
    {
      public int a(Size paramAnonymousSize1, Size paramAnonymousSize2)
      {
        int i = paramAnonymousSize1.height * paramAnonymousSize1.width;
        int j = paramAnonymousSize2.height * paramAnonymousSize2.width;
        if (j < i)
          return -1;
        if (j > i)
          return 1;
        return 0;
      }
    });
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramParameters.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Size localSize2 = (Size)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localSize2.width).append('x').append(localSize2.height).append(' ');
    }
    double d1 = aqs.ac() / aqs.ad();
    localObject1 = paramParameters.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Size)((Iterator)localObject1).next();
      int i = ((Size)localObject2).width;
      int j = ((Size)localObject2).height;
      if (i * j < 153600)
      {
        ((Iterator)localObject1).remove();
      }
      else
      {
        int k;
        label194: int m;
        if (i > j)
        {
          k = 1;
          if (k == 0)
            break label243;
          m = j;
          label203: if (k == 0)
            break label250;
        }
        while (true)
        {
          if (Math.abs(m / i - d1) <= 0.15D)
            break label257;
          ((Iterator)localObject1).remove();
          break;
          k = 0;
          break label194;
          label243: m = i;
          break label203;
          label250: i = j;
        }
        label257: if ((m == aqs.ac()) && (i == aqs.ad()))
          return localObject2;
      }
    }
    if (!paramParameters.isEmpty())
      return (Size)paramParameters.get(0);
    return localSize1;
  }

  public static boolean a()
  {
    return c() > 0;
  }

  private void b()
  {
    getWindow().getAttributes().screenBrightness = 1.0F;
    getWindow().requestFeature(1);
    getWindow().addFlags(128);
  }

  private static int c()
  {
    try
    {
      int j = Camera.getNumberOfCameras();
      int i = 0;
      while (i < j)
      {
        CameraInfo localCameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, localCameraInfo);
        int k = localCameraInfo.facing;
        if (k == 1)
          return i;
        i += 1;
      }
    }
    catch (Exception localException)
    {
    }
    return -1;
  }

  private void d()
  {
    Parameters localParameters = this.b.getParameters();
    Size localSize = a(localParameters);
    localParameters.setPreviewSize(localSize.width, localSize.height);
    int k = ari.b(localSize.width, localSize.height);
    int i = ari.a(localSize.width, localSize.height);
    float f1 = i / k;
    float f2 = this.c.getHeight() / this.c.getWidth();
    int j;
    if ((k >= this.c.getWidth()) && (i >= this.c.getHeight()))
      j = k;
    while (true)
    {
      this.c.a(j, i);
      return;
      if (f1 > f2)
      {
        j = this.c.getWidth();
        f1 = j;
        i = (int)(i * f1 / k);
      }
      else
      {
        j = this.c.getHeight();
        f1 = j;
        k = (int)(k * f1 / i);
        i = j;
        j = k;
      }
    }
  }

  public void a(int paramInt)
  {
    int i = 0;
    while (true)
    {
      try
      {
        CameraInfo localCameraInfo = new CameraInfo();
        Camera.getCameraInfo(paramInt, localCameraInfo);
        paramInt = i;
        switch (getWindowManager().getDefaultDisplay().getRotation())
        {
        case 0:
          if (localCameraInfo.facing == 1)
          {
            paramInt = (360 - (paramInt + localCameraInfo.orientation) % 360) % 360;
            this.b.setDisplayOrientation(paramInt);
            return;
          }
          paramInt = (localCameraInfo.orientation - paramInt + 360) % 360;
          continue;
        default:
        case 1:
        case 2:
        case 3:
        }
      }
      catch (Exception localException)
      {
        this.b.setDisplayOrientation(90);
        return;
      }
      paramInt = i;
      continue;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!a())
    {
      finish();
      return;
    }
    b();
    setContentView(2130968579);
    this.c = ((MirrorSurfaceView)findViewById(2131755052));
    this.d = this.c.getHolder();
    this.d.setFormat(-3);
    this.d.addCallback(this);
    this.d.setKeepScreenOn(true);
    this.d.setType(3);
  }

  protected void onStart()
  {
    super.onStart();
    acw.i = true;
    acw.e(this, false);
  }

  protected void onStop()
  {
    super.onStop();
    acw.i = false;
    acw.c(this, false);
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.e)
        this.b.stopPreview();
      if (this.b != null)
      {
        d();
        this.b.startPreview();
        this.e = true;
      }
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
    }
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      int i = c();
      if (i <= 0)
        return;
      this.b = Camera.open(i);
      a(i);
      this.b.setPreviewDisplay(this.d);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      if (this.b != null)
      {
        this.b.release();
        this.b = null;
      }
    }
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.b != null)
    {
      this.b.setPreviewCallback(null);
      this.b.stopPreview();
      this.b.release();
      this.b = null;
      this.e = false;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.MirrorActivity
 * JD-Core Version:    0.6.2
 */