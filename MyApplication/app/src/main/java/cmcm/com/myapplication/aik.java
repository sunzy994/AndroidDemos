package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

public class aik
{
  private static String a;

  public static String a()
  {
    if (a == null)
      a = b();
    return a;
  }

  public static String a(PackageInfo paramPackageInfo)
  {
    try
    {
      paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
      paramPackageInfo = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramPackageInfo))).getPublicKey();
      if ((paramPackageInfo instanceof RSAPublicKey))
        return ((RSAPublicKey)paramPackageInfo).getModulus().toString(16);
      if (paramPackageInfo != null)
      {
        paramPackageInfo = paramPackageInfo.toString();
        paramPackageInfo = paramPackageInfo.substring(paramPackageInfo.indexOf("modulus: ") + 9, paramPackageInfo.indexOf("\n", paramPackageInfo.indexOf("modulus:")));
        return paramPackageInfo;
      }
    }
    catch (CertificateException paramPackageInfo)
    {
      paramPackageInfo.printStackTrace();
    }
    return "";
  }

  private static String a(int[] paramArrayOfInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfInt.length + paramArrayOfString.length != paramArrayOfBoolean.length)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramArrayOfBoolean.length;
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < n)
    {
      Object localObject;
      if (paramArrayOfBoolean[j] != 0)
      {
        int m = i + 1;
        localObject = Integer.valueOf(paramArrayOfInt[i]);
        i = m;
      }
      while (true)
      {
        localStringBuilder.append(localObject);
        j += 1;
        break;
        localObject = paramArrayOfString[k];
        k += 1;
      }
    }
    return localStringBuilder.toString();
  }

  public static boolean a(String paramString, Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      boolean bool1 = bool2;
      int j;
      int i;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.signatures != null)
        {
          paramContext = paramString.signatures;
          j = paramContext.length;
          i = 0;
        }
      }
      while (true)
      {
        bool1 = bool2;
        if (i < j)
        {
          Object localObject = paramContext[i];
          bool1 = a(paramString).equals(a());
          if (bool1)
            bool1 = true;
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    catch (Exception paramString)
    {
    }
    return false;
  }

  private static String b()
  {
    return a(new int[] { 8602, 7844, 4454, 289, 3384, 406, 562, 3381, 527, 7733, 8259, 9809, 2657, 9133, 5191, 5441, 968, 217, 218 }, new String[] { "8c0", "b59", "a4d", "24c", "64cf", "e5ce", "7c46", "f0f6d", "b52c", "de1b", "9d91", "91cac", "b321", "af822b", "daee", "b33e", "c37f", "dc3d", "70cac", "61a7e", "c269", "a42c", "8c75cc", "7b1c", "e4320", "6ddb", "51ba", "75c35", "f6a", "5c4ff", "a299", "ee7b", "0c2a", "f5ce", "2f30", "a23c", "9cc0", "5f6e", "bfe", "b9ad", "fc102", "ae7", "e9e", "37f", "8ba", "8ab", "a7" }, new boolean[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aik
 * JD-Core Version:    0.6.2
 */