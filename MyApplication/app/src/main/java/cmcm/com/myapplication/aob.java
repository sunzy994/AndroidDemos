package cmcm.com.myapplication;

public abstract class aob
  implements Runnable
{
  protected long b;

  public void a(long paramLong)
  {
    this.b = paramLong;
    run();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aob
 * JD-Core Version:    0.6.2
 */