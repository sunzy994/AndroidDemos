package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class xr
{
  private final Context a;
  private final PackageManager b;
  private final HashMap<ComponentName, Bitmap> c = new HashMap(18);
  private Bitmap d;
  private Bitmap e;

  private xr(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getPackageManager();
  }

  private Bitmap c(ComponentName paramComponentName)
  {
    Object localObject1 = (Bitmap)this.c.get(paramComponentName);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = xp.a(this.a).b(paramComponentName);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = xp.a(this.a).a(paramComponentName);
        Log.d("Swipe.cache.IconLoader", "Icon for " + paramComponentName + " saved into icon fs cache " + localObject1);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        this.c.put(paramComponentName, localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }

  public void a()
  {
    Object localObject = new ArrayList(this.c.values());
    this.c.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
      atw.a((Bitmap)((Iterator)localObject).next());
    atw.a(this.e);
    this.e = null;
    atw.a(this.d);
    this.d = null;
  }

  public boolean a(ComponentName paramComponentName)
  {
    return (paramComponentName != null) && (this.c.containsKey(paramComponentName));
  }

  public Bitmap b()
  {
    if (this.e == null)
      this.e = atw.b(this.a, atw.a(this.a));
    return this.e;
  }

  public Bitmap b(ComponentName paramComponentName)
  {
    if (paramComponentName == null)
      return null;
    return c(paramComponentName);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xr
 * JD-Core Version:    0.6.2
 */