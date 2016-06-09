package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.lazyswipe.fan.hetero.iwatch.WatchFanItem;

public class zs extends yf
{
  public zs(WatchFanItem paramWatchFanItem)
  {
    super(paramWatchFanItem);
  }

  protected void b()
  {
    if (WatchFanItem.d(this.b) == null)
    {
      Bitmap localBitmap = atp.f(this.b.getContext());
      Rect localRect = this.b.getIconRect();
      WatchFanItem localWatchFanItem = this.b;
      int i = localRect.left;
      int j = (localRect.width() - localBitmap.getWidth()) / 2;
      int k = localRect.top;
      int m = (localRect.height() - localBitmap.getHeight()) / 2;
      int n = localRect.left;
      int i1 = (localRect.width() + localBitmap.getWidth()) / 2;
      int i2 = localRect.top;
      int i3 = localRect.height();
      WatchFanItem.a(localWatchFanItem, new Rect(i + j, k + m, n + i1, (localBitmap.getHeight() + i3) / 2 + i2));
    }
  }

  protected void b(Canvas paramCanvas)
  {
    if (!(WatchFanItem.a(this.b) instanceof zw))
      super.b(paramCanvas);
    Bitmap localBitmap;
    do
    {
      return;
      if (WatchFanItem.b(this.b))
        b();
      localBitmap = atp.f(this.b.getContext());
    }
    while ((!WatchFanItem.c(this.b)) || (!atw.b(localBitmap)));
    paramCanvas.drawBitmap(localBitmap, null, WatchFanItem.d(this.b), WatchFanItem.e(this.b));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zs
 * JD-Core Version:    0.6.2
 */