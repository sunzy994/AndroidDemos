package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class zh extends ArrayAdapter<yu>
{
  public zh(Context paramContext, List<yu> paramList)
  {
    super(paramList, 0, localList);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new zi(this, null);
      paramView = LayoutInflater.from(getContext()).inflate(2130968721, null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131755195));
      paramViewGroup.b = ((CheckBox)paramView.findViewById(2131755406));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131755405));
      paramViewGroup.d = paramView.findViewById(2131755051);
      paramView.setTag(paramViewGroup);
    }
    while (true)
    {
      yu localyu = (yu)getItem(paramInt);
      paramViewGroup.a.setText(localyu.f());
      paramViewGroup.c.setImageDrawable(localyu.e());
      paramViewGroup.b.setChecked(localyu.b());
      if (paramInt < getCount() - 1)
        break;
      paramViewGroup.d.setVisibility(4);
      return paramView;
      paramViewGroup = (zi)paramView.getTag();
    }
    paramViewGroup.d.setVisibility(0);
    return paramView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zh
 * JD-Core Version:    0.6.2
 */