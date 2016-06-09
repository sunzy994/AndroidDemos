package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.widget.HorizontalGridList;

public class avp extends BaseAdapter
{
  private final HorizontalGridList a;

  public avp(HorizontalGridList paramHorizontalGridList)
  {
    this.a = paramHorizontalGridList;
  }

  private avq a(ViewGroup paramViewGroup, int paramInt)
  {
    return new avq(this, (GridLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968595, paramViewGroup, false), HorizontalGridList.a(this.a));
  }

  private void a(avq paramavq, int paramInt)
  {
    int j = HorizontalGridList.a(this.a);
    int k = a();
    paramInt *= j;
    int i = 0;
    if (i < j)
    {
      FanItem localFanItem = avq.b(paramavq)[i];
      if (paramInt > k - 1)
        if (localFanItem.getVisibility() == 0)
          localFanItem.setVisibility(4);
      while (true)
      {
        i += 1;
        paramInt += 1;
        break;
        if (localFanItem.getVisibility() != 0)
          localFanItem.setVisibility(0);
        a(localFanItem, paramInt);
        b(localFanItem);
      }
    }
  }

  @TargetApi(15)
  private void b(FanItem paramFanItem)
  {
    if ((Build.VERSION.SDK_INT >= 15) && (!paramFanItem.hasOnClickListeners()))
      paramFanItem.setOnClickListener(HorizontalGridList.b(this.a));
  }

  protected int a()
  {
    return 0;
  }

  protected void a(FanItem paramFanItem)
  {
    paramFanItem.setTextColor(Color.parseColor("#4e4e4e"));
  }

  protected void a(FanItem paramFanItem, int paramInt)
  {
  }

  public int b()
  {
    if (HorizontalGridList.a(this.a) == 0)
      return 0;
    return (int)Math.ceil(a() / (HorizontalGridList.a(this.a) * 1.0F));
  }

  public int getCount()
  {
    return b();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (paramView = a(paramViewGroup, paramInt); ; paramView = (avq)paramView.getTag())
    {
      a(paramView, paramInt);
      return avq.a(paramView);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     avp
 * JD-Core Version:    0.6.2
 */