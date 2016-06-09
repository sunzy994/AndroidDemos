package cmcm.com.myapplication;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.FanLayer;
import com.lazyswipe.fan.ItemSector;
import com.lazyswipe.fan.SectorArea;

public class ym
  implements GestureDetector.OnGestureListener
{
  public ym(SectorArea paramSectorArea)
  {
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    SectorArea.a(this.a, false);
    this.a.q = true;
    this.a.r = this.a.m;
    this.a.f.getCurrentFanLayer().setLayerType(aqr.b, null);
    this.a.f.getNextFanLayer().setLayerType(aqr.b, null);
    this.a.f.getNextFanLayer().animate().cancel();
    this.a.f.getCurrentFanLayer().animate().cancel();
    this.a.f.getCurrentFanLayer().setRotation(0.0F);
    this.a.f.getNextFanLayer().setVisibility(4);
    this.a.p = false;
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    SectorArea.a(this.a, true);
    return false;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
      return true;
    float f1 = paramMotionEvent1.getRawX();
    float f2 = paramMotionEvent1.getRawY();
    float f3 = paramMotionEvent2.getRawX();
    float f4 = paramMotionEvent2.getRawY();
    return this.a.a(f1, f2, f3, f4, paramFloat1, paramFloat2);
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = SectorArea.a(this.a.f.getCurrentFanLayer(), paramMotionEvent);
    if ((paramMotionEvent != null) && ((paramMotionEvent instanceof FanItem)))
      this.a.f.getCurrentFanLayer().onClick(paramMotionEvent);
    while (true)
    {
      return true;
      this.a.d.onClick(this.a.d);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ym
 * JD-Core Version:    0.6.2
 */