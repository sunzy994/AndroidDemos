package cmcm.com.myapplication;

public class de<T>
  implements dd<T>
{
  private final Object[] a;
  private int b;

  public de(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("The max pool size must be > 0");
    this.a = new Object[paramInt];
  }

  private boolean b(T paramT)
  {
    boolean bool2 = false;
    int i = 0;
    while (true)
    {
      boolean bool1 = bool2;
      if (i < this.b)
      {
        if (this.a[i] == paramT)
          bool1 = true;
      }
      else
        return bool1;
      i += 1;
    }
  }

  public T a()
  {
    if (this.b > 0)
    {
      int i = this.b - 1;
      Object localObject = this.a[i];
      this.a[i] = null;
      this.b -= 1;
      return localObject;
    }
    return null;
  }

  public boolean a(T paramT)
  {
    if (b(paramT))
      throw new IllegalStateException("Already in the pool!");
    if (this.b < this.a.length)
    {
      this.a[this.b] = paramT;
      this.b += 1;
      return true;
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     de
 * JD-Core Version:    0.6.2
 */