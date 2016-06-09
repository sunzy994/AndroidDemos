package cmcm.com.myapplication.com.lazyswipe.app;

import alo;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import asp;
import java.util.ArrayList;
import java.util.List;
import wp;
import xa;
import xe;
import xj;
import xm;

public class LazyProvider extends ContentProvider
{
  private static final UriMatcher a = new UriMatcher(-1);
  private SQLiteOpenHelper b;
  private boolean c;

  static
  {
    a.addURI("com.lazyswipe", "application", 1);
    a.addURI("com.lazyswipe", "application/#", 2);
    a.addURI("com.lazyswipe", "banner", 3);
    a.addURI("com.lazyswipe", "banner/*", 4);
    a.addURI("com.lazyswipe", "op_log", 5);
    a.addURI("com.lazyswipe", "op_log/#", 6);
    a.addURI("com.lazyswipe", "default_favorites", 9);
    a.addURI("com.lazyswipe", "best_match_favorites", 10);
    a.addURI("com.lazyswipe", "contact", 21);
    a.addURI("com.lazyswipe", "contact_app_key", 22);
    a.addURI("com.lazyswipe", "notification", 23);
    a.addURI("com.lazyswipe", "notification_AGGREGATE_BY_CONTACT_APP", 24);
    a.addURI("com.lazyswipe", "notification_AGGREGATE_BY_APP", 25);
    a.addURI("com.lazyswipe", "app_contact", 26);
    a.addURI("com.lazyswipe", "contact_log", 27);
    a.addURI("com.lazyswipe", "contact_log/#", 28);
    a.addURI("com.lazyswipe", "news", 29);
    a.addURI("com.lazyswipe", "news/#", 30);
  }

  private int a(SQLiteDatabase paramSQLiteDatabase)
  {
    SQLiteDatabase localSQLiteDatabase2 = null;
    SQLiteDatabase localSQLiteDatabase1 = null;
    int j = 0;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT changes() AS affected_row_count", null);
      localSQLiteDatabase1 = paramSQLiteDatabase;
      localSQLiteDatabase2 = paramSQLiteDatabase;
      if (paramSQLiteDatabase.moveToFirst())
      {
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localSQLiteDatabase2 = paramSQLiteDatabase;
        int i = paramSQLiteDatabase.getInt(0);
        j = i;
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.close();
          j = i;
        }
        return j;
      }
      return 0;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      return 0;
    }
    finally
    {
      if (localSQLiteDatabase2 != null)
        localSQLiteDatabase2.close();
    }
    throw paramSQLiteDatabase;
  }

  // ERROR //
  private Cursor a(SQLiteDatabase paramSQLiteDatabase, wp paramwp)
  {
    // Byte code:
    //   0: new 92	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: ldc 95
    //   11: aload_2
    //   12: getfield 100	wp:c	[Ljava/lang/String;
    //   15: iconst_0
    //   16: aaload
    //   17: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +306 -> 326
    //   23: ldc 108
    //   25: astore 5
    //   27: aload_2
    //   28: getfield 100	wp:c	[Ljava/lang/String;
    //   31: astore_3
    //   32: aload_1
    //   33: ldc 110
    //   35: iconst_2
    //   36: anewarray 102	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload 5
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc 112
    //   48: aastore
    //   49: ldc 114
    //   51: aload_3
    //   52: aload 5
    //   54: aconst_null
    //   55: ldc 116
    //   57: invokevirtual 120	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: invokeinterface 82 1 0
    //   72: ifeq +211 -> 283
    //   75: iconst_0
    //   76: istore 7
    //   78: iload 7
    //   80: ifle +24 -> 104
    //   83: aload 4
    //   85: astore_3
    //   86: aload 6
    //   88: bipush 10
    //   90: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   93: ldc 126
    //   95: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: bipush 10
    //   100: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: astore_3
    //   107: aload 6
    //   109: ldc 131
    //   111: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 133
    //   116: getstatic 138	com/lazyswipe/notification/NotificationData:d	[Ljava/lang/String;
    //   119: invokestatic 144	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: bipush 44
    //   127: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   130: iload 7
    //   132: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: ldc 149
    //   137: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 151
    //   142: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 153
    //   147: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 155
    //   152: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 48
    //   157: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 157
    //   162: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 159
    //   172: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 4
    //   177: iconst_0
    //   178: invokeinterface 163 2 0
    //   183: invokestatic 169	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 171
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 173
    //   196: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 159
    //   201: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: bipush 39
    //   206: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   209: aload_2
    //   210: getfield 100	wp:c	[Ljava/lang/String;
    //   213: iconst_0
    //   214: aaload
    //   215: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: bipush 39
    //   220: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: astore_3
    //   227: aload 4
    //   229: invokeinterface 176 1 0
    //   234: ifne +182 -> 416
    //   237: aload 4
    //   239: astore_3
    //   240: aload 6
    //   242: bipush 10
    //   244: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   247: ldc 178
    //   249: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: bipush 116
    //   254: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   257: bipush 44
    //   259: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   262: ldc 180
    //   264: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 182
    //   269: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 4
    //   275: astore_3
    //   276: aload 4
    //   278: invokeinterface 89 1 0
    //   283: aload 4
    //   285: ifnull +20 -> 305
    //   288: aload 4
    //   290: invokeinterface 185 1 0
    //   295: ifne +10 -> 305
    //   298: aload 4
    //   300: invokeinterface 89 1 0
    //   305: aload 6
    //   307: invokevirtual 189	java/lang/StringBuilder:length	()I
    //   310: ifle +96 -> 406
    //   313: aload_1
    //   314: aload 6
    //   316: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: aconst_null
    //   320: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   323: astore_1
    //   324: aload_1
    //   325: areturn
    //   326: ldc 195
    //   328: astore 5
    //   330: goto -303 -> 27
    //   333: astore_2
    //   334: aconst_null
    //   335: astore 4
    //   337: aload 4
    //   339: astore_3
    //   340: ldc 197
    //   342: ldc 199
    //   344: aload_2
    //   345: invokestatic 204	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   348: aload 4
    //   350: ifnull -45 -> 305
    //   353: aload 4
    //   355: invokeinterface 185 1 0
    //   360: ifne -55 -> 305
    //   363: aload 4
    //   365: invokeinterface 89 1 0
    //   370: goto -65 -> 305
    //   373: astore_1
    //   374: aconst_null
    //   375: astore_3
    //   376: aload_3
    //   377: ifnull +18 -> 395
    //   380: aload_3
    //   381: invokeinterface 185 1 0
    //   386: ifne +9 -> 395
    //   389: aload_3
    //   390: invokeinterface 89 1 0
    //   395: aload_1
    //   396: athrow
    //   397: astore_1
    //   398: ldc 197
    //   400: ldc 206
    //   402: aload_1
    //   403: invokestatic 204	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   406: aconst_null
    //   407: areturn
    //   408: astore_1
    //   409: goto -33 -> 376
    //   412: astore_2
    //   413: goto -76 -> 337
    //   416: iload 7
    //   418: iconst_1
    //   419: iadd
    //   420: istore 7
    //   422: goto -344 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   27	62	333	java/lang/Throwable
    //   27	62	373	finally
    //   313	324	397	java/lang/Throwable
    //   65	75	408	finally
    //   86	104	408	finally
    //   107	224	408	finally
    //   227	237	408	finally
    //   240	273	408	finally
    //   276	283	408	finally
    //   340	348	408	finally
    //   65	75	412	java/lang/Throwable
    //   86	104	412	java/lang/Throwable
    //   107	224	412	java/lang/Throwable
    //   227	237	412	java/lang/Throwable
    //   240	273	412	java/lang/Throwable
    //   276	283	412	java/lang/Throwable
  }

  // ERROR //
  private Bundle a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 211	com/lazyswipe/app/LazyProvider:getContext	()Landroid/content/Context;
    //   9: astore 4
    //   11: aload 4
    //   13: invokestatic 216	ahy:d	(Landroid/content/Context;)Z
    //   16: ifeq +67 -> 83
    //   19: bipush 13
    //   21: istore 8
    //   23: aload 4
    //   25: iload 8
    //   27: ldc 218
    //   29: invokestatic 223	aqn:a	(Landroid/content/Context;ILjava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: aload_2
    //   34: invokeinterface 228 1 0
    //   39: istore 10
    //   41: invokestatic 233	vv:a	()Lvv;
    //   44: ldc 235
    //   46: ldc 237
    //   48: iload 10
    //   50: invokevirtual 239	vv:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   53: iload 10
    //   55: iload 8
    //   57: if_icmpge +851 -> 908
    //   60: aload_0
    //   61: invokevirtual 211	com/lazyswipe/app/LazyProvider:getContext	()Landroid/content/Context;
    //   64: iload 8
    //   66: ldc 241
    //   68: invokestatic 223	aqn:a	(Landroid/content/Context;ILjava/lang/String;)Ljava/util/List;
    //   71: astore_2
    //   72: aload_2
    //   73: invokeinterface 244 1 0
    //   78: ifeq +12 -> 90
    //   81: aconst_null
    //   82: areturn
    //   83: bipush 9
    //   85: istore 8
    //   87: goto -64 -> 23
    //   90: aload_0
    //   91: getfield 246	com/lazyswipe/app/LazyProvider:b	Landroid/database/sqlite/SQLiteOpenHelper;
    //   94: invokevirtual 252	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: new 254	android/content/ContentValues
    //   103: dup
    //   104: iconst_4
    //   105: invokespecial 255	android/content/ContentValues:<init>	(I)V
    //   108: astore_3
    //   109: aload_2
    //   110: invokeinterface 259 1 0
    //   115: astore_2
    //   116: iconst_0
    //   117: istore 8
    //   119: iload 8
    //   121: istore 10
    //   123: aload_2
    //   124: invokeinterface 264 1 0
    //   129: ifeq +607 -> 736
    //   132: iload 8
    //   134: istore 10
    //   136: aload_2
    //   137: invokeinterface 268 1 0
    //   142: checkcast 270	alw
    //   145: astore 5
    //   147: iload 9
    //   149: iconst_1
    //   150: iadd
    //   151: istore 11
    //   153: iload 8
    //   155: istore 10
    //   157: aload_3
    //   158: ldc_w 272
    //   161: iload 9
    //   163: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: invokevirtual 282	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   169: iload 8
    //   171: istore 10
    //   173: aload_3
    //   174: ldc_w 284
    //   177: aload 5
    //   179: getfield 287	alw:c	Landroid/net/Uri;
    //   182: invokevirtual 290	android/net/Uri:toString	()Ljava/lang/String;
    //   185: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 8
    //   190: istore 10
    //   192: aload 5
    //   194: getfield 296	alw:d	Ljava/lang/String;
    //   197: invokestatic 299	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +19 -> 219
    //   203: iload 8
    //   205: istore 10
    //   207: aload_3
    //   208: ldc_w 301
    //   211: aload 5
    //   213: getfield 296	alw:d	Ljava/lang/String;
    //   216: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: iload 8
    //   221: istore 10
    //   223: aload 5
    //   225: getfield 304	alw:e	Landroid/net/Uri;
    //   228: ifnull +66 -> 294
    //   231: iload 8
    //   233: istore 10
    //   235: aload_3
    //   236: ldc_w 306
    //   239: aload 5
    //   241: getfield 304	alw:e	Landroid/net/Uri;
    //   244: invokevirtual 290	android/net/Uri:toString	()Ljava/lang/String;
    //   247: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iload 8
    //   252: istore 10
    //   254: aload 4
    //   256: aload 5
    //   258: getfield 287	alw:c	Landroid/net/Uri;
    //   261: invokestatic 309	aqn:a	(Landroid/content/Context;Landroid/net/Uri;)[B
    //   264: astore 6
    //   266: aload 6
    //   268: ifnull +26 -> 294
    //   271: iload 8
    //   273: istore 10
    //   275: aload 6
    //   277: arraylength
    //   278: ifle +16 -> 294
    //   281: iload 8
    //   283: istore 10
    //   285: aload_3
    //   286: ldc_w 311
    //   289: aload 6
    //   291: invokevirtual 314	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   294: aload_1
    //   295: ldc 44
    //   297: aconst_null
    //   298: aload_3
    //   299: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   302: lstore 12
    //   304: lload 12
    //   306: lconst_0
    //   307: lcmp
    //   308: ifgt +10 -> 318
    //   311: iload 11
    //   313: istore 9
    //   315: goto -196 -> 119
    //   318: aload 5
    //   320: getfield 287	alw:c	Landroid/net/Uri;
    //   323: invokevirtual 321	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   326: astore 6
    //   328: aload_3
    //   329: invokevirtual 324	android/content/ContentValues:clear	()V
    //   332: aload_3
    //   333: ldc_w 326
    //   336: lload 12
    //   338: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   341: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   344: aload_3
    //   345: ldc_w 336
    //   348: ldc_w 338
    //   351: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload 5
    //   356: getfield 287	alw:c	Landroid/net/Uri;
    //   359: aload 4
    //   361: invokestatic 341	aqn:c	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
    //   364: astore 7
    //   366: aload_3
    //   367: ldc_w 343
    //   370: aload 7
    //   372: getfield 349	android/util/Pair:second	Ljava/lang/Object;
    //   375: checkcast 102	java/lang/String
    //   378: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_3
    //   382: ldc_w 351
    //   385: aload 7
    //   387: getfield 354	android/util/Pair:first	Ljava/lang/Object;
    //   390: checkcast 102	java/lang/String
    //   393: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_1
    //   397: ldc 46
    //   399: aconst_null
    //   400: aload_3
    //   401: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   404: pop2
    //   405: aload_3
    //   406: invokevirtual 324	android/content/ContentValues:clear	()V
    //   409: aload_3
    //   410: ldc_w 326
    //   413: lload 12
    //   415: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   421: aload_3
    //   422: ldc_w 336
    //   425: ldc_w 356
    //   428: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_3
    //   432: ldc_w 343
    //   435: aload 5
    //   437: getfield 287	alw:c	Landroid/net/Uri;
    //   440: aload 4
    //   442: invokestatic 359	aqn:b	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   445: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload_1
    //   449: ldc 46
    //   451: aconst_null
    //   452: aload_3
    //   453: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   456: pop2
    //   457: aload_3
    //   458: invokevirtual 324	android/content/ContentValues:clear	()V
    //   461: aload_3
    //   462: ldc_w 326
    //   465: lload 12
    //   467: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   470: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   473: aload_3
    //   474: ldc_w 336
    //   477: ldc 95
    //   479: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload_3
    //   483: ldc_w 343
    //   486: aload 5
    //   488: getfield 287	alw:c	Landroid/net/Uri;
    //   491: aload 4
    //   493: invokestatic 361	aqn:d	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   496: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload_1
    //   500: ldc 46
    //   502: aconst_null
    //   503: aload_3
    //   504: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   507: pop2
    //   508: aload_3
    //   509: invokevirtual 324	android/content/ContentValues:clear	()V
    //   512: aload_3
    //   513: ldc_w 326
    //   516: lload 12
    //   518: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   521: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   524: aload_3
    //   525: ldc_w 336
    //   528: ldc_w 363
    //   531: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_3
    //   535: ldc_w 343
    //   538: aload 5
    //   540: getfield 287	alw:c	Landroid/net/Uri;
    //   543: aload 4
    //   545: invokestatic 365	aqn:a	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   548: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_1
    //   552: ldc 46
    //   554: aconst_null
    //   555: aload_3
    //   556: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   559: pop2
    //   560: aload_3
    //   561: invokevirtual 324	android/content/ContentValues:clear	()V
    //   564: aload_3
    //   565: ldc_w 326
    //   568: lload 12
    //   570: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   573: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   576: aload_3
    //   577: ldc_w 336
    //   580: ldc_w 367
    //   583: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload_3
    //   587: ldc_w 343
    //   590: aload 6
    //   592: aload 4
    //   594: invokestatic 370	aqn:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   597: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload_1
    //   601: ldc 46
    //   603: aconst_null
    //   604: aload_3
    //   605: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   608: pop2
    //   609: aload_3
    //   610: invokevirtual 324	android/content/ContentValues:clear	()V
    //   613: aload_3
    //   614: ldc_w 326
    //   617: lload 12
    //   619: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   622: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   625: aload_3
    //   626: ldc_w 336
    //   629: ldc_w 372
    //   632: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 6
    //   637: aload 4
    //   639: invokestatic 374	aqn:b	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   642: astore 5
    //   644: aload_3
    //   645: ldc_w 343
    //   648: aload 5
    //   650: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: aload_1
    //   654: ldc 46
    //   656: aconst_null
    //   657: aload_3
    //   658: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   661: pop2
    //   662: aload_3
    //   663: invokevirtual 324	android/content/ContentValues:clear	()V
    //   666: aload_3
    //   667: ldc_w 326
    //   670: lload 12
    //   672: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   678: aload_3
    //   679: ldc_w 336
    //   682: ldc_w 376
    //   685: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload_3
    //   689: ldc_w 343
    //   692: aload 5
    //   694: invokevirtual 293	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload_1
    //   698: ldc 46
    //   700: aconst_null
    //   701: aload_3
    //   702: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   705: pop2
    //   706: iload 8
    //   708: iconst_1
    //   709: iadd
    //   710: istore 8
    //   712: iload 8
    //   714: istore 10
    //   716: aload_3
    //   717: invokevirtual 324	android/content/ContentValues:clear	()V
    //   720: iload 8
    //   722: istore 10
    //   724: aload_1
    //   725: invokevirtual 379	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	()Z
    //   728: pop
    //   729: iload 11
    //   731: istore 9
    //   733: goto -614 -> 119
    //   736: iload 8
    //   738: istore 10
    //   740: aload_1
    //   741: invokevirtual 382	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   744: aload_1
    //   745: ifnull +156 -> 901
    //   748: aload_1
    //   749: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   752: ifeq +149 -> 901
    //   755: aload_1
    //   756: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   759: iload 8
    //   761: istore 9
    //   763: aload 4
    //   765: iconst_1
    //   766: invokestatic 391	alw:a	(Landroid/content/Context;Z)Ljava/util/List;
    //   769: pop
    //   770: new 393	android/os/Bundle
    //   773: dup
    //   774: iconst_1
    //   775: invokespecial 394	android/os/Bundle:<init>	(I)V
    //   778: astore_1
    //   779: aload_1
    //   780: ldc_w 396
    //   783: iload 9
    //   785: invokevirtual 400	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   788: aload_1
    //   789: areturn
    //   790: astore_2
    //   791: iconst_0
    //   792: istore 8
    //   794: ldc 197
    //   796: new 92	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 402
    //   806: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_2
    //   810: invokevirtual 405	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 411	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   822: pop
    //   823: iload 8
    //   825: istore 9
    //   827: aload_1
    //   828: ifnull -65 -> 763
    //   831: iload 8
    //   833: istore 9
    //   835: aload_1
    //   836: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   839: ifeq -76 -> 763
    //   842: aload_1
    //   843: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   846: iload 8
    //   848: istore 9
    //   850: goto -87 -> 763
    //   853: astore_2
    //   854: aconst_null
    //   855: astore_1
    //   856: aload_1
    //   857: ifnull +14 -> 871
    //   860: aload_1
    //   861: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   864: ifeq +7 -> 871
    //   867: aload_1
    //   868: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   871: aload_2
    //   872: athrow
    //   873: astore_2
    //   874: goto -18 -> 856
    //   877: astore_2
    //   878: goto -22 -> 856
    //   881: astore_2
    //   882: iconst_0
    //   883: istore 8
    //   885: goto -91 -> 794
    //   888: astore_2
    //   889: iload 10
    //   891: istore 8
    //   893: goto -99 -> 794
    //   896: astore 5
    //   898: goto -186 -> 712
    //   901: iload 8
    //   903: istore 9
    //   905: goto -142 -> 763
    //   908: goto -836 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   90	98	790	java/lang/Throwable
    //   90	98	853	finally
    //   100	116	873	finally
    //   123	132	873	finally
    //   136	147	873	finally
    //   157	169	873	finally
    //   173	188	873	finally
    //   192	203	873	finally
    //   207	219	873	finally
    //   223	231	873	finally
    //   235	250	873	finally
    //   254	266	873	finally
    //   275	281	873	finally
    //   285	294	873	finally
    //   294	304	873	finally
    //   318	706	873	finally
    //   716	720	873	finally
    //   724	729	873	finally
    //   740	744	873	finally
    //   794	823	877	finally
    //   100	116	881	java/lang/Throwable
    //   123	132	888	java/lang/Throwable
    //   136	147	888	java/lang/Throwable
    //   157	169	888	java/lang/Throwable
    //   173	188	888	java/lang/Throwable
    //   192	203	888	java/lang/Throwable
    //   207	219	888	java/lang/Throwable
    //   223	231	888	java/lang/Throwable
    //   235	250	888	java/lang/Throwable
    //   254	266	888	java/lang/Throwable
    //   275	281	888	java/lang/Throwable
    //   285	294	888	java/lang/Throwable
    //   716	720	888	java/lang/Throwable
    //   724	729	888	java/lang/Throwable
    //   740	744	888	java/lang/Throwable
    //   294	304	896	java/lang/Throwable
    //   318	706	896	java/lang/Throwable
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (("com.tencent.mm".equals(paramString1)) && (Build.VERSION.SDK_INT >= 18))
    {
      paramString2 = " DELETE FROM memory_db.notification WHERE package_name=? AND n_id=? AND _id NOT IN( SELECT _id FROM memory_db.notification WHERE package_name=? AND n_id=? ORDER BY _when DESC LIMIT 15)";
      paramString4 = new String[4];
      paramString4[0] = paramString1;
      paramString4[1] = paramString3;
      paramString4[2] = paramString1;
      paramString4[3] = paramString3;
      paramString1 = paramString4;
    }
    try
    {
      while (true)
      {
        paramSQLiteDatabase.execSQL(paramString2, paramString1);
        if (a(paramSQLiteDatabase) > 0)
          alo.a(paramSQLiteDatabase);
        return;
        if (("com.whatsapp".equals(paramString1)) || ("com.viber.voip".equals(paramString1)) || ("org.telegram.messenger".equals(paramString1)) || ("com.tencent.mm".equals(paramString1)))
        {
          if (paramString5 == null)
          {
            paramString3 = " AND app_identity IS NULL ";
            paramString4 = new String[4];
            paramString4[0] = paramString1;
            paramString4[1] = paramString2;
            paramString4[2] = paramString1;
            paramString4[3] = paramString2;
            paramString1 = paramString4;
            paramString2 = paramString3;
          }
          while (true)
          {
            paramString2 = " DELETE FROM memory_db.notification WHERE package_name=? AND title=?" + paramString2 + " AND " + "_id" + " NOT IN(" + " SELECT " + "_id" + " FROM " + "memory_db." + "notification" + " WHERE " + "package_name" + "=?" + " AND " + "title" + "=?" + paramString2 + " ORDER BY " + "_when" + " DESC" + " LIMIT " + 15 + ")";
            break;
            paramString4 = " AND app_identity=?";
            paramString3 = new String[6];
            paramString3[0] = paramString1;
            paramString3[1] = paramString2;
            paramString3[2] = paramString5;
            paramString3[3] = paramString1;
            paramString3[4] = paramString2;
            paramString3[5] = paramString5;
            paramString2 = paramString4;
            paramString1 = paramString3;
          }
        }
        paramString2 = " DELETE FROM memory_db.notification WHERE package_name=? AND _id NOT IN( SELECT _id FROM memory_db.notification WHERE package_name=? ORDER BY _when DESC LIMIT 15)";
        paramString3 = new String[2];
        paramString3[0] = paramString1;
        paramString3[1] = paramString1;
        paramString1 = paramString3;
      }
    }
    catch (Throwable paramSQLiteDatabase)
    {
    }
  }

  private boolean a(ContentValues paramContentValues)
  {
    return a(paramContentValues, "key_suppress_notify");
  }

  private boolean a(ContentValues paramContentValues, String paramString)
  {
    boolean bool = paramContentValues.containsKey(paramString);
    if (bool)
      paramContentValues.remove(paramString);
    return bool;
  }

  private boolean a(Bundle paramBundle)
  {
    return a(paramBundle, "key_suppress_notify");
  }

  private boolean a(Bundle paramBundle, String paramString)
  {
    if ((paramBundle != null) && (paramBundle.containsKey(paramString)));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        paramBundle.remove(paramString);
      return bool;
    }
  }

  private boolean a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      localSQLiteDatabase.execSQL(" UPDATE contact_log SET times=times+1, last_contact=? WHERE contact_id=?", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString });
      if (a(localSQLiteDatabase) <= 0)
        localSQLiteDatabase.execSQL("INSERT INTO contact_log (contact_id, last_contact, times) VALUES  (?, ?, 1)", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
      return true;
    }
    catch (Throwable localThrowable)
    {
      asp.b("Swipe.Provider", "Could not update contact log: " + paramString + "; " + localThrowable.getMessage());
    }
    return false;
  }

  private boolean a(String paramString, long paramLong)
  {
    try
    {
      this.b.getWritableDatabase().execSQL(" UPDATE banner SET time_showed=time_showed+?, seen=? WHERE code=?", new Object[] { Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()), paramString });
      return true;
    }
    catch (Throwable localThrowable)
    {
      asp.b("Swipe.Provider", "Could not update showed time for banner " + paramString + ": " + localThrowable.getMessage());
    }
    return false;
  }

  private boolean a(String[] paramArrayOfString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" UPDATE application SET called_num=");
    Object localObject;
    if (1 == paramInt)
      localObject = " CASE  WHEN 1==is_system THEN 15 ELSE 25 END ";
    while (true)
    {
      paramArrayOfString = localObject + " WHERE " + "package" + " IN(" + "'" + TextUtils.join("','", paramArrayOfString) + "'" + ")" + " AND " + "called_num" + "<=0";
      try
      {
        this.b.getWritableDatabase().execSQL(paramArrayOfString, null);
        return true;
        localObject = Integer.valueOf(2);
      }
      catch (Throwable paramArrayOfString)
      {
        asp.b("Swipe.Provider", "Could not update call count of running packages: " + paramArrayOfString.getMessage());
      }
    }
    return false;
  }

  // ERROR //
  private Cursor b(SQLiteDatabase paramSQLiteDatabase, wp paramwp)
  {
    // Byte code:
    //   0: new 92	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload_2
    //   10: getfield 100	wp:c	[Ljava/lang/String;
    //   13: astore_3
    //   14: aload_1
    //   15: ldc 110
    //   17: iconst_2
    //   18: anewarray 102	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 173
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 112
    //   30: aastore
    //   31: ldc_w 518
    //   34: aload_3
    //   35: ldc 173
    //   37: aconst_null
    //   38: ldc 116
    //   40: invokevirtual 120	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: invokeinterface 82 1 0
    //   55: ifeq +209 -> 264
    //   58: iconst_0
    //   59: istore 6
    //   61: iload 6
    //   63: ifle +24 -> 87
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: bipush 10
    //   73: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   76: ldc 126
    //   78: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: bipush 10
    //   83: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 4
    //   89: astore_3
    //   90: aload 5
    //   92: ldc 131
    //   94: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 133
    //   99: getstatic 519	com/lazyswipe/notification/NotificationData:c	[Ljava/lang/String;
    //   102: invokestatic 144	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   105: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: bipush 44
    //   110: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   113: iload 6
    //   115: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc 149
    //   120: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 151
    //   125: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 153
    //   130: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 155
    //   135: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 48
    //   140: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 157
    //   145: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 173
    //   150: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: bipush 61
    //   155: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   158: bipush 39
    //   160: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   163: aload 4
    //   165: iconst_0
    //   166: invokeinterface 163 2 0
    //   171: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: bipush 39
    //   176: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   179: ldc 171
    //   181: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 326
    //   187: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 159
    //   192: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: getfield 100	wp:c	[Ljava/lang/String;
    //   199: iconst_0
    //   200: aaload
    //   201: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: astore_3
    //   208: aload 4
    //   210: invokeinterface 176 1 0
    //   215: ifne +176 -> 391
    //   218: aload 4
    //   220: astore_3
    //   221: aload 5
    //   223: bipush 10
    //   225: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   228: ldc 178
    //   230: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: bipush 116
    //   235: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   238: bipush 44
    //   240: invokevirtual 124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   243: ldc 180
    //   245: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 182
    //   250: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 4
    //   256: astore_3
    //   257: aload 4
    //   259: invokeinterface 89 1 0
    //   264: aload 4
    //   266: ifnull +20 -> 286
    //   269: aload 4
    //   271: invokeinterface 185 1 0
    //   276: ifne +10 -> 286
    //   279: aload 4
    //   281: invokeinterface 89 1 0
    //   286: aload 5
    //   288: invokevirtual 189	java/lang/StringBuilder:length	()I
    //   291: ifle +90 -> 381
    //   294: aload_1
    //   295: aload 5
    //   297: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: aconst_null
    //   301: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   304: astore_1
    //   305: aload_1
    //   306: areturn
    //   307: astore_2
    //   308: aconst_null
    //   309: astore 4
    //   311: aload 4
    //   313: astore_3
    //   314: ldc 197
    //   316: ldc 199
    //   318: aload_2
    //   319: invokestatic 204	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload 4
    //   324: ifnull -38 -> 286
    //   327: aload 4
    //   329: invokeinterface 185 1 0
    //   334: ifne -48 -> 286
    //   337: aload 4
    //   339: invokeinterface 89 1 0
    //   344: goto -58 -> 286
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: ifnull +18 -> 369
    //   354: aload_3
    //   355: invokeinterface 185 1 0
    //   360: ifne +9 -> 369
    //   363: aload_3
    //   364: invokeinterface 89 1 0
    //   369: aload_1
    //   370: athrow
    //   371: astore_1
    //   372: ldc 197
    //   374: ldc_w 521
    //   377: aload_1
    //   378: invokestatic 204	asp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: aconst_null
    //   382: areturn
    //   383: astore_1
    //   384: goto -34 -> 350
    //   387: astore_2
    //   388: goto -77 -> 311
    //   391: iload 6
    //   393: iconst_1
    //   394: iadd
    //   395: istore 6
    //   397: goto -336 -> 61
    //
    // Exception table:
    //   from	to	target	type
    //   9	45	307	java/lang/Throwable
    //   9	45	347	finally
    //   294	305	371	java/lang/Throwable
    //   48	58	383	finally
    //   69	87	383	finally
    //   90	205	383	finally
    //   208	218	383	finally
    //   221	254	383	finally
    //   257	264	383	finally
    //   314	322	383	finally
    //   48	58	387	java/lang/Throwable
    //   69	87	387	java/lang/Throwable
    //   90	205	387	java/lang/Throwable
    //   208	218	387	java/lang/Throwable
    //   221	254	387	java/lang/Throwable
    //   257	264	387	java/lang/Throwable
  }

  // ERROR //
  private Bundle b(Bundle paramBundle)
  {
    // Byte code:
    //   0: new 393	android/os/Bundle
    //   3: dup
    //   4: iconst_1
    //   5: invokespecial 394	android/os/Bundle:<init>	(I)V
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 246	com/lazyswipe/app/LazyProvider:b	Landroid/database/sqlite/SQLiteOpenHelper;
    //   14: invokevirtual 252	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_3
    //   18: aload_3
    //   19: astore_2
    //   20: aload_3
    //   21: invokevirtual 525	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   24: aload_3
    //   25: astore_2
    //   26: aload_3
    //   27: ldc_w 527
    //   30: iconst_4
    //   31: anewarray 102	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: ldc_w 529
    //   40: invokevirtual 531	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: ldc 180
    //   49: invokevirtual 531	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: aload_1
    //   56: ldc_w 533
    //   59: invokevirtual 531	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_3
    //   65: aload_1
    //   66: ldc_w 535
    //   69: invokevirtual 531	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: aastore
    //   73: invokevirtual 424	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: ldc_w 396
    //   83: aload_0
    //   84: aload_3
    //   85: invokespecial 426	com/lazyswipe/app/LazyProvider:a	(Landroid/database/sqlite/SQLiteDatabase;)I
    //   88: invokevirtual 400	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 382	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   97: iconst_0
    //   98: ifeq +11 -> 109
    //   101: new 537	java/lang/NullPointerException
    //   104: dup
    //   105: invokespecial 538	java/lang/NullPointerException:<init>	()V
    //   108: athrow
    //   109: aload_3
    //   110: ifnull +14 -> 124
    //   113: aload_3
    //   114: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   117: ifeq +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   124: aload 4
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: ldc 197
    //   134: new 92	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 540
    //   144: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 405	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 487	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: iconst_0
    //   161: ifeq +11 -> 172
    //   164: new 537	java/lang/NullPointerException
    //   167: dup
    //   168: invokespecial 538	java/lang/NullPointerException:<init>	()V
    //   171: athrow
    //   172: aload_3
    //   173: ifnull -49 -> 124
    //   176: aload_3
    //   177: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   180: ifeq -56 -> 124
    //   183: aload_3
    //   184: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   187: aload 4
    //   189: areturn
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: iconst_0
    //   194: ifeq +11 -> 205
    //   197: new 537	java/lang/NullPointerException
    //   200: dup
    //   201: invokespecial 538	java/lang/NullPointerException:<init>	()V
    //   204: athrow
    //   205: aload_2
    //   206: ifnull +14 -> 220
    //   209: aload_2
    //   210: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   213: ifeq +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: goto -30 -> 193
    //   226: astore_1
    //   227: goto -97 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   10	18	127	java/lang/Throwable
    //   10	18	190	finally
    //   20	24	222	finally
    //   26	76	222	finally
    //   78	91	222	finally
    //   93	97	222	finally
    //   132	160	222	finally
    //   20	24	226	java/lang/Throwable
    //   26	76	226	java/lang/Throwable
    //   78	91	226	java/lang/Throwable
    //   93	97	226	java/lang/Throwable
  }

  // ERROR //
  private Bundle b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 246	com/lazyswipe/app/LazyProvider:b	Landroid/database/sqlite/SQLiteOpenHelper;
    //   7: invokevirtual 252	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore 5
    //   12: aload 5
    //   14: ldc_w 543
    //   17: aconst_null
    //   18: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: new 545	java/util/ArrayList
    //   25: dup
    //   26: aload_2
    //   27: invokeinterface 548 1 0
    //   32: invokespecial 549	java/util/ArrayList:<init>	(I)V
    //   35: astore_3
    //   36: aload_2
    //   37: invokeinterface 176 1 0
    //   42: ifeq +132 -> 174
    //   45: aload_3
    //   46: getstatic 555	java/util/Locale:US	Ljava/util/Locale;
    //   49: ldc_w 557
    //   52: iconst_3
    //   53: anewarray 473	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_2
    //   59: iconst_0
    //   60: invokeinterface 163 2 0
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_2
    //   69: iconst_1
    //   70: invokeinterface 163 2 0
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: aload_2
    //   79: iconst_2
    //   80: invokeinterface 163 2 0
    //   85: aastore
    //   86: invokestatic 561	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokevirtual 564	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -57 -> 36
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_1
    //   103: astore 7
    //   105: aload_3
    //   106: astore 6
    //   108: aload_2
    //   109: astore 5
    //   111: ldc 197
    //   113: new 92	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 402
    //   123: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 4
    //   128: invokevirtual 405	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 487	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: invokeinterface 89 1 0
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_3
    //   155: invokeinterface 89 1 0
    //   160: aload_1
    //   161: ifnull +9 -> 170
    //   164: aload_1
    //   165: invokeinterface 89 1 0
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: areturn
    //   174: new 393	android/os/Bundle
    //   177: dup
    //   178: iconst_1
    //   179: invokespecial 394	android/os/Bundle:<init>	(I)V
    //   182: astore 8
    //   184: aload 8
    //   186: ldc_w 533
    //   189: aload_3
    //   190: invokevirtual 568	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   193: aload 5
    //   195: ldc_w 570
    //   198: iconst_1
    //   199: anewarray 102	java/lang/String
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   209: astore_3
    //   210: aload_3
    //   211: invokeinterface 82 1 0
    //   216: ifeq +19 -> 235
    //   219: aload 8
    //   221: ldc_w 535
    //   224: new 135	com/lazyswipe/notification/NotificationData
    //   227: dup
    //   228: aload_3
    //   229: invokespecial 573	com/lazyswipe/notification/NotificationData:<init>	(Landroid/database/Cursor;)V
    //   232: invokevirtual 577	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   235: aload 5
    //   237: ldc_w 579
    //   240: aconst_null
    //   241: invokevirtual 76	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   244: astore_1
    //   245: aload_1
    //   246: astore 7
    //   248: aload_3
    //   249: astore 6
    //   251: aload_2
    //   252: astore 5
    //   254: aload_1
    //   255: invokeinterface 82 1 0
    //   260: pop
    //   261: aload_1
    //   262: astore 7
    //   264: aload_3
    //   265: astore 6
    //   267: aload_2
    //   268: astore 5
    //   270: aload 8
    //   272: ldc_w 581
    //   275: aload_1
    //   276: iconst_0
    //   277: invokeinterface 86 2 0
    //   282: invokevirtual 400	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   285: aload_2
    //   286: ifnull +9 -> 295
    //   289: aload_2
    //   290: invokeinterface 89 1 0
    //   295: aload_3
    //   296: ifnull +9 -> 305
    //   299: aload_3
    //   300: invokeinterface 89 1 0
    //   305: aload 8
    //   307: astore_2
    //   308: aload_1
    //   309: ifnull -137 -> 172
    //   312: aload_1
    //   313: invokeinterface 89 1 0
    //   318: aload 8
    //   320: areturn
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +9 -> 336
    //   330: aload_2
    //   331: invokeinterface 89 1 0
    //   336: aload_3
    //   337: ifnull +9 -> 346
    //   340: aload_3
    //   341: invokeinterface 89 1 0
    //   346: aload 4
    //   348: ifnull +10 -> 358
    //   351: aload 4
    //   353: invokeinterface 89 1 0
    //   358: aload_1
    //   359: athrow
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_3
    //   363: goto -37 -> 326
    //   366: astore_1
    //   367: goto -41 -> 326
    //   370: astore_1
    //   371: aload 7
    //   373: astore 4
    //   375: aload 6
    //   377: astore_3
    //   378: aload 5
    //   380: astore_2
    //   381: goto -55 -> 326
    //   384: astore 4
    //   386: aconst_null
    //   387: astore_1
    //   388: aconst_null
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_2
    //   392: goto -290 -> 102
    //   395: astore 4
    //   397: aconst_null
    //   398: astore_1
    //   399: goto -297 -> 102
    //   402: astore 4
    //   404: goto -302 -> 102
    //
    // Exception table:
    //   from	to	target	type
    //   22	36	96	java/lang/Throwable
    //   36	93	96	java/lang/Throwable
    //   174	210	96	java/lang/Throwable
    //   3	22	321	finally
    //   22	36	360	finally
    //   36	93	360	finally
    //   174	210	360	finally
    //   210	235	366	finally
    //   235	245	366	finally
    //   111	140	370	finally
    //   254	261	370	finally
    //   270	285	370	finally
    //   3	22	384	java/lang/Throwable
    //   210	235	395	java/lang/Throwable
    //   235	245	395	java/lang/Throwable
    //   254	261	402	java/lang/Throwable
    //   270	285	402	java/lang/Throwable
  }

  private boolean b(ContentValues paramContentValues)
  {
    return a(paramContentValues, "key_replace_if_exists");
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    return super.applyBatch(paramArrayList);
  }

  // ERROR //
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 595	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4: invokeinterface 228 1 0
    //   9: iconst_1
    //   10: if_icmpeq +31 -> 41
    //   13: new 597	java/lang/IllegalArgumentException
    //   16: dup
    //   17: new 92	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 599
    //   27: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 601	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: aload_1
    //   42: invokestatic 604	wp:a	(Landroid/net/Uri;)Ljava/lang/String;
    //   45: astore 6
    //   47: aload_2
    //   48: arraylength
    //   49: istore 7
    //   51: aconst_null
    //   52: astore 4
    //   54: aconst_null
    //   55: astore 5
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 606	com/lazyswipe/app/LazyProvider:c	Z
    //   62: iconst_0
    //   63: istore 17
    //   65: iconst_0
    //   66: istore 14
    //   68: iconst_0
    //   69: istore 15
    //   71: iconst_0
    //   72: istore 16
    //   74: aload_0
    //   75: getfield 246	com/lazyswipe/app/LazyProvider:b	Landroid/database/sqlite/SQLiteOpenHelper;
    //   78: invokevirtual 252	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   81: astore_3
    //   82: iload 17
    //   84: istore 15
    //   86: iload 7
    //   88: istore 8
    //   90: aload_3
    //   91: invokevirtual 525	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   94: iload 17
    //   96: istore 15
    //   98: iload 7
    //   100: istore 8
    //   102: aload_2
    //   103: arraylength
    //   104: istore 11
    //   106: iconst_0
    //   107: istore 10
    //   109: iconst_0
    //   110: istore 9
    //   112: iload 16
    //   114: istore 15
    //   116: goto +345 -> 461
    //   119: iload 9
    //   121: ifne +337 -> 458
    //   124: iload 14
    //   126: istore 15
    //   128: iload 7
    //   130: istore 8
    //   132: aload_0
    //   133: aload 4
    //   135: invokespecial 608	com/lazyswipe/app/LazyProvider:b	(Landroid/content/ContentValues;)Z
    //   138: istore 16
    //   140: iload 14
    //   142: istore 15
    //   144: iload 7
    //   146: istore 8
    //   148: aload_0
    //   149: aload 4
    //   151: invokespecial 610	com/lazyswipe/app/LazyProvider:a	(Landroid/content/ContentValues;)Z
    //   154: istore 14
    //   156: iload 16
    //   158: istore 15
    //   160: iload 15
    //   162: ifeq +41 -> 203
    //   165: aload_3
    //   166: aload 6
    //   168: aconst_null
    //   169: aload 4
    //   171: invokevirtual 613	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   174: lstore 12
    //   176: lconst_0
    //   177: lload 12
    //   179: lcmp
    //   180: ifle +275 -> 455
    //   183: iload 7
    //   185: iconst_1
    //   186: isub
    //   187: istore 7
    //   189: aload_3
    //   190: invokevirtual 379	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	()Z
    //   193: pop
    //   194: iload 9
    //   196: iconst_1
    //   197: iadd
    //   198: istore 9
    //   200: goto +279 -> 479
    //   203: aload_3
    //   204: aload 6
    //   206: aconst_null
    //   207: aload 4
    //   209: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   212: lstore 12
    //   214: goto -38 -> 176
    //   217: iload 14
    //   219: istore 15
    //   221: iload 7
    //   223: istore 8
    //   225: aload_3
    //   226: invokevirtual 382	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 606	com/lazyswipe/app/LazyProvider:c	Z
    //   234: iload 14
    //   236: istore 15
    //   238: iload 7
    //   240: istore 8
    //   242: aload_3
    //   243: ifnull +30 -> 273
    //   246: iload 14
    //   248: istore 15
    //   250: iload 7
    //   252: istore 8
    //   254: aload_3
    //   255: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   258: ifeq +15 -> 273
    //   261: aload_3
    //   262: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   265: iload 7
    //   267: istore 8
    //   269: iload 14
    //   271: istore 15
    //   273: iload 8
    //   275: ifle +20 -> 295
    //   278: iload 15
    //   280: ifne +15 -> 295
    //   283: aload_0
    //   284: invokevirtual 211	com/lazyswipe/app/LazyProvider:getContext	()Landroid/content/Context;
    //   287: invokevirtual 619	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   290: aload_1
    //   291: aconst_null
    //   292: invokevirtual 625	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   295: iload 8
    //   297: ireturn
    //   298: astore_3
    //   299: iload 15
    //   301: istore 14
    //   303: aload 5
    //   305: astore_2
    //   306: aload_2
    //   307: astore 4
    //   309: ldc 197
    //   311: new 92	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 627
    //   321: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_3
    //   325: invokevirtual 405	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   328: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 487	asp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_0
    //   338: iconst_0
    //   339: putfield 606	com/lazyswipe/app/LazyProvider:c	Z
    //   342: iload 14
    //   344: istore 15
    //   346: iload 7
    //   348: istore 8
    //   350: aload_2
    //   351: ifnull -78 -> 273
    //   354: iload 14
    //   356: istore 15
    //   358: iload 7
    //   360: istore 8
    //   362: aload_2
    //   363: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   366: ifeq -93 -> 273
    //   369: aload_2
    //   370: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   373: iload 14
    //   375: istore 15
    //   377: iload 7
    //   379: istore 8
    //   381: goto -108 -> 273
    //   384: astore_1
    //   385: aload_0
    //   386: iconst_0
    //   387: putfield 606	com/lazyswipe/app/LazyProvider:c	Z
    //   390: aload 4
    //   392: ifnull +16 -> 408
    //   395: aload 4
    //   397: invokevirtual 385	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   400: ifeq +8 -> 408
    //   403: aload 4
    //   405: invokevirtual 388	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aload_3
    //   412: astore 4
    //   414: goto -29 -> 385
    //   417: astore 4
    //   419: aload_3
    //   420: astore_2
    //   421: aload 4
    //   423: astore_3
    //   424: iload 15
    //   426: istore 14
    //   428: iload 8
    //   430: istore 7
    //   432: goto -126 -> 306
    //   435: astore 4
    //   437: aload_3
    //   438: astore_2
    //   439: aload 4
    //   441: astore_3
    //   442: goto -136 -> 306
    //   445: astore 4
    //   447: aload_3
    //   448: astore_2
    //   449: aload 4
    //   451: astore_3
    //   452: goto -146 -> 306
    //   455: goto -266 -> 189
    //   458: goto -298 -> 160
    //   461: iload 10
    //   463: iload 11
    //   465: if_icmpge -248 -> 217
    //   468: aload_2
    //   469: iload 10
    //   471: aaload
    //   472: astore 4
    //   474: aload 4
    //   476: ifnonnull -357 -> 119
    //   479: iload 10
    //   481: iconst_1
    //   482: iadd
    //   483: istore 10
    //   485: goto -24 -> 461
    //
    // Exception table:
    //   from	to	target	type
    //   74	82	298	java/lang/Throwable
    //   74	82	384	finally
    //   309	337	384	finally
    //   90	94	410	finally
    //   102	106	410	finally
    //   132	140	410	finally
    //   148	156	410	finally
    //   165	176	410	finally
    //   189	194	410	finally
    //   203	214	410	finally
    //   225	229	410	finally
    //   90	94	417	java/lang/Throwable
    //   102	106	417	java/lang/Throwable
    //   132	140	417	java/lang/Throwable
    //   148	156	417	java/lang/Throwable
    //   225	229	417	java/lang/Throwable
    //   165	176	435	java/lang/Throwable
    //   203	214	435	java/lang/Throwable
    //   189	194	445	java/lang/Throwable
  }

  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    int k = 1;
    int m = 1;
    int j = 1;
    boolean bool1 = a(paramBundle);
    int i = -1;
    switch (paramString1.hashCode())
    {
    default:
      switch (i)
      {
      default:
        paramString1 = null;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      break;
    case 1699420547:
    case -1143832403:
    case 595358846:
    case -231680217:
    case -1645799926:
    case -1398814369:
    }
    do
    {
      do
      {
        return paramString1;
        if (!paramString1.equals("initContacts"))
          break;
        i = 0;
        break;
        if (!paramString1.equals("updateContactLog"))
          break;
        i = 1;
        break;
        if (!paramString1.equals("updateBannerShowedTime"))
          break;
        i = 2;
        break;
        if (!paramString1.equals("initFavorites"))
          break;
        i = 3;
        break;
        if (!paramString1.equals("getNotificationNumber"))
          break;
        i = 4;
        break;
        if (!paramString1.equals("updateNotificationTextAndNumber"))
          break;
        i = 5;
        break;
        return a();
        boolean bool2 = a(paramString2);
        paramString1 = new Bundle(1);
        if (bool2);
        for (i = j; ; i = 0)
        {
          paramString1.putInt("result_affected_row_count", i);
          if ((bool2) && (!bool1))
            getContext().getContentResolver().notifyChange(xe.a, null);
          return paramString1;
        }
        bool2 = a(paramBundle.getString("extra_param_1"), paramBundle.getLong("extra_param_2"));
        paramString1 = new Bundle(1);
        if (bool2);
        for (i = k; ; i = 0)
        {
          paramString1.putInt("result_affected_row_count", i);
          if ((bool2) && (!bool1))
            getContext().getContentResolver().notifyChange(xa.a, null);
          return paramString1;
        }
        bool2 = a(paramBundle.getStringArray("extra_param_1"), paramBundle.getInt("extra_param_2"));
        paramString1 = new Bundle(1);
        if (bool2);
        for (i = m; ; i = 0)
        {
          paramString1.putInt("result_affected_row_count", i);
          if ((bool2) && (!bool1))
            getContext().getContentResolver().notifyChange(xa.a, null);
          return paramString1;
        }
        return b(paramString2);
        paramString2 = b(paramBundle);
        paramString1 = paramString2;
      }
      while (bool1);
      paramString1 = paramString2;
    }
    while (paramString2.getInt("result_affected_row_count") <= 0);
    getContext().getContentResolver().notifyChange(xj.a, null);
    return paramString2;
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramString = new wp(this, paramUri, paramString, paramArrayOfString);
    try
    {
      paramArrayOfString = this.b.getWritableDatabase();
      if ("contact_app_key".equals(paramString.a));
      int i = paramArrayOfString.delete(paramString.a, paramString.b, paramString.c);
      if (i > 0)
      {
        if ((!this.c) && (!paramString.d))
          getContext().getContentResolver().notifyChange(paramUri, null);
        if (paramString.a.contains("notification"))
          alo.a(paramArrayOfString);
      }
      return i;
    }
    catch (Throwable paramUri)
    {
      asp.b("Swipe.Provider", "delete failed: " + paramUri.getMessage());
    }
    return 0;
  }

  public String getType(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    case 7:
    case 8:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    default:
      return "";
    case 1:
      return "vnd.android.cursor.dir/com.lazyswipe.application";
    case 2:
      return "vnd.android.cursor.item/com.lazyswipe.application";
    case 3:
      return "vnd.android.cursor.dir/com.lazyswipe.banner";
    case 4:
      return "vnd.android.cursor.item/com.lazyswipe.banner";
    case 5:
      return "vnd.android.cursor.dir/com.lazyswipe.op_log";
    case 6:
      return "vnd.android.cursor.item/com.lazyswipe.op_log";
    case 9:
      return "vnd.android.cursor.dir/com.lazyswipe.default_favorites";
    case 10:
      return "vnd.android.cursor.dir/com.lazyswipe.best_match_favorites";
    case 21:
      return "vnd.android.cursor.dir/com.lazyswipe.contact";
    case 22:
      return "vnd.android.cursor.dir/com.lazyswipe.contact_app_key";
    case 23:
    case 24:
    case 25:
      return "vnd.android.cursor.dir/com.lazyswipe.notification";
    case 26:
      return "vnd.android.cursor.dir/com.lazyswipe.app_contact";
    case 27:
      return "vnd.android.cursor.dir/com.lazyswipe.contact_log";
    case 28:
      return "vnd.android.cursor.item/com.lazyswipe.contact_log";
    case 29:
      return "vnd.android.cursor.dir/com.lazyswipe.news";
    case 30:
    }
    return "vnd.android.cursor.item/com.lazyswipe.news";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramUri.getPathSegments().size() != 1)
      throw new IllegalArgumentException("Invalid uri: " + paramUri);
    String str = wp.a(paramUri);
    boolean bool1 = a(paramContentValues);
    boolean bool2 = b(paramContentValues);
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      if (bool2);
      for (long l = localSQLiteDatabase.replace(str, null, paramContentValues); l >= 0L; l = localSQLiteDatabase.insert(str, null, paramContentValues))
      {
        paramUri = ContentUris.withAppendedId(paramUri, l);
        if (str.contains("notification"))
        {
          alo.d(l);
          a(localSQLiteDatabase, paramContentValues.getAsString("package_name"), paramContentValues.getAsString("title"), paramContentValues.getAsString("n_id"), paramContentValues.getAsString("contact_id"), paramContentValues.getAsString("app_identity"));
        }
        if ((this.c) || (bool1))
          break label221;
        getContext().getContentResolver().notifyChange(paramUri, null);
        break label221;
      }
    }
    catch (Throwable paramUri)
    {
      asp.b("Swipe.Provider", "insert failed: " + paramUri.getMessage());
    }
    return null;
    label221: return paramUri;
  }

  public boolean onCreate()
  {
    this.b = new DatabaseHelper(getContext());
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    wp localwp = new wp(this, paramUri, paramString1, paramArrayOfString2);
    try
    {
      if ("public_pref".equals(localwp.a))
        return xm.a(getContext(), paramUri, paramString1, paramArrayOfString2);
      paramString1 = this.b.getReadableDatabase();
      if ("notification_AGGREGATE_BY_CONTACT_APP".equals(localwp.a))
        return b(paramString1, localwp);
      if ("notification_AGGREGATE_BY_APP".equals(localwp.a))
        return a(paramString1, localwp);
      paramArrayOfString1 = paramString1.query(localwp.a, paramArrayOfString1, localwp.b, localwp.c, null, null, paramString2);
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
      return paramArrayOfString1;
    }
    catch (Throwable paramUri)
    {
      asp.b("Swipe.Provider", "query failed: " + paramUri.getMessage());
    }
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    wp localwp = new wp(this, paramUri, paramString, paramArrayOfString);
    int i;
    try
    {
      if ("public_pref".equals(localwp.a))
        return xm.a(getContext(), paramUri, paramContentValues, paramString, paramArrayOfString);
      boolean bool = a(paramContentValues);
      int j = this.b.getWritableDatabase().update(localwp.a, paramContentValues, localwp.b, localwp.c);
      i = j;
      if (j > 0)
      {
        i = j;
        if (!this.c)
        {
          i = j;
          if (!bool)
          {
            getContext().getContentResolver().notifyChange(paramUri, null);
            return j;
          }
        }
      }
    }
    catch (Throwable paramUri)
    {
      asp.b("Swipe.Provider", "update failed: " + paramUri.getMessage());
      i = 0;
    }
    return i;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.app.LazyProvider
 * JD-Core Version:    0.6.2
 */