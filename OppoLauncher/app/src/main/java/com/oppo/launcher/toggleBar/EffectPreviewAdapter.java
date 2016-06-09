package com.oppo.launcher.toggleBar;

import com.oppo.launcher.Launcher;
import java.util.ArrayList;

public class EffectPreviewAdapter extends ToggleBarPreviewAdapter
{
  public EffectPreviewAdapter(Launcher paramLauncher)
  {
    super(paramLauncher);
    this.mToggleBarPreviewList = ToggleBarPreviewUtils.getEffectPreviews(paramLauncher);
  }

  public EffectPreviewAdapter(ArrayList<ToggleBarPreviewItem> paramArrayList, Launcher paramLauncher)
  {
    super(paramArrayList, paramLauncher);
  }

  public void refreshUsingSign(ToggleBarPreviewItem paramToggleBarPreviewItem)
  {
    if (this.mToggleBarPreviewList != null)
    {
      int i = 0;
      while (i < this.mToggleBarPreviewList.size())
      {
        ((ToggleBarPreviewItem)this.mToggleBarPreviewList.get(i)).mInUsing = false;
        i += 1;
      }
    }
    if (paramToggleBarPreviewItem != null)
      paramToggleBarPreviewItem.mInUsing = true;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.EffectPreviewAdapter
 * JD-Core Version:    0.6.2
 */