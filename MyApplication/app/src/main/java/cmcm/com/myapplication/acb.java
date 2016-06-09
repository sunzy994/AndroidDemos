package cmcm.com.myapplication;

import android.content.ComponentName;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lazyswipe.features.allapps.AppsContentView;
import com.lazyswipe.features.allapps.AppsListAppIcon;
import com.lazyswipe.features.allapps.AppsListItem;

public final class acb extends BaseAdapter
{
  private acb(AppsContentView paramAppsContentView)
  {
  }

  public void a()
  {
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return AppsContentView.e(this.a).e();
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
    int j;
    int k;
    ach[] arrayOfach;
    final AppsListAppIcon[] arrayOfAppsListAppIcon;
    int i;
    if (paramView == null)
    {
      paramView = (AppsListItem)LayoutInflater.from(this.a.getContext()).inflate(2130968592, null);
      j = AppsContentView.e(this.a).b(paramInt);
      k = AppsContentView.e(this.a).a(j);
      arrayOfach = AppsContentView.e(this.a).a(j, paramInt - k);
      arrayOfAppsListAppIcon = paramView.getBodyViews();
      paramViewGroup = arrayOfAppsListAppIcon;
      if (arrayOfAppsListAppIcon.length != arrayOfach.length)
      {
        paramView.a(arrayOfach.length);
        paramViewGroup = paramView.getBodyViews();
      }
      i = 0;
      label102: if (i >= arrayOfach.length)
        break label338;
      if (arrayOfach[i] == null)
        break label302;
      paramViewGroup[i].setText(arrayOfach[i].b);
      if (arrayOfach[i].b() == null)
        break label200;
      paramViewGroup[i].a(arrayOfach[i].b(), false);
      label160: paramViewGroup[i].setTag(arrayOfach[i]);
      paramViewGroup[i].setOnClickListener(this.a);
    }
    while (true)
    {
      i += 1;
      break label102;
      paramView = (AppsListItem)paramView;
      break;
      label200: arrayOfAppsListAppIcon = paramViewGroup[i];
      final ach localach = arrayOfach[i];
      if (AppsContentView.f(this.a) == null)
        break label160;
      xo localxo = AppsContentView.f(this.a).a(new xo()
      {
        public void a()
        {
          if (this.a != null)
            AppsContentView.g(acb.this.a).post(new Runnable()
            {
              public void run()
              {
                acb.1.this.b.a(acb.1.this.a, false);
                acb.1.this.c.a(acb.1.this.a);
              }
            });
        }

        public ComponentName b()
        {
          return localach.a.i;
        }
      });
      if (localxo != null)
      {
        arrayOfAppsListAppIcon.a(localxo.a, false);
        localach.a(localxo.a);
        break label160;
      }
      arrayOfAppsListAppIcon.a(new apd(AppsContentView.f(this.a).e()), true);
      break label160;
      label302: paramViewGroup[i].setText(null);
      paramViewGroup[i].a(null, false);
      paramViewGroup[i].setTag(null);
      paramViewGroup[i].setOnClickListener(null);
    }
    label338: paramView.getBodyView().setOnClickListener(this.a);
    if (paramInt == k)
    {
      paramViewGroup = AppsContentView.e(this.a).b()[j];
      if (paramInt == 0);
      for (boolean bool = true; ; bool = false)
      {
        paramView.a(bool, paramViewGroup);
        return paramView;
      }
    }
    paramView.a(false, null);
    return paramView;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acb
 * JD-Core Version:    0.6.2
 */