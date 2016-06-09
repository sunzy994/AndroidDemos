package com.oppo.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class HomeKeyObserver
{
  private Context mContext;
  private HomeKeyBroadcastReceiver mHomeKeyBroadcastReceiver;
  private IntentFilter mIntentFilter;
  private OnHomeKeyListener mOnHomeKeyListener;

  public HomeKeyObserver(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public void setHomeKeyListener(OnHomeKeyListener paramOnHomeKeyListener)
  {
    this.mOnHomeKeyListener = paramOnHomeKeyListener;
  }

  public void startListen()
  {
    this.mIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.mHomeKeyBroadcastReceiver = new HomeKeyBroadcastReceiver();
    this.mContext.registerReceiver(this.mHomeKeyBroadcastReceiver, this.mIntentFilter);
  }

  public void stopListen()
  {
    if (this.mHomeKeyBroadcastReceiver != null)
      this.mContext.unregisterReceiver(this.mHomeKeyBroadcastReceiver);
  }

  class HomeKeyBroadcastReceiver extends BroadcastReceiver
  {
    final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    final String SYSTEM_DIALOG_REASON_KEY = "reason";
    final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

    HomeKeyBroadcastReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (HomeKeyObserver.this.mOnHomeKeyListener != null))
        {
          if (!paramContext.equals("homekey"))
            break label55;
          HomeKeyObserver.this.mOnHomeKeyListener.onHomeKeyPressed();
        }
      }
      label55: 
      while (!paramContext.equals("recentapps"))
        return;
      HomeKeyObserver.this.mOnHomeKeyListener.onHomeKeyLongPressed();
    }
  }

  public static abstract interface OnHomeKeyListener
  {
    public abstract void onHomeKeyLongPressed();

    public abstract void onHomeKeyPressed();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.HomeKeyObserver
 * JD-Core Version:    0.6.2
 */