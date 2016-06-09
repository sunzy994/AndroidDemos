package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lazyswipe.features.locate.CityQueryView;
import com.lazyswipe.features.weather.bean.City;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afj extends BaseAdapter
{
  private final List<City> b = new ArrayList();
  private String c = null;
  private final int d;
  private final LayoutInflater e;

  public afj(CityQueryView paramCityQueryView, Context paramContext, int paramInt)
  {
    this.d = paramInt;
    this.e = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    if (this.b.isEmpty())
    {
      if (CityQueryView.o(paramCityQueryView) == null)
        CityQueryView.a(paramCityQueryView, new ajy(paramContext, paramContext.getPackageName()));
      a(null);
    }
  }

  private void a(List<City> paramList1, List<City> paramList2)
  {
    int i = paramList2.size() - 1;
    while (i >= 0)
    {
      this.b.add(paramList2.get(i));
      i -= 1;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      City localCity = (City)paramList1.next();
      if (!paramList2.contains(localCity))
        this.b.add(localCity);
    }
    notifyDataSetChanged();
  }

  public void a(String paramString)
  {
    this.c = paramString;
    this.b.clear();
    if (TextUtils.isEmpty(paramString));
    for (paramString = CityQueryView.o(this.a).a(); ; paramString = CityQueryView.o(this.a).a(paramString, CityQueryView.p(this.a)))
    {
      a(paramString, CityQueryView.j(this.a).j());
      return;
    }
  }

  public void a(List<City> paramList)
  {
    this.b.clear();
    a(CityQueryView.o(this.a).a(), paramList);
  }

  public boolean a()
  {
    if (this.c != null)
    {
      a(null);
      return true;
    }
    return false;
  }

  public int getCount()
  {
    return this.b.size() + 1;
  }

  public Object getItem(int paramInt)
  {
    if (paramInt == 0)
      return CityQueryView.i(this.a);
    return this.b.get(paramInt - 1);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.e.inflate(this.d, paramViewGroup, false);
    while (true)
    {
      paramViewGroup = (TextView)paramView;
      Object localObject = getItem(paramInt);
      paramViewGroup.setTag(localObject);
      if ((localObject instanceof City))
      {
        paramViewGroup.setText(((City)localObject).a());
        return paramView;
      }
      paramViewGroup.setText(2131230810);
      return paramView;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afj
 * JD-Core Version:    0.6.2
 */