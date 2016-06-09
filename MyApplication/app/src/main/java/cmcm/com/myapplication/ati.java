package cmcm.com.myapplication;

public class ati extends Exception
{
  private final int a;
  private final Throwable b;

  public ati(int paramInt, Throwable paramThrowable)
  {
    this.a = paramInt;
    this.b = paramThrowable;
  }

  public int a()
  {
    return this.a;
  }

  public Throwable b()
  {
    return this.b;
  }

  public boolean c()
  {
    return (this.a == 1) || (this.a == 5) || (this.a == 6) || (this.a == 7);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ati
 * JD-Core Version:    0.6.2
 */