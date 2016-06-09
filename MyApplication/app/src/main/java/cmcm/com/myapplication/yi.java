package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

public class yi extends View
  implements OnClickListener
{
  private final Path a;
  private final int b;
  private final int c;
  private final int d;
  private WeakReference<Runnable> e;
  private boolean f;

  private yi(Context paramContext, int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    super(paramContext);
    setLayerType(1, null);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.a = new Path();
    this.a.addCircle(paramInt1, paramInt2, paramInt3, Direction.CW);
    this.e = new WeakReference(paramRunnable);
    setOnClickListener(this);
  }

  public static yi a(yb paramyb, int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    paramRunnable = new yi(paramyb.getContext(), paramInt1, paramInt2, paramInt3, paramRunnable);
    paramyb.addView(paramRunnable);
    return paramRunnable;
  }

  public static void a()
  {
    if (yb.getInstance() != null)
      yb.getInstance().m();
  }

  public void b()
  {
    if (this.e != null)
      this.e.clear();
    this.e = null;
  }

  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    try
    {
      super.dispatchConfigurationChanged(paramConfiguration);
      return;
    }
    catch (Throwable paramConfiguration)
    {
    }
  }

  public void onClick(View paramView)
  {
    if ((this.f) && (this.e != null) && (this.e.get() != null))
      ((Runnable)this.e.get()).run();
    a();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    post(new Runnable()
    {
      public void run()
      {
        if (yb.getInstance() != null)
          yb.getInstance().m();
      }
    });
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    paramCanvas.clipPath(this.a, Region.Op.DIFFERENCE);
    paramCanvas.drawColor(-1728053248);
    paramCanvas.setDrawFilter(localDrawFilter);
    paramCanvas.restore();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return super.onTouchEvent(paramMotionEvent);
    case 0:
    }
    if (ari.a(this.b, this.c, paramMotionEvent.getX(), paramMotionEvent.getY()) < this.d + asq.a(10.0F));
    for (boolean bool = true; ; bool = false)
    {
      this.f = bool;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yi
 * JD-Core Version:    0.6.2
 */