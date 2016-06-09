package cmcm.com.myapplication;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.File;

public class xp
{
  private static xp a = null;
  private static final Object c = new Object();
  private final Application b;

  private xp(Application paramApplication)
  {
    this.b = paramApplication;
  }

  private String a()
  {
    return aro.c() + "/icons/";
  }

  public static xp a(Context paramContext)
  {
    synchronized (c)
    {
      if (a == null)
        a = new xp((Application)paramContext.getApplicationContext());
      return a;
    }
  }

  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 256) || (paramInt2 > 256) || (paramInt1 != paramInt2);
  }

  private String c(ComponentName paramComponentName)
  {
    return a() + paramComponentName.flattenToShortString();
  }

  private String d(ComponentName paramComponentName)
  {
    return a() + paramComponentName.flattenToShortString() + ".info";
  }

  // ERROR //
  public Bitmap a(ComponentName paramComponentName)
  {
    // Byte code:
    //   0: invokestatic 75	art:c	()Z
    //   3: ifeq +9 -> 12
    //   6: invokestatic 77	art:d	()Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 79	xp:c	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   19: astore 6
    //   21: new 81	java/io/File
    //   24: dup
    //   25: aload 6
    //   27: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   37: invokevirtual 90	java/io/File:exists	()Z
    //   40: ifne +12 -> 52
    //   43: aload 5
    //   45: invokevirtual 87	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 93	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: invokestatic 98	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   55: invokevirtual 101	com/lazyswipe/SwipeApplication:a	()Lwm;
    //   58: aload_1
    //   59: invokevirtual 106	wm:a	(Landroid/content/ComponentName;)Lwk;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +262 -> 326
    //   67: aload_2
    //   68: getfield 112	wk:j	Ljava/lang/String;
    //   71: ifnull +255 -> 326
    //   74: invokestatic 98	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   77: invokevirtual 116	com/lazyswipe/SwipeApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   80: astore_3
    //   81: aload_3
    //   82: new 61	android/content/ComponentName
    //   85: dup
    //   86: aload_1
    //   87: invokevirtual 119	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   90: aload_2
    //   91: getfield 112	wk:j	Ljava/lang/String;
    //   94: invokespecial 122	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_0
    //   98: invokevirtual 128	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   101: aload_3
    //   102: invokevirtual 134	android/content/pm/ActivityInfo:loadIcon	(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
    //   105: astore_2
    //   106: aload_2
    //   107: astore_3
    //   108: aload_2
    //   109: ifnonnull +222 -> 331
    //   112: aload_0
    //   113: getfield 23	xp:b	Landroid/app/Application;
    //   116: aload_1
    //   117: invokevirtual 119	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   120: aload_1
    //   121: invokevirtual 137	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   124: invokestatic 142	asq:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   127: astore_3
    //   128: goto +203 -> 331
    //   131: aload 4
    //   133: invokestatic 147	atw:b	(Landroid/graphics/Bitmap;)Z
    //   136: ifeq +113 -> 249
    //   139: new 149	java/io/FileOutputStream
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload_3
    //   150: astore_2
    //   151: aload 4
    //   153: getstatic 156	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   156: bipush 100
    //   158: aload_3
    //   159: invokevirtual 162	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   162: pop
    //   163: aload_3
    //   164: astore_2
    //   165: aload_3
    //   166: invokevirtual 165	java/io/FileOutputStream:flush	()V
    //   169: aload_3
    //   170: astore_2
    //   171: new 81	java/io/File
    //   174: dup
    //   175: aload_0
    //   176: aload_1
    //   177: invokespecial 167	xp:d	(Landroid/content/ComponentName;)Ljava/lang/String;
    //   180: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: new 26	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   190: aload_0
    //   191: getfield 23	xp:b	Landroid/app/Application;
    //   194: aload_1
    //   195: invokevirtual 119	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   198: invokestatic 171	asq:o	(Landroid/content/Context;Ljava/lang/String;)J
    //   201: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc 176
    //   206: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 5
    //   211: invokevirtual 180	java/io/File:lastModified	()J
    //   214: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 185	aqx:b	(Ljava/io/File;Ljava/lang/String;)V
    //   223: aload_3
    //   224: invokestatic 190	arf:a	(Ljava/io/Closeable;)V
    //   227: aload 4
    //   229: areturn
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -127 -> 106
    //   236: aload_3
    //   237: aload_0
    //   238: getfield 23	xp:b	Landroid/app/Application;
    //   241: invokestatic 193	atw:a	(Landroid/graphics/drawable/Drawable;Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   244: astore 4
    //   246: goto -115 -> 131
    //   249: aconst_null
    //   250: invokestatic 190	arf:a	(Ljava/io/Closeable;)V
    //   253: aconst_null
    //   254: areturn
    //   255: astore 4
    //   257: aconst_null
    //   258: astore_3
    //   259: aload_3
    //   260: astore_2
    //   261: ldc 195
    //   263: new 26	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   270: ldc 197
    //   272: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: ldc 199
    //   281: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: aload 4
    //   289: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   292: pop
    //   293: aload_3
    //   294: astore_2
    //   295: aload 5
    //   297: invokestatic 208	aqx:e	(Ljava/io/File;)Z
    //   300: pop
    //   301: aload_3
    //   302: invokestatic 190	arf:a	(Ljava/io/Closeable;)V
    //   305: goto -52 -> 253
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_2
    //   311: aload_2
    //   312: invokestatic 190	arf:a	(Ljava/io/Closeable;)V
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: goto -7 -> 311
    //   321: astore 4
    //   323: goto -64 -> 259
    //   326: aconst_null
    //   327: astore_2
    //   328: goto -222 -> 106
    //   331: aload_3
    //   332: ifnonnull -96 -> 236
    //   335: aconst_null
    //   336: astore 4
    //   338: goto -207 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   81	106	230	java/lang/Throwable
    //   32	52	255	java/lang/Throwable
    //   52	63	255	java/lang/Throwable
    //   67	81	255	java/lang/Throwable
    //   112	128	255	java/lang/Throwable
    //   131	149	255	java/lang/Throwable
    //   236	246	255	java/lang/Throwable
    //   32	52	308	finally
    //   52	63	308	finally
    //   67	81	308	finally
    //   81	106	308	finally
    //   112	128	308	finally
    //   131	149	308	finally
    //   236	246	308	finally
    //   151	163	317	finally
    //   165	169	317	finally
    //   171	223	317	finally
    //   261	293	317	finally
    //   295	301	317	finally
    //   151	163	321	java/lang/Throwable
    //   165	169	321	java/lang/Throwable
    //   171	223	321	java/lang/Throwable
  }

  public Bitmap b(ComponentName paramComponentName)
  {
    File localFile = new File(c(paramComponentName));
    if (!localFile.exists())
      return null;
    try
    {
      localObject = aqx.i(new File(d(paramComponentName))).split(";");
      long l1 = Long.parseLong(localObject[0]);
      long l2 = Long.parseLong(localObject[1]);
      if ((l1 != asq.o(this.b, paramComponentName.getPackageName())) || (l2 != localFile.lastModified()))
      {
        Log.e("Swipe.cache.IconFsCache", "Cache data does not match, ignored");
        aqx.e(localFile);
        return null;
      }
    }
    catch (Throwable paramComponentName)
    {
      Log.e("Swipe.cache.IconFsCache", "getIconFromCacheFile failed, ignored.", paramComponentName);
      aqx.e(localFile);
      return null;
    }
    Object localObject = new Options();
    ((Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(localFile.getAbsolutePath(), (Options)localObject);
    if (a(((Options)localObject).outWidth, ((Options)localObject).outHeight))
    {
      Log.e("Swipe.cache.IconFsCache", "decode icon cache " + paramComponentName + " file dimension error:" + ((Options)localObject).outWidth + "," + ((Options)localObject).outHeight + ", ignored.");
      aqx.e(localFile);
      return null;
    }
    paramComponentName = BitmapFactory.decodeFile(localFile.getAbsolutePath());
    int i = atw.a(this.b);
    if (i != paramComponentName.getWidth())
    {
      Log.e("Swipe.cache.IconFsCache", "icon size changed. from " + paramComponentName.getWidth() + " to " + i + ", ignored.");
      aqx.e(localFile);
      return null;
    }
    return paramComponentName;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xp
 * JD-Core Version:    0.6.2
 */