package cmcm.com.myapplication;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class qg
{
  public static boolean a = false;
  private static final byte[] b = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

  public static String a(String paramString)
  {
    return a("H$#EFGEDVD#$Tffvvbrf", paramString);
  }

  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = c(paramString1);
      c("message", paramString2);
      paramString1 = Base64.encodeToString(a(paramString1, b, paramString2.getBytes("UTF-8")), 2);
      c("Base64.NO_WRAP", paramString1);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      if (a)
        Log.e("AESCrypt", "UnsupportedEncodingException ", paramString1);
    }
    throw new GeneralSecurityException(paramString1);
  }

  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp6_5 = arrayOfChar1;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }

  private static void a(String paramString, byte[] paramArrayOfByte)
  {
    if (a)
      Log.d("AESCrypt", paramString + "[" + paramArrayOfByte.length + "] [" + a(paramArrayOfByte) + "]");
  }

  public static byte[] a(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(1, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    a("cipherText", paramSecretKeySpec);
    return paramSecretKeySpec;
  }

  public static String b(String paramString)
  {
    return b("H$#EFGEDVD#$Tffvvbrf", paramString);
  }

  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = c(paramString1);
      c("base64EncodedCipherText", paramString2);
      paramString2 = Base64.decode(paramString2, 2);
      a("decodedCipherText", paramString2);
      paramString1 = b(paramString1, b, paramString2);
      a("decryptedBytes", paramString1);
      paramString1 = new String(paramString1, "UTF-8");
      c("message", paramString1);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      if (a)
        Log.e("AESCrypt", "UnsupportedEncodingException ", paramString1);
    }
    throw new GeneralSecurityException(paramString1);
  }

  public static byte[] b(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, paramSecretKeySpec, new IvParameterSpec(paramArrayOfByte1));
    paramSecretKeySpec = localCipher.doFinal(paramArrayOfByte2);
    a("decryptedBytes", paramSecretKeySpec);
    return paramSecretKeySpec;
  }

  private static SecretKeySpec c(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    paramString = paramString.getBytes("UTF-8");
    localMessageDigest.update(paramString, 0, paramString.length);
    paramString = localMessageDigest.digest();
    a("SHA-256 key ", paramString);
    return new SecretKeySpec(paramString, "AES");
  }

  private static void c(String paramString1, String paramString2)
  {
    if (a)
      Log.d("AESCrypt", paramString1 + "[" + paramString2.length() + "] [" + paramString2 + "]");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qg
 * JD-Core Version:    0.6.2
 */