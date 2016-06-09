package cmcm.com.myapplication;

import android.os.SystemClock;
import com.lazyswipe.widget.listview.DragSortListView;

public class axq
  implements Runnable
{
  private float a;
  protected long b;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i;

  public axq(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.d = paramFloat;
    this.a = paramInt;
    paramFloat = 1.0F / (this.d * 2.0F * (1.0F - this.d));
    this.h = paramFloat;
    this.e = paramFloat;
    this.f = (this.d / ((this.d - 1.0F) * 2.0F));
    this.g = (1.0F / (1.0F - this.d));
  }

  public float a(float paramFloat)
  {
    if (paramFloat < this.d)
      return this.e * paramFloat * paramFloat;
    if (paramFloat < 1.0F - this.d)
      return this.f + this.g * paramFloat;
    return 1.0F - this.h * (paramFloat - 1.0F) * (paramFloat - 1.0F);
  }

  public void a()
  {
  }

  public void a(float paramFloat1, float paramFloat2)
  {
  }

  public void b()
  {
  }

  public void c()
  {
    this.b = SystemClock.uptimeMillis();
    this.i = false;
    a();
    this.c.post(this);
  }

  public void d()
  {
    this.i = true;
  }

  public void run()
  {
    if (this.i)
      return;
    float f1 = (float)(SystemClock.uptimeMillis() - this.b) / this.a;
    if (f1 >= 1.0F)
    {
      a(1.0F, 1.0F);
      b();
      return;
    }
    a(f1, a(f1));
    this.c.post(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axq
 * JD-Core Version:    0.6.2
 */