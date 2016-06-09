package cmcm.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.lazyswipe.features.search.SearchWebView;
import java.util.List;

public class ahi extends ArrayAdapter<ahk>
  implements OnClickListener
{
  private final List<ahk> a;
  private final Filter b;
  private String c;
  private final SearchWebView d;

  public ahi(Context paramContext, SearchWebView paramSearchWebView, List<ahk> paramList)
  {
    super(paramContext, 0, paramList);
    this.d = paramSearchWebView;
    this.a = paramList;
    this.b = new Filter()
    {
      protected FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
      {
        FilterResults localFilterResults = new FilterResults();
        if (paramAnonymousCharSequence == null);
        for (paramAnonymousCharSequence = null; ; paramAnonymousCharSequence = paramAnonymousCharSequence.toString().trim())
        {
          paramAnonymousCharSequence = ahe.a(ahi.this.getContext(), ahi.b(ahi.this).getSearchEngine(), paramAnonymousCharSequence);
          localFilterResults.count = paramAnonymousCharSequence.size();
          localFilterResults.values = paramAnonymousCharSequence;
          return localFilterResults;
        }
      }

      protected void publishResults(CharSequence paramAnonymousCharSequence, FilterResults paramAnonymousFilterResults)
      {
        ahi.a(ahi.this).clear();
        ahi.a(ahi.this).addAll((List)paramAnonymousFilterResults.values);
        ahi.this.notifyDataSetChanged();
      }
    };
  }

  public void a()
  {
    this.b.filter(null);
  }

  public void a(String paramString)
  {
    if ((this.c != null) && (this.c.equals(paramString)))
      return;
    this.c = paramString;
    this.b.filter(paramString);
  }

  public void b()
  {
    this.b.filter(this.c);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ahk localahk = (ahk)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
      paramViewGroup = LayoutInflater.from(getContext()).inflate(2130968739, null);
    if (!(paramViewGroup.getTag() instanceof ahj))
    {
      paramView = new ahj(this, paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    while (true)
    {
      paramView.a(localahk);
      return paramViewGroup;
      paramView = (ahj)paramViewGroup.getTag();
    }
  }

  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ahk))
    {
      paramView = (ahk)paramView.getTag();
      if (paramView.f)
      {
        ahe.b(getContext(), paramView.e());
        this.a.remove(paramView);
        notifyDataSetChanged();
      }
    }
    else
    {
      return;
    }
    this.d.a(paramView.e());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahi
 * JD-Core Version:    0.6.2
 */