package com.oppo.launcher;

import android.os.Handler;

public class Alarm
  implements Runnable
{
  static final boolean DEBUG = false;
  private static final String TAG = "Alarm";
  private OnAlarmListener mAlarmListener;
  private boolean mAlarmPending = false;
  private long mAlarmTriggerTime;
  private Handler mHandler = new Handler();
  private boolean mWaitingForCallback;

  public boolean alarmPending()
  {
    return this.mAlarmPending;
  }

  public void cancelAlarm()
  {
    this.mAlarmTriggerTime = 0L;
    this.mAlarmPending = false;
  }

  public void run()
  {
    this.mWaitingForCallback = false;
    if (this.mAlarmTriggerTime != 0L)
    {
      long l = System.currentTimeMillis();
      if (this.mAlarmTriggerTime <= l)
        break label52;
      this.mHandler.postDelayed(this, Math.max(0L, this.mAlarmTriggerTime - l));
      this.mWaitingForCallback = true;
    }
    label52: 
    do
    {
      return;
      this.mAlarmPending = false;
    }
    while (this.mAlarmListener == null);
    this.mAlarmListener.onAlarm(this);
  }

  public void setAlarm(long paramLong)
  {
    long l = System.currentTimeMillis();
    this.mAlarmPending = true;
    this.mAlarmTriggerTime = (l + paramLong);
    if (!this.mWaitingForCallback)
    {
      this.mHandler.postDelayed(this, this.mAlarmTriggerTime - l);
      this.mWaitingForCallback = true;
    }
  }

  public void setOnAlarmListener(OnAlarmListener paramOnAlarmListener)
  {
    this.mAlarmListener = paramOnAlarmListener;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.Alarm
 * JD-Core Version:    0.6.2
 */