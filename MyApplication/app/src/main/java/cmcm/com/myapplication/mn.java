package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.URI;

public class mn
{
  private static mt a = mt.a;
  private static mn b;
  private String c;
  private Context d;

  private mn(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      this.c = this.d.getPackageManager().getApplicationInfo(this.d.getPackageName(), 128).metaData.getString("app_license");
      if (TextUtils.isEmpty(this.c))
        throw new IllegalArgumentException("license should not null");
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      ob.a(paramContext);
    }
  }

  public static String a()
  {
    return null;
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null))
      if (mv.a())
        mv.c("ToolboxManager", "Params error.");
    Object localObject;
    oa localoa;
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          localObject = paramIntent.getAction();
          if ("android.intent.action.PACKAGE_ADDED".equals(localObject))
            break;
        }
        while (!mv.a());
        mv.c("ToolboxManager", "Not ACTION_PACKAGE_ADDED: " + (String) localObject);
        return;
        bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (mv.a())
          mv.c("ToolboxManager", "ACTION_PACKAGE_ADDED, replaceing? " + bool);
      }
      while (bool);
      paramIntent = URI.create(paramIntent.getDataString()).getSchemeSpecificPart();
      localObject = nb.a(paramContext).d(paramIntent);
      if (localObject != null)
      {
        mv.c("ToolboxManager", "TiggerPreParse:packageName:" + paramIntent + ";id=" + ((oa) localObject).b() + ";preParse=" + ((oa) localObject).j());
        if (((oa)localObject).j() == 1)
        {
          ((oa)localObject).a(true);
          new ns(paramContext).c((oa)localObject, ((oa)localObject).h());
        }
      }
      localObject = nb.a(paramContext);
      localoa = ((nb)localObject).b(paramIntent);
      if (localoa != null)
        break;
    }
    while (!mv.a());
    mv.c("ToolboxManager", "Non-click item, skip.");
    return;
    nr.f(paramContext, localoa);
    ((nb)localObject).c(paramIntent);
  }

  public static void a(Context paramContext, String paramString)
  {
    nm.a(paramContext).a(paramString);
    try
    {
      if (b == null)
        b = new mn(paramContext.getApplicationContext());
      return;
    }
    finally
    {
    }
    throw paramContext;
  }

  public static mn c()
  {
    if (b == null)
      throw new IllegalStateException("Please call init first.");
    return b;
  }

  public static boolean d()
  {
    return a == mt.a;
  }

  public final String b()
  {
    return this.c;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mn
 * JD-Core Version:    0.6.2
 */