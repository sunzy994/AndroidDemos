package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.UserActionBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.util.TimeInfoUtil;

public class UserActionAgent
{
  public static void recordUserAction(Context paramContext, int paramInt1, int paramInt2)
  {
    RecordHandler.addTask(paramContext, new UserActionBean(paramInt1, TimeInfoUtil.getFormatHour(), paramInt2));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.UserActionAgent
 * JD-Core Version:    0.6.2
 */