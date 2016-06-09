package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.util.r;
import com.facebook.ads.internal.view.e;
import com.facebook.ads.internal.view.video.a;

public class MediaView extends RelativeLayout
{
  private final e a;
  private final a b;
  private boolean c = false;
  private boolean d = true;

  public MediaView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MediaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new e(paramContext);
    this.a.setLayoutParams(new LayoutParams(-1, -1));
    addView(this.a);
    this.b = new a(paramContext);
    paramContext = new LayoutParams(-1, -1);
    paramContext.addRule(13);
    this.b.setLayoutParams(paramContext);
    this.b.setAutoplay(this.d);
    addView(this.b);
  }

  private boolean a(NativeAd paramNativeAd)
  {
    return !r.a(paramNativeAd.a());
  }

  public boolean isAutoplay()
  {
    return this.d;
  }

  public void setAutoplay(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.b.setAutoplay(paramBoolean);
  }

  public void setNativeAd(NativeAd paramNativeAd)
  {
    paramNativeAd.b(true);
    paramNativeAd.setMediaViewAutoplay(this.d);
    if (this.c)
    {
      this.a.a(null, null);
      this.b.b();
      this.c = false;
    }
    if (a(paramNativeAd))
    {
      this.a.setVisibility(4);
      this.b.setVisibility(0);
      bringChildToFront(this.b);
      this.c = true;
    }
    while (paramNativeAd.getAdCoverImage() == null)
      try
      {
        this.b.setVideoPlayReportURI(paramNativeAd.b());
        this.b.setVideoTimeReportURI(paramNativeAd.c());
        this.b.setVideoURI(paramNativeAd.a());
        return;
      }
      catch (Exception paramNativeAd)
      {
        paramNativeAd.printStackTrace();
        return;
      }
    this.b.a();
    this.b.setVisibility(4);
    this.a.setVisibility(0);
    bringChildToFront(this.a);
    this.c = true;
    new k(this.a).execute(new String[] { paramNativeAd.getAdCoverImage().getUrl() });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.MediaView
 * JD-Core Version:    0.6.2
 */