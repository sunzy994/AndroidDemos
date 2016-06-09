package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.lazyswipe.features.search.SearchPopupView;
import java.util.List;

public class aha extends agj<ahk>
  implements OnClickListener
{
  public aha(Context paramContext, String paramString)
  {
    super(paramContext);
  }

  protected View a(int paramInt)
  {
    if ((this.b == null) || (this.b.size() <= paramInt))
      return null;
    ahk localahk = (ahk)this.b.get(paramInt);
    View localView = LayoutInflater.from(getContext()).inflate(2130968739, null);
    new ahb(this, localView).a(localahk);
    return localView;
  }

  protected List<ahk> a(String paramString, agk paramagk)
  {
    return ahe.a(getContext(), ahe.e(getContext()), paramString);
  }

  public void onClick(View paramView)
  {
    ahk localahk;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ahk)))
    {
      localahk = (ahk)paramView.getTag();
      if (paramView.getId() != 2131755470)
        break label81;
      if (localahk.f)
      {
        ahe.b(getContext(), localahk.e());
        this.b.remove(localahk);
        f();
      }
    }
    else
    {
      return;
    }
    this.a.a(localahk.e(), 0);
    return;
    label81: this.a.a(localahk.e(), 0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aha
 * JD-Core Version:    0.6.2
 */