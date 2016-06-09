package cmcm.com.myapplication;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import java.util.ArrayList;
import java.util.Collection;

final class aok
  implements AutoFocusCallback
{
  private static final Collection<String> a = new ArrayList(2);
  private boolean b;
  private final boolean c;
  private final Camera d;

  static
  {
    a.add("auto");
    a.add("macro");
  }

  aok(Context paramContext, Camera paramCamera)
  {
    this.d = paramCamera;
    paramContext = paramCamera.getParameters().getFocusMode();
    this.c = a.contains(paramContext);
    a();
  }

  void a()
  {
    try
    {
      if (this.c)
        this.b = true;
      try
      {
        this.d.autoFocus(this);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
          asp.a("Swipe.Light", "Unexpected exception while focusing", localRuntimeException);
      }
    }
    finally
    {
    }
  }

  void b()
  {
    try
    {
      if (this.c)
        this.b = false;
      try
      {
        this.d.cancelAutoFocus();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
          asp.a("Swipe.Light", "Unexpected exception while cancelling focusing", localRuntimeException);
      }
    }
    finally
    {
    }
  }

  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aok
 * JD-Core Version:    0.6.2
 */