package cmcm.com.myapplication;

public class alu
{
  public static final alu a = new alu(-1, null, null, null);
  public final String b;
  public final String c;
  public final int d;
  public final String e;

  public alu(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.d = paramInt;
    this.c = paramString1;
    this.e = paramString2;
    this.b = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      do
        return false;
      while (!(paramObject instanceof alu));
      paramObject = (alu)paramObject;
    }
    while ((this.d != paramObject.d) || (!asq.a(this.c, paramObject.c)) || (!asq.a(this.e, paramObject.e)) || (!asq.a(this.b, paramObject.b)));
    return true;
  }

  public int hashCode()
  {
    int k = 0;
    int m = this.d;
    int i;
    if (this.c != null)
    {
      i = this.c.hashCode();
      if (this.e == null)
        break label80;
    }
    label80: for (int j = this.e.hashCode(); ; j = 0)
    {
      if (this.b != null)
        k = this.b.hashCode();
      return (j + (i + (m + 527) * 31) * 31) * 31 + k;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "Id=" + this.d + ",tag=" + this.c + ",key=" + this.e + ",pkg=" + this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alu
 * JD-Core Version:    0.6.2
 */