package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class aif
{
  static final String b = "Swipe." + aif.class.getSimpleName();
  protected static final String c = new File(SwipeApplication.c().getFilesDir(), "/launcher_theme").getAbsolutePath();
  protected static final String d = c + "/current/";
  protected static final String e = c + "/all/";
  protected static final String f = e + "res/drawable-hdpi";
  private static Integer l;
  private static Boolean m;
  private aim a;
  protected final Context g;
  protected final String h;
  protected final aii i;
  private boolean j;
  private ais k;

  protected aif(Context paramContext, String paramString, aii paramaii)
  {
    this.g = paramContext;
    this.i = paramaii;
    this.h = paramString;
  }

  private static void a(Context paramContext, String paramString)
  {
    paramContext = new File(d).listFiles();
    int i1 = paramContext.length;
    int n = 0;
    while (n < i1)
    {
      File localFile = paramContext[n];
      if (!localFile.getName().equals(paramString))
        aqx.e(localFile);
      n += 1;
    }
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      l();
      aif localaif = b(paramContext);
      if (localaif == null)
        return false;
      if (!vs.a(paramContext, "pref_current_theme_apk0", "").equals(localaif.h))
      {
        boolean bool = localaif.b();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static aif b(Context paramContext)
  {
    String str = ahx.b(paramContext).O();
    if (TextUtils.isEmpty(str))
    {
      vs.b(paramContext, "pref_current_theme_apk0", "");
      return null;
    }
    if (!asq.c(paramContext, str))
    {
      vs.b(paramContext, "pref_current_theme_apk0", "");
      return null;
    }
    try
    {
      paramContext = new aif(paramContext, str, new aii(paramContext, str));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e(b, "getCurrentLauncherTheme() failed.", paramContext);
    }
    return null;
  }

  static int c(Context paramContext)
  {
    if (l != null)
    {
      n = l.intValue();
      return n;
    }
    String str1 = e(paramContext);
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    Object localObject = new File(d, str1);
    if (((File)localObject).exists())
      i1 = i2;
    label220: 
    while (true)
      try
      {
        localObject = aqx.m(new File((File) localObject, "info")).iterator();
        i1 = n;
        if (((Iterator)localObject).hasNext())
        {
          i1 = n;
          String str2 = (String)((Iterator)localObject).next();
          i1 = n;
          if (!str2.startsWith("density:"))
            break label220;
          i1 = n;
          n = Integer.parseInt(str2.substring("density:".length()));
          continue;
        }
        i1 = n;
        n = i1;
        if (i1 == 0)
          n = b(paramContext).h();
        i1 = n;
        if (n == 0)
          i1 = 240;
        n = i1;
        if (i1 <= 0)
          break;
        l = Integer.valueOf(i1);
        return i1;
      }
      catch (Exception localException)
      {
        Log.e(b, "Failed to get the package density for " + str1);
      }
  }

  static boolean d(Context paramContext)
  {
    if (m != null)
      return m.booleanValue();
    String str1 = e(paramContext);
    if (str1 == null)
      return false;
    Object localObject = new File(d, str1);
    boolean bool;
    if (((File)localObject).exists())
    {
      try
      {
        localObject = aqx.m(new File((File) localObject, "info")).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if (str2.startsWith("default:"))
          {
            if (Integer.parseInt(str2.substring("default:".length())) != 1)
              break label182;
            bool = true;
            m = Boolean.valueOf(bool);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(b, "Failed to get the package default for " + str1);
      }
    }
    else if (m == null)
    {
      paramContext = b(paramContext);
      if (paramContext == null)
        break label188;
    }
    label182: label188: for (m = Boolean.valueOf(paramContext.d()); ; m = Boolean.valueOf(false))
    {
      return Boolean.TRUE.equals(m);
      bool = false;
      break;
    }
  }

  private static String e(Context paramContext)
  {
    return ahx.b(paramContext).O();
  }

  // ERROR //
  private boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 261	aif:i	()Ljava/util/List;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 263	aif:c	()Ljava/io/File;
    //   9: astore_3
    //   10: new 265	java/util/HashMap
    //   13: dup
    //   14: invokespecial 266	java/util/HashMap:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: ldc_w 268
    //   24: ldc 80
    //   26: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: pop
    //   30: aload 4
    //   32: ldc_w 274
    //   35: aconst_null
    //   36: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: aload 4
    //   42: ldc_w 276
    //   45: aconst_null
    //   46: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload 4
    //   52: ldc_w 278
    //   55: aconst_null
    //   56: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload 4
    //   62: ldc_w 280
    //   65: aconst_null
    //   66: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload 4
    //   72: ldc_w 282
    //   75: aconst_null
    //   76: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 4
    //   82: ldc_w 284
    //   85: aconst_null
    //   86: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 4
    //   92: ldc_w 286
    //   95: aconst_null
    //   96: invokevirtual 272	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: new 288	java/util/HashSet
    //   103: dup
    //   104: invokespecial 289	java/util/HashSet:<init>	()V
    //   107: astore 5
    //   109: aload 5
    //   111: ldc_w 291
    //   114: invokeinterface 296 2 0
    //   119: pop
    //   120: aload 5
    //   122: ldc_w 298
    //   125: invokeinterface 296 2 0
    //   130: pop
    //   131: aload 5
    //   133: ldc_w 300
    //   136: invokeinterface 296 2 0
    //   141: pop
    //   142: aload 5
    //   144: ldc_w 302
    //   147: invokeinterface 296 2 0
    //   152: pop
    //   153: aload 5
    //   155: ldc_w 304
    //   158: invokeinterface 296 2 0
    //   163: pop
    //   164: aload 5
    //   166: ldc_w 306
    //   169: invokeinterface 296 2 0
    //   174: pop
    //   175: aload 5
    //   177: ldc_w 308
    //   180: invokeinterface 296 2 0
    //   185: pop
    //   186: aload 5
    //   188: ldc_w 310
    //   191: invokeinterface 296 2 0
    //   196: pop
    //   197: aload 5
    //   199: ldc_w 312
    //   202: invokeinterface 296 2 0
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 316	java/util/HashMap:keySet	()Ljava/util/Set;
    //   213: astore 6
    //   215: aload_1
    //   216: invokeinterface 199 1 0
    //   221: astore 7
    //   223: iconst_0
    //   224: istore 10
    //   226: aload 7
    //   228: invokeinterface 204 1 0
    //   233: ifeq +199 -> 432
    //   236: aload 7
    //   238: invokeinterface 208 1 0
    //   243: checkcast 104	java/lang/String
    //   246: astore_2
    //   247: aload 6
    //   249: invokeinterface 317 1 0
    //   254: astore 8
    //   256: aload 8
    //   258: invokeinterface 204 1 0
    //   263: ifeq +290 -> 553
    //   266: aload 8
    //   268: invokeinterface 208 1 0
    //   273: checkcast 104	java/lang/String
    //   276: astore_1
    //   277: aload_2
    //   278: aload_1
    //   279: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   282: ifeq -26 -> 256
    //   285: aload 4
    //   287: aload_1
    //   288: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: checkcast 104	java/lang/String
    //   294: astore 8
    //   296: aload 8
    //   298: ifnull +247 -> 545
    //   301: new 29	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   308: aload 8
    //   310: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_2
    //   314: aload_1
    //   315: invokevirtual 217	java/lang/String:length	()I
    //   318: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   321: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore_1
    //   328: iconst_1
    //   329: istore 9
    //   331: aload_2
    //   332: ifnull +207 -> 539
    //   335: aload 5
    //   337: invokeinterface 317 1 0
    //   342: astore 8
    //   344: aload 8
    //   346: invokeinterface 204 1 0
    //   351: ifeq +188 -> 539
    //   354: aload_2
    //   355: aload 8
    //   357: invokeinterface 208 1 0
    //   362: checkcast 104	java/lang/String
    //   365: invokevirtual 324	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   368: istore 12
    //   370: iload 12
    //   372: ifeq -28 -> 344
    //   375: iconst_1
    //   376: istore 11
    //   378: iload 11
    //   380: ifne -154 -> 226
    //   383: iload 9
    //   385: ifeq +42 -> 427
    //   388: aload_1
    //   389: ifnull -163 -> 226
    //   392: aload_0
    //   393: getfield 89	aif:i	Laii;
    //   396: aload_2
    //   397: invokevirtual 327	aii:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   400: astore_2
    //   401: aload_2
    //   402: ifnull +16 -> 418
    //   405: aload_2
    //   406: new 51	java/io/File
    //   409: dup
    //   410: aload_3
    //   411: aload_1
    //   412: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   415: invokestatic 332	arf:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   418: iload 10
    //   420: iconst_1
    //   421: iadd
    //   422: istore 10
    //   424: goto -198 -> 226
    //   427: aload_2
    //   428: astore_1
    //   429: goto -37 -> 392
    //   432: iload 10
    //   434: ifne +5 -> 439
    //   437: iconst_0
    //   438: ireturn
    //   439: new 51	java/io/File
    //   442: dup
    //   443: aload_3
    //   444: ldc 190
    //   446: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   449: astore_1
    //   450: new 29	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 334
    //   460: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: invokespecial 336	aif:g	()I
    //   467: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: ldc_w 341
    //   473: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc 210
    //   478: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_0
    //   482: invokespecial 227	aif:h	()I
    //   485: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc_w 341
    //   491: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 343
    //   497: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: astore_2
    //   501: aload_0
    //   502: invokevirtual 252	aif:d	()Z
    //   505: ifeq +21 -> 526
    //   508: iconst_1
    //   509: istore 9
    //   511: aload_1
    //   512: aload_2
    //   513: iload 9
    //   515: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 345	aqx:b	(Ljava/io/File;Ljava/lang/String;)V
    //   524: iconst_1
    //   525: ireturn
    //   526: iconst_0
    //   527: istore 9
    //   529: goto -18 -> 511
    //   532: astore_1
    //   533: iconst_0
    //   534: ireturn
    //   535: astore_1
    //   536: goto -118 -> 418
    //   539: iconst_0
    //   540: istore 11
    //   542: goto -164 -> 378
    //   545: iconst_1
    //   546: istore 9
    //   548: aconst_null
    //   549: astore_1
    //   550: goto -219 -> 331
    //   553: iconst_0
    //   554: istore 9
    //   556: aconst_null
    //   557: astore_1
    //   558: goto -227 -> 331
    //
    // Exception table:
    //   from	to	target	type
    //   0	223	532	java/lang/Throwable
    //   226	256	532	java/lang/Throwable
    //   256	296	532	java/lang/Throwable
    //   301	328	532	java/lang/Throwable
    //   335	344	532	java/lang/Throwable
    //   344	370	532	java/lang/Throwable
    //   439	508	532	java/lang/Throwable
    //   511	524	532	java/lang/Throwable
    //   392	401	535	java/lang/Throwable
    //   405	418	535	java/lang/Throwable
  }

  private int g()
  {
    if (this.a == null)
      this.a = this.i.e();
    if (this.a != null)
      return this.a.b().intValue();
    return 0;
  }

  private int h()
  {
    if (this.a == null)
      this.a = this.i.e();
    if (this.a != null)
      return this.a.d();
    return 320;
  }

  private List<String> i()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localZipInputStream = new ZipInputStream(new FileInputStream(j().d));
      try
      {
        while (true)
        {
          ZipEntry localZipEntry = localZipInputStream.getNextEntry();
          if (localZipEntry == null)
            break;
          String str = localZipEntry.getName();
          if (str.startsWith("assets/"))
          {
            str = str.substring("assets/".length());
            if (!localZipEntry.isDirectory())
              localArrayList.add(str);
          }
        }
      }
      finally
      {
      }
      arf.a(localZipInputStream);
      throw localList;
      arf.a(localZipInputStream);
      return localList;
    }
    finally
    {
      while (true)
        ZipInputStream localZipInputStream = null;
    }
  }

  private ais j()
  {
    if (!this.j)
    {
      this.j = true;
      this.k = this.i.f();
    }
    return this.k;
  }

  private boolean k()
  {
    return this.i.b();
  }

  private static void l()
  {
    l = null;
    m = null;
  }

  protected boolean a()
  {
    return true;
  }

  public boolean b()
  {
    if (!aik.a(this.h, this.g))
      return false;
    asq.b();
    aqx.f(new File(e));
    if (!f())
      return false;
    Context localContext = this.g;
    if (k());
    for (String str = null; ; str = "default-icon_bg_none")
    {
      vs.b(localContext, "pref_current_theme_icon_bg", str);
      a(this.g, this.h);
      if (a())
        break;
      return false;
    }
    e();
    return true;
  }

  protected File c()
  {
    return new File(d, this.h);
  }

  public boolean d()
  {
    return j().f;
  }

  protected void e()
  {
    vs.b(this.g, "pref_current_theme_apk0", this.h);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aif
 * JD-Core Version:    0.6.2
 */