package cmcm.com.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public abstract class avh extends ImageView
{
  public avh(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public abstract float getRatio();

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension((int)(getRatio() * paramInt1), paramInt1);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avh
 * JD-Core Version:    0.6.2
 */