package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class afz extends BaseAdapter
  implements OnClickListener
{
  private afz(afy paramafy)
  {
  }

  public int getCount()
  {
    return afy.d(this.a).size();
  }

  public Object getItem(int paramInt)
  {
    return afy.d(this.a).get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(afy.j(this.a)).inflate(2130968674, null);
      paramView = new age(this.a, null);
      paramView.a = ((ImageView)paramViewGroup.findViewById(2131755306));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131755308));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131755310));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131755311));
      paramView.e = ((Button)paramViewGroup.findViewById(2131755312));
      paramViewGroup.setTag(paramView);
    }
    agh localagh = (agh)afy.d(this.a).get(paramInt);
    age localage = (age)paramViewGroup.getTag();
    localage.b.setText(localagh.b);
    localage.d.setText(localagh.e);
    long l2 = localagh.g;
    paramView = "";
    long l1;
    if (l2 >= 1000000000L)
    {
      l1 = l2 / 1000000000L;
      paramView = " Billion+";
      localage.c.setText(String.valueOf(l1) + paramView);
      if ((afy.i(this.a)[paramInt] != null) && (afy.i(this.a)[paramInt].b != null))
        break label396;
      afy.i(this.a)[paramInt] = new agd(null);
      afy.a(this.a, paramInt, paramViewGroup);
      label272: if (!asq.c(afy.j(this.a), localagh.c))
        break label419;
      localage.e.setText(afy.j(this.a).getString(2131231220));
      localage.e.setBackgroundResource(2130837631);
    }
    while (true)
    {
      localage.e.setTag(localagh);
      localage.e.setOnClickListener(this);
      paramViewGroup.setId(paramInt);
      return paramViewGroup;
      if (l2 >= 1000000L)
      {
        l1 = l2 / 1000000L;
        paramView = " Million+";
        break;
      }
      l1 = l2;
      if (l2 < 1000L)
        break;
      l1 = l2 / 1000L;
      paramView = ",000+";
      break;
      label396: localage.a.setImageBitmap(afy.i(this.a)[paramInt].b);
      break label272;
      label419: localage.e.setText(afy.j(this.a).getString(2131231218));
      localage.e.setBackgroundResource(2130837628);
    }
  }

  public void onClick(View paramView)
  {
    Object localObject;
    Context localContext;
    if ((paramView.getTag() instanceof agh))
    {
      localObject = (agh)paramView.getTag();
      paramView = ((agh)localObject).d.split("&referrer=");
      localObject = ((agh)localObject).c;
      if (!asq.c(afy.j(this.a), (String) localObject))
        vy.a(afy.j(this.a), "CP", (String)localObject);
      if (paramView.length <= 1)
        break label94;
      paramView = paramView[1];
      localContext = afy.j(this.a);
      if (!TextUtils.isEmpty(paramView))
        break label99;
    }
    label94: label99: for (paramView = (View)localObject; ; paramView = (String)localObject + "&referrer=" + paramView)
    {
      asq.g(localContext, paramView);
      return;
      paramView = null;
      break;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afz
 * JD-Core Version:    0.6.2
 */