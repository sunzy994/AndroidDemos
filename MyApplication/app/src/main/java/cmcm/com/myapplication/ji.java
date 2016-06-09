package cmcm.com.myapplication;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class ji
{
  private static Field a;
  private static boolean b;
  private static Field c;
  private static boolean d;

  static int a(TextView paramTextView)
  {
    if (!d)
    {
      c = a("mMaxMode");
      d = true;
    }
    if ((c != null) && (a(c, paramTextView) == 1))
    {
      if (!b)
      {
        a = a("mMaximum");
        b = true;
      }
      if (a != null)
        return a(a, paramTextView);
    }
    return -1;
  }

  private static int a(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      Log.d("TextViewCompatDonut", "Could not retrieve value of " + paramField.getName() + " field.");
    }
    return -1;
  }

  private static Field a(String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.e("TextViewCompatDonut", "Could not retrieve " + paramString + " field.");
    }
    return localObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ji
 * JD-Core Version:    0.6.2
 */