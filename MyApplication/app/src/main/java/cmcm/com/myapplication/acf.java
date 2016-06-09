package cmcm.com.myapplication;

import android.content.Context;
import java.util.Arrays;
import java.util.List;

public class acf
{
  private acg a;
  private String[] b;
  private List<ach>[] c;
  private int[] d;
  private int e;
  private int f;

  public acf(Context paramContext, acg paramacg)
  {
    this.a = paramacg;
    a();
  }

  private void a(String[] paramArrayOfString, List<ach>[] paramArrayOfList)
  {
    this.b = paramArrayOfString;
    this.c = paramArrayOfList;
    this.d = new int[paramArrayOfList.length];
    int i = 0;
    int j = 0;
    if (i < paramArrayOfList.length)
    {
      label46: int m;
      if (this.b[i] == null)
      {
        this.b[i] = " ";
        this.d[i] = j;
        m = paramArrayOfList[i].size() / this.f;
        if (paramArrayOfList[i].size() % this.f != 0)
          break label123;
      }
      label123: for (int k = 0; ; k = 1)
      {
        j += k + m;
        i += 1;
        break;
        this.b[i] = this.b[i].trim();
        break label46;
      }
    }
    this.e = j;
  }

  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.b.length))
      return -1;
    return this.d[paramInt];
  }

  public void a()
  {
    this.f = 4;
    this.a.a();
    a(this.a.b(), this.a.c());
  }

  public ach[] a(int paramInt1, int paramInt2)
  {
    ach[] arrayOfach = new ach[this.f];
    if ((paramInt1 < 0) || (paramInt1 >= this.b.length))
      return arrayOfach;
    List localList = this.c[paramInt1];
    paramInt1 = 0;
    while (paramInt1 < this.f)
    {
      int i = this.f * paramInt2 + paramInt1;
      if ((i >= 0) && (i < localList.size()))
        arrayOfach[paramInt1] = ((ach)localList.get(i));
      paramInt1 += 1;
    }
    return arrayOfach;
  }

  public int b(int paramInt)
  {
    int k;
    if ((paramInt < 0) || (paramInt >= this.e))
    {
      k = -1;
      return k;
    }
    int j = Arrays.binarySearch(this.d, paramInt);
    if (j >= 0)
    {
      int i = j + 1;
      while (true)
      {
        k = j;
        if (i >= this.d.length)
          break;
        if (this.d[i] == paramInt)
          j = i;
        i += 1;
      }
    }
    return -j - 2;
  }

  public String[] b()
  {
    return this.b;
  }

  public List<ach>[] c()
  {
    return this.c;
  }

  public int[] d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acf
 * JD-Core Version:    0.6.2
 */