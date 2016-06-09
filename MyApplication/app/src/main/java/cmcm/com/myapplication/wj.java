package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.allapps.AllAppsActivity;
import com.lazyswipe.ui.MainActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class wj
{
  private final HashSet<ComponentName> a = new HashSet();
  private final HashSet<ComponentName> b = new HashSet();
  private final HashSet<ComponentName> c = new HashSet();
  private final HashSet<String> d = new HashSet();
  private final HashSet<String> e = new HashSet();
  private final Context f;

  public wj(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
    b(paramContext);
    c(paramContext);
    d(paramContext);
    e(paramContext);
  }

  public static wj a()
  {
    return SwipeApplication.c().a().a;
  }

  private void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    paramString = paramContext.queryIntentActivities(asq.b(paramString), 65536);
    if (paramString == null);
    while (true)
    {
      return;
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ResolveInfo)localIterator.next();
        if (((ResolveInfo)localObject).activityInfo != null)
        {
          this.c.add(asq.a((ResolveInfo)localObject));
          localObject = paramContext.queryIntentActivities(asq.a(((ResolveInfo)localObject).activityInfo.packageName), 0).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
            if (localResolveInfo != null)
              this.c.add(asq.a(localResolveInfo));
          }
        }
      }
      paramString.clear();
      paramContext = this.c.iterator();
      while (paramContext.hasNext())
      {
        paramString = (ComponentName)paramContext.next();
        this.e.add(paramString.getPackageName());
      }
    }
  }

  private void b(Context paramContext)
  {
    this.d.clear();
    this.d.add("com.android.browser");
    this.d.add("com.UCMobile.intl");
    this.d.add("com.explore.web.browser");
    this.d.add("org.mozilla.firefox");
    this.d.add("com.apusapps.browser");
    this.d.add("com.opera.mini.native");
    this.d.add("com.baidu.browser.inter");
    this.d.add("com.ksmobile.cb");
    this.d.add("mobi.mgeek.TunnyBrowser");
    this.d.add("com.android.chrome");
    this.d.add("com.uc.browser.en");
    this.d.add("com.opera.browser");
    this.d.add("explore.web.browser");
    this.d.add("com.dolphin.browser.express.web");
    this.d.add("com.uc.browser.hd");
    this.d.add("com.mx.browser");
    this.d.add("android.task.browser");
  }

  private void c(Context paramContext)
  {
    a(paramContext, null);
  }

  private void d(Context paramContext)
  {
    this.a.addAll(a(paramContext));
  }

  private void e(Context paramContext)
  {
    this.b.add(new ComponentName(paramContext, MainActivity.class));
  }

  public ArrayList<ComponentName> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (adc.a())
      localArrayList.add(new ComponentName(paramContext, adc.class));
    localArrayList.add(new ComponentName(paramContext, "com.lazyswipe.features.ad.mobvista.PicksActivity"));
    localArrayList.add(new ComponentName(paramContext, AllAppsActivity.class));
    return localArrayList;
  }

  public void a(String paramString)
  {
    asq.a(this.c, paramString);
    asq.a(this.a, paramString);
    asq.a(this.b, paramString);
    this.e.remove(paramString);
  }

  public boolean a(ComponentName paramComponentName)
  {
    return (this.c.contains(paramComponentName)) || ((Build.VERSION.SDK_INT >= 21) && (this.e.contains(paramComponentName.getPackageName())));
  }

  public boolean a(ComponentName paramComponentName, String[] paramArrayOfString)
  {
    if (paramComponentName == null);
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            return false;
            str = paramComponentName.getClassName();
          }
          while (("com.lazyswipe.features.ad.mobvista.PicksActivity".equals(str)) || ("com.hola.channel.pub.GamesActivity".equals(str)));
          if (this.a.contains(paramComponentName))
            return true;
        }
        while ((this.b.contains(paramComponentName)) || (this.c.contains(paramComponentName)));
        paramComponentName = paramComponentName.getPackageName();
      }
      while ("com.lazyswipe".equals(paramComponentName));
      if (paramComponentName.equals("com.qiigame.flocker.global"))
        return true;
    }
    while ((paramComponentName.equals("com.lazyswipe.lock")) || (paramComponentName.equals("com.hola.screenlock")));
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (true)
      {
        if (i >= j)
          break label150;
        if (paramComponentName.equals(paramArrayOfString[i]))
          break;
        i += 1;
      }
    }
    label150: return true;
  }

  public List<String> b()
  {
    return new ArrayList(this.e);
  }

  public void b(String paramString)
  {
    asq.a(this.c, paramString);
    a(this.f, paramString);
  }

  public boolean c(String paramString)
  {
    return this.e.contains(paramString);
  }

  public boolean d(String paramString)
  {
    return this.d.contains(paramString);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wj
 * JD-Core Version:    0.6.2
 */