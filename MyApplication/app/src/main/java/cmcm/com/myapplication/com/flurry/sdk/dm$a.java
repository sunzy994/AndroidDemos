package cmcm.com.myapplication.com.flurry.sdk;

import java.util.TimerTask;

class dm$a extends TimerTask
{
  private dm.b b;

  dm$a(dm paramdm, dm.b paramb)
  {
    this.b = paramb;
  }

  public void run()
  {
    this.a.a();
    if (this.b != null)
      this.b.q();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dm.a
 * JD-Core Version:    0.6.2
 */