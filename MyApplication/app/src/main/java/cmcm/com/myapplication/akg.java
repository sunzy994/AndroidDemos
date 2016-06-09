package cmcm.com.myapplication;

public class akg extends Exception
{
  private int a = 0;
  private String b;

  public akg(int paramInt)
  {
    this.a = paramInt;
  }

  public int a()
  {
    return this.a;
  }

  public String getMessage()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akg
 * JD-Core Version:    0.6.2
 */