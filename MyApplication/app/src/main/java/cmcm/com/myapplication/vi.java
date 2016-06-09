package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class vi
  implements Thread.UncaughtExceptionHandler
{
  protected final DateFormat a;
  protected final Context b;
  protected final String c;
  private final Thread.UncaughtExceptionHandler d;
  private final Map<String, String> e;

  public vi(Context paramContext, String paramString)
  {
    this.c = paramString;
    this.b = paramContext.getApplicationContext();
    this.a = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US);
    this.d = Thread.getDefaultUncaughtExceptionHandler();
    this.e = new LinkedHashMap();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  private void a(StringBuilder paramStringBuilder, File paramFile, String paramString)
  {
    aqx.a(new File(paramFile, paramString), paramStringBuilder.toString());
  }

  private void c()
  {
    try
    {
      this.e.put("[Product]", "");
      b();
      label18: this.e.put("[Device]", "");
      Field[] arrayOfField = Build.class.getFields();
      int j = arrayOfField.length;
      int i = 0;
      while (true)
      {
        Field localField;
        if (i < j)
          localField = arrayOfField[i];
        try
        {
          this.e.put(localField.getName(), localField.get(null).toString());
          label76: i += 1;
          continue;
          this.e.put("SDK", String.valueOf(VERSION.SDK_INT));
          return;
        }
        catch (Exception localException2)
        {
          break label76;
        }
      }
    }
    catch (Exception localException1)
    {
      break label18;
    }
  }

  public File a()
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject3 = new File(this.c);
    Object localObject1 = localObject3;
    if (!((File)localObject3).exists())
      localObject1 = this.b.getFilesDir();
    File[] arrayOfFile = ((File)localObject1).listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("crash-");
      }
    });
    localObject3 = localObject5;
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length > 0)
        break label67;
      localObject3 = localObject5;
    }
    label67: int j;
    long l;
    int i;
    Object localObject2;
    do
    {
      return localObject3;
      if (arrayOfFile.length == 1)
        return arrayOfFile[0];
      localObject1 = new Comparator()
      {
        public int a(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          return (int)(paramAnonymousFile2.lastModified() - paramAnonymousFile1.lastModified());
        }
      };
      try
      {
        Arrays.sort(arrayOfFile, (Comparator)localObject1);
        localObject1 = arrayOfFile[0];
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        j = arrayOfFile.length;
        l = 0L;
        i = 0;
        localObject2 = localObject4;
      }
      localObject3 = localObject2;
    }
    while (i >= j);
    localObject3 = arrayOfFile[i];
    if (((File)localObject3).lastModified() > l)
    {
      l = ((File)localObject3).lastModified();
      localObject2 = localObject3;
    }
    while (true)
    {
      i += 1;
      break;
    }
  }

  protected void a(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = this.e.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entry)((Iterator)localObject1).next();
      localStringBuilder.append((String)((Entry)localObject2).getKey()).append('=').append((String)((Entry)localObject2).getValue()).append("\n");
    }
    localStringBuilder.append("\n[Exception]\n");
    localObject1 = new StringWriter();
    Object localObject2 = new PrintWriter((Writer)localObject1);
    paramThrowable.printStackTrace((PrintWriter)localObject2);
    for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause())
      paramThrowable.printStackTrace((PrintWriter)localObject2);
    ((PrintWriter)localObject2).close();
    localStringBuilder.append(localObject1.toString());
    paramThrowable = "crash-" + this.a.format(new Date()) + ".txt";
    localObject1 = new File(this.c);
    if (((File)localObject1).exists())
    {
      a(localStringBuilder, (File)localObject1, paramThrowable);
      return;
    }
    a(localStringBuilder, this.b.getFilesDir(), paramThrowable);
  }

  public boolean a(Thread paramThread, Throwable paramThrowable)
  {
    c();
    a(paramThrowable);
    return false;
  }

  protected void b()
  {
    this.e.put("VersionName", "2.25");
    this.e.put("VersionCode", String.valueOf(22500));
    this.e.put("PackageName", "com.lazyswipe");
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!a(paramThread, paramThrowable))
    {
      asp.d();
      this.d.uncaughtException(paramThread, paramThrowable);
      return;
    }
    try
    {
      Thread.sleep(1500L);
      label30: Process.killProcess(Process.myPid());
      System.exit(-1);
      return;
    }
    catch (InterruptedException paramThread)
    {
      break label30;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vi
 * JD-Core Version:    0.6.2
 */