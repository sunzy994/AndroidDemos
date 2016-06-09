package cmcm.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dataflurry.stat.StatProvider;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class kg extends SQLiteOpenHelper
{
  public kg(StatProvider paramStatProvider, Context paramContext)
  {
    super(paramContext, "qiigameAgent.db", null, 4);
  }

  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE if NOT EXISTS TabAgent2 (ID INTEGER PRIMARY KEY, date INTEGER DEFAULT 0, eventId TEXT, eventType INTEGER DEFAULT 0,eventMessage TEXT, count INTEGER DEFAULT 0, sendState INTEGER DEFAULT 0 )");
    b(paramSQLiteDatabase);
  }

  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE if NOT EXISTS FileData (_id INTEGER PRIMARY KEY, key TEXT, value TEXT, type TEXT )");
    kv.a().a = this.a.getContext().getFilesDir().getAbsolutePath();
    Object localObject = new km(kv.a().a + "/ConfigData/" + "config.ini");
    Map.Entry localEntry;
    ContentValues localContentValues;
    synchronized (((km)localObject).a)
    {
      localObject = ((km)localObject).a.entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        localContentValues = new ContentValues();
        localContentValues.put("key", (String)localEntry.getKey());
        localContentValues.put("value", (String)localEntry.getValue());
        localContentValues.put("type", "string");
        paramSQLiteDatabase.insert("FileData", "_id", localContentValues);
      }
    }
    localObject = new km(kv.a().a + "/ConfigData/" + "reffer.ini");
    synchronized (((km)localObject).a)
    {
      localObject = ((km)localObject).a.entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        localContentValues = new ContentValues();
        localContentValues.put("key", (String)localEntry.getKey());
        localContentValues.put("value", (String)localEntry.getValue());
        localContentValues.put("type", "string");
        paramSQLiteDatabase.insert("FileData", "_id", localContentValues);
      }
    }
  }

  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS TabAgent2");
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    kz localkz = new kz(this.a.getContext());
    localkz.a(true);
    localkz.a();
    a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    kz localkz = new kz(this.a.getContext());
    localkz.a(false);
    localkz.a();
    switch (paramInt1)
    {
    default:
      c(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      return;
    case 3:
    }
    b(paramSQLiteDatabase);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kg
 * JD-Core Version:    0.6.2
 */