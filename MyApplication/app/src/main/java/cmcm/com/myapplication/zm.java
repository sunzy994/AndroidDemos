package cmcm.com.myapplication;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;

public class zm
  implements Serializable, Comparator<zl>
{
  public int a(zl paramzl1, zl paramzl2)
  {
    if ((zl.b(paramzl1) == '*') && (zl.b(paramzl2) != '*'));
    do
    {
      do
      {
        return -1;
        if ((zl.b(paramzl1) != '*') && (zl.b(paramzl2) == '*'))
          return 1;
        if ((zl.b(paramzl1) == '#') && (zl.b(paramzl2) != '#'))
          return 1;
      }
      while ((zl.b(paramzl1) != '#') && (zl.b(paramzl2) == '#'));
      if (zl.b(paramzl1) == zl.b(paramzl2))
        break;
    }
    while (zl.b(paramzl1) < zl.b(paramzl2));
    return 1;
    return asq.a.compare(zl.f(paramzl1), zl.f(paramzl2));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zm
 * JD-Core Version:    0.6.2
 */