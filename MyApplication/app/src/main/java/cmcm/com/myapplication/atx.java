package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class atx
{
  private static atx f;
  private final apd a;
  private final Application b;
  private final PackageManager c;
  private final HashMap<ComponentName, apd> d = new HashMap(18);
  private final int e;
  private Drawable g;
  private Drawable h;
  private Drawable i;

  private atx(Application paramApplication)
  {
    ActivityManager localActivityManager = (ActivityManager)paramApplication.getSystemService("activity");
    this.b = paramApplication;
    this.c = paramApplication.getPackageManager();
    this.e = localActivityManager.getLauncherLargeIconDensity();
    this.a = g();
  }

  private Drawable a(ActivityInfo paramActivityInfo)
  {
    try
    {
      Resources localResources = this.c.getResourcesForApplication(paramActivityInfo.applicationInfo);
      if (localResources != null)
      {
        int j = paramActivityInfo.getIconResource();
        if (j != 0)
          return a(localResources, j);
      }
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Object localObject = null;
    }
    return f();
  }

  private Drawable a(ResolveInfo paramResolveInfo)
  {
    return a(paramResolveInfo.activityInfo);
  }

  @TargetApi(15)
  private Drawable a(Resources paramResources, int paramInt)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 15)
        paramResources = paramResources.getDrawableForDensity(paramInt, this.e);
      else
        paramResources = paramResources.getDrawable(paramInt);
    }
    catch (NotFoundException paramResources)
    {
      paramResources = null;
    }
    while (paramResources == null)
      return f();
    return paramResources;
  }

  private apd a(ComponentName paramComponentName, ResolveInfo paramResolveInfo, boolean paramBoolean)
  {
    if (paramResolveInfo == null);
    for (ComponentName localComponentName = paramComponentName; ; localComponentName = asq.a(paramResolveInfo))
    {
      apd localapd = (apd)this.d.get(localComponentName);
      Object localObject = localapd;
      if (localapd == null)
      {
        paramComponentName = aid.a(this.b, paramComponentName, paramResolveInfo);
        localObject = paramComponentName;
        if (!paramBoolean)
        {
          this.d.put(localComponentName, paramComponentName);
          localObject = paramComponentName;
        }
      }
      return localObject;
    }
  }

  public static atx a()
  {
    if (f == null)
      f = new atx(SwipeApplication.c());
    return f;
  }

  private Drawable b(ComponentName paramComponentName)
  {
    return b(paramComponentName, false);
  }

  private Drawable b(ComponentName paramComponentName, boolean paramBoolean)
  {
    if (paramComponentName == null);
    do
    {
      do
      {
        return null;
        Object localObject1 = SwipeApplication.c().a().a(paramComponentName);
        if ((localObject1 != null) && (((wk)localObject1).j != null))
          try
          {
            localObject1 = this.c.getActivityInfo(new ComponentName(((wk)localObject1).i.getPackageName(), ((wk)localObject1).j), 0).loadIcon(this.c);
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
          }
        Object localObject2 = asq.a(paramComponentName);
        localObject2 = this.b.getPackageManager().resolveActivity((Intent)localObject2, 0);
        if (localObject2 != null)
          return a((ResolveInfo)localObject2);
      }
      while (paramBoolean);
      paramComponentName = asq.b(this.b, paramComponentName);
    }
    while (paramComponentName == null);
    return b(paramComponentName, true);
  }

  private Drawable f()
  {
    return this.b.getResources().getDrawable(2130903040);
  }

  private apd g()
  {
    Drawable localDrawable = f();
    Bitmap localBitmap = Bitmap.createBitmap(Math.max(localDrawable.getIntrinsicWidth(), 1), Math.max(localDrawable.getIntrinsicHeight(), 1), Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localDrawable.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    localDrawable.draw(localCanvas);
    localCanvas.setBitmap(null);
    return new apd(localBitmap);
  }

  public Bitmap a(ComponentName paramComponentName, ResolveInfo paramResolveInfo)
  {
    if (paramResolveInfo != null);
    for (paramComponentName = a(paramResolveInfo); ; paramComponentName = b(paramComponentName))
      return atw.a(paramComponentName, this.b);
  }

  public apd a(ComponentName paramComponentName)
  {
    return a(paramComponentName, false);
  }

  // ERROR //
  public apd a(ComponentName arg1, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	atx:d	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_3
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokespecial 268	atx:a	(Landroid/content/ComponentName;Landroid/content/pm/ResolveInfo;Z)Lapd;
    //   22: astore_1
    //   23: aload_3
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: astore_1
    //   28: aload_3
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	13	27	finally
    //   15	25	27	finally
    //   28	30	27	finally
  }

  public void b()
  {
    synchronized (this.d)
    {
      Object localObject1 = new ArrayList(this.d.values());
      this.d.clear();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
        atw.a(((apd)((Iterator)localObject1).next()).a());
    }
    this.h = null;
    this.g = null;
    this.i = null;
  }

  public Drawable c()
  {
    if (!atw.c(this.g))
      this.g = ahx.b(this.b).F();
    return this.g;
  }

  public Drawable d()
  {
    if (!atw.c(this.h))
      this.h = ahx.b(this.b).H();
    return this.h;
  }

  public Drawable e()
  {
    if (!atw.c(this.i))
      this.i = ahx.b(this.b).G();
    return this.i;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atx
 * JD-Core Version:    0.6.2
 */