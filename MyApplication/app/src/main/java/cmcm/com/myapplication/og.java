package cmcm.com.myapplication;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.hola.alliance.AppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class og
{
  private static final List<String> a = new ArrayList(Arrays.asList(new String[] { "com.lazyswipe", "com.hola.launcher", "com.qiigame.flocker.global", "com.autumn.privacyace" }));
  private static Thread b;
  private static boolean c;

  public static int a()
  {
    return 1;
  }

  private static AppInfo a(Context paramContext)
  {
    AppInfo localAppInfo = new AppInfo();
    localAppInfo.a = paramContext.getPackageName();
    localAppInfo.b = a();
    return localAppInfo;
  }

  public static AppInfo a(Intent paramIntent)
  {
    if (paramIntent != null);
    try
    {
      paramIntent = (AppInfo)paramIntent.getParcelableExtra("source_info");
      if (paramIntent != null)
        return paramIntent;
      return null;
    }
    catch (Exception paramIntent)
    {
      oh.a("Alliance", "Error happens.", paramIntent);
    }
    return null;
  }

  public static void a(Context paramContext, final oi paramoi)
  {
    if (b != null)
      return;
    b = new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject1 = og.this.getPackageName();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ArrayList localArrayList = new ArrayList(og.b());
            if (!og.c())
              localArrayList.remove(localObject1);
            localObject1 = new ok(localArrayList);
            og.a(og.this, (ok)localObject1, paramoi);
          }
          return;
        }
        catch (Exception localException)
        {
          oh.a("Alliance", "Error happens.", localException);
          return;
        }
        finally
        {
          og.a(null);
        }
      }
    };
    b.start();
  }

  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
    oh.a = paramBoolean;
  }

  private static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext == null)
      {
        oh.a("Alliance", "app " + paramString + " uninstall!");
        return false;
      }
    }
    catch (NameNotFoundException paramContext)
    {
      while (true)
        paramContext = null;
      oh.a("Alliance", "app " + paramString + " install!");
    }
    return true;
  }

  private static boolean a(Set<String> paramSet, String paramString)
  {
    try
    {
      if (paramSet.contains(paramString))
      {
        oh.a("Alliance", "app " + paramString + " running!");
        return true;
      }
      oh.a("Alliance", "app " + paramString + " not running!");
      return false;
    }
    catch (Exception paramSet)
    {
      oh.a("Alliance", "Error happens.", paramSet);
    }
    return false;
  }

  private static void b(Context paramContext, ok paramok, oi paramoi)
  {
    if ((paramContext == null) || (paramok == null))
      return;
    HashSet localHashSet;
    Object localObject2;
    try
    {
      paramContext = paramContext.getApplicationContext();
      localObject1 = ol.a(paramContext);
      localHashSet = new HashSet();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if (((ActivityManager.RunningAppProcessInfo)localObject2).pkgList != null)
            localHashSet.addAll(Arrays.asList(((ActivityManager.RunningAppProcessInfo)localObject2).pkgList));
        }
      }
    }
    catch (Exception paramContext)
    {
      oh.a("Alliance", "Error happens.", paramContext);
      return;
    }
    Object localObject1 = new oj();
    int i;
    if ((paramok.a != null) && (paramok.a.size() > 0))
    {
      i = 0;
      localObject2 = paramok.a.iterator();
    }
    label363: label366: 
    while (true)
    {
      String str1;
      if (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty(str1)) || (!a(paramContext, str1)))
          break label363;
        boolean bool = a(localHashSet, str1);
        if (bool)
          break label363;
      }
      while (true)
      {
        try
        {
          String str2 = str1 + ".action.AllianceService";
          Intent localIntent = new Intent(str2);
          localIntent.setPackage(str1);
          AppInfo localAppInfo = a(paramContext);
          if (localAppInfo != null)
            localIntent.putExtra("source_info", localAppInfo);
          oh.a("Alliance", "start Service: " + str2);
          paramContext.startService(localIntent);
          ((oj)localObject1).a.add(str1);
          i += 1;
          if ((paramok.b <= 0) || (i < paramok.b))
            break label366;
          if (paramoi == null)
            break;
          paramoi.a((oj)localObject1);
          return;
        }
        catch (Throwable localThrowable)
        {
          oh.a("Alliance", "Failed to start service.", localThrowable);
        }
        if (paramoi == null)
          break;
        paramoi.a((oj)localObject1);
        return;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     og
 * JD-Core Version:    0.6.2
 */