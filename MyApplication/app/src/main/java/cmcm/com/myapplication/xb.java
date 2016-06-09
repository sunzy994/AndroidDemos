package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xb
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/best_match_favorites");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS best_match_favorites (_id INTEGER PRIMARY KEY, package TEXT NOT NULL, language TEXT , country TEXT , include INTEGER DEFAULT 1, match_country INTEGER DEFAULT 1, app_type INTEGER )");
    b(paramSQLiteDatabase);
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, int paramInt)
  {
    paramString2 = "'" + paramString2 + "'";
    paramSQLiteDatabase.execSQL("INSERT INTO best_match_favorites (package, include, language, match_country, app_type) VALUES  ('" + paramString1 + "'" + ", " + ash.a + ", " + paramString2 + ", " + ash.b + ", " + paramInt + ")");
  }

  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase, "com.vkontakte.android", "ru", 0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xb
 * JD-Core Version:    0.6.2
 */