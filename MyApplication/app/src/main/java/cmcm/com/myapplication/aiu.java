package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.theme.preview.ThemesActivity;
import java.util.Calendar;

public class aiu extends yw
  implements alh
{
  static final String a = "Swipe." + aiw.class.getSimpleName();
  private final Context b;

  public aiu(Context paramContext)
  {
    this.b = paramContext;
  }

  public static void a(Context paramContext)
  {
    if (!arl.g(paramContext));
    ahw localahw;
    do
    {
      long l;
      do
      {
        do
        {
          return;
          l = vs.b();
        }
        while ((l > 0L) && (Math.abs(l - System.currentTimeMillis()) < 43200000L));
        l = vs.a(paramContext, "_preload_time", -1L);
      }
      while ((System.currentTimeMillis() - l < 86400000L) || (Calendar.getInstance().after(aiv.b())) || (b(paramContext)));
      localahw = ahx.a(paramContext, "");
    }
    while (!(localahw instanceof ahr));
    vs.b(paramContext, "_preload_time", System.currentTimeMillis());
    ((ahr)localahw).D();
  }

  static boolean b(Context paramContext)
  {
    return ahx.a(paramContext, "").e();
  }

  public static boolean i(Context paramContext)
  {
    return (vs.c(paramContext, "_need_shuffle", true)) && (b(paramContext));
  }

  public static void j(Context paramContext)
  {
    vs.b(paramContext, "_need_shuffle", false);
  }

  public static void k(Context paramContext)
  {
    vs.b(paramContext, "_applied", true);
  }

  public static boolean s()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (asq.r(localSwipeApplication));
    Calendar localCalendar;
    do
    {
      do
        return false;
      while ((!vs.c(localSwipeApplication, "_show_tip", false)) || (vs.c(localSwipeApplication, "_applied", false)) || (vs.c(localSwipeApplication, "_dismiss_icon", false)));
      localCalendar = Calendar.getInstance();
    }
    while ((localCalendar.before(aiv.a())) || (localCalendar.after(aiv.b())) || ((!b(localSwipeApplication)) && (!arl.h(localSwipeApplication))));
    return true;
  }

  public CharSequence a()
  {
    return this.b.getString(2131231081);
  }

  public Drawable c(Context paramContext)
  {
    return this.b.getResources().getDrawable(2130837845);
  }

  public boolean d(Context paramContext)
  {
    g();
    paramContext = new Intent(this.b, ThemesActivity.class);
    asq.d(this.b, paramContext);
    return true;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public void g()
  {
    vs.b(this.b, "_dismiss_icon", true);
  }

  public String p()
  {
    return "";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aiu
 * JD-Core Version:    0.6.2
 */