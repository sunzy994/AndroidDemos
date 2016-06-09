package com.oppo.launcher;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class FolderItemView extends BubbleTextView
{
  private Folder mFolder;
  private Rect mFolderIconPosition = null;
  private int mWorkspaceTranslationX = 0;

  public FolderItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public Folder getFolder()
  {
    return this.mFolder;
  }

  public FolderIcon getFolderIcon()
  {
    if (this.mFolder == null)
      return null;
    return (FolderIcon)this.mFolder.getFolderIcon();
  }

  public Rect getFolderIconOriginalPos()
  {
    int i = this.mWorkspaceTranslationX;
    int j = this.mLauncher.getWorkspace().getScrollX();
    Rect localRect = new Rect();
    localRect.set(this.mFolderIconPosition);
    localRect.offset(i - j, 0);
    return localRect;
  }

  public void initPositionForOrderMore()
  {
    if (this.mLauncher != null)
    {
      if (this.mFolderIconPosition == null)
        this.mFolderIconPosition = new Rect();
      this.mLauncher.getDragLayer().getViewRectRelativeToSelf(getFolderIcon(), this.mFolderIconPosition);
      this.mWorkspaceTranslationX = this.mLauncher.getWorkspace().getScrollX();
    }
  }

  public void setFolder(Folder paramFolder)
  {
    this.mFolder = paramFolder;
  }

  public void setOrderMoreModeSelected(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setOrderMoreModeSelected(paramBoolean1, false);
    if ((paramBoolean2) && (getFolderIcon() != null))
      getFolderIcon().setOrderMoreModeSelected(paramBoolean1, false, false);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FolderItemView
 * JD-Core Version:    0.6.2
 */