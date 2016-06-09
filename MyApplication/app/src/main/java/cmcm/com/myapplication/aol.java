package cmcm.com.myapplication;

import android.content.Context;

public class aol extends aoi
{
  public aol(Context paramContext)
  {
  }

  // ERROR //
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 16	java/io/FileInputStream
    //   6: dup
    //   7: ldc 18
    //   9: invokespecial 21	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 25	java/io/FileInputStream:read	()I
    //   17: istore_3
    //   18: aload_1
    //   19: invokevirtual 28	java/io/FileInputStream:close	()V
    //   22: iload_3
    //   23: iconst_m1
    //   24: if_icmpne +22 -> 46
    //   27: iload 5
    //   29: istore 4
    //   31: aload_1
    //   32: ifnull +11 -> 43
    //   35: aload_1
    //   36: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   39: iload 5
    //   41: istore 4
    //   43: iload 4
    //   45: ireturn
    //   46: aload_0
    //   47: iconst_0
    //   48: invokevirtual 36	aol:a	(Z)Z
    //   51: istore 4
    //   53: iload 4
    //   55: istore 5
    //   57: iload 5
    //   59: istore 4
    //   61: aload_1
    //   62: ifnull -19 -> 43
    //   65: aload_1
    //   66: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   69: iload 5
    //   71: ireturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_1
    //   75: iload 5
    //   77: istore 4
    //   79: aload_1
    //   80: ifnull -37 -> 43
    //   83: aload_1
    //   84: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   100: aload_2
    //   101: athrow
    //   102: astore_2
    //   103: goto -11 -> 92
    //   106: astore_2
    //   107: goto -32 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   3	13	72	java/lang/Exception
    //   3	13	89	finally
    //   13	22	102	finally
    //   46	53	102	finally
    //   13	22	106	java/lang/Exception
    //   46	53	106	java/lang/Exception
  }

  // ERROR //
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 38	java/io/FileOutputStream
    //   3: dup
    //   4: ldc 18
    //   6: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: iload_1
    //   11: ifeq +35 -> 46
    //   14: bipush 49
    //   16: istore 4
    //   18: aload_2
    //   19: iconst_2
    //   20: newarray byte
    //   22: dup
    //   23: iconst_0
    //   24: iload 4
    //   26: i2b
    //   27: bastore
    //   28: dup
    //   29: iconst_1
    //   30: bipush 10
    //   32: bastore
    //   33: invokevirtual 43	java/io/FileOutputStream:write	([B)V
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   44: iconst_1
    //   45: ireturn
    //   46: bipush 48
    //   48: istore 4
    //   50: goto -32 -> 18
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: astore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   77: aload_3
    //   78: athrow
    //   79: astore_3
    //   80: goto -11 -> 69
    //   83: astore_3
    //   84: goto -28 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   0	10	53	java/lang/Exception
    //   0	10	66	finally
    //   18	36	79	finally
    //   18	36	83	java/lang/Exception
  }

  // ERROR //
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: new 16	java/io/FileInputStream
    //   11: dup
    //   12: ldc 18
    //   14: invokespecial 21	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 25	java/io/FileInputStream:read	()I
    //   22: istore 4
    //   24: iload 4
    //   26: bipush 48
    //   28: if_icmpeq +6 -> 34
    //   31: iconst_1
    //   32: istore 5
    //   34: iload 5
    //   36: istore 6
    //   38: aload_1
    //   39: ifnull +11 -> 50
    //   42: aload_1
    //   43: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   46: iload 5
    //   48: istore 6
    //   50: iload 6
    //   52: ireturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull -7 -> 50
    //   60: aload_1
    //   61: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokestatic 33	arf:a	(Ljava/io/Closeable;)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: goto -15 -> 67
    //   85: astore_2
    //   86: goto -30 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   8	18	53	java/lang/Exception
    //   8	18	66	finally
    //   18	24	77	finally
    //   18	24	85	java/lang/Exception
  }

  public void c()
  {
    a(false);
  }

  public void d()
  {
    a(true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aol
 * JD-Core Version:    0.6.2
 */