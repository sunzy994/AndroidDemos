package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.weather.bean.City;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class afk extends BaseAdapter
{
  private final List<City> b = new ArrayList();
  private final int c;
  private boolean d = true;
  private boolean e = false;
  private int f;
  private final View g;
  private final View h;
  private final ProgressBar i;
  private final ListView j;
  private final boolean k;
  private final boolean l;
  private final LayoutInflater m;

  public afk(CityQueryView paramCityQueryView, Context paramContext, int paramInt, ListView paramListView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramInt;
    this.m = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.g = this.m.inflate(2130968616, null);
    this.h = this.g.findViewById(2131755194);
    this.i = ((ProgressBar)this.g.findViewById(2131755193));
    paramCityQueryView = new tn(paramContext, asq.a(28.0F));
    paramCityQueryView.setBounds(0, 0, asq.a(28.0F), asq.a(28.0F));
    this.i.setIndeterminateDrawable(paramCityQueryView);
    this.j = paramListView;
    this.k = paramBoolean1;
    this.l = paramBoolean2;
  }

  public int a()
  {
    return this.f;
  }

  public void a(Collection<City> paramCollection, boolean paramBoolean, int paramInt)
  {
    int n = paramInt;
    if (paramInt <= 1)
    {
      this.b.clear();
      n = 1;
    }
    this.f = n;
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        City localCity = (City)paramCollection.next();
        this.b.add(localCity);
      }
    }
    this.d = paramBoolean;
    this.e = false;
    b();
    notifyDataSetChanged();
  }

  public void b()
  {
    if ((this.d) && (this.j.getFooterViewsCount() == 0))
      this.j.addFooterView(this.g);
    while (this.e)
    {
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      return;
      if ((!this.d) && (this.j.getFooterViewsCount() > 0))
        this.j.removeFooterView(this.g);
    }
    this.i.setVisibility(8);
    this.h.setVisibility(0);
  }

  public int getCount()
  {
    int i1 = this.b.size();
    if (this.l);
    for (int n = 1; ; n = 0)
      return n + i1;
  }

  public Object getItem(int paramInt)
  {
    if (this.l)
    {
      if (paramInt == 0)
        return CityQueryView.i(this.a);
      return this.b.get(paramInt - 1);
    }
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.m.inflate(this.c, paramViewGroup, false);
      paramViewGroup = new afl(paramView);
      paramView.setTag(paramViewGroup);
    }
    while (true)
    {
      Object localObject = getItem(paramInt);
      if (!(localObject instanceof City))
        break;
      paramViewGroup.a((City)localObject, this.k);
      paramViewGroup.a.setTag(localObject);
      return paramView;
      paramViewGroup = (afl)paramView.getTag();
    }
    paramViewGroup.a();
    return paramView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afk
 * JD-Core Version:    0.6.2
 */