package cmcm.com.myapplication;

import java.lang.reflect.Method;

public class ms
{
  private String[] a;
  private long b;

  public ms(String[] paramArrayOfString, long paramLong)
  {
    this.a = paramArrayOfString;
    this.b = paramLong;
  }

  static Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
    }
    return null;
  }

  static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
    }
    return null;
  }

  static Method a(String paramString1, String paramString2, Class[] paramArrayOfClass)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
    }
    return null;
  }

  public final String[] a()
  {
    return this.a;
  }

  public final long b()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ms
 * JD-Core Version:    0.6.2
 */