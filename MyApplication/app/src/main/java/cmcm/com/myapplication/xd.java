package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class xd
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/contact_app_key");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS contact_app_key (contact_id INTEGER NOT NULL, app TEXT NOT NULL, key TEXT NOT NULL, is_enable INTEGER DEFAULT 1, data_1 TEXT , data_2 TEXT , data_3 TEXT )");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_contact_app_key_id ON contact_app_key (contact_id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_contact_app_key_app ON contact_app_key (app)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xd
 * JD-Core Version:    0.6.2
 */