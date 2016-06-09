package com.oppo.launcher;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.oppo.launcher.settings.FeatureOption;
import com.oppo.shared_prefs.LauncherSharedPrefs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ApplicationInfo extends ItemInfo
{
  static final boolean DEBUG = false;
  static final int DOWNLOADED_FLAG = 1;
  public static final int ITEM_TYPE_APPLICATION = 0;
  public static final int ITEM_TYPE_SHORTCUT = 1;
  public static final String OLD_COMPONENT_NAME_KEY = "oldComponentName";
  public static final String OLD_COMPONENT_NAME_VERSION = "oldComponentNameVersion";
  private static final String TAG = "ApplicationInfo";
  static final int UPDATED_SYSTEM_APP_FLAG = 2;
  public ComponentName componentName;
  boolean customIcon;
  int flags = 0;
  ShortcutIconResource iconResource;
  public Intent intent;
  Drawable mIconFancyDrawable;
  private int mMetaVersion = 0;
  ResolveInfo mResolveInfo;
  boolean matchPackageAndClassName = true;
  int tmpFolderCellX = -1;
  int tmpFolderCellY = -1;
  boolean usingFallbackIcon;

  public ApplicationInfo()
  {
    this.itemType = 0;
  }

  public ApplicationInfo(PackageManager paramPackageManager, ResolveInfo paramResolveInfo, IconCache paramIconCache, HashMap<Object, CharSequence> paramHashMap)
  {
    this.packageName = paramResolveInfo.activityInfo.applicationInfo.packageName;
    this.className = paramResolveInfo.activityInfo.name;
    this.componentName = new ComponentName(this.packageName, this.className);
    this.container = -1L;
    setActivity(this.componentName, 270532608);
    try
    {
      int i = paramPackageManager.getApplicationInfo(this.packageName, 0).flags;
      if ((i & 0x1) == 0)
      {
        this.flags |= 1;
        this.uninstallable = true;
        if ((i & 0x80) != 0)
          this.flags |= 2;
      }
      this.mResolveInfo = paramResolveInfo;
      paramIconCache.getTitleAndIcon(this);
      initInstalledLocation(paramPackageManager);
      return;
    }
    catch (NameNotFoundException paramHashMap)
    {
      while (true)
        Log.w("ApplicationInfo", "PackageManager.getApplicationInfo failed for " + this.packageName);
    }
  }

  public ApplicationInfo(ResolveInfo paramResolveInfo, IconCache paramIconCache)
  {
    this.packageName = paramResolveInfo.activityInfo.applicationInfo.packageName;
    this.className = paramResolveInfo.activityInfo.name;
    this.componentName = new ComponentName(this.packageName, this.className);
    if ((paramResolveInfo.activityInfo.applicationInfo.flags & 0x1) == 1);
    for (this.uninstallable = false; ; this.uninstallable = true)
    {
      this.container = -1L;
      setActivity(this.componentName, 270532608);
      this.mResolveInfo = paramResolveInfo;
      return;
    }
  }

  public ApplicationInfo(ApplicationInfo paramApplicationInfo)
  {
    super(paramApplicationInfo);
    updateAppInfo(paramApplicationInfo);
  }

  private void deleteOldAppMetaVersion(Context paramContext, String paramString)
  {
    paramContext = LauncherSharedPrefs.getLauncherPrefs(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.commit();
  }

  public static void dumpApplicationInfoList(String paramString1, String paramString2, ArrayList<ApplicationInfo> paramArrayList)
  {
    Log.d(paramString1, paramString2 + " size=" + paramArrayList.size());
    paramString2 = paramArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramArrayList = (ApplicationInfo)paramString2.next();
      Log.d(paramString1, "   title=\"" + paramArrayList.title + "\" iconBitmap=" + paramArrayList.mIconFancyDrawable);
    }
  }

  private ComponentName getMatchedOldComponentName(Context paramContext, String[] paramArrayOfString)
  {
    Object localObject2 = null;
    SQLiteDatabase localSQLiteDatabase = null;
    Object localObject1 = localSQLiteDatabase;
    if (paramArrayOfString != null)
    {
      localObject1 = localSQLiteDatabase;
      if (paramArrayOfString.length > 0)
      {
        localSQLiteDatabase = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
        localSQLiteDatabase.beginTransaction();
        localObject1 = localObject2;
      }
    }
    try
    {
      paramContext = updateNewComponentInDatabase(paramContext, localSQLiteDatabase, paramArrayOfString, "singledesktopitems");
      localObject1 = paramContext;
      localSQLiteDatabase.setTransactionSuccessful();
      LauncherModelDataHelper.endAndCloseDB(localSQLiteDatabase);
      localObject1 = paramContext;
      return localObject1;
    }
    catch (Exception paramContext)
    {
      Log.e("ApplicationInfo", "getMatchedOldComponentName --- e = " + paramContext);
      return localObject1;
    }
    finally
    {
      LauncherModelDataHelper.endAndCloseDB(localSQLiteDatabase);
    }
    throw paramContext;
  }

  private String[] getStrArrayFromApp(Context paramContext, String paramString, int paramInt)
  {
    String[] arrayOfString = new String[0];
    try
    {
      paramString = paramContext.createPackageContext(paramString, 2);
      if (LauncherModel.DEBUG_META)
        Log.d("LauncherModelMeta", "getStrArrayFromApp -- appContext = " + paramString);
      paramContext = arrayOfString;
      if (paramString != null)
        paramContext = paramString.getResources().getStringArray(paramInt);
      return paramContext;
    }
    catch (NameNotFoundException paramContext)
    {
      do
      {
        Log.e("ApplicationInfo", "getStrArrayFromApp --- e = " + paramContext);
        paramContext = arrayOfString;
      }
      while (!LauncherModel.DEBUG_META);
      Log.d("LauncherModelMeta", "getStrArrayFromApp --- createPackageContext error");
    }
    return arrayOfString;
  }

  private int readAppMetaVersion(Context paramContext)
  {
    int i = LauncherSharedPrefs.getLauncherPrefs(paramContext).getInt(this.componentName.getPackageName() + "/" + this.componentName.getClassName(), 0);
    if (LauncherModel.DEBUG_META)
      Log.d("LauncherModelMeta", "readAppMetaVersion --- spMetaVersion = " + i);
    return i;
  }

  private void updateAppMetaVersion(Context paramContext)
  {
    paramContext = LauncherSharedPrefs.getLauncherPrefs(paramContext).edit();
    String str = this.componentName.getPackageName() + "/" + this.componentName.getClassName();
    if (LauncherModel.DEBUG_META)
      Log.d("LauncherModelMeta", "updateAppMetaVersion --- appInfo.getMetaVersion() = " + getMetaVersion());
    paramContext.putInt(str, getMetaVersion());
    paramContext.commit();
  }

  private int updateIntentInWorkspace(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("intent", paramString2);
    int i = paramSQLiteDatabase.update("singledesktopitems", localContentValues, "intent = '" + paramString1 + "'", null);
    if (LauncherModel.DEBUG_META)
      Log.d("LauncherModelMeta", "updateIntentInWorkspace --- count = " + i);
    return i;
  }

  public void copyDataToApplicationInfoFromDB(ApplicationInfo paramApplicationInfo)
  {
    this.id = paramApplicationInfo.id;
    this.cellX = paramApplicationInfo.cellX;
    this.cellY = paramApplicationInfo.cellY;
    this.spanX = paramApplicationInfo.spanX;
    this.spanY = paramApplicationInfo.spanY;
    this.screenId = paramApplicationInfo.screenId;
    this.itemType = paramApplicationInfo.itemType;
    this.container = paramApplicationInfo.container;
    this.title = paramApplicationInfo.title;
    this.newinstalled = paramApplicationInfo.newinstalled;
  }

  public Intent generateIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setComponent(new ComponentName(paramString1, paramString2));
    localIntent.setFlags(270532608);
    if (LauncherModel.DEBUG_META)
      Log.d("LauncherModelMeta", "generateIntentStr --- intent.toUri(0) = " + localIntent.toUri(0));
    return localIntent;
  }

  public Drawable getIcon()
  {
    return this.mIconFancyDrawable;
  }

  public Drawable getIcon(IconCache paramIconCache)
  {
    if (this.mIconFancyDrawable == null)
      this.mIconFancyDrawable = paramIconCache.getIcon(this.intent);
    return this.mIconFancyDrawable;
  }

  public Bitmap getIconBitmap()
  {
    if ((this.mIconFancyDrawable != null) && ((this.mIconFancyDrawable instanceof BitmapDrawable)))
      return ((BitmapDrawable)this.mIconFancyDrawable).getBitmap();
    return null;
  }

  public Bitmap getIconBitmap(IconCache paramIconCache)
  {
    paramIconCache = getIcon(paramIconCache);
    if ((paramIconCache != null) && ((paramIconCache instanceof BitmapDrawable)))
      return ((BitmapDrawable)paramIconCache).getBitmap();
    return null;
  }

  public Intent getIntent()
  {
    return this.intent;
  }

  public int getMetaVersion()
  {
    return this.mMetaVersion;
  }

  public String getPackageClassName()
  {
    return this.componentName.flattenToString();
  }

  public void initInstalledLocation(PackageManager paramPackageManager)
  {
    try
    {
      if (FeatureOption.APP2SD_DISABLED)
      {
        this.installedLocation = 0;
        return;
      }
      if ((paramPackageManager.getApplicationInfo(this.mResolveInfo.activityInfo.applicationInfo.packageName, 8192).flags & 0x40000) != 0)
      {
        this.installedLocation = 1;
        return;
      }
    }
    catch (Exception paramPackageManager)
    {
      Log.e("ApplicationInfo", " Exception: " + paramPackageManager.getStackTrace());
      return;
    }
    this.installedLocation = 0;
  }

  public boolean isApplication()
  {
    return this.itemType == 0;
  }

  public boolean isShortcut()
  {
    return this.itemType == 1;
  }

  public String[] loadMetaComponentName(Context paramContext, boolean paramBoolean)
  {
    if (LauncherModel.DEBUG_META)
      Log.d("LauncherModelMeta", "loadMetaComponentName uninstallable = " + this.uninstallable + ". entry-- appInfo = " + this + ", appInfo.intent = " + this.intent);
    if (this.uninstallable)
      paramContext = null;
    while (true)
    {
      return paramContext;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getActivityInfo(this.componentName, 128).metaData;
        if (LauncherModel.DEBUG_META)
          Log.d("LauncherModelMeta", "loadMetaComponentName --- mataData = " + localObject);
        if (localObject != null)
        {
          int i = ((Bundle)localObject).getInt("oldComponentNameVersion", 0);
          if (LauncherModel.DEBUG_META)
            Log.d("LauncherModelMeta", "loadMetaComponentName --- newMetaVersion = " + i);
          if ((i > 0) && (!paramBoolean))
          {
            int j = readAppMetaVersion(paramContext);
            if (LauncherModel.DEBUG_META)
              Log.d("LauncherModelMeta", "loadMetaComponentName --- savedMetaVersion = " + j);
            if (i <= j)
            {
              Log.w("LauncherModelMeta", "No meta version in app's manifest, return");
              return null;
            }
            setMetaVersion(i);
          }
          i = ((Bundle)localObject).getInt("oldComponentName");
          if (LauncherModel.DEBUG_META)
            Log.d("LauncherModelMeta", "loadMetaComponentName -- oldCompResId -- = " + i);
          if (i != 0)
          {
            localObject = getStrArrayFromApp(paramContext, this.componentName.getPackageName(), i);
            if ((localObject != null) && (localObject.length > 0))
            {
              paramContext = (Context)localObject;
              if (!LauncherModel.DEBUG_META)
                continue;
              i = 0;
              while (true)
              {
                paramContext = (Context)localObject;
                if (i >= localObject.length)
                  break;
                Log.d("LauncherModelMeta", "loadMetaComponentName -- oldCompArray[" + i + "] = " + localObject[i]);
                i += 1;
              }
            }
          }
        }
      }
      catch (NameNotFoundException paramContext)
      {
        Log.e("ApplicationInfo", "loadMetaComponentName --- e = " + paramContext);
      }
    }
    return null;
  }

  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    String str = null;
    Object localObject = str;
    if (this.mIconFancyDrawable != null)
    {
      localObject = str;
      if ((this.mIconFancyDrawable instanceof BitmapDrawable))
        localObject = ((BitmapDrawable)this.mIconFancyDrawable).getBitmap();
    }
    if (this.intent != null)
    {
      str = this.intent.toUri(0);
      paramContentValues.put("intent", str);
      paramContentValues.put("modelState", Integer.valueOf(this.installedLocation));
      if (!isShortcut())
        break label172;
      if (!this.customIcon)
        break label113;
      paramContentValues.put("iconType", Integer.valueOf(1));
      writeBitmap(paramContentValues, (Bitmap)localObject);
    }
    label113: 
    while (!isApplication())
    {
      do
      {
        return;
        str = null;
        break;
        if (!this.usingFallbackIcon)
          writeBitmap(paramContentValues, (Bitmap)localObject);
        paramContentValues.put("iconType", Integer.valueOf(0));
      }
      while (this.iconResource == null);
      paramContentValues.put("iconPackage", this.iconResource.packageName);
      paramContentValues.put("iconResource", this.iconResource.resourceName);
      return;
    }
    label172: paramContentValues.put("packageName", this.componentName.getPackageName());
    paramContentValues.put("className", this.componentName.getClassName());
    writeBitmap(paramContentValues, (Bitmap)localObject);
  }

  void setActivity(ComponentName paramComponentName, int paramInt)
  {
    this.componentName = paramComponentName;
    this.intent = new Intent("android.intent.action.MAIN");
    this.intent.addCategory("android.intent.category.LAUNCHER");
    this.intent.setComponent(paramComponentName);
    this.intent.setFlags(paramInt);
    this.itemType = 0;
  }

  public void setIcon(Drawable paramDrawable)
  {
    this.mIconFancyDrawable = paramDrawable;
  }

  public void setMetaVersion(int paramInt)
  {
    this.mMetaVersion = paramInt;
  }

  public void setNeedMatchPkgAndClsNameFlag(Context paramContext, ResolveInfo paramResolveInfo)
  {
    if (paramResolveInfo == null);
    while (this.uninstallable)
      return;
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setPackage(paramResolveInfo.activityInfo.applicationInfo.packageName);
    if (paramContext.queryIntentActivities(localIntent, 0).size() > 1)
    {
      this.matchPackageAndClassName = true;
      return;
    }
    this.matchPackageAndClassName = false;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ApplicationInfo(title=");
    if (this.title == null);
    for (String str = null; ; str = this.title.toString())
    {
      str = str + "), " + "componentName = " + this.componentName + ", uninstallable = " + this.uninstallable + ", unreadNum = " + this.unreadNum + ", intent = " + this.intent;
      return str + ", screenId = " + this.screenId + ", container = " + this.container + ", cellX = " + this.cellX + ", cellY = " + this.cellY + ", spanX = " + this.spanX + ", spanY = " + this.spanY + ", installLocation = " + this.installedLocation;
    }
  }

  public ComponentName updateAppComponentFromMeta(Context paramContext)
  {
    return getMatchedOldComponentName(paramContext, loadMetaComponentName(paramContext, false));
  }

  public void updateAppInfo(ApplicationInfo paramApplicationInfo)
  {
    this.mIconFancyDrawable = paramApplicationInfo.mIconFancyDrawable;
    this.uninstallable = paramApplicationInfo.uninstallable;
    this.packageName = paramApplicationInfo.packageName;
    this.className = paramApplicationInfo.className;
    this.componentName = paramApplicationInfo.componentName;
    this.mResolveInfo = paramApplicationInfo.mResolveInfo;
    this.unreadNum = paramApplicationInfo.unreadNum;
    this.title = String.valueOf(paramApplicationInfo.title);
    this.intent = new Intent(paramApplicationInfo.intent);
    this.flags = paramApplicationInfo.flags;
    this.installedLocation = paramApplicationInfo.installedLocation;
    this.container = paramApplicationInfo.container;
    this.newinstalled = paramApplicationInfo.newinstalled;
    if (isShortcut())
    {
      if (paramApplicationInfo.iconResource != null)
      {
        this.iconResource = new ShortcutIconResource();
        this.iconResource.packageName = paramApplicationInfo.iconResource.packageName;
        this.iconResource.resourceName = paramApplicationInfo.iconResource.resourceName;
      }
      this.customIcon = paramApplicationInfo.customIcon;
      this.usingFallbackIcon = paramApplicationInfo.usingFallbackIcon;
    }
  }

  public void updateAppUninstallFlag(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      if ((paramContext.getApplicationInfo(this.componentName.getPackageName(), 0).flags & 0x1) == 0)
      {
        this.uninstallable = true;
        return;
      }
      this.uninstallable = false;
      return;
    }
    catch (NameNotFoundException paramContext)
    {
      Log.w("ApplicationInfo", "PackageManager.getApplicationInfo failed for " + this.packageName);
    }
  }

  public ComponentName updateNewComponentInDatabase(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfString != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfString.length > 0)
      {
        int i = paramArrayOfString.length - 1;
        localObject1 = localObject2;
        if (i >= 0)
        {
          String str2 = paramArrayOfString[i];
          int j = str2.indexOf("/");
          if (j < 0)
            Log.w("LauncherModelMeta", "ApplicationInfo:updateNewComponentInDatabase --- metaStr format error! continue... compStr = " + str2);
          String str3;
          do
          {
            i -= 1;
            break;
            str3 = str2.substring(0, j);
            localObject1 = str2.substring(j + 1, str2.length());
            if (LauncherModel.DEBUG_META)
              Log.d("LauncherModelMeta", "ApplicationInfo:updateNewComponentInDatabase ComponentName.PackageName = " + this.componentName.getPackageName() + ", ComponentName.ClassName = " + this.componentName.getClassName() + ", oldPackageName = " + str3 + ", oldClassName = " + (String)localObject1);
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("packageName", this.componentName.getPackageName());
            localContentValues.put("className", this.componentName.getClassName());
            int k = paramSQLiteDatabase.update(paramString, localContentValues, "packageName = '" + str3 + "' AND " + "className" + " = '" + (String)localObject1 + "'", null);
            if (LauncherModel.DEBUG_META)
              Log.d("LauncherModelMeta", "ApplicationInfo:updateNewComponentInDatabase --- count = " + k);
            j = k;
            if (k <= 0)
            {
              String str1 = this.componentName.getClassName();
              k = paramSQLiteDatabase.update(paramString, localContentValues, "packageName = '" + str3 + "' AND " + "className" + " = '" + str1 + "'", null);
              j = k;
              localObject1 = str1;
              if (LauncherModel.DEBUG_META)
              {
                Log.d("LauncherModelMeta", "ApplicationInfo:updateNewComponentInDatabase --- else count = " + k + "  oldPackageName = " + str3 + "  oldClassName = " + str1);
                localObject1 = str1;
                j = k;
              }
            }
          }
          while (j <= 0);
          paramArrayOfString = new ComponentName(str3, (String)localObject1);
          updateAppMetaVersion(paramContext);
          updateIntentInWorkspace(paramSQLiteDatabase, generateIntent(str3, (String)localObject1).toUri(0), this.intent.toUri(0));
          deleteOldAppMetaVersion(paramContext, str2);
          localObject1 = paramArrayOfString;
        }
      }
    }
    return localObject1;
  }

  public void updateResolveInfo(ResolveInfo paramResolveInfo)
  {
    this.mResolveInfo = paramResolveInfo;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ApplicationInfo
 * JD-Core Version:    0.6.2
 */