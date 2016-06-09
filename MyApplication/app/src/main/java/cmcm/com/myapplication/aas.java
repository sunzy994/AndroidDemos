package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.lazyswipe.SettingsService;

public class aas
{
  public static long a(int paramInt)
  {
    return abd.k.q[(paramInt - 9)].getLong("gap3g");
  }

  public static long a(Context paramContext, int paramInt)
  {
    if (!aar.w)
      return abd.k.q[(paramInt - 9)].getLong("delay");
    return abd.k.u.getLong("delay");
  }

  static int[] a(Context paramContext)
  {
    int i = b(paramContext);
    Object localObject;
    if (!aar.w)
      localObject = abd.k.q[(i - 9)].getString("seq");
    try
    {
      while (true)
      {
        String[] arrayOfString = ((String)localObject).split(",");
        int[] arrayOfInt = new int[arrayOfString.length];
        i = 0;
        while (true)
        {
          localObject = arrayOfInt;
          if (i >= arrayOfString.length)
            break;
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i].trim());
          if (3 == arrayOfInt[i])
            paramContext.startService(new Intent(paramContext, SettingsService.class).putExtra("extra.START_LOCATING", true));
          i += 1;
        }
        localObject = abd.k.u.getString("seq");
      }
    }
    catch (Exception paramContext)
    {
      localObject = new int[0];
    }
    return localObject;
  }

  private static int b(Context paramContext)
  {
    int j = aav.a(paramContext);
    int i = j;
    if (j == -1)
      i = 9;
    return i;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aas
 * JD-Core Version:    0.6.2
 */