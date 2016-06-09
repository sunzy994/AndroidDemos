package cmcm.com.myapplication.com.hola.channel.sdk.game.graphics;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.Log;
import cv;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rt;
import sb;
import sc;
import sl;

public class ImageCache
{
  private static final String a = "GameSDK." + ImageCache.class.getSimpleName();
  private static final CompressFormat b = CompressFormat.JPEG;
  private rt c;
  private cv<String, BitmapDrawable> d;
  private sc e;
  private final Object f = new Object();
  private boolean g = true;
  private Map<String, SoftReference<Bitmap>> h;
  private boolean i;

  private ImageCache(sc paramsc)
  {
    a(paramsc);
  }

  @TargetApi(9)
  public static long a(File paramFile)
  {
    return paramFile.getUsableSpace();
  }

  private static ImageCache.RetainFragment a(FragmentManager paramFragmentManager)
  {
    ImageCache.RetainFragment localRetainFragment2 = (ImageCache.RetainFragment)paramFragmentManager.findFragmentByTag(a);
    ImageCache.RetainFragment localRetainFragment1 = localRetainFragment2;
    if (localRetainFragment2 == null)
    {
      localRetainFragment1 = new ImageCache.RetainFragment();
      paramFragmentManager.beginTransaction().add(localRetainFragment1, a).commitAllowingStateLoss();
    }
    return localRetainFragment1;
  }

  public static ImageCache a(FragmentManager paramFragmentManager, sc paramsc)
  {
    if (paramFragmentManager == null)
      paramFragmentManager = new ImageCache(paramsc);
    ImageCache.RetainFragment localRetainFragment;
    ImageCache localImageCache;
    do
    {
      return paramFragmentManager;
      localRetainFragment = a(paramFragmentManager);
      localImageCache = (ImageCache)localRetainFragment.a();
      paramFragmentManager = localImageCache;
    }
    while (localImageCache != null);
    paramFragmentManager = new ImageCache(paramsc);
    localRetainFragment.a(paramFragmentManager);
    return paramFragmentManager;
  }

  @TargetApi(8)
  public static File a(Context paramContext)
  {
    return paramContext.getExternalCacheDir();
  }

  public static File a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) || (!e()));
    for (paramContext = a(paramContext).getPath(); ; paramContext = paramContext.getCacheDir().getPath())
      return new File(paramContext + File.separator + paramString);
  }

  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
      if (str.length() == 1)
        localStringBuilder.append('0');
      localStringBuilder.append(str);
      j += 1;
    }
    return localStringBuilder.toString();
  }

  private void a(sc paramsc)
  {
    this.e = paramsc;
    if (this.e.f)
    {
      Log.i(a, "Memory cache created (size = " + this.e.a + ")");
      this.h = Collections.synchronizedMap(new HashMap());
      this.d = new cv(this.e.a)
      {
        protected int a(String paramAnonymousString, BitmapDrawable paramAnonymousBitmapDrawable)
        {
          int j = sb.a(paramAnonymousBitmapDrawable) / 1024;
          int i = j;
          if (j == 0)
            i = 1;
          return i;
        }

        protected void a(boolean paramAnonymousBoolean, String paramAnonymousString, BitmapDrawable paramAnonymousBitmapDrawable1, BitmapDrawable paramAnonymousBitmapDrawable2)
        {
          if (sl.class.isInstance(paramAnonymousBitmapDrawable1))
            ((sl)paramAnonymousBitmapDrawable1).a(false);
          while (ImageCache.a(ImageCache.this))
            return;
          ImageCache.b(ImageCache.this).put(paramAnonymousString, new SoftReference(paramAnonymousBitmapDrawable1.getBitmap()));
        }
      };
    }
    if (paramsc.h)
      a();
  }

  public static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = a(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return String.valueOf(paramString.hashCode());
  }

  @TargetApi(9)
  public static boolean e()
  {
    return Environment.isExternalStorageRemovable();
  }

  public Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    if ((this.h != null) && (!this.h.isEmpty()))
      synchronized (this.h)
      {
        Object localObject = (SoftReference)this.h.get(paramString);
        if (localObject != null)
        {
          localObject = (Bitmap)((SoftReference)localObject).get();
          if ((localObject != null) && (((Bitmap)localObject).isMutable()))
          {
            if (sb.a((Bitmap)localObject, paramOptions))
            {
              this.h.remove(paramString);
              return localObject;
            }
          }
          else
            this.h.remove(paramString);
        }
      }
    return null;
  }

  public BitmapDrawable a(String paramString)
  {
    BitmapDrawable localBitmapDrawable = null;
    if (this.d != null)
      localBitmapDrawable = (BitmapDrawable)this.d.a(paramString);
    return localBitmapDrawable;
  }

  public void a()
  {
    synchronized (this.f)
    {
      if (((this.c == null) || (this.c.a())) && (this.e.g) && (this.e.c != null))
      {
        if (!this.e.c.exists())
          this.e.c.mkdirs();
        long l = a(this.e.c);
        int j = this.e.b;
        if (l <= j);
      }
      try
      {
        this.c = rt.a(this.e.c, 1, 1, this.e.b);
        Log.i(a, "Disk cache initialized");
        this.g = false;
        this.f.notifyAll();
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          this.e.c = null;
          Log.w(a, "initDiskCache - " + localException);
        }
      }
    }
  }

  // ERROR //
  public void a(String paramString, BitmapDrawable paramBitmapDrawable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 200	com/hola/channel/sdk/game/graphics/ImageCache:d	Lcv;
    //   13: ifnull +31 -> 44
    //   16: ldc_w 319
    //   19: aload_2
    //   20: invokevirtual 322	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   23: ifeq +11 -> 34
    //   26: aload_2
    //   27: checkcast 319	sl
    //   30: iconst_1
    //   31: invokevirtual 325	sl:a	(Z)V
    //   34: aload_0
    //   35: getfield 200	com/hola/channel/sdk/game/graphics/ImageCache:d	Lcv;
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 328	cv:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_0
    //   45: getfield 61	com/hola/channel/sdk/game/graphics/ImageCache:f	Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 280	com/hola/channel/sdk/game/graphics/ImageCache:c	Lrt;
    //   55: ifnull +82 -> 137
    //   58: aload_1
    //   59: invokestatic 330	com/hola/channel/sdk/game/graphics/ImageCache:c	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 4
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 280	com/hola/channel/sdk/game/graphics/ImageCache:c	Lrt;
    //   70: aload 4
    //   72: invokevirtual 333	rt:a	(Ljava/lang/String;)Lrx;
    //   75: astore 5
    //   77: aload 5
    //   79: ifnonnull +66 -> 145
    //   82: aload_0
    //   83: getfield 280	com/hola/channel/sdk/game/graphics/ImageCache:c	Lrt;
    //   86: aload 4
    //   88: invokevirtual 336	rt:b	(Ljava/lang/String;)Lru;
    //   91: astore 4
    //   93: aload 4
    //   95: ifnull +38 -> 133
    //   98: aload 4
    //   100: iconst_0
    //   101: invokevirtual 341	ru:a	(I)Ljava/io/OutputStream;
    //   104: astore_1
    //   105: aload_2
    //   106: invokevirtual 345	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: getfield 165	com/hola/channel/sdk/game/graphics/ImageCache:e	Lsc;
    //   113: getfield 347	sc:d	Landroid/graphics/Bitmap$CompressFormat;
    //   116: aload_0
    //   117: getfield 165	com/hola/channel/sdk/game/graphics/ImageCache:e	Lsc;
    //   120: getfield 349	sc:e	I
    //   123: aload_1
    //   124: invokevirtual 353	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   127: pop
    //   128: aload 4
    //   130: invokevirtual 354	ru:a	()V
    //   133: aload_1
    //   134: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   137: aload_3
    //   138: monitorexit
    //   139: return
    //   140: astore_1
    //   141: aload_3
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: aload 5
    //   147: iconst_0
    //   148: invokevirtual 364	rx:a	(I)Ljava/io/InputStream;
    //   151: invokevirtual 369	java/io/InputStream:close	()V
    //   154: goto -21 -> 133
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: getstatic 49	com/hola/channel/sdk/game/graphics/ImageCache:a	Ljava/lang/String;
    //   163: new 29	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 371
    //   173: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 314	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   186: pop
    //   187: aload_1
    //   188: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   191: goto -54 -> 137
    //   194: aload_1
    //   195: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: goto -7 -> 194
    //   204: astore_2
    //   205: goto -11 -> 194
    //   208: astore_2
    //   209: goto -49 -> 160
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_1
    //   215: goto -21 -> 194
    //
    // Exception table:
    //   from	to	target	type
    //   51	64	140	finally
    //   133	137	140	finally
    //   137	139	140	finally
    //   141	143	140	finally
    //   187	191	140	finally
    //   194	200	140	finally
    //   66	77	157	java/lang/Throwable
    //   82	93	157	java/lang/Throwable
    //   98	105	157	java/lang/Throwable
    //   145	154	157	java/lang/Throwable
    //   105	133	200	finally
    //   160	187	204	finally
    //   105	133	208	java/lang/Throwable
    //   66	77	212	finally
    //   82	93	212	finally
    //   98	105	212	finally
    //   145	154	212	finally
  }

  // ERROR //
  public Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 330	com/hola/channel/sdk/game/graphics/ImageCache:c	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 61	com/hola/channel/sdk/game/graphics/ImageCache:f	Ljava/lang/Object;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 63	com/hola/channel/sdk/game/graphics/ImageCache:g	Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifeq +17 -> 39
    //   25: aload_0
    //   26: getfield 61	com/hola/channel/sdk/game/graphics/ImageCache:f	Ljava/lang/Object;
    //   29: invokevirtual 377	java/lang/Object:wait	()V
    //   32: goto -18 -> 14
    //   35: astore_3
    //   36: goto -22 -> 14
    //   39: aload_0
    //   40: getfield 280	com/hola/channel/sdk/game/graphics/ImageCache:c	Lrt;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +62 -> 107
    //   48: aload_0
    //   49: getfield 280	com/hola/channel/sdk/game/graphics/ImageCache:c	Lrt;
    //   52: aload_2
    //   53: invokevirtual 333	rt:a	(Ljava/lang/String;)Lrx;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +116 -> 174
    //   61: aload_2
    //   62: iconst_0
    //   63: invokevirtual 364	rx:a	(I)Ljava/io/InputStream;
    //   66: astore_2
    //   67: aload_2
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +33 -> 103
    //   73: aload_2
    //   74: astore_3
    //   75: aload_2
    //   76: checkcast 379	java/io/FileInputStream
    //   79: invokevirtual 383	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   82: ldc_w 384
    //   85: ldc_w 384
    //   88: aload_0
    //   89: aload_1
    //   90: invokestatic 387	sb:a	(Ljava/io/FileDescriptor;IILcom/hola/channel/sdk/game/graphics/ImageCache;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   93: astore_1
    //   94: aload_2
    //   95: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_1
    //   102: areturn
    //   103: aload_3
    //   104: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   107: aload 4
    //   109: monitorexit
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_3
    //   117: getstatic 49	com/hola/channel/sdk/game/graphics/ImageCache:a	Ljava/lang/String;
    //   120: new 29	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 389
    //   130: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 314	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: aload_2
    //   145: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   148: goto -41 -> 107
    //   151: astore_1
    //   152: aload 4
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: invokestatic 359	qp:a	(Ljava/io/Closeable;)V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -7 -> 160
    //   170: astore_1
    //   171: goto -56 -> 115
    //   174: aconst_null
    //   175: astore_3
    //   176: goto -73 -> 103
    //
    // Exception table:
    //   from	to	target	type
    //   25	32	35	java/lang/InterruptedException
    //   48	57	112	java/lang/Exception
    //   61	67	112	java/lang/Exception
    //   14	20	151	finally
    //   25	32	151	finally
    //   39	44	151	finally
    //   94	101	151	finally
    //   103	107	151	finally
    //   107	110	151	finally
    //   144	148	151	finally
    //   152	155	151	finally
    //   160	166	151	finally
    //   48	57	157	finally
    //   61	67	157	finally
    //   75	94	166	finally
    //   117	144	166	finally
    //   75	94	170	java/lang/Exception
  }

  public void b()
  {
    if (this.d != null)
    {
      this.i = true;
      this.d.a();
      this.i = false;
    }
    if (this.h != null)
      this.h.clear();
    synchronized (this.f)
    {
      this.g = true;
      if (this.c != null)
      {
        boolean bool = this.c.a();
        if (bool);
      }
      try
      {
        this.c.c();
        this.c = null;
        a();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(a, "clearCache - " + localIOException);
      }
    }
  }

  public void c()
  {
    synchronized (this.f)
    {
      rt localrt = this.c;
      if (localrt != null);
      try
      {
        this.c.b();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(a, "flush - " + localIOException);
      }
    }
  }

  public void d()
  {
    synchronized (this.f)
    {
      rt localrt = this.c;
      if (localrt != null);
      try
      {
        if (!this.c.a())
        {
          this.c.close();
          this.c = null;
        }
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.w(a, "close - " + localIOException);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.graphics.ImageCache
 * JD-Core Version:    0.6.2
 */