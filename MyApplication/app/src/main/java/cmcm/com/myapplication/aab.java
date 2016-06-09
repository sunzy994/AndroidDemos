package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.notification.NotificationView;

public class aab
{
  public boolean a = false;
  public boolean b = false;
  private final NotificationView c;
  private final Point d = new Point();
  private final Point e = new Point();
  private Point f = new Point();
  private final Handler g = new Handler();
  private aac h;

  public aab(NotificationView paramNotificationView)
  {
    this.c = paramNotificationView;
  }

  public void a()
  {
    this.a = true;
    Context localContext = this.c.getContext();
    int j = localContext.getResources().getDimensionPixelSize(2131296335) >> 1;
    Point localPoint = this.d;
    if (vs.B(localContext));
    for (int i = j; ; i = aqs.ac() - j)
    {
      localPoint.x = i;
      this.e.y = (aqs.ad() - j);
      return;
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (this.h == null)
      this.h = new aac(this, paramInt2, paramInt1);
    while (true)
    {
      this.g.post(this.h);
      return;
      this.h.a(paramInt2, paramInt1);
    }
  }

  public void a(final AnimatorListener paramAnimatorListener)
  {
    this.c.setLayerType(2, null);
    this.c.animate().setDuration(270L).alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        aab.a(aab.this).setLayerType(0, null);
        paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
      }
    });
  }

  public void a(Canvas paramCanvas)
  {
  }

  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return;
    case 0:
    }
    this.a = false;
    this.b = false;
    this.d.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }

  public void a(FanItem paramFanItem)
  {
    Context localContext = this.c.getContext();
    if (paramFanItem != null)
    {
      Rect localRect = paramFanItem.getIconRect();
      int[] arrayOfInt = new int[2];
      paramFanItem.getLocationInWindow(arrayOfInt);
      if (localRect != null)
      {
        this.e.x = (arrayOfInt[0] + localRect.left + localRect.width() / 2);
        paramFanItem = this.e;
        i = arrayOfInt[1];
        j = localRect.top;
        paramFanItem.y = (localRect.height() / 2 + (i + j));
        return;
      }
      j = localContext.getResources().getDimensionPixelSize(2131296335) >> 1;
      paramFanItem = this.e;
      if (vs.B(localContext));
      for (i = j; ; i = aqs.ac() - j)
      {
        paramFanItem.x = i;
        this.e.y = (aqs.ad() - j);
        return;
      }
    }
    int j = this.c.getResources().getDimensionPixelSize(2131296335) >> 1;
    paramFanItem = this.e;
    if (vs.B(localContext));
    for (int i = j; ; i = aqs.ac() - j)
    {
      paramFanItem.x = i;
      this.e.y = (aqs.ad() - j);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void b()
  {
    this.c.setLayerType(2, null);
    this.c.setAlpha(0.0F);
    this.c.animate().setDuration(380L).alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        aab.a(aab.this).setLayerType(0, null);
      }
    });
  }

  public void b(Canvas paramCanvas)
  {
  }

  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aab
 * JD-Core Version:    0.6.2
 */