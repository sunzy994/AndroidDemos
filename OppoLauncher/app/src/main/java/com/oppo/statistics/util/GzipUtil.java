package com.oppo.statistics.util;

public class GzipUtil
{
  private static final int IO_BUF_SIZE = 1024;

  // ERROR //
  public static byte[] compress(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 22	java/lang/String:length	()I
    //   8: ifne +9 -> 17
    //   11: ldc 24
    //   13: invokevirtual 28	java/lang/String:getBytes	()[B
    //   16: areturn
    //   17: new 30	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 4
    //   26: new 33	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokevirtual 28	java/lang/String:getBytes	()[B
    //   34: invokespecial 36	java/io/ByteArrayInputStream:<init>	([B)V
    //   37: astore 5
    //   39: aconst_null
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_3
    //   43: new 38	java/util/zip/GZIPOutputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 41	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_1
    //   53: sipush 1024
    //   56: newarray byte
    //   58: astore_0
    //   59: aload 5
    //   61: aload_0
    //   62: invokevirtual 45	java/io/ByteArrayInputStream:read	([B)I
    //   65: istore 6
    //   67: iload 6
    //   69: ifle +45 -> 114
    //   72: aload_1
    //   73: aload_0
    //   74: iconst_0
    //   75: iload 6
    //   77: invokevirtual 49	java/util/zip/GZIPOutputStream:write	([BII)V
    //   80: aload_1
    //   81: invokevirtual 52	java/util/zip/GZIPOutputStream:flush	()V
    //   84: goto -25 -> 59
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: invokestatic 58	com/oppo/statistics/util/LogUtil:e	(Ljava/lang/Exception;)V
    //   94: aload 5
    //   96: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 62	java/util/zip/GZIPOutputStream:close	()V
    //   103: aload 4
    //   105: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 66	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: areturn
    //   114: aload 5
    //   116: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   119: aload_1
    //   120: invokevirtual 62	java/util/zip/GZIPOutputStream:close	()V
    //   123: aload 4
    //   125: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   128: goto -20 -> 108
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   136: goto -28 -> 108
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   144: goto -36 -> 108
    //   147: astore_1
    //   148: aload 5
    //   150: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   153: aload_0
    //   154: invokevirtual 62	java/util/zip/GZIPOutputStream:close	()V
    //   157: aload 4
    //   159: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   169: goto -7 -> 162
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_2
    //   176: astore_1
    //   177: goto -29 -> 148
    //   180: astore_2
    //   181: aload_3
    //   182: astore_1
    //   183: goto -95 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   53	59	87	java/io/IOException
    //   59	67	87	java/io/IOException
    //   72	84	87	java/io/IOException
    //   114	128	131	java/io/IOException
    //   94	108	139	java/io/IOException
    //   43	53	147	finally
    //   90	94	147	finally
    //   148	162	164	java/io/IOException
    //   53	59	172	finally
    //   59	67	172	finally
    //   72	84	172	finally
    //   43	53	180	java/io/IOException
  }

  // ERROR //
  public static String uncompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +6 -> 12
    //   9: ldc 24
    //   11: areturn
    //   12: new 30	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore 4
    //   21: new 33	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 36	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_0
    //   33: aconst_null
    //   34: astore_3
    //   35: new 73	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 5
    //   41: invokespecial 76	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_1
    //   45: sipush 1024
    //   48: newarray byte
    //   50: astore_0
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 77	java/util/zip/GZIPInputStream:read	([B)I
    //   56: istore 6
    //   58: iload 6
    //   60: ifle +47 -> 107
    //   63: aload 4
    //   65: aload_0
    //   66: iconst_0
    //   67: iload 6
    //   69: invokevirtual 78	java/io/ByteArrayOutputStream:write	([BII)V
    //   72: aload 4
    //   74: invokevirtual 79	java/io/ByteArrayOutputStream:flush	()V
    //   77: goto -26 -> 51
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: invokestatic 58	com/oppo/statistics/util/LogUtil:e	(Ljava/lang/Exception;)V
    //   87: aload 5
    //   89: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   92: aload_1
    //   93: invokevirtual 80	java/util/zip/GZIPInputStream:close	()V
    //   96: aload 4
    //   98: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   101: aload 4
    //   103: invokevirtual 84	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   106: areturn
    //   107: aload 5
    //   109: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   112: aload_1
    //   113: invokevirtual 80	java/util/zip/GZIPInputStream:close	()V
    //   116: aload 4
    //   118: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   121: goto -20 -> 101
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   129: goto -28 -> 101
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   137: goto -36 -> 101
    //   140: astore_1
    //   141: aload 5
    //   143: invokevirtual 61	java/io/ByteArrayInputStream:close	()V
    //   146: aload_0
    //   147: invokevirtual 80	java/util/zip/GZIPInputStream:close	()V
    //   150: aload 4
    //   152: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 69	java/io/IOException:printStackTrace	()V
    //   162: goto -7 -> 155
    //   165: astore_2
    //   166: aload_1
    //   167: astore_0
    //   168: aload_2
    //   169: astore_1
    //   170: goto -29 -> 141
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: goto -95 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   45	51	80	java/io/IOException
    //   51	58	80	java/io/IOException
    //   63	77	80	java/io/IOException
    //   107	121	124	java/io/IOException
    //   87	101	132	java/io/IOException
    //   35	45	140	finally
    //   83	87	140	finally
    //   141	155	157	java/io/IOException
    //   45	51	165	finally
    //   51	58	165	finally
    //   63	77	165	finally
    //   35	45	173	java/io/IOException
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.GzipUtil
 * JD-Core Version:    0.6.2
 */