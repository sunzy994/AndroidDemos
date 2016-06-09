package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class rk
  implements BaseColumns
{
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS game_log(_id INTEGER PRIMARY KEY, key TEXT, start_time INTEGER, end_time INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_key_start_time_game_log ON game_log(key, start_time)");
    paramSQLiteDatabase.execSQL("CREATE VIEW IF NOT EXISTS v_game_log AS SELECT key, MAX(start_time) AS start_time FROM game_log GROUP BY key");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rk
 * JD-Core Version:    0.6.2
 */