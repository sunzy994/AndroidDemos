package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class asj
{
  private static boolean a = false;
  private static boolean b = false;
  private static Set<String> c;
  private static Thread d;
  private static final Object e = new Object();

  public static void a()
  {
    synchronized (e)
    {
      b = true;
      a = false;
      d = null;
      return;
    }
  }

  public static void a(long paramLong)
  {
    synchronized (e)
    {
      if (!a)
      {
        b = false;
        d = new Thread(new ask(paramLong));
        d.start();
      }
      return;
    }
  }

  public static boolean a(Context paramContext, String paramString)
  {
    if (c == null)
      c = vs.P(paramContext);
    return c.contains(paramString);
  }

  public static boolean b()
  {
    return a;
  }

  private static String[] b(List<PackageInfo> paramList, Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)paramList.next();
      try
      {
        String str = localPackageInfo.packageName;
        if ((!TextUtils.isEmpty(str)) && (!a(paramContext, str)) && (localPackageInfo.applicationInfo.flags >= 10000) && (!localArrayList2.contains(str)))
          localArrayList1.add(str);
      }
      catch (Exception localException)
      {
      }
    }
    return (String[])localArrayList1.toArray(new String[localArrayList1.size()]);
  }

  private static void c(long paramLong)
  {
    synchronized (e)
    {
      d = null;
      b = false;
      a = false;
      aoc.b(paramLong);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asj
 * JD-Core Version:    0.6.2
 */