package cmcm.com.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class apd extends Drawable
{
  protected Bitmap a;
  protected int b;
  protected int c;
  protected final Paint d = new Paint(2);

  public apd(Resources paramResources, Bitmap paramBitmap)
  {
    this(paramBitmap);
  }

  public apd(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    if (paramBitmap != null)
    {
      this.b = this.a.getWidth();
      this.c = this.a.getHeight();
      return;
    }
    this.c = 0;
    this.b = 0;
  }

  public Bitmap a()
  {
    return this.a;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      if (this.a.isRecycled())
        Log.e("Launcher.Bitmap", "Bitmap is already recycled.");
    }
    else
      return;
    Rect localRect = getBounds();
    paramCanvas.drawBitmap(this.a, null, localRect, this.d);
  }

  public int getIntrinsicHeight()
  {
    return this.c;
  }

  public int getIntrinsicWidth()
  {
    return this.b;
  }

  public int getMinimumHeight()
  {
    return this.c;
  }

  public int getMinimumWidth()
  {
    return this.b;
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apd
 * JD-Core Version:    0.6.2
 */