package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import org.json.JSONObject;

public class xs extends WebView
  implements Callback, OnClickListener, OnTouchListener
{
  yb a;
  boolean b;
  long c;
  String d;
  private Handler e;

  public xs(Context paramContext)
  {
    this(paramContext, null);
  }

  public xs(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public xs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public static xs a(Context paramContext, yb paramyb, JSONObject paramJSONObject)
  {
    if (!arl.h(paramContext))
      return null;
    try
    {
      String str = paramJSONObject.getString("link");
      paramJSONObject = paramJSONObject.getString("code");
      paramContext = new xs(paramContext);
      paramContext.setOwner(paramyb);
      paramContext.d = paramJSONObject;
      paramContext.loadUrl(str);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      asp.b("Swipe.BannerView", "Failed to get banner url: " + paramContext.getMessage());
    }
    return null;
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void a()
  {
    this.e = new Handler(this);
    WebSettings localWebSettings = getSettings();
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      label22: setBackgroundColor(Color.argb(1, 0, 0, 0));
      try
      {
        setLayerType(1, null);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setWebViewClient(new xt(this, null));
        setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 19)
          setOnTouchListener(this);
        wd.h(getContext());
        return;
      }
      catch (Throwable localThrowable1)
      {
        while (true)
          Log.w("Swipe.BannerView", "Failed to set layer type of web view", localThrowable1);
      }
    }
    catch (Throwable localThrowable2)
    {
      break label22;
    }
  }

  public static void a(View paramView)
  {
    paramView.post(new Runnable()
    {
      public void run()
      {
        ((ViewGroup)xs.this.getParent()).removeView(xs.this);
      }
    });
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate().alpha(0.0F).setDuration(yd.a() / 2);
    if (paramBoolean)
      asv.b(localViewPropertyAnimator, new Runnable()
      {
        public void run()
        {
          xs.a(xs.this);
        }
      });
    localViewPropertyAnimator.start();
  }

  public static void b(View paramView)
  {
    a(paramView, false);
  }

  private void setOwner(yb paramyb)
  {
    this.a = paramyb;
  }

  public long getBannerShowedTime()
  {
    if (this.b)
      return System.currentTimeMillis() - this.c;
    return -1L;
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      this.e.removeMessages(2);
      this.a.c(true);
      return true;
    }
    if (2 == paramMessage.what)
    {
      onClick(this);
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((paramView instanceof xs)) && (paramMotionEvent.getAction() == 0))
      this.e.sendEmptyMessageDelayed(2, 400L);
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xs
 * JD-Core Version:    0.6.2
 */