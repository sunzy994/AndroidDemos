package cmcm.com.myapplication.com.qq.e.comm.util;

import android.util.Base64;
import java.security.MessageDigest;

public class Md5Util
{
  private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  public static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0)
        j = k + 256;
      k = j / 16;
      localStringBuffer.append(a[k] + a[(j % 16)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }

  // ERROR //
  public static String encode(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 73
    //   6: areturn
    //   7: aconst_null
    //   8: astore_1
    //   9: ldc 75
    //   11: invokestatic 81	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   14: astore_2
    //   15: new 83	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore_1
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 90	java/io/FileInputStream:read	([B)I
    //   35: istore_3
    //   36: iload_3
    //   37: ifle +25 -> 62
    //   40: aload_2
    //   41: aload_1
    //   42: iconst_0
    //   43: iload_3
    //   44: invokevirtual 94	java/security/MessageDigest:update	([BII)V
    //   47: goto -17 -> 30
    //   50: astore_1
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 97	java/io/FileInputStream:close	()V
    //   59: ldc 73
    //   61: areturn
    //   62: aload_2
    //   63: invokevirtual 101	java/security/MessageDigest:digest	()[B
    //   66: invokestatic 103	com/qq/e/comm/util/Md5Util:byteArrayToHexString	([B)Ljava/lang/String;
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 97	java/io/FileInputStream:close	()V
    //   74: aload_1
    //   75: areturn
    //   76: astore_0
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 97	java/io/FileInputStream:close	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: goto -34 -> 59
    //   96: astore_0
    //   97: goto -7 -> 90
    //   100: astore_1
    //   101: goto -19 -> 82
    //   104: astore_0
    //   105: aload_1
    //   106: astore_0
    //   107: goto -56 -> 51
    //
    // Exception table:
    //   from	to	target	type
    //   24	30	50	java/lang/Exception
    //   30	36	50	java/lang/Exception
    //   40	47	50	java/lang/Exception
    //   62	70	50	java/lang/Exception
    //   70	74	76	java/lang/Exception
    //   9	24	79	finally
    //   55	59	92	java/lang/Exception
    //   86	90	96	java/lang/Exception
    //   24	30	100	finally
    //   30	36	100	finally
    //   40	47	100	finally
    //   62	70	100	finally
    //   9	24	104	java/lang/Exception
  }

  // ERROR //
  public static String encode(String paramString)
  {
    // Byte code:
    //   0: new 10	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 107	java/lang/String:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: ldc 75
    //   11: invokestatic 81	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   14: aload_0
    //   15: invokevirtual 110	java/lang/String:getBytes	()[B
    //   18: invokevirtual 113	java/security/MessageDigest:digest	([B)[B
    //   21: invokestatic 103	com/qq/e/comm/util/Md5Util:byteArrayToHexString	([B)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: areturn
    //   27: astore_0
    //   28: aconst_null
    //   29: areturn
    //   30: astore_1
    //   31: aload_0
    //   32: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	27	java/lang/Exception
    //   9	25	30	java/lang/Exception
  }

  public static String encodeBase64String(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    try
    {
      paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      GDTLogger.e("Exception while md5 base64String", paramString);
    }
    return null;
  }

  public static byte[] hexStringtoByteArray(String paramString)
  {
    if (paramString.length() % 2 != 0)
      return null;
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int k = 0;
    if (k < paramString.length() - 1)
    {
      char c1 = paramString.charAt(k);
      char c2 = paramString.charAt(k + 1);
      int j = Character.toLowerCase(c1);
      int m = Character.toLowerCase(c2);
      if (j <= 57)
      {
        j -= 48;
        label77: j <<= 4;
        if (m > 57)
          break label153;
        j += m - 48;
      }
      while (true)
      {
        m = j;
        if (j > 127)
          m = j - 256;
        int i = (byte)m;
        arrayOfByte[(k / 2)] = i;
        k += 2;
        break;
        j = j - 97 + 10;
        break label77;
        label153: j += m - 97 + 10;
      }
    }
    return arrayOfByte;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.util.Md5Util
 * JD-Core Version:    0.6.2
 */