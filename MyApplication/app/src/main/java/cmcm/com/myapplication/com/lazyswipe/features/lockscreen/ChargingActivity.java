package cmcm.com.myapplication.com.lazyswipe.features.lockscreen;

import abd;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import aqr;
import ari;
import asj;
import asq;
import asr;
import ci;
import com.holaverse.charging.model.Battery;
import com.lazyswipe.SwipeApplication;
import java.text.DecimalFormat;
import ud;
import uh;
import ui;
import ul;
import uv;
import vs;
import vy;
import wq;

public class ChargingActivity extends ud
  implements uv
{
  private static final String a = "Swipe." + ChargingActivity.class.getSimpleName();
  private OmniChargingView b;
  private boolean c;
  private boolean d;
  private ui e = new ui()
  {
    public void a()
    {
      ChargingActivity.c();
    }

    public boolean a(int paramAnonymousInt)
    {
      return ChargingActivity.a(paramAnonymousInt);
    }
  };
  private long f;
  private BroadcastReceiver g;

  public static boolean a(int paramInt)
  {
    if (!abd.a());
    while ((!vs.c(SwipeApplication.c(), "key_charging_lockscreen", true)) || ((paramInt == 1) && (asq.a(SwipeApplication.c(), false)) && (!wq.e())))
      return true;
    return false;
  }

  public static void c()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    asq.d(localSwipeApplication, new Intent(localSwipeApplication, ChargingActivity.class));
  }

  private boolean e()
  {
    return uh.b(this) == 1;
  }

  private void f()
  {
    asq.b();
    aqr.a();
    long l1 = aqr.c(this);
    long l2 = l1 - this.f;
    float f1;
    if (l2 >= l1)
    {
      f1 = 50.0F;
      Math.round(f1);
      if (l2 <= 1073741824L)
        break label82;
    }
    label82: for (Object localObject1 = asq.b; ; localObject1 = asq.c)
    {
      localObject1 = asq.a(l2, (DecimalFormat)localObject1);
      if (l2 > 0L)
        break label89;
      return;
      f1 = (float)l2 * 100.0F / (float)this.f;
      break;
    }
    label89: Object localObject2 = ari.c(5, 9) + "%";
    String str = getString(2131230776, new Object[] { localObject1, localObject2 });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf((String)localObject1);
    int j = ((String)localObject1).length();
    localSpannableString.setSpan(new ForegroundColorSpan(-16732417), i, j + i, 33);
    i = str.indexOf((String)localObject2);
    j = ((String)localObject2).length();
    localSpannableString.setSpan(new ForegroundColorSpan(-16732417), i, j + i, 33);
    ((TextView)findViewById(2131755188)).setText(localSpannableString);
    localObject1 = findViewById(2131755187);
    localObject2 = findViewById(2131755168);
    ((View)localObject1).setVisibility(0);
    ((View)localObject1).setTranslationY(0.0F);
    ((View)localObject1).animate().translationY(-((View)localObject2).getBottom() + ul.b(this, 15.0F)).setDuration(900L).setInterpolator(new OvershootInterpolator()).setListener(null);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        this.a.animate().alpha(0.0F).setDuration(250L).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            ChargingActivity.3.this.a.setTranslationY(0.0F);
            ChargingActivity.3.this.a.setVisibility(8);
          }
        });
      }
    }
    , 3200L);
  }

  public void a()
  {
    this.b.c();
  }

  public void a(Battery paramBattery)
  {
    if (paramBattery != null)
      this.b.a(paramBattery);
  }

  public void b()
  {
    this.b.d();
  }

  protected void d()
  {
    this.f = aqr.c(this);
    IntentFilter localIntentFilter;
    if (this.g == null)
    {
      this.g = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          try
          {
            if (!ChargingActivity.this.isFinishing())
              ChargingActivity.a(ChargingActivity.this);
            ci.a(paramAnonymousContext).a(this);
            ChargingActivity.a(ChargingActivity.this, null);
            return;
          }
          catch (Exception paramAnonymousContext)
          {
          }
        }
      };
      localIntentFilter = new IntentFilter("ACTION_BOOST_LOGIC_FINISH");
    }
    try
    {
      ci.a(this).a(this.g, localIntentFilter);
      label50: asj.a(System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }

  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }

  public void onClose(View paramView)
  {
    if (!isFinishing())
      finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(2130968613);
    this.b = ((OmniChargingView)asr.a(this, 2131755163));
    this.b.setDelegate(this);
    this.d = true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    vy.b(this, "B45");
    try
    {
      ci.a(this).a(this.g);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }

  protected void onResume()
  {
    super.onResume();
    this.b.f();
  }

  protected void onStart()
  {
    super.onStart();
    this.c = e();
    if ((this.c) && (this.d))
    {
      this.b.setNeedBoost(true);
      d();
    }
    while (true)
    {
      if (!this.c)
        this.b.e();
      this.b.b();
      this.d = false;
      return;
      this.b.setNeedBoost(false);
    }
  }

  protected void onStop()
  {
    super.onStop();
    this.b.a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.lockscreen.ChargingActivity
 * JD-Core Version:    0.6.2
 */