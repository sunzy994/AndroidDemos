package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class abk
  implements abq, OnClickListener, AdListener
{
  private static final String a = "Swipe." + abk.class.getSimpleName();
  private final Context b;
  private final int c;
  private final String d;
  private final NativeAd e;
  private abr f;
  private String g;
  private String h;
  private String i;
  private String j;

  public abk(Context paramContext, int paramInt, String paramString, abr paramabr)
  {
    this.b = paramContext.getApplicationContext();
    this.d = paramString;
    this.c = paramInt;
    this.e = new NativeAd(this.b, this.d);
    this.e.setAdListener(this);
    a(paramabr);
  }

  private void n()
  {
    int k = 0;
    String str = String.valueOf(Calendar.getInstance().get(6));
    SharedPreferences localSharedPreferences = vs.a(this.b);
    Object localObject = localSharedPreferences.getStringSet("key_cover_urls", null);
    if (localObject == null)
    {
      localObject = new HashSet(2);
      ((Set)localObject).add(this.h);
      ((Set)localObject).add(str);
    }
    while (k != 0)
    {
      vy.a(this.b, "CR", "1");
      return;
      if (!((Set)localObject).contains(str))
      {
        ((Set)localObject).clear();
        ((Set)localObject).add(str);
        ((Set)localObject).add(this.h);
      }
      else if (((Set)localObject).contains(this.h))
      {
        k = 1;
      }
      else
      {
        ((Set)localObject).add(this.h);
      }
    }
    vy.a(this.b, "CR", "0");
    localSharedPreferences.edit().putStringSet("key_cover_urls", (Set)localObject).apply();
  }

  public int a()
  {
    return 2;
  }

  public void a(abr paramabr)
  {
    this.f = paramabr;
  }

  public void a(View paramView)
  {
    this.e.registerViewForInteraction(paramView);
  }

  public void a(View paramView, Runnable paramRunnable)
  {
  }

  public void a(boolean paramBoolean)
  {
    this.e.loadAd();
  }

  public void b()
  {
    this.e.unregisterView();
  }

  public String c()
  {
    return this.e.getAdCallToAction();
  }

  public String d()
  {
    return this.e.getAdTitle();
  }

  public String e()
  {
    return this.e.getAdBody();
  }

  public String f()
  {
    return this.i;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.j;
  }

  public String i()
  {
    return this.h;
  }

  public Drawable j()
  {
    return null;
  }

  public Drawable k()
  {
    return null;
  }

  public long l()
  {
    return 3600000L;
  }

  public void m()
  {
    this.e.destroy();
  }

  public void onAdClicked(Ad paramAd)
  {
    if (this.f != null)
      this.f.a(this);
  }

  public void onAdLoaded(Ad paramAd)
  {
    paramAd = this.e.getAdIcon();
    if (paramAd != null)
    {
      this.g = paramAd.getUrl();
      this.i = (aro.a(this.b) + arh.a(this.g));
    }
    paramAd = this.e.getAdCoverImage();
    if (paramAd != null)
    {
      this.h = paramAd.getUrl();
      if (aav.b(2) != 0)
        n();
      this.j = (aro.a(this.b) + arh.a(this.h));
    }
    vy.a(this.c, 1, 1, "fb");
    if (this.f != null)
      this.f.a(this, true);
  }

  public void onClick(View paramView)
  {
  }

  public void onError(Ad paramAd, AdError paramAdError)
  {
    vy.b(this.c, paramAdError.getErrorCode());
    if (this.f != null)
      this.f.a(this, true, paramAdError.getErrorCode(), paramAdError.getErrorMessage());
  }

  public String toString()
  {
    return "FacebookNativeAd{title=" + this.e.getAdTitle() + ";body=" + this.e.getAdBody() + ";CTA=" + this.e.getAdCallToAction() + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abk
 * JD-Core Version:    0.6.2
 */