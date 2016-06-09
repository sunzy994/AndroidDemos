package cmcm.com.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.lazyswipe.widget.GridGallery;

public class avj extends ViewGroup.LayoutParams
{
  public boolean a = false;

  public avj(GridGallery paramGridGallery, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public avj(GridGallery paramGridGallery, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public avj(GridGallery paramGridGallery, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avj
 * JD-Core Version:    0.6.2
 */