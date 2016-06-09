package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Window;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.DismissKeyguardActivity;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class asq
{
  public static Collator a = Collator.getInstance();
  public static final DecimalFormat b = new DecimalFormat("#0.#");
  public static final DecimalFormat c = new DecimalFormat("#");

  public static double a(double paramDouble1, double paramDouble2)
  {
    return a(0.0D, 0.0D, paramDouble1, paramDouble2);
  }

  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return Math.toDegrees(Math.atan2(paramDouble3 - paramDouble1, paramDouble4 - paramDouble2));
  }

  public static int a(float paramFloat)
  {
    return (int)(vj.c * paramFloat + 0.5F);
  }

  public static int a(int paramInt)
  {
    return (int)(paramInt / vj.c + 0.5F);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt1;
  }

  public static int a(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 != null) && (paramDate2 != null))
    {
      paramDate1 = a(paramDate1);
      paramDate2 = a(paramDate2);
      return (int)((paramDate1.getTime() - paramDate2.getTime()) / 86400000L);
    }
    return 0;
  }

  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = paramArrayOfInt.length - 1;
      while (i >= 0)
      {
        if (paramArrayOfInt[i] == paramInt)
          return i;
        i -= 1;
      }
    }
    return -1;
  }

  public static int a(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject != null) && (paramString != null))
    {
      int i = paramArrayOfObject.length - 1;
      while (i >= 0)
      {
        if (paramArrayOfObject[i].toString().equals(paramString))
          return i;
        i -= 1;
      }
    }
    return -1;
  }

  public static int a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramString != null))
    {
      int i = paramArrayOfString.length - 1;
      while (i >= 0)
      {
        if (paramArrayOfString[i].equals(paramString))
          return i;
        i -= 1;
      }
    }
    return -1;
  }

  public static ComponentName a(Context paramContext, RecentTaskInfo paramRecentTaskInfo)
  {
    return b(paramContext, paramRecentTaskInfo.baseIntent);
  }

  public static ComponentName a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean)
  {
    if (a(paramContext, a(paramComponentName)))
      return paramComponentName;
    if (paramBoolean)
      return h(paramContext, paramComponentName.getPackageName());
    return null;
  }

  public static ComponentName a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (paramIntent.hasCategory("android.intent.category.LAUNCHER"))
      return localComponentName;
    paramContext = b(paramContext, localComponentName);
    if (paramContext != null);
    while (true)
    {
      return paramContext;
      if (paramBoolean)
        paramContext = localComponentName;
      else
        paramContext = null;
    }
  }

  public static ComponentName a(ResolveInfo paramResolveInfo)
  {
    if (paramResolveInfo.activityInfo.targetActivity != null);
    for (String str = paramResolveInfo.activityInfo.targetActivity; ; str = paramResolveInfo.activityInfo.name)
      return new ComponentName(paramResolveInfo.activityInfo.packageName, str);
  }

  public static Intent a(PendingIntent paramPendingIntent)
  {
    try
    {
      Method localMethod = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
      localMethod.setAccessible(true);
      paramPendingIntent = (Intent)localMethod.invoke(paramPendingIntent, new Object[0]);
      return paramPendingIntent;
    }
    catch (Throwable paramPendingIntent)
    {
    }
    return null;
  }

  public static Intent a(ComponentName paramComponentName)
  {
    return a((String)null).setComponent(paramComponentName);
  }

  public static Intent a(Uri paramUri, String paramString)
  {
    return new Intent("android.intent.action.VIEW").addFlags(268435456).setDataAndType(paramUri, paramString);
  }

  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
    if (!TextUtils.isEmpty(paramString))
      localIntent.setPackage(paramString);
    return localIntent;
  }

  public static Intent a(String paramString1, String paramString2)
  {
    return a(Uri.parse(paramString1), paramString2);
  }

  public static Drawable a(PackageManager paramPackageManager, String paramString)
  {
    return a(paramPackageManager, paramString, null);
  }

  public static Drawable a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    try
    {
      if ((TextUtils.isEmpty(paramString2)) || (paramString2.equals("null")));
      for (paramPackageManager = paramPackageManager.getApplicationIcon(paramString1); ; paramPackageManager = paramPackageManager.getActivityInfo(new ComponentName(paramString1, paramString2), 16).loadIcon(paramPackageManager))
      {
        paramString1 = paramPackageManager;
        if (paramPackageManager == null)
          paramString1 = SwipeApplication.c().getResources().getDrawable(2130903040);
        return paramString1;
      }
    }
    catch (Throwable paramPackageManager)
    {
      while (true)
      {
        Log.w("Swipe.Utils", "Could not get app icon", paramPackageManager);
        paramPackageManager = null;
      }
    }
  }

  public static Message a(Handler paramHandler, int paramInt, Bundle paramBundle, Object paramObject)
  {
    paramHandler = Message.obtain(paramHandler, paramInt);
    if (paramObject != null)
      paramHandler.obj = paramObject;
    if (paramBundle != null)
      paramHandler.setData(paramBundle);
    return paramHandler;
  }

  private static Object a(Context paramContext, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.widget.LockPatternUtils");
      paramContext = localClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      paramContext = localClass.getMethod(paramString, (Class[])paramArrayOfClass).invoke(paramContext, (Object[])paramArrayOfObject);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      asp.b("Swipe.Utils", "Failed to execute method " + paramString, paramContext);
    }
    return null;
  }

  public static <T> T a(Collection<T> paramCollection, T[] paramArrayOfT)
  {
    if (paramCollection != null)
    {
      int j = paramArrayOfT.length;
      int i = 0;
      while (i < j)
      {
        T ? = paramArrayOfT[i];
        if (paramCollection.contains(?))
          return ?;
        i += 1;
      }
    }
    return null;
  }

  public static String a(long paramLong, DecimalFormat paramDecimalFormat)
  {
    if (paramDecimalFormat == null)
      return paramLong + "B";
    if (paramLong > 1073741824L)
      return paramDecimalFormat.format((float)paramLong / 1.073742E+09F) + "G";
    if (paramLong > 1048576L)
      return paramDecimalFormat.format((float)paramLong / 1048576.0F) + "M";
    if (paramLong > 1024L)
      return paramDecimalFormat.format((float)paramLong / 1024.0F) + "K";
    return paramLong + "B";
  }

  public static String a(Context paramContext)
  {
    return c(paramContext).getPackageName();
  }

  // ERROR //
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 359	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_0
    //   7: aload_2
    //   8: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +88 -> 99
    //   14: aload_3
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 363	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +75 -> 97
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual 369	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   30: invokeinterface 372 1 0
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +78 -> 119
    //   44: aload_3
    //   45: aload_1
    //   46: invokestatic 174	asq:a	(Ljava/lang/String;)Landroid/content/Intent;
    //   49: iconst_0
    //   50: invokevirtual 376	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +64 -> 119
    //   58: aload_0
    //   59: invokeinterface 382 1 0
    //   64: ifle +55 -> 119
    //   67: aload_0
    //   68: invokeinterface 386 1 0
    //   73: invokeinterface 392 1 0
    //   78: checkcast 129	android/content/pm/ResolveInfo
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +36 -> 119
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 393	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   91: invokeinterface 372 1 0
    //   96: astore_0
    //   97: aload_0
    //   98: areturn
    //   99: aload_3
    //   100: new 103	android/content/ComponentName
    //   103: dup
    //   104: aload_1
    //   105: aload_2
    //   106: invokespecial 145	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: invokestatic 396	asq:a	(Landroid/content/pm/PackageManager;Landroid/content/ComponentName;)Ljava/lang/String;
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aload_2
    //   118: areturn
    //   119: aload_2
    //   120: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   14	21	113	android/content/pm/PackageManager$NameNotFoundException
    //   25	36	113	android/content/pm/PackageManager$NameNotFoundException
    //   36	54	116	android/content/pm/PackageManager$NameNotFoundException
    //   58	82	116	android/content/pm/PackageManager$NameNotFoundException
    //   86	97	116	android/content/pm/PackageManager$NameNotFoundException
  }

  public static String a(PackageManager paramPackageManager, ComponentName paramComponentName)
  {
    try
    {
      paramPackageManager = paramPackageManager.getActivityInfo(paramComponentName, 0).loadLabel(paramPackageManager).toString();
      return paramPackageManager;
    }
    catch (Throwable paramPackageManager)
    {
      Log.w("Swipe.Utils", "Could not get app Name", paramPackageManager);
    }
    return paramComponentName.getPackageName();
  }

  public static String a(SparseIntArray paramSparseIntArray)
  {
    int i = 0;
    if (paramSparseIntArray == null)
      return "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      while (i < paramSparseIntArray.size())
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(" ,");
        localStringBuilder.append(paramSparseIntArray.keyAt(i)).append(" : ").append(paramSparseIntArray.valueAt(i));
        i += 1;
      }
      localStringBuilder.insert(0, "{");
      localStringBuilder.append("}");
      paramSparseIntArray = localStringBuilder.toString();
      return paramSparseIntArray;
    }
    catch (Exception paramSparseIntArray)
    {
    }
    return "";
  }

  public static String a(Map<?, ?> paramMap)
  {
    if (paramMap == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(" ,");
      localStringBuilder.append(localEntry.getKey()).append(" : ").append(localEntry.getValue());
    }
    localStringBuilder.insert(0, "{");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  private static Date a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTime();
  }

  public static Set<String> a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject;
      if (Build.VERSION.SDK_INT < 21)
      {
        localObject = paramContext.getRecentTasks(paramInt, 2);
        if (localObject != null)
        {
          paramContext = new HashSet(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (true)
          {
            RecentTaskInfo localRecentTaskInfo;
            if (((Iterator)localObject).hasNext())
            {
              localRecentTaskInfo = (RecentTaskInfo)((Iterator)localObject).next();
              int i = paramContext.size();
              if (i <= paramInt);
            }
            else
            {
              return paramContext;
            }
            try
            {
              paramContext.add(localRecentTaskInfo.baseIntent.getComponent().getPackageName());
            }
            catch (Throwable localThrowable)
            {
            }
          }
        }
      }
      else
      {
        localObject = paramContext.getRunningAppProcesses();
        if (localObject != null)
        {
          paramContext = new HashSet(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)((Iterator)localObject).next();
            if (paramContext.size() > paramInt)
              break;
            Collections.addAll(paramContext, localRunningAppProcessInfo.pkgList);
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      Log.w("Swipe.Utils", "Could not get running packages", paramContext);
    }
    return Collections.EMPTY_SET;
    return paramContext;
  }

  public static void a()
  {
    b();
  }

  public static void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  // ERROR //
  public static void a(Activity paramActivity)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: invokestatic 540	aqs:Q	()Z
    //   8: ifeq +73 -> 81
    //   11: invokestatic 543	aqs:R	()Z
    //   14: ifeq +204 -> 218
    //   17: aload_0
    //   18: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   21: invokevirtual 553	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: ldc_w 555
    //   27: iconst_1
    //   28: anewarray 157	java/lang/Class
    //   31: dup
    //   32: iconst_0
    //   33: getstatic 561	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   36: aastore
    //   37: invokestatic 566	arp:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +176 -> 218
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: iconst_0
    //   57: invokestatic 570	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokevirtual 171	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: iconst_1
    //   66: istore_2
    //   67: iload_2
    //   68: ifne +13 -> 81
    //   71: aload_0
    //   72: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   75: ldc_w 571
    //   78: invokevirtual 575	android/view/Window:addFlags	(I)V
    //   81: invokestatic 540	aqs:Q	()Z
    //   84: ifeq +106 -> 190
    //   87: aload_0
    //   88: invokestatic 578	asq:w	(Landroid/content/Context;)I
    //   91: putstatic 581	vj:m	I
    //   94: iload 4
    //   96: istore_2
    //   97: invokestatic 543	aqs:R	()Z
    //   100: ifeq +76 -> 176
    //   103: aload_0
    //   104: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   107: invokevirtual 553	java/lang/Object:getClass	()Ljava/lang/Class;
    //   110: ldc_w 583
    //   113: iconst_1
    //   114: anewarray 157	java/lang/Class
    //   117: dup
    //   118: iconst_0
    //   119: getstatic 561	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   122: aastore
    //   123: invokestatic 566	arp:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +112 -> 240
    //   131: aload_0
    //   132: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   135: ldc_w 584
    //   138: invokevirtual 575	android/view/Window:addFlags	(I)V
    //   141: aload_0
    //   142: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   145: invokevirtual 588	android/view/Window:getDecorView	()Landroid/view/View;
    //   148: sipush 512
    //   151: invokevirtual 593	android/view/View:setSystemUiVisibility	(I)V
    //   154: aload_1
    //   155: aload_0
    //   156: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: iconst_0
    //   166: invokestatic 570	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokevirtual 171	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: iload_3
    //   175: istore_2
    //   176: iload_2
    //   177: ifne +13 -> 190
    //   180: aload_0
    //   181: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   184: ldc_w 594
    //   187: invokevirtual 575	android/view/Window:addFlags	(I)V
    //   190: invokestatic 540	aqs:Q	()Z
    //   193: ifne +13 -> 206
    //   196: aload_0
    //   197: invokevirtual 549	android/app/Activity:getWindow	()Landroid/view/Window;
    //   200: sipush 512
    //   203: invokevirtual 575	android/view/Window:addFlags	(I)V
    //   206: return
    //   207: astore_1
    //   208: ldc 250
    //   210: ldc_w 596
    //   213: aload_1
    //   214: invokestatic 599	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: iconst_0
    //   219: istore_2
    //   220: goto -153 -> 67
    //   223: astore_1
    //   224: ldc 250
    //   226: ldc_w 596
    //   229: aload_1
    //   230: invokestatic 599	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: iload 4
    //   236: istore_2
    //   237: goto -61 -> 176
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -66 -> 176
    //
    // Exception table:
    //   from	to	target	type
    //   17	41	207	java/lang/Throwable
    //   45	65	207	java/lang/Throwable
    //   103	127	223	java/lang/Throwable
    //   131	174	223	java/lang/Throwable
  }

  @TargetApi(21)
  public static void a(Activity paramActivity, int paramInt)
  {
    try
    {
      paramActivity.getWindow().setStatusBarColor(paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
    }
  }

  public static void a(Context paramContext, long paramLong)
  {
    paramContext = o(paramContext);
    if (paramContext != null)
      paramContext.vibrate(paramLong);
  }

  public static void a(Context paramContext, ComponentName paramComponentName, int paramInt1, int paramInt2)
  {
    a(paramContext, paramComponentName, paramInt1, paramInt2, null);
  }

  public static void a(Context paramContext, ComponentName paramComponentName, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(paramInt1));
    localIntent.putExtra("duplicate", false);
    paramComponentName = new Intent("android.intent.action.MAIN").setComponent(paramComponentName);
    paramComponentName.replaceExtras(paramBundle);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramComponentName);
    localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(paramContext, paramInt2));
    paramContext.sendBroadcast(localIntent);
  }

  public static void a(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public static void a(Context paramContext, File paramFile, OnScanCompletedListener paramOnScanCompletedListener)
  {
    String[] arrayOfString = paramFile.list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      if (j > 0)
      {
        paramFile = paramFile.getAbsolutePath();
        int i = 0;
        while (i < j)
        {
          arrayOfString[i] = (paramFile + "/" + arrayOfString[i]);
          i += 1;
        }
        a(paramContext, arrayOfString, paramOnScanCompletedListener);
      }
    }
  }

  public static void a(Context paramContext, String paramString, OnScanCompletedListener paramOnScanCompletedListener)
  {
    a(paramContext, new String[] { paramString }, paramOnScanCompletedListener);
  }

  public static void a(Context paramContext, String[] paramArrayOfString, OnScanCompletedListener paramOnScanCompletedListener)
  {
    MediaScannerConnection.scanFile(paramContext, paramArrayOfString, null, paramOnScanCompletedListener);
  }

  public static void a(Iterable<ComponentName> paramIterable, String paramString)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
      if (((ComponentName)paramIterable.next()).getPackageName().equals(paramString))
        paramIterable.remove();
  }

  public static void a(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject2 = e("statusbar");
      Object localObject1 = localObject2.getClass();
      if (paramArrayOfClass == null);
      for (localObject1 = ((Class)localObject1).getMethod(paramString, new Class[0]); ; localObject1 = ((Class)localObject1).getMethod(paramString, paramArrayOfClass))
      {
        ((Method)localObject1).setAccessible(true);
        if (paramArrayOfClass != null)
          break;
        ((Method)localObject1).invoke(localObject2, new Object[0]);
        return;
      }
      ((Method)localObject1).invoke(localObject2, paramArrayOfObject);
      return;
    }
    catch (InvocationTargetException paramArrayOfClass)
    {
      Log.w("Swipe.Utils", "Execution of method " + paramString + " failed", paramArrayOfClass.getTargetException());
      return;
    }
    catch (Throwable paramArrayOfClass)
    {
      Log.w("Swipe.Utils", "Execution of method " + paramString + " failed", paramArrayOfClass);
    }
  }

  public static void a(Throwable paramThrowable)
  {
    a(paramThrowable, 6, "Swipe.Utils", null);
  }

  public static void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    case 5:
    default:
      str = paramString2;
      if (TextUtils.isEmpty(paramString2))
        str = "Unexpected error";
      asp.a(paramString1, str, paramThrowable);
    case 2:
    case 3:
      return;
    case 4:
      paramThrowable = paramString2;
      if (TextUtils.isEmpty(paramString2))
        paramThrowable = "Unexpected error";
      asp.a(paramString1, paramThrowable);
      return;
    case 6:
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
      str = "Unexpected error";
    asp.b(paramString1, str, paramThrowable);
  }

  public static void a(Throwable paramThrowable, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean)
      a(paramThrowable, paramInt, paramString1, paramString2);
  }

  public static boolean a(Context paramContext, ComponentName paramComponentName)
  {
    return ((DevicePolicyManager)paramContext.getSystemService("device_policy")).isAdminActive(paramComponentName);
  }

  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    while (paramContext.getPackageManager().resolveActivity(paramIntent, 0) == null)
      return false;
    return true;
  }

  public static boolean a(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).iterator();
      while (paramContext.hasNext())
      {
        boolean bool = paramString.equals(((ResolveInfo)paramContext.next()).activityInfo.applicationInfo.packageName);
        if (bool)
          return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static boolean a(Context paramContext, Class<?> paramClass)
  {
    return c(paramContext).getClassName().equals(paramClass.getName());
  }

  public static boolean a(Context paramContext, String paramString)
  {
    return e(paramContext).contains(paramString);
  }

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.charAt(0) != '?')
      paramString = String.format(Locale.US, "market://details?id=%1$s", new Object[] { paramString });
    while (true)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString));
      if ((paramBoolean1) && (paramBoolean2))
        localIntent.setPackage("com.android.vending");
      if (!(paramContext instanceof Activity))
        localIntent.addFlags(268435456);
      try
      {
        paramContext.startActivity(localIntent);
        return true;
        paramString = String.format(Locale.US, "market://details%1$s", new Object[] { paramString });
      }
      catch (Throwable localThrowable)
      {
        if ((paramBoolean1) && (paramBoolean2))
        {
          if (paramString.equals("com.hola.launcher"))
          {
            j(paramContext);
            return true;
          }
          return a(paramContext, paramString, false, true);
        }
        localIntent.setData(Uri.parse("https://play.google.com/store/apps/details" + paramString));
        try
        {
          paramContext.startActivity(localIntent);
          return true;
        }
        catch (Throwable paramContext)
        {
        }
      }
    }
    return false;
  }

  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Throwable paramContext)
    {
    }
    return paramBoolean;
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public static boolean a(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }

  public static ComponentName b(Context paramContext, ComponentName paramComponentName)
  {
    return a(paramContext, paramComponentName, true);
  }

  public static ComponentName b(Context paramContext, Intent paramIntent)
  {
    return a(paramContext, paramIntent, true);
  }

  public static Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    if (!TextUtils.isEmpty(paramString))
      localIntent.setPackage(paramString);
    return localIntent;
  }

  public static Drawable b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext.getPackageManager(), paramString1, paramString2);
  }

  public static StateListDrawable b(int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt);
    Object localObject = new float[3];
    Color.colorToHSV(paramInt, (float[])localObject);
    localObject[2] *= 0.7F;
    localObject = new ColorDrawable(Color.HSVToColor((float[])localObject));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    localStateListDrawable.addState(new int[] { 16842908 }, (Drawable)localObject);
    localStateListDrawable.addState(new int[] { 16842910 }, localColorDrawable);
    return localStateListDrawable;
  }

  public static String b(Context paramContext, long paramLong)
  {
    if (paramLong <= 0L)
      return "";
    paramLong = System.currentTimeMillis() - paramLong;
    if (paramLong < 0L)
      return "";
    paramContext = paramContext.getResources();
    if (paramLong < 60000L)
      return paramContext.getString(2131230999);
    if (paramLong < 3600000L)
    {
      i = (int)(paramLong / 60000L);
      return paramContext.getQuantityString(2131558402, i, new Object[] { Integer.valueOf(i) });
    }
    if (paramLong < 86400000L)
    {
      i = (int)(paramLong / 3600000L);
      return paramContext.getQuantityString(2131558401, i, new Object[] { Integer.valueOf(i) });
    }
    int i = (int)(paramLong / 86400000L);
    return paramContext.getQuantityString(2131558400, i, new Object[] { Integer.valueOf(i) });
  }

  public static String b(ResolveInfo paramResolveInfo)
  {
    if (paramResolveInfo.activityInfo.targetActivity == null)
      return null;
    return paramResolveInfo.activityInfo.name;
  }

  public static String b(Collection<?> paramCollection)
  {
    if (paramCollection == null)
      return "[null]";
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(" ,");
      localStringBuilder.append(localObject);
    }
    localStringBuilder.insert(0, "[");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public static String b(Map<String, String> paramMap)
  {
    if (paramMap == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append("&");
      String str2 = (String)paramMap.get(str1);
      localStringBuilder.append(str1).append("=").append(str2);
    }
    return localStringBuilder.toString();
  }

  public static Set<String> b(Context paramContext)
  {
    return a(paramContext, 2147483647);
  }

  public static void b()
  {
    try
    {
      Runtime.getRuntime().gc();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void b(Activity paramActivity)
  {
    if (!aqs.Q())
      new apj(paramActivity, paramActivity.getWindow().getDecorView());
  }

  public static void b(Context paramContext, File paramFile)
  {
    a(paramContext, paramFile.getAbsolutePath(), null);
  }

  public static void b(Throwable paramThrowable)
  {
    a(paramThrowable, false, 0, null, null);
  }

  public static void b(Throwable paramThrowable, int paramInt, String paramString1, String paramString2)
  {
    a(paramThrowable, true, paramInt, paramString1, paramString2);
  }

  public static boolean b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.parse("package:" + paramString));
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static ComponentName c(Context paramContext)
  {
    while (true)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 21)
        {
          paramContext = ((RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (paramContext == null)
            break label276;
          return paramContext;
        }
        if (!aqs.ai())
          break label115;
        if (!wu.b(paramContext))
          break label292;
        paramContext = wu.c(paramContext);
        if (paramContext != null)
        {
          paramContext = new ComponentName(paramContext, "");
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        asp.a("Swipe.Utils", "Failed to get the foreground component", paramContext);
        return new ComponentName("DUMMY", "DUMMY");
      }
      return new ComponentName("", "");
      label115: if (aqs.ah())
      {
        paramContext = ase.g();
        if (paramContext != null)
          return new ComponentName(paramContext, "");
        paramContext = new ComponentName("", "");
        return paramContext;
      }
      try
      {
        Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        paramContext = RunningAppProcessInfo.class.getDeclaredField("processState");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (RunningAppProcessInfo)((Iterator)localObject1).next();
          if (((RunningAppProcessInfo)localObject2).importance == 100)
          {
            int i = ((RunningAppProcessInfo)localObject2).importanceReasonCode;
            if (i == 0)
              try
              {
                if (paramContext.getInt(localObject2) == 2)
                {
                  localObject2 = new ComponentName(localObject2.pkgList[0], "");
                  return localObject2;
                }
              }
              catch (Throwable localThrowable)
              {
                asp.a("Swipe.Utils", "Failed to get the foreground package", localThrowable);
              }
          }
        }
      }
      catch (Throwable paramContext)
      {
        asp.a("Swipe.Utils", "Failed to get the foreground package", paramContext);
      }
      label276: paramContext = new ComponentName("", "");
      return paramContext;
      label292: paramContext = null;
    }
  }

  public static Intent c()
  {
    return a((String)null);
  }

  public static Intent c(String paramString)
  {
    return a(paramString, null);
  }

  public static void c(Context paramContext, File paramFile)
  {
    a(paramContext, paramFile, null);
  }

  public static boolean c(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = a(paramContext.getPackageManager().queryIntentActivities(paramIntent, 0));
      if (!bool2)
        bool1 = true;
      return bool1;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static boolean c(Context paramContext, String paramString)
  {
    return d(paramContext, paramString) != null;
  }

  public static boolean c(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, new ComponentName(paramString1, paramString2));
  }

  public static Intent d()
  {
    return b(null);
  }

  public static PackageInfo d(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  // ERROR //
  public static String d(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 988	asq:q	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/res/AssetManager;
    //   5: aload_2
    //   6: invokevirtual 994	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: aload_0
    //   11: invokestatic 999	arf:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: invokestatic 1002	arf:a	(Ljava/io/Closeable;)V
    //   19: aload_1
    //   20: areturn
    //   21: astore_0
    //   22: aconst_null
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 1002	arf:a	(Ljava/io/Closeable;)V
    //   28: aconst_null
    //   29: areturn
    //   30: astore_0
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_0
    //   34: invokestatic 1002	arf:a	(Ljava/io/Closeable;)V
    //   37: aconst_null
    //   38: areturn
    //   39: astore_0
    //   40: aconst_null
    //   41: astore_2
    //   42: aload_0
    //   43: astore_1
    //   44: aload_2
    //   45: invokestatic 1002	arf:a	(Ljava/io/Closeable;)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_0
    //   52: astore_2
    //   53: goto -9 -> 44
    //   56: astore_1
    //   57: goto -24 -> 33
    //   60: astore_1
    //   61: goto -37 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   0	10	21	android/content/pm/PackageManager$NameNotFoundException
    //   0	10	30	java/io/IOException
    //   0	10	39	finally
    //   10	15	50	finally
    //   10	15	56	java/io/IOException
    //   10	15	60	android/content/pm/PackageManager$NameNotFoundException
  }

  public static void d(String paramString)
  {
    a(paramString, null, null);
  }

  public static boolean d(Context paramContext)
  {
    return ((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing());
  }

  public static boolean d(Context paramContext, Intent paramIntent)
  {
    try
    {
      if ((!(paramContext instanceof Activity)) && ((paramIntent.getFlags() & 0x10000000) == 0))
        paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.w("Swipe.Utils", "Failed to start activity: " + paramIntent, paramContext);
    }
    return false;
  }

  public static Object e(String paramString)
  {
    Class localClass = Class.forName("android.os.ServiceManager");
    paramString = (IBinder)localClass.getMethod("getService", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
    return Class.forName(paramString.getInterfaceDescriptor()).getClasses()[0].getMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { paramString });
  }

  public static String e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static List<String> e(Context paramContext)
  {
    try
    {
      paramContext = ((SwipeApplication)paramContext.getApplicationContext()).a().a.b();
      return paramContext;
    }
    catch (Exception paramContext)
    {
    }
    return new ArrayList(0);
  }

  public static boolean e()
  {
    boolean bool = false;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null)
        bool = true;
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static Intent f(String paramString)
  {
    return new Intent(paramString).addFlags(270532608);
  }

  public static Drawable f(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, null);
  }

  public static void f(Context paramContext)
  {
    Intent localIntent = d();
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static boolean f()
  {
    return Camera.getNumberOfCameras() > 0;
  }

  public static void g()
  {
    d("toggleRecentApps");
  }

  public static boolean g(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addFlags(268468224);
      localIntent.setComponent(new ComponentName("com.lazyswipe.lock", "com.qigame.dockonelock.StartMainActivity"));
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static boolean g(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true, false);
  }

  public static boolean g(String paramString)
  {
    return a(Locale.getDefault().getLanguage(), paramString);
  }

  public static ComponentName h(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(a(paramString), 0).iterator();
    while (paramContext.hasNext())
    {
      paramString = (ResolveInfo)paramContext.next();
      if (paramString != null)
        return a(paramString);
    }
    return null;
  }

  public static Map<String, String> h(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = Collections.emptyMap();
    String[] arrayOfString;
    HashMap localHashMap;
    int j;
    int i;
    do
    {
      return paramString;
      arrayOfString = paramString.split("&");
      localHashMap = new HashMap(arrayOfString.length);
      j = arrayOfString.length;
      i = 0;
      paramString = localHashMap;
    }
    while (i >= j);
    paramString = arrayOfString[i];
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      i += 1;
      break;
      paramString = paramString.split("=");
      if (paramString.length == 2)
        localHashMap.put(paramString[0].trim(), paramString[1].trim());
    }
  }

  public static void h()
  {
    d("expandNotificationsPanel");
  }

  public static boolean h(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.lazyswipe.lock", 0);
      return true;
    }
    catch (NameNotFoundException paramContext)
    {
    }
    return false;
  }

  public static Intent i()
  {
    return f("android.settings.SETTINGS");
  }

  public static Intent i(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(Uri.parse("mailto:"));
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
    return localIntent;
  }

  public static void i(Context paramContext, String paramString)
  {
    paramString = c(paramString);
    paramString.addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE").putExtra("com.android.browser.application_id", "com.lazyswipe");
    d(paramContext, paramString);
  }

  public static boolean i(Context paramContext)
  {
    return c(paramContext, "com.lazyswipe.lock", "com.qigame.dockonelock.DeviceAdmin");
  }

  public static String j()
  {
    Locale localLocale = Locale.getDefault();
    return localLocale.getLanguage() + "_" + localLocale.getCountry();
  }

  public static void j(Context paramContext)
  {
    final File localFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "com.hola.launcher.apk");
    new atc(paramContext, paramContext.getString(2131231245), localFile, "http://a.holaworld.cn/clients/latest?pid=300102&channel=90004", null, new asz(), new atd()
    {
      public void a(int paramAnonymousInt)
      {
      }

      public void b()
      {
        asq.a(asq.this, localFile);
      }

      public void r_()
      {
      }
    }).a();
  }

  public static boolean j(Context paramContext, String paramString)
  {
    Intent localIntent = a(paramString);
    if (d(paramContext, localIntent))
      return true;
    paramString = h(paramContext, paramString);
    if (paramString != null)
    {
      localIntent.setClassName(paramString.getPackageName(), paramString.getClassName());
      localIntent.addFlags(268435456);
      return d(paramContext, localIntent);
    }
    return false;
  }

  public static String k()
  {
    return Locale.getDefault().getLanguage();
  }

  public static boolean k(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0) != null;
  }

  public static boolean k(Context paramContext, String paramString)
  {
    return d(paramContext, f(paramString));
  }

  public static int l(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness_mode", 0);
  }

  public static RunningServiceInfo l(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        RunningServiceInfo localRunningServiceInfo = (RunningServiceInfo)paramContext.next();
        if (paramString.equals(localRunningServiceInfo.service.getClassName()))
          return localRunningServiceInfo;
      }
    }
    return null;
  }

  public static boolean l()
  {
    return g(Locale.CHINESE.getLanguage());
  }

  public static int m(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "screen_brightness", 124);
  }

  public static String m()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  public static boolean m(Context paramContext, String paramString)
  {
    return l(paramContext, paramString) != null;
  }

  public static boolean n()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }

  public static boolean n(Context paramContext)
  {
    return k(paramContext, "android.settings.SETTINGS");
  }

  public static boolean n(Context paramContext, String paramString)
  {
    paramContext = l(paramContext, paramString);
    return (paramContext != null) && (paramContext.crashCount <= 0);
  }

  public static int o()
  {
    try
    {
      int i = "com.lazyswipe".split("\\.").length;
      return i;
    }
    catch (Exception localException)
    {
    }
    return 2;
  }

  public static long o(Context paramContext, String paramString)
  {
    try
    {
      long l = new File(paramContext.getPackageManager().getApplicationInfo(paramString, 0).sourceDir).lastModified();
      return l;
    }
    catch (Throwable paramContext)
    {
      Log.w("Swipe.Utils", "Could not get the last update time", paramContext);
    }
    return 0L;
  }

  public static Vibrator o(Context paramContext)
  {
    try
    {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      if (paramContext != null)
      {
        boolean bool = paramContext.hasVibrator();
        if (bool)
          return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static String p(Context paramContext, String paramString)
  {
    paramContext = vs.u(paramContext);
    if (TextUtils.isEmpty(paramContext))
      return paramString;
    return paramString + "&uid=" + paramContext;
  }

  public static boolean p()
  {
    try
    {
      int i = "com.lazyswipe".length();
      return i == 13;
    }
    catch (Exception localException)
    {
    }
    return true;
  }

  public static boolean p(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "haptic_feedback_enabled", 0);
      if (i != 0)
        bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
    }
    return false;
  }

  public static AssetManager q(Context paramContext, String paramString)
  {
    if (paramString == null)
      return paramContext.getAssets();
    return paramContext.createPackageContext(paramString, 0).getAssets();
  }

  public static String q()
  {
    return "qQ1";
  }

  public static boolean q(Context paramContext)
  {
    return a(paramContext, true);
  }

  public static int r()
  {
    return 6;
  }

  public static <T> T r(Context paramContext, String paramString)
  {
    return paramContext.getSystemService(paramString);
  }

  @TargetApi(16)
  public static boolean r(Context paramContext)
  {
    paramContext = (KeyguardManager)paramContext.getSystemService("keyguard");
    if (Build.VERSION.SDK_INT >= 16)
      return paramContext.isKeyguardLocked();
    return paramContext.inKeyguardRestrictedInputMode();
  }

  private static Object s(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null, null);
  }

  public static String s()
  {
    return "com.lazyswipe_preferences";
  }

  @TargetApi(16)
  public static boolean s(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return ((KeyguardManager)paramContext.getSystemService("keyguard")).isKeyguardSecure();
    paramContext = s(paramContext, "isSecure");
    if (paramContext != null)
      return ((Boolean)paramContext).booleanValue();
    return false;
  }

  public static void t(Context paramContext)
  {
    if (r(paramContext))
    {
      if (s(paramContext))
        aso.a(paramContext, 2131231151, true);
    }
    else
      return;
    DismissKeyguardActivity.a(paramContext);
  }

  public static Drawable u(Context paramContext)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(-16732929);
    paramContext = new LayerDrawable(new Drawable[] { localColorDrawable, paramContext.getResources().getDrawable(2130837803) });
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramContext);
    localStateListDrawable.addState(new int[0], localColorDrawable);
    return localStateListDrawable;
  }

  public static Map<String, String> v(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", vs.u(paramContext));
    localHashMap.put("pkg", "com.lazyswipe");
    localHashMap.put("ver", String.valueOf(22500));
    localHashMap.put("pid", "300105");
    localHashMap.put("cid", "26100");
    localHashMap.put("vid", "00");
    localHashMap.put("lang", URLEncoder.encode(j()));
    localHashMap.put("osVer", String.valueOf(aqr.c()));
    localHashMap.put("w", String.valueOf(aqs.ae()));
    localHashMap.put("h", String.valueOf(aqs.af()));
    localHashMap.put("dpi", String.valueOf(aqr.d(paramContext)));
    return localHashMap;
  }

  public static int w(Context paramContext)
  {
    int i;
    try
    {
      if ("1".equals(aqs.a("qemu.hw.mainkeys")))
        return 0;
      i = paramContext.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
      if (!paramContext.getResources().getBoolean(i))
      {
        Log.e("Swipe.Utils", "There is no navigation bar.");
        return 0;
      }
    }
    catch (Throwable paramContext)
    {
      return 0;
    }
    try
    {
      i = paramContext.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Throwable paramContext)
    {
    }
    return 0;
  }

  public static List<ResolveInfo> x(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    Intent localIntent = c();
    try
    {
      List localList = paramContext.queryIntentActivities(localIntent, 0);
      return localList;
    }
    catch (Exception localException1)
    {
      Object localObject = paramContext.getInstalledPackages(0);
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        try
        {
          localIntent.setPackage(localPackageInfo.packageName);
          localArrayList.addAll(paramContext.queryIntentActivities(localIntent, 0));
        }
        catch (Exception localException2)
        {
        }
      }
      return localArrayList;
    }
  }

  public static void y(Context paramContext)
  {
    try
    {
      paramContext.startActivity(c("fb://page/910557125654657").setClassName("com.facebook.katana", "com.facebook.katana.IntentUriHandler"));
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramContext.startActivity(c("http://www.facebook.com/holaverse"));
        return;
      }
      catch (Exception paramContext)
      {
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asq
 * JD-Core Version:    0.6.2
 */