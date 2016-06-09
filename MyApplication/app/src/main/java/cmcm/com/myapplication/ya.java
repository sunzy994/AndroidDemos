package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import android.view.View.DragShadowBuilder;

class ya extends DragShadowBuilder
{
  private float a = 1.0F;
  private int b;
  private int c;
  private Point d;

  public ya(View paramView, float paramFloat)
  {
    super(paramView);
    this.a = paramFloat;
  }

  public ya(View paramView, float paramFloat, Point paramPoint)
  {
    this(paramView, paramFloat);
    this.d = paramPoint;
  }

  public void onDrawShadow(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.scale(this.a, this.a);
    super.onDrawShadow(paramCanvas);
    paramCanvas.restore();
  }

  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    this.b = ((int)(getView().getWidth() * this.a));
    this.c = ((int)(getView().getHeight() * this.a));
    paramPoint1.set(this.b, this.c);
    if (this.d == null)
    {
      paramPoint2.set(this.b / 2, this.c / 2);
      return;
    }
    if ((this.d.x < 0) || (this.d.y < 0))
    {
      paramPoint2.set(this.b / 2, this.c / 2);
      return;
    }
    paramPoint2.set(this.d.x, this.d.y);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ya
 * JD-Core Version:    0.6.2
 */