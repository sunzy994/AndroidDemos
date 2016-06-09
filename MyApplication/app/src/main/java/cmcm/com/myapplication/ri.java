package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ri
  implements BaseColumns
{
  public static final String[] a = { "name", "key", "players", "icon", "brief", "resUrl", "version", "size", "accelerate", "horizontal", "init", "md5", "webUrl" };

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS game(_id INTEGER PRIMARY KEY, name TEXT, key TEXT, players INTEGER, icon TEXT, brief TEXT, version INTEGER, resUrl TEXT, size INTEGER, accelerate INTEGER, horizontal INTEGER, init TEXT, md5 TEXT, webUrl TEXT)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_key_game ON game(key)");
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE game ADD COLUMN webUrl TEXT");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ri
 * JD-Core Version:    0.6.2
 */