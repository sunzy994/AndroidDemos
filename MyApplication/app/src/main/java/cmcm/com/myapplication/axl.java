package cmcm.com.myapplication;

import com.lazyswipe.widget.listview.DragSortListView;

public class axl extends axq
{
  private float d;
  private float e;

  public void a()
  {
    this.d = DragSortListView.f(this.a);
    this.e = DragSortListView.g(this.a);
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (DragSortListView.b(this.a) != 4)
    {
      d();
      return;
    }
    DragSortListView.a(this.a, (int)(this.e * paramFloat2 + (1.0F - paramFloat2) * this.d));
    DragSortListView.h(this.a).y = (DragSortListView.i(this.a) - DragSortListView.f(this.a));
    DragSortListView.a(this.a, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axl
 * JD-Core Version:    0.6.2
 */