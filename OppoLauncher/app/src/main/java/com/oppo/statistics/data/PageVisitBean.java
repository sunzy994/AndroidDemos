package com.oppo.statistics.data;

public class PageVisitBean
  implements StatisticBean
{
  private String mActivities;
  private long mDuration;
  private String mTime;

  public String getActivities()
  {
    return this.mActivities;
  }

  public int getDataType()
  {
    return 3;
  }

  public long getDuration()
  {
    return this.mDuration;
  }

  public String getTime()
  {
    return this.mTime;
  }

  public void setActivities(String paramString)
  {
    this.mActivities = paramString;
  }

  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }

  public void setTime(String paramString)
  {
    this.mTime = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time is :");
    localStringBuilder.append(getTime());
    localStringBuilder.append("\n");
    localStringBuilder.append("duration is :");
    localStringBuilder.append(getDuration());
    localStringBuilder.append("\n");
    localStringBuilder.append("activities is :");
    localStringBuilder.append(getActivities());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.PageVisitBean
 * JD-Core Version:    0.6.2
 */