package cmcm.com.myapplication.com.hola.channel.sdk.game.app;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import ra;
import rd;
import sq;

public abstract class CursorLoaderFragment extends LoaderFragment<Cursor>
  implements OnScrollListener
{
  private static final String s = "GameSDK." + CursorLoaderFragment.class.getSimpleName();
  public CursorAdapter c;

  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);

  public abstract rd a(int paramInt, Bundle paramBundle);

  public void a(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    super.onLoadFinished(paramLoader, paramCursor);
    this.c.swapCursor(paramCursor);
    if (paramCursor != null)
    {
      this.i = b(paramCursor);
      this.h = c(paramCursor);
      e();
    }
  }

  public abstract void a(Cursor paramCursor);

  public abstract void a(View paramView, Context paramContext, Cursor paramCursor);

  public abstract int b(Cursor paramCursor);

  public abstract int c(Cursor paramCursor);

  public ListAdapter d()
  {
    ra localra = new ra(this, getActivity(), null);
    this.c = localra;
    return localra;
  }

  protected void e()
  {
    if (this.k == null);
    do
    {
      do
      {
        return;
        if ((this.h < this.i) && (f()))
          break;
      }
      while (!this.k.c());
      this.k.b();
      return;
    }
    while (this.k.c());
    this.k.a();
  }

  public boolean f()
  {
    return false;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((f()) && (this.d != null))
      this.d.setOnScrollListener(this);
  }

  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = a(paramInt, paramBundle);
    paramBundle.setUpdateThrottle(1500L);
    return paramBundle;
  }

  public void onDestroy()
  {
    if (this.c != null)
    {
      this.c.swapCursor(null);
      this.c = null;
    }
    super.onDestroy();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((Cursor)paramAdapterView.getItemAtPosition(paramInt));
  }

  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    if (this.c != null)
      this.c.swapCursor(null);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.j) && (!this.e.a()) && (f()) && (this.k.c()) && (paramAbsListView.getLastVisiblePosition() >= paramAbsListView.getCount() - 1))
      g();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.app.CursorLoaderFragment
 * JD-Core Version:    0.6.2
 */