package cmcm.com.myapplication;

import android.content.Context;

public class kz
{
  private la a;

  public kz(Context paramContext)
  {
    this.a = new la(paramContext, "qiigameAgent@v2");
  }

  public void a()
  {
    if (this.a != null)
      this.a.a();
    this.a = null;
  }

  public void a(long paramLong)
  {
    this.a.a(400, paramLong);
  }

  public void a(boolean paramBoolean)
  {
    this.a.a(501, paramBoolean);
  }

  public long b()
  {
    return this.a.b(400, 0L);
  }

  public void b(long paramLong)
  {
    this.a.a(403, paramLong);
  }

  public void b(boolean paramBoolean)
  {
    this.a.a(600, paramBoolean);
  }

  public long c()
  {
    return this.a.b(403, 0L);
  }

  public void c(long paramLong)
  {
    this.a.a(401, paramLong);
  }

  public long d()
  {
    return this.a.b(401, 0L);
  }

  public boolean e()
  {
    return this.a.b(501, false);
  }

  public void f()
  {
    String str1 = 404 + String.valueOf(ky.e());
    String str2 = this.a.b(503, "");
    if (!str2.equals(str1))
    {
      this.a.b(str2);
      this.a.a(503, str1);
    }
    this.a.a(str1, true);
  }

  public boolean g()
  {
    String str = 404 + String.valueOf(ky.e());
    return this.a.b(str, false);
  }

  public int h()
  {
    String str = 406 + kv.a().g();
    return this.a.b(str, 0);
  }

  public void i()
  {
    String str1 = 407 + kv.a().g();
    String str2 = this.a.b(506, "");
    if (!str2.equals(str1))
    {
      this.a.b(str2);
      this.a.a(506, str1);
    }
    this.a.a(str1, h() + 1);
  }

  public int j()
  {
    String str = 407 + kv.a().g();
    return this.a.b(str, 0);
  }

  public boolean k()
  {
    return this.a.b(600, false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kz
 * JD-Core Version:    0.6.2
 */