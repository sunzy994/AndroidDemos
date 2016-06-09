package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.lang.ref.WeakReference;

public class yy extends yw
  implements alh
{
  private final Context a;
  private wk b;

  public yy(Context paramContext)
  {
    this.a = paramContext;
    Object localObject = vs.a(paramContext).getString("key_notification_apps_selected", null);
    try
    {
      localObject = ((String)localObject).split(",");
      this.b = ((SwipeApplication)paramContext.getApplicationContext()).a().a(localObject[0]);
      if ((this.b.c == null) || (this.b.c.get() == null))
        this.b.a(paramContext.getPackageManager());
      return;
    }
    catch (Exception paramContext)
    {
      this.b = null;
    }
  }

  public static boolean t()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (asq.r(localSwipeApplication));
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      localSharedPreferences = vs.a(localSwipeApplication);
    }
    while ((amk.b(localSwipeApplication)) || (localSharedPreferences.getBoolean("key_recent_notification_service_hint", false)) || (localSharedPreferences.getInt("key_tutorial_step", 0) > 100) || (TextUtils.isEmpty(localSharedPreferences.getString("key_notification_apps_selected", null))) || (alo.d(localSwipeApplication)));
    return true;
  }

  public CharSequence a()
  {
    return this.a.getText(2131231159);
  }

  public Drawable c(Context paramContext)
  {
    if (this.b.c == null)
      paramContext = null;
    while (true)
    {
      Object localObject = paramContext;
      if (paramContext == null);
      try
      {
        localObject = this.b.a(this.a.getPackageManager());
        return localObject;
        paramContext = (Drawable)this.b.c.get();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    return paramContext;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d(Context paramContext)
  {
    amk.b(this.a, true);
    vs.b(paramContext, System.currentTimeMillis());
    vs.e(paramContext, 98);
    if (yb.getInstance() != null)
      yb.getInstance().c();
    vy.a(paramContext, "B11");
    return false;
  }

  public boolean e(Context paramContext)
  {
    return true;
  }

  public String f()
  {
    if (this.b != null)
      return this.b.i.getPackageName();
    return null;
  }

  public void g()
  {
    vs.a(this.a).edit().putBoolean("key_recent_notification_service_hint", true).apply();
  }

  public boolean m()
  {
    return false;
  }

  public String p()
  {
    return "";
  }

  public boolean s()
  {
    return this.b != null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yy
 * JD-Core Version:    0.6.2
 */