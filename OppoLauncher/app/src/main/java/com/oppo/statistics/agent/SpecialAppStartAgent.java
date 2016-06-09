package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.SpecialAppStartBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.util.AccountUtil;
import com.oppo.statistics.util.TimeInfoUtil;

public class SpecialAppStartAgent
{
  public static void onSpecialAppStart(Context paramContext, int paramInt)
  {
    String str = TimeInfoUtil.getFormatTime();
    RecordHandler.addTask(paramContext, new SpecialAppStartBean(AccountUtil.getSsoId(paramContext), str, paramInt));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.SpecialAppStartAgent
 * JD-Core Version:    0.6.2
 */