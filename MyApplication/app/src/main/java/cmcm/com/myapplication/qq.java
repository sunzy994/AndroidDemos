package cmcm.com.myapplication;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

public class qq
{
  public static void a(Context paramContext, String paramString, Throwable paramThrowable)
  {
    int i = 0;
    a(paramString, paramThrowable);
    if ((paramContext != null) && (paramThrowable != null))
    {
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      paramThrowable = paramThrowable.getMessage();
      paramString = paramThrowable;
      if (paramThrowable == null)
        paramString = "null";
      localHashMap.put("msg", Base64.encodeToString(paramString.getBytes(), 2));
      localArrayList.add(localHashMap);
      int k = arrayOfStackTraceElement.length;
      int j = 0;
      while (j < k)
      {
        paramString = arrayOfStackTraceElement[j];
        paramThrowable = new HashMap();
        paramThrowable.put(String.valueOf(i), Base64.encodeToString(paramString.toString().getBytes(), 2));
        localArrayList.add(paramThrowable);
        j += 1;
        i += 1;
      }
      qf.a(paramContext, "E4", localArrayList);
    }
  }

  public static void a(String paramString)
  {
    a("[HOLA:D]", paramString);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (qj.a)
      Log.d(paramString1, paramString2);
  }

  public static void a(String paramString, Throwable paramThrowable)
  {
    String str1 = paramString;
    if (paramString == null)
      str1 = "[HOLA:E]";
    if (paramThrowable == null);
    for (paramString = "E.null"; ; paramString = paramThrowable.getMessage())
    {
      String str2 = paramString;
      if (paramString == null)
        str2 = "Unknown";
      d(str1, str2);
      paramThrowable.printStackTrace();
      return;
    }
  }

  public static void a(Throwable paramThrowable)
  {
    a(null, paramThrowable);
  }

  public static void b(String paramString)
  {
    c("[HOLA:W]", paramString);
  }

  public static void b(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }

  public static void c(String paramString)
  {
    d("[HOLA:E]", paramString);
  }

  public static void c(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null)
      str = "E";
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = "E";
    Log.e(str, paramString1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qq
 * JD-Core Version:    0.6.2
 */