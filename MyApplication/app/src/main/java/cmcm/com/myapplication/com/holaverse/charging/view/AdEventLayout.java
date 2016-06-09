package cmcm.com.myapplication.com.holaverse.charging.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import tz;
import ul;
import ur;

public class AdEventLayout extends LinearLayout
{
  public static boolean a = false;
  public static Boolean b;
  public ur c;
  private VelocityTracker d;
  private GestureDetector e;
  private Scroller f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private final int l;
  private MotionEvent m;
  private Paint n = null;
  private int o;
  private int p;
  private int q = 0;
  private int r = 0;
  private String s;
  private String t;

  public AdEventLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AdEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AdEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    this.s = paramContext.getString(tz.global_open);
    this.t = paramContext.getString(tz.global_close);
    this.f = new Scroller(getContext());
    this.d = VelocityTracker.obtain();
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = new GestureDetector(getContext(), new SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        if (AdEventLayout.a(AdEventLayout.this) == 0)
        {
          AdEventLayout.a(AdEventLayout.this, AdEventLayout.this.getWidth() / 5);
          Rect localRect = new Rect();
          AdEventLayout.c(AdEventLayout.this).getTextBounds(AdEventLayout.b(AdEventLayout.this), 0, AdEventLayout.b(AdEventLayout.this).length(), localRect);
          AdEventLayout.a(AdEventLayout.this, Math.max(AdEventLayout.a(AdEventLayout.this), localRect.width() + AdEventLayout.d(AdEventLayout.this)));
          AdEventLayout.b(AdEventLayout.this, AdEventLayout.this.getWidth() / 5);
          localRect = new Rect();
          AdEventLayout.c(AdEventLayout.this).getTextBounds(AdEventLayout.e(AdEventLayout.this), 0, AdEventLayout.e(AdEventLayout.this).length(), localRect);
          AdEventLayout.b(AdEventLayout.this, Math.max(AdEventLayout.f(AdEventLayout.this), localRect.width() + AdEventLayout.g(AdEventLayout.this)));
        }
        if (AdEventLayout.d(AdEventLayout.this) == 0)
        {
          AdEventLayout.c(AdEventLayout.this, AdEventLayout.this.getPaddingLeft());
          AdEventLayout.d(AdEventLayout.this, AdEventLayout.this.getPaddingRight());
        }
        AdEventLayout.a(AdEventLayout.this, paramAnonymousMotionEvent);
        AdEventLayout.a = true;
        AdEventLayout.b = null;
        AdEventLayout.e(AdEventLayout.this, (int)paramAnonymousMotionEvent.getX());
        AdEventLayout.f(AdEventLayout.this, (int)paramAnonymousMotionEvent.getY());
        if ((AdEventLayout.h(AdEventLayout.this) != null) && (!AdEventLayout.h(AdEventLayout.this).isFinished()))
          AdEventLayout.h(AdEventLayout.this).abortAnimation();
        AdEventLayout.g(AdEventLayout.this, (int)(paramAnonymousMotionEvent.getX() - AdEventLayout.this.getLeft()));
        AdEventLayout.h(AdEventLayout.this, (int)(paramAnonymousMotionEvent.getY() - AdEventLayout.this.getTop()));
        AdEventLayout.i(AdEventLayout.this, AdEventLayout.this.getScrollX());
        return super.onDown(paramAnonymousMotionEvent);
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        final boolean bool = false;
        if ((AdEventLayout.b == null) || (!AdEventLayout.b.booleanValue()))
          return false;
        AdEventLayout.n(AdEventLayout.this).computeCurrentVelocity(1000);
        int i;
        if ((paramAnonymousFloat1 > 0.0F) && (AdEventLayout.this.getScrollX() < 0))
          i = -AdEventLayout.this.getWidth();
        while (true)
        {
          int j = (int)(1000.0F * Math.abs(i - AdEventLayout.this.getScrollX()) / AdEventLayout.this.getWidth());
          AdEventLayout.h(AdEventLayout.this).startScroll(AdEventLayout.this.getScrollX(), 0, i - AdEventLayout.this.getScrollX(), 0, j);
          if (i < 0)
            bool = true;
          if (i != 0)
            AdEventLayout.this.postDelayed(new Runnable()
            {
              public void run()
              {
                if (AdEventLayout.this.c != null)
                  AdEventLayout.this.c.a(bool);
                if (bool)
                  AdEventLayout.o(AdEventLayout.this);
              }
            }
            , j);
          AdEventLayout.this.invalidate();
          return super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          if ((paramAnonymousFloat1 < 0.0F) && (AdEventLayout.this.getScrollX() > 0))
            i = AdEventLayout.this.getWidth();
          else
            i = 0;
        }
      }

      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int i;
        if (AdEventLayout.b == null)
        {
          i = (int)Math.abs(paramAnonymousMotionEvent2.getX() - AdEventLayout.i(AdEventLayout.this));
          j = (int)Math.abs(paramAnonymousMotionEvent2.getY() - AdEventLayout.j(AdEventLayout.this));
          if ((i <= AdEventLayout.k(AdEventLayout.this)) || (i < j))
            break label87;
        }
        for (AdEventLayout.b = Boolean.valueOf(true); (AdEventLayout.b == null) || (!AdEventLayout.b.booleanValue()); AdEventLayout.b = Boolean.valueOf(false))
        {
          label70: return false;
          label87: if ((j <= AdEventLayout.k(AdEventLayout.this)) || (j <= i))
            break label70;
        }
        int j = -(int)(paramAnonymousMotionEvent2.getX() - AdEventLayout.l(AdEventLayout.this)) + AdEventLayout.m(AdEventLayout.this);
        if (j <= 0)
          if (j >= -AdEventLayout.a(AdEventLayout.this))
            i = j;
        while (true)
        {
          AdEventLayout.this.scrollTo(i, 0);
          return super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          i = (j - AdEventLayout.a(AdEventLayout.this)) / 2;
          continue;
          i = j;
          if (j > AdEventLayout.f(AdEventLayout.this))
            i = (j + AdEventLayout.f(AdEventLayout.this)) / 2;
        }
      }

      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        return super.onSingleTapConfirmed(paramAnonymousMotionEvent);
      }

      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AdEventLayout.o(AdEventLayout.this);
        return super.onSingleTapUp(paramAnonymousMotionEvent);
      }
    });
    if (this.n == null)
    {
      this.n = new Paint();
      this.n.setColor(-1);
      this.n.setAntiAlias(true);
      this.n.setTextAlign(Align.LEFT);
      this.n.setTextSize(ul.b(paramContext, 12.0F));
      this.n.setFlags(7);
    }
  }

  private void a()
  {
    if (this.m == null)
      return;
    postDelayed(new Runnable()
    {
      public void run()
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(AdEventLayout.p(AdEventLayout.this).getDownTime(), l, 0, AdEventLayout.p(AdEventLayout.this).getX(), AdEventLayout.p(AdEventLayout.this).getY(), 0);
        AdEventLayout.this.getChildAt(0).onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    , 0);
    postDelayed(new Runnable()
    {
      public void run()
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(AdEventLayout.p(AdEventLayout.this).getDownTime(), l, 1, AdEventLayout.p(AdEventLayout.this).getX(), AdEventLayout.p(AdEventLayout.this).getY(), 0);
        AdEventLayout.this.getChildAt(0).onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    , 100);
  }

  public void computeScroll()
  {
    if (this.f.computeScrollOffset())
    {
      scrollTo(this.f.getCurrX(), 0);
      invalidate();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = 255;
    if ((this.q == 0) || (getScrollX() == 0))
    {
      super.onDraw(paramCanvas);
      return;
    }
    int i2 = -getScrollX();
    int i3;
    if (i2 >= 0)
    {
      this.n.setTextAlign(Align.LEFT);
      if (i2 < this.q)
      {
        i1 = (int)(i2 * 255.0F / this.q);
        this.n.setAlpha(i1);
        i1 = this.o - i2;
        i3 = getPaddingTop() + ul.b(getContext(), 18.0F);
        if (i2 >= this.q)
          break label161;
        paramCanvas.drawText(this.s, i1, i3, this.n);
      }
    }
    while (true)
    {
      super.onDraw(paramCanvas);
      return;
      if (i2 <= getWidth() - this.q)
        break;
      i1 = (int)((getWidth() - i2) * 255.0F / this.q);
      break;
      label161: paramCanvas.drawText(this.s, i1 + i2 - this.q, i3, this.n);
      continue;
      this.n.setTextAlign(Align.RIGHT);
      if (-i2 < this.r)
        i1 = (int)(-i2 * 255.0F / this.r);
      while (true)
      {
        this.n.setAlpha(i1);
        i1 = getWidth() - this.p - i2;
        i3 = getPaddingTop() + ul.b(getContext(), 18.0F);
        if (-i2 >= this.r)
          break label321;
        paramCanvas.drawText(this.t, i1, i3, this.n);
        break;
        if (-i2 > getWidth() - this.r)
          i1 = (int)((getWidth() + i2) * 255.0F / this.r);
      }
      label321: paramCanvas.drawText(this.t, i1 + i2 + this.r, i3, this.n);
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.d.addMovement(paramMotionEvent);
    this.e.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
      return super.onInterceptTouchEvent(paramMotionEvent);
    return true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.d.addMovement(paramMotionEvent);
    this.e.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 1:
    case 3:
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      a = false;
    }
    while ((b == null) || (!b.booleanValue()));
    int i1;
    int i2;
    final boolean bool;
    if (this.f.isFinished())
    {
      if ((getScrollX() >= 0) || (paramMotionEvent.getX() - this.g <= this.q))
        break label194;
      i1 = -getWidth();
      i2 = 1;
      bool = true;
    }
    while (true)
    {
      int i3 = (int)(1000.0F * Math.abs(i1 - getScrollX()) / getWidth());
      this.f.startScroll(getScrollX(), 0, i1 - getScrollX(), 0, i3);
      if (i2 != 0)
        postDelayed(new Runnable()
        {
          public void run()
          {
            if (AdEventLayout.this.c != null)
              AdEventLayout.this.c.a(bool);
            if (bool)
              AdEventLayout.o(AdEventLayout.this);
          }
        }
        , i3);
      invalidate();
      break;
      label194: if ((getScrollX() > 0) && (this.g - paramMotionEvent.getX() > this.r))
      {
        i1 = getWidth();
        i2 = 1;
        bool = false;
      }
      else
      {
        i2 = 0;
        bool = false;
        i1 = 0;
      }
    }
  }

  public void setOnFlingOutListener(ur paramur)
  {
    this.c = paramur;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.AdEventLayout
 * JD-Core Version:    0.6.2
 */