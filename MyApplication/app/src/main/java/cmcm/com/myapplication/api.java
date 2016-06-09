package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class api extends Drawable
{
  private final Paint a = new Paint();
  private final Paint b = new Paint();
  private final int c;
  private final int d;
  private int e = 0;
  private final float f = 88.235291F;

  public api(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    setLevel(0);
  }

  public void a(int paramInt)
  {
    setLevel(paramInt * 100);
  }

  public void draw(Canvas paramCanvas)
  {
    float f1 = Math.max(getLevel() / 10000.0F, 0.2F);
    Rect localRect = getBounds();
    float f2 = localRect.width() / 8.0F;
    int i = this.e;
    this.e = (i + 1);
    float f3 = i / 88.235291F * (localRect.width() + f2);
    paramCanvas.save();
    paramCanvas.clipRect(localRect.left, localRect.top, localRect.left + localRect.width() * f1, localRect.bottom);
    paramCanvas.drawPaint(this.a);
    if ((f3 > 0.0F) && (f3 < localRect.width() * f1 + f2))
    {
      paramCanvas.translate(f3, 0.0F);
      paramCanvas.drawPaint(this.b);
    }
    paramCanvas.restore();
    if (f3 >= f1 * localRect.width() + f2)
      this.e = 0;
    invalidateSelf();
  }

  public int getOpacity()
  {
    return 0;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.setShader(new LinearGradient(paramRect.left, paramRect.top, paramRect.right, paramRect.top, this.c, this.d, Shader.TileMode.CLAMP));
    float f1 = paramRect.width() / 8.0F;
    Paint localPaint = this.b;
    float f2 = paramRect.left;
    float f3 = paramRect.left;
    paramRect = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(f2 - f1, 0.0F, f3, 0.0F, new int[] { 16777215, -285212673, 16777215 }, new float[] { 0.0F, 0.5F, 1.0F }, paramRect));
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     api
 * JD-Core Version:    0.6.2
 */