package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import android.content.Intent;
import apc;

public class AllAppsShortcut extends apc
{
  protected Intent a()
  {
    return new Intent("android.intent.action.MAIN").setClass(this, AllAppsActivity.class);
  }

  protected int b()
  {
    return 2131231270;
  }

  protected int c()
  {
    return 2130837856;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.AllAppsShortcut
 * JD-Core Version:    0.6.2
 */