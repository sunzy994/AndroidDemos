package cmcm.com.myapplication.com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ci;
import com.facebook.ads.internal.adapters.m;
import com.facebook.ads.internal.adapters.n;
import java.util.HashMap;
import java.util.Map;

class NativeAd$b extends BroadcastReceiver
{
  private boolean b;

  private NativeAd$b(NativeAd paramNativeAd)
  {
  }

  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.ads.native.impression:" + NativeAd.o(this.a));
    localIntentFilter.addAction("com.facebook.ads.native.click:" + NativeAd.o(this.a));
    ci.a(NativeAd.d(this.a)).a(this, localIntentFilter);
    this.b = true;
  }

  public void b()
  {
    if (!this.b)
      return;
    try
    {
      ci.a(NativeAd.d(this.a)).a(this);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction().split(":")[0];
    if ("com.facebook.ads.native.impression".equals(paramContext))
      NativeAd.h(this.a).a();
    while (!"com.facebook.ads.native.click".equals(paramContext))
      return;
    paramContext = new HashMap();
    paramContext.put("mil", Boolean.valueOf(true));
    NativeAd.f(this.a).b(paramContext);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAd.b
 * JD-Core Version:    0.6.2
 */