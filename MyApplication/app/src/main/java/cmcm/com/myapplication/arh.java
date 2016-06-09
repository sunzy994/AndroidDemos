package cmcm.com.myapplication;

import java.security.MessageDigest;

public class arh
{
  private static MessageDigest a = null;
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };

  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes());
      return paramString;
    }
    finally
    {
      paramString = finally;
    }
    throw paramString;
  }

  // ERROR //
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	arh:a	Ljava/security/MessageDigest;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 54
    //   13: invokestatic 60	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: putstatic 13	arh:a	Ljava/security/MessageDigest;
    //   19: getstatic 13	arh:a	Ljava/security/MessageDigest;
    //   22: ifnull +81 -> 103
    //   25: getstatic 13	arh:a	Ljava/security/MessageDigest;
    //   28: invokevirtual 63	java/security/MessageDigest:reset	()V
    //   31: getstatic 13	arh:a	Ljava/security/MessageDigest;
    //   34: aload_0
    //   35: invokevirtual 67	java/security/MessageDigest:update	([B)V
    //   38: getstatic 13	arh:a	Ljava/security/MessageDigest;
    //   41: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   44: astore_0
    //   45: new 72	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 74
    //   51: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: arraylength
    //   57: istore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: goto +58 -> 119
    //   64: iload_3
    //   65: bipush 16
    //   67: if_icmpge +10 -> 77
    //   70: aload_1
    //   71: ldc 80
    //   73: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: iload_3
    //   79: invokestatic 90	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   82: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto +29 -> 119
    //   93: aload_1
    //   94: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: areturn
    //   103: ldc 74
    //   105: astore_0
    //   106: goto -8 -> 98
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    //   115: astore_1
    //   116: goto -97 -> 19
    //   119: iload_2
    //   120: iload 5
    //   122: if_icmpge -29 -> 93
    //   125: aload_0
    //   126: iload_2
    //   127: baload
    //   128: istore 4
    //   130: iload 4
    //   132: istore_3
    //   133: iload 4
    //   135: ifge -71 -> 64
    //   138: iload 4
    //   140: sipush 256
    //   143: iadd
    //   144: istore_3
    //   145: goto -81 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   3	7	109	finally
    //   11	19	109	finally
    //   19	59	109	finally
    //   70	77	109	finally
    //   77	86	109	finally
    //   93	98	109	finally
    //   11	19	115	java/lang/Exception
  }

  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      localObject = new String(aqh.a(((MessageDigest)localObject).digest()), "UTF-8");
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arh
 * JD-Core Version:    0.6.2
 */