package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class rh
  implements BaseColumns
{
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS category(_id INTEGER PRIMARY KEY, name TEXT, code INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_code_category ON category(code)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rh
 * JD-Core Version:    0.6.2
 */