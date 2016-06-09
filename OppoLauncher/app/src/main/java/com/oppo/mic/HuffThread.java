package com.oppo.mic;

import android.util.Log;

public class HuffThread extends Thread
{
  private static final boolean DEBUG = false;
  private static final String TAG = "HuffThread";
  private String control = "";
  private boolean mIsAlive = true;
  private IMicCallback mMicCallback;
  private MicroPhone mMicroPhone;

  public HuffThread()
  {
    synchronized (this.control)
    {
      this.mMicroPhone = MicroPhone.getInstance();
      this.mMicroPhone.openMic();
      return;
    }
  }

  public void exit()
  {
    this.mIsAlive = false;
  }

  public void run()
  {
    synchronized (this.control)
    {
      if (this.mIsAlive)
        runLogic();
    }
    this.mMicroPhone.closeMic();
  }

  protected void runLogic()
  {
    float f = this.mMicroPhone.getNoiseData();
    if ((f > 3000.0F) && (this.mMicCallback != null))
      this.mMicCallback.detectSound(f);
    try
    {
      Thread.sleep(35L);
      return;
    }
    catch (Exception localException)
    {
      Log.e("HuffThread", "runLogic --- e = " + localException);
    }
  }

  public void setMicCallback(IMicCallback paramIMicCallback)
  {
    this.mMicCallback = paramIMicCallback;
  }

  public static abstract interface IMicCallback
  {
    public abstract void detectSound(float paramFloat);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.mic.HuffThread
 * JD-Core Version:    0.6.2
 */