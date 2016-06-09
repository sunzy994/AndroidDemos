package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class wt
{
  private static final String a = "Swipe." + wt.class.getSimpleName();

  public static List<wk> a(int paramInt)
  {
    return SwipeApplication.c().a().b(paramInt);
  }

  public static void a()
  {
    List localList = b();
    localList.remove("com.lazyswipe");
    wm localwm = SwipeApplication.c().a();
    int i = 0;
    if (i < localList.size())
    {
      wk localwk = localwm.a((String)localList.get(i));
      if ((localwk == null) || (localwk.e > 0L));
      while (true)
      {
        i += 1;
        break;
        localwk.e = (System.currentTimeMillis() - i * 10);
        localwm.b(localwk);
      }
    }
  }

  public static List<String> b()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 21)
        return c();
      List localList = d();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Log.w(a, "Could not get running packages", localThrowable);
    }
    return new ArrayList(0);
  }

  private static List<String> c()
  {
    Object localObject = ((ActivityManager)SwipeApplication.c().getSystemService("activity")).getRecentTasks(2147483647, 2);
    if (localObject == null)
      return new ArrayList(0);
    TreeSet localTreeSet = new TreeSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecentTaskInfo localRecentTaskInfo = (RecentTaskInfo)((Iterator)localObject).next();
      try
      {
        localTreeSet.add(localRecentTaskInfo.baseIntent.getComponent().getPackageName());
      }
      catch (Throwable localThrowable)
      {
      }
    }
    return new ArrayList(localTreeSet);
  }

  @TargetApi(21)
  private static List<String> d()
  {
    Object localObject1 = ((ActivityManager)SwipeApplication.c().getSystemService("activity")).getRunningAppProcesses();
    if (localObject1 == null)
      return new ArrayList(0);
    Object localObject2 = new ArrayList((Collection)localObject1);
    Collections.sort((List)localObject2, new Comparator()
    {
      public int a(RunningAppProcessInfo paramAnonymousRunningAppProcessInfo1, RunningAppProcessInfo paramAnonymousRunningAppProcessInfo2)
      {
        int i = paramAnonymousRunningAppProcessInfo1.importance;
        int j = paramAnonymousRunningAppProcessInfo2.importance;
        if (i > j)
          return -1;
        if (i == j)
          return 0;
        return 1;
      }
    });
    localObject1 = new TreeSet();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RunningAppProcessInfo localRunningAppProcessInfo = (RunningAppProcessInfo)((Iterator)localObject2).next();
      try
      {
        Collections.addAll((Collection)localObject1, localRunningAppProcessInfo.pkgList);
      }
      catch (Throwable localThrowable)
      {
      }
    }
    return new ArrayList((Collection)localObject1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wt
 * JD-Core Version:    0.6.2
 */