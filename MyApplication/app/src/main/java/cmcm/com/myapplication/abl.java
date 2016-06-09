package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeAD;
import com.qq.e.ads.nativ.NativeAD.NativeAdListener;
import com.qq.e.ads.nativ.NativeADDataRef;
import java.util.List;

public class abl
  implements abq, NativeAD.NativeAdListener
{
  public static final String a = "Swipe." + abl.class.getSimpleName();
  private final Context b;
  private final int c;
  private final NativeAD d;
  private NativeADDataRef e;
  private abr f;
  private Handler g = new Handler(Looper.getMainLooper());
  private View h;

  public abl(Context paramContext, int paramInt, abr paramabr)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramInt;
    this.d = new NativeAD(this.b, "1103461577", a(paramInt), this);
    this.d.setBrowserType(BrowserType.Default);
    this.d.setDownAPPConfirmPolicy(DownAPPConfirmPolicy.Default);
    a(paramabr);
  }

  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "8000909952532719";
    case 14:
    }
    return "8000909952532719";
  }

  public int a()
  {
    return 6;
  }

  public void a(abr paramabr)
  {
    this.f = paramabr;
  }

  public void a(View paramView)
  {
    a(paramView, null);
  }

  public void a(final View paramView, final Runnable paramRunnable)
  {
    this.h = paramView;
    if (this.e != null)
      this.e.onExposured(paramView);
    if (this.h != null)
      paramView.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (abl.a(abl.this) != null)
            abl.a(abl.this).onClicked(paramView);
          if (abl.b(abl.this) != null)
            abl.b(abl.this).a(abl.this);
          if (paramRunnable != null)
            paramRunnable.run();
        }
      });
  }

  public void a(boolean paramBoolean)
  {
    this.d.loadAD(1);
  }

  public void b()
  {
    if (this.h != null)
      this.h.setOnClickListener(null);
  }

  public String c()
  {
    if (!this.e.isAPP())
      return "查看详情";
    switch (this.e.getAPPStatus())
    {
    default:
      return "查看详情";
    case 0:
      return "点击下载";
    case 1:
      return "点击启动";
    case 2:
      return "点击更新";
    case 4:
      StringBuilder localStringBuilder = new StringBuilder().append("下载中:");
      if (this.e.getProgress() >= 0);
      for (int i = this.e.getProgress(); ; i = 0)
        return i + "%";
    case 8:
      return "点击安装";
    case 16:
    }
    return "下载失败,点击重试";
  }

  public String d()
  {
    return this.e.getTitle();
  }

  public String e()
  {
    return this.e.getDesc();
  }

  public String f()
  {
    return aro.a(this.b) + arh.a(g());
  }

  public String g()
  {
    return this.e.getIconUrl();
  }

  public String h()
  {
    return aro.a(this.b) + arh.a(i());
  }

  public String i()
  {
    return this.e.getImgUrl();
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
    b();
  }

  public void onADLoaded(List<NativeADDataRef> paramList)
  {
    if (asq.a(paramList))
      if (this.f != null)
        this.g.post(new Runnable()
        {
          public void run()
          {
            abl.b(abl.this).a(abl.this, true, 0, "");
          }
        });
    do
    {
      return;
      this.e = ((NativeADDataRef)paramList.get(0));
      vy.a(this.c, 1, 1, "qq");
    }
    while (this.f == null);
    this.g.post(new Runnable()
    {
      public void run()
      {
        abl.b(abl.this).a(abl.this, true);
      }
    });
  }

  public void onADStatusChanged(NativeADDataRef paramNativeADDataRef)
  {
  }

  public void onNoAD(final int paramInt)
  {
    vy.a(this.c, "qq", paramInt);
    if (this.f != null)
      this.g.post(new Runnable()
      {
        public void run()
        {
          abl.b(abl.this).a(abl.this, true, paramInt, "");
        }
      });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abl
 * JD-Core Version:    0.6.2
 */