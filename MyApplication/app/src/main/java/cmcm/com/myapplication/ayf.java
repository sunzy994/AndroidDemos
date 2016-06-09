package cmcm.com.myapplication;

class ayf
{
  public azl a;
  public azl b;
  public int c;
  public int d;
  public int e;
  public int f;

  private ayf(azl paramazl1, azl paramazl2)
  {
    this.a = paramazl1;
    this.b = paramazl2;
  }

  private ayf(azl paramazl1, azl paramazl2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramazl1, paramazl2);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }

  public String toString()
  {
    return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayf
 * JD-Core Version:    0.6.2
 */