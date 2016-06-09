package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class jl extends BroadcastReceiver
{
  public static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  private static final List<String> b = Arrays.asList(new String[] { "is_cache" });
  private static jk c = null;
  private static boolean d = false;
  private static long e;
  private static ScheduledExecutorService f = null;

  public static String a()
  {
    return a("AppUserId");
  }

  // ERROR //
  public static String a(android.content.ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getstatic 31	jl:a	Landroid/net/Uri;
    //   6: iconst_1
    //   7: anewarray 33	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 70
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +14 -> 37
    //   26: aload_2
    //   27: invokeinterface 82 1 0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +19 -> 53
    //   37: aload_1
    //   38: astore_0
    //   39: aload_2
    //   40: ifnull +11 -> 51
    //   43: aload_2
    //   44: invokeinterface 85 1 0
    //   49: aload_1
    //   50: astore_0
    //   51: aload_0
    //   52: areturn
    //   53: aload_2
    //   54: aload_2
    //   55: ldc 70
    //   57: invokeinterface 89 2 0
    //   62: invokeinterface 93 2 0
    //   67: astore_0
    //   68: aload_0
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: ifnull -22 -> 51
    //   76: aload_2
    //   77: invokeinterface 85 1 0
    //   82: aload_1
    //   83: areturn
    //   84: astore_0
    //   85: aload_1
    //   86: areturn
    //   87: astore_0
    //   88: ldc 95
    //   90: ldc 97
    //   92: aload_0
    //   93: invokestatic 103	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: ifnull -49 -> 51
    //   103: aload_2
    //   104: invokeinterface 85 1 0
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_2
    //   116: ifnull +9 -> 125
    //   119: aload_2
    //   120: invokeinterface 85 1 0
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: goto -6 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   76	82	84	java/lang/Exception
    //   26	33	87	java/lang/Exception
    //   53	68	87	java/lang/Exception
    //   103	109	111	java/lang/Exception
    //   26	33	114	finally
    //   53	68	114	finally
    //   88	97	114	finally
    //   43	49	127	java/lang/Exception
    //   119	125	130	java/lang/Exception
  }

  public static String a(String paramString)
  {
    return jq.a().b(paramString);
  }

  private static String a(SimpleDateFormat paramSimpleDateFormat, Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appsflyer-data", 0);
    String str = localSharedPreferences.getString("appsFlyerFirstInstall", null);
    Object localObject = str;
    if (str == null)
    {
      if (!h(paramContext))
        break label121;
      if (g(paramContext))
        Log.d("AppsFlyer_1.13", "AppsFlyer: first launch detected");
    }
    label121: for (paramSimpleDateFormat = paramSimpleDateFormat.format(new Date()); ; paramSimpleDateFormat = "")
    {
      localObject = localSharedPreferences.edit();
      ((Editor)localObject).putString("appsFlyerFirstInstall", paramSimpleDateFormat);
      ((Editor)localObject).commit();
      localObject = paramSimpleDateFormat;
      if (g(paramContext))
        Log.i("AppsFlyer_1.13", "AppsFlyer: first launch date: " + (String)localObject);
      return localObject;
    }
  }

  public static void a(Context paramContext)
  {
    a(paramContext, null);
    if (g(paramContext))
      Log.i("AppsFlyer_1.13", "Start tracking package: " + paramContext.getPackageName());
  }

  @Deprecated
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (paramString3 != null) && (paramString3.matches("-?\\d+(\\.\\d+)?")))
      Log.i("AppsFlyer_1.13", "AppsFLyer: numeric value '" + paramString3 + "' for event '" + paramString2 + "' will be categorized as a revenue event.");
    String str2 = jq.a().a(paramContext);
    String str1 = str2;
    if (str2 == null)
      str1 = "";
    b(paramContext, paramString1, paramString2, paramString3, str1);
  }

  private static void a(Context paramContext, Map<String, String> paramMap)
  {
    if (jq.a().b("deviceTrackingDisabled", false))
      paramMap.put("deviceTrackingDisabled", "true");
    while (true)
    {
      return;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appsflyer-data", 0);
      boolean bool = jq.a().b("collectIMEI", true);
      String str1 = localSharedPreferences.getString("imeiCached", null);
      if (bool);
      try
      {
        Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
        str2 = (String)localObject1.getClass().getMethod("getDeviceId", new Class[0]).invoke(localObject1, new Object[0]);
        if (str2 == null)
          localObject1 = str1;
        while (true)
        {
          while (true)
          {
            if (localObject1 != null)
              paramMap.put("imei", localObject1);
            bool = jq.a().b("collectAndroidId", true);
            localObject1 = localSharedPreferences.getString("androidIdCached", null);
            if (!bool)
              break;
            try
            {
              paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
              if (paramContext != null)
                break label254;
              paramContext = (Context)localObject1;
              if (paramContext == null)
                break;
              paramMap.put("android_id", paramContext);
              return;
            }
            catch (Exception paramContext)
            {
              return;
            }
          }
          localObject1 = str2;
          if (str1 == null)
          {
            localObject1 = localSharedPreferences.edit();
            ((Editor)localObject1).putString("imeiCached", str2);
            if (Build.VERSION.SDK_INT < 9)
              break label241;
            ((Editor)localObject1).apply();
            localObject1 = str2;
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str2;
          Log.i("AppsFlyer_1.13", "WARNING:READ_PHONE_STATE is missing");
          continue;
          label241: localException.commit();
          Object localObject2 = str2;
          continue;
          label254: localObject2 = localSharedPreferences.edit();
          ((Editor)localObject2).putString("androidIdCached", paramContext);
          if (Build.VERSION.SDK_INT >= 9)
            ((Editor)localObject2).apply();
          else
            ((Editor)localObject2).commit();
        }
      }
    }
  }

  // ERROR //
  private void a(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 4
    //   8: astore_3
    //   9: new 162	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 296
    //   19: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 5
    //   27: aload 4
    //   29: astore_3
    //   30: aload_2
    //   31: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   34: ifeq +33 -> 67
    //   37: aload 4
    //   39: astore_3
    //   40: ldc 95
    //   42: new 162	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 298
    //   52: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 5
    //   57: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: aload 4
    //   69: astore_3
    //   70: new 300	java/util/HashMap
    //   73: dup
    //   74: invokespecial 301	java/util/HashMap:<init>	()V
    //   77: astore 7
    //   79: aload 4
    //   81: astore_3
    //   82: aload 7
    //   84: ldc_w 303
    //   87: aload_1
    //   88: invokeinterface 229 3 0
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: aload_2
    //   98: aload 7
    //   100: invokestatic 305	jl:b	(Landroid/content/Context;Ljava/util/Map;)V
    //   103: aload 4
    //   105: astore_3
    //   106: aload_2
    //   107: aload 7
    //   109: invokestatic 307	jl:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   112: aload 4
    //   114: astore_3
    //   115: aload 7
    //   117: invokestatic 309	jl:d	(Ljava/util/Map;)Ljava/lang/String;
    //   120: astore 7
    //   122: aload 4
    //   124: astore_3
    //   125: new 311	java/net/URL
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 314	java/net/URL:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 318	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   137: checkcast 320	java/net/HttpURLConnection
    //   140: astore 4
    //   142: aload 4
    //   144: ldc_w 322
    //   147: invokevirtual 325	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   150: aload 7
    //   152: invokevirtual 329	java/lang/String:getBytes	()[B
    //   155: arraylength
    //   156: istore 8
    //   158: aload 4
    //   160: ldc_w 331
    //   163: new 162	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   170: iload 8
    //   172: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 177
    //   177: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 4
    //   188: ldc_w 340
    //   191: ldc_w 341
    //   194: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 4
    //   199: sipush 10000
    //   202: invokevirtual 345	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   205: aload 4
    //   207: iconst_1
    //   208: invokevirtual 349	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   211: new 351	java/io/OutputStreamWriter
    //   214: dup
    //   215: aload 4
    //   217: invokevirtual 355	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   220: invokespecial 358	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   223: astore 5
    //   225: aload 5
    //   227: aload 7
    //   229: invokevirtual 361	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   232: aload 5
    //   234: ifnull +8 -> 242
    //   237: aload 5
    //   239: invokevirtual 362	java/io/OutputStreamWriter:close	()V
    //   242: aload 4
    //   244: invokevirtual 366	java/net/HttpURLConnection:getResponseCode	()I
    //   247: sipush 200
    //   250: if_icmpne +129 -> 379
    //   253: aload_2
    //   254: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   257: ifeq +29 -> 286
    //   260: ldc 95
    //   262: new 162	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 368
    //   272: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   285: pop
    //   286: aload 4
    //   288: ifnull +8 -> 296
    //   291: aload 4
    //   293: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   296: return
    //   297: astore_3
    //   298: aconst_null
    //   299: astore 5
    //   301: aload 5
    //   303: ifnull +8 -> 311
    //   306: aload 5
    //   308: invokevirtual 362	java/io/OutputStreamWriter:close	()V
    //   311: aload_3
    //   312: athrow
    //   313: astore 5
    //   315: aload 4
    //   317: astore_3
    //   318: aload_2
    //   319: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   322: ifeq +46 -> 368
    //   325: aload 4
    //   327: astore_3
    //   328: ldc 95
    //   330: new 162	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 373
    //   340: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_1
    //   344: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 375
    //   350: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 5
    //   355: invokevirtual 378	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   358: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   367: pop
    //   368: aload 4
    //   370: ifnull -74 -> 296
    //   373: aload 4
    //   375: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   378: return
    //   379: aload_2
    //   380: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   383: ifeq -97 -> 286
    //   386: ldc 95
    //   388: new 162	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 373
    //   398: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: goto -126 -> 286
    //   415: astore_1
    //   416: aload 4
    //   418: astore_3
    //   419: aload_3
    //   420: ifnull +7 -> 427
    //   423: aload_3
    //   424: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore_1
    //   430: goto -11 -> 419
    //   433: astore 5
    //   435: aload 6
    //   437: astore 4
    //   439: goto -124 -> 315
    //   442: astore_3
    //   443: goto -142 -> 301
    //
    // Exception table:
    //   from	to	target	type
    //   211	225	297	finally
    //   142	211	313	java/lang/Throwable
    //   237	242	313	java/lang/Throwable
    //   242	286	313	java/lang/Throwable
    //   306	311	313	java/lang/Throwable
    //   311	313	313	java/lang/Throwable
    //   379	412	313	java/lang/Throwable
    //   142	211	415	finally
    //   237	242	415	finally
    //   242	286	415	finally
    //   306	311	415	finally
    //   311	313	415	finally
    //   379	412	415	finally
    //   9	27	429	finally
    //   30	37	429	finally
    //   40	67	429	finally
    //   70	79	429	finally
    //   82	94	429	finally
    //   97	103	429	finally
    //   106	112	429	finally
    //   115	122	429	finally
    //   125	142	429	finally
    //   318	325	429	finally
    //   328	368	429	finally
    //   9	27	433	java/lang/Throwable
    //   30	37	433	java/lang/Throwable
    //   40	67	433	java/lang/Throwable
    //   70	79	433	java/lang/Throwable
    //   82	94	433	java/lang/Throwable
    //   97	103	433	java/lang/Throwable
    //   106	112	433	java/lang/Throwable
    //   115	122	433	java/lang/Throwable
    //   125	142	433	java/lang/Throwable
    //   225	232	442	finally
  }

  protected static void a(String paramString1, String paramString2)
  {
    jq.a().a(paramString1, paramString2);
  }

  private static void a(String paramString1, String paramString2, Context paramContext)
  {
    if ((paramContext != null) && ("com.appsflyer".equals(paramContext.getPackageName())))
      jt.a().a(paramString1 + paramString2);
  }

  // ERROR //
  private static void a(URL paramURL, String paramString1, String paramString2, WeakReference<Context> paramWeakReference, String paramString3, String paramString4, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 406	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   4: checkcast 115	android/content/Context
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 318	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: checkcast 320	java/net/HttpURLConnection
    //   16: astore 7
    //   18: aload 7
    //   20: ldc_w 322
    //   23: invokevirtual 325	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 329	java/lang/String:getBytes	()[B
    //   30: arraylength
    //   31: istore 10
    //   33: aload 7
    //   35: ldc_w 331
    //   38: new 162	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   45: iload 10
    //   47: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 177
    //   52: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload 7
    //   63: ldc_w 340
    //   66: ldc_w 341
    //   69: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 7
    //   74: sipush 10000
    //   77: invokevirtual 345	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   80: aload 7
    //   82: iconst_1
    //   83: invokevirtual 349	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   86: new 351	java/io/OutputStreamWriter
    //   89: dup
    //   90: aload 7
    //   92: invokevirtual 355	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   95: invokespecial 358	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   98: astore 8
    //   100: aload 8
    //   102: aload_1
    //   103: invokevirtual 361	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   106: aload 8
    //   108: ifnull +8 -> 116
    //   111: aload 8
    //   113: invokevirtual 362	java/io/OutputStreamWriter:close	()V
    //   116: aload 7
    //   118: invokevirtual 366	java/net/HttpURLConnection:getResponseCode	()I
    //   121: istore 10
    //   123: aload 9
    //   125: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   128: ifeq +30 -> 158
    //   131: aload 5
    //   133: new 162	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 408
    //   143: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload 10
    //   148: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: aload 9
    //   160: aload 5
    //   162: ldc_w 410
    //   165: iload 10
    //   167: invokestatic 414	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   170: invokestatic 416	jl:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: ldc_w 418
    //   176: iload 10
    //   178: invokestatic 414	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   181: aload 9
    //   183: invokestatic 420	jl:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   186: aload 9
    //   188: ldc 113
    //   190: iconst_0
    //   191: invokevirtual 119	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   194: astore_0
    //   195: iload 10
    //   197: sipush 200
    //   200: if_icmpne +61 -> 261
    //   203: aload 4
    //   205: ifnull +13 -> 218
    //   208: invokestatic 425	jx:a	()Ljx;
    //   211: aload 4
    //   213: aload 9
    //   215: invokevirtual 427	jx:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   218: aload_3
    //   219: invokevirtual 406	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   222: ifnull +39 -> 261
    //   225: aload 4
    //   227: ifnonnull +34 -> 261
    //   230: aload_0
    //   231: invokeinterface 151 1 0
    //   236: astore_1
    //   237: aload_1
    //   238: ldc_w 429
    //   241: ldc 223
    //   243: invokeinterface 157 3 0
    //   248: pop
    //   249: aload_1
    //   250: invokeinterface 160 1 0
    //   255: pop
    //   256: aload 9
    //   258: invokestatic 432	jl:l	(Landroid/content/Context;)V
    //   261: aload_0
    //   262: ldc_w 434
    //   265: aconst_null
    //   266: invokeinterface 126 3 0
    //   271: ifnonnull +81 -> 352
    //   274: aload_2
    //   275: ifnull +77 -> 352
    //   278: iload 6
    //   280: ifeq +72 -> 352
    //   283: invokestatic 440	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   286: astore_0
    //   287: aload_0
    //   288: new 442	jm
    //   291: dup
    //   292: aload 9
    //   294: invokevirtual 446	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   297: aload_2
    //   298: aload_0
    //   299: invokespecial 449	jm:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   302: ldc2_w 450
    //   305: getstatic 457	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   308: invokeinterface 463 5 0
    //   313: pop
    //   314: aload 7
    //   316: ifnull +8 -> 324
    //   319: aload 7
    //   321: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   324: return
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_1
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 362	java/io/OutputStreamWriter:close	()V
    //   336: aload_0
    //   337: athrow
    //   338: astore_0
    //   339: aload 7
    //   341: astore_1
    //   342: aload_1
    //   343: ifnull +7 -> 350
    //   346: aload_1
    //   347: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   350: aload_0
    //   351: athrow
    //   352: aload_2
    //   353: ifnonnull +15 -> 368
    //   356: aload 5
    //   358: ldc_w 465
    //   361: invokestatic 467	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: goto -51 -> 314
    //   368: iload 6
    //   370: ifeq -56 -> 314
    //   373: getstatic 45	jl:c	Ljk;
    //   376: ifnull -62 -> 314
    //   379: aload_0
    //   380: ldc_w 434
    //   383: aconst_null
    //   384: invokeinterface 126 3 0
    //   389: ifnull -75 -> 314
    //   392: aload 9
    //   394: iconst_0
    //   395: invokestatic 56	jl:b	(Landroid/content/Context;Z)I
    //   398: istore 10
    //   400: iload 10
    //   402: iconst_1
    //   403: if_icmple -89 -> 314
    //   406: aload 9
    //   408: invokestatic 470	jl:b	(Landroid/content/Context;)Ljava/util/Map;
    //   411: astore_0
    //   412: aload_0
    //   413: ifnull -99 -> 314
    //   416: getstatic 45	jl:c	Ljk;
    //   419: aload_0
    //   420: invokeinterface 475 2 0
    //   425: goto -111 -> 314
    //   428: astore_0
    //   429: goto -115 -> 314
    //   432: astore_0
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -93 -> 342
    //   438: astore_0
    //   439: aload 8
    //   441: astore_1
    //   442: goto -114 -> 328
    //
    // Exception table:
    //   from	to	target	type
    //   86	100	325	finally
    //   18	86	338	finally
    //   111	116	338	finally
    //   116	158	338	finally
    //   158	195	338	finally
    //   208	218	338	finally
    //   218	225	338	finally
    //   230	261	338	finally
    //   261	274	338	finally
    //   283	314	338	finally
    //   332	336	338	finally
    //   336	338	338	finally
    //   356	365	338	finally
    //   373	400	338	finally
    //   406	412	338	finally
    //   416	425	338	finally
    //   406	412	428	jr
    //   416	425	428	jr
    //   9	18	432	finally
    //   100	106	438	finally
  }

  private static int b(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("appsflyer-data", 0);
    int j = paramContext.getInt("appsFlyerCount", 0);
    int i = j;
    if (paramBoolean)
    {
      i = j + 1;
      paramContext = paramContext.edit();
      paramContext.putInt("appsFlyerCount", i);
      paramContext.commit();
    }
    return i;
  }

  public static Map<String, String> b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appsflyer-data", 0);
    String str = jq.a().a(paramContext);
    if ((str != null) && (str.length() > 0) && (str.contains("af_tranid")))
      return b(str, paramContext);
    paramContext = localSharedPreferences.getString("attributionId", null);
    if ((paramContext != null) && (paramContext.length() > 0))
      return f(paramContext);
    throw new jr();
  }

  private static Map<String, String> b(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    int i = paramString.indexOf('&');
    if ((i >= 0) && (paramString.length() > i + 1))
    {
      String[] arrayOfString = paramString.split("\\&");
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        paramString = arrayOfString[i].split("=");
        String str = e(paramString[0]);
        if (paramString.length > 1);
        for (paramString = paramString[1]; ; paramString = "")
        {
          localHashMap.put(str, paramString);
          i += 1;
          break;
        }
      }
    }
    try
    {
      if (!localHashMap.containsKey("install_time"))
      {
        long l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).firstInstallTime;
        localHashMap.put("install_time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(l)));
      }
      if (!localHashMap.containsKey("af_status"))
        localHashMap.put("af_status", "Non-organic");
      return localHashMap;
    }
    catch (Exception paramString)
    {
      while (true)
        Log.w("AppsFlyer_1.13", "Could not fetch install time");
    }
  }

  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (jq.a().b("shouldMonitor", false))
    {
      Intent localIntent = new Intent("com.appsflyer.MonitorBroadcast");
      localIntent.setPackage("com.appsflyer.nightvision");
      localIntent.putExtra("message", paramString2);
      localIntent.putExtra("value", paramString3);
      localIntent.putExtra("packageName", "true");
      localIntent.putExtra("pid", new Integer(Process.myPid()));
      localIntent.putExtra("eventIdentifier", paramString1);
      localIntent.putExtra("sdk", "2.3.1.13");
      paramContext.sendBroadcast(localIntent);
    }
  }

  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    localScheduledExecutorService.schedule(new jo(paramContext, paramString1, paramString2, paramString3, paramString4, localScheduledExecutorService, null), 5L, TimeUnit.MILLISECONDS);
  }

  private static void b(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      localObject = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      String str = ((AdvertisingIdClient.Info)localObject).getId();
      paramMap.put("advertiserId", str);
      if (!((AdvertisingIdClient.Info)localObject).isLimitAdTrackingEnabled());
      for (boolean bool = true; ; bool = false)
      {
        localObject = Boolean.toString(bool);
        paramMap.put("advertiserIdEnabled", localObject);
        jq.a().a("advertiserId", str);
        jq.a().a("advertiserIdEnabled", (String)localObject);
        return;
      }
    }
    catch (ClassNotFoundException paramMap)
    {
      while (!g(paramContext));
      Log.i("AppsFlyer_1.13", "WARNING:Google Play services SDK jar is missing.");
      return;
    }
    catch (Exception localException)
    {
      Object localObject = jq.a().b("advertiserId");
      if (localObject != null)
        paramMap.put("advertiserId", localObject);
      localObject = jq.a().b("advertiserIdEnabled");
      if (localObject != null)
        paramMap.put("advertiserIdEnabled", localObject);
      if (localException.getLocalizedMessage() == null)
        break label180;
    }
    Log.i("AppsFlyer_1.13", localException.getLocalizedMessage());
    while (true)
    {
      a("Could not fetch advertiser id: ", localException.getLocalizedMessage(), paramContext);
      return;
      label180: Log.i("AppsFlyer_1.13", localException.toString());
    }
  }

  public static void b(String paramString)
  {
    a("AppUserId", paramString);
  }

  private static void b(String paramString1, String paramString2, String paramString3, WeakReference<Context> paramWeakReference, String paramString4, String paramString5, boolean paramBoolean)
  {
    URL localURL = new URL(paramString1);
    if (g((Context)paramWeakReference.get()))
      Log.i(paramString5, "url: " + localURL.toString());
    a("call server.", "\n" + localURL.toString() + "\nPOST:" + paramString2, (Context)paramWeakReference.get());
    if (g((Context)paramWeakReference.get()))
      Log.i(paramString5, "data: " + paramString2);
    b((Context)paramWeakReference.get(), paramString5, "EVENT_DATA", paramString2);
    if (paramBoolean)
      jq.a().d();
    try
    {
      a(localURL, paramString2, paramString3, paramWeakReference, paramString4, paramString5, paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      if (jq.a().b("useHttpFallback", false))
      {
        a("https failed: " + localIOException.getLocalizedMessage(), "", (Context)paramWeakReference.get());
        a(new URL(paramString1.replace("https:", "http:")), paramString2, paramString3, paramWeakReference, paramString4, paramString5, paramBoolean);
        return;
      }
      Log.i(paramString5, "failed to send requeset to server. " + localIOException.getLocalizedMessage());
      b((Context)paramWeakReference.get(), paramString5, "ERROR", localIOException.getLocalizedMessage());
    }
  }

  private static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("appsflyer-data", 0);
    if (paramContext.contains("CACHED_CHANNEL"))
      return paramContext.getString("CACHED_CHANNEL", null);
    paramContext = paramContext.edit();
    paramContext.putString("CACHED_CHANNEL", paramString);
    paramContext.commit();
    return paramString;
  }

  private static String c(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("af_timestamp");
    if ((paramMap == null) || (paramMap.length() < 5))
      return "AppsFlyer_1.13";
    return "AppsFlyer_1.13-" + paramMap.substring(4);
  }

  // ERROR //
  private static void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +1665 -> 1666
    //   4: iconst_1
    //   5: istore 16
    //   7: new 300	java/util/HashMap
    //   10: dup
    //   11: invokespecial 301	java/util/HashMap:<init>	()V
    //   14: astore 7
    //   16: aload 7
    //   18: ldc_w 686
    //   21: new 140	java/util/Date
    //   24: dup
    //   25: invokespecial 141	java/util/Date:<init>	()V
    //   28: invokevirtual 703	java/util/Date:getTime	()J
    //   31: invokestatic 708	java/lang/Long:toString	(J)Ljava/lang/String;
    //   34: invokeinterface 229 3 0
    //   39: pop
    //   40: aload 7
    //   42: invokestatic 180	jl:c	(Ljava/util/Map;)Ljava/lang/String;
    //   45: astore 6
    //   47: aload_0
    //   48: invokestatic 133	jl:g	(Landroid/content/Context;)Z
    //   51: ifeq +1589 -> 1640
    //   54: ldc_w 710
    //   57: ldc 177
    //   59: aload_0
    //   60: invokestatic 420	jl:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   63: new 162	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 712
    //   73: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: astore 8
    //   78: iload 16
    //   80: ifeq +1592 -> 1672
    //   83: ldc_w 714
    //   86: astore 5
    //   88: aload 6
    //   90: aload 8
    //   92: aload 5
    //   94: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: iload 16
    //   106: ifeq +1572 -> 1678
    //   109: ldc_w 714
    //   112: astore 5
    //   114: ldc_w 716
    //   117: aload 5
    //   119: aload_0
    //   120: invokestatic 420	jl:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   123: goto +1517 -> 1640
    //   126: aload_0
    //   127: aload 6
    //   129: ldc_w 718
    //   132: aload 5
    //   134: invokestatic 416	jl:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   137: invokestatic 425	jx:a	()Ljx;
    //   140: aload_0
    //   141: invokevirtual 720	jx:a	(Landroid/content/Context;)V
    //   144: aload_0
    //   145: invokevirtual 530	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   148: aload_0
    //   149: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   152: sipush 4096
    //   155: invokevirtual 536	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   158: getfield 724	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   161: invokestatic 41	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   164: astore 5
    //   166: aload 5
    //   168: ldc_w 726
    //   171: invokeinterface 730 2 0
    //   176: ifne +21 -> 197
    //   179: ldc 95
    //   181: ldc_w 732
    //   184: invokestatic 467	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aload_0
    //   189: aconst_null
    //   190: ldc_w 734
    //   193: aconst_null
    //   194: invokestatic 416	jl:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 5
    //   199: ldc_w 736
    //   202: invokeinterface 730 2 0
    //   207: ifne +12 -> 219
    //   210: ldc 95
    //   212: ldc_w 738
    //   215: invokestatic 467	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   218: pop
    //   219: aload 5
    //   221: ldc_w 740
    //   224: invokeinterface 730 2 0
    //   229: ifne +12 -> 241
    //   232: ldc 95
    //   234: ldc_w 742
    //   237: invokestatic 467	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: new 162	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: ldc_w 744
    //   255: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   262: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 7
    //   268: ldc_w 746
    //   271: getstatic 752	android/os/Build:BRAND	Ljava/lang/String;
    //   274: invokeinterface 229 3 0
    //   279: pop
    //   280: aload 7
    //   282: ldc_w 754
    //   285: getstatic 757	android/os/Build:DEVICE	Ljava/lang/String;
    //   288: invokeinterface 229 3 0
    //   293: pop
    //   294: aload 7
    //   296: ldc_w 759
    //   299: getstatic 762	android/os/Build:PRODUCT	Ljava/lang/String;
    //   302: invokeinterface 229 3 0
    //   307: pop
    //   308: aload 7
    //   310: ldc_w 592
    //   313: getstatic 284	android/os/Build$VERSION:SDK_INT	I
    //   316: invokestatic 414	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   319: invokeinterface 229 3 0
    //   324: pop
    //   325: aload 7
    //   327: ldc_w 764
    //   330: getstatic 767	android/os/Build:MODEL	Ljava/lang/String;
    //   333: invokeinterface 229 3 0
    //   338: pop
    //   339: aload 7
    //   341: ldc_w 769
    //   344: getstatic 772	android/os/Build:TYPE	Ljava/lang/String;
    //   347: invokeinterface 229 3 0
    //   352: pop
    //   353: invokestatic 108	jq:a	()Ljq;
    //   356: ldc_w 774
    //   359: invokevirtual 110	jq:b	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore 5
    //   364: aload 5
    //   366: ifnull +24 -> 390
    //   369: aload 5
    //   371: invokevirtual 493	java/lang/String:length	()I
    //   374: ifle +16 -> 390
    //   377: aload 7
    //   379: ldc_w 774
    //   382: aload 5
    //   384: invokeinterface 229 3 0
    //   389: pop
    //   390: aload_0
    //   391: invokestatic 777	jl:m	(Landroid/content/Context;)Ljava/lang/String;
    //   394: astore 5
    //   396: aload_0
    //   397: aload 5
    //   399: invokestatic 490	jl:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   402: astore 9
    //   404: aload 9
    //   406: ifnull +16 -> 422
    //   409: aload 7
    //   411: ldc_w 779
    //   414: aload 9
    //   416: invokeinterface 229 3 0
    //   421: pop
    //   422: aload 9
    //   424: ifnull +1229 -> 1653
    //   427: aload 9
    //   429: aload 5
    //   431: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: ifeq +6 -> 440
    //   437: goto +1216 -> 1653
    //   440: aload 7
    //   442: ldc_w 781
    //   445: aload 5
    //   447: invokeinterface 229 3 0
    //   452: pop
    //   453: aload_0
    //   454: invokestatic 783	jl:i	(Landroid/content/Context;)Ljava/lang/String;
    //   457: astore 5
    //   459: aload 5
    //   461: ifnull +19 -> 480
    //   464: aload 7
    //   466: ldc_w 785
    //   469: aload 5
    //   471: invokevirtual 788	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   474: invokeinterface 229 3 0
    //   479: pop
    //   480: aload_0
    //   481: invokestatic 791	jl:k	(Landroid/content/Context;)Ljava/lang/String;
    //   484: astore 5
    //   486: aload 5
    //   488: ifnull +19 -> 507
    //   491: aload 7
    //   493: ldc_w 793
    //   496: aload 5
    //   498: invokevirtual 788	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   501: invokeinterface 229 3 0
    //   506: pop
    //   507: aload_0
    //   508: invokestatic 796	jl:j	(Landroid/content/Context;)Ljava/lang/String;
    //   511: astore 5
    //   513: aload 5
    //   515: ifnull +19 -> 534
    //   518: aload 7
    //   520: ldc_w 798
    //   523: aload 5
    //   525: invokevirtual 788	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   528: invokeinterface 229 3 0
    //   533: pop
    //   534: aload_1
    //   535: ifnull +13 -> 548
    //   538: aload_1
    //   539: astore 5
    //   541: aload_1
    //   542: invokevirtual 493	java/lang/String:length	()I
    //   545: ifne +11 -> 556
    //   548: ldc_w 800
    //   551: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   554: astore 5
    //   556: aload 5
    //   558: ifnull +153 -> 711
    //   561: aload 5
    //   563: invokevirtual 493	java/lang/String:length	()I
    //   566: ifle +145 -> 711
    //   569: aload 7
    //   571: ldc_w 802
    //   574: aload 5
    //   576: invokeinterface 229 3 0
    //   581: pop
    //   582: aload 5
    //   584: invokevirtual 493	java/lang/String:length	()I
    //   587: bipush 8
    //   589: if_icmple +22 -> 611
    //   592: aload 7
    //   594: ldc_w 804
    //   597: aload 5
    //   599: iconst_0
    //   600: bipush 8
    //   602: invokevirtual 807	java/lang/String:substring	(II)Ljava/lang/String;
    //   605: invokeinterface 229 3 0
    //   610: pop
    //   611: invokestatic 809	jl:a	()Ljava/lang/String;
    //   614: astore_1
    //   615: aload_1
    //   616: ifnull +15 -> 631
    //   619: aload 7
    //   621: ldc_w 811
    //   624: aload_1
    //   625: invokeinterface 229 3 0
    //   630: pop
    //   631: invokestatic 108	jq:a	()Ljq;
    //   634: ldc_w 813
    //   637: invokevirtual 815	jq:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   640: astore_1
    //   641: aload_1
    //   642: ifnull +831 -> 1473
    //   645: new 162	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   652: astore 5
    //   654: aload_1
    //   655: arraylength
    //   656: istore 11
    //   658: iconst_0
    //   659: istore 10
    //   661: iload 10
    //   663: iload 11
    //   665: if_icmpge +75 -> 740
    //   668: aload_1
    //   669: iload 10
    //   671: aaload
    //   672: astore 9
    //   674: aload 5
    //   676: invokevirtual 816	java/lang/StringBuilder:length	()I
    //   679: iconst_1
    //   680: if_icmple +11 -> 691
    //   683: aload 5
    //   685: bipush 44
    //   687: invokevirtual 819	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 5
    //   693: aload 9
    //   695: invokestatic 822	jv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   698: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: iload 10
    //   704: iconst_1
    //   705: iadd
    //   706: istore 10
    //   708: goto -47 -> 661
    //   711: aload 6
    //   713: ldc_w 824
    //   716: invokestatic 826	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   719: pop
    //   720: aload_0
    //   721: aload 6
    //   723: ldc_w 828
    //   726: aconst_null
    //   727: invokestatic 416	jl:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload 6
    //   732: ldc_w 830
    //   735: invokestatic 826	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   738: pop
    //   739: return
    //   740: aload 7
    //   742: ldc_w 832
    //   745: aload 5
    //   747: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokeinterface 229 3 0
    //   755: pop
    //   756: aload_2
    //   757: ifnull +31 -> 788
    //   760: aload 7
    //   762: ldc_w 834
    //   765: aload_2
    //   766: invokeinterface 229 3 0
    //   771: pop
    //   772: aload_3
    //   773: ifnull +15 -> 788
    //   776: aload 7
    //   778: ldc_w 836
    //   781: aload_3
    //   782: invokeinterface 229 3 0
    //   787: pop
    //   788: ldc_w 838
    //   791: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   794: ifnull +20 -> 814
    //   797: aload 7
    //   799: ldc_w 838
    //   802: ldc_w 838
    //   805: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   808: invokeinterface 229 3 0
    //   813: pop
    //   814: ldc_w 840
    //   817: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   820: astore_1
    //   821: aload_1
    //   822: ifnull +55 -> 877
    //   825: aload_1
    //   826: invokevirtual 493	java/lang/String:length	()I
    //   829: iconst_3
    //   830: if_icmpeq +35 -> 865
    //   833: ldc 95
    //   835: new 162	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 842
    //   845: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_1
    //   849: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc_w 844
    //   855: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokestatic 467	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   864: pop
    //   865: aload 7
    //   867: ldc_w 846
    //   870: aload_1
    //   871: invokeinterface 229 3 0
    //   876: pop
    //   877: ldc_w 848
    //   880: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   883: astore_1
    //   884: aload_1
    //   885: ifnull +15 -> 900
    //   888: aload 7
    //   890: ldc_w 850
    //   893: aload_1
    //   894: invokeinterface 229 3 0
    //   899: pop
    //   900: aload 7
    //   902: ldc_w 852
    //   905: aload_0
    //   906: invokestatic 854	jl:c	(Landroid/content/Context;)Z
    //   909: invokestatic 634	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   912: invokeinterface 229 3 0
    //   917: pop
    //   918: aload_0
    //   919: invokevirtual 271	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   922: invokestatic 856	jl:a	(Landroid/content/ContentResolver;)Ljava/lang/String;
    //   925: astore_1
    //   926: aload_1
    //   927: ifnull +15 -> 942
    //   930: aload 7
    //   932: ldc_w 858
    //   935: aload_1
    //   936: invokeinterface 229 3 0
    //   941: pop
    //   942: aload_0
    //   943: aload 7
    //   945: invokestatic 307	jl:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   948: aload_0
    //   949: invokestatic 861	jw:a	(Landroid/content/Context;)Ljava/lang/String;
    //   952: astore_1
    //   953: aload_1
    //   954: ifnull +15 -> 969
    //   957: aload 7
    //   959: ldc_w 863
    //   962: aload_1
    //   963: invokeinterface 229 3 0
    //   968: pop
    //   969: aload 7
    //   971: ldc_w 865
    //   974: invokestatic 871	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   977: invokevirtual 874	java/util/Locale:getDisplayLanguage	()Ljava/lang/String;
    //   980: invokeinterface 229 3 0
    //   985: pop
    //   986: aload_0
    //   987: ldc 235
    //   989: invokevirtual 239	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   992: checkcast 241	android/telephony/TelephonyManager
    //   995: astore_1
    //   996: aload 7
    //   998: ldc_w 876
    //   1001: aload_1
    //   1002: invokevirtual 879	android/telephony/TelephonyManager:getSimOperatorName	()Ljava/lang/String;
    //   1005: invokeinterface 229 3 0
    //   1010: pop
    //   1011: aload 7
    //   1013: ldc_w 881
    //   1016: aload_1
    //   1017: invokevirtual 884	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   1020: invokeinterface 229 3 0
    //   1025: pop
    //   1026: aload 7
    //   1028: ldc_w 886
    //   1031: aload_0
    //   1032: invokestatic 889	jl:n	(Landroid/content/Context;)Ljava/lang/String;
    //   1035: invokeinterface 229 3 0
    //   1040: pop
    //   1041: aload_0
    //   1042: aload 7
    //   1044: invokestatic 305	jl:b	(Landroid/content/Context;Ljava/util/Map;)V
    //   1047: new 143	java/text/SimpleDateFormat
    //   1050: dup
    //   1051: ldc_w 891
    //   1054: invokespecial 544	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   1057: astore_1
    //   1058: getstatic 284	android/os/Build$VERSION:SDK_INT	I
    //   1061: istore 10
    //   1063: iload 10
    //   1065: bipush 9
    //   1067: if_icmplt +40 -> 1107
    //   1070: aload 7
    //   1072: ldc_w 893
    //   1075: aload_1
    //   1076: new 140	java/util/Date
    //   1079: dup
    //   1080: aload_0
    //   1081: invokevirtual 530	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1084: aload_0
    //   1085: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1088: iconst_0
    //   1089: invokevirtual 536	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1092: getfield 541	android/content/pm/PackageInfo:firstInstallTime	J
    //   1095: invokespecial 547	java/util/Date:<init>	(J)V
    //   1098: invokevirtual 147	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1101: invokeinterface 229 3 0
    //   1106: pop
    //   1107: aload_0
    //   1108: invokevirtual 530	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1111: aload_0
    //   1112: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1115: iconst_0
    //   1116: invokevirtual 536	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1119: astore_2
    //   1120: aload 7
    //   1122: ldc_w 895
    //   1125: aload_2
    //   1126: getfield 898	android/content/pm/PackageInfo:versionCode	I
    //   1129: invokestatic 414	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1132: invokeinterface 229 3 0
    //   1137: pop
    //   1138: aload 7
    //   1140: ldc_w 900
    //   1143: aload_2
    //   1144: getfield 903	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1147: invokeinterface 229 3 0
    //   1152: pop
    //   1153: aload_2
    //   1154: getfield 541	android/content/pm/PackageInfo:firstInstallTime	J
    //   1157: lstore 12
    //   1159: aload_2
    //   1160: getfield 906	android/content/pm/PackageInfo:lastUpdateTime	J
    //   1163: lstore 14
    //   1165: aload 7
    //   1167: ldc_w 908
    //   1170: aload_1
    //   1171: new 140	java/util/Date
    //   1174: dup
    //   1175: lload 12
    //   1177: invokespecial 547	java/util/Date:<init>	(J)V
    //   1180: invokevirtual 147	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1183: invokeinterface 229 3 0
    //   1188: pop
    //   1189: aload 7
    //   1191: ldc_w 910
    //   1194: aload_1
    //   1195: new 140	java/util/Date
    //   1198: dup
    //   1199: lload 14
    //   1201: invokespecial 547	java/util/Date:<init>	(J)V
    //   1204: invokevirtual 147	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1207: invokeinterface 229 3 0
    //   1212: pop
    //   1213: aload 7
    //   1215: ldc_w 912
    //   1218: aload_1
    //   1219: aload_0
    //   1220: invokestatic 914	jl:a	(Ljava/text/SimpleDateFormat;Landroid/content/Context;)Ljava/lang/String;
    //   1223: invokeinterface 229 3 0
    //   1228: pop
    //   1229: aload 4
    //   1231: invokevirtual 493	java/lang/String:length	()I
    //   1234: ifle +16 -> 1250
    //   1237: aload 7
    //   1239: ldc_w 916
    //   1242: aload 4
    //   1244: invokeinterface 229 3 0
    //   1249: pop
    //   1250: aload_0
    //   1251: ldc 113
    //   1253: iconst_0
    //   1254: invokevirtual 119	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1257: astore_1
    //   1258: aload_1
    //   1259: ldc_w 434
    //   1262: aconst_null
    //   1263: invokeinterface 126 3 0
    //   1268: astore_2
    //   1269: aload_2
    //   1270: ifnull +22 -> 1292
    //   1273: aload_2
    //   1274: invokevirtual 493	java/lang/String:length	()I
    //   1277: ifle +15 -> 1292
    //   1280: aload 7
    //   1282: ldc_w 918
    //   1285: aload_2
    //   1286: invokeinterface 229 3 0
    //   1291: pop
    //   1292: iload 16
    //   1294: ifeq +286 -> 1580
    //   1297: aload_0
    //   1298: instanceof 920
    //   1301: ifeq +279 -> 1580
    //   1304: aload_0
    //   1305: checkcast 920	android/app/Activity
    //   1308: invokevirtual 924	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1311: astore_2
    //   1312: aload_2
    //   1313: invokevirtual 927	android/content/Intent:getAction	()Ljava/lang/String;
    //   1316: ldc_w 929
    //   1319: if_acmpne +116 -> 1435
    //   1322: aload_2
    //   1323: invokevirtual 933	android/content/Intent:getData	()Landroid/net/Uri;
    //   1326: astore_2
    //   1327: aload_2
    //   1328: ldc_w 935
    //   1331: invokevirtual 938	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1334: ifnull +92 -> 1426
    //   1337: aload 7
    //   1339: ldc_w 940
    //   1342: ldc 223
    //   1344: invokeinterface 229 3 0
    //   1349: pop
    //   1350: aload_2
    //   1351: invokevirtual 943	android/net/Uri:getQuery	()Ljava/lang/String;
    //   1354: invokevirtual 944	java/lang/String:toString	()Ljava/lang/String;
    //   1357: aload_0
    //   1358: invokestatic 502	jl:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;
    //   1361: astore_2
    //   1362: new 946	org/json/JSONObject
    //   1365: dup
    //   1366: aload_2
    //   1367: invokespecial 948	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   1370: invokevirtual 949	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1373: astore_3
    //   1374: aload 7
    //   1376: ldc_w 951
    //   1379: aload_3
    //   1380: invokeinterface 229 3 0
    //   1385: pop
    //   1386: aload_1
    //   1387: invokeinterface 151 1 0
    //   1392: astore_1
    //   1393: aload_1
    //   1394: ldc_w 953
    //   1397: aload_3
    //   1398: invokeinterface 157 3 0
    //   1403: pop
    //   1404: aload_1
    //   1405: invokeinterface 160 1 0
    //   1410: pop
    //   1411: getstatic 45	jl:c	Ljk;
    //   1414: ifnull +12 -> 1426
    //   1417: getstatic 45	jl:c	Ljk;
    //   1420: aload_2
    //   1421: invokeinterface 955 2 0
    //   1426: getstatic 961	java/lang/System:out	Ljava/io/PrintStream;
    //   1429: ldc_w 963
    //   1432: invokevirtual 968	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1435: new 970	jp
    //   1438: dup
    //   1439: aload 8
    //   1441: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: aload 7
    //   1446: aload_0
    //   1447: invokevirtual 446	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1450: iload 16
    //   1452: aconst_null
    //   1453: invokespecial 973	jp:<init>	(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;ZLjl$1;)V
    //   1456: invokevirtual 976	jp:run	()V
    //   1459: return
    //   1460: astore_0
    //   1461: aload 6
    //   1463: aload_0
    //   1464: invokevirtual 378	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1467: aload_0
    //   1468: invokestatic 978	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1471: pop
    //   1472: return
    //   1473: ldc_w 980
    //   1476: invokestatic 65	jl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1479: astore_1
    //   1480: aload_1
    //   1481: ifnull -725 -> 756
    //   1484: aload 7
    //   1486: ldc_w 982
    //   1489: aload_1
    //   1490: invokestatic 822	jv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1493: invokeinterface 229 3 0
    //   1498: pop
    //   1499: goto -743 -> 756
    //   1502: astore_1
    //   1503: ldc 95
    //   1505: new 162	java/lang/StringBuilder
    //   1508: dup
    //   1509: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1512: ldc_w 984
    //   1515: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: ldc_w 984
    //   1521: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: ldc_w 986
    //   1527: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload_1
    //   1531: invokevirtual 989	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1534: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1543: pop
    //   1544: goto -575 -> 969
    //   1547: astore_1
    //   1548: ldc 95
    //   1550: new 162	java/lang/StringBuilder
    //   1553: dup
    //   1554: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   1557: ldc_w 991
    //   1560: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: aload_1
    //   1564: invokevirtual 989	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1567: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1573: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1576: pop
    //   1577: goto -536 -> 1041
    //   1580: iload 16
    //   1582: ifne -147 -> 1435
    //   1585: aload_1
    //   1586: ldc_w 953
    //   1589: aconst_null
    //   1590: invokeinterface 126 3 0
    //   1595: astore_1
    //   1596: aload_1
    //   1597: ifnull -162 -> 1435
    //   1600: aload 7
    //   1602: ldc_w 951
    //   1605: aload_1
    //   1606: invokeinterface 229 3 0
    //   1611: pop
    //   1612: goto -177 -> 1435
    //   1615: astore_1
    //   1616: goto -387 -> 1229
    //   1619: astore_1
    //   1620: goto -391 -> 1229
    //   1623: astore_2
    //   1624: goto -517 -> 1107
    //   1627: astore_1
    //   1628: goto -602 -> 1026
    //   1631: astore_1
    //   1632: goto -646 -> 986
    //   1635: astore 5
    //   1637: goto -1396 -> 241
    //   1640: iload 16
    //   1642: ifeq +42 -> 1684
    //   1645: ldc_w 714
    //   1648: astore 5
    //   1650: goto -1524 -> 126
    //   1653: aload 9
    //   1655: ifnonnull -1202 -> 453
    //   1658: aload 5
    //   1660: ifnull -1207 -> 453
    //   1663: goto -1223 -> 440
    //   1666: iconst_0
    //   1667: istore 16
    //   1669: goto -1662 -> 7
    //   1672: aload_2
    //   1673: astore 5
    //   1675: goto -1587 -> 88
    //   1678: aload_2
    //   1679: astore 5
    //   1681: goto -1567 -> 114
    //   1684: aload_2
    //   1685: astore 5
    //   1687: goto -1561 -> 126
    //
    // Exception table:
    //   from	to	target	type
    //   47	78	1460	java/lang/Throwable
    //   88	104	1460	java/lang/Throwable
    //   114	123	1460	java/lang/Throwable
    //   126	144	1460	java/lang/Throwable
    //   144	197	1460	java/lang/Throwable
    //   197	219	1460	java/lang/Throwable
    //   219	241	1460	java/lang/Throwable
    //   241	364	1460	java/lang/Throwable
    //   369	390	1460	java/lang/Throwable
    //   390	404	1460	java/lang/Throwable
    //   409	422	1460	java/lang/Throwable
    //   427	437	1460	java/lang/Throwable
    //   440	453	1460	java/lang/Throwable
    //   453	459	1460	java/lang/Throwable
    //   464	480	1460	java/lang/Throwable
    //   480	486	1460	java/lang/Throwable
    //   491	507	1460	java/lang/Throwable
    //   507	513	1460	java/lang/Throwable
    //   518	534	1460	java/lang/Throwable
    //   541	548	1460	java/lang/Throwable
    //   548	556	1460	java/lang/Throwable
    //   561	611	1460	java/lang/Throwable
    //   611	615	1460	java/lang/Throwable
    //   619	631	1460	java/lang/Throwable
    //   631	641	1460	java/lang/Throwable
    //   645	658	1460	java/lang/Throwable
    //   674	691	1460	java/lang/Throwable
    //   691	702	1460	java/lang/Throwable
    //   711	739	1460	java/lang/Throwable
    //   740	756	1460	java/lang/Throwable
    //   760	772	1460	java/lang/Throwable
    //   776	788	1460	java/lang/Throwable
    //   788	814	1460	java/lang/Throwable
    //   814	821	1460	java/lang/Throwable
    //   825	865	1460	java/lang/Throwable
    //   865	877	1460	java/lang/Throwable
    //   877	884	1460	java/lang/Throwable
    //   888	900	1460	java/lang/Throwable
    //   900	926	1460	java/lang/Throwable
    //   930	942	1460	java/lang/Throwable
    //   942	948	1460	java/lang/Throwable
    //   948	953	1460	java/lang/Throwable
    //   957	969	1460	java/lang/Throwable
    //   969	986	1460	java/lang/Throwable
    //   986	1026	1460	java/lang/Throwable
    //   1026	1041	1460	java/lang/Throwable
    //   1041	1063	1460	java/lang/Throwable
    //   1070	1107	1460	java/lang/Throwable
    //   1107	1229	1460	java/lang/Throwable
    //   1229	1250	1460	java/lang/Throwable
    //   1250	1269	1460	java/lang/Throwable
    //   1273	1292	1460	java/lang/Throwable
    //   1297	1426	1460	java/lang/Throwable
    //   1426	1435	1460	java/lang/Throwable
    //   1435	1459	1460	java/lang/Throwable
    //   1473	1480	1460	java/lang/Throwable
    //   1484	1499	1460	java/lang/Throwable
    //   1503	1544	1460	java/lang/Throwable
    //   1548	1577	1460	java/lang/Throwable
    //   1585	1596	1460	java/lang/Throwable
    //   1600	1612	1460	java/lang/Throwable
    //   948	953	1502	java/lang/Exception
    //   957	969	1502	java/lang/Exception
    //   1026	1041	1547	java/lang/Exception
    //   1107	1229	1615	java/lang/NoSuchFieldError
    //   1107	1229	1619	android/content/pm/PackageManager$NameNotFoundException
    //   1070	1107	1623	java/lang/Exception
    //   986	1026	1627	java/lang/Exception
    //   969	986	1631	java/lang/Exception
    //   144	197	1635	java/lang/Exception
    //   197	219	1635	java/lang/Exception
    //   219	241	1635	java/lang/Exception
  }

  public static void c(String paramString)
  {
    a("AppsFlyerKey", paramString);
  }

  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).flags;
      if ((i & 0x1) != 0)
        bool = true;
      return bool;
    }
    catch (NameNotFoundException paramContext)
    {
      Log.e("AppsFlyer_1.13", "Could not check if app is pre installed", paramContext);
    }
    return false;
  }

  public static String d(Context paramContext)
  {
    return jw.a(paramContext);
  }

  private static String d(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)paramMap.get(str2);
      if (str1 == null);
      for (str1 = ""; ; str1 = URLEncoder.encode(str1, "UTF-8"))
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append('&');
        localStringBuilder.append(str2).append('=').append(str1);
        break;
      }
    }
    return localStringBuilder.toString();
  }

  private static String e(String paramString)
  {
    String str;
    if (paramString.equals("c"))
      str = "campaign";
    do
    {
      return str;
      str = paramString;
    }
    while (!paramString.equals("pid"));
    return "media_source";
  }

  private static Map<String, String> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!b.contains(str))
          localHashMap.put(str, paramString.getString(str));
      }
    }
    catch (JSONException paramString)
    {
      Log.w("AppsFlyer_1.13", paramString);
      return null;
    }
    return localHashMap;
  }

  private static boolean g(Context paramContext)
  {
    return !jq.a().e();
  }

  private static boolean h(Context paramContext)
  {
    boolean bool = false;
    if (!paramContext.getSharedPreferences("appsflyer-data", 0).contains("appsFlyerCount"))
      bool = true;
    return bool;
  }

  private static String i(Context paramContext)
  {
    String str = null;
    Object localObject = paramContext.getSharedPreferences("appsflyer-data", 0);
    if (((SharedPreferences)localObject).contains("INSTALL_STORE"))
      return ((SharedPreferences)localObject).getString("INSTALL_STORE", null);
    boolean bool = h(paramContext);
    localObject = ((SharedPreferences)localObject).edit();
    if (bool)
      str = j(paramContext);
    ((Editor)localObject).putString("INSTALL_STORE", str);
    ((Editor)localObject).commit();
    return str;
  }

  private static String j(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).get("AF_STORE");
        if (localObject != null)
        {
          if ((localObject instanceof String))
            return (String)localObject;
          localObject = localObject.toString();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      if (g(paramContext))
        Log.i("AppsFlyer_1.13", "Could not find AF_STORE value in the manifest", localException);
    }
    return null;
  }

  private static String k(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = paramContext.getSharedPreferences("appsflyer-data", 0);
    if (((SharedPreferences)localObject1).contains("preInstallName"))
      return ((SharedPreferences)localObject1).getString("preInstallName", null);
    boolean bool = h(paramContext);
    Editor localEditor = ((SharedPreferences)localObject1).edit();
    localObject1 = localObject2;
    if (bool);
    try
    {
      localObject1 = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).get("AF_PRE_INSTALL_NAME");
        if (localObject1 != null)
        {
          if ((localObject1 instanceof String))
            localObject1 = (String)localObject1;
          for (paramContext = (Context)localObject1; ; paramContext = (Context)localObject1)
          {
            localObject1 = paramContext;
            localEditor.putString("preInstallName", (String)localObject1);
            localEditor.commit();
            return localObject1;
            localObject1 = localObject1.toString();
          }
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject1 = localObject2;
        if (g(paramContext))
        {
          Log.i("AppsFlyer_1.13", "Could not find AF_PRE_INSTALL_NAME value in the manifest", localException);
          localObject1 = localObject2;
          continue;
          paramContext = null;
        }
      }
    }
  }

  private static void l(Context paramContext)
  {
    if ((d) || (System.currentTimeMillis() - e < 15000L));
    while (f != null)
      return;
    f = Executors.newSingleThreadScheduledExecutor();
    f.schedule(new jn(paramContext), 1L, TimeUnit.SECONDS);
  }

  private static String m(Context paramContext)
  {
    String str = jq.a().b("channel");
    Object localObject = str;
    if (str == null)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        if (paramContext != null)
        {
          paramContext = paramContext.get("CHANNEL");
          if (paramContext != null)
            if ((paramContext instanceof String))
              paramContext = (String)paramContext;
            else
              paramContext = paramContext.toString();
        }
      }
      catch (Exception paramContext)
      {
        Log.i("AppsFlyer_1.13", "Could not load CHANNEL value", paramContext);
        return str;
      }
      paramContext = str;
      localObject = paramContext;
    }
    return localObject;
  }

  private static String n(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext.getNetworkInfo(1).isConnectedOrConnecting())
      return "WIFI";
    if (paramContext.getNetworkInfo(0).isConnectedOrConnecting())
      return "MOBILE";
    return "unkown";
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction()))
      a(paramIntent.getDataString(), paramContext);
    do
    {
      do
      {
        return;
        localObject = paramIntent.getStringExtra("shouldMonitor");
        if (localObject != null)
        {
          Log.i("AppsFlyer_1.13", "Turning on monitoring.");
          jq.a().a("shouldMonitor", ((String)localObject).equals("true"));
          b(paramContext, null, "START_TRACKING", paramContext.getPackageName());
          return;
        }
        Log.i("AppsFlyer_1.13", "****** onReceive called *******");
        a("******* onReceive: ", "", paramContext);
        jq.a().b();
        paramIntent = paramIntent.getStringExtra("referrer");
        if (g(paramContext))
          Log.i("AppsFlyer_1.13", "Play store referrer: " + paramIntent);
      }
      while (paramIntent == null);
      a("BroadcastReceiver got referrer: ", paramIntent, paramContext);
      a("onRecieve called. refferer=", paramIntent, paramContext);
      Object localObject = paramContext.getSharedPreferences("appsflyer-data", 0).edit();
      ((Editor)localObject).putString("referrer", paramIntent);
      ((Editor)localObject).commit();
      jq.a().c(paramIntent);
    }
    while (!jq.a().c());
    Log.i("AppsFlyer_1.13", "onReceive: isLaunchCalled");
    b(paramContext, null, null, null, paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jl
 * JD-Core Version:    0.6.2
 */