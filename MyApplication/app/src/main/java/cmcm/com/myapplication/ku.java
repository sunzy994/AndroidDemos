package cmcm.com.myapplication;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ku
{
  public static String a = "tgpPPsiJWz2LF8Vv8";
  public static String b = "haGZtPMSfQ3Vf83";
  private static String c = "tgpPPsiJWz2LF8Vv8haGZtPMSfQ3Vf83";
  private static String d = "tgpPPsiJWz2LF8Vv8haGZtPMSfQ3Vf83";

  public static long a()
  {
    return System.currentTimeMillis();
  }

  public static String a(long paramLong)
  {
    return a(String.valueOf(paramLong));
  }

  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return a(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }

  public static String a(String paramString, int paramInt)
  {
    if (paramInt > 0)
      return paramString.substring(paramInt);
    return paramString.substring(paramString.length() + paramInt);
  }

  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramInt1, paramInt1 + paramInt2);
  }

  public static String a(String paramString, long paramLong)
  {
    paramString = "0000000000" + paramLong;
    return paramString.substring(paramString.length() - 10);
  }

  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(Base64.encodeToString(paramString1.getBytes("utf-8"), 0), "ENCODE", paramString2 + b);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, 0);
  }

  public static String a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = a(paramString3);
    String str2 = a(a(paramString3, 0, 16));
    String str1 = a(a(paramString3, 16, 16));
    paramString3 = a(paramString1, 0, 4);
    Object localObject = a(a(a()), -4);
    if (paramString2.equals("DECODE"))
    {
      str2 = str2 + a(new StringBuilder().append(str2).append(paramString3).toString());
      i = str2.length();
      localObject = b(a(paramString1, 4));
      if (!paramString2.equals("DECODE"))
        break label179;
    }
    int k;
    int[] arrayOfInt1;
    label179: for (paramString1 = (String)localObject; ; paramString1 = a("%010d", 0L) + a(a(new StringBuilder().append(paramString1).append(str1).toString()), 0, 16) + paramString1)
    {
      k = paramString1.length();
      localObject = new StringBuffer();
      arrayOfInt1 = new int[256];
      paramInt = 0;
      while (paramInt < 256)
      {
        arrayOfInt1[paramInt] = paramInt;
        paramInt += 1;
      }
      paramString3 = (String)localObject;
      break;
    }
    int[] arrayOfInt2 = new int[256];
    paramInt = 0;
    while (paramInt <= 255)
    {
      arrayOfInt2[paramInt] = str2.charAt(paramInt % i);
      paramInt += 1;
    }
    int i = 0;
    paramInt = 0;
    while (paramInt < 256)
    {
      i = (i + arrayOfInt1[paramInt] + arrayOfInt2[paramInt]) % 256;
      j = arrayOfInt1[paramInt];
      arrayOfInt1[paramInt] = arrayOfInt1[i];
      arrayOfInt1[i] = j;
      paramInt += 1;
    }
    i = 0;
    int j = 0;
    paramInt = 0;
    while (paramInt < k)
    {
      j = (j + 1) % 256;
      i = (i + arrayOfInt1[j]) % 256;
      int m = arrayOfInt1[j];
      arrayOfInt1[j] = arrayOfInt1[i];
      arrayOfInt1[i] = m;
      ((StringBuffer)localObject).append((char)(paramString1.charAt(paramInt) ^ arrayOfInt1[((arrayOfInt1[j] + arrayOfInt1[i]) % 256)]));
      paramInt += 1;
    }
    if (paramString2.equals("DECODE"))
    {
      paramString1 = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length());
      if ((Integer.parseInt(a(paramString1.toString(), 0, 10)) == 0) && (a(paramString1.toString(), 10, 16).equals(a(a(a(paramString1.toString(), 26) + str1), 0, 16))))
        return a(paramString1.toString(), 26);
      return "";
    }
    return paramString3 + c(((StringBuffer)localObject).toString());
  }

  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1)
        localStringBuffer.append("0").append(str);
      while (true)
      {
        i += 1;
        break;
        localStringBuffer.append(str);
      }
    }
    return localStringBuffer.toString();
  }

  public static String b(String paramString)
  {
    try
    {
      paramString = new String(kt.a(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return paramString.getMessage();
  }

  public static String b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = a(Base64.encodeToString(paramArrayOfByte, 0), "ENCODE", c);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }

  public static String c(String paramString)
  {
    try
    {
      paramString = new String(kt.a(paramString.getBytes()));
      return paramString;
    }
    catch (Exception paramString)
    {
    }
    return paramString.getMessage();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ku
 * JD-Core Version:    0.6.2
 */