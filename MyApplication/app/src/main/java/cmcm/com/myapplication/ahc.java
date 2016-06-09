package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdScrollView.AdViewProvider;
import com.facebook.ads.NativeAdsManager;
import java.util.List;

public class ahc extends agj<ahk>
{
  private static final String g = "Swipe." + ahc.class.getSimpleName();
  private static NativeAdsManager i;
  private final atq h;
  private View j = null;
  private View k = null;
  private boolean l = false;
  private final Context m;
  private final Handler n = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      }
      do
      {
        return;
        paramAnonymousMessage = (aqm)paramAnonymousMessage.obj;
      }
      while ((!(paramAnonymousMessage.b instanceof ImageView)) || (!atw.b(paramAnonymousMessage.e)));
      ImageView localImageView = (ImageView)paramAnonymousMessage.b;
      if (localImageView.getScaleType() != ScaleType.CENTER_CROP)
        localImageView.startAnimation(AnimationUtils.loadAnimation(ahc.this.getContext(), 17432576));
      localImageView.setScaleType(ScaleType.CENTER_CROP);
      ((ImageView)paramAnonymousMessage.b).setImageBitmap(paramAnonymousMessage.e);
    }
  };

  public ahc(Context paramContext, atq paramatq)
  {
    super(paramContext, (String)null);
    this.h = paramatq;
    this.m = paramContext;
  }

  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null)
      return;
    if (TextUtils.isEmpty(paramString))
    {
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(0);
    paramImageView.setTag(paramString);
    paramString = new aqm(paramImageView, null, paramString)
    {
      public void b()
      {
        Message localMessage = Message.obtain(ahc.a(ahc.this), 1);
        localMessage.obj = this;
        localMessage.sendToTarget();
      }
    };
    paramString = (aqm)this.h.a(paramString);
    if (paramString != null)
    {
      paramString.b();
      return;
    }
    paramImageView.setImageDrawable(getResources().getDrawable(2130837695));
    paramImageView.setScaleType(ScaleType.CENTER_INSIDE);
  }

  private void g()
  {
    this.l = true;
  }

  private View getAdScrollView()
  {
    NativeAdScrollView localNativeAdScrollView = new NativeAdScrollView(getContext(), i, new NativeAdScrollView.AdViewProvider()
    {
      public View createView(NativeAd paramAnonymousNativeAd, int paramAnonymousInt)
      {
        ahd localahd = new ahd(ahc.this, ahc.this.getContext());
        localahd.a(paramAnonymousNativeAd);
        localahd.a();
        return ahd.a(localahd);
      }

      public void destroyView(NativeAd paramAnonymousNativeAd, View paramAnonymousView)
      {
        if (paramAnonymousNativeAd != null)
        {
          paramAnonymousNativeAd.unregisterView();
          paramAnonymousNativeAd.destroy();
        }
      }
    });
    if ((localNativeAdScrollView.getChildAt(0) instanceof ViewPager))
    {
      localObject = (ViewPager)localNativeAdScrollView.getChildAt(0);
      ((ViewPager)localObject).setClipChildren(false);
      ((ViewPager)localObject).setOnPageChangeListener(new gi()
      {
        public void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          this.a.requestDisallowInterceptTouchEvent(true);
          if (this.a.getParent() != null)
            ((View)this.a.getParent()).invalidate();
        }

        public void b_(int paramAnonymousInt)
        {
        }

        public void c(int paramAnonymousInt)
        {
        }
      });
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    localNativeAdScrollView.setInset(5);
    ((RelativeLayout.LayoutParams)localObject).setMargins(asq.a(12.0F), 0, asq.a(12.0F), 0);
    localNativeAdScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localNativeAdScrollView.setClipChildren(false);
    return localNativeAdScrollView;
  }

  protected View a(int paramInt)
  {
    return null;
  }

  protected List<ahk> a(String paramString, agk paramagk)
  {
    return null;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahc
 * JD-Core Version:    0.6.2
 */