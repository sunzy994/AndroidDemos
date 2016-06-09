package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.DebugBean;
import com.oppo.statistics.record.RecordHandler;

public class DebugAgent
{
  public static void setDebug(Context paramContext, boolean paramBoolean)
  {
    RecordHandler.addTask(paramContext, new DebugBean(paramBoolean));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.DebugAgent
 * JD-Core Version:    0.6.2
 */