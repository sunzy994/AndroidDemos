package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xk
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/notification_log");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS notification_log (_id INTEGER PRIMARY KEY, identity TEXT NOT NULL, last_update_date INTEGER DEFAULT 0, times INTEGER DEFAULT 0)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xk
 * JD-Core Version:    0.6.2
 */