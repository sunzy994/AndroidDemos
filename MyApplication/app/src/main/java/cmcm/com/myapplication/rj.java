package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class rj
  implements BaseColumns
{
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS game_list(_id INTEGER PRIMARY KEY, code INTEGER, key TEXT, list_type INTEGER DEFAULT 0)");
    c(paramSQLiteDatabase);
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS index_code_game_list");
    paramSQLiteDatabase.execSQL("ALTER TABLE game_list ADD COLUMN list_type INTEGER DEFAULT 0");
    c(paramSQLiteDatabase);
  }

  private static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS index_type_code_game_list ON game_list(list_type, code)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rj
 * JD-Core Version:    0.6.2
 */