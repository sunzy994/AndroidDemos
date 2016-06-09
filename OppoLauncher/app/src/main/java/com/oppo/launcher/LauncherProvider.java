package com.oppo.launcher;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.CursorWindowAllocationException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.oppo.launcher.expdev.ExpRegionHandler;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import com.oppo.shared_prefs.LauncherSharedPrefs;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class LauncherProvider extends ContentProvider
{
  public static final String AUTHORITY = "com.oppo.launcher.settings";
  static final Uri CONTENT_APPWIDGET_RESET_URI = Uri.parse("content://com.oppo.launcher.settings/appWidgetReset");
  public static final String DATABASE_NAME_4x4 = "launcher_4x4.db";
  public static final String DATABASE_NAME_5x4 = "launcher.db";
  public static String DATABASE_PATH;
  public static final int DATABASE_VERSION = 27;
  private static final boolean DEBUG_CREATEDATABASES = false;
  private static final boolean DEBUG_ENABLE = false;
  private static final boolean DEBUG_SQL = false;
  private static final String NEW_WEATHER_WIDGET_CLASS_NAME = "com.coloros.widget.smallweather.OppoWeather";
  private static final String NEW_WEATHER_WIDGET_INTENT = "com.coloros.widget.smallweather/com.coloros.widget.smallweather.OppoWeather";
  private static final String OLD_WEATHER_WIDGET_CLASS_NAME = "com.oppo.widget.smallweather.OppoWeather";
  private static final String OLD_WEATHER_WIDGET_INTENT = "com.oppo.widget.smallweather/com.oppo.widget.smallweather.OppoWeather";
  public static final String PARAMETER_NOTIFY = "notify";
  private static final int SINGLE_DESKTOP_DEFAULT_PAGE_NUM = 3;
  public static final String TABLE_NEWINSTALL = "newinstall";
  public static final String TABLE_SINGLEDESKTOP_ITEMS = "singledesktopitems";
  public static final String TABLE_SINGLEDESKTOP_SCREENS = "singledesktopscreens";
  public static final String TABLE_SINGLEDESKTOP_SHORTCUT_BLACKLIST = "shortcutblacklist";
  public static final String TABLE_SINGLEDESKTOP_SHORTCUT_WHITELIST = "shortcutwhitelist";
  private static final String TAG = "LauncherProvider";
  private static String mCurrentDatabaseName;
  private DatabaseHelper mOpenHelper;

  static String buildOrWhereString(String paramString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      localStringBuilder.append(paramString).append("=").append(paramArrayOfInt[i]);
      if (i > 0)
        localStringBuilder.append(" OR ");
      i -= 1;
    }
    return localStringBuilder.toString();
  }

  private static long dbInsertAndCheck(DatabaseHelper paramDatabaseHelper, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("_id"))
      throw new RuntimeException("Error: attempting to add item without specifying an id");
    return paramSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
  }

  private static void deleteId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    SqlArguments localSqlArguments = new SqlArguments(LauncherSettings.SingleDeskTopItems.getContentUri(paramLong, false), null, null);
    paramSQLiteDatabase.delete(localSqlArguments.table, localSqlArguments.where, localSqlArguments.args);
  }

  private int queryScreenIdByIndex(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    int i = -1;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject4;
    try
    {
      String str = "screenNum=" + paramInt;
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramSQLiteDatabase = paramSQLiteDatabase.query("singledesktopscreens", new String[] { "screenId" }, str, null, null, null, null);
      if (paramSQLiteDatabase == null)
      {
        paramInt = i;
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.close();
          paramInt = i;
        }
      }
      do
      {
        do
        {
          return paramInt;
          localObject2 = paramSQLiteDatabase;
          localObject1 = paramSQLiteDatabase;
          paramInt = paramSQLiteDatabase.getColumnIndex("screenId");
          localObject2 = paramSQLiteDatabase;
          localObject1 = paramSQLiteDatabase;
          if (!paramSQLiteDatabase.moveToNext())
            break;
          localObject2 = paramSQLiteDatabase;
          localObject1 = paramSQLiteDatabase;
          paramInt = paramSQLiteDatabase.getInt(paramInt);
          i = paramInt;
          paramInt = i;
        }
        while (paramSQLiteDatabase == null);
        paramSQLiteDatabase.close();
        return i;
        paramInt = i;
      }
      while (paramSQLiteDatabase == null);
      paramSQLiteDatabase.close();
      return -1;
    }
    catch (Exception paramSQLiteDatabase)
    {
      localObject1 = localObject2;
      Log.e("LauncherProvider", "queryScreenIdByIndex --- e = " + paramSQLiteDatabase);
      paramInt = i;
      return -1;
    }
    finally
    {
      if (localObject1 != null)
        ((Cursor)localObject1).close();
    }
    throw paramSQLiteDatabase;
  }

  private void sendNotify(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("notify");
    if ((str == null) || ("true".equals(str)))
      getContext().getContentResolver().notifyChange(paramUri, null);
  }

  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    SqlArguments localSqlArguments = new SqlArguments(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int j = paramArrayOfContentValues.length;
      int i = 0;
      while (i < j)
      {
        long l = dbInsertAndCheck(this.mOpenHelper, localSQLiteDatabase, localSqlArguments.table, null, paramArrayOfContentValues[i]);
        if (l < 0L)
          return 0;
        i += 1;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      sendNotify(paramUri);
      return paramArrayOfContentValues.length;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e("LauncherProvider", "bulkInsert --- e = " + localException);
        localSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw paramUri;
  }

  public void clearWorkspaceScreenNewId()
  {
    this.mOpenHelper.clearWorkspaceScreenNewId();
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    paramArrayOfString = this.mOpenHelper.getWritableDatabase();
    int i = 0;
    try
    {
      int j = paramArrayOfString.delete(paramString.table, paramString.where, paramString.args);
      i = j;
      if (i > 0)
        sendNotify(paramUri);
      return i;
    }
    catch (Exception paramString)
    {
      while (true)
        Log.e("LauncherProvider", "delete --- e = " + paramString);
    }
  }

  public long generateNewId()
  {
    return this.mOpenHelper.generateNewId();
  }

  public long generateWorkspaceScreenNewId()
  {
    return this.mOpenHelper.generateWorkspaceScreenNewId();
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
    SqlArguments localSqlArguments = new SqlArguments(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
    long l = dbInsertAndCheck(this.mOpenHelper, localSQLiteDatabase, localSqlArguments.table, null, paramContentValues);
    if (l <= 0L)
      return null;
    paramUri = ContentUris.withAppendedId(paramUri, l);
    sendNotify(paramUri);
    return paramUri;
  }

  public boolean onCreate()
  {
    LauncherApplication localLauncherApplication = (LauncherApplication)getContext();
    ScreenGridUtils.initScreenGridNumData(localLauncherApplication);
    mCurrentDatabaseName = ScreenGridUtils.getDatabaseName(localLauncherApplication);
    DATABASE_PATH = "/data/data/com.oppo.launcher/databases/" + mCurrentDatabaseName;
    this.mOpenHelper = new DatabaseHelper(getContext());
    ((LauncherApplication)getContext()).setLauncherProvider(this);
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramArrayOfString2 = new SqlArguments(paramUri, paramString1, paramArrayOfString2);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables(paramArrayOfString2.table);
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
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
      Log.e("LauncherProvider", "query Exception  uri = " + paramUri);
    }
    return paramString1;
  }

  public void resetDatabaseHelper()
  {
    this.mOpenHelper = new DatabaseHelper(getContext());
    ((LauncherApplication)getContext()).setLauncherProvider(this);
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    paramArrayOfString = this.mOpenHelper.getWritableDatabase();
    int i = 0;
    try
    {
      int j = paramArrayOfString.update(paramString.table, paramContentValues, paramString.where, paramString.args);
      i = j;
      if (i > 0)
        sendNotify(paramUri);
      return i;
    }
    catch (Exception paramContentValues)
    {
      while (true)
        Log.e("LauncherProvider", "update --- e = " + paramContentValues);
    }
  }

  public void updateDockBarHotseatsMaxNumToFour(Context paramContext)
  {
    if (paramContext == null);
    while (true)
    {
      return;
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_PATH, null, 0);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        this.mOpenHelper.updateDockBarHotseatsMaxNumToFour(paramContext, localSQLiteDatabase);
        return;
      }
      catch (Exception paramContext)
      {
        localObject2 = localObject1;
        Log.e("LauncherProvider", "updateDockBarHotseatsMaxNumToFour --- e = " + paramContext);
        return;
      }
      finally
      {
        if (localObject2 != null)
          localObject2.close();
      }
    }
    throw paramContext;
  }

  private static class DatabaseHelper extends SQLiteOpenHelper
  {
    private static final String TAG_APPWIDGET = "appwidget";
    private static final String TAG_FAVORITE = "favorite";
    private static final String TAG_FAVORITES = "favorites";
    private static final String TAG_FOLDER = "folder";
    private static final String TAG_SHORTCUT = "shortcut";
    private int[][] mAllappsScreenIdTransformed = (int[][])null;
    private final AppWidgetHost mAppWidgetHost;
    int[] mCellXYTemp = new int[2];
    private final Context mContext;
    private SQLiteDatabase mDefaultSQLiteDatabase = null;
    int[] mEmptyCell = { -1, -1 };
    public HashMap<Integer, Integer> mFolderIdList = null;
    private long mMaxId = -1L;
    private ArrayList<String> mMergedAppList = null;
    int mPreScreenId = -1;
    private int[][] mWorkspaceScreenIdTransformed = (int[][])null;
    private long mWorkspaceScreenNewMaxId = -1L;

    DatabaseHelper(Context paramContext)
    {
      super(LauncherProvider.mCurrentDatabaseName, null, 27);
      this.mContext = paramContext;
      this.mAppWidgetHost = new AppWidgetHost(paramContext, 1024);
      if (this.mWorkspaceScreenNewMaxId == -1L);
      try
      {
        this.mWorkspaceScreenNewMaxId = initializeWorkspaceScreenMaxId(getWritableDatabase());
        if (this.mMaxId == -1L)
          this.mMaxId = initializeMaxId(getWritableDatabase());
        return;
      }
      catch (SQLiteException paramContext)
      {
        while (true)
        {
          Log.w("LauncherProvider", " OppoLauncher could not open read/ write database ,try to open read database begin ");
          getReadableDatabase();
          Log.w("LauncherProvider", " OppoLauncher could not open read/ write database ,try to open read database end ");
          Process.killProcess(Process.myPid());
        }
      }
    }

    // ERROR //
    private long addAppShortcut(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, TypedArray paramTypedArray, PackageManager paramPackageManager)
    {
      // Byte code:
      //   0: ldc2_w 58
      //   3: lstore 14
      //   5: aload_3
      //   6: iconst_2
      //   7: invokevirtual 136	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
      //   10: astore 6
      //   12: aload_3
      //   13: iconst_0
      //   14: invokevirtual 136	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
      //   17: astore 7
      //   19: aload_2
      //   20: ldc 138
      //   22: invokevirtual 144	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
      //   25: invokevirtual 150	java/lang/Long:longValue	()J
      //   28: lstore 12
      //   30: aload_2
      //   31: ldc 152
      //   33: invokevirtual 156	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
      //   36: invokevirtual 161	java/lang/Integer:intValue	()I
      //   39: istore 10
      //   41: aload_2
      //   42: ldc 163
      //   44: invokevirtual 156	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
      //   47: invokevirtual 161	java/lang/Integer:intValue	()I
      //   50: istore 11
      //   52: lload 12
      //   54: ldc2_w 164
      //   57: lcmp
      //   58: ifeq +351 -> 409
      //   61: lload 12
      //   63: ldc2_w 166
      //   66: lcmp
      //   67: ifeq +342 -> 409
      //   70: iconst_1
      //   71: istore 9
      //   73: iload 9
      //   75: ifne +31 -> 106
      //   78: iload 10
      //   80: aload_0
      //   81: getfield 76	com/oppo/launcher/LauncherProvider$DatabaseHelper:mEmptyCell	[I
      //   84: iconst_0
      //   85: iaload
      //   86: if_icmpne +20 -> 106
      //   89: iload 11
      //   91: aload_0
      //   92: getfield 76	com/oppo/launcher/LauncherProvider$DatabaseHelper:mEmptyCell	[I
      //   95: iconst_1
      //   96: iaload
      //   97: if_icmpne +9 -> 106
      //   100: aload_0
      //   101: iconst_m1
      //   102: iconst_m1
      //   103: invokespecial 171	com/oppo/launcher/LauncherProvider$DatabaseHelper:setEmptyCell	(II)V
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 82	com/oppo/launcher/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   111: aload 6
      //   113: invokespecial 175	com/oppo/launcher/LauncherProvider$DatabaseHelper:findActivitiesForPackage	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;
      //   116: astore 8
      //   118: aload 8
      //   120: invokeinterface 180 1 0
      //   125: iconst_1
      //   126: if_icmpne +289 -> 415
      //   129: aload 8
      //   131: iconst_0
      //   132: invokeinterface 184 2 0
      //   137: checkcast 186	android/content/pm/ResolveInfo
      //   140: getfield 190	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   143: getfield 195	android/content/pm/ActivityInfo:name	Ljava/lang/String;
      //   146: astore_3
      //   147: aload 6
      //   149: astore 5
      //   151: aload 4
      //   153: new 197	android/content/ComponentName
      //   156: dup
      //   157: aload 5
      //   159: aload_3
      //   160: invokespecial 200	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   163: iconst_0
      //   164: invokevirtual 206	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
      //   167: astore 6
      //   169: lload 14
      //   171: lstore 12
      //   173: aload_0
      //   174: invokevirtual 209	com/oppo/launcher/LauncherProvider$DatabaseHelper:generateNewId	()J
      //   177: lstore 14
      //   179: lload 14
      //   181: lstore 12
      //   183: aload_2
      //   184: ldc 211
      //   186: aload 5
      //   188: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   191: lload 14
      //   193: lstore 12
      //   195: aload_2
      //   196: ldc 216
      //   198: aload_3
      //   199: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   202: lload 14
      //   204: lstore 12
      //   206: aload_2
      //   207: ldc 218
      //   209: aload 6
      //   211: aload 4
      //   213: invokevirtual 222	android/content/pm/ActivityInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   216: invokeinterface 227 1 0
      //   221: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   224: lload 14
      //   226: lstore 12
      //   228: aload_2
      //   229: ldc 229
      //   231: iconst_0
      //   232: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   235: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   238: lload 14
      //   240: lstore 12
      //   242: aload_2
      //   243: ldc 238
      //   245: iconst_1
      //   246: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   249: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   252: lload 14
      //   254: lstore 12
      //   256: aload_2
      //   257: ldc 240
      //   259: iconst_1
      //   260: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   263: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   266: lload 14
      //   268: lstore 12
      //   270: aload_2
      //   271: ldc 242
      //   273: lload 14
      //   275: invokestatic 245	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   278: invokevirtual 248	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   281: lload 14
      //   283: lstore 12
      //   285: aload_2
      //   286: ldc 250
      //   288: aload_0
      //   289: aload_0
      //   290: getfield 82	com/oppo/launcher/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   293: aload 5
      //   295: invokespecial 254	com/oppo/launcher/LauncherProvider$DatabaseHelper:getAppInstalledLocation	(Landroid/content/Context;Ljava/lang/String;)I
      //   298: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   301: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   304: iload 9
      //   306: ifne +52 -> 358
      //   309: lload 14
      //   311: lstore 12
      //   313: aload_0
      //   314: invokespecial 258	com/oppo/launcher/LauncherProvider$DatabaseHelper:isEmptyCellExist	()Z
      //   317: ifeq +41 -> 358
      //   320: lload 14
      //   322: lstore 12
      //   324: aload_2
      //   325: ldc 152
      //   327: aload_0
      //   328: getfield 76	com/oppo/launcher/LauncherProvider$DatabaseHelper:mEmptyCell	[I
      //   331: iconst_0
      //   332: iaload
      //   333: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   336: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   339: lload 14
      //   341: lstore 12
      //   343: aload_2
      //   344: ldc 163
      //   346: aload_0
      //   347: getfield 76	com/oppo/launcher/LauncherProvider$DatabaseHelper:mEmptyCell	[I
      //   350: iconst_1
      //   351: iaload
      //   352: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   355: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   358: lload 14
      //   360: lstore 12
      //   362: aload_0
      //   363: aload_1
      //   364: ldc_w 260
      //   367: aconst_null
      //   368: aload_2
      //   369: invokestatic 264	com/oppo/launcher/LauncherProvider:access$100	(Lcom/oppo/launcher/LauncherProvider$DatabaseHelper;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   372: lconst_0
      //   373: lcmp
      //   374: ifge +158 -> 532
      //   377: iload 9
      //   379: ifne +26 -> 405
      //   382: lload 14
      //   384: lstore 12
      //   386: aload_0
      //   387: invokespecial 258	com/oppo/launcher/LauncherProvider$DatabaseHelper:isEmptyCellExist	()Z
      //   390: ifne +15 -> 405
      //   393: lload 14
      //   395: lstore 12
      //   397: aload_0
      //   398: iload 10
      //   400: iload 11
      //   402: invokespecial 171	com/oppo/launcher/LauncherProvider$DatabaseHelper:setEmptyCell	(II)V
      //   405: ldc2_w 58
      //   408: lreturn
      //   409: iconst_0
      //   410: istore 9
      //   412: goto -339 -> 73
      //   415: aload 7
      //   417: astore_3
      //   418: aload 6
      //   420: astore 5
      //   422: aload 8
      //   424: invokeinterface 180 1 0
      //   429: ifne -278 -> 151
      //   432: iload 9
      //   434: ifne +18 -> 452
      //   437: aload_0
      //   438: invokespecial 258	com/oppo/launcher/LauncherProvider$DatabaseHelper:isEmptyCellExist	()Z
      //   441: ifne +11 -> 452
      //   444: aload_0
      //   445: iload 10
      //   447: iload 11
      //   449: invokespecial 171	com/oppo/launcher/LauncherProvider$DatabaseHelper:setEmptyCell	(II)V
      //   452: aload 4
      //   454: iconst_1
      //   455: anewarray 266	java/lang/String
      //   458: dup
      //   459: iconst_0
      //   460: aload 6
      //   462: aastore
      //   463: invokevirtual 270	android/content/pm/PackageManager:canonicalToCurrentPackageNames	([Ljava/lang/String;)[Ljava/lang/String;
      //   466: astore_3
      //   467: aload_3
      //   468: ifnull +8 -> 476
      //   471: aload_3
      //   472: arraylength
      //   473: ifgt +7 -> 480
      //   476: ldc2_w 58
      //   479: lreturn
      //   480: aload_3
      //   481: iconst_0
      //   482: aaload
      //   483: astore 5
      //   485: aload 7
      //   487: astore_3
      //   488: goto -337 -> 151
      //   491: astore 6
      //   493: lload 14
      //   495: lstore 12
      //   497: aload 4
      //   499: new 197	android/content/ComponentName
      //   502: dup
      //   503: aload 4
      //   505: iconst_1
      //   506: anewarray 266	java/lang/String
      //   509: dup
      //   510: iconst_0
      //   511: aload 5
      //   513: aastore
      //   514: invokevirtual 273	android/content/pm/PackageManager:currentToCanonicalPackageNames	([Ljava/lang/String;)[Ljava/lang/String;
      //   517: iconst_0
      //   518: aaload
      //   519: aload_3
      //   520: invokespecial 200	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   523: iconst_0
      //   524: invokevirtual 206	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
      //   527: astore 6
      //   529: goto -360 -> 169
      //   532: lload 14
      //   534: lstore 16
      //   536: iload 9
      //   538: ifne +58 -> 596
      //   541: lload 14
      //   543: lstore 16
      //   545: lload 14
      //   547: lstore 12
      //   549: aload_0
      //   550: invokespecial 258	com/oppo/launcher/LauncherProvider$DatabaseHelper:isEmptyCellExist	()Z
      //   553: ifeq +43 -> 596
      //   556: lload 14
      //   558: lstore 12
      //   560: aload_0
      //   561: aload_0
      //   562: getfield 76	com/oppo/launcher/LauncherProvider$DatabaseHelper:mEmptyCell	[I
      //   565: aload_0
      //   566: getfield 80	com/oppo/launcher/LauncherProvider$DatabaseHelper:mCellXYTemp	[I
      //   569: invokespecial 277	com/oppo/launcher/LauncherProvider$DatabaseHelper:getNextCell	([I[I)V
      //   572: lload 14
      //   574: lstore 12
      //   576: aload_0
      //   577: aload_0
      //   578: getfield 80	com/oppo/launcher/LauncherProvider$DatabaseHelper:mCellXYTemp	[I
      //   581: iconst_0
      //   582: iaload
      //   583: aload_0
      //   584: getfield 80	com/oppo/launcher/LauncherProvider$DatabaseHelper:mCellXYTemp	[I
      //   587: iconst_1
      //   588: iaload
      //   589: invokespecial 171	com/oppo/launcher/LauncherProvider$DatabaseHelper:setEmptyCell	(II)V
      //   592: lload 14
      //   594: lstore 16
      //   596: lload 16
      //   598: lreturn
      //   599: astore_1
      //   600: ldc 102
      //   602: new 279	java/lang/StringBuilder
      //   605: dup
      //   606: invokespecial 282	java/lang/StringBuilder:<init>	()V
      //   609: ldc_w 284
      //   612: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   615: aload 5
      //   617: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   620: ldc_w 290
      //   623: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   626: aload_3
      //   627: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   633: aload_1
      //   634: invokestatic 294	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   637: pop
      //   638: lload 12
      //   640: lstore 16
      //   642: iload 9
      //   644: ifne -48 -> 596
      //   647: lload 12
      //   649: lstore 16
      //   651: aload_0
      //   652: invokespecial 258	com/oppo/launcher/LauncherProvider$DatabaseHelper:isEmptyCellExist	()Z
      //   655: ifne -59 -> 596
      //   658: aload_0
      //   659: iload 10
      //   661: iload 11
      //   663: invokespecial 171	com/oppo/launcher/LauncherProvider$DatabaseHelper:setEmptyCell	(II)V
      //   666: lload 12
      //   668: lstore 16
      //   670: goto -74 -> 596
      //
      // Exception table:
      //   from	to	target	type
      //   151	169	491	android/content/pm/PackageManager$NameNotFoundException
      //   173	179	599	android/content/pm/PackageManager$NameNotFoundException
      //   183	191	599	android/content/pm/PackageManager$NameNotFoundException
      //   195	202	599	android/content/pm/PackageManager$NameNotFoundException
      //   206	224	599	android/content/pm/PackageManager$NameNotFoundException
      //   228	238	599	android/content/pm/PackageManager$NameNotFoundException
      //   242	252	599	android/content/pm/PackageManager$NameNotFoundException
      //   256	266	599	android/content/pm/PackageManager$NameNotFoundException
      //   270	281	599	android/content/pm/PackageManager$NameNotFoundException
      //   285	304	599	android/content/pm/PackageManager$NameNotFoundException
      //   313	320	599	android/content/pm/PackageManager$NameNotFoundException
      //   324	339	599	android/content/pm/PackageManager$NameNotFoundException
      //   343	358	599	android/content/pm/PackageManager$NameNotFoundException
      //   362	377	599	android/content/pm/PackageManager$NameNotFoundException
      //   386	393	599	android/content/pm/PackageManager$NameNotFoundException
      //   397	405	599	android/content/pm/PackageManager$NameNotFoundException
      //   497	529	599	android/content/pm/PackageManager$NameNotFoundException
      //   549	556	599	android/content/pm/PackageManager$NameNotFoundException
      //   560	572	599	android/content/pm/PackageManager$NameNotFoundException
      //   576	592	599	android/content/pm/PackageManager$NameNotFoundException
    }

    private boolean addAppWidget(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, ComponentName paramComponentName, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      boolean bool2 = false;
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this.mContext);
      boolean bool1 = bool2;
      try
      {
        int i = this.mAppWidgetHost.allocateAppWidgetId();
        bool1 = bool2;
        paramContentValues.put("intent", paramComponentName.getPackageName());
        bool1 = bool2;
        paramContentValues.put("className", paramComponentName.getClassName());
        bool1 = bool2;
        paramContentValues.put("itemType", Integer.valueOf(5));
        bool1 = bool2;
        paramContentValues.put("spanX", Integer.valueOf(paramInt1));
        bool1 = bool2;
        paramContentValues.put("spanY", Integer.valueOf(paramInt2));
        bool1 = bool2;
        paramContentValues.put("appWidgetId", Integer.valueOf(i));
        bool1 = bool2;
        paramContentValues.put("_id", Long.valueOf(generateNewId()));
        bool1 = bool2;
        paramContentValues.put("modelState", Integer.valueOf(getAppInstalledLocation(this.mContext, paramComponentName.getPackageName())));
        if (paramBoolean)
        {
          bool1 = bool2;
          paramContentValues.put("intent", paramComponentName.flattenToString());
          bool1 = bool2;
          paramContentValues.put("appWidgetId", Integer.valueOf(-150));
        }
        bool1 = bool2;
        LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "singledesktopitems", null, paramContentValues);
        bool1 = true;
        localAppWidgetManager.bindAppWidgetId(i, paramComponentName);
        return true;
      }
      catch (RuntimeException paramSQLiteDatabase)
      {
        Log.e("LauncherProvider", "Problem allocating appWidgetId", paramSQLiteDatabase);
      }
      return bool1;
    }

    private boolean addAppWidget(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, TypedArray paramTypedArray, PackageManager paramPackageManager)
    {
      String str1 = paramTypedArray.getString(2);
      String str2 = paramTypedArray.getString(0);
      Object localObject = paramTypedArray.getString(13);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((String)localObject).equals("1"))
          bool1 = true;
      }
      if ((str1 == null) || (str2 == null))
        return false;
      int i = 1;
      localObject = new ComponentName(str1, str2);
      try
      {
        paramPackageManager.getReceiverInfo((ComponentName)localObject, 0);
        paramPackageManager = (PackageManager)localObject;
        if (i != 0)
          return addAppWidget(paramSQLiteDatabase, paramContentValues, paramPackageManager, paramTypedArray.getInt(7, 0), paramTypedArray.getInt(8, 0), bool1);
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.w("LauncherProvider", "addAppWidget --  get receiver info failed(1): ", localException);
          localObject = new ComponentName(paramPackageManager.currentToCanonicalPackageNames(new String[] { str1 })[0], str2);
          try
          {
            paramPackageManager.getReceiverInfo((ComponentName)localObject, 0);
            paramPackageManager = (PackageManager)localObject;
          }
          catch (Exception paramPackageManager)
          {
            Log.w("LauncherProvider", "addAppWidget --  get receiver info failed(2): ", localException);
            i = 0;
            paramPackageManager = (PackageManager)localObject;
          }
        }
      }
      return false;
    }

    private long addFolder(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
    {
      paramContentValues.put("itemType", Integer.valueOf(3));
      paramContentValues.put("spanX", Integer.valueOf(1));
      paramContentValues.put("spanY", Integer.valueOf(1));
      paramContentValues.put("modelState", Integer.valueOf(0));
      long l2 = generateNewId();
      paramContentValues.put("_id", Long.valueOf(l2));
      int i = paramContentValues.getAsInteger("cellX").intValue();
      int j = paramContentValues.getAsInteger("cellY").intValue();
      if (isEmptyCellExist())
      {
        paramContentValues.put("cellX", Integer.valueOf(this.mEmptyCell[0]));
        paramContentValues.put("cellY", Integer.valueOf(this.mEmptyCell[1]));
      }
      long l1;
      if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "singledesktopitems", null, paramContentValues) <= 0L)
      {
        if (!isEmptyCellExist())
          setEmptyCell(i, j);
        l1 = -1L;
      }
      do
      {
        return l1;
        l1 = l2;
      }
      while (!isEmptyCellExist());
      getNextCell(this.mEmptyCell, this.mCellXYTemp);
      setEmptyCell(this.mCellXYTemp[0], this.mCellXYTemp[1]);
      return l2;
    }

    private long addUriShortcut(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, TypedArray paramTypedArray)
    {
      Resources localResources = this.mContext.getResources();
      int j = 0;
      int i = paramTypedArray.getResourceId(9, 0);
      int k = paramTypedArray.getResourceId(10, 0);
      TypedArray localTypedArray = null;
      do
      {
        try
        {
          paramTypedArray = paramTypedArray.getString(11);
          localTypedArray = paramTypedArray;
          paramTypedArray = Intent.parseUri(paramTypedArray, 0);
          if ((i == 0) || (k == 0))
          {
            Log.w("LauncherProvider", "Shortcut is missing title or icon resource ID");
            l = -1L;
            return l;
          }
        }
        catch (URISyntaxException paramSQLiteDatabase)
        {
          Log.w("LauncherProvider", "Shortcut has malformed uri: " + localTypedArray);
          return -1L;
        }
        long l = generateNewId();
        paramTypedArray.setFlags(268435456);
        paramContentValues.put("intent", paramTypedArray.toUri(0));
        paramContentValues.put("title", localResources.getString(k));
        paramContentValues.put("itemType", Integer.valueOf(1));
        paramContentValues.put("spanX", Integer.valueOf(1));
        paramContentValues.put("spanY", Integer.valueOf(1));
        paramContentValues.put("iconType", Integer.valueOf(0));
        paramContentValues.put("iconPackage", this.mContext.getPackageName());
        paramContentValues.put("iconResource", localResources.getResourceName(i));
        paramContentValues.put("_id", Long.valueOf(l));
        i = j;
        if (paramTypedArray != null)
        {
          i = j;
          if (paramTypedArray.getComponent() != null)
          {
            paramTypedArray = paramTypedArray.getComponent().getPackageName();
            i = getAppInstalledLocation(this.mContext, paramTypedArray);
          }
        }
        paramContentValues.put("modelState", Integer.valueOf(i));
      }
      while (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "singledesktopitems", null, paramContentValues) >= 0L);
      return -1L;
    }

    private int copyFromCursor(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
    {
      int j = paramCursor.getColumnIndexOrThrow("_id");
      int k = paramCursor.getColumnIndexOrThrow("intent");
      int m = paramCursor.getColumnIndexOrThrow("title");
      int n = paramCursor.getColumnIndexOrThrow("iconType");
      int i1 = paramCursor.getColumnIndexOrThrow("icon");
      int i2 = paramCursor.getColumnIndexOrThrow("iconPackage");
      int i3 = paramCursor.getColumnIndexOrThrow("iconResource");
      int i4 = paramCursor.getColumnIndexOrThrow("container");
      int i5 = paramCursor.getColumnIndexOrThrow("itemType");
      int i6 = paramCursor.getColumnIndexOrThrow("screenId");
      int i7 = paramCursor.getColumnIndexOrThrow("cellX");
      int i8 = paramCursor.getColumnIndexOrThrow("cellY");
      int i9 = paramCursor.getColumnIndexOrThrow("uri");
      int i10 = paramCursor.getColumnIndexOrThrow("displayMode");
      ContentValues[] arrayOfContentValues = new ContentValues[paramCursor.getCount()];
      int i = 0;
      while (paramCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues(paramCursor.getColumnCount());
        localContentValues.put("_id", Long.valueOf(paramCursor.getLong(j)));
        localContentValues.put("intent", paramCursor.getString(k));
        localContentValues.put("title", paramCursor.getString(m));
        localContentValues.put("iconType", Integer.valueOf(paramCursor.getInt(n)));
        localContentValues.put("icon", paramCursor.getBlob(i1));
        localContentValues.put("iconPackage", paramCursor.getString(i2));
        localContentValues.put("iconResource", paramCursor.getString(i3));
        localContentValues.put("container", Integer.valueOf(paramCursor.getInt(i4)));
        localContentValues.put("itemType", Integer.valueOf(paramCursor.getInt(i5)));
        localContentValues.put("appWidgetId", Integer.valueOf(-1));
        localContentValues.put("screenId", Integer.valueOf(paramCursor.getInt(i6)));
        localContentValues.put("cellX", Integer.valueOf(paramCursor.getInt(i7)));
        localContentValues.put("cellY", Integer.valueOf(paramCursor.getInt(i8)));
        localContentValues.put("uri", paramCursor.getString(i9));
        localContentValues.put("displayMode", Integer.valueOf(paramCursor.getInt(i10)));
        arrayOfContentValues[i] = localContentValues;
        i += 1;
      }
      paramSQLiteDatabase.beginTransaction();
      j = 0;
      i = 0;
      try
      {
        m = arrayOfContentValues.length;
        k = 0;
        while (k < m)
        {
          j = i;
          long l = LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "singledesktopitems", null, arrayOfContentValues[k]);
          if (l < 0L)
            return 0;
          i += 1;
          k += 1;
        }
        j = i;
        paramSQLiteDatabase.setTransactionSuccessful();
        return i;
      }
      catch (Exception paramCursor)
      {
        while (true)
        {
          Log.e("LauncherProvider", "copyFromCursor --- e = " + paramCursor);
          paramSQLiteDatabase.endTransaction();
          i = j;
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      throw paramCursor;
    }

    private long createFolderInDockBar(Context paramContext, SQLiteDatabase paramSQLiteDatabase, int paramInt)
    {
      long l = generateNewId();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_id", Long.valueOf(l));
      localContentValues.put("title", paramContext.getText(2131427330).toString());
      localContentValues.put("itemType", Integer.valueOf(3));
      localContentValues.put("container", Integer.valueOf(-101));
      localContentValues.put("screenId", Integer.valueOf(999));
      localContentValues.put("cellX", Integer.valueOf(paramInt));
      localContentValues.put("cellY", Integer.valueOf(0));
      localContentValues.put("spanX", Integer.valueOf(1));
      localContentValues.put("spanY", Integer.valueOf(1));
      paramSQLiteDatabase.insert("singledesktopitems", null, localContentValues);
      return l;
    }

    private void createTableNewInstalled(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE newinstall (_id INTEGER PRIMARY KEY,packagename TEXT,newinstallflag INTEGER);");
    }

    private void createTableSingleDeskTopItems(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE singledesktopitems (_id INTEGER PRIMARY KEY,title TEXT,intent TEXT,packageName TEXT,className TEXT,container INTEGER,screenId INTEGER,cellX INTEGER,cellY INTEGER,spanX INTEGER DEFAULT 1,spanY INTEGER DEFAULT 1,itemType INTEGER,appWidgetId INTEGER NOT NULL DEFAULT -1,isFileShortcut INTEGER,iconType INTEGER,iconPackage TEXT,iconResource TEXT,icon BLOB,uri TEXT,displayMode INTEGER,modelState INTEGER);");
    }

    private void createTableSingleDeskTopScreens(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE singledesktopscreens (_id INTEGER PRIMARY KEY,screenId INTEGER,screenNum INTEGER);");
    }

    private void createTableSingleDeskTopShortcutWhiteList(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE shortcutwhitelist (_id INTEGER PRIMARY KEY,itemName TEXT,itemType INTEGER);");
    }

    private List<ResolveInfo> findActivitiesForPackage(Context paramContext, String paramString)
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

    private int getAppInstalledLocation(Context paramContext, String paramString)
    {
      int i = 0;
      paramContext = paramContext.getPackageManager();
      try
      {
        int j = paramContext.getApplicationInfo(paramString, 0).flags;
        if ((j & 0x40000) != 0)
          i = 1;
        return i;
      }
      catch (Exception paramContext)
      {
        Log.e("LauncherProvider", " Exception: " + paramContext);
      }
      return 0;
    }

    private int getIdleScreenId(ArrayList<Integer> paramArrayList)
    {
      int i = 1000;
      while (i <= 1026)
        if (paramArrayList.contains(Integer.valueOf(i)))
        {
          i += 1;
        }
        else
        {
          paramArrayList.add(Integer.valueOf(i));
          return i;
        }
      return 0;
    }

    private void getNextCell(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2 == null)
        arrayOfInt = new int[2];
      int i = ScreenGridUtils.getScreenXGridNum();
      if ((paramArrayOfInt1[0] >= i) || (paramArrayOfInt1[1] >= ScreenGridUtils.getScreenYGridNum()))
      {
        arrayOfInt[0] = -1;
        arrayOfInt[1] = -1;
        Log.w("LauncherProvider", "getNextCell --- the cellX or cellY out of range");
        return;
      }
      int j = paramArrayOfInt1[1] * i + paramArrayOfInt1[0];
      arrayOfInt[0] = ((j + 1) % i);
      arrayOfInt[1] = ((j + 1) / i);
    }

    private ComponentName getProviderInPackage(String paramString)
    {
      Object localObject = AppWidgetManager.getInstance(this.mContext);
      localObject = Utilities.getAllAppWidgetsProviders(this.mContext, (AppWidgetManager)localObject);
      if (localObject == null)
        return null;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ComponentName localComponentName = ((AppWidgetProviderInfo)((Iterator)localObject).next()).provider;
        if ((localComponentName != null) && (localComponentName.getPackageName().equals(paramString)))
          return localComponentName;
      }
      return null;
    }

    private void initInstalledLocationToItems(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      try
      {
        localCursor = paramSQLiteDatabase.query("singledesktopitems", new String[] { "_id", "packageName" }, "itemType=0", null, null, null, null);
        localObject2 = localCursor;
        localObject3 = localCursor;
        localObject1 = localCursor;
        int j = localCursor.getColumnIndexOrThrow("_id");
        localObject2 = localCursor;
        localObject3 = localCursor;
        localObject1 = localCursor;
        int k = localCursor.getColumnIndexOrThrow("packageName");
        int i = 0;
        while (true)
        {
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          if (!localCursor.moveToNext())
            break;
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          int m = localCursor.getInt(j);
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          Object localObject4 = localCursor.getString(k);
          if (localObject4 != null)
          {
            localObject2 = localCursor;
            localObject3 = localCursor;
            localObject1 = localCursor;
            i = getAppInstalledLocation(this.mContext, (String)localObject4);
          }
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          localObject4 = new ContentValues();
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          ((ContentValues)localObject4).put("modelState", Integer.valueOf(i));
          localObject2 = localCursor;
          localObject3 = localCursor;
          localObject1 = localCursor;
          paramSQLiteDatabase.update("singledesktopitems", (ContentValues)localObject4, "_id=" + m, null);
        }
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        Cursor localCursor;
        localObject1 = localObject2;
        Log.w("LauncherProvider", "initInstalledLocationToItems -- ", paramSQLiteDatabase);
        return;
        return;
      }
      catch (CursorWindowAllocationException paramSQLiteDatabase)
      {
        localObject1 = localObject3;
        Log.w("LauncherProvider", paramSQLiteDatabase);
        return;
      }
      finally
      {
        if (localObject1 != null)
          localObject1.close();
      }
      throw paramSQLiteDatabase;
    }

    private void initSingleDeskTopItems(SQLiteDatabase paramSQLiteDatabase)
    {
      loadDefaultItems(paramSQLiteDatabase, ExpRegionHandler.getWorkspaceXml(this.mContext));
    }

    private void initSingleDeskTopScreens(SQLiteDatabase paramSQLiteDatabase)
    {
      int i = 0;
      while (i < 3)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("_id", Long.valueOf(generateWorkspaceScreenNewId()));
        localContentValues.put("screenId", Integer.valueOf(i + 1000));
        localContentValues.put("screenNum", Integer.valueOf(i));
        paramSQLiteDatabase.insert("singledesktopscreens", null, localContentValues);
        i += 1;
      }
    }

    private long initializeMaxId(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      long l3 = -1L;
      long l2 = l3;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT MAX(_id) FROM singledesktopitems", null);
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
          throw new RuntimeException("Error: could not query favorites max id");
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        long l1;
        localObject = localSQLiteDatabase;
        Log.e("LauncherProvider", "initializeMaxId --- e = " + paramSQLiteDatabase);
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

    private long initializeWorkspaceScreenMaxId(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      long l3 = -1L;
      long l2 = l3;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT MAX(_id) FROM singledesktopscreens", null);
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
          throw new RuntimeException("Error: could not query workspacescreens max id");
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        long l1;
        localObject = localSQLiteDatabase;
        Log.e("LauncherProvider", "initializeWorkspaceScreenMaxId --- e = " + paramSQLiteDatabase);
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

    private boolean isEmptyCellExist()
    {
      return (this.mEmptyCell[0] != -1) && (this.mEmptyCell[1] != -1);
    }

    private boolean isInstalledLocationColumnExist(SQLiteDatabase paramSQLiteDatabase)
    {
      SQLiteDatabase localSQLiteDatabase2 = null;
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase1 = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("singledesktopitems", new String[] { "modelState" }, null, null, null, null, null);
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase1 = paramSQLiteDatabase;
          localSQLiteDatabase2 = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          int i = paramSQLiteDatabase.getCount();
          if (i > 0)
          {
            if (paramSQLiteDatabase != null)
              paramSQLiteDatabase.close();
            return true;
          }
        }
        if (paramSQLiteDatabase != null)
          paramSQLiteDatabase.close();
        return false;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        while (true)
        {
          localObject = localSQLiteDatabase1;
          Log.w("LauncherProvider", paramSQLiteDatabase);
          if (localSQLiteDatabase1 != null)
            localSQLiteDatabase1.close();
        }
      }
      catch (CursorWindowAllocationException paramSQLiteDatabase)
      {
        while (true)
        {
          localObject = localSQLiteDatabase2;
          Log.w("LauncherProvider", paramSQLiteDatabase);
          if (localSQLiteDatabase2 != null)
            localSQLiteDatabase2.close();
        }
      }
      finally
      {
        if (localObject != null)
          ((Cursor)localObject).close();
      }
      throw paramSQLiteDatabase;
    }

    private boolean isTableNull(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT _id FROM " + paramString, null);
        if (paramSQLiteDatabase != null)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          boolean bool = paramSQLiteDatabase.moveToNext();
          if (bool)
          {
            if (paramSQLiteDatabase != null)
              paramSQLiteDatabase.close();
            return false;
          }
        }
        if (paramSQLiteDatabase != null)
          paramSQLiteDatabase.close();
        return true;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        while (true)
        {
          localObject = localSQLiteDatabase;
          Log.w("LauncherProvider", "isTableNull tableName = " + paramString, paramSQLiteDatabase);
          if (localSQLiteDatabase != null)
            localSQLiteDatabase.close();
        }
      }
      finally
      {
        if (localObject != null)
          ((Cursor)localObject).close();
      }
      throw paramSQLiteDatabase;
    }

    private void loadDefaultItems(SQLiteDatabase paramSQLiteDatabase, int paramInt)
    {
      ContentValues localContentValues = new ContentValues();
      PackageManager localPackageManager = this.mContext.getPackageManager();
      while (true)
      {
        XmlResourceParser localXmlResourceParser;
        AttributeSet localAttributeSet;
        Object localObject1;
        TypedArray localTypedArray;
        long l1;
        Object localObject2;
        String str1;
        String str2;
        try
        {
          localXmlResourceParser = this.mContext.getResources().getXml(paramInt);
          localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
          Utilities.beginDocument(localXmlResourceParser, "favorites");
          int i = localXmlResourceParser.getDepth();
          paramInt = localXmlResourceParser.next();
          if (((paramInt != 3) || (localXmlResourceParser.getDepth() > i)) && (paramInt != 1))
          {
            if (paramInt != 2)
              continue;
            localObject1 = localXmlResourceParser.getName();
            localTypedArray = this.mContext.obtainStyledAttributes(localAttributeSet, R.styleable.Favorite);
            l1 = -100L;
            if (localTypedArray.hasValue(3))
              l1 = Long.valueOf(localTypedArray.getString(3)).longValue();
            localObject2 = localTypedArray.getString(4);
            str1 = localTypedArray.getString(5);
            str2 = localTypedArray.getString(6);
            localContentValues.clear();
            localContentValues.put("container", Long.valueOf(l1));
            if (l1 != -101L)
              continue;
            paramInt = 999;
            if (this.mPreScreenId != paramInt)
            {
              this.mPreScreenId = paramInt;
              setEmptyCell(-1, -1);
            }
            localContentValues.put("screenId", Integer.valueOf(paramInt));
            localContentValues.put("cellX", str1);
            localContentValues.put("cellY", str2);
            if (!"favorite".equals(localObject1))
              continue;
            addAppShortcut(paramSQLiteDatabase, localContentValues, localTypedArray, localPackageManager);
            localTypedArray.recycle();
            continue;
          }
        }
        catch (XmlPullParserException paramSQLiteDatabase)
        {
          Log.w("LauncherProvider", "Got exception parsing favorites.", paramSQLiteDatabase);
          return;
          paramInt = changeScreenToScreenId(Integer.parseInt((String)localObject2));
          continue;
          if ("appwidget".equals(localObject1))
          {
            addAppWidget(paramSQLiteDatabase, localContentValues, localTypedArray, localPackageManager);
            continue;
          }
        }
        catch (IOException paramSQLiteDatabase)
        {
          Log.w("LauncherProvider", "Got exception parsing favorites.", paramSQLiteDatabase);
          return;
          if ("shortcut".equals(localObject1))
          {
            addUriShortcut(paramSQLiteDatabase, localContentValues, localTypedArray);
            continue;
          }
        }
        catch (RuntimeException paramSQLiteDatabase)
        {
          Log.w("LauncherProvider", "Got exception parsing favorites.", paramSQLiteDatabase);
          return;
        }
        if ("folder".equals(localObject1))
        {
          localContentValues.put("title", " " + localTypedArray.getString(12));
          l1 = addFolder(paramSQLiteDatabase, localContentValues);
          localObject1 = new ArrayList();
          paramInt = localXmlResourceParser.getDepth();
          int j;
          do
          {
            j = localXmlResourceParser.next();
            if ((j == 3) && (localXmlResourceParser.getDepth() <= paramInt))
              break;
          }
          while (j != 2);
          str1 = localXmlResourceParser.getName();
          localObject2 = this.mContext.obtainStyledAttributes(localAttributeSet, R.styleable.Favorite);
          localContentValues.clear();
          localContentValues.put("container", Long.valueOf(l1));
          long l2;
          if (("favorite".equals(str1)) && (l1 >= 0L))
          {
            str1 = localTypedArray.getString(4);
            str2 = localTypedArray.getString(5);
            String str3 = localTypedArray.getString(6);
            localContentValues.put("screenId", Integer.valueOf(changeScreenToScreenId(Integer.parseInt(str1))));
            localContentValues.put("cellX", str2);
            localContentValues.put("cellY", str3);
            l2 = addAppShortcut(paramSQLiteDatabase, localContentValues, (TypedArray)localObject2, localPackageManager);
            if (l2 >= 0L)
              ((ArrayList)localObject1).add(Long.valueOf(l2));
          }
          while (true)
          {
            ((TypedArray)localObject2).recycle();
            break;
            if ((!"shortcut".equals(str1)) || (l1 < 0L))
              break label662;
            l2 = addUriShortcut(paramSQLiteDatabase, localContentValues, (TypedArray)localObject2);
            if (l2 >= 0L)
              ((ArrayList)localObject1).add(Long.valueOf(l2));
          }
          label662: throw new RuntimeException("Folders can contain only shortcuts");
          if ((((ArrayList)localObject1).size() < 2) && (l1 >= 0L))
          {
            LauncherProvider.deleteId(paramSQLiteDatabase, l1);
            if (((ArrayList)localObject1).size() > 0)
              LauncherProvider.deleteId(paramSQLiteDatabase, ((Long)((ArrayList)localObject1).get(0)).longValue());
          }
        }
      }
    }

    private void normalizeIcons(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.beginTransaction();
      Object localObject5 = null;
      Cursor localCursor2 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      int i = 0;
      Cursor localCursor1 = localCursor2;
      Object localObject2 = localObject5;
      while (true)
      {
        try
        {
          SQLiteStatement localSQLiteStatement = paramSQLiteDatabase.compileStatement("UPDATE favorites SET icon=? WHERE _id=?");
          localCursor1 = localCursor2;
          localObject3 = localSQLiteStatement;
          localObject2 = localObject5;
          localObject4 = localSQLiteStatement;
          localCursor2 = paramSQLiteDatabase.rawQuery("SELECT _id, icon FROM favorites WHERE iconType=1", null);
          localCursor1 = localCursor2;
          localObject3 = localSQLiteStatement;
          localObject2 = localCursor2;
          localObject4 = localSQLiteStatement;
          int j = localCursor2.getColumnIndexOrThrow("_id");
          localCursor1 = localCursor2;
          localObject3 = localSQLiteStatement;
          localObject2 = localCursor2;
          localObject4 = localSQLiteStatement;
          int k = localCursor2.getColumnIndexOrThrow("icon");
          localCursor1 = localCursor2;
          localObject3 = localSQLiteStatement;
          localObject2 = localCursor2;
          localObject4 = localSQLiteStatement;
          if (localCursor2.moveToNext())
          {
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            long l = localCursor2.getLong(j);
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            localObject5 = localCursor2.getBlob(k);
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            try
            {
              localObject5 = Utilities.resampleIconBitmap(BitmapFactory.decodeByteArray((byte[])localObject5, 0, localObject5.length), this.mContext);
              if (localObject5 == null)
                continue;
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              localSQLiteStatement.bindLong(1, l);
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              byte[] arrayOfByte = ItemInfo.flattenBitmap((Bitmap)localObject5);
              if (arrayOfByte != null)
              {
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                localSQLiteStatement.bindBlob(2, arrayOfByte);
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                localSQLiteStatement.execute();
              }
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              ((Bitmap)localObject5).recycle();
            }
            catch (Exception localException)
            {
              if (i == 0)
              {
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                Log.e("LauncherProvider", "Failed normalizing icon " + l, localException);
              }
              else
              {
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                Log.e("LauncherProvider", "Also failed normalizing icon " + l);
              }
            }
          }
        }
        catch (SQLException localSQLException)
        {
          localObject2 = localCursor1;
          localObject4 = localObject3;
          Log.w("LauncherProvider", "Problem while allocating appWidgetIds for existing widgets", localSQLException);
          paramSQLiteDatabase.endTransaction();
          if (localObject3 != null)
            localObject3.close();
          if (localCursor1 != null)
            localCursor1.close();
          return;
          localCursor1 = localCursor2;
          localObject3 = localSQLException;
          localObject2 = localCursor2;
          localObject4 = localSQLException;
          paramSQLiteDatabase.setTransactionSuccessful();
          paramSQLiteDatabase.endTransaction();
          if (localSQLException != null)
            localSQLException.close();
          if (localCursor2 == null)
            continue;
          localCursor2.close();
          return;
        }
        finally
        {
          paramSQLiteDatabase.endTransaction();
          if (localObject4 != null)
            localObject4.close();
          if (localObject2 != null)
            ((Cursor)localObject2).close();
        }
        i = 1;
      }
    }

    private void removeItemFromDefaultWorkspace(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
    {
      String str2;
      Object localObject;
      String str1;
      if (paramString != null)
      {
        str2 = null;
        localObject = null;
        str1 = null;
      }
      try
      {
        paramString = paramSQLiteDatabase.query("singledesktopitems", null, "className=?", new String[] { paramString }, null, null, null);
        str1 = paramString;
        str2 = paramString;
        localObject = paramString;
        ItemInfo localItemInfo = new ItemInfo();
        if (paramString != null)
        {
          str1 = paramString;
          str2 = paramString;
          localObject = paramString;
          if (paramString.moveToNext())
          {
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int i = paramString.getColumnIndexOrThrow("_id");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int j = paramString.getColumnIndexOrThrow("itemType");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int k = paramString.getColumnIndexOrThrow("container");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int m = paramString.getColumnIndexOrThrow("screenId");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int n = paramString.getColumnIndexOrThrow("cellX");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            int i1 = paramString.getColumnIndexOrThrow("cellY");
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            localItemInfo.itemType = paramString.getInt(j);
            str1 = paramString;
            str2 = paramString;
            localObject = paramString;
            if (localItemInfo.itemType == paramInt)
            {
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              localItemInfo.id = paramString.getLong(i);
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              localItemInfo.cellX = paramString.getInt(n);
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              localItemInfo.cellY = paramString.getInt(i1);
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              localItemInfo.screenId = paramString.getInt(m);
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              localItemInfo.container = paramString.getInt(k);
              str1 = paramString;
              str2 = paramString;
              localObject = paramString;
              if (paramSQLiteDatabase.delete("singledesktopitems", "_id=" + localItemInfo.id, null) != 0)
              {
                str1 = paramString;
                str2 = paramString;
                localObject = paramString;
                resetIconLocationWhenItemRemoved(paramSQLiteDatabase, localItemInfo);
              }
            }
          }
        }
        if (paramString != null)
          paramString.close();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        do
        {
          localObject = str1;
          Log.w("LauncherProvider", paramSQLiteDatabase);
        }
        while (str1 == null);
        str1.close();
        return;
      }
      catch (CursorWindowAllocationException paramSQLiteDatabase)
      {
        do
        {
          localObject = str2;
          Log.w("LauncherProvider", paramSQLiteDatabase);
        }
        while (str2 == null);
        str2.close();
        return;
      }
      finally
      {
        if (localObject != null)
          ((Cursor)localObject).close();
      }
      throw paramSQLiteDatabase;
    }

    private void removeTableSingleDeskTopShortcutBlackList(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS shortcutblacklist");
      if (this.mContext != null)
      {
        paramSQLiteDatabase = LauncherSharedPrefs.getLauncherPrefs(this.mContext).edit();
        paramSQLiteDatabase.remove("shortcut_blacklist_version");
        paramSQLiteDatabase.commit();
      }
    }

    private void resetIconLocationWhenItemRemoved(SQLiteDatabase paramSQLiteDatabase, ItemInfo paramItemInfo)
    {
      if ((paramItemInfo == null) || (paramItemInfo.cellX < 0) || (paramItemInfo.cellY < 0));
      while (true)
      {
        return;
        if (paramItemInfo.screenId != 999)
        {
          Object localObject11 = null;
          Object localObject12 = null;
          Object localObject10 = null;
          Object localObject1 = null;
          Object localObject6 = null;
          Object localObject7 = null;
          Object localObject13 = null;
          Object localObject14 = null;
          Cursor localCursor2 = null;
          Object localObject9 = localObject11;
          Object localObject4 = localObject1;
          Object localObject5 = localObject13;
          Object localObject8 = localObject12;
          Object localObject2 = localObject6;
          Object localObject3 = localObject14;
          try
          {
            int k = paramItemInfo.cellX;
            localObject9 = localObject11;
            localObject4 = localObject1;
            localObject5 = localObject13;
            localObject8 = localObject12;
            localObject2 = localObject6;
            localObject3 = localObject14;
            int m = paramItemInfo.cellY;
            localObject9 = localObject11;
            localObject4 = localObject1;
            localObject5 = localObject13;
            localObject8 = localObject12;
            localObject2 = localObject6;
            localObject3 = localObject14;
            int n = ScreenGridUtils.getScreenXGridNum();
            localObject9 = localObject11;
            localObject4 = localObject1;
            localObject5 = localObject13;
            localObject8 = localObject12;
            localObject2 = localObject6;
            localObject3 = localObject14;
            int j;
            int i;
            if (paramItemInfo.container == -100L)
            {
              localObject9 = localObject11;
              localObject4 = localObject1;
              localObject5 = localObject13;
              localObject8 = localObject12;
              localObject2 = localObject6;
              localObject3 = localObject14;
              localObject1 = paramSQLiteDatabase.query("singledesktopitems", null, "container=? and screenId=?", new String[] { String.valueOf(paramItemInfo.container), String.valueOf(paramItemInfo.screenId) }, null, null, "cellY, cellX");
              localObject6 = localCursor2;
              j = m;
              i = k;
            }
            while (localObject1 != null)
            {
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              m = ((Cursor)localObject1).getColumnIndexOrThrow("_id");
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              int i1 = ((Cursor)localObject1).getColumnIndexOrThrow("itemType");
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              ((Cursor)localObject1).getColumnIndexOrThrow("container");
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              ((Cursor)localObject1).getColumnIndexOrThrow("screenId");
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              int i2 = ((Cursor)localObject1).getColumnIndexOrThrow("cellX");
              localObject9 = localObject1;
              localObject4 = localObject7;
              localObject5 = localObject6;
              localObject8 = localObject1;
              localObject2 = localObject7;
              localObject3 = localObject6;
              int i3 = ((Cursor)localObject1).getColumnIndexOrThrow("cellY");
              while (true)
              {
                localObject9 = localObject1;
                localObject4 = localObject7;
                localObject5 = localObject6;
                localObject8 = localObject1;
                localObject2 = localObject7;
                localObject3 = localObject6;
                if (!((Cursor)localObject1).moveToNext())
                  break;
                localObject9 = localObject1;
                localObject4 = localObject7;
                localObject5 = localObject6;
                localObject8 = localObject1;
                localObject2 = localObject7;
                localObject3 = localObject6;
                if (((Cursor)localObject1).getInt(i1) != 5)
                {
                  localObject9 = localObject1;
                  localObject4 = localObject7;
                  localObject5 = localObject6;
                  localObject8 = localObject1;
                  localObject2 = localObject7;
                  localObject3 = localObject6;
                  k = ((Cursor)localObject1).getInt(m);
                  localObject9 = localObject1;
                  localObject4 = localObject7;
                  localObject5 = localObject6;
                  localObject8 = localObject1;
                  localObject2 = localObject7;
                  localObject3 = localObject6;
                  int i4 = ((Cursor)localObject1).getInt(i2);
                  localObject9 = localObject1;
                  localObject4 = localObject7;
                  localObject5 = localObject6;
                  localObject8 = localObject1;
                  localObject2 = localObject7;
                  localObject3 = localObject6;
                  int i5 = ((Cursor)localObject1).getInt(i3);
                  if ((i5 > j) || ((i5 == j) && (i4 > i)))
                  {
                    localObject9 = localObject1;
                    localObject4 = localObject7;
                    localObject5 = localObject6;
                    localObject8 = localObject1;
                    localObject2 = localObject7;
                    localObject3 = localObject6;
                    paramItemInfo = new ContentValues();
                    localObject9 = localObject1;
                    localObject4 = localObject7;
                    localObject5 = localObject6;
                    localObject8 = localObject1;
                    localObject2 = localObject7;
                    localObject3 = localObject6;
                    paramItemInfo.put("cellX", Integer.valueOf(i));
                    localObject9 = localObject1;
                    localObject4 = localObject7;
                    localObject5 = localObject6;
                    localObject8 = localObject1;
                    localObject2 = localObject7;
                    localObject3 = localObject6;
                    paramItemInfo.put("cellY", Integer.valueOf(j));
                    localObject9 = localObject1;
                    localObject4 = localObject7;
                    localObject5 = localObject6;
                    localObject8 = localObject1;
                    localObject2 = localObject7;
                    localObject3 = localObject6;
                    paramSQLiteDatabase.update("singledesktopitems", paramItemInfo, "_id=" + k, null);
                    k = i + 1;
                    i = k;
                    if (k >= n)
                    {
                      i = 0;
                      j += 1;
                    }
                  }
                }
              }
              localObject9 = localObject11;
              localObject4 = localObject1;
              localObject5 = localObject13;
              localObject8 = localObject12;
              localObject2 = localObject6;
              localObject3 = localObject14;
              Cursor localCursor1 = paramSQLiteDatabase.query("singledesktopitems", null, "container=? ", new String[] { String.valueOf(paramItemInfo.container) }, null, null, null);
              localObject1 = localObject10;
              i = k;
              j = m;
              localObject7 = localCursor1;
              localObject6 = localCursor2;
              if (localCursor1 != null)
              {
                localObject1 = localObject10;
                i = k;
                j = m;
                localObject7 = localCursor1;
                localObject6 = localCursor2;
                localObject9 = localObject11;
                localObject4 = localCursor1;
                localObject5 = localObject13;
                localObject8 = localObject12;
                localObject2 = localCursor1;
                localObject3 = localObject14;
                if (localCursor1.getCount() == 0)
                {
                  localObject9 = localObject11;
                  localObject4 = localCursor1;
                  localObject5 = localObject13;
                  localObject8 = localObject12;
                  localObject2 = localCursor1;
                  localObject3 = localObject14;
                  localCursor2 = paramSQLiteDatabase.query("singledesktopitems", null, "_id=? ", new String[] { String.valueOf(paramItemInfo.container) }, null, null, null);
                  localObject1 = localObject10;
                  i = k;
                  j = m;
                  localObject7 = localCursor1;
                  localObject6 = localCursor2;
                  if (localCursor2 != null)
                  {
                    localObject1 = localObject10;
                    i = k;
                    j = m;
                    localObject7 = localCursor1;
                    localObject6 = localCursor2;
                    localObject9 = localObject11;
                    localObject4 = localCursor1;
                    localObject5 = localCursor2;
                    localObject8 = localObject12;
                    localObject2 = localCursor1;
                    localObject3 = localCursor2;
                    if (localCursor2.moveToNext())
                    {
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      k = localCursor2.getColumnIndexOrThrow("cellX");
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      j = localCursor2.getColumnIndexOrThrow("cellY");
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      i = localCursor2.getColumnIndexOrThrow("container");
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      k = localCursor2.getInt(k);
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      m = localCursor2.getInt(j);
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      i1 = localCursor2.getInt(i);
                      localObject1 = localObject10;
                      i = k;
                      j = m;
                      localObject7 = localCursor1;
                      localObject6 = localCursor2;
                      localObject9 = localObject11;
                      localObject4 = localCursor1;
                      localObject5 = localCursor2;
                      localObject8 = localObject12;
                      localObject2 = localCursor1;
                      localObject3 = localCursor2;
                      if (paramSQLiteDatabase.delete("singledesktopitems", "_id=" + paramItemInfo.container, null) != 0)
                      {
                        localObject9 = localObject11;
                        localObject4 = localCursor1;
                        localObject5 = localCursor2;
                        localObject8 = localObject12;
                        localObject2 = localCursor1;
                        localObject3 = localCursor2;
                        localObject1 = paramSQLiteDatabase.query("singledesktopitems", null, "container=? and screenId=?", new String[] { String.valueOf(i1), String.valueOf(paramItemInfo.screenId) }, null, null, "cellY, cellX");
                        i = k;
                        j = m;
                        localObject7 = localCursor1;
                        localObject6 = localCursor2;
                      }
                    }
                  }
                }
              }
            }
            if (localObject1 != null)
              ((Cursor)localObject1).close();
            if (localObject7 != null)
              localObject7.close();
            if (localObject6 != null)
            {
              localObject6.close();
              return;
            }
          }
          catch (Exception paramSQLiteDatabase)
          {
            localObject8 = localObject9;
            localObject2 = localObject4;
            localObject3 = localObject5;
            Log.e("LauncherProvider", "resetIconLocationWhenAppIconRemoved --- e = " + paramSQLiteDatabase);
            return;
          }
          finally
          {
            if (localObject8 != null)
              localObject8.close();
            if (localObject2 != null)
              localObject2.close();
            if (localObject3 != null)
              ((Cursor)localObject3).close();
          }
        }
      }
      throw paramSQLiteDatabase;
    }

    private void sendAppWidgetResetNotify()
    {
      this.mContext.getContentResolver().notifyChange(LauncherProvider.CONTENT_APPWIDGET_RESET_URI, null);
    }

    private void setEmptyCell(int paramInt1, int paramInt2)
    {
      this.mEmptyCell[0] = paramInt1;
      this.mEmptyCell[1] = paramInt2;
    }

    private void updateItemPosInDB(SQLiteDatabase paramSQLiteDatabase, int paramInt1, long paramLong, int paramInt2, int paramInt3)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("container", Long.valueOf(paramLong));
      localContentValues.put("cellX", Integer.valueOf(paramInt2));
      localContentValues.put("cellY", Integer.valueOf(paramInt3));
      paramSQLiteDatabase.update("singledesktopitems", localContentValues, "_id=" + paramInt1, null);
    }

    private void updatePackageAndClass(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (paramSQLiteDatabase == null)
      {
        Log.w("LauncherProvider", "updatePackageAndClass, db == null, return");
        return;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("packageName", paramString1);
        localContentValues.put("className", paramString2);
        paramSQLiteDatabase.update("singledesktopitems", localContentValues, "packageName='" + paramString3 + "' AND " + "className" + "='" + paramString4 + "'", null);
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        Log.w("LauncherProvider", "updatePackageAndClass, e = " + paramSQLiteDatabase);
      }
    }

    private void updateToVersion16(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.v("LauncherProvider", "updateToVersion16--- entry");
      if (!isInstalledLocationColumnExist(paramSQLiteDatabase))
      {
        Log.v("LauncherProvider", "updateToVersion16--- add column");
        paramSQLiteDatabase.execSQL("ALTER TABLE singledesktopitems ADD COLUMN modelState INTEGER DEFAULT 0");
        initInstalledLocationToItems(paramSQLiteDatabase);
      }
    }

    private void updateWidgetPackageName(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (paramSQLiteDatabase == null)
      {
        Log.w("LauncherProvider", "updateWidgetPackageName, db == null, return");
        return;
      }
      int i = 0;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("intent", paramString1);
        localContentValues.put("className", paramString2);
        int j = paramSQLiteDatabase.update("singledesktopitems", localContentValues, "intent='" + paramString3 + "' AND " + "className" + "='" + paramString4 + "'", null);
        i = j;
        Log.v("LauncherProvider", "updateWidgetPackageName newClass = " + paramString2 + ". --- result = " + i);
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        while (true)
          Log.w("LauncherProvider", "updateWidgetPackageName, e = " + paramSQLiteDatabase);
      }
    }

    public int changeScreenToScreenId(int paramInt)
    {
      return paramInt + 1000;
    }

    public void clearWorkspaceScreenNewId()
    {
      this.mWorkspaceScreenNewMaxId = 0L;
    }

    public long generateNewId()
    {
      if (this.mMaxId < 0L)
        throw new RuntimeException("Error: max id was not initialized");
      this.mMaxId += 1L;
      return this.mMaxId;
    }

    public long generateWorkspaceScreenNewId()
    {
      if (this.mWorkspaceScreenNewMaxId < 0L)
        throw new RuntimeException("Error: mWorkspaceScreenNewMaxId was not initialized");
      this.mWorkspaceScreenNewMaxId += 1L;
      return this.mWorkspaceScreenNewMaxId;
    }

    public SQLiteDatabase getReadableDatabase()
    {
      if (this.mDefaultSQLiteDatabase != null)
        return this.mDefaultSQLiteDatabase;
      return super.getReadableDatabase();
    }

    public SQLiteDatabase getWritableDatabase()
    {
      if (this.mDefaultSQLiteDatabase != null)
        return this.mDefaultSQLiteDatabase;
      return super.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mDefaultSQLiteDatabase = paramSQLiteDatabase;
      this.mMaxId = 1L;
      this.mWorkspaceScreenNewMaxId = 1L;
      createTableNewInstalled(paramSQLiteDatabase);
      createTableSingleDeskTopScreens(paramSQLiteDatabase);
      createTableSingleDeskTopItems(paramSQLiteDatabase);
      createTableSingleDeskTopShortcutWhiteList(paramSQLiteDatabase);
      if (this.mAppWidgetHost != null)
      {
        this.mAppWidgetHost.deleteHost();
        sendAppWidgetResetNotify();
      }
      initSingleDeskTopScreens(paramSQLiteDatabase);
      initSingleDeskTopItems(paramSQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.mDefaultSQLiteDatabase = paramSQLiteDatabase;
      this.mContext.deleteDatabase("launcher.db");
      this.mContext.deleteDatabase("launcher_4x4.db");
      onCreate(paramSQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.mDefaultSQLiteDatabase = paramSQLiteDatabase;
      paramInt2 = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 < 16)
      {
        updateToVersion16(paramSQLiteDatabase);
        paramInt1 = 16;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 17)
      {
        if (this.mMaxId == -1L)
          this.mMaxId = initializeMaxId(paramSQLiteDatabase);
        updateDockBarHotseatsMaxNumToFour(this.mContext, paramSQLiteDatabase);
        paramInt2 = 17;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 21)
      {
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.oppo.speechassist.Main", 0);
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.oppo.ota.activity.EntryActivity", 0);
        paramInt1 = 21;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 22)
      {
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.oppo.launcher.dynamicIcon.cleanup", 0);
        paramInt2 = 22;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 24)
      {
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.nearme.ocloud.activity.MainActivity", 0);
        paramInt1 = 24;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 25)
      {
        updateWidgetPackageName(paramSQLiteDatabase, "com.coloros.widget.smallweather/com.coloros.widget.smallweather.OppoWeather", "com.coloros.widget.smallweather.OppoWeather", "com.oppo.widget.smallweather/com.oppo.widget.smallweather.OppoWeather", "com.oppo.widget.smallweather.OppoWeather");
        updatePackageAndClass(paramSQLiteDatabase, "com.tencent.tvoem", "com.tencent.qqlive.ona.activity.WelcomeActivity", "com.oppo.video", "com.oppo.video.VideoListActivity");
        paramInt2 = 25;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 26)
      {
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.coloros.widget.smallweather.OppoWeather", 5);
        removeItemFromDefaultWorkspace(paramSQLiteDatabase, "com.oppo.music.MusicPageWidgetProvider", 5);
        paramInt1 = 26;
      }
      if (paramInt1 < 27)
      {
        removeTableSingleDeskTopShortcutBlackList(paramSQLiteDatabase);
        createTableSingleDeskTopShortcutWhiteList(paramSQLiteDatabase);
      }
    }

    public void updateDockBarHotseatsMaxNumToFour(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      if ((paramSQLiteDatabase == null) || (paramContext == null));
      while (true)
      {
        return;
        Object localObject6 = null;
        Object localObject3 = null;
        Object localObject5 = null;
        Object localObject9 = null;
        Object localObject10 = null;
        Object localObject11 = null;
        Object localObject12 = null;
        Object localObject8 = null;
        Object localObject2 = localObject9;
        Object localObject4 = localObject11;
        Object localObject1 = localObject12;
        try
        {
          localCursor = paramSQLiteDatabase.query("singledesktopitems", null, new String("screenId = ? AND container = ?"), new String[] { String.valueOf(999), String.valueOf(-101) }, null, null, "cellX");
          localObject7 = localObject10;
          if (localCursor != null)
          {
            localObject5 = localCursor;
            localObject2 = localObject9;
            localObject7 = localObject10;
            localObject6 = localCursor;
            localObject4 = localObject11;
            localObject3 = localCursor;
            localObject1 = localObject12;
            if (localCursor.getCount() > 4)
            {
              localObject5 = localCursor;
              localObject2 = localObject9;
              localObject6 = localCursor;
              localObject4 = localObject11;
              localObject3 = localCursor;
              localObject1 = localObject12;
              Resources localResources = paramContext.getResources();
              localObject7 = localObject10;
              if (localResources != null)
              {
                localObject5 = localCursor;
                localObject2 = localObject9;
                localObject6 = localCursor;
                localObject4 = localObject11;
                localObject3 = localCursor;
                localObject1 = localObject12;
                int k = localResources.getInteger(2131296270);
                localObject5 = localCursor;
                localObject2 = localObject9;
                localObject6 = localCursor;
                localObject4 = localObject11;
                localObject3 = localCursor;
                localObject1 = localObject12;
                int m = localCursor.getColumnIndexOrThrow("_id");
                localObject5 = localCursor;
                localObject2 = localObject9;
                localObject6 = localCursor;
                localObject4 = localObject11;
                localObject3 = localCursor;
                localObject1 = localObject12;
                int n = localCursor.getColumnIndexOrThrow("itemType");
                localObject5 = localCursor;
                localObject2 = localObject9;
                localObject6 = localCursor;
                localObject4 = localObject11;
                localObject3 = localCursor;
                localObject1 = localObject12;
                long l = createFolderInDockBar(paramContext, paramSQLiteDatabase, 3);
                int i = 0;
                localObject5 = localCursor;
                localObject2 = localObject9;
                localObject6 = localCursor;
                localObject4 = localObject11;
                localObject3 = localCursor;
                localObject1 = localObject12;
                localCursor.moveToPosition(2);
                paramContext = localObject8;
                while (true)
                {
                  localObject5 = localCursor;
                  localObject2 = paramContext;
                  localObject7 = paramContext;
                  localObject6 = localCursor;
                  localObject4 = paramContext;
                  localObject3 = localCursor;
                  localObject1 = paramContext;
                  if (!localCursor.moveToNext())
                    break;
                  localObject5 = localCursor;
                  localObject2 = paramContext;
                  localObject6 = localCursor;
                  localObject4 = paramContext;
                  localObject3 = localCursor;
                  localObject1 = paramContext;
                  int j = localCursor.getInt(n);
                  localObject5 = localCursor;
                  localObject2 = paramContext;
                  localObject6 = localCursor;
                  localObject4 = paramContext;
                  localObject3 = localCursor;
                  localObject1 = paramContext;
                  int i1 = localCursor.getInt(m);
                  if ((j == 0) || (j == 1))
                  {
                    localObject5 = localCursor;
                    localObject2 = paramContext;
                    localObject6 = localCursor;
                    localObject4 = paramContext;
                    localObject3 = localCursor;
                    localObject1 = paramContext;
                    updateItemPosInDB(paramSQLiteDatabase, i1, l, i % k, i / k);
                    i += 1;
                  }
                  else if (j == 3)
                  {
                    localObject5 = localCursor;
                    localObject2 = paramContext;
                    localObject6 = localCursor;
                    localObject4 = paramContext;
                    localObject3 = localCursor;
                    localObject1 = paramContext;
                    paramContext = paramSQLiteDatabase.query("singledesktopitems", null, new String("container = ?"), new String[] { String.valueOf(i1) }, null, null, "cellY, cellX");
                    j = i;
                    if (paramContext != null)
                    {
                      j = i;
                      localObject5 = localCursor;
                      localObject2 = paramContext;
                      localObject6 = localCursor;
                      localObject4 = paramContext;
                      localObject3 = localCursor;
                      localObject1 = paramContext;
                      if (paramContext.getCount() > 0)
                        while (true)
                        {
                          j = i;
                          localObject5 = localCursor;
                          localObject2 = paramContext;
                          localObject6 = localCursor;
                          localObject4 = paramContext;
                          localObject3 = localCursor;
                          localObject1 = paramContext;
                          if (!paramContext.moveToNext())
                            break;
                          localObject5 = localCursor;
                          localObject2 = paramContext;
                          localObject6 = localCursor;
                          localObject4 = paramContext;
                          localObject3 = localCursor;
                          localObject1 = paramContext;
                          updateItemPosInDB(paramSQLiteDatabase, paramContext.getInt(m), l, i % k, i / k);
                          i += 1;
                        }
                    }
                    localObject5 = localCursor;
                    localObject2 = paramContext;
                    localObject6 = localCursor;
                    localObject4 = paramContext;
                    localObject3 = localCursor;
                    localObject1 = paramContext;
                    paramSQLiteDatabase.delete("singledesktopitems", "_id=" + i1, null);
                    i = j;
                  }
                }
              }
            }
          }
        }
        catch (SQLException paramContext)
        {
          Cursor localCursor;
          Object localObject7;
          localObject3 = localObject5;
          localObject1 = localObject2;
          Log.w("LauncherProvider", paramContext);
          return;
          return;
        }
        catch (CursorWindowAllocationException paramContext)
        {
          localObject3 = localObject6;
          localObject1 = localObject4;
          Log.w("LauncherProvider", paramContext);
          return;
        }
        finally
        {
          if (localObject3 != null)
            localObject3.close();
          if (localObject1 != null)
            ((Cursor)localObject1).close();
        }
      }
      throw paramContext;
    }
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
 * Qualified Name:     com.oppo.launcher.LauncherProvider
 * JD-Core Version:    0.6.2
 */