package com.oppo.statistics.data;

public class AppLogBean
  implements StatisticBean
{
  private String mBody = "";
  private String mType = "";

  public AppLogBean(String paramString1, String paramString2)
  {
    this.mType = paramString1;
    this.mBody = paramString2;
  }

  public String getBody()
  {
    return this.mBody;
  }

  public int getDataType()
  {
    return 4;
  }

  public String getType()
  {
    return this.mType;
  }

  public void setAppLog(String paramString)
  {
    this.mBody = paramString;
  }

  public void setType(String paramString)
  {
    this.mType = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type is :");
    localStringBuilder.append(getDataType());
    localStringBuilder.append("\n");
    localStringBuilder.append("body is :");
    localStringBuilder.append(getBody());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.AppLogBean
 * JD-Core Version:    0.6.2
 */