package com.oppo.launcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.oppo.widget.OppoEditText;

public class FolderEditText extends OppoEditText
{
  private static final boolean DEBUG_ENABLE = false;
  private static final String TAG = "FolderEditText";
  public static long sBackPressCurTime = 0L;
  private BaseFolder mFolder;

  public FolderEditText(Context paramContext)
  {
    super(paramContext);
  }

  public FolderEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FolderEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mFolder.isFolderNameVisiable())
      sBackPressCurTime = System.currentTimeMillis();
    if (paramKeyEvent.getKeyCode() == 4)
      this.mFolder.doneEditingFolderName(true);
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }

  public void setFolder(BaseFolder paramBaseFolder)
  {
    this.mFolder = paramBaseFolder;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FolderEditText
 * JD-Core Version:    0.6.2
 */