package cmcm.com.myapplication;

public class aya
{
  public int a;
  public int b;
  public int c;

  aya(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  String a()
  {
    switch (this.a)
    {
    default:
      return "??";
    case 0:
      return "add";
    case 1:
      return "rm";
    case 2:
      return "up";
    case 3:
    }
    return "mv";
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        paramObject = (aya)paramObject;
        if (this.a != paramObject.a)
          return false;
      }
      while ((this.a == 3) && (Math.abs(this.c - this.b) == 1) && (this.c == paramObject.b) && (this.b == paramObject.c));
      if (this.c != paramObject.c)
        return false;
    }
    while (this.b == paramObject.b);
    return false;
  }

  public int hashCode()
  {
    return (this.a * 31 + this.b) * 31 + this.c;
  }

  public String toString()
  {
    return "[" + a() + ",s:" + this.b + "c:" + this.c + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aya
 * JD-Core Version:    0.6.2
 */