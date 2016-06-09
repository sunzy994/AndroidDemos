package cmcm.com.myapplication.com.lazyswipe.features.guide;

import ade;
import aib;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import aph;
import com.lazyswipe.SwipeApplication;

public class NewGuideActivity extends aph
  implements OnClickListener
{
  private static final String i = "Swipe." + NewGuideActivity.class.getSimpleName();
  private final Handler j = new Handler();
  private boolean k;
  private boolean l;
  private final BroadcastReceiver m = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = 1;
      if (paramAnonymousIntent == null);
      label64: 
      do
      {
        return;
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          if (NewGuide.getShowCount() < 2)
          {
            if ((!NewGuideActivity.a(NewGuideActivity.this)) || (i == 0))
              break label64;
            NewGuideActivity.b(NewGuideActivity.this);
          }
          while (true)
          {
            NewGuideActivity.a(NewGuideActivity.this, false);
            return;
            i = 0;
            break;
            NewGuideActivity.c(NewGuideActivity.this);
            NewGuideActivity.this.finish();
          }
        }
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramAnonymousContext));
      NewGuideActivity.a(NewGuideActivity.this, true);
    }
  };

  public static void a(Context paramContext)
  {
    aib.b(SwipeApplication.c());
    Intent localIntent = new Intent(paramContext, NewGuideActivity.class);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  private boolean a(Intent paramIntent)
  {
    if (paramIntent == null);
    while (!paramIntent.getBooleanExtra("finish_me", false))
      return false;
    finish();
    return true;
  }

  public static void g()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Intent localIntent = new Intent(localSwipeApplication, NewGuideActivity.class);
    localIntent.putExtra("finish_me", true);
    localIntent.addFlags(268435456);
    localSwipeApplication.startActivity(localIntent);
  }

  private void h()
  {
    final Context localContext = getApplicationContext();
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        if (!NewGuideActivity.this.isFinishing())
          NewGuide.a(localContext, false);
      }
    }
    , 200L);
  }

  private void i()
  {
    NewGuide.g();
  }

  private void j()
  {
    if (this.k)
      return;
    try
    {
      this.k = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.m, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    if (!this.k)
      return;
    try
    {
      this.k = false;
      unregisterReceiver(this.m);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131755056:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (a(getIntent()))
      return;
    setContentView(2130968582);
    paramBundle = findViewById(2131755056);
    paramBundle.setOnClickListener(this);
    paramBundle.setBackgroundDrawable(ade.a());
    j();
    h();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    k();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.NewGuideActivity
 * JD-Core Version:    0.6.2
 */