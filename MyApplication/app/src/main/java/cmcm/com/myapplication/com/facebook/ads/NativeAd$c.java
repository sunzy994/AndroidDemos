package cmcm.com.myapplication.com.facebook.ads;

import com.facebook.ads.internal.adapters.b;

class NativeAd$c extends b
{
  private NativeAd$c(NativeAd paramNativeAd)
  {
  }

  public boolean a()
  {
    return false;
  }

  public void d()
  {
    if (NativeAd.m(this.a) != null)
      NativeAd.m(this.a).onLoggingImpression(this.a);
    if (((NativeAd.a(this.a) instanceof ImpressionListener)) && (NativeAd.a(this.a) != NativeAd.m(this.a)))
      ((ImpressionListener)NativeAd.a(this.a)).onLoggingImpression(this.a);
  }

  public void e()
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.NativeAd.c
 * JD-Core Version:    0.6.2
 */