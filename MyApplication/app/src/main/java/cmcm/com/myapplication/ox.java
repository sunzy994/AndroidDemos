package cmcm.com.myapplication;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class ox
{
  private static HashMap<String, Long> a = new HashMap();

  public static Class a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return paramClassLoader.loadClass(paramString);
  }

  public static ClassLoader a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, paramContext.getClassLoader());
  }

  public static ClassLoader a(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    ow.a("jarFile", paramString);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
      throw new FileNotFoundException("Loader jarFile " + paramString + " not exists");
    long l = System.currentTimeMillis();
    a.put(paramString, Long.valueOf(l));
    localObject = oz.b((File) localObject);
    paramContext = new File(paramContext.getDir("app_hola_dex_loader", 0), (String)localObject);
    localObject = paramContext.getAbsolutePath();
    if (!paramContext.exists())
      paramContext.mkdirs();
    ow.a("optDir", (String)localObject);
    paramContext = new DexClassLoader(paramString, (String)localObject, null, paramClassLoader);
    Log.w("Loader.getLoader.time", String.valueOf(System.currentTimeMillis() - l));
    return paramContext;
  }

  public static Object a(Class paramClass, String paramString)
  {
    return a(null, paramClass, paramString);
  }

  public static Object a(Class paramClass, String paramString, Object[] paramArrayOfObject)
  {
    return a(paramClass, paramString, paramArrayOfObject, null);
  }

  public static Object a(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    return a(null, paramClass, paramString, paramArrayOfObject, paramArrayOfClass);
  }

  public static Object a(Class paramClass, Object[] paramArrayOfObject)
  {
    return a(paramClass, paramArrayOfObject, null);
  }

  public static Object a(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null)
      arrayOfClass = a(paramArrayOfObject);
    return paramClass.getConstructor(arrayOfClass).newInstance(paramArrayOfObject);
  }

  public static Object a(ClassLoader paramClassLoader, Class paramClass, InvocationHandler paramInvocationHandler)
  {
    return a(paramClassLoader, new Class[] { paramClass }, paramInvocationHandler);
  }

  public static Object a(ClassLoader paramClassLoader, Class[] paramArrayOfClass, InvocationHandler paramInvocationHandler)
  {
    return Proxy.newProxyInstance(paramClassLoader, paramArrayOfClass, paramInvocationHandler);
  }

  public static Object a(Object paramObject, Class paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      paramClass = localField;
      boolean bool = paramClass.isAccessible();
      if (!bool)
        paramClass.setAccessible(true);
      paramObject = paramClass.get(paramObject);
      if (!bool)
        paramClass.setAccessible(false);
      return paramObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (true)
        paramClass = paramClass.getField(paramString);
    }
  }

  public static Object a(Object paramObject, Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null)
      arrayOfClass = a(paramArrayOfObject);
    return paramClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramArrayOfObject);
  }

  public static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, paramObject.getClass(), paramString);
  }

  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return a(paramObject, paramString, paramArrayOfObject, null);
  }

  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    return a(paramObject, paramObject.getClass(), paramString, paramArrayOfObject, paramArrayOfClass);
  }

  public static void a(ContextWrapper paramContextWrapper, ClassLoader paramClassLoader)
  {
    a(a(paramContextWrapper.getBaseContext(), "mPackageInfo"), "mClassLoader", paramClassLoader);
  }

  public static void a(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      paramClass = localField;
      boolean bool = paramClass.isAccessible();
      if (!bool)
        paramClass.setAccessible(true);
      paramClass.set(paramObject1, paramObject2);
      if (!bool)
        paramClass.setAccessible(false);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (true)
        paramClass = paramClass.getField(paramString);
    }
  }

  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    a(paramObject1, paramObject1.getClass(), paramString, paramObject2);
  }

  private static Class[] a(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    Class[] arrayOfClass = new Class[j];
    int i = 0;
    while (i < j)
    {
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
      i += 1;
    }
    return arrayOfClass;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ox
 * JD-Core Version:    0.6.2
 */