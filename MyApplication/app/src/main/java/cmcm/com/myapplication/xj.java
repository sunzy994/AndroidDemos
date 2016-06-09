package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xj
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/notification");
  public static final Uri b = Uri.parse("content://com.lazyswipe/notification_AGGREGATE_BY_CONTACT_APP");
  public static final Uri c = Uri.parse("content://com.lazyswipe/notification_AGGREGATE_BY_APP");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS memory_db.notification (_id INTEGER PRIMARY KEY AUTOINCREMENT, package_name TEXT , n_id INTEGER , icon INTEGER , _text TEXT , title TEXT , ticker_text TEXT , contact_uri TEXT , _when INTEGER , tag TEXT , key TEXT , _group TEXT , sort_key TEXT , is_summary INTEGER DEFAULT 0, is_child INTEGER DEFAULT 0, flags INTEGER , priority INTEGER , number INTEGER DEFAULT 1, contact_id INTEGER DEFAULT 0, uid INTEGER , large_icon BLOB , app_identity TEXT )");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_contact ON notification (contact_id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_uid ON notification (uid)");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_id ON notification (n_id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_package ON notification (package_name)");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_group ON notification (_group)");
    paramSQLiteDatabase.execSQL("CREATE INDEX memory_db.index_notification_when ON notification (_when)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xj
 * JD-Core Version:    0.6.2
 */