package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.duapps.ad.a.a;
import com.duapps.ad.a.c;
import com.duapps.ad.stats.DuAdCacheProvider;
import org.json.JSONObject;

public final class nb
{
  private static String a = "http://api.mobula.sdk.duapps.com/adunion/slot/getDlAd?";
  private static String b = "http://api.mobula.sdk.duapps.com/adunion/rtb/getInmobiAd?";
  private static String c = "http://api.mobula.sdk.duapps.com/adunion/rtb/fetchAd?";
  private static nb e;
  private Context d;

  private nb(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      long l = System.currentTimeMillis();
      this.d.getContentResolver().delete(DuAdCacheProvider.a(this.d, 3), "ts<?", new String[] { String.valueOf(l - 7200000L) });
      return;
    }
    catch (Exception paramContext)
    {
      mv.a("ToolboxCacheManager", "mDatabase initCacheDatabase() del exception: ", paramContext);
    }
  }

  public static nb a(Context paramContext)
  {
    try
    {
      if (e == null)
        e = new nb(paramContext.getApplicationContext());
      paramContext = e;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  // ERROR //
  final nj a(String paramString)
  {
    // Byte code:
    //   0: new 91	nj
    //   3: dup
    //   4: invokespecial 92	nj:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: putfield 93	nj:a	Ljava/lang/String;
    //   15: aload_0
    //   16: getfield 35	nb:d	Landroid/content/Context;
    //   19: invokevirtual 47	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: aload_0
    //   23: getfield 35	nb:d	Landroid/content/Context;
    //   26: iconst_3
    //   27: invokestatic 52	com/duapps/ad/stats/DuAdCacheProvider:a	(Landroid/content/Context;I)Landroid/net/Uri;
    //   30: iconst_2
    //   31: anewarray 56	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 95
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 97
    //   43: aastore
    //   44: ldc 99
    //   46: iconst_1
    //   47: anewarray 56	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: aconst_null
    //   55: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +42 -> 102
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokeinterface 109 1 0
    //   71: ifeq +31 -> 102
    //   74: aload_2
    //   75: astore_1
    //   76: aload 4
    //   78: aload_2
    //   79: iconst_0
    //   80: invokeinterface 113 2 0
    //   85: putfield 114	nj:b	Ljava/lang/String;
    //   88: aload_2
    //   89: astore_1
    //   90: aload 4
    //   92: aload_2
    //   93: iconst_1
    //   94: invokeinterface 118 2 0
    //   99: putfield 121	nj:c	J
    //   102: aload_2
    //   103: ifnull +18 -> 121
    //   106: aload_2
    //   107: invokeinterface 124 1 0
    //   112: ifne +9 -> 121
    //   115: aload_2
    //   116: invokeinterface 127 1 0
    //   121: aload 4
    //   123: areturn
    //   124: astore_3
    //   125: aconst_null
    //   126: astore_2
    //   127: aload_2
    //   128: astore_1
    //   129: ldc 70
    //   131: ldc 129
    //   133: aload_3
    //   134: invokestatic 77	mv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_2
    //   138: ifnull -17 -> 121
    //   141: aload_2
    //   142: invokeinterface 124 1 0
    //   147: ifne -26 -> 121
    //   150: aload_2
    //   151: invokeinterface 127 1 0
    //   156: aload 4
    //   158: areturn
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +18 -> 181
    //   166: aload_1
    //   167: invokeinterface 124 1 0
    //   172: ifne +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 127 1 0
    //   181: aload_2
    //   182: athrow
    //   183: astore_2
    //   184: goto -22 -> 162
    //   187: astore_3
    //   188: goto -61 -> 127
    //
    // Exception table:
    //   from	to	target	type
    //   15	59	124	java/lang/Exception
    //   15	59	159	finally
    //   65	74	183	finally
    //   76	88	183	finally
    //   90	102	183	finally
    //   129	137	183	finally
    //   65	74	187	java/lang/Exception
    //   76	88	187	java/lang/Exception
    //   90	102	187	java/lang/Exception
  }

  public final void a()
  {
    long l = System.currentTimeMillis();
    try
    {
      String str = Long.toString(l - 86400000L);
      this.d.getContentResolver().delete(DuAdCacheProvider.a(this.d, 5), "ctime<?", new String[] { str });
      return;
    }
    catch (Exception localException)
    {
      mv.a("ToolboxCacheManager", "clearTriggerPreParseData error: ", localException);
    }
  }

  public final void a(int paramInt1, int paramInt2, ml paramml)
  {
    String str1 = a;
    paramml.a();
    Object localObject = this.d;
    localObject = nm.a();
    String str2 = "native_" + (String)localObject + "_" + "native" + "_" + paramInt1 + "_" + 1;
    if (!np.b(this.d))
    {
      paramml.a(lb.a.b());
      return;
    }
    mm.a().a(new nc(this, (String)localObject, 1, paramInt1, "native", str1, str2, paramml));
  }

  public final void a(int paramInt1, int paramInt2, ml paramml, int paramInt3)
  {
    String str1 = c;
    paramml.a();
    Object localObject = this.d;
    localObject = nm.a();
    DisplayMetrics localDisplayMetrics = this.d.getResources().getDisplayMetrics();
    String str2 = "online_" + (String)localObject + "_" + "online" + "_" + paramInt1 + "_" + 1;
    if (!np.b(this.d))
    {
      paramml.a(lb.a.b());
      return;
    }
    mm.a().a(new ne(this, (String)localObject, localDisplayMetrics, 1, paramInt1, "online", paramInt3, str1, str2, paramml));
  }

  public final void a(int paramInt, String paramString1, String paramString2, ml paramml)
  {
    paramml.a();
    if (!na.a(b + paramInt, this.d))
    {
      paramml.a("This url is request too frequently.");
      mv.c("ToolboxCacheManager", "This url is request too frequently.");
      return;
    }
    Object localObject = this.d;
    localObject = nm.a();
    if (!np.b(this.d))
    {
      paramml.a(lb.a.b());
      return;
    }
    mm.a().a(new ng(this, (String)localObject, paramInt, paramString1, paramString2, paramml));
  }

  public final void a(c paramc)
  {
    mm.a().a(new ni(this, paramc));
  }

  final void a(nj paramnj)
  {
    ContentValues localContentValues = new ContentValues(4);
    localContentValues.put("key", paramnj.a);
    localContentValues.put("data", paramnj.b);
    localContentValues.put("ts", Long.valueOf(paramnj.c));
    paramnj = paramnj.a;
    try
    {
      if (this.d.getContentResolver().update(DuAdCacheProvider.a(this.d, 3), localContentValues, "key=?", new String[] { paramnj }) <= 0)
        this.d.getContentResolver().insert(DuAdCacheProvider.a(this.d, 3), localContentValues);
      return;
    }
    catch (Exception paramnj)
    {
      mv.a("ToolboxCacheManager", "cacheDabase saveCacheEntry() exception: ", paramnj);
    }
  }

  public final void a(oa paramoa)
  {
    if ((paramoa == null) || (TextUtils.isEmpty(paramoa.a())));
    while (true)
    {
      return;
      try
      {
        ContentValues localContentValues = new ContentValues(5);
        localContentValues.put("pkgName", paramoa.a());
        localContentValues.put("ctime", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("cdata", oa.a(paramoa).toString());
        paramoa = paramoa.a();
        if (this.d.getContentResolver().update(DuAdCacheProvider.a(this.d, 2), localContentValues, "pkgName=?", new String[] { paramoa }) == 0)
        {
          localContentValues.put("status", Integer.valueOf(0));
          this.d.getContentResolver().insert(DuAdCacheProvider.a(this.d, 2), localContentValues);
          return;
        }
      }
      catch (Exception paramoa)
      {
        mv.a("ToolboxCacheManager", "updateOrInsertValidClickTime() exception: ", paramoa);
      }
    }
  }

  // ERROR //
  public final oa b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: getfield 35	nb:d	Landroid/content/Context;
    //   18: invokevirtual 47	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: aload_0
    //   22: getfield 35	nb:d	Landroid/content/Context;
    //   25: iconst_2
    //   26: invokestatic 52	com/duapps/ad/stats/DuAdCacheProvider:a	(Landroid/content/Context;I)Landroid/net/Uri;
    //   29: iconst_2
    //   30: anewarray 56	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 280
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc_w 278
    //   44: aastore
    //   45: ldc_w 303
    //   48: iconst_2
    //   49: anewarray 56	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: lload 4
    //   60: ldc2_w 130
    //   63: lsub
    //   64: invokestatic 62	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: aconst_null
    //   69: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +138 -> 212
    //   77: aload_1
    //   78: astore_2
    //   79: aload_1
    //   80: invokeinterface 109 1 0
    //   85: ifeq +127 -> 212
    //   88: aload_1
    //   89: astore_2
    //   90: new 285	org/json/JSONObject
    //   93: dup
    //   94: aload_1
    //   95: iconst_0
    //   96: invokeinterface 113 2 0
    //   101: invokespecial 305	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   104: invokestatic 308	oa:a	(Lorg/json/JSONObject;)Loa;
    //   107: astore_3
    //   108: aload_3
    //   109: astore_2
    //   110: aload_2
    //   111: astore_3
    //   112: aload_1
    //   113: ifnull +22 -> 135
    //   116: aload_2
    //   117: astore_3
    //   118: aload_1
    //   119: invokeinterface 124 1 0
    //   124: ifne +11 -> 135
    //   127: aload_1
    //   128: invokeinterface 127 1 0
    //   133: aload_2
    //   134: astore_3
    //   135: aload_3
    //   136: areturn
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: astore_2
    //   142: ldc 70
    //   144: ldc_w 310
    //   147: aload_3
    //   148: invokestatic 77	mv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_1
    //   152: ifnull +55 -> 207
    //   155: aload_1
    //   156: invokeinterface 124 1 0
    //   161: ifne +46 -> 207
    //   164: aload_1
    //   165: invokeinterface 127 1 0
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -37 -> 135
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +18 -> 197
    //   182: aload_2
    //   183: invokeinterface 124 1 0
    //   188: ifne +9 -> 197
    //   191: aload_2
    //   192: invokeinterface 127 1 0
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: goto -22 -> 178
    //   203: astore_3
    //   204: goto -64 -> 140
    //   207: aconst_null
    //   208: astore_3
    //   209: goto -74 -> 135
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -104 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   14	73	137	java/lang/Exception
    //   14	73	175	finally
    //   79	88	199	finally
    //   90	108	199	finally
    //   142	151	199	finally
    //   79	88	203	java/lang/Exception
    //   90	108	203	java/lang/Exception
  }

  public final void b(oa paramoa)
  {
    if ((paramoa == null) || (TextUtils.isEmpty(paramoa.a())));
    do
      while (true)
      {
        return;
        try
        {
          ContentValues localContentValues = new ContentValues(5);
          localContentValues.put("ad_id", Long.valueOf(paramoa.c.a));
          localContentValues.put("pkgName", paramoa.a());
          localContentValues.put("data", oa.a(paramoa).toString());
          localContentValues.put("ctime", Long.valueOf(System.currentTimeMillis()));
          paramoa = paramoa.a();
          if (this.d.getContentResolver().update(DuAdCacheProvider.a(this.d, 5), localContentValues, "pkgName=?", new String[] { paramoa }) == 0)
          {
            this.d.getContentResolver().insert(DuAdCacheProvider.a(this.d, 5), localContentValues);
            mv.c("ToolboxCacheManager", "update or insert triggerPreParse data success");
            return;
          }
        }
        catch (Exception paramoa)
        {
        }
      }
    while (!mv.a());
    mv.a("ToolboxCacheManager", "update or insert triggerPreParse data error: ", paramoa);
  }

  public final void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    try
    {
      this.d.getContentResolver().delete(DuAdCacheProvider.a(this.d, 2), "pkgName=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      mv.a("ToolboxCacheManager", "mDatabase removeValidClickRecord() del exception: ", paramString);
    }
  }

  // ERROR //
  public final oa d(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 35	nb:d	Landroid/content/Context;
    //   13: invokevirtual 47	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload_0
    //   17: getfield 35	nb:d	Landroid/content/Context;
    //   20: iconst_5
    //   21: invokestatic 52	com/duapps/ad/stats/DuAdCacheProvider:a	(Landroid/content/Context;I)Landroid/net/Uri;
    //   24: iconst_2
    //   25: anewarray 56	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 276
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc 95
    //   38: aastore
    //   39: ldc_w 329
    //   42: iconst_1
    //   43: anewarray 56	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +146 -> 202
    //   59: aload_1
    //   60: astore_2
    //   61: aload_1
    //   62: invokeinterface 109 1 0
    //   67: ifeq +135 -> 202
    //   70: aload_1
    //   71: astore_2
    //   72: new 285	org/json/JSONObject
    //   75: dup
    //   76: aload_1
    //   77: iconst_1
    //   78: invokeinterface 113 2 0
    //   83: invokespecial 305	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   86: invokestatic 308	oa:a	(Lorg/json/JSONObject;)Loa;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_2
    //   92: aload_2
    //   93: astore_3
    //   94: aload_1
    //   95: ifnull +22 -> 117
    //   98: aload_2
    //   99: astore_3
    //   100: aload_1
    //   101: invokeinterface 124 1 0
    //   106: ifne +11 -> 117
    //   109: aload_1
    //   110: invokeinterface 127 1 0
    //   115: aload_2
    //   116: astore_3
    //   117: aload_3
    //   118: areturn
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: astore_2
    //   124: invokestatic 323	mv:a	()Z
    //   127: ifeq +14 -> 141
    //   130: aload_1
    //   131: astore_2
    //   132: ldc 70
    //   134: ldc_w 331
    //   137: aload_3
    //   138: invokestatic 77	mv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_1
    //   142: ifnull +55 -> 197
    //   145: aload_1
    //   146: invokeinterface 124 1 0
    //   151: ifne +46 -> 197
    //   154: aload_1
    //   155: invokeinterface 127 1 0
    //   160: aconst_null
    //   161: astore_3
    //   162: goto -45 -> 117
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +18 -> 187
    //   172: aload_2
    //   173: invokeinterface 124 1 0
    //   178: ifne +9 -> 187
    //   181: aload_2
    //   182: invokeinterface 127 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: goto -22 -> 168
    //   193: astore_3
    //   194: goto -72 -> 122
    //   197: aconst_null
    //   198: astore_3
    //   199: goto -82 -> 117
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -112 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   9	55	119	java/lang/Exception
    //   9	55	165	finally
    //   61	70	189	finally
    //   72	90	189	finally
    //   124	130	189	finally
    //   132	141	189	finally
    //   61	70	193	java/lang/Exception
    //   72	90	193	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nb
 * JD-Core Version:    0.6.2
 */