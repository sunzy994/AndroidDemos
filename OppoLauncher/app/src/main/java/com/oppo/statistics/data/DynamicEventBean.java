package com.oppo.statistics.data;

public class DynamicEventBean
  implements StatisticBean
{
  private String mBody = "";
  private int mUploadMode = 0;

  public DynamicEventBean(int paramInt, String paramString)
  {
    this.mUploadMode = paramInt;
    this.mBody = paramString;
  }

  public String getBody()
  {
    return this.mBody;
  }

  public int getDataType()
  {
    return 10;
  }

  public int getUploadMode()
  {
    return this.mUploadMode;
  }

  public void setBody(String paramString)
  {
    this.mBody = paramString;
  }

  public void setUploadMode(int paramInt)
  {
    this.mUploadMode = paramInt;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadMode is :");
    localStringBuilder.append(this.mUploadMode);
    localStringBuilder.append("\n");
    localStringBuilder.append("body is :");
    localStringBuilder.append(getBody());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.DynamicEventBean
 * JD-Core Version:    0.6.2
 */