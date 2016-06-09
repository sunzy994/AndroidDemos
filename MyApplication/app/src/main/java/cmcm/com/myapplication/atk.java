package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.io.IOException;

public abstract class atk
  implements Callback
{
  private static final String a = "Swipe." + atk.class.getSimpleName();
  private Handler b;
  private atm c;
  private boolean d;

  public atk(atm paramatm, boolean paramBoolean)
  {
    if (paramatm == null)
      throw new IllegalArgumentException("callback should not be null");
    this.b = new Handler(Looper.getMainLooper(), this);
    this.c = paramatm;
    this.d = paramBoolean;
  }

  // ERROR //
  public static Bitmap a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 74	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: aload_2
    //   14: iconst_0
    //   15: sipush 480
    //   18: invokestatic 82	atw:a	(Ljava/io/InputStream;ZI)Landroid/graphics/Bitmap;
    //   21: astore_3
    //   22: aload_2
    //   23: astore_1
    //   24: aload_3
    //   25: invokestatic 85	atw:b	(Landroid/graphics/Bitmap;)Z
    //   28: istore 4
    //   30: iload 4
    //   32: ifeq +9 -> 41
    //   35: aload_2
    //   36: invokestatic 90	arf:a	(Ljava/io/Closeable;)V
    //   39: aload_3
    //   40: areturn
    //   41: aload_2
    //   42: astore_1
    //   43: new 92	java/lang/RuntimeException
    //   46: dup
    //   47: new 20	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   54: ldc 94
    //   56: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: astore_1
    //   71: aload_2
    //   72: astore_1
    //   73: new 70	java/lang/OutOfMemoryError
    //   76: dup
    //   77: new 20	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   84: ldc 94
    //   86: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 99	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: astore_0
    //   101: aload_1
    //   102: invokestatic 90	arf:a	(Ljava/io/Closeable;)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_1
    //   110: new 92	java/lang/RuntimeException
    //   113: dup
    //   114: new 20	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   121: ldc 94
    //   123: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore_0
    //   138: goto -37 -> 101
    //   141: astore_1
    //   142: aload_2
    //   143: astore_1
    //   144: goto -34 -> 110
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -77 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   13	22	70	java/lang/OutOfMemoryError
    //   24	30	70	java/lang/OutOfMemoryError
    //   43	70	70	java/lang/OutOfMemoryError
    //   13	22	100	finally
    //   24	30	100	finally
    //   43	70	100	finally
    //   73	100	100	finally
    //   110	137	100	finally
    //   2	11	107	java/lang/Exception
    //   2	11	137	finally
    //   13	22	141	java/lang/Exception
    //   24	30	141	java/lang/Exception
    //   43	70	141	java/lang/Exception
    //   2	11	147	java/lang/OutOfMemoryError
  }

  public static Bitmap a(String paramString1, String paramString2)
  {
    return a(new File(paramString1, paramString2 + ".png"));
  }

  private void e()
  {
    Log.i(a, "onResourceSucceed()");
    aqx.b(a());
    this.b.sendEmptyMessage(1);
  }

  private void g()
  {
    Log.i(a, "onResourceFailed()");
    this.b.sendEmptyMessage(2);
  }

  private boolean h()
  {
    Log.i(a, "initResFromUnzipFolder()" + this.c);
    File localFile = new File(b());
    if (!localFile.exists())
    {
      Log.e(a, "Local UnzipFolder not found");
      return false;
    }
    try
    {
      this.c.a(localFile);
      boolean bool = this.c.m_();
      if (!bool)
        aqx.e(localFile);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e(a, "initResHolderFromUnzipFolder error", localException);
      aqx.e(localFile);
    }
    return false;
  }

  private boolean i()
  {
    Log.e(a, "initResFromZipFile()");
    File localFile = new File(a());
    aqx.e(new File(b()));
    if (!localFile.exists())
    {
      Log.e(a, "Local ZipFile not found " + localFile);
      return false;
    }
    try
    {
      asu.a(localFile.getAbsolutePath(), b());
      if ((h()) && (this.c.m_()));
      for (boolean bool = true; ; bool = false)
      {
        if (!bool)
        {
          aqx.e(new File(b()));
          aqx.e(localFile);
        }
        return bool;
      }
    }
    catch (IOException localIOException)
    {
      Log.e(a, "UnzipFolder error", localIOException);
      aqx.e(new File(b()));
      aqx.e(localFile);
    }
    return false;
  }

  private boolean j()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    this.b.sendEmptyMessage(3);
    if (!arl.i(localSwipeApplication))
      return false;
    aqx.e(new File(a()));
    boolean bool2 = atn.a(localSwipeApplication, new ato(new File(a()), c(), false));
    boolean bool1 = bool2;
    if (bool2)
      bool1 = i();
    this.b.sendEmptyMessage(4);
    this.c.q_();
    return bool1;
  }

  public Bitmap a(String paramString)
  {
    return a(b(), paramString);
  }

  public abstract String a();

  public abstract String b();

  public abstract String c();

  public void d()
  {
    Log.i(a, "start().");
    if (this.c.m_())
    {
      Log.i(a, "start(). isResourceDone(), super.start()");
      this.c.n_();
      aqx.b(a());
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        if (atk.a(atk.this));
        for (int i = -2; ; i = 10)
        {
          Process.setThreadPriority(i);
          atk.this.f();
          return;
        }
      }
    }).start();
  }

  public boolean f()
  {
    Log.i(a, "prepareResource()");
    if (h())
    {
      Log.i(a, "initResFromUnzipFolder success()");
      e();
      return true;
    }
    if (i())
    {
      Log.i(a, "initResFromZipFile success()");
      e();
      return true;
    }
    if (j())
    {
      Log.i(a, "initResFromRemote success()");
      e();
      return true;
    }
    Log.i(a, "prepareResource failed");
    g();
    return false;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return false;
      if (this.c.m_())
      {
        this.c.n_();
      }
      else
      {
        this.c.o_();
        continue;
        this.c.o_();
        continue;
        this.c.p_();
        continue;
        this.c.q_();
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atk
 * JD-Core Version:    0.6.2
 */