package cmcm.com.myapplication;

public abstract class baa
  implements Runnable
{
  private Runnable a;
  private byte b;

  public void a()
  {
    a(null);
  }

  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
      this.a = paramRunnable;
    switch (this.b)
    {
    case 1:
    default:
      return;
    case 0:
      this.b = 1;
      run();
      return;
    case 2:
    }
    c();
  }

  public void b()
  {
    this.b = 0;
  }

  public void b(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }

  public void c()
  {
    if (this.a != null)
      this.a.run();
    this.b = 2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     baa
 * JD-Core Version:    0.6.2
 */