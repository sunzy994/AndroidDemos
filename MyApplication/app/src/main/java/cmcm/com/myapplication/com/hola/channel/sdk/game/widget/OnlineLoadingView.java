package cmcm.com.myapplication.com.hola.channel.sdk.game.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import qs;
import qx;
import sb;
import sr;
import te;
import tn;

public class OnlineLoadingView extends FrameLayout
  implements OnClickListener
{
  private static final String a = "GameSDK." + OnlineLoadingView.class.getSimpleName();
  private View b;
  private ProgressBar c;
  private int d;
  private int e;
  private View f;
  private TextView g;
  private float h;
  private int i;
  private int j;
  private sr k;
  private CharSequence l;
  private View m;
  private Runnable n;

  public OnlineLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OnlineLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public OnlineLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  @TargetApi(21)
  public OnlineLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.h = qs.a(paramContext.getResources(), 2.0F);
    this.j = -15963477;
    this.i = -14835464;
  }

  public void a()
  {
    setVisibility(0);
    if (this.b != null)
      this.b.setVisibility(0);
    if (this.f != null)
      this.f.setVisibility(8);
    if (this.m != null)
      this.m.setVisibility(8);
  }

  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    this.h = paramFloat;
    this.i = paramInt1;
    this.j = paramInt2;
    if (this.g != null)
      this.g.setBackgroundDrawable(sb.a(this.h, this.i, this.j));
  }

  public void a(long paramLong)
  {
    a();
    if (this.n != null)
      removeCallbacks(this.n);
    while (true)
    {
      postDelayed(this.n, paramLong);
      return;
      this.n = new Runnable()
      {
        public void run()
        {
          if (OnlineLoadingView.this.d())
            OnlineLoadingView.this.b();
        }
      };
    }
  }

  public void b()
  {
    setVisibility(0);
    if (this.f != null)
      this.f.setVisibility(0);
    if (this.b != null)
      this.b.setVisibility(8);
    if (this.m != null)
      this.m.setVisibility(8);
  }

  public void c()
  {
    setVisibility(0);
    if (this.m != null)
      this.m.setVisibility(0);
    if (this.b != null)
      this.b.setVisibility(8);
    if (this.f != null)
      this.f.setVisibility(8);
  }

  public boolean d()
  {
    return (getVisibility() == 0) && (this.b != null) && (this.b.getVisibility() == 0);
  }

  public boolean e()
  {
    return (this.f != null) && (this.f.getVisibility() == 0);
  }

  public void f()
  {
    setVisibility(8);
  }

  public void onClick(View paramView)
  {
    if ((this.k != null) && (paramView.getId() == te.hg_online_error_refresh_button))
      this.k.b();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.n != null)
      removeCallbacks(this.n);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Log.d(a, "onFinishInflate called in thread " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName());
    this.f = qx.a(this, te.hg_online_error);
    this.b = qx.a(this, te.hg_online_loading);
    this.g = ((TextView)qx.a(this, te.hg_online_error_refresh_button));
    this.g.setOnClickListener(this);
    this.g.setBackgroundDrawable(sb.a(this.h, this.i, this.j));
    if (this.l != null)
      this.g.setText(this.l);
    this.c = ((ProgressBar)qx.a(this, te.hg_online_loading_image));
    this.c.setIndeterminateDrawable(new tn(getContext(), this.e, this.d));
    this.m = qx.a(this, te.hg_online_empty);
  }

  public void setActionClickListener(sr paramsr)
  {
    this.k = paramsr;
  }

  public void setActionText(int paramInt)
  {
    setActionText(getResources().getText(paramInt));
  }

  public void setActionText(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
    if (this.g != null)
      this.g.setText(paramCharSequence);
  }

  public void setActionVisibility(int paramInt)
  {
    if (this.g.getVisibility() != paramInt)
      this.g.setVisibility(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.widget.OnlineLoadingView
 * JD-Core Version:    0.6.2
 */