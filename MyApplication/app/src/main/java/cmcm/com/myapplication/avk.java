package cmcm.com.myapplication;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.BaseAdapter;
import com.lazyswipe.widget.GridGallery;
import java.util.LinkedList;

public class avk extends DataSetObserver
{
  private avk(GridGallery paramGridGallery)
  {
  }

  public void onChanged()
  {
    Object localObject = (View)GridGallery.a(this.a).poll();
    if (localObject == null)
    {
      GridGallery.b(this.a);
      GridGallery.a(this.a, true);
      localObject = this.a;
      if (GridGallery.c(this.a) != null)
        break label77;
    }
    label77: for (int i = 0; ; i = GridGallery.c(this.a).getCount())
    {
      GridGallery.a((GridGallery)localObject, i);
      this.a.requestLayout();
      return;
      this.a.a((View)localObject, false);
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avk
 * JD-Core Version:    0.6.2
 */