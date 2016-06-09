package cmcm.com.myapplication;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aqw
{
  private static final String a = "Swipe." + aqw.class.getSimpleName();
  private static Cipher b;

  public static String a()
  {
    return "qQ1" + asi.a(6) + "vLjW" + asi.a(25) + "I0z7F" + asi.a(18) + "NLFDN5w==";
  }

  public static String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 != null);
    try
    {
      int i = paramString1.trim().length();
      if (i == 0);
      for (localObject = paramString1; ; localObject = new String(((Cipher)localObject).doFinal(a(paramString1))))
      {
        return localObject;
        paramString2 = new SecretKeySpec(aqh.d(paramString2.getBytes()), "AES");
        localObject = b();
        ((Cipher)localObject).init(2, paramString2);
      }
    }
    catch (Exception paramString2)
    {
      while (true)
      {
        Log.e(a, "Failed to decrypt via AES.", paramString2);
        localObject = paramString1;
      }
    }
    finally
    {
    }
    throw paramString1;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1)
        str1 = '0' + str2;
      localStringBuilder.append(str1.toUpperCase());
      i += 1;
    }
    return localStringBuilder.toString();
  }

  private static byte[] a(String paramString)
  {
    if (paramString.length() < 1)
      return null;
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length() / 2)
    {
      arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 1), 16) * 16 + Integer.parseInt(paramString.substring(i * 2 + 1, i * 2 + 2), 16)));
      i += 1;
    }
    return arrayOfByte;
  }

  public static String b(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 != null);
    try
    {
      int i = paramString1.trim().length();
      if (i == 0);
      for (localObject = paramString1; ; localObject = a(((Cipher)localObject).doFinal(paramString1.getBytes("utf-8"))))
      {
        return localObject;
        paramString2 = new SecretKeySpec(aqh.d(paramString2.getBytes()), "AES");
        localObject = b();
        ((Cipher)localObject).init(1, paramString2);
      }
    }
    catch (Exception paramString2)
    {
      while (true)
      {
        Log.e(a, "Failed to encrypt via AES.", paramString2);
        localObject = paramString1;
      }
    }
    finally
    {
    }
    throw paramString1;
  }

  private static Cipher b()
  {
    if (b == null)
      b = Cipher.getInstance("AES");
    return b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqw
 * JD-Core Version:    0.6.2
 */