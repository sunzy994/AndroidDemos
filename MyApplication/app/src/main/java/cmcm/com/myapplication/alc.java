package cmcm.com.myapplication;

public class alc extends ale
{
  private long f = -1L;

  protected void a()
  {
    super.a();
    this.f = -1L;
  }

  protected void b()
  {
    super.b();
    this.f = -1L;
  }

  public float c()
  {
    long l = d();
    if (this.f == -1L)
      this.f = l;
    float f1 = (float)(l - this.a - this.f);
    if (this.b == 0)
      return 1.0F;
    return f1 / this.b;
  }

  protected long d()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alc
 * JD-Core Version:    0.6.2
 */