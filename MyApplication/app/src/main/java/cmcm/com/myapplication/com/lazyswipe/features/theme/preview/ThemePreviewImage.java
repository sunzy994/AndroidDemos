package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import asq;
import avh;

public class ThemePreviewImage extends avh
{
  private boolean a;
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final int d = asq.a(4.0F);

  public ThemePreviewImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected float getRatio()
  {
    return 0.5951265F;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((!isInEditMode()) && (this.a) && (getDrawable() != null))
    {
      Rect localRect = getDrawable().getBounds();
      this.c.set(localRect);
      this.b.reset();
      this.b.addRoundRect(this.c, this.d, this.d, Direction.CW);
      paramCanvas.scale(0.95F, 0.95F, getWidth() / 2, getHeight() / 2);
      paramCanvas.save();
      paramCanvas.clipPath(this.b);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }

  protected void setClipRoundRect(boolean paramBoolean)
  {
    this.a = false;
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.ThemePreviewImage
 * JD-Core Version:    0.6.2
 */