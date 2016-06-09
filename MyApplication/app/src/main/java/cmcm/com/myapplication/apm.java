package cmcm.com.myapplication;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class apm
  implements Serializable, Comparator<String>
{
  private final List<String> a;
  private final Map<String, CharSequence> b;

  public apm(List<String> paramList, Map<String, CharSequence> paramMap)
  {
    this.a = paramList;
    this.b = paramMap;
  }

  public int a(String paramString1, String paramString2)
  {
    int m = 0;
    int k = 1;
    int i;
    if ((this.a != null) && (this.a.contains(paramString1)))
      i = 1;
    while (true)
    {
      int j = m;
      if (this.a != null)
      {
        j = m;
        if (this.a.contains(paramString2))
          j = 1;
      }
      if (i == j);
      try
      {
        paramString1 = (CharSequence)this.b.get(paramString1);
        paramString2 = (CharSequence)this.b.get(paramString2);
        if ((paramString1 != null) && (paramString2 != null))
          j = asq.a.compare(paramString1, paramString2);
        label127: 
        do
        {
          do
          {
            return j;
            i = 0;
            break;
            if ((paramString1 != null) || (paramString2 != null))
              break label137;
            j = k;
          }
          while (i == 0);
          return -1;
          j = k;
        }
        while (paramString1 != null);
        label137: return -1;
      }
      catch (Throwable paramString1)
      {
        break label127;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apm
 * JD-Core Version:    0.6.2
 */