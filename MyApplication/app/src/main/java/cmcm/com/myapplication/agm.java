package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

public abstract class agm extends agj<agr>
  implements OnClickListener
{
  protected final int g = asq.a(44.0F);
  protected final int h = asq.a(80.0F);
  private final xq i;
  private final Handler j = new Handler();

  public agm(Context paramContext, String paramString, xq paramxq)
  {
    super(paramContext, paramString);
    this.i = paramxq;
  }

  protected View a(int paramInt)
  {
    if (getTotalItemCount() <= paramInt)
      return null;
    agn localagn = g();
    paramInt = getLineItemCount() * paramInt;
    localagn.a(this.b, paramInt);
    localagn.setLayoutParams(new LayoutParams(-1, 0 + this.h));
    return localagn;
  }

  protected boolean e()
  {
    return false;
  }

  protected agn g()
  {
    return new agn(this, getContext());
  }

  protected View getContentBottomEdgeView()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LayoutParams(-1, asq.a(10.0F)));
    return localLinearLayout;
  }

  protected int getInitPageSize()
  {
    return 2;
  }

  protected int getLineItemCount()
  {
    return 5;
  }

  protected int getNextPageSize()
  {
    return 2;
  }

  protected int getTotalItemCount()
  {
    int k = 0;
    if ((this.b == null) || (this.b.size() == 0))
      return 0;
    int m = this.b.size() / getLineItemCount();
    if (this.b.size() % getLineItemCount() == 0);
    while (true)
    {
      return k + m;
      k = 1;
    }
  }

  public void onClick(View paramView)
  {
    paramView = (agr)paramView.getTag();
    if (paramView == null)
      return;
    yb.p();
    paramView.a.a(getContext());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agm
 * JD-Core Version:    0.6.2
 */