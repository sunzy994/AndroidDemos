package cmcm.com.myapplication;

import android.os.SystemClock;
import android.view.View;
import com.lazyswipe.widget.listview.DragSortListView;

public class axe
  implements Runnable
{
  private boolean b;
  private long c;
  private long d;
  private int e;
  private float f;
  private long g;
  private int h;
  private float i;
  private boolean j = false;

  public axe(DragSortListView paramDragSortListView)
  {
  }

  public void a(int paramInt)
  {
    if (!this.j)
    {
      this.b = false;
      this.j = true;
      this.g = SystemClock.uptimeMillis();
      this.c = this.g;
      this.h = paramInt;
      this.a.post(this);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.removeCallbacks(this);
      this.j = false;
      return;
    }
    this.b = true;
  }

  public boolean a()
  {
    return this.j;
  }

  public int b()
  {
    if (this.j)
      return this.h;
    return -1;
  }

  public void run()
  {
    if (this.b)
    {
      this.j = false;
      return;
    }
    int m = this.a.getFirstVisiblePosition();
    int k = this.a.getLastVisiblePosition();
    int i1 = this.a.getCount();
    int n = this.a.getPaddingTop();
    int i2 = this.a.getHeight() - n - this.a.getPaddingBottom();
    int i3 = Math.min(DragSortListView.i(this.a), DragSortListView.u(this.a) + DragSortListView.g(this.a));
    int i4 = Math.max(DragSortListView.i(this.a), DragSortListView.u(this.a) - DragSortListView.g(this.a));
    View localView;
    if (this.h == 0)
    {
      localView = this.a.getChildAt(0);
      if (localView == null)
      {
        this.j = false;
        return;
      }
      if ((m == 0) && (localView.getTop() == n))
      {
        this.j = false;
        return;
      }
      this.i = DragSortListView.x(this.a).a((DragSortListView.v(this.a) - i4) / DragSortListView.w(this.a), this.c);
      this.d = SystemClock.uptimeMillis();
      this.f = ((float)(this.d - this.c));
      this.e = Math.round(this.i * this.f);
      if (this.e < 0)
        break label468;
      this.e = Math.min(i2, this.e);
      k = m;
    }
    while (true)
    {
      localView = this.a.getChildAt(k - m);
      i1 = localView.getTop() + this.e;
      m = i1;
      if (k == 0)
      {
        m = i1;
        if (i1 > n)
          m = n;
      }
      DragSortListView.b(this.a, true);
      this.a.setSelectionFromTop(k, m - n);
      this.a.layoutChildren();
      this.a.invalidate();
      DragSortListView.b(this.a, false);
      DragSortListView.c(this.a, k, localView, false);
      this.c = this.d;
      this.a.post(this);
      return;
      localView = this.a.getChildAt(k - m);
      if (localView == null)
      {
        this.j = false;
        return;
      }
      if ((k == i1 - 1) && (localView.getBottom() <= i2 + n))
      {
        this.j = false;
        return;
      }
      this.i = (-DragSortListView.x(this.a).a((i3 - DragSortListView.y(this.a)) / DragSortListView.z(this.a), this.c));
      break;
      label468: this.e = Math.max(-i2, this.e);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axe
 * JD-Core Version:    0.6.2
 */