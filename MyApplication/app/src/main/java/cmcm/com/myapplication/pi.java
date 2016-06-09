package cmcm.com.myapplication;

public class pi extends Exception
{
  private int a;

  public pi(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }

  public pi(String paramString)
  {
    super(paramString);
  }

  public pi(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = 1000;
  }

  public int a()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pi
 * JD-Core Version:    0.6.2
 */