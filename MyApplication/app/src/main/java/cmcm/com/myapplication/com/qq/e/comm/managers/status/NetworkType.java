package cmcm.com.myapplication.com.qq.e.comm.managers.status;

public enum NetworkType
{
  private int a;
  private int b;

  private NetworkType(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public final int getConnValue()
  {
    return this.a;
  }

  public final int getPermValue()
  {
    return this.b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.status.NetworkType
 * JD-Core Version:    0.6.2
 */