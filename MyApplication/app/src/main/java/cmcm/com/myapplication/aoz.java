package cmcm.com.myapplication;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class aoz
  implements OnScrollListener
{
  private boolean b = false;
  private aiy c;

  public aoz(aoy paramaoy, aiy paramaiy)
  {
    this.c = paramaiy;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= paramInt1 + paramInt2)
    {
      this.b = true;
      return;
    }
    this.b = false;
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c != null)
      this.c.b(paramInt);
    if (this.b)
      this.a.Q();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoz
 * JD-Core Version:    0.6.2
 */