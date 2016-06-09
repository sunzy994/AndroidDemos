package cmcm.com.myapplication;

import android.content.Context;
import com.lazyswipe.features.leap.card.AdCard;
import com.lazyswipe.features.leap.card.ThemeCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adv
{
  private static final String a = "Swipe." + adv.class.getSimpleName();
  private static adv b;
  private boolean c;

  public adv()
  {
    if (ari.c(0, 2) == 0)
      bool = true;
    this.c = bool;
  }

  public static adv a()
  {
    try
    {
      if (b == null)
        b = new adv();
      return b;
    }
    finally
    {
    }
  }

  private static void a(List<Object> paramList, Object paramObject)
  {
    if (paramObject != null)
      paramList.add(paramObject);
  }

  public static boolean a(List<Object> paramList)
  {
    if (asq.a(paramList));
    do
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
    while (!(paramList.next() instanceof aee));
    return true;
  }

  private List<Object> b(Context paramContext, int paramInt)
  {
    boolean bool = true;
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
    {
      if (arl.g(paramContext))
      {
        a(localArrayList, d(paramContext));
        if (abd.a())
        {
          localObject = c(paramContext);
          a(localArrayList, localObject);
          a(localArrayList, d(paramContext));
          a(localArrayList, d(paramContext));
          if (!adx.h())
            break label96;
        }
        label96: for (paramContext = Integer.valueOf(8); ; paramContext = d(paramContext))
        {
          a(localArrayList, paramContext);
          return localArrayList;
          localObject = d(paramContext);
          break;
        }
      }
      a(localArrayList, d(paramContext));
      if (adx.h());
      for (localObject = Integer.valueOf(8); ; localObject = d(paramContext))
      {
        a(localArrayList, localObject);
        a(localArrayList, d(paramContext));
        a(localArrayList, d(paramContext));
        a(localArrayList, d(paramContext));
        return localArrayList;
      }
    }
    if (paramInt % 2 == 1)
    {
      if (!this.c);
      while (true)
      {
        this.c = bool;
        a(localArrayList, d(paramContext));
        a(localArrayList, d(paramContext));
        if (abd.a())
          break;
        localObject = d(paramContext);
        a(localArrayList, localObject);
        a(localArrayList, d(paramContext));
        a(localArrayList, d(paramContext));
        return localArrayList;
        bool = false;
      }
      if (this.c);
      for (paramInt = 2; ; paramInt = 3)
      {
        localObject = Integer.valueOf(paramInt);
        break;
      }
    }
    a(localArrayList, d(paramContext));
    if (abd.a());
    for (Object localObject = c(paramContext); ; localObject = d(paramContext))
    {
      a(localArrayList, localObject);
      a(localArrayList, d(paramContext));
      a(localArrayList, d(paramContext));
      a(localArrayList, d(paramContext));
      return localArrayList;
    }
  }

  private static abt c(Context paramContext)
  {
    return AdCard.b(paramContext);
  }

  private static aee d(Context paramContext)
  {
    return aed.a(paramContext).b(paramContext);
  }

  public List<Object> a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt);
  }

  public void a(Context paramContext)
  {
    aed.a(paramContext).a();
    aed.a(paramContext).c(paramContext);
    ThemeCard.h();
  }

  public List<Object> b(Context paramContext)
  {
    return a(paramContext, 0);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adv
 * JD-Core Version:    0.6.2
 */