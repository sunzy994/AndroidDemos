package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.lazyswipe.widget.recyclerview.RecyclerView;

public abstract class ayw
{
  @Deprecated
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
  }

  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, azi paramazi)
  {
    a(paramCanvas, paramRecyclerView);
  }

  @Deprecated
  public void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    paramRect.set(0, 0, 0, 0);
  }

  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, azi paramazi)
  {
    a(paramRect, ((ayz)paramView.getLayoutParams()).c(), paramRecyclerView);
  }

  @Deprecated
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
  }

  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, azi paramazi)
  {
    b(paramCanvas, paramRecyclerView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayw
 * JD-Core Version:    0.6.2
 */