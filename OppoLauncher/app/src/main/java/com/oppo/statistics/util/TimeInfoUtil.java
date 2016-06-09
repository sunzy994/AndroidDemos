package com.oppo.statistics.util;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat"})
public class TimeInfoUtil
{
  public static final long MILLISECOND_OF_A_DAY = 86400000L;
  public static final long MILLISECOND_OF_A_MINUTE = 60000L;
  public static final long MILLISECOND_OF_A_WEEK = 604800000L;
  public static final String TIME_PATTERN_01 = "yyyy-MM-dd HH:mm:ss";
  public static final String TIME_PATTERN_02 = "yyyyMMddHH";
  public static final String TIME_PATTERN_03 = "yyyyMMdd";

  public static long getCurrentTime()
  {
    return System.currentTimeMillis();
  }

  public static String getFormatDate()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }

  public static String getFormatDate(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }

  public static String getFormatHour()
  {
    return new SimpleDateFormat("yyyyMMddHH").format(new Date());
  }

  public static String getFormatHour(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMddHH").format(new Date(paramLong));
  }

  public static String getFormatTime()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public static String getFormatTime(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.TimeInfoUtil
 * JD-Core Version:    0.6.2
 */