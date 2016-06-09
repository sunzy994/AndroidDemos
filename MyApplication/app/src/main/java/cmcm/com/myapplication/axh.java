package cmcm.com.myapplication;

import android.graphics.Point;
import android.view.View;
import com.lazyswipe.widget.listview.DragSortListView;

public class axh extends axq
{
  private int d;
  private int e;
  private float f;
  private float g;

  public axh(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }

  private int e()
  {
    int i = this.a.getFirstVisiblePosition();
    int j = (DragSortListView.l(this.a) + this.a.getDividerHeight()) / 2;
    View localView = this.a.getChildAt(this.d - i);
    if (localView != null)
    {
      if (this.d == this.e)
        return localView.getTop();
      if (this.d < this.e)
        return localView.getTop() - j;
      return localView.getBottom() + j - DragSortListView.m(this.a);
    }
    d();
    return -1;
  }

  public void a()
  {
    this.d = DragSortListView.j(this.a);
    this.e = DragSortListView.k(this.a);
    DragSortListView.b(this.a, 2);
    this.f = (DragSortListView.h(this.a).y - e());
    this.g = (DragSortListView.h(this.a).x - this.a.getPaddingLeft());
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    int i = e();
    int j = this.a.getPaddingLeft();
    paramFloat1 = DragSortListView.h(this.a).y - i;
    float f1 = DragSortListView.h(this.a).x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.f)) || (paramFloat2 < Math.abs(f1 / this.g)))
    {
      DragSortListView.h(this.a).y = (i + (int)(this.f * paramFloat2));
      DragSortListView.h(this.a).x = (this.a.getPaddingLeft() + (int)(this.g * paramFloat2));
      DragSortListView.a(this.a, true);
    }
  }

  public void b()
  {
    DragSortListView.n(this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axh
 * JD-Core Version:    0.6.2
 */