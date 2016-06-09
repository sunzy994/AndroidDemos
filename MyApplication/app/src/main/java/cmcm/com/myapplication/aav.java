package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class aav
{
  public static int a()
  {
    if (abd.k == null)
      return 2;
    return abd.k.u.getInt("layout", 2);
  }

  public static int a(Context paramContext)
  {
    if (abd.k == null);
    int i;
    do
    {
      return -1;
      i = vs.t(paramContext);
      paramContext = abd.k.u.getIntArray("card1");
      if ((paramContext != null) && (Arrays.binarySearch(paramContext, i) >= 0))
        return 9;
      paramContext = abd.k.u.getIntArray("card2");
    }
    while ((paramContext == null) || (Arrays.binarySearch(paramContext, i) < 0));
    return 10;
  }

  public static void a(Context paramContext, int paramInt)
  {
    if (abd.k == null);
    aau localaau;
    do
    {
      return;
      localaau = (aau) abd.k.v.get(paramInt);
    }
    while ((localaau == null) || (localaau.a <= 0));
    localaau.a = 0;
    localaau.d = 0L;
    vs.a(paramContext).edit().remove("key_ad_vendor_failure_record_" + paramInt).apply();
  }

  public static boolean a(int paramInt)
  {
    aau localaau = (aau) abd.k.v.get(paramInt);
    if ((localaau != null) && (localaau.a > 0))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localaau.d;
      long l3 = localaau.c;
      long l4 = localaau.a;
      if (l1 - l2 <= Math.min(l3, localaau.b * l4))
        return true;
    }
    return false;
  }

  public static int b(int paramInt)
  {
    if (abd.k == null)
      return 0;
    return abd.k.t.get(paramInt, 0);
  }

  public static void b(Context paramContext, int paramInt)
  {
    if (abd.k == null);
    aau localaau;
    do
    {
      return;
      localaau = (aau) abd.k.v.get(paramInt);
    }
    while (localaau == null);
    localaau.a += 1;
    localaau.d = System.currentTimeMillis();
    HashSet localHashSet = new HashSet(2);
    localHashSet.add(String.valueOf(localaau.a));
    localHashSet.add(String.valueOf(localaau.d));
    vs.a(paramContext).edit().putStringSet("key_ad_vendor_failure_record_" + paramInt, localHashSet).apply();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aav
 * JD-Core Version:    0.6.2
 */