package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class wz
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/app_contact");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS app_contact (_id INTEGER PRIMARY KEY, package_name TEXT , key TEXT , name TEXT , icon BLOB )");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX  IF NOT EXISTS index_app_contact_package_key ON app_contact (package_name, key)");
    paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_app_contact_name ON app_contact (name)");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER  IF NOT EXISTS on_app_contact_insert AFTER  INSERT  ON app_contact BEGIN  UPDATE contact SET image= NEW.icon WHERE _id= ( SELECT c._id FROM app_contact a, contact_app_key b, contact c  WHERE a.package_name=b.app AND a.key=b.key AND b.contact_id=c._id AND a.package_name= NEW.package_name AND a.key= NEW.key AND c.image IS NULL ); END ");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wz
 * JD-Core Version:    0.6.2
 */