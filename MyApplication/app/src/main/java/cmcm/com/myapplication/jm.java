package cmcm.com.myapplication;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

class jm
  implements Runnable
{
  private static AtomicInteger d = new AtomicInteger(0);
  private WeakReference<Context> a = null;
  private String b;
  private ScheduledExecutorService c;

  public jm(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramString;
    this.c = paramScheduledExecutorService;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 38	jm:b	Ljava/lang/String;
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: getfield 38	jm:b	Ljava/lang/String;
    //   14: invokevirtual 51	java/lang/String:length	()I
    //   17: ifne +4 -> 21
    //   20: return
    //   21: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   24: invokevirtual 54	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   27: pop
    //   28: aload_0
    //   29: getfield 31	jm:a	Ljava/lang/ref/WeakReference;
    //   32: invokevirtual 58	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   35: checkcast 60	android/content/Context
    //   38: astore 6
    //   40: aload 6
    //   42: ifnonnull +22 -> 64
    //   45: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   48: invokevirtual 63	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   51: pop
    //   52: iconst_0
    //   53: ifeq -33 -> 20
    //   56: new 65	java/lang/NullPointerException
    //   59: dup
    //   60: invokespecial 66	java/lang/NullPointerException:<init>	()V
    //   63: athrow
    //   64: aload 6
    //   66: aload 6
    //   68: invokestatic 72	jl:e	(Landroid/content/Context;)Ljava/lang/String;
    //   71: invokestatic 75	jl:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_2
    //   75: ldc 77
    //   77: astore_1
    //   78: aload_2
    //   79: ifnull +23 -> 102
    //   82: new 79	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   89: ldc 82
    //   91: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_1
    //   102: new 79	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   109: ldc 92
    //   111: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 6
    //   116: invokevirtual 95	android/content/Context:getPackageName	()Ljava/lang/String;
    //   119: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 97
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 38	jm:b	Ljava/lang/String;
    //   135: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 99
    //   140: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 6
    //   145: invokestatic 101	jl:d	(Landroid/content/Context;)Ljava/lang/String;
    //   148: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: astore_2
    //   152: aload 6
    //   154: invokestatic 105	jl:f	(Landroid/content/Context;)Z
    //   157: ifeq +31 -> 188
    //   160: ldc 107
    //   162: new 79	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   169: ldc 109
    //   171: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_2
    //   175: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 115	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: new 117	java/net/URL
    //   191: dup
    //   192: aload_2
    //   193: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 120	java/net/URL:<init>	(Ljava/lang/String;)V
    //   199: invokevirtual 124	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   202: checkcast 126	java/net/HttpURLConnection
    //   205: astore_3
    //   206: aload_3
    //   207: astore_1
    //   208: aload_3
    //   209: ldc 128
    //   211: invokevirtual 131	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   214: aload_3
    //   215: astore_1
    //   216: aload_3
    //   217: sipush 10000
    //   220: invokevirtual 134	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   223: aload_3
    //   224: astore_1
    //   225: aload_3
    //   226: ldc 136
    //   228: ldc 138
    //   230: invokevirtual 142	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_3
    //   234: astore_1
    //   235: aload_3
    //   236: invokevirtual 145	java/net/HttpURLConnection:connect	()V
    //   239: aload_3
    //   240: astore_1
    //   241: aload_3
    //   242: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   245: sipush 200
    //   248: if_icmpne +437 -> 685
    //   251: aload_3
    //   252: astore_1
    //   253: new 79	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   260: astore 7
    //   262: new 150	java/io/InputStreamReader
    //   265: dup
    //   266: aload_3
    //   267: invokevirtual 154	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   270: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   273: astore 5
    //   275: new 159	java/io/BufferedReader
    //   278: dup
    //   279: aload 5
    //   281: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   284: astore_2
    //   285: aload_2
    //   286: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   289: astore_1
    //   290: aload_1
    //   291: ifnull +117 -> 408
    //   294: aload 7
    //   296: aload_1
    //   297: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: bipush 10
    //   302: invokevirtual 168	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: goto -21 -> 285
    //   309: astore_1
    //   310: aload_2
    //   311: astore 4
    //   313: aload_1
    //   314: astore_2
    //   315: aload 4
    //   317: ifnull +10 -> 327
    //   320: aload_3
    //   321: astore_1
    //   322: aload 4
    //   324: invokevirtual 170	java/io/BufferedReader:close	()V
    //   327: aload 5
    //   329: ifnull +10 -> 339
    //   332: aload_3
    //   333: astore_1
    //   334: aload 5
    //   336: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   339: aload_3
    //   340: astore_1
    //   341: aload_2
    //   342: athrow
    //   343: astore_1
    //   344: aload_3
    //   345: astore_2
    //   346: aload_1
    //   347: astore_3
    //   348: aload_2
    //   349: astore_1
    //   350: invokestatic 174	jl:b	()Ljk;
    //   353: ifnull +17 -> 370
    //   356: aload_2
    //   357: astore_1
    //   358: invokestatic 174	jl:b	()Ljk;
    //   361: aload_3
    //   362: invokevirtual 177	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   365: invokeinterface 181 2 0
    //   370: aload_2
    //   371: astore_1
    //   372: ldc 107
    //   374: aload_3
    //   375: invokevirtual 177	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   378: aload_3
    //   379: invokestatic 184	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   382: pop
    //   383: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   386: invokevirtual 63	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   389: pop
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   398: aload_0
    //   399: getfield 40	jm:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   402: invokeinterface 192 1 0
    //   407: return
    //   408: aload_2
    //   409: ifnull +9 -> 418
    //   412: aload_3
    //   413: astore_1
    //   414: aload_2
    //   415: invokevirtual 170	java/io/BufferedReader:close	()V
    //   418: aload 5
    //   420: ifnull +10 -> 430
    //   423: aload_3
    //   424: astore_1
    //   425: aload 5
    //   427: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   430: aload_3
    //   431: astore_1
    //   432: aload 6
    //   434: invokestatic 105	jl:f	(Landroid/content/Context;)Z
    //   437: ifeq +34 -> 471
    //   440: aload_3
    //   441: astore_1
    //   442: ldc 107
    //   444: new 79	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   451: ldc 194
    //   453: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 7
    //   458: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 115	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   470: pop
    //   471: aload_3
    //   472: astore_1
    //   473: aload 7
    //   475: invokevirtual 195	java/lang/StringBuilder:length	()I
    //   478: ifle +185 -> 663
    //   481: aload 6
    //   483: ifnull +180 -> 663
    //   486: aload_3
    //   487: astore_1
    //   488: aload 7
    //   490: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 198	jl:d	(Ljava/lang/String;)Ljava/util/Map;
    //   496: astore_2
    //   497: aload_3
    //   498: astore_1
    //   499: aload_2
    //   500: ldc 200
    //   502: invokeinterface 205 2 0
    //   507: checkcast 47	java/lang/String
    //   510: astore 5
    //   512: aload 5
    //   514: ifnull +15 -> 529
    //   517: aload_3
    //   518: astore_1
    //   519: ldc 207
    //   521: aload 5
    //   523: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +90 -> 616
    //   529: aload_3
    //   530: astore_1
    //   531: aload 6
    //   533: ldc 213
    //   535: iconst_0
    //   536: invokevirtual 217	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   539: invokeinterface 223 1 0
    //   544: astore 4
    //   546: aload_3
    //   547: astore_1
    //   548: aload 4
    //   550: ldc 225
    //   552: aload 7
    //   554: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokeinterface 231 3 0
    //   562: pop
    //   563: aload_3
    //   564: astore_1
    //   565: aload 4
    //   567: invokeinterface 235 1 0
    //   572: pop
    //   573: aload_3
    //   574: astore_1
    //   575: aload 6
    //   577: invokestatic 105	jl:f	(Landroid/content/Context;)Z
    //   580: ifeq +36 -> 616
    //   583: aload_3
    //   584: astore_1
    //   585: ldc 107
    //   587: new 79	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   594: ldc 237
    //   596: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 5
    //   601: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc 239
    //   606: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 241	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   615: pop
    //   616: aload_3
    //   617: astore_1
    //   618: invokestatic 174	jl:b	()Ljk;
    //   621: ifnull +42 -> 663
    //   624: aload_3
    //   625: astore_1
    //   626: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   629: invokevirtual 244	java/util/concurrent/atomic/AtomicInteger:intValue	()I
    //   632: istore 8
    //   634: iload 8
    //   636: iconst_1
    //   637: if_icmpgt +26 -> 663
    //   640: aload_3
    //   641: astore_1
    //   642: aload 6
    //   644: invokestatic 247	jl:b	(Landroid/content/Context;)Ljava/util/Map;
    //   647: astore 4
    //   649: aload 4
    //   651: astore_2
    //   652: aload_3
    //   653: astore_1
    //   654: invokestatic 174	jl:b	()Ljk;
    //   657: aload_2
    //   658: invokeinterface 250 2 0
    //   663: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   666: invokevirtual 63	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   669: pop
    //   670: aload_3
    //   671: ifnull -273 -> 398
    //   674: aload_3
    //   675: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   678: goto -280 -> 398
    //   681: astore_1
    //   682: goto -30 -> 652
    //   685: aload_3
    //   686: astore_1
    //   687: invokestatic 174	jl:b	()Ljk;
    //   690: ifnull +35 -> 725
    //   693: aload_3
    //   694: astore_1
    //   695: invokestatic 174	jl:b	()Ljk;
    //   698: new 79	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   705: ldc 252
    //   707: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload_3
    //   711: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   714: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokeinterface 181 2 0
    //   725: aload_3
    //   726: astore_1
    //   727: aload 6
    //   729: invokestatic 105	jl:f	(Landroid/content/Context;)Z
    //   732: ifeq -69 -> 663
    //   735: aload_3
    //   736: astore_1
    //   737: ldc 107
    //   739: new 79	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 257
    //   749: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_3
    //   753: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   756: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 259
    //   762: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload_2
    //   766: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 115	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   775: pop
    //   776: goto -113 -> 663
    //   779: astore_3
    //   780: aload_1
    //   781: astore_2
    //   782: aload_3
    //   783: astore_1
    //   784: getstatic 25	jm:d	Ljava/util/concurrent/atomic/AtomicInteger;
    //   787: invokevirtual 63	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   790: pop
    //   791: aload_2
    //   792: ifnull +7 -> 799
    //   795: aload_2
    //   796: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   799: aload_1
    //   800: athrow
    //   801: astore_1
    //   802: aconst_null
    //   803: astore_2
    //   804: goto -20 -> 784
    //   807: astore_3
    //   808: aconst_null
    //   809: astore_2
    //   810: goto -462 -> 348
    //   813: astore_2
    //   814: aconst_null
    //   815: astore 5
    //   817: goto -502 -> 315
    //   820: astore_2
    //   821: goto -506 -> 315
    //
    // Exception table:
    //   from	to	target	type
    //   285	290	309	finally
    //   294	306	309	finally
    //   208	214	343	java/lang/Throwable
    //   216	223	343	java/lang/Throwable
    //   225	233	343	java/lang/Throwable
    //   235	239	343	java/lang/Throwable
    //   241	251	343	java/lang/Throwable
    //   253	262	343	java/lang/Throwable
    //   322	327	343	java/lang/Throwable
    //   334	339	343	java/lang/Throwable
    //   341	343	343	java/lang/Throwable
    //   414	418	343	java/lang/Throwable
    //   425	430	343	java/lang/Throwable
    //   432	440	343	java/lang/Throwable
    //   442	471	343	java/lang/Throwable
    //   473	481	343	java/lang/Throwable
    //   488	497	343	java/lang/Throwable
    //   499	512	343	java/lang/Throwable
    //   519	529	343	java/lang/Throwable
    //   531	546	343	java/lang/Throwable
    //   548	563	343	java/lang/Throwable
    //   565	573	343	java/lang/Throwable
    //   575	583	343	java/lang/Throwable
    //   585	616	343	java/lang/Throwable
    //   618	624	343	java/lang/Throwable
    //   626	634	343	java/lang/Throwable
    //   642	649	343	java/lang/Throwable
    //   654	663	343	java/lang/Throwable
    //   687	693	343	java/lang/Throwable
    //   695	725	343	java/lang/Throwable
    //   727	735	343	java/lang/Throwable
    //   737	776	343	java/lang/Throwable
    //   642	649	681	jr
    //   208	214	779	finally
    //   216	223	779	finally
    //   225	233	779	finally
    //   235	239	779	finally
    //   241	251	779	finally
    //   253	262	779	finally
    //   322	327	779	finally
    //   334	339	779	finally
    //   341	343	779	finally
    //   350	356	779	finally
    //   358	370	779	finally
    //   372	383	779	finally
    //   414	418	779	finally
    //   425	430	779	finally
    //   432	440	779	finally
    //   442	471	779	finally
    //   473	481	779	finally
    //   488	497	779	finally
    //   499	512	779	finally
    //   519	529	779	finally
    //   531	546	779	finally
    //   548	563	779	finally
    //   565	573	779	finally
    //   575	583	779	finally
    //   585	616	779	finally
    //   618	624	779	finally
    //   626	634	779	finally
    //   642	649	779	finally
    //   654	663	779	finally
    //   687	693	779	finally
    //   695	725	779	finally
    //   727	735	779	finally
    //   737	776	779	finally
    //   28	40	801	finally
    //   64	75	801	finally
    //   82	102	801	finally
    //   102	188	801	finally
    //   188	206	801	finally
    //   28	40	807	java/lang/Throwable
    //   64	75	807	java/lang/Throwable
    //   82	102	807	java/lang/Throwable
    //   102	188	807	java/lang/Throwable
    //   188	206	807	java/lang/Throwable
    //   262	275	813	finally
    //   275	285	820	finally
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jm
 * JD-Core Version:    0.6.2
 */