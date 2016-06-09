package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import com.lazyswipe.SwipeApplication;
import java.util.Arrays;

public class auh extends ShapeDrawable
{
  private Paint a;

  public auh(Shape paramShape, float paramFloat, int paramInt)
  {
    super(paramShape);
    a(paramFloat, paramInt);
  }

  public static auh a(int paramInt, float paramFloat)
  {
    Object localObject1 = SwipeApplication.c();
    Object localObject2 = new float[8];
    Arrays.fill((float[])localObject2, paramFloat);
    int i = ((Context)localObject1).getResources().getDimensionPixelSize(2131296389);
    new RectF(i, i, i, i);
    localObject1 = new auh(new RoundRectShape((float[])localObject2, null, null), i, paramInt);
    localObject2 = ((auh)localObject1).getPaint();
    ((Paint)localObject2).setColor(paramInt);
    ((Paint)localObject2).setStyle(Style.FILL);
    return localObject1;
  }

  public static auh a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject = new float[8];
    Arrays.fill((float[])localObject, paramFloat1);
    localObject = new auh(new RoundRectShape((float[])localObject, new RectF(paramFloat2, paramFloat2, paramFloat2, paramFloat2), null), paramFloat2, paramInt);
    Paint localPaint = ((auh)localObject).getPaint();
    localPaint.setColor(paramInt);
    localPaint.setStyle(Style.STROKE);
    return localObject;
  }

  private void a(float paramFloat, int paramInt)
  {
    this.a = new Paint(getPaint());
    this.a.setStyle(Style.STROKE);
    this.a.setColor(paramInt);
    this.a.setStrokeWidth(paramFloat);
  }

  public static auh b(int paramInt, float paramFloat)
  {
    return a(paramInt, paramFloat, SwipeApplication.c().getResources().getDimensionPixelSize(2131296389));
  }

  protected void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
  {
    super.onDraw(paramShape, paramCanvas, paramPaint);
    paramShape.draw(paramCanvas, this.a);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auh
 * JD-Core Version:    0.6.2
 */