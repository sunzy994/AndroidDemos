package cmcm.com.myapplication.com.lazyswipe.features.leap.slot;

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
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import ari;
import asq;

public class SlotRoller extends View
{
  private static final String a = "Swipe." + SlotRoller.class.getSimpleName();
  private static final int b = asq.a(23.0F);
  private static final int c = asq.a(3.0F);
  private int d;
  private int e;
  private final int f = asq.a(113.3F);
  private int g;
  private final Handler h = new Handler();
  private int i;
  private float j = 0.0F;
  private final Paint k = new Paint(7);
  private final Paint l = new Paint();
  private SlotMachine m;
  private int n;
  private final Runnable o = new Runnable()
  {
    public void run()
    {
      SlotRoller.b(SlotRoller.this).removeCallbacks(this);
      SlotRoller.c(SlotRoller.this);
      SlotRoller.a(SlotRoller.this, SlotRoller.d(SlotRoller.this) + SlotRoller.e(SlotRoller.this));
      SlotRoller.this.invalidate();
      if (SlotRoller.f(SlotRoller.this) != 7)
        SlotRoller.b(SlotRoller.this).post(this);
    }
  };
  private int p;

  public SlotRoller(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private Bitmap a(int paramInt, boolean paramBoolean)
  {
    return this.m.a(b(paramInt, paramBoolean));
  }

  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.j == 0.0F)
    {
      paramCanvas.drawBitmap(a(paramInt1, false), 0.0F, paramInt2, null);
      return;
    }
    if (this.j == 1.0F)
    {
      paramCanvas.drawBitmap(a(paramInt1, true), 0.0F, paramInt2, null);
      return;
    }
    this.l.setAlpha((int)(this.j * 255.0F));
    paramCanvas.drawBitmap(a(paramInt1, true), 0.0F, paramInt2, this.l);
    this.k.setAlpha((int)((1.0F - this.j) * 255.0F));
    paramCanvas.drawBitmap(a(paramInt1, false), 0.0F, paramInt2, this.k);
  }

  private int b(int paramInt)
  {
    return (paramInt + 14) % 7 + 1;
  }

  private String b(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("slot_roller_").append(paramInt);
    if (paramBoolean);
    for (String str = "_blur"; ; str = "")
      return str;
  }

  private void b()
  {
    this.n = 2;
  }

  private void c()
  {
    switch (this.n)
    {
    case 3:
    default:
      return;
    case 0:
      if (this.i < b)
      {
        this.i += 1;
        this.j = (this.i / b);
        return;
      }
      this.n = 1;
      return;
    case 1:
    case 2:
      this.i = b;
      this.j = 1.0F;
      return;
    case 4:
      if (this.i > c)
      {
        this.i -= 1;
        this.j = ari.a(b, 1.0F, c, 0.0F, this.i);
        return;
      }
      this.n = 5;
      return;
    case 5:
    case 6:
      this.i = c;
      this.j = 0.0F;
      return;
    case 7:
    }
    this.i = 0;
    d();
  }

  private void d()
  {
    this.h.removeCallbacks(this.o);
    int i1 = this.p;
    int i2 = this.g;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    localValueAnimator.setDuration(1050L);
    localValueAnimator.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)(Math.cos(10.995574F * paramAnonymousFloat) * (1.0D - Math.pow(paramAnonymousFloat, 0.4D)));
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        SlotRoller.a(SlotRoller.this, (int)(SlotRoller.g(SlotRoller.this) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * this.a));
        SlotRoller.this.invalidate();
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SlotRoller.h(SlotRoller.this).j();
      }
    });
    localValueAnimator.start();
  }

  void a()
  {
    int i1 = 1;
    while (i1 <= 7)
    {
      a(i1, true);
      a(i1, false);
      i1 += 1;
    }
  }

  void a(int paramInt)
  {
    this.h.postDelayed(new Runnable()
    {
      public void run()
      {
        SlotRoller.a(SlotRoller.this);
      }
    }
    , paramInt);
  }

  void a(int paramInt1, int paramInt2)
  {
    Log.i(a, "start(), targetPoint = " + paramInt1);
    this.n = 0;
    this.e = paramInt1;
    this.h.postDelayed(this.o, paramInt2);
  }

  void a(int paramInt, SlotMachine paramSlotMachine)
  {
    this.d = paramInt;
    this.m = paramSlotMachine;
    this.g = ((this.d - 1) * this.f);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.h.removeCallbacks(this.o);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.m.b);
    label123: 
    do
    {
      int i2;
      do
      {
        return;
        i2 = b(this.g / this.f);
        int i1 = this.g % this.f;
        a(paramCanvas, i2, i1);
        if (i1 != 0);
        for (i1 = 1; ; i1 = 0)
        {
          if (i1 != 0)
            a(paramCanvas, b(this.g / this.f + 1), this.g % this.f - this.f);
          if (this.n != 2)
            break label123;
          if (b(this.e - 2) != b(i2))
            break;
          this.n = 4;
          return;
        }
        if (this.n != 5)
          break;
      }
      while (b(this.e - 1) != b(i2));
      this.n = 6;
      this.p = ((this.g / this.f + 1) * this.f);
      return;
    }
    while ((this.n != 6) || (this.p - this.g >= this.f * 0.5D));
    this.n = 7;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.slot.SlotRoller
 * JD-Core Version:    0.6.2
 */