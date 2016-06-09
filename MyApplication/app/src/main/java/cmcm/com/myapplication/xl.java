package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

public class xl
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/op_log");

  // ERROR //
  public static long a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 20	xl:a	Landroid/net/Uri;
    //   7: lload_1
    //   8: invokestatic 36	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   11: iconst_1
    //   12: anewarray 38	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc 40
    //   19: aastore
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 46	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_0
    //   27: aload_0
    //   28: invokeinterface 52 1 0
    //   33: ifeq +25 -> 58
    //   36: aload_0
    //   37: iconst_0
    //   38: invokeinterface 56 2 0
    //   43: lstore 4
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 59 1 0
    //   55: lload 4
    //   57: lreturn
    //   58: aload_0
    //   59: ifnull +9 -> 68
    //   62: aload_0
    //   63: invokeinterface 59 1 0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_0
    //   73: ldc 61
    //   75: new 63	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   82: ldc 68
    //   84: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: lload_1
    //   88: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: ldc 77
    //   93: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aload_3
    //   100: invokestatic 86	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: ifnull -36 -> 68
    //   107: aload_0
    //   108: invokeinterface 59 1 0
    //   113: goto -45 -> 68
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +9 -> 129
    //   123: aload_0
    //   124: invokeinterface 59 1 0
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: goto -13 -> 119
    //   135: astore_3
    //   136: goto -17 -> 119
    //   139: astore_3
    //   140: goto -67 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   0	27	70	java/lang/Throwable
    //   0	27	116	finally
    //   27	45	131	finally
    //   73	103	135	finally
    //   27	45	139	java/lang/Throwable
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS op_log (_id INTEGER PRIMARY KEY, code INTEGER , last_op INTEGER )");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX index_op_log_code ON op_log (code)");
  }

  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramContext, paramLong1);
    return System.currentTimeMillis() - paramLong1 > paramLong2;
  }

  public static boolean b(Context paramContext, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("code", Long.valueOf(paramLong));
    localContentValues.put("last_op", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("key_replace_if_exists", Boolean.valueOf(true));
    try
    {
      paramContext = paramContext.getContentResolver().insert(a, localContentValues);
      return paramContext != null;
    }
    catch (Throwable paramContext)
    {
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xl
 * JD-Core Version:    0.6.2
 */