package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;

public class ld
{
  private Context a;
  private nq b;
  private lc c;
  private int d;
  private lg e;
  private View f;
  private np g = new np(this);

  public ld(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = paramInt1;
    this.e = ((lg) lf.a(paramContext.getApplicationContext()).a(this.d, paramInt2));
  }

  public void a(View paramView)
  {
    if (a())
    {
      if (this.f != null)
        b();
      this.f = paramView;
      this.b.a(paramView);
    }
  }

  public void a(lc paramlc)
  {
    this.c = paramlc;
  }

  public boolean a()
  {
    return this.b != null;
  }

  public void b()
  {
    if (a())
      this.b.f();
  }

  public void c()
  {
    if (!na.f(this.a))
    {
      this.g.a(lb.c);
      return;
    }
    this.e.a(null);
    this.e.a(this.g);
    this.e.a();
    na.g(this.a);
  }

  public void d()
  {
    if (a())
      this.b.g();
    this.e.a(null);
    this.e.b();
  }

  public String e()
  {
    if (a())
      return this.b.a();
    return null;
  }

  public String f()
  {
    if (a())
      return this.b.b();
    return null;
  }

  public String g()
  {
    if (a())
      return this.b.c();
    return null;
  }

  public String h()
  {
    if (a())
      return this.b.d();
    return null;
  }

  public String i()
  {
    if (a())
      return this.b.e();
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ld
 * JD-Core Version:    0.6.2
 */