package com.oppo.launcher.effect.agent;

import android.content.res.Resources;
import android.view.View;
import com.oppo.launcher.PagedView;
import com.oppo.launcher.PagedView.PageInfo;
import com.oppo.launcher.Workspace;
import com.oppo.launcher.effect.EffectAgent;
import com.oppo.launcher.effect.EffectAgent.TransformationInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class SlantEffectAgent extends EffectAgent
{
  private static final boolean DEBUG = false;
  private static final String TAG = "SlantEffectAgent";
  private float mMaxRotation = 0.0F;
  private float mScaleFactorInMini = 0.0F;
  private float mSpringLoadedShrinkFactor = 0.0F;
  private float mSpringLoadedShrinkFactor_1 = 0.0F;
  private float mSpringLoadedShrinkFactor_2 = 0.0F;
  private float mTranslationXFactorInMini = 0.0F;

  public void applyLoopSlantEffect(int paramInt)
  {
    if ((this.mPagedView == null) || (this.mPagedView.isSwitchingState()));
    while (true)
    {
      return;
      if (0.0F >= this.mTranslationXFactorInMini)
      {
        localObject = this.mPagedView.getResources();
        if (localObject != null)
        {
          this.mTranslationXFactorInMini = (((Resources)localObject).getInteger(2131296275) / 100.0F);
          this.mScaleFactorInMini = (((Resources)localObject).getInteger(2131296257) / 10000.0F);
          this.mSpringLoadedShrinkFactor = (((Resources)localObject).getInteger(2131296256) / 100.0F);
        }
      }
      this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_2;
      if (((this.mPagedView instanceof Workspace)) && (((Workspace)this.mPagedView).isOrderMode()))
        this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_1;
      Object localObject = this.mPagedView.getVisiblePages().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PagedView.PageInfo localPageInfo = (PagedView.PageInfo)((Iterator)localObject).next();
        View localView = this.mPagedView.getChildAt(localPageInfo.mIndex);
        if (localView != null)
        {
          float f1 = this.mPagedView.getScrollProgress(localPageInfo);
          float f3 = this.mMaxRotation * f1;
          float f2 = this.mPagedView.getOffsetXForRotation(f3, localView.getWidth(), localView.getHeight());
          f1 = f2;
          if (!this.mPagedView.isNormal())
          {
            f1 = f2 * this.mTranslationXFactorInMini;
            f2 = Math.abs(f3) / this.mMaxRotation * this.mScaleFactorInMini + 1.0F;
            localView.setScaleX(this.mSpringLoadedShrinkFactor * f2);
            localView.setScaleY(this.mSpringLoadedShrinkFactor * f2);
          }
          localPageInfo.mDeltaTranx = f1;
          localPageInfo.mRotateY = f3;
        }
      }
    }
  }

  public void applySlantEffect(int paramInt)
  {
    if ((this.mPagedView == null) || (this.mPagedView.isSwitchingState()));
    while (true)
    {
      return;
      Object localObject;
      if (0.0F >= this.mTranslationXFactorInMini)
      {
        localObject = this.mPagedView.getResources();
        if (localObject != null)
        {
          this.mTranslationXFactorInMini = (((Resources)localObject).getInteger(2131296275) / 100.0F);
          this.mScaleFactorInMini = (((Resources)localObject).getInteger(2131296257) / 10000.0F);
          this.mSpringLoadedShrinkFactor = (((Resources)localObject).getInteger(2131296256) / 100.0F);
        }
      }
      this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_2;
      if (this.mPagedView.isOrderMode())
        this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_1;
      this.mPagedView.getVisiblePages(this.mTempVisiblePagesRange);
      int i = this.mTempVisiblePagesRange[0];
      int j = this.mTempVisiblePagesRange[1];
      if ((i != -1) || (j != -1))
        if ((i == j) && (this.mPagedView.isNormal()))
        {
          localObject = this.mPagedView.getPageAt(i);
          if (localObject != null)
          {
            ((View)localObject).setTranslationX(0.0F);
            ((View)localObject).setScaleX(this.mPagedView.getLayoutScale());
            ((View)localObject).setScaleY(this.mPagedView.getLayoutScale());
            ((View)localObject).setRotationY(0.0F);
            ((View)localObject).setAlpha(1.0F);
          }
        }
        else
        {
          while (i <= j)
          {
            localObject = this.mPagedView.getChildAt(i);
            if (localObject != null)
            {
              float f1 = this.mPagedView.getScrollProgress(paramInt, (View)localObject, i);
              float f3 = this.mMaxRotation * f1;
              float f2 = this.mPagedView.getOffsetXForRotation(f3, ((View)localObject).getWidth(), ((View)localObject).getHeight());
              f1 = f2;
              if (!this.mPagedView.isNormal())
              {
                f1 = f2 * this.mTranslationXFactorInMini;
                f2 = Math.abs(f3) / this.mMaxRotation * this.mScaleFactorInMini + 1.0F;
                ((View)localObject).setScaleX(this.mSpringLoadedShrinkFactor * f2);
                ((View)localObject).setScaleY(this.mSpringLoadedShrinkFactor * f2);
              }
              ((View)localObject).setTranslationX(f1);
              ((View)localObject).setRotationY(f3);
            }
            i += 1;
          }
        }
    }
  }

  public void applyWorkspaceEffect(int paramInt)
  {
    applySlantEffect(paramInt);
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
        this.mChildDefaultParams.setAlpha(localView.getAlpha());
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
    int i;
    label32: View localView;
    if (this.mPagedView.isOrderMode())
    {
      this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_1;
      i = 0;
      if (i >= j)
        return;
      localView = this.mPagedView.getChildAt(i);
      if (localView != null)
      {
        if (this.mChildDefaultParams == null)
          break label132;
        localView.setRotationY(this.mChildDefaultParams.getRotationY());
        localView.setAlpha(this.mChildDefaultParams.getAlpha());
        label79: localView.setTranslationX(0.0F);
        if (!this.mPagedView.isNormal())
          break label145;
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
      }
    }
    while (true)
    {
      i += 1;
      break label32;
      if (!this.mPagedView.isSpringLoaded())
        break;
      this.mSpringLoadedShrinkFactor = this.mSpringLoadedShrinkFactor_2;
      break;
      label132: localView.setRotationY(0.0F);
      localView.setAlpha(1.0F);
      break label79;
      label145: localView.setScaleX(this.mSpringLoadedShrinkFactor);
      localView.setScaleY(this.mSpringLoadedShrinkFactor);
    }
  }

  public void setPagedView(PagedView paramPagedView)
  {
    super.setPagedView(paramPagedView);
    paramPagedView = this.mPagedView.getResources();
    this.mSpringLoadedShrinkFactor_1 = (paramPagedView.getInteger(2131296261) / 100.0F);
    this.mSpringLoadedShrinkFactor_2 = (paramPagedView.getInteger(2131296256) / 100.0F);
    this.mMaxRotation = (paramPagedView.getInteger(2131296292) / 10.0F);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.agent.SlantEffectAgent
 * JD-Core Version:    0.6.2
 */