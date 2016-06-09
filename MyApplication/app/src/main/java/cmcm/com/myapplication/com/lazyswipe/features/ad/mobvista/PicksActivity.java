package cmcm.com.myapplication.com.lazyswipe.features.ad.mobvista;

import aby;
import android.content.Intent;
import android.os.Bundle;
import aov;
import vy;

public class PicksActivity extends aov
{
  private aby i;
  private boolean j = true;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = new aby(this);
    this.i.a(6);
    if ((getIntent() != null) && (!getIntent().getBooleanExtra("extra_external", false)))
      vy.b(this, "B22");
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      this.i.a();
      this.i = null;
    }
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    if (this.j)
    {
      this.j = false;
      return;
    }
    finish();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.ad.mobvista.PicksActivity
 * JD-Core Version:    0.6.2
 */