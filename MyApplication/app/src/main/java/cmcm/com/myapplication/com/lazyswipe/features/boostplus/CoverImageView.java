package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class CoverImageView extends ImageView
{
  private float a = 0.6474609F;
  private float b = -1.0F;

  public CoverImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    super.setImageBitmap(paramBitmap);
    if ((paramBitmap != null) && (paramBoolean))
    {
      this.b = (paramBitmap.getHeight() / paramBitmap.getWidth());
      return;
    }
    this.b = -1.0F;
  }

  public float getOriginRatio()
  {
    return this.a;
  }

  public float getRatio()
  {
    if (this.b > 0.0F)
      return this.b;
    return this.a;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, (int)(getRatio() * paramInt1));
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.b = -1.0F;
  }

  public void setOriginRatio(float paramFloat)
  {
    if (paramFloat > 0.0F)
      this.a = paramFloat;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.CoverImageView
 * JD-Core Version:    0.6.2
 */