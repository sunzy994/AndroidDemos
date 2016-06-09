package cmcm.com.myapplication.com.flurry.sdk;

public class dh
{
  private static final String b = dh.class.getSimpleName();
  byte[] a;

  // ERROR //
  public dh(di paramdi)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/lang/Object:<init>	()V
    //   4: aconst_null
    //   5: astore_3
    //   6: new 27	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 28	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 30	java/io/DataOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 33	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: iconst_3
    //   27: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 41	com/flurry/sdk/di:a	()Ljava/lang/String;
    //   35: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 48	com/flurry/sdk/di:b	()J
    //   43: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 55	com/flurry/sdk/di:c	()J
    //   51: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual 58	com/flurry/sdk/di:d	()J
    //   59: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   62: aload_1
    //   63: invokevirtual 62	com/flurry/sdk/di:e	()Ljava/util/Map;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnonnull +241 -> 309
    //   71: aload_2
    //   72: iconst_0
    //   73: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 65	com/flurry/sdk/di:f	()Ljava/lang/String;
    //   81: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: aload_1
    //   86: invokevirtual 68	com/flurry/sdk/di:g	()Ljava/lang/String;
    //   89: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   92: aload_2
    //   93: aload_1
    //   94: invokevirtual 72	com/flurry/sdk/di:h	()I
    //   97: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 78	com/flurry/sdk/di:i	()Ljava/lang/String;
    //   105: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   112: ifnonnull +304 -> 416
    //   115: aload_2
    //   116: iconst_0
    //   117: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   120: aload_2
    //   121: aload_1
    //   122: invokevirtual 89	com/flurry/sdk/di:k	()I
    //   125: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   128: aload_2
    //   129: iconst_m1
    //   130: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   133: aload_2
    //   134: iconst_m1
    //   135: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   138: aload_2
    //   139: aload_1
    //   140: invokevirtual 96	com/flurry/sdk/di:l	()B
    //   143: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   146: aload_1
    //   147: invokevirtual 100	com/flurry/sdk/di:m	()Ljava/lang/Long;
    //   150: ifnonnull +315 -> 465
    //   153: aload_2
    //   154: iconst_0
    //   155: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   158: aload_1
    //   159: invokevirtual 103	com/flurry/sdk/di:n	()Ljava/util/Map;
    //   162: astore_3
    //   163: aload_3
    //   164: ifnonnull +320 -> 484
    //   167: aload_2
    //   168: iconst_0
    //   169: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   172: aload_1
    //   173: invokevirtual 107	com/flurry/sdk/di:o	()Ljava/util/List;
    //   176: astore_3
    //   177: aload_3
    //   178: ifnonnull +382 -> 560
    //   181: aload_2
    //   182: iconst_0
    //   183: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 111	com/flurry/sdk/di:p	()Z
    //   191: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   194: aload_1
    //   195: invokevirtual 114	com/flurry/sdk/di:r	()Ljava/util/List;
    //   198: astore_3
    //   199: aload_3
    //   200: ifnull +454 -> 654
    //   203: iconst_0
    //   204: istore 7
    //   206: iconst_0
    //   207: istore 8
    //   209: iconst_0
    //   210: istore 6
    //   212: iload 7
    //   214: aload_3
    //   215: invokeinterface 119 1 0
    //   220: if_icmpge +431 -> 651
    //   223: iload 8
    //   225: aload_3
    //   226: iload 7
    //   228: invokeinterface 123 2 0
    //   233: checkcast 125	com/flurry/sdk/da
    //   236: invokevirtual 127	com/flurry/sdk/da:a	()I
    //   239: iadd
    //   240: istore 8
    //   242: iload 8
    //   244: ldc 128
    //   246: if_icmple +418 -> 664
    //   249: iconst_5
    //   250: getstatic 18	com/flurry/sdk/dh:b	Ljava/lang/String;
    //   253: ldc 130
    //   255: invokestatic 135	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   258: aload_2
    //   259: aload_1
    //   260: invokevirtual 138	com/flurry/sdk/di:q	()I
    //   263: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   266: aload_2
    //   267: iload 6
    //   269: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   272: iconst_0
    //   273: istore 7
    //   275: iload 7
    //   277: iload 6
    //   279: if_icmpge +326 -> 605
    //   282: aload_2
    //   283: aload_3
    //   284: iload 7
    //   286: invokeinterface 123 2 0
    //   291: checkcast 125	com/flurry/sdk/da
    //   294: invokevirtual 141	com/flurry/sdk/da:b	()[B
    //   297: invokevirtual 145	java/io/DataOutputStream:write	([B)V
    //   300: iload 7
    //   302: iconst_1
    //   303: iadd
    //   304: istore 7
    //   306: goto -31 -> 275
    //   309: aload_2
    //   310: aload_3
    //   311: invokeinterface 148 1 0
    //   316: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   319: aload_3
    //   320: invokeinterface 152 1 0
    //   325: invokeinterface 158 1 0
    //   330: astore_3
    //   331: aload_3
    //   332: invokeinterface 163 1 0
    //   337: ifeq -261 -> 76
    //   340: aload_3
    //   341: invokeinterface 167 1 0
    //   346: checkcast 169	java/util/Map$Entry
    //   349: astore 5
    //   351: aload_2
    //   352: aload 5
    //   354: invokeinterface 172 1 0
    //   359: checkcast 174	java/lang/String
    //   362: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   365: aload_2
    //   366: aload 5
    //   368: invokeinterface 177 1 0
    //   373: checkcast 174	java/lang/String
    //   376: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   379: aload_2
    //   380: iconst_0
    //   381: invokevirtual 75	java/io/DataOutputStream:writeByte	(I)V
    //   384: goto -53 -> 331
    //   387: astore_3
    //   388: aload_2
    //   389: astore_1
    //   390: aload_3
    //   391: astore_2
    //   392: bipush 6
    //   394: getstatic 18	com/flurry/sdk/dh:b	Ljava/lang/String;
    //   397: ldc 179
    //   399: aload_2
    //   400: invokestatic 182	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload_2
    //   404: athrow
    //   405: astore_3
    //   406: aload_1
    //   407: astore_2
    //   408: aload_3
    //   409: astore_1
    //   410: aload_2
    //   411: invokestatic 187	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   414: aload_1
    //   415: athrow
    //   416: aload_2
    //   417: iconst_1
    //   418: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   421: aload_2
    //   422: aload_0
    //   423: aload_1
    //   424: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   427: invokevirtual 193	android/location/Location:getLatitude	()D
    //   430: invokevirtual 196	com/flurry/sdk/dh:a	(D)D
    //   433: invokevirtual 200	java/io/DataOutputStream:writeDouble	(D)V
    //   436: aload_2
    //   437: aload_0
    //   438: aload_1
    //   439: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   442: invokevirtual 203	android/location/Location:getLongitude	()D
    //   445: invokevirtual 196	com/flurry/sdk/dh:a	(D)D
    //   448: invokevirtual 200	java/io/DataOutputStream:writeDouble	(D)V
    //   451: aload_2
    //   452: aload_1
    //   453: invokevirtual 82	com/flurry/sdk/di:j	()Landroid/location/Location;
    //   456: invokevirtual 207	android/location/Location:getAccuracy	()F
    //   459: invokevirtual 211	java/io/DataOutputStream:writeFloat	(F)V
    //   462: goto -342 -> 120
    //   465: aload_2
    //   466: iconst_1
    //   467: invokevirtual 86	java/io/DataOutputStream:writeBoolean	(Z)V
    //   470: aload_2
    //   471: aload_1
    //   472: invokevirtual 100	com/flurry/sdk/di:m	()Ljava/lang/Long;
    //   475: invokevirtual 216	java/lang/Long:longValue	()J
    //   478: invokevirtual 52	java/io/DataOutputStream:writeLong	(J)V
    //   481: goto -323 -> 158
    //   484: aload_2
    //   485: aload_3
    //   486: invokeinterface 148 1 0
    //   491: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   494: aload_3
    //   495: invokeinterface 152 1 0
    //   500: invokeinterface 158 1 0
    //   505: astore_3
    //   506: aload_3
    //   507: invokeinterface 163 1 0
    //   512: ifeq -340 -> 172
    //   515: aload_3
    //   516: invokeinterface 167 1 0
    //   521: checkcast 169	java/util/Map$Entry
    //   524: astore 5
    //   526: aload_2
    //   527: aload 5
    //   529: invokeinterface 172 1 0
    //   534: checkcast 174	java/lang/String
    //   537: invokevirtual 45	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   540: aload_2
    //   541: aload 5
    //   543: invokeinterface 177 1 0
    //   548: checkcast 218	com/flurry/sdk/cx$a
    //   551: getfield 221	com/flurry/sdk/cx$a:a	I
    //   554: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   557: goto -51 -> 506
    //   560: aload_2
    //   561: aload_3
    //   562: invokeinterface 119 1 0
    //   567: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   570: aload_3
    //   571: invokeinterface 222 1 0
    //   576: astore_3
    //   577: aload_3
    //   578: invokeinterface 163 1 0
    //   583: ifeq -397 -> 186
    //   586: aload_2
    //   587: aload_3
    //   588: invokeinterface 167 1 0
    //   593: checkcast 224	com/flurry/sdk/db
    //   596: invokevirtual 226	com/flurry/sdk/db:e	()[B
    //   599: invokevirtual 145	java/io/DataOutputStream:write	([B)V
    //   602: goto -25 -> 577
    //   605: aload_2
    //   606: iconst_m1
    //   607: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   610: aload_2
    //   611: iconst_0
    //   612: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   615: aload_2
    //   616: iconst_0
    //   617: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   620: aload_2
    //   621: iconst_0
    //   622: invokevirtual 37	java/io/DataOutputStream:writeShort	(I)V
    //   625: aload_0
    //   626: aload 4
    //   628: invokevirtual 229	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   631: putfield 231	com/flurry/sdk/dh:a	[B
    //   634: aload_2
    //   635: invokestatic 187	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   638: return
    //   639: astore_1
    //   640: aconst_null
    //   641: astore_2
    //   642: goto -232 -> 410
    //   645: astore_2
    //   646: aload_3
    //   647: astore_1
    //   648: goto -256 -> 392
    //   651: goto -393 -> 258
    //   654: iconst_0
    //   655: istore 6
    //   657: goto -399 -> 258
    //   660: astore_1
    //   661: goto -251 -> 410
    //   664: iload 6
    //   666: iconst_1
    //   667: iadd
    //   668: istore 6
    //   670: iload 7
    //   672: iconst_1
    //   673: iadd
    //   674: istore 7
    //   676: goto -464 -> 212
    //
    // Exception table:
    //   from	to	target	type
    //   25	67	387	java/io/IOException
    //   71	76	387	java/io/IOException
    //   76	120	387	java/io/IOException
    //   120	158	387	java/io/IOException
    //   158	163	387	java/io/IOException
    //   167	172	387	java/io/IOException
    //   172	177	387	java/io/IOException
    //   181	186	387	java/io/IOException
    //   186	199	387	java/io/IOException
    //   212	242	387	java/io/IOException
    //   249	258	387	java/io/IOException
    //   258	272	387	java/io/IOException
    //   282	300	387	java/io/IOException
    //   309	331	387	java/io/IOException
    //   331	384	387	java/io/IOException
    //   416	462	387	java/io/IOException
    //   465	481	387	java/io/IOException
    //   484	506	387	java/io/IOException
    //   506	557	387	java/io/IOException
    //   560	577	387	java/io/IOException
    //   577	602	387	java/io/IOException
    //   605	634	387	java/io/IOException
    //   392	405	405	finally
    //   6	25	639	finally
    //   6	25	645	java/io/IOException
    //   25	67	660	finally
    //   71	76	660	finally
    //   76	120	660	finally
    //   120	158	660	finally
    //   158	163	660	finally
    //   167	172	660	finally
    //   172	177	660	finally
    //   181	186	660	finally
    //   186	199	660	finally
    //   212	242	660	finally
    //   249	258	660	finally
    //   258	272	660	finally
    //   282	300	660	finally
    //   309	331	660	finally
    //   331	384	660	finally
    //   416	462	660	finally
    //   465	481	660	finally
    //   484	506	660	finally
    //   506	557	660	finally
    //   560	577	660	finally
    //   577	602	660	finally
    //   605	634	660	finally
  }

  public dh(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }

  double a(double paramDouble)
  {
    return Math.round(paramDouble * 1000.0D) / 1000.0D;
  }

  public byte[] a()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dh
 * JD-Core Version:    0.6.2
 */