package com.oppo.statistics.util;

import android.util.Base64;

public class Base64Util
{
  public static String base64Decode(String paramString)
  {
    try
    {
      paramString = new String(Base64.decode(paramString, 0), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtil.e("NearMeStatistics", paramString);
    }
    return "";
  }

  public static String base64Encode(String paramString)
  {
    try
    {
      paramString = new String(Base64.encode(paramString.getBytes(), 0), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtil.e("NearMeStatistics", paramString);
    }
    return "";
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.Base64Util
 * JD-Core Version:    0.6.2
 */