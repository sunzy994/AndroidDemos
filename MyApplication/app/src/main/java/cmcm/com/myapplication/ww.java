package cmcm.com.myapplication;

import android.app.usage.UsageStats;
import java.util.Comparator;

public class ww
  implements Comparator<UsageStats>
{
  public int a(UsageStats paramUsageStats1, UsageStats paramUsageStats2)
  {
    if (wu.a() != null)
      return (int)(wu.a(paramUsageStats2) - wu.a(paramUsageStats1));
    return (int)(paramUsageStats2.getTotalTimeInForeground() - paramUsageStats1.getTotalTimeInForeground());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ww
 * JD-Core Version:    0.6.2
 */