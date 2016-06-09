package cmcm.com.myapplication;

import java.io.FileOutputStream;
import java.io.OutputStream;

public final class ru
{
  private final rw b;
  private boolean c;

  private ru(rt paramrt, rw paramrw)
  {
    this.b = paramrw;
  }

  public OutputStream a(int paramInt)
  {
    synchronized (this.a)
    {
      if (rw.a(this.b) != this)
        throw new IllegalStateException();
    }
    rv localrv = new rv(this, new FileOutputStream(this.b.b(paramInt)), null);
    return localrv;
  }

  public void a()
  {
    if (this.c)
    {
      rt.a(this.a, this, false);
      this.a.c(rw.c(this.b));
      return;
    }
    rt.a(this.a, this, true);
  }

  public void b()
  {
    rt.a(this.a, this, false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ru
 * JD-Core Version:    0.6.2
 */