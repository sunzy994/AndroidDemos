package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.notification.NotificationData.Action;
import com.lazyswipe.notification.NotificationDataExtended;
import com.lazyswipe.notification.SwipeAccessibilityService;
import com.lazyswipe.notification.SwipeNotificationListenerService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class alo
{
  public static final boolean a = false;
  static final Object b = new Object();
  public static final HashSet<String> c = new HashSet(0);
  static final Handler d = new Handler(Looper.getMainLooper(), new Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = (xu)((WeakReference)paramAnonymousMessage.obj).get();
      if (paramAnonymousMessage != null)
      {
        yw.g = true;
        paramAnonymousMessage.m();
        paramAnonymousMessage.a(true);
        if (paramAnonymousMessage.f())
          paramAnonymousMessage.i();
        paramAnonymousMessage.n();
        yw.g = false;
      }
      return true;
    }
  });
  static final HashMap<String, Integer> e = new LinkedHashMap(0);
  public static boolean f;
  static final cu<PendingIntent> g = new cu(0);
  static final cu<NotificationData.Action> h = new cu(0);
  static final cu<NotificationData.Action[]> i = new cu(0);
  static final HashMap<String, CharSequence> j = new HashMap(0);
  public static final Set<String> k = new HashSet(5);
  static String l;
  public static boolean m;
  static WeakReference<alq> n;
  public static NotificationData o;
  private static alp p;
  private static alt q;
  private static OnSharedPreferenceChangeListener r;

  public static PendingIntent a(long paramLong)
  {
    return (PendingIntent)g.a(paramLong);
  }

  public static Cursor a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext, paramString, paramBoolean, false);
  }

  public static Cursor a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2);
    try
    {
      return paramContext.getContentResolver().query(xj.c, null, "?", new String[] { paramString }, null);
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = xj.a;
      String[] arrayOfString = NotificationData.d;
      if (paramBoolean1);
      for (paramContext = "_when DESC"; ; paramContext = "_when")
        return localContentResolver.query(localUri, arrayOfString, "package_name=? AND contact_id=?", new String[] { paramString, "0" }, paramContext);
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static void a()
  {
    synchronized (b)
    {
      k.clear();
      return;
    }
  }

  public static void a(long paramLong, Notification paramNotification)
  {
    synchronized (b)
    {
      b(paramLong, paramNotification);
      return;
    }
  }

  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if ((n != null) && (n.get() != null))
      {
        boolean bool = d(paramContext);
        if (!bool);
      }
    }
    try
    {
      ((alq)n.get()).b(true);
      label45: alx.a(paramContext);
      if (q != null)
        return;
      q = new alt(paramContext.getApplicationContext(), d);
      q.a();
      SharedPreferences localSharedPreferences = vs.a(paramContext);
      l = localSharedPreferences.getString("key_notification_apps_selected", paramContext.getString(2131231208));
      a(null);
      paramContext = paramContext.getApplicationContext();
      p = new alp(paramContext, d);
      p.a();
      r = new OnSharedPreferenceChangeListener()
      {
        public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
        {
          if ("key_notification_apps_selected".equals(paramAnonymousString))
            alo.a(paramAnonymousSharedPreferences);
          while (!"key_sms_notification".equals(paramAnonymousString))
            return;
          if (paramAnonymousSharedPreferences.getBoolean(paramAnonymousString, false))
          {
            alo.g().dispatchChange(true);
            return;
          }
          alo.c(alo.this);
        }
      };
      localSharedPreferences.registerOnSharedPreferenceChangeListener(r);
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (Throwable localThrowable)
    {
      break label45;
    }
  }

  public static void a(Context paramContext, final long paramLong)
  {
    arj.a(new Runnable() {
      public void run() {
        alo.this.getContentResolver().delete(xj.a, "_id=?", new String[]{String.valueOf(paramLong)});
      }
    });
  }

  public static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    a(paramContext, String.valueOf(paramLong1), paramLong2);
  }

  public static void a(Context paramContext, alu paramalu)
  {
    a(paramContext, paramalu, 0L);
  }

  public static void a(Context paramContext, final alu paramalu, long paramLong)
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n_id").append("=?").append(" AND ").append("package_name").append("=?").append(" AND ");
    int i1;
    label107: ArrayList localArrayList;
    if (paramalu.c == null)
    {
      localStringBuilder.append("tag").append(" IS NULL ");
      i1 = 0;
      localStringBuilder.append(" AND ");
      if (paramalu.e != null)
        break label237;
      localStringBuilder.append("key").append(" IS NULL ");
      localArrayList = new ArrayList(5);
      localArrayList.add(String.valueOf(paramalu.d));
      localArrayList.add(paramalu.b);
      if ((i1 == 0) || (i2 == 0))
        break label258;
      localArrayList.add(paramalu.c);
      localArrayList.add(paramalu.e);
    }
    while (true)
    {
      paramalu = new String[localArrayList.size()];
      localArrayList.toArray(paramalu);
      arj.a(new Runnable() {
        public void run() {
          try {
            alo.this.getContentResolver().delete(xj.a, this.b, paramalu);
            return;
          } catch (Throwable localThrowable) {
          }
        }
      });
      return;
      localStringBuilder.append("tag").append("=?");
      i1 = 1;
      break;
      label237: localStringBuilder.append("key").append("=?");
      i2 = 1;
      break label107;
      label258: if (i1 != 0)
        localArrayList.add(paramalu.c);
      else if (i2 != 0)
        localArrayList.add(paramalu.e);
    }
  }

  public static void a(Context paramContext, NotificationData paramNotificationData)
  {
    alu localalu = paramNotificationData.c();
    int i2 = -1;
    int i1 = i2;
    if (Build.VERSION.SDK_INT >= 18)
    {
      i1 = i2;
      if ((paramNotificationData instanceof NotificationDataExtended))
      {
        i2 = ((NotificationDataExtended)paramNotificationData).r;
        i1 = i2;
        if (i2 >= 0)
          i1 = i2;
      }
    }
    else
    {
      i2 = i1;
      if (i1 != 6)
        break label95;
    }
    if (!paramNotificationData.a());
    for (boolean bool = true; ; bool = false)
    {
      SwipeNotificationListenerService.b = bool;
      SwipeNotificationListenerService.a(paramNotificationData.l, paramNotificationData.n, paramNotificationData.m, paramNotificationData.o);
      i2 = i1;
      label95: if (i2 < 0)
        break;
      a(paramContext, paramNotificationData, i2);
      return;
    }
    a(paramContext, localalu);
  }

  public static void a(Context paramContext, NotificationData paramNotificationData, int paramInt)
  {
    if (paramNotificationData == null)
      return;
    arj.a(new Runnable() {
      public void run() {
        try {
          alo.this.getContentResolver().delete(xj.a, this.b + "=?" + " AND " + "package_name" + "=?", new String[]{this.c, this.d});
          return;
        } catch (Throwable localThrowable) {
          Log.w("Swipe.Notification", "Could not remove notifications of " + this.d + " where " + this.b + " = " + this.c);
        }
      }
    });
  }

  public static void a(Context paramContext, final String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("package_name");
    localStringBuilder.append("=?");
    if (paramString != null)
      if (paramLong > 0L)
      {
        localStringBuilder.append(" AND ").append("flags").append("=?");
        paramString = new String[2];
        paramString[0] = "0";
        paramString[1] = String.valueOf(paramLong);
      }
    while (true)
    {
      arj.a(new Runnable() {
        // ERROR //
        public void run() {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	alo$4:a	Landroid/content/Context;
          //   4: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
          //   7: astore_3
          //   8: aload_0
          //   9: getfield 20	alo$4:a	Landroid/content/Context;
          //   12: invokestatic 42	vs:c	(Landroid/content/Context;)Ljava/util/Set;
          //   15: astore_2
          //   16: getstatic 47	xj:a	Landroid/net/Uri;
          //   19: astore_1
          //   20: aload_0
          //   21: getfield 22	alo$4:b	Ljava/lang/String;
          //   24: astore 4
          //   26: aload_0
          //   27: getfield 24	alo$4:c	[Ljava/lang/String;
          //   30: astore 5
          //   32: aload_3
          //   33: aload_1
          //   34: iconst_1
          //   35: anewarray 49	java/lang/String
          //   38: dup
          //   39: iconst_0
          //   40: ldc 51
          //   42: aastore
          //   43: aload 4
          //   45: aload 5
          //   47: aconst_null
          //   48: invokevirtual 57	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
          //   51: astore_1
          //   52: aload_2
          //   53: invokeinterface 63 1 0
          //   58: ifne +101 -> 159
          //   61: new 65	java/util/HashSet
          //   64: dup
          //   65: aload_1
          //   66: invokeinterface 70 1 0
          //   71: invokespecial 73	java/util/HashSet:<init>	(I)V
          //   74: astore_2
          //   75: aload_1
          //   76: invokeinterface 77 1 0
          //   81: ifeq +42 -> 123
          //   84: aload_2
          //   85: aload_1
          //   86: iconst_0
          //   87: invokeinterface 81 2 0
          //   92: invokeinterface 85 2 0
          //   97: pop
          //   98: goto -23 -> 75
          //   101: astore_2
          //   102: aload_1
          //   103: invokestatic 90	arf:a	(Landroid/database/Cursor;)V
          //   106: aload_3
          //   107: getstatic 47	xj:a	Landroid/net/Uri;
          //   110: aload_0
          //   111: getfield 22	alo$4:b	Ljava/lang/String;
          //   114: aload_0
          //   115: getfield 24	alo$4:c	[Ljava/lang/String;
          //   118: invokevirtual 94	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
          //   121: pop
          //   122: return
          //   123: aload_0
          //   124: getfield 20	alo$4:a	Landroid/content/Context;
          //   127: aload_2
          //   128: invokestatic 97	vs:a	(Landroid/content/Context;Ljava/util/Set;)V
          //   131: aload_1
          //   132: invokestatic 90	arf:a	(Landroid/database/Cursor;)V
          //   135: goto -29 -> 106
          //   138: astore_2
          //   139: aconst_null
          //   140: astore_1
          //   141: aload_1
          //   142: invokestatic 90	arf:a	(Landroid/database/Cursor;)V
          //   145: aload_2
          //   146: athrow
          //   147: astore_1
          //   148: return
          //   149: astore_2
          //   150: goto -9 -> 141
          //   153: astore_1
          //   154: aconst_null
          //   155: astore_1
          //   156: goto -54 -> 102
          //   159: goto -84 -> 75
          //
          // Exception table:
          //   from	to	target	type
          //   52	75	101	java/lang/Throwable
          //   75	98	101	java/lang/Throwable
          //   123	131	101	java/lang/Throwable
          //   16	52	138	finally
          //   106	122	147	java/lang/Throwable
          //   52	75	149	finally
          //   75	98	149	finally
          //   123	131	149	finally
          //   16	52	153	java/lang/Throwable
        }
      });
      return;
      paramString = new String[1];
      paramString[0] = "0";
      continue;
      paramString = new String[1];
      paramString[0] = "0";
    }
  }

  public static void a(Context paramContext, final String paramString, final Notification paramNotification)
  {
    arj.a(new Runnable() {
      public void run() {
        try {
          alo.a(alo.this, paramString, paramNotification, null);
          return;
        } catch (Throwable localThrowable) {
          asp.a("Swipe.Notification", "Exception occurred when adding a notification", localThrowable);
        }
      }
    });
  }

  static void a(Context paramContext, String paramString, Notification paramNotification, Object paramObject)
  {
    a(paramContext, paramString, paramNotification, paramObject, false);
  }

  static void a(SharedPreferences paramSharedPreferences)
  {
    String str = l;
    l = paramSharedPreferences.getString("key_notification_apps_selected", "");
    if (asq.a(str, l))
      return;
    a(str);
  }

  // ERROR //
  public static void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_1
    //   9: getstatic 68	alo:b	Ljava/lang/Object;
    //   12: astore 6
    //   14: aload 6
    //   16: monitorenter
    //   17: new 260	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: getstatic 101	alo:h	Lcu;
    //   29: invokevirtual 381	cu:b	()I
    //   32: istore 9
    //   34: iload 9
    //   36: ifle +166 -> 202
    //   39: iconst_0
    //   40: istore 8
    //   42: iload 8
    //   44: iload 9
    //   46: if_icmpge +39 -> 85
    //   49: iload 8
    //   51: ifle +11 -> 62
    //   54: aload 7
    //   56: bipush 44
    //   58: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: getstatic 101	alo:h	Lcu;
    //   67: iload 8
    //   69: invokevirtual 387	cu:b	(I)J
    //   72: invokevirtual 390	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: iload 8
    //   78: iconst_1
    //   79: iadd
    //   80: istore 8
    //   82: goto -40 -> 42
    //   85: new 260	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 392
    //   95: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 7
    //   100: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 394
    //   109: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload_0
    //   118: ldc_w 396
    //   121: iconst_1
    //   122: anewarray 138	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: ldc_w 398
    //   130: aastore
    //   131: aload 5
    //   133: aconst_null
    //   134: aconst_null
    //   135: aconst_null
    //   136: aconst_null
    //   137: invokevirtual 403	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   140: astore 5
    //   142: aload 5
    //   144: astore_1
    //   145: new 70	java/util/HashSet
    //   148: dup
    //   149: aload_1
    //   150: invokeinterface 408 1 0
    //   155: invokespecial 73	java/util/HashSet:<init>	(I)V
    //   158: astore 5
    //   160: aload_1
    //   161: invokeinterface 411 1 0
    //   166: ifeq +101 -> 267
    //   169: aload 5
    //   171: aload_1
    //   172: iconst_0
    //   173: invokeinterface 414 2 0
    //   178: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   181: invokeinterface 420 2 0
    //   186: pop
    //   187: goto -27 -> 160
    //   190: astore 5
    //   192: aload_1
    //   193: ifnull +9 -> 202
    //   196: aload_1
    //   197: invokeinterface 423 1 0
    //   202: getstatic 103	alo:i	Lcu;
    //   205: invokevirtual 381	cu:b	()I
    //   208: istore 9
    //   210: iload 9
    //   212: ifle +250 -> 462
    //   215: aload 7
    //   217: iconst_0
    //   218: invokevirtual 426	java/lang/StringBuilder:setLength	(I)V
    //   221: iconst_0
    //   222: istore 8
    //   224: iload 8
    //   226: iload 9
    //   228: if_icmpge +126 -> 354
    //   231: iload 8
    //   233: ifle +11 -> 244
    //   236: aload 7
    //   238: bipush 44
    //   240: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 7
    //   246: getstatic 103	alo:i	Lcu;
    //   249: iload 8
    //   251: invokevirtual 387	cu:b	(I)J
    //   254: invokevirtual 390	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: iload 8
    //   260: iconst_1
    //   261: iadd
    //   262: istore 8
    //   264: goto -40 -> 224
    //   267: iconst_0
    //   268: istore 8
    //   270: iload 8
    //   272: getstatic 101	alo:h	Lcu;
    //   275: invokevirtual 381	cu:b	()I
    //   278: if_icmpge +63 -> 341
    //   281: aload 5
    //   283: getstatic 101	alo:h	Lcu;
    //   286: iload 8
    //   288: invokevirtual 387	cu:b	(I)J
    //   291: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   294: invokeinterface 429 2 0
    //   299: ifeq +12 -> 311
    //   302: iload 8
    //   304: iconst_1
    //   305: iadd
    //   306: istore 8
    //   308: goto -38 -> 270
    //   311: getstatic 101	alo:h	Lcu;
    //   314: iload 8
    //   316: invokevirtual 431	cu:a	(I)V
    //   319: goto -49 -> 270
    //   322: astore_0
    //   323: aload_1
    //   324: ifnull +9 -> 333
    //   327: aload_1
    //   328: invokeinterface 423 1 0
    //   333: aload_0
    //   334: athrow
    //   335: astore_0
    //   336: aload 6
    //   338: monitorexit
    //   339: aload_0
    //   340: athrow
    //   341: aload_1
    //   342: ifnull -140 -> 202
    //   345: aload_1
    //   346: invokeinterface 423 1 0
    //   351: goto -149 -> 202
    //   354: new 260	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 392
    //   364: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 7
    //   369: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 394
    //   378: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore_1
    //   385: aload_0
    //   386: ldc_w 396
    //   389: iconst_1
    //   390: anewarray 138	java/lang/String
    //   393: dup
    //   394: iconst_0
    //   395: ldc_w 398
    //   398: aastore
    //   399: aload_1
    //   400: aconst_null
    //   401: aconst_null
    //   402: aconst_null
    //   403: aconst_null
    //   404: invokevirtual 403	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   407: astore_1
    //   408: new 70	java/util/HashSet
    //   411: dup
    //   412: aload_1
    //   413: invokeinterface 408 1 0
    //   418: invokespecial 73	java/util/HashSet:<init>	(I)V
    //   421: astore_2
    //   422: aload_1
    //   423: invokeinterface 411 1 0
    //   428: ifeq +99 -> 527
    //   431: aload_2
    //   432: aload_1
    //   433: iconst_0
    //   434: invokeinterface 414 2 0
    //   439: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   442: invokeinterface 420 2 0
    //   447: pop
    //   448: goto -26 -> 422
    //   451: astore_2
    //   452: aload_1
    //   453: ifnull +9 -> 462
    //   456: aload_1
    //   457: invokeinterface 423 1 0
    //   462: aload 7
    //   464: iconst_0
    //   465: invokevirtual 426	java/lang/StringBuilder:setLength	(I)V
    //   468: getstatic 99	alo:g	Lcu;
    //   471: invokevirtual 381	cu:b	()I
    //   474: istore 9
    //   476: iload 9
    //   478: ifle +261 -> 739
    //   481: iconst_0
    //   482: istore 8
    //   484: iload 8
    //   486: iload 9
    //   488: if_icmpge +119 -> 607
    //   491: iload 8
    //   493: ifle +11 -> 504
    //   496: aload 7
    //   498: bipush 44
    //   500: invokevirtual 384	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 7
    //   506: getstatic 99	alo:g	Lcu;
    //   509: iload 8
    //   511: invokevirtual 387	cu:b	(I)J
    //   514: invokevirtual 390	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: iload 8
    //   520: iconst_1
    //   521: iadd
    //   522: istore 8
    //   524: goto -40 -> 484
    //   527: iconst_0
    //   528: istore 8
    //   530: iload 8
    //   532: getstatic 103	alo:i	Lcu;
    //   535: invokevirtual 381	cu:b	()I
    //   538: if_icmpge +56 -> 594
    //   541: aload_2
    //   542: getstatic 103	alo:i	Lcu;
    //   545: iload 8
    //   547: invokevirtual 387	cu:b	(I)J
    //   550: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   553: invokeinterface 429 2 0
    //   558: ifeq +12 -> 570
    //   561: iload 8
    //   563: iconst_1
    //   564: iadd
    //   565: istore 8
    //   567: goto -37 -> 530
    //   570: getstatic 103	alo:i	Lcu;
    //   573: iload 8
    //   575: invokevirtual 431	cu:a	(I)V
    //   578: goto -48 -> 530
    //   581: astore_0
    //   582: aload_1
    //   583: ifnull +9 -> 592
    //   586: aload_1
    //   587: invokeinterface 423 1 0
    //   592: aload_0
    //   593: athrow
    //   594: aload_1
    //   595: ifnull -133 -> 462
    //   598: aload_1
    //   599: invokeinterface 423 1 0
    //   604: goto -142 -> 462
    //   607: aload_3
    //   608: astore_1
    //   609: aload 4
    //   611: astore_2
    //   612: new 260	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 392
    //   622: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload 7
    //   627: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: ldc_w 394
    //   636: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: astore 5
    //   644: aload_3
    //   645: astore_1
    //   646: aload 4
    //   648: astore_2
    //   649: aload_0
    //   650: ldc_w 396
    //   653: iconst_1
    //   654: anewarray 138	java/lang/String
    //   657: dup
    //   658: iconst_0
    //   659: ldc_w 398
    //   662: aastore
    //   663: aload 5
    //   665: aconst_null
    //   666: aconst_null
    //   667: aconst_null
    //   668: aconst_null
    //   669: invokevirtual 403	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   672: astore_0
    //   673: aload_0
    //   674: astore_1
    //   675: aload_0
    //   676: astore_2
    //   677: new 70	java/util/HashSet
    //   680: dup
    //   681: aload_0
    //   682: invokeinterface 408 1 0
    //   687: invokespecial 73	java/util/HashSet:<init>	(I)V
    //   690: astore_3
    //   691: aload_0
    //   692: astore_1
    //   693: aload_0
    //   694: astore_2
    //   695: aload_0
    //   696: invokeinterface 411 1 0
    //   701: ifeq +42 -> 743
    //   704: aload_0
    //   705: astore_1
    //   706: aload_0
    //   707: astore_2
    //   708: aload_3
    //   709: aload_0
    //   710: iconst_0
    //   711: invokeinterface 414 2 0
    //   716: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   719: invokeinterface 420 2 0
    //   724: pop
    //   725: goto -34 -> 691
    //   728: astore_0
    //   729: aload_1
    //   730: ifnull +9 -> 739
    //   733: aload_1
    //   734: invokeinterface 423 1 0
    //   739: aload 6
    //   741: monitorexit
    //   742: return
    //   743: iconst_0
    //   744: istore 8
    //   746: aload_0
    //   747: astore_1
    //   748: aload_0
    //   749: astore_2
    //   750: iload 8
    //   752: getstatic 99	alo:g	Lcu;
    //   755: invokevirtual 381	cu:b	()I
    //   758: if_icmpge +64 -> 822
    //   761: aload_0
    //   762: astore_1
    //   763: aload_0
    //   764: astore_2
    //   765: aload_3
    //   766: getstatic 99	alo:g	Lcu;
    //   769: iload 8
    //   771: invokevirtual 387	cu:b	(I)J
    //   774: invokestatic 419	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   777: invokeinterface 429 2 0
    //   782: ifeq +12 -> 794
    //   785: iload 8
    //   787: iconst_1
    //   788: iadd
    //   789: istore 8
    //   791: goto -45 -> 746
    //   794: aload_0
    //   795: astore_1
    //   796: aload_0
    //   797: astore_2
    //   798: getstatic 99	alo:g	Lcu;
    //   801: iload 8
    //   803: invokevirtual 431	cu:a	(I)V
    //   806: goto -60 -> 746
    //   809: astore_0
    //   810: aload_2
    //   811: ifnull +9 -> 820
    //   814: aload_2
    //   815: invokeinterface 423 1 0
    //   820: aload_0
    //   821: athrow
    //   822: aload_0
    //   823: ifnull -84 -> 739
    //   826: aload_0
    //   827: invokeinterface 423 1 0
    //   832: goto -93 -> 739
    //   835: astore_0
    //   836: aload_2
    //   837: astore_1
    //   838: goto -256 -> 582
    //   841: astore_1
    //   842: aconst_null
    //   843: astore_1
    //   844: goto -392 -> 452
    //   847: astore_0
    //   848: goto -525 -> 323
    //   851: astore_1
    //   852: aconst_null
    //   853: astore_1
    //   854: goto -662 -> 192
    //
    // Exception table:
    //   from	to	target	type
    //   145	160	190	java/lang/Throwable
    //   160	187	190	java/lang/Throwable
    //   270	302	190	java/lang/Throwable
    //   311	319	190	java/lang/Throwable
    //   145	160	322	finally
    //   160	187	322	finally
    //   270	302	322	finally
    //   311	319	322	finally
    //   17	34	335	finally
    //   54	62	335	finally
    //   62	76	335	finally
    //   196	202	335	finally
    //   202	210	335	finally
    //   215	221	335	finally
    //   236	244	335	finally
    //   244	258	335	finally
    //   327	333	335	finally
    //   333	335	335	finally
    //   336	339	335	finally
    //   345	351	335	finally
    //   456	462	335	finally
    //   462	476	335	finally
    //   496	504	335	finally
    //   504	518	335	finally
    //   586	592	335	finally
    //   592	594	335	finally
    //   598	604	335	finally
    //   733	739	335	finally
    //   739	742	335	finally
    //   814	820	335	finally
    //   820	822	335	finally
    //   826	832	335	finally
    //   408	422	451	java/lang/Throwable
    //   422	448	451	java/lang/Throwable
    //   530	561	451	java/lang/Throwable
    //   570	578	451	java/lang/Throwable
    //   408	422	581	finally
    //   422	448	581	finally
    //   530	561	581	finally
    //   570	578	581	finally
    //   612	644	728	java/lang/Throwable
    //   649	673	728	java/lang/Throwable
    //   677	691	728	java/lang/Throwable
    //   695	704	728	java/lang/Throwable
    //   708	725	728	java/lang/Throwable
    //   750	761	728	java/lang/Throwable
    //   765	785	728	java/lang/Throwable
    //   798	806	728	java/lang/Throwable
    //   612	644	809	finally
    //   649	673	809	finally
    //   677	691	809	finally
    //   695	704	809	finally
    //   708	725	809	finally
    //   750	761	809	finally
    //   765	785	809	finally
    //   798	806	809	finally
    //   354	408	835	finally
    //   354	408	841	java/lang/Throwable
    //   85	142	847	finally
    //   85	142	851	java/lang/Throwable
  }

  static void a(String paramString)
  {
    Object localObject2;
    synchronized (b)
    {
      c.clear();
      if (!TextUtils.isEmpty(l))
      {
        localObject2 = l.split(",");
        c.addAll(Arrays.asList((Object[])localObject2));
        localObject2 = asl.e(SwipeApplication.c());
        if (!"com.textra".equals(localObject2))
          c.remove(localObject2);
      }
      localObject2 = j.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
        if (!c.contains(((Entry)((Iterator)localObject2).next()).getKey()))
          ((Iterator)localObject2).remove();
    }
    if ((Build.VERSION.SDK_INT >= 18) && (!TextUtils.isEmpty(paramString)) && (SwipeNotificationListenerService.a != null))
    {
      paramString = paramString.split(",");
      localObject2 = new HashSet(paramString.length);
      ((Set)localObject2).addAll(Arrays.asList(paramString));
      SwipeNotificationListenerService.a.a((Set)localObject2);
    }
  }

  public static boolean a(Context paramContext, alq paramalq)
  {
    if (paramalq == null)
    {
      n = null;
      return false;
    }
    n = new WeakReference(paramalq);
    return d(paramContext);
  }

  public static boolean a(Context paramContext, CharSequence paramCharSequence)
  {
    return (paramCharSequence != null) && (a(paramContext, paramCharSequence.toString()));
  }

  public static boolean a(Context paramContext, String paramString)
  {
    return (paramString != null) && (c.contains(paramString));
  }

  public static boolean a(Context paramContext, String paramString, Notification paramNotification, Object paramObject, boolean paramBoolean)
  {
    synchronized (b)
    {
      if ((CharSequence)j.get(paramString) == null)
      {
        paramContext = asq.a(paramContext, paramString, null);
        j.put(paramString, paramContext);
      }
      long l1 = NotificationData.a(paramString, paramNotification, paramObject, paramBoolean);
      if (l1 < 0L)
        return false;
      if (l1 > 0L)
      {
        a(l1, paramNotification);
        return true;
      }
      return true;
    }
  }

  public static NotificationData.Action b(long paramLong)
  {
    return (NotificationData.Action)h.a(paramLong);
  }

  // ERROR //
  public static NotificationData b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokestatic 536	alo:c	(Landroid/content/Context;Ljava/lang/String;)Landroid/database/Cursor;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnull +37 -> 46
    //   12: aload_0
    //   13: invokeinterface 539 1 0
    //   18: ifeq +28 -> 46
    //   21: new 148	com/lazyswipe/notification/NotificationData
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 542	com/lazyswipe/notification/NotificationData:<init>	(Landroid/database/Cursor;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: ifnull +11 -> 44
    //   36: aload_0
    //   37: invokeinterface 423 1 0
    //   42: aload_2
    //   43: astore_1
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: astore_1
    //   48: aload_0
    //   49: ifnull -5 -> 44
    //   52: aload_0
    //   53: invokeinterface 423 1 0
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: aload_2
    //   66: ifnull +9 -> 75
    //   69: aload_2
    //   70: invokeinterface 423 1 0
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: astore_2
    //   80: goto -15 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	60	finally
    //   12	30	77	finally
  }

  private static void b(long paramLong, Notification paramNotification)
  {
    if (paramNotification.contentIntent != null)
      g.b(paramLong, paramNotification.contentIntent);
    paramNotification = arm.c(paramNotification);
    ArrayList localArrayList = new ArrayList(paramNotification.length);
    int i2 = paramNotification.length;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = paramNotification[i1];
      if (((NotificationData.Action)localObject).d != null)
        h.c(paramLong, localObject);
      while (true)
      {
        if (localArrayList.size() > 0)
        {
          localObject = new NotificationData.Action[localArrayList.size()];
          i.c(paramLong, localArrayList.toArray((Object[])localObject));
        }
        i1 += 1;
        break;
        localArrayList.add(localObject);
      }
    }
  }

  public static void b(Context arg0)
  {
    synchronized (b)
    {
      e.clear();
      g.c();
      h.c();
      j.clear();
      i.c();
      if ((n == null) || (n.get() == null));
    }
    try
    {
      ((alq)n.get()).b(false);
      label68: alx.c();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Throwable )
    {
      break label68;
    }
  }

  public static void b(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    arj.a(new Runnable() {
      // ERROR //
      public void run() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: aload_0
        //   3: getfield 20	alo$6:a	Landroid/content/Context;
        //   6: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   9: astore 4
        //   11: aload_0
        //   12: getfield 22	alo$6:b	Z
        //   15: ifeq +193 -> 208
        //   18: iconst_1
        //   19: anewarray 39	java/lang/String
        //   22: astore_3
        //   23: aload_3
        //   24: iconst_0
        //   25: aload_0
        //   26: getfield 24	alo$6:c	Ljava/lang/String;
        //   29: aastore
        //   30: aload_3
        //   31: astore_2
        //   32: getstatic 45	android/os/Build$VERSION:SDK_INT	I
        //   35: bipush 18
        //   37: if_icmplt +118 -> 155
        //   40: aload 4
        //   42: getstatic 50	xj:a	Landroid/net/Uri;
        //   45: iconst_4
        //   46: anewarray 39	java/lang/String
        //   49: dup
        //   50: iconst_0
        //   51: ldc 52
        //   53: aastore
        //   54: dup
        //   55: iconst_1
        //   56: ldc 54
        //   58: aastore
        //   59: dup
        //   60: iconst_2
        //   61: ldc 56
        //   63: aastore
        //   64: dup
        //   65: iconst_3
        //   66: ldc 58
        //   68: aastore
        //   69: ldc 60
        //   71: aload_3
        //   72: aconst_null
        //   73: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   76: astore_2
        //   77: aload_2
        //   78: astore_1
        //   79: aload_1
        //   80: invokeinterface 72 1 0
        //   85: ifeq +89 -> 174
        //   88: aload_1
        //   89: iconst_3
        //   90: invokeinterface 76 2 0
        //   95: invokestatic 81	arm:a	(I)Z
        //   98: ifne +70 -> 168
        //   101: iconst_1
        //   102: istore 5
        //   104: iload 5
        //   106: putstatic 84	com/lazyswipe/notification/SwipeNotificationListenerService:b	Z
        //   109: aload_0
        //   110: getfield 24	alo$6:c	Ljava/lang/String;
        //   113: aload_1
        //   114: iconst_1
        //   115: invokeinterface 88 2 0
        //   120: aload_1
        //   121: iconst_0
        //   122: invokeinterface 76 2 0
        //   127: aload_1
        //   128: iconst_2
        //   129: invokeinterface 88 2 0
        //   134: invokestatic 91	com/lazyswipe/notification/SwipeNotificationListenerService:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
        //   137: goto -58 -> 79
        //   140: astore_2
        //   141: aload_3
        //   142: astore_2
        //   143: aload_1
        //   144: ifnull +11 -> 155
        //   147: aload_1
        //   148: invokeinterface 94 1 0
        //   153: aload_3
        //   154: astore_2
        //   155: aload 4
        //   157: getstatic 50	xj:a	Landroid/net/Uri;
        //   160: ldc 60
        //   162: aload_2
        //   163: invokevirtual 98	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
        //   166: pop
        //   167: return
        //   168: iconst_0
        //   169: istore 5
        //   171: goto -67 -> 104
        //   174: aload_3
        //   175: astore_2
        //   176: aload_1
        //   177: ifnull -22 -> 155
        //   180: aload_1
        //   181: invokeinterface 94 1 0
        //   186: aload_3
        //   187: astore_2
        //   188: goto -33 -> 155
        //   191: astore_3
        //   192: aload_1
        //   193: astore_2
        //   194: aload_3
        //   195: astore_1
        //   196: aload_2
        //   197: ifnull +9 -> 206
        //   200: aload_2
        //   201: invokeinterface 94 1 0
        //   206: aload_1
        //   207: athrow
        //   208: iconst_1
        //   209: anewarray 39	java/lang/String
        //   212: astore_2
        //   213: aload_2
        //   214: iconst_0
        //   215: aload_0
        //   216: getfield 24	alo$6:c	Ljava/lang/String;
        //   219: aastore
        //   220: goto -65 -> 155
        //   223: astore_1
        //   224: return
        //   225: astore_3
        //   226: aload_1
        //   227: astore_2
        //   228: aload_3
        //   229: astore_1
        //   230: goto -34 -> 196
        //   233: astore_1
        //   234: aconst_null
        //   235: astore_1
        //   236: goto -95 -> 141
        //
        // Exception table:
        //   from	to	target	type
        //   79	101	140	java/lang/Throwable
        //   104	137	140	java/lang/Throwable
        //   40	77	191	finally
        //   155	167	223	java/lang/Throwable
        //   79	101	225	finally
        //   104	137	225	finally
        //   40	77	233	java/lang/Throwable
      }
    });
  }

  public static boolean b()
  {
    return (a) && (m);
  }

  public static boolean b(String paramString)
  {
    return "com.tencent.mobileqq".equals(paramString);
  }

  public static Cursor c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, false);
  }

  public static CharSequence c(String paramString)
  {
    return (CharSequence)j.get(paramString);
  }

  public static void c()
  {
    j.clear();
  }

  public static void c(Context paramContext)
  {
    a(paramContext, null, 0L);
  }

  public static NotificationData.Action[] c(long paramLong)
  {
    return (NotificationData.Action[])i.a(paramLong);
  }

  public static void d(long paramLong)
  {
    synchronized (b)
    {
      h.c(paramLong);
      g.c(paramLong);
      i.c(paramLong);
      return;
    }
  }

  public static void d(Context paramContext, String paramString)
  {
    b(paramContext, paramString, false);
  }

  public static void d(String paramString)
  {
    SwipeService.a(paramString);
  }

  public static boolean d()
  {
    while (true)
    {
      synchronized (b)
      {
        if (e.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public static boolean d(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 18)
        return SwipeNotificationListenerService.b(paramContext);
      boolean bool = SwipeAccessibilityService.a(paramContext);
      return bool;
    }
    catch (Throwable paramContext)
    {
      asp.a("Swipe.Notification", "Failed to determine if notification listener service is running", paramContext);
    }
    return false;
  }

  public static Map<String, Integer> e()
  {
    synchronized (b)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(e);
      return localLinkedHashMap;
    }
  }

  public static void e(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 18)
      localObject = "android.settings.ACCESSIBILITY_SETTINGS";
    StringBuilder localStringBuilder;
    while (true)
    {
      localObject = new Intent((String)localObject);
      if (!(paramContext instanceof Activity))
        ((Intent)localObject).addFlags(268435456);
      try
      {
        paramContext.startActivity((Intent)localObject);
        return;
        localObject = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder().append("Couldn't start the ");
        if (Build.VERSION.SDK_INT >= 18);
      }
    }
    for (Object localObject = "Accessibility settings"; ; localObject = "Notification access settings")
    {
      Toast.makeText(paramContext, (String)localObject + ". Please contact your device manufacture!", 0).show();
      asp.a("Swipe.Notification", "Failed to start the setting activity", localException);
      return;
    }
  }

  public static void f()
  {
    SwipeService.c();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alo
 * JD-Core Version:    0.6.2
 */