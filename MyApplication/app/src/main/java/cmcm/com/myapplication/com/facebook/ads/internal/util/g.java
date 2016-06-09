package cmcm.com.myapplication.com.facebook.ads.internal.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.thirdparty.http.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  private static final String b = g.class.getSimpleName();
  private static boolean c = false;

  public static e a(AdSize paramAdSize)
  {
    switch (2.a[paramAdSize.ordinal()])
    {
    default:
      return e.b;
    case 1:
      return e.f;
    case 2:
      return e.e;
    case 3:
      return e.d;
    case 4:
    }
    return e.c;
  }

  // ERROR //
  public static g.a a(android.content.ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 26	com/facebook/ads/internal/util/g:a	Landroid/net/Uri;
    //   4: iconst_3
    //   5: anewarray 71	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc 73
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 75
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 77
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 83	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +14 -> 45
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokeinterface 89 1 0
    //   42: ifne +32 -> 74
    //   45: aload_1
    //   46: astore_0
    //   47: new 91	com/facebook/ads/internal/util/g$a
    //   50: dup
    //   51: aconst_null
    //   52: aconst_null
    //   53: iconst_0
    //   54: invokespecial 94	com/facebook/ads/internal/util/g$a:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_1
    //   65: invokeinterface 97 1 0
    //   70: aload_2
    //   71: astore_0
    //   72: aload_0
    //   73: areturn
    //   74: aload_1
    //   75: astore_0
    //   76: new 91	com/facebook/ads/internal/util/g$a
    //   79: dup
    //   80: aload_1
    //   81: aload_1
    //   82: ldc 73
    //   84: invokeinterface 101 2 0
    //   89: invokeinterface 105 2 0
    //   94: aload_1
    //   95: aload_1
    //   96: ldc 75
    //   98: invokeinterface 101 2 0
    //   103: invokeinterface 105 2 0
    //   108: aload_1
    //   109: aload_1
    //   110: ldc 77
    //   112: invokeinterface 101 2 0
    //   117: invokeinterface 105 2 0
    //   122: invokestatic 111	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   125: invokevirtual 114	java/lang/Boolean:booleanValue	()Z
    //   128: invokespecial 94	com/facebook/ads/internal/util/g$a:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull -63 -> 72
    //   138: aload_1
    //   139: invokeinterface 97 1 0
    //   144: aload_2
    //   145: areturn
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: astore_0
    //   151: new 91	com/facebook/ads/internal/util/g$a
    //   154: dup
    //   155: aconst_null
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokespecial 94	com/facebook/ads/internal/util/g$a:<init>	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   161: astore_2
    //   162: aload_2
    //   163: astore_0
    //   164: aload_1
    //   165: ifnull -93 -> 72
    //   168: aload_1
    //   169: invokeinterface 97 1 0
    //   174: aload_2
    //   175: areturn
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_0
    //   179: aload_0
    //   180: ifnull +9 -> 189
    //   183: aload_0
    //   184: invokeinterface 97 1 0
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: goto -13 -> 179
    //   195: astore_0
    //   196: goto -47 -> 149
    //
    // Exception table:
    //   from	to	target	type
    //   0	30	146	java/lang/Exception
    //   0	30	176	finally
    //   36	45	191	finally
    //   47	58	191	finally
    //   76	132	191	finally
    //   151	162	191	finally
    //   36	45	195	java/lang/Exception
    //   47	58	195	java/lang/Exception
    //   76	132	195	java/lang/Exception
  }

  public static Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
    }
    return null;
  }

  public static String a(InputStream paramInputStream)
  {
    StringWriter localStringWriter = new StringWriter();
    paramInputStream = new InputStreamReader(paramInputStream);
    Object localObject = new char[4096];
    while (true)
    {
      int i = paramInputStream.read((char[])localObject);
      if (i == -1)
        break;
      localStringWriter.write((char[])localObject, 0, i);
    }
    localObject = localStringWriter.toString();
    localStringWriter.close();
    paramInputStream.close();
    return localObject;
  }

  public static String a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      String str = a(localGZIPInputStream);
      localGZIPInputStream.close();
      paramArrayOfByte.close();
      return str;
    }
    catch (Exception paramArrayOfByte)
    {
      c.a(b.a(paramArrayOfByte, "Error decompressing data"));
      paramArrayOfByte.printStackTrace();
    }
    return "";
  }

  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
    }
    return null;
  }

  public static Method a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
    }
    return null;
  }

  public static void a(Context paramContext, Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addCategory("android.intent.category.BROWSABLE");
    paramUri.addFlags(268435456);
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramUri.putExtra("create_new_tab", false);
    paramContext.startActivity(paramUri);
  }

  public static void a(Context paramContext, String paramString)
  {
    if (AdSettings.isTestMode(paramContext))
      Log.d("FBAudienceNetworkLog", paramString + " (displayed for test ads only)");
  }

  public static void a(DisplayMetrics paramDisplayMetrics, View paramView, AdSize paramAdSize)
  {
    if ((int)(paramDisplayMetrics.widthPixels / paramDisplayMetrics.density) >= paramAdSize.getWidth());
    for (int i = paramDisplayMetrics.widthPixels; ; i = (int)Math.ceil(paramAdSize.getWidth() * paramDisplayMetrics.density))
    {
      paramDisplayMetrics = new RelativeLayout.LayoutParams(i, (int)Math.ceil(paramAdSize.getHeight() * paramDisplayMetrics.density));
      paramDisplayMetrics.addRule(14, -1);
      paramView.setLayoutParams(paramDisplayMetrics);
      return;
    }
  }

  public static void a(View paramView, boolean paramBoolean, String paramString)
  {
  }

  public static boolean a()
  {
    String str = AdSettings.getUrlPrefix();
    return (!r.a(str)) && (str.endsWith(".sb"));
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      if (!((PowerManager)paramContext.getSystemService("power")).isScreenOn())
        return false;
      boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (bool)
        return false;
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return true;
  }

  public static boolean a(Context paramContext, View paramView, int paramInt)
  {
    if (paramView == null)
    {
      a(paramView, false, "adView is null.");
      return false;
    }
    if (paramView.getParent() == null)
    {
      a(paramView, false, "adView has no parent.");
      return false;
    }
    if (paramView.getVisibility() != 0)
    {
      a(paramView, false, "adView is not set to VISIBLE.");
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (paramView.getAlpha() < 0.9F))
    {
      a(paramView, false, "adView is too transparent.");
      return false;
    }
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics;
    try
    {
      paramView.getLocationOnScreen(arrayOfInt);
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if ((arrayOfInt[0] < 0) || (localDisplayMetrics.widthPixels - arrayOfInt[0] < j))
      {
        a(paramView, false, "adView is not fully on screen horizontally.");
        return false;
      }
    }
    catch (NullPointerException paramContext)
    {
      a(paramView, false, "Cannot get location on screen.");
      return false;
    }
    paramInt = (int)(i * (100.0D - paramInt) / 100.0D);
    if ((arrayOfInt[1] < 0) && (Math.abs(arrayOfInt[1]) > paramInt))
    {
      a(paramView, false, "adView is not visible from the top.");
      return false;
    }
    if (i + arrayOfInt[1] - localDisplayMetrics.heightPixels > paramInt)
    {
      a(paramView, false, "adView is not visible from the bottom.");
      return false;
    }
    a(paramView, true, "adView is visible.");
    return a(paramContext);
  }

  public static byte[] a(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      paramString = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramString;
    }
    catch (Exception paramString)
    {
      c.a(b.a(paramString, "Error compressing data"));
      paramString.printStackTrace();
    }
    return new byte[0];
  }

  public static void b()
  {
    if (!c)
      try
      {
        X509TrustManager local1 = new X509TrustManager()
        {
          public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          {
          }

          public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          {
          }

          public X509Certificate[] getAcceptedIssuers()
          {
            return null;
          }
        };
        SSLContext localSSLContext = SSLContext.getInstance("SSL");
        SecureRandom localSecureRandom = new SecureRandom();
        localSSLContext.init(null, new TrustManager[] { local1 }, localSecureRandom);
        HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
        Log.d(b, "Sandbox SSL validation disabled.");
        return;
      }
      catch (Exception localException)
      {
        Log.e(b, "Failed to disable sandbox SSL validation: " + localException);
        return;
      }
    Log.d(b, "Sandbox SSL validation already disabled, ignoring...");
  }

  public static a c()
  {
    a locala = new a();
    locala.c(30000);
    locala.b(3);
    if (a())
      b();
    return locala;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.g
 * JD-Core Version:    0.6.2
 */