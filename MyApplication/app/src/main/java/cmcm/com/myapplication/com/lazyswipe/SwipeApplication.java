package cmcm.com.myapplication.com.lazyswipe;

import abf;
import agi;
import ahw;
import ahx;
import aie;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import aqe;
import aqq;
import aqx;
import ard;
import arh;
import arl;
import asp;
import asq;
import com.baidu.android.procmo.ProcessMonitor;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import jl;
import org.json.JSONObject;
import vg;
import vi;
import vs;
import vv;
import vw;
import vy;
import wd;
import wm;

public class SwipeApplication extends Application
{
  public static JSONObject a;
  private static final Object b = new Object();
  private static SwipeApplication c;
  private wm d;

  public static SwipeApplication c()
  {
    return c;
  }

  private void d()
  {
    int i = vs.a(this, "key_last_version_code", 0);
    if (22500 != i)
    {
      vs.b(this, "key_last_version_code", 22500);
      if ((i > 0) && (i < 2112))
        vs.b(this, "key_is_version_pre_2112", true);
      Log.i("Swipe.Application", "Swipe upgraded from " + i + " to " + 22500);
      aqe.a(this);
    }
  }

  public wm a()
  {
    return a(true);
  }

  public wm a(boolean paramBoolean)
  {
    synchronized (b)
    {
      if ((this.d == null) && (paramBoolean))
        this.d = new wm(this);
      return this.d;
    }
  }

  public void b()
  {
    Object localObject2 = getPackageManager();
    String str = "";
    Object localObject3 = asq.c("http://www.google.com/m");
    ResolveInfo localResolveInfo = ((PackageManager)localObject2).resolveActivity((Intent)localObject3, 0);
    Object localObject1 = str;
    if (localResolveInfo != null)
    {
      localObject1 = str;
      if (localResolveInfo.activityInfo != null)
      {
        localObject1 = str;
        if (localResolveInfo.activityInfo.packageName.equals("android"))
        {
          localObject1 = str;
          if (localResolveInfo.activityInfo.name.equals("com.android.internal.app.ResolverActivity"))
          {
            localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject3, 65536).iterator();
            do
            {
              localObject1 = str;
              if (!((Iterator)localObject2).hasNext())
                break;
              localObject1 = (ResolveInfo)((Iterator)localObject2).next();
            }
            while ((((ResolveInfo)localObject1).activityInfo.applicationInfo.flags & 0x1) == 0);
            localObject1 = ((ResolveInfo)localObject1).activityInfo.packageName + "/" + ((ResolveInfo)localObject1).activityInfo.name;
          }
        }
      }
    }
    localObject2 = new StringBuilder("http://www.lazyswipe.cn/uninstall.html");
    try
    {
      localObject3 = ((StringBuilder)localObject2).append("?lang=").append(URLEncoder.encode(asq.j())).append("&pid=").append("300105").append("&cid=").append("26100").append("&vn=").append("2.25").append("&vc=").append(22500).append("&b=").append(URLEncoder.encode(Build.BRAND)).append("&m=").append(URLEncoder.encode(Build.MODEL)).append("&d=").append(URLEncoder.encode(Build.DISPLAY)).append("&r=").append(VERSION.SDK_INT).append("&network=");
      if (arl.f(this))
        str = "wifi";
      while (true)
      {
        ((StringBuilder)localObject3).append(str).append("&uid=").append(URLEncoder.encode(vs.u(this))).append("&promoteChannel=").append(URLEncoder.encode(vy.f()));
        try
        {
          label335: new ProcessMonitor(this, arh.a("com.lazyswipe"), ((StringBuilder)localObject2).toString(), (String)localObject1, 0).a(10000L);
          return;
          str = "apn";
        }
        catch (Throwable localThrowable1)
        {
          asp.a("Swipe.Application", "Could not start process monitor", localThrowable1);
          return;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label335;
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    vg.b(this, paramConfiguration);
  }

  public void onCreate()
  {
    super.onCreate();
    c = this;
    vg.a(this);
    if ((!vg.i) && (!vg.j));
    while (true)
    {
      return;
      vw.a(this);
      Object localObject = vv.a();
      ((vv)localObject).a(5000L);
      ((vv)localObject).c(this);
      new vy().a(this);
      asp.a("Swipe.Application", vg.h + "; Product:" + "300105" + ", Vendor:" + "00" + ", Channel:" + "26100");
      vs.d(this);
      ard.a(this);
      try
      {
        localObject = getExternalFilesDir("log");
        ((File)localObject).mkdirs();
        asp.a(((File)localObject).getAbsolutePath(), true);
        label141: new vi(this, asp.a);
        aie.a(this).a();
        abf.b(this);
        ahx.b(this).y();
        jl.c("krdjtD9yK9ayjGzXx9VR3h");
        jl.b("LazySwipe");
        jl.a(this);
        if (vg.i)
        {
          vs.a();
          a();
          if (this.d == null)
            continue;
          this.d.d();
          return;
        }
        if (!vg.j)
          continue;
        vw.a(this, "appStarts");
        d();
        if (arl.h(this))
          wd.a(this);
        b();
        new aqq(this, "com.lazyswipe", PagerService.class.getName(), 3, false).a();
        agi.b(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label141;
      }
    }
  }

  public void onTerminate()
  {
    super.onTerminate();
    if (this.d != null)
      this.d.a(this);
  }

  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (1 == vs.c(this, 5))
      vv.a().a("onTrimMemory", "level", String.valueOf(paramInt));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.SwipeApplication
 * JD-Core Version:    0.6.2
 */