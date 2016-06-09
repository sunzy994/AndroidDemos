package cmcm.com.myapplication;

import java.util.Random;

public class zd
{
  private final int a;
  private final Random b;
  private final int[] c;
  private int d = 0;

  public zd(int paramInt)
  {
    this.a = paramInt;
    this.c = new int[paramInt];
    while (i < paramInt)
    {
      this.c[i] = i;
      i += 1;
    }
    this.b = new Random();
  }

  public int a()
  {
    int i = this.b.nextInt(this.a - this.d);
    int j = this.c[i];
    this.c[i] = this.c[(this.a - this.d - 1)];
    this.d += 1;
    return j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zd
 * JD-Core Version:    0.6.2
 */