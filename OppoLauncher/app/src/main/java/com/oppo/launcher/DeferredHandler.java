package com.oppo.launcher;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

public class DeferredHandler
{
  private static final boolean DEBUG = false;
  private final String TAG = "DeferredHandler";
  private Impl mHandler = new Impl(null);
  private LinkedList<Runnable> mQueue = new LinkedList();

  private void post(Runnable paramRunnable)
  {
    synchronized (this.mQueue)
    {
      this.mQueue.add(paramRunnable);
      int i = this.mQueue.size();
      if (i == 1)
        scheduleNextLocked();
      return;
    }
  }

  public void cancel()
  {
    synchronized (this.mQueue)
    {
      this.mQueue.clear();
      return;
    }
  }

  public void postWorkspaceRunnable(Runnable paramRunnable)
  {
    post(paramRunnable);
  }

  void scheduleNextLocked()
  {
    this.mHandler.sendEmptyMessage(1);
  }

  private class Impl extends Handler
    implements MessageQueue.IdleHandler
  {
    private Impl()
    {
    }

    public void handleMessage(Message arg1)
    {
      synchronized (DeferredHandler.this.mQueue)
      {
        if (DeferredHandler.this.mQueue.size() == 0)
          return;
        Runnable localRunnable = (Runnable)DeferredHandler.this.mQueue.removeFirst();
        localRunnable.run();
        synchronized (DeferredHandler.this.mQueue)
        {
          DeferredHandler.this.scheduleNextLocked();
          return;
        }
      }
    }

    public boolean queueIdle()
    {
      handleMessage(null);
      return false;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.DeferredHandler
 * JD-Core Version:    0.6.2
 */