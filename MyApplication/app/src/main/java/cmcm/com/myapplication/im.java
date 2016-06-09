package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class im
{
  private static final ip b = new in();
  private Object a;

  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new iq();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      b = new io();
      return;
    }
  }

  public im(Context paramContext)
  {
    this.a = b.a(paramContext);
  }

  public void a(int paramInt1, int paramInt2)
  {
    b.a(this.a, paramInt1, paramInt2);
  }

  public boolean a()
  {
    return b.a(this.a);
  }

  public boolean a(float paramFloat)
  {
    return b.a(this.a, paramFloat);
  }

  public boolean a(int paramInt)
  {
    return b.a(this.a, paramInt);
  }

  public boolean a(Canvas paramCanvas)
  {
    return b.a(this.a, paramCanvas);
  }

  public void b()
  {
    b.b(this.a);
  }

  public boolean c()
  {
    return b.c(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     im
 * JD-Core Version:    0.6.2
 */