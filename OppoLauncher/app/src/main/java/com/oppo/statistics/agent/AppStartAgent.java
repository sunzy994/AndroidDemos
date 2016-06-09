package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.AppStartBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.util.LogUtil;
import com.oppo.statistics.util.TimeInfoUtil;

public class AppStartAgent
{
  public static void recordAppStart(Context paramContext)
  {
    LogUtil.i("NearMeStatistics", "调用AppStart");
    RecordHandler.addTask(paramContext, new AppStartBean(TimeInfoUtil.getFormatTime()));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.AppStartAgent
 * JD-Core Version:    0.6.2
 */