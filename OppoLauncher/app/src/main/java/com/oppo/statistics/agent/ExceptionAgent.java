package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.ExceptionBean;
import com.oppo.statistics.record.RecordHandler;

public class ExceptionAgent
{
  public static void recordException(Context paramContext, ExceptionBean paramExceptionBean)
  {
    RecordHandler.addTask(paramContext, paramExceptionBean);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.ExceptionAgent
 * JD-Core Version:    0.6.2
 */