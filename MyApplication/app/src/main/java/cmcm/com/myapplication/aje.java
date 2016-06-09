package cmcm.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.lazyswipe.features.theme.preview.LocalThemeDetailActivity;
import java.util.ArrayList;
import java.util.List;

public class aje extends apb
{
  private GridView aa;
  private List<ahw> ab = new ArrayList();
  private ajd ac;
  private OnScrollListener ad = new OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if (aje.a(aje.this) != null)
        aje.a(aje.this).b(paramAnonymousInt);
    }
  };
  private aji ai = new aji()
  {
    protected void a(Context paramAnonymousContext)
    {
      aje.a(aje.this, true);
    }
  };

  private void d(boolean paramBoolean)
  {
    List localList = ahx.e(c());
    if ((paramBoolean) || (localList.size() != this.ab.size()))
    {
      this.ac.a(localList);
      this.ac.notifyDataSetChanged();
    }
  }

  protected int J()
  {
    return 2130968641;
  }

  protected boolean K()
  {
    return false;
  }

  public void L()
  {
  }

  public void M()
  {
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.aa = ((GridView)a(paramView, 2131755046));
    this.ac = new ajd(d());
    this.ab = ahx.e(c());
    this.ac.a(this.ab);
    this.aa.setAdapter(this.ac);
    this.aa.setOnScrollListener(this.ad);
    this.aa.setOnItemClickListener(new OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (ahw)aje.a(aje.this).a(paramAnonymousInt);
        LocalThemeDetailActivity.a(aje.this.d(), paramAnonymousAdapterView.g);
      }
    });
  }

  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    this.ai.c(d());
  }

  public void o()
  {
    super.o();
    if (this.ac != null)
      this.ac.a();
    this.ai.d(d());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aje
 * JD-Core Version:    0.6.2
 */