package cmcm.com.myapplication.com.hola.channel.sdk.game.content.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import pe;
import qm;
import rh;
import ri;
import rj;
import rk;
import rl;
import rm;
import rp;
import sn;

public class OpenHelper extends SQLiteOpenHelper
{
  private static final String a = "GameSDK." + OpenHelper.class.getSimpleName();
  private static volatile boolean d;
  private final Context b;
  private final File c;

  public OpenHelper(Context paramContext)
  {
    super(paramContext, "hola_games_data.db", null, 5);
    this.c = new File(paramContext.getFilesDir(), ".hola_games_data.lock");
    this.b = paramContext.getApplicationContext();
  }

  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    rk.a(paramSQLiteDatabase);
    rm.a(paramSQLiteDatabase);
  }

  private void b()
  {
    if (d)
      return;
    d = true;
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        paramAnonymousArrayOfVoid = new File(Environment.getExternalStorageDirectory(), ".hola_games").listFiles();
        int j;
        int i;
        if ((paramAnonymousArrayOfVoid != null) && (paramAnonymousArrayOfVoid.length > 0))
        {
          j = paramAnonymousArrayOfVoid.length;
          i = 0;
        }
        while (true)
        {
          Void localVoid;
          String str;
          if (i < j)
          {
            localVoid = paramAnonymousArrayOfVoid[i];
            if (localVoid.exists())
            {
              str = localVoid.getName();
              int k = str.indexOf('.');
              if (k > 0)
                str = str.substring(0, k);
            }
          }
          try
          {
            qm.a(localVoid, pe.a(str));
            label86: i += 1;
            continue;
            OpenHelper.a(false);
            return null;
          }
          catch (Exception localException)
          {
            break label86;
          }
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    rj.b(paramSQLiteDatabase);
  }

  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    ri.b(paramSQLiteDatabase);
  }

  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    rl.b(paramSQLiteDatabase);
    sn.a(this.b).a(this.b, paramSQLiteDatabase);
  }

  public Context a()
  {
    return this.b;
  }

  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (rp localrp)
    {
      localrp = localrp;
      Log.i(a, "Database recreate for downgrading purpose");
      this.b.deleteDatabase("hola_games_data.db");
      return super.getWritableDatabase();
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      Log.e(a, "getWritableDatabase failed", localThrowable);
      return null;
    }
    finally
    {
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    ri.a(paramSQLiteDatabase);
    rh.a(paramSQLiteDatabase);
    rj.a(paramSQLiteDatabase);
    rl.a(paramSQLiteDatabase);
    a(paramSQLiteDatabase);
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.i(a, "onDowngrade: " + paramInt1 + " -> " + paramInt2);
    throw new rp(null);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2)
      b();
    if (paramInt1 < 3)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 < 4)
      c(paramSQLiteDatabase);
    if (paramInt1 < 5)
      d(paramSQLiteDatabase);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.content.provider.OpenHelper
 * JD-Core Version:    0.6.2
 */