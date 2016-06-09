package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import acd;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aph;
import asq;
import vs;
import vv;

public class AllAppsActivity extends aph
{
  private static void a(Context paramContext)
  {
    if (vs.c(paramContext, "key_send_all_apps_shortcut", true))
    {
      vs.b(paramContext, "key_send_all_apps_shortcut", false);
      asq.a(paramContext, new ComponentName(paramContext, AllAppsActivity.class), 2131231270, 2130837856);
    }
  }

  private static void b(Activity paramActivity, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    AppsContentView localAppsContentView = (AppsContentView)LayoutInflater.from(paramFrameLayout.getContext()).inflate(2130968594, null);
    localAppsContentView.setLaunchedFromShortcut(paramBoolean);
    localAppsContentView.setCallback(new acd()
    {
      public void a()
      {
        AllAppsActivity.this.finish();
      }

      public void b()
      {
        AllAppsActivity.this.finish();
      }
    });
    paramFrameLayout.addView(localAppsContentView, new FrameLayout.LayoutParams(-1, -1, 80));
    localAppsContentView.a();
  }

  protected void onCreate(final Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    a(this);
    final boolean bool = getIntent().getBooleanExtra("extra.SHORTCUT_LAUNCH", false);
    paramBundle = new FrameLayout(this);
    paramBundle.setBackgroundColor(-1442840576);
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    new Handler().post(new Runnable()
    {
      public void run()
      {
        AllAppsActivity.a(AllAppsActivity.this, paramBundle, bool);
      }
    });
    paramBundle = vv.a();
    if (bool)
      i = 1;
    paramBundle.a("AllApps launch", "shortcut", i);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.AllAppsActivity
 * JD-Core Version:    0.6.2
 */