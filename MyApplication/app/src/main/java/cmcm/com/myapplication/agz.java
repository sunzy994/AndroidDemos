package cmcm.com.myapplication;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class agz extends agm
{
  private ArrayList<agr> i = null;

  public agz(Context paramContext, String paramString, xq paramxq)
  {
    super(paramContext, paramString, paramxq);
  }

  private List<agr> getCachedResult()
  {
    if (this.i != null)
      return this.i;
    this.i = new ArrayList();
    Object localObject = SwipeApplication.c().a();
    int j;
    if (!((wm)localObject).b)
      j = 0;
    while (true)
    {
      if ((j >= 60) || (((wm)localObject).b))
      {
        localObject = ((wm)localObject).a();
        Collections.sort((List)localObject, wk.p);
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          wk localwk = (wk)((Iterator)localObject).next();
          this.i.add(new agr(localwk, localwk.b));
        }
      }
      try
      {
        Thread.sleep(500L);
        label117: j += 1;
        continue;
        return this.i;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label117;
      }
    }
  }

  protected List<agr> a(String paramString, agk paramagk)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString))
      return localArrayList;
    List localList = getCachedResult();
    if (TextUtils.isEmpty(paramString))
      return localList;
    paramString = paramString.toLowerCase();
    int k = getLineItemCount();
    int m = localList.size();
    int j = 0;
    while ((j < m) && (!paramagk.a()) && (localArrayList.size() < k))
    {
      agr localagr = (agr)localList.get(j);
      int n = localagr.b().indexOf(paramString);
      if (n >= 0)
      {
        String str = localagr.a.b.toString();
        localArrayList.add(new agr(localagr.a, Html.fromHtml(str.substring(0, n) + "<font color=\"#24CFEA\">" + str.substring(n, paramString.length() + n) + "</font>" + str.substring(n + paramString.length()))));
      }
      j += 1;
    }
    return localArrayList;
  }

  public void onClick(View paramView)
  {
    super.onClick(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agz
 * JD-Core Version:    0.6.2
 */