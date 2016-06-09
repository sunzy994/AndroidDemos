package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;

public class np
{
  np(ld paramld)
  {
  }

  public static String a(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.dianxinos.DXStatService.stat.TokenManager").getMethod("getToken", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      if ((paramContext != null) && ((paramContext instanceof String)))
      {
        paramContext = String.valueOf(paramContext);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1)
        localStringBuilder.append('0');
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }

  public static void a(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("your sid(" + paramInt + ") is invalid, Please check it ");
  }

  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT <= 8)
    {
      paramEditor.commit();
      return;
    }
    paramEditor.apply();
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
    }
  }

  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 0);
      return true;
    }
    catch (NameNotFoundException paramContext)
    {
    }
    return false;
  }

  public static boolean b(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }

  public void a()
  {
    if (ld.a(this.a) != null)
      ld.a(this.a).b(this.a);
  }

  public void a(lb paramlb)
  {
    if (ld.a(this.a) != null)
      ld.a(this.a).a(this.a, paramlb);
  }

  public void a(nq paramnq)
  {
    ld.a(this.a, paramnq);
    if (ld.a(this.a) != null)
      ld.a(this.a).a(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     np
 * JD-Core Version:    0.6.2
 */