package cmcm.com.myapplication.com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  private static final byte[] a = { 91, -62 };
  private static Cipher b = null;
  private static Cipher c = null;
  private static byte[] d = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

  @SuppressLint({"TrulyRandom"})
  private static Cipher a()
  {
    try
    {
      Cipher localCipher;
      if (b != null)
        localCipher = b;
      while (true)
      {
        return localCipher;
        try
        {
          localCipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
          localCipher.init(1, new SecretKeySpec(d, "AES"));
          b = localCipher;
          localCipher = b;
        }
        catch (Exception localException)
        {
          throw new a.a("Fail To Init Cipher", localException);
        }
      }
    }
    finally
    {
    }
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.write(a);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeByte(2);
      localDataOutputStream.write(c(com.qq.e.comm.a.a(paramArrayOfByte)));
      localDataOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
    }
    throw new a.b("Exception while packaging byte array", paramArrayOfByte);
  }

  private static Cipher b()
  {
    try
    {
      Cipher localCipher;
      if (c != null)
        localCipher = c;
      while (true)
      {
        return localCipher;
        try
        {
          localCipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
          localCipher.init(2, new SecretKeySpec(d, "AES"));
          c = localCipher;
          localCipher = c;
        }
        catch (Exception localException)
        {
          throw new a.a("Fail To Init Cipher", localException);
        }
      }
    }
    finally
    {
    }
  }

  @TargetApi(9)
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
      throw new a.b("S2SS Package FormatError", null);
    try
    {
      DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[4];
      localDataInputStream.read(arrayOfByte);
      if ((a[0] != arrayOfByte[0]) || (a[1] != arrayOfByte[1]) || (1 != arrayOfByte[2]) || (2 != arrayOfByte[3]))
        throw new a.b("S2SS Package Magic/Version FormatError", null);
    }
    catch (Exception paramArrayOfByte)
    {
      throw new a.b("Exception while packaging byte array", paramArrayOfByte);
    }
    paramArrayOfByte = com.qq.e.comm.a.b(d(Arrays.copyOfRange(paramArrayOfByte, 4, paramArrayOfByte.length)));
    return paramArrayOfByte;
  }

  private static byte[] c(byte[] paramArrayOfByte)
  {
    Cipher localCipher = a();
    try
    {
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
    }
    throw new a.a("Exception While encrypt byte array", paramArrayOfByte);
  }

  private static byte[] d(byte[] paramArrayOfByte)
  {
    Cipher localCipher = b();
    try
    {
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
    }
    throw new a.a("Exception While dencrypt byte array", paramArrayOfByte);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.net.rr.a
 * JD-Core Version:    0.6.2
 */