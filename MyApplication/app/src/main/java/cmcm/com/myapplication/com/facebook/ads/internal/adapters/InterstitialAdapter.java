package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class InterstitialAdapter
  implements AdAdapter
{
  public final AdPlacementType getPlacementType()
  {
    return AdPlacementType.INTERSTITIAL;
  }

  public abstract void loadInterstitialAd(Context paramContext, InterstitialAdapterListener paramInterstitialAdapterListener, Map<String, Object> paramMap);

  public abstract boolean show();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.InterstitialAdapter
 * JD-Core Version:    0.6.2
 */