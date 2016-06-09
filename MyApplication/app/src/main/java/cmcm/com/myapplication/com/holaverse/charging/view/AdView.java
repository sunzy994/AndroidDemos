package cmcm.com.myapplication.com.holaverse.charging.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ur;
import us;

public class AdView extends LinearLayout
{
  private us a;
  private int b;
  private AdEventLayout c = null;
  private float d;
  private float e;
  private Boolean f = null;

  public AdView(Context paramContext)
  {
    super(paramContext);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if ((this.c != null) && (this.c.getParent() != null))
    {
      ((ViewGroup)this.c.getParent()).removeView(this.c);
      this.c = null;
    }
  }

  public void a(us paramus, AdEventLayout paramAdEventLayout)
  {
    this.a = paramus;
    this.c = paramAdEventLayout;
    this.c.setOnFlingOutListener(new ur()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        AdView.a(AdView.this);
        if (AdView.b(AdView.this) != null)
          AdView.b(AdView.this).a(paramAnonymousBoolean);
      }
    });
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    do
    {
      while (true)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        this.f = null;
      }
      if (this.f != null)
        return this.f.booleanValue();
      if (Math.abs(paramMotionEvent.getY() - this.e) > this.b)
        this.f = Boolean.valueOf(true);
      if (Math.abs(paramMotionEvent.getX() - this.d) > this.b)
        this.f = Boolean.valueOf(false);
    }
    while (this.f == null);
    return this.f.booleanValue();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 0:
    }
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.AdView
 * JD-Core Version:    0.6.2
 */