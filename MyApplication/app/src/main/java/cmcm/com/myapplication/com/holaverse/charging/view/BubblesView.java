package cmcm.com.myapplication.com.holaverse.charging.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
import ut;

public class BubblesView extends View
  implements AnimatorUpdateListener
{
  static String a = "BubblesView";
  Paint b = new Paint(1);
  ValueAnimator c;
  Random d = new Random();
  int e;
  int f;
  ut[] g;
  int h = 1;
  int i = 2;

  public BubblesView(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public BubblesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  public BubblesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }

  private int a(int paramInt)
  {
    return this.d.nextInt(paramInt) + 1;
  }

  private int a(int paramInt1, int paramInt2)
  {
    return this.d.nextInt(paramInt2 - paramInt1) + paramInt1;
  }

  private void a(ut paramut)
  {
    paramut.f = ((int)(a(5, 9) * 0.1F * 255.0F));
    paramut.b = (this.e / a(8, 16));
    paramut.e = a(2);
    paramut.d = (a(this.e / 160, this.e / 40) / 10.0F);
    paramut.c = (a(this.f / 50, this.f / 30) / 10.0F);
    paramut.a = 0;
    paramut.g = (this.e / 2);
    paramut.h = this.f;
    paramut.i = a(50, 100);
  }

  private void b(ut paramut)
  {
    if (paramut.i > 0)
    {
      paramut.i -= 1;
      return;
    }
    if (paramut.a < paramut.b)
      paramut.a += 1;
    paramut.h -= paramut.c;
    if (paramut.h - paramut.a < 0.0F)
    {
      a(paramut);
      return;
    }
    if (paramut.e == this.h)
    {
      if (paramut.g - paramut.a <= 0.0F)
      {
        paramut.e = this.i;
        return;
      }
      paramut.g -= paramut.d;
      return;
    }
    if (paramut.g + paramut.a >= this.e)
    {
      paramut.e = this.h;
      return;
    }
    paramut.g += paramut.d;
  }

  private void c()
  {
    setWillNotDraw(false);
    this.b.setStrokeWidth(5.0F);
    this.b.setColor(-1);
    this.c = ValueAnimator.ofInt(new int[] { 0, 100 });
    this.c.addUpdateListener(this);
    this.c.setRepeatCount(-1);
    this.c.setRepeatMode(1);
    this.c.setDuration(200000L);
    this.g = new ut[10];
    this.c.start();
  }

  public void a()
  {
    if (!this.c.isRunning())
      this.c.start();
  }

  public void b()
  {
    if (this.c.isRunning())
      this.c.cancel();
    int j = 0;
    if (j < this.g.length)
    {
      if (this.g[j] == null);
      while (true)
      {
        j += 1;
        break;
        a(this.g[j]);
      }
    }
    invalidate();
  }

  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int j = 0;
    if (j < this.g.length)
    {
      if (this.g[j] == null);
      while (true)
      {
        j += 1;
        break;
        b(this.g[j]);
      }
    }
    postInvalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    if (this.e == 0)
    {
      this.e = getWidth();
      this.f = getHeight();
      j = 0;
      while (j < this.g.length)
      {
        this.g[j] = new ut(this);
        a(this.g[j]);
        ut localut = this.g[j];
        localut.i += j * 100;
        j += 1;
      }
    }
    paramCanvas.drawColor(0);
    int j = k;
    while (j < this.g.length)
    {
      this.b.setAlpha(this.g[j].f);
      paramCanvas.drawCircle((int)this.g[j].g, (int)this.g[j].h, this.g[j].a, this.b);
      j += 1;
    }
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.BubblesView
 * JD-Core Version:    0.6.2
 */