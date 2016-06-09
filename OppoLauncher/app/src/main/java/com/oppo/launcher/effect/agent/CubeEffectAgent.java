package com.oppo.launcher.effect.agent;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.oppo.launcher.PagedView;
import com.oppo.launcher.effect.EffectAgent;
import com.oppo.launcher.effect.EffectAgent.TransformationInfo;

public class CubeEffectAgent extends EffectAgent
{
  private static final boolean DEBUG = false;
  private static final float MAX_ROTATION = 90.0F;
  private static final float STANDARD_CAMERA_DISTANCE = 1280.0F;
  private static final String TAG = "CubeEffectAgent";
  private static final float TARGET_CAMERA_DISTANCE = 4200.0F;
  private float mDensity = 1.0F;

  public void applyCubeEffect(int paramInt)
  {
    if ((this.mPagedView == null) || (this.mPagedView.isSwitchingState()));
    int i;
    int j;
    View localView;
    do
    {
      return;
      this.mPagedView.getVisiblePages(this.mTempVisiblePagesRange);
      i = this.mTempVisiblePagesRange[0];
      j = this.mTempVisiblePagesRange[1];
      if ((i != j) || (!this.mPagedView.isNormal()))
        break;
      localView = this.mPagedView.getPageAt(i);
    }
    while (localView == null);
    localView.setRotationY(0.0F);
    localView.setPivotX(localView.getMeasuredWidth() / 2.0F);
    localView.setPivotY(localView.getMeasuredHeight() / 2.0F);
    localView.setTranslationX(0.0F);
    localView.setCameraDistance(this.mDensity * 4200.0F);
    return;
    label129: float f3;
    float f2;
    if (i <= j)
    {
      localView = this.mPagedView.getChildAt(i);
      if (localView != null)
      {
        localView.setPivotY(localView.getMeasuredHeight() / 2.0F);
        f3 = this.mPagedView.getScrollProgress(paramInt, localView, i);
        if (f3 <= 0.0F)
          break label261;
        f2 = -90.0F * Math.abs(f3);
      }
    }
    for (float f1 = localView.getMeasuredWidth(); ; f1 = 0.0F)
    {
      if (!this.mPagedView.isNormal())
        localView.setTranslationX(this.mPagedView.getTranslationXforCubeEffect(f3, localView));
      localView.setCameraDistance(this.mDensity * 4200.0F);
      localView.setPivotX(f1);
      localView.setRotationY(f2);
      i += 1;
      break label129;
      break;
      label261: f2 = 90.0F * Math.abs(f3);
    }
  }

  public void applyWorkspaceEffect(int paramInt)
  {
    applyCubeEffect(paramInt);
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
        this.mChildDefaultParams.setRotationY(localView.getRotationY());
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

  protected void restoreParameters()
  {
    super.restoreParameters();
    int j = this.mPagedView.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mPagedView.getChildAt(i);
      if (localView != null)
      {
        if (this.mChildDefaultParams == null)
          break label101;
        localView.setRotationY(this.mChildDefaultParams.getRotationY());
        localView.setPivotX(localView.getMeasuredWidth() / 2.0F);
        localView.setPivotY(localView.getMeasuredHeight() / 2.0F);
        localView.setTranslationX(this.mChildDefaultParams.getTranslationX());
      }
      while (true)
      {
        localView.setCameraDistance(1280.0F * this.mDensity);
        i += 1;
        break;
        label101: localView.setRotationY(0.0F);
        localView.setPivotX(localView.getMeasuredWidth() / 2.0F);
        localView.setPivotY(localView.getMeasuredHeight() / 2.0F);
        localView.setTranslationX(0.0F);
      }
    }
  }

  public void setPagedView(PagedView paramPagedView)
  {
    super.setPagedView(paramPagedView);
    if (paramPagedView != null)
      this.mDensity = paramPagedView.getResources().getDisplayMetrics().density;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.agent.CubeEffectAgent
 * JD-Core Version:    0.6.2
 */