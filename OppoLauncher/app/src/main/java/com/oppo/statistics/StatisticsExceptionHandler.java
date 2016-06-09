package com.oppo.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.statistics.agent.ExceptionAgent;
import com.oppo.statistics.data.ExceptionBean;
import com.oppo.statistics.util.LogUtil;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StatisticsExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Context mContext;
  private Thread.UncaughtExceptionHandler mHandler;

  public StatisticsExceptionHandler(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = Thread.getDefaultUncaughtExceptionHandler();
  }

  private String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    try
    {
      paramThrowable.printStackTrace(localPrintWriter);
      paramThrowable = localStringWriter.toString();
      return paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      LogUtil.e("NearMeStatistics", paramThrowable);
      return null;
    }
    finally
    {
      localPrintWriter.close();
    }
    throw paramThrowable;
  }

  public void setStatisticsExceptionHandler()
  {
    if (this == this.mHandler)
      return;
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    LogUtil.d("NearMeStatistics", "StatisticsExceptionHandler: get the uncaughtException.");
    String str = getStackTrace(paramThrowable);
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(str))
    {
      ExceptionBean localExceptionBean = new ExceptionBean();
      localExceptionBean.setCount(1);
      localExceptionBean.setEventTime(l);
      localExceptionBean.setException(str);
      ExceptionAgent.recordException(this.mContext, localExceptionBean);
    }
    if (this.mHandler != null)
      this.mHandler.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.StatisticsExceptionHandler
 * JD-Core Version:    0.6.2
 */