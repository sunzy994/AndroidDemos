package com.oppo.launcher.toggleBar;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import com.oppo.launcher.animation.OppoBezierInterpolator;

public abstract class ToggleBarRecyclerScroller extends LinearSmoothScroller
{
  private static final boolean DEBUG = false;
  private static final String TAG = "ToggleBarRecyclerScroller";
  private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2F;
  private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 0;
  private int mScrollTime;
  protected final ToggleBarInterpolator mToggleBarInterpolator = new ToggleBarInterpolator(null);

  public ToggleBarRecyclerScroller(Context paramContext)
  {
    super(paramContext);
  }

  public abstract PointF computeScrollVectorForPosition(int paramInt);

  public void doSwitchToOvershoot(boolean paramBoolean, float paramFloat)
  {
    if (paramBoolean)
    {
      this.mToggleBarInterpolator.switchToOvershoot(paramFloat);
      return;
    }
    this.mToggleBarInterpolator.switchToNormal();
  }

  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
    if (calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j)) > 0)
      paramAction.update(-i, -j, this.mScrollTime, this.mToggleBarInterpolator);
  }

  public void setScrollTime(int paramInt)
  {
    this.mScrollTime = paramInt;
  }

  protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action paramAction)
  {
    PointF localPointF = computeScrollVectorForPosition(getTargetPosition());
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      Log.e("ToggleBarRecyclerScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
      int i = getTargetPosition();
      stop();
      instantScrollToPosition(i);
      return;
    }
    normalize(localPointF);
    this.mTargetVector = localPointF;
    this.mInterimTargetDx = ((int)(localPointF.x * 0.0F));
    this.mInterimTargetDy = ((int)(localPointF.y * 0.0F));
    paramAction.update((int)(this.mInterimTargetDx * 1.2F), (int)(this.mInterimTargetDy * 1.2F), this.mScrollTime, this.mToggleBarInterpolator);
  }

  private static enum State
  {
    NORMAL, OVERSHOOT;
  }

  private final class ToggleBarInterpolator
    implements Interpolator
  {
    private OppoBezierInterpolator mOppoBezierInterpolator = new OppoBezierInterpolator(0.2000000029802322D, 0.300000011920929D, 0.2099999934434891D, 1.0D, true);
    private State mSwitchToOvershoot = State.NORMAL;
    private float mTension = 2.0F;

    private ToggleBarInterpolator()
    {
    }

    private float normalInterpolation(float paramFloat)
    {
      return this.mOppoBezierInterpolator.getInterpolation(paramFloat);
    }

    private float overShootInterpolation(double paramDouble)
    {
      paramDouble -= 1.0D;
      return (float)(paramDouble * paramDouble * ((this.mTension + 1.0D) * paramDouble + this.mTension) + 1.0D);
    }

    private void setTension(float paramFloat)
    {
      this.mTension = paramFloat;
    }

    public float getInterpolation(float paramFloat)
    {
      if (isOvershoot())
        return overShootInterpolation(paramFloat);
      return normalInterpolation(paramFloat);
    }

    public boolean isOvershoot()
    {
      return State.OVERSHOOT == this.mSwitchToOvershoot;
    }

    public void switchToNormal()
    {
      this.mSwitchToOvershoot = State.NORMAL;
    }

    public void switchToOvershoot(float paramFloat)
    {
      this.mSwitchToOvershoot = State.OVERSHOOT;
      setTension(paramFloat);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarRecyclerScroller
 * JD-Core Version:    0.6.2
 */