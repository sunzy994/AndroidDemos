package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public final class abs
  implements Runnable
{
  private final aar a;
  private final boolean b;

  abs(aar paramaar, boolean paramBoolean)
  {
    this.a = paramaar;
    this.b = paramBoolean;
  }

  private String a(Context paramContext)
  {
    int i = 1;
    while (true)
    {
      File[] arrayOfFile;
      try
      {
        arrayOfFile = paramContext.getFilesDir().listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return aqx.a(paramAnonymousString).startsWith(".hola_ap_config");
          }
        });
        if (arrayOfFile.length <= 0)
          return null;
        if (arrayOfFile.length == 1)
        {
          break label152;
          paramContext = aqx.i((File) localObject);
          asp.a(abd.f, "Configuration from previous version used");
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        return null;
      }
      try
      {
        Arrays.sort(arrayOfFile, new Comparator()
        {
          public int a(File paramAnonymousFile1, File paramAnonymousFile2)
          {
            return (int)(paramAnonymousFile2.lastModified() - paramAnonymousFile1.lastModified());
          }
        });
      }
      catch (Throwable paramContext)
      {
        i = 0;
      }
      label152: 
      while (i == 0)
      {
        int m = arrayOfFile.length;
        int j = 0;
        i = 0;
        paramContext = null;
        localObject = paramContext;
        if (j >= m)
          break;
        localObject = arrayOfFile[j];
        String str = aqx.a((File) localObject);
        int k = asi.a(str.substring(str.indexOf('-') + 1), 0);
        if (k > i)
        {
          paramContext = (Context)localObject;
          i = k;
        }
        while (true)
        {
          j += 1;
          break;
        }
      }
      Object localObject = arrayOfFile[0];
    }
  }

  private String a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    int k = 0;
    if ((!paramBoolean) || ((this.b) && (System.currentTimeMillis() - paramFile.lastModified() > 7200000L)))
    {
      asp.a(abd.f, "Refreshing app configuration data...");
      Object localObject = Locale.US;
      int i;
      if (asq.c(paramContext, "com.android.vending"))
      {
        i = 1;
        if (!asq.c(paramContext, "com.google.android.gms"))
          break label218;
      }
      label218: for (int j = 1; ; j = 0)
      {
        if (asq.c(paramContext, "com.facebook.katana"))
          k = 1;
        localObject = ard.a(paramContext, String.format((Locale) localObject, "http://i.haloapps.com/adscfg?a=%1$s&v=%2$d&s=%3$s&gp=%4$d&gs=%5$d&fb=%6$d&uid=%7$s&hash=%8$s", new Object[]{"300105", Integer.valueOf(22500), "26100", Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), asi.b(vs.u(paramContext)), this.a.x}), 300000, 300000);
        if (arr.a != ((arq)localObject).a)
          break label224;
        localObject = ((arq)localObject).c;
        if (!aqx.a(paramFile, (String) localObject, true))
          aqx.a(paramFile, (String) localObject);
        if (!paramBoolean)
          b(paramContext);
        return localObject;
        i = 0;
        break;
      }
      label224: asp.b(abd.f, "Could not fetch configuration: " + ((arq) localObject).b);
      if (paramBoolean)
        aqx.b(paramFile, true);
    }
    return null;
  }

  private void b(final Context paramContext)
  {
    arj.a(new Runnable() {
      public void run() {
        try {
          File[] arrayOfFile = paramContext.getFilesDir().listFiles();
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j) {
            File localFile = arrayOfFile[i];
            String str = aqx.a(localFile);
            if ((str.startsWith(".hola_ap_config")) && (!str.endsWith("_22500")))
              localFile.delete();
            i += 1;
          }
        } catch (Throwable localThrowable) {
        }
      }
    }
            , 30000L);
  }

  public void run()
  {
    int i;
    if (!abd.l)
      i = 1;
    while (true)
    {
      abd.l = false;
      SwipeApplication localSwipeApplication = SwipeApplication.c();
      if ((i != 0) && (!vg.j));
      try
      {
        long l;
        if (vg.i)
        {
          l = 3000L;
          label39: Thread.sleep(l);
        }
        try
        {
          label44: File localFile = new File(localSwipeApplication.getFilesDir(), ".hola_ap_config_22500");
          boolean bool = localFile.exists();
          String str = a(localSwipeApplication, localFile, bool);
          if (i != 0)
            if (!TextUtils.isEmpty(str))
              label85: this.a.a(localSwipeApplication, str);
          while (true)
          {
            abd.l = true;
            if (vg.j)
              abd.a(localSwipeApplication);
            abj.a(localSwipeApplication);
            return;
            i = 0;
            break;
            l = 9000L;
            break label39;
            if (bool)
            {
              str = aqx.i(localFile);
              break label85;
            }
            asp.b(abd.f, "Neither configuration nor file exists!");
            str = a(localSwipeApplication);
            break label85;
            if (!TextUtils.isEmpty(str))
              this.a.a(localSwipeApplication, str);
          }
        }
        catch (Throwable localThrowable1)
        {
          while (true)
          {
            asp.a(abd.f, "Could not init configuration", localThrowable1);
            this.a.a(localSwipeApplication, null);
            abd.l = true;
          }
        }
        finally
        {
          abd.l = true;
        }
      }
      catch (Throwable localThrowable2)
      {
        break label44;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abs
 * JD-Core Version:    0.6.2
 */