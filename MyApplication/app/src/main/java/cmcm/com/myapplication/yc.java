package cmcm.com.myapplication;

public class yc
{
  public boolean a;
  public boolean b;
  public int c;
  public int d;
  String e;
  String f;
  public String g;
  public int h = -1;
  public int i = -1;
  public int j;
  public boolean k;
  public boolean l;
  public boolean m;
  public int n;

  public yc()
  {
    a();
  }

  public yc a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a();
    this.b = paramBoolean;
    this.c = paramInt1;
    this.d = paramInt2;
    return this;
  }

  public yc a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
    return this;
  }

  public yc a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean2)
  {
    a(paramBoolean1, paramInt1, paramInt2);
    this.h = paramInt3;
    this.i = paramInt4;
    this.j = paramInt5;
    this.a = paramBoolean2;
    return this;
  }

  public yc a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a();
    this.l = paramBoolean2;
    this.b = paramBoolean1;
    this.a = paramBoolean3;
    this.c = 99;
    this.d = -1;
    return this;
  }

  public void a()
  {
    this.b = false;
    this.c = 99;
    this.d = 0;
    this.f = null;
    this.e = null;
    this.g = null;
    this.i = -1;
    this.h = -1;
    this.j = 0;
    this.l = false;
    this.m = false;
    this.n = 0;
  }

  public String toString()
  {
    return "FanOpenParams:{left=" + this.b + ",tab=" + this.g + ",toucher=" + this.c + ",degree=" + this.d + ",x=" + this.h + ",y=" + this.i + ",index=" + this.j + ",isClick=" + this.a + ",byHandTrack=" + this.k + ",suppressNotifications=" + this.l + ",component=" + this.e + "/" + this.f + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yc
 * JD-Core Version:    0.6.2
 */