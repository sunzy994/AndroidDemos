package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.util.Log;
import com.lazyswipe.SwipeService;
import java.io.File;

public class vp extends BroadcastReceiver
{
  private static final String a = "Swipe." + vp.class.getSimpleName();
  private boolean b;
  private final File c;
  private final File d;
  private final File e;
  private FileObserver f;
  private int g;
  private Context h;
  private String i;

  @SuppressLint({"SdCardPath"})
  private vp()
  {
    if (Build.MODEL.equals("MI 3"));
    for (File localFile = new File("/sdcard/Pictures"); ; localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES))
    {
      this.d = localFile;
      this.c = new File(this.d, "Screenshots");
      this.e = this.d.getParentFile();
      return;
    }
  }

  public static vp a(Context paramContext)
  {
    return vq.a.b(paramContext);
  }

  private void a(Uri paramUri)
  {
    if (!this.d.exists())
      d();
    while (this.f != null)
      return;
    c();
  }

  private void a(final String paramString)
  {
    if (asq.a(this.i, paramString));
    Handler localHandler;
    do
    {
      return;
      this.i = paramString;
      paramString = Uri.parse("file://" + this.c.getAbsolutePath() + "/" + paramString);
      localHandler = SwipeService.a();
    }
    while (localHandler == null);
    acw.e(this.h, true);
    localHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        act.a(paramString);
      }
    }
    , 0L);
  }

  private vp b(Context paramContext)
  {
    if (this.h == null)
      this.h = paramContext.getApplicationContext();
    return this;
  }

  private void c()
  {
    if (this.c.exists())
    {
      this.g = 1;
      this.f = new vr(this, this.c, 1032);
      return;
    }
    if (this.d.exists())
    {
      this.g = 2;
      this.f = new vr(this, this.d, 1280);
      return;
    }
    if (this.e.exists())
    {
      this.g = 3;
      this.f = new vr(this, this.e, 256);
      return;
    }
    this.g = 0;
  }

  private void d()
  {
    if (this.f != null)
    {
      this.f.stopWatching();
      this.f = null;
    }
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 179	vp:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 179	vp:b	Z
    //   19: aload_0
    //   20: getfield 79	vp:c	Ljava/io/File;
    //   23: invokevirtual 182	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: new 184	android/content/IntentFilter
    //   30: dup
    //   31: invokespecial 185	android/content/IntentFilter:<init>	()V
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 187
    //   38: invokevirtual 190	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: ldc 192
    //   44: invokevirtual 190	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 143	vp:h	Landroid/content/Context;
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 196	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   56: pop
    //   57: aload_0
    //   58: invokespecial 116	vp:c	()V
    //   61: goto -50 -> 11
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: goto -13 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	64	finally
    //   14	47	64	finally
    //   47	57	64	finally
    //   57	61	64	finally
    //   47	57	69	java/lang/Throwable
  }

  void a(int paramInt, String paramString)
  {
    if (1 == this.g)
      if (8 == paramInt)
        a(paramString);
    label19: 
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label19;
              break label19;
              break label19;
              do
                return;
              while (1024 != paramInt);
              d();
              c();
              return;
              if (2 != this.g)
                break;
              if (1024 == paramInt)
              {
                d();
                c();
                return;
              }
            }
            while (!"Screenshots".equals(paramString));
            d();
            c();
            paramString = this.c.list();
          }
          while ((paramString == null) || (paramString.length <= 0));
          a(8, paramString[0]);
          return;
        }
        while ((3 != this.g) || (!"Pictures".equals(paramString)));
        d();
        c();
      }
      while (1 != this.g);
      paramString = this.c.list();
    }
    while ((paramString == null) || (paramString.length <= 0));
    a(8, paramString[0]);
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 179	vp:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 179	vp:b	Z
    //   19: aload_0
    //   20: getfield 143	vp:h	Landroid/content/Context;
    //   23: aload_0
    //   24: invokevirtual 211	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   27: aload_0
    //   28: invokespecial 112	vp:d	()V
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_1
    //   40: goto -13 -> 27
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	19	34	finally
    //   19	27	34	finally
    //   27	31	34	finally
    //   19	27	39	java/lang/Throwable
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getData();
    Log.i(a, "Storage: " + paramContext);
    a(paramContext);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vp
 * JD-Core Version:    0.6.2
 */