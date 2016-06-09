package cmcm.com.myapplication.com.lazyswipe.tile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class MirrorSurfaceView extends SurfaceView
{
  int a;
  int b;

  public MirrorSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    requestLayout();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a > 0)
      setMeasuredDimension(this.a, this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.MirrorSurfaceView
 * JD-Core Version:    0.6.2
 */