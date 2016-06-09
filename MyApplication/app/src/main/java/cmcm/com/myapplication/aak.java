package cmcm.com.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lazyswipe.fan.tab.CustomTabSettingsFragment;
import java.util.List;

public class aak extends BaseAdapter
{
  private aak(CustomTabSettingsFragment paramCustomTabSettingsFragment)
  {
  }

  public int getCount()
  {
    return CustomTabSettingsFragment.a(this.a).size();
  }

  public Object getItem(int paramInt)
  {
    return CustomTabSettingsFragment.a(this.a).get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
      paramViewGroup = LayoutInflater.from(this.a.getActivity()).inflate(2130968623, null);
    paramView = (TextView)paramViewGroup.findViewById(2131755211);
    if (paramInt == 0);
    for (int i = -1; ; i = 2046820351)
    {
      paramView.setTextColor(i);
      aao localaao = (aao)CustomTabSettingsFragment.a(this.a).get(paramInt);
      paramView.setText(localaao.a(this.a.getActivity()));
      if (!(localaao instanceof aaj))
        break;
      paramView.setTag(localaao);
      paramView.setOnClickListener(this.a);
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837661, 0);
      return paramViewGroup;
    }
    paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    return paramViewGroup;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aak
 * JD-Core Version:    0.6.2
 */