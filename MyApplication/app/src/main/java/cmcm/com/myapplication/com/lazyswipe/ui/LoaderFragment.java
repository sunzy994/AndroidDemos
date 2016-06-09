package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public abstract class LoaderFragment<D> extends BaseFragment
  implements LoaderCallbacks<D>, AdapterView.OnItemClickListener
{
  private static final String g = "Swipe." + LoaderFragment.class.getSimpleName();
  protected AbsListView a;
  protected int f = Math.abs(hashCode());

  protected void b()
  {
  }

  protected abstract ListAdapter d();

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    try
    {
      this.a.setOnItemClickListener(this);
      this.a.setAdapter(d());
      b();
      getLoaderManager().initLoader(this.f, null, this);
      return;
    }
    catch (Throwable paramBundle)
    {
    }
  }

  public void onDestroy()
  {
    getLoaderManager().destroyLoader(this.f);
    if (this.a != null)
    {
      this.a.setAdapter(null);
      this.a = null;
    }
    super.onDestroy();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("loaderId", this.f);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.LoaderFragment
 * JD-Core Version:    0.6.2
 */