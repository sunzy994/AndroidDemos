package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xc
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/contact");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS contact (_id INTEGER PRIMARY KEY, uri TEXT , name TEXT , thumb TEXT , image BLOB , _order INTEGER )");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_contact_uri ON contact (uri)");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_contact_order ON contact (_order)");
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE contact ADD COLUMN prefer_number TEXT ");
  }

  public static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE contact ADD COLUMN shortcut TEXT ");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xc
 * JD-Core Version:    0.6.2
 */