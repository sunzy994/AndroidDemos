package cmcm.com.myapplication;

import android.util.Log;
import android.view.animation.Interpolator;
import com.lazyswipe.widget.recyclerview.RecyclerView;

public class azh
{
  private int a;
  private int b;
  private int c;
  private Interpolator d;
  private boolean e = false;
  private int f = 0;

  public azh(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, -2147483648, null);
  }

  public azh(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInterpolator;
  }

  private void a()
  {
    if ((this.d != null) && (this.c < 1))
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    if (this.c < 1)
      throw new IllegalStateException("Scroll duration must be a positive number");
  }

  private void a(RecyclerView paramRecyclerView)
  {
    if (this.e)
    {
      a();
      if (this.d == null)
        if (this.c == -2147483648)
          RecyclerView.m(paramRecyclerView).b(this.a, this.b);
      while (true)
      {
        this.f += 1;
        if (this.f > 10)
          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        this.e = false;
        return;
        RecyclerView.m(paramRecyclerView).a(this.a, this.b, this.c);
        continue;
        RecyclerView.m(paramRecyclerView).a(this.a, this.b, this.c, this.d);
      }
    }
    this.f = 0;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInterpolator;
    this.e = true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azh
 * JD-Core Version:    0.6.2
 */