package cmcm.com.myapplication;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

public class gk extends DataSetObserver
{
  private gk(ViewPager paramViewPager)
  {
  }

  public void onChanged()
  {
    this.a.dataSetChanged();
  }

  public void onInvalidated()
  {
    this.a.dataSetChanged();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gk
 * JD-Core Version:    0.6.2
 */