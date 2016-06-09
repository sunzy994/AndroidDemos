package com.oppo.launcher.toggleBar;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.oppo.launcher.Launcher;

public class ToggleBarPreviewItem
{
  private static final String TAG = "ToggleBarPreviewItem";
  public boolean mCanRepeatedlySet = false;
  public int mId = -1;
  public boolean mInUsing = false;
  public boolean mIsCanLongClick = false;
  public boolean mIsNeedShowLabel = true;
  public Launcher mLauncher;
  public Drawable mThumbnail = null;
  public Bitmap mThumbnailBitmap = null;
  public String mTitle;

  public ToggleBarPreviewItem()
  {
    this(null, null);
  }

  public ToggleBarPreviewItem(String paramString, Drawable paramDrawable)
  {
    this(paramString, paramDrawable, false);
  }

  public ToggleBarPreviewItem(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    this.mTitle = paramString;
    this.mThumbnail = paramDrawable;
    this.mInUsing = paramBoolean;
    initState();
  }

  public void dealWithWhenAdded()
  {
  }

  public boolean getInUsing()
  {
    return this.mInUsing;
  }

  public Object getTag()
  {
    return null;
  }

  public Drawable getThumbnail()
  {
    return this.mThumbnail;
  }

  public void handleOnClick()
  {
  }

  public void initState()
  {
  }

  public void recycle()
  {
    if (this.mThumbnail != null)
    {
      this.mThumbnail.setCallback(null);
      this.mThumbnail = null;
    }
    if (this.mThumbnailBitmap != null)
    {
      this.mThumbnailBitmap.recycle();
      this.mThumbnailBitmap = null;
    }
  }

  public void setInUsing(boolean paramBoolean)
  {
    this.mInUsing = paramBoolean;
  }

  public void setLauncher(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarPreviewItem
 * JD-Core Version:    0.6.2
 */