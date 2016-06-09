package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xi
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/news");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS news (_id INTEGER PRIMARY KEY, dateCreated INTEGER NOT NULL, title TEXT , author TEXT , purl TEXT , pichttp TEXT , read INTEGER DEFAULT 0)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX  IF NOT EXISTS index_news_date_created ON news (dateCreated)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xi
 * JD-Core Version:    0.6.2
 */