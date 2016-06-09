package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.lazyswipe.features.weather.bean.WeatherForecast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class akc
{
  static final Map<Integer, Integer> a = new HashMap();
  private static final int[] b = { 2130837575, 2130837566, 2130837567, 2130837568, 2130837569, 2130837570, 2130837572, 2130837571, 2130837573, 2130837574 };
  private static final int[] c = { 2131230825, 2131230836, 2131230847, 2131230858, 2131230865, 2131230866, 2131230867, 2131230868, 2131230869, 2131230826, 2131230827, 2131230828, 2131230829, 2131230830, 2131230831, 2131230832, 2131230833, 2131230834, 2131230835, 2131230837, 2131230838, 2131230839, 2131230840, 2131230841, 2131230842, 2131230843, 2131230844, 2131230845, 2131230846, 2131230848, 2131230849, 2131230850, 2131230851, 2131230852, 2131230853, 2131230854, 2131230855, 2131230856, 2131230857, 2131230859, 2131230860, 2131230861, 2131230862, 2131230863, 2131230864, 2131230875, 2131230877, 2131230876, 2131230873, 2131230881, 2131230872, 2131230874, 2131230882, 2131230880, 2131230883, 2131230884, 2131230888, 2131230886, 2131230887, 2131230879, 2131230878, 2131230871, 2131230885, 2131230823, 2131230824, 2131230818, 2131230819, 2131230820, 2131230821, 2131230822 };

  static
  {
    a(a, Integer.valueOf(1), new Integer[] { Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(35), Integer.valueOf(37) });
    a(a, Integer.valueOf(2), new Integer[] { Integer.valueOf(28), Integer.valueOf(29), Integer.valueOf(30), Integer.valueOf(31) });
    a(a, Integer.valueOf(3), new Integer[] { Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(26), Integer.valueOf(27) });
    a(a, Integer.valueOf(5), new Integer[] { Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(36), Integer.valueOf(38), Integer.valueOf(39), Integer.valueOf(41), Integer.valueOf(42), Integer.valueOf(48) });
    a(a, Integer.valueOf(12), new Integer[] { Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(43), Integer.valueOf(44), Integer.valueOf(47) });
    a(a, Integer.valueOf(16), new Integer[] { Integer.valueOf(21), Integer.valueOf(22) });
    a(a, Integer.valueOf(17), new Integer[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(20), Integer.valueOf(23) });
  }

  public static int a(int paramInt)
  {
    return a(a, paramInt, false);
  }

  public static int a(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    return paramContext.getResources().getIdentifier(paramString, "drawable", str);
  }

  public static int a(Map<Integer, Integer> paramMap, int paramInt, boolean paramBoolean)
  {
    int j = 2;
    int i;
    if (paramMap.containsKey(Integer.valueOf(paramInt)))
      i = ((Integer)paramMap.get(Integer.valueOf(paramInt))).intValue();
    do
    {
      do
      {
        return i;
        i = j;
      }
      while (paramInt > 0);
      i = j;
    }
    while (paramBoolean);
    return -1;
  }

  public static akw a(WeatherForecast paramWeatherForecast, Date paramDate, int paramInt)
  {
    return a(paramWeatherForecast, paramDate, paramInt, false);
  }

  public static akw a(WeatherForecast paramWeatherForecast, Date paramDate, int paramInt, boolean paramBoolean)
  {
    if ((paramWeatherForecast != null) && (paramWeatherForecast.a() != null))
    {
      paramWeatherForecast = paramWeatherForecast.a().iterator();
      while (paramWeatherForecast.hasNext())
      {
        akw localakw = (akw)paramWeatherForecast.next();
        if ((localakw != null) && (localakw.a() != null) && (asq.a(localakw.a(), paramDate) == paramInt) && ((!paramBoolean) || (!localakw.d())))
          return localakw;
      }
    }
    return null;
  }

  public static Integer a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramInt = a(paramContext, a(paramInt, paramBoolean));
      return Integer.valueOf(paramInt);
    }
    catch (Throwable paramContext)
    {
    }
    return Integer.valueOf(2130837575);
  }

  public static String a()
  {
    return "fonts/clock_thin.ttf";
  }

  public static String a(int paramInt, boolean paramBoolean)
  {
    paramInt = a(a, paramInt, false);
    if (paramInt > 0)
    {
      if ((paramBoolean) && (paramInt == 1))
        return "clockweather_w1_night";
      if ((paramBoolean) && (paramInt == 2))
        return "clockweather_w2_night";
      return "clockweather_w" + paramInt;
    }
    if (paramBoolean)
      return "clockweather_w1_night";
    return "clockweather_w_nodata_3_0";
  }

  public static String a(Context paramContext, int paramInt)
  {
    try
    {
      paramInt = b(paramContext, "clockweather_w_desc" + paramInt);
      if (paramInt > 0)
      {
        String str = paramContext.getString(paramInt);
        return str;
      }
    }
    catch (Exception localException)
    {
    }
    return paramContext.getString(2131230808);
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = vs.R(paramContext);
    if (bool == "c".equalsIgnoreCase(paramString2));
    while (TextUtils.isEmpty(paramString1))
      return paramString1;
    float f1 = 0.0F;
    try
    {
      float f2 = Float.parseFloat(paramString1);
      f1 = f2;
      label37: if (bool);
      for (f1 = (f1 - 32.0F) / 1.8F; ; f1 = f1 * 1.8F + 32.0F)
      {
        paramString1 = new DecimalFormat("#").format(f1);
        paramContext = paramString1;
        if ("-0".equals(paramString1))
          paramContext = "0";
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      break label37;
    }
  }

  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("http://weather.qiigame.com/weather/thirdpart/");
    if (paramBoolean);
    for (String str = "live"; ; str = "prediction")
      return asq.p(paramContext, str + "?woeId=" + paramString + "&lang=" + asq.j());
  }

  public static String a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString)))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramString.length();
    int k = 0;
    while (k < m)
    {
      int j = paramString.charAt(k);
      int i = j;
      if (j == 65293)
        i = 45;
      if ((Character.isDigit(i)) || (i == 45))
        localStringBuilder.append(i);
      k += 1;
    }
    return localStringBuilder.toString();
  }

  public static List<akw> a(WeatherForecast paramWeatherForecast, List<akw> paramList)
  {
    if ((paramWeatherForecast == null) || (paramList == null))
      return null;
    ArrayList localArrayList = new ArrayList();
    Date localDate = new Date();
    int i = 0;
    while ((i < paramList.size()) && (i < 7))
    {
      localArrayList.add(a(paramWeatherForecast, localDate, i, true));
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramWeatherForecast = localArrayList.iterator();
      while (paramWeatherForecast.hasNext())
        if ((akw)paramWeatherForecast.next() == null)
          paramWeatherForecast.remove();
    }
    return localArrayList;
  }

  private static void a(Map<Integer, Integer> paramMap, Integer paramInteger, Integer[] paramArrayOfInteger)
  {
    if ((paramArrayOfInteger != null) && (paramArrayOfInteger.length > 0))
    {
      int j = paramArrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        paramMap.put(paramArrayOfInteger[i], paramInteger);
        i += 1;
      }
    }
  }

  static boolean a(Calendar paramCalendar)
  {
    return b(paramCalendar.get(11));
  }

  public static boolean a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return a(localCalendar);
  }

  static int b(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    return paramContext.getResources().getIdentifier(paramString, "string", str);
  }

  public static boolean b(int paramInt)
  {
    return (paramInt >= 18) || (paramInt <= 5);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akc
 * JD-Core Version:    0.6.2
 */