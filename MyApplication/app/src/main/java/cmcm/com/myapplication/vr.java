package cmcm.com.myapplication;

import android.os.FileObserver;
import java.io.File;

class vr extends FileObserver
{
  public vr(vp paramvp, File paramFile, int paramInt)
  {
    this(paramvp, paramFile.getAbsolutePath(), paramInt);
  }

  public vr(vp paramvp, String paramString, int paramInt)
  {
    super(paramString, paramInt);
    startWatching();
  }

  public void onEvent(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }

  public String toString()
  {
    return Integer.toHexString(hashCode());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vr
 * JD-Core Version:    0.6.2
 */