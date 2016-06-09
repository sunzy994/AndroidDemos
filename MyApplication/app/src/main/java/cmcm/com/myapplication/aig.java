package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class aig
{
  private static final String a = "Swipe." + aig.class.getSimpleName();
  private static aig d;
  private Map<String, String> b;
  private final Set<String> c = new HashSet();

  private aig()
  {
    this.c.add("com.android.settings/com.android.settings.Settings$TetherSettingsActivity");
    this.c.add("com.android.deskclock/com.android.deskclock.AlarmClock");
    this.c.add("com.android.settings/com.android.settings.MiuiPasswordGuardActivity");
    this.c.add("com.android.settings/com.android.settings.VirusScanActivity");
    this.c.add("com.android.settings/com.android.settings.wifi.WifiApSettings");
    this.c.add("com.android.settings/com.android.settings.wifi.WifiApInfoService");
    this.c.add("com.android.settings/com.android.settings.TetherSettings");
    this.c.add("com.android.settings/com.android.settings.profilemode.AudioProfileSettings");
    this.c.add("com.android.settings/com.android.settings.Settings$WifiSettingsActivity");
    this.c.add("com.android.settings/com.android.settings.wifi.MobileApSettings");
    this.c.add("com.android.settings/com.android.settings.wifi.WifiSettings");
    this.c.add("com.android.settings/com.android.settings.wifi.tethersettings");
    this.c.add("com.android.settings/com.android.settings.Settings$ProfileSettingsActivity");
    this.c.add("com.android.settings/com.android.settings.wfd.WifiDisplaySettingsActivity");
    this.c.add("com.android.settings/com.android.settings.BackgroundApplicationsManager");
    this.c.add("com.android.settings/com.android.settings.permission.PermManageActivity");
    this.c.add("com.android.settings/com.miui.securitycenter.Main");
    this.c.add("com.lazyswipe/com.lazyswipe.features.ad.game.GameActivity");
  }

  public static aig a(Context paramContext)
  {
    if (d == null)
      d = new aig();
    d.b(paramContext);
    return d;
  }

  // ERROR //
  private Map<String, String> b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: getfield 98	aig:b	Ljava/util/Map;
    //   16: ifnonnull +423 -> 439
    //   19: new 100	java/util/HashMap
    //   22: dup
    //   23: invokespecial 101	java/util/HashMap:<init>	()V
    //   26: astore 10
    //   28: new 103	java/io/File
    //   31: dup
    //   32: invokestatic 108	aro:d	()Ljava/io/File;
    //   35: ldc 110
    //   37: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: astore 11
    //   45: new 103	java/io/File
    //   48: dup
    //   49: aload 11
    //   51: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 12
    //   56: aload 12
    //   58: invokevirtual 122	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 126	java/io/File:exists	()Z
    //   64: ifne +12 -> 76
    //   67: aload 12
    //   69: invokevirtual 122	java/io/File:getParentFile	()Ljava/io/File;
    //   72: invokevirtual 129	java/io/File:mkdirs	()Z
    //   75: pop
    //   76: aload 12
    //   78: invokevirtual 126	java/io/File:exists	()Z
    //   81: ifne +363 -> 444
    //   84: aload_1
    //   85: invokevirtual 135	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   88: ldc 136
    //   90: invokevirtual 142	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   93: aload 12
    //   95: invokestatic 147	aqx:b	(Ljava/io/InputStream;Ljava/io/File;)V
    //   98: aload 11
    //   100: aconst_null
    //   101: invokestatic 153	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   104: astore 4
    //   106: aload 8
    //   108: astore 7
    //   110: aload 4
    //   112: astore_3
    //   113: aload 9
    //   115: astore 5
    //   117: aload 4
    //   119: astore_2
    //   120: aload 4
    //   122: bipush 44
    //   124: invokevirtual 157	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   127: aload 8
    //   129: astore 7
    //   131: aload 4
    //   133: astore_3
    //   134: aload 9
    //   136: astore 5
    //   138: aload 4
    //   140: astore_2
    //   141: aload 4
    //   143: ldc 159
    //   145: aconst_null
    //   146: invokevirtual 163	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore_1
    //   150: aload_1
    //   151: astore 7
    //   153: aload 4
    //   155: astore_3
    //   156: aload_1
    //   157: astore 5
    //   159: aload 4
    //   161: astore_2
    //   162: aload_1
    //   163: invokeinterface 169 1 0
    //   168: ifle +256 -> 424
    //   171: aload_1
    //   172: astore 7
    //   174: aload 4
    //   176: astore_3
    //   177: aload_1
    //   178: astore 5
    //   180: aload 4
    //   182: astore_2
    //   183: aload_1
    //   184: invokeinterface 172 1 0
    //   189: ifeq +235 -> 424
    //   192: aload_1
    //   193: astore 7
    //   195: aload 4
    //   197: astore_3
    //   198: aload_1
    //   199: astore 5
    //   201: aload 4
    //   203: astore_2
    //   204: aload_1
    //   205: ldc 174
    //   207: invokeinterface 178 2 0
    //   212: istore 13
    //   214: aload_1
    //   215: astore 7
    //   217: aload 4
    //   219: astore_3
    //   220: aload_1
    //   221: astore 5
    //   223: aload 4
    //   225: astore_2
    //   226: aload_1
    //   227: ldc 180
    //   229: invokeinterface 178 2 0
    //   234: istore 14
    //   236: aload_1
    //   237: astore 7
    //   239: aload 4
    //   241: astore_3
    //   242: aload_1
    //   243: astore 5
    //   245: aload 4
    //   247: astore_2
    //   248: aload_1
    //   249: ldc 182
    //   251: invokeinterface 178 2 0
    //   256: istore 15
    //   258: aload_1
    //   259: astore 7
    //   261: aload 4
    //   263: astore_3
    //   264: aload_1
    //   265: astore 5
    //   267: aload 4
    //   269: astore_2
    //   270: aload_1
    //   271: iload 15
    //   273: invokeinterface 186 2 0
    //   278: astore 6
    //   280: aload 6
    //   282: ifnull +442 -> 724
    //   285: aload_1
    //   286: astore 7
    //   288: aload 4
    //   290: astore_3
    //   291: aload_1
    //   292: astore 5
    //   294: aload 4
    //   296: astore_2
    //   297: aload 6
    //   299: invokevirtual 191	java/lang/String:length	()I
    //   302: ifeq +422 -> 724
    //   305: aload_1
    //   306: astore 7
    //   308: aload 4
    //   310: astore_3
    //   311: aload_1
    //   312: astore 5
    //   314: aload 4
    //   316: astore_2
    //   317: aload 6
    //   319: ldc 193
    //   321: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   324: ifeq +298 -> 622
    //   327: aload_1
    //   328: astore 7
    //   330: aload 4
    //   332: astore_3
    //   333: aload_1
    //   334: astore 5
    //   336: aload 4
    //   338: astore_2
    //   339: aload 10
    //   341: new 18	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   348: aload_1
    //   349: iload 13
    //   351: invokeinterface 186 2 0
    //   356: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   359: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 202
    //   364: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 6
    //   369: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   372: iconst_1
    //   373: invokevirtual 205	java/lang/String:substring	(I)Ljava/lang/String;
    //   376: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aload_1
    //   383: iload 14
    //   385: invokeinterface 186 2 0
    //   390: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   393: invokeinterface 211 3 0
    //   398: pop
    //   399: aload_1
    //   400: astore 7
    //   402: aload 4
    //   404: astore_3
    //   405: aload_1
    //   406: astore 5
    //   408: aload 4
    //   410: astore_2
    //   411: aload_1
    //   412: invokeinterface 214 1 0
    //   417: istore 16
    //   419: iload 16
    //   421: ifne -163 -> 258
    //   424: aload_1
    //   425: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   428: aload 4
    //   430: invokestatic 222	arf:a	(Ljava/io/Closeable;)V
    //   433: aload_0
    //   434: aload 10
    //   436: putfield 98	aig:b	Ljava/util/Map;
    //   439: aload_0
    //   440: getfield 98	aig:b	Ljava/util/Map;
    //   443: areturn
    //   444: aload 11
    //   446: aconst_null
    //   447: invokestatic 153	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   450: astore 6
    //   452: aload 6
    //   454: astore 4
    //   456: aload 8
    //   458: astore 7
    //   460: aload 6
    //   462: astore_3
    //   463: aload 9
    //   465: astore 5
    //   467: aload 6
    //   469: astore_2
    //   470: aload 6
    //   472: invokevirtual 225	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   475: bipush 44
    //   477: if_icmpge -350 -> 127
    //   480: aload 8
    //   482: astore 7
    //   484: aload 6
    //   486: astore_3
    //   487: aload 9
    //   489: astore 5
    //   491: aload 6
    //   493: astore_2
    //   494: aload 6
    //   496: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   499: aload 8
    //   501: astore 7
    //   503: aload 6
    //   505: astore_3
    //   506: aload 9
    //   508: astore 5
    //   510: aload 6
    //   512: astore_2
    //   513: aload 12
    //   515: invokevirtual 231	java/io/File:delete	()Z
    //   518: pop
    //   519: aload 8
    //   521: astore 7
    //   523: aload 6
    //   525: astore_3
    //   526: aload 9
    //   528: astore 5
    //   530: aload 6
    //   532: astore_2
    //   533: aload_1
    //   534: invokevirtual 135	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   537: ldc 136
    //   539: invokevirtual 142	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   542: aload 12
    //   544: invokestatic 147	aqx:b	(Ljava/io/InputStream;Ljava/io/File;)V
    //   547: aload 8
    //   549: astore 7
    //   551: aload 6
    //   553: astore_3
    //   554: aload 9
    //   556: astore 5
    //   558: aload 6
    //   560: astore_2
    //   561: aload 11
    //   563: aconst_null
    //   564: invokestatic 153	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   567: astore 4
    //   569: aload 8
    //   571: astore 7
    //   573: aload 4
    //   575: astore_3
    //   576: aload 9
    //   578: astore 5
    //   580: aload 4
    //   582: astore_2
    //   583: aload 4
    //   585: bipush 44
    //   587: invokevirtual 157	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   590: goto -463 -> 127
    //   593: astore_1
    //   594: aload 7
    //   596: astore 5
    //   598: aload_3
    //   599: astore_2
    //   600: getstatic 38	aig:a	Ljava/lang/String;
    //   603: ldc 233
    //   605: aload_1
    //   606: invokestatic 239	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   609: pop
    //   610: aload 7
    //   612: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   615: aload_3
    //   616: invokestatic 222	arf:a	(Ljava/io/Closeable;)V
    //   619: goto -186 -> 433
    //   622: aload_1
    //   623: astore 7
    //   625: aload 4
    //   627: astore_3
    //   628: aload_1
    //   629: astore 5
    //   631: aload 4
    //   633: astore_2
    //   634: aload 10
    //   636: new 18	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   643: aload_1
    //   644: iload 13
    //   646: invokeinterface 186 2 0
    //   651: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   654: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: ldc 202
    //   659: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload_1
    //   663: iload 13
    //   665: invokeinterface 186 2 0
    //   670: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   673: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: ldc 241
    //   678: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 6
    //   683: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   686: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: aload_1
    //   693: iload 14
    //   695: invokeinterface 186 2 0
    //   700: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   703: invokeinterface 211 3 0
    //   708: pop
    //   709: goto -310 -> 399
    //   712: astore_1
    //   713: aload 5
    //   715: invokestatic 219	arf:a	(Landroid/database/Cursor;)V
    //   718: aload_2
    //   719: invokestatic 222	arf:a	(Ljava/io/Closeable;)V
    //   722: aload_1
    //   723: athrow
    //   724: aload_1
    //   725: astore 7
    //   727: aload 4
    //   729: astore_3
    //   730: aload_1
    //   731: astore 5
    //   733: aload 4
    //   735: astore_2
    //   736: aload 10
    //   738: aload_1
    //   739: iload 13
    //   741: invokeinterface 186 2 0
    //   746: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   749: aload_1
    //   750: iload 14
    //   752: invokeinterface 186 2 0
    //   757: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   760: invokeinterface 211 3 0
    //   765: pop
    //   766: goto -367 -> 399
    //   769: astore_1
    //   770: aconst_null
    //   771: astore_2
    //   772: goto -59 -> 713
    //   775: astore_1
    //   776: aconst_null
    //   777: astore_3
    //   778: goto -184 -> 594
    //
    // Exception table:
    //   from	to	target	type
    //   120	127	593	java/lang/Exception
    //   141	150	593	java/lang/Exception
    //   162	171	593	java/lang/Exception
    //   183	192	593	java/lang/Exception
    //   204	214	593	java/lang/Exception
    //   226	236	593	java/lang/Exception
    //   248	258	593	java/lang/Exception
    //   270	280	593	java/lang/Exception
    //   297	305	593	java/lang/Exception
    //   317	327	593	java/lang/Exception
    //   339	399	593	java/lang/Exception
    //   411	419	593	java/lang/Exception
    //   470	480	593	java/lang/Exception
    //   494	499	593	java/lang/Exception
    //   513	519	593	java/lang/Exception
    //   533	547	593	java/lang/Exception
    //   561	569	593	java/lang/Exception
    //   583	590	593	java/lang/Exception
    //   634	709	593	java/lang/Exception
    //   736	766	593	java/lang/Exception
    //   120	127	712	finally
    //   141	150	712	finally
    //   162	171	712	finally
    //   183	192	712	finally
    //   204	214	712	finally
    //   226	236	712	finally
    //   248	258	712	finally
    //   270	280	712	finally
    //   297	305	712	finally
    //   317	327	712	finally
    //   339	399	712	finally
    //   411	419	712	finally
    //   470	480	712	finally
    //   494	499	712	finally
    //   513	519	712	finally
    //   533	547	712	finally
    //   561	569	712	finally
    //   583	590	712	finally
    //   600	610	712	finally
    //   634	709	712	finally
    //   736	766	712	finally
    //   45	76	769	finally
    //   76	106	769	finally
    //   444	452	769	finally
    //   45	76	775	java/lang/Exception
    //   76	106	775	java/lang/Exception
    //   444	452	775	java/lang/Exception
  }

  public String a(ComponentName paramComponentName, String paramString)
  {
    return a(paramComponentName.getPackageName(), paramComponentName.getClassName(), paramString);
  }

  public String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 != null);
    paramString3 = paramString1;
    if ("com.tencent.qqlite".equals(paramString1))
      paramString3 = "com.tencent.mobileqq";
    if (this.c.contains(paramString3 + "/" + paramString2))
      return null;
    if (this.b.containsKey(paramString3 + "/" + paramString2))
      paramString1 = (String)this.b.get(paramString3 + "/" + paramString2);
    while (true)
    {
      paramString3 = paramString1;
      if ("com.google.android.apps.maps".equals(paramString1))
      {
        paramString3 = paramString1;
        if (!"com.google.android.maps.MapsActivity".equals(paramString2))
          paramString3 = null;
      }
      if (paramString3 != null)
      {
        return "app_" + paramString3.toLowerCase().replace(".", "_");
        if (this.b.containsKey(paramString3))
          paramString1 = (String)this.b.get(paramString3);
      }
      else
      {
        return null;
        paramString1 = paramString3;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aig
 * JD-Core Version:    0.6.2
 */