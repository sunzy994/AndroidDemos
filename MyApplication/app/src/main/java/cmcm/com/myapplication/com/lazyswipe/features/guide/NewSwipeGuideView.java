package cmcm.com.myapplication.com.lazyswipe.features.guide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aqs;
import ast;
import atw;
import avd;
import com.lazyswipe.SwipeService;
import vu;

public class NewSwipeGuideView extends FrameLayout
{
  private static final String a = "Swipe." + NewSwipeGuideView.class.getSimpleName();
  private static NewSwipeGuideView b;
  private avd c;
  private avd d;
  private WindowManager.LayoutParams e;
  private boolean f;
  private final BroadcastReceiver g = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null);
      do
      {
        return;
        paramAnonymousContext = paramAnonymousIntent.getAction();
      }
      while ((!"android.intent.action.SCREEN_OFF".equals(paramAnonymousContext)) && (!"detach_new_guide".equals(paramAnonymousContext)));
      NewSwipeGuideView.a();
    }
  };
  private int h;

  public NewSwipeGuideView(Context paramContext)
  {
    super(paramContext);
  }

  public NewSwipeGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void a()
  {
    if (b != null)
    {
      if (aqs.g())
        NewGuideActivity.g();
      b.c();
      b = null;
    }
  }

  public static void a(Context paramContext)
  {
    if (b == null)
      b = (NewSwipeGuideView)LayoutInflater.from(paramContext).inflate(2130968749, null);
    b.b();
  }

  public static void b(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("detach_new_guide"));
  }

  private void d()
  {
    if (this.f)
      return;
    try
    {
      this.f = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("detach_new_guide");
      getContext().registerReceiver(this.g, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void e()
  {
    if (!this.f)
      return;
    try
    {
      this.f = false;
      getContext().unregisterReceiver(this.g);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    setLayerType(2, null);
    this.e = ast.a(getContext(), true);
    this.e.width = aqs.ac();
    this.e.height = aqs.ad();
    this.e.x = 0;
    this.e.y = 0;
    WindowManager.LayoutParams localLayoutParams = this.e;
    localLayoutParams.flags |= 1024;
    ast.a(getContext(), this, this.e);
  }

  public void c()
  {
    ast.a(getContext(), this);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (!paramKeyEvent.isCanceled()))
    {
      this.h += 1;
      if (this.h >= 2)
        c();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
    SwipeService localSwipeService = SwipeService.i();
    vu localvu = localSwipeService.e;
    this.c = new avd(localSwipeService, true, true, 7, localvu);
    this.c.g();
    this.d = new avd(localSwipeService, false, true, 7, localvu);
    this.d.g();
    requestFocus();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
    if (this.c != null)
    {
      this.c.h();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.h();
      this.d = null;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ImageView localImageView = (ImageView)findViewById(2131755376);
    ((ImageView)findViewById(2131755377)).setImageBitmap(atw.c(((BitmapDrawable)localImageView.getDrawable()).getBitmap()));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.guide.NewSwipeGuideView
 * JD-Core Version:    0.6.2
 */