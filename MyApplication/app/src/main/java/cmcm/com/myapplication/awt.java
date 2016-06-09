package cmcm.com.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class awt extends BaseAdapter
{
  private final awo b;

  public awt(aws paramaws, awo paramawo)
  {
    this.b = paramawo;
  }

  public awr a(int paramInt)
  {
    if (aws.a(this.a));
    for (ArrayList localArrayList = this.b.i(); ; localArrayList = this.b.g())
      return (awr)localArrayList.get(paramInt);
  }

  public int getCount()
  {
    if (aws.a(this.a));
    for (ArrayList localArrayList = this.b.i(); ; localArrayList = this.b.g())
      return localArrayList.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = aws.b(this.a).inflate(2130968723, paramViewGroup, false);
    while (true)
    {
      ((awx)paramView).a(a(paramInt));
      return paramView;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awt
 * JD-Core Version:    0.6.2
 */