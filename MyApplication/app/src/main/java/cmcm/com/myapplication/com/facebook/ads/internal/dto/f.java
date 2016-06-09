package cmcm.com.myapplication.com.facebook.ads.internal.dto;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public class f
{
  public static final String a = VERSION.RELEASE;
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static String f = "";
  public static int g = 0;
  public static String h = "";
  public static String i = "";
  public static int j = 0;
  public static String k = "";
  public static int l = 0;
  public static String m = "";
  public static String n = "";
  public static String o = "";
  public static boolean p = false;
  public static String q = "";
  private static boolean r = false;

  public static void a(Context paramContext)
  {
    try
    {
      if (!r)
      {
        r = true;
        c(paramContext);
      }
      d(paramContext);
      return;
    }
    finally
    {
    }
    throw paramContext;
  }

  // ERROR //
  public static void b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 29	com/facebook/ads/internal/dto/f:r	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: ldc 80
    //   10: iconst_0
    //   11: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 88
    //   18: invokeinterface 94 2 0
    //   23: ifeq +16 -> 39
    //   26: aload_2
    //   27: ldc 88
    //   29: ldc 38
    //   31: invokeinterface 98 3 0
    //   36: putstatic 64	com/facebook/ads/internal/dto/f:n	Ljava/lang/String;
    //   39: aload_2
    //   40: ldc 100
    //   42: invokeinterface 94 2 0
    //   47: ifeq +39 -> 86
    //   50: aload_2
    //   51: ldc 100
    //   53: ldc 38
    //   55: invokeinterface 98 3 0
    //   60: putstatic 66	com/facebook/ads/internal/dto/f:o	Ljava/lang/String;
    //   63: aload_2
    //   64: ldc 102
    //   66: getstatic 68	com/facebook/ads/internal/dto/f:p	Z
    //   69: invokeinterface 106 3 0
    //   74: putstatic 68	com/facebook/ads/internal/dto/f:p	Z
    //   77: getstatic 111	com/facebook/ads/internal/f$c:a	Lcom/facebook/ads/internal/f$c;
    //   80: invokevirtual 115	com/facebook/ads/internal/f$c:name	()Ljava/lang/String;
    //   83: putstatic 70	com/facebook/ads/internal/dto/f:q	Ljava/lang/String;
    //   86: aload_0
    //   87: invokevirtual 119	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   90: invokestatic 124	com/facebook/ads/internal/util/g:a	(Landroid/content/ContentResolver;)Lcom/facebook/ads/internal/util/g$a;
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +16 -> 111
    //   98: aload_1
    //   99: getfield 127	com/facebook/ads/internal/util/g$a:a	Ljava/lang/String;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: putstatic 64	com/facebook/ads/internal/dto/f:n	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_1
    //   113: invokestatic 132	com/facebook/ads/internal/f:a	(Landroid/content/Context;Lcom/facebook/ads/internal/util/g$a;)Lcom/facebook/ads/internal/f;
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +43 -> 161
    //   121: aload_0
    //   122: invokevirtual 134	com/facebook/ads/internal/f:a	()Ljava/lang/String;
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 137	com/facebook/ads/internal/f:b	()Z
    //   130: istore 4
    //   132: aload_1
    //   133: ifnull +28 -> 161
    //   136: aload_1
    //   137: putstatic 66	com/facebook/ads/internal/dto/f:o	Ljava/lang/String;
    //   140: iload 4
    //   142: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   145: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   148: putstatic 68	com/facebook/ads/internal/dto/f:p	Z
    //   151: aload_0
    //   152: invokevirtual 149	com/facebook/ads/internal/f:c	()Lcom/facebook/ads/internal/f$c;
    //   155: invokevirtual 115	com/facebook/ads/internal/f$c:name	()Ljava/lang/String;
    //   158: putstatic 70	com/facebook/ads/internal/dto/f:q	Ljava/lang/String;
    //   161: aload_2
    //   162: invokeinterface 153 1 0
    //   167: astore_0
    //   168: aload_0
    //   169: ldc 88
    //   171: getstatic 64	com/facebook/ads/internal/dto/f:n	Ljava/lang/String;
    //   174: invokeinterface 159 3 0
    //   179: pop
    //   180: aload_0
    //   181: ldc 100
    //   183: getstatic 66	com/facebook/ads/internal/dto/f:o	Ljava/lang/String;
    //   186: invokeinterface 159 3 0
    //   191: pop
    //   192: aload_0
    //   193: ldc 102
    //   195: getstatic 68	com/facebook/ads/internal/dto/f:p	Z
    //   198: invokeinterface 163 3 0
    //   203: pop
    //   204: aload_0
    //   205: invokeinterface 166 1 0
    //   210: return
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   216: return
    //   217: astore_1
    //   218: aload_1
    //   219: ldc 171
    //   221: invokestatic 176	com/facebook/ads/internal/util/b:a	(Ljava/lang/Throwable;Ljava/lang/String;)Lcom/facebook/ads/internal/util/b;
    //   224: invokestatic 181	com/facebook/ads/internal/util/c:a	(Lcom/facebook/ads/internal/util/b;)V
    //   227: aconst_null
    //   228: astore_1
    //   229: goto -135 -> 94
    //   232: astore_0
    //   233: aload_0
    //   234: ldc 183
    //   236: invokestatic 176	com/facebook/ads/internal/util/b:a	(Ljava/lang/Throwable;Ljava/lang/String;)Lcom/facebook/ads/internal/util/b;
    //   239: invokestatic 181	com/facebook/ads/internal/util/c:a	(Lcom/facebook/ads/internal/util/b;)V
    //   242: aconst_null
    //   243: astore_0
    //   244: goto -127 -> 117
    //
    // Exception table:
    //   from	to	target	type
    //   7	39	211	java/lang/Exception
    //   39	86	211	java/lang/Exception
    //   98	103	211	java/lang/Exception
    //   107	111	211	java/lang/Exception
    //   121	132	211	java/lang/Exception
    //   136	161	211	java/lang/Exception
    //   161	210	211	java/lang/Exception
    //   218	227	211	java/lang/Exception
    //   233	242	211	java/lang/Exception
    //   86	94	217	java/lang/Exception
    //   111	117	232	java/lang/Exception
  }

  private static void c(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    try
    {
      Object localObject2 = ((PackageManager)localObject1).getPackageInfo(paramContext.getPackageName(), 0);
      d = ((PackageInfo)localObject2).packageName;
      f = ((PackageInfo)localObject2).versionName;
      g = ((PackageInfo)localObject2).versionCode;
      try
      {
        label36: if ((d != null) && (d.length() >= 0))
        {
          localObject2 = ((PackageManager)localObject1).getInstallerPackageName(d);
          if ((localObject2 != null) && (((String)localObject2).length() > 0))
            h = (String)localObject2;
        }
        try
        {
          label74: localObject1 = ((PackageManager)localObject1).getApplicationLabel(((PackageManager)localObject1).getApplicationInfo(paramContext.getPackageName(), 0));
          if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
            e = ((CharSequence)localObject1).toString();
          label110: paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            paramContext = paramContext.getNetworkOperatorName();
            if ((paramContext != null) && (paramContext.length() > 0))
              i = paramContext;
          }
          paramContext = Build.MANUFACTURER;
          if ((paramContext != null) && (paramContext.length() > 0))
            b = paramContext;
          paramContext = Build.MODEL;
          if ((paramContext != null) && (paramContext.length() > 0))
            c = Build.MODEL;
          return;
        }
        catch (NameNotFoundException localNameNotFoundException1)
        {
          break label110;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    catch (NameNotFoundException localNameNotFoundException2)
    {
      break label36;
    }
  }

  private static void d(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
      {
        j = paramContext.getType();
        k = paramContext.getTypeName();
        l = paramContext.getSubtype();
        m = paramContext.getSubtypeName();
      }
      return;
    }
    catch (Exception paramContext)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.dto.f
 * JD-Core Version:    0.6.2
 */