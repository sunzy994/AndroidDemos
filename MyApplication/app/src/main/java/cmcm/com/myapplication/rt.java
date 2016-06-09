package cmcm.com.myapplication;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class rt
  implements Closeable
{
  private static final Charset a = Charset.forName("UTF-8");
  private final File b;
  private final File c;
  private final File d;
  private final int e;
  private final long f;
  private final int g;
  private long h = 0L;
  private Writer i;
  private final LinkedHashMap<String, rw> j = new LinkedHashMap(0, 0.75F, true);
  private int k;
  private long l = 0L;
  private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final Callable<Void> n = new Callable()
  {
    public Void a()
    {
      synchronized (rt.this)
      {
        if (rt.a(rt.this) == null)
          return null;
        rt.b(rt.this);
        if (rt.c(rt.this))
        {
          rt.d(rt.this);
          rt.a(rt.this, 0);
        }
        return null;
      }
    }
  };

  private rt(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramFile;
    this.e = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.g = paramInt2;
    this.f = paramLong;
  }

  public static String a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    while (true)
    {
      int i1 = paramInputStream.read();
      if (i1 == -1)
        throw new EOFException();
      if (i1 == 10)
      {
        i1 = localStringBuilder.length();
        if ((i1 > 0) && (localStringBuilder.charAt(i1 - 1) == '\r'))
          localStringBuilder.setLength(i1 - 1);
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i1);
    }
  }

  public static rt a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    rt localrt = new rt(paramFile, paramInt1, paramInt2, paramLong);
    if (localrt.c.exists())
      try
      {
        localrt.d();
        localrt.e();
        localrt.i = new BufferedWriter(new FileWriter(localrt.c, true), 8192);
        return localrt;
      }
      catch (IOException localIOException)
      {
        localrt.c();
      }
    paramFile.mkdirs();
    paramFile = new rt(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.f();
    return paramFile;
  }

  private ru a(String paramString, long paramLong)
  {
    while (true)
    {
      rw localrw;
      try
      {
        h();
        e(paramString);
        localrw = (rw)this.j.get(paramString);
        if (paramLong != -1L)
          if (localrw != null)
          {
            long l1 = rw.e(localrw);
            if (l1 == paramLong);
          }
          else
          {
            paramString = null;
            return paramString;
          }
        if (localrw == null)
        {
          localrw = new rw(this, paramString, null);
          this.j.put(paramString, localrw);
          localru = new ru(this, localrw, null);
          rw.a(localrw, localru);
          this.i.write("DIRTY " + paramString + '\n');
          this.i.flush();
          paramString = localru;
          continue;
        }
      }
      finally
      {
      }
      ru localru = rw.a(localrw);
      if (localru != null)
        paramString = null;
    }
  }

  public static void a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      throw new IllegalArgumentException("not a directory: " + paramFile);
    int i2 = arrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramFile = arrayOfFile[i1];
      if (paramFile.isDirectory())
        a(paramFile);
      if (!paramFile.delete())
        throw new IOException("failed to delete file: " + paramFile);
      i1 += 1;
    }
  }

  private void a(ru paramru, boolean paramBoolean)
  {
    int i3 = 0;
    rw localrw;
    try
    {
      localrw = ru.a(paramru);
      if (rw.a(localrw) != paramru)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int i2 = i3;
    int i1;
    if (paramBoolean)
    {
      i2 = i3;
      if (!rw.d(localrw))
      {
        i1 = 0;
        i2 = i3;
        if (i1 < this.g)
        {
          if (localrw.b(i1).exists())
            break label386;
          paramru.b();
          throw new IllegalStateException("edit didn't create file " + i1);
        }
      }
    }
    while (true)
    {
      long l1;
      if (i2 < this.g)
      {
        paramru = localrw.b(i2);
        if (paramBoolean)
        {
          if (paramru.exists())
          {
            File localFile = localrw.a(i2);
            paramru.renameTo(localFile);
            l1 = rw.b(localrw)[i2];
            long l2 = localFile.length();
            rw.b(localrw)[i2] = l2;
            this.h = (this.h - l1 + l2);
          }
        }
        else
          b(paramru);
      }
      else
      {
        this.k += 1;
        rw.a(localrw, null);
        if ((rw.d(localrw) | paramBoolean))
        {
          rw.a(localrw, true);
          this.i.write("CLEAN " + rw.c(localrw) + localrw.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.l;
            this.l = (1L + l1);
            rw.a(localrw, l1);
          }
        }
        while (true)
        {
          if ((this.h > this.f) || (g()))
            this.m.submit(this.n);
          return;
          this.j.remove(rw.c(localrw));
          this.i.write("REMOVE " + rw.c(localrw) + '\n');
        }
        label386: i1 += 1;
        break;
      }
      i2 += 1;
    }
  }

  private static <T> T[] a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayOfT.length;
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    if ((paramInt1 < 0) || (paramInt1 > i1))
      throw new ArrayIndexOutOfBoundsException();
    paramInt2 -= paramInt1;
    i1 = Math.min(paramInt2, i1 - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt2);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i1);
    return arrayOfObject;
  }

  private static void b(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: new 358	java/io/BufferedInputStream
    //   3: dup
    //   4: new 360	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 97	rt:c	Ljava/io/File;
    //   12: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: sipush 8192
    //   18: invokespecial 365	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload_1
    //   28: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   31: astore_3
    //   32: aload_1
    //   33: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   48: astore 6
    //   50: ldc_w 369
    //   53: aload_2
    //   54: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc_w 377
    //   63: aload_3
    //   64: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 88	rt:e	I
    //   74: invokestatic 382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 4
    //   79: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 103	rt:g	I
    //   89: invokestatic 382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 5
    //   94: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 384
    //   103: aload 6
    //   105: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +76 -> 184
    //   111: new 147	java/io/IOException
    //   114: dup
    //   115: new 114	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 386
    //   125: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 388
    //   135: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 388
    //   145: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 5
    //   150: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 388
    //   156: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 6
    //   161: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 390
    //   167: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 252	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_2
    //   178: aload_1
    //   179: invokestatic 395	qp:a	(Ljava/io/Closeable;)V
    //   182: aload_2
    //   183: athrow
    //   184: aload_0
    //   185: aload_1
    //   186: invokestatic 367	rt:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   189: invokespecial 397	rt:d	(Ljava/lang/String;)V
    //   192: goto -8 -> 184
    //   195: astore_2
    //   196: aload_1
    //   197: invokestatic 395	qp:a	(Ljava/io/Closeable;)V
    //   200: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	111	177	finally
    //   111	177	177	finally
    //   184	192	177	finally
    //   184	192	195	java/io/EOFException
  }

  private void d(String paramString)
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length < 2)
      throw new IOException("unexpected journal line: " + paramString);
    String str = arrayOfString[1];
    if ((arrayOfString[0].equals("REMOVE")) && (arrayOfString.length == 2))
    {
      this.j.remove(str);
      return;
    }
    rw localrw = (rw)this.j.get(str);
    if (localrw == null)
    {
      localrw = new rw(this, str, null);
      this.j.put(str, localrw);
    }
    while (true)
    {
      if ((arrayOfString[0].equals("CLEAN")) && (arrayOfString.length == this.g + 2))
      {
        rw.a(localrw, true);
        rw.a(localrw, null);
        rw.a(localrw, (String[]) a(arrayOfString, 2, arrayOfString.length));
        return;
      }
      if ((arrayOfString[0].equals("DIRTY")) && (arrayOfString.length == 2))
      {
        rw.a(localrw, new ru(this, localrw, null));
        return;
      }
      if ((arrayOfString[0].equals("READ")) && (arrayOfString.length == 2))
        break;
      throw new IOException("unexpected journal line: " + paramString);
    }
  }

  private void e()
  {
    b(this.d);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      rw localrw = (rw)localIterator.next();
      int i1;
      if (rw.a(localrw) == null)
      {
        i1 = 0;
        while (i1 < this.g)
        {
          this.h += rw.b(localrw)[i1];
          i1 += 1;
        }
      }
      else
      {
        rw.a(localrw, null);
        i1 = 0;
        while (i1 < this.g)
        {
          b(localrw.a(i1));
          b(localrw.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }

  private void e(String paramString)
  {
    if ((paramString.contains(" ")) || (paramString.contains("\n")) || (paramString.contains("\r")))
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
  }

  private void f()
  {
    while (true)
    {
      rw localrw;
      try
      {
        if (this.i != null)
          this.i.close();
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(this.d), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.e));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.g));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.j.values().iterator();
        if (!localIterator.hasNext())
          break;
        localrw = (rw)localIterator.next();
        if (rw.a(localrw) != null)
        {
          localBufferedWriter.write("DIRTY " + rw.c(localrw) + '\n');
          continue;
        }
      }
      finally
      {
      }
      localObject.write("CLEAN " + rw.c(localrw) + localrw.a() + '\n');
    }
    localObject.close();
    this.d.renameTo(this.c);
    this.i = new BufferedWriter(new FileWriter(this.c, true), 8192);
  }

  private boolean g()
  {
    return (this.k >= 2000) && (this.k >= this.j.size());
  }

  private void h()
  {
    if (this.i == null)
      throw new IllegalStateException("cache is closed");
  }

  private void i()
  {
    while (this.h > this.f)
      c((String)((Map.Entry)this.j.entrySet().iterator().next()).getKey());
  }

  // ERROR //
  public rx a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 186	rt:h	()V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 188	rt:e	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 59	rt:j	Ljava/util/LinkedHashMap;
    //   17: aload_1
    //   18: invokevirtual 192	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 194	rw
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +9 -> 37
    //   31: aload_3
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_3
    //   38: astore_2
    //   39: aload 4
    //   41: invokestatic 265	rw:d	(Lrw;)Z
    //   44: ifeq -11 -> 33
    //   47: aload_0
    //   48: getfield 103	rt:g	I
    //   51: anewarray 119	java/io/InputStream
    //   54: astore_2
    //   55: iconst_0
    //   56: istore 5
    //   58: iload 5
    //   60: aload_0
    //   61: getfield 103	rt:g	I
    //   64: if_icmpge +30 -> 94
    //   67: aload_2
    //   68: iload 5
    //   70: new 360	java/io/FileInputStream
    //   73: dup
    //   74: aload 4
    //   76: iload 5
    //   78: invokevirtual 278	rw:a	(I)Ljava/io/File;
    //   81: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: aastore
    //   85: iload 5
    //   87: iconst_1
    //   88: iadd
    //   89: istore 5
    //   91: goto -33 -> 58
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 108	rt:k	I
    //   99: iconst_1
    //   100: iadd
    //   101: putfield 108	rt:k	I
    //   104: aload_0
    //   105: getfield 111	rt:i	Ljava/io/Writer;
    //   108: new 114	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 484
    //   118: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: bipush 10
    //   127: invokevirtual 144	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   130: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 487	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   136: pop
    //   137: aload_0
    //   138: invokespecial 305	rt:g	()Z
    //   141: ifeq +17 -> 158
    //   144: aload_0
    //   145: getfield 79	rt:m	Ljava/util/concurrent/ExecutorService;
    //   148: aload_0
    //   149: getfield 84	rt:n	Ljava/util/concurrent/Callable;
    //   152: invokeinterface 311 2 0
    //   157: pop
    //   158: new 489	rx
    //   161: dup
    //   162: aload_0
    //   163: aload_1
    //   164: aload 4
    //   166: invokestatic 199	rw:e	(Lrw;)J
    //   169: aload_2
    //   170: aconst_null
    //   171: invokespecial 492	rx:<init>	(Lrt;Ljava/lang/String;J[Ljava/io/InputStream;Lrt$1;)V
    //   174: astore_2
    //   175: goto -142 -> 33
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: goto -153 -> 33
    //
    // Exception table:
    //   from	to	target	type
    //   4	26	178	finally
    //   39	55	178	finally
    //   58	85	178	finally
    //   94	158	178	finally
    //   158	175	178	finally
    //   58	85	183	java/io/FileNotFoundException
  }

  public boolean a()
  {
    return this.i == null;
  }

  public ru b(String paramString)
  {
    return a(paramString, -1L);
  }

  public void b()
  {
    try
    {
      h();
      i();
      this.i.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    close();
    a(this.b);
  }

  public boolean c(String paramString)
  {
    int i1 = 0;
    while (true)
    {
      try
      {
        h();
        e(paramString);
        rw localrw = (rw)this.j.get(paramString);
        Object localObject;
        if (localrw != null)
        {
          localObject = rw.a(localrw);
          if (localObject == null);
        }
        else
        {
          bool = false;
          return bool;
          this.h -= rw.b(localrw)[i1];
          rw.b(localrw)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.g)
        {
          localObject = localrw.a(i1);
          if (((File)localObject).delete())
            continue;
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally
      {
      }
      this.k += 1;
      this.i.append("REMOVE " + paramString + '\n');
      this.j.remove(paramString);
      if (g())
        this.m.submit(this.n);
      boolean bool = true;
    }
  }

  public void close()
  {
    while (true)
    {
      try
      {
        Object localObject1 = this.i;
        if (localObject1 == null)
          return;
        localObject1 = new ArrayList(this.j.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          rw localrw = (rw)((Iterator)localObject1).next();
          if (rw.a(localrw) == null)
            continue;
          rw.a(localrw).b();
          continue;
        }
      }
      finally
      {
      }
      i();
      this.i.close();
      this.i = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rt
 * JD-Core Version:    0.6.2
 */