package cmcm.com.myapplication;

class ask
  implements Runnable
{
  private final long a;

  public ask(long paramLong)
  {
    this.a = paramLong;
  }

  protected void a()
  {
    if (!aaq.b().c());
    try
    {
      Thread.sleep(3000L);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 43	asj:c	()Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: iconst_1
    //   10: invokestatic 46	asj:a	(Z)Z
    //   13: pop
    //   14: aload_2
    //   15: monitorexit
    //   16: bipush 10
    //   18: invokestatic 52	android/os/Process:setThreadPriority	(I)V
    //   21: invokestatic 57	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 59	ask:a	()V
    //   30: aload 5
    //   32: invokevirtual 65	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   35: astore_1
    //   36: aload 5
    //   38: ldc 67
    //   40: invokevirtual 71	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast 73	android/app/ActivityManager
    //   46: astore_3
    //   47: aload_1
    //   48: iconst_0
    //   49: invokevirtual 79	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload 5
    //   58: invokestatic 82	asj:a	(Ljava/util/List;Landroid/content/Context;)[Ljava/lang/String;
    //   61: astore 4
    //   63: aload_2
    //   64: astore_1
    //   65: aload 5
    //   67: invokestatic 87	ci:a	(Landroid/content/Context;)Lci;
    //   70: astore 6
    //   72: aload_2
    //   73: astore_1
    //   74: new 89	android/content/Intent
    //   77: dup
    //   78: ldc 91
    //   80: invokespecial 94	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   83: astore 5
    //   85: aload_2
    //   86: astore_1
    //   87: aload 5
    //   89: ldc 96
    //   91: aload 4
    //   93: invokevirtual 100	android/content/Intent:putExtra	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;
    //   96: pop
    //   97: aload_2
    //   98: astore_1
    //   99: aload 5
    //   101: ldc 102
    //   103: aload_0
    //   104: getfield 15	ask:a	J
    //   107: invokevirtual 105	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   110: pop
    //   111: aload_2
    //   112: astore_1
    //   113: aload 6
    //   115: aload 5
    //   117: invokevirtual 108	ci:a	(Landroid/content/Intent;)Z
    //   120: pop
    //   121: aload_2
    //   122: astore_1
    //   123: aload 4
    //   125: arraylength
    //   126: istore 8
    //   128: iload 7
    //   130: iload 8
    //   132: if_icmpge +22 -> 154
    //   135: aload 4
    //   137: iload 7
    //   139: aaload
    //   140: astore 5
    //   142: aload_2
    //   143: astore_1
    //   144: invokestatic 111	asj:d	()Z
    //   147: istore 9
    //   149: iload 9
    //   151: ifeq +38 -> 189
    //   154: aload_0
    //   155: getfield 15	ask:a	J
    //   158: invokestatic 113	asj:b	(J)V
    //   161: aload_2
    //   162: ifnull +9 -> 171
    //   165: aload_2
    //   166: invokeinterface 118 1 0
    //   171: iconst_0
    //   172: ifeq +11 -> 183
    //   175: new 120	java/lang/NullPointerException
    //   178: dup
    //   179: invokespecial 121	java/lang/NullPointerException:<init>	()V
    //   182: athrow
    //   183: return
    //   184: astore_1
    //   185: aload_2
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    //   189: aload_2
    //   190: astore_1
    //   191: aload_3
    //   192: aload 5
    //   194: invokevirtual 124	android/app/ActivityManager:killBackgroundProcesses	(Ljava/lang/String;)V
    //   197: iload 7
    //   199: iconst_1
    //   200: iadd
    //   201: istore 7
    //   203: goto -75 -> 128
    //   206: astore 5
    //   208: aload_2
    //   209: astore_1
    //   210: aload 5
    //   212: invokestatic 129	asq:a	(Ljava/lang/Throwable;)V
    //   215: goto -18 -> 197
    //   218: astore_3
    //   219: aload_2
    //   220: astore_1
    //   221: aload_3
    //   222: invokestatic 129	asq:a	(Ljava/lang/Throwable;)V
    //   225: aload_0
    //   226: getfield 15	ask:a	J
    //   229: invokestatic 113	asj:b	(J)V
    //   232: aload_2
    //   233: ifnull +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 118 1 0
    //   242: iconst_0
    //   243: ifeq -60 -> 183
    //   246: new 120	java/lang/NullPointerException
    //   249: dup
    //   250: invokespecial 121	java/lang/NullPointerException:<init>	()V
    //   253: athrow
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_0
    //   258: getfield 15	ask:a	J
    //   261: invokestatic 113	asj:b	(J)V
    //   264: aload_1
    //   265: ifnull +9 -> 274
    //   268: aload_1
    //   269: invokeinterface 118 1 0
    //   274: iconst_0
    //   275: ifeq +11 -> 286
    //   278: new 120	java/lang/NullPointerException
    //   281: dup
    //   282: invokespecial 121	java/lang/NullPointerException:<init>	()V
    //   285: athrow
    //   286: aload_2
    //   287: athrow
    //   288: astore_2
    //   289: goto -32 -> 257
    //   292: astore_3
    //   293: aconst_null
    //   294: astore_2
    //   295: goto -76 -> 219
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	184	finally
    //   185	187	184	finally
    //   191	197	206	java/lang/Exception
    //   55	63	218	java/lang/Throwable
    //   65	72	218	java/lang/Throwable
    //   74	85	218	java/lang/Throwable
    //   87	97	218	java/lang/Throwable
    //   99	111	218	java/lang/Throwable
    //   113	121	218	java/lang/Throwable
    //   123	128	218	java/lang/Throwable
    //   144	149	218	java/lang/Throwable
    //   191	197	218	java/lang/Throwable
    //   210	215	218	java/lang/Throwable
    //   26	53	254	finally
    //   55	63	288	finally
    //   65	72	288	finally
    //   74	85	288	finally
    //   87	97	288	finally
    //   99	111	288	finally
    //   113	121	288	finally
    //   123	128	288	finally
    //   144	149	288	finally
    //   191	197	288	finally
    //   210	215	288	finally
    //   221	225	288	finally
    //   26	53	292	java/lang/Throwable
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ask
 * JD-Core Version:    0.6.2
 */