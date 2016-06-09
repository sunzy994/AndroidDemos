package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Fragment;
import android.content.Intent;

public class AdvancedSettingsActivity extends FragmentContainer
{
  private boolean i = false;
  private AdvancedSettingsFragment k;

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
      this.i = true;
  }

  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    this.k = ((AdvancedSettingsFragment)paramFragment);
  }

  protected void onStart()
  {
    super.onStart();
    if (this.i)
      if (this.i)
        break label33;
    label33: for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      this.k.a();
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.AdvancedSettingsActivity
 * JD-Core Version:    0.6.2
 */