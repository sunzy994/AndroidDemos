package cmcm.com.myapplication.com.lazyswipe.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ast;
import java.lang.ref.WeakReference;
import vj;
import vs;

public class FixedTip extends RelativeLayout
  implements DialogInterface
{
  protected static final String a = "Swipe." + FixedTip.class.getSimpleName();
  private static WeakReference<FixedTip> j;
  public WeakReference<OnCancelListener> b;
  private TextView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private FrameLayout g;
  private int h;
  private WindowManager.LayoutParams i;

  public FixedTip(Context paramContext)
  {
    super(paramContext);
  }

  public FixedTip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void b()
  {
    if ((j != null) && (j.get() != null));
    try
    {
      ((FixedTip)j.get()).dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void a()
  {
    if ((j == null) || (j.get() == null))
      ast.a(getContext(), this, this.i);
  }

  public void a(boolean paramBoolean)
  {
    ast.a(getContext(), this);
    if ((paramBoolean) && (this.b != null) && (this.b.get() != null))
      ((OnCancelListener)this.b.get()).onCancel(this);
  }

  public void c()
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.i = new WindowManager.LayoutParams();
    int k = localDisplayMetrics.heightPixels;
    int m = getResources().getDimensionPixelOffset(2131296350) + this.h;
    this.i.width = -1;
    this.i.height = m;
    this.i.x = 0;
    this.i.y = (k - m);
    this.i.format = 1;
    this.i.flags = 327976;
    this.i.type = vs.n(getContext());
    this.i.gravity = (vj.a | 0x30);
  }

  public void cancel()
  {
  }

  public void dismiss()
  {
    a(true);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    j = new WeakReference(this);
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    dismiss();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (j != null)
    {
      j.clear();
      j = null;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((TextView)findViewById(2131755238));
    this.d = ((ImageView)findViewById(2131755237));
    this.e = ((TextView)findViewById(2131755241));
    this.f = ((TextView)findViewById(2131755240));
    this.g = ((FrameLayout)findViewById(2131755239));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return super.onTouchEvent(paramMotionEvent);
    case 4:
    }
    dismiss();
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.FixedTip
 * JD-Core Version:    0.6.2
 */