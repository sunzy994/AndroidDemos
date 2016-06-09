package cmcm.com.myapplication.com.lazyswipe.notification;

import alo;
import alu;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import arm;
import asp;
import asq;
import com.lazyswipe.SwipeService;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import vo;
import xj;

@TargetApi(18)
public final class SwipeNotificationListenerService extends NotificationListenerService
  implements Callback
{
  public static SwipeNotificationListenerService a;
  public static boolean b = false;
  private static Field c;
  private Handler d;

  @TargetApi(21)
  public static int a()
  {
    if (a == null)
      return -1;
    return a.getCurrentInterruptionFilter();
  }

  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (a == null)
      return;
    if (Build.VERSION.SDK_INT >= 21)
    {
      a.cancelNotification(paramString3);
      return;
    }
    a.cancelNotification(paramString1, paramString2, paramInt);
  }

  private static boolean a(Notification paramNotification)
  {
    boolean bool2 = false;
    paramNotification = b(paramNotification);
    boolean bool1 = bool2;
    if (paramNotification != null)
    {
      bool1 = bool2;
      if ("android.system.imeswitcher".equals(paramNotification[0]))
        bool1 = true;
    }
    return bool1;
  }

  public static boolean a(Context paramContext)
  {
    return asq.n(paramContext, SwipeNotificationListenerService.class.getName());
  }

  @TargetApi(20)
  private boolean a(StatusBarNotification paramStatusBarNotification, boolean paramBoolean)
  {
    String str = paramStatusBarNotification.getPackageName();
    Notification localNotification = paramStatusBarNotification.getNotification();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((arm.e(localNotification)) && (("com.google.android.gm".equals(str)) || ("com.skype.raider".equals(str)) || ("org.telegram.messenger".equals(str)) || ("com.textra".equals(str))))
        return false;
      paramStatusBarNotification.getGroupKey();
    }
    return alo.a(this, str, localNotification, paramStatusBarNotification, paramBoolean);
  }

  public static boolean b(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    if (TextUtils.isEmpty(paramContext));
    while (true)
    {
      return false;
      paramContext = paramContext.split(":");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(paramContext[i]);
        if ((localComponentName != null) && (localComponentName.getPackageName().equals("com.lazyswipe")))
          return true;
        i += 1;
      }
    }
  }

  private static String[] b(Notification paramNotification)
  {
    try
    {
      if (c == null)
      {
        c = paramNotification.getClass().getDeclaredField("kind");
        c.setAccessible(true);
      }
      paramNotification = (String[])c.get(paramNotification);
      return paramNotification;
    }
    catch (Exception paramNotification)
    {
    }
    return null;
  }

  public void a(Set<String> paramSet)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    int k = n;
    int j;
    if (alo.c.size() > 0)
      j = m;
    while (true)
    {
      try
      {
        StatusBarNotification[] arrayOfStatusBarNotification = getActiveNotifications();
        k = n;
        if (arrayOfStatusBarNotification != null)
        {
          j = m;
          k = n;
          if (arrayOfStatusBarNotification.length > 0)
          {
            j = m;
            n = arrayOfStatusBarNotification.length;
            m = 0;
            k = i;
            if (m < n)
            {
              StatusBarNotification localStatusBarNotification = arrayOfStatusBarNotification[m];
              j = i;
              String str = localStatusBarNotification.getPackageName();
              j = i;
              k = i;
              if (paramSet.contains(str))
                break label212;
              j = i;
              if ("com.lazyswipe".equals(str))
              {
                j = i;
                if (1 == localStatusBarNotification.getId())
                {
                  k = i;
                  break label212;
                }
              }
              j = i;
              k = i;
              if (!alo.c.contains(str))
                break label212;
              j = i;
              boolean bool = a(localStatusBarNotification, true);
              k = i | bool;
            }
          }
        }
      }
      catch (Exception paramSet)
      {
        asp.a("Swipe.Notification", "Failed to getActiveNotifications", paramSet);
        k = j;
      }
      if (k != 0)
        getContentResolver().notifyChange(xj.a, null);
      return;
      label212: m += 1;
      i = k;
    }
  }

  // ERROR //
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: getstatic 29	com/lazyswipe/notification/SwipeNotificationListenerService:b	Z
    //   8: ifeq +13 -> 21
    //   11: iconst_0
    //   12: putstatic 29	com/lazyswipe/notification/SwipeNotificationListenerService:b	Z
    //   15: iconst_1
    //   16: istore 4
    //   18: iload 4
    //   20: ireturn
    //   21: aload_1
    //   22: getfield 232	android/os/Message:obj	Ljava/lang/Object;
    //   25: instanceof 234
    //   28: ifeq -10 -> 18
    //   31: aload_1
    //   32: getfield 232	android/os/Message:obj	Ljava/lang/Object;
    //   35: checkcast 234	alu
    //   38: astore_3
    //   39: aload_3
    //   40: getfield 237	alu:b	Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: aload_0
    //   46: invokestatic 243	asl:g	(Landroid/content/Context;)Ljava/lang/String;
    //   49: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +151 -> 203
    //   55: ldc 245
    //   57: astore_1
    //   58: getstatic 249	alo:k	Ljava/util/Set;
    //   61: aload_1
    //   62: invokeinterface 252 2 0
    //   67: pop
    //   68: aload_0
    //   69: invokevirtual 209	com/lazyswipe/notification/SwipeNotificationListenerService:getContentResolver	()Landroid/content/ContentResolver;
    //   72: getstatic 214	xj:a	Landroid/net/Uri;
    //   75: iconst_1
    //   76: anewarray 63	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc 254
    //   83: aastore
    //   84: ldc_w 256
    //   87: iconst_1
    //   88: anewarray 63	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: aastore
    //   95: aconst_null
    //   96: invokevirtual 260	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore_1
    //   100: aload_1
    //   101: invokeinterface 266 1 0
    //   106: ifeq +57 -> 163
    //   109: aload_1
    //   110: iconst_0
    //   111: invokeinterface 269 2 0
    //   116: astore_2
    //   117: aload_2
    //   118: ldc2_w 270
    //   121: invokestatic 276	asi:a	(Ljava/lang/String;J)J
    //   124: lconst_0
    //   125: lcmp
    //   126: ifle -26 -> 100
    //   129: getstatic 249	alo:k	Ljava/util/Set;
    //   132: aload_2
    //   133: invokeinterface 252 2 0
    //   138: pop
    //   139: goto -39 -> 100
    //   142: astore_2
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload_1
    //   148: invokeinterface 279 1 0
    //   153: aload_0
    //   154: aload_3
    //   155: ldc2_w 270
    //   158: invokestatic 282	alo:a	(Landroid/content/Context;Lalu;J)V
    //   161: iconst_1
    //   162: ireturn
    //   163: aload_1
    //   164: ifnull -11 -> 153
    //   167: aload_1
    //   168: invokeinterface 279 1 0
    //   173: goto -20 -> 153
    //   176: astore_3
    //   177: aload_2
    //   178: astore_1
    //   179: aload_3
    //   180: astore_2
    //   181: aload_1
    //   182: ifnull +9 -> 191
    //   185: aload_1
    //   186: invokeinterface 279 1 0
    //   191: aload_2
    //   192: athrow
    //   193: astore_2
    //   194: goto -13 -> 181
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -57 -> 143
    //   203: goto -145 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   100	139	142	java/lang/Throwable
    //   68	100	176	finally
    //   100	139	193	finally
    //   68	100	197	java/lang/Throwable
  }

  public IBinder onBind(Intent paramIntent)
  {
    a = this;
    alo.a(this);
    if (Build.VERSION.SDK_INT < 21)
      new Handler().post(new Runnable()
      {
        public void run()
        {
          SwipeNotificationListenerService.this.a(Collections.emptySet());
        }
      });
    return super.onBind(paramIntent);
  }

  public void onCreate()
  {
    super.onCreate();
    SwipeService.a(this);
    arm.a(this);
    this.d = new Handler(this);
  }

  public void onInterruptionFilterChanged(int paramInt)
  {
  }

  public void onListenerConnected()
  {
    a(Collections.emptySet());
  }

  @TargetApi(20)
  public void onNotificationPosted(StatusBarNotification paramStatusBarNotification)
  {
    Object localObject2 = null;
    if (!SwipeService.b());
    String str;
    label54: label85: 
    do
    {
      return;
      str = paramStatusBarNotification.getPackageName();
      if ((alo.a) && ("android".equals(str)) && (a(paramStatusBarNotification.getNotification())))
      {
        boolean bool = asq.n();
        if (!bool)
          break label150;
        localObject1 = null;
        if (!alo.m)
        {
          alo.m = true;
          localObject3 = SwipeService.i();
          if (localObject3 != null)
          {
            if (!bool)
              break label157;
            ((SwipeService)localObject3).d(false);
          }
        }
        asp.a("Swipe.Notification", "IME showed up");
        localObject3 = SwipeService.i();
        if (localObject3 != null)
        {
          if (!bool)
            break label179;
          ((vo)localObject3).a(true, 0);
        }
      }
      while (true)
      {
        if (!"com.lazyswipe".equals(str))
          break label201;
        if (paramStatusBarNotification.getId() != 1)
          break;
        try
        {
          SwipeService.a().sendEmptyMessageDelayed(9, 1500L);
          return;
        }
        catch (Throwable paramStatusBarNotification)
        {
          return;
        }
        localObject1 = SwipeService.a();
        break label54;
        if (localObject1 == null)
          break label85;
        ((Handler)localObject1).post(new Runnable()
        {
          public void run()
          {
            this.a.d(false);
          }
        });
        break label85;
        if (localObject1 != null)
          ((Handler)localObject1).post(new Runnable()
          {
            public void run()
            {
              this.a.a(true, 0);
            }
          });
      }
    }
    while (!alo.a(this, str));
    label150: label157: label179: label201: int i = paramStatusBarNotification.getId();
    Object localObject3 = paramStatusBarNotification.getTag();
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 20)
      localObject1 = paramStatusBarNotification.getKey();
    localObject1 = new alu(i, (String)localObject3, (String)localObject1, str);
    this.d.removeMessages(((alu)localObject1).hashCode());
    a(paramStatusBarNotification, false);
  }

  @TargetApi(20)
  public void onNotificationRemoved(final StatusBarNotification paramStatusBarNotification)
  {
    Object localObject = paramStatusBarNotification.getPackageName();
    if ((!"com.lazyswipe".equals(localObject)) || (paramStatusBarNotification.getId() == 1));
    try
    {
      SwipeService.a().removeMessages(9);
      do
      {
        do
        {
          do
          {
            return;
            if ((!alo.a) || (!"android".equals(localObject)) || (!a(paramStatusBarNotification.getNotification())))
              break;
            asp.a("Swipe.Notification", "IME dismissed");
            paramStatusBarNotification = SwipeService.i();
          }
          while (paramStatusBarNotification == null);
          if (asq.n())
          {
            paramStatusBarNotification.a(false, 0);
            return;
          }
          localObject = SwipeService.a();
        }
        while (localObject == null);
        ((Handler)localObject).post(new Runnable()
        {
          public void run()
          {
            paramStatusBarNotification.a(false, 0);
          }
        });
        return;
      }
      while (!alo.a(this, (String)localObject));
      if (0L == paramStatusBarNotification.getNotification().when)
      {
        asp.a("Swipe.Notification", "Not removing notification as timestamp is zero: " + paramStatusBarNotification);
        return;
      }
      if ((TextUtils.isEmpty(paramStatusBarNotification.getNotification().tickerText)) && (alo.b((String)localObject)))
      {
        asp.a("Swipe.Notification", "Not removing notification as ticker text is empty: " + paramStatusBarNotification);
        return;
      }
      int i = paramStatusBarNotification.getId();
      String str = paramStatusBarNotification.getTag();
      if (Build.VERSION.SDK_INT >= 20);
      for (paramStatusBarNotification = paramStatusBarNotification.getKey(); ; paramStatusBarNotification = null)
      {
        paramStatusBarNotification = new alu(i, str, paramStatusBarNotification, (String)localObject);
        this.d.sendMessageDelayed(Message.obtain(this.d, paramStatusBarNotification.hashCode(), paramStatusBarNotification), 100L);
        return;
      }
    }
    catch (Throwable paramStatusBarNotification)
    {
    }
  }

  @TargetApi(21)
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i;
    if ((paramIntent != null) && ("com.lazyswipe.action_REQUEST_INTERRUPTION_FILTER".equals(paramIntent.getAction())))
    {
      i = paramIntent.getIntExtra("extra.FILTER", -1);
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      try
      {
        requestInterruptionFilter(i);
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public boolean onUnbind(Intent paramIntent)
  {
    a = null;
    alo.b(this);
    return super.onUnbind(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.notification.SwipeNotificationListenerService
 * JD-Core Version:    0.6.2
 */