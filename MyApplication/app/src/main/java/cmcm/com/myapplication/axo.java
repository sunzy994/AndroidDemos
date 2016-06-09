package cmcm.com.myapplication;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.lazyswipe.widget.listview.DragSortListView;

public class axo extends axq
{
  private float d;
  private float e;
  private float f;
  private int g = -1;
  private int h = -1;
  private int i;
  private int j;
  private int k;

  public axo(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }

  public void a()
  {
    int m = -1;
    this.g = -1;
    this.h = -1;
    this.i = DragSortListView.o(this.a);
    this.j = DragSortListView.p(this.a);
    this.k = DragSortListView.k(this.a);
    DragSortListView.b(this.a, 1);
    this.d = DragSortListView.h(this.a).x;
    if (DragSortListView.q(this.a))
    {
      float f1 = this.a.getWidth() * 2.0F;
      if (DragSortListView.r(this.a) == 0.0F)
      {
        DragSortListView localDragSortListView = this.a;
        if (this.d < 0.0F)
          DragSortListView.a(localDragSortListView, m * f1);
      }
      do
      {
        return;
        m = 1;
        break;
        f1 *= 2.0F;
        if ((DragSortListView.r(this.a) < 0.0F) && (DragSortListView.r(this.a) > -f1))
        {
          DragSortListView.a(this.a, -f1);
          return;
        }
      }
      while ((DragSortListView.r(this.a) <= 0.0F) || (DragSortListView.r(this.a) >= f1));
      DragSortListView.a(this.a, f1);
      return;
    }
    DragSortListView.s(this.a);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int n = this.a.getFirstVisiblePosition();
    View localView = this.a.getChildAt(this.i - n);
    if (DragSortListView.q(this.a))
    {
      paramFloat2 = (float)(SystemClock.uptimeMillis() - this.b) / 1000.0F;
      if (paramFloat2 != 0.0F);
    }
    do
    {
      do
      {
        return;
        float f1 = DragSortListView.r(this.a);
        int i1 = this.a.getWidth();
        localObject = this.a;
        float f2 = DragSortListView.r(this.a);
        if (DragSortListView.r(this.a) > 0.0F);
        for (m = 1; ; m = -1)
        {
          DragSortListView.a((DragSortListView)localObject, m * paramFloat2 * i1 + f2);
          this.d += f1 * paramFloat2;
          DragSortListView.h(this.a).x = ((int)this.d);
          if ((this.d >= i1) || (this.d <= -i1))
            break;
          this.b = SystemClock.uptimeMillis();
          DragSortListView.a(this.a, true);
          return;
        }
        if (localView != null)
        {
          if (this.g == -1)
          {
            this.g = DragSortListView.b(this.a, this.i, localView, false);
            this.e = (localView.getHeight() - this.g);
          }
          m = Math.max((int)(this.e * paramFloat1), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (m + this.g);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      while (this.j == this.i);
      localView = this.a.getChildAt(this.j - n);
    }
    while (localView == null);
    if (this.h == -1)
    {
      this.h = DragSortListView.b(this.a, this.j, localView, false);
      this.f = (localView.getHeight() - this.h);
    }
    int m = Math.max((int)(this.f * paramFloat1), 1);
    Object localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (m + this.h);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }

  public void b()
  {
    DragSortListView.t(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axo
 * JD-Core Version:    0.6.2
 */