package com.oppo.statistics.data;

public class ExceptionBean
  implements StatisticBean
{
  private int mCount;
  private long mEventTime;
  private String mException;

  public int getCount()
  {
    return this.mCount;
  }

  public int getDataType()
  {
    return 5;
  }

  public long getEventTime()
  {
    return this.mEventTime;
  }

  public String getException()
  {
    return this.mException;
  }

  public void setCount(int paramInt)
  {
    this.mCount = paramInt;
  }

  public void setEventTime(long paramLong)
  {
    this.mEventTime = paramLong;
  }

  public void setException(String paramString)
  {
    this.mException = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exception is :");
    localStringBuilder.append(getException());
    localStringBuilder.append("\n");
    localStringBuilder.append("count is :");
    localStringBuilder.append(getCount());
    localStringBuilder.append("\n");
    localStringBuilder.append("time is :");
    localStringBuilder.append(getEventTime());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.ExceptionBean
 * JD-Core Version:    0.6.2
 */