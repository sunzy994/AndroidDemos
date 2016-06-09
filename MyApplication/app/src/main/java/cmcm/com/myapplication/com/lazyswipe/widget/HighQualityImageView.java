package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import atw;

public class HighQualityImageView extends ImageView
{
  public HighQualityImageView(Context paramContext)
  {
    super(paramContext);
  }

  public HighQualityImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    DrawFilter localDrawFilter = paramCanvas.getDrawFilter();
    paramCanvas.setDrawFilter(atw.a);
    super.onDraw(paramCanvas);
    paramCanvas.setDrawFilter(localDrawFilter);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.HighQualityImageView
 * JD-Core Version:    0.6.2
 */