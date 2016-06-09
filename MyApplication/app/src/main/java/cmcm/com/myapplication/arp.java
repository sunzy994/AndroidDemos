package cmcm.com.myapplication;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class arp
{
  public static Class<?> a(Object paramObject, String paramString)
  {
    Object localObject = null;
    if (paramObject != null)
      paramObject = paramObject.getClass();
    do
    {
      do
      {
        return paramObject;
        paramObject = localObject;
      }
      while (paramString == null);
      paramObject = localObject;
    }
    while (paramString.length() <= 0);
    try
    {
      paramObject = Class.forName(paramString);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Log.w("Swipe.ReflectionUtils", "exception when getting class " + paramString + ": " + paramObject.getMessage());
    }
    return null;
  }

  // ERROR //
  public static Object a(Object paramObject, Field paramField)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 63	java/lang/reflect/Field:isAccessible	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifne +8 -> 14
    //   9: aload_1
    //   10: iconst_1
    //   11: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
    //   14: aload_1
    //   15: aload_0
    //   16: invokevirtual 71	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore_0
    //   20: iload_2
    //   21: ifne +8 -> 29
    //   24: aload_1
    //   25: iconst_0
    //   26: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
    //   29: aload_0
    //   30: areturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: ldc 26
    //   36: ldc 73
    //   38: aload_1
    //   39: invokestatic 76	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   42: pop
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: goto -12 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	31	java/lang/Throwable
    //   9	14	31	java/lang/Throwable
    //   14	20	31	java/lang/Throwable
    //   24	29	45	java/lang/Throwable
  }

  public static Object a(Object paramObject1, Field paramField, Object paramObject2)
  {
    try
    {
      boolean bool = paramField.isAccessible();
      if (!bool)
        paramField.setAccessible(true);
      paramField.set(paramObject1, paramObject2);
      if (!bool)
        paramField.setAccessible(false);
      return null;
    }
    catch (Throwable paramObject1)
    {
      Log.w("Swipe.ReflectionUtils", "exception", paramObject1);
    }
    return null;
  }

  // ERROR //
  public static Object a(Object paramObject, Method paramMethod)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 85	java/lang/reflect/Method:isAccessible	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifne +8 -> 14
    //   9: aload_1
    //   10: iconst_1
    //   11: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   14: aload_1
    //   15: aload_0
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_0
    //   24: iload_2
    //   25: ifne +8 -> 33
    //   28: aload_1
    //   29: iconst_0
    //   30: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   33: aload_0
    //   34: areturn
    //   35: astore_1
    //   36: aconst_null
    //   37: astore_0
    //   38: ldc 26
    //   40: ldc 73
    //   42: aload_1
    //   43: invokestatic 76	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   46: pop
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: goto -12 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	35	java/lang/Throwable
    //   9	14	35	java/lang/Throwable
    //   14	24	35	java/lang/Throwable
    //   28	33	49	java/lang/Throwable
  }

  // ERROR //
  public static Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 85	java/lang/reflect/Method:isAccessible	()Z
    //   4: istore_3
    //   5: iload_3
    //   6: ifne +8 -> 14
    //   9: aload_1
    //   10: iconst_1
    //   11: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   14: aload_1
    //   15: aload_0
    //   16: aload_2
    //   17: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore_0
    //   21: iload_3
    //   22: ifne +8 -> 30
    //   25: aload_1
    //   26: iconst_0
    //   27: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   30: aload_0
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_0
    //   35: ldc 26
    //   37: ldc 73
    //   39: aload_1
    //   40: invokestatic 76	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   43: pop
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: goto -12 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	32	java/lang/Throwable
    //   9	14	32	java/lang/Throwable
    //   14	21	32	java/lang/Throwable
    //   25	30	46	java/lang/Throwable
  }

  public static Method a(Class<?> paramClass, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() <= 0);
    }
    try
    {
      localObject1 = paramClass.getMethod(paramString, new Class[0]);
      return localObject1;
    }
    catch (Throwable paramClass)
    {
      Log.w("Swipe.ReflectionUtils", "exception when getting method " + paramString + ": " + paramClass.getMessage());
    }
    return null;
  }

  public static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() <= 0);
    }
    try
    {
      localObject1 = paramClass.getMethod(paramString, paramArrayOfClass);
      return localObject1;
    }
    catch (Throwable paramClass)
    {
      Log.w("Swipe.ReflectionUtils", "exception when getting method " + paramString + ": " + paramClass.getMessage());
    }
    return null;
  }

  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    a(paramObject1, c(paramObject1.getClass(), paramString), paramObject2);
  }

  public static Object b(Object paramObject, String paramString)
  {
    paramString = c(paramObject.getClass(), paramString);
    if (paramString == null)
      return null;
    return a(paramObject, paramString);
  }

  public static Field b(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getField(paramString);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      Log.w("Swipe.ReflectionUtils", "exception when getting field " + paramString + ": " + paramClass.getMessage());
    }
    return null;
  }

  public static Method b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramArrayOfClass != null);
      try
      {
        return paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
        paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);
        return paramClass;
      }
      catch (Throwable paramClass)
      {
        Log.w("Swipe.ReflectionUtils", "exception when getting method " + paramString + ": " + paramClass.getMessage());
      }
    }
    return null;
  }

  public static Object c(Object paramObject, String paramString)
  {
    return a(paramObject, c(paramObject.getClass(), paramString));
  }

  public static Field c(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      Log.w("Swipe.ReflectionUtils", "exception", paramClass);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arp
 * JD-Core Version:    0.6.2
 */