package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.Collator;
import java.util.Comparator;
import java.util.Iterator;

public class wk
{
  public static final Comparator<wk> p = new Comparator()
  {
    public final int a(wk paramAnonymouswk1, wk paramAnonymouswk2)
    {
      return asq.a.compare(paramAnonymouswk1.b, paramAnonymouswk2.b);
    }
  };
  public long a = -1L;
  public CharSequence b;
  public WeakReference<Drawable> c;
  public long d = -1L;
  public long e = -1L;
  public int f = 0;
  public boolean g;
  public apd h;
  public ComponentName i;
  public String j;
  public int k;
  public boolean l;
  public int m;
  public boolean n;
  public int o;

  public wk()
  {
  }

  public wk(PackageManager paramPackageManager, ResolveInfo paramResolveInfo)
  {
    this(paramPackageManager, paramResolveInfo, true);
  }

  public wk(PackageManager paramPackageManager, ResolveInfo paramResolveInfo, boolean paramBoolean)
  {
    this.i = asq.a(paramResolveInfo);
    this.j = asq.b(paramResolveInfo);
    a(paramPackageManager, paramResolveInfo, paramBoolean);
  }

  public wk(Cursor paramCursor, xh paramxh)
  {
    a(paramCursor, paramxh);
  }

  public static void a(Iterable<wk> paramIterable, String paramString)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
      if (((wk)paramIterable.next()).i.getPackageName().equals(paramString))
        paramIterable.remove();
  }

  public Intent a(Context paramContext)
  {
    Intent localIntent;
    if (this.l)
    {
      localIntent = new Intent();
      if (this.j == null)
        break label113;
      localIntent.setClassName(this.i.getPackageName(), this.j);
    }
    while (true)
    {
      if (!this.l)
        localIntent.setFlags(270532608);
      boolean bool = asq.d(paramContext, localIntent);
      if (!bool)
      {
        paramContext = "Failed to launch app: " + localIntent.getComponent().toString();
        aqx.a(asp.a("launch_failure_", 1, true), paramContext);
      }
      if (!bool)
        break label125;
      return localIntent;
      localIntent = asq.c();
      break;
      label113: localIntent.setComponent(this.i);
    }
    label125: return null;
  }

  public Drawable a(PackageManager paramPackageManager)
  {
    return b(paramPackageManager, false);
  }

  public void a(ContentValues paramContentValues)
  {
    paramContentValues.put("intent", this.i.flattenToString());
    paramContentValues.put("last_called_time", Long.valueOf(this.e));
    paramContentValues.put("called_num", Integer.valueOf(this.f));
    paramContentValues.put("alias", this.j);
    paramContentValues.put("package", this.i.getPackageName());
    paramContentValues.put("on_sdcard", Integer.valueOf(this.k));
    paramContentValues.put("label", this.b.toString());
    if (this.g);
    for (int i1 = 1; ; i1 = 0)
    {
      paramContentValues.put("is_system", Integer.valueOf(i1));
      paramContentValues.put("updated", Long.valueOf(this.d));
      paramContentValues.put("custom_tab_pos", Integer.valueOf(this.o));
      return;
    }
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext.getPackageManager(), paramBoolean);
  }

  public void a(PackageManager paramPackageManager, ActivityInfo paramActivityInfo)
  {
    this.b = paramActivityInfo.loadLabel(paramPackageManager);
    if (!(this.b instanceof String))
    {
      asp.b("Swipe.AppInfo", "Non-String label: " + this.b + ", " + this.b.getClass().getSimpleName());
      this.b = this.b.toString();
    }
  }

  public void a(PackageManager paramPackageManager, ActivityInfo paramActivityInfo, boolean paramBoolean)
  {
    int i1 = 1;
    a(paramPackageManager, paramActivityInfo);
    if (paramBoolean)
    {
      this.h = null;
      this.c = null;
    }
    paramPackageManager = paramActivityInfo.applicationInfo;
    this.d = new File(paramPackageManager.sourceDir).lastModified();
    if ((paramPackageManager.flags & 0x1) != 0)
    {
      paramBoolean = true;
      this.g = paramBoolean;
      if ((paramPackageManager.flags & 0x40000) == 0)
        break label85;
    }
    while (true)
    {
      this.k = i1;
      return;
      paramBoolean = false;
      break;
      label85: i1 = 0;
    }
  }

  public void a(PackageManager paramPackageManager, ResolveInfo paramResolveInfo)
  {
    a(paramPackageManager, paramResolveInfo, true);
  }

  public void a(PackageManager paramPackageManager, ResolveInfo paramResolveInfo, boolean paramBoolean)
  {
    a(paramPackageManager, paramResolveInfo.activityInfo, paramBoolean);
  }

  public void a(PackageManager paramPackageManager, boolean paramBoolean)
  {
    try
    {
      a(paramPackageManager, paramPackageManager.getActivityInfo(this.i, 0), paramBoolean);
      return;
    }
    catch (Throwable paramPackageManager)
    {
    }
  }

  public void a(Cursor paramCursor, xh paramxh)
  {
    boolean bool = true;
    this.a = paramCursor.getInt(paramxh.a);
    this.i = ComponentName.unflattenFromString(paramCursor.getString(paramxh.b));
    this.e = paramCursor.getLong(paramxh.c);
    this.f = paramCursor.getInt(paramxh.d);
    this.k = paramCursor.getInt(paramxh.f);
    this.b = paramCursor.getString(paramxh.i);
    if (paramCursor.getInt(paramxh.j) == 1);
    while (true)
    {
      this.g = bool;
      this.d = paramCursor.getLong(paramxh.k);
      this.o = paramCursor.getInt(paramxh.l);
      return;
      bool = false;
    }
  }

  public boolean a()
  {
    return this.f >= 2147483547;
  }

  public Drawable b(PackageManager paramPackageManager, boolean paramBoolean)
  {
    if (this.c == null);
    for (Drawable localDrawable = null; localDrawable != null; localDrawable = (Drawable)this.c.get())
      return localDrawable;
    Object localObject2;
    if (this.j != null)
      localObject2 = new ComponentName(this.i.getPackageName(), this.j);
    while (true)
    {
      localObject2 = paramPackageManager.getActivityInfo((ComponentName)localObject2, 0);
      if (!paramBoolean);
      try
      {
        if (!ahy.d(SwipeApplication.c()));
        for (paramPackageManager = ((ActivityInfo)localObject2).loadIcon(paramPackageManager); ; paramPackageManager = ahy.a(SwipeApplication.c(), paramPackageManager))
        {
          try
          {
            this.c = new WeakReference(paramPackageManager);
            return paramPackageManager;
          }
          catch (Throwable localThrowable1)
          {
          }
          asp.b("Swipe.AppInfo", "Failed to load icon: " + localThrowable1.getMessage());
          return paramPackageManager;
          localObject2 = this.i;
          break;
          paramPackageManager = ((ActivityInfo)localObject2).loadIcon(paramPackageManager);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
        {
          paramPackageManager = localThrowable1;
          Object localObject1 = localThrowable2;
        }
      }
    }
  }

  public boolean b()
  {
    return this.f > 2147483547;
  }

  public String toString()
  {
    return "AppInfo[id:" + this.a + ", label:" + this.b + ", system: " + this.g + ", called: " + this.f + ", component: " + this.i + ", alias: " + this.j + ", installed on sdcard? " + this.k + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wk
 * JD-Core Version:    0.6.2
 */