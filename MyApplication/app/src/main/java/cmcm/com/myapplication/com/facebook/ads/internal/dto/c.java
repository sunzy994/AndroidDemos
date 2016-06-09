package cmcm.com.myapplication.com.facebook.ads.internal.dto;

import java.util.ArrayList;
import java.util.List;

public class c
{
  private List<a> a = new ArrayList();
  private int b = 0;
  private d c;

  public c(d paramd)
  {
    this.c = paramd;
  }

  public d a()
  {
    return this.c;
  }

  public void a(a parama)
  {
    this.a.add(parama);
  }

  public int b()
  {
    return this.a.size();
  }

  public a c()
  {
    if (this.b < this.a.size())
    {
      this.b += 1;
      return (a)this.a.get(this.b - 1);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.dto.c
 * JD-Core Version:    0.6.2
 */