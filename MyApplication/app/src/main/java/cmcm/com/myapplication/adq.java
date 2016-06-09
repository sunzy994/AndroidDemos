package cmcm.com.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lazyswipe.features.leap.card.AdCard;
import com.lazyswipe.features.leap.card.CardFlow;
import com.lazyswipe.features.leap.card.LoadMoreCard;
import com.lazyswipe.features.leap.card.NewsCard;
import com.lazyswipe.features.leap.card.ThemeCard;
import java.util.List;

public class adq extends ayp<adt>
{
  private adq(CardFlow paramCardFlow)
  {
  }

  public int a()
  {
    return CardFlow.b(this.a).size();
  }

  public int a(int paramInt)
  {
    Object localObject = CardFlow.b(this.a).get(paramInt);
    if ((localObject instanceof aee))
      return 0;
    if ((localObject instanceof abt))
      return 1;
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    return 5;
  }

  public adt a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a.getContext();
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup);
    if (paramInt == 0)
      paramViewGroup = (NewsCard)localLayoutInflater.inflate(2130968600, null, false);
    while (true)
    {
      paramViewGroup.d = this.a;
      return paramViewGroup.getCardHolder();
      if (paramInt == 2)
        paramViewGroup = new aeh(paramViewGroup);
      else if (paramInt == 3)
        paramViewGroup = new adw(paramViewGroup);
      else if (paramInt == 4)
        paramViewGroup = (ThemeCard)localLayoutInflater.inflate(2130968603, null, false);
      else if (paramInt == 8)
        paramViewGroup = new adx(paramViewGroup);
      else if (paramInt == 5)
        paramViewGroup = new aef(paramViewGroup);
      else if (paramInt == 6)
        paramViewGroup = (LoadMoreCard)localLayoutInflater.inflate(2130968599, null, false);
      else if (paramInt == 7)
        paramViewGroup = new aeb(paramViewGroup);
      else if (paramInt == 1)
        paramViewGroup = AdCard.a(paramViewGroup);
      else
        paramViewGroup = new aef(paramViewGroup);
    }
  }

  public void a(adt paramadt, int paramInt)
  {
    paramadt.a(CardFlow.b(this.a).get(paramInt));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adq
 * JD-Core Version:    0.6.2
 */