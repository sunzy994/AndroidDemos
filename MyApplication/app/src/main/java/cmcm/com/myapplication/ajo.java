package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;

public class ajo extends yw
  implements alh
{
  public static boolean a;
  private static final String b = "Swipe." + ajo.class.getSimpleName();
  private final Context c = SwipeApplication.c();
  private boolean i = true;

  public static boolean a(Context paramContext)
  {
    return false;
  }

  private void u()
  {
    Object localObject = yb.getInstance();
    if ((localObject == null) || (!((yb)localObject).isShown()) || (((yb)localObject).f()));
    do
    {
      return;
      localObject = ((yb)localObject).getItemLayer();
    }
    while (localObject == null);
    ((xu)localObject).getTab().g();
    ((xu)localObject).getTab().a((SwipeApplication)this.c.getApplicationContext());
    ((xu)localObject).a(true);
  }

  public CharSequence a()
  {
    return this.c.getString(2131231171);
  }

  public Drawable c(Context paramContext)
  {
    return this.c.getResources().getDrawable(2130903040);
  }

  public boolean c()
  {
    return false;
  }

  public boolean d(Context paramContext)
  {
    yb.a(this.h, this);
    return false;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public void g()
  {
    if (!this.i)
    {
      this.i = true;
      return;
    }
    if (s() != null);
    u();
    this.i = true;
  }

  public int h(Context paramContext)
  {
    return -32768;
  }

  public boolean m()
  {
    return true;
  }

  public int q()
  {
    return 2130837848;
  }

  public ajl s()
  {
    return ajl.a(this.c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajo
 * JD-Core Version:    0.6.2
 */