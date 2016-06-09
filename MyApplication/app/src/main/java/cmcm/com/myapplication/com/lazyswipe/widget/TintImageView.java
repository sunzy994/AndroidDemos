package cmcm.com.myapplication.com.lazyswipe.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import awe;

public class TintImageView extends ImageView
{
  public TintImageView(Context paramContext)
  {
    super(paramContext);
  }

  public TintImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TintImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public TintImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = getDrawable();
    if (!(localDrawable instanceof awe))
      setImageDrawable(new awe(localDrawable));
    super.draw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.TintImageView
 * JD-Core Version:    0.6.2
 */