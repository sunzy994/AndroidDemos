package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import com.lazyswipe.fan.FanItem;

public class zf extends yw
  implements ant
{
  private final Context a;
  private final ans b;

  public zf(Context paramContext, ans paramans)
  {
    this.a = paramContext;
    this.b = paramans;
    this.b.a(this);
  }

  public static ShapeDrawable a(Context paramContext, int paramInt)
  {
    return atw.a(paramInt, paramContext.getResources().getDimensionPixelSize(2131296397));
  }

  public Drawable a(boolean paramBoolean)
  {
    ahw localahw = ahx.b(this.a);
    if (paramBoolean)
      return localahw.c(this.a);
    return localahw.b(this.a);
  }

  public Drawable c(Context paramContext)
  {
    return ahx.b(this.a).a(this.a, this.b);
  }

  public boolean d(Context paramContext)
  {
    if ((this.b instanceof ani));
    for (ani.a += 1; ; ani.a = 0)
    {
      vy.a(this.b.c());
      return this.b.i();
    }
  }

  public boolean e(Context paramContext)
  {
    if (this.b.a_(paramContext))
    {
      if (!(this.b instanceof ams))
        aso.a(paramContext, this.b.d());
      this.b.k(paramContext);
      return true;
    }
    return false;
  }

  public int f(Context paramContext)
  {
    int i = super.f(paramContext);
    if (this.b.a(0))
      return i;
    return Color.argb(127, Color.red(i), Color.green(i), Color.blue(i));
  }

  public String g()
  {
    return this.b.g();
  }

  public boolean g(Context paramContext)
  {
    return this.b.x();
  }

  public Drawable h()
  {
    return a(this.b.a(0));
  }

  public void k()
  {
    super.k();
    if ((this.h != null) && (this.b.w()))
      this.h.a();
  }

  public boolean r()
  {
    return !this.b.h();
  }

  public void s()
  {
    k();
  }

  public String t()
  {
    return this.b.b();
  }

  public void u()
  {
    this.b.u_();
  }

  public void v()
  {
    this.b.v_();
  }

  public ans w()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zf
 * JD-Core Version:    0.6.2
 */