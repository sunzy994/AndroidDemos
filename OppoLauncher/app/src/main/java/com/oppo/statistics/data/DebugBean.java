package com.oppo.statistics.data;

public class DebugBean
  implements StatisticBean
{
  private boolean mFlag = false;

  public DebugBean(boolean paramBoolean)
  {
    this.mFlag = paramBoolean;
  }

  public int getDataType()
  {
    return 12;
  }

  public boolean getFlag()
  {
    return this.mFlag;
  }

  public void setFlag(boolean paramBoolean)
  {
    this.mFlag = paramBoolean;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type is :");
    localStringBuilder.append(getDataType());
    localStringBuilder.append("\n");
    localStringBuilder.append("flag is :");
    localStringBuilder.append(getFlag());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.data.DebugBean
 * JD-Core Version:    0.6.2
 */