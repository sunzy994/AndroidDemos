package com.oppo.launcher;

import android.view.View;

public class CheckLongPressHelper
{
  private boolean mHasPerformedLongPress;
  private CheckForLongPress mPendingCheckForLongPress;
  private View mView;

  public CheckLongPressHelper(View paramView)
  {
    this.mView = paramView;
  }

  public void cancelLongPress()
  {
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress != null)
    {
      this.mView.removeCallbacks(this.mPendingCheckForLongPress);
      this.mPendingCheckForLongPress = null;
    }
  }

  public boolean hasPerformedLongPress()
  {
    return this.mHasPerformedLongPress;
  }

  public void postCheckForLongPress()
  {
    this.mHasPerformedLongPress = false;
    if (this.mPendingCheckForLongPress == null)
      this.mPendingCheckForLongPress = new CheckForLongPress();
    this.mView.postDelayed(this.mPendingCheckForLongPress, LauncherApplication.getLongPressTimeout());
  }

  class CheckForLongPress
    implements Runnable
  {
    CheckForLongPress()
    {
    }

    public void run()
    {
      if ((CheckLongPressHelper.this.mView.getParent() != null) && (CheckLongPressHelper.this.mView.hasWindowFocus()) && (!CheckLongPressHelper.this.mHasPerformedLongPress) && (CheckLongPressHelper.this.mView.performLongClick()))
      {
        CheckLongPressHelper.this.mView.setPressed(false);
        CheckLongPressHelper.access$102(CheckLongPressHelper.this, true);
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.CheckLongPressHelper
 * JD-Core Version:    0.6.2
 */