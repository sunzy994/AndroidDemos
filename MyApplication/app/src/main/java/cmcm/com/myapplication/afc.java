package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.lazyswipe.features.leap.slot.SlotMachine;

public class afc extends View
{
  private Bitmap a;
  private Bitmap b;
  private final SlotMachine c;
  private int d;
  private final Paint e;
  private final Handler f = new Handler();
  private ValueAnimator g;

  public afc(Context paramContext, SlotMachine paramSlotMachine, ViewGroup paramViewGroup, boolean paramBoolean, int paramInt)
  {
    super(paramContext);
    int i = asq.a(11.0F);
    int j = asq.a(161.0F);
    if (paramBoolean);
    for (float f1 = 13.0F; ; f1 = 337.0F)
    {
      int k = asq.a(f1);
      int m = asq.a(8.67F);
      paramContext = new FrameLayout.LayoutParams(i, i);
      paramContext.leftMargin = k;
      paramContext.topMargin = ((m + i) * paramInt + j);
      paramViewGroup.addView(this, paramContext);
      this.c = paramSlotMachine;
      this.e = new Paint(7);
      return;
    }
  }

  private void b()
  {
    asv.a(this.g);
    this.f.removeCallbacksAndMessages(null);
    this.g = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.g.setDuration(640L);
    this.g.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.36F)
          return 0.0F;
        if (paramAnonymousFloat < 0.4F)
          return 25.0F * (paramAnonymousFloat - 0.36F);
        return 1.67F - 1.67F * paramAnonymousFloat;
      }
    });
    this.g.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        afc.a(afc.this, 0);
        afc.this.invalidate();
      }
    });
    this.g.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        afc.a(afc.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        afc.this.invalidate();
      }
    });
    this.g.start();
  }

  public void a()
  {
    this.a = this.c.a("slot_light_bg");
    this.b = this.c.a("slot_light_fg");
  }

  public void a(int paramInt)
  {
    asv.a(this.g);
    this.f.removeCallbacksAndMessages(null);
    this.f.postDelayed(new Runnable()
    {
      public void run()
      {
        afc.a(afc.this);
      }
    }
    , paramInt);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    atw.a(this.a);
    atw.a(this.b);
    this.f.removeCallbacksAndMessages(null);
    asv.a(this.g);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != null)
      paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
    if (this.b != null)
    {
      this.e.setAlpha(this.d);
      paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.e);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = asq.a(11.0F);
    setMeasuredDimension(paramInt1, paramInt1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afc
 * JD-Core Version:    0.6.2
 */