package cmcm.com.myapplication;

import android.animation.ValueAnimator;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.SectorArea;
import com.lazyswipe.fan.hetero.iwatch.WatchItemSector;

public class zu
  implements GestureDetector.OnGestureListener
{
  public zu(WatchItemSector paramWatchItemSector)
  {
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    WatchItemSector.a(this.a, false);
    this.a.n = true;
    this.a.o = this.a.k;
    if (WatchItemSector.f(this.a) != null)
      WatchItemSector.f(this.a).cancel();
    WatchItemSector.a(this.a, WatchItemSector.a(this.a, paramMotionEvent));
    WatchItemSector.b(this.a, WatchItemSector.g(this.a));
    this.a.m = false;
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    WatchItemSector.a(this.a, true);
    return false;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
      return true;
    float f1 = paramMotionEvent1.getX();
    float f2 = paramMotionEvent1.getY();
    float f3 = paramMotionEvent2.getX();
    float f4 = paramMotionEvent2.getY();
    return this.a.a(f1, f2, f3, f4, paramFloat1, paramFloat2);
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    int k = 0;
    View localView = SectorArea.a(this.a, paramMotionEvent);
    if ((localView != null) && ((localView instanceof FanItem)))
    {
      this.a.onClick(localView);
      return true;
    }
    int j = WatchItemSector.h(this.a).getTabSectorOuterSize();
    int m = WatchItemSector.i(this.a).getTabSectorInnerSize();
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    if (this.a.c);
    for (int i = 0; ; i = this.a.getWidth())
    {
      int i2 = this.a.getHeight();
      i = (n - i) * (n - i) + (i1 - i2) * (i1 - i2);
      if ((i <= j * j) && (i >= m * m))
        break;
      WatchItemSector.k(this.a).onClick(WatchItemSector.j(this.a));
      return true;
    }
    if (this.a.c)
    {
      i = (int)Math.abs(asq.a(this.a.getHeight(), 0.0D, i1, n));
      label203: if (((i >= 25) && (i <= 65)) || (this.a.k) || (this.a.m))
        break label357;
      j = k;
      if (i > 65)
      {
        j = k;
        if (i <= 90)
          j = 1;
      }
      this.a.j();
      WatchItemSector.c(this.a, ahy.d(WatchItemSector.l(this.a)));
      if (j == 0)
        break label359;
    }
    label357: label359: for (float f = ((int)WatchItemSector.l(this.a) / 90 - 1) * 90; ; f = ((int)WatchItemSector.l(this.a) / 90 + 1) * 90)
    {
      WatchItemSector.a(this.a, true, f);
      return true;
      i = 180 - (int)Math.abs(asq.a(this.a.getHeight(), this.a.getWidth(), i1, n));
      break label203;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zu
 * JD-Core Version:    0.6.2
 */