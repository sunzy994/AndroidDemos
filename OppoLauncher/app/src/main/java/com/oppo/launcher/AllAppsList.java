package com.oppo.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AllAppsList
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_APPLICATIONS_NUMBER = 42;
  public static final int RECENT_TASK_NUMBER = 15;
  private static final String TAG = "AllAppsList";
  public ArrayList<ApplicationInfo> added = new ArrayList(42);
  public ArrayList<String> appwidgetPackageList = new ArrayList();
  public ArrayList<ApplicationInfo> data = new ArrayList(42);
  public ArrayList<ApplicationInfo> databaseData = new ArrayList();
  private IconCache mIconCache;
  private LruCache<String, ApplicationInfo> mRecentClickedAppInfoCache = new LruCache(15);
  public ArrayList<ApplicationInfo> modified = new ArrayList();
  public ArrayList<ApplicationInfo> removed = new ArrayList();

  public AllAppsList(IconCache paramIconCache)
  {
    this.mIconCache = paramIconCache;
  }

  public static List<ResolveInfo> findActivitiesForPackage(Context paramContext, String paramString)
  {
    Intent localIntent = null;
    if (paramString == null)
      paramContext = localIntent;
    do
    {
      return paramContext;
      paramContext = paramContext.getPackageManager();
      localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString);
      paramString = paramContext.queryIntentActivities(localIntent, 0);
      paramContext = paramString;
    }
    while (paramString != null);
    return new ArrayList();
  }

  private static boolean findActivity(ArrayList<ApplicationInfo> paramArrayList, ComponentName paramComponentName)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
      if (((ApplicationInfo)paramArrayList.next()).componentName.equals(paramComponentName))
        return true;
    return false;
  }

  private static boolean findActivity(List<ResolveInfo> paramList, ComponentName paramComponentName)
  {
    paramComponentName = paramComponentName.getClassName();
    paramList = paramList.iterator();
    while (paramList.hasNext())
      if (((ResolveInfo)paramList.next()).activityInfo.name.equals(paramComponentName))
        return true;
    return false;
  }

  private ArrayList<ApplicationInfo> findApplicationByPackageName(ArrayList<ApplicationInfo> paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)paramArrayList.next();
      if (localApplicationInfo.componentName.getPackageName().equals(paramString))
        localArrayList.add(localApplicationInfo);
    }
    return localArrayList;
  }

  private boolean updateInstallPositionIfNeed(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    boolean bool2 = false;
    Iterator localIterator = this.data.iterator();
    ApplicationInfo localApplicationInfo;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext())
        break;
      localApplicationInfo = (ApplicationInfo)localIterator.next();
    }
    while ((!localApplicationInfo.componentName.equals(paramApplicationInfo.componentName)) || (localApplicationInfo.installedLocation == paramApplicationInfo.installedLocation));
    localApplicationInfo.installedLocation = paramApplicationInfo.installedLocation;
    if ((localApplicationInfo.installedLocation == 0) && (localApplicationInfo.isAppUnavailable()))
      localApplicationInfo.updateAppUnavailableFlag(paramContext);
    boolean bool1 = true;
    return bool1;
  }

  public boolean add(ApplicationInfo paramApplicationInfo)
  {
    try
    {
      boolean bool = findActivity(this.data, paramApplicationInfo.componentName);
      if (bool);
      for (bool = false; ; bool = true)
      {
        return bool;
        this.data.add(paramApplicationInfo);
        this.added.add(paramApplicationInfo);
        if (LauncherUtil.DEBUG_FANCY_ICON)
          Log.d("AllAppsList", "debugFancyIcon, add = " + paramApplicationInfo.componentName);
      }
    }
    finally
    {
    }
    throw paramApplicationInfo;
  }

  public void addFromDB(ApplicationInfo paramApplicationInfo)
  {
    try
    {
      boolean bool = findActivity(this.data, paramApplicationInfo.componentName);
      if (bool);
      while (true)
      {
        return;
        this.data.add(paramApplicationInfo);
        Collections.sort(this.data, LauncherModel.APP_PACKAGE_CLASS_NAME_COMPARATOR);
      }
    }
    finally
    {
    }
    throw paramApplicationInfo;
  }

  public void addPackage(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = findActivitiesForPackage(paramContext, paramString);
    if ((localObject == null) || (((List)localObject).size() <= 0))
      Log.w("AllAppsList", "addPackage --- matches.size() <= 0 return");
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
        ApplicationInfo localApplicationInfo = new ApplicationInfo(paramContext.getPackageManager(), localResolveInfo, this.mIconCache, null);
        if ((!Utilities.isAppHide(paramContext, paramString)) && (!localApplicationInfo.componentName.getClassName().equals("com.google.android.maps.driveabout.app.DestinationActivity")) && (!Utilities.isAppShouldHideForCMCC(paramContext, paramString)))
        {
          if ((localApplicationInfo.installedLocation == 1) && (!LauncherModel.isExternalAppAvailable()))
            LauncherModel.setExternalAppAvailable(true);
          if ((LauncherUtil.isThirdPartApp(localResolveInfo.activityInfo.applicationInfo)) && (!paramBoolean))
          {
            localApplicationInfo.newinstalled = 1;
            LauncherModelDataHelper.updateNewInstallItemsInDB(paramContext, localApplicationInfo);
          }
          if ((!add(localApplicationInfo)) && (updateInstallPositionIfNeed(paramContext, localApplicationInfo)))
          {
            this.modified.add(localApplicationInfo);
            if (LauncherUtil.DEBUG_FANCY_ICON)
              Log.d("AllAppsList", "debugFancyIcon, addPackage, modified = " + paramString);
          }
        }
      }
      Collections.sort(this.data, LauncherModel.APP_PACKAGE_CLASS_NAME_COMPARATOR);
    }
  }

  public void addToRecentClickedAppInfoCache(ApplicationInfo paramApplicationInfo)
  {
    if ((paramApplicationInfo != null) && (paramApplicationInfo.packageName != null))
      this.mRecentClickedAppInfoCache.put(paramApplicationInfo.packageName, paramApplicationInfo);
  }

  public void clear()
  {
    this.data.clear();
    this.added.clear();
    this.removed.clear();
    this.modified.clear();
    if (LauncherUtil.DEBUG_FANCY_ICON)
      Log.d("AllAppsList", "debugFancyIcon, clear, all is empty now");
    this.databaseData.clear();
    this.mRecentClickedAppInfoCache.evictAll();
  }

  public ApplicationInfo findApplicationInfoLocked(String paramString1, String paramString2)
  {
    Iterator localIterator = this.data.iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      ComponentName localComponentName = localApplicationInfo.intent.getComponent();
      if ((paramString1.equals(localComponentName.getPackageName())) && (paramString2.equals(localComponentName.getClassName())))
        return localApplicationInfo;
    }
    return null;
  }

  public ApplicationInfo get(int paramInt)
  {
    return (ApplicationInfo)this.data.get(paramInt);
  }

  public ApplicationInfo getAppInfoFromRecentClickedAppInfoCache(String paramString)
  {
    return (ApplicationInfo)this.mRecentClickedAppInfoCache.get(paramString);
  }

  public void removePackage(Context paramContext, String paramString)
  {
    while (true)
    {
      int i;
      try
      {
        ArrayList localArrayList = this.data;
        int j = 0;
        i = localArrayList.size() - 1;
        if (i >= 0)
        {
          ApplicationInfo localApplicationInfo = (ApplicationInfo)localArrayList.get(i);
          ComponentName localComponentName = localApplicationInfo.intent.getComponent();
          if (paramString.equals(localComponentName.getPackageName()))
          {
            this.removed.add(localApplicationInfo);
            localArrayList.remove(i);
            j = 1;
            if (LauncherUtil.DEBUG_FANCY_ICON)
              Log.d("AllAppsList", "debugFancyIcon, removePackage, addremoved = " + paramString);
            this.mIconCache.remove(localComponentName);
            LauncherModelDataHelper.deleteNewInstallItemsFromDB(paramContext, localApplicationInfo);
          }
        }
        else
        {
          this.mRecentClickedAppInfoCache.remove(paramString);
          if (j == 0)
            this.appwidgetPackageList.add(paramString);
          Log.d("AllAppsList", "removePackage, flushNormalIcons now!");
          this.mIconCache.flushNormalIcons();
          return;
        }
      }
      finally
      {
      }
      i -= 1;
    }
  }

  public int size()
  {
    return this.data.size();
  }

  public void updateAppNewInstallFlag(Context paramContext, String paramString)
  {
    if (paramString == null);
    while (true)
    {
      int i;
      try
      {
        Log.e("AllAppsList", "updateAppNewInstallFlag ---> packageName = null, return. ");
        return;
        i = this.data.size() - 1;
        if (i < 0)
          continue;
        ApplicationInfo localApplicationInfo = (ApplicationInfo)this.data.get(i);
        ComponentName localComponentName = localApplicationInfo.intent.getComponent();
        if (localComponentName == null)
        {
          Log.e("AllAppsList", "updateAppNewInstallFlag ---> component = null, continue. applicationInfo.intent = " + localApplicationInfo.intent);
        }
        else if ((localApplicationInfo.newinstalled == 1) && (paramString.equals(localComponentName.getPackageName())))
        {
          localApplicationInfo.newinstalled = 0;
          this.modified.add(localApplicationInfo);
          LauncherModelDataHelper.deleteNewInstallItemsFromDB(paramContext, localApplicationInfo);
        }
      }
      finally
      {
      }
      i -= 1;
    }
  }

  public void updateAppUnavailableFlag(Context paramContext, String paramString)
  {
    try
    {
      int i = this.data.size() - 1;
      while (i >= 0)
      {
        ApplicationInfo localApplicationInfo = (ApplicationInfo)this.data.get(i);
        ComponentName localComponentName = localApplicationInfo.intent.getComponent();
        if ((paramString != null) && (localComponentName != null) && (paramString.equals(localComponentName.getPackageName())))
        {
          localApplicationInfo.updateAppUnavailableFlag(paramContext);
          if (LauncherUtil.DEBUG_FANCY_ICON)
            Log.d("AllAppsList", "debugFancyIcon, updateAppUnavailableFlag, modified = " + paramString);
          this.modified.add(localApplicationInfo);
        }
        i -= 1;
      }
      return;
    }
    finally
    {
    }
    throw paramContext;
  }

  public void updatePackage(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject3;
    while (true)
    {
      ApplicationInfo localApplicationInfo;
      try
      {
        localObject1 = findActivitiesForPackage(paramContext, paramString);
        Log.d("AllAppsList", "updatePackage ---> packageName = " + paramString + "---> matches.size() = " + ((List)localObject1).size());
        if (((List)localObject1).size() <= 0)
          break label589;
        localObject2 = findApplicationByPackageName(this.data, paramString);
        localObject3 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext())
          break;
        localApplicationInfo = (ApplicationInfo)((Iterator)localObject3).next();
        if (findActivity((List)localObject1, localApplicationInfo.componentName))
          continue;
        if ((((List)localObject1).size() == 1) && (((ArrayList)localObject2).size() == 1))
        {
          Object localObject4 = (ResolveInfo)((List)localObject1).get(0);
          localApplicationInfo = (ApplicationInfo)((ArrayList)localObject2).get(0);
          if (localApplicationInfo == null)
            continue;
          localObject4 = LauncherModel.getComponentNameFromResolveInfo((ResolveInfo)localObject4);
          localApplicationInfo.componentName = ((ComponentName)localObject4);
          localApplicationInfo.intent.setComponent((ComponentName)localObject4);
          if (localObject4 == null)
            continue;
          localApplicationInfo.packageName = ((ComponentName)localObject4).getPackageName();
          localApplicationInfo.className = ((ComponentName)localObject4).getClassName();
          continue;
        }
      }
      finally
      {
      }
      this.removed.add(localApplicationInfo);
      if (LauncherUtil.DEBUG_FANCY_ICON)
        Log.d("AllAppsList", "debugFancyIcon, updatePackage, addremove = " + localApplicationInfo.componentName);
      this.mIconCache.remove(localApplicationInfo.componentName);
      this.data.remove(localApplicationInfo);
      this.mRecentClickedAppInfoCache.remove(paramString);
    }
    int i = 0;
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ResolveInfo)((Iterator)localObject2).next();
      localObject1 = findApplicationInfoLocked(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName, ((ResolveInfo)localObject3).activityInfo.name);
      if ((!Utilities.isAppHide(paramContext, paramString)) && (!((ResolveInfo)localObject3).activityInfo.name.equals("com.google.android.maps.driveabout.app.DestinationActivity")) && (!Utilities.isAppShouldHideForCMCC(paramContext, paramString)))
      {
        if (localObject1 == null)
        {
          localObject1 = new ApplicationInfo(paramContext.getPackageManager(), (ResolveInfo)localObject3, this.mIconCache, null);
          add((ApplicationInfo)localObject1);
        }
        for (int j = 1; ; j = i)
        {
          i = j;
          if (!LauncherUtil.isThirdPartApp(((ResolveInfo)localObject3).activityInfo.applicationInfo))
            break;
          i = j;
          if (paramBoolean1)
            break;
          i = j;
          if (!paramBoolean2)
            break;
          ((ApplicationInfo)localObject1).newinstalled = 1;
          LauncherModelDataHelper.updateNewInstallItemsInDB(paramContext, (ApplicationInfo)localObject1);
          i = j;
          break;
          if (LauncherUtil.DEBUG_FANCY_ICON)
            Log.d("AllAppsList", "debugFancyIcon, updatePackage, modified = " + ((ApplicationInfo)localObject1).componentName);
          this.mIconCache.remove(((ApplicationInfo)localObject1).componentName);
          ((ApplicationInfo)localObject1).updateResolveInfo((ResolveInfo)localObject3);
          ((ApplicationInfo)localObject1).initInstalledLocation(paramContext.getPackageManager());
          this.mIconCache.getTitleAndIcon((ApplicationInfo)localObject1);
          this.modified.add(localObject1);
        }
      }
    }
    if (i != 0)
      Collections.sort(this.data, LauncherModel.APP_PACKAGE_CLASS_NAME_COMPARATOR);
    while (true)
    {
      return;
      label589: i = this.data.size() - 1;
      while (i >= 0)
      {
        paramContext = (ApplicationInfo)this.data.get(i);
        localObject1 = paramContext.intent.getComponent();
        if (paramString.equals(((ComponentName)localObject1).getPackageName()))
        {
          this.removed.add(paramContext);
          if (LauncherUtil.DEBUG_FANCY_ICON)
            Log.d("AllAppsList", "debugFancyIcon, updatePackage, matches.size() ==0,addremove = " + paramContext.componentName);
          this.mIconCache.remove((ComponentName)localObject1);
          this.data.remove(i);
          this.mRecentClickedAppInfoCache.remove(paramString);
        }
        i -= 1;
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.AllAppsList
 * JD-Core Version:    0.6.2
 */