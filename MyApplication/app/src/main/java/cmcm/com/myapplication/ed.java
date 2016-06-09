package cmcm.com.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

class ed
{
  private static Field a;
  private static boolean b;

  static void a(LayoutInflater paramLayoutInflater, Factory2 paramFactory2)
  {
    if (!b);
    try
    {
      a = LayoutInflater.class.getDeclaredField("mFactory2");
      a.setAccessible(true);
      b = true;
      if (a == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        a.set(paramLayoutInflater, paramFactory2);
        return;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", localNoSuchFieldException);
      }
      catch (IllegalAccessException paramFactory2)
      {
        Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + paramLayoutInflater + "; inflation may have unexpected results.", paramFactory2);
      }
    }
  }

  static void a(LayoutInflater paramLayoutInflater, eg parameg)
  {
    if (parameg != null);
    for (parameg = new ee(parameg); ; parameg = null)
    {
      paramLayoutInflater.setFactory2(parameg);
      Factory localFactory = paramLayoutInflater.getFactory();
      if (!(localFactory instanceof Factory2))
        break;
      a(paramLayoutInflater, (Factory2)localFactory);
      return;
    }
    a(paramLayoutInflater, parameg);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ed
 * JD-Core Version:    0.6.2
 */