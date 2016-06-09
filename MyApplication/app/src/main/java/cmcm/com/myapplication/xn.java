package cmcm.com.myapplication;

import android.database.AbstractCursor;

public class xn extends AbstractCursor
{
  private final String[] a = { "value" };
  private final Object b;

  public xn(Object paramObject)
  {
    this.b = paramObject;
  }

  public String[] getColumnNames()
  {
    return this.a;
  }

  public int getCount()
  {
    return 1;
  }

  public double getDouble(int paramInt)
  {
    if ((this.b instanceof Double));
    for (Double localDouble = (Double)this.b; ; localDouble = null)
      return localDouble.doubleValue();
  }

  public float getFloat(int paramInt)
  {
    if ((this.b instanceof Float));
    for (Float localFloat = (Float)this.b; ; localFloat = null)
      return localFloat.floatValue();
  }

  public int getInt(int paramInt)
  {
    if ((this.b instanceof Integer));
    for (Integer localInteger = (Integer)this.b; ; localInteger = null)
      return localInteger.intValue();
  }

  public long getLong(int paramInt)
  {
    if ((this.b instanceof Long));
    for (Long localLong = (Long)this.b; ; localLong = null)
      return localLong.longValue();
  }

  public short getShort(int paramInt)
  {
    if ((this.b instanceof Short));
    for (Short localShort = (Short)this.b; ; localShort = null)
      return localShort.shortValue();
  }

  public String getString(int paramInt)
  {
    if ((this.b instanceof String))
      return (String)this.b;
    return null;
  }

  public boolean isNull(int paramInt)
  {
    return this.b == null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xn
 * JD-Core Version:    0.6.2
 */