package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class eb
{
  private static final String a = eb.class.getSimpleName();
  private static String b;
  private static String c;

  public static String a()
  {
    try
    {
      String str;
      if (!TextUtils.isEmpty(b))
        str = b;
      while (true)
      {
        return str;
        if (!TextUtils.isEmpty(c))
        {
          str = c;
        }
        else
        {
          c = b();
          str = c;
        }
      }
    }
    finally
    {
    }
  }

  public static void a(String paramString)
  {
    b = paramString;
  }

  private static String b()
  {
    try
    {
      Object localObject = do.a().b();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      if (((PackageInfo)localObject).versionName != null)
        return ((PackageInfo)localObject).versionName;
      if (((PackageInfo)localObject).versionCode != 0)
      {
        localObject = Integer.toString(((PackageInfo)localObject).versionCode);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      el.a(6, a, "", localThrowable);
    }
    return "Unknown";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.eb
 * JD-Core Version:    0.6.2
 */