package com.oppo.statistics.data;

public class CommonBean
  implements StatisticBean
{
  private String logMap = "";
  private String logTag = "";
  private boolean uploadNow = false;

  public CommonBean(String paramString1, String paramString2)
  {
    this.logTag = paramString1;
    this.logMap = paramString2;
  }

  public CommonBean(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.logTag = paramString1;
    this.logMap = paramString2;
    this.uploadNow = paramBoolean;
  }

  public int getDataType()
  {
    return 9;
  }

  public String getLogMap()
  {
    return this.logMap;
  }

  public String getLogTag()
  {
    return this.logTag;
  }

  public boolean getUploadNow()
  {
    return this.uploadNow;
  }

  public void setLogMap(String paramString)
  {
    this.logMap = paramString;
  }

  public void setLogTag(String paramString)
  {
    this.logTag = paramString;
  }

  public void setUploadNow(boolean paramBoolean)
  {
    this.uploadNow = paramBoolean;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type is :");
    localStringBuilder.append(getDataType());
    localStringBuilder.append(",");
    localStringBuilder.append("uploadNow is :");
    localStringBuilder.append(getUploadNow());
    localStringBuilder.append(",");
    localStringBuilder.append("tag is :");
    localStringBuilder.append(getLogTag());
    localStringBuilder.append(",");
    localStringBuilder.append("map is :");
    localStringBuilder.append(getLogMap());
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.CommonBean
 * JD-Core Version:    0.6.2
 */