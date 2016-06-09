package cmcm.com.myapplication;

import java.util.TimerTask;

class ug extends TimerTask
{
  public ug(ue paramue)
  {
  }

  public void run()
  {
    long l = System.currentTimeMillis() - ue.e();
    if (500L + l >= 600000L)
    {
      ue.f().e = 0L;
      ue.a(this.a).cancel();
      this.a.a(3);
      return;
    }
    ue.f().f = ue.b(this.a);
    ue.f().e = (600000L - l);
    ue.a(this.a, ue.f());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ug
 * JD-Core Version:    0.6.2
 */