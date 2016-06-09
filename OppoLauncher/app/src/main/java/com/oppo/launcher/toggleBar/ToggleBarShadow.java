package com.oppo.launcher.toggleBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.oppo.launcher.LauncherViewPropertyAnimator;

public class ToggleBarShadow
{
  private static final boolean DEBUG = false;
  private static final String TAG = "ToggleBarShadow";
  private AnimatorSet mItemInAnimatorSet = null;
  private RelativeLayout mToggle;
  private ToggleBarRecyclerView mToggleBarRecyclerView;

  public ToggleBarShadow(RelativeLayout paramRelativeLayout, ToggleBarRecyclerView paramToggleBarRecyclerView)
  {
    this.mToggleBarRecyclerView = paramToggleBarRecyclerView;
    this.mToggle = paramRelativeLayout;
  }

  private void addInDragLayer(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (this.mToggleBarRecyclerView == null) || (this.mToggle == null))
      return;
    LayoutParams localLayoutParams = new LayoutParams((LayoutParams)this.mToggleBarRecyclerView.getLayoutParams());
    this.mToggle.addView(paramView, localLayoutParams);
  }

  private AnimatorSet getItemInAnimator(View paramView)
  {
    if (paramView == null)
      return null;
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(1.0F);
    LauncherViewPropertyAnimator localLauncherViewPropertyAnimator = new LauncherViewPropertyAnimator(paramView);
    localLauncherViewPropertyAnimator.scaleX(0.6F).scaleY(0.6F).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.5F));
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(290L);
    paramView.setInterpolator(new DecelerateInterpolator(1.5F));
    paramView.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localLauncherViewPropertyAnimator).after(0L);
    localAnimatorSet.play(paramView).after(0L);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    return localAnimatorSet;
  }

  public void doBarAnimationIn(int paramInt, final ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null);
    do
    {
      return;
      j = paramViewGroup.getChildCount();
    }
    while (j == 0);
    addInDragLayer(paramViewGroup, true);
    int i = j;
    if (j > 4)
      i = 4;
    if (this.mItemInAnimatorSet != null)
    {
      this.mItemInAnimatorSet.cancel();
      this.mItemInAnimatorSet = null;
    }
    this.mItemInAnimatorSet = new AnimatorSet();
    int j = 0;
    while (j < i)
    {
      new AnimatorSet();
      AnimatorSet localAnimatorSet = getItemInAnimator(paramViewGroup.getChildAt(j));
      if (localAnimatorSet != null)
        this.mItemInAnimatorSet.play(localAnimatorSet).after(paramInt);
      j += 1;
    }
    this.mItemInAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (ToggleBarShadow.this.mToggle != null)
          ToggleBarShadow.this.mToggle.removeView(paramViewGroup);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    this.mItemInAnimatorSet.start();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarShadow
 * JD-Core Version:    0.6.2
 */