package cmcm.com.myapplication;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class wd
{
  public static final Handler a = new Handler(b.getLooper());
  private static final HandlerThread b = new HandlerThread("Swipe.API");

  static
  {
    b.setPriority(10);
    b.start();
  }

  public static void a()
  {
    if (SwipeApplication.a != null);
    try
    {
      a(SwipeApplication.c(), SwipeApplication.a);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext)
  {
    Log.i("Swipe.API", "onNetworkAvailable");
    if (TextUtils.isEmpty(vs.u(paramContext)))
      b(paramContext);
    while (true)
    {
      abf.a(paramContext);
      aiu.a(paramContext);
      ass.a(paramContext);
      aib.d(paramContext);
      return;
      d(paramContext);
      vy.c();
      ajk.a().a(paramContext);
      ajk.a().b(paramContext);
      if ((!vs.m(paramContext)) && (vs.E(paramContext) > 0))
        vy.d(paramContext);
      if ((abd.a()) && (abd.l))
        abd.b();
      if (!vs.D(paramContext))
      {
        vs.C(paramContext);
        vz.a(paramContext);
      }
    }
  }

  static void a(Context paramContext, int paramInt, Map<String, String> paramMap)
  {
    if (1 == paramInt)
      xl.b(paramContext, 1L);
    asp.a("Swipe.API", "Getting banners #" + paramInt + ", since:" + (String)paramMap.get("sinceId") + " ...");
    paramMap.put("page", String.valueOf(paramInt));
    arq localarq = ard.a(paramContext, "http://a.lazyswipe.cn/banners", paramMap, 10000, 10000);
    if (arr.a != localarq.a);
    while (true)
    {
      return;
      try
      {
        wc localwc = new wc(localarq.c);
        localwc.a(paramContext);
        if (1 == paramInt)
        {
          int i = localwc.a();
          paramInt = 2;
          while (paramInt <= i)
          {
            a(paramContext, paramInt, paramMap);
            paramInt += 1;
          }
        }
      }
      catch (JSONException paramContext)
      {
        asp.b("Swipe.API", "Could not parse the json string: " + localarq.c);
      }
    }
  }

  public static void a(Context paramContext, final long paramLong)
  {
    try
    {
      String str = SwipeApplication.a.getString("code");
      arj.a(a, new Runnable()
      {
        public void run()
        {
          Bundle localBundle = new Bundle(2);
          localBundle.putString("extra_param_1", wd.this);
          localBundle.putLong("extra_param_2", paramLong);
          try
          {
            this.c.getContentResolver().call(xa.a, "updateBannerShowedTime", null, localBundle);
            label47: SwipeApplication.a = wd.g(this.c);
            return;
          }
          catch (Throwable localThrowable)
          {
            break label47;
          }
        }
      });
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  public static void a(final Context paramContext, String paramString)
  {
    try
    {
      arj.a(a, new Runnable()
      {
        public void run()
        {
          ContentValues localContentValues = new ContentValues(1);
          localContentValues.put("seen", Integer.valueOf(-1));
          paramContext.getContentResolver().update(xa.a.buildUpon().appendPath(wd.this).build(), localContentValues, null, null);
        }
      });
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (vs.q(paramContext))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 8) && (i < 23) && (System.currentTimeMillis() - paramJSONObject.getLong("endTime") <= 0L))
      {
        paramJSONObject = paramJSONObject.getString("content");
        paramJSONObject = new Notification.Builder(paramContext).setSmallIcon(2130903040).setContentTitle(paramJSONObject).setTicker(paramJSONObject).setContentText(paramContext.getResources().getText(2131231238) + " " + paramContext.getResources().getText(2131230782)).setContentIntent(SwipeService.e(paramContext)).setAutoCancel(true).getNotification();
        ((NotificationManager)paramContext.getSystemService("notification")).notify(1001, paramJSONObject);
        vz.a();
      }
    }
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    arj.a(a, new wg(paramContext, paramBoolean));
  }

  public static void a(Context paramContext, Uri[] paramArrayOfUri, String paramString1, String paramString2)
  {
    arj.a(a, new wh(paramContext, paramArrayOfUri, paramString1, paramString2));
  }

  public static boolean a(Context paramContext, Uri[] paramArrayOfUri, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = vs.u(paramContext);
    paramArrayOfUri = (Uri[])localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      c(paramContext);
      localObject = vs.u(paramContext);
      paramArrayOfUri = (Uri[])localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        asp.b("Swipe.API", "Feedback not sent because of missing user id");
        return false;
      }
    }
    asp.a("Swipe.API", "Sending feedback...");
    localObject = new HashMap();
    ((Map)localObject).put("userId", paramArrayOfUri);
    ((Map)localObject).put("title", "Feedback");
    ((Map)localObject).put("content", paramString1);
    ((Map)localObject).put("channel", "26100");
    ((Map)localObject).put("pid", "300105");
    ((Map)localObject).put("verNum", String.valueOf(22500));
    ((Map)localObject).put("contact", asi.b(paramString2));
    ((Map)localObject).put("phoneModel", Build.MODEL);
    ((Map)localObject).put("osVersion", String.valueOf(VERSION.SDK_INT));
    ((Map)localObject).put("promoteChannel", vy.f());
    if (!TextUtils.isEmpty(paramString3))
      ((Map)localObject).put("crash", asi.b(paramString3));
    paramContext = ard.a(paramContext, "http://a.lazyswipe.cn/feedbacks/send", (Map)localObject, 30000, 30000);
    if (arr.a != paramContext.a)
      return false;
    try
    {
      boolean bool = new wb(paramContext.c).d();
      return bool;
    }
    catch (JSONException paramArrayOfUri)
    {
      asp.b("Swipe.API", "Could not parse the json string: " + paramContext.c);
    }
    return false;
  }

  public static void b(Context paramContext)
  {
    arj.a(a, new wi(paramContext));
  }

  public static void b(Context paramContext, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!e(paramContext)))
      return;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("sinceId", String.valueOf(f(paramContext)));
    localHashMap.put("pageSize", "10");
    localHashMap.put("needAppVer", "1");
    a(paramContext, 1, localHashMap);
    if (SwipeApplication.a == null)
      SwipeApplication.a = g(paramContext);
    a();
  }

  public static void c(Context paramContext)
  {
    if (!TextUtils.isEmpty(vs.u(paramContext)));
    while (true)
    {
      return;
      asp.a("Swipe.API", "Registering user...");
      Object localObject1 = new HashMap(6);
      ((Map)localObject1).put("deviceId", aqs.m(paramContext));
      ((Map)localObject1).put("m0", asl.c(paramContext));
      ((Map)localObject1).put("pinfo", "2300105XX26100^^^^00,00");
      ((Map)localObject1).put("clientVer", String.valueOf(22500));
      ((Map)localObject1).put("m1", aqs.n(paramContext));
      ((Map)localObject1).put("m2", aqs.o(paramContext));
      localObject1 = ard.a(paramContext, "http://a.lazyswipe.cn/users/activate", (Map)localObject1, 10000, 10000);
      if (arr.a == ((arq)localObject1).a)
        try
        {
          Object localObject2 = new wa(((arq)localObject1).c);
          asp.a("Swipe.API", "Activation result: " + localObject2);
          String str = ((wa)localObject2).b();
          if (!TextUtils.isEmpty(str))
          {
            vs.a(paramContext, str, ((wa)localObject2).a());
            if (vs.E(paramContext) > 0)
              vy.d(paramContext);
            vy.d();
            localObject2 = vs.a(paramContext);
            vy.a(paramContext, "C2", String.valueOf(((SharedPreferences)localObject2).getInt("key_default_theme", -1)));
            ((SharedPreferences)localObject2).edit().remove("key_default_theme").apply();
            SwipeApplication.c().b();
            return;
          }
        }
        catch (JSONException paramContext)
        {
          asp.b("Swipe.API", "Could not parse the json string: " + ((arq)localObject1).c);
        }
    }
  }

  public static void d(Context paramContext)
  {
    a(paramContext, false);
  }

  static boolean e(Context paramContext)
  {
    return (System.currentTimeMillis() - vs.b() >= 86400000L) && (xl.a(paramContext, 1L, 86400000L));
  }

  // ERROR //
  static long f(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 526	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 531	xa:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 169	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 533
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 539	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface 544 1 0
    //   30: ifeq +33 -> 63
    //   33: aload_0
    //   34: iconst_0
    //   35: invokeinterface 548 2 0
    //   40: ifne +23 -> 63
    //   43: aload_0
    //   44: iconst_0
    //   45: invokeinterface 551 2 0
    //   50: lstore_2
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 554 1 0
    //   61: lload_2
    //   62: lreturn
    //   63: aload_0
    //   64: ifnull +9 -> 73
    //   67: aload_0
    //   68: invokeinterface 554 1 0
    //   73: lconst_0
    //   74: lreturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: ldc 18
    //   80: new 146	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 556
    //   90: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 559	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 222	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: ifnull -34 -> 73
    //   110: aload_0
    //   111: invokeinterface 554 1 0
    //   116: goto -43 -> 73
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +9 -> 132
    //   126: aload_0
    //   127: invokeinterface 554 1 0
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: goto -13 -> 122
    //   138: astore_1
    //   139: goto -17 -> 122
    //   142: astore_1
    //   143: goto -65 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   0	24	75	java/lang/Throwable
    //   0	24	119	finally
    //   24	51	134	finally
    //   78	106	138	finally
    //   24	51	142	java/lang/Throwable
  }

  // ERROR //
  public static JSONObject g(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: lload 9
    //   7: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10: astore_1
    //   11: invokestatic 565	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   14: invokestatic 568	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   17: astore_2
    //   18: aload_2
    //   19: bipush 15
    //   21: invokevirtual 257	java/util/Calendar:get	(I)I
    //   24: istore 7
    //   26: aload_2
    //   27: bipush 16
    //   29: invokevirtual 257	java/util/Calendar:get	(I)I
    //   32: iload 7
    //   34: iadd
    //   35: ineg
    //   36: ldc_w 569
    //   39: idiv
    //   40: invokestatic 186	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   43: astore_3
    //   44: new 146	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 571
    //   54: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_3
    //   58: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 573
    //   64: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 575
    //   70: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 577
    //   76: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 579
    //   82: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 581
    //   88: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 575
    //   94: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_2
    //   101: new 146	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 583
    //   111: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 573
    //   121: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 265
    //   127: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 577
    //   133: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 579
    //   139: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 581
    //   145: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 265
    //   151: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore_3
    //   158: aload_0
    //   159: invokevirtual 526	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   162: getstatic 531	xa:a	Landroid/net/Uri;
    //   165: bipush 8
    //   167: anewarray 169	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: ldc_w 585
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_2
    //   179: aastore
    //   180: dup
    //   181: iconst_2
    //   182: aload_3
    //   183: aastore
    //   184: dup
    //   185: iconst_3
    //   186: ldc 227
    //   188: aastore
    //   189: dup
    //   190: iconst_4
    //   191: ldc_w 271
    //   194: aastore
    //   195: dup
    //   196: iconst_5
    //   197: ldc_w 587
    //   200: aastore
    //   201: dup
    //   202: bipush 6
    //   204: ldc_w 589
    //   207: aastore
    //   208: dup
    //   209: bipush 7
    //   211: ldc_w 591
    //   214: aastore
    //   215: ldc_w 593
    //   218: iconst_2
    //   219: anewarray 169	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload_1
    //   229: aastore
    //   230: ldc_w 595
    //   233: invokevirtual 539	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   236: astore_1
    //   237: aload_1
    //   238: invokeinterface 598 1 0
    //   243: ifeq +354 -> 597
    //   246: aload_1
    //   247: iconst_0
    //   248: invokeinterface 600 2 0
    //   253: astore_3
    //   254: aload_3
    //   255: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +244 -> 502
    //   261: aload_1
    //   262: aload_1
    //   263: ldc 227
    //   265: invokeinterface 604 2 0
    //   270: invokeinterface 600 2 0
    //   275: astore 4
    //   277: aload_0
    //   278: aload_3
    //   279: aload_1
    //   280: aload_1
    //   281: ldc_w 591
    //   284: invokeinterface 604 2 0
    //   289: invokeinterface 606 2 0
    //   294: invokestatic 609	wc:a	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   297: ifne +59 -> 356
    //   300: aload_0
    //   301: aload 4
    //   303: invokestatic 611	wd:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   306: goto -69 -> 237
    //   309: astore_2
    //   310: aload_1
    //   311: astore_0
    //   312: aload_2
    //   313: astore_1
    //   314: ldc 18
    //   316: new 146	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 613
    //   326: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_1
    //   330: invokevirtual 559	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 222	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_0
    //   343: ifnull +9 -> 352
    //   346: aload_0
    //   347: invokeinterface 554 1 0
    //   352: aconst_null
    //   353: astore_0
    //   354: aload_0
    //   355: areturn
    //   356: aload_1
    //   357: aload_1
    //   358: ldc_w 589
    //   361: invokeinterface 604 2 0
    //   366: invokeinterface 606 2 0
    //   371: istore 7
    //   373: aconst_null
    //   374: astore_2
    //   375: aload_0
    //   376: invokevirtual 526	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   379: astore 5
    //   381: getstatic 531	xa:a	Landroid/net/Uri;
    //   384: astore 6
    //   386: iload 7
    //   388: i2l
    //   389: lstore 11
    //   391: aload 5
    //   393: aload 6
    //   395: iconst_1
    //   396: anewarray 169	java/lang/String
    //   399: dup
    //   400: iconst_0
    //   401: ldc_w 615
    //   404: aastore
    //   405: ldc_w 617
    //   408: iconst_3
    //   409: anewarray 169	java/lang/String
    //   412: dup
    //   413: iconst_0
    //   414: aload_3
    //   415: aastore
    //   416: dup
    //   417: iconst_1
    //   418: lload 9
    //   420: lload 11
    //   422: ldc2_w 518
    //   425: lmul
    //   426: lsub
    //   427: invokestatic 425	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   430: aastore
    //   431: dup
    //   432: iconst_2
    //   433: aload 4
    //   435: aastore
    //   436: aconst_null
    //   437: invokevirtual 539	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   440: astore_3
    //   441: aload_3
    //   442: astore_2
    //   443: aload_2
    //   444: invokeinterface 544 1 0
    //   449: ifeq +43 -> 492
    //   452: aload_2
    //   453: iconst_0
    //   454: invokeinterface 606 2 0
    //   459: istore 7
    //   461: iload 7
    //   463: ifle +29 -> 492
    //   466: aload_2
    //   467: ifnull -230 -> 237
    //   470: aload_2
    //   471: invokeinterface 554 1 0
    //   476: goto -239 -> 237
    //   479: astore_0
    //   480: aload_1
    //   481: ifnull +9 -> 490
    //   484: aload_1
    //   485: invokeinterface 554 1 0
    //   490: aload_0
    //   491: athrow
    //   492: aload_2
    //   493: ifnull +9 -> 502
    //   496: aload_2
    //   497: invokeinterface 554 1 0
    //   502: aload_1
    //   503: invokeinterface 620 1 0
    //   508: istore 8
    //   510: new 229	org/json/JSONObject
    //   513: dup
    //   514: invokespecial 621	org/json/JSONObject:<init>	()V
    //   517: astore_2
    //   518: iconst_0
    //   519: istore 7
    //   521: iload 7
    //   523: iload 8
    //   525: if_icmpge +58 -> 583
    //   528: aload_2
    //   529: aload_1
    //   530: iload 7
    //   532: invokeinterface 624 2 0
    //   537: aload_1
    //   538: iload 7
    //   540: invokeinterface 600 2 0
    //   545: invokevirtual 627	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   548: pop
    //   549: iload 7
    //   551: iconst_1
    //   552: iadd
    //   553: istore 7
    //   555: goto -34 -> 521
    //   558: aload_2
    //   559: ifnull -57 -> 502
    //   562: aload_2
    //   563: invokeinterface 554 1 0
    //   568: goto -66 -> 502
    //   571: aload_2
    //   572: ifnull +9 -> 581
    //   575: aload_2
    //   576: invokeinterface 554 1 0
    //   581: aload_0
    //   582: athrow
    //   583: aload_2
    //   584: astore_0
    //   585: aload_1
    //   586: ifnull -232 -> 354
    //   589: aload_1
    //   590: invokeinterface 554 1 0
    //   595: aload_2
    //   596: areturn
    //   597: aload_1
    //   598: ifnull -246 -> 352
    //   601: aload_1
    //   602: invokeinterface 554 1 0
    //   607: goto -255 -> 352
    //   610: astore_0
    //   611: aconst_null
    //   612: astore_1
    //   613: goto -133 -> 480
    //   616: astore_2
    //   617: aload_0
    //   618: astore_1
    //   619: aload_2
    //   620: astore_0
    //   621: goto -141 -> 480
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_0
    //   627: goto -313 -> 314
    //   630: astore_0
    //   631: goto -60 -> 571
    //   634: astore_0
    //   635: goto -77 -> 558
    //   638: astore_0
    //   639: aconst_null
    //   640: astore_2
    //   641: goto -83 -> 558
    //   644: astore_0
    //   645: goto -74 -> 571
    //
    // Exception table:
    //   from	to	target	type
    //   237	306	309	java/lang/Throwable
    //   356	373	309	java/lang/Throwable
    //   470	476	309	java/lang/Throwable
    //   496	502	309	java/lang/Throwable
    //   502	518	309	java/lang/Throwable
    //   528	549	309	java/lang/Throwable
    //   562	568	309	java/lang/Throwable
    //   575	581	309	java/lang/Throwable
    //   581	583	309	java/lang/Throwable
    //   237	306	479	finally
    //   356	373	479	finally
    //   470	476	479	finally
    //   496	502	479	finally
    //   502	518	479	finally
    //   528	549	479	finally
    //   562	568	479	finally
    //   575	581	479	finally
    //   581	583	479	finally
    //   158	237	610	finally
    //   314	342	616	finally
    //   158	237	624	java/lang/Throwable
    //   443	461	630	finally
    //   443	461	634	java/lang/Throwable
    //   375	386	638	java/lang/Throwable
    //   391	441	638	java/lang/Throwable
    //   375	386	644	finally
    //   391	441	644	finally
  }

  public static void h(Context paramContext)
  {
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(1001);
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wd
 * JD-Core Version:    0.6.2
 */