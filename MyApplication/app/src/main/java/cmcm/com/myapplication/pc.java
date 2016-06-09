package cmcm.com.myapplication;

public final class pc
{
  public static final pc c = new pc();
  public int a;
  public String b;

  static
  {
    c.a = 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (pc)paramObject;
    }
    while (this.a == paramObject.a);
    return false;
  }

  public int hashCode()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pc
 * JD-Core Version:    0.6.2
 */