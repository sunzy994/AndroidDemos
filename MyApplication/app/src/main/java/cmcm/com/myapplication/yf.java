package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.animation.AccelerateInterpolator;
import com.lazyswipe.fan.FanItem;

public class yf
{
  private final Paint b = new Paint(7);
  private int c;
  private int d;
  private int e;
  private int f;
  private final int g = asq.a(14.0F);
  private final Rect h = new Rect();
  private ShapeDrawable i;
  private Drawable j;
  private auf k;
  private final Rect l = new Rect();
  private float m = 0.9F;
  private RectF n;
  private Path o;

  public yf(FanItem paramFanItem)
  {
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (this.j == null)
      this.j = new aug(atw.a(paramInt2), this.a.getResources().getDrawable(paramInt1), asq.a(18.0F));
  }

  private void a(Canvas paramCanvas, yw paramyw)
  {
    String str = paramyw.p();
    int i1 = paramyw.q();
    if ((str == FanItem.a) && (i1 == -1))
      return;
    if ("".equals(str))
    {
      c();
      i3 = asq.a(12.0F);
      if (ahy.d(this.a.getContext()))
      {
        i1 = asq.a(4.0F);
        if (!ahy.d(this.a.getContext()))
          break label173;
      }
      label173: for (i2 = asq.a(6.0F); ; i2 = 0)
      {
        i1 = Math.max(FanItem.m(this.a).right + asq.a(2.5F) - i3 - i1, 0);
        i2 = Math.max(i2 + (FanItem.m(this.a).top - i3 / 3), 0);
        this.i.setBounds(i1, i2, i1 + i3, i3 + i2);
        this.i.draw(paramCanvas);
        return;
        i1 = 0;
        break;
      }
    }
    if (i1 != -1)
    {
      a(i1, paramyw.h(this.a.getContext()));
      i1 = asq.a(18.0F);
      i2 = Math.max(FanItem.m(this.a).right + asq.a(2.5F) - i1, 0);
      i3 = Math.max(FanItem.m(this.a).top - i1 / 3, 0);
      this.j.setBounds(i2, i3, i2 + i1, i1 + i3);
      this.j.draw(paramCanvas);
      return;
    }
    b();
    this.k.a(str);
    paramyw = this.k;
    i1 = FanItem.m(this.a).left;
    int i2 = FanItem.m(this.a).top;
    int i3 = FanItem.m(this.a).right;
    paramyw.a(paramCanvas, i1, i2, asq.a(2.5F) + i3, FanItem.m(this.a).bottom);
  }

  private void b()
  {
    if (this.k == null)
      this.k = new auf(this.a.getContext(), this.a);
  }

  private void c()
  {
    if (this.i == null)
      this.i = atw.a(this.a.getResources().getColor(2131689476));
  }

  private void c(Canvas paramCanvas)
  {
    Bitmap localBitmap = atp.b(this.a.getContext());
    int i2 = Math.max(FanItem.m(this.a).right - this.g, 0);
    int i3 = Math.max(FanItem.m(this.a).top - this.g, 0);
    int i1 = i2;
    if (localBitmap.getWidth() + i2 > this.a.getWidth())
      i1 = this.a.getWidth() - localBitmap.getWidth() - 1;
    this.l.set(i1, i3, localBitmap.getWidth() + i1, localBitmap.getHeight() + i3);
    paramCanvas.drawBitmap(localBitmap, null, this.l, this.b);
  }

  private void d()
  {
    if (FanItem.j(this.a))
      return;
    FanItem.d(this.a, true);
    this.a.invalidate();
  }

  private void d(Canvas paramCanvas)
  {
    if (this.n == null)
      this.n = new RectF();
    this.n.set(0.0F, 0.0F, FanItem.m(this.a).width(), FanItem.m(this.a).height());
    this.n.offset(FanItem.m(this.a).left, FanItem.m(this.a).top);
    if (this.a.getLayerType() == 1)
    {
      if (this.o == null)
        this.o = new Path();
      this.o.reset();
      this.o.addCircle(this.n.centerX(), this.n.centerY(), (int)this.n.width() >> 1, Direction.CCW);
      this.o.close();
      paramCanvas.clipPath(this.o);
      return;
    }
    paramCanvas.clipRect(this.n);
  }

  private void e()
  {
    if (!FanItem.j(this.a))
      return;
    FanItem.d(this.a, false);
    this.a.invalidate();
  }

  protected void a()
  {
    Bitmap localBitmap = atp.a(this.a.getContext());
    if ((this.c <= 0) || (this.d <= 0) || (this.e <= 0) || (this.f <= 0))
    {
      this.c = localBitmap.getWidth();
      this.d = localBitmap.getHeight();
      this.e = Math.max(FanItem.m(this.a).left - this.c / 3, 0);
      this.f = (FanItem.m(this.a).top - asq.a(1.5F));
    }
  }

  public void a(Canvas paramCanvas)
  {
    b(paramCanvas);
    if (FanItem.j(this.a))
      c(paramCanvas);
    while (true)
    {
      return;
      if ((this.a.getTag() instanceof yw))
      {
        yw localyw = (yw)this.a.getTag();
        try
        {
          a(paramCanvas, localyw);
          if (localyw.n())
          {
            paramCanvas.save();
            d(paramCanvas);
          }
          localyw.a(paramCanvas);
          if (localyw.n())
          {
            paramCanvas.restore();
            return;
          }
        }
        catch (Exception paramCanvas)
        {
          asq.b(paramCanvas, 5, FanItem.n(), "dispatchDraw");
        }
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    if ((this.a.f) || ((this.a.getTag() != null) && ((this.a.getTag() instanceof yw)) && (!((yw)this.a.getTag()).d())))
      return;
    this.a.f = true;
    if (paramBoolean)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.9F });
      localValueAnimator.setDuration(70L);
      localValueAnimator.setInterpolator(new AccelerateInterpolator());
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          yf.a(yf.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          yf.this.a.invalidate();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          yf.a(yf.this, 0.9F);
          yf.this.a.invalidate();
        }
      });
      localValueAnimator.start();
      return;
    }
    this.m = 0.9F;
    this.a.invalidate();
  }

  public void a(boolean paramBoolean, final yg paramyg)
  {
    if (!this.a.f)
      return;
    if (paramBoolean)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.9F, 0.0F });
      localValueAnimator.setDuration(70L);
      localValueAnimator.setInterpolator(new AccelerateInterpolator());
      localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          yf.a(yf.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          yf.this.a.invalidate();
        }
      });
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          yf.this.a.f = false;
          yf.this.a.invalidate();
          if (paramyg != null)
            yf.this.a.post(new Runnable()
            {
              public void run()
              {
                yf.4.this.a.b();
              }
            });
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramyg != null)
            paramyg.a();
        }
      });
      localValueAnimator.start();
      return;
    }
    this.a.f = false;
    this.a.invalidate();
  }

  protected void b(Canvas paramCanvas)
  {
    if (!this.a.f);
    Bitmap localBitmap;
    do
    {
      return;
      a();
      localBitmap = atp.a(this.a.getContext());
    }
    while (!atw.b(localBitmap));
    int i1 = (int)(this.c * (1.0F - this.m) * 0.5F);
    int i2 = (int)(this.d * (1.0F - this.m) * 0.5F);
    this.h.set(this.e + i1, this.f + i2, this.e + this.c - i1, this.f + this.d - i2);
    paramCanvas.drawBitmap(localBitmap, null, this.h, this.b);
    FanItem.k(this.a).set(this.e + i1, this.f + i2, this.e + this.c - i1, this.f + this.d - i2);
    double d2 = FanItem.l(this.a);
    if (ahy.d(this.a.getContext()));
    for (double d1 = 0.7D; ; d1 = 0.4D)
    {
      i1 = (int)(d1 * d2);
      FanItem.k(this.a).inset(-i1, -i1);
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yf
 * JD-Core Version:    0.6.2
 */