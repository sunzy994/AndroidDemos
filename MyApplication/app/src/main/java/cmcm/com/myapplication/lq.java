package cmcm.com.myapplication;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.duapps.ad.a.a;

final class lq
  implements OnClickListener, OnTouchListener
{
  private boolean b;

  lq(lo paramlo)
  {
  }

  public final void onClick(View paramView)
  {
    if (lo.b(this.a) != null)
      lo.b(this.a).a();
    if (this.b)
      mv.c(lo.i(), "No touch data recorded,please ensure touch events reach the ad View by returing false if you intercept the event.");
    if (lo.c(this.a) == null)
      lo.a(this.a, new ns(lo.d(this.a)));
    if (lo.e(this.a))
    {
      paramView = lo.a(this.a).s;
      if ((paramView != null) && (paramView.length > 0))
      {
        int i = 0;
        while (i < paramView.length)
        {
          String str = paramView[i];
          mm.a().a(new lr(this, str));
          i += 1;
        }
      }
      lo.c(this.a).a(new oa(lo.a(this.a)));
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (lo.f(this.a) != null))
    {
      lo.f(this.a).getWidth();
      lo.f(this.a).getHeight();
      Object localObject = new int[2];
      lo.f(this.a).getLocationInWindow((int[])localObject);
      localObject = new Rect();
      lo.f(this.a).getGlobalVisibleRect((Rect)localObject);
      ((Rect)localObject).width();
      ((Rect)localObject).height();
      paramView.getLocationInWindow(new int[2]);
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      this.b = true;
    }
    if (lo.g(this.a) != null)
      return lo.g(this.a).onTouch(paramView, paramMotionEvent);
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lq
 * JD-Core Version:    0.6.2
 */