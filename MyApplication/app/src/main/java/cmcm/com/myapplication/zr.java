package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import com.lazyswipe.SwipeApplication;

public class zr
{
  public static final int a = localResources.getDimensionPixelSize(2131296287) + n / 2 - asq.a(1.0F);
  public static final int b = a + (int)(n * 0.97D);
  public static final int c = b + (int)(n * 0.97D);
  public static final int d = c + (int)(n * 0.66D);
  public final boolean e;
  public final int f;
  public final int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public zq[] l;
  private float m;

  static
  {
    Resources localResources = SwipeApplication.c().getResources();
    int n = localResources.getDimensionPixelSize(2131296279) + localResources.getDimensionPixelSize(2131296286);
  }

  public zr(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.e = paramBoolean;
    b();
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 6:
    case 7:
    case 8:
      this.i = 0;
      this.h = a;
      return;
    case 0:
    case 1:
    case 2:
      this.i = 1;
      this.h = b;
      return;
    case 3:
    case 4:
    case 5:
    case 9:
    case 10:
      this.i = 2;
      this.h = c;
      return;
    case 11:
    case 12:
    }
    this.i = 3;
    this.h = d;
  }

  private void b()
  {
    a(this.g);
    this.l = zq.a(this.f, this.g);
    if ((this.l != null) && (this.l.length > 1))
    {
      this.m = ahy.a(this.l[0].b);
      this.m = ahy.a(this.e, this.m);
      double d1 = Math.toRadians(this.m);
      this.j = ((int)(this.h * Math.cos(d1)));
      double d2 = this.h;
      this.k = ((int)(Math.sin(d1) * d2));
    }
  }

  public float a()
  {
    return ahy.a(this.e, this.m);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zr
 * JD-Core Version:    0.6.2
 */