package cmcm.com.myapplication.com.lazyswipe.notification;

import aj;
import alo;
import alu;
import alw;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import aqn;
import arm;
import asi;
import asp;
import asq;
import atw;
import com.lazyswipe.SwipeApplication;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xj;

public class NotificationData
  implements Parcelable
{
  public static final Creator<NotificationData> CREATOR = new Creator()
  {
    public NotificationData a(Parcel paramAnonymousParcel)
    {
      return new NotificationData(paramAnonymousParcel, null);
    }

    public NotificationData[] a(int paramAnonymousInt)
    {
      return new NotificationData[paramAnonymousInt];
    }
  };
  public static final Uri a = Uri.parse("content://sms");
  public static final Uri b = Uri.parse("content://mms-sms");
  public static final String[] c = { "title", "_text", "ticker_text", "_when", "_id", "package_name", "n_id", "tag", "key", "app_identity", "flags" };
  public static final String[] d = { "title", "_text", "ticker_text", "_when", "_id", "package_name", "n_id", "tag", "key", "app_identity", "flags", "large_icon" };
  private static Field r;
  private static final Pattern s = Pattern.compile("^\\[\\d+.*\\](.*): (.*)");
  private static final Pattern t = Pattern.compile("^(.*) @ (.*): (.*)");
  private static final Pattern u = Pattern.compile("^(.*): (.*)");
  public long e;
  public long f;
  public String g;
  public String h;
  public String i;
  public List<String> j;
  public Bitmap k;
  public String l;
  public int m;
  public String n;
  public String o;
  public String p;
  public int q;

  public NotificationData()
  {
  }

  public NotificationData(Cursor paramCursor)
  {
    this.e = paramCursor.getInt(4);
    this.h = paramCursor.getString(1);
    this.g = paramCursor.getString(0);
    this.i = paramCursor.getString(2);
    this.f = paramCursor.getLong(3);
    this.l = paramCursor.getString(5);
    this.m = paramCursor.getInt(6);
    this.n = paramCursor.getString(7);
    this.o = paramCursor.getString(8);
    this.p = paramCursor.getString(9);
    this.q = paramCursor.getInt(10);
    if (paramCursor.getColumnCount() > 11)
      this.k = atw.a(paramCursor.getBlob(11));
  }

  private NotificationData(Parcel paramParcel)
  {
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readInt();
    this.k = ((Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel));
  }

  private static long a(Context paramContext, String paramString1, Notification paramNotification, NotificationData paramNotificationData, ContentValues paramContentValues, String paramString2)
  {
    Stack localStack = new Stack();
    localStack.addAll(paramNotificationData.j);
    long l1;
    int i2;
    label52: int i3;
    int i4;
    label77: Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ("com.viber.voip".equals(paramString1))
    {
      i1 = paramNotificationData.j.size();
      l1 = -1L;
      if (paramString2 == null)
        break label213;
      i2 = 1;
      if ((!"com.viber.voip".equals(paramString1)) || (localStack.size() != 1))
        break label219;
      i3 = 1;
      i4 = i1;
      do
      {
        l2 = l1;
        if (localStack.isEmpty())
          break;
        localObject1 = "0";
        localObject2 = (String)localStack.pop();
        if (i3 != 0)
          localObject2 = paramNotificationData.i;
      }
      while (TextUtils.isEmpty((CharSequence)localObject2));
      localObject3 = t.matcher((CharSequence)localObject2);
      if (!((Matcher)localObject3).matches())
        break label229;
      localObject4 = ((Matcher)localObject3).group(2);
      localObject2 = ((Matcher)localObject3).group(1);
      localObject3 = ((Matcher)localObject3).group(3);
      localObject3 = (String)localObject2 + ": " + (String)localObject3;
    }
    while (true)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3))
        break label364;
      l2 = -1L;
      return l2;
      i1 = 0;
      break;
      label213: i2 = 0;
      break label52;
      label219: i3 = 0;
      i4 = i1;
      break label77;
      label229: localObject3 = u.matcher((CharSequence)localObject2);
      if ((i2 == 0) && (((Matcher)localObject3).matches()))
      {
        localObject4 = ((Matcher)localObject3).group(1);
        localObject3 = ((Matcher)localObject3).group(2);
        localObject1 = a(paramContext, paramString1, (String)localObject4);
      }
      else
      {
        String str1 = paramNotificationData.g;
        localObject3 = localObject2;
        localObject4 = str1;
        if (i2 != 0)
        {
          String str2 = a(paramContext.getContentResolver(), new String[] { paramString1, paramString2 });
          localObject3 = localObject2;
          localObject4 = str1;
          localObject1 = str2;
          if (str2.charAt(0) == '0')
          {
            localObject1 = a(paramContext, paramString1, str1);
            localObject3 = localObject2;
            localObject4 = str1;
          }
        }
      }
    }
    label364: paramContentValues.put("_text", (String)localObject3);
    paramContentValues.put("title", (String)localObject4);
    long l2 = paramNotification.when;
    if (("com.viber.voip".equals(paramString1)) || ("org.telegram.messenger".equals(paramString1)));
    for (int i1 = i4 - 1; ; i1 = i4 + 1)
    {
      paramContentValues.put("_when", Long.valueOf(l2 - i4));
      paramContentValues.put("contact_id", (String)localObject1);
      l2 = l1;
      try
      {
        localObject2 = paramContext.getContentResolver().insert(xj.a, paramContentValues);
        l2 = l1;
        if (localObject2 != null)
        {
          l2 = l1;
          l1 = ContentUris.parseId((Uri)localObject2);
          l2 = l1;
          if (asi.a((String)localObject1, -1L) > 0L)
          {
            l2 = l1;
            alo.k.add(localObject1);
          }
          while (true)
          {
            l2 = l1;
            alo.a(l1, paramNotification);
            l2 = l1;
            break;
            l2 = l1;
            alo.k.add(paramString1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        i4 = i1;
        l1 = l2;
      }
      break;
    }
  }

  @SuppressLint({"NewApi"})
  public static long a(String paramString, Notification paramNotification, Object paramObject, boolean paramBoolean)
  {
    if (paramNotification.when == 0L)
      return -1L;
    if ((TextUtils.isEmpty(paramNotification.tickerText)) && (alo.b(paramString)))
      return -1L;
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (arm.d(paramNotification))
    {
      if ("com.bbm".equals(paramString))
        return -1L;
      if (!localSwipeApplication.getString(2131231208).contains(paramString))
        return -1L;
    }
    int i1;
    String str1;
    Object localObject3;
    Object localObject4;
    if ((paramObject != null) && ((paramObject instanceof StatusBarNotification)))
    {
      localObject1 = (StatusBarNotification)paramObject;
      i1 = ((StatusBarNotification)localObject1).getId();
      str1 = ((StatusBarNotification)localObject1).getTag();
      if (Build.VERSION.SDK_INT >= 20)
      {
        localObject1 = ((StatusBarNotification)localObject1).getKey();
        localObject3 = aj.b(paramNotification);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject4 = aj.a(paramNotification);
          localObject2 = localObject3;
          if (localObject4 != null)
            localObject2 = ((Bundle)localObject4).getString("android.support.wearable.groupKey");
        }
        localObject3 = localObject2;
      }
    }
    int i3;
    for (Object localObject2 = localObject1; ; localObject2 = null)
    {
      localObject1 = null;
      i3 = 1;
      if (!arm.c(paramString))
        break label797;
      if (str1 == null)
        break label216;
      return -1L;
      localObject1 = null;
      break;
      localObject3 = null;
      str1 = null;
      i1 = 0;
    }
    label216: Object localObject1 = arm.b(paramNotification);
    while (true)
    {
      localObject4 = new NotificationData();
      try
      {
        arm.a(localSwipeApplication, paramNotification, (NotificationData)localObject4);
        i2 = i3;
        if (!TextUtils.isEmpty(((NotificationData)localObject4).g))
        {
          i2 = i3;
          if (!TextUtils.isEmpty(((NotificationData)localObject4).h))
          {
            if ((!arm.c(paramString)) && (!"com.viber.voip".equals(paramString)) && (!arm.d(paramString)))
              break label855;
            if (((NotificationData)localObject4).j != null)
            {
              if ((Build.VERSION.SDK_INT >= 21) && (!"com.viber.voip".equals(paramString)) && (!arm.c(paramString)))
                break label822;
              b(localSwipeApplication, paramString, (NotificationData)localObject4, (String)localObject1);
            }
          }
        }
        while (true)
        {
          i2 = 0;
          if (i2 != 0)
          {
            ((NotificationData)localObject4).j = null;
            ((NotificationData)localObject4).a(paramNotification);
          }
          if (paramNotification.largeIcon != null)
            ((NotificationData)localObject4).k = paramNotification.largeIcon;
          if ((TextUtils.isEmpty(((NotificationData)localObject4).i)) && (!TextUtils.isEmpty(paramNotification.tickerText)))
            ((NotificationData)localObject4).i = paramNotification.tickerText.toString();
          if (!"com.textra".equals(paramString))
            break label864;
          localSwipeApplication.getContentResolver().delete(xj.a, "package_name=? AND title=?key_suppress_notify", new String[] { paramString, ((NotificationData)localObject4).g });
          ContentValues localContentValues = new ContentValues();
          if (paramBoolean)
            localContentValues.put("key_suppress_notify", Boolean.valueOf(true));
          localContentValues.put("icon", Integer.valueOf(paramNotification.icon));
          localContentValues.put("n_id", Integer.valueOf(i1));
          localContentValues.put("tag", str1);
          localContentValues.put("key", (String)localObject2);
          localContentValues.put("_group", (String)localObject3);
          localContentValues.put("package_name", paramString);
          if (!TextUtils.isEmpty(((NotificationData)localObject4).i))
            localContentValues.put("ticker_text", ((NotificationData)localObject4).i);
          localContentValues.put("flags", Integer.valueOf(paramNotification.flags));
          localContentValues.put("app_identity", (String)localObject1);
          if (Build.VERSION.SDK_INT >= 16)
            localContentValues.put("priority", Integer.valueOf(paramNotification.priority));
          if (paramNotification.largeIcon == null)
            break label1030;
          localContentValues.put("large_icon", atw.d(paramNotification.largeIcon));
          if ((paramObject != null) && ((paramObject instanceof StatusBarNotification)))
          {
            paramObject = (StatusBarNotification)paramObject;
            if (Build.VERSION.SDK_INT >= 18)
            {
              localContentValues.put("uid", Integer.valueOf(paramObject.getUserId()));
              if (Build.VERSION.SDK_INT >= 20)
                localContentValues.put("sort_key", paramNotification.getSortKey());
            }
          }
          if (localObject1 != null)
          {
            paramObject = localSwipeApplication.getContentResolver();
            localObject2 = new String[2];
            localObject2[0] = paramString;
            localObject2[1] = localObject1;
            a(paramObject, (String[])localObject2);
            if (paramNotification.largeIcon != null)
              a(localSwipeApplication, paramObject, paramString, paramNotification, (String)localObject1, (NotificationData)localObject4, (String[])localObject2);
          }
          if (((!arm.c(paramString)) && (!"com.viber.voip".equals(paramString)) && (!arm.d(paramString))) || (((NotificationData)localObject4).j == null) || (((NotificationData)localObject4).j.size() <= 0))
            break label1061;
          return a(localSwipeApplication, paramString, paramNotification, (NotificationData)localObject4, localContentValues, (String)localObject1);
          label797: if (!arm.d(paramString))
            break;
          if (str1 != null)
            return -1L;
          localObject1 = arm.a(paramNotification);
          break;
          label822: a(localSwipeApplication, paramString, (NotificationData)localObject4, (String)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        label855: label864: String str2;
        while (true)
        {
          asp.b("Swipe.Notification", "Failed to extra the expanded text.", localThrowable);
          int i2 = i3;
          continue;
          ((NotificationData)localObject4).j = null;
          continue;
          if ((paramString.equals("com.tencent.qqlite")) || (paramString.equals("com.sina.weibo")) || (arm.a(paramString)) || (paramString.equals("com.google.android.gm")))
          {
            if (a(localSwipeApplication, (NotificationData)localObject4, paramString))
              return -1L;
          }
          else if (("com.tencent.mm".equals(paramString)) && (!TextUtils.isEmpty(((NotificationData)localObject4).h)))
          {
            Object localObject5 = s.matcher(((NotificationData)localObject4).h);
            if (((Matcher)localObject5).matches())
            {
              str2 = ((Matcher)localObject5).group(1);
              localObject5 = ((Matcher)localObject5).group(2);
              if (asq.a(str2, ((NotificationData)localObject4).g))
              {
                ((NotificationData)localObject4).h = ((String)localObject5);
              }
              else
              {
                ((NotificationData)localObject4).h = (str2 + ": " + (String)localObject5);
                continue;
                label1030: localObject2 = atw.a(arm.a(localSwipeApplication, paramString));
                if (localObject2 != null)
                  str2.put("large_icon", atw.d((Bitmap)localObject2));
              }
            }
          }
        }
        label1061: str2.put("contact_id", "0");
        str2.put("_when", Long.valueOf(paramNotification.when));
        paramObject = ((NotificationData)localObject4).g;
        localObject1 = ((NotificationData)localObject4).h;
        str2.put("title", paramObject);
        str2.put("_text", (String)localObject1);
        if (paramNotification.number > 0)
          str2.put("number", Integer.valueOf(paramNotification.number));
        try
        {
          paramNotification = localSwipeApplication.getContentResolver().insert(xj.a, str2);
          if (paramNotification != null)
          {
            if (asi.a("0", -1L) > 0L)
              alo.k.add("0");
            while (true)
            {
              return ContentUris.parseId(paramNotification);
              alo.k.add(paramString);
            }
          }
        }
        catch (Throwable paramString)
        {
        }
      }
    }
    return -1L;
  }

  // ERROR //
  private static String a(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getstatic 514	xd:a	Landroid/net/Uri;
    //   6: iconst_1
    //   7: anewarray 60	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc_w 296
    //   15: aastore
    //   16: ldc_w 516
    //   19: aload_1
    //   20: aconst_null
    //   21: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: invokeinterface 523 1 0
    //   31: ifeq +23 -> 54
    //   34: aload_0
    //   35: iconst_0
    //   36: invokeinterface 126 2 0
    //   41: astore_1
    //   42: aload_0
    //   43: ifnull +9 -> 52
    //   46: aload_0
    //   47: invokeinterface 526 1 0
    //   52: aload_1
    //   53: areturn
    //   54: aload_0
    //   55: ifnull +9 -> 64
    //   58: aload_0
    //   59: invokeinterface 526 1 0
    //   64: ldc 223
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull -7 -> 64
    //   74: aload_0
    //   75: invokeinterface 526 1 0
    //   80: goto -16 -> 64
    //   83: astore_0
    //   84: aload_2
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +9 -> 96
    //   90: aload_1
    //   91: invokeinterface 526 1 0
    //   96: aload_0
    //   97: athrow
    //   98: astore_2
    //   99: aload_0
    //   100: astore_1
    //   101: aload_2
    //   102: astore_0
    //   103: goto -17 -> 86
    //   106: astore_1
    //   107: goto -37 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   2	25	67	java/lang/Throwable
    //   2	25	83	finally
    //   25	42	98	finally
    //   25	42	106	java/lang/Throwable
  }

  // ERROR //
  private static String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 514	xd:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 60	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 296
    //   18: aastore
    //   19: ldc_w 528
    //   22: iconst_3
    //   23: anewarray 60	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: aload_1
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: aload_2
    //   37: aastore
    //   38: aconst_null
    //   39: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_0
    //   43: aload_0
    //   44: invokeinterface 523 1 0
    //   49: ifeq +23 -> 72
    //   52: aload_0
    //   53: iconst_0
    //   54: invokeinterface 126 2 0
    //   59: astore_1
    //   60: aload_0
    //   61: ifnull +9 -> 70
    //   64: aload_0
    //   65: invokeinterface 526 1 0
    //   70: aload_1
    //   71: areturn
    //   72: aload_0
    //   73: ifnull +9 -> 82
    //   76: aload_0
    //   77: invokeinterface 526 1 0
    //   82: ldc 223
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull -7 -> 82
    //   92: aload_0
    //   93: invokeinterface 526 1 0
    //   98: goto -16 -> 82
    //   101: astore_0
    //   102: aload_3
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +9 -> 114
    //   108: aload_1
    //   109: invokeinterface 526 1 0
    //   114: aload_0
    //   115: athrow
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: goto -17 -> 104
    //   124: astore_1
    //   125: goto -37 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   2	43	85	java/lang/Throwable
    //   2	43	101	finally
    //   43	60	116	finally
    //   43	60	124	java/lang/Throwable
  }

  private void a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (Build.VERSION.SDK_INT < 19)
        break label66;
      paramNotification = paramNotification.extras;
    }
    while (true)
    {
      CharSequence localCharSequence = paramNotification.getCharSequence("android.title");
      if (localCharSequence != null)
        this.g = localCharSequence.toString();
      paramNotification = paramNotification.getCharSequence("android.text");
      if (paramNotification != null)
        this.h = paramNotification.toString();
      return;
      try
      {
        label66: if (r == null)
        {
          r = paramNotification.getClass().getDeclaredField("extras");
          r.setAccessible(true);
        }
        paramNotification = (Bundle)r.get(paramNotification);
      }
      catch (Exception paramNotification)
      {
      }
    }
  }

  // ERROR //
  private static void a(Context paramContext, ContentResolver paramContentResolver, String paramString1, Notification paramNotification, String paramString2, NotificationData paramNotificationData, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: getstatic 568	wz:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 60	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 570
    //   16: aastore
    //   17: ldc_w 572
    //   20: aload 6
    //   22: aconst_null
    //   23: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore 6
    //   28: aload 6
    //   30: invokeinterface 523 1 0
    //   35: ifeq +94 -> 129
    //   38: aload 6
    //   40: iconst_0
    //   41: invokeinterface 120 2 0
    //   46: ifgt +83 -> 129
    //   49: aload_3
    //   50: getfield 406	android/app/Notification:largeIcon	Landroid/graphics/Bitmap;
    //   53: aload_0
    //   54: invokestatic 577	aqn:a	(Landroid/graphics/Bitmap;Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   57: astore_3
    //   58: aload_3
    //   59: invokestatic 580	aqn:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   62: astore_0
    //   63: aload_3
    //   64: invokestatic 583	atw:a	(Landroid/graphics/Bitmap;)V
    //   67: aload_0
    //   68: invokestatic 451	atw:d	(Landroid/graphics/Bitmap;)[B
    //   71: astore_3
    //   72: aload_0
    //   73: invokestatic 583	atw:a	(Landroid/graphics/Bitmap;)V
    //   76: new 274	android/content/ContentValues
    //   79: dup
    //   80: iconst_4
    //   81: invokespecial 586	android/content/ContentValues:<init>	(I)V
    //   84: astore_0
    //   85: aload_0
    //   86: ldc 72
    //   88: aload_2
    //   89: invokevirtual 278	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: ldc_w 588
    //   96: aload 5
    //   98: getfield 130	com/lazyswipe/notification/NotificationData:g	Ljava/lang/String;
    //   101: invokevirtual 278	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: ldc 78
    //   107: aload 4
    //   109: invokevirtual 278	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: ldc_w 430
    //   116: aload_3
    //   117: invokevirtual 454	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   120: aload_1
    //   121: getstatic 568	wz:a	Landroid/net/Uri;
    //   124: aload_0
    //   125: invokevirtual 305	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   128: pop
    //   129: aload 6
    //   131: ifnull +10 -> 141
    //   134: aload 6
    //   136: invokeinterface 526 1 0
    //   141: return
    //   142: astore_0
    //   143: aconst_null
    //   144: astore 6
    //   146: aload 6
    //   148: ifnull -7 -> 141
    //   151: aload 6
    //   153: invokeinterface 526 1 0
    //   158: return
    //   159: astore_0
    //   160: aload 7
    //   162: astore 6
    //   164: aload 6
    //   166: ifnull +10 -> 176
    //   169: aload 6
    //   171: invokeinterface 526 1 0
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: goto -15 -> 164
    //   182: astore_0
    //   183: goto -37 -> 146
    //
    // Exception table:
    //   from	to	target	type
    //   3	28	142	java/lang/Throwable
    //   3	28	159	finally
    //   28	129	178	finally
    //   28	129	182	java/lang/Throwable
  }

  // ERROR //
  private static void a(Context paramContext, String paramString1, NotificationData paramNotificationData, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 299	xj:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 60	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 64
    //   15: aastore
    //   16: ldc_w 590
    //   19: iconst_1
    //   20: anewarray 60	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: ldc_w 592
    //   30: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_0
    //   34: aload_0
    //   35: invokeinterface 523 1 0
    //   40: ifne +19 -> 59
    //   43: aload_2
    //   44: aconst_null
    //   45: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   48: aload_0
    //   49: ifnull +9 -> 58
    //   52: aload_0
    //   53: invokeinterface 526 1 0
    //   58: return
    //   59: aload_0
    //   60: iconst_0
    //   61: invokeinterface 126 2 0
    //   66: astore_1
    //   67: aload_2
    //   68: aload_2
    //   69: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   72: aload_2
    //   73: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   76: invokeinterface 214 1 0
    //   81: iconst_1
    //   82: isub
    //   83: invokeinterface 595 2 0
    //   88: checkcast 60	java/lang/String
    //   91: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   94: aload_2
    //   95: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   98: aload_1
    //   99: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   102: istore 4
    //   104: iload 4
    //   106: iflt +36 -> 142
    //   109: aload_2
    //   110: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   113: invokeinterface 602 1 0
    //   118: aload_2
    //   119: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   122: aload_2
    //   123: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   126: iload 4
    //   128: aload_1
    //   129: invokevirtual 605	java/lang/String:length	()I
    //   132: iadd
    //   133: invokevirtual 608	java/lang/String:substring	(I)Ljava/lang/String;
    //   136: invokeinterface 609 2 0
    //   141: pop
    //   142: aload_2
    //   143: aconst_null
    //   144: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   147: goto -99 -> 48
    //   150: astore_1
    //   151: aload_0
    //   152: ifnull -94 -> 58
    //   155: aload_0
    //   156: invokeinterface 526 1 0
    //   161: return
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_0
    //   170: invokeinterface 526 1 0
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: goto -13 -> 165
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_0
    //   184: goto -33 -> 151
    //
    // Exception table:
    //   from	to	target	type
    //   34	48	150	java/lang/Throwable
    //   59	104	150	java/lang/Throwable
    //   109	142	150	java/lang/Throwable
    //   142	147	150	java/lang/Throwable
    //   0	34	162	finally
    //   34	48	177	finally
    //   59	104	177	finally
    //   109	142	177	finally
    //   142	147	177	finally
    //   0	34	181	java/lang/Throwable
  }

  // ERROR //
  private static boolean a(Context paramContext, NotificationData paramNotificationData, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: iconst_1
    //   4: istore 9
    //   6: aload_0
    //   7: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 299	xj:a	Landroid/net/Uri;
    //   13: iconst_3
    //   14: anewarray 60	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 62
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 64
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 66
    //   31: aastore
    //   32: ldc_w 590
    //   35: iconst_1
    //   36: anewarray 60	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_2
    //   42: aastore
    //   43: ldc_w 592
    //   46: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_0
    //   50: aload_0
    //   51: invokeinterface 523 1 0
    //   56: ifeq +160 -> 216
    //   59: aload_0
    //   60: iconst_0
    //   61: invokeinterface 126 2 0
    //   66: astore_3
    //   67: aload_0
    //   68: iconst_1
    //   69: invokeinterface 126 2 0
    //   74: astore 4
    //   76: aload_0
    //   77: iconst_2
    //   78: invokeinterface 126 2 0
    //   83: astore 5
    //   85: aload_2
    //   86: invokestatic 488	arm:a	(Ljava/lang/String;)Z
    //   89: ifeq +52 -> 141
    //   92: aload_3
    //   93: aload_1
    //   94: getfield 130	com/lazyswipe/notification/NotificationData:g	Ljava/lang/String;
    //   97: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   100: ifeq +35 -> 135
    //   103: aload 4
    //   105: aload_1
    //   106: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   109: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   112: istore 8
    //   114: iload 8
    //   116: ifeq +19 -> 135
    //   119: iconst_1
    //   120: istore 8
    //   122: aload_0
    //   123: ifnull +9 -> 132
    //   126: aload_0
    //   127: invokeinterface 526 1 0
    //   132: iload 8
    //   134: ireturn
    //   135: iconst_0
    //   136: istore 8
    //   138: goto -16 -> 122
    //   141: iconst_m1
    //   142: istore 6
    //   144: aload_2
    //   145: invokevirtual 612	java/lang/String:hashCode	()I
    //   148: istore 7
    //   150: iload 7
    //   152: lookupswitch	default:+36->188, -543674259:+108->260, -191341148:+76->228, 1536737232:+92->244
    //   189: iconst_3
    //   190: tableswitch	default:+26 -> 216, 0:+86->276, 1:+148->338, 2:+176->366
    //   217: ifnull +9 -> 226
    //   220: aload_0
    //   221: invokeinterface 526 1 0
    //   226: iconst_0
    //   227: ireturn
    //   228: aload_2
    //   229: ldc_w 484
    //   232: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifeq -47 -> 188
    //   238: iconst_0
    //   239: istore 6
    //   241: goto -53 -> 188
    //   244: aload_2
    //   245: ldc_w 486
    //   248: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq -63 -> 188
    //   254: iconst_1
    //   255: istore 6
    //   257: goto -69 -> 188
    //   260: aload_2
    //   261: ldc_w 490
    //   264: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq -79 -> 188
    //   270: iconst_2
    //   271: istore 6
    //   273: goto -85 -> 188
    //   276: aload_3
    //   277: aload_1
    //   278: getfield 130	com/lazyswipe/notification/NotificationData:g	Ljava/lang/String;
    //   281: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   284: ifeq +48 -> 332
    //   287: aload 4
    //   289: aload_1
    //   290: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   293: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   296: ifeq +36 -> 332
    //   299: aload 5
    //   301: aload_1
    //   302: getfield 132	com/lazyswipe/notification/NotificationData:i	Ljava/lang/String;
    //   305: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   308: istore 8
    //   310: iload 8
    //   312: ifeq +20 -> 332
    //   315: iload 9
    //   317: istore 8
    //   319: aload_0
    //   320: ifnull -188 -> 132
    //   323: aload_0
    //   324: invokeinterface 526 1 0
    //   329: iload 9
    //   331: ireturn
    //   332: iconst_0
    //   333: istore 9
    //   335: goto -20 -> 315
    //   338: aload 5
    //   340: aload_1
    //   341: getfield 132	com/lazyswipe/notification/NotificationData:i	Ljava/lang/String;
    //   344: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   347: istore 9
    //   349: iload 9
    //   351: istore 8
    //   353: aload_0
    //   354: ifnull -222 -> 132
    //   357: aload_0
    //   358: invokeinterface 526 1 0
    //   363: iload 9
    //   365: ireturn
    //   366: aload_3
    //   367: aload_1
    //   368: getfield 130	com/lazyswipe/notification/NotificationData:g	Ljava/lang/String;
    //   371: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   374: ifeq +40 -> 414
    //   377: aload 4
    //   379: aload_1
    //   380: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   383: invokestatic 500	asq:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   386: istore 9
    //   388: iload 9
    //   390: ifeq +24 -> 414
    //   393: iload 8
    //   395: istore 9
    //   397: iload 9
    //   399: istore 8
    //   401: aload_0
    //   402: ifnull -270 -> 132
    //   405: aload_0
    //   406: invokeinterface 526 1 0
    //   411: iload 9
    //   413: ireturn
    //   414: iconst_0
    //   415: istore 9
    //   417: goto -20 -> 397
    //   420: astore_0
    //   421: aconst_null
    //   422: astore_0
    //   423: aload_0
    //   424: ifnull -198 -> 226
    //   427: aload_0
    //   428: invokeinterface 526 1 0
    //   433: goto -207 -> 226
    //   436: astore_1
    //   437: aconst_null
    //   438: astore_0
    //   439: aload_0
    //   440: ifnull +9 -> 449
    //   443: aload_0
    //   444: invokeinterface 526 1 0
    //   449: aload_1
    //   450: athrow
    //   451: astore_1
    //   452: goto -13 -> 439
    //   455: astore_1
    //   456: goto -33 -> 423
    //
    // Exception table:
    //   from	to	target	type
    //   6	50	420	java/lang/Throwable
    //   6	50	436	finally
    //   50	114	451	finally
    //   144	150	451	finally
    //   228	238	451	finally
    //   244	254	451	finally
    //   260	270	451	finally
    //   276	310	451	finally
    //   338	349	451	finally
    //   366	388	451	finally
    //   50	114	455	java/lang/Throwable
    //   144	150	455	java/lang/Throwable
    //   228	238	455	java/lang/Throwable
    //   244	254	455	java/lang/Throwable
    //   260	270	455	java/lang/Throwable
    //   276	310	455	java/lang/Throwable
    //   338	349	455	java/lang/Throwable
    //   366	388	455	java/lang/Throwable
  }

  public static boolean a(Cursor paramCursor, alw paramalw, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = SwipeApplication.c().getContentResolver();
    String str1;
    if (TextUtils.isEmpty(paramalw.d))
      if (TextUtils.isEmpty(paramString1))
        str1 = paramCursor.getString(0);
    while (true)
    {
      ContentValues localContentValues = new ContentValues(9);
      if ((alw.a != paramalw) && (paramalw.i.containsKey("sms")))
        localContentValues.put("contact_id", Long.valueOf(paramalw.b));
      localContentValues.put("n_id", Long.valueOf(paramCursor.getLong(3)));
      localContentValues.put("_when", Long.valueOf(paramCursor.getLong(1)));
      localContentValues.put("contact_uri", paramString2);
      localContentValues.put("package_name", "0");
      localContentValues.put("flags", Integer.valueOf(paramCursor.getInt(4)));
      String str2 = paramCursor.getString(2);
      paramCursor = paramCursor.getString(0);
      localContentValues.put("title", str1);
      localContentValues.put("_text", str2);
      localContentValues.put("ticker_text", paramCursor);
      paramCursor = aqn.a(SwipeApplication.c(), paramalw, paramString1, Uri.parse(paramString2));
      if (paramCursor != null)
        localContentValues.put("large_icon", atw.d(paramCursor));
      try
      {
        if (localContentResolver.insert(xj.a, localContentValues) != null)
        {
          if (localContentValues.containsKey("contact_id"))
            alo.k.add(String.valueOf(paramalw.b));
          while (true)
          {
            return true;
            str1 = paramString1;
            break;
            str1 = paramalw.d;
            break;
            alo.k.add("0");
          }
        }
      }
      catch (Throwable paramCursor)
      {
      }
    }
    return false;
  }

  // ERROR //
  private static void b(Context paramContext, String paramString1, NotificationData paramNotificationData, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 265	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 299	xj:a	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 60	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 570
    //   16: aastore
    //   17: ldc_w 590
    //   20: iconst_1
    //   21: anewarray 60	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: aconst_null
    //   29: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnull +42 -> 76
    //   37: aload_0
    //   38: invokeinterface 523 1 0
    //   43: ifeq +33 -> 76
    //   46: aload_0
    //   47: iconst_0
    //   48: invokeinterface 120 2 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifne +25 -> 82
    //   60: aload_2
    //   61: aconst_null
    //   62: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   65: aload_0
    //   66: ifnull +9 -> 75
    //   69: aload_0
    //   70: invokeinterface 526 1 0
    //   75: return
    //   76: iconst_0
    //   77: istore 4
    //   79: goto -24 -> 55
    //   82: aload_2
    //   83: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   86: astore_3
    //   87: ldc 205
    //   89: aload_1
    //   90: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifne +119 -> 212
    //   96: ldc_w 285
    //   99: aload_1
    //   100: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +64 -> 167
    //   106: goto +106 -> 212
    //   109: aload_2
    //   110: aload_3
    //   111: iload 4
    //   113: invokeinterface 595 2 0
    //   118: checkcast 60	java/lang/String
    //   121: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   124: aload_2
    //   125: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   128: invokeinterface 602 1 0
    //   133: aload_2
    //   134: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   137: aload_2
    //   138: getfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   141: invokeinterface 609 2 0
    //   146: pop
    //   147: aload_2
    //   148: aconst_null
    //   149: putfield 128	com/lazyswipe/notification/NotificationData:h	Ljava/lang/String;
    //   152: goto -87 -> 65
    //   155: astore_1
    //   156: aload_0
    //   157: ifnull -82 -> 75
    //   160: aload_0
    //   161: invokeinterface 526 1 0
    //   166: return
    //   167: aload_2
    //   168: getfield 199	com/lazyswipe/notification/NotificationData:j	Ljava/util/List;
    //   171: invokeinterface 214 1 0
    //   176: istore 4
    //   178: iload 4
    //   180: iconst_1
    //   181: isub
    //   182: istore 4
    //   184: goto -75 -> 109
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_0
    //   190: aload_0
    //   191: ifnull +9 -> 200
    //   194: aload_0
    //   195: invokeinterface 526 1 0
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: goto -13 -> 190
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -53 -> 156
    //   212: iconst_0
    //   213: istore 4
    //   215: goto -106 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   37	55	155	java/lang/Throwable
    //   60	65	155	java/lang/Throwable
    //   82	106	155	java/lang/Throwable
    //   109	152	155	java/lang/Throwable
    //   167	178	155	java/lang/Throwable
    //   0	33	187	finally
    //   37	55	202	finally
    //   60	65	202	finally
    //   82	106	202	finally
    //   109	152	202	finally
    //   167	178	202	finally
    //   0	33	206	java/lang/Throwable
  }

  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 6:
      return "n_id";
    case 0:
    }
    return "title";
  }

  public boolean a()
  {
    return arm.a(this.q);
  }

  public String b()
  {
    if (!TextUtils.isEmpty(this.h))
      return this.h;
    if (!TextUtils.isEmpty(this.i))
      return this.i;
    return null;
  }

  public String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 6:
      return String.valueOf(this.m);
    case 0:
    }
    return this.g;
  }

  public alu c()
  {
    return new alu(this.m, this.n, this.o, this.l);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NotificationData));
    do
    {
      return false;
      paramObject = (NotificationData)paramObject;
    }
    while ((!asq.a(paramObject.i, this.i)) || (!asq.a(paramObject.g, this.g)) || (!asq.a(paramObject.h, this.h)));
    return true;
  }

  public int hashCode()
  {
    int i3 = 0;
    int i1;
    if (this.i != null)
    {
      i1 = this.i.hashCode();
      if (this.h == null)
        break label68;
    }
    label68: for (int i2 = this.h.hashCode(); ; i2 = 0)
    {
      if (this.g != null)
        i3 = this.g.hashCode();
      return (i2 + (i1 + 527) * 31) * 31 + i3;
      i1 = 0;
      break;
    }
  }

  public String toString()
  {
    return "ticker=" + this.i + ",title=" + this.g + ",text=" + this.h + ",timestamp=" + this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeParcelable(this.k, paramInt);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeInt(this.q);
    if (this.k != null)
      this.k.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.notification.NotificationData
 * JD-Core Version:    0.6.2
 */