package cmcm.com.myapplication.com.lazyswipe.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.widget.FixWidthHeightRatioImageView;

public class PreviewImageView extends FixWidthHeightRatioImageView
{
  public PreviewImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a()
  {
    setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837806));
    setBackgroundColor(-1710619);
    if (getScaleType() != ImageView.ScaleType.CENTER_INSIDE)
      setScaleType(ImageView.ScaleType.CENTER_INSIDE);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), (int)(getMeasuredWidth() * 1.777976F));
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    setBackgroundDrawable(null);
    if (getScaleType() != ImageView.ScaleType.FIT_XY)
      setScaleType(ImageView.ScaleType.FIT_XY);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.view.PreviewImageView
 * JD-Core Version:    0.6.2
 */