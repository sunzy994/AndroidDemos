package cmcm.com.myapplication.com.lazyswipe.ui;

import amk;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import aqs;
import arj;
import com.lazyswipe.SwipeService;
import com.lazyswipe.features.guide.NewGuide;
import com.lazyswipe.features.guide.NewGuideActivity;
import com.lazyswipe.features.guide.UpgradeGuideActivity;
import vs;
import xm;

public class StartupActivity extends Activity
{
  private boolean a;

  private void a()
  {
    int j = vs.E(this);
    boolean bool;
    SharedPreferences localSharedPreferences;
    int k;
    if (j <= 0)
    {
      bool = true;
      amk.b(this, bool);
      localSharedPreferences = vs.a(this);
      if (!localSharedPreferences.contains("key_boot_completed_received"))
        localSharedPreferences.edit().putBoolean("key_boot_completed_received", true).apply();
      if ((!amk.b(this)) && (j <= 2) && (!SwipeService.f(this)))
      {
        k = InitialSettingsFragment.b(this);
        if ((localSharedPreferences.getBoolean("key_hint_auto_start", false)) || (localSharedPreferences.getBoolean("key_boot_completed_received", false)) || ((3 != k) && (2 != k)))
          break label396;
        amk.c(this, true);
        localSharedPreferences.edit().putBoolean("key_hint_auto_start", true).putInt("key_tutorial_step", 107).apply();
      }
    }
    label396: for (int i = 1; ; i = 0)
    {
      if ((i == 0) && (!localSharedPreferences.getBoolean("key_hint_protect_app", false)) && (3 == k) && (aqs.k(this)))
      {
        amk.c(this, true);
        localSharedPreferences.edit().putBoolean("key_hint_protect_app", true).putInt("key_tutorial_step", 109).apply();
      }
      if (((aqs.I()) || ((aqs.a()) && (Build.VERSION.SDK_INT >= 21))) && (!aqs.b(this)))
      {
        startActivity(new Intent(this, MainActivity.class));
        return;
        bool = false;
        break;
      }
      switch (j)
      {
      default:
      case 2:
      case 3:
      case 0:
      case 1:
      }
      while (true)
      {
        finish();
        return;
        if (!UpgradeGuideActivity.i)
        {
          MainActivity.a(this);
          if (j == 2)
            MainActivity.a(this, false);
        }
        else
        {
          UpgradeGuideActivity.i = false;
          UpgradeGuideActivity.a(this);
          continue;
          arj.a(new Runnable()
          {
            public void run()
            {
              StartupActivity.this.getContentResolver().query(xm.a, null, null, null, null);
            }
          });
          continue;
          if (localSharedPreferences.getInt("key_tutorial_step", 1) < NewGuide.getGuideEndStep())
          {
            if (NewGuide.getShowCount() > 1)
            {
              NewGuide.g();
              MainActivity.a(this);
            }
            else
            {
              MainActivity.a(this, false);
              NewGuideActivity.a(this);
            }
          }
          else
            MainActivity.a(this);
        }
      }
    }
  }

  public static void a(Context paramContext)
  {
    a(paramContext, false);
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, StartupActivity.class).addFlags(268435456);
    if (paramBoolean)
      localIntent.addFlags(16384);
    paramContext.startActivity(localIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.a = true;
  }

  protected void onResume()
  {
    super.onResume();
    if (this.a)
    {
      this.a = false;
      a();
    }
    while (isFinishing())
      return;
    finish();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.StartupActivity
 * JD-Core Version:    0.6.2
 */