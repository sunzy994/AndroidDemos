package cmcm.com.myapplication;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;

public class ql
{
  public static String a()
  {
    return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
  }

  public static String[] a(Context paramContext)
  {
    String str = Build.CPU_ABI;
    paramContext = new String[3];
    if (str.contains("armeabi"))
      if (str.contains("-v"))
        paramContext[0] = "ARMV7";
    while (true)
    {
      qq.d("cpu", paramContext[0]);
      return paramContext;
      paramContext[0] = "ARM";
      continue;
      if (str.contains("arm64"))
      {
        paramContext[0] = "ARM64";
      }
      else if (str.contains("x86"))
      {
        paramContext[0] = "X86";
      }
      else
      {
        str = Build.CPU_ABI2;
        if (str.contains("armeabi"))
        {
          if (str.contains("-v"))
            paramContext[0] = "ARMV7";
          else
            paramContext[0] = "ARM";
        }
        else if (str.contains("x86"))
          paramContext[0] = "X86";
      }
    }
  }

  public static int b()
  {
    return TimeZone.getDefault().getRawOffset() / 3600 / 1000;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ql
 * JD-Core Version:    0.6.2
 */