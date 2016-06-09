package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.hola.channel.sdk.game.widget.TabLayout;

public class st extends LinearLayout
{
  private int b;
  private final Paint c;
  private int d = -1;
  private float e;
  private int f = -1;
  private int g = -1;
  private ValueAnimator h;

  public st(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.c = new Paint();
  }

  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.f) || (paramInt2 != this.g))
    {
      this.f = paramInt1;
      this.g = paramInt2;
      ez.d(this);
    }
  }

  private void c()
  {
    View localView = getChildAt(this.d);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int m = localView.getLeft();
      int k = localView.getRight();
      i = k;
      j = m;
      if (this.e > 0.0F)
      {
        i = k;
        j = m;
        if (this.d < getChildCount() - 1)
        {
          localView = getChildAt(this.d + 1);
          float f1 = this.e;
          float f2 = localView.getLeft();
          float f3 = this.e;
          j = (int)(m * (1.0F - f3) + f1 * f2);
          f1 = this.e;
          f2 = localView.getRight();
          f3 = this.e;
          i = (int)(k * (1.0F - f3) + f2 * f1);
        }
      }
    }
    while (true)
    {
      b(j, i);
      return;
      i = -1;
      j = -1;
    }
  }

  public void a(int paramInt)
  {
    if (this.c.getColor() != paramInt)
    {
      this.c.setColor(paramInt);
      ez.d(this);
    }
  }

  public void a(int paramInt, float paramFloat)
  {
    this.d = paramInt;
    this.e = paramFloat;
    c();
  }

  public void a(final int paramInt1, int paramInt2)
  {
    final int i;
    Object localObject;
    final int k;
    final int m;
    final int j;
    if (ez.h(this) == 1)
    {
      i = 1;
      localObject = getChildAt(paramInt1);
      k = ((View)localObject).getLeft();
      m = ((View)localObject).getRight();
      if (Math.abs(paramInt1 - this.d) > 1)
        break label161;
      i = this.f;
      j = this.g;
    }
    while (true)
    {
      if ((i != k) || (j != m))
      {
        localObject = TabLayout.a(this.a, new ValueAnimator());
        ((ValueAnimator)localObject).setInterpolator(TabLayout.a);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f = paramAnonymousValueAnimator.getAnimatedFraction();
            st.a(st.this, TabLayout.a(i, k, f), TabLayout.a(j, m, f));
          }
        });
        ((ValueAnimator)localObject).addListener(new AnimatorListener()
        {
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            st.a(st.this, paramInt1);
            st.a(st.this, 0.0F);
          }

          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            st.a(st.this, paramInt1);
            st.a(st.this, 0.0F);
          }

          public void onAnimationRepeat(Animator paramAnonymousAnimator)
          {
          }

          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
          }
        });
        ((ValueAnimator)localObject).start();
        this.h = ((ValueAnimator)localObject);
      }
      return;
      i = 0;
      break;
      label161: j = TabLayout.b(this.a, 24);
      if (paramInt1 < this.d)
      {
        if (i != 0)
        {
          j = k - j;
          i = j;
        }
        else
        {
          j = m + j;
          i = j;
        }
      }
      else if (i != 0)
      {
        j = m + j;
        i = j;
      }
      else
      {
        j = k - j;
        i = j;
      }
    }
  }

  public boolean a()
  {
    boolean bool2 = false;
    int j = getChildCount();
    int i = 0;
    while (true)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (getChildAt(i).getWidth() <= 0)
          bool1 = true;
      }
      else
        return bool1;
      i += 1;
    }
  }

  public float b()
  {
    return this.d + this.e;
  }

  public void b(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      ez.d(this);
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.f >= 0) && (this.g > this.f))
      paramCanvas.drawRect(this.f, getHeight() - this.b, this.g, getHeight(), this.c);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.h != null) && (this.h.isRunning()))
    {
      this.h.cancel();
      long l = this.h.getDuration();
      paramInt1 = this.d;
      float f1 = this.h.getAnimatedFraction();
      a(paramInt1, Math.round((float)l * (1.0F - f1)));
      return;
    }
    c();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    super.onMeasure(paramInt1, paramInt2);
    label18: if (MeasureSpec.getMode(paramInt1) != 1073741824)
      break label18;
    while ((TabLayout.i(this.a) != 1) || (TabLayout.l(this.a) != 1))
      return;
    int n = getChildCount();
    int k = 0;
    int j = 0;
    label53: Object localObject;
    if (k < n)
    {
      localObject = getChildAt(k);
      if (((View)localObject).getVisibility() != 0)
        break label238;
    }
    label138: label223: label235: label238: for (int i = Math.max(j, ((View)localObject).getMeasuredWidth()); ; i = j)
    {
      k += 1;
      j = i;
      break label53;
      if (j <= 0)
        break;
      i = TabLayout.b(this.a, 16);
      if (j * n <= getMeasuredWidth() - i * 2)
      {
        k = 0;
        i = m;
        m = i;
        if (k >= n)
          break label223;
        localObject = (LayoutParams)getChildAt(k).getLayoutParams();
        if ((((LayoutParams)localObject).width == j) && (((LayoutParams)localObject).weight == 0.0F))
          break label235;
        ((LayoutParams)localObject).width = j;
        ((LayoutParams)localObject).weight = 0.0F;
        i = 1;
      }
      while (true)
      {
        k += 1;
        break label138;
        TabLayout.c(this.a, 0);
        TabLayout.a(this.a, false);
        m = 1;
        if (m == 0)
          break;
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     st
 * JD-Core Version:    0.6.2
 */