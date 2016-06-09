package com.oppo.launcher.toggleBar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LauncherElementInstructions extends ImageView
  implements ToggleBarRecyclerView.OnElementViewVisibilityListener
{
  public static final String TAG = "LauncherElementInstructions";

  public LauncherElementInstructions(Context paramContext)
  {
    super(paramContext);
  }

  public LauncherElementInstructions(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public LauncherElementInstructions(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void onVisible(int paramInt)
  {
    setVisibility(paramInt);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.LauncherElementInstructions
 * JD-Core Version:    0.6.2
 */