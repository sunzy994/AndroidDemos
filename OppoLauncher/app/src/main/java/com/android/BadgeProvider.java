package com.android;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;
import com.oppo.launcher.LauncherUtil;
import java.util.List;

public class BadgeProvider extends ContentProvider
{
  public static final String AUTHORITY = "com.android.badge";
  public static final String DATABASE_NAME = "badge.db";
  private static final boolean DEBUG_CALL = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final boolean DEBUG_ENABLE = false;
  private static final boolean DEBUG_SQL = false;
  public static final String PARAMETER_NOTIFY = "notify";
  public static final String PARAMETER_PACKAGENAME = "packageName";
  public static final String TABLE_NAME = "badge";
  private static final String TAG = "BadgeProvider";
  private BadgeHelper mDbHelper;

  private static long dbInsertAndCheck(BadgeHelper paramBadgeHelper, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("_id"))
      throw new RuntimeException("Error: attempting to add item without specifying an id");
    return paramSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
  }

  private void sendNotify(Uri paramUri, String paramString)
  {
    Object localObject = paramUri.getQueryParameter("notify");
    if ((localObject == null) || ("true".equals(localObject)))
    {
      localObject = paramUri;
      if (paramString != null)
      {
        Builder localBuilder = paramUri.buildUpon();
        localObject = paramUri;
        if (localBuilder != null)
        {
          localBuilder.appendQueryParameter("packageName", paramString);
          localObject = localBuilder.build();
        }
      }
      getContext().getContentResolver().notifyChange((Uri)localObject, null);
    }
  }

  private boolean updateOrInsertOneItem(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
      Log.w("BadgeProvider", "updateOrInsertOneItem packageName = null");
    while (true)
    {
      return false;
      int i = paramInt;
      if (paramInt > 100)
        i = 100;
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        Cursor localCursor = this.mDbHelper.getWritableDatabase().query("badge", null, new String("app_package_name = ? "), new String[] { paramString }, null, null, null);
        if (localCursor == null)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          Log.w("BadgeProvider", "updateOrInsertOneItem query cursor = null");
          return false;
        }
        localObject1 = localCursor;
        localObject2 = localCursor;
        ContentValues localContentValues;
        if (localCursor.getCount() > 0)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (localCursor.moveToNext())
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (i != localCursor.getInt(localCursor.getColumnIndexOrThrow("app_badge_count")))
            {
              localObject1 = localCursor;
              localObject2 = localCursor;
              paramInt = localCursor.getInt(localCursor.getColumnIndexOrThrow("_id"));
              localObject1 = localCursor;
              localObject2 = localCursor;
              localContentValues = new ContentValues();
              localObject1 = localCursor;
              localObject2 = localCursor;
              localContentValues.put("app_package_name", paramString);
              localObject1 = localCursor;
              localObject2 = localCursor;
              localContentValues.put("app_badge_count", Integer.valueOf(i));
              localObject1 = localCursor;
              localObject2 = localCursor;
              update(BadgeItems.CONTENT_URI, localContentValues, "_id=" + paramInt, null);
            }
          }
        }
        while (true)
        {
          return true;
          localObject1 = localCursor;
          localObject2 = localCursor;
          long l = generateNewId();
          localObject1 = localCursor;
          localObject2 = localCursor;
          localContentValues = new ContentValues();
          localObject1 = localCursor;
          localObject2 = localCursor;
          localContentValues.put("_id", Long.valueOf(l));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localContentValues.put("app_package_name", paramString);
          localObject1 = localCursor;
          localObject2 = localCursor;
          localContentValues.put("app_badge_count", Integer.valueOf(i));
          localObject1 = localCursor;
          localObject2 = localCursor;
          insert(BadgeItems.CONTENT_URI, localContentValues);
        }
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        Log.e("BadgeProvider", "updateOrInsertOneItem --- e = " + paramString);
        return false;
      }
      finally
      {
        if (localObject2 != null)
          localObject2.close();
      }
    }
    throw paramString;
  }

  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      Log.w("BadgeProvider", "call extras = null");
      paramBundle = null;
    }
    int i;
    do
    {
      return paramBundle;
      i = -1;
      switch (paramString1.hashCode())
      {
      default:
      case -413886741:
      }
      while (true)
        switch (i)
        {
        default:
          Log.w("BadgeProvider", "call method = " + paramString1);
          return super.call(paramString1, paramString2, paramBundle);
          if (paramString1.equals("setAppBadgeCount"))
            i = 0;
          break;
        case 0:
        }
      if (paramBundle.getStringArrayList("app_shortcut_custom_id") != null)
        return null;
      i = paramBundle.getInt("app_badge_count");
      paramString2 = paramBundle.getString("app_badge_packageName");
      paramString1 = paramString2;
      if (paramString2 == null)
        paramString1 = getCallingPackage();
      if (DEBUG_CALL)
        Log.d("BadgeProvider", "packageName = " + paramString1 + ", badgeCount = " + i);
    }
    while (setAppBadgeCount(paramString1, i));
    return null;
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    paramArrayOfString = this.mDbHelper.getWritableDatabase();
    int i = 0;
    try
    {
      int j = paramArrayOfString.delete(paramString.table, paramString.where, paramString.args);
      i = j;
      if (i > 0)
        sendNotify(paramUri, null);
      return i;
    }
    catch (Exception paramString)
    {
      while (true)
        Log.e("BadgeProvider", "delete --- e = " + paramString);
    }
  }

  public long generateNewId()
  {
    return this.mDbHelper.generateNewId();
  }

  public String getType(Uri paramUri)
  {
    paramUri = new SqlArguments(paramUri, null, null);
    if (TextUtils.isEmpty(paramUri.where))
      return "vnd.android.cursor.dir/" + paramUri.table;
    return "vnd.android.cursor.item/" + paramUri.table;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject = new SqlArguments(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.mDbHelper.getWritableDatabase();
    if (dbInsertAndCheck(this.mDbHelper, localSQLiteDatabase, ((SqlArguments)localObject).table, null, paramContentValues) <= 0L)
      return null;
    localObject = null;
    if (paramContentValues.containsKey("app_package_name"))
      localObject = (String)paramContentValues.get("app_package_name");
    sendNotify(paramUri, (String)localObject);
    return paramUri;
  }

  public boolean onCreate()
  {
    this.mDbHelper = new BadgeHelper(getContext());
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramArrayOfString2 = new SqlArguments(paramUri, paramString1, paramArrayOfString2);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables(paramArrayOfString2.table);
    SQLiteDatabase localSQLiteDatabase = this.mDbHelper.getWritableDatabase();
    paramString1 = null;
    try
    {
      paramArrayOfString1 = localSQLiteQueryBuilder.query(localSQLiteDatabase, paramArrayOfString1, paramArrayOfString2.where, paramArrayOfString2.args, null, null, paramString2);
      paramString1 = paramArrayOfString1;
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
      return paramArrayOfString1;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("BadgeProvider", "query Exception  uri = " + paramUri);
    }
    return paramString1;
  }

  public boolean setAppBadgeCount(String paramString, int paramInt)
  {
    if (paramInt < 0)
      Log.e("BadgeProvider", "setAppBadgeCount badgeCount < 0");
    do
    {
      return false;
      if (paramString == null)
      {
        Log.e("BadgeProvider", "setAppBadgeCount packageName = null");
        return false;
      }
    }
    while (!updateOrInsertOneItem(paramString, paramInt, false));
    return true;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    paramArrayOfString = this.mDbHelper.getWritableDatabase();
    int i = 0;
    try
    {
      int j = paramArrayOfString.update(paramString.table, paramContentValues, paramString.where, paramString.args);
      i = j;
      if (i > 0)
      {
        paramString = null;
        if (paramContentValues.containsKey("app_package_name"))
        {
          paramString = (String)paramContentValues.get("app_package_name");
          paramContentValues.remove("app_package_name");
        }
        sendNotify(paramUri, paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      while (true)
        Log.e("BadgeProvider", "update --- e = " + paramString);
    }
  }

  public class BadgeHelper extends SQLiteOpenHelper
  {
    private static final int DATABASE_VERSION = 1;
    private final Context mContext;
    private long mMaxId = -1L;

    public BadgeHelper(Context arg2)
    {
      super("badge.db", null, 1);
      this.mContext = localContext;
      if (this.mMaxId == -1L)
        this.mMaxId = initializeMaxId(getWritableDatabase());
    }

    private long initializeMaxId(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      long l3 = -1L;
      long l2 = l3;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT MAX(_id) FROM badge", null);
        l1 = l3;
        if (paramSQLiteDatabase != null)
        {
          l1 = l3;
          localSQLiteDatabase = paramSQLiteDatabase;
          l2 = l3;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.moveToNext())
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            l2 = l3;
            localObject = paramSQLiteDatabase;
            l1 = paramSQLiteDatabase.getLong(0);
          }
        }
        if (l1 == -1L)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          l2 = l1;
          localObject = paramSQLiteDatabase;
          throw new RuntimeException("Error: could not query max id");
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        long l1;
        localObject = localSQLiteDatabase;
        Log.e("BadgeProvider", "initializeMaxId --- e = " + paramSQLiteDatabase);
        l3 = l2;
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.close();
          l3 = l2;
        }
        do
        {
          return l3;
          l3 = l1;
        }
        while (paramSQLiteDatabase == null);
        paramSQLiteDatabase.close();
        return l1;
      }
      finally
      {
        if (localObject != null)
          ((Cursor)localObject).close();
      }
      throw paramSQLiteDatabase;
    }

    public long generateNewId()
    {
      if (this.mMaxId < 0L)
        throw new RuntimeException("Error: max id was not initialized");
      this.mMaxId += 1L;
      return this.mMaxId;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS badge(_id INTEGER PRIMARY KEY AUTOINCREMENT, app_package_name TEXT, app_badge_count INTEGER);");
      this.mMaxId = 1L;
    }

    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (this.mContext != null)
        this.mContext.deleteDatabase("badge.db");
      while (true)
      {
        onCreate(paramSQLiteDatabase);
        return;
        Log.e("BadgeProvider", "onDowngrade mContext = null");
      }
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }

  public static final class BadgeItems
    implements BaseColumns
  {
    public static final String APP_BADGE_COUNT = "app_badge_count";
    public static final String APP_PACKAGE_NAME = "app_package_name";
    public static final Uri CONTENT_URI = Uri.parse("content://com.android.badge/badge");
  }

  static class SqlArguments
  {
    public final String[] args;
    public final String table;
    public final String where;

    SqlArguments(Uri paramUri)
    {
      if (paramUri.getPathSegments().size() == 1)
      {
        this.table = ((String)paramUri.getPathSegments().get(0));
        this.where = null;
        this.args = null;
        return;
      }
      throw new IllegalArgumentException("Invalid URI: " + paramUri);
    }

    SqlArguments(Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      if (paramUri.getPathSegments().size() == 1)
      {
        this.table = ((String)paramUri.getPathSegments().get(0));
        this.where = paramString;
        this.args = paramArrayOfString;
        return;
      }
      if (paramUri.getPathSegments().size() != 2)
        throw new IllegalArgumentException("Invalid URI: " + paramUri);
      if (!TextUtils.isEmpty(paramString))
        throw new UnsupportedOperationException("WHERE clause not supported: " + paramUri);
      this.table = ((String)paramUri.getPathSegments().get(0));
      this.where = ("_id=" + ContentUris.parseId(paramUri));
      this.args = null;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.android.BadgeProvider
 * JD-Core Version:    0.6.2
 */