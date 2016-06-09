package com.oppo.launcher.effect.agent;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.oppo.launcher.PagedView;
import com.oppo.launcher.PagedView.PageInfo;
import com.oppo.launcher.PagedView.ZInterpolator;
import com.oppo.launcher.effect.EffectAgent;
import com.oppo.launcher.effect.EffectAgent.TransformationInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class StackEffectAgent extends EffectAgent
{
  private static final boolean DEBUG = false;
  private static final boolean PERFORM_OVERSCROLL_ROTATION = true;
  private static final String TAG = "StackEffectAgent";
  private static float TRANSITION_SCALE_FACTOR = 0.74F;
  private AccelerateInterpolator mAlphaInterpolator = new AccelerateInterpolator(0.9F);
  private float mSpringLoadedShrinkFactor = 0.0F;
  private float mSpringLoadedShrinkFactor_1 = 0.0F;
  private float mSpringLoadedShrinkFactor_2 = 0.0F;
  private PagedView.ZInterpolator mZInterpolator = new PagedView.ZInterpolator(0.5F);

  private void applyStackEffect(int paramInt)
  {
    if ((this.mPagedView.isFastDrawing()) || (this.mPagedView.isSwitchingState()));
    int i;
    int j;
    View localView;
    do
    {
      return;
      this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_2;
      if (this.mPagedView.isOrderMode())
        this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_1;
      this.mPagedView.getVisiblePages(this.mTempVisiblePagesRange);
      i = this.mTempVisiblePagesRange[0];
      j = this.mTempVisiblePagesRange[1];
      if ((i != j) || (!this.mPagedView.isNormal()))
        break;
      localView = this.mPagedView.getPageAt(i);
    }
    while (localView == null);
    localView.setTranslationX(0.0F);
    localView.setScaleX(this.mPagedView.getLayoutScale());
    localView.setScaleY(this.mPagedView.getLayoutScale());
    localView.setAlpha(1.0F);
    return;
    label144: float f3;
    float f1;
    float f2;
    label245: int k;
    int m;
    label282: float f4;
    if (i <= j)
    {
      localView = this.mPagedView.getPageAt(i);
      if (localView != null)
      {
        f3 = this.mPagedView.getScrollProgress(paramInt, localView, i);
        f1 = this.mZInterpolator.getInterpolation(Math.abs(Math.min(f3, 0.0F)));
        float f5 = 1.0F - f1 + TRANSITION_SCALE_FACTOR * f1;
        f1 = Math.min(0.0F, f3) * localView.getMeasuredWidth();
        if (f3 >= 0.0F)
          break label357;
        f2 = this.mAlphaInterpolator.getInterpolation(1.0F - Math.abs(f3));
        k = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        if ((i != 0) || (f3 >= 0.0F))
          break label362;
        f2 = 1.0F;
        f1 = this.mPagedView.getScrollX();
        f4 = f5;
        f3 = f1;
        if (!this.mPagedView.isNormal())
        {
          f3 = f1 * this.mSpringLoadedShrinkFactor;
          f4 = f5 * this.mSpringLoadedShrinkFactor;
        }
        if ((!isFirstOrLastPage(localView)) || (!isOverScroll()))
          break label434;
        localView.setTranslationX(f3 / 3.0F);
      }
    }
    while (true)
    {
      localView.setAlpha(f2);
      i += 1;
      break label144;
      break;
      label357: f2 = 1.0F;
      break label245;
      label362: if ((i == this.mPagedView.getChildCount() - 1) && (f3 > 0.0F))
      {
        f2 = 1.0F;
        f1 = this.mPagedView.getScrollX() - this.mPagedView.getMaxScrollX();
        break label282;
      }
      localView.setPivotY(m / 2.0F);
      localView.setPivotX(k / 2.0F);
      localView.setRotationY(0.0F);
      break label282;
      label434: localView.setTranslationX(f3);
      localView.setScaleX(f4);
      localView.setScaleY(f4);
    }
  }

  public void applyLoopStackEffect(int paramInt)
  {
    if ((this.mPagedView == null) || (this.mPagedView.isSwitchingState()))
      return;
    if (0.0F >= this.mSpringLoadedShrinkFactor)
    {
      localObject = this.mPagedView.getResources();
      if (localObject != null)
        this.mSpringLoadedShrinkFactor = (((Resources)localObject).getInteger(2131296262) / 100.0F);
    }
    Object localObject = this.mPagedView.getVisiblePages().iterator();
    label68: PagedView.PageInfo localPageInfo;
    View localView;
    float f2;
    float f4;
    float f5;
    while (((Iterator)localObject).hasNext())
    {
      localPageInfo = (PagedView.PageInfo)((Iterator)localObject).next();
      localView = this.mPagedView.getChildAt(localPageInfo.mIndex);
      if (localView != null)
      {
        f1 = this.mPagedView.getScrollProgress(localPageInfo);
        f2 = this.mZInterpolator.getInterpolation(Math.abs(Math.min(f1, 0.0F)));
        f4 = 1.0F - f2 + TRANSITION_SCALE_FACTOR * f2;
        f5 = Math.min(0.0F, f1) * localView.getMeasuredWidth();
        if (f1 >= 0.0F)
          break label277;
      }
    }
    label277: for (float f1 = this.mAlphaInterpolator.getInterpolation(1.0F - Math.abs(f1)); ; f1 = 1.0F)
    {
      paramInt = localView.getMeasuredWidth();
      localView.setPivotY(localView.getMeasuredHeight() / 2.0F);
      localView.setPivotX(paramInt / 2.0F);
      localView.setRotationY(0.0F);
      float f3 = f4;
      f2 = f5;
      if (!this.mPagedView.isNormal())
      {
        f2 = f5 * this.mSpringLoadedShrinkFactor;
        f3 = f4 * this.mSpringLoadedShrinkFactor;
      }
      localPageInfo.mDeltaTranx = f2;
      localPageInfo.mAlpha = f1;
      localPageInfo.mScaleX = f3;
      localPageInfo.mScaleY = f3;
      break label68;
      break;
    }
  }

  public void applyWorkspaceEffect(int paramInt)
  {
    applyStackEffect(paramInt);
  }

  protected boolean backUpParameters()
  {
    int i = this.mPagedView.getChildCount();
    this.mChildDefaultParams = new EffectAgent.TransformationInfo();
    if (i > 0)
    {
      View localView = this.mPagedView.getChildAt(this.mPagedView.getCurrentPage());
      if (localView != null)
      {
        this.mChildDefaultParams.setScaleX(localView.getScaleX());
        this.mChildDefaultParams.setScaleY(localView.getScaleY());
        this.mChildDefaultParams.setAlpha(localView.getAlpha());
        this.mChildDefaultParams.setTranslationX(localView.getTranslationX());
      }
      while (true)
      {
        return true;
        this.mChildDefaultParams = null;
      }
    }
    this.mChildDefaultParams = null;
    return false;
  }

  public boolean isFirstOrLastPage(View paramView)
  {
    int i = this.mPagedView.indexOfChild(paramView);
    return (i == 0) || (this.mPagedView.getChildCount() - 1 == i);
  }

  public boolean isOverScroll()
  {
    int i = this.mPagedView.getScrollX();
    int j = this.mPagedView.getChildCount();
    int k = this.mPagedView.getWidth();
    return (i < 0) || (i > (j - 1) * k);
  }

  protected void restoreParameters()
  {
    super.restoreParameters();
    int j = this.mPagedView.getChildCount();
    Log.d("StackEffectAgent", "restoreParameters for " + this + ", mPagedView = " + this.mPagedView + ", childCount = " + j);
    int i = 0;
    if (i < j)
    {
      View localView = this.mPagedView.getChildAt(i);
      if (localView != null)
      {
        if (this.mChildDefaultParams == null)
          break label138;
        localView.setTranslationX(this.mChildDefaultParams.getTranslationX());
        localView.setScaleX(this.mPagedView.getLayoutScale());
        localView.setScaleY(this.mPagedView.getLayoutScale());
        localView.setAlpha(this.mChildDefaultParams.getAlpha());
      }
      while (true)
      {
        i += 1;
        break;
        label138: localView.setTranslationX(0.0F);
        localView.setScaleX(this.mPagedView.getLayoutScale());
        localView.setScaleY(this.mPagedView.getLayoutScale());
        localView.setAlpha(1.0F);
      }
    }
  }

  public void setPagedView(PagedView paramPagedView)
  {
    super.setPagedView(paramPagedView);
    paramPagedView = this.mPagedView.getResources();
    this.mSpringLoadedShrinkFactor_1 = (paramPagedView.getInteger(2131296261) / 100.0F);
    this.mSpringLoadedShrinkFactor_2 = (paramPagedView.getInteger(2131296256) / 100.0F);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.agent.StackEffectAgent
 * JD-Core Version:    0.6.2
 */