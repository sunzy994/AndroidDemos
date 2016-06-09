package cmcm.com.myapplication.com.lazyswipe.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ast;
import java.lang.ref.WeakReference;
import vj;
import vs;

public class FloatTip extends RelativeLayout
  implements DialogInterface, Callback, OnKeyListener
{
  protected static final String a = "Swipe." + FloatTip.class.getSimpleName();
  protected static boolean h;
  private static WeakReference<FloatTip> j;
  public TextView b;
  public TextView c;
  ImageView d;
  public long e;
  protected Handler f;
  protected WindowManager.LayoutParams g;
  public WeakReference<OnDismissListener> i;

  public FloatTip(Context paramContext)
  {
    this(paramContext, null);
  }

  public FloatTip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FloatTip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public static boolean b()
  {
    return h;
  }

  public static void c()
  {
    if ((j != null) && (j.get() != null));
    try
    {
      ((FloatTip)j.get()).dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static boolean d()
  {
    if ((j != null) && (j.get() != null));
    try
    {
      ((FloatTip)j.get()).dismiss();
      label27: return true;
      return false;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }

  private boolean e()
  {
    return this.e > 0L;
  }

  private void f()
  {
    View localView = findViewById(2131755250);
    Object localObject = (ViewGroup)findViewById(2131755253);
    if ((((ViewGroup)localObject).getVisibility() != 0) || (((ViewGroup)localObject).getChildCount() != 1))
      return;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
    localTranslateAnimation.setDuration(500L);
    localView.startAnimation(localTranslateAnimation);
    localView.bringToFront();
    ((ViewGroup)localObject).setVisibility(0);
    localView = ((ViewGroup)localObject).getChildAt(0);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.2F, 1, 0.0F);
    ((TranslateAnimation)localObject).setInterpolator(new OvershootInterpolator(1.0F));
    ((TranslateAnimation)localObject).setDuration(500L);
    ((TranslateAnimation)localObject).setStartOffset(500L);
    ((TranslateAnimation)localObject).setFillBefore(true);
    localView.setAnimation((Animation)localObject);
  }

  public void a()
  {
    if (!h)
    {
      h = true;
      ast.a(getContext(), this, this.g);
      if (e())
        this.f.sendEmptyMessageDelayed(0, this.e);
    }
  }

  public void a(int paramInt)
  {
    Object localObject = getContext().getResources().getDisplayMetrics();
    this.g = new WindowManager.LayoutParams();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int n = getMeasuredWidth();
    int i1 = getMeasuredHeight();
    int k = i1;
    int m = n;
    int i4;
    if (n <= 0)
      i4 = MeasureSpec.makeMeasureSpec(0, 0);
    try
    {
      measure(i4, i4);
      m = getMeasuredWidth();
      k = getMeasuredHeight();
      this.g.width = m;
      WindowManager.LayoutParams localLayoutParams = this.g;
      if (k > 0)
      {
        localLayoutParams.height = k;
        if ((paramInt != 3) && (paramInt != 8388611))
          break label386;
        this.g.x = 0;
        this.g.y = ((int)(((DisplayMetrics)localObject).density * 45.0F));
        this.g.format = 1;
        this.g.flags = 327936;
        if (e())
        {
          localObject = this.g;
          ((WindowManager.LayoutParams)localObject).flags |= 32;
          localObject = this.g;
          ((WindowManager.LayoutParams)localObject).flags |= 8;
        }
        this.g.type = vs.n(getContext());
        this.g.gravity = (vj.a | 0x30);
      }
    }
    catch (Throwable localThrowable1)
    {
      while (true)
      {
        n = i1;
        try
        {
          View localView = getChildAt(0);
          n = i1;
          localView.measure(i4, i4);
          n = i1;
          int i2 = localView.getMeasuredWidth();
          n = i1;
          i1 = localView.getMeasuredHeight();
          k = i1;
          m = i2;
          n = i1;
          if (getChildCount() <= 1)
            continue;
          k = i1;
          m = i2;
          n = i1;
          if (getChildAt(1).getVisibility() != 0)
            continue;
          n = i1;
          localView = getChildAt(1);
          n = i1;
          localView.measure(i4, i4);
          n = i1;
          k = localView.getMeasuredHeight();
          k = i1 + k;
          m = i2;
        }
        catch (Throwable localThrowable2)
        {
          m = Math.min(i3, ((DisplayMetrics)localObject).heightPixels) * 5 / 6;
          k = n;
        }
        continue;
        k = -2;
        continue;
        label386: if ((paramInt == 5) || (paramInt == 8388613))
          this.g.x = (i3 - m);
        else
          this.g.x = (i3 - m >> 1);
      }
    }
  }

  public void cancel()
  {
  }

  public void dismiss()
  {
    if (h)
    {
      h = false;
      this.f.removeMessages(0);
      ast.a(getContext(), this);
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      d();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
    }
    while (true)
    {
      return true;
      dismiss();
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    f();
    j = new WeakReference(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    dismiss();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.i != null) && (this.i.get() != null));
    try
    {
      ((OnDismissListener)this.i.get()).onDismiss(this);
      label37: if (j != null)
      {
        j.clear();
        j = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label37;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = new Handler(this);
    this.b = ((TextView)findViewById(2131755188));
    this.c = ((TextView)findViewById(2131755252));
    this.d = ((ImageView)findViewById(2131755251));
    setFocusable(true);
    setFocusableInTouchMode(true);
    setOnKeyListener(this);
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      dismiss();
      return true;
    }
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return super.onTouchEvent(paramMotionEvent);
    case 1:
    }
    dismiss();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.FloatTip
 * JD-Core Version:    0.6.2
 */