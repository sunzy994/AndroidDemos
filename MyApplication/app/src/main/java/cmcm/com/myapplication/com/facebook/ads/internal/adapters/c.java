package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ci;
import com.facebook.ads.AdError;

public class c extends BroadcastReceiver
{
  private String a;
  private Context b;
  private InterstitialAdapterListener c;
  private InterstitialAdapter d;

  public c(Context paramContext, String paramString, InterstitialAdapter paramInterstitialAdapter, InterstitialAdapterListener paramInterstitialAdapterListener)
  {
    this.b = paramContext;
    this.a = paramString;
    this.c = paramInterstitialAdapterListener;
    this.d = paramInterstitialAdapter;
  }

  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.a);
    localIntentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.a);
    localIntentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.a);
    localIntentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.a);
    localIntentFilter.addAction("com.facebook.ads.interstitial.error:" + this.a);
    ci.a(this.b).a(this, localIntentFilter);
  }

  public void b()
  {
    try
    {
      ci.a(this.b).a(this);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction().split(":")[0];
    if ((this.c == null) || (paramContext == null));
    do
    {
      return;
      if ("com.facebook.ads.interstitial.clicked".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("com.facebook.ads.interstitial.ad.click.url");
        boolean bool = paramIntent.getBooleanExtra("com.facebook.ads.interstitial.ad.player.handles.click", true);
        this.c.onInterstitialAdClicked(this.d, paramContext, bool);
        return;
      }
      if ("com.facebook.ads.interstitial.dismissed".equals(paramContext))
      {
        this.c.onInterstitialAdDismissed(this.d);
        return;
      }
      if ("com.facebook.ads.interstitial.displayed".equals(paramContext))
      {
        this.c.onInterstitialAdDisplayed(this.d);
        return;
      }
      if ("com.facebook.ads.interstitial.impression.logged".equals(paramContext))
      {
        this.c.onInterstitialLoggingImpression(this.d);
        return;
      }
    }
    while (!"com.facebook.ads.interstitial.error".equals(paramContext));
    this.c.onInterstitialError(this.d, AdError.INTERNAL_ERROR);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.c
 * JD-Core Version:    0.6.2
 */