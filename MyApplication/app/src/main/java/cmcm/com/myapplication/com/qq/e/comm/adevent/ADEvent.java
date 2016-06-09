package cmcm.com.myapplication.com.qq.e.comm.adevent;

public class ADEvent
{
  private final int a;
  private final Object[] b;

  public ADEvent(int paramInt)
  {
    this(paramInt, null);
  }

  public ADEvent(int paramInt, Object[] paramArrayOfObject)
  {
    this.a = paramInt;
    this.b = paramArrayOfObject;
  }

  public Object[] getParas()
  {
    if (this.b == null)
      return new Object[0];
    return this.b;
  }

  public int getType()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.adevent.ADEvent
 * JD-Core Version:    0.6.2
 */