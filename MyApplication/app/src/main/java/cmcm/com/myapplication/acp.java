package cmcm.com.myapplication;

public class acp extends acv
{
  private static acp c;

  public static acp h()
  {
    if (c == null)
      c = new acp();
    return c;
  }

  protected int a()
  {
    return 4;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acp
 * JD-Core Version:    0.6.2
 */