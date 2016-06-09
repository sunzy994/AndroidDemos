package com.oppo.launcher.effect.agent;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.oppo.launcher.PagedView;
import com.oppo.launcher.Workspace;
import com.oppo.launcher.effect.EffectAgent;
import com.oppo.launcher.effect.EffectAgent.TransformationInfo;

public class RotationEffectAgent extends EffectAgent
{
  public static final boolean DEBUG = false;
  private static final float MAX_SCALE_FACTOR = 0.35F;
  private static final float STANDARD_CAMERA_DISTANCE = 1280.0F;
  public static final String TAG = "RotationEffectAgent";
  private static final float TARGET_CAMERA_DISTANCE = 3500.0F;
  private float mDensity = 1.0F;
  private float mSpringLoadedShrinkFactor = 0.0F;
  private float mSpringLoadedShrinkFactor_1 = 0.0F;
  private float mSpringLoadedShrinkFactor_2 = 0.0F;

  private void applyRotationEffect(int paramInt)
  {
    if (this.mPagedView == null);
    while (true)
    {
      return;
      if (!this.mPagedView.isSwitchingState())
      {
        this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_2;
        if (((this.mPagedView instanceof Workspace)) && (((Workspace)this.mPagedView).isOrderMode()))
          this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_1;
        int[] arrayOfInt = this.mTempVisiblePagesRange;
        this.mPagedView.getVisiblePages(arrayOfInt);
        int i = this.mPagedView.getScrollX();
        int j = this.mPagedView.getMeasuredWidth() / 2;
        paramInt = arrayOfInt[0];
        while (paramInt <= arrayOfInt[1])
        {
          View localView = this.mPagedView.getPageAt(paramInt);
          if (localView != null)
            doAnimateImpl(paramInt, localView, this.mPagedView.getScrollProgress(i + j, localView, paramInt));
          paramInt += 1;
        }
      }
    }
  }

  private void doAnimateImpl(int paramInt, View paramView, float paramFloat)
  {
    float f4 = this.mPagedView.getScrollX();
    float f1;
    if (Math.abs(paramFloat) < 0.5F)
    {
      f1 = 1.0F;
      if (paramFloat <= 0.0F)
        break label121;
    }
    label121: for (float f2 = -180.0F * Math.abs(paramFloat); ; f2 = 180.0F * Math.abs(paramFloat))
    {
      float f3 = 1.0F - Math.abs(paramFloat) + 0.35F * Math.abs(paramFloat);
      paramFloat = f3;
      if (!this.mPagedView.isNormal())
        paramFloat = f3 * this.mSpringLoadedShrinkFactor;
      paramView.setCameraDistance(3500.0F * this.mDensity);
      paramView.setAlpha(f1);
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      paramView.setRotationY(f2);
      paramView.setX(f4);
      return;
      f1 = 0.0F;
      break;
    }
  }

  public void applyWorkspaceEffect(int paramInt)
  {
    applyRotationEffect(paramInt);
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
          break label112;
        localView.setScaleX(this.mPagedView.getLayoutScale());
        localView.setScaleY(this.mPagedView.getLayoutScale());
        localView.setAlpha(this.mChildDefaultParams.getAlpha());
        localView.setTranslationX(this.mChildDefaultParams.getTranslationX());
        localView.setRotationY(this.mChildDefaultParams.getRotationY());
      }
      while (true)
      {
        localView.setCameraDistance(1280.0F * this.mDensity);
        i += 1;
        break;
        label112: localView.setScaleX(this.mPagedView.getLayoutScale());
        localView.setScaleY(this.mPagedView.getLayoutScale());
        localView.setTranslationX(localView.getTranslationX());
        localView.setRotationY(localView.getRotationY());
        localView.setAlpha(1.0F);
      }
    }
  }

  public void setPagedView(PagedView paramPagedView)
  {
    super.setPagedView(paramPagedView);
    if (paramPagedView != null)
      this.mDensity = paramPagedView.getResources().getDisplayMetrics().density;
    paramPagedView = this.mPagedView.getResources();
    this.mSpringLoadedShrinkFactor_1 = (paramPagedView.getInteger(2131296261) / 100.0F);
    this.mSpringLoadedShrinkFactor_2 = (paramPagedView.getInteger(2131296256) / 100.0F);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.agent.RotationEffectAgent
 * JD-Core Version:    0.6.2
 */