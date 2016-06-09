package cmcm.com.myapplication.com.facebook.ads.internal.view.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdActivity.Type;
import com.facebook.ads.NativeAdVideoActivity;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.adapters.d.a;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.o;
import java.util.HashMap;

public class a extends FrameLayout
{
  private com.facebook.ads.internal.view.video.support.a a;
  private d b;
  private a.c c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  private boolean h;
  private int i;
  private Handler j;
  private Handler k;
  private Runnable l;
  private Runnable m;
  private float n;

  public a(Context paramContext)
  {
    super(paramContext);
    e();
  }

  private void a(Context paramContext, Intent paramIntent)
  {
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
    paramIntent.putExtra("useNativeCloseButton", true);
    paramIntent.putExtra("viewType", InterstitialAdActivity.Type.VIDEO);
    paramIntent.putExtra("videoURL", getVideoURI());
    paramIntent.putExtra("videoPlayReportURL", getVideoPlayReportURI());
    paramIntent.putExtra("videoTimeReportURL", getVideoTimeReportURI());
    paramIntent.putExtra("predefinedOrientationKey", 13);
    paramIntent.addFlags(268435456);
  }

  private boolean a(Class<?> paramClass)
  {
    try
    {
      Context localContext = getContext();
      paramClass = new Intent(localContext, paramClass);
      a(localContext, paramClass);
      localContext.startActivity(paramClass);
      return true;
    }
    catch (Exception paramClass)
    {
      c.a(com.facebook.ads.internal.util.b.a(paramClass, "Error occurred while loading fullscreen video activity."));
    }
    return false;
  }

  private void e()
  {
    this.n = 0.0F;
    Object localObject1 = new RelativeLayout(getContext());
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).setGravity(17);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    setBackgroundColor(0);
    localObject2 = getContext();
    this.a = new com.facebook.ads.internal.view.video.support.a((Context)localObject2);
    this.a.setBackgroundColor(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(9, -1);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setFrameVideoViewListener(new com.facebook.ads.internal.view.video.support.b()
    {
      public void a(MediaPlayer paramAnonymousMediaPlayer)
      {
        MediaPlayer localMediaPlayer = paramAnonymousMediaPlayer;
        try
        {
          if (paramAnonymousMediaPlayer.isPlaying())
          {
            paramAnonymousMediaPlayer.stop();
            paramAnonymousMediaPlayer.release();
            localMediaPlayer = new MediaPlayer();
          }
          localMediaPlayer.setVolume(a.this.getVolume(), a.this.getVolume());
          localMediaPlayer.setLooping(false);
          if (jdField_this.getAutoplay())
            jdField_this.c();
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          paramAnonymousMediaPlayer.printStackTrace();
        }
      }
    });
    ((RelativeLayout)localObject1).addView(this.a);
    addView((View)localObject1);
    this.k = new Handler();
    this.l = new a.b(this);
    this.k.postDelayed(this.l, 250L);
    this.j = new Handler();
    this.m = new a.a(this);
    this.j.postDelayed(this.m, 250L);
    this.b = new d((Context)localObject2, this, 50, true, new d.a()
    {
      public void a()
      {
        if (jdField_this.getAutoplay())
          a.this.c();
      }

      public void b()
      {
        a.this.d();
      }
    });
    this.b.a(0);
    this.b.b(250);
    this.b.a();
    setOnTouchListenerInternal(new OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() == 1) && (jdField_this.getVideoURI() != null))
        {
          a.a(a.this);
          return true;
        }
        return false;
      }
    });
    setOnClickListenerInternal(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (jdField_this.getVideoURI() != null)
          a.a(a.this);
      }
    });
    this.c = new a.c(this, (Context)localObject2);
    localObject1 = new LayoutParams(100, 100, 80);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.c.setOnTouchListener(new OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if (a.c.a(a.b(a.this)))
          {
            a.this.c();
            return true;
          }
          a.this.d();
          return true;
        }
        return false;
      }
    });
    this.c.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.c.a(a.b(a.this)))
        {
          a.this.c();
          return;
        }
        a.this.d();
      }
    });
    addView(this.c);
  }

  private void f()
  {
    if ((!this.h) && (getVideoTimeReportURI() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("time", Integer.toString(this.i / 1000));
      localHashMap.put("inline", "1");
      new o(localHashMap).execute(new String[] { getVideoTimeReportURI() });
      this.h = true;
      this.i = 0;
    }
  }

  private void g()
  {
    if (!a(NativeAdVideoActivity.class))
      a(InterstitialAdActivity.class);
  }

  private void setOnClickListenerInternal(OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }

  private void setOnTouchListenerInternal(OnTouchListener paramOnTouchListener)
  {
    super.setOnTouchListener(paramOnTouchListener);
  }

  public void a()
  {
    if (this.i > 0)
    {
      f();
      this.i = 0;
    }
  }

  public void b()
  {
    this.d = null;
  }

  public void c()
  {
    a.c.a(this.c, false);
    this.a.a();
  }

  public void d()
  {
    a.c.a(this.c, true);
    this.a.b();
  }

  public boolean getAutoplay()
  {
    return this.g;
  }

  public String getVideoPlayReportURI()
  {
    return this.e;
  }

  public String getVideoTimeReportURI()
  {
    return this.f;
  }

  public String getVideoURI()
  {
    return this.d;
  }

  float getVolume()
  {
    return this.n;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f();
    this.b.b();
  }

  public void setAutoplay(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void setOnClickListener(OnClickListener paramOnClickListener)
  {
  }

  public void setOnTouchListener(OnTouchListener paramOnTouchListener)
  {
  }

  public void setVideoPlayReportURI(String paramString)
  {
    this.e = paramString;
  }

  public void setVideoTimeReportURI(String paramString)
  {
    a();
    this.f = paramString;
  }

  public void setVideoURI(String paramString)
  {
    this.d = paramString;
    if (paramString != null)
    {
      this.a.setup(Uri.parse(paramString));
      if (this.g)
        this.a.a();
    }
  }

  void setVolume(float paramFloat)
  {
    this.n = paramFloat;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.video.a
 * JD-Core Version:    0.6.2
 */