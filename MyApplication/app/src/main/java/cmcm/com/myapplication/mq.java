package cmcm.com.myapplication;

public abstract class mq
{
  public abstract void a(int paramInt, Object paramObject);

  public abstract void a(int paramInt, String paramString);

  public void a(Exception paramException)
  {
    a(-1, paramException.getMessage());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mq
 * JD-Core Version:    0.6.2
 */