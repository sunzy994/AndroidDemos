package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;

public class sm extends BitmapDrawable
{
  private final float a;
  private final RectF b = new RectF();
  private final RectF c;
  private final BitmapShader d;
  private final Paint e;
  private final int f;

  public sm(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    super(paramBitmap);
    this.a = paramFloat;
    this.f = paramInt;
    this.d = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.c = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.e = new Paint(7);
    this.e.setShader(this.d);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(this.b, this.a, this.a, this.e);
    int i = this.f ^ 0xF;
    if ((i & 0x1) != 0)
      paramCanvas.drawRect(0.0F, 0.0F, this.a, this.a, this.e);
    if ((i & 0x2) != 0)
      paramCanvas.drawRect(this.b.right - this.a, 0.0F, this.b.right, this.a, this.e);
    if ((i & 0x4) != 0)
      paramCanvas.drawRect(0.0F, this.b.bottom - this.a, this.a, this.b.bottom, this.e);
    if ((i & 0x8) != 0)
      paramCanvas.drawRect(this.b.right - this.a, this.b.bottom - this.a, this.b.right, this.b.bottom, this.e);
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.b.set(0.0F, 0.0F, paramRect.width(), paramRect.height());
    paramRect = new Matrix();
    paramRect.setRectToRect(this.c, this.b, ScaleToFit.CENTER);
    this.d.setLocalMatrix(paramRect);
  }

  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sm
 * JD-Core Version:    0.6.2
 */