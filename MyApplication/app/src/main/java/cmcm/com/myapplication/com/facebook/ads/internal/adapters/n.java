package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class n
  implements AdAdapter
{
  public abstract void a(int paramInt);

  public abstract void a(Context paramContext, o paramo, Map<String, Object> paramMap);

  public abstract void a(Map<String, Object> paramMap);

  public abstract void b(Map<String, Object> paramMap);

  public abstract boolean d();

  public abstract boolean e();

  public abstract boolean f();

  public abstract boolean g();

  public final AdPlacementType getPlacementType()
  {
    return AdPlacementType.NATIVE;
  }

  public abstract int h();

  public abstract int i();

  public abstract int j();

  public abstract NativeAd.Image k();

  public abstract NativeAd.Image l();

  public abstract NativeAdViewAttributes m();

  public abstract String n();

  public abstract String o();

  public abstract String p();

  public abstract String q();

  public abstract String r();

  public abstract NativeAd.Rating s();

  public abstract NativeAd.Image t();

  public abstract String u();

  public abstract String v();

  public abstract String w();

  public abstract String x();

  public abstract AdExtras y();

  public abstract boolean z();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.n
 * JD-Core Version:    0.6.2
 */