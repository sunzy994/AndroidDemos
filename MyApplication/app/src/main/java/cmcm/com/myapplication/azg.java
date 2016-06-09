package cmcm.com.myapplication;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import com.lazyswipe.widget.recyclerview.RecyclerView;

public abstract class azg
{
  private int a = -1;
  private RecyclerView b;
  private ayy c;
  private boolean d;
  private boolean e;
  private View f;
  private final azh g = new azh(0, 0);

  private void a(int paramInt1, int paramInt2)
  {
    if ((!this.e) || (this.a == -1))
      f();
    this.d = false;
    if (this.f != null)
    {
      if (a(this.f) != this.a)
        break label116;
      a(this.f, this.b.g, this.g);
      azh.a(this.g, this.b);
      f();
    }
    while (true)
    {
      if (this.e)
      {
        a(paramInt1, paramInt2, this.b.g, this.g);
        azh.a(this.g, this.b);
      }
      return;
      label116: Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
      this.f = null;
    }
  }

  public int a(View paramView)
  {
    return this.b.c(paramView);
  }

  protected abstract void a(int paramInt1, int paramInt2, azi paramazi, azh paramazh);

  protected void a(PointF paramPointF)
  {
    double d1 = Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    paramPointF.x = ((float)(paramPointF.x / d1));
    paramPointF.y = ((float)(paramPointF.y / d1));
  }

  protected abstract void a(View paramView, azi paramazi, azh paramazh);

  void a(RecyclerView paramRecyclerView, ayy paramayy)
  {
    this.b = paramRecyclerView;
    this.c = paramayy;
    if (this.a == -1)
      throw new IllegalArgumentException("Invalid target position");
    azi.c(this.b.g, this.a);
    this.e = true;
    this.d = true;
    this.f = e(i());
    b();
    RecyclerView.m(this.b).a();
  }

  protected abstract void b();

  protected void b(View paramView)
  {
    if (a(paramView) == i())
      this.f = paramView;
  }

  protected abstract void c();

  public void d(int paramInt)
  {
    this.a = paramInt;
  }

  public View e(int paramInt)
  {
    return RecyclerView.d(this.b).b(paramInt);
  }

  public ayy e()
  {
    return this.c;
  }

  protected final void f()
  {
    if (!this.e)
      return;
    c();
    azi.c(this.b.g, -1);
    this.f = null;
    this.a = -1;
    this.d = false;
    this.e = false;
    ayy.a(this.c, this);
    this.c = null;
    this.b = null;
  }

  public void f(int paramInt)
  {
    this.b.a(paramInt);
  }

  public boolean g()
  {
    return this.d;
  }

  public boolean h()
  {
    return this.e;
  }

  public int i()
  {
    return this.a;
  }

  public int j()
  {
    return RecyclerView.d(this.b).k();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azg
 * JD-Core Version:    0.6.2
 */