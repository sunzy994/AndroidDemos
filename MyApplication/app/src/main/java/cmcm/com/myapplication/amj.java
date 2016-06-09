package cmcm.com.myapplication;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class amj extends amd
{
  private static final String l = "Swipe." + amj.class.getSimpleName();
  protected ContentProviderClient i = null;
  protected Uri j;
  protected ContentObserver k;

  protected amj(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  abstract void a(List<String> paramList, int paramInt);

  boolean a(Map<String, String> paramMap)
  {
    ContentProviderClient localContentProviderClient = h();
    if ((paramMap == null) || (paramMap.size() <= 0));
    try
    {
      int m = localContentProviderClient.delete(this.j, null, null);
      if (m > 0);
      for (boolean bool = true; ; bool = false)
        return bool;
      ContentValues localContentValues = new ContentValues(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Entry localEntry = (Entry)paramMap.next();
        localContentValues.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      try
      {
        localContentProviderClient.insert(this.j, localContentValues);
        return true;
      }
      catch (Throwable paramMap)
      {
      }
      label133: return false;
    }
    catch (Throwable paramMap)
    {
      break label133;
    }
  }

  void b(Map<String, String> paramMap)
  {
    try
    {
      localCursor = h().query(this.j, null, null, null, null);
      if (paramMap == null);
      while (true)
      {
        try
        {
          paramMap = new HashMap(localCursor.getCount());
          if (!localCursor.moveToNext())
            break;
          paramMap.put(localCursor.getString(0), localCursor.getString(1));
          continue;
        }
        finally
        {
        }
        if (localCursor != null)
          localCursor.close();
        throw paramMap;
        paramMap.clear();
      }
      if (localCursor != null)
        localCursor.close();
      return;
    }
    finally
    {
      while (true)
        Cursor localCursor = null;
    }
  }

  boolean b()
  {
    return true;
  }

  void c()
  {
    b(this.c);
  }

  // ERROR //
  protected void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 154	amj:k	Landroid/database/ContentObserver;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 158	amj:g	Landroid/content/Context;
    //   13: invokevirtual 164	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload_0
    //   17: getfield 154	amj:k	Landroid/database/ContentObserver;
    //   20: invokevirtual 170	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   23: aload_0
    //   24: getfield 46	amj:i	Landroid/content/ContentProviderClient;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +16 -> 45
    //   32: aload_0
    //   33: getfield 46	amj:i	Landroid/content/ContentProviderClient;
    //   36: invokevirtual 173	android/content/ContentProviderClient:release	()Z
    //   39: pop
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 46	amj:i	Landroid/content/ContentProviderClient;
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: goto -9 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   2	23	48	finally
    //   23	28	48	finally
    //   32	45	48	finally
    //   45	47	48	finally
    //   49	51	48	finally
    //   32	45	53	java/lang/Throwable
  }

  protected ContentProviderClient h()
  {
    while (true)
    {
      ContentProviderClient localContentProviderClient2;
      try
      {
        localContentProviderClient2 = this.i;
        if (localContentProviderClient2 == null)
        {
          Object localObject1 = null;
          try
          {
            String str = this.j.getAuthority();
            localObject1 = str;
            ContentProviderClient localContentProviderClient3 = this.g.getContentResolver().acquireContentProviderClient(str);
            localObject1 = str;
            this.i = localContentProviderClient3;
            localObject1 = localContentProviderClient3;
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            Log.w(l, "[" + this.f + "] " + "Could not acquire content provider client for " + localObject1, localThrowable);
          }
        }
      }
      finally
      {
      }
      ContentProviderClient localContentProviderClient1 = localContentProviderClient2;
    }
  }

  protected void i()
  {
    this.k = new ContentObserver(new Handler(Looper.getMainLooper()))
    {
      private Handler b;
      private Runnable c;

      public void onChange(boolean paramAnonymousBoolean)
      {
        onChange(paramAnonymousBoolean, null);
      }

      public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        if (paramAnonymousUri != null)
        {
          paramAnonymousUri = paramAnonymousUri.getPathSegments();
          int i = paramAnonymousUri.size();
          if (i <= 1)
            return;
          amj.this.a(paramAnonymousUri, i);
          return;
        }
        if (this.b == null)
        {
          this.b = new Handler(Looper.getMainLooper());
          this.c = new Runnable()
          {
            public void run()
            {
              amj.this.j();
            }
          };
        }
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 20L);
      }
    };
    this.g.getContentResolver().registerContentObserver(this.j, true, this.k);
  }

  void j()
  {
    if (this.c == null)
      return;
    Object localObject1 = new HashMap(this.c.size());
    try
    {
      b((Map)localObject1);
      ame localame = (ame)edit();
      if (((Map)localObject1).size() <= 0)
        localame.clear();
      while (true)
      {
        localame.a(true);
        return;
        Object localObject2 = this.c.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Entry localEntry = (Entry)((Iterator)localObject2).next();
          String str1 = (String)localEntry.getKey();
          String str2 = (String)((Map)localObject1).remove(str1);
          if (str2 == null)
            localame.remove(str1);
          else if (!str2.equals(localEntry.getValue()))
            localame.putString(str1, str2);
        }
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entry)((Iterator)localObject1).next();
          localame.putString((String)((Entry)localObject2).getKey(), (String)((Entry)localObject2).getValue());
        }
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amj
 * JD-Core Version:    0.6.2
 */