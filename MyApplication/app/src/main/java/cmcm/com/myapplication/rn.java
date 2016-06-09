package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.hola.channel.sdk.game.content.provider.OpenHelper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class rn
{
  public static final String a = "GameSDK." + rn.class.getSimpleName();
  private static rn c;
  final OpenHelper b;
  private final Handler d;
  private final Handler e;

  private rn(Context paramContext)
  {
    this.b = new OpenHelper(paramContext);
    this.e = new Handler(Looper.getMainLooper());
    paramContext = new HandlerThread(a, 10);
    paramContext.start();
    this.d = new Handler(paramContext.getLooper());
    this.d.post(new Runnable()
    {
      public void run()
      {
        rn.this.a();
      }
    });
  }

  private long a(SQLiteDatabase paramSQLiteDatabase, JSONObject paramJSONObject, ContentValues paramContentValues)
  {
    try
    {
      long l = paramSQLiteDatabase.replace("game", null, a(paramJSONObject, paramContentValues));
      return l;
    }
    catch (Throwable paramSQLiteDatabase)
    {
    }
    return 0L;
  }

  private ContentValues a(String paramString, int paramInt, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString);
    localContentValues.put("status", Integer.valueOf(paramInt));
    if (paramBoolean);
    for (paramInt = 1; ; paramInt = 0)
    {
      localContentValues.put("game_hide_down", Integer.valueOf(paramInt));
      return localContentValues;
    }
  }

  private ContentValues a(JSONObject paramJSONObject, ContentValues paramContentValues)
  {
    if (paramContentValues == null)
      paramContentValues = new ContentValues(ri.a.length);
    while (true)
    {
      String[] arrayOfString = ri.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str3 = arrayOfString[i];
        String str2 = paramJSONObject.optString(str3, null);
        if (str2 != null)
        {
          String str1 = str2;
          if ("md5".equals(str3))
            str1 = str2.toUpperCase(Locale.US);
          paramContentValues.put(str3, str1);
        }
        i += 1;
      }
      paramContentValues.clear();
    }
    return paramContentValues;
  }

  public static Uri a(String paramString)
  {
    return Uri.parse("content://com.hola.channel.sdk.game.data." + paramString);
  }

  private List<pd> a(int paramInt)
  {
    Object localObject7 = null;
    Object localObject6 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localObject6;
    Object localObject5;
    for (Object localObject1 = localObject7; ; localObject1 = "1")
      try
      {
        Object localObject8 = new StringBuilder().append("SELECT game.key , name , size , status , game_hide_down , resUrl , game.md5 FROM game , game_status WHERE game_status.key = game.key AND status <> ?");
        if (paramInt == 0)
        {
          Object localObject4 = "";
          localObject2 = localObject6;
          localObject1 = localObject7;
          localObject8 = (String)localObject4;
          if (paramInt != 0)
            break label175;
          localObject2 = localObject6;
          localObject1 = localObject7;
          localObject4 = new String[1];
          localObject2 = localObject6;
          localObject1 = localObject7;
          localObject4[0] = String.valueOf(1);
          localObject2 = localObject6;
          localObject1 = localObject7;
          localObject4 = a(null, (String)localObject8, (String[])localObject4, null);
          while (localObject4 != null)
          {
            localObject2 = localObject4;
            localObject1 = localObject4;
            if (!((Cursor)localObject4).moveToNext())
              break;
            localObject2 = localObject4;
            localObject1 = localObject4;
            localArrayList.add(a((Cursor)localObject4));
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localObject1 = localObject2;
          localException.printStackTrace();
          qp.a(localObject2);
          return localArrayList;
          localObject5 = " AND game_hide_down = ?";
          continue;
          label175: localObject2 = localObject6;
          localObject1 = localObject7;
          localObject5 = new String[2];
          localObject2 = localObject6;
          localObject1 = localObject7;
          localObject5[0] = String.valueOf(1);
          if (paramInt != 1)
            break;
          localObject1 = "0";
          localObject5[1] = localObject1;
        }
      }
      finally
      {
        qp.a((Cursor)localObject1);
      }
    qp.a((Cursor)localObject5);
    return localArrayList;
  }

  private static pd a(Cursor paramCursor)
  {
    boolean bool = true;
    pd localpd = new pd();
    localpd.d = paramCursor.getString(0);
    localpd.c = paramCursor.getString(1);
    localpd.f = paramCursor.getInt(2);
    localpd.b = paramCursor.getInt(3);
    if (paramCursor.getInt(4) == 1);
    while (true)
    {
      localpd.a = bool;
      localpd.e = paramCursor.getString(5);
      localpd.m = paramCursor.getString(6);
      return localpd;
      bool = false;
    }
  }

  public static rn a(Context paramContext)
  {
    try
    {
      if (c == null)
        c = new rn(paramContext);
      paramContext = c;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  private boolean a(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramLong > 0L) && (!paramBoolean))
      if (2 == paramInt)
      {
        paramInt = Integer.parseInt(paramString);
        if ((paramInt != 0) && (paramInt != 100));
      }
      else
      {
        paramString = this.b.a().getContentResolver();
        paramString.notifyChange(a("game_list/category"), null);
        paramString.notifyChange(a("game_list/hot"), null);
        paramString.notifyChange(a("game_list/new"), null);
        paramString.notifyChange(a("game_list/subject"), null);
        return true;
      }
    return false;
  }

  private void f(String paramString)
  {
    d(paramString);
    qm.b(new File(pe.b(paramString)));
  }

  private boolean h()
  {
    long l2 = 0L;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor = a(null, "SELECT SUM(size) FROM game_status , game WHERE game_hide_down = ? AND game_status.key = game.key AND status = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
      l1 = l2;
      String str;
      if (localCursor != null)
      {
        l1 = l2;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          str = localCursor.getString(0);
          localObject1 = localCursor;
          localObject3 = localCursor;
          boolean bool = TextUtils.isEmpty(str);
          if (!bool)
            break label108;
        }
      }
      for (l1 = l2; ; l1 = Long.valueOf(str).longValue())
      {
        qp.a(localCursor);
        if (l1 < 41943040L)
          break;
        return true;
        label108: localObject1 = localCursor;
        localObject3 = localCursor;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject3 = localObject1;
        localException.printStackTrace();
        qp.a(localObject1);
        long l1 = l2;
      }
    }
    finally
    {
      qp.a(localObject3);
    }
    return false;
  }

  public int a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("status", Integer.valueOf(0));
      int i = localSQLiteDatabase.update("game_status", localContentValues, "status<>?", new String[] { String.valueOf(1) });
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.w(a, "Reset game status failed", localThrowable);
    }
    return -1;
  }

  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int i = this.b.getWritableDatabase().update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramContentValues)
    {
      Log.w(a, "Update " + paramString1 + " failed", paramContentValues);
    }
    return 0;
  }

  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int i = this.b.getWritableDatabase().delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramString2)
    {
      Log.w(a, "Delete from " + paramString1 + " failed", paramString2);
    }
    return -1;
  }

  // ERROR //
  public int a(List<pc> paramList)
  {
    // Byte code:
    //   0: new 102	android/content/ContentValues
    //   3: dup
    //   4: iconst_2
    //   5: invokespecial 130	android/content/ContentValues:<init>	(I)V
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 52	rn:b	Lcom/hola/channel/sdk/game/content/provider/OpenHelper;
    //   14: invokevirtual 319	com/hola/channel/sdk/game/content/provider/OpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_3
    //   20: aload_2
    //   21: invokevirtual 349	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   24: aload_2
    //   25: astore_3
    //   26: aload_1
    //   27: invokeinterface 353 1 0
    //   32: astore_1
    //   33: iconst_m1
    //   34: istore 6
    //   36: iload 6
    //   38: istore 8
    //   40: aload_2
    //   41: astore_3
    //   42: aload_1
    //   43: invokeinterface 358 1 0
    //   48: ifeq +163 -> 211
    //   51: iload 6
    //   53: istore 8
    //   55: aload_2
    //   56: astore_3
    //   57: aload_1
    //   58: invokeinterface 362 1 0
    //   63: checkcast 364	pc
    //   66: astore 5
    //   68: iload 6
    //   70: istore 8
    //   72: aload_2
    //   73: astore_3
    //   74: aload 5
    //   76: getstatic 367	pc:c	Lpc;
    //   79: invokevirtual 368	pc:equals	(Ljava/lang/Object;)Z
    //   82: ifne -46 -> 36
    //   85: iload 6
    //   87: istore 8
    //   89: aload_2
    //   90: astore_3
    //   91: aload 4
    //   93: ldc_w 370
    //   96: aload 5
    //   98: getfield 372	pc:a	I
    //   101: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   107: iload 6
    //   109: istore 8
    //   111: aload_2
    //   112: astore_3
    //   113: aload 4
    //   115: ldc_w 374
    //   118: aload 5
    //   120: getfield 376	pc:b	Ljava/lang/String;
    //   123: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload 6
    //   128: istore 7
    //   130: iload 6
    //   132: istore 8
    //   134: aload_2
    //   135: astore_3
    //   136: aload_2
    //   137: ldc_w 378
    //   140: aconst_null
    //   141: aload 4
    //   143: invokevirtual 99	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   146: lconst_0
    //   147: lcmp
    //   148: ifle +9 -> 157
    //   151: iload 6
    //   153: iconst_1
    //   154: iadd
    //   155: istore 7
    //   157: iload 7
    //   159: istore 8
    //   161: aload_2
    //   162: astore_3
    //   163: aload_2
    //   164: invokevirtual 381	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	()Z
    //   167: pop
    //   168: iload 7
    //   170: istore 6
    //   172: goto -136 -> 36
    //   175: astore_1
    //   176: iload 8
    //   178: istore 6
    //   180: aload_2
    //   181: astore_3
    //   182: getstatic 43	rn:a	Ljava/lang/String;
    //   185: ldc_w 383
    //   188: aload_1
    //   189: invokestatic 335	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   192: pop
    //   193: aload_2
    //   194: ifnull +14 -> 208
    //   197: aload_2
    //   198: invokevirtual 386	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   201: ifeq +7 -> 208
    //   204: aload_2
    //   205: invokevirtual 389	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   208: iload 6
    //   210: ireturn
    //   211: iload 6
    //   213: istore 8
    //   215: aload_2
    //   216: astore_3
    //   217: aload_2
    //   218: invokevirtual 392	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   221: aload_2
    //   222: ifnull +57 -> 279
    //   225: aload_2
    //   226: invokevirtual 386	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   229: ifeq +50 -> 279
    //   232: aload_2
    //   233: invokevirtual 389	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   236: iload 6
    //   238: ireturn
    //   239: astore_1
    //   240: aconst_null
    //   241: astore_3
    //   242: aload_3
    //   243: ifnull +14 -> 257
    //   246: aload_3
    //   247: invokevirtual 386	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   250: ifeq +7 -> 257
    //   253: aload_3
    //   254: invokevirtual 389	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   257: aload_1
    //   258: athrow
    //   259: astore_1
    //   260: goto -18 -> 242
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_2
    //   266: iconst_m1
    //   267: istore 6
    //   269: goto -89 -> 180
    //   272: astore_1
    //   273: iconst_m1
    //   274: istore 6
    //   276: goto -96 -> 180
    //   279: iload 6
    //   281: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   42	51	175	java/lang/Throwable
    //   57	68	175	java/lang/Throwable
    //   74	85	175	java/lang/Throwable
    //   91	107	175	java/lang/Throwable
    //   113	126	175	java/lang/Throwable
    //   136	151	175	java/lang/Throwable
    //   163	168	175	java/lang/Throwable
    //   217	221	175	java/lang/Throwable
    //   10	18	239	finally
    //   20	24	259	finally
    //   26	33	259	finally
    //   42	51	259	finally
    //   57	68	259	finally
    //   74	85	259	finally
    //   91	107	259	finally
    //   113	126	259	finally
    //   136	151	259	finally
    //   163	168	259	finally
    //   182	193	259	finally
    //   217	221	259	finally
    //   10	18	263	java/lang/Throwable
    //   20	24	272	java/lang/Throwable
    //   26	33	272	java/lang/Throwable
  }

  public int a(JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramJSONObject, paramInt1, paramInt2, paramInt3, false);
  }

  public int a(JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j = -1;
    JSONObject localJSONObject2 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    ContentValues localContentValues = new ContentValues(ri.a.length);
    JSONObject localJSONObject1 = localJSONObject2;
    int i = j;
    Object localObject1 = localObject2;
    while (true)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("games");
        paramJSONObject = localObject3;
        i = j;
        if (localJSONArray != null)
        {
          localJSONObject1 = localJSONObject2;
          i = j;
          localObject1 = localObject2;
          paramJSONObject = this.b.getWritableDatabase();
          localJSONObject1 = paramJSONObject;
          i = j;
          localObject1 = paramJSONObject;
          paramJSONObject.beginTransaction();
          if (1 == paramInt3)
          {
            localJSONObject1 = paramJSONObject;
            i = j;
            localObject1 = paramJSONObject;
            paramJSONObject.delete("game_list", "code=? AND list_type=?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
          }
          localJSONObject1 = paramJSONObject;
          i = j;
          localObject1 = paramJSONObject;
          int m = localJSONArray.length();
          int k = 0;
          paramInt3 = j;
          if (k < m)
          {
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            localJSONObject2 = localJSONArray.getJSONObject(k);
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            if (a(paramJSONObject, localJSONObject2, localContentValues) <= 0L)
              break label568;
            j = 1;
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            localContentValues.clear();
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            localContentValues.put("list_type", Integer.valueOf(paramInt1));
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            localContentValues.put("code", Integer.valueOf(paramInt2));
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            localContentValues.put("key", localJSONObject2.optString("key"));
            localJSONObject1 = paramJSONObject;
            i = paramInt3;
            localObject1 = paramJSONObject;
            if (paramJSONObject.insert("game_list", null, localContentValues) <= 0L)
              break label574;
            i = 1;
            break;
            label328: localJSONObject1 = paramJSONObject;
            i = j;
            localObject1 = paramJSONObject;
            paramJSONObject.yieldIfContendedSafely();
            k += 1;
            paramInt3 = j;
            continue;
          }
          localJSONObject1 = paramJSONObject;
          i = paramInt3;
          localObject1 = paramJSONObject;
          paramJSONObject.setTransactionSuccessful();
          i = paramInt3;
        }
        paramInt2 = i;
        if (paramJSONObject != null)
        {
          paramInt2 = i;
          if (paramJSONObject.inTransaction())
          {
            paramJSONObject.endTransaction();
            paramInt2 = i;
          }
        }
        if (paramInt2 > 0);
        switch (paramInt1)
        {
        default:
          paramJSONObject = "game_list/subject";
          if (!paramBoolean)
            this.b.a().getContentResolver().notifyChange(a(paramJSONObject), null);
          return paramInt2;
        case 1:
        case 2:
        case 0:
        }
      }
      catch (Throwable paramJSONObject)
      {
        localObject1 = localJSONObject1;
        Log.w(a, "Insert game failed", paramJSONObject);
        paramInt2 = i;
        if (localJSONObject1 == null)
          continue;
        paramInt2 = i;
        if (!localJSONObject1.inTransaction())
          continue;
        localJSONObject1.endTransaction();
        paramInt2 = i;
        continue;
      }
      finally
      {
        if ((localObject1 != null) && (((SQLiteDatabase)localObject1).inTransaction()))
          ((SQLiteDatabase)localObject1).endTransaction();
      }
      paramJSONObject = "game_list/hot";
      continue;
      paramJSONObject = "game_list/new";
      continue;
      paramJSONObject = "game_list/category";
    }
    while (true)
    {
      if (j == 0)
      {
        j = paramInt3;
        if (i == 0)
          break label328;
      }
      j = paramInt3 + 1;
      break label328;
      label568: j = 0;
      break;
      label574: i = 0;
    }
  }

  public long a(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("key", paramString);
    localContentValues.put("start_time", Long.valueOf(paramLong));
    paramLong = b("game_log", localContentValues);
    if (paramLong > 0L)
    {
      paramString = this.b.a().getContentResolver();
      paramString.notifyChange(a("game_log"), null);
      paramString.notifyChange(a("game_list/new"), null);
      paramString.notifyChange(a("game_list/hot"), null);
    }
    return paramLong;
  }

  public long a(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = this.b.getWritableDatabase().replace(paramString, "_id", paramContentValues);
      return l;
    }
    catch (Throwable paramContentValues)
    {
      Log.w(a, "Insert into " + paramString + " failed", paramContentValues);
    }
    return -1L;
  }

  @SuppressLint({"NewApi"})
  public Cursor a(String paramString1, String paramString2, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
      if (Build.VERSION.SDK_INT >= 16);
      for (paramString2 = localSQLiteDatabase.rawQuery(paramString2, paramArrayOfString, paramCancellationSignal); ; paramString2 = localSQLiteDatabase.rawQuery(paramString2, paramArrayOfString))
      {
        paramArrayOfString = paramString2;
        if (TextUtils.isEmpty(paramString1))
          break;
        paramString2.setNotificationUri(this.b.a().getContentResolver(), a(paramString1));
        return paramString2;
      }
    }
    catch (Throwable paramString2)
    {
      Log.w(a, "Raw query " + paramString1 + " failed", paramString2);
      paramArrayOfString = new MatrixCursor(new String[] { "_id" }, 0);
    }
    return paramArrayOfString;
  }

  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    try
    {
      paramArrayOfString1 = this.b.getReadableDatabase().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3);
      paramArrayOfString1.setNotificationUri(this.b.a().getContentResolver(), a(paramString1));
      return paramArrayOfString1;
    }
    catch (Throwable paramArrayOfString1)
    {
      Log.w(a, "Query " + paramString1 + " failed", paramArrayOfString1);
    }
    return null;
  }

  // ERROR //
  public void a(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +134 -> 135
    //   4: aload_2
    //   5: ldc_w 487
    //   8: aconst_null
    //   9: invokevirtual 469	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_3
    //   13: aload_3
    //   14: astore 4
    //   16: new 102	android/content/ContentValues
    //   19: dup
    //   20: iconst_3
    //   21: invokespecial 130	android/content/ContentValues:<init>	(I)V
    //   24: astore 5
    //   26: aload_3
    //   27: astore 4
    //   29: aload 5
    //   31: ldc 111
    //   33: iconst_0
    //   34: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   40: aload_3
    //   41: astore 4
    //   43: aload 5
    //   45: ldc 122
    //   47: iconst_1
    //   48: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   54: aload_3
    //   55: ifnull +118 -> 173
    //   58: aload_3
    //   59: astore 4
    //   61: aload_3
    //   62: invokeinterface 187 1 0
    //   67: ifeq +106 -> 173
    //   70: aload_3
    //   71: astore 4
    //   73: aload 5
    //   75: ldc 105
    //   77: aload_3
    //   78: iconst_0
    //   79: invokeinterface 217 2 0
    //   84: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_2
    //   88: ifnull +61 -> 149
    //   91: aload_3
    //   92: astore 4
    //   94: aload_2
    //   95: ldc_w 321
    //   98: aconst_null
    //   99: aload 5
    //   101: invokevirtual 425	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   104: pop2
    //   105: goto -51 -> 54
    //   108: astore_2
    //   109: aload_3
    //   110: astore 4
    //   112: aload_2
    //   113: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   116: aload_3
    //   117: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   120: aload_1
    //   121: invokevirtual 258	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   124: ldc_w 321
    //   127: invokestatic 262	rn:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   130: aconst_null
    //   131: invokevirtual 268	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   134: return
    //   135: aload_0
    //   136: aconst_null
    //   137: ldc_w 487
    //   140: aconst_null
    //   141: aconst_null
    //   142: invokevirtual 181	rn:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   145: astore_3
    //   146: goto -133 -> 13
    //   149: aload_3
    //   150: astore 4
    //   152: aload_0
    //   153: ldc_w 321
    //   156: aload 5
    //   158: invokevirtual 441	rn:b	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   161: pop2
    //   162: goto -108 -> 54
    //   165: astore_1
    //   166: aload 4
    //   168: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   171: aload_1
    //   172: athrow
    //   173: aload_3
    //   174: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   177: goto -57 -> 120
    //   180: astore_1
    //   181: aconst_null
    //   182: astore 4
    //   184: goto -18 -> 166
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_3
    //   190: goto -81 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   16	26	108	java/lang/Exception
    //   29	40	108	java/lang/Exception
    //   43	54	108	java/lang/Exception
    //   61	70	108	java/lang/Exception
    //   73	87	108	java/lang/Exception
    //   94	105	108	java/lang/Exception
    //   152	162	108	java/lang/Exception
    //   16	26	165	finally
    //   29	40	165	finally
    //   43	54	165	finally
    //   61	70	165	finally
    //   73	87	165	finally
    //   94	105	165	finally
    //   112	116	165	finally
    //   152	162	165	finally
    //   4	13	180	finally
    //   135	146	180	finally
    //   4	13	187	java/lang/Exception
    //   135	146	187	java/lang/Exception
  }

  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
      paramRunnable.run();
    try
    {
      this.b.close();
      this.d.getLooper().quit();
      c = null;
      return;
    }
    finally
    {
    }
    throw paramRunnable;
  }

  public void a(final String paramString1, final int paramInt1, final String paramString2, final int paramInt2)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        rn.this.a(paramString1, paramInt1, paramString2, paramInt2, false);
      }
    });
  }

  public void a(String paramString, ro paramro)
  {
    a(paramString, null, paramro);
  }

  public void a(final String paramString1, final String[] paramArrayOfString1, final String paramString2, final String[] paramArrayOfString2, final String paramString3, final ro paramro)
  {
    paramro = new WeakReference(paramro);
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (paramro.get() == null);
        while (true)
        {
          return;
          try
          {
            ((ro)paramro.get()).a();
            try
            {
              localCursor = rn.this.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3);
            }
            finally
            {
              try
              {
                Cursor localCursor;
                Object localObject1 = paramro.get();
                if (localObject1 != null)
                {
                  try
                  {
                    bool = ((ro)paramro.get()).a(localCursor);
                    if (!bool)
                      continue;
                    qp.a(localCursor);
                    return;
                  }
                  catch (Throwable localThrowable2)
                  {
                    bool = true;
                  }
                  localObject2 = finally;
                  localCursor = null;
                  label101: qp.a(localCursor);
                  throw localObject2;
                }
              }
              finally
              {
                break label101;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            while (true)
            {
              continue;
              boolean bool = true;
            }
          }
        }
      }
    });
  }

  public void a(String paramString, String[] paramArrayOfString, ro paramro)
  {
    a("game", paramArrayOfString, "key=?", new String[] { paramString }, null, paramro);
  }

  public boolean a(Context paramContext, pe parampe, boolean paramBoolean)
  {
    int i = 2;
    while (true)
    {
      try
      {
        pd localpd = c(parampe.d);
        if (localpd == null)
        {
          if (paramBoolean)
            i = 1;
          paramContext = a(parampe.d, i, false);
          if (paramBoolean)
            paramContext.put("md5", parampe.m);
          a(b("game_status", paramContext), i, parampe.m, false);
        }
        else if (paramBoolean)
        {
          a(parampe.d, 1, parampe.m, 0, false);
          if (!localpd.a)
            break;
          sn.a(paramContext).b(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      a(parampe.d, 2, 0, 0, false);
    }
    return true;
  }

  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramString, paramInt1, String.valueOf(paramInt2), paramInt3, paramBoolean);
  }

  public boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    long l = 0L;
    try
    {
      ContentValues localContentValues = new ContentValues(4);
      localContentValues.put("key", paramString1);
      localContentValues.put("status", Integer.valueOf(paramInt1));
      localContentValues.put("md5", paramString2.toUpperCase(Locale.US));
      if (paramInt2 != -1)
        localContentValues.put("game_hide_down", Integer.valueOf(paramInt2));
      paramInt2 = a("game_status", localContentValues, "key = ? ", new String[] { paramString1 });
      l = paramInt2;
      return a(l, paramInt1, paramString2, paramBoolean);
    }
    catch (Throwable paramString1)
    {
      while (true)
        Log.w(a, "Update game status failed", paramString1);
    }
  }

  public int b(String paramString)
  {
    return a(paramString, null, null);
  }

  public long b(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = this.b.getWritableDatabase().insert(paramString, "_id", paramContentValues);
      return l;
    }
    catch (Throwable paramContentValues)
    {
      Log.w(a, "Insert into " + paramString + " failed", paramContentValues);
    }
    return -1L;
  }

  // ERROR //
  public pd b()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc_w 555
    //   5: iconst_2
    //   6: anewarray 140	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: iconst_1
    //   12: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iconst_1
    //   19: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   22: aastore
    //   23: aconst_null
    //   24: invokevirtual 181	rn:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +27 -> 56
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokeinterface 297 1 0
    //   40: ifeq +16 -> 56
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 190	rn:a	(Landroid/database/Cursor;)Lpd;
    //   49: astore_3
    //   50: aload_2
    //   51: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   54: aload_3
    //   55: areturn
    //   56: aload_2
    //   57: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   71: aload_2
    //   72: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   86: aload_2
    //   87: athrow
    //   88: astore_2
    //   89: aload_1
    //   90: astore_3
    //   91: goto -9 -> 82
    //   94: astore_3
    //   95: goto -30 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   0	28	62	java/lang/Exception
    //   0	28	77	finally
    //   34	43	88	finally
    //   45	50	88	finally
    //   67	71	88	finally
    //   34	43	94	java/lang/Exception
    //   45	50	94	java/lang/Exception
  }

  public void b(Runnable paramRunnable)
  {
    this.d.post(paramRunnable);
  }

  public boolean b(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("end_time", Long.valueOf(System.currentTimeMillis()));
    return a("game_log", localContentValues, "key=? AND start_time=?", new String[] { paramString, String.valueOf(paramLong) }) > 0;
  }

  public pd c()
  {
    pd localpd;
    if (h())
    {
      localpd = b();
      if (localpd != null)
        break label21;
    }
    while (true)
    {
      return d();
      label21: f(localpd.d);
    }
  }

  // ERROR //
  public pd c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc_w 578
    //   5: iconst_1
    //   6: anewarray 140	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: aconst_null
    //   14: invokevirtual 181	rn:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +27 -> 46
    //   22: aload_2
    //   23: astore_1
    //   24: aload_2
    //   25: invokeinterface 297 1 0
    //   30: ifeq +16 -> 46
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokestatic 190	rn:a	(Landroid/database/Cursor;)Lpd;
    //   39: astore_3
    //   40: aload_2
    //   41: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   44: aload_3
    //   45: areturn
    //   46: aload_2
    //   47: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   50: aconst_null
    //   51: areturn
    //   52: astore_3
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   61: aload_2
    //   62: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_1
    //   71: astore_2
    //   72: aload_3
    //   73: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: aload_1
    //   80: astore_3
    //   81: goto -9 -> 72
    //   84: astore_3
    //   85: goto -30 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	52	java/lang/Exception
    //   0	18	67	finally
    //   24	33	78	finally
    //   35	40	78	finally
    //   57	61	78	finally
    //   24	33	84	java/lang/Exception
    //   35	40	84	java/lang/Exception
  }

  // ERROR //
  public pd d()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc_w 580
    //   5: iconst_2
    //   6: anewarray 140	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: iconst_1
    //   12: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iconst_1
    //   19: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   22: aastore
    //   23: aconst_null
    //   24: invokevirtual 181	rn:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +27 -> 56
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokeinterface 297 1 0
    //   40: ifeq +16 -> 56
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 190	rn:a	(Landroid/database/Cursor;)Lpd;
    //   49: astore_3
    //   50: aload_2
    //   51: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   54: aload_3
    //   55: areturn
    //   56: aload_2
    //   57: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   71: aload_2
    //   72: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   86: aload_2
    //   87: athrow
    //   88: astore_2
    //   89: aload_1
    //   90: astore_3
    //   91: goto -9 -> 82
    //   94: astore_3
    //   95: goto -30 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   0	28	62	java/lang/Exception
    //   0	28	77	finally
    //   34	43	88	finally
    //   45	50	88	finally
    //   67	71	88	finally
    //   34	43	94	java/lang/Exception
    //   45	50	94	java/lang/Exception
  }

  public void d(String paramString)
  {
    a("game_status", "key = ?", new String[] { paramString });
  }

  public List<pd> e()
  {
    return a(0);
  }

  // ERROR //
  public pe e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 90
    //   3: aconst_null
    //   4: ldc_w 519
    //   7: iconst_1
    //   8: anewarray 140	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: aconst_null
    //   16: invokevirtual 589	rn:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: invokeinterface 297 1 0
    //   28: ifeq +18 -> 46
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: invokestatic 592	pe:a	(Landroid/database/Cursor;)Lpe;
    //   37: astore 4
    //   39: aload_3
    //   40: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   43: aload 4
    //   45: areturn
    //   46: aload_3
    //   47: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   50: aconst_null
    //   51: areturn
    //   52: astore 4
    //   54: aconst_null
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: getstatic 43	rn:a	Ljava/lang/String;
    //   61: new 23	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 594
    //   71: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: aload 4
    //   83: invokestatic 335	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: aload_3
    //   88: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   91: goto -41 -> 50
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 203	qp:a	(Landroid/database/Cursor;)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: goto -7 -> 97
    //   107: astore 4
    //   109: goto -53 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   0	20	52	java/lang/Throwable
    //   0	20	94	finally
    //   22	31	103	finally
    //   33	39	103	finally
    //   58	87	103	finally
    //   22	31	107	java/lang/Throwable
    //   33	39	107	java/lang/Throwable
  }

  public List<pd> f()
  {
    return a(2);
  }

  public int g()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("status", Integer.valueOf(0));
      int i = localSQLiteDatabase.update("game_status", localContentValues, "status=?", new String[] { String.valueOf(3) });
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.w(a, "Reset game status failed", localThrowable);
    }
    return -1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rn
 * JD-Core Version:    0.6.2
 */