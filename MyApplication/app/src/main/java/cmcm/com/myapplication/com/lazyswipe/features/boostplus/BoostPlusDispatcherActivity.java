package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BoostPlusDispatcherActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (Intent)getIntent().getParcelableExtra("package");
    finish();
    overridePendingTransition(0, 0);
    startActivity(paramBundle);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.BoostPlusDispatcherActivity
 * JD-Core Version:    0.6.2
 */