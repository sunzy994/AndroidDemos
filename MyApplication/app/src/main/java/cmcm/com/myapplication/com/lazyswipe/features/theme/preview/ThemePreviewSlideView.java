package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import aqs;
import com.lazyswipe.widget.GridGallery;

public class ThemePreviewSlideView extends GridGallery
{
  private float a;
  private final Matrix b = new Matrix();

  public ThemePreviewSlideView(Context paramContext)
  {
    super(paramContext);
  }

  public ThemePreviewSlideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i;
    if ((this.a == 0.0F) && ((paramView instanceof ThemePreviewItem)))
    {
      i = ((ThemePreviewItem)paramView).getImage().getMeasuredWidth();
      if (i != 0)
        this.a = ((aqs.ac() - i) * 3.0F / 4.0F);
    }
    if (this.a != 0.0F)
    {
      i = paramView.getLeft();
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      float f = i * 1.0F / j;
      this.b.reset();
      this.b.postTranslate(-i, -k / 2);
      if (f < 0.0F)
        this.b.postTranslate(-j, 0.0F);
      if (f < 0.0F)
        this.b.postTranslate(j, 0.0F);
      this.b.postTranslate(i, k / 2);
      this.b.postTranslate(-f * this.a, 0.0F);
      paramCanvas.save();
      paramCanvas.concat(this.b);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restore();
      return bool;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.ThemePreviewSlideView
 * JD-Core Version:    0.6.2
 */