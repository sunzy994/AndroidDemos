package cmcm.com.myapplication;

import android.content.ComponentName;
import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;

public final class apl
  implements Serializable, Comparator<wk>
{
  private final List<String> a;

  public apl(List<String> paramList)
  {
    this.a = paramList;
  }

  public int a(wk paramwk1, wk paramwk2)
  {
    boolean bool = this.a.contains(paramwk1.i.getPackageName());
    if (bool == this.a.contains(paramwk2.i.getPackageName()))
      return asq.a.compare(paramwk1.b, paramwk2.b);
    if (bool)
      return -1;
    return 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apl
 * JD-Core Version:    0.6.2
 */