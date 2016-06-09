package com.oppo.mic;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class MicroPhone
{
  private static final boolean DEBUG = false;
  private static final int MAX_FILESIZE_BYTES = 900000;
  protected static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;
  private static final float MIC_DB_MAX = 100.0F;
  private static final String TAG = "MicroPhoneTools";
  private static MicroPhone microPhoneInstance = null;
  private boolean huffFlag;
  private MediaRecorder mMediaRecorder;
  private OnInfoListener mOnInfoListener = new OnInfoListener()
  {
    public void onInfo(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      switch (paramAnonymousInt1)
      {
      default:
        return;
      case 801:
      }
      MicroPhone.this.closeMic();
      MicroPhone.this.openMic();
    }
  };
  private float noiseData;

  public static MicroPhone getInstance()
  {
    try
    {
      if (microPhoneInstance == null)
        microPhoneInstance = new MicroPhone();
      MicroPhone localMicroPhone = microPhoneInstance;
      return localMicroPhone;
    }
    finally
    {
    }
  }

  private void setupMediaRecorder()
  {
    if (this.mMediaRecorder == null)
    {
      this.mMediaRecorder = new MediaRecorder();
      this.mMediaRecorder.setOnInfoListener(this.mOnInfoListener);
    }
    if (this.mMediaRecorder == null)
    {
      Log.e("MicroPhoneTools", "CAN NOT new a MediaRecorder instance, please check the permission!!");
      return;
    }
    try
    {
      this.mMediaRecorder.setAudioSource(1);
      this.mMediaRecorder.setOutputFormat(1);
      this.mMediaRecorder.setAudioEncoder(1);
      String str = Environment.getExternalStorageDirectory().toString() + "/test.amr";
      this.mMediaRecorder.setOutputFile(str);
      this.mMediaRecorder.setMaxFileSize(900000L);
      try
      {
        this.mMediaRecorder.prepare();
        return;
      }
      catch (Exception localException1)
      {
        Log.e("MicroPhoneTools", "Could not prepare MediaRecorder: " + localException1.toString());
        this.mMediaRecorder.release();
        this.mMediaRecorder = null;
        return;
      }
    }
    catch (Exception localException2)
    {
      while (true)
      {
        Log.e("MicroPhoneTools", "setAudioSource failed");
        Log.e("MicroPhoneTools", "setupMediaRecorder --- e = " + localException2);
      }
    }
  }

  private void startMediaRecorder()
  {
    if (this.mMediaRecorder != null);
    try
    {
      this.mMediaRecorder.start();
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroPhoneTools", "Could start MediaRecorder: " + localException.toString());
      this.mMediaRecorder.release();
      this.mMediaRecorder = null;
    }
  }

  private void stopMediaRecorder()
  {
    if (this.mMediaRecorder != null)
    {
      this.mMediaRecorder.stop();
      this.mMediaRecorder.release();
      this.mMediaRecorder = null;
    }
  }

  public void closeMic()
  {
    stopMediaRecorder();
  }

  public boolean detectHuff()
  {
    detectNoiseData();
    return this.huffFlag;
  }

  public void detectNoiseData()
  {
    int i = 0;
    if (this.mMediaRecorder != null)
    {
      i = this.mMediaRecorder.getMaxAmplitude();
      this.noiseData = i;
    }
    if (10.0F * (float)Math.log(i) >= 100.0F)
    {
      this.huffFlag = true;
      return;
    }
    this.huffFlag = false;
  }

  public float getNoiseData()
  {
    detectNoiseData();
    return this.noiseData;
  }

  public void openMic()
  {
    setupMediaRecorder();
    startMediaRecorder();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.mic.MicroPhone
 * JD-Core Version:    0.6.2
 */