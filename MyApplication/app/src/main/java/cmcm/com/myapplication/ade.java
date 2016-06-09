package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class ade extends Drawable
{
  private int a = vg.e;
  private int b = vg.f;
  private final Paint c;
  private final int[] d;
  private final float[] e;

  private ade(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this.d = paramArrayOfInt;
    this.e = paramArrayOfFloat;
    paramArrayOfInt = new LinearGradient(0.0F, this.b, 0.0F, 0.0F, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP);
    this.c = new Paint();
    this.c.setShader(paramArrayOfInt);
    this.c.setDither(true);
  }

  public static ade a()
  {
    return a(new int[] { -1302601475, -1671700227, 1299214300, 4539257, 4539257 }, new float[] { 0.0F, 0.06F, 0.28F, 0.5F, 1.0F });
  }

  public static ade a(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    return new ade(paramArrayOfInt, paramArrayOfFloat);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, this.a, this.b, this.c);
  }

  public int getIntrinsicHeight()
  {
    return this.b;
  }

  public int getIntrinsicWidth()
  {
    return this.a;
  }

  public int getOpacity()
  {
    return 0;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a = paramRect.width();
    this.b = paramRect.height();
    paramRect = new LinearGradient(0.0F, this.b, 0.0F, 0.0F, this.d, this.e, Shader.TileMode.CLAMP);
    this.c.setShader(paramRect);
    this.c.setDither(true);
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ade
 * JD-Core Version:    0.6.2
 */