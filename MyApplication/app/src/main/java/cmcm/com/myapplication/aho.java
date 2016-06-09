package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.util.Log;
import com.lazyswipe.SwipeService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aho extends ahr
{
  private static final String n = "Swipe." + aho.class.getSimpleName();
  private String o;
  private long p;

  public aho(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.o = paramString1;
  }

  private static aho a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    paramResolveInfo = paramResolveInfo.activityInfo;
    String str = paramResolveInfo.packageName;
    if (!str.startsWith("com.hola.launcher.theme."));
    while (true)
    {
      return null;
      try
      {
        if (new aii(paramContext, str).h())
        {
          paramContext = new aho(paramContext, str, paramResolveInfo.loadLabel(paramContext.getPackageManager()).toString());
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
      }
    }
    return null;
  }

  public static aho a(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(paramString);
    paramString = paramContext.getPackageManager().queryIntentActivities(paramString, 0);
    if (paramString.size() > 0)
    {
      paramContext = a(paramContext, (ResolveInfo)paramString.get(0));
      if (paramContext != null)
        return paramContext;
    }
    return null;
  }

  // ERROR //
  private Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	aho:a	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 43	aho:o	Ljava/lang/String;
    //   8: iconst_0
    //   9: invokevirtual 132	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   12: invokevirtual 136	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   15: new 17	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   22: ldc 138
    //   24: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokevirtual 144	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 128	aho:a	Landroid/content/Context;
    //   46: aload 4
    //   48: iload_2
    //   49: iload_3
    //   50: invokestatic 149	atw:a	(Landroid/content/Context;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   53: astore 5
    //   55: aload 4
    //   57: invokestatic 154	arf:a	(Ljava/io/Closeable;)V
    //   60: aload 5
    //   62: areturn
    //   63: astore 5
    //   65: aconst_null
    //   66: astore 4
    //   68: aload 4
    //   70: astore_1
    //   71: getstatic 37	aho:n	Ljava/lang/String;
    //   74: ldc 156
    //   76: aload 5
    //   78: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   81: pop
    //   82: aload 4
    //   84: invokestatic 154	arf:a	(Ljava/io/Closeable;)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore 5
    //   93: aload_1
    //   94: astore 4
    //   96: aload 5
    //   98: invokestatic 154	arf:a	(Ljava/io/Closeable;)V
    //   101: aload 4
    //   103: athrow
    //   104: astore 4
    //   106: aload_1
    //   107: astore 5
    //   109: goto -13 -> 96
    //   112: astore 5
    //   114: goto -46 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   0	39	63	java/lang/Exception
    //   0	39	89	finally
    //   42	55	104	finally
    //   71	82	104	finally
    //   42	55	112	java/lang/Exception
  }

  public static List<ahw> a(Context paramContext)
  {
    Object localObject1 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
    Object localObject2 = paramContext.getPackageManager().queryIntentActivities((Intent)localObject1, 0);
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aho localaho = a(paramContext, (ResolveInfo)((Iterator)localObject2).next());
      if (localaho != null)
        ((List)localObject1).add(localaho);
    }
    return localObject1;
  }

  public static void b(Context paramContext, String paramString)
  {
    if (!paramString.startsWith("com.hola.launcher.theme."));
    do
    {
      String str;
      long l;
      do
      {
        return;
        str = vs.a(paramContext, "download_external_apk_theme_key", "");
        l = vs.a(paramContext, "download_external_apk_theme_time", -1L);
      }
      while ((!str.equals(paramString)) || (System.currentTimeMillis() - l > 300000L));
      paramString = a(paramContext, paramString);
    }
    while (paramString == null);
    SwipeService.a(paramContext, paramString.g, true);
  }

  public static void c(Context paramContext, String paramString)
  {
    if (!paramString.startsWith("com.hola.launcher.theme."));
    do
    {
      return;
      paramString = new aho(paramContext, paramString, "");
      if (paramString.L())
        SwipeService.a(paramContext, "purple", false);
    }
    while (!paramString.e());
    arj.a(new Runnable() {
      public void run() {
        aqx.b(aho.this.E());
      }
    });
  }

  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!e())
    {
      Log.e(n, "goto gp " + this.o);
      vs.b(this.a, "download_external_apk_theme_key", this.g);
      vs.b(this.a, "download_external_apk_theme_time", System.currentTimeMillis());
      asq.a(this.a, this.o, true, false);
      return;
    }
    super.a(paramBoolean, paramRunnable);
  }

  public Bitmap c()
  {
    Bitmap localBitmap = super.c();
    if (atw.b(localBitmap))
      return localBitmap;
    return a("preview1_omni.jpg", j, k);
  }

  public List<Bitmap> d()
  {
    ArrayList localArrayList = new ArrayList();
    Bitmap localBitmap = a("preview1_omni.jpg", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview1.jpg", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview2.jpg", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    localBitmap = a("preview3.jpg", l, m);
    if (atw.b(localBitmap))
      localArrayList.add(localBitmap);
    return localArrayList;
  }

  public boolean e()
  {
    return asq.c(this.a, this.o);
  }

  public long f()
  {
    long l = 0L;
    PackageInfo localPackageInfo;
    if (this.p <= 0L)
    {
      localPackageInfo = asq.d(this.a, this.o);
      if (localPackageInfo != null)
        break label37;
    }
    while (true)
    {
      this.p = l;
      return this.p;
      label37: l = localPackageInfo.firstInstallTime;
    }
  }

  public boolean g()
  {
    return true;
  }

  protected void j_()
  {
    Log.i(n, "start().");
    if (z())
    {
      Log.i(n, "start(). isResourceDone(), super.start()");
      A();
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (aho.this.k_())
          {
            aho.this.A();
            return;
          }
          aho.this.B();
          return;
        }
        catch (Exception localException)
        {
          Log.e(aho.h(), "prepareAsync() failed.", localException);
          aho.this.B();
        }
      }
    }).start();
  }

  protected boolean k_()
  {
    try
    {
      aii localaii = new aii(this.a, this.o);
      boolean bool = new ahp(this, this.a, this.o, localaii, null).b();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aho
 * JD-Core Version:    0.6.2
 */