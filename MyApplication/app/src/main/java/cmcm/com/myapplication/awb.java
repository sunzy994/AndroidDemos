package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class awb
  implements OnTouchListener
{
  private final int a;
  private final int b;
  private final int c;
  private final long d;
  private final ListView e;
  private final awc f;
  private int g = 1;
  private final List<awd> h = new ArrayList();
  private int i = 0;
  private float j;
  private float k;
  private boolean l;
  private VelocityTracker m;
  private int n;
  private View o;
  private boolean p;
  private int q = 0;
  private boolean r;
  private final int s;

  public awb(ListView paramListView, awc paramawc)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramListView.getContext());
    this.a = localViewConfiguration.getScaledTouchSlop();
    this.b = (localViewConfiguration.getScaledMinimumFlingVelocity() * 16);
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.d = paramListView.getContext().getResources().getInteger(17694720);
    this.e = paramListView;
    this.f = paramawc;
    this.s = ViewConfiguration.get(paramListView.getContext()).getScaledTouchSlop();
  }

  private void a(final View paramView, int paramInt)
  {
    final ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    final int i1 = paramView.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, 1 }).setDuration(this.d);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        awb.a(awb.this);
        if (awb.b(awb.this) == 0)
        {
          Collections.sort(awb.c(awb.this));
          paramAnonymousAnimator = new int[awb.c(awb.this).size()];
          int i = awb.c(awb.this).size() - 1;
          while (i >= 0)
          {
            paramAnonymousAnimator[i] = i1;
            i -= 1;
          }
          awb.e(awb.this).a(awb.d(awb.this), paramAnonymousAnimator);
          paramAnonymousAnimator = awb.c(awb.this).iterator();
          while (paramAnonymousAnimator.hasNext())
          {
            final awd localawd = (awd)paramAnonymousAnimator.next();
            localawd.b.postDelayed(new Runnable()
            {
              public void run()
              {
                localawd.b.setAlpha(1.0F);
                localawd.b.setTranslationX(0.0F);
                ViewGroup.LayoutParams localLayoutParams = localawd.b.getLayoutParams();
                localLayoutParams.height = awb.3.this.a;
                localawd.b.setLayoutParams(localLayoutParams);
              }
            }
            , 100L);
          }
          awb.c(awb.this).clear();
        }
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        localLayoutParams.height = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramView.setLayoutParams(localLayoutParams);
      }
    });
    this.h.add(new awd(this, paramInt, paramView));
    localValueAnimator.start();
  }

  private void a(final View paramView, final int paramInt, boolean paramBoolean)
  {
    this.i += 1;
    if (paramView == null)
    {
      this.f.a(this.e, new int[] { paramInt });
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (paramBoolean);
    for (float f1 = this.g; ; f1 = -this.g)
    {
      localViewPropertyAnimator.translationX(f1).alpha(0.0F).setDuration(this.d).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          awb.a(awb.this, paramView, paramInt);
        }
      });
      return;
    }
  }

  public OnScrollListener a()
  {
    return new OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        boolean bool = true;
        paramAnonymousAbsListView = awb.this;
        if (paramAnonymousInt != 1);
        while (true)
        {
          paramAnonymousAbsListView.a(bool);
          return;
          bool = false;
        }
      }
    };
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      this.p = paramBoolean;
      return;
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i2 = 1;
    int i1 = 0;
    if (this.g < 2)
      this.g = this.e.getWidth();
    label276: float f1;
    float f2;
    float f3;
    float f4;
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 1:
      do
      {
        do
        {
          return false;
          this.j = paramMotionEvent.getX();
          this.k = paramMotionEvent.getY();
          this.q = 0;
          this.r = false;
        }
        while (this.p);
        Rect localRect = new Rect();
        i2 = this.e.getChildCount();
        Object localObject = new int[2];
        this.e.getLocationOnScreen((int[])localObject);
        int i3 = (int)paramMotionEvent.getRawX();
        int i4 = localObject[0];
        int i5 = (int)paramMotionEvent.getRawY();
        int i6 = localObject[1];
        if (i1 < i2)
        {
          localObject = this.e.getChildAt(i1);
          ((View)localObject).getHitRect(localRect);
          if (localRect.contains(i3 - i4, i5 - i6))
            this.o = ((View)localObject);
        }
        else if (this.o != null)
        {
          this.n = this.e.getPositionForView(this.o);
          if (!this.f.a(this.n))
            break label276;
          this.m = VelocityTracker.obtain();
          this.m.addMovement(paramMotionEvent);
        }
        while (true)
        {
          paramView.onTouchEvent(paramMotionEvent);
          return true;
          i1 += 1;
          break;
          this.o = null;
        }
        this.q = 0;
      }
      while (((this.o == null) && (!this.r) && (this.f != null) && (this.f.a(this.e))) || (this.m == null));
      f1 = paramMotionEvent.getRawX() - this.j;
      this.m.addMovement(paramMotionEvent);
      this.m.computeCurrentVelocity(1000);
      f2 = this.m.getXVelocity();
      f3 = Math.abs(f2);
      f4 = Math.abs(this.m.getYVelocity());
      if (Math.abs(f1) > this.g / 2)
        if (f1 > 0.0F)
        {
          bool = true;
          i1 = i2;
        }
      break;
    case 3:
    case 2:
    }
    while (true)
    {
      if (i1 != 0)
        a(this.o, this.n, bool);
      while (true)
      {
        this.m.recycle();
        this.m = null;
        this.j = 0.0F;
        this.o = null;
        this.n = -1;
        this.l = false;
        return false;
        bool = false;
        i1 = i2;
        break;
        if ((this.b > f3) || (f3 > this.c) || (f4 >= f3))
          break label991;
        if (f2 < 0.0F)
        {
          i1 = 1;
          label520: if (f1 >= 0.0F)
            break label560;
          i2 = 1;
          label529: if (i1 != i2)
            break label566;
          i1 = 1;
          label539: if (this.m.getXVelocity() <= 0.0F)
            break label572;
        }
        while (true)
        {
          break;
          i1 = 0;
          break label520;
          label560: i2 = 0;
          break label529;
          label566: i1 = 0;
          break label539;
          label572: bool = false;
        }
        if (this.o != null)
          this.o.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
      }
      this.q = 0;
      if (this.m == null)
        break;
      if (this.o != null)
        this.o.animate().translationX(0.0F).alpha(1.0F).setDuration(this.d).setListener(null);
      this.m.recycle();
      this.m = null;
      this.j = 0.0F;
      this.o = null;
      this.n = -1;
      this.l = false;
      return false;
      if (this.q == 0)
      {
        f1 = Math.abs(paramMotionEvent.getX() - this.j);
        f2 = Math.abs(paramMotionEvent.getY() - this.k);
        if (f1 <= this.s)
          break label927;
        i1 = 1;
        label742: if (f2 <= this.s)
          break label933;
        i2 = 1;
        label756: if ((i1 != 0) || (i2 != 0))
        {
          if (f1 <= f2)
            break label939;
          this.q = 1;
        }
      }
      label927: label933: label939: label983: label989: 
      while (true)
      {
        if (this.q != 0)
          this.r = true;
        if ((this.m == null) || (this.p))
          break;
        this.m.addMovement(paramMotionEvent);
        f1 = paramMotionEvent.getRawX() - this.j;
        if (Math.abs(f1) > this.a)
        {
          this.l = true;
          this.e.requestDisallowInterceptTouchEvent(true);
          paramView = MotionEvent.obtain(paramMotionEvent);
          paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
          this.e.onTouchEvent(paramView);
          paramView.recycle();
        }
        if (!this.l)
          break;
        this.o.setTranslationX(f1);
        this.o.setAlpha(Math.max(0.15F, Math.min(1.0F, 1.0F - Math.abs(f1) * 2.0F / this.g)));
        return true;
        i1 = 0;
        break label742;
        i2 = 0;
        break label756;
        if (i1 == 0)
          if (paramMotionEvent.getY() - this.k <= 0.0F)
            break label983;
        for (this.q = 3; ; this.q = 2)
        {
          if ((this.q != 0) || (i1 == 0))
            break label989;
          this.q = 1;
          break;
        }
      }
      label991: bool = false;
      i1 = 0;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awb
 * JD-Core Version:    0.6.2
 */