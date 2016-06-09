package cmcm.com.myapplication.com.lazyswipe.features.leap.slot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import asq;
import atw;

public class SlotResultArea extends FrameLayout
{
  private SlotMachine a;
  private SlotResultContent b;
  private SlotResultContent c;
  private int d;
  private int e;
  private int f;
  private Bitmap g;
  private Rect h;

  public SlotResultArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(Canvas paramCanvas)
  {
    int i = 0;
    int j = asq.a(17.0F);
    while (i < getMeasuredHeight() + this.g.getHeight())
    {
      paramCanvas.drawBitmap(this.g, j, i, null);
      i += this.g.getHeight();
    }
  }

  void a()
  {
    setVisibility(0);
    final boolean bool;
    if (this.d == 0)
    {
      bool = true;
      if (!bool)
        break label100;
    }
    label100: for (final int i = this.f; ; i = this.e)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
      i = this.d;
      localValueAnimator.setInterpolator(new AccelerateInterpolator(2.0F));
      localValueAnimator.setDuration(550L);
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (bool)
          {
            SlotResultArea.b(SlotResultArea.this).setTranslationY(-SlotResultArea.a(SlotResultArea.this) + i);
            SlotResultArea.d(SlotResultArea.this).setTranslationY(-SlotResultArea.a(SlotResultArea.this) - SlotResultArea.c(SlotResultArea.this) + i);
            if (SlotResultArea.b(SlotResultArea.this).f())
              SlotResultArea.e(SlotResultArea.this).set(0, 0, 0, 0);
          }
          while (true)
          {
            SlotResultArea.a(SlotResultArea.this, i + i);
            SlotResultArea.this.invalidate();
            return;
            SlotResultArea.e(SlotResultArea.this).set(0, 0, SlotResultArea.this.getMeasuredWidth(), (int)SlotResultArea.b(SlotResultArea.this).getY() + SlotResultArea.c(SlotResultArea.this));
            continue;
            SlotResultArea.d(SlotResultArea.this).setTranslationY(i - 2);
            SlotResultArea.b(SlotResultArea.this).setTranslationY(-SlotResultArea.c(SlotResultArea.this) + i);
            if ((SlotResultArea.d(SlotResultArea.this).f()) && (SlotResultArea.b(SlotResultArea.this).f()))
              SlotResultArea.e(SlotResultArea.this).set(0, 0, 0, 0);
            else if ((!SlotResultArea.d(SlotResultArea.this).f()) && (!SlotResultArea.b(SlotResultArea.this).f()))
              SlotResultArea.e(SlotResultArea.this).set(0, 0, SlotResultArea.this.getMeasuredWidth(), SlotResultArea.this.getMeasuredHeight());
            else if ((!SlotResultArea.d(SlotResultArea.this).f()) && (SlotResultArea.b(SlotResultArea.this).f()))
              SlotResultArea.e(SlotResultArea.this).set(0, (int)SlotResultArea.d(SlotResultArea.this).getY(), SlotResultArea.this.getMeasuredWidth(), SlotResultArea.this.getMeasuredHeight());
            else if ((SlotResultArea.d(SlotResultArea.this).f()) && (!SlotResultArea.b(SlotResultArea.this).f()))
              SlotResultArea.e(SlotResultArea.this).set(0, 0, SlotResultArea.this.getMeasuredWidth(), (int)SlotResultArea.b(SlotResultArea.this).getY() + SlotResultArea.c(SlotResultArea.this));
          }
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!bool)
            SlotResultArea.d(SlotResultArea.this).e();
          paramAnonymousAnimator = SlotResultArea.d(SlotResultArea.this);
          SlotResultArea.a(SlotResultArea.this, SlotResultArea.b(SlotResultArea.this));
          SlotResultArea.b(SlotResultArea.this, paramAnonymousAnimator);
          SlotResultArea.this.b();
          SlotResultArea.this.invalidate();
        }
      });
      localValueAnimator.start();
      return;
      bool = false;
      break;
    }
  }

  void a(int paramInt)
  {
    b();
    this.c.a(paramInt);
  }

  void a(boolean paramBoolean)
  {
    b();
    this.c.a(paramBoolean);
  }

  void b()
  {
    if (this.d == 0)
    {
      this.c.setTranslationY(-this.f);
      this.b.setTranslationY(-this.f - this.e);
      return;
    }
    this.c.setTranslationY(-this.e);
    this.b.setTranslationY(0.0F);
  }

  void b(boolean paramBoolean)
  {
    this.a.i();
  }

  void c()
  {
    b();
    this.c.d();
  }

  void d()
  {
    this.g = this.a.a("slot_paper_side");
    this.b.a();
    this.c.a();
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.g == null)
      return;
    paramCanvas.save();
    paramCanvas.clipRect(this.h);
    paramCanvas.translate(0.0F, this.d % this.g.getHeight());
    a(paramCanvas);
    paramCanvas.rotate(180.0F, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
    a(paramCanvas);
    paramCanvas.restore();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    atw.a(this.g);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((SlotResultContent)findViewById(2131755488));
    this.c = ((SlotResultContent)findViewById(2131755489));
    Resources localResources = getResources();
    this.e = localResources.getDimensionPixelOffset(2131296392);
    this.f = localResources.getDimensionPixelOffset(2131296393);
    this.h = new Rect();
    b();
  }

  protected void setContainer(SlotMachine paramSlotMachine)
  {
    this.a = paramSlotMachine;
    this.b.a(paramSlotMachine, this);
    this.c.a(paramSlotMachine, this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.slot.SlotResultArea
 * JD-Core Version:    0.6.2
 */