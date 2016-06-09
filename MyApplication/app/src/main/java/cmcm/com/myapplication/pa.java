package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class pa
{
  public static void a(Context paramContext, final boolean paramBoolean, final ot paramot)
  {
    b(paramContext, "analytics.jar", oy.d, oy.c, null, new ot()
    {
      public void a(Object paramAnonymousObject)
      {
        if (!((String)paramAnonymousObject).equals("LO"))
          oz.a(pa.this, "GC4", String.valueOf(oz.a(pa.this)));
        if ((!paramBoolean) && (!oz.c(pa.this)))
        {
          paramot.a(new Exception("Sdk only init on wifi network"));
          return;
        }
        pa.a(pa.this, "hola_loader.zip", oy.b, oy.a, "hola_loader", paramot);
      }

      public void a(Throwable paramAnonymousThrowable)
      {
        paramot.a(paramAnonymousThrowable);
      }
    });
  }

  private static void b(Context paramContext, String paramString1, final String paramString2, String paramString3, final String paramString4, final ot paramot)
  {
    try
    {
      File localFile = oy.a(paramContext, paramString1);
      if (paramString4 == null);
      for (paramString4 = null; b(localFile, paramString2); paramString4 = oy.a(paramContext, paramString4))
      {
        paramot.a("LO");
        return;
      }
      Object localObject1 = localFile.getParentFile();
      if (!((File)localObject1).exists())
        ((File)localObject1).mkdirs();
      localObject1 = paramContext.getPackageManager().getInstalledApplications(128).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ApplicationInfo)((Iterator)localObject1).next();
        try
        {
          localObject2 = oy.a(paramContext, ((ApplicationInfo)localObject2).packageName, paramString1);
          if (oz.c((File)localObject2).equals(paramString2))
          {
            oz.a((File)localObject2, localFile);
            oz.b(localFile, "644");
            if (paramString4 != null)
              b(localFile, paramString4);
            paramot.a("OP");
            return;
          }
        }
        catch (Throwable localThrowable)
        {
        }
      }
      new oo(paramContext, paramString3, localFile.getAbsolutePath(), 2, 0L, false, new oq()
      {
        private int e = 0;

        public void a(oo paramAnonymousoo, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramAnonymousInt1 == 5)
            try
            {
              oz.d(pa.this);
              if (!pa.a(pa.this, paramString2))
              {
                paramot.a(new Exception("file md5 not match"));
                return;
              }
              oz.b(pa.this, "644");
              if (paramString4 != null)
                pa.a(pa.this, paramString4);
              paramot.a("RM");
              return;
            }
            catch (Exception paramAnonymousoo)
            {
              paramot.a(new Exception(paramAnonymousoo));
              return;
            }
          if (paramAnonymousInt1 == 6)
            paramot.a(new Exception("download " + paramAnonymousString + " failed"));
        }

        public void a(oo paramAnonymousoo, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
        {
          if (this.e != paramAnonymousInt)
          {
            ow.a("dl", "url=" + paramAnonymousString + ", percent=" + paramAnonymousInt);
            this.e = paramAnonymousInt;
          }
        }
      }).c();
      return;
    }
    catch (Exception paramContext)
    {
      paramot.a(new Exception(paramContext));
    }
  }

  private static void b(File paramFile1, File paramFile2)
  {
    if (!paramFile2.exists())
      paramFile2.mkdirs();
    while (true)
    {
      pb.a(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
      return;
      ou.c(paramFile2);
      paramFile2.mkdirs();
    }
  }

  private static boolean b(File paramFile, String paramString)
  {
    try
    {
      paramString = paramString.toUpperCase();
      ow.a("LoaderInit", "checkFileMd5");
      ow.a("file", paramFile.getAbsolutePath());
      ow.a("md5_rm", paramString);
      if (!paramFile.exists())
        return false;
      paramFile = oz.c(paramFile).toUpperCase();
      ow.a("md5_lo", paramFile);
      boolean bool = paramString.equals(paramFile);
      if (bool)
        return true;
    }
    catch (Exception paramFile)
    {
      ow.a(paramFile);
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pa
 * JD-Core Version:    0.6.2
 */