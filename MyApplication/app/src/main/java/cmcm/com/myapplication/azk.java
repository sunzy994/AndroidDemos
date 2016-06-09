package cmcm.com.myapplication;

import android.view.View;
import android.view.animation.Interpolator;
import com.lazyswipe.widget.recyclerview.RecyclerView;
import java.util.ArrayList;

public class azk
  implements Runnable
{
  private int b;
  private int c;
  private iu d;
  private Interpolator e = RecyclerView.s();
  private boolean f = false;
  private boolean g = false;

  public azk(RecyclerView paramRecyclerView)
  {
    this.d = iu.a(paramRecyclerView.getContext(), RecyclerView.s());
  }

  private float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }

  private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = Math.abs(paramInt1);
    int k = Math.abs(paramInt2);
    int i;
    if (j > k)
    {
      i = 1;
      paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i == 0)
        break label140;
    }
    label140: for (paramInt1 = this.a.getWidth(); ; paramInt1 = this.a.getHeight())
    {
      paramInt4 = paramInt1 / 2;
      float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
      float f1 = paramInt4;
      float f2 = paramInt4;
      f3 = a(f3);
      if (paramInt3 <= 0)
        break label151;
      paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / paramInt3)) * 4;
      return Math.min(paramInt1, 2000);
      i = 0;
      break;
    }
    label151: if (i != 0);
    for (paramInt2 = j; ; paramInt2 = k)
    {
      paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
      break;
    }
  }

  private void c()
  {
    this.g = false;
    this.f = true;
  }

  private void d()
  {
    this.f = false;
    if (this.g)
      a();
  }

  void a()
  {
    if (this.f)
    {
      this.g = true;
      return;
    }
    ez.a(this.a, this);
  }

  public void a(int paramInt1, int paramInt2)
  {
    RecyclerView.b(this.a, 2);
    this.c = 0;
    this.b = 0;
    this.d.a(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    a();
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, RecyclerView.s());
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, b(paramInt1, paramInt2, paramInt3, paramInt4));
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.e != paramInterpolator)
    {
      this.e = paramInterpolator;
      this.d = iu.a(this.a.getContext(), paramInterpolator);
    }
    RecyclerView.b(this.a, 2);
    this.c = 0;
    this.b = 0;
    this.d.a(0, 0, paramInt1, paramInt2, paramInt3);
    a();
  }

  public void b()
  {
    this.a.removeCallbacks(this);
    this.d.h();
  }

  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }

  public void run()
  {
    c();
    RecyclerView.e(this.a);
    iu localiu = this.d;
    azg localazg = RecyclerView.d(this.a).j;
    int i4;
    int i5;
    int i6;
    int i7;
    int n;
    int m;
    int i1;
    int j;
    int i;
    int k;
    int i2;
    if (localiu.g())
    {
      i4 = localiu.b();
      i5 = localiu.c();
      i6 = i4 - this.b;
      i7 = i5 - this.c;
      n = 0;
      i3 = 0;
      m = 0;
      i1 = 0;
      this.b = i4;
      this.c = i5;
      j = 0;
      i = 0;
      k = 0;
      i2 = 0;
      if (RecyclerView.f(this.a) != null)
      {
        this.a.f();
        RecyclerView.b(this.a, true);
        j = i3;
        if (i6 != 0)
        {
          j = RecyclerView.d(this.a).a(i6, this.a.b, this.a.g);
          i = i6 - j;
        }
        k = i2;
        m = i1;
        if (i7 != 0)
        {
          m = RecyclerView.d(this.a).b(i7, this.a.b, this.a.g);
          k = i7 - m;
        }
        if (RecyclerView.g(this.a))
        {
          i1 = this.a.d.b();
          n = 0;
          if (n < i1)
          {
            View localView = this.a.d.b(n);
            Object localObject = this.a.a(localView);
            if ((localObject != null) && (((azl)localObject).i != null))
              if (((azl)localObject).i == null)
                break label367;
            label367: for (localObject = ((azl)localObject).i.b; ; localObject = null)
            {
              if (localObject != null)
              {
                i2 = localView.getLeft();
                i3 = localView.getTop();
                if ((i2 != ((View)localObject).getLeft()) || (i3 != ((View)localObject).getTop()))
                  ((View)localObject).layout(i2, i3, ((View)localObject).getWidth() + i2, ((View)localObject).getHeight() + i3);
              }
              n += 1;
              break;
            }
          }
        }
        if ((localazg != null) && (!localazg.g()) && (localazg.h()))
        {
          n = this.a.g.e();
          if (n != 0)
            break label722;
          localazg.f();
        }
        RecyclerView.b(this.a, false);
        this.a.b(false);
        n = j;
        j = i;
      }
      if ((i6 != n) || (i7 != m))
        break label773;
      i1 = 1;
      label453: if (!RecyclerView.h(this.a).isEmpty())
        this.a.invalidate();
      if (ez.a(this.a) != 2)
        RecyclerView.a(this.a, i6, i7);
      if ((j != 0) || (k != 0))
      {
        i2 = (int)localiu.f();
        if (j == i4)
          break label825;
        if (j >= 0)
          break label779;
        i = -i2;
      }
    }
    label529: label550: label825: for (int i3 = i; ; i3 = 0)
    {
      if (k != i5)
        if (k < 0)
          i = -i2;
      while (true)
      {
        if (ez.a(this.a) != 2)
          this.a.d(i3, i);
        if (((i3 != 0) || (j == i4) || (localiu.d() == 0)) && ((i != 0) || (k == i5) || (localiu.e() == 0)))
          localiu.h();
        if ((n != 0) || (m != 0))
        {
          RecyclerView.a(this.a, 0, 0, 0, 0);
          if (RecyclerView.i(this.a) != null)
            RecyclerView.i(this.a).a(this.a, n, m);
        }
        if (!RecyclerView.j(this.a))
          this.a.invalidate();
        if ((localiu.a()) || (i1 == 0))
          RecyclerView.b(this.a, 0);
        while (true)
        {
          if ((localazg != null) && (localazg.g()))
            azg.a(localazg, 0, 0);
          d();
          return;
          label722: if (localazg.i() >= n)
          {
            localazg.d(n - 1);
            azg.a(localazg, i6 - i, i7 - k);
            break;
          }
          azg.a(localazg, i6 - i, i7 - k);
          break;
          i1 = 0;
          break label453;
          if (j > 0)
          {
            i = i2;
            break label529;
          }
          i = 0;
          break label529;
          i = i2;
          if (k > 0)
            break label550;
          i = 0;
          break label550;
          a();
        }
        i = 0;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azk
 * JD-Core Version:    0.6.2
 */