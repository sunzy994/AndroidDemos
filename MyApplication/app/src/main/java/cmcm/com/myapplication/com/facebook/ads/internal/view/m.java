package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity;

public class m
  implements h
{
  private g a;

  public m(InterstitialAdActivity paramInterstitialAdActivity, h.a parama)
  {
    this.a = new g(paramInterstitialAdActivity);
    paramInterstitialAdActivity = new RelativeLayout.LayoutParams(-1, -2);
    paramInterstitialAdActivity.addRule(15);
    this.a.setLayoutParams(paramInterstitialAdActivity);
    parama.a(this.a);
  }

  public void a()
  {
  }

  public void a(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramIntent.getStringExtra("videoURL");
    String str = paramIntent.getStringExtra("videoPlayReportURL");
    paramIntent = paramIntent.getStringExtra("videoTimeReportURL");
    this.a.setVideoPlayReportURI(str);
    this.a.setVideoTimeReportURI(paramIntent);
    this.a.setVideoURI(paramBundle);
    this.a.a();
  }

  public void a(Bundle paramBundle)
  {
  }

  public void b()
  {
  }

  public void c()
  {
    this.a.b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.m
 * JD-Core Version:    0.6.2
 */