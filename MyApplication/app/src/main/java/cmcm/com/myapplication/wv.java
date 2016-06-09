package cmcm.com.myapplication;

import android.app.usage.UsageStats;
import java.util.Comparator;

public class wv
  implements Comparator<UsageStats>
{
  public final int a(UsageStats paramUsageStats1, UsageStats paramUsageStats2)
  {
    return (int)(paramUsageStats2.getLastTimeUsed() - paramUsageStats1.getLastTimeUsed());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wv
 * JD-Core Version:    0.6.2
 */