package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.List;

public class amu extends amo
{
  private static final String[][] b = { { "com.android.calculator2", "com.android.calculator2.Calculator" }, { "com.sec.android.app.popupcalculator", "com.sec.android.app.popupcalculator.Calculator" } };

  public amu(Context paramContext)
  {
    super(paramContext);
  }

  public static Intent f(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 15)
    {
      localIntent.addCategory("android.intent.category.APP_CALCULATOR");
      localObject1 = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext())
          break;
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      }
      while ((localObject2 == null) || (((ResolveInfo)localObject2).activityInfo == null) || ("android".equals(((ResolveInfo)localObject2).activityInfo.packageName)));
    }
    for (Object localObject1 = ((ResolveInfo)localObject2).activityInfo; ; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localIntent.setClassName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name);
        return localIntent;
        localObject1 = paramContext.getPackageManager();
        localObject2 = b;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          localIntent.setClassName(localObject3[0], localObject3[1]);
          if (((PackageManager)localObject1).resolveActivity(localIntent, 0) != null)
            return localIntent;
          i += 1;
        }
      }
      localObject1 = paramContext.getPackageManager().getInstalledPackages(0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PackageInfo)((Iterator)localObject1).next();
        if (((PackageInfo)localObject2).packageName.toLowerCase().contains("calcul"))
        {
          localObject2 = asq.h(paramContext, ((PackageInfo) localObject2).packageName);
          if (localObject2 != null)
          {
            localIntent.setComponent((ComponentName)localObject2);
            return localIntent;
          }
        }
      }
      return null;
    }
  }

  public static String g(Context paramContext)
  {
    paramContext = f(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.getComponent();
      if (paramContext != null)
        return paramContext.getPackageName();
    }
    return null;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837819;
  }

  public String b()
  {
    return "Calculator";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_calculator";
  }

  public int c()
  {
    return 26;
  }

  protected void s_()
  {
    this.a = f(this.e);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amu
 * JD-Core Version:    0.6.2
 */