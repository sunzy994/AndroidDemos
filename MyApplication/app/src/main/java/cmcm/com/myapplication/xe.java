package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xe
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/contact_log");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS contact_log (_id INTEGER PRIMARY KEY, contact_id INTEGER NOT NULL, last_contact INTEGER DEFAULT 0, times INTEGER DEFAULT 0)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX  IF NOT EXISTS index_contact_log_id ON contact_log (contact_id)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xe
 * JD-Core Version:    0.6.2
 */