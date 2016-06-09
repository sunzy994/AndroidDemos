package cmcm.com.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.features.weather.bean.City;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajy
{
  private final Context a;
  private String b;
  private ajz c;
  private AsyncTask d = null;

  public ajy(Context paramContext)
  {
    this.a = paramContext;
    try
    {
      paramContext = c();
      if (paramContext != null)
        paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("Swipe.QueryCityHandler", "Failed to init city db", paramContext);
      throw new NullPointerException();
    }
    finally
    {
      if (0 == 0);
    }
    throw paramContext;
  }

  public ajy(Context paramContext, String paramString)
  {
    this(paramContext);
    this.b = paramString;
  }

  // ERROR //
  private SQLiteDatabase c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	ajy:b	Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: aload_2
    //   8: ifnonnull +11 -> 19
    //   11: aload_0
    //   12: getfield 25	ajy:a	Landroid/content/Context;
    //   15: invokevirtual 62	android/content/Context:getPackageName	()Ljava/lang/String;
    //   18: astore_1
    //   19: new 64	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   26: invokestatic 71	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   29: invokevirtual 76	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 82
    //   37: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 84
    //   46: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 5
    //   54: new 73	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 6
    //   65: aload 6
    //   67: invokevirtual 93	java/io/File:getParentFile	()Ljava/io/File;
    //   70: invokevirtual 97	java/io/File:exists	()Z
    //   73: ifne +12 -> 85
    //   76: aload 6
    //   78: invokevirtual 93	java/io/File:getParentFile	()Ljava/io/File;
    //   81: invokevirtual 100	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 25	ajy:a	Landroid/content/Context;
    //   89: invokevirtual 104	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 106
    //   96: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   99: astore_2
    //   100: aload 6
    //   102: invokevirtual 97	java/io/File:exists	()Z
    //   105: ifne +30 -> 135
    //   108: aload_2
    //   109: aload 6
    //   111: invokestatic 117	aqx:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   114: pop
    //   115: aload 5
    //   117: aconst_null
    //   118: invokestatic 121	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   121: astore_3
    //   122: aload_3
    //   123: astore_1
    //   124: aload_3
    //   125: iconst_5
    //   126: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   129: aload_2
    //   130: invokestatic 130	arf:a	(Ljava/io/Closeable;)V
    //   133: aload_3
    //   134: areturn
    //   135: aload 5
    //   137: aconst_null
    //   138: invokestatic 121	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: astore_1
    //   149: aload 4
    //   151: invokevirtual 134	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   154: iconst_5
    //   155: if_icmpge -26 -> 129
    //   158: aload 4
    //   160: astore_1
    //   161: aload 4
    //   163: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: aload 4
    //   168: astore_1
    //   169: aload 6
    //   171: invokevirtual 137	java/io/File:delete	()Z
    //   174: pop
    //   175: aload 4
    //   177: astore_1
    //   178: aload_2
    //   179: aload 6
    //   181: invokestatic 117	aqx:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   184: pop
    //   185: aload 4
    //   187: astore_1
    //   188: aload 5
    //   190: aconst_null
    //   191: invokestatic 121	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   194: astore_3
    //   195: aload_3
    //   196: astore_1
    //   197: aload_3
    //   198: iconst_5
    //   199: invokevirtual 125	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   202: goto -73 -> 129
    //   205: astore_3
    //   206: aload_2
    //   207: invokestatic 130	arf:a	(Ljava/io/Closeable;)V
    //   210: aload_1
    //   211: areturn
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_2
    //   215: aload_2
    //   216: invokestatic 130	arf:a	(Ljava/io/Closeable;)V
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: goto -7 -> 215
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -24 -> 206
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_1
    //   236: goto -30 -> 206
    //
    // Exception table:
    //   from	to	target	type
    //   124	129	205	java/lang/Exception
    //   149	158	205	java/lang/Exception
    //   161	166	205	java/lang/Exception
    //   169	175	205	java/lang/Exception
    //   178	185	205	java/lang/Exception
    //   188	195	205	java/lang/Exception
    //   197	202	205	java/lang/Exception
    //   93	100	212	finally
    //   100	122	221	finally
    //   124	129	221	finally
    //   135	143	221	finally
    //   149	158	221	finally
    //   161	166	221	finally
    //   169	175	221	finally
    //   178	185	221	finally
    //   188	195	221	finally
    //   197	202	221	finally
    //   93	100	225	java/lang/Exception
    //   100	122	233	java/lang/Exception
    //   135	143	233	java/lang/Exception
  }

  // ERROR //
  public List<City> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: new 140	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 141	java/util/ArrayList:<init>	()V
    //   17: astore 6
    //   19: aload_0
    //   20: invokespecial 28	ajy:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: astore_2
    //   28: aload 5
    //   30: astore 4
    //   32: aload_3
    //   33: ldc 143
    //   35: aconst_null
    //   36: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_3
    //   45: astore_2
    //   46: aload 5
    //   48: astore 4
    //   50: aload 5
    //   52: invokeinterface 152 1 0
    //   57: ifle +128 -> 185
    //   60: aload 5
    //   62: astore_1
    //   63: aload_3
    //   64: astore_2
    //   65: aload 5
    //   67: astore 4
    //   69: aload 5
    //   71: invokeinterface 155 1 0
    //   76: ifeq +109 -> 185
    //   79: aload 5
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: ldc 157
    //   92: invokeinterface 161 2 0
    //   97: istore 7
    //   99: aload 5
    //   101: astore_1
    //   102: aload_3
    //   103: astore_2
    //   104: aload 5
    //   106: astore 4
    //   108: aload 5
    //   110: ldc 163
    //   112: invokeinterface 161 2 0
    //   117: istore 8
    //   119: aload 5
    //   121: astore_1
    //   122: aload_3
    //   123: astore_2
    //   124: aload 5
    //   126: astore 4
    //   128: aload 6
    //   130: new 165	com/lazyswipe/features/weather/bean/City
    //   133: dup
    //   134: aload 5
    //   136: iload 7
    //   138: invokeinterface 169 2 0
    //   143: aconst_null
    //   144: aload 5
    //   146: iload 8
    //   148: invokeinterface 169 2 0
    //   153: invokespecial 172	com/lazyswipe/features/weather/bean/City:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   156: invokeinterface 178 2 0
    //   161: pop
    //   162: aload 5
    //   164: astore_1
    //   165: aload_3
    //   166: astore_2
    //   167: aload 5
    //   169: astore 4
    //   171: aload 5
    //   173: invokeinterface 181 1 0
    //   178: istore 9
    //   180: iload 9
    //   182: ifne -63 -> 119
    //   185: aload 5
    //   187: ifnull +10 -> 197
    //   190: aload 5
    //   192: invokeinterface 182 1 0
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   205: aload 6
    //   207: areturn
    //   208: astore 5
    //   210: aconst_null
    //   211: astore_3
    //   212: aload 4
    //   214: astore_1
    //   215: aload_3
    //   216: astore_2
    //   217: ldc 35
    //   219: ldc 184
    //   221: aload 5
    //   223: invokestatic 43	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   226: pop
    //   227: aload 4
    //   229: ifnull +10 -> 239
    //   232: aload 4
    //   234: invokeinterface 182 1 0
    //   239: aload_3
    //   240: ifnull -35 -> 205
    //   243: aload_3
    //   244: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   247: aload 6
    //   249: areturn
    //   250: astore_3
    //   251: aconst_null
    //   252: astore_2
    //   253: aload_1
    //   254: ifnull +9 -> 263
    //   257: aload_1
    //   258: invokeinterface 182 1 0
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   271: aload_3
    //   272: athrow
    //   273: astore_3
    //   274: goto -21 -> 253
    //   277: astore 5
    //   279: goto -67 -> 212
    //
    // Exception table:
    //   from	to	target	type
    //   19	24	208	java/lang/Exception
    //   19	24	250	finally
    //   32	41	273	finally
    //   50	60	273	finally
    //   69	79	273	finally
    //   88	99	273	finally
    //   108	119	273	finally
    //   128	162	273	finally
    //   171	180	273	finally
    //   217	227	273	finally
    //   32	41	277	java/lang/Exception
    //   50	60	277	java/lang/Exception
    //   69	79	277	java/lang/Exception
    //   88	99	277	java/lang/Exception
    //   108	119	277	java/lang/Exception
    //   128	162	277	java/lang/Exception
    //   171	180	277	java/lang/Exception
  }

  // ERROR //
  public List<City> a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 5
    //   11: new 140	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 141	java/util/ArrayList:<init>	()V
    //   18: astore 9
    //   20: aload_0
    //   21: invokespecial 28	ajy:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: ldc 189
    //   28: astore 6
    //   30: aload 7
    //   32: astore_2
    //   33: aload 4
    //   35: astore_3
    //   36: aload 8
    //   38: astore 5
    //   40: aload_1
    //   41: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +138 -> 182
    //   47: aload 7
    //   49: astore_2
    //   50: aload 4
    //   52: astore_3
    //   53: aload 8
    //   55: astore 5
    //   57: new 64	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   64: ldc 189
    //   66: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 197
    //   71: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 199
    //   80: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 201
    //   89: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 6
    //   97: aload 7
    //   99: astore_2
    //   100: aload 4
    //   102: astore_3
    //   103: aload 8
    //   105: astore 5
    //   107: new 64	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   114: ldc 203
    //   116: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 205
    //   125: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore_1
    //   132: aload 7
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: aload 8
    //   140: astore 5
    //   142: new 64	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   149: aload 6
    //   151: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 207
    //   156: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 209
    //   165: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 211
    //   174: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 6
    //   182: aload 7
    //   184: astore_2
    //   185: aload 4
    //   187: astore_3
    //   188: aload 8
    //   190: astore 5
    //   192: aload 4
    //   194: aload 6
    //   196: aconst_null
    //   197: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   200: astore_1
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: astore_3
    //   206: aload_1
    //   207: astore 5
    //   209: aload_1
    //   210: invokeinterface 152 1 0
    //   215: ifle +166 -> 381
    //   218: aload_1
    //   219: astore_2
    //   220: aload 4
    //   222: astore_3
    //   223: aload_1
    //   224: astore 5
    //   226: aload_1
    //   227: invokeinterface 155 1 0
    //   232: ifeq +149 -> 381
    //   235: aload_1
    //   236: astore_2
    //   237: aload 4
    //   239: astore_3
    //   240: aload_1
    //   241: astore 5
    //   243: aload_1
    //   244: ldc 157
    //   246: invokeinterface 161 2 0
    //   251: istore 10
    //   253: aload_1
    //   254: astore_2
    //   255: aload 4
    //   257: astore_3
    //   258: aload_1
    //   259: astore 5
    //   261: aload_1
    //   262: ldc 213
    //   264: invokeinterface 161 2 0
    //   269: istore 11
    //   271: aload_1
    //   272: astore_2
    //   273: aload 4
    //   275: astore_3
    //   276: aload_1
    //   277: astore 5
    //   279: aload_1
    //   280: ldc 163
    //   282: invokeinterface 161 2 0
    //   287: istore 12
    //   289: aload_1
    //   290: astore_2
    //   291: aload 4
    //   293: astore_3
    //   294: aload_1
    //   295: astore 5
    //   297: aload_1
    //   298: iload 10
    //   300: invokeinterface 169 2 0
    //   305: astore 6
    //   307: aload_1
    //   308: astore_2
    //   309: aload 4
    //   311: astore_3
    //   312: aload_1
    //   313: astore 5
    //   315: aload_1
    //   316: iload 12
    //   318: invokeinterface 169 2 0
    //   323: astore 7
    //   325: aload_1
    //   326: astore_2
    //   327: aload 4
    //   329: astore_3
    //   330: aload_1
    //   331: astore 5
    //   333: aload 9
    //   335: new 165	com/lazyswipe/features/weather/bean/City
    //   338: dup
    //   339: aload 6
    //   341: aload_1
    //   342: iload 11
    //   344: invokeinterface 169 2 0
    //   349: aload 7
    //   351: invokespecial 172	com/lazyswipe/features/weather/bean/City:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: invokeinterface 178 2 0
    //   359: pop
    //   360: aload_1
    //   361: astore_2
    //   362: aload 4
    //   364: astore_3
    //   365: aload_1
    //   366: astore 5
    //   368: aload_1
    //   369: invokeinterface 181 1 0
    //   374: istore 13
    //   376: iload 13
    //   378: ifne -89 -> 289
    //   381: aload_1
    //   382: ifnull +9 -> 391
    //   385: aload_1
    //   386: invokeinterface 182 1 0
    //   391: aload 4
    //   393: ifnull +8 -> 401
    //   396: aload 4
    //   398: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   401: aload 9
    //   403: areturn
    //   404: astore_1
    //   405: aconst_null
    //   406: astore 4
    //   408: aload 5
    //   410: astore_2
    //   411: aload 4
    //   413: astore_3
    //   414: ldc 35
    //   416: ldc 215
    //   418: aload_1
    //   419: invokestatic 43	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   422: pop
    //   423: aload 5
    //   425: ifnull +10 -> 435
    //   428: aload 5
    //   430: invokeinterface 182 1 0
    //   435: aload 4
    //   437: ifnull -36 -> 401
    //   440: aload 4
    //   442: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   445: aload 9
    //   447: areturn
    //   448: astore_1
    //   449: aconst_null
    //   450: astore_3
    //   451: aload_2
    //   452: ifnull +9 -> 461
    //   455: aload_2
    //   456: invokeinterface 182 1 0
    //   461: aload_3
    //   462: ifnull +7 -> 469
    //   465: aload_3
    //   466: invokevirtual 33	android/database/sqlite/SQLiteDatabase:close	()V
    //   469: aload_1
    //   470: athrow
    //   471: astore_1
    //   472: goto -21 -> 451
    //   475: astore_1
    //   476: goto -68 -> 408
    //
    // Exception table:
    //   from	to	target	type
    //   20	26	404	java/lang/Exception
    //   20	26	448	finally
    //   40	47	471	finally
    //   57	97	471	finally
    //   107	132	471	finally
    //   142	182	471	finally
    //   192	201	471	finally
    //   209	218	471	finally
    //   226	235	471	finally
    //   243	253	471	finally
    //   261	271	471	finally
    //   279	289	471	finally
    //   297	307	471	finally
    //   315	325	471	finally
    //   333	360	471	finally
    //   368	376	471	finally
    //   414	423	471	finally
    //   40	47	475	java/lang/Exception
    //   57	97	475	java/lang/Exception
    //   107	132	475	java/lang/Exception
    //   142	182	475	java/lang/Exception
    //   192	201	475	java/lang/Exception
    //   209	218	475	java/lang/Exception
    //   226	235	475	java/lang/Exception
    //   243	253	475	java/lang/Exception
    //   261	271	475	java/lang/Exception
    //   279	289	475	java/lang/Exception
    //   297	307	475	java/lang/Exception
    //   315	325	475	java/lang/Exception
    //   333	360	475	java/lang/Exception
    //   368	376	475	java/lang/Exception
  }

  public void a(ajz paramajz)
  {
    this.c = paramajz;
  }

  public void a(final String paramString, final int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    String str = afm.a(this.a, paramString.toLowerCase(), 20, paramInt);
    if (this.d != null)
      this.d.cancel(true);
    this.d = new AsyncTask()
    {
      private boolean d;
      private boolean e;

      protected List<City> a(String[] paramAnonymousArrayOfString)
      {
        paramAnonymousArrayOfString = paramAnonymousArrayOfString[0];
        ArrayList localArrayList = new ArrayList();
        while (true)
        {
          int i;
          Object localObject;
          try
          {
            paramAnonymousArrayOfString = new arb(ajy.a(ajy.this)).a(paramAnonymousArrayOfString, null);
            if (TextUtils.isEmpty(paramAnonymousArrayOfString))
              return localArrayList;
            paramAnonymousArrayOfString = new JSONObject(paramAnonymousArrayOfString);
            if ((paramAnonymousArrayOfString.optInt("statusCode") != 200) || (paramAnonymousArrayOfString.opt("searchWeatherInfoList") == null))
              break label229;
            if (paramInt >= paramAnonymousArrayOfString.optInt("totalPage"))
              break label240;
            bool = true;
            this.e = bool;
            JSONArray localJSONArray = paramAnonymousArrayOfString.getJSONArray("searchWeatherInfoList");
            i = 0;
            if (i >= localJSONArray.length())
              break label229;
            localObject = localJSONArray.getJSONObject(i);
            paramAnonymousArrayOfString = ((JSONObject)localObject).optString("name");
            String str = ((JSONObject)localObject).optString("cityid");
            if ((TextUtils.isEmpty(paramAnonymousArrayOfString)) || (TextUtils.isEmpty(str)))
              break label231;
            localObject = paramAnonymousArrayOfString.trim();
            if (((String)localObject).contains(","))
            {
              paramAnonymousArrayOfString = ((String)localObject).substring(0, ((String)localObject).indexOf(',')).trim();
              paramAnonymousArrayOfString = new City(paramAnonymousArrayOfString, null, str);
              paramAnonymousArrayOfString.a = ((String)localObject);
              localArrayList.add(paramAnonymousArrayOfString);
            }
          }
          catch (Exception paramAnonymousArrayOfString)
          {
            Log.e("Swipe.QueryCityHandler", "update weather exception", paramAnonymousArrayOfString);
            return localArrayList;
          }
          paramAnonymousArrayOfString = (String[])localObject;
          continue;
          label229: return localArrayList;
          label231: i += 1;
          continue;
          label240: boolean bool = false;
        }
      }

      protected void a(List<City> paramAnonymousList)
      {
        if ((isCancelled()) || (ajy.b(ajy.this) == null))
          return;
        if ((paramAnonymousList == null) || (this.d))
          ajy.b(ajy.this).b();
        ajy.b(ajy.this).a(paramString, paramAnonymousList, this.e, paramInt);
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { str });
  }

  public void b()
  {
    if ((this.d != null) && (this.d.getStatus() != Status.FINISHED))
      this.d.cancel(true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajy
 * JD-Core Version:    0.6.2
 */