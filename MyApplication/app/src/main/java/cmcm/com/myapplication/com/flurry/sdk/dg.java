package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class dg
{
  static final Integer a = Integer.valueOf(50);
  private static final String d = dg.class.getSimpleName();
  String b;
  LinkedHashMap<String, List<String>> c;

  public dg(String paramString)
  {
    a(paramString);
  }

  private boolean a(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
      bool1 = bool2;
    try
    {
      if (paramFile.exists())
      {
        el.a(4, d, "Trying to delete persistence file : " + paramFile.getAbsolutePath());
        bool1 = paramFile.delete();
        if (!bool1)
          break label70;
        el.a(4, d, "Deleted persistence file");
      }
      while (true)
      {
        return bool1;
        label70: el.a(6, d, "Cannot delete persistence file");
      }
    }
    finally
    {
    }
    throw paramFile;
  }

  // ERROR //
  private boolean a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpne +13 -> 24
    //   14: bipush 6
    //   16: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   19: ldc 85
    //   21: invokestatic 64	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: invokestatic 90	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   27: invokevirtual 93	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   37: ldc 95
    //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 101	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 105	com/flurry/sdk/fa:a	(Ljava/io/File;)Z
    //   57: istore 8
    //   59: iload 8
    //   61: ifne +12 -> 73
    //   64: aconst_null
    //   65: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 7
    //   72: ireturn
    //   73: new 112	java/io/DataOutputStream
    //   76: dup
    //   77: new 114	java/io/FileOutputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 120	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore_3
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: aload_2
    //   93: invokeinterface 126 1 0
    //   98: invokevirtual 130	java/io/DataOutputStream:writeShort	(I)V
    //   101: iconst_0
    //   102: istore 5
    //   104: aload_3
    //   105: astore_1
    //   106: iload 5
    //   108: aload_2
    //   109: invokeinterface 126 1 0
    //   114: if_icmpge +92 -> 206
    //   117: aload_3
    //   118: astore_1
    //   119: aload_2
    //   120: iload 5
    //   122: invokeinterface 134 2 0
    //   127: checkcast 136	java/lang/String
    //   130: invokevirtual 140	java/lang/String:getBytes	()[B
    //   133: astore 4
    //   135: aload_3
    //   136: astore_1
    //   137: aload 4
    //   139: arraylength
    //   140: istore 6
    //   142: aload_3
    //   143: astore_1
    //   144: iconst_4
    //   145: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   148: new 46	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   155: ldc 142
    //   157: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 5
    //   162: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc 147
    //   167: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload 6
    //   172: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 64	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: astore_1
    //   183: aload_3
    //   184: iload 6
    //   186: invokevirtual 130	java/io/DataOutputStream:writeShort	(I)V
    //   189: aload_3
    //   190: astore_1
    //   191: aload_3
    //   192: aload 4
    //   194: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   197: iload 5
    //   199: iconst_1
    //   200: iadd
    //   201: istore 5
    //   203: goto -99 -> 104
    //   206: aload_3
    //   207: astore_1
    //   208: aload_3
    //   209: iconst_0
    //   210: invokevirtual 130	java/io/DataOutputStream:writeShort	(I)V
    //   213: iconst_1
    //   214: istore 7
    //   216: aload_3
    //   217: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   220: goto -152 -> 68
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_2
    //   228: astore_1
    //   229: bipush 6
    //   231: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   234: ldc 153
    //   236: aload 4
    //   238: invokestatic 156	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_2
    //   242: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   245: iconst_0
    //   246: istore 7
    //   248: goto -28 -> 220
    //   251: aload_1
    //   252: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   255: aload_2
    //   256: athrow
    //   257: astore_1
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_1
    //   261: athrow
    //   262: astore_2
    //   263: goto -12 -> 251
    //   266: astore 4
    //   268: aload_3
    //   269: astore_2
    //   270: goto -43 -> 227
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -25 -> 251
    //
    // Exception table:
    //   from	to	target	type
    //   53	59	223	java/lang/Throwable
    //   73	89	223	java/lang/Throwable
    //   5	24	257	finally
    //   24	53	257	finally
    //   64	68	257	finally
    //   216	220	257	finally
    //   241	245	257	finally
    //   251	257	257	finally
    //   91	101	262	finally
    //   106	117	262	finally
    //   119	135	262	finally
    //   137	142	262	finally
    //   144	181	262	finally
    //   183	189	262	finally
    //   191	197	262	finally
    //   208	213	262	finally
    //   229	241	262	finally
    //   91	101	266	java/lang/Throwable
    //   106	117	266	java/lang/Throwable
    //   119	135	266	java/lang/Throwable
    //   137	142	266	java/lang/Throwable
    //   144	181	266	java/lang/Throwable
    //   183	189	266	java/lang/Throwable
    //   191	197	266	java/lang/Throwable
    //   208	213	266	java/lang/Throwable
    //   53	59	273	finally
    //   73	89	273	finally
  }

  private void c()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(this.c.keySet());
      b();
      if (!localLinkedList.isEmpty())
        a(this.b, localLinkedList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  private List<String> e(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   7: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   10: if_acmpne +13 -> 23
    //   13: bipush 6
    //   15: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   18: ldc 184
    //   20: invokestatic 64	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 90	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   26: invokevirtual 93	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   29: new 46	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   36: ldc 95
    //   38: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 101	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 44	java/io/File:exists	()Z
    //   56: istore 8
    //   58: iload 8
    //   60: ifeq +228 -> 288
    //   63: new 186	java/io/DataInputStream
    //   66: dup
    //   67: new 188	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 192	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore 4
    //   80: aload 4
    //   82: astore_2
    //   83: aload 4
    //   85: invokevirtual 195	java/io/DataInputStream:readUnsignedShort	()I
    //   88: istore 6
    //   90: iload 6
    //   92: ifne +14 -> 106
    //   95: aload 4
    //   97: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   100: aload_3
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: areturn
    //   106: aload 4
    //   108: astore_2
    //   109: new 197	java/util/ArrayList
    //   112: dup
    //   113: iload 6
    //   115: invokespecial 199	java/util/ArrayList:<init>	(I)V
    //   118: astore_1
    //   119: iconst_0
    //   120: istore 5
    //   122: iload 5
    //   124: iload 6
    //   126: if_icmpge +97 -> 223
    //   129: aload 4
    //   131: astore_2
    //   132: aload 4
    //   134: invokevirtual 195	java/io/DataInputStream:readUnsignedShort	()I
    //   137: istore 7
    //   139: aload 4
    //   141: astore_2
    //   142: iconst_4
    //   143: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   146: new 46	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   153: ldc 201
    //   155: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 5
    //   160: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc 147
    //   165: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 7
    //   170: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 64	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   179: aload 4
    //   181: astore_2
    //   182: iload 7
    //   184: newarray byte
    //   186: astore_3
    //   187: aload 4
    //   189: astore_2
    //   190: aload 4
    //   192: aload_3
    //   193: invokevirtual 204	java/io/DataInputStream:readFully	([B)V
    //   196: aload 4
    //   198: astore_2
    //   199: aload_1
    //   200: new 136	java/lang/String
    //   203: dup
    //   204: aload_3
    //   205: invokespecial 206	java/lang/String:<init>	([B)V
    //   208: invokeinterface 210 2 0
    //   213: pop
    //   214: iload 5
    //   216: iconst_1
    //   217: iadd
    //   218: istore 5
    //   220: goto -98 -> 122
    //   223: aload 4
    //   225: astore_2
    //   226: aload 4
    //   228: invokevirtual 195	java/io/DataInputStream:readUnsignedShort	()I
    //   231: istore 5
    //   233: iload 5
    //   235: ifne +3 -> 238
    //   238: aload 4
    //   240: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   243: goto -141 -> 102
    //   246: astore_3
    //   247: aconst_null
    //   248: astore 4
    //   250: aconst_null
    //   251: astore_1
    //   252: aload 4
    //   254: astore_2
    //   255: bipush 6
    //   257: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   260: ldc 212
    //   262: aload_3
    //   263: invokestatic 156	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload 4
    //   268: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   271: goto -28 -> 243
    //   274: astore_1
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: aload_2
    //   283: invokestatic 110	com/flurry/sdk/fb:a	(Ljava/io/Closeable;)V
    //   286: aload_1
    //   287: athrow
    //   288: iconst_5
    //   289: getstatic 22	com/flurry/sdk/dg:d	Ljava/lang/String;
    //   292: ldc 214
    //   294: invokestatic 64	com/flurry/sdk/el:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -56 -> 243
    //   302: astore_1
    //   303: goto -21 -> 282
    //   306: astore_3
    //   307: aconst_null
    //   308: astore_1
    //   309: goto -57 -> 252
    //   312: astore_3
    //   313: goto -61 -> 252
    //
    // Exception table:
    //   from	to	target	type
    //   63	80	246	java/lang/Throwable
    //   4	23	274	finally
    //   23	58	274	finally
    //   95	100	274	finally
    //   238	243	274	finally
    //   266	271	274	finally
    //   282	288	274	finally
    //   288	297	274	finally
    //   63	80	279	finally
    //   83	90	302	finally
    //   109	119	302	finally
    //   132	139	302	finally
    //   142	179	302	finally
    //   182	187	302	finally
    //   190	196	302	finally
    //   199	214	302	finally
    //   226	233	302	finally
    //   255	266	302	finally
    //   83	90	306	java/lang/Throwable
    //   109	119	306	java/lang/Throwable
    //   132	139	312	java/lang/Throwable
    //   142	179	312	java/lang/Throwable
    //   182	187	312	java/lang/Throwable
    //   190	196	312	java/lang/Throwable
    //   199	214	312	java/lang/Throwable
    //   226	233	312	java/lang/Throwable
  }

  public List<String> a()
  {
    return new ArrayList(this.c.keySet());
  }

  public void a(df paramdf, String paramString)
  {
    int i = 0;
    while (true)
      try
      {
        el.a(4, d, "addBlockInfo");
        String str = paramdf.a();
        paramdf = (List)this.c.get(paramString);
        if (paramdf == null)
        {
          el.a(4, d, "New Data Key");
          paramdf = new LinkedList();
          i = 1;
          paramdf.add(str);
          if (paramdf.size() > a.intValue())
          {
            b((String)paramdf.get(0));
            paramdf.remove(0);
          }
          this.c.put(paramString, paramdf);
          a(paramString, paramdf);
          if (i != 0)
            c();
          return;
        }
      }
      finally
      {
      }
  }

  void a(String paramString)
  {
    this.c = new LinkedHashMap();
    this.b = (paramString + "Main");
    paramString = e(this.b);
    if (paramString == null);
    while (true)
    {
      return;
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        List localList = e(str);
        if (localList != null)
          this.c.put(str, localList);
      }
    }
  }

  public boolean a(String paramString1, String paramString2)
  {
    List localList = (List)this.c.get(paramString2);
    boolean bool = false;
    if (localList != null)
    {
      b(paramString1);
      bool = localList.remove(paramString1);
    }
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.c.put(paramString2, localList);
      a(paramString2, localList);
      return bool;
    }
    d(paramString2);
    return bool;
  }

  void b()
  {
    a(do.a().b().getFileStreamPath(".FlurrySenderIndex.info." + this.b));
  }

  boolean b(String paramString)
  {
    return new df(paramString).c();
  }

  public List<String> c(String paramString)
  {
    return (List)this.c.get(paramString);
  }

  public boolean d(String paramString)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
        el.a(6, d, "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
      File localFile = do.a().b().getFileStreamPath(".FlurrySenderIndex.info." + paramString);
      List localList = c(paramString);
      if (localList != null)
      {
        el.a(4, d, "discardOutdatedBlocksForDataKey: notSentBlocks = " + localList.size());
        int i = 0;
        while (i < localList.size())
        {
          String str = (String)localList.get(i);
          b(str);
          el.a(4, d, "discardOutdatedBlocksForDataKey: removed block = " + str);
          i += 1;
        }
      }
      this.c.remove(paramString);
      boolean bool = a(localFile);
      c();
      return bool;
    }
    finally
    {
    }
    throw paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dg
 * JD-Core Version:    0.6.2
 */