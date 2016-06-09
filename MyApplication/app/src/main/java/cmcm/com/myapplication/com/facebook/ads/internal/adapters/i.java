package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdActivity.Type;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.h;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class i extends InterstitialAdapter
{
  private final String a = UUID.randomUUID().toString();
  private Context b;
  private c c;
  private InterstitialAdapterListener d;
  private boolean e = false;
  private k f;
  private i.a g;
  private WebView h;

  private int a()
  {
    int i = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay().getRotation();
    if (this.g == i.a.b)
    {
      switch (i)
      {
      default:
        return 0;
      case 2:
      case 3:
      }
      return 8;
    }
    switch (i)
    {
    default:
      return 1;
    case 2:
    }
    return 9;
  }

  public void loadInterstitialAd(Context paramContext, InterstitialAdapterListener paramInterstitialAdapterListener, Map<String, Object> paramMap)
  {
    this.b = paramContext;
    this.d = paramInterstitialAdapterListener;
    this.f = k.a((JSONObject)paramMap.get("data"));
    if (f.a(paramContext, this.f))
      paramInterstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
    do
    {
      return;
      this.c = new c(paramContext, this.a, this, this.d);
      this.c.a();
      paramContext = this.f.h();
      if (paramContext.containsKey("orientation"))
        this.g = i.a.a(Integer.parseInt((String)paramContext.get("orientation")));
      this.e = true;
    }
    while (this.d == null);
    this.d.onInterstitialAdLoaded(this);
  }

  public void onDestroy()
  {
    if (this.c != null)
      this.c.b();
    if (this.h != null)
    {
      h.a(this.h);
      this.h.destroy();
      this.h = null;
    }
  }

  public boolean show()
  {
    if (!this.e)
    {
      if (this.d != null)
        this.d.onInterstitialError(this, AdError.INTERNAL_ERROR);
      return false;
    }
    Intent localIntent = new Intent(this.b, InterstitialAdActivity.class);
    this.f.a(localIntent);
    localIntent.putExtra("predefinedOrientationKey", a());
    localIntent.putExtra("adInterstitialUniqueId", this.a);
    localIntent.putExtra("viewType", InterstitialAdActivity.Type.DISPLAY);
    localIntent.addFlags(268435456);
    this.b.startActivity(localIntent);
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.i
 * JD-Core Version:    0.6.2
 */