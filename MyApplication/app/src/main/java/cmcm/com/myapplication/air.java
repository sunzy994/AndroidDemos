package cmcm.com.myapplication;

import android.util.Log;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class air
{
  public static int a = 0;

  private static String a(String paramString)
  {
    while (true)
    {
      int m;
      try
      {
        paramString = b(paramString);
        k = 1;
        j = 0;
        if (j < paramString.length)
        {
          int i = paramString[j];
          paramString[j] = paramString[(j + 1)];
          paramString[(j + 1)] = i;
          paramString[j] = ((byte)(paramString[j] - k));
          k += 1;
          m = j + 1;
          paramString[m] = ((byte)(paramString[m] - k));
          j = k;
          if (k >= 4)
            j = 0;
        }
        else
        {
          paramString = b(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.e("EncryptData", "EncryptData", paramString);
        return "";
      }
      m += 1;
      int k = j + 1;
      int j = m;
    }
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = a(b(a("6957897B2653954C271339566957897B2653954C27133956")), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("EncryptData", " decrypt error ", paramArrayOfByte);
    }
    return null;
  }

  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "DESede");
      Cipher localCipher = Cipher.getInstance("DESede");
      localCipher.init(2, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      Log.e("EncryptData", "EncryptData", paramArrayOfByte1);
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      while (true)
        Log.e("EncryptData", "EncryptData", paramArrayOfByte1);
    }
  }

  private static String b(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1);
      for (str1 = str1 + "0" + str2; ; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toUpperCase();
  }

  private static byte[] b(String paramString)
  {
    if (paramString.length() % 2 != 0)
      throw new Exception("key format is not right");
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      i += 1;
      char c2 = paramString.charAt(i);
      if (((c1 < '0') || (c1 > '9')) && ((c1 < 'A') || (c1 > 'F')) && ((c1 < 'a') || (c1 > 'f')))
        throw new Exception("key format is not right");
      if (((c2 < '0') || (c2 > '9')) && ((c2 < 'A') || (c2 > 'F')) && ((c2 < 'a') || (c2 > 'f')))
        throw new Exception("key format is not right");
      int j = Integer.decode("0x" + c1 + c2).intValue();
      if (j > 127)
        arrayOfByte[(i / 2)] = ((byte)(j | 0xFFFFFF00));
      while (true)
      {
        i += 1;
        break;
        arrayOfByte[(i / 2)] = ((byte)j);
      }
    }
    return arrayOfByte;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     air
 * JD-Core Version:    0.6.2
 */