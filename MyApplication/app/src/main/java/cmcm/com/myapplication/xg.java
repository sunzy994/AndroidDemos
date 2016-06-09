package cmcm.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;

public class xg
  implements BaseColumns
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/application");

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS application (_id INTEGER PRIMARY KEY, intent TEXT , last_called_time INTEGER , called_num INTEGER , alias TEXT , on_sdcard INTEGER DEFAULT 0, package TEXT , uninstalled INTEGER DEFAULT 0, label TEXT , is_system INTEGER , updated INTEGER )");
    d(paramSQLiteDatabase);
    e(paramSQLiteDatabase);
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase, SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN on_sdcard INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN package TEXT ");
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN uninstalled INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL(" DELETE FROM application WHERE _id NOT IN( SELECT  MIN(_id) FROM application GROUP BY intent)");
    d(paramSQLiteDatabase);
    e(paramSQLiteDatabase);
    c(paramSQLiteDatabase, paramSQLiteOpenHelper);
  }

  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN alias TEXT ");
  }

  // ERROR //
  public static void b(SQLiteDatabase paramSQLiteDatabase, SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ldc 55
    //   5: invokevirtual 30	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 57
    //   11: ldc 59
    //   13: invokestatic 64	arp:c	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: invokestatic 67	arp:a	(Ljava/lang/Object;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   19: checkcast 69	android/content/Context
    //   22: invokevirtual 73	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   25: astore_3
    //   26: getstatic 78	ash:b	Ljava/lang/String;
    //   29: astore_1
    //   30: aload_0
    //   31: ldc 80
    //   33: iconst_2
    //   34: anewarray 82	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 84
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 86
    //   46: aastore
    //   47: ldc 88
    //   49: iconst_1
    //   50: anewarray 82	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_1
    //   64: new 94	android/content/ContentValues
    //   67: dup
    //   68: iconst_1
    //   69: invokespecial 98	android/content/ContentValues:<init>	(I)V
    //   72: astore_2
    //   73: aload_1
    //   74: invokeinterface 104 1 0
    //   79: istore 5
    //   81: iload 5
    //   83: ifeq +65 -> 148
    //   86: aload_2
    //   87: ldc 106
    //   89: aload_3
    //   90: aload_1
    //   91: iconst_1
    //   92: invokeinterface 110 2 0
    //   97: invokestatic 116	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
    //   100: iconst_0
    //   101: invokevirtual 122	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   104: aload_3
    //   105: invokevirtual 128	android/content/pm/ActivityInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   108: invokeinterface 134 1 0
    //   113: invokevirtual 138	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: ldc 80
    //   119: aload_2
    //   120: ldc 140
    //   122: iconst_1
    //   123: anewarray 82	java/lang/String
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: iconst_0
    //   130: invokeinterface 110 2 0
    //   135: aastore
    //   136: invokevirtual 144	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: pop
    //   140: goto -67 -> 73
    //   143: astore 4
    //   145: goto -72 -> 73
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 147 1 0
    //   158: return
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull -5 -> 158
    //   166: aload_1
    //   167: invokeinterface 147 1 0
    //   172: return
    //   173: astore_0
    //   174: aload_2
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +9 -> 186
    //   180: aload_1
    //   181: invokeinterface 147 1 0
    //   186: aload_0
    //   187: athrow
    //   188: astore_0
    //   189: goto -13 -> 176
    //   192: astore_0
    //   193: goto -31 -> 162
    //
    // Exception table:
    //   from	to	target	type
    //   86	140	143	java/lang/Throwable
    //   8	64	159	java/lang/Throwable
    //   8	64	173	finally
    //   64	73	188	finally
    //   73	81	188	finally
    //   86	140	188	finally
    //   64	73	192	java/lang/Throwable
    //   73	81	192	java/lang/Throwable
  }

  public static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN is_system INTEGER ");
    paramSQLiteDatabase.execSQL("ALTER TABLE application ADD COLUMN updated INTEGER ");
  }

  // ERROR //
  private static void c(SQLiteDatabase paramSQLiteDatabase, SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ldc 153
    //   5: invokevirtual 30	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 57
    //   11: ldc 59
    //   13: invokestatic 64	arp:c	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: invokestatic 67	arp:a	(Ljava/lang/Object;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   19: checkcast 69	android/content/Context
    //   22: invokevirtual 73	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   25: astore_3
    //   26: aload_0
    //   27: ldc 80
    //   29: iconst_2
    //   30: anewarray 82	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 84
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 155
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_1
    //   52: aload_1
    //   53: invokeinterface 104 1 0
    //   58: ifeq +83 -> 141
    //   61: aload_3
    //   62: aload_1
    //   63: iconst_1
    //   64: invokeinterface 110 2 0
    //   69: iconst_0
    //   70: invokevirtual 159	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   73: getfield 165	android/content/pm/ApplicationInfo:flags	I
    //   76: ldc 166
    //   78: iand
    //   79: ifeq +56 -> 135
    //   82: iconst_1
    //   83: istore 4
    //   85: iconst_1
    //   86: iload 4
    //   88: if_icmpne -36 -> 52
    //   91: aload_0
    //   92: new 168	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   99: ldc 172
    //   101: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: iconst_0
    //   106: invokeinterface 180 2 0
    //   111: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokevirtual 30	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   120: goto -68 -> 52
    //   123: astore_0
    //   124: aload_1
    //   125: ifnull +9 -> 134
    //   128: aload_1
    //   129: invokeinterface 147 1 0
    //   134: return
    //   135: iconst_0
    //   136: istore 4
    //   138: goto -53 -> 85
    //   141: aload_1
    //   142: ifnull -8 -> 134
    //   145: aload_1
    //   146: invokeinterface 147 1 0
    //   151: return
    //   152: astore_0
    //   153: aload_2
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 147 1 0
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: goto -13 -> 155
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -50 -> 124
    //
    // Exception table:
    //   from	to	target	type
    //   52	82	123	java/lang/Throwable
    //   91	120	123	java/lang/Throwable
    //   8	52	152	finally
    //   52	82	167	finally
    //   91	120	167	finally
    //   8	52	171	java/lang/Throwable
  }

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX index_intent ON application (intent)");
      label6: paramSQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS index_intent ON application (intent)");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label6;
    }
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX index_package ON application (package)");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xg
 * JD-Core Version:    0.6.2
 */