package cmcm.com.myapplication;

import java.lang.reflect.Method;

public class or
{
  private static Class a;

  private static Object a(String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    int i = 0;
    if (!a())
      return null;
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null)
    {
      paramArrayOfClass = new Class[paramArrayOfObject.length];
      int k = paramArrayOfObject.length;
      int j = 0;
      while (true)
      {
        arrayOfClass = paramArrayOfClass;
        if (i >= k)
          break;
        paramArrayOfClass[j] = paramArrayOfObject[i].getClass();
        j += 1;
        i += 1;
      }
    }
    try
    {
      paramString = a.getMethod(paramString, arrayOfClass).invoke(null, paramArrayOfObject);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }

  public static void a(String paramString1, String paramString2)
  {
    a("d", new Object[] { paramString1, paramString2 }, new Class[] { String.class, String.class });
  }

  public static void a(Throwable paramThrowable)
  {
    a("e", new Object[] { paramThrowable }, new Class[] { Throwable.class });
  }

  private static boolean a()
  {
    try
    {
      if (a == null)
        a = Class.forName("qq");
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     or
 * JD-Core Version:    0.6.2
 */