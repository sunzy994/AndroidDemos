package cmcm.com.myapplication;

import java.io.Serializable;

public class jz
  implements Serializable
{
  private int a;
  private int b;
  private int c;

  public int a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public int b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }

  public int c()
  {
    return this.c;
  }

  public void c(int paramInt)
  {
    this.c = paramInt;
  }

  public String toString()
  {
    return "EventCollectRuleData [start = " + this.a + ", end = " + this.b + ", type = " + this.c + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jz
 * JD-Core Version:    0.6.2
 */