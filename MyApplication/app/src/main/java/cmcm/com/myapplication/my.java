package cmcm.com.myapplication;

import com.duapps.ad.a.a;

final class my
  implements Comparable, Runnable
{
  private a a;
  private long b;

  public my(mw parammw, a parama)
  {
    this.a = parama;
  }

  private void a(a parama, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    this.c.a(parama, paramInt1, paramInt2, paramLong);
    mz localmz = new mz();
    localmz.a = parama.f;
    localmz.d = paramString;
    localmz.b = parama.c;
    localmz.c = paramInt1;
    localmz.e = System.currentTimeMillis();
    oe.a(mw.b(this.c)).a(localmz);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (paramObject == null);
      bool1 = bool2;
    }
    while (getClass() != paramObject.getClass());
    return this.a.equals(((my)paramObject).a);
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: bipush 10
    //   8: invokestatic 93	android/os/Process:setThreadPriority	(I)V
    //   11: aload_0
    //   12: getfield 23	my:a	Lcom/duapps/ad/a/a;
    //   15: getfield 39	com/duapps/ad/a/a:f	Ljava/lang/String;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 18	my:c	Lmw;
    //   23: invokestatic 96	mw:a	(Lmw;)Ljava/util/HashSet;
    //   26: aload_3
    //   27: invokevirtual 101	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 18	my:c	Lmw;
    //   35: invokestatic 63	mw:b	(Lmw;)Landroid/content/Context;
    //   38: invokestatic 68	oe:a	(Landroid/content/Context;)Loe;
    //   41: aload_3
    //   42: invokevirtual 104	oe:a	(Ljava/lang/String;)Lmz;
    //   45: astore_1
    //   46: aload_1
    //   47: getfield 51	mz:c	I
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: getfield 51	mz:c	I
    //   57: iconst_3
    //   58: if_icmpne +382 -> 440
    //   61: aload_0
    //   62: getfield 23	my:a	Lcom/duapps/ad/a/a;
    //   65: astore 4
    //   67: iload 7
    //   69: istore 5
    //   71: aload 4
    //   73: getfield 39	com/duapps/ad/a/a:f	Ljava/lang/String;
    //   76: astore_2
    //   77: iload 7
    //   79: istore 5
    //   81: aload_0
    //   82: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   85: putfield 111	my:b	J
    //   88: aload_2
    //   89: ifnull +174 -> 263
    //   92: iload 6
    //   94: bipush 10
    //   96: if_icmpge +167 -> 263
    //   99: iload 6
    //   101: iconst_1
    //   102: iadd
    //   103: istore 6
    //   105: iload 6
    //   107: istore 5
    //   109: new 113	java/net/URL
    //   112: dup
    //   113: aload_2
    //   114: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   120: checkcast 122	java/net/HttpURLConnection
    //   123: astore_1
    //   124: aload_1
    //   125: iconst_0
    //   126: invokevirtual 126	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   129: aload_1
    //   130: ldc 128
    //   132: getstatic 129	mw:b	Ljava/lang/String;
    //   135: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_1
    //   139: ldc 135
    //   141: ldc 137
    //   143: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: ldc 139
    //   149: ldc 141
    //   151: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_1
    //   155: sipush 30000
    //   158: invokevirtual 144	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   161: aload_1
    //   162: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   165: istore 5
    //   167: iload 5
    //   169: sipush 302
    //   172: if_icmpeq +27 -> 199
    //   175: iload 5
    //   177: sipush 301
    //   180: if_icmpeq +19 -> 199
    //   183: iload 5
    //   185: sipush 307
    //   188: if_icmpeq +11 -> 199
    //   191: iload 5
    //   193: sipush 303
    //   196: if_icmpne +180 -> 376
    //   199: aload_1
    //   200: ldc 150
    //   202: invokevirtual 154	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore_2
    //   206: aload_2
    //   207: invokestatic 159	nz:a	(Ljava/lang/String;)Z
    //   210: ifeq +66 -> 276
    //   213: invokestatic 164	mv:a	()Z
    //   216: ifeq +25 -> 241
    //   219: getstatic 165	mw:a	Ljava/lang/String;
    //   222: new 167	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 169
    //   228: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload_2
    //   232: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 180	mv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: aload 4
    //   244: iconst_1
    //   245: aload_2
    //   246: iload 6
    //   248: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   251: aload_0
    //   252: getfield 111	my:b	J
    //   255: lsub
    //   256: invokespecial 182	my:a	(Lcom/duapps/ad/a/a;ILjava/lang/String;IJ)V
    //   259: aload_1
    //   260: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   263: aload_0
    //   264: getfield 18	my:c	Lmw;
    //   267: invokestatic 96	mw:a	(Lmw;)Ljava/util/HashSet;
    //   270: aload_3
    //   271: invokevirtual 188	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: return
    //   276: invokestatic 164	mv:a	()Z
    //   279: ifeq +25 -> 304
    //   282: getstatic 165	mw:a	Ljava/lang/String;
    //   285: new 167	java/lang/StringBuilder
    //   288: dup
    //   289: ldc 190
    //   291: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload_2
    //   295: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 180	mv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_1
    //   305: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   308: goto -220 -> 88
    //   311: astore_2
    //   312: iload 6
    //   314: istore 5
    //   316: invokestatic 164	mv:a	()Z
    //   319: ifeq +28 -> 347
    //   322: getstatic 165	mw:a	Ljava/lang/String;
    //   325: new 167	java/lang/StringBuilder
    //   328: dup
    //   329: ldc 192
    //   331: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_2
    //   335: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 180	mv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: aload 4
    //   350: iconst_3
    //   351: aconst_null
    //   352: iload 5
    //   354: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   357: aload_0
    //   358: getfield 111	my:b	J
    //   361: lsub
    //   362: invokespecial 182	my:a	(Lcom/duapps/ad/a/a;ILjava/lang/String;IJ)V
    //   365: aload_1
    //   366: ifnull -103 -> 263
    //   369: aload_1
    //   370: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   373: goto -110 -> 263
    //   376: invokestatic 164	mv:a	()Z
    //   379: ifeq +25 -> 404
    //   382: getstatic 165	mw:a	Ljava/lang/String;
    //   385: new 167	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 197
    //   391: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_2
    //   395: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 180	mv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_0
    //   405: aload 4
    //   407: iconst_2
    //   408: aload_2
    //   409: iload 6
    //   411: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   414: aload_0
    //   415: getfield 111	my:b	J
    //   418: lsub
    //   419: invokespecial 182	my:a	(Lcom/duapps/ad/a/a;ILjava/lang/String;IJ)V
    //   422: aload_1
    //   423: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   426: goto -163 -> 263
    //   429: astore_2
    //   430: aload_1
    //   431: ifnull +7 -> 438
    //   434: aload_1
    //   435: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   438: aload_2
    //   439: athrow
    //   440: invokestatic 164	mv:a	()Z
    //   443: ifeq -180 -> 263
    //   446: getstatic 165	mw:a	Ljava/lang/String;
    //   449: new 167	java/lang/StringBuilder
    //   452: dup
    //   453: ldc 199
    //   455: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: getfield 51	mz:c	I
    //   462: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 180	mv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -208 -> 263
    //   474: astore_2
    //   475: aconst_null
    //   476: astore_1
    //   477: goto -47 -> 430
    //   480: astore_2
    //   481: goto -51 -> 430
    //   484: astore_2
    //   485: aconst_null
    //   486: astore_1
    //   487: goto -171 -> 316
    //
    // Exception table:
    //   from	to	target	type
    //   124	167	311	java/lang/Exception
    //   199	241	311	java/lang/Exception
    //   241	263	311	java/lang/Exception
    //   276	304	311	java/lang/Exception
    //   304	308	311	java/lang/Exception
    //   376	404	311	java/lang/Exception
    //   404	426	311	java/lang/Exception
    //   124	167	429	finally
    //   199	241	429	finally
    //   241	263	429	finally
    //   276	304	429	finally
    //   304	308	429	finally
    //   376	404	429	finally
    //   404	426	429	finally
    //   71	77	474	finally
    //   81	88	474	finally
    //   109	124	474	finally
    //   316	347	480	finally
    //   347	365	480	finally
    //   71	77	484	java/lang/Exception
    //   81	88	484	java/lang/Exception
    //   109	124	484	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     my
 * JD-Core Version:    0.6.2
 */