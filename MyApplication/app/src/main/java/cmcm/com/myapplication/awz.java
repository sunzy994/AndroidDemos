package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;

public class awz extends ViewGroup
{
  private int a = 48;

  public awz(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
  }

  public int getGravity()
  {
    return this.a;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if (localView == null)
      return;
    if (this.a == 48)
    {
      localView.layout(0, 0, getMeasuredWidth(), localView.getMeasuredHeight());
      return;
    }
    localView.layout(0, getMeasuredHeight() - localView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = MeasureSpec.getSize(paramInt2);
    int j = MeasureSpec.getSize(paramInt1);
    paramInt2 = MeasureSpec.getMode(paramInt2);
    View localView = getChildAt(0);
    if (localView == null)
    {
      setMeasuredDimension(0, j);
      return;
    }
    if (localView.isLayoutRequested())
      measureChild(localView, paramInt1, MeasureSpec.makeMeasureSpec(0, 0));
    paramInt1 = i;
    LayoutParams localLayoutParams;
    if (paramInt2 == 0)
    {
      localLayoutParams = getLayoutParams();
      if (localLayoutParams.height <= 0)
        break label88;
    }
    label88: for (paramInt1 = localLayoutParams.height; ; paramInt1 = localView.getMeasuredHeight())
    {
      setMeasuredDimension(j, paramInt1);
      return;
    }
  }

  public void setGravity(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awz
 * JD-Core Version:    0.6.2
 */