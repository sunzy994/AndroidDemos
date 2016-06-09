package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

final class la
{
  private Context a;

  la(Context paramContext)
  {
    this.a = paramContext;
  }

  la(Context paramContext, String paramString)
  {
    this(paramContext);
    a(paramString);
  }

  private boolean b()
  {
    return this.a != null;
  }

  // ERROR //
  String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_0
    //   3: invokespecial 27	la:b	()Z
    //   6: ifeq +92 -> 98
    //   9: aload_0
    //   10: getfield 13	la:a	Landroid/content/Context;
    //   13: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: getstatic 38	ke:a	Landroid/net/Uri;
    //   19: aconst_null
    //   20: iconst_0
    //   21: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: iconst_2
    //   25: anewarray 40	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_2
    //   35: invokestatic 47	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: aastore
    //   39: aconst_null
    //   40: invokevirtual 53	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +55 -> 100
    //   48: aload_1
    //   49: astore_3
    //   50: aload_1
    //   51: invokeinterface 59 1 0
    //   56: ifle +44 -> 100
    //   59: aload_1
    //   60: astore_3
    //   61: aload_1
    //   62: invokeinterface 62 1 0
    //   67: ifeq +33 -> 100
    //   70: aload_1
    //   71: astore_3
    //   72: aload_1
    //   73: iconst_1
    //   74: invokeinterface 65 2 0
    //   79: astore 4
    //   81: aload 4
    //   83: astore_2
    //   84: aload_2
    //   85: astore_3
    //   86: aload_1
    //   87: ifnull +11 -> 98
    //   90: aload_1
    //   91: invokeinterface 68 1 0
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: areturn
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: ifnull -5 -> 98
    //   106: aload_1
    //   107: invokeinterface 68 1 0
    //   112: aload_2
    //   113: areturn
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: astore_3
    //   120: ldc 70
    //   122: new 72	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   129: ldc 75
    //   131: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 4
    //   136: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   139: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 90	kx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: astore_3
    //   150: aload 4
    //   152: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   155: aload_2
    //   156: astore_3
    //   157: aload_1
    //   158: ifnull -60 -> 98
    //   161: aload_1
    //   162: invokeinterface 68 1 0
    //   167: aload_2
    //   168: areturn
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull +9 -> 182
    //   176: aload_3
    //   177: invokeinterface 68 1 0
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: goto -13 -> 172
    //   188: astore 4
    //   190: goto -72 -> 118
    //
    // Exception table:
    //   from	to	target	type
    //   9	44	114	java/lang/Exception
    //   9	44	169	finally
    //   50	59	184	finally
    //   61	70	184	finally
    //   72	81	184	finally
    //   120	148	184	finally
    //   150	155	184	finally
    //   50	59	188	java/lang/Exception
    //   61	70	188	java/lang/Exception
    //   72	81	188	java/lang/Exception
  }

  void a()
  {
    this.a = null;
  }

  void a(int paramInt, long paramLong)
  {
    if (b())
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("prefs_type", Integer.valueOf(2));
      localContentValues.put("prefs_key", String.valueOf(paramInt));
      localContentValues.put("prefs_valuse", Long.valueOf(paramLong));
      this.a.getContentResolver().insert(ke.a, localContentValues);
    }
  }

  void a(int paramInt, String paramString)
  {
    if (b())
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("prefs_type", Integer.valueOf(0));
      localContentValues.put("prefs_key", String.valueOf(paramInt));
      localContentValues.put("prefs_valuse", paramString);
      this.a.getContentResolver().insert(ke.a, localContentValues);
    }
  }

  void a(int paramInt, boolean paramBoolean)
  {
    a(String.valueOf(paramInt), paramBoolean);
  }

  void a(String paramString)
  {
  }

  void a(String paramString, int paramInt)
  {
    if (b())
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("prefs_type", Integer.valueOf(3));
      localContentValues.put("prefs_key", paramString);
      localContentValues.put("prefs_valuse", Integer.valueOf(paramInt));
      this.a.getContentResolver().insert(ke.a, localContentValues);
    }
  }

  void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (b())
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("prefs_type", Integer.valueOf(1));
        localContentValues.put("prefs_key", paramString);
        localContentValues.put("prefs_valuse", Boolean.valueOf(paramBoolean));
        this.a.getContentResolver().insert(ke.a, localContentValues);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }

  // ERROR //
  int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 5
    //   3: aload_0
    //   4: invokespecial 27	la:b	()Z
    //   7: ifeq +94 -> 101
    //   10: aload_0
    //   11: getfield 13	la:a	Landroid/content/Context;
    //   14: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 38	ke:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: iconst_3
    //   22: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: iconst_2
    //   26: anewarray 40	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_1
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: iload_2
    //   36: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual 53	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +58 -> 104
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: invokeinterface 59 1 0
    //   57: ifle +47 -> 104
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: invokeinterface 62 1 0
    //   68: ifeq +36 -> 104
    //   71: aload_3
    //   72: astore_1
    //   73: aload_3
    //   74: iconst_1
    //   75: invokeinterface 145 2 0
    //   80: istore 5
    //   82: iload 5
    //   84: istore_2
    //   85: iload_2
    //   86: istore 5
    //   88: aload_3
    //   89: ifnull +12 -> 101
    //   92: aload_3
    //   93: invokeinterface 68 1 0
    //   98: iload_2
    //   99: istore 5
    //   101: iload 5
    //   103: ireturn
    //   104: iload_2
    //   105: istore 5
    //   107: aload_3
    //   108: ifnull -7 -> 101
    //   111: aload_3
    //   112: invokeinterface 68 1 0
    //   117: iload_2
    //   118: ireturn
    //   119: astore 4
    //   121: aconst_null
    //   122: astore_3
    //   123: aload_3
    //   124: astore_1
    //   125: ldc 70
    //   127: new 72	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   134: ldc 75
    //   136: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 4
    //   141: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 90	kx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_3
    //   154: astore_1
    //   155: aload 4
    //   157: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   160: iload_2
    //   161: istore 5
    //   163: aload_3
    //   164: ifnull -63 -> 101
    //   167: aload_3
    //   168: invokeinterface 68 1 0
    //   173: iload_2
    //   174: ireturn
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +9 -> 188
    //   182: aload_1
    //   183: invokeinterface 68 1 0
    //   188: aload_3
    //   189: athrow
    //   190: astore_3
    //   191: goto -13 -> 178
    //   194: astore 4
    //   196: goto -73 -> 123
    //
    // Exception table:
    //   from	to	target	type
    //   10	45	119	java/lang/Exception
    //   10	45	175	finally
    //   51	60	190	finally
    //   62	71	190	finally
    //   73	82	190	finally
    //   125	153	190	finally
    //   155	160	190	finally
    //   51	60	194	java/lang/Exception
    //   62	71	194	java/lang/Exception
    //   73	82	194	java/lang/Exception
  }

  // ERROR //
  long b(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: lload_2
    //   1: lstore 7
    //   3: aload_0
    //   4: invokespecial 27	la:b	()Z
    //   7: ifeq +110 -> 117
    //   10: aload_0
    //   11: getfield 13	la:a	Landroid/content/Context;
    //   14: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 38	ke:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: iconst_2
    //   22: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: iconst_2
    //   26: anewarray 40	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: iload_1
    //   32: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: lload_2
    //   39: invokestatic 149	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 53	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +69 -> 120
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: invokeinterface 59 1 0
    //   65: ifle +55 -> 120
    //   68: aload 5
    //   70: astore 4
    //   72: aload 5
    //   74: invokeinterface 62 1 0
    //   79: ifeq +41 -> 120
    //   82: aload 5
    //   84: astore 4
    //   86: aload 5
    //   88: iconst_1
    //   89: invokeinterface 153 2 0
    //   94: lstore 7
    //   96: lload 7
    //   98: lstore_2
    //   99: lload_2
    //   100: lstore 7
    //   102: aload 5
    //   104: ifnull +13 -> 117
    //   107: aload 5
    //   109: invokeinterface 68 1 0
    //   114: lload_2
    //   115: lstore 7
    //   117: lload 7
    //   119: lreturn
    //   120: lload_2
    //   121: lstore 7
    //   123: aload 5
    //   125: ifnull -8 -> 117
    //   128: aload 5
    //   130: invokeinterface 68 1 0
    //   135: lload_2
    //   136: lreturn
    //   137: astore 6
    //   139: aconst_null
    //   140: astore 5
    //   142: aload 5
    //   144: astore 4
    //   146: ldc 70
    //   148: new 72	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   155: ldc 75
    //   157: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 6
    //   162: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   165: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 90	kx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 5
    //   176: astore 4
    //   178: aload 6
    //   180: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   183: lload_2
    //   184: lstore 7
    //   186: aload 5
    //   188: ifnull -71 -> 117
    //   191: aload 5
    //   193: invokeinterface 68 1 0
    //   198: lload_2
    //   199: lreturn
    //   200: astore 5
    //   202: aconst_null
    //   203: astore 4
    //   205: aload 4
    //   207: ifnull +10 -> 217
    //   210: aload 4
    //   212: invokeinterface 68 1 0
    //   217: aload 5
    //   219: athrow
    //   220: astore 5
    //   222: goto -17 -> 205
    //   225: astore 6
    //   227: goto -85 -> 142
    //
    // Exception table:
    //   from	to	target	type
    //   10	49	137	java/lang/Exception
    //   10	49	200	finally
    //   58	68	220	finally
    //   72	82	220	finally
    //   86	96	220	finally
    //   146	174	220	finally
    //   178	183	220	finally
    //   58	68	225	java/lang/Exception
    //   72	82	225	java/lang/Exception
    //   86	96	225	java/lang/Exception
  }

  String b(int paramInt, String paramString)
  {
    return a(String.valueOf(paramInt), paramString);
  }

  void b(String paramString)
  {
    if (b())
      this.a.getContentResolver().delete(ke.a, null, new String[] { String.valueOf(paramString), null });
  }

  boolean b(int paramInt, boolean paramBoolean)
  {
    return b(String.valueOf(paramInt), paramBoolean);
  }

  // ERROR //
  boolean b(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 5
    //   3: aload_0
    //   4: invokespecial 27	la:b	()Z
    //   7: ifeq +100 -> 107
    //   10: aload_0
    //   11: getfield 13	la:a	Landroid/content/Context;
    //   14: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 38	ke:a	Landroid/net/Uri;
    //   20: aconst_null
    //   21: iconst_1
    //   22: invokestatic 44	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: iconst_2
    //   26: anewarray 40	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_1
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: iload_2
    //   36: invokestatic 167	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual 53	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +64 -> 110
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: invokeinterface 59 1 0
    //   57: ifle +53 -> 110
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: invokeinterface 62 1 0
    //   68: ifeq +42 -> 110
    //   71: aload_3
    //   72: astore_1
    //   73: aload_3
    //   74: iconst_1
    //   75: invokeinterface 65 2 0
    //   80: invokestatic 170	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   83: invokevirtual 173	java/lang/Boolean:booleanValue	()Z
    //   86: istore 5
    //   88: iload 5
    //   90: istore_2
    //   91: iload_2
    //   92: istore 5
    //   94: aload_3
    //   95: ifnull +12 -> 107
    //   98: aload_3
    //   99: invokeinterface 68 1 0
    //   104: iload_2
    //   105: istore 5
    //   107: iload 5
    //   109: ireturn
    //   110: iload_2
    //   111: istore 5
    //   113: aload_3
    //   114: ifnull -7 -> 107
    //   117: aload_3
    //   118: invokeinterface 68 1 0
    //   123: iload_2
    //   124: ireturn
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_3
    //   129: aload_3
    //   130: astore_1
    //   131: ldc 70
    //   133: new 72	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   140: ldc 75
    //   142: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 4
    //   147: invokevirtual 83	java/lang/Exception:toString	()Ljava/lang/String;
    //   150: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 90	kx:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_3
    //   160: astore_1
    //   161: aload 4
    //   163: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   166: iload_2
    //   167: istore 5
    //   169: aload_3
    //   170: ifnull -63 -> 107
    //   173: aload_3
    //   174: invokeinterface 68 1 0
    //   179: iload_2
    //   180: ireturn
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 68 1 0
    //   194: aload_3
    //   195: athrow
    //   196: astore_3
    //   197: goto -13 -> 184
    //   200: astore 4
    //   202: goto -73 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   10	45	125	java/lang/Exception
    //   10	45	181	finally
    //   51	60	196	finally
    //   62	71	196	finally
    //   73	88	196	finally
    //   131	159	196	finally
    //   161	166	196	finally
    //   51	60	200	java/lang/Exception
    //   62	71	200	java/lang/Exception
    //   73	88	200	java/lang/Exception
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     la
 * JD-Core Version:    0.6.2
 */