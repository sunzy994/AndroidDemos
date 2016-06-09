package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build.VERSION;
import com.lazyswipe.notification.SwipeAccessibilityService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class vz
{
  public static void a()
  {
    vv.a().a("24小时未划通知");
  }

  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("值", String.valueOf(paramInt));
    vv.a().a("HolaLauncher点击", localHashMap);
  }

  public static void a(Context paramContext)
  {
    int k = 2;
    int j = 1;
    vy.a(paramContext, vs.d(paramContext));
    boolean bool = alo.d(paramContext);
    int i;
    label66: label82: label102: label119: final vv localvv;
    if (Build.VERSION.SDK_INT >= 18)
      if (bool)
      {
        str = "1";
        str = String.valueOf(str);
        vy.a(paramContext, "CE", str);
        if (abd.a())
        {
          if (!vs.c(paramContext, "key_charging_lockscreen", true))
            break label358;
          i = 1;
          vy.b(paramContext, "B42", i);
        }
        if (!acw.a(paramContext))
          break label363;
        i = 2;
        vy.b(paramContext, "B30", i);
        if (!vs.c(paramContext, "key_memory_tip_enable", true))
          break label368;
        str = "1";
        vy.a(paramContext, "CI", str);
        if (!acw.a(paramContext))
          break label374;
        i = k;
        vy.b(paramContext, "CU", i);
        localvv = vv.a();
        localvv.a("Toucher位置日计", "值", String.valueOf(vs.A(paramContext)));
        if (Build.VERSION.SDK_INT >= 18)
        {
          if (!SwipeAccessibilityService.a(paramContext))
            break label379;
          str = "ON";
          label163: localvv.a("操作校正日计", "值", str);
        }
        localvv.a("主题日计", "值", String.valueOf(ahx.a(paramContext)));
        if (!asq.c(paramContext, "com.hola.launcher"))
          break label385;
        i = 1;
        label198: localvv.a("Hola安装日计", "值", String.valueOf(i));
        if (!vs.o(paramContext))
          break label390;
        i = 1;
        label219: vy.a(paramContext, "CS", String.valueOf(i));
        if (!SwipeAccessibilityService.a(paramContext))
          break label395;
        i = j;
        label239: vy.b(paramContext, "D3", i);
        if (!acw.b(paramContext))
          break label400;
      }
    label385: label390: label395: label400: for (String str = "ON"; ; str = "OFF")
    {
      localvv.a("悬浮窗日计", "值", str);
      localvv.a("通知提示方式日计", "value", vs.b(paramContext));
      ass.b(paramContext);
      i = abf.c(paramContext);
      if (i > 100)
        localvv.a("拉霸金币", "value", i);
      if (vs.c(paramContext, "pref_lucky_leap_never_show", false))
        vy.b(paramContext, "B55");
      arj.a(new Runnable()
      {
        // ERROR //
        public void run()
        {
          // Byte code:
          //   0: invokestatic 30	vz:b	()I
          //   3: invokestatic 36	java/lang/String:valueOf	(I)Ljava/lang/String;
          //   6: astore_2
          //   7: aload_0
          //   8: getfield 18	vz$1:a	Landroid/content/Context;
          //   11: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   14: astore_1
          //   15: getstatic 47	xk:a	Landroid/net/Uri;
          //   18: astore_3
          //   19: new 49	java/lang/StringBuilder
          //   22: dup
          //   23: invokespecial 50	java/lang/StringBuilder:<init>	()V
          //   26: ldc 52
          //   28: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   31: aload_2
          //   32: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   35: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   38: astore 4
          //   40: aload_1
          //   41: aload_3
          //   42: iconst_1
          //   43: anewarray 32	java/lang/String
          //   46: dup
          //   47: iconst_0
          //   48: ldc 62
          //   50: aastore
          //   51: aload 4
          //   53: aconst_null
          //   54: aconst_null
          //   55: invokevirtual 68	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
          //   58: astore_1
          //   59: aload_1
          //   60: invokeinterface 74 1 0
          //   65: ifeq +174 -> 239
          //   68: aload_1
          //   69: iconst_0
          //   70: invokeinterface 78 2 0
          //   75: istore 5
          //   77: aload_0
          //   78: getfield 20	vz$1:b	Lvv;
          //   81: ldc 80
          //   83: ldc 82
          //   85: iload 5
          //   87: invokestatic 36	java/lang/String:valueOf	(I)Ljava/lang/String;
          //   90: invokevirtual 87	vv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   93: goto -34 -> 59
          //   96: astore_3
          //   97: aload_1
          //   98: astore_2
          //   99: aload_3
          //   100: astore_1
          //   101: aload_2
          //   102: ifnull +9 -> 111
          //   105: aload_2
          //   106: invokeinterface 90 1 0
          //   111: aload_1
          //   112: athrow
          //   113: astore_1
          //   114: ldc 92
          //   116: ldc 94
          //   118: aload_1
          //   119: invokestatic 100	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   122: pop
          //   123: new 102	aal
          //   126: dup
          //   127: invokespecial 103	aal:<init>	()V
          //   130: astore_1
          //   131: aload_1
          //   132: aload_0
          //   133: getfield 18	vz$1:a	Landroid/content/Context;
          //   136: invokevirtual 107	android/content/Context:getApplicationContext	()Landroid/content/Context;
          //   139: checkcast 109	com/lazyswipe/SwipeApplication
          //   142: invokevirtual 112	aal:a	(Lcom/lazyswipe/SwipeApplication;)V
          //   145: aload_1
          //   146: aload_0
          //   147: getfield 18	vz$1:a	Landroid/content/Context;
          //   150: invokevirtual 116	aal:c	(Landroid/content/Context;)Ljava/util/List;
          //   153: astore_2
          //   154: new 118	android/content/ComponentName
          //   157: dup
          //   158: aload_0
          //   159: getfield 18	vz$1:a	Landroid/content/Context;
          //   162: ldc 120
          //   164: invokespecial 123	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
          //   167: astore_1
          //   168: aload_2
          //   169: invokeinterface 129 1 0
          //   174: astore_2
          //   175: aload_2
          //   176: invokeinterface 134 1 0
          //   181: ifeq +123 -> 304
          //   184: aload_2
          //   185: invokeinterface 138 1 0
          //   190: checkcast 140	yw
          //   193: astore_3
          //   194: aload_1
          //   195: aload_3
          //   196: invokevirtual 143	yw:e	()Lwk;
          //   199: getfield 149	wk:i	Landroid/content/ComponentName;
          //   202: invokevirtual 153	android/content/ComponentName:equals	(Ljava/lang/Object;)Z
          //   205: istore 6
          //   207: iload 6
          //   209: ifeq -34 -> 175
          //   212: iconst_1
          //   213: istore 5
          //   215: aload_0
          //   216: getfield 20	vz$1:b	Lvv;
          //   219: astore_1
          //   220: iload 5
          //   222: ifeq +64 -> 286
          //   225: iconst_1
          //   226: istore 5
          //   228: aload_1
          //   229: ldc 155
          //   231: ldc 157
          //   233: iload 5
          //   235: invokevirtual 160	vv:a	(Ljava/lang/String;Ljava/lang/String;I)V
          //   238: return
          //   239: aload_1
          //   240: ifnull +9 -> 249
          //   243: aload_1
          //   244: invokeinterface 90 1 0
          //   249: aload_0
          //   250: getfield 18	vz$1:a	Landroid/content/Context;
          //   253: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   256: getstatic 47	xk:a	Landroid/net/Uri;
          //   259: new 49	java/lang/StringBuilder
          //   262: dup
          //   263: invokespecial 50	java/lang/StringBuilder:<init>	()V
          //   266: ldc 162
          //   268: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   271: aload_2
          //   272: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   275: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   278: aconst_null
          //   279: invokevirtual 166	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
          //   282: pop
          //   283: goto -160 -> 123
          //   286: iconst_0
          //   287: istore 5
          //   289: goto -61 -> 228
          //   292: astore_1
          //   293: return
          //   294: astore_3
          //   295: goto -120 -> 175
          //   298: astore_1
          //   299: aconst_null
          //   300: astore_2
          //   301: goto -200 -> 101
          //   304: iconst_0
          //   305: istore 5
          //   307: goto -92 -> 215
          //
          // Exception table:
          //   from	to	target	type
          //   59	93	96	finally
          //   0	7	113	java/lang/Throwable
          //   105	111	113	java/lang/Throwable
          //   111	113	113	java/lang/Throwable
          //   243	249	113	java/lang/Throwable
          //   249	283	113	java/lang/Throwable
          //   123	175	292	java/lang/Throwable
          //   175	194	292	java/lang/Throwable
          //   215	220	292	java/lang/Throwable
          //   228	238	292	java/lang/Throwable
          //   194	207	294	java/lang/Throwable
          //   7	59	298	finally
        }
      });
      return;
      str = "2";
      break;
      if (bool);
      for (str = "3"; ; str = "4")
      {
        str = String.valueOf(str);
        break;
      }
      label358: i = 0;
      break label66;
      label363: i = 1;
      break label82;
      label368: str = "0";
      break label102;
      label374: i = 1;
      break label119;
      label379: str = "OFF";
      break label163;
      i = 0;
      break label198;
      i = 0;
      break label219;
      i = 0;
      break label239;
    }
  }

  private static int c()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -1);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    return localCalendar.get(5) + (i * 10000 + j * 100);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vz
 * JD-Core Version:    0.6.2
 */