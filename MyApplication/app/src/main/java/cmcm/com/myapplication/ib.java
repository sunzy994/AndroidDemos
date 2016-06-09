package cmcm.com.myapplication;

import android.os.Build.VERSION;

public class ib
{
  private static final ie a = new ig();
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new if();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new id();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new ic();
      return;
    }
  }

  public ib(Object paramObject)
  {
    this.b = paramObject;
  }

  public static ib a()
  {
    return new ib(a.a());
  }

  public void a(int paramInt)
  {
    a.b(this.b, paramInt);
  }

  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }

  public void b(int paramInt)
  {
    a.a(this.b, paramInt);
  }

  public void c(int paramInt)
  {
    a.c(this.b, paramInt);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        paramObject = (ib)paramObject;
        if (this.b != null)
          break;
      }
      while (paramObject.b == null);
      return false;
    }
    while (this.b.equals(paramObject.b));
    return false;
  }

  public int hashCode()
  {
    if (this.b == null)
      return 0;
    return this.b.hashCode();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ib
 * JD-Core Version:    0.6.2
 */