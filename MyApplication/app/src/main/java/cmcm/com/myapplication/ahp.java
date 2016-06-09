package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

class ahp extends aif
{
  private ahp(aho paramaho, Context paramContext, String paramString, aii paramaii)
  {
    super(paramContext, paramString, paramaii);
  }

  private void a(String paramString)
  {
    try
    {
      File localFile = new File(c().getAbsolutePath() + "/" + "res/drawable-hdpi", paramString);
      paramString = new File(this.a.E(), paramString);
      if ((!paramString.exists()) && (localFile.exists()))
        aqx.c(localFile, paramString);
      return;
    }
    catch (Exception paramString)
    {
    }
  }

  private boolean f()
  {
    Log.e(aho.h(), "initResFromZipFile()");
    File localFile = new File(c(), "omniswipe.zip");
    aqx.e(new File(this.a.E()));
    if (!localFile.exists())
    {
      Log.e(aho.h(), "Local ZipFile not found " + localFile);
      return false;
    }
    try
    {
      asu.a(localFile.getAbsolutePath(), this.a.E());
      boolean bool = this.a.z();
      if (!bool)
      {
        aqx.e(new File(this.a.E()));
        aqx.e(localFile);
      }
      Log.e(aho.h(), "initResFromZipFile, ok = " + bool);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e(aho.h(), "UnzipFolder error", localIOException);
      aqx.e(new File(this.a.E()));
      aqx.e(localFile);
    }
    return false;
  }

  protected boolean a()
  {
    if (!f())
      return false;
    a("icon_bg.png");
    a("icon_fg.png");
    a("icon_mask.png");
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahp
 * JD-Core Version:    0.6.2
 */