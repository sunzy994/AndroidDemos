package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oo
{
  private int a = 1;
  private boolean b = false;
  private String c;
  private String d;
  private int e;
  private long f;
  private long g;
  private Context h;
  private List<os> i;
  private List<op> j;
  private oq k;
  private Boolean l;

  public oo(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong, boolean paramBoolean, oq paramoq)
  {
    this.h = paramContext;
    if (paramString1 == null);
    for (paramContext = null; ; paramContext = paramString1.trim())
    {
      this.c = paramContext;
      this.d = paramString2;
      this.e = paramInt;
      this.f = paramLong;
      this.k = paramoq;
      this.l = Boolean.valueOf(paramBoolean);
      a(paramBoolean);
      return;
    }
  }

  private void a(int paramInt)
  {
    a(paramInt, 200);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    or.a("Downloader", "changeState:" + paramInt1 + ",url:" + this.c + ", http code: " + paramInt2);
    if (this.k != null)
      this.k.a(this, this.c, this.a, paramInt2);
  }

  private void a(final boolean paramBoolean)
  {
    a(1);
    new Thread(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: iconst_m1
        //   1: istore 5
        //   3: aload_0
        //   4: getfield 18	oo$1:b	Loo;
        //   7: invokestatic 30	oo:a	(Loo;)J
        //   10: lconst_0
        //   11: lcmp
        //   12: ifne +229 -> 241
        //   15: new 32	java/net/URL
        //   18: dup
        //   19: aload_0
        //   20: getfield 18	oo$1:b	Loo;
        //   23: invokestatic 35	oo:b	(Loo;)Ljava/lang/String;
        //   26: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
        //   29: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   32: checkcast 44	java/net/HttpURLConnection
        //   35: astore_1
        //   36: iload 5
        //   38: istore 4
        //   40: aload_1
        //   41: sipush 5000
        //   44: invokevirtual 48	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   47: iload 5
        //   49: istore 4
        //   51: aload_1
        //   52: ldc 50
        //   54: invokevirtual 53	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   57: iload 5
        //   59: istore 4
        //   61: aload_1
        //   62: invokevirtual 57	java/net/HttpURLConnection:getResponseCode	()I
        //   65: istore 5
        //   67: iload 5
        //   69: istore 4
        //   71: aload_0
        //   72: getfield 18	oo$1:b	Loo;
        //   75: aload_1
        //   76: invokevirtual 60	java/net/HttpURLConnection:getContentLength	()I
        //   79: i2l
        //   80: invokestatic 63	oo:a	(Loo;J)J
        //   83: pop2
        //   84: iload 5
        //   86: istore 4
        //   88: ldc 65
        //   90: new 67	java/lang/StringBuilder
        //   93: dup
        //   94: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   97: ldc 70
        //   99: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: aload_0
        //   103: getfield 18	oo$1:b	Loo;
        //   106: invokestatic 30	oo:a	(Loo;)J
        //   109: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   112: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   115: invokestatic 86	or:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   118: iload 5
        //   120: istore 4
        //   122: aload_1
        //   123: astore_2
        //   124: aload_0
        //   125: getfield 18	oo$1:b	Loo;
        //   128: invokestatic 30	oo:a	(Loo;)J
        //   131: lconst_0
        //   132: lcmp
        //   133: ifle +25 -> 158
        //   136: aload_1
        //   137: astore_2
        //   138: aload_0
        //   139: getfield 18	oo$1:b	Loo;
        //   142: aload_0
        //   143: getfield 20	oo$1:a	Z
        //   146: invokestatic 88	oo:a	(Loo;Z)V
        //   149: aload_1
        //   150: ifnull +7 -> 157
        //   153: aload_1
        //   154: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
        //   157: return
        //   158: aload_1
        //   159: astore_2
        //   160: aload_0
        //   161: getfield 18	oo$1:b	Loo;
        //   164: bipush 6
        //   166: iload 4
        //   168: invokestatic 94	oo:a	(Loo;II)V
        //   171: goto -22 -> 149
        //   174: astore_3
        //   175: aload_1
        //   176: astore_2
        //   177: aload_3
        //   178: invokestatic 97	or:a	(Ljava/lang/Throwable;)V
        //   181: aload_1
        //   182: astore_2
        //   183: aload_0
        //   184: getfield 18	oo$1:b	Loo;
        //   187: bipush 6
        //   189: iload 4
        //   191: invokestatic 94	oo:a	(Loo;II)V
        //   194: aload_1
        //   195: ifnull -38 -> 157
        //   198: aload_1
        //   199: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
        //   202: return
        //   203: astore_1
        //   204: aconst_null
        //   205: astore_2
        //   206: aload_2
        //   207: ifnull +7 -> 214
        //   210: aload_2
        //   211: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
        //   214: aload_1
        //   215: athrow
        //   216: astore_3
        //   217: aload_1
        //   218: astore_2
        //   219: aload_3
        //   220: astore_1
        //   221: goto -15 -> 206
        //   224: astore_1
        //   225: goto -19 -> 206
        //   228: astore_3
        //   229: aconst_null
        //   230: astore_1
        //   231: iconst_m1
        //   232: istore 4
        //   234: goto -59 -> 175
        //   237: astore_3
        //   238: goto -63 -> 175
        //   241: aconst_null
        //   242: astore_1
        //   243: iconst_m1
        //   244: istore 4
        //   246: goto -124 -> 122
        //
        // Exception table:
        //   from	to	target	type
        //   124	136	174	java/lang/Exception
        //   138	149	174	java/lang/Exception
        //   160	171	174	java/lang/Exception
        //   3	36	203	finally
        //   40	47	216	finally
        //   51	57	216	finally
        //   61	67	216	finally
        //   71	84	216	finally
        //   88	118	216	finally
        //   124	136	224	finally
        //   138	149	224	finally
        //   160	171	224	finally
        //   177	181	224	finally
        //   183	194	224	finally
        //   3	36	228	java/lang/Exception
        //   40	47	237	java/lang/Exception
        //   51	57	237	java/lang/Exception
        //   61	67	237	java/lang/Exception
        //   71	84	237	java/lang/Exception
        //   88	118	237	java/lang/Exception
      }
    }).start();
  }

  private boolean a(String paramString)
  {
    return on.a(this.h, paramString);
  }

  private void b(String paramString)
  {
    on.c(this.h, paramString);
  }

  private void b(boolean paramBoolean)
  {
    if (this.e < 1)
      this.e = 1;
    File localFile = new File(this.d);
    if (!localFile.getParentFile().exists())
      localFile.getParentFile().mkdirs();
    long l1;
    int m;
    os localos;
    if (a(this.c))
    {
      l1 = this.f / this.e;
      this.i = new ArrayList();
      m = 0;
      while (m < this.e - 1)
      {
        localos = new os(m, m * l1, (m + 1) * l1 - 1L, 0L, this.c);
        this.i.add(localos);
        m += 1;
      }
      localos = new os(this.e - 1, (this.e - 1) * l1, this.f - 1L, 0L, this.c);
      this.i.add(localos);
      if (!paramBoolean);
    }
    while (true)
    {
      try
      {
        if (localFile.exists())
          localFile.delete();
        on.a(this.h, this.i);
        a(2);
        if (this.b)
          c();
        return;
      }
      catch (Exception localException)
      {
        or.a(localException);
        continue;
      }
      this.i = on.b(this.h, this.c);
      Iterator localIterator = this.i.iterator();
      for (m = 0; localIterator.hasNext(); m = (int)(localos.d + l1))
      {
        localos = (os)localIterator.next();
        if (localos.d >= localos.c - localos.b)
          localos.d = 0L;
        l1 = m;
      }
      this.g = m;
    }
  }

  private int e()
  {
    f();
    if (this.f <= 0L)
      return 0;
    return (int)(this.g * 100L / this.f);
  }

  private void f()
  {
    if (this.i != null)
    {
      Iterator localIterator = this.i.iterator();
      for (long l1 = 0L; localIterator.hasNext(); l1 = ((os)localIterator.next()).d + l1);
      if (l1 != 0L)
        this.g = l1;
    }
  }

  private void g()
  {
    int n = 1;
    int m = 1;
    label283: 
    while (true)
      try
      {
        Object localObject1;
        Object localObject3;
        if (this.i != null)
        {
          localObject1 = this.i.iterator();
          long l1 = 0L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (os)((Iterator)localObject1).next();
            l1 += ((os)localObject3).d;
            if (((os)localObject3).d >= ((os)localObject3).c - ((os)localObject3).b)
              break label283;
            m = 0;
            break label283;
          }
          n = m;
          if (l1 != 0L)
          {
            this.g = l1;
            n = m;
          }
        }
        if ((n != 0) && (this.a == 3))
        {
          localObject1 = new File(this.d + ".te");
          localObject3 = new File(this.d);
          if ((((File)localObject3).exists()) && (((File)localObject3).length() == this.f))
            a(5);
          if ((((File)localObject1).exists()) && (((File)localObject1).length() == this.f))
          {
            new File(this.d + ".te").renameTo(new File(this.d));
            b(this.c);
            a(5);
          }
          if (b() == 3)
          {
            this.f = 0L;
            a(this.l.booleanValue());
          }
        }
        return;
      }
      finally
      {
      }
  }

  public String a()
  {
    return this.d;
  }

  public int b()
  {
    return this.a;
  }

  public void c()
  {
    if (this.i != null)
    {
      if (this.a == 3);
      int m;
      do
      {
        return;
        if (this.j != null)
          this.j.clear();
        while (true)
        {
          Iterator localIterator = this.i.iterator();
          m = 1;
          while (localIterator.hasNext())
          {
            Object localObject = (os)localIterator.next();
            if (((os)localObject).c - ((os)localObject).b > ((os)localObject).d)
            {
              m = 0;
              localObject = new op(this, (os)localObject);
              ((op)localObject).start();
              this.j.add(localObject);
            }
          }
          this.j = new ArrayList();
        }
        a(3);
      }
      while (m == 0);
      g();
      return;
    }
    this.b = true;
  }

  public void d()
  {
    a(4);
    if (this.j != null)
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
        ((op)localIterator.next()).a();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     oo
 * JD-Core Version:    0.6.2
 */