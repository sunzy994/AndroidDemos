package cmcm.com.myapplication;

import android.widget.Scroller;

class azw
  implements Runnable
{
  private int b;
  private Scroller c;
  private boolean d = false;
  private int e;
  private int f;

  public azw(azu paramazu)
  {
    this.c = new Scroller(paramazu.getContext());
  }

  private void b()
  {
    if (azu.a)
      bah.a(this.a.b, "finish, currentPos:%s", new Object[]{Integer.valueOf(azu.b(this.a).k())});
    c();
    this.a.b();
  }

  private void c()
  {
    this.d = false;
    this.b = 0;
    this.a.removeCallbacks(this);
  }

  public void a()
  {
    if (this.d)
    {
      if (!this.c.isFinished())
        this.c.forceFinished(true);
      this.a.a();
      c();
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (azu.b(this.a).e(paramInt1))
      return;
    this.e = azu.b(this.a).k();
    this.f = paramInt1;
    int i = paramInt1 - this.e;
    if (azu.a)
      bah.b(this.a.b, "tryToScrollTo: start: %s, distance:%s, to:%s", new Object[]{Integer.valueOf(this.e), Integer.valueOf(i), Integer.valueOf(paramInt1)});
    this.a.removeCallbacks(this);
    this.b = 0;
    if (!this.c.isFinished())
      this.c.forceFinished(true);
    this.c.startScroll(0, 0, 0, i, paramInt2);
    this.a.post(this);
    this.d = true;
  }

  public void run()
  {
    if ((!this.c.computeScrollOffset()) || (this.c.isFinished()));
    for (boolean bool = true; ; bool = false)
    {
      int i = this.c.getCurrY();
      int j = i - this.b;
      if ((azu.a) && (j != 0))
        bah.a(this.a.b, "scroll: %s, start: %s, to: %s, currentPos: %s, current :%s, last: %s, delta: %s", new Object[]{Boolean.valueOf(bool), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(azu.b(this.a).k()), Integer.valueOf(i), Integer.valueOf(this.b), Integer.valueOf(j)});
      if (bool)
        break;
      this.b = i;
      azu.a(this.a, j);
      this.a.post(this);
      return;
    }
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azw
 * JD-Core Version:    0.6.2
 */