package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class rl
  implements BaseColumns
{
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS game_status(_id INTEGER PRIMARY KEY, key TEXT, status INTEGER, md5 TEXT, game_hide_down INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_key_game_status ON game_status(key)");
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE game_status ADD COLUMN game_hide_down INTEGER");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rl
 * JD-Core Version:    0.6.2
 */