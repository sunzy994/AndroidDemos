package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kv
{
  private static kv A;
  private static final String e = System.getProperty("line.separator");
  private static final String[] x = { "U", "D", "I", "C", "O", "N", "B", "M", "W", "P", "S", "Q", "V", "K", "A", "H" };
  private static final String[] y = { "pkg", "ms", "c", "w", "n", "iso", "lang", "pdtid", "pvc", "u", "par1", "par2", "b", "m", "aos", "aon", "o", "p1", "p2" };
  private Context B;
  private SparseArray<int[]> C;
  private long D = 0L;
  private int E = 5;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private String I = "none";
  private int J = -2;
  public String a = null;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = "";
  private boolean o = false;
  private String p = "";
  private String q = null;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private long z = 0L;

  private void A()
  {
    if (this.H)
      return;
    try
    {
      new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            if ((kv.this.l()) || (!kv.a(kv.this, kv.a(kv.this))))
            {
              if (kn.a)
                kx.d("DF_QA", "发送普通事件3~5 isSend:" + kv.this.l());
              kl.a().a(kv.a(kv.this));
              return null;
            }
            if (TextUtils.isEmpty(kv.this.b()))
            {
              if (kn.a)
                kx.d("DF_QA", "发送普通事件3~5 getUseId:" + kv.this.b());
              kl.a().a(kv.a(kv.this));
              return null;
            }
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
            paramAnonymousArrayOfObject.printStackTrace();
            kl.a().a(kv.a(kv.this));
          }
          Object localObject;
          while (true)
          {
            kv.this.c(false);
            kv.c(kv.this, null);
            return null;
            if (ky.e(kv.a(kv.this)) == null)
            {
              if (kn.a)
                kx.d("DF_QA", "无网络..........");
              kl.a().a(kv.a(kv.this));
              return null;
            }
            kv.this.c(true);
            paramAnonymousArrayOfObject = kv.this.b().substring(0, 2) + kv.this.b().substring(kv.this.b().length() - 4, kv.this.b().length());
            long l = System.currentTimeMillis();
            localObject = paramAnonymousArrayOfObject + l + ".txt";
            str1 = kv.d(kv.this);
            if (kn.a)
              kx.a("DF_QA", "发送普通事件3~5 data:" + str1);
            if (!TextUtils.isEmpty(str1))
            {
              if (!kv.a(kv.this, str1, (String)localObject, false))
                break label792;
              ky.a(kv.this.a + "/" + (String) localObject, kv.this.a + paramAnonymousArrayOfObject + l + ".zip", true, "java zip");
              localObject = new File(kv.this.a + paramAnonymousArrayOfObject + l + ".zip");
              if (((File)localObject).exists())
                break;
              kl.a().a(kv.a(kv.this));
            }
          }
          String str1 = ku.b(ky.a((File) localObject));
          if (kv.this.k());
          for (paramAnonymousArrayOfObject = "http://dh.lazyswipe.com/l/api/log/operate/write"; ; paramAnonymousArrayOfObject = "http://dh.lazyswipe.cn/l/api/log/operate/write")
          {
            if (kv.this.j())
              paramAnonymousArrayOfObject = "http://log.test.qiigame.com/l/api/log/operate/write";
            if (!TextUtils.isEmpty(paramAnonymousArrayOfObject))
            {
              String str2 = paramAnonymousArrayOfObject.substring("http://".length(), paramAnonymousArrayOfObject.indexOf("/l/api"));
              boolean bool2 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject, null, "2", false);
              boolean bool1;
              if (!bool2)
              {
                String str3 = kv.a(kv.this, "purl_ip");
                bool1 = bool2;
                if (!TextUtils.isEmpty(str3))
                  bool1 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject.replace(str2, str3), str2, "2", false);
                label648: if (bool1)
                  break label762;
                kl.a().a(kv.a(kv.this));
              }
              while (true)
              {
                new kz(kv.a(kv.this)).a();
                ((File)localObject).delete();
                break;
                str1 = ky.e(str2);
                if (kn.a)
                  Log.v("DF_QA", "sendFileData newURL:" + paramAnonymousArrayOfObject.replace(str2, str1));
                bool1 = bool2;
                if (TextUtils.isEmpty(str1))
                  break label648;
                kv.a(kv.this, "purl_ip", str1);
                bool1 = bool2;
                break label648;
                label762: kl.a().b(kv.a(kv.this));
                kl.a().d(kv.a(kv.this));
              }
              label792: kl.a().a(kv.a(kv.this));
              break;
            }
            return null;
          }
        }
      }
      .execute(new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void B()
  {
    if (kn.a)
      kx.a("DF_QA", "initSendRule");
    try
    {
      Object localObject1 = x();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        k(null);
        return;
      }
      localObject1 = u((String)localObject1);
      Object localObject2 = ((kb)localObject1).b();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        break label166;
      this.C = new SparseArray();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        jz localjz = (jz)((Iterator)localObject2).next();
        int i1 = localjz.c();
        int i2 = localjz.a();
        int i3 = localjz.b();
        this.C.put(i1, new int[] { i2, i3 });
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    a(localThrowable.c());
    a(localThrowable.d());
    h(localThrowable.e());
    return;
    label166: k(null);
  }

  private int C()
  {
    int i3 = 0;
    int i1 = 0;
    Object localObject = b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).toCharArray();
      int i4 = localObject.length;
      int i2 = 0;
      while (true)
      {
        i3 = i1;
        if (i2 >= i4)
          break;
        i3 = localObject[i2];
        i2 += 1;
        i1 = i3 + i1;
      }
    }
    return Math.abs(i3) % 100;
  }

  private String D()
  {
    try
    {
      if ((this.C == null) || (this.C.size() == 0))
      {
        B();
        return null;
      }
      localObject2 = "";
      Object localObject3 = kl.a().a(this.B, 7);
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject3).size() != 0)
        {
          localObject3 = ((List)localObject3).iterator();
          localObject1 = "";
          while (((Iterator)localObject3).hasNext())
          {
            kw localkw = (kw)((Iterator)localObject3).next();
            String str = ky.a(7, 0L, localkw.b(), localkw.d());
            localObject2 = localObject1;
            if (((String)localObject1).getBytes().length + str.getBytes().length >= 1000000)
              break label170;
            localObject1 = (String)localObject1 + str;
            kl.a().a(this.B, localkw, 1);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return "";
    }
    Object localObject2 = localThrowable;
    label170: return localObject2;
  }

  private String E()
  {
    Object localObject3 = "";
    kw localkw;
    String str;
    try
    {
      localObject4 = kl.a().a(this.B, 0);
      Object localObject1 = localObject3;
      if (localObject4 == null)
        break label143;
      localObject1 = localObject3;
      if (((List)localObject4).size() == 0)
        break label143;
      localObject4 = ((List)localObject4).iterator();
      localObject3 = "";
      while (true)
      {
        if (!((Iterator)localObject4).hasNext())
          break label141;
        localkw = (kw)((Iterator)localObject4).next();
        str = ky.a(0, 0L, localkw.b(), null);
        localObject1 = localObject3;
        if (((String)localObject3).getBytes().length + str.getBytes().length >= 1000000)
          break;
        localObject3 = (String)localObject3 + str;
        kl.a().a(this.B, localkw, 1);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject2 = "";
    }
    return localObject2;
    label141: Object localObject2 = localObject3;
    label143: Object localObject4 = kl.a().a(this.B, 1);
    localObject3 = localObject2;
    if (localObject4 != null)
    {
      localObject3 = localObject2;
      if (((List)localObject4).size() != 0)
      {
        localObject4 = ((List)localObject4).iterator();
        localObject3 = localObject2;
        while (true)
        {
          if (!((Iterator)localObject4).hasNext())
            break label407;
          localkw = (kw)((Iterator)localObject4).next();
          str = ky.a(1, 0L, localkw.b(), localkw.d());
          localObject2 = localObject3;
          if (((String)localObject3).getBytes().length + str.getBytes().length >= 1000000)
            break;
          localObject3 = (String)localObject3 + str;
          kl.a().a(this.B, localkw, 1);
        }
      }
    }
    label403: label407: 
    while (true)
    {
      localObject4 = kl.a().a(this.B, 2);
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject4).size() != 0)
        {
          localObject4 = ((List)localObject4).iterator();
          while (true)
          {
            if (!((Iterator)localObject4).hasNext())
              break label403;
            localkw = (kw)((Iterator)localObject4).next();
            str = ky.a(2, 0L, localkw.b(), localkw.d());
            localObject2 = localObject3;
            if (((String)localObject3).getBytes().length + str.getBytes().length >= 1000000)
              break;
            localObject3 = (String)localObject3 + str;
            kl.a().a(this.B, localkw, 1);
          }
          localObject2 = localObject3;
        }
      }
      return localObject2;
    }
  }

  private void F()
  {
    if (this.H)
      return;
    new AsyncTask()
    {
      protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
      {
        try
        {
          if (TextUtils.isEmpty(kv.this.b()))
          {
            if (!kn.a)
              break label446;
            Log.w("DF_QA", "sendAdvertisementData getUseId:" + kv.this.b());
            return null;
          }
          if ((kv.this.l()) || (ky.e(kv.a(kv.this)) == null))
          {
            if (!kn.a)
              break label446;
            Log.w("DF_QA", "无网络.........." + kv.this.l());
            return null;
          }
        }
        catch (Throwable paramAnonymousArrayOfObject)
        {
          if (kn.a)
            Log.w("system.err", paramAnonymousArrayOfObject);
          paramAnonymousArrayOfObject.printStackTrace();
        }
        String str1;
        do
        {
          kv.this.c(false);
          kv.g(kv.this);
          return null;
          kv.this.c(true);
          str1 = kv.f(kv.this);
        }
        while (TextUtils.isEmpty(str1));
        if (kv.this.k());
        for (paramAnonymousArrayOfObject = "http://mo.haloapps.com/ad/api/log/ad/write"; ; paramAnonymousArrayOfObject = "http://mo.haloapps.cn/ad/api/log/ad/write")
        {
          if (kv.this.j())
            paramAnonymousArrayOfObject = "http://mo.test.haloapps.com/ad/api/log/ad/write";
          String str2 = paramAnonymousArrayOfObject.substring("http://".length(), paramAnonymousArrayOfObject.indexOf("/ad/api"));
          boolean bool2 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject, null, "4", true);
          boolean bool1;
          if (!bool2)
          {
            String str3 = kv.a(kv.this, "adurl_ip");
            bool1 = bool2;
            if (!TextUtils.isEmpty(str3))
              bool1 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject.replace(str2, str3), str2, "4", true);
          }
          while (true)
          {
            if (bool1)
              break label399;
            new kz(kv.a(kv.this)).a();
            kl.a().a(kv.a(kv.this));
            break;
            str1 = ky.e(str2);
            if (kn.a)
              Log.v("DF_QA", "sendAdvertisementData() newURL:" + paramAnonymousArrayOfObject.replace(str2, str1));
            bool1 = bool2;
            if (!TextUtils.isEmpty(str1))
            {
              kv.a(kv.this, "adurl_ip", str1);
              bool1 = bool2;
            }
          }
          label399: new kz(kv.a(kv.this)).a();
          kl.a().b(kv.a(kv.this));
          kl.a().d(kv.a(kv.this));
          break;
          label446: return null;
        }
      }
    }
    .execute(new Object[0]);
  }

  private boolean G()
  {
    boolean bool = true;
    if (this.H)
      return true;
    String str = m("onlyWifi");
    if (!TextUtils.isEmpty(str))
      if (ky.b(str) != 1)
        break label44;
    while (true)
    {
      this.s = bool;
      return this.s;
      label44: bool = false;
    }
  }

  private int H()
  {
    kz localkz = new kz(this.B);
    int i1 = localkz.j();
    localkz.a();
    return i1;
  }

  private void I()
  {
    kz localkz = new kz(this.B);
    localkz.i();
    localkz.a();
  }

  public static kv a()
  {
    if (A == null)
      A = new kv();
    return A;
  }

  private void a(int paramInt)
  {
    if (this.H);
    do
    {
      return;
      this.E = paramInt;
      c("recount", String.valueOf(this.E));
    }
    while (!kn.a);
    Log.v("DF_QA", "setRecount:" + this.E);
  }

  private void a(final int paramInt, final long paramLong, String paramString1, final String paramString2)
  {
    new AsyncTask()
    {
      protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
      {
        if (kl.a().e(kv.a(kv.this)) >= 12000)
          kl.a().f(kv.a(kv.this));
        kl.a().a(kv.a(kv.this), paramLong, paramInt, paramString2, this.d, 0L);
        return null;
      }
    }
    .execute(new Object[0]);
  }

  // ERROR //
  private void a(final int paramInt, final String paramString1, final String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 24	kv$7
    //   5: dup
    //   6: aload_0
    //   7: iload_1
    //   8: aload_2
    //   9: aload_3
    //   10: invokespecial 419	kv$7:<init>	(Lkv;ILjava/lang/String;Ljava/lang/String;)V
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokevirtual 420	kv$7:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    //   29: astore_2
    //   30: goto -9 -> 21
    //
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
    //   2	21	29	java/lang/Throwable
  }

  private void a(long paramLong)
  {
    if (this.H);
    do
    {
      return;
      this.D = paramLong;
      c("interval", String.valueOf(this.D));
    }
    while (!kn.a);
    Log.v("DF_QA", "setInterval:" + this.D);
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    n(paramString1);
    o(paramString2);
    p(paramString3);
    q(paramString4);
    r(paramString5);
  }

  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    try
    {
      int i1 = ky.b(ky.a(this.B)) / 100;
      paramString2 = kr.a(paramString1, paramString2, paramString3, paramString4, paramBoolean, (String)kn.d.get(i1, "UN"));
      if (kn.a)
        Log.v("DF_QA", "onEvent_immediate address:" + paramString4);
      paramString2 = ky.a(paramString2);
      if ((paramString2 == null) || (paramString2.size() == 0) || (!"ok".equals(paramString2.get("content"))))
      {
        if (kn.a)
          Log.w("DF_QA", "发送数据失败");
        if ((paramString2 != null) && (!"error".equals(paramString2.get("content"))) && (!TextUtils.isEmpty((CharSequence)paramString2.get("hc"))) && (TextUtils.isEmpty(paramString4)))
          kr.a(this.B, paramString1, (String)paramString2.get("hc"), paramString5);
      }
      else
      {
        long l1 = ky.c((String) paramString2.get("date"));
        if (l1 != 0L)
          this.z = (l1 - System.currentTimeMillis());
        return true;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    return false;
  }

  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool1 = false;
    while (true)
    {
      int i1;
      try
      {
        boolean bool2 = TextUtils.isEmpty(paramString1);
        if (bool2)
        {
          paramBoolean = bool1;
          return paramBoolean;
        }
        try
        {
          if (TextUtils.isEmpty(this.a))
          {
            if (this.B == null)
              break label430;
            c(this.B);
          }
          paramString2 = new File(this.a + "/" + paramString2);
          Object localObject = paramString2.getParentFile();
          if (localObject != null);
          try
          {
            if (!((File)localObject).exists())
              ((File)localObject).mkdirs();
            localObject = new StringBuffer();
            if (paramBoolean)
              continue;
            ((StringBuffer)localObject).append(d(this.B)).append(e);
            paramString1 = paramString1.split(";");
            i2 = paramString1.length;
            i1 = 0;
            if (i1 >= i2)
              continue;
            ((StringBuffer)localObject).append(paramString1[i1]).append(e);
            i1 += 1;
            continue;
          }
          catch (Throwable paramString1)
          {
            paramString1.printStackTrace();
            paramBoolean = false;
          }
          continue;
          paramString1 = paramString1.split(";");
          int i2 = paramString1.length;
          i1 = 0;
          if (i1 < i2)
          {
            String[] arrayOfString = paramString1[i1].split(",");
            if (arrayOfString.length != 4)
              break label435;
            ((StringBuffer)localObject).append("[").append(e);
            long l1 = ky.c(arrayOfString[1]);
            ((StringBuffer)localObject).append(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.US).format(new Date(l1))).append(e);
            ((StringBuffer)localObject).append(arrayOfString[2]).append(e);
            ((StringBuffer)localObject).append("]").append(e);
            break label435;
          }
          paramString1 = ((StringBuffer)localObject).toString();
          if (kn.a)
            Log.v("DF_QA", "con:" + paramString1);
          paramString2 = new FileOutputStream(paramString2);
          localObject = new OutputStreamWriter(paramString2, "utf-8");
          ((Writer)localObject).write(paramString1);
          ((Writer)localObject).close();
          paramString2.close();
          paramBoolean = true;
        }
        catch (Throwable paramString1)
        {
          paramString1.printStackTrace();
          paramBoolean = bool1;
        }
        continue;
      }
      finally
      {
      }
      label430: paramBoolean = false;
      continue;
      label435: i1 += 1;
    }
  }

  private void b(int paramInt)
  {
    if (this.H);
    do
    {
      return;
      this.J = paramInt;
      c("optOutEnabled", String.valueOf(this.J));
    }
    while (!kn.a);
    Log.v("DF_QA", "setOptOutEnabled:" + this.J);
  }

  private void b(final int paramInt, final String paramString1, final String paramString2)
  {
    try
    {
      new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            String str1 = kv.this.b();
            if (kn.a)
              Log.v("DF_QA", "onEvent_immediate id :" + kv.b(kv.this));
            String str2 = ky.a(paramInt, 0L, paramString1, paramString2);
            if (kn.a)
              Log.v("DF_QA", "onEvent_immediate data1:" + str2);
            if (kv.this.k());
            for (paramAnonymousArrayOfObject = "http://dr.lazyswipe.com/l/api/log/timely/write"; ; paramAnonymousArrayOfObject = "http://dr.lazyswipe.cn/l/api/log/timely/write")
            {
              if (kv.this.j())
                paramAnonymousArrayOfObject = "http://log.test.qiigame.com/l/api/log/timely/write";
              if (TextUtils.isEmpty(paramAnonymousArrayOfObject))
                return null;
              String str3 = paramAnonymousArrayOfObject.substring("http://".length(), paramAnonymousArrayOfObject.indexOf("/l/api"));
              boolean bool2 = kv.a(kv.this, str1, str2, paramAnonymousArrayOfObject, null, "1", true);
              boolean bool1;
              if (!bool2)
              {
                String str4 = kv.a(kv.this, "iurl_ip");
                bool1 = bool2;
                if (!TextUtils.isEmpty(str4))
                  bool1 = kv.a(kv.this, str1, str2, paramAnonymousArrayOfObject.replace(str3, str4), str3, "1", true);
              }
              while (!bool1)
              {
                kl.a().a(kv.a(kv.this), 0L, paramString1, paramInt, paramString2, 0L);
                return null;
                str1 = ky.e(str3);
                if (kn.a)
                  Log.v("DF_QA", "onEvent_immediate newURL:" + paramAnonymousArrayOfObject.replace(str3, str1));
                bool1 = bool2;
                if (!TextUtils.isEmpty(str1))
                {
                  kv.a(kv.this, "iurl_ip", str1);
                  bool1 = bool2;
                }
              }
              return null;
            }
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
          }
          return null;
        }
      }
      .execute(new Object[0]);
      return;
    }
    finally
    {
      paramString1 = finally;
    }
    throw paramString1;
  }

  private void c(Context paramContext)
  {
    this.a = ("" + paramContext.getFilesDir());
  }

  private void c(final String paramString1, final String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(this.a))
      {
        if (this.B != null)
          c(this.B);
      }
      else
        new AsyncTask()
        {
          protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
          {
            kl.a().a(kv.a(kv.this), paramString1, paramString2);
            return null;
          }
        }
        .execute(new Object[0]);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }

  private String d(Context paramContext)
  {
    if (TextUtils.isEmpty(b()))
    {
      if (kn.a)
        Log.v("DF_QA", "未获取到useId");
      return null;
    }
    int i1 = ky.b(ky.a(paramContext)) / 100;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i2 = localDisplayMetrics.widthPixels;
    int i3 = localDisplayMetrics.heightPixels;
    if (kn.a)
      Log.v("DF_QA", "mSW1:" + i2 + ",mSH1:" + i3);
    return x[0] + ":" + b() + "`" + x[1] + ":" + ky.b(paramContext) + "`" + x[2] + ":" + ky.c(paramContext) + "`" + x[3] + ":" + (String)kn.d.get(i1, "UN") + "`" + x[4] + ":" + ky.a(paramContext) + "`" + x[5] + ":" + ky.j(paramContext) + "`" + x[6] + ":" + ky.d() + "`" + x[7] + ":" + ky.a() + "`" + x[8] + ":" + c() + "`" + x[9] + ":" + d() + "`" + x[10] + ":" + e() + "`" + x[11] + ":" + f() + "`" + x[12] + ":" + g() + "`" + x[13] + ":" + ky.b() + "`" + x[14] + ":" + Math.min(i2, i3) + "`" + x[15] + ":" + Math.max(i2, i3);
  }

  private boolean e(Context paramContext)
  {
    boolean bool2 = true;
    if (this.H)
      return false;
    boolean bool1 = bool2;
    if (G())
      if (!ky.f(paramContext))
        break label31;
    label31: for (bool1 = bool2; ; bool1 = false)
      return bool1;
  }

  private void h(boolean paramBoolean)
  {
    if (this.H)
      return;
    this.F = paramBoolean;
    if (this.F);
    for (String str = "1"; ; str = "0")
    {
      c("stable", str);
      if (!kn.a)
        break;
      Log.v("DF_QA", "setStable:" + this.F);
      return;
    }
  }

  private String m(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(this.a))
      {
        if (this.B != null)
          c(this.B);
      }
      else
      {
        paramString = kl.a().c(this.B, paramString);
        if (TextUtils.isEmpty(paramString))
          break label54;
        return paramString;
      }
      return "";
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    label54: return "";
  }

  private void n(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      do
      {
        return;
        this.g = paramString;
        if (!TextUtils.isEmpty(this.a))
          break;
      }
      while (this.B == null);
      c(this.B);
      c("woeId", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setWoeId:" + this.g);
  }

  private void o(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.h = paramString;
      c("productId", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setProductId:" + this.h);
  }

  private void p(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.i = paramString;
      c("supplierId", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setSupplierId:" + this.i);
  }

  private void q(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.j = paramString;
      c("channelId", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setChannelId:" + this.j);
  }

  private void r(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      do
      {
        return;
        this.k = paramString;
        if (!TextUtils.isEmpty(this.a))
          break;
      }
      while (this.B == null);
      c(this.B);
      c("versionCode", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setVersionCode:" + this.k);
  }

  private void s(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    this.q = paramString;
    c("sendRule", paramString);
  }

  private void t(String paramString)
  {
    if (this.H)
      return;
    try
    {
      new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            if ((kv.this.l()) || (!kv.a(kv.this, kv.a(kv.this))))
            {
              if (kn.a)
                Log.v("DF_QA", "发送日统计事件6 isSend:" + kv.this.l());
              kl.a().a(kv.a(kv.this));
              return null;
            }
            if (TextUtils.isEmpty(kv.this.b()))
            {
              if (kn.a)
                Log.w("DF_QA", "发送日统计事件6 getUseId:" + kv.this.b());
              kl.a().a(kv.a(kv.this));
              return null;
            }
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
            paramAnonymousArrayOfObject.printStackTrace();
            kl.a().a(kv.a(kv.this));
          }
          Object localObject;
          while (true)
          {
            kv.this.c(false);
            return null;
            if (ky.e(kv.a(kv.this)) == null)
            {
              kl.a().a(kv.a(kv.this));
              return null;
            }
            kv.this.c(true);
            paramAnonymousArrayOfObject = kv.this.b().substring(0, 2) + kv.this.b().substring(kv.this.b().length() - 4, kv.this.b().length());
            long l = System.currentTimeMillis();
            localObject = paramAnonymousArrayOfObject + l + ".txt";
            str1 = kv.c(kv.this);
            if (kn.a)
              kx.a("DF_QA", "发送日统计事件6 data:" + str1);
            if ((!TextUtils.isEmpty(str1)) && (kv.a(kv.this, str1, (String)localObject, false)))
            {
              ky.a(kv.this.a + "/" + (String) localObject, kv.this.a + paramAnonymousArrayOfObject + l + ".zip", true, "java zip");
              localObject = new File(kv.this.a + paramAnonymousArrayOfObject + l + ".zip");
              if (((File)localObject).exists())
                break;
              kl.a().a(kv.a(kv.this));
            }
          }
          String str1 = ku.b(ky.a((File) localObject));
          if (kv.this.k());
          for (paramAnonymousArrayOfObject = "http://dh.lazyswipe.com/l/api/log/operate/write"; ; paramAnonymousArrayOfObject = "http://dh.lazyswipe.cn/l/api/log/operate/write")
          {
            if (kv.this.j())
              paramAnonymousArrayOfObject = "http://log.test.qiigame.com/l/api/log/operate/write";
            if (!TextUtils.isEmpty(paramAnonymousArrayOfObject))
            {
              String str2 = paramAnonymousArrayOfObject.substring("http://".length(), paramAnonymousArrayOfObject.indexOf("/l/api"));
              boolean bool2 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject, null, "2", false);
              boolean bool1;
              if (!bool2)
              {
                String str3 = kv.a(kv.this, "purl_ip");
                bool1 = bool2;
                if (!TextUtils.isEmpty(str3))
                  bool1 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject.replace(str2, str3), str2, "2", false);
                label629: if (bool1)
                  break label726;
                kl.a().a(kv.a(kv.this));
              }
              while (true)
              {
                ((File)localObject).delete();
                break;
                str1 = ky.e(str2);
                if (kn.a)
                  Log.v("DF_QA", "sendFileData newURL:" + paramAnonymousArrayOfObject.replace(str2, str1));
                bool1 = bool2;
                if (TextUtils.isEmpty(str1))
                  break label629;
                kv.a(kv.this, "purl_ip", str1);
                bool1 = bool2;
                break label629;
                label726: kl.a().b(kv.a(kv.this));
                kl.a().d(kv.a(kv.this));
              }
            }
            return null;
          }
        }
      }
      .execute(new Object[0]);
      return;
    }
    catch (Throwable paramString)
    {
    }
  }

  private kb u(String paramString)
  {
    boolean bool1 = true;
    int i1 = 0;
    kb localkb = new kb();
    while (true)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        boolean bool2 = ((JSONObject)localObject).getBoolean("success");
        int i2 = ((JSONObject)localObject).getInt("statusCode");
        localkb.a(bool2);
        localkb.a(i2);
        localkb.a(((JSONObject)localObject).getLong("interval"));
        localkb.b(((JSONObject)localObject).getInt("recount"));
        if (((JSONObject)localObject).getInt("stable") == 1)
        {
          localkb.b(bool1);
          paramString = new ArrayList();
          localObject = ((JSONObject)localObject).getJSONArray("rules");
          i2 = ((JSONArray)localObject).length();
          if (i1 < i2)
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
            jz localjz = new jz();
            localjz.a(localJSONObject.getInt("start"));
            localjz.b(localJSONObject.getInt("end"));
            localjz.c(localJSONObject.getInt("type"));
            paramString.add(localjz);
            i1 += 1;
            continue;
          }
          localkb.a(paramString);
          return localkb;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localkb;
      }
      bool1 = false;
    }
  }

  private void v(String paramString)
  {
    if (this.H);
    do
    {
      return;
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
        str = "none";
      this.I = str;
      c("advertisingId", URLEncoder.encode(this.I));
    }
    while (!kn.a);
    Log.v("DF_QA", "setAdvertisingId:" + this.I);
  }

  private String x()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.q))
      this.q = m("sendRule");
    return this.q;
  }

  private String y()
  {
    Object localObject1;
    if ((this.C == null) || (this.C.size() == 0))
    {
      B();
      localObject1 = null;
    }
    String str1;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            str1 = "";
            localObject1 = str1;
          }
          while (C() < ((int[])this.C.get(6))[0]);
          localObject1 = str1;
        }
        while (C() > ((int[])this.C.get(6))[1]);
        localObject2 = kl.a().c(this.B);
        localObject1 = str1;
      }
      while (localObject2 == null);
      localObject1 = str1;
    }
    while (((List)localObject2).size() == 0);
    Object localObject2 = ((List)localObject2).iterator();
    while (true)
    {
      localObject1 = str1;
      if (!((Iterator)localObject2).hasNext())
        break;
      kw localkw = (kw)((Iterator)localObject2).next();
      String str2 = ky.a(6, localkw.a().longValue(), localkw.b(), String.valueOf(localkw.e()));
      localObject1 = str1;
      if (str1.getBytes().length + str2.getBytes().length >= 1000000)
        break;
      str1 = str1 + str2;
      kl.a().a(this.B, localkw, 1);
    }
  }

  private String z()
  {
    Object localObject6;
    Object localObject7;
    String str;
    try
    {
      if ((this.C == null) || (this.C.size() == 0))
      {
        B();
        return "";
      }
      if (kn.a)
        kx.a("DF_QA", "getUserValue(): " + C());
      localObject5 = "";
      Object localObject1 = localObject5;
      if (C() >= ((int[])this.C.get(3))[0])
      {
        localObject1 = localObject5;
        if (C() <= ((int[])this.C.get(3))[1])
        {
          localObject6 = kl.a().a(this.B, 3);
          localObject1 = localObject5;
          if (localObject6 != null)
          {
            localObject1 = localObject5;
            if (((List)localObject6).size() != 0)
            {
              localObject6 = ((List)localObject6).iterator();
              while (true)
              {
                localObject1 = localObject5;
                if (!((Iterator)localObject6).hasNext())
                  break label309;
                localObject7 = (kw)((Iterator)localObject6).next();
                str = ky.a(3, ((kw) localObject7).a().longValue(), ((kw) localObject7).b(), null);
                if ((((kw)localObject7).a().longValue() != 0L) || ("E3".equals(((kw)localObject7).b())) || (H() >= 50))
                  break;
                I();
                kl.a().a(this.B, ((kw)localObject7).b());
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
        return "";
        Object localObject2 = localObject5;
        if (((String)localObject5).getBytes().length + str.getBytes().length >= 1000000)
          break;
        localObject5 = (String)localObject5 + str;
        kl.a().a(this.B, (kw)localObject7, 1);
      }
    }
    finally
    {
    }
    label309: Object localObject5 = localObject3;
    if (C() >= ((int[])this.C.get(4))[0])
    {
      localObject5 = localObject3;
      if (C() <= ((int[])this.C.get(4))[1])
      {
        localObject6 = kl.a().a(this.B, 4);
        localObject5 = localObject3;
        if (localObject6 != null)
        {
          localObject5 = localObject3;
          if (((List)localObject6).size() != 0)
          {
            localObject7 = ((List)localObject6).iterator();
            localObject6 = localObject3;
            while (true)
            {
              localObject5 = localObject6;
              if (!((Iterator)localObject7).hasNext())
                break;
              localObject5 = (kw)((Iterator)localObject7).next();
              str = ky.a(4, ((kw) localObject5).a().longValue(), ((kw) localObject5).b(), ((kw) localObject5).d());
              if ((((kw)localObject5).a().longValue() == 0L) && (!"E3".equals(((kw)localObject5).b())) && (H() < 50))
              {
                I();
                kl.a().a(this.B, ((kw)localObject5).b());
              }
              else
              {
                localObject4 = localObject6;
                if (((String)localObject6).getBytes().length + str.getBytes().length >= 1000000)
                  break label788;
                localObject6 = (String)localObject6 + str;
                kl.a().a(this.B, (kw)localObject5, 1);
              }
            }
          }
        }
      }
    }
    Object localObject4 = localObject5;
    if (C() >= ((int[])this.C.get(5))[0])
    {
      localObject4 = localObject5;
      if (C() <= ((int[])this.C.get(5))[1])
      {
        localObject6 = kl.a().a(this.B, 5);
        localObject4 = localObject5;
        if (localObject6 != null)
        {
          localObject4 = localObject5;
          if (((List)localObject6).size() != 0)
          {
            localObject6 = ((List)localObject6).iterator();
            while (true)
            {
              localObject4 = localObject5;
              if (!((Iterator)localObject6).hasNext())
                break;
              localObject7 = (kw)((Iterator)localObject6).next();
              str = ky.a(5, ((kw) localObject7).a().longValue(), ((kw) localObject7).b(), ((kw) localObject7).d());
              if ((((kw)localObject7).a().longValue() == 0L) && (!"E3".equals(((kw)localObject7).b())) && (H() < 50))
              {
                I();
                kl.a().a(this.B, ((kw)localObject7).b());
              }
              else
              {
                localObject4 = localObject5;
                if (((String)localObject5).getBytes().length + str.getBytes().length >= 1000000)
                  break;
                localObject5 = (String)localObject5 + str;
                kl.a().a(this.B, (kw)localObject7, 1);
              }
            }
          }
        }
      }
    }
    label788: return localObject4;
  }

  public void a(Context paramContext)
  {
    try
    {
      this.B = paramContext;
      c(this.B);
      if (kn.a)
        kx.a("DF_QA", "mSavePath:" + this.a);
      if ((this.C == null) || (this.C.size() == 0))
        B();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }

  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (this.H)
        return;
      a(paramContext);
      a(paramString1, paramString2, paramString3, paramString4, paramString5);
      j(paramString5);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      if (kn.a)
        Log.e("DF_QA", "start 失败!");
    }
  }

  public void a(String paramString)
  {
    if (this.H);
    do
    {
      do
        return;
      while (TextUtils.isEmpty(paramString));
      this.f = paramString;
      c("useId", paramString);
    }
    while (!kn.a);
    kx.a("DF_QA", "setUseId:" + paramString + ", value:" + C());
  }

  public void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.H;
      if (bool);
      while (true)
      {
        return;
        if (!TextUtils.isEmpty(paramString1))
          b(1, paramString1, ky.a(paramString2, 1));
      }
    }
    finally
    {
    }
    throw paramString1;
  }

  public void a(String paramString, HashMap<String, String>[] paramArrayOfHashMap)
  {
    try
    {
      boolean bool = this.H;
      if (bool);
      while (true)
      {
        return;
        if (!TextUtils.isEmpty(paramString))
          b(2, paramString, ky.a(paramArrayOfHashMap));
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public void a(ks paramks)
  {
    paramks.a(true, -1);
  }

  public void a(boolean paramBoolean)
  {
    if (this.H)
      return;
    this.r = paramBoolean;
    if (this.r);
    for (String str = "1"; ; str = "0")
    {
      c("debug", str);
      if (!kn.a)
        break;
      Log.v("DF_QA", "setmDebug:" + this.r);
      return;
    }
  }

  public String b()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.f))
      this.f = m("useId");
    return this.f;
  }

  // ERROR //
  public String b(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 332	kl:a	()Lkl;
    //   3: aload_1
    //   4: ldc_w 894
    //   7: invokevirtual 722	kl:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 245	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +55 -> 70
    //   18: aload_1
    //   19: invokestatic 899	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: getstatic 227	kn:a	Z
    //   26: ifeq +28 -> 54
    //   29: ldc 229
    //   31: new 354	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 901
    //   41: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 236	kx:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_1
    //   55: areturn
    //   56: astore_2
    //   57: ldc 170
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 854	java/lang/Exception:printStackTrace	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: goto -7 -> 60
    //   70: ldc 170
    //   72: astore_1
    //   73: goto -50 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   0	23	56	java/lang/Exception
    //   23	54	66	java/lang/Exception
  }

  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.n = paramString;
      c("appsflyer_productid", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setAppsflyerProductId:" + this.n);
  }

  public void b(String paramString1, String paramString2)
  {
    try
    {
      if (kn.a)
        kx.a("DF_QA", "onEventR_4 ei:" + paramString1 + ",em:" + paramString2);
      if (this.H)
        return;
      if (!TextUtils.isEmpty(paramString1))
      {
        long l1 = System.currentTimeMillis();
        l1 = this.z + l1;
        paramString2 = ky.a(paramString2, 4);
        String str = ky.a(4, l1, paramString1, paramString2);
        if (kn.a)
          kx.a("DF_QA", "onEvent_4 data:" + str);
        a(4, l1, paramString1, paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }

  public void b(String paramString, HashMap<String, String>[] paramArrayOfHashMap)
  {
    try
    {
      boolean bool = this.H;
      if (bool);
      while (true)
      {
        return;
        if (!TextUtils.isEmpty(paramString))
          a(7, paramString, ky.a(paramArrayOfHashMap));
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public void b(boolean paramBoolean)
  {
    if (this.H)
      return;
    this.t = paramBoolean;
    if (this.t);
    for (String str = "1"; ; str = "0")
    {
      c("abroad", str);
      return;
    }
  }

  public String c()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.g))
      this.g = m("woeId");
    return this.g;
  }

  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.l = paramString;
      c("par1", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setPar1:" + this.l);
  }

  public void c(String paramString, HashMap<String, String>[] paramArrayOfHashMap)
  {
    try
    {
      if (kn.a)
        kx.a("DF_QA", "onEventR_5 ei:" + paramString + ",em:" + paramArrayOfHashMap.toString());
      if (this.H)
        return;
      if (!TextUtils.isEmpty(paramString))
      {
        long l1 = System.currentTimeMillis();
        l1 = this.z + l1;
        paramArrayOfHashMap = ky.a(paramArrayOfHashMap);
        String str = ky.a(5, l1, paramString, paramArrayOfHashMap);
        if (kn.a)
          kx.a("DF_QA", "onEvent_5 data:" + str);
        a(5, l1, paramString, paramArrayOfHashMap);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }

  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (this.u);
    for (String str = "1"; ; str = "0")
    {
      c("dataState", str);
      if (kn.a)
        Log.v("DF_QA", "setSend:" + this.u);
      return;
    }
  }

  public String d()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.h))
      this.h = m("productId");
    return this.h;
  }

  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return;
      this.m = paramString;
      c("par2", paramString);
    }
    while (!kn.a);
    Log.v("DF_QA", "setPar2:" + this.m);
  }

  public void d(boolean paramBoolean)
  {
    if (this.H)
      return;
    kn.a = paramBoolean;
  }

  public String e()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.i))
      this.i = m("supplierId");
    return this.i;
  }

  public void e(String paramString)
  {
    try
    {
      boolean bool = this.H;
      if (bool);
      while (true)
      {
        return;
        if (!TextUtils.isEmpty(paramString))
          b(0, paramString, null);
      }
    }
    finally
    {
    }
    throw paramString;
  }

  public void e(boolean paramBoolean)
  {
  }

  public String f()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.j))
      this.j = m("channelId");
    return this.j;
  }

  public void f(String paramString)
  {
    try
    {
      a(paramString, String.valueOf(System.currentTimeMillis() + this.z));
      return;
    }
    catch (Throwable paramString)
    {
      while (true)
        paramString.printStackTrace();
    }
    finally
    {
    }
    throw paramString;
  }

  public void f(boolean paramBoolean)
  {
    if (this.H)
      return;
    this.w = paramBoolean;
    if (this.w);
    for (String str = "1"; ; str = "0")
    {
      c("is_new_user", str);
      if (!kn.a)
        break;
      Log.v("DF_QA", "setIsNewUser:" + this.w);
      return;
    }
  }

  public String g()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.k))
      this.k = m("versionCode");
    return this.k;
  }

  public void g(String paramString)
  {
    try
    {
      if (kn.a)
        kx.a("DF_QA", "onEventR_3 ei:" + paramString);
      if (this.H)
        return;
      if (!TextUtils.isEmpty(paramString))
      {
        long l1 = System.currentTimeMillis();
        l1 = this.z + l1;
        if (kn.a)
        {
          String str = ky.a(3, l1, paramString, null);
          kx.a("DF_QA", "onEvent_3 data:" + str);
        }
        a(3, l1, paramString, "");
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }

  public void g(boolean paramBoolean)
  {
    if (this.H)
      return;
    if ((r()) && (!paramBoolean))
    {
      str = "";
      String[] arrayOfString = p().split(",");
      if (arrayOfString.length >= 2)
        str = arrayOfString[1];
      b("D1", s() + "_" + str);
    }
    this.o = paramBoolean;
    if (this.o);
    for (String str = "1"; ; str = "0")
    {
      c("promotionpackage", str);
      if (kn.a)
        Log.v("DF_QA", "setPromotionPackage:" + this.o);
      if (!this.o)
        break;
      this.B.getContentResolver().call(ke.a, String.valueOf(500), null, null);
      return;
    }
  }

  public String h()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.l))
      this.l = m("par1");
    return this.l;
  }

  public void h(final String paramString)
  {
    try
    {
      if (this.H)
        return;
      if (!TextUtils.isEmpty(paramString))
      {
        long l1 = ky.e();
        if (kn.a)
        {
          String str = ky.a(6, l1, paramString, null);
          kx.a("DF_QA", "onEvent_6 data:" + str);
        }
        new AsyncTask()
        {
          protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
          {
            if (kl.a().e(kv.a(kv.this)) >= 12000)
              kl.a().f(kv.a(kv.this));
            kl.a().a(kv.a(kv.this), paramString, 6L);
            return null;
          }
        }
        .execute(new Object[0]);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }

  public String i()
  {
    if (this.H)
      return "";
    if (TextUtils.isEmpty(this.m))
      this.m = m("par2");
    return this.m;
  }

  public void i(String paramString)
  {
    try
    {
      if (this.H)
        return;
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = ky.a(9, System.currentTimeMillis() + this.z, paramString, g());
        if (kn.a)
          kx.a("DF_QA", "onEvent_9 data:" + (String) localObject);
        localObject = kl.a().a(this.B, 9, paramString);
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          kl.a().a(this.B, System.currentTimeMillis() + this.z, paramString, 9, g(), 0L);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }

  public void j(final String paramString)
  {
    try
    {
      new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            kl.a().b(kv.a(kv.this), paramString);
            label18: return null;
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
            break label18;
          }
        }
      }
      .execute(new Object[0]);
      return;
    }
    catch (Throwable paramString)
    {
    }
  }

  public boolean j()
  {
    boolean bool = false;
    if (this.H)
      return false;
    try
    {
      String str = m("debug");
      if (!TextUtils.isEmpty(str))
      {
        if (ky.b(str) == 1)
          bool = true;
        this.r = bool;
      }
      return this.r;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        localThrowable.printStackTrace();
    }
  }

  public void k(final String paramString)
  {
    if (kn.a)
      kx.a("DF_QA", "requestSendRule");
    if (this.v)
      return;
    try
    {
      new AsyncTask()
      {
        // ERROR //
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 17	kv$4:b	Lkv;
          //   4: iconst_1
          //   5: invokestatic 30	kv:a	(Lkv;Z)Z
          //   8: pop
          //   9: aload_0
          //   10: getfield 17	kv$4:b	Lkv;
          //   13: invokevirtual 33	kv:k	()Z
          //   16: ifeq +41 -> 57
          //   19: ldc 35
          //   21: astore_1
          //   22: aload_0
          //   23: getfield 17	kv$4:b	Lkv;
          //   26: invokevirtual 38	kv:j	()Z
          //   29: ifeq +706 -> 735
          //   32: ldc 40
          //   34: astore_1
          //   35: aload_1
          //   36: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   39: istore 11
          //   41: iload 11
          //   43: ifeq +20 -> 63
          //   46: aload_0
          //   47: getfield 17	kv$4:b	Lkv;
          //   50: iconst_0
          //   51: invokestatic 30	kv:a	(Lkv;Z)Z
          //   54: pop
          //   55: aconst_null
          //   56: areturn
          //   57: ldc 48
          //   59: astore_1
          //   60: goto -38 -> 22
          //   63: aload_1
          //   64: ldc 50
          //   66: invokevirtual 56	java/lang/String:length	()I
          //   69: aload_1
          //   70: ldc 58
          //   72: invokevirtual 62	java/lang/String:indexOf	(Ljava/lang/String;)I
          //   75: invokevirtual 66	java/lang/String:substring	(II)Ljava/lang/String;
          //   78: astore_3
          //   79: aload_0
          //   80: getfield 17	kv$4:b	Lkv;
          //   83: invokevirtual 69	kv:b	()Ljava/lang/String;
          //   86: astore 4
          //   88: aload_0
          //   89: getfield 19	kv$4:a	Ljava/lang/String;
          //   92: astore 5
          //   94: aload_0
          //   95: getfield 19	kv$4:a	Ljava/lang/String;
          //   98: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   101: ifeq +143 -> 244
          //   104: aconst_null
          //   105: astore_2
          //   106: aload 4
          //   108: aload_1
          //   109: aload 5
          //   111: aload_2
          //   112: invokestatic 74	kr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   115: astore 4
          //   117: getstatic 79	kn:a	Z
          //   120: ifeq +28 -> 148
          //   123: ldc 81
          //   125: new 83	java/lang/StringBuilder
          //   128: dup
          //   129: invokespecial 84	java/lang/StringBuilder:<init>	()V
          //   132: ldc 86
          //   134: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   137: aload_3
          //   138: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   141: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   144: invokestatic 99	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
          //   147: pop
          //   148: invokestatic 105	java/lang/System:currentTimeMillis	()J
          //   151: lstore 9
          //   153: new 107	kz
          //   156: dup
          //   157: aload_0
          //   158: getfield 17	kv$4:b	Lkv;
          //   161: invokestatic 110	kv:a	(Lkv;)Landroid/content/Context;
          //   164: invokespecial 113	kz:<init>	(Landroid/content/Context;)V
          //   167: astore_2
          //   168: aload_2
          //   169: lload 9
          //   171: ldc2_w 114
          //   174: lsub
          //   175: invokevirtual 118	kz:a	(J)V
          //   178: aload_2
          //   179: invokevirtual 120	kz:a	()V
          //   182: aload 4
          //   184: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   187: ifne +493 -> 680
          //   190: aload 4
          //   192: ldc 122
          //   194: invokevirtual 126	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   197: ifne +13 -> 210
          //   200: aload 4
          //   202: ldc 128
          //   204: invokevirtual 126	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   207: ifeq +42 -> 249
          //   210: getstatic 79	kn:a	Z
          //   213: ifeq +11 -> 224
          //   216: ldc 81
          //   218: ldc 130
          //   220: invokestatic 133	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
          //   223: pop
          //   224: aload_0
          //   225: getfield 17	kv$4:b	Lkv;
          //   228: iconst_0
          //   229: invokestatic 30	kv:a	(Lkv;Z)Z
          //   232: pop
          //   233: aload_0
          //   234: getfield 17	kv$4:b	Lkv;
          //   237: iconst_0
          //   238: invokestatic 30	kv:a	(Lkv;Z)Z
          //   241: pop
          //   242: aconst_null
          //   243: areturn
          //   244: aload_3
          //   245: astore_2
          //   246: goto -140 -> 106
          //   249: aload_0
          //   250: getfield 17	kv$4:b	Lkv;
          //   253: aload 4
          //   255: invokestatic 137	kv:d	(Lkv;Ljava/lang/String;)Lkb;
          //   258: astore_2
          //   259: aload_2
          //   260: invokevirtual 141	kb:a	()Z
          //   263: ifeq +296 -> 559
          //   266: aload_0
          //   267: getfield 19	kv$4:a	Ljava/lang/String;
          //   270: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   273: ifeq +65 -> 338
          //   276: aload_3
          //   277: invokestatic 146	ky:e	(Ljava/lang/String;)Ljava/lang/String;
          //   280: astore 5
          //   282: getstatic 79	kn:a	Z
          //   285: ifeq +34 -> 319
          //   288: ldc 81
          //   290: new 83	java/lang/StringBuilder
          //   293: dup
          //   294: invokespecial 84	java/lang/StringBuilder:<init>	()V
          //   297: ldc 148
          //   299: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   302: aload_1
          //   303: aload_3
          //   304: aload 5
          //   306: invokevirtual 152	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
          //   309: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   312: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   315: invokestatic 99	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
          //   318: pop
          //   319: aload 5
          //   321: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   324: ifne +14 -> 338
          //   327: aload_0
          //   328: getfield 17	kv$4:b	Lkv;
          //   331: ldc 154
          //   333: aload 5
          //   335: invokestatic 157	kv:a	(Lkv;Ljava/lang/String;Ljava/lang/String;)V
          //   338: aload_0
          //   339: getfield 17	kv$4:b	Lkv;
          //   342: aload 4
          //   344: invokestatic 159	kv:e	(Lkv;Ljava/lang/String;)V
          //   347: invokestatic 105	java/lang/System:currentTimeMillis	()J
          //   350: lstore 9
          //   352: new 107	kz
          //   355: dup
          //   356: aload_0
          //   357: getfield 17	kv$4:b	Lkv;
          //   360: invokestatic 110	kv:a	(Lkv;)Landroid/content/Context;
          //   363: invokespecial 113	kz:<init>	(Landroid/content/Context;)V
          //   366: astore_1
          //   367: aload_1
          //   368: lload 9
          //   370: invokevirtual 118	kz:a	(J)V
          //   373: aload_1
          //   374: invokevirtual 120	kz:a	()V
          //   377: aload_2
          //   378: invokevirtual 162	kb:b	()Ljava/util/List;
          //   381: astore_1
          //   382: aload_0
          //   383: getfield 17	kv$4:b	Lkv;
          //   386: new 164	android/util/SparseArray
          //   389: dup
          //   390: invokespecial 165	android/util/SparseArray:<init>	()V
          //   393: invokestatic 168	kv:a	(Lkv;Landroid/util/SparseArray;)Landroid/util/SparseArray;
          //   396: pop
          //   397: aload_1
          //   398: invokeinterface 174 1 0
          //   403: astore_1
          //   404: aload_1
          //   405: invokeinterface 179 1 0
          //   410: ifeq +92 -> 502
          //   413: aload_1
          //   414: invokeinterface 183 1 0
          //   419: checkcast 185	jz
          //   422: astore_3
          //   423: aload_3
          //   424: invokevirtual 188	jz:c	()I
          //   427: istore 6
          //   429: aload_3
          //   430: invokevirtual 190	jz:a	()I
          //   433: istore 7
          //   435: aload_3
          //   436: invokevirtual 192	jz:b	()I
          //   439: istore 8
          //   441: aload_0
          //   442: getfield 17	kv$4:b	Lkv;
          //   445: invokestatic 195	kv:e	(Lkv;)Landroid/util/SparseArray;
          //   448: iload 6
          //   450: iconst_2
          //   451: newarray int
          //   453: dup
          //   454: iconst_0
          //   455: iload 7
          //   457: iastore
          //   458: dup
          //   459: iconst_1
          //   460: iload 8
          //   462: iastore
          //   463: invokevirtual 199	android/util/SparseArray:put	(ILjava/lang/Object;)V
          //   466: goto -62 -> 404
          //   469: astore_1
          //   470: aload_1
          //   471: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
          //   474: aload_0
          //   475: getfield 17	kv$4:b	Lkv;
          //   478: iconst_0
          //   479: invokestatic 30	kv:a	(Lkv;Z)Z
          //   482: pop
          //   483: goto -250 -> 233
          //   486: astore_1
          //   487: aload_1
          //   488: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
          //   491: aload_0
          //   492: getfield 17	kv$4:b	Lkv;
          //   495: iconst_0
          //   496: invokestatic 30	kv:a	(Lkv;Z)Z
          //   499: pop
          //   500: aconst_null
          //   501: areturn
          //   502: aload_0
          //   503: getfield 17	kv$4:b	Lkv;
          //   506: aload_2
          //   507: invokevirtual 204	kb:c	()J
          //   510: invokestatic 207	kv:a	(Lkv;J)V
          //   513: aload_0
          //   514: getfield 17	kv$4:b	Lkv;
          //   517: aload_2
          //   518: invokevirtual 209	kb:d	()I
          //   521: invokestatic 212	kv:c	(Lkv;I)V
          //   524: aload_0
          //   525: getfield 17	kv$4:b	Lkv;
          //   528: aload_2
          //   529: invokevirtual 214	kb:e	()Z
          //   532: invokestatic 217	kv:b	(Lkv;Z)V
          //   535: aload_0
          //   536: getfield 17	kv$4:b	Lkv;
          //   539: iconst_0
          //   540: invokestatic 30	kv:a	(Lkv;Z)Z
          //   543: pop
          //   544: goto -311 -> 233
          //   547: astore_1
          //   548: aload_0
          //   549: getfield 17	kv$4:b	Lkv;
          //   552: iconst_0
          //   553: invokestatic 30	kv:a	(Lkv;Z)Z
          //   556: pop
          //   557: aload_1
          //   558: athrow
          //   559: aload 4
          //   561: invokestatic 220	ky:a	(Ljava/lang/String;)Ljava/util/HashMap;
          //   564: astore_2
          //   565: aload_2
          //   566: ldc 222
          //   568: invokevirtual 228	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   571: checkcast 230	java/lang/CharSequence
          //   574: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   577: ifne +74 -> 651
          //   580: aload_0
          //   581: getfield 17	kv$4:b	Lkv;
          //   584: ldc 154
          //   586: invokestatic 233	kv:a	(Lkv;Ljava/lang/String;)Ljava/lang/String;
          //   589: astore 4
          //   591: aload_0
          //   592: getfield 19	kv$4:a	Ljava/lang/String;
          //   595: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   598: ifeq +53 -> 651
          //   601: aload_0
          //   602: getfield 17	kv$4:b	Lkv;
          //   605: invokestatic 110	kv:a	(Lkv;)Landroid/content/Context;
          //   608: aload_0
          //   609: getfield 17	kv$4:b	Lkv;
          //   612: invokevirtual 69	kv:b	()Ljava/lang/String;
          //   615: aload_2
          //   616: ldc 222
          //   618: invokevirtual 228	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   621: checkcast 52	java/lang/String
          //   624: ldc 235
          //   626: invokestatic 238	kr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   629: aload 4
          //   631: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   634: ifne +17 -> 651
          //   637: aload_0
          //   638: getfield 17	kv$4:b	Lkv;
          //   641: aload_1
          //   642: aload_3
          //   643: aload 4
          //   645: invokevirtual 152	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
          //   648: invokevirtual 239	kv:k	(Ljava/lang/String;)V
          //   651: getstatic 79	kn:a	Z
          //   654: ifeq -119 -> 535
          //   657: ldc 81
          //   659: ldc 241
          //   661: invokestatic 244	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   664: pop
          //   665: goto -130 -> 535
          //   668: astore_1
          //   669: aload_0
          //   670: getfield 17	kv$4:b	Lkv;
          //   673: iconst_0
          //   674: invokestatic 30	kv:a	(Lkv;Z)Z
          //   677: pop
          //   678: aload_1
          //   679: athrow
          //   680: getstatic 79	kn:a	Z
          //   683: ifeq +11 -> 694
          //   686: ldc 81
          //   688: ldc 246
          //   690: invokestatic 244	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   693: pop
          //   694: aload_0
          //   695: getfield 17	kv$4:b	Lkv;
          //   698: iconst_0
          //   699: invokestatic 30	kv:a	(Lkv;Z)Z
          //   702: pop
          //   703: goto -470 -> 233
          //   706: astore_1
          //   707: aload_1
          //   708: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
          //   711: aload_0
          //   712: getfield 17	kv$4:b	Lkv;
          //   715: iconst_0
          //   716: invokestatic 30	kv:a	(Lkv;Z)Z
          //   719: pop
          //   720: goto -487 -> 233
          //   723: astore_1
          //   724: aload_0
          //   725: getfield 17	kv$4:b	Lkv;
          //   728: iconst_0
          //   729: invokestatic 30	kv:a	(Lkv;Z)Z
          //   732: pop
          //   733: aload_1
          //   734: athrow
          //   735: goto -700 -> 35
          //
          // Exception table:
          //   from	to	target	type
          //   249	319	469	java/lang/Throwable
          //   319	338	469	java/lang/Throwable
          //   338	404	469	java/lang/Throwable
          //   404	466	469	java/lang/Throwable
          //   502	535	469	java/lang/Throwable
          //   559	651	469	java/lang/Throwable
          //   651	665	469	java/lang/Throwable
          //   0	19	486	java/lang/Throwable
          //   22	32	486	java/lang/Throwable
          //   35	41	486	java/lang/Throwable
          //   63	104	486	java/lang/Throwable
          //   106	148	486	java/lang/Throwable
          //   148	210	486	java/lang/Throwable
          //   210	224	486	java/lang/Throwable
          //   224	233	486	java/lang/Throwable
          //   474	483	486	java/lang/Throwable
          //   535	544	486	java/lang/Throwable
          //   669	680	486	java/lang/Throwable
          //   694	703	486	java/lang/Throwable
          //   711	720	486	java/lang/Throwable
          //   724	735	486	java/lang/Throwable
          //   0	19	547	finally
          //   22	32	547	finally
          //   35	41	547	finally
          //   63	104	547	finally
          //   106	148	547	finally
          //   148	210	547	finally
          //   210	224	547	finally
          //   224	233	547	finally
          //   474	483	547	finally
          //   487	491	547	finally
          //   535	544	547	finally
          //   669	680	547	finally
          //   694	703	547	finally
          //   711	720	547	finally
          //   724	735	547	finally
          //   249	319	668	finally
          //   319	338	668	finally
          //   338	404	668	finally
          //   404	466	668	finally
          //   470	474	668	finally
          //   502	535	668	finally
          //   559	651	668	finally
          //   651	665	668	finally
          //   680	694	706	java/lang/Throwable
          //   680	694	723	finally
          //   707	711	723	finally
        }
      }
      .execute(new Object[0]);
      return;
    }
    catch (Throwable paramString)
    {
    }
  }

  public boolean k()
  {
    boolean bool = false;
    if (this.H)
      return false;
    try
    {
      String str = m("abroad");
      if (!TextUtils.isEmpty(str))
      {
        if (ky.b(str) == 1)
          bool = true;
        this.t = bool;
      }
      return this.t;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        localThrowable.printStackTrace();
    }
  }

  public void l(String paramString)
  {
    if (this.H);
    do
    {
      return;
      this.p = paramString;
      c("promotion_id", this.p);
    }
    while (!kn.a);
    Log.v("DF_QA", "setPromotionId:" + this.p);
  }

  public boolean l()
  {
    boolean bool = true;
    if (this.H)
      return false;
    String str = m("dataState");
    if (!TextUtils.isEmpty(str))
      if (ky.b(str) != 1)
        break label44;
    while (true)
    {
      this.u = bool;
      return this.u;
      label44: bool = false;
    }
  }

  public void m()
  {
    new AsyncTask()
    {
      protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
      {
        try
        {
          paramAnonymousArrayOfObject = kh.a(kv.a(kv.this));
          String str = paramAnonymousArrayOfObject.a();
          if (paramAnonymousArrayOfObject.b());
          for (int i = 1; ; i = 0)
          {
            if (kn.a)
              Log.v("DF_QA", "getAdInfo advertisingId:" + str);
            if (kn.a)
              Log.v("DF_QA", "getAdInfo optOutEnabled:" + i);
            kv.b(kv.this, str);
            kv.a(kv.this, i);
            return null;
          }
        }
        catch (Exception paramAnonymousArrayOfObject)
        {
          while (true)
          {
            paramAnonymousArrayOfObject.printStackTrace();
            if (kn.a)
              Log.w("DF_QA", "getAdInfo err:" + paramAnonymousArrayOfObject);
            kv.b(kv.this, -1);
          }
        }
      }
    }
    .execute(new Object[0]);
  }

  public void n()
  {
    if (this.H)
      return;
    new AsyncTask()
    {
      protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
      {
        try
        {
          if (TextUtils.isEmpty(kv.this.b()))
          {
            if (!kn.a)
              break label484;
            Log.w("DF_QA", "发送普通事件0~2 getUseId:" + kv.this.b());
            return null;
          }
          if ((kv.this.l()) || (ky.e(kv.a(kv.this)) == null))
          {
            if (!kn.a)
              break label484;
            Log.w("DF_QA", "无网络.........." + kv.this.l());
            return null;
          }
        }
        catch (Throwable paramAnonymousArrayOfObject)
        {
          if (kn.a)
            Log.w("system.err", paramAnonymousArrayOfObject);
          paramAnonymousArrayOfObject.printStackTrace();
        }
        String str1;
        do
        {
          kv.this.c(false);
          kv.i(kv.this);
          return null;
          kv.this.c(true);
          str1 = kv.h(kv.this);
          if (kn.a)
            Log.v("DF_QA", "sendImmediateData() data:" + str1);
        }
        while (TextUtils.isEmpty(str1));
        if (kv.this.k());
        for (paramAnonymousArrayOfObject = "http://dr.lazyswipe.cn/l/api/log/timely/write"; ; paramAnonymousArrayOfObject = "http://dr.lazyswipe.com/l/api/log/timely/write")
        {
          if (kv.this.j())
            paramAnonymousArrayOfObject = "http://log.test.qiigame.com/l/api/log/timely/write";
          if (!TextUtils.isEmpty(paramAnonymousArrayOfObject))
          {
            String str2 = paramAnonymousArrayOfObject.substring("http://".length(), paramAnonymousArrayOfObject.indexOf("/l/api"));
            boolean bool2 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject, null, "1", true);
            boolean bool1;
            if (!bool2)
            {
              String str3 = kv.a(kv.this, "iurl_ip");
              bool1 = bool2;
              if (!TextUtils.isEmpty(str3))
                bool1 = kv.a(kv.this, kv.this.b(), str1, paramAnonymousArrayOfObject.replace(str2, str3), str2, "1", true);
            }
            while (true)
            {
              if (bool1)
                break label437;
              new kz(kv.a(kv.this)).a();
              kl.a().a(kv.a(kv.this));
              break;
              str1 = ky.e(str2);
              if (kn.a)
                Log.v("DF_QA", "sendImmediateData() newURL:" + paramAnonymousArrayOfObject.replace(str2, str1));
              bool1 = bool2;
              if (!TextUtils.isEmpty(str1))
              {
                kv.a(kv.this, "iurl_ip", str1);
                bool1 = bool2;
              }
            }
            label437: new kz(kv.a(kv.this)).a();
            kl.a().b(kv.a(kv.this));
            kl.a().d(kv.a(kv.this));
            break;
          }
          label484: return null;
        }
      }
    }
    .execute(new Object[0]);
  }

  public boolean o()
  {
    boolean bool = true;
    if (this.H)
      return false;
    String str = m("is_new_user");
    if (!TextUtils.isEmpty(str))
      if (ky.b(str) != 1)
        break label44;
    while (true)
    {
      this.w = bool;
      return this.w;
      label44: bool = false;
    }
  }

  public String p()
  {
    if (this.H);
    while (true)
    {
      return "unknow";
      try
      {
        if (TextUtils.isEmpty(this.a))
        {
          if (this.B != null)
            c(this.B);
        }
        else
        {
          String str = kl.a().c(this.B, "pid_c");
          if (TextUtils.isEmpty(str))
            continue;
          return URLDecoder.decode(str);
        }
        return "unknow";
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return "unknow";
  }

  public boolean q()
  {
    boolean bool = true;
    if (this.H)
      return false;
    String str = m("stable");
    if (!TextUtils.isEmpty(str))
      if (ky.b(str) != 1)
        break label44;
    while (true)
    {
      this.F = bool;
      return this.F;
      label44: bool = false;
    }
  }

  public boolean r()
  {
    boolean bool = true;
    if (this.H)
      return false;
    String str = m("promotionpackage");
    if (!TextUtils.isEmpty(str))
      if (ky.b(str) != 1)
        break label44;
    while (true)
    {
      this.o = bool;
      return this.o;
      label44: bool = false;
    }
  }

  public String s()
  {
    if (this.H)
      return "";
    String str = m("promotion_id");
    if (!TextUtils.isEmpty(str))
      this.p = str;
    return this.p;
  }

  public String t()
  {
    if (this.H)
      return this.I;
    String str = m("advertisingId");
    if (!TextUtils.isEmpty(str))
      this.I = URLDecoder.decode(str);
    return this.I;
  }

  public int u()
  {
    if (this.H)
      return -1;
    String str = m("optOutEnabled");
    if (!TextUtils.isEmpty(str))
      this.J = ky.b(str);
    return this.J;
  }

  public boolean v()
  {
    return this.H;
  }

  public Context w()
  {
    return this.B;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kv
 * JD-Core Version:    0.6.2
 */