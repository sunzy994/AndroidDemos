package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;

public class l extends RelativeLayout
{
  private int a = 0;
  private int b = 0;

  public l(Context paramContext)
  {
    super(paramContext);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.b > 0) && (getMeasuredWidth() > this.b))
      setMeasuredDimension(this.b, getMeasuredHeight());
    while (getMeasuredWidth() >= this.a)
      return;
    setMeasuredDimension(this.a, getMeasuredHeight());
  }

  protected void setMaxWidth(int paramInt)
  {
    this.b = paramInt;
  }

  public void setMinWidth(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.l
 * JD-Core Version:    0.6.2
 */