package cmcm.com.myapplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;

public class jv
{
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    Formatter localFormatter = new Formatter();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) });
      i += 1;
    }
    paramArrayOfByte = localFormatter.toString();
    localFormatter.close();
    return paramArrayOfByte;
  }

  public String a(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("appsflyerKey");
    String str2 = (String)paramMap.get("af_timestamp");
    paramMap = (String)paramMap.get("uid");
    return a(str1.substring(0, 7) + paramMap.substring(0, 7) + str2.substring(str2.length() - 7));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jv
 * JD-Core Version:    0.6.2
 */