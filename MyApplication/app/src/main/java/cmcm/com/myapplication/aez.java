package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aez
{
  private static final Object b = new Object();
  TreeSet<afa> a;
  private boolean c;
  private int d;
  private int e;
  private final int f;
  private WeakReference<afb> g;
  private final File h;

  private aez(final Context paramContext, afb paramafb, int paramInt)
  {
    this.f = paramInt;
    this.e = vs.a(paramContext, "key_lucky_wallpapers_seen", 0);
    this.h = SwipeApplication.c().getExternalFilesDir("wallpaper");
    if (this.h != null)
      this.h.mkdirs();
    if (paramafb != null)
      this.g = new WeakReference(paramafb);
    this.c = true;
    paramContext = paramContext.getApplicationContext();
    arj.a(wd.a, new Runnable() {
      public void run() {
        try {
          File localFile = new File(paramContext.getFilesDir(), ".wallpapers");
          if (!localFile.exists())
            aez.this.a(paramContext, localFile);
          while (true) {
            return;
            String str = aqx.i(localFile);
            if (aez.this.a(str) <= 0)
              aez.this.a(paramContext, localFile);
          }
        } catch (Throwable localThrowable) {
        } finally {
          aez.a(aez.this, false);
        }
      }
    });
  }

  public static aez a(Context paramContext, afb paramafb, int paramInt)
  {
    return new aez(paramContext, paramafb, paramInt);
  }

  int a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("statusCode");
      if (i != 200)
      {
        Log.w("Swipe.WallpaperLoader", "Result code:" + i);
        return 0;
      }
      localObject = ((JSONObject)localObject).optJSONArray("results");
      if (localObject != null)
      {
        int j = ((JSONArray)localObject).length();
        if (j > 0)
        {
          if (this.a != null)
            this.a.clear();
          this.a = new TreeSet();
          i = this.e;
          afa localafa;
          while (i < j)
          {
            localafa = new afa(((JSONArray)localObject).getJSONObject(i), this.h, this.f);
            this.a.add(localafa);
            i += 1;
          }
          if (this.e >= j)
          {
            i = 0;
            while (i < j)
            {
              localafa = new afa(((JSONArray)localObject).getJSONObject(i), this.h, this.f);
              this.a.add(localafa);
              i += 1;
            }
            this.d = ((afa)this.a.last()).b;
            this.a.clear();
            return 0;
          }
          this.d = ((afa)this.a.last()).b;
          localObject = (afa)this.a.pollFirst();
          if (localObject == null)
            break label357;
          a((afa)localObject);
          vs.b(SwipeApplication.c(), "key_lucky_wallpapers_seen", this.e);
          return this.a.size() + 1;
        }
      }
      Log.w("Swipe.WallpaperLoader", "No data found: " + paramString);
      label322: return 0;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Log.w("Swipe.WallpaperLoader", "Could not parse json: " + paramString);
    }
    catch (Throwable paramString)
    {
      break label322;
    }
    label357: return 0;
  }

  String a(Context paramContext, long paramLong)
  {
    int i = Math.min(vj.e, vj.f);
    int j = Math.max(vj.e, vj.f);
    StringBuilder localStringBuilder = new StringBuilder("http://a.holaworld.cn").append("/wallpapers/after").append("?id=").append(paramLong).append("&ver=").append(22500).append("&cw=").append(i).append("&lc=").append(asi.b("26100")).append("&w=").append(i).append("&h=").append(j).append("&dpi=").append(vj.d).append("&lang=").append(asq.j()).append("&network=");
    if (arl.g(paramContext));
    for (paramContext = "wifi"; ; paramContext = "apn")
      return paramContext + "&psize=" + 10 + "&page=" + 1 + "&tv=2";
  }

  // ERROR //
  void a(afa paramafa)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 33	aez:f	I
    //   5: putfield 259	afa:a	I
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 42	aez:e	I
    //   13: iconst_1
    //   14: iadd
    //   15: putfield 42	aez:e	I
    //   18: aload_1
    //   19: getfield 262	afa:c	Ljava/lang/String;
    //   22: astore_3
    //   23: aload_1
    //   24: getfield 264	afa:e	Ljava/lang/String;
    //   27: astore_2
    //   28: new 57	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 268	java/io/File:exists	()Z
    //   43: ifne +72 -> 115
    //   46: new 270	arb
    //   49: dup
    //   50: invokestatic 47	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   53: invokespecial 273	arb:<init>	(Landroid/content/Context;)V
    //   56: aload_2
    //   57: aconst_null
    //   58: new 57	java/io/File
    //   61: dup
    //   62: aload_3
    //   63: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: invokevirtual 276	arb:a	(Ljava/lang/String;Ljava/util/Map;Ljava/io/File;)Z
    //   69: pop
    //   70: aload 4
    //   72: invokevirtual 268	java/io/File:exists	()Z
    //   75: ifne +40 -> 115
    //   78: aload_0
    //   79: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   82: ifnull +33 -> 115
    //   85: aload_0
    //   86: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   89: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   92: ifnull +23 -> 115
    //   95: aload_0
    //   96: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   99: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   102: checkcast 281	afb
    //   105: aload_1
    //   106: ldc_w 283
    //   109: invokeinterface 286 3 0
    //   114: return
    //   115: aload_0
    //   116: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   119: ifnull -5 -> 114
    //   122: aload_0
    //   123: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   126: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   129: ifnull -15 -> 114
    //   132: invokestatic 47	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   135: pop
    //   136: aload_3
    //   137: invokestatic 291	aqs:ae	()I
    //   140: iconst_0
    //   141: invokestatic 296	atw:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   144: astore_2
    //   145: aload_2
    //   146: invokestatic 299	atw:b	(Landroid/graphics/Bitmap;)Z
    //   149: ifne +55 -> 204
    //   152: aload_3
    //   153: invokestatic 302	atw:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   156: astore_2
    //   157: aload_2
    //   158: invokestatic 299	atw:b	(Landroid/graphics/Bitmap;)Z
    //   161: ifeq +21 -> 182
    //   164: aload_0
    //   165: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   168: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   171: checkcast 281	afb
    //   174: aload_1
    //   175: aload_2
    //   176: invokeinterface 305 3 0
    //   181: return
    //   182: aload_0
    //   183: getfield 68	aez:g	Ljava/lang/ref/WeakReference;
    //   186: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   189: checkcast 281	afb
    //   192: aload_1
    //   193: ldc_w 307
    //   196: invokeinterface 286 3 0
    //   201: return
    //   202: astore_1
    //   203: return
    //   204: goto -47 -> 157
    //   207: astore_1
    //   208: return
    //
    // Exception table:
    //   from	to	target	type
    //   95	114	202	java/lang/Throwable
    //   157	181	207	java/lang/Throwable
    //   182	201	207	java/lang/Throwable
  }

  void a(Context paramContext, File paramFile)
  {
    paramContext = ard.a(paramContext, a(paramContext, this.d), 10000, 10000);
    if (arr.a == paramContext.a)
    {
      this.e = 0;
      if (a(paramContext.c) > 0)
        aqx.b(paramFile, paramContext.c);
    }
    do
    {
      do
        return;
      while ((this.g == null) || (this.g.get() == null));
      asp.b("Swipe.WallpaperLoader", "Could not fetch wallpapers info: " + paramContext.c);
      ((afb)this.g.get()).a(new afa(this.f), "Could not fetch wallpaper info: " + paramContext.c);
      return;
      Log.w("Swipe.WallpaperLoader", "Http result code: " + paramContext.b);
    }
    while ((this.g == null) || (this.g.get() == null));
    asp.b("Swipe.WallpaperLoader", "Could not fetch wallpapers info: " + paramContext.b);
    ((afb)this.g.get()).a(new afa(this.f), "Could not fetch wallpaper info: " + paramContext.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aez
 * JD-Core Version:    0.6.2
 */