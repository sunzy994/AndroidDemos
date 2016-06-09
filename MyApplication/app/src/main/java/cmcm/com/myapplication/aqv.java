package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;
import java.io.FileFilter;

public abstract class aqv
{
  protected String a;

  public int a()
  {
    return 1;
  }

  public boolean a(Context paramContext)
  {
    return true;
  }

  public abstract String b(Context paramContext);

  public abstract String c(Context paramContext);

  public void d(final Context paramContext)
  {
    paramContext = e(paramContext).getParentFile().listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return paramAnonymousFile.getName().startsWith(aqv.this.b(paramContext));
      }
    });
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        aqx.e(paramContext[i]);
        i += 1;
      }
    }
  }

  public File e(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("sdk", 0), b(paramContext) + "-" + a() + ".jar");
    if (!paramContext.getParentFile().exists())
      paramContext.getParentFile().mkdirs();
    return paramContext;
  }

  public File f(Context paramContext)
  {
    if (art.b())
      paramContext = new File(aro.c(), b(paramContext) + "-tmp");
    File localFile;
    do
    {
      return paramContext;
      localFile = new File(paramContext.getCacheDir(), b(paramContext) + "-tmp");
      paramContext = localFile;
    }
    while (localFile.getParentFile().exists());
    localFile.getParentFile().mkdirs();
    return localFile;
  }

  public boolean g(Context paramContext)
  {
    try
    {
      aqx.a(f(paramContext), e(paramContext));
      return true;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  protected String h(Context paramContext)
  {
    return b(paramContext) + "-" + a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqv
 * JD-Core Version:    0.6.2
 */