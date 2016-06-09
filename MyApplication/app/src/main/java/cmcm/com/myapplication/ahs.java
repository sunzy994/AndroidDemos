package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class ahs extends apd
{
  private final int e;
  private final boolean f;
  private boolean g = true;
  private final Rect h = new Rect();

  public ahs(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    super(paramBitmap);
    this.e = paramInt;
    this.f = paramBoolean;
  }

  public void a(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
      this.g = paramBoolean;
  }

  public void draw(Canvas paramCanvas)
  {
    if ((this.g) && (atw.b(this.a)))
      paramCanvas.drawBitmap(this.a, null, this.h, this.d);
  }

  public int getIntrinsicHeight()
  {
    return this.e;
  }

  public int getIntrinsicWidth()
  {
    return this.e;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    int i = ari.b(paramRect.width(), paramRect.height(), this.e);
    if (this.f)
    {
      this.h.set(0, paramRect.bottom - i, i, paramRect.bottom);
      return;
    }
    this.h.set(paramRect.right - i, paramRect.bottom - i, paramRect.right, paramRect.bottom);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahs
 * JD-Core Version:    0.6.2
 */