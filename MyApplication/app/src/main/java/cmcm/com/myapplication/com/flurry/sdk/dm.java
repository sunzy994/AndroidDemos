package cmcm.com.myapplication.com.flurry.sdk;

import java.util.Timer;

class dm
{
  private Timer a;
  private dm.a b;
  private dm.b c;

  dm(dm.b paramb)
  {
    this.c = paramb;
  }

  public void a()
  {
    try
    {
      if (this.a != null)
      {
        this.a.cancel();
        this.a = null;
      }
      this.b = null;
      return;
    }
    finally
    {
    }
  }

  public void a(long paramLong)
  {
    try
    {
      if (b())
        a();
      this.a = new Timer("FlurrySessionTimer");
      this.b = new dm.a(this, this.c);
      this.a.schedule(this.b, paramLong);
      return;
    }
    finally
    {
    }
  }

  public boolean b()
  {
    return this.a != null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dm
 * JD-Core Version:    0.6.2
 */