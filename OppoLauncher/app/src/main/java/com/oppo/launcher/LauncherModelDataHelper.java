package com.oppo.launcher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.oppo.shared_prefs.LauncherSharedPrefs;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class LauncherModelDataHelper
{
  public static final String BLACKLIST_NEARME_URI = "content://com.nearme.romupdate.provider.db/update_list";
  public static final String BUILD_VERSION = "com.oppo.build_version";
  public static final boolean DEBUG_LOADERS = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final boolean DEBUG_NORMAL = false;
  public static final String SHORTCUT_BLACKLIST_VERSION = "shortcut_blacklist_version";
  private static final String SHORTCUT_INTENT_WHITELIST = "intent_whitelist";
  private static final String SHORTCUT_PACKAGENAME_WHITELIST = "packagename_whitelist";
  private static final String SHORTCUT_TITLE_PACKAGENAME_WHITELIST = "title_packagename_whitelist";
  private static final String SHORTCUT_TITLE_WHITELIST = "title_whitelist";
  private static final String SHORTCUT_WHITELIST_VERSION = "shortcut_whitelist_version";
  static final String TAG = "LauncherModelDataHelper";
  private static LauncherModelDataHelper sInstance;
  private ArrayList<String> mNewInstallPackageNames = new ArrayList();
  private ArrayList<ItemInfo> mUpdateAppInfoIconList = new ArrayList();

  public static void deleteNewInstallItemsFromDB(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    paramApplicationInfo = paramApplicationInfo.componentName.getPackageName();
    paramContext = paramContext.getContentResolver();
    if (paramContext != null)
      paramContext.delete(LauncherSettings.NewInstallItems.CONTENT_URI_NO_NOTIFICATION, "packagename = '" + paramApplicationInfo + "'", null);
  }

  private void deleteShortcutWhiteListDatabase(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.delete("shortcutwhitelist", null, null);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("LauncherModelDataHelper", "deleteShortcutWhiteListDatabase e = " + paramContext);
    }
  }

  public static void endAndCloseDB(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.inTransaction()))
    {
      paramSQLiteDatabase.endTransaction();
      paramSQLiteDatabase.close();
    }
  }

  public static LauncherModelDataHelper getInstance()
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new LauncherModelDataHelper();
      return sInstance;
    }
    finally
    {
    }
  }

  public static String getPackageNameByIntent(Context paramContext, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getPackage();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ComponentName localComponentName = paramIntent.getComponent();
        localObject1 = localObject2;
        if (localComponentName != null)
          localObject1 = localComponentName.getPackageName();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (paramContext == null);
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      localObject2 = localObject1;
      if (paramContext != null)
      {
        paramContext = paramContext.resolveActivity(paramIntent, 65536);
        localObject2 = localObject1;
        if (paramContext != null)
        {
          localObject2 = localObject1;
          if (paramContext.activityInfo != null)
            localObject2 = paramContext.activityInfo.packageName;
        }
      }
      return localObject2;
    }
    catch (Exception paramContext)
    {
      Log.w("LauncherModelDataHelper", "getPackageNameByIntent get packageName by ResolveInfo e = " + paramContext);
    }
    return localObject1;
  }

  private static long initializeTableInstallMaxId(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = null;
    long l2 = -1L;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT MAX(_id) FROM newinstall", null);
      if (paramSQLiteDatabase != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        if (paramSQLiteDatabase.moveToNext())
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
        }
      }
      for (long l1 = paramSQLiteDatabase.getLong(0); ; l1 = 0L)
      {
        l2 = l1;
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.close();
          l2 = l1;
        }
        return l2;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        Log.e("LauncherModelDataHelper", "initializeTableInstallMaxId --- e = " + paramSQLiteDatabase);
      }
      while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return -1L;
    }
    finally
    {
      if (localObject != null)
        ((Cursor)localObject).close();
    }
    throw paramSQLiteDatabase;
  }

  public static void insertNewFlagItemsToDB(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    String str = paramApplicationInfo.componentName.getPackageName();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = null;
    paramContext = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      long l = initializeTableInstallMaxId(localSQLiteDatabase);
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      ContentValues localContentValues = new ContentValues();
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      localContentValues.put("newinstallflag", Integer.valueOf(paramApplicationInfo.newinstalled));
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      localContentValues.put("_id", Long.valueOf(l + 1L));
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      localContentValues.put("packagename", str);
      paramContext = localSQLiteDatabase;
      localObject = localSQLiteDatabase;
      localContentResolver.insert(LauncherSettings.NewInstallItems.CONTENT_URI_NO_NOTIFICATION, localContentValues);
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramApplicationInfo)
    {
      do
      {
        localObject = paramContext;
        Log.e("LauncherModelDataHelper", "updateNewInstallItemsInDB --- e = " + paramApplicationInfo);
      }
      while (paramContext == null);
      paramContext.close();
      return;
    }
    finally
    {
      if (localObject != null)
        ((SQLiteDatabase)localObject).close();
    }
    throw paramContext;
  }

  private static void insertShortcutWhiteListInDatabase(Context paramContext, ArrayList<String> paramArrayList, int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
      try
      {
        paramContext = new ContentValues();
        paramContext.put("itemName", (String)paramArrayList.get(i));
        paramContext.put("itemType", Integer.valueOf(paramInt));
        paramSQLiteDatabase.insert("shortcutwhitelist", null, paramContext);
        i += 1;
      }
      catch (Exception paramContext)
      {
        Log.e("LauncherModelDataHelper", "insertShortcutWhiteListInDatabase e = " + paramContext);
      }
  }

  public static boolean isShortcutInWhiteList(Context paramContext, Intent paramIntent, String paramString)
  {
    String str3;
    String str2;
    if ((paramIntent != null) && (paramContext != null))
    {
      str3 = getPackageNameByIntent(paramContext, paramIntent);
      str2 = paramIntent.toUri(0);
      if (((!LauncherAssetManager.isInDefaultShortcutWhiteList(paramString, 2)) || (!LauncherAssetManager.isInDefaultShortcutWhiteList(str3, 3))) && (!LauncherAssetManager.isInDefaultShortcutWhiteList(str3, 0)) && (!LauncherAssetManager.isInDefaultShortcutWhiteList(str2, 1)));
    }
    while (true)
    {
      return true;
      ContentResolver localContentResolver = paramContext.getContentResolver();
      paramContext = null;
      paramIntent = null;
      String str1 = null;
      if (paramString != null);
      try
      {
        paramString = localContentResolver.query(LauncherSettings.SingleDeskTopShortcutWhiteList.CONTENT_URI, null, "(itemType=? and itemName=?)", new String[] { String.valueOf(2), paramString }, null);
        str1 = paramString;
        boolean bool;
        if (paramString != null)
        {
          str1 = paramString;
          paramContext = paramString;
          paramIntent = paramString;
          if (paramString.moveToFirst())
          {
            str1 = paramString;
            if (str3 != null)
            {
              paramContext = paramString;
              paramIntent = paramString;
              paramString = localContentResolver.query(LauncherSettings.SingleDeskTopShortcutWhiteList.CONTENT_URI, null, "(itemType=? and itemName=?)", new String[] { String.valueOf(3), str3 }, null);
              str1 = paramString;
              if (paramString != null)
              {
                paramContext = paramString;
                paramIntent = paramString;
                bool = paramString.moveToFirst();
                str1 = paramString;
                if (bool)
                  return true;
              }
            }
          }
        }
        paramIntent = str1;
        if (str3 != null)
        {
          paramContext = str1;
          paramIntent = str1;
          paramString = localContentResolver.query(LauncherSettings.SingleDeskTopShortcutWhiteList.CONTENT_URI, null, "(itemType=? and itemName=?)", new String[] { String.valueOf(0), str3 }, null);
          paramIntent = paramString;
          if (paramString != null)
          {
            paramContext = paramString;
            paramIntent = paramString;
            bool = paramString.moveToFirst();
            paramIntent = paramString;
            if (bool)
              return true;
          }
        }
        paramContext = paramIntent;
        if (str2 != null)
        {
          paramContext = paramIntent;
          paramString = localContentResolver.query(LauncherSettings.SingleDeskTopShortcutWhiteList.CONTENT_URI, null, "(itemType=? and itemName=?)", new String[] { String.valueOf(1), str2 }, null);
          paramContext = paramString;
          if (paramString != null)
          {
            paramContext = paramString;
            paramIntent = paramString;
            bool = paramString.moveToFirst();
            paramContext = paramString;
            if (bool)
              return true;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        while (true)
        {
          paramIntent = paramContext;
          Log.e("LauncherModelDataHelper", "isShortcutInWhiteList fail e = " + paramString);
          if (paramContext != null)
            paramContext.close();
        }
      }
      finally
      {
        if (paramIntent != null)
          paramIntent.close();
      }
    }
    throw paramContext;
  }

  private ArrayList<String> loadNewInstallAppsInner(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramContext.getContentResolver();
    Object localObject1 = null;
    paramContext = null;
    try
    {
      localObject2 = ((ContentResolver)localObject2).query(LauncherSettings.NewInstallItems.CONTENT_URI_NO_NOTIFICATION, new String[] { "packagename", "newinstallflag" }, null, null, null);
      paramContext = (Context)localObject2;
      localObject1 = localObject2;
      if (((Cursor)localObject2).getCount() > 0)
        while (true)
        {
          paramContext = (Context)localObject2;
          localObject1 = localObject2;
          if (!((Cursor)localObject2).moveToNext())
            break;
          paramContext = (Context)localObject2;
          localObject1 = localObject2;
          String str = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("packagename"));
          if (str != null)
          {
            paramContext = (Context)localObject2;
            localObject1 = localObject2;
            if (!"".equals(str))
            {
              paramContext = (Context)localObject2;
              localObject1 = localObject2;
              localArrayList.add(str);
            }
          }
        }
    }
    catch (Exception localException)
    {
      localObject1 = paramContext;
      Log.e("LauncherModelDataHelper", "loadNewInstallAppsInner --- e = " + localException);
      if (paramContext != null)
        paramContext.close();
      do
        return localArrayList;
      while (localException == null);
      localException.close();
      return localArrayList;
    }
    finally
    {
      if (localObject1 != null)
        ((Cursor)localObject1).close();
    }
    throw paramContext;
  }

  private boolean parseAndUpdateShortcutWhiteListInDatabase(Context paramContext, String paramString)
    throws XmlPullParserException, IOException
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
      if (DEBUG_LOADERS)
        Log.d("LauncherModelDataHelper", "parseAndUpdateShortcutWhiteListInDatabase return false TextUtils.isEmpty(xml) = " + TextUtils.isEmpty(paramString) + ", context = " + paramContext);
    while (true)
    {
      return false;
      String str1 = null;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      localXmlPullParser.nextTag();
      int i = localXmlPullParser.getEventType();
      paramString = str1;
      if (i != 1)
      {
        str1 = paramString;
        String str2;
        if (2 == i)
        {
          str2 = localXmlPullParser.getName();
          if ("string-array".equals(str2))
            paramString = localXmlPullParser.getAttributeValue(0);
          str1 = paramString;
          if (paramString != null)
          {
            if (!"packagename_whitelist".equals(paramString))
              break label238;
            str1 = paramString;
            if ("item".equals(str2))
            {
              localArrayList1.add(localXmlPullParser.nextText());
              str1 = paramString;
            }
          }
        }
        while (true)
        {
          i = localXmlPullParser.next();
          paramString = str1;
          break;
          label238: if ("intent_whitelist".equals(paramString))
          {
            str1 = paramString;
            if ("item".equals(str2))
            {
              localArrayList2.add(localXmlPullParser.nextText());
              str1 = paramString;
            }
          }
          else if ("title_whitelist".equals(paramString))
          {
            str1 = paramString;
            if ("item".equals(str2))
            {
              localArrayList3.add(localXmlPullParser.nextText());
              str1 = paramString;
            }
          }
          else
          {
            str1 = paramString;
            if ("title_packagename_whitelist".equals(paramString))
            {
              str1 = paramString;
              if ("item".equals(str2))
              {
                localArrayList4.add(localXmlPullParser.nextText());
                str1 = paramString;
              }
            }
          }
        }
      }
      if (((localArrayList1 != null) && (localArrayList1.size() > 0)) || ((localArrayList2 != null) && (localArrayList2.size() > 0)))
      {
        paramString = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
        try
        {
          deleteShortcutWhiteListDatabase(paramContext, paramString);
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
            insertShortcutWhiteListInDatabase(paramContext, localArrayList1, 0, paramString);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            insertShortcutWhiteListInDatabase(paramContext, localArrayList2, 1, paramString);
          if ((localArrayList3 != null) && (localArrayList3.size() > 0))
            insertShortcutWhiteListInDatabase(paramContext, localArrayList3, 2, paramString);
          if ((localArrayList4 != null) && (localArrayList4.size() > 0))
            insertShortcutWhiteListInDatabase(paramContext, localArrayList4, 3, paramString);
          return true;
        }
        catch (Exception paramContext)
        {
          Log.e("LauncherModelDataHelper", "parseAndUpdateShortcutWhiteListInDatabase e = " + paramContext);
          return false;
        }
        finally
        {
          if (paramString != null)
            paramString.close();
        }
      }
    }
    return false;
  }

  public static void updateNewInstallItemsInDB(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    Object localObject3 = paramApplicationInfo.componentName.getPackageName();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      localObject3 = localContentResolver.query(LauncherSettings.NewInstallItems.CONTENT_URI_NO_NOTIFICATION, new String[] { "newinstallflag" }, "packagename =? ", new String[] { localObject3 }, null);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (((Cursor)localObject3).getCount() == 0)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        insertNewFlagItemsToDB(paramContext, paramApplicationInfo);
      }
      if (localObject3 != null)
        ((Cursor)localObject3).close();
      return;
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      Log.e("LauncherModelDataHelper", "updateNewInstallItemsInDB --- e = " + paramContext);
      return;
    }
    finally
    {
      if (localObject2 != null)
        localObject2.close();
    }
    throw paramContext;
  }

  public void clearWillUpdateAppInfoIconList()
  {
    this.mUpdateAppInfoIconList.clear();
  }

  public void deleteNewInstallAppInDatebase()
  {
    SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("newinstall", null, null);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      Log.e("LauncherModelDataHelper", "deleteNewInstallAppInDatebase --- e = " + localException);
      return;
    }
    finally
    {
      endAndCloseDB(localSQLiteDatabase);
    }
  }

  public int getAppNewInstallFlag(String paramString)
  {
    if (DEBUG_LOADERS)
      Log.d("LauncherModelDataHelper", "getAppNewInstallFlag -- packageNameString = " + paramString);
    if (this.mNewInstallPackageNames.size() > 0)
    {
      Iterator localIterator = this.mNewInstallPackageNames.iterator();
      while (localIterator.hasNext())
        if (paramString.equals((String)localIterator.next()))
          return 1;
    }
    return 0;
  }

  public ArrayList<ItemInfo> getWillUpdateAppInfoIconList()
  {
    if (DEBUG_LOADERS)
      Log.d("LauncherModelDataHelper", this + " getWillUpdateAppInfoIconList mUpdateAppInfoIconList.size() = " + this.mUpdateAppInfoIconList.size());
    return this.mUpdateAppInfoIconList;
  }

  public void loadNewInstallApps(Context paramContext)
  {
    this.mNewInstallPackageNames.clear();
    this.mNewInstallPackageNames = loadNewInstallAppsInner(paramContext);
  }

  public void updateSavedIcon(Context paramContext, ApplicationInfo paramApplicationInfo, byte[] paramArrayOfByte, IconCache paramIconCache)
  {
    if (paramArrayOfByte != null);
    try
    {
      boolean bool = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length).sameAs(paramApplicationInfo.getIconBitmap(paramIconCache));
      if (!bool)
        i = 1;
      while (true)
      {
        if (i != 0)
        {
          if (DEBUG_LOADERS)
            Log.d("LauncherModelDataHelper", "going to save icon bitmap for info=" + paramApplicationInfo);
          this.mUpdateAppInfoIconList.add(paramApplicationInfo);
        }
        return;
        i = 0;
        continue;
        i = 1;
      }
    }
    catch (Exception paramContext)
    {
      while (true)
        int i = 1;
    }
  }

  public void updateSavedIcon(ApplicationInfo paramApplicationInfo1, ApplicationInfo paramApplicationInfo2)
  {
    try
    {
      if (paramApplicationInfo2.getIcon() != null)
      {
        boolean bool = paramApplicationInfo1.getIconBitmap().sameAs(paramApplicationInfo2.getIconBitmap());
        if (!bool)
          i = 1;
      }
      while (true)
      {
        if (i != 0)
          this.mUpdateAppInfoIconList.add(paramApplicationInfo1);
        return;
        i = 0;
        continue;
        i = 1;
      }
    }
    catch (Exception paramApplicationInfo2)
    {
      while (true)
        int i = 1;
    }
  }

  public void updateShortcutWhiteListInDatabase(Context paramContext)
  {
    if (paramContext == null)
      Log.w("LauncherModelDataHelper", "updateShortcutWhiteListInDatabase context = null");
    while (true)
    {
      return;
      SharedPreferences localSharedPreferences = LauncherSharedPrefs.getLauncherPrefs(paramContext);
      int i = localSharedPreferences.getInt("shortcut_whitelist_version", 0);
      Cursor localCursor = paramContext.getContentResolver().query(Uri.parse("content://com.nearme.romupdate.provider.db/update_list"), new String[] { "version", "xml" }, "filtername=\"shortcut_whitelist\"", null, null);
      if (localCursor != null);
      try
      {
        if (localCursor.moveToFirst())
        {
          int j = localCursor.getInt(localCursor.getColumnIndex("version"));
          if (DEBUG_LOADERS)
            Log.d("LauncherModelDataHelper", "updateShortcutWhiteListInDatabase versionInPrefs = " + i + ", versionInNearMeDB = " + j);
          if ((i < j) && (parseAndUpdateShortcutWhiteListInDatabase(paramContext, localCursor.getString(localCursor.getColumnIndex("xml")))))
          {
            paramContext = localSharedPreferences.edit();
            paramContext.putInt("shortcut_whitelist_version", j);
            paramContext.commit();
          }
        }
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("LauncherModelDataHelper", "updateShortcutWhiteListInDatabase fail e = " + paramContext);
        return;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
    throw paramContext;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherModelDataHelper
 * JD-Core Version:    0.6.2
 */