package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class aug extends aue
{
  private final Drawable a;
  private final Drawable b;
  private final int c;

  public aug(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt)
  {
    this.c = paramInt;
    this.a = paramDrawable1;
    this.b = paramDrawable2;
    paramDrawable1.setBounds(0, 0, paramInt, paramInt);
    paramDrawable2.setBounds((paramInt - paramDrawable2.getIntrinsicWidth()) / 2, (paramInt - paramDrawable2.getIntrinsicHeight()) / 2, (paramDrawable2.getIntrinsicWidth() + paramInt) / 2, (paramDrawable2.getIntrinsicHeight() + paramInt) / 2);
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
      this.a.draw(paramCanvas);
    if (this.b != null)
      this.b.draw(paramCanvas);
  }

  public int getIntrinsicHeight()
  {
    if (getBounds().height() > 0)
      return getBounds().height();
    return this.c;
  }

  public int getIntrinsicWidth()
  {
    if (getBounds().width() > 0)
      return getBounds().width();
    return this.c;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.a != null)
      this.a.setBounds(paramRect);
    if (this.b != null)
      this.b.setBounds(paramRect.left + (paramRect.width() - this.b.getIntrinsicWidth()) / 2, paramRect.top + (paramRect.height() - this.b.getIntrinsicHeight()) / 2, paramRect.left + (paramRect.width() + this.b.getIntrinsicWidth()) / 2, paramRect.top + (paramRect.height() + this.b.getIntrinsicHeight()) / 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aug
 * JD-Core Version:    0.6.2
 */