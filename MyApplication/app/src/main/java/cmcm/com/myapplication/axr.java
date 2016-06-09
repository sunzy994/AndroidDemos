package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;

public class axr
  implements axj
{
  private Bitmap a;
  private ImageView b;
  private int c = -16777216;
  private ListView d;

  public axr(ListView paramListView)
  {
    this.d = paramListView;
  }

  public void a(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.a.recycle();
    this.a = null;
  }

  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
  }

  public View d(int paramInt)
  {
    View localView = this.d.getChildAt(this.d.getHeaderViewsCount() + paramInt - this.d.getFirstVisiblePosition());
    if (localView == null)
      return null;
    localView.setPressed(false);
    localView.setDrawingCacheEnabled(true);
    this.a = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    if (this.b == null)
      this.b = new ImageView(this.d.getContext());
    this.b.setBackgroundColor(this.c);
    this.b.setPadding(0, 0, 0, 0);
    this.b.setImageBitmap(this.a);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(localView.getWidth(), localView.getHeight()));
    return this.b;
  }

  public void e(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axr
 * JD-Core Version:    0.6.2
 */