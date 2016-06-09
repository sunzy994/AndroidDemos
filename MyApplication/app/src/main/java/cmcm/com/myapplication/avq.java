package cmcm.com.myapplication;

import android.view.View;
import android.widget.GridLayout;
import com.lazyswipe.fan.FanItem;

public class avq
{
  private final FanItem[] a;
  private final int b;
  private final GridLayout c;

  public avq(avp paramavp, GridLayout paramGridLayout, int paramInt)
  {
    this.c = paramGridLayout;
    this.b = paramInt;
    this.a = new FanItem[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      this.a[paramInt] = ((FanItem)this.c.getChildAt(paramInt));
      paramavp.a(this.a[paramInt]);
      paramInt += 1;
    }
    paramInt = this.b;
    while (paramInt < this.c.getChildCount())
    {
      this.c.getChildAt(paramInt).setVisibility(8);
      paramInt += 1;
    }
    this.c.setTag(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avq
 * JD-Core Version:    0.6.2
 */