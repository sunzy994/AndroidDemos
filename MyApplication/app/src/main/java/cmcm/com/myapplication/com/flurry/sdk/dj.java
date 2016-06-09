package cmcm.com.myapplication.com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import com.flurry.android.impl.analytics.FlurryAnalyticsModule;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class dj
  implements dm.b, dq.a
{
  static int a = 100;
  static int b = 10;
  static int c = 1000;
  static int d = 160000;
  static int e = 50;
  static int f = 20;
  private static final String g = dj.class.getSimpleName();
  private String A = "";
  private String B = "";
  private byte C = -1;
  private Location D;
  private boolean E;
  private String F;
  private byte G;
  private long H;
  private long I;
  private final Map<String, cx.a> J = new HashMap();
  private final List<db> K = new ArrayList();
  private boolean L;
  private int M;
  private final List<da> N = new ArrayList();
  private int O;
  private int P;
  private final cy Q = new cy();
  private Map<String, List<String>> R;
  private dm S;
  private int T;
  private boolean U = false;
  private final AtomicInteger h = new AtomicInteger(0);
  private final AtomicInteger i = new AtomicInteger(0);
  private final AtomicInteger j = new AtomicInteger(0);
  private final String k;
  private String l;
  private WeakReference<Context> m;
  private File n = null;
  private List<dh> o;
  private final Map<dr, ByteBuffer> p = new HashMap();
  private boolean q;
  private long r;
  private List<dh> s = new ArrayList();
  private AdvertisingIdClient.Info t;
  private byte[] u;
  private String v;
  private long w;
  private long x;
  private long y;
  private long z;

  public dj(String paramString)
  {
    el.a(4, g, "Creating new Flurry session");
    this.k = paramString;
    this.m = new WeakReference(null);
  }

  private void A()
  {
    try
    {
      el.a(3, g, "generating agent report");
      dc localdc = new dc(this.k, this.l, this.q, o(), this.r, this.w, this.s, p(), this.Q.a(false), a(), cx.a().b(), System.currentTimeMillis());
      this.o = new ArrayList(this.s);
      if ((localdc != null) && (localdc.a() != null))
      {
        el.a(3, g, "generated report of size " + localdc.a().length + " with " + this.s.size() + " reports.");
        a(localdc.a());
        this.s.removeAll(this.o);
        this.o = null;
        B();
        return;
      }
      el.d(g, "Error generating report");
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(6, g, "", localThrowable);
    }
  }

  private void B()
  {
    try
    {
      if (!fa.a(this.n))
        el.d(g, "Error persisting report: could not create directory");
      while (true)
      {
        return;
        try
        {
          DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(this.n));
          dk localdk = new dk();
          localdk.a(this.q);
          localdk.a(this.r);
          localdk.a(this.s);
          localdk.a(localDataOutputStream, this.k, i());
        }
        catch (Exception localException)
        {
          el.b(g, "Error saving persistent data", localException);
        }
      }
    }
    finally
    {
    }
  }

  // ERROR //
  private void C()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_4
    //   5: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
    //   8: new 232	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 315
    //   18: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
    //   25: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 171	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
    //   41: invokevirtual 323	java/io/File:exists	()Z
    //   44: istore 7
    //   46: iload 7
    //   48: ifeq +171 -> 219
    //   51: new 325	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
    //   59: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: astore_3
    //   63: new 328	java/io/DataInputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 331	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_2
    //   72: new 293	com/flurry/sdk/dk
    //   75: dup
    //   76: invokespecial 294	com/flurry/sdk/dk:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 173	com/flurry/sdk/dj:k	Ljava/lang/String;
    //   86: invokevirtual 334	com/flurry/sdk/dk:a	(Ljava/io/DataInputStream;Ljava/lang/String;)Z
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 336	com/flurry/sdk/dk:a	()Z
    //   95: putfield 190	com/flurry/sdk/dj:q	Z
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 338	com/flurry/sdk/dk:c	()J
    //   103: putfield 195	com/flurry/sdk/dj:r	J
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 341	com/flurry/sdk/dk:b	()Ljava/util/List;
    //   111: putfield 143	com/flurry/sdk/dj:s	Ljava/util/List;
    //   114: iconst_1
    //   115: istore 5
    //   117: aload_2
    //   118: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   121: aload_3
    //   122: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   125: iload 5
    //   127: istore 6
    //   129: iload 5
    //   131: ifne +25 -> 156
    //   134: iconst_3
    //   135: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
    //   138: ldc_w 348
    //   141: invokestatic 171	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
    //   148: invokevirtual 351	java/io/File:delete	()Z
    //   151: pop
    //   152: iload 5
    //   154: istore 6
    //   156: iload 6
    //   158: ifne +16 -> 174
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 190	com/flurry/sdk/dj:q	Z
    //   166: aload_0
    //   167: aload_0
    //   168: getfield 197	com/flurry/sdk/dj:w	J
    //   171: putfield 195	com/flurry/sdk/dj:r	J
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
    //   183: ldc_w 353
    //   186: aload_3
    //   187: invokestatic 313	com/flurry/sdk/el:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: aload_2
    //   191: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   194: aload_1
    //   195: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   198: iconst_0
    //   199: istore 5
    //   201: goto -76 -> 125
    //   204: aload_2
    //   205: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   208: aload_3
    //   209: invokestatic 346	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: iconst_4
    //   220: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
    //   223: ldc_w 355
    //   226: invokestatic 171	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   229: iconst_0
    //   230: istore 6
    //   232: goto -76 -> 156
    //   235: astore_1
    //   236: aconst_null
    //   237: astore_2
    //   238: goto -34 -> 204
    //   241: astore_1
    //   242: goto -38 -> 204
    //   245: astore 4
    //   247: aload_1
    //   248: astore_3
    //   249: aload 4
    //   251: astore_1
    //   252: goto -48 -> 204
    //   255: astore 4
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_3
    //   260: astore_1
    //   261: aload 4
    //   263: astore_3
    //   264: goto -84 -> 180
    //   267: astore 4
    //   269: aload_3
    //   270: astore_1
    //   271: aload 4
    //   273: astore_3
    //   274: goto -94 -> 180
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_3
    //   282: goto -78 -> 204
    //
    // Exception table:
    //   from	to	target	type
    //   51	63	177	java/lang/Exception
    //   4	46	214	finally
    //   117	125	214	finally
    //   134	152	214	finally
    //   161	174	214	finally
    //   190	198	214	finally
    //   204	214	214	finally
    //   219	229	214	finally
    //   63	72	235	finally
    //   72	114	241	finally
    //   180	190	245	finally
    //   63	72	255	java/lang/Exception
    //   72	114	267	java/lang/Exception
    //   51	63	277	finally
  }

  private void D()
  {
    this.T += 1;
  }

  private void E()
  {
    if (this.T > 0)
      this.T -= 1;
  }

  private String F()
  {
    return ".flurryagent." + Integer.toString(this.k.hashCode(), 16);
  }

  private int G()
  {
    return this.h.incrementAndGet();
  }

  private int H()
  {
    return this.i.incrementAndGet();
  }

  private void a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.K.iterator();
      while (localIterator.hasNext())
      {
        db localdb = (db)localIterator.next();
        if ((localdb.a()) && (!localdb.b()))
          localdb.a(paramLong);
      }
    }
    finally
    {
    }
  }

  private void a(dr paramdr, ByteBuffer paramByteBuffer)
  {
    synchronized (this.p)
    {
      this.p.put(paramdr, paramByteBuffer);
      return;
    }
  }

  private void a(byte[] paramArrayOfByte)
  {
    dd localdd = FlurryAnalyticsModule.getInstance().a();
    String str = "" + dn.a().b();
    localdd.b(paramArrayOfByte, this.k, str);
  }

  private Map<String, List<String>> d(Context paramContext)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if ((paramContext instanceof Activity))
    {
      Bundle localBundle = ((Activity)paramContext).getIntent().getExtras();
      localObject = localIterator;
      if (localBundle != null)
      {
        el.a(3, g, "Launch Options Bundle is present " + localBundle.toString());
        localObject = new HashMap();
        localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null)
          {
            paramContext = localBundle.get(str);
            if (paramContext != null);
            for (paramContext = paramContext.toString(); ; paramContext = "null")
            {
              ((Map)localObject).put(str, new ArrayList(Arrays.asList(new String[] { paramContext })));
              el.a(3, g, "Launch options Key: " + str + ". Its value: " + paramContext);
              break;
            }
          }
        }
      }
    }
    return localObject;
  }

  private void u()
  {
    dq localdq = dp.a();
    this.G = ((Byte)localdq.a("Gender")).byteValue();
    localdq.a("Gender", this);
    el.a(4, g, "initSettings, Gender = " + this.G);
    this.F = ((String)localdq.a("UserId"));
    localdq.a("UserId", this);
    el.a(4, g, "initSettings, UserId = " + this.F);
    this.E = ((Boolean)localdq.a("LogEvents")).booleanValue();
    localdq.a("LogEvents", this);
    el.a(4, g, "initSettings, LogEvents = " + this.E);
    this.H = ((Long)localdq.a("Age")).longValue();
    localdq.a("Age", this);
    el.a(4, g, "initSettings, BirthDate = " + this.H);
    this.I = ((Long)localdq.a("ContinueSessionMillis")).longValue();
    localdq.a("ContinueSessionMillis", this);
    el.a(4, g, "initSettings, ContinueSessionMillis = " + this.I);
  }

  private void v()
  {
    try
    {
      if (this.v != null)
      {
        el.a(3, g, "Fetched phone id");
        a(dr.a, ByteBuffer.wrap(this.v.getBytes()));
      }
      if (this.u != null)
      {
        el.a(3, g, "Fetched hashed IMEI");
        a(dr.b, ByteBuffer.wrap(this.u));
      }
      if (this.t != null)
      {
        el.a(3, g, "Fetched advertising id");
        a(dr.c, ByteBuffer.wrap(this.t.getId().getBytes()));
      }
      A();
      return;
    }
    catch (Throwable localThrowable)
    {
      el.a(6, g, "", localThrowable);
    }
  }

  private void w()
  {
    a(new fc()
    {
      public void a()
      {
        dh localdh = dj.this.d();
        dj.c(dj.this).clear();
        dj.c(dj.this).add(localdh);
        dj.d(dj.this);
      }
    });
  }

  private void x()
  {
    a(new fc()
    {
      public void a()
      {
        dj.e(dj.this);
      }
    });
  }

  private void y()
  {
    try
    {
      try
      {
        if (this.s.size() > 0);
        for (int i1 = 1; ; i1 = 0)
        {
          if (i1 != 0)
            A();
          return;
        }
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable)
    {
      el.a(6, g, "", localThrowable);
    }
  }

  private void z()
  {
    a(new fc()
    {
      public void a()
      {
        dz.a().d();
      }
    });
  }

  Map<String, List<String>> a()
  {
    return this.R;
  }

  public void a(Context paramContext)
  {
    try
    {
      el.a(4, g, "Initializing new Flurry session with context:" + paramContext);
      this.m = new WeakReference(paramContext);
      this.S = new dm(this);
      this.n = paramContext.getFileStreamPath(F());
      this.l = eb.a();
      this.y = -1L;
      this.O = 0;
      this.B = TimeZone.getDefault().getID();
      this.A = (Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry());
      this.L = true;
      this.M = 0;
      this.P = 0;
      this.R = d(paramContext);
      u();
      long l1 = SystemClock.elapsedRealtime();
      this.w = System.currentTimeMillis();
      this.x = l1;
      a(new fc()
      {
        public void a()
        {
          dj.a(dj.this, dw.a());
        }
      });
      a(new fc()
      {
        public void a()
        {
          dj.a(dj.this, dy.a());
        }
      });
      a(new fc()
      {
        public void a()
        {
          dj.a(dj.this, ea.a());
        }
      });
      a(new fc()
      {
        public void a()
        {
          dj.a(dj.this);
        }
      });
      a(new fc()
      {
        public void a()
        {
          dj.b(dj.this);
        }
      });
      em.a().a(this, paramContext);
      this.U = true;
      return;
    }
    finally
    {
      paramContext = finally;
    }
    throw paramContext;
  }

  public void a(fc paramfc)
  {
    do.a().c(paramfc);
  }

  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("Gender"))
    {
      this.G = ((Byte)paramObject).byteValue();
      el.a(4, g, "onSettingUpdate, Gender = " + this.G);
      return;
    }
    if (paramString.equals("UserId"))
    {
      this.F = ((String)paramObject);
      el.a(4, g, "onSettingUpdate, UserId = " + this.F);
      return;
    }
    if (paramString.equals("LogEvents"))
    {
      this.E = ((Boolean)paramObject).booleanValue();
      el.a(4, g, "onSettingUpdate, LogEvents = " + this.E);
      return;
    }
    if (paramString.equals("Age"))
    {
      this.H = ((Long)paramObject).longValue();
      el.a(4, g, "onSettingUpdate, Birthdate = " + this.H);
      return;
    }
    if (paramString.equals("ContinueSessionMillis"))
    {
      this.I = ((Long)paramObject).longValue();
      el.a(4, g, "onSettingUpdate, ContinueSessionMillis = " + this.I);
      return;
    }
    el.a(6, g, "onSettingUpdate internal error!");
  }

  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (paramString1 != null);
    while (true)
    {
      int i1;
      try
      {
        long l1;
        if ("uncaught".equals(paramString1))
        {
          i1 = 1;
          this.O += 1;
          if (this.N.size() < e)
          {
            l1 = System.currentTimeMillis();
            paramString1 = new da(H(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
            this.N.add(paramString1);
            el.d(g, "Error logged: " + paramString1.c());
          }
        }
        else
        {
          i1 = 0;
          continue;
        }
        if (i1 == 0)
          break label243;
        i1 = 0;
        if (i1 >= this.N.size())
          continue;
        da localda = (da)this.N.get(i1);
        if ((localda.c() != null) && (!"uncaught".equals(localda.c())))
        {
          l1 = System.currentTimeMillis();
          paramString1 = new da(H(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
          this.N.set(i1, paramString1);
          continue;
        }
      }
      finally
      {
      }
      i1 += 1;
      continue;
      label243: el.d(g, "Max errors logged. No more errors logged.");
    }
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    while (true)
    {
      db localdb;
      try
      {
        Iterator localIterator = this.K.iterator();
        int i1;
        if (localIterator.hasNext())
        {
          localdb = (db)localIterator.next();
          if (!localdb.a(paramString))
            continue;
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.x;
          if ((paramMap != null) && (paramMap.size() > 0) && (this.M < d))
          {
            i1 = this.M - localdb.d();
            paramString = new HashMap(localdb.c());
            localdb.a(paramMap);
            if (localdb.d() + i1 > d)
              break label202;
            if (localdb.c().size() <= b)
              continue;
            el.d(g, "MaxEventParams exceeded on endEvent: " + localdb.c().size());
            localdb.b(paramString);
          }
          localdb.a(l1 - l2);
        }
        return;
        this.M = (i1 + localdb.d());
        continue;
      }
      finally
      {
      }
      label202: localdb.b(paramString);
      this.L = false;
      this.M = d;
      el.d(g, "Event Log size exceeded. No more event details logged.");
    }
  }

  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    while (true)
    {
      long l1;
      long l2;
      String str;
      int i1;
      try
      {
        l1 = SystemClock.elapsedRealtime();
        l2 = this.x;
        str = fb.a(paramString);
        i1 = str.length();
        if (i1 == 0)
          return;
        paramString = (cx.a)this.J.get(str);
        if (paramString != null)
          break label242;
        if (this.J.size() < a)
        {
          paramString = new cx.a();
          paramString.a = 1;
          this.J.put(str, paramString);
          el.d(g, "Event count started: " + str);
          if ((!this.E) || (this.K.size() >= c) || (this.M >= d))
            break label373;
          if (paramMap != null)
            break label381;
          paramString = Collections.emptyMap();
          if (paramString.size() <= b)
            break label282;
          el.d(g, "MaxEventParams exceeded: " + paramString.size());
          continue;
        }
      }
      finally
      {
      }
      el.d(g, "Too many different events. Event not counted: " + str);
      continue;
      label242: paramString.a += 1;
      el.d(g, "Event count incremented: " + str);
      continue;
      label282: paramString = new db(G(), str, paramString, l1 - l2, paramBoolean);
      if (paramString.d() + this.M <= d)
      {
        this.K.add(paramString);
        i1 = this.M;
        this.M = (paramString.d() + i1);
      }
      else
      {
        this.M = d;
        this.L = false;
        el.d(g, "Event Log size exceeded. No more event details logged.");
        continue;
        label373: this.L = false;
        continue;
        label381: paramString = paramMap;
      }
    }
  }

  public void b()
  {
    this.q = true;
  }

  public void b(Context paramContext)
  {
    try
    {
      boolean bool = this.U;
      if (!bool);
      while (true)
      {
        return;
        el.d(g, "Start session with context: " + paramContext + " count:" + g());
        this.m = new WeakReference(paramContext);
        if (this.S.b())
          this.S.a();
        D();
        dz.a().c();
        this.D = dz.a().f();
        em.a().b(this, paramContext);
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  public void c()
  {
    try
    {
      boolean bool = this.U;
      if (!bool);
      while (true)
      {
        return;
        el.d(g, "Finalize session");
        if (this.S.b())
          this.S.a();
        if (g() != 0)
          el.a(6, g, "Session with apiKey = " + j() + " was ended while getSessionCount() is not 0");
        this.T = 0;
        x();
        em.a().a(this);
        a(new fc()
        {
          public void a()
          {
            dl.a().a(dj.this.j());
          }
        });
        dp.a().b("Gender", this);
        dp.a().b("UserId", this);
        dp.a().b("Age", this);
        dp.a().b("LogEvents", this);
        dp.a().b("ContinueSessionMillis", this);
      }
    }
    finally
    {
    }
  }

  public void c(Context paramContext)
  {
    try
    {
      boolean bool = this.U;
      if (!bool);
      while (true)
      {
        return;
        em.a().c(this, paramContext);
        this.D = dz.a().f();
        z();
        E();
        el.d(g, "End session with context: " + paramContext + " count:" + g());
        this.y = (SystemClock.elapsedRealtime() - this.x);
        a(this.y);
        w();
        if (g() == 0)
          this.S.a(this.I);
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  dh d()
  {
    try
    {
      Object localObject1 = new di();
      ((di)localObject1).a(this.l);
      ((di)localObject1).a(this.w);
      ((di)localObject1).b(this.y);
      ((di)localObject1).c(this.z);
      ((di)localObject1).b(k());
      ((di)localObject1).c(l());
      ((di)localObject1).a(this.C);
      ((di)localObject1).d(h());
      ((di)localObject1).a(this.D);
      ((di)localObject1).b(f());
      ((di)localObject1).a(this.G);
      ((di)localObject1).a(Long.valueOf(this.H));
      ((di)localObject1).a(t());
      ((di)localObject1).a(r());
      ((di)localObject1).a(this.L);
      ((di)localObject1).b(s());
      ((di)localObject1).c(this.O);
      try
      {
        localObject1 = new dh((di)localObject1);
        if (localObject1 == null)
          el.d(g, "New session report wasn't created");
        return localObject1;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          localIOException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    finally
    {
    }
  }

  public void e()
  {
    try
    {
      this.P += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int f()
  {
    return this.P;
  }

  int g()
  {
    return this.T;
  }

  String h()
  {
    if (this.F == null)
      return "";
    return this.F;
  }

  public String i()
  {
    return this.v;
  }

  public String j()
  {
    return this.k;
  }

  public String k()
  {
    return this.A;
  }

  public String l()
  {
    return this.B;
  }

  public long m()
  {
    return this.w;
  }

  public long n()
  {
    return this.x;
  }

  public boolean o()
  {
    return (this.t == null) || (!this.t.isLimitAdTrackingEnabled());
  }

  public Map<dr, ByteBuffer> p()
  {
    return new HashMap(this.p);
  }

  public void q()
  {
    c();
  }

  List<db> r()
  {
    return this.K;
  }

  List<da> s()
  {
    return this.N;
  }

  Map<String, cx.a> t()
  {
    return this.J;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dj
 * JD-Core Version:    0.6.2
 */