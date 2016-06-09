package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.duapps.ad.stats.DuAdCacheProvider;

public final class oe
{
  private static oe b;
  private Context a;

  private oe(Context paramContext)
  {
    this.a = paramContext;
  }

  public static oe a(Context paramContext)
  {
    try
    {
      if (b == null)
        b = new oe(paramContext.getApplicationContext());
      paramContext = b;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  // ERROR //
  public final mz a(String paramString)
  {
    // Byte code:
    //   0: new 32	mz
    //   3: dup
    //   4: invokespecial 33	mz:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: putfield 36	mz:a	Ljava/lang/String;
    //   15: aload 4
    //   17: iconst_0
    //   18: putfield 40	mz:c	I
    //   21: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   24: lstore 5
    //   26: aload_0
    //   27: getfield 15	oe:a	Landroid/content/Context;
    //   30: invokevirtual 50	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   33: aload_0
    //   34: getfield 15	oe:a	Landroid/content/Context;
    //   37: iconst_1
    //   38: invokestatic 55	com/duapps/ad/stats/DuAdCacheProvider:a	(Landroid/content/Context;I)Landroid/net/Uri;
    //   41: iconst_4
    //   42: anewarray 57	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 59
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc 61
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 63
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: ldc 65
    //   64: aastore
    //   65: ldc 67
    //   67: iconst_2
    //   68: anewarray 57	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: lload 5
    //   79: ldc2_w 68
    //   82: lsub
    //   83: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   86: aastore
    //   87: ldc 75
    //   89: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +70 -> 164
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: invokeinterface 87 1 0
    //   105: ifeq +59 -> 164
    //   108: aload_2
    //   109: astore_1
    //   110: aload 4
    //   112: aload_2
    //   113: iconst_0
    //   114: invokeinterface 91 2 0
    //   119: putfield 36	mz:a	Ljava/lang/String;
    //   122: aload_2
    //   123: astore_1
    //   124: aload 4
    //   126: aload_2
    //   127: iconst_1
    //   128: invokeinterface 91 2 0
    //   133: putfield 93	mz:b	Ljava/lang/String;
    //   136: aload_2
    //   137: astore_1
    //   138: aload 4
    //   140: aload_2
    //   141: iconst_2
    //   142: invokeinterface 91 2 0
    //   147: putfield 96	mz:d	Ljava/lang/String;
    //   150: aload_2
    //   151: astore_1
    //   152: aload 4
    //   154: aload_2
    //   155: iconst_3
    //   156: invokeinterface 100 2 0
    //   161: putfield 40	mz:c	I
    //   164: aload_2
    //   165: ifnull +18 -> 183
    //   168: aload_2
    //   169: invokeinterface 103 1 0
    //   174: ifne +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 106 1 0
    //   183: aload 4
    //   185: areturn
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_2
    //   189: aload_2
    //   190: astore_1
    //   191: ldc 108
    //   193: ldc 110
    //   195: aload_3
    //   196: invokestatic 115	mv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_2
    //   200: ifnull -17 -> 183
    //   203: aload_2
    //   204: invokeinterface 103 1 0
    //   209: ifne -26 -> 183
    //   212: aload_2
    //   213: invokeinterface 106 1 0
    //   218: aload 4
    //   220: areturn
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +18 -> 243
    //   228: aload_1
    //   229: invokeinterface 103 1 0
    //   234: ifne +9 -> 243
    //   237: aload_1
    //   238: invokeinterface 106 1 0
    //   243: aload_2
    //   244: athrow
    //   245: astore_2
    //   246: goto -22 -> 224
    //   249: astore_3
    //   250: goto -61 -> 189
    //
    // Exception table:
    //   from	to	target	type
    //   26	93	186	java/lang/Exception
    //   26	93	221	finally
    //   99	108	245	finally
    //   110	122	245	finally
    //   124	136	245	finally
    //   138	150	245	finally
    //   152	164	245	finally
    //   191	199	245	finally
    //   99	108	249	java/lang/Exception
    //   110	122	249	java/lang/Exception
    //   124	136	249	java/lang/Exception
    //   138	150	249	java/lang/Exception
    //   152	164	249	java/lang/Exception
  }

  public final void a(mz parammz)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_url", parammz.a);
    localContentValues.put("pkg", parammz.b);
    localContentValues.put("p_url", parammz.d);
    localContentValues.put("type", Integer.valueOf(parammz.c));
    localContentValues.put("ts", Long.valueOf(parammz.e));
    parammz = parammz.a;
    try
    {
      if (this.a.getContentResolver().update(DuAdCacheProvider.a(this.a, 1), localContentValues, "_url = ?", new String[] { parammz }) <= 0)
        this.a.getContentResolver().insert(DuAdCacheProvider.a(this.a, 1), localContentValues);
      long l = System.currentTimeMillis();
      try
      {
        this.a.getContentResolver().delete(DuAdCacheProvider.a(this.a, 1), "ts<?", new String[] { String.valueOf(l - 86400000L) });
        return;
      }
      catch (Exception parammz)
      {
        mv.a("ToolboxCacheMgr", "dumpTimeOutDatas() exception: ", parammz);
        return;
      }
    }
    catch (Exception parammz)
    {
      mv.a("ToolboxCacheMgr", "saveParseResult() exception: ", parammz);
    }
  }

  // ERROR //
  public final int b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 15	oe:a	Landroid/content/Context;
    //   9: invokevirtual 50	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_0
    //   13: getfield 15	oe:a	Landroid/content/Context;
    //   16: iconst_1
    //   17: invokestatic 55	com/duapps/ad/stats/DuAdCacheProvider:a	(Landroid/content/Context;I)Landroid/net/Uri;
    //   20: iconst_1
    //   21: anewarray 57	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 65
    //   28: aastore
    //   29: ldc 67
    //   31: iconst_2
    //   32: anewarray 57	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: lload 5
    //   43: ldc2_w 68
    //   46: lsub
    //   47: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   50: aastore
    //   51: ldc 75
    //   53: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +115 -> 173
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: invokeinterface 87 1 0
    //   69: ifeq +104 -> 173
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: iconst_0
    //   76: invokeinterface 100 2 0
    //   81: istore 4
    //   83: aload_2
    //   84: ifnull +18 -> 102
    //   87: aload_2
    //   88: invokeinterface 103 1 0
    //   93: ifne +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 106 1 0
    //   102: iload 4
    //   104: ireturn
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: ldc 108
    //   112: ldc 168
    //   114: aload_3
    //   115: invokestatic 115	mv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_2
    //   119: ifnull +52 -> 171
    //   122: aload_2
    //   123: invokeinterface 103 1 0
    //   128: ifne +43 -> 171
    //   131: aload_2
    //   132: invokeinterface 106 1 0
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +18 -> 161
    //   146: aload_1
    //   147: invokeinterface 103 1 0
    //   152: ifne +9 -> 161
    //   155: aload_1
    //   156: invokeinterface 106 1 0
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -22 -> 142
    //   167: astore_3
    //   168: goto -60 -> 108
    //   171: iconst_0
    //   172: ireturn
    //   173: iconst_0
    //   174: istore 4
    //   176: goto -93 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   5	57	105	java/lang/Exception
    //   5	57	139	finally
    //   63	72	163	finally
    //   74	83	163	finally
    //   110	118	163	finally
    //   63	72	167	java/lang/Exception
    //   74	83	167	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     oe
 * JD-Core Version:    0.6.2
 */