package cmcm.com.myapplication.com.lazyswipe.features.search;

import ach;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import apd;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.allapps.AppsListAppIcon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vv;
import vy;
import wk;
import wm;
import xo;
import xq;
import yb;

public class SuggestionAppsHolder extends LinearLayout
  implements OnClickListener
{
  private ArrayList<ach> a = null;
  private final List<ach> b = new ArrayList();
  private Filter c;
  private String d;
  private int e;
  private xq f;
  private final AppsListAppIcon[] g = new AppsListAppIcon[5];
  private final Handler h = new Handler();

  public SuggestionAppsHolder(Context paramContext)
  {
    super(paramContext);
  }

  public SuggestionAppsHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void c()
  {
    if (this.b.isEmpty())
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    int i = 0;
    label27: if (i < this.g.length)
    {
      if (i < this.b.size())
        break label94;
      this.g[i].a(null, false);
      this.g[i].setText(null);
      this.g[i].setTag(null);
    }
    while (true)
    {
      i += 1;
      break label27;
      break;
      label94: final ach localach = (ach)this.b.get(i);
      final AppsListAppIcon localAppsListAppIcon = this.g[i];
      localAppsListAppIcon.setText(localach.b);
      localAppsListAppIcon.setTag(localach);
      if (localach.b() != null)
      {
        localAppsListAppIcon.a(localach.b(), false);
      }
      else if (this.f != null)
      {
        xo localxo = this.f.a(new xo()
        {
          public void a()
          {
            if (this.a != null)
              SuggestionAppsHolder.a(SuggestionAppsHolder.this).post(new Runnable()
              {
                public void run()
                {
                  SuggestionAppsHolder.1.this.b.a(SuggestionAppsHolder.1.this.a, false);
                  SuggestionAppsHolder.1.this.c.a(SuggestionAppsHolder.1.this.a);
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
          localAppsListAppIcon.a(localxo.a, false);
          localach.a(localxo.a);
        }
        else
        {
          localAppsListAppIcon.a(new apd(this.f.e()), true);
        }
      }
    }
  }

  public void a()
  {
    if (!this.b.isEmpty())
      setVisibility(0);
  }

  public void a(String paramString, int paramInt)
  {
    this.e = paramInt;
    if ((this.d != null) && (this.d.equals(paramString)))
      return;
    this.d = paramString;
    this.c.filter(paramString);
  }

  public void b()
  {
    setVisibility(8);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.f = xq.a(getContext());
  }

  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ach))
    {
      vv.a().a("Search", "Local", String.valueOf(this.e - 1));
      vy.a(getContext(), "CL", String.valueOf(this.e));
      paramView = (ach)paramView.getTag();
      yb.p();
      paramView.a.a(getContext());
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    xq.a(this.f);
    this.f = null;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = 0;
    while (i < this.g.length)
    {
      this.g[i] = ((AppsListAppIcon)LayoutInflater.from(getContext()).inflate(2130968733, null));
      this.g[i].setOnClickListener(this);
      LayoutParams localLayoutParams = new LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      addView(this.g[i], localLayoutParams);
      i += 1;
    }
    this.c = new Filter()
    {
      private List<ach> a()
      {
        if (SuggestionAppsHolder.d(SuggestionAppsHolder.this) != null)
          return SuggestionAppsHolder.d(SuggestionAppsHolder.this);
        SuggestionAppsHolder.a(SuggestionAppsHolder.this, new ArrayList());
        Object localObject = SwipeApplication.c().a();
        int i;
        if (!((wm)localObject).b)
          i = 0;
        while (true)
        {
          if ((i >= 60) || (((wm)localObject).b))
          {
            localObject = ((wm)localObject).a();
            Collections.sort((List)localObject, wk.p);
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              wk localwk = (wk)((Iterator)localObject).next();
              SuggestionAppsHolder.d(SuggestionAppsHolder.this).add(new ach(localwk, localwk.b, false));
            }
          }
          try
          {
            Thread.sleep(500L);
            label131: i += 1;
            continue;
            return SuggestionAppsHolder.d(SuggestionAppsHolder.this);
          }
          catch (InterruptedException localInterruptedException)
          {
            break label131;
          }
        }
      }

      private List<ach> a(String paramAnonymousString)
      {
        ArrayList localArrayList = new ArrayList();
        if (TextUtils.isEmpty(paramAnonymousString))
          return localArrayList;
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          ach localach = (ach)localIterator.next();
          int i = localach.a().indexOf(paramAnonymousString);
          if (i >= 0)
          {
            String str = localach.a.b.toString();
            localArrayList.add(new ach(localach.a, Html.fromHtml(str.substring(0, i) + "<font color=\"#24CFEA\">" + str.substring(i, paramAnonymousString.length() + i) + "</font>" + str.substring(i + paramAnonymousString.length())), false));
          }
        }
        return localArrayList;
      }

      protected FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
      {
        FilterResults localFilterResults = new FilterResults();
        if (paramAnonymousCharSequence == null);
        for (paramAnonymousCharSequence = null; ; paramAnonymousCharSequence = paramAnonymousCharSequence.toString().toLowerCase().trim())
        {
          paramAnonymousCharSequence = a(paramAnonymousCharSequence);
          localFilterResults.count = paramAnonymousCharSequence.size();
          localFilterResults.values = paramAnonymousCharSequence;
          return localFilterResults;
        }
      }

      protected void publishResults(CharSequence paramAnonymousCharSequence, FilterResults paramAnonymousFilterResults)
      {
        SuggestionAppsHolder.b(SuggestionAppsHolder.this).clear();
        SuggestionAppsHolder.b(SuggestionAppsHolder.this).addAll((List)paramAnonymousFilterResults.values);
        SuggestionAppsHolder.c(SuggestionAppsHolder.this);
      }
    };
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.search.SuggestionAppsHolder
 * JD-Core Version:    0.6.2
 */