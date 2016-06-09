package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.PointF;
import com.lazyswipe.widget.recyclerview.LinearLayoutManager;
import com.lazyswipe.widget.recyclerview.RecyclerView;

public class adu extends LinearLayoutManager
{
  private Context k;

  public adu(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    this.k = paramContext;
  }

  public void a(RecyclerView paramRecyclerView, azi paramazi, int paramInt)
  {
    paramRecyclerView = new ayl(this.k)
    {
      protected int a()
      {
        return -1;
      }

      public PointF a(int paramAnonymousInt)
      {
        return adu.this.c(paramAnonymousInt);
      }
    };
    paramRecyclerView.d(paramInt);
    a(paramRecyclerView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adu
 * JD-Core Version:    0.6.2
 */