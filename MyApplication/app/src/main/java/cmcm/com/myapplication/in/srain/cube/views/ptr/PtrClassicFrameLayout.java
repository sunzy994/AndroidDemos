package cmcm.com.myapplication.in.srain.cube.views.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import azs;
import azt;
import azu;

public class PtrClassicFrameLayout extends azu
{
  private azs d;

  public PtrClassicFrameLayout(Context paramContext)
  {
    super(paramContext);
    i();
  }

  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }

  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
  }

  private void i()
  {
    this.d = new azs(getContext());
    setHeaderView(this.d);
    a(this.d);
  }

  public void a(azt paramazt1, azt paramazt2)
  {
    this.d.a(paramazt1, paramazt2);
  }

  public azs getHeader()
  {
    return this.d;
  }

  public ProgressBar getPrgoressBar()
  {
    return this.d.getLoadingProgressBar();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     in.srain.cube.views.ptr.PtrClassicFrameLayout
 * JD-Core Version:    0.6.2
 */