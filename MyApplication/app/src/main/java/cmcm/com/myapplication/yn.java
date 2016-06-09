package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class yn extends Drawable
{
  public final int a;
  public int b;
  public int c;
  private final Paint d = new Paint(1);
  private final boolean e;
  private PorterDuffXfermode f;
  private final Drawable g;
  private final int h;
  private final int i;
  private float j = 1.0F;

  public yn(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Drawable paramDrawable)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.i = paramInt3;
    this.e = paramBoolean;
    this.d.setColor(paramInt4);
    this.h = Color.alpha(paramInt4);
    this.g = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    try
    {
      this.f = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
      return;
    }
    catch (Throwable paramDrawable)
    {
    }
  }

  private void a(Canvas paramCanvas, Rect paramRect)
  {
    float f2;
    if (this.e)
    {
      f1 = 0.0F;
      float f3 = paramRect.bottom - this.g.getIntrinsicHeight();
      paramCanvas.save();
      if (this.j != 1.0F)
      {
        float f4 = this.j;
        float f5 = this.j;
        if (!this.e)
          break label174;
        f2 = paramRect.left;
        label64: paramCanvas.scale(f4, f5, f2, paramRect.bottom);
      }
      paramCanvas.translate(f1, f3);
      if (!this.e)
        break label184;
    }
    label174: label184: for (float f1 = this.c; ; f1 = -this.c)
    {
      paramCanvas.translate(f1, -this.c);
      if (!this.e)
        paramCanvas.scale(-1.0F, 1.0F, this.g.getIntrinsicWidth() / 2, this.g.getIntrinsicHeight() / 2);
      this.g.draw(paramCanvas);
      paramCanvas.restore();
      return;
      f1 = paramRect.right - this.g.getIntrinsicWidth();
      break;
      f2 = paramRect.right;
      break label64;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.b <= 0)
      return;
    Rect localRect = getBounds();
    int k = (int)(this.j * this.i);
    paramCanvas.saveLayer(localRect.left, localRect.top, localRect.right, localRect.bottom, null, 31);
    this.d.setXfermode(null);
    if (this.e)
    {
      f1 = localRect.left + k;
      label79: paramCanvas.drawCircle(f1, localRect.bottom - k, this.b * this.j, this.d);
      if (this.a > 0)
      {
        this.d.setXfermode(this.f);
        if (!this.e)
          break label198;
      }
    }
    label198: for (float f1 = localRect.left + k; ; f1 = localRect.right - k)
    {
      paramCanvas.drawCircle(f1, localRect.bottom - k, this.a * this.j, this.d);
      paramCanvas.restore();
      if (this.g == null)
        break;
      a(paramCanvas, localRect);
      return;
      f1 = localRect.right - k;
      break label79;
    }
  }

  public int getIntrinsicHeight()
  {
    return this.b + this.i;
  }

  public int getIntrinsicWidth()
  {
    return this.b + this.i;
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.j = (Math.min(paramRect.width(), paramRect.height()) * 1.0F / getIntrinsicWidth());
  }

  public void setAlpha(int paramInt)
  {
    this.d.setAlpha((int)(paramInt / 255.0F * this.h));
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yn
 * JD-Core Version:    0.6.2
 */