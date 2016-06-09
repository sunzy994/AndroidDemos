package cmcm.com.myapplication;

import java.util.List;

class agl extends Thread
  implements agk
{
  private final String b;
  private boolean c = false;

  public agl(agj paramagj, String paramString)
  {
    this.b = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean a()
  {
    return this.c;
  }

  public void run()
  {
    List localList = this.a.a(this.b, this);
    if (!a())
      agj.a(this.a, localList);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agl
 * JD-Core Version:    0.6.2
 */