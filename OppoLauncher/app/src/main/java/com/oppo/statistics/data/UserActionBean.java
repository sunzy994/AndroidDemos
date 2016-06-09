package com.oppo.statistics.data;

public class UserActionBean
  implements StatisticBean
{
  private int mAmount = 0;
  private int mCode = 0;
  private String mDate = "0";

  public UserActionBean(int paramInt1, String paramString, int paramInt2)
  {
    this.mCode = paramInt1;
    this.mDate = paramString;
    this.mAmount = paramInt2;
  }

  public int getActionAmount()
  {
    return this.mAmount;
  }

  public int getActionCode()
  {
    return this.mCode;
  }

  public String getActionDate()
  {
    return this.mDate;
  }

  public int getDataType()
  {
    return 2;
  }

  public void setActionAmount(int paramInt)
  {
    this.mAmount = paramInt;
  }

  public void setActionCode(int paramInt)
  {
    this.mCode = paramInt;
  }

  public void setActionDate(String paramString)
  {
    this.mDate = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action code is: ");
    localStringBuilder.append(getActionCode());
    localStringBuilder.append("\n");
    localStringBuilder.append("action amount is: ");
    localStringBuilder.append(getActionAmount());
    localStringBuilder.append("\n");
    localStringBuilder.append("action date is: ");
    localStringBuilder.append(getActionDate());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.UserActionBean
 * JD-Core Version:    0.6.2
 */