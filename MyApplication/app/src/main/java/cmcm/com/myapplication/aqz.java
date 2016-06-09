package cmcm.com.myapplication;

import java.util.Arrays;

public class aqz
{
  public static int[] a(int[] paramArrayOfInt)
  {
    if (!b(paramArrayOfInt))
      return null;
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInt[paramArrayOfInt[i]] = i;
      i += 1;
    }
    return arrayOfInt;
  }

  public static boolean b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return false;
    if (paramArrayOfInt.length == 0)
      return true;
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    Arrays.fill(arrayOfInt, 0);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label67;
      int k = paramArrayOfInt[i];
      if ((k < 0) || (k >= paramArrayOfInt.length))
        break;
      arrayOfInt[k] += 1;
      i += 1;
    }
    label67: j = arrayOfInt.length;
    i = 0;
    while (true)
    {
      if (i >= j)
        break label91;
      if (arrayOfInt[i] != 1)
        break;
      i += 1;
    }
    label91: return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqz
 * JD-Core Version:    0.6.2
 */