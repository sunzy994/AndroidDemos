package cmcm.com.myapplication;

import android.content.Context;

final class als
  implements Runnable
{
  private final Context a;

  als(Context paramContext)
  {
    this.a = paramContext;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	als:a	Landroid/content/Context;
    //   4: invokestatic 25	vs:z	(Landroid/content/Context;)Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 15	als:a	Landroid/content/Context;
    //   15: invokevirtual 31	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 11
    //   20: aload 11
    //   22: getstatic 36	com/lazyswipe/notification/NotificationData:a	Landroid/net/Uri;
    //   25: iconst_5
    //   26: anewarray 38	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 40
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc 42
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc 44
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: ldc 46
    //   48: aastore
    //   49: dup
    //   50: iconst_4
    //   51: ldc 48
    //   53: aastore
    //   54: ldc 50
    //   56: aconst_null
    //   57: ldc 52
    //   59: invokevirtual 58	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 6
    //   64: new 60	java/util/ArrayList
    //   67: dup
    //   68: aload 6
    //   70: invokeinterface 66 1 0
    //   75: invokespecial 69	java/util/ArrayList:<init>	(I)V
    //   78: astore 12
    //   80: aload_0
    //   81: getfield 15	als:a	Landroid/content/Context;
    //   84: invokestatic 74	alw:a	(Landroid/content/Context;)Ljava/util/List;
    //   87: astore 13
    //   89: aload_0
    //   90: getfield 15	als:a	Landroid/content/Context;
    //   93: invokestatic 78	vs:c	(Landroid/content/Context;)Ljava/util/Set;
    //   96: astore 14
    //   98: aload 6
    //   100: invokeinterface 82 1 0
    //   105: ifne +555 -> 660
    //   108: aload_0
    //   109: getfield 15	als:a	Landroid/content/Context;
    //   112: aconst_null
    //   113: invokestatic 85	vs:a	(Landroid/content/Context;Ljava/util/Set;)V
    //   116: getstatic 88	xj:a	Landroid/net/Uri;
    //   119: astore_2
    //   120: new 90	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   127: astore_3
    //   128: aload 12
    //   130: invokeinterface 96 1 0
    //   135: ifle +489 -> 624
    //   138: new 90	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   145: ldc 98
    //   147: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 104
    //   152: aload 12
    //   154: invokestatic 110	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   157: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 112
    //   162: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 114
    //   167: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore_1
    //   174: aload 11
    //   176: aload_2
    //   177: aload_3
    //   178: aload_1
    //   179: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 120
    //   184: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 122
    //   189: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_1
    //   196: anewarray 38	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: ldc 124
    //   203: aastore
    //   204: invokevirtual 128	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   207: pop
    //   208: aload 6
    //   210: ifnull -200 -> 10
    //   213: aload 6
    //   215: invokeinterface 131 1 0
    //   220: return
    //   221: aload_1
    //   222: astore 5
    //   224: aload_2
    //   225: astore 7
    //   227: aload_3
    //   228: astore_2
    //   229: aload 4
    //   231: astore_1
    //   232: aload 7
    //   234: astore_3
    //   235: aload 5
    //   237: astore 4
    //   239: aload 6
    //   241: iconst_3
    //   242: invokeinterface 135 2 0
    //   247: astore 7
    //   249: aload 12
    //   251: aload 7
    //   253: invokestatic 141	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   256: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   259: invokeinterface 149 2 0
    //   264: pop
    //   265: aload 14
    //   267: aload 7
    //   269: invokeinterface 154 2 0
    //   274: ifeq +38 -> 312
    //   277: aload 4
    //   279: astore 5
    //   281: aload_3
    //   282: astore 7
    //   284: aload_1
    //   285: astore 4
    //   287: aload_2
    //   288: astore_3
    //   289: aload 7
    //   291: astore_2
    //   292: aload 5
    //   294: astore_1
    //   295: aload 6
    //   297: invokeinterface 157 1 0
    //   302: istore 16
    //   304: iload 16
    //   306: ifne -85 -> 221
    //   309: goto -193 -> 116
    //   312: aconst_null
    //   313: astore 5
    //   315: aload 11
    //   317: getstatic 88	xj:a	Landroid/net/Uri;
    //   320: iconst_1
    //   321: anewarray 38	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: ldc 159
    //   328: aastore
    //   329: ldc 161
    //   331: iconst_2
    //   332: anewarray 38	java/lang/String
    //   335: dup
    //   336: iconst_0
    //   337: ldc 124
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload 7
    //   344: aastore
    //   345: aconst_null
    //   346: invokevirtual 58	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   349: astore 10
    //   351: aload 10
    //   353: invokeinterface 82 1 0
    //   358: istore 16
    //   360: iload 16
    //   362: ifeq +49 -> 411
    //   365: aload 4
    //   367: astore 7
    //   369: aload_3
    //   370: astore 5
    //   372: aload_2
    //   373: astore 8
    //   375: aload_1
    //   376: astore 9
    //   378: aload 10
    //   380: ifnull +292 -> 672
    //   383: aload 10
    //   385: invokeinterface 131 1 0
    //   390: aload_2
    //   391: astore 5
    //   393: aload_1
    //   394: astore 7
    //   396: aload 4
    //   398: astore_1
    //   399: aload_3
    //   400: astore_2
    //   401: aload 5
    //   403: astore_3
    //   404: aload 7
    //   406: astore 4
    //   408: goto -113 -> 295
    //   411: aload 10
    //   413: ifnull +10 -> 423
    //   416: aload 10
    //   418: invokeinterface 131 1 0
    //   423: aload 6
    //   425: iconst_0
    //   426: invokeinterface 135 2 0
    //   431: astore 7
    //   433: aload_3
    //   434: astore 5
    //   436: aload_1
    //   437: astore_3
    //   438: aload 7
    //   440: aload_1
    //   441: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   444: ifne +28 -> 472
    //   447: aconst_null
    //   448: astore 5
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 11
    //   455: aload 7
    //   457: invokestatic 169	aqn:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Lalw;
    //   460: astore_1
    //   461: aload_1
    //   462: ifnonnull +94 -> 556
    //   465: getstatic 172	alw:a	Lalw;
    //   468: astore_2
    //   469: aload 7
    //   471: astore_3
    //   472: aload 6
    //   474: aload_2
    //   475: aload 5
    //   477: aload 4
    //   479: invokestatic 175	com/lazyswipe/notification/NotificationData:a	(Landroid/database/Cursor;Lalw;Ljava/lang/String;Ljava/lang/String;)Z
    //   482: pop
    //   483: aload 4
    //   485: astore 7
    //   487: aload_2
    //   488: astore 8
    //   490: aload_3
    //   491: astore 9
    //   493: goto +179 -> 672
    //   496: aload 10
    //   498: ifnull -75 -> 423
    //   501: aload 10
    //   503: invokeinterface 131 1 0
    //   508: goto -85 -> 423
    //   511: astore_1
    //   512: aload 6
    //   514: ifnull -504 -> 10
    //   517: aload 6
    //   519: invokeinterface 131 1 0
    //   524: return
    //   525: astore_1
    //   526: aload 5
    //   528: astore_2
    //   529: aload_2
    //   530: ifnull +9 -> 539
    //   533: aload_2
    //   534: invokeinterface 131 1 0
    //   539: aload_1
    //   540: athrow
    //   541: astore_1
    //   542: aload 6
    //   544: ifnull +10 -> 554
    //   547: aload 6
    //   549: invokeinterface 131 1 0
    //   554: aload_1
    //   555: athrow
    //   556: aload 13
    //   558: aload_1
    //   559: invokeinterface 179 2 0
    //   564: istore 15
    //   566: iload 15
    //   568: iflt +31 -> 599
    //   571: aload_1
    //   572: getfield 181	alw:c	Landroid/net/Uri;
    //   575: invokevirtual 184	android/net/Uri:toString	()Ljava/lang/String;
    //   578: astore 4
    //   580: aload 13
    //   582: iload 15
    //   584: invokeinterface 188 2 0
    //   589: checkcast 71	alw
    //   592: astore_2
    //   593: aload 7
    //   595: astore_3
    //   596: goto -124 -> 472
    //   599: aload_1
    //   600: getfield 192	alw:d	Ljava/lang/String;
    //   603: astore 5
    //   605: aload_1
    //   606: getfield 181	alw:c	Landroid/net/Uri;
    //   609: invokevirtual 184	android/net/Uri:toString	()Ljava/lang/String;
    //   612: astore 4
    //   614: getstatic 172	alw:a	Lalw;
    //   617: astore_2
    //   618: aload 7
    //   620: astore_3
    //   621: goto -149 -> 472
    //   624: ldc 194
    //   626: astore_1
    //   627: goto -453 -> 174
    //   630: astore_1
    //   631: aconst_null
    //   632: astore 6
    //   634: goto -92 -> 542
    //   637: astore_1
    //   638: aconst_null
    //   639: astore 6
    //   641: goto -129 -> 512
    //   644: astore_1
    //   645: goto -437 -> 208
    //   648: astore_1
    //   649: aload 10
    //   651: astore_2
    //   652: goto -123 -> 529
    //   655: astore 5
    //   657: goto -161 -> 496
    //   660: aconst_null
    //   661: astore 4
    //   663: aconst_null
    //   664: astore_3
    //   665: aconst_null
    //   666: astore_2
    //   667: aconst_null
    //   668: astore_1
    //   669: goto -430 -> 239
    //   672: aload 7
    //   674: astore_1
    //   675: aload 5
    //   677: astore_2
    //   678: aload 8
    //   680: astore_3
    //   681: aload 9
    //   683: astore 4
    //   685: goto -390 -> 295
    //   688: astore 5
    //   690: aconst_null
    //   691: astore 10
    //   693: goto -197 -> 496
    //
    // Exception table:
    //   from	to	target	type
    //   64	116	511	java/lang/Throwable
    //   239	277	511	java/lang/Throwable
    //   295	304	511	java/lang/Throwable
    //   383	390	511	java/lang/Throwable
    //   416	423	511	java/lang/Throwable
    //   423	433	511	java/lang/Throwable
    //   438	447	511	java/lang/Throwable
    //   453	461	511	java/lang/Throwable
    //   465	469	511	java/lang/Throwable
    //   472	483	511	java/lang/Throwable
    //   501	508	511	java/lang/Throwable
    //   533	539	511	java/lang/Throwable
    //   539	541	511	java/lang/Throwable
    //   556	566	511	java/lang/Throwable
    //   571	593	511	java/lang/Throwable
    //   599	618	511	java/lang/Throwable
    //   315	351	525	finally
    //   64	116	541	finally
    //   116	174	541	finally
    //   174	208	541	finally
    //   239	277	541	finally
    //   295	304	541	finally
    //   383	390	541	finally
    //   416	423	541	finally
    //   423	433	541	finally
    //   438	447	541	finally
    //   453	461	541	finally
    //   465	469	541	finally
    //   472	483	541	finally
    //   501	508	541	finally
    //   533	539	541	finally
    //   539	541	541	finally
    //   556	566	541	finally
    //   571	593	541	finally
    //   599	618	541	finally
    //   11	64	630	finally
    //   11	64	637	java/lang/Throwable
    //   116	174	644	java/lang/Throwable
    //   174	208	644	java/lang/Throwable
    //   351	360	648	finally
    //   351	360	655	java/lang/Throwable
    //   315	351	688	java/lang/Throwable
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     als
 * JD-Core Version:    0.6.2
 */