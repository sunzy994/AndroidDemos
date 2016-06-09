package cmcm.com.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class om extends SQLiteOpenHelper
{
  public om(Context paramContext)
  {
    super(paramContext, "download.db", null, 1);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_info (_id INTEGER PRIMARY KEY, thread_id INTEGER, start_pos INTEGER, end_pos INTEGER, complete_size INTEGER, url TEXT )");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     om
 * JD-Core Version:    0.6.2
 */