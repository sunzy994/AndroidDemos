package cmcm.com.myapplication.com.hola.channel.sdk.game.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import pw;
import px;
import qx;
import ry;
import sa;
import te;

public class AdView extends LinearLayout
{
  View a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private int e;
  private int f;
  private int g;

  public AdView(Context paramContext)
  {
    super(paramContext);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void a()
  {
    if (getVisibility() != 0)
      setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.g });
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        AdView.this.getLayoutParams().height = ((int)f);
        AdView.this.requestLayout();
      }
    });
    localValueAnimator.addListener(new AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AdView.this.getLayoutParams().height = 0;
        AdView.this.a.setVisibility(0);
      }
    });
    localValueAnimator.start();
  }

  public void a(final Runnable paramRunnable)
  {
    animate().alpha(0.0F).translationY(-this.g).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        paramRunnable.run();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramRunnable.run();
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
  }

  public void a(px parampx)
  {
    a(parampx, true);
  }

  public void a(px parampx, boolean paramBoolean)
  {
    try
    {
      this.c.setText(parampx.c());
      this.d.setText(parampx.d());
      this.b.setScaleType(ScaleType.CENTER_INSIDE);
      ry.a(getContext()).a(parampx.b().a()).a(this.e, this.f).a().a(this.b);
      if (paramBoolean)
        parampx.a(this);
      return;
    }
    catch (Throwable parampx)
    {
      Log.w("GameSDK." + AdView.class.getSimpleName(), "Bind AD failed", parampx);
    }
  }

  public int getAdHeight()
  {
    return this.g;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = qx.a(this, te.hg_ad_content);
    this.b = ((ImageView)qx.a(this, te.hg_ad_cover));
    this.c = ((TextView)qx.a(this, te.hg_ad_title));
    this.d = ((TextView)qx.a(this, te.hg_ad_call_to_action));
    this.e = (getResources().getDisplayMetrics().widthPixels - getPaddingLeft() - getPaddingRight());
    this.f = ((int)(this.e * 0.5225F));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    int i = this.f;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int m = localMarginLayoutParams.height;
    int n = localMarginLayoutParams.bottomMargin;
    this.g = (localMarginLayoutParams.topMargin + (i + j + k + m + n) + this.d.getPaddingTop() + this.d.getPaddingBottom());
    this.b.getLayoutParams().height = this.f;
    this.b.getLayoutParams().width = this.e;
    getLayoutParams().height = this.g;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.widget.AdView
 * JD-Core Version:    0.6.2
 */