package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Action;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.notification.NotificationData.Action;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class arm
{
  private static arn a;

  public static Intent a(Intent paramIntent, String paramString)
  {
    return paramIntent;
  }

  public static Drawable a(Context paramContext, NotificationData paramNotificationData)
  {
    if (paramNotificationData.k != null)
      return new BitmapDrawable(paramNotificationData.k);
    return a(paramContext, paramNotificationData.l);
  }

  public static Drawable a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.length() <= 1)
      str = asl.g(paramContext);
    return asq.f(paramContext, str);
  }

  public static String a(Notification paramNotification)
  {
    paramNotification = b(paramNotification.contentIntent);
    if (paramNotification == null);
    int i;
    do
    {
      return null;
      i = paramNotification.getInt("userId", -1);
    }
    while (i == -1);
    return String.valueOf(i);
  }

  public static String a(PendingIntent paramPendingIntent)
  {
    paramPendingIntent = b(paramPendingIntent);
    if (paramPendingIntent != null)
      return paramPendingIntent.getString("jid");
    return null;
  }

  private static HashMap<Integer, CharSequence> a(RemoteViews paramRemoteViews)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = null;
    try
    {
      Object localObject2 = RemoteViews.class.getDeclaredField("mActions");
      if (localObject2 != null)
      {
        ((Field)localObject2).setAccessible(true);
        localObject1 = (List)((Field)localObject2).get(paramRemoteViews);
      }
      if (localObject1 != null)
      {
        paramRemoteViews = ((List)localObject1).iterator();
        while (paramRemoteViews.hasNext())
        {
          localObject2 = (Parcelable)paramRemoteViews.next();
          localObject1 = Parcel.obtain();
          ((Parcelable)localObject2).writeToParcel((Parcel)localObject1, 0);
          ((Parcel)localObject1).setDataPosition(0);
          if (((Parcel)localObject1).readInt() == 2)
          {
            int i = ((Parcel)localObject1).readInt();
            localObject2 = ((Parcel)localObject1).readString();
            if (localObject2 != null)
            {
              if (((String)localObject2).equals("setText"))
              {
                ((Parcel)localObject1).readInt();
                localHashMap.put(Integer.valueOf(i), (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel((Parcel)localObject1));
              }
              ((Parcel)localObject1).recycle();
            }
          }
        }
      }
    }
    catch (Throwable paramRemoteViews)
    {
    }
    return localHashMap;
  }

  public static void a(Context paramContext)
  {
    if (a == null)
      a = new arn(paramContext);
  }

  public static void a(Context paramContext, int paramInt)
  {
    paramContext = b(paramContext);
    if (paramContext != null)
      paramContext.cancel(paramInt);
  }

  public static void a(Context paramContext, int paramInt, Notification paramNotification)
  {
    if (paramNotification != null)
    {
      paramContext = b(paramContext);
      if (paramContext != null)
        paramContext.notify(paramInt, paramNotification);
    }
  }

  public static void a(Context paramContext, Notification paramNotification, NotificationData paramNotificationData)
  {
    a(paramContext, paramNotification.contentView, paramNotificationData);
    if (Build.VERSION.SDK_INT >= 16)
      a(paramContext, f(paramNotification), paramNotificationData);
  }

  private static void a(Context paramContext, RemoteViews paramRemoteViews, NotificationData paramNotificationData)
  {
    arn localarn = a;
    if (localarn == null)
      return;
    Object localObject2 = null;
    paramContext = null;
    Object localObject1 = null;
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap = a(paramRemoteViews);
    label80: label245: Object localObject3;
    if (localHashMap.size() > 0)
      if (localHashMap.containsKey(Integer.valueOf(localarn.i)))
      {
        paramContext = (CharSequence)localHashMap.get(Integer.valueOf(localarn.i));
        paramRemoteViews = (RemoteViews)localObject1;
        if (localHashMap.containsKey(Integer.valueOf(2131558423)))
          paramRemoteViews = (CharSequence)localHashMap.get(Integer.valueOf(2131558423));
        if (localHashMap.containsKey(Integer.valueOf(2131558425)))
          paramContext = (CharSequence)localHashMap.get(Integer.valueOf(2131558425));
        if (localHashMap.containsKey(Integer.valueOf(2131558405)))
          paramRemoteViews = (CharSequence)localHashMap.get(Integer.valueOf(2131558405));
        localObject1 = paramContext;
        if (localHashMap.containsKey(Integer.valueOf(2131558657)))
          localObject1 = (CharSequence)localHashMap.get(Integer.valueOf(2131558657));
        if (!localHashMap.containsKey(Integer.valueOf(localarn.b)))
          break label1453;
        paramContext = (CharSequence)localHashMap.get(Integer.valueOf(localarn.b));
        ArrayList localArrayList2 = new ArrayList();
        paramRemoteViews = (RemoteViews)localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.k)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.k));
          paramRemoteViews = (RemoteViews)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localArrayList2.add(localObject3);
            paramRemoteViews = (RemoteViews)localObject3;
          }
        }
        localObject2 = paramRemoteViews;
        if (localHashMap.containsKey(Integer.valueOf(localarn.l)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.l));
          localObject2 = paramRemoteViews;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = TextUtils.concat(new CharSequence[] { paramRemoteViews, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        paramRemoteViews = (RemoteViews)localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.m)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.m));
          paramRemoteViews = (RemoteViews)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramRemoteViews = TextUtils.concat(new CharSequence[] { localObject2, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        localObject2 = paramRemoteViews;
        if (localHashMap.containsKey(Integer.valueOf(localarn.n)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.n));
          localObject2 = paramRemoteViews;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = TextUtils.concat(new CharSequence[] { paramRemoteViews, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        paramRemoteViews = (RemoteViews)localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.o)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.o));
          paramRemoteViews = (RemoteViews)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramRemoteViews = TextUtils.concat(new CharSequence[] { localObject2, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        localObject2 = paramRemoteViews;
        if (localHashMap.containsKey(Integer.valueOf(localarn.p)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.p));
          localObject2 = paramRemoteViews;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = TextUtils.concat(new CharSequence[] { paramRemoteViews, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        paramRemoteViews = (RemoteViews)localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.q)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.q));
          paramRemoteViews = (RemoteViews)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramRemoteViews = TextUtils.concat(new CharSequence[] { localObject2, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        localObject2 = paramRemoteViews;
        if (localHashMap.containsKey(Integer.valueOf(localarn.r)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.r));
          localObject2 = paramRemoteViews;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = TextUtils.concat(new CharSequence[] { paramRemoteViews, "\n", localObject3 });
            localArrayList2.add(localObject3);
          }
        }
        localObject3 = localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.s)))
        {
          paramRemoteViews = (CharSequence)localHashMap.get(Integer.valueOf(localarn.s));
          localObject3 = localObject2;
          if (!TextUtils.isEmpty(paramRemoteViews))
          {
            localObject3 = TextUtils.concat(new CharSequence[] { localObject2, "\n", paramRemoteViews });
            localArrayList2.add(paramRemoteViews);
          }
        }
        paramRemoteViews = (RemoteViews)localObject3;
        if (localHashMap.containsKey(Integer.valueOf(localarn.t)))
        {
          localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.t));
          paramRemoteViews = (RemoteViews)localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramRemoteViews = TextUtils.concat(new CharSequence[] { localObject3, "\n", localObject2 });
            localArrayList2.add(localObject2);
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
          break label1535;
        localArrayList1.addAll(localArrayList2);
        localObject2 = null;
        localObject1 = paramRemoteViews;
        label1105: paramRemoteViews = (RemoteViews)localObject2;
        if (localHashMap.containsKey(Integer.valueOf(localarn.e)))
        {
          localObject3 = (CharSequence)localHashMap.get(Integer.valueOf(localarn.e));
          paramRemoteViews = (RemoteViews)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (localObject2 != null)
              break label1550;
            paramRemoteViews = (RemoteViews)localObject3;
          }
        }
        label1165: localObject3 = paramRemoteViews;
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = paramRemoteViews;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(paramRemoteViews))
          {
            localArrayList1.add(paramRemoteViews);
            localObject3 = null;
            localObject2 = paramRemoteViews;
          }
        }
        paramRemoteViews = paramContext;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramRemoteViews = paramContext;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramRemoteViews = paramContext;
            localObject1 = localObject2;
            if (!localObject2.equals(localObject3));
          }
        }
      }
    while (true)
    {
      if (paramRemoteViews != null)
        paramNotificationData.g = paramRemoteViews.toString();
      if (localObject1 != null)
        paramNotificationData.h = ((CharSequence)localObject1).toString();
      if (localArrayList1.size() <= 0)
        break;
      paramContext = new ArrayList(localArrayList1.size());
      paramRemoteViews = localArrayList1.iterator();
      while (true)
        if (paramRemoteViews.hasNext())
        {
          paramContext.add(((CharSequence)paramRemoteViews.next()).toString());
          continue;
          if (localHashMap.containsKey(Integer.valueOf(localarn.c)))
          {
            paramContext = (CharSequence)localHashMap.get(Integer.valueOf(localarn.c));
            break;
          }
          if (localHashMap.containsKey(Integer.valueOf(2131296299)))
          {
            paramContext = (CharSequence)localHashMap.get(Integer.valueOf(2131296299));
            break;
          }
          if (!localHashMap.containsKey(Integer.valueOf(2131099791)))
            break label1585;
          paramContext = (CharSequence)localHashMap.get(Integer.valueOf(2131099791));
          break;
          label1453: if (localHashMap.containsKey(Integer.valueOf(localarn.g)))
          {
            paramContext = (CharSequence)localHashMap.get(Integer.valueOf(localarn.g));
            break label245;
          }
          paramContext = paramRemoteViews;
          if (!localHashMap.containsKey(Integer.valueOf(localarn.j)))
            break label245;
          paramContext = (CharSequence)localHashMap.get(Integer.valueOf(localarn.j));
          break label245;
          label1535: localArrayList1.add(localObject1);
          localObject2 = paramRemoteViews;
          break label1105;
          label1550: paramRemoteViews = localObject2 + "\n" + localObject3;
          break label1165;
        }
      paramNotificationData.j = paramContext;
      return;
      label1585: paramContext = null;
      break label80;
      localObject1 = null;
      paramRemoteViews = paramContext;
    }
  }

  private static void a(Context paramContext, final String paramString, PendingIntent paramPendingIntent)
  {
    if ("com.whatsapp".equals(paramString));
    for (paramString = a(paramPendingIntent); ; paramString = null)
    {
      if (!TextUtils.isEmpty(paramString))
        arj.a(new Runnable()
        {
          // ERROR //
          public void run()
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 18	arm$1:a	Landroid/content/Context;
            //   4: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
            //   7: astore_1
            //   8: getstatic 38	xk:a	Landroid/net/Uri;
            //   11: astore_2
            //   12: aload_0
            //   13: getfield 20	arm$1:b	Ljava/lang/String;
            //   16: astore_3
            //   17: invokestatic 41	arm:a	()I
            //   20: istore 4
            //   22: aload_1
            //   23: aload_2
            //   24: iconst_1
            //   25: anewarray 43	java/lang/String
            //   28: dup
            //   29: iconst_0
            //   30: ldc 45
            //   32: aastore
            //   33: ldc 47
            //   35: iconst_2
            //   36: anewarray 43	java/lang/String
            //   39: dup
            //   40: iconst_0
            //   41: aload_3
            //   42: aastore
            //   43: dup
            //   44: iconst_1
            //   45: iload 4
            //   47: invokestatic 51	java/lang/String:valueOf	(I)Ljava/lang/String;
            //   50: aastore
            //   51: aconst_null
            //   52: invokevirtual 57	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
            //   55: astore_2
            //   56: aload_2
            //   57: invokeinterface 63 1 0
            //   62: ifeq +196 -> 258
            //   65: aload_2
            //   66: iconst_0
            //   67: invokeinterface 67 2 0
            //   72: istore 4
            //   74: aload_2
            //   75: ifnull +9 -> 84
            //   78: aload_2
            //   79: invokeinterface 70 1 0
            //   84: aload_0
            //   85: getfield 18	arm$1:a	Landroid/content/Context;
            //   88: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
            //   91: astore_1
            //   92: iload 4
            //   94: iflt +110 -> 204
            //   97: new 72	android/content/ContentValues
            //   100: dup
            //   101: invokespecial 73	android/content/ContentValues:<init>	()V
            //   104: astore_2
            //   105: aload_2
            //   106: ldc 45
            //   108: iload 4
            //   110: iconst_1
            //   111: iadd
            //   112: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
            //   115: invokevirtual 82	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
            //   118: aload_1
            //   119: getstatic 38	xk:a	Landroid/net/Uri;
            //   122: aload_2
            //   123: ldc 47
            //   125: iconst_2
            //   126: anewarray 43	java/lang/String
            //   129: dup
            //   130: iconst_0
            //   131: aload_0
            //   132: getfield 20	arm$1:b	Ljava/lang/String;
            //   135: aastore
            //   136: dup
            //   137: iconst_1
            //   138: invokestatic 41	arm:a	()I
            //   141: invokestatic 51	java/lang/String:valueOf	(I)Ljava/lang/String;
            //   144: aastore
            //   145: invokevirtual 86	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
            //   148: pop
            //   149: return
            //   150: aload_2
            //   151: ifnull +9 -> 160
            //   154: aload_2
            //   155: invokeinterface 70 1 0
            //   160: aload_1
            //   161: athrow
            //   162: astore_1
            //   163: ldc 88
            //   165: new 90	java/lang/StringBuilder
            //   168: dup
            //   169: invokespecial 91	java/lang/StringBuilder:<init>	()V
            //   172: ldc 93
            //   174: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   177: aload_0
            //   178: getfield 20	arm$1:b	Ljava/lang/String;
            //   181: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   184: ldc 99
            //   186: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   189: invokestatic 41	arm:a	()I
            //   192: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
            //   195: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   198: aload_1
            //   199: invokestatic 112	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   202: pop
            //   203: return
            //   204: new 72	android/content/ContentValues
            //   207: dup
            //   208: invokespecial 73	android/content/ContentValues:<init>	()V
            //   211: astore_2
            //   212: aload_2
            //   213: ldc 45
            //   215: iconst_1
            //   216: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
            //   219: invokevirtual 82	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
            //   222: aload_2
            //   223: ldc 114
            //   225: aload_0
            //   226: getfield 20	arm$1:b	Ljava/lang/String;
            //   229: invokevirtual 117	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
            //   232: aload_2
            //   233: ldc 119
            //   235: invokestatic 41	arm:a	()I
            //   238: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
            //   241: invokevirtual 82	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
            //   244: aload_1
            //   245: getstatic 38	xk:a	Landroid/net/Uri;
            //   248: aload_2
            //   249: invokevirtual 123	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
            //   252: pop
            //   253: return
            //   254: astore_1
            //   255: goto -105 -> 150
            //   258: iconst_m1
            //   259: istore 4
            //   261: goto -187 -> 74
            //   264: astore_1
            //   265: aconst_null
            //   266: astore_2
            //   267: goto -117 -> 150
            //
            // Exception table:
            //   from	to	target	type
            //   78	84	162	java/lang/Throwable
            //   84	92	162	java/lang/Throwable
            //   97	149	162	java/lang/Throwable
            //   154	160	162	java/lang/Throwable
            //   160	162	162	java/lang/Throwable
            //   204	253	162	java/lang/Throwable
            //   56	74	254	finally
            //   0	56	264	finally
          }
        });
      return;
    }
  }

  public static boolean a(int paramInt)
  {
    return ((paramInt & 0x20) == 0) && (!b(paramInt));
  }

  public static boolean a(String paramString)
  {
    return ("com.google.android.gm".equals(paramString)) || ("com.android.email".equals(paramString)) || ("com.motorola.email".equals(paramString)) || ("com.yahoo.mobile.client.android.mail".equals(paramString));
  }

  private static int b()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    return localCalendar.get(5) + (i * 10000 + j * 100);
  }

  private static NotificationManager b(Context paramContext)
  {
    return (NotificationManager)paramContext.getSystemService("notification");
  }

  private static Bundle b(PendingIntent paramPendingIntent)
  {
    if (paramPendingIntent == null);
    do
    {
      do
      {
        return null;
        paramPendingIntent = asq.a(paramPendingIntent);
      }
      while (paramPendingIntent == null);
      paramPendingIntent = paramPendingIntent.getExtras();
    }
    while (paramPendingIntent == null);
    return paramPendingIntent;
  }

  public static String b(Notification paramNotification)
  {
    return a(paramNotification.contentIntent);
  }

  public static void b(Context paramContext, NotificationData paramNotificationData)
  {
    try
    {
      PendingIntent localPendingIntent = alo.a(paramNotificationData.e);
      a(paramContext, paramNotificationData.l, localPendingIntent);
      localPendingIntent.send();
      return;
    }
    catch (Throwable localThrowable)
    {
      asp.a("Swipe.NotificationUtils", "Failed to send the notification content intent", localThrowable);
      if (paramNotificationData.l.length() > 1);
    }
    for (paramNotificationData = asl.g(paramContext); ; paramNotificationData = paramNotificationData.l)
    {
      asq.j(paramContext, paramNotificationData);
      return;
    }
  }

  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }

  public static boolean b(String paramString)
  {
    return ("com.whatsapp".equals(paramString)) || ("com.tencent.mm".equals(paramString)) || ("com.google.android.gm".equals(paramString)) || ("org.telegram.messenger".equals(paramString)) || ("com.viber.voip".equals(paramString));
  }

  public static boolean c(String paramString)
  {
    return "com.whatsapp".equals(paramString);
  }

  public static NotificationData.Action[] c(Notification paramNotification)
  {
    int j = 0;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet(0);
    Object localObject1 = arg.a(paramNotification).c().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ak)((Iterator)localObject1).next();
      if (!localHashSet.contains(((ak)localObject2).b))
      {
        localHashSet.add(((ak)localObject2).b);
        NotificationData.Action localAction = new NotificationData.Action();
        localAction.a = ((ak)localObject2).a;
        localAction.c = ((ak)localObject2).c;
        localAction.b = ((ak)localObject2).b;
        localAction.d = ((ak)localObject2).e();
        localArrayList.add(localAction);
      }
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if ((paramNotification.actions == null) || (paramNotification.actions.length <= 0))
        break label392;
      paramNotification = paramNotification.actions;
      j = paramNotification.length;
      if (i >= j)
        break label392;
      localObject1 = paramNotification[i];
      if (localHashSet.contains(((Action)localObject1).title));
      while (true)
      {
        i += 1;
        break;
        localHashSet.add(((Action)localObject1).title);
        localArrayList.add(new NotificationData.Action((Action)localObject1));
      }
    }
    while (true)
    {
      try
      {
        localObject1 = paramNotification.getClass().getDeclaredField("actions");
        if (localObject1 != null)
        {
          ((Field)localObject1).setAccessible(true);
          paramNotification = (Object[])((Field)localObject1).get(paramNotification);
          break label410;
          if (i < paramNotification.length)
          {
            localObject1 = new NotificationData.Action();
            localObject2 = Class.forName("android.app.Notification$Action");
            ((NotificationData.Action)localObject1).b = ((CharSequence)((Class)localObject2).getDeclaredField("title").get(paramNotification[i]));
            if (localHashSet.contains(((NotificationData.Action)localObject1).b))
              break label421;
            localHashSet.add(((NotificationData.Action)localObject1).b);
            ((NotificationData.Action)localObject1).a = ((Class)localObject2).getDeclaredField("icon").getInt(paramNotification[i]);
            ((NotificationData.Action)localObject1).c = ((PendingIntent)((Class)localObject2).getDeclaredField("actionIntent").get(paramNotification[i]));
            localArrayList.add(localObject1);
          }
        }
      }
      catch (Exception paramNotification)
      {
      }
      label392: label410: 
      do
      {
        paramNotification = new NotificationData.Action[localArrayList.size()];
        localArrayList.toArray(paramNotification);
        return paramNotification;
        paramNotification = null;
      }
      while (paramNotification == null);
      i = j;
      continue;
      label421: i += 1;
    }
  }

  public static boolean d(Notification paramNotification)
  {
    return b(paramNotification.flags);
  }

  public static boolean d(String paramString)
  {
    return "org.telegram.messenger".equals(paramString);
  }

  public static boolean e(Notification paramNotification)
  {
    try
    {
      boolean bool = ((Boolean)Notification.class.getDeclaredMethod("isGroupSummary", new Class[0]).invoke(paramNotification, new Object[0])).booleanValue();
      return bool;
    }
    catch (Throwable paramNotification)
    {
    }
    return false;
  }

  @TargetApi(16)
  private static RemoteViews f(Notification paramNotification)
  {
    if (paramNotification.bigContentView == null)
      return paramNotification.contentView;
    return paramNotification.bigContentView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arm
 * JD-Core Version:    0.6.2
 */