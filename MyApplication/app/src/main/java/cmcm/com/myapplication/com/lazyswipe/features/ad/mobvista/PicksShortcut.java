package cmcm.com.myapplication.com.lazyswipe.features.ad.mobvista;

import android.content.Intent;
import apc;

public class PicksShortcut extends apc
{
  protected Intent a()
  {
    return new Intent("android.intent.action.MAIN").setClass(this, PicksActivity.class).putExtra("extra_external", true);
  }

  protected int b()
  {
    return 2131231173;
  }

  protected int c()
  {
    return 2130837858;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.ad.mobvista.PicksShortcut
 * JD-Core Version:    0.6.2
 */