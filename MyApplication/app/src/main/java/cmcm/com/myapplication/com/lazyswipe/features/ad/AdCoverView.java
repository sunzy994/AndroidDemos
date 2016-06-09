package cmcm.com.myapplication.com.lazyswipe.features.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import aqs;
import asq;
import com.lazyswipe.widget.FixWidthHeightRatioImageView;
import vj;

public class AdCoverView extends FixWidthHeightRatioImageView
{
  private static final String d = "Swipe." + AdCoverView.class.getSimpleName();
  private boolean e;

  public AdCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.e) || (this.c * this.b == 0))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (!vj.g)
    {
      if (this.c > this.b)
      {
        paramInt1 = aqs.ac() / 2 - asq.a(12.0F);
        setMeasuredDimension(paramInt1, (int)(this.a * paramInt1));
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (this.c > this.b)
    {
      paramInt2 = aqs.ae() - asq.a(48.0F);
      paramInt1 = paramInt2;
      if (vj.d > 480)
        paramInt1 = paramInt2 + asq.a(4.0F);
      setMeasuredDimension((int)(paramInt1 / this.a), paramInt1);
      return;
    }
    paramInt2 = aqs.ae();
    int i = asq.a(200.0F);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2 - i);
  }

  public void setAdCoverSizeFix(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.ad.AdCoverView
 * JD-Core Version:    0.6.2
 */