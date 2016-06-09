package cmcm.com.myapplication.com.facebook.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.util.g;

public class AdChoicesView extends RelativeLayout
{
  private final Context a;
  private final NativeAd b;
  private final DisplayMetrics c;
  private boolean d = false;
  private TextView e;

  public AdChoicesView(Context paramContext, NativeAd paramNativeAd)
  {
    this(paramContext, paramNativeAd, false);
  }

  public AdChoicesView(Context paramContext, NativeAd paramNativeAd, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramNativeAd;
    this.c = this.a.getResources().getDisplayMetrics();
    paramContext = this.b.getAdChoicesIcon();
    paramNativeAd = new LayoutParams(-2, -2);
    setOnTouchListener(new OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (AdChoicesView.a(AdChoicesView.this))
            g.a(AdChoicesView.b(AdChoicesView.this), Uri.parse(AdChoicesView.c(AdChoicesView.this).getAdChoicesLinkUrl()));
          while (true)
          {
            return true;
            AdChoicesView.d(AdChoicesView.this);
          }
        }
        return false;
      }
    });
    this.e = new TextView(this.a);
    addView(this.e);
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    if (paramBoolean)
    {
      localLayoutParams.addRule(11, a(paramContext).getId());
      localLayoutParams.width = 0;
      paramNativeAd.width = Math.round((paramContext.getWidth() + 4) * this.c.density);
      paramNativeAd.height = Math.round((paramContext.getHeight() + 2) * this.c.density);
    }
    for (this.d = false; ; this.d = true)
    {
      setLayoutParams(paramNativeAd);
      localLayoutParams.addRule(15, -1);
      this.e.setLayoutParams(localLayoutParams);
      this.e.setSingleLine();
      this.e.setText("AdChoices");
      this.e.setTextSize(10.0F);
      this.e.setTextColor(-4341303);
      return;
    }
  }

  private ImageView a(NativeAd.Image paramImage)
  {
    ImageView localImageView = new ImageView(this.a);
    addView(localImageView);
    LayoutParams localLayoutParams = new LayoutParams(Math.round(paramImage.getWidth() * this.c.density), Math.round(paramImage.getHeight() * this.c.density));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(Math.round(4.0F * this.c.density), Math.round(this.c.density * 2.0F), Math.round(this.c.density * 2.0F), Math.round(this.c.density * 2.0F));
    localImageView.setLayoutParams(localLayoutParams);
    NativeAd.downloadAndDisplayImage(paramImage, localImageView);
    return localImageView;
  }

  private void a()
  {
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(this.e.getTextSize());
    final int j = Math.round(((Paint)localObject).measureText("AdChoices") + 4.0F * this.c.density);
    final int i = getWidth();
    j += i;
    this.d = true;
    localObject = new Animation()
    {
      protected void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        int i = (int)(i + (j - i) * paramAnonymousFloat);
        AdChoicesView.this.getLayoutParams().width = i;
        AdChoicesView.this.requestLayout();
        AdChoicesView.e(AdChoicesView.this).getLayoutParams().width = (i - i);
        AdChoicesView.e(AdChoicesView.this).requestLayout();
      }

      public boolean willChangeBounds()
      {
        return true;
      }
    };
    ((Animation)localObject).setAnimationListener(new AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (!AdChoicesView.a(AdChoicesView.this))
              return;
            AdChoicesView.a(AdChoicesView.this, false);
            Animation local1 = new Animation()
            {
              protected void applyTransformation(float paramAnonymous3Float, Transformation paramAnonymous3Transformation)
              {
                int i = (int)(AdChoicesView.3.this.a + (AdChoicesView.3.this.b - AdChoicesView.3.this.a) * paramAnonymous3Float);
                AdChoicesView.this.getLayoutParams().width = i;
                AdChoicesView.this.requestLayout();
                AdChoicesView.e(AdChoicesView.this).getLayoutParams().width = (i - AdChoicesView.3.this.b);
                AdChoicesView.e(AdChoicesView.this).requestLayout();
              }

              public boolean willChangeBounds()
              {
                return true;
              }
            };
            local1.setDuration(300L);
            local1.setFillAfter(true);
            AdChoicesView.this.startAnimation(local1);
          }
        }
        , 3000L);
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    });
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.AdChoicesView
 * JD-Core Version:    0.6.2
 */