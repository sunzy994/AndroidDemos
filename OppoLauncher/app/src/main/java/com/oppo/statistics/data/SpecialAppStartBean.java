package com.oppo.statistics.data;

public class SpecialAppStartBean
  implements StatisticBean
{
  private int mAppId = 0;
  private String mSsoid = "0";
  private String mTime = "0";

  public SpecialAppStartBean(String paramString1, String paramString2, int paramInt)
  {
    this.mSsoid = paramString1;
    this.mTime = paramString2;
    this.mAppId = paramInt;
  }

  public int getAppId()
  {
    return this.mAppId;
  }

  public int getDataType()
  {
    return 7;
  }

  public String getSsoid()
  {
    return this.mSsoid;
  }

  public String getTime()
  {
    return this.mTime;
  }

  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
  }

  public void setSsoid(String paramString)
  {
    this.mSsoid = paramString;
  }

  public void setTime(String paramString)
  {
    this.mTime = paramString;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.SpecialAppStartBean
 * JD-Core Version:    0.6.2
 */