package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View.DragShadowBuilder;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lazyswipe.fan.FanItem;
import java.lang.ref.WeakReference;

public class xz extends ImageView
{
  private static final String a = "Swipe." + xz.class.getSimpleName();
  private WeakReference<FanItem> b;

  public xz(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    if ((this.b != null) && (this.b.get() != null))
    {
      FanItem localFanItem = (FanItem)this.b.get();
      float f = localFanItem.getBaseScale();
      localFanItem.setScaleX(f);
      localFanItem.setScaleY(f);
    }
  }

  public void a(final FanItem paramFanItem)
  {
    this.b = new WeakReference(paramFanItem);
    final int i = paramFanItem.getWidth();
    final int k = paramFanItem.getHeight();
    final int j = (int)(i * 1.2F);
    k = (int)(k * 1.2F);
    Rect localRect = paramFanItem.getIconRect();
    int m = localRect.left + localRect.width() / 2;
    int n = localRect.top;
    n = localRect.height() / 2 + n;
    final int i1 = (int)(m * 0.2000001F);
    final int i2 = (int)(n * 0.2000001F);
    paramFanItem.setPivotX(m);
    paramFanItem.setPivotY(n);
    paramFanItem.animate().scaleX(1.2F).scaleY(1.2F).setDuration(80L).setListener(new AnimatorListenerAdapter()
    {
      private void a()
      {
        Object localObject = b();
        if (!atw.b((Bitmap)localObject))
        {
          xz.this.a();
          localObject = new ya(paramFanItem, 1.2F);
          paramFanItem.startDrag(null, (View.DragShadowBuilder)localObject, paramFanItem, 0);
          return;
        }
        xz.this.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 83;
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(-i * 1.2F));
        yb.getInstance().addView(xz.this, (ViewGroup.LayoutParams)localObject);
        xz.this.post(new Runnable()
        {
          public void run()
          {
            if (xz.1.this.a == null)
              return;
            Object localObject = xz.1.this.a.getTouchDownPoint();
            localObject = new Point(((Point)localObject).x + xz.1.this.c, ((Point)localObject).y + xz.1.this.d);
            localObject = new ya(xz.this, 1.0F, (Point)localObject);
            xz.1.this.a.startDrag(null, (View.DragShadowBuilder)localObject, xz.1.this.a, 0);
            xz.this.postDelayed(new Runnable()
            {
              public void run()
              {
                xz.this.a();
              }
            }
            , 100L);
          }
        });
      }

      private Bitmap b()
      {
        Bitmap localBitmap1 = Bitmap.createBitmap(j, k, Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap1);
        localCanvas.setDrawFilter(atw.a);
        Bitmap localBitmap2 = atw.b(paramFanItem);
        if (atw.b(localBitmap2))
        {
          Paint localPaint = new Paint(7);
          localCanvas.drawBitmap(localBitmap2, null, new Rect(0, 0, j, k), localPaint);
          return localBitmap1;
        }
        atw.a(localBitmap1);
        return null;
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        try
        {
          a();
          return;
        }
        catch (Exception paramAnonymousAnimator)
        {
          xz.this.a();
          paramAnonymousAnimator = new ya(paramFanItem, 1.2F);
          paramFanItem.startDrag(null, paramAnonymousAnimator, paramFanItem, 0);
        }
      }
    });
  }

  public void b()
  {
    setImageBitmap(null);
    a();
    post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (yb.getInstance() != null)
            yb.getInstance().removeView(xz.this);
          if (xz.a(xz.this) != null)
          {
            xz.a(xz.this).clear();
            xz.a(xz.this, null);
          }
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xz
 * JD-Core Version:    0.6.2
 */