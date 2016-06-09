package cmcm.com.myapplication.com.hola.channel.sdk.game.app;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.hola.channel.sdk.game.fragment.BaseGameFragment;
import jb;
import sq;

public abstract class LoaderFragment<D> extends BaseGameFragment
  implements LoaderCallbacks<D>, OnItemClickListener, jb
{
  private static final String c = "GameSDK." + LoaderFragment.class.getSimpleName();
  public ListView d;
  public SwipeRefreshLayout e;
  protected int f = Math.abs(hashCode());
  public int g = 20;
  public int h = 1;
  protected int i = 1;
  protected boolean j;
  protected sq k;

  public View a(int paramInt)
  {
    return null;
  }

  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    if (paramBundle != null)
    {
      this.f = paramBundle.getInt("loaderId", this.f);
      this.g = paramBundle.getInt("pageSize", this.g);
    }
  }

  public void a(View paramView)
  {
    super.a(paramView);
    this.d = ((ListView)paramView.findViewById(16908298));
    paramView = paramView.findViewById(16908292);
    if (paramView != null)
      this.d.setEmptyView(paramView);
    if ((this.d.getParent() instanceof SwipeRefreshLayout))
    {
      this.e = ((SwipeRefreshLayout)this.d.getParent());
      if (this.e != null)
      {
        this.e.setOnRefreshListener(this);
        k();
      }
    }
  }

  protected View b(int paramInt)
  {
    return null;
  }

  public abstract ListAdapter d();

  public void g()
  {
    this.j = true;
  }

  public int h()
  {
    return 0;
  }

  public int i()
  {
    return 0;
  }

  protected int j()
  {
    return 0;
  }

  public void k()
  {
    this.e.setEnabled(false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    int n = 0;
    super.onActivityCreated(paramBundle);
    try
    {
      int i1 = j();
      int m = 0;
      while (m < i1)
      {
        this.d.addHeaderView(b(m));
        m += 1;
      }
      i1 = i() - 1;
      m = n;
      while (m < i1)
      {
        this.d.addFooterView(a(m));
        m += 1;
      }
      if (m < i1 + 1)
      {
        paramBundle = a(m);
        if ((paramBundle instanceof sq))
          this.k = ((sq)paramBundle);
        this.d.addFooterView(paramBundle);
      }
      this.d.setAdapter(d());
      m = h();
      if (m != 0)
        this.f = m;
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
    if (this.d != null)
    {
      this.d.setAdapter(null);
      this.d = null;
    }
    super.onDestroy();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
  }

  public void onLoadFinished(Loader<D> paramLoader, D paramD)
  {
    if (this.j)
      this.j = false;
    if ((this.e != null) && (this.e.a()))
      this.e.setRefreshing(false);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("loaderId", this.f);
    paramBundle.putInt("pageSize", this.g);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.app.LoaderFragment
 * JD-Core Version:    0.6.2
 */