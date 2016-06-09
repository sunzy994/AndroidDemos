package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class rm
  implements BaseColumns
{
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subject(_id INTEGER PRIMARY KEY, code INTEGER, name TEXT, intro TEXT, icon TEXT, banner TEXT, expire INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_code_subject ON subject(code)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS index_expire_millis_subject ON subject(expire)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rm
 * JD-Core Version:    0.6.2
 */