package cmcm.com.myapplication;

import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.lazyswipe.widget.GridGallery;

public class avo
  implements Runnable
{
  private final Scroller b;
  private int c;

  public avo(final GridGallery paramGridGallery)
  {
    this.b = new Scroller(paramGridGallery.getContext(), new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    });
  }

  private void c()
  {
    ez.a(this.a, this);
  }

  public void a()
  {
    this.b.abortAnimation();
    this.a.a();
    this.a.removeCallbacks(this);
  }

  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.b.abortAnimation();
    this.a.removeCallbacks(this);
    if (paramInt2 == 0)
    {
      this.a.a();
      return;
    }
    this.c = paramInt1;
    int i;
    if (paramFloat == 0.0F)
    {
      i = 500;
      i = Math.min(500, i);
      if (!GridGallery.d(this.a))
        break label105;
      this.b.startScroll(paramInt1, 0, paramInt2, 0, i);
    }
    while (true)
    {
      c();
      return;
      i = (int)(this.a.getWidth() * 2000 / Math.abs(paramFloat));
      break;
      label105: this.b.startScroll(0, paramInt1, 0, paramInt2, i);
    }
  }

  public boolean b()
  {
    return this.b.isFinished();
  }

  public void run()
  {
    if (this.b.computeScrollOffset())
    {
      if (GridGallery.d(this.a));
      for (int i = this.b.getCurrX(); ; i = this.b.getCurrY())
      {
        int j = this.c;
        this.c = i;
        GridGallery.b(this.a, i - j);
        c();
        return;
      }
    }
    this.a.a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avo
 * JD-Core Version:    0.6.2
 */