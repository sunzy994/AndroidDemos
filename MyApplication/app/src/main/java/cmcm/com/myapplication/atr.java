package cmcm.com.myapplication;

import android.graphics.Bitmap;

public abstract class atr
{
  private String a = null;
  private boolean b = true;
  public Bitmap e;
  protected int f;
  protected int g;

  public static String a(String paramString)
  {
    return arh.a(paramString);
  }

  public abstract String a();

  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public void b()
  {
  }

  public String c()
  {
    return null;
  }

  public String d()
  {
    if ((this.a == null) || (this.a.equals("")))
      this.a = a(a());
    return this.a;
  }

  public ats e()
  {
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atr
 * JD-Core Version:    0.6.2
 */