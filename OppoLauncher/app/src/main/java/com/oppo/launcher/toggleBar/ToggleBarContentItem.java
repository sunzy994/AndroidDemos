package com.oppo.launcher.toggleBar;

import android.graphics.drawable.Drawable;
import com.oppo.launcher.Launcher;

public class ToggleBarContentItem extends ToggleBarPreviewItem
{
  private static final String TAG = "ToggleBarContentItem";

  public ToggleBarContentItem()
  {
    super(null, null);
  }

  public ToggleBarContentItem(String paramString, Drawable paramDrawable)
  {
    super(paramString, paramDrawable);
  }

  public void handleOnClick()
  {
    ToggleBarManager localToggleBarManager = this.mLauncher.getToggleBarManager();
    if (localToggleBarManager == null)
      return;
    if (this.mId == 0)
    {
      localToggleBarManager.handleOnClick(ToggleBarManager.ToggleType.WIDGET_ALL);
      return;
    }
    localToggleBarManager.handleOnClick(ToggleBarManager.ToggleType.EFFECT);
  }

  public void initState()
  {
    this.mIsNeedShowLabel = false;
    this.mIsCanLongClick = false;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarContentItem
 * JD-Core Version:    0.6.2
 */