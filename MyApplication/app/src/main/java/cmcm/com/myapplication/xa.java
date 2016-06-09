package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xa
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/banner");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS banner (_id INTEGER PRIMARY KEY, code TEXT NOT NULL, content TEXT , useTimeZone INTEGER DEFAULT 1, link TEXT , beginTime INTEGER , endTime TEXT , seen INTEGER DEFAULT 0, pkg TEXT , duration INTEGER DEFAULT 0, retrospect INTEGER DEFAULT 0, time_showed INTEGER DEFAULT 0, appVer INTEGER DEFAULT 0)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX index_banner_code ON banner (code)");
    paramSQLiteDatabase.execSQL("CREATE INDEX index_banner_package ON banner (pkg)");
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE banner ADD COLUMN pkg TEXT ");
      paramSQLiteDatabase.execSQL("ALTER TABLE banner ADD COLUMN duration INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE banner ADD COLUMN retrospect INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE banner ADD COLUMN time_showed INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("CREATE INDEX index_banner_package ON banner (pkg)");
      paramSQLiteDatabase.execSQL(" UPDATE banner SET duration=0, retrospect=0, time_showed=0");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
    }
  }

  public static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE banner ADD COLUMN appVer INTEGER DEFAULT 0");
      return;
    }
    catch (Throwable paramSQLiteDatabase)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xa
 * JD-Core Version:    0.6.2
 */