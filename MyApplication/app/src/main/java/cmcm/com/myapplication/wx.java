package cmcm.com.myapplication;

import android.app.usage.UsageStats;
import java.util.Comparator;
import java.util.Map;

public class wx
  implements Comparator<String>
{
  private final Comparator<UsageStats> a;
  private final Map<String, UsageStats> b;

  public wx(Map<String, UsageStats> paramMap, Comparator<UsageStats> paramComparator)
  {
    this.a = paramComparator;
    this.b = paramMap;
  }

  public int a(String paramString1, String paramString2)
  {
    return this.a.compare(this.b.get(paramString1), this.b.get(paramString2));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wx
 * JD-Core Version:    0.6.2
 */