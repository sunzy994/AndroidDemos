package cmcm.com.myapplication;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

final class mh
  implements OnClickListener, OnTouchListener
{
  private boolean a;

  mh(mg parammg)
  {
  }

  public final void onClick(View paramView)
  {
    if (mg.a(this.b) != null)
      mg.a(this.b).a();
    if (this.a)
      mv.c("NativeAdIMWrapper", "No touch data recorded,please ensure touch events reach the ad View by returing false if you intercept the event.");
    if (mg.b(this.b) == null)
      mg.a(this.b, new ns(mg.c(this.b)));
    if (mg.d(this.b))
    {
      mg.b(this.b).a(new oa(mg.e(this.b)));
      mm.a().a(new mf(mg.c(this.b), true, mg.e(this.b)));
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (mg.f(this.b) != null))
    {
      mg.f(this.b).getWidth();
      mg.f(this.b).getHeight();
      Object localObject = new int[2];
      mg.f(this.b).getLocationInWindow((int[])localObject);
      localObject = new Rect();
      mg.f(this.b).getGlobalVisibleRect((Rect)localObject);
      ((Rect)localObject).width();
      ((Rect)localObject).height();
      paramView.getLocationInWindow(new int[2]);
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      this.a = true;
    }
    if (mg.g(this.b) != null)
      return mg.g(this.b).onTouch(paramView, paramMotionEvent);
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mh
 * JD-Core Version:    0.6.2
 */