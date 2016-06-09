package com.oppo.launcher.widget;

import android.app.Dialog;
import android.content.Context;

public class OppoDialog extends Dialog
{
  protected int mBackgroundResId;
  protected int mLayoutId;

  public OppoDialog(Context paramContext)
  {
    super(paramContext);
  }

  public OppoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public int getBackgroundResourse()
  {
    if (this.mBackgroundResId > 0)
      return this.mBackgroundResId;
    return 0;
  }

  public int getLayoutId(int paramInt)
  {
    if (this.mLayoutId > 0)
      return this.mLayoutId;
    return 0;
  }

  public void setBackgroundResourse(int paramInt)
  {
    this.mBackgroundResId = paramInt;
  }

  public void setLayoutId(int paramInt)
  {
    this.mLayoutId = paramInt;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.widget.OppoDialog
 * JD-Core Version:    0.6.2
 */