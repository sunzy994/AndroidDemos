package cmcm.com.myapplication.com.lazyswipe.features.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import aph;
import asq;
import com.lazyswipe.SwipeApplication;

public class UpgradeGuideActivity extends aph
{
  public static boolean i = false;

  public static void a(Context paramContext)
  {
    asq.d(paramContext, new Intent(paramContext, UpgradeGuideActivity.class));
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent == null);
    while (!paramIntent.getBooleanExtra("finish_me", false))
      return;
    finish();
  }

  public static void g()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Intent localIntent = new Intent(localSwipeApplication, UpgradeGuideActivity.class);
    localIntent.putExtra("finish_me", true);
    localIntent.addFlags(268435456);
    localSwipeApplication.startActivity(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getIntent());
    setContentView(2130968587);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.UpgradeGuideActivity
 * JD-Core Version:    0.6.2
 */