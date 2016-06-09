package com.oppo.statistics.data;

public class AppStartBean
  implements StatisticBean
{
  private String mTime = "0";

  public AppStartBean(String paramString)
  {
    this.mTime = paramString;
  }

  public int getDataType()
  {
    return 1;
  }

  public String getTime()
  {
    return this.mTime;
  }

  public void setTime(String paramString)
  {
    this.mTime = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginTime is :");
    localStringBuilder.append(getTime());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.AppStartBean
 * JD-Core Version:    0.6.2
 */