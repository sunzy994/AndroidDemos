package cmcm.com.myapplication;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.provider.Settings.Secure;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.util.PsProcess;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class acn extends AsyncTask<Context, List<acl>, List<acl>>
{
  private static final String a = "Swipe." + acn.class.getSimpleName();
  private Set<String> b = new HashSet();

  public acn(Set<String> paramSet)
  {
    this.b = paramSet;
  }

  private acl a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (paramString.equals("com.lazyswipe"));
    while (true)
    {
      return null;
      if ((!paramString.equals("com.hola.screenlock")) && (!paramString.startsWith("com.hola.launcher.plugin.")) && (!paramString.equals("com.hola.launcher")) && (!paramString.equals("android")))
      {
        acl localacl = new acl();
        localacl.a = paramString;
        PackageManager localPackageManager = SwipeApplication.c().getPackageManager();
        try
        {
          ApplicationInfo localApplicationInfo = localPackageManager.getPackageInfo(paramString, 0).applicationInfo;
          if ((localApplicationInfo.flags & 0x1) != 0)
            bool = true;
          localacl.e = bool;
          if (!localacl.e)
          {
            localacl.b = new apd(atw.a(localApplicationInfo.loadIcon(localPackageManager), paramContext));
            localacl.c = localApplicationInfo.loadLabel(localPackageManager).toString();
            localacl.f = this.b.contains(paramString);
            return localacl;
          }
        }
        catch (Throwable paramContext)
        {
        }
      }
    }
    return null;
  }

  private boolean a(HashMap<String, acl> paramHashMap, List<acl> paramList, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = ase.e();
    if (localObject != null)
    {
      HashSet localHashSet = new HashSet();
      if (paramString1 != null)
        localHashSet.add(paramString1);
      paramString1 = ((List)localObject).iterator();
      String str;
      while (paramString1.hasNext())
      {
        str = ((PsProcess)paramString1.next()).a();
        if ((str != null) && (paramString2.startsWith(str)))
          localHashSet.add(str);
      }
      localHashSet.removeAll(asq.e(paramContext));
      localHashSet.add("com.lazyswipe.pro2");
      paramString2 = ((List)localObject).iterator();
      label273: 
      while (paramString2.hasNext())
      {
        localObject = (PsProcess)paramString2.next();
        str = ((PsProcess)localObject).a();
        if (isCancelled())
          return true;
        if (!localHashSet.contains(str))
        {
          if (paramHashMap.containsKey(str))
            paramString1 = (acl)paramHashMap.get(str);
          while (true)
          {
            if (paramString1.g.contains(Integer.valueOf(((PsProcess)localObject).c)))
              break label273;
            paramString1.g.add(Integer.valueOf(((PsProcess)localObject).c));
            break;
            paramString1 = a(paramContext, str);
            if (paramString1 == null)
              break;
            paramHashMap.put(str, paramString1);
            paramList.add(paramString1);
          }
        }
      }
    }
    return false;
  }

  private boolean b(HashMap<String, acl> paramHashMap, List<acl> paramList, Context paramContext, String paramString1, String paramString2)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    Object localObject1 = localActivityManager.getRunningAppProcesses();
    if (localObject1 != null)
    {
      HashSet localHashSet = new HashSet();
      if (paramString1 != null)
        localHashSet.add(paramString1);
      paramString1 = ((List)localObject1).iterator();
      Object localObject2;
      while (paramString1.hasNext())
      {
        localObject2 = (RunningAppProcessInfo)paramString1.next();
        if ((((RunningAppProcessInfo)localObject2).pkgList != null) && ((paramString2.startsWith(((RunningAppProcessInfo)localObject2).processName)) || (((RunningAppProcessInfo)localObject2).importance < 300)))
          localHashSet.addAll(Arrays.asList(((RunningAppProcessInfo)localObject2).pkgList));
      }
      localHashSet.removeAll(asq.e(paramContext));
      localHashSet.add("com.lazyswipe.pro2");
      paramString2 = ((List)localObject1).iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (RunningAppProcessInfo)paramString2.next();
        if (((RunningAppProcessInfo)localObject1).pkgList != null)
        {
          localObject2 = ((RunningAppProcessInfo)localObject1).pkgList;
          int k = localObject2.length;
          int i = 0;
          label205: Object localObject3;
          if (i < k)
          {
            localObject3 = localObject2[i];
            if (isCancelled())
              return true;
            if (!localHashSet.contains(localObject3))
              break label249;
          }
          label408: 
          while (true)
          {
            i += 1;
            break label205;
            break;
            label249: if (paramHashMap.containsKey(localObject3))
              paramString1 = (acl)paramHashMap.get(localObject3);
            while (true)
            {
              if (paramString1.g.contains(Integer.valueOf(((RunningAppProcessInfo)localObject1).pid)))
                break label408;
              paramString1.g.add(Integer.valueOf(((RunningAppProcessInfo)localObject1).pid));
              localObject3 = localActivityManager.getProcessMemoryInfo(new int[] { ((RunningAppProcessInfo)localObject1).pid });
              int m = localObject3.length;
              int j = 0;
              while (j < m)
              {
                Object localObject4 = localObject3[j];
                paramString1.d += localObject4.getTotalPrivateDirty();
                j += 1;
              }
              break;
              paramString1 = a(paramContext, (String)localObject3);
              if (paramString1 == null)
                break;
              paramHashMap.put(localObject3, paramString1);
              paramList.add(paramString1);
            }
          }
        }
      }
    }
    return false;
  }

  protected List<acl> a(Context[] paramArrayOfContext)
  {
    while (true)
    {
      try
      {
        localObject1 = Settings.Secure.getString(paramArrayOfContext[0].getContentResolver(), "default_input_method");
        localObject3 = localObject1;
        if (localObject1 == null)
          localObject3 = "";
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Object localObject1 = WallpaperManager.getInstance(paramArrayOfContext[0]).getWallpaperInfo();
          if (localObject1 != null)
          {
            localObject1 = ((WallpaperInfo)localObject1).getPackageName();
            localHashMap = new HashMap();
            localArrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21)
            {
              if (!a(localHashMap, localArrayList, paramArrayOfContext[0], (String)localObject1, (String)localObject3))
                continue;
              return null;
              localThrowable1 = localThrowable1;
              Object localObject2 = null;
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3;
          HashMap localHashMap;
          ArrayList localArrayList;
          Log.e(a, "WallpaperManager failed", localThrowable2);
          str = null;
          continue;
          if (b(localHashMap, localArrayList, paramArrayOfContext[0], str, (String)localObject3))
            continue;
          Collections.sort(localArrayList, new Comparator()
          {
            public int a(acl paramAnonymousacl1, acl paramAnonymousacl2)
            {
              if (paramAnonymousacl1.f != paramAnonymousacl2.f)
              {
                if (paramAnonymousacl1.f)
                  return 1;
                return -1;
              }
              return asq.a.compare(paramAnonymousacl1.c, paramAnonymousacl2.c);
            }
          });
          publishProgress(new List[] { new ArrayList(localArrayList) });
          return localArrayList;
        }
      }
      String str = null;
    }
  }

  public void a(ArrayList<acl> paramArrayList)
  {
  }

  public void a(List<acl> paramList)
  {
  }

  protected void a(List<acl>[] paramArrayOfList)
  {
    if (isCancelled())
      return;
    a(new ArrayList(paramArrayOfList[0]));
  }

  protected void b(List<acl> paramList)
  {
    a(paramList);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acn
 * JD-Core Version:    0.6.2
 */