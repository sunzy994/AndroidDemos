package com.oppo.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.color.uiengine.AppsIconsHelper;
import com.oppo.launcher.theme.ThemeUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class IconCache
{
  private static final boolean DEBUG_ENABLE = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final boolean DEBUG_TITLE_ICON = DEBUG_ENABLE;
  private static final int INITIAL_ICON_CACHE_CAPACITY = 50;
  private static final String TAG = "IconCache";
  private final HashMap<ComponentName, CacheEntry> mCache = new HashMap(50);
  private final LauncherApplication mContext;
  private final Bitmap mDefaultIcon;
  private int mIconDpi;
  private final PackageManager mPackageManager;

  public IconCache(LauncherApplication paramLauncherApplication)
  {
    this.mContext = paramLauncherApplication;
    this.mPackageManager = paramLauncherApplication.getPackageManager();
    int i = paramLauncherApplication.getResources().getDisplayMetrics().densityDpi;
    if (LauncherApplication.isScreenLarge())
      if (i == 120)
        this.mIconDpi = 160;
    while (true)
    {
      if (DEBUG_ENABLE)
        Log.d("IconCache", "IconCache, mIconDpi = " + this.mIconDpi);
      this.mDefaultIcon = makeDefaultIcon();
      return;
      if (i == 160)
      {
        this.mIconDpi = 240;
      }
      else if (i == 240)
      {
        this.mIconDpi = 320;
      }
      else if (i == 320)
      {
        this.mIconDpi = 320;
        continue;
        this.mIconDpi = paramLauncherApplication.getResources().getDisplayMetrics().densityDpi;
      }
    }
  }

  private CacheEntry cacheLocked(ComponentName paramComponentName, ResolveInfo paramResolveInfo, HashMap<Object, CharSequence> paramHashMap)
  {
    CacheEntry localCacheEntry2 = (CacheEntry)this.mCache.get(paramComponentName);
    if (DEBUG_TITLE_ICON)
      Log.d("IconCache", "cacheLocked entry--- componentName = " + paramComponentName + ", entry = " + localCacheEntry2);
    CacheEntry localCacheEntry1 = localCacheEntry2;
    boolean bool;
    if (localCacheEntry2 == null)
    {
      localCacheEntry1 = new CacheEntry(null);
      this.mCache.put(paramComponentName, localCacheEntry1);
      paramComponentName = LauncherModel.getComponentNameFromResolveInfo(paramResolveInfo);
      if ((paramHashMap == null) || (!paramHashMap.containsKey(paramComponentName)))
        break label333;
      localCacheEntry1.title = ((CharSequence)paramHashMap.get(paramComponentName)).toString();
      bool = LauncherUtil.isThirdPartApp(paramResolveInfo.activityInfo.applicationInfo);
      if ((DEBUG_TITLE_ICON) && (bool))
        Log.d("IconCache", "cacheLocked third part icon, applicationInfo = " + paramResolveInfo.activityInfo.applicationInfo + ", entry.title = " + localCacheEntry1.title);
      if (localCacheEntry1.title == null)
        localCacheEntry1.title = paramResolveInfo.activityInfo.name;
      localCacheEntry1.mIconsHelper = ThemeUtil.createAppsIconsHelper();
      if (localCacheEntry1.mIconsHelper == null)
        break label369;
      paramComponentName = localCacheEntry1.mIconsHelper.getIcon(this.mContext, paramResolveInfo.activityInfo, Utilities.getIconWidth(), Utilities.getIconWidth());
      localCacheEntry1.mIconsHelper.onResume();
    }
    while (true)
    {
      if (DEBUG_TITLE_ICON)
        Log.d("IconCache", "cacheLocked entry.title = " + localCacheEntry1.title + " drawable = " + paramComponentName);
      paramResolveInfo = paramComponentName;
      if ((paramComponentName instanceof BitmapDrawable))
        paramResolveInfo = new BitmapDrawable(Utilities.createIconBitmap(paramComponentName, this.mContext, bool));
      localCacheEntry1.icon = paramResolveInfo;
      return localCacheEntry1;
      label333: localCacheEntry1.title = paramResolveInfo.loadLabel(this.mPackageManager).toString();
      if (paramHashMap == null)
        break;
      paramHashMap.put(paramComponentName, localCacheEntry1.title);
      break;
      label369: paramComponentName = paramResolveInfo.activityInfo.loadIcon(this.mPackageManager);
    }
  }

  private Bitmap getApplicationBitmapIcon(Context paramContext, String paramString)
  {
    Object localObject = null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      android.content.pm.ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramString, 8192);
      paramContext = localObject;
      if (localApplicationInfo != null)
      {
        paramContext = ((BitmapDrawable)localApplicationInfo.loadIcon(localPackageManager)).getBitmap();
        int i = Utilities.getIconWidth();
        paramContext = Bitmap.createScaledBitmap(paramContext, i, i, true);
      }
      return paramContext;
    }
    catch (NameNotFoundException paramContext)
    {
      Log.e("IconCache", "getApplicationBitmapIcon --- e = " + paramContext);
      paramContext = this.mDefaultIcon;
      Log.w("IconCache", "getApplicationBitmapIcon -- " + paramString + ", icon = " + paramContext);
    }
    return paramContext;
  }

  private Bitmap makeDefaultIcon()
  {
    return Utilities.createIconBitmap(getFullResDefaultActivityIcon(), this.mContext);
  }

  public void flush()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.values().iterator();
      while (localIterator.hasNext())
      {
        CacheEntry localCacheEntry = (CacheEntry)localIterator.next();
        if ((localCacheEntry != null) && (localCacheEntry.mIconsHelper != null))
          localCacheEntry.mIconsHelper.cleanUp();
      }
    }
    this.mCache.clear();
    if (LauncherUtil.DEBUG_FANCY_ICON)
      Log.d("IconCache", "debugFancyIcon, flush", new Exception());
  }

  public void flushFancyIcons()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        CacheEntry localCacheEntry = (CacheEntry)((Map.Entry)localIterator.next()).getValue();
        if ((localCacheEntry != null) && (localCacheEntry.mIconsHelper != null) && (localCacheEntry.mIconsHelper.isFancyIcon()))
        {
          localCacheEntry.mIconsHelper.cleanUp();
          localIterator.remove();
        }
      }
    }
  }

  public void flushNormalIcons()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        CacheEntry localCacheEntry = (CacheEntry)((Map.Entry)localIterator.next()).getValue();
        if ((localCacheEntry == null) || (localCacheEntry.mIconsHelper == null) || (!localCacheEntry.mIconsHelper.isFancyIcon()))
          localIterator.remove();
      }
    }
  }

  public Bitmap getDefaultIcon()
  {
    return this.mDefaultIcon;
  }

  public Drawable getFullResDefaultActivityIcon()
  {
    return getFullResIcon(this.mContext.getResources(), 2130903040);
  }

  public Drawable getFullResIcon(ResolveInfo paramResolveInfo)
  {
    try
    {
      Resources localResources = this.mPackageManager.getResourcesForApplication(paramResolveInfo.activityInfo.applicationInfo);
      if (localResources != null)
      {
        int i = paramResolveInfo.activityInfo.getIconResource();
        if (i != 0)
          return getFullResIcon(localResources, i);
      }
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Object localObject = null;
    }
    return getFullResDefaultActivityIcon();
  }

  public Drawable getFullResIcon(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getDrawableForDensity(paramInt, this.mIconDpi);
      return paramResources;
    }
    catch (NotFoundException paramResources)
    {
      paramResources = this.mContext.getResources().getDrawable(2130837556);
      Log.w("IconCache", "getFullResIcon, Resources.NotFoundException d = " + paramResources);
    }
    return paramResources;
  }

  public Drawable getFullResIcon(String paramString, int paramInt)
  {
    try
    {
      paramString = this.mPackageManager.getResourcesForApplication(paramString);
      if ((paramString != null) && (paramInt != 0))
        return getFullResIcon(paramString, paramInt);
    }
    catch (NameNotFoundException paramString)
    {
      while (true)
        paramString = null;
    }
    return getFullResDefaultActivityIcon();
  }

  public Drawable getIcon(ComponentName paramComponentName, ResolveInfo paramResolveInfo, HashMap<Object, CharSequence> paramHashMap)
  {
    HashMap localHashMap = this.mCache;
    if ((paramResolveInfo == null) || (paramComponentName == null));
    try
    {
      paramComponentName = new BitmapDrawable(this.mDefaultIcon);
      return paramComponentName;
      paramComponentName = cacheLocked(paramComponentName, paramResolveInfo, paramHashMap).icon;
      return paramComponentName;
    }
    finally
    {
    }
    throw paramComponentName;
  }

  public Drawable getIcon(Intent paramIntent)
  {
    ResolveInfo localResolveInfo = this.mPackageManager.resolveActivity(paramIntent, 0);
    return getIcon(paramIntent.getComponent(), localResolveInfo, null);
  }

  public String getTitle(Intent paramIntent)
  {
    synchronized (this.mCache)
    {
      ResolveInfo localResolveInfo = this.mPackageManager.resolveActivity(paramIntent, 0);
      paramIntent = paramIntent.getComponent();
      if ((localResolveInfo == null) || (paramIntent == null))
        return null;
      paramIntent = cacheLocked(paramIntent, localResolveInfo, null).title;
      return paramIntent;
    }
  }

  public void getTitleAndIcon(ApplicationInfo paramApplicationInfo)
  {
    synchronized (this.mCache)
    {
      CacheEntry localCacheEntry = cacheLocked(paramApplicationInfo.componentName, paramApplicationInfo.mResolveInfo, null);
      paramApplicationInfo.setIcon(localCacheEntry.icon);
      paramApplicationInfo.title = localCacheEntry.title;
      if (DEBUG_ENABLE)
        Log.d("IconCache", "getTitleAndIcon --- componentName = " + paramApplicationInfo.componentName + "getTitleAndIcon --- title = " + paramApplicationInfo.title + ", application.iconBitmap = " + paramApplicationInfo.getIcon());
      return;
    }
  }

  public boolean isDefaultIcon(Bitmap paramBitmap)
  {
    return this.mDefaultIcon == paramBitmap;
  }

  public void onPauseDrawable()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.values().iterator();
      while (localIterator.hasNext())
      {
        CacheEntry localCacheEntry = (CacheEntry)localIterator.next();
        if (localCacheEntry.mIconsHelper != null)
        {
          localCacheEntry.mIconsHelper.onPause();
          localCacheEntry.mIconsHelper.onPauseThread();
        }
      }
    }
  }

  public void onPauseDrawable(Intent paramIntent)
  {
    synchronized (this.mCache)
    {
      ResolveInfo localResolveInfo = this.mPackageManager.resolveActivity(paramIntent, 0);
      paramIntent = paramIntent.getComponent();
      if ((localResolveInfo == null) || (paramIntent == null))
        return;
      paramIntent = cacheLocked(paramIntent, localResolveInfo, null);
      if (paramIntent.mIconsHelper != null)
        paramIntent.mIconsHelper.onPause();
      return;
    }
  }

  public void onResumeDrawable()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.values().iterator();
      while (localIterator.hasNext())
      {
        CacheEntry localCacheEntry = (CacheEntry)localIterator.next();
        if (localCacheEntry.mIconsHelper != null)
        {
          localCacheEntry.mIconsHelper.onResume();
          localCacheEntry.mIconsHelper.onResumeThread();
        }
      }
    }
  }

  public void onResumeDrawable(Intent paramIntent)
  {
    synchronized (this.mCache)
    {
      ResolveInfo localResolveInfo = this.mPackageManager.resolveActivity(paramIntent, 0);
      paramIntent = paramIntent.getComponent();
      if ((localResolveInfo == null) || (paramIntent == null))
        return;
      paramIntent = cacheLocked(paramIntent, localResolveInfo, null);
      if (paramIntent.mIconsHelper != null)
        paramIntent.mIconsHelper.onResume();
      return;
    }
  }

  public void remove(ComponentName paramComponentName)
  {
    synchronized (this.mCache)
    {
      CacheEntry localCacheEntry = (CacheEntry)this.mCache.get(paramComponentName);
      if ((localCacheEntry != null) && (localCacheEntry.mIconsHelper != null))
        localCacheEntry.mIconsHelper.cleanUp();
      this.mCache.remove(paramComponentName);
      return;
    }
  }

  public void updateAppIconIfEmpty(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    if ((paramContext != null) && (paramApplicationInfo.getIcon() == null))
    {
      Log.w("IconCache", "updateAppIconIfEmpty, icon is null, get the application icon, appInfo = " + paramApplicationInfo);
      paramApplicationInfo.setIcon(new BitmapDrawable(getApplicationBitmapIcon(paramContext, paramApplicationInfo.componentName.getPackageName())));
    }
  }

  private static class CacheEntry
  {
    public Drawable icon;
    public AppsIconsHelper mIconsHelper;
    public String title;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.IconCache
 * JD-Core Version:    0.6.2
 */