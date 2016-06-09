package com.oppo.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorUtil
{
  private static final int SHAKETHRESHOLD = 200;
  private static final String TAG = "SensorUtil";
  private static SensorUtil sensorUtilInstance = null;
  private Context context;
  private ISensorCallback mSensorCallback;
  private MySensorEventListener sensorEventListener;
  private SensorManager sensorManager;
  private SensorEvent sensorUtilEvent;

  public SensorUtil(Context paramContext)
  {
    this.context = paramContext;
  }

  public static SensorUtil getInstance(Context paramContext)
  {
    try
    {
      if (sensorUtilInstance == null)
        sensorUtilInstance = new SensorUtil(paramContext);
      paramContext = sensorUtilInstance;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  private void setSensorUtilEvent(SensorEvent paramSensorEvent)
  {
    this.sensorUtilEvent = paramSensorEvent;
  }

  public void closeSensor()
  {
    this.sensorManager.unregisterListener(this.sensorEventListener);
  }

  public SensorEvent getSensorUtilEvent()
  {
    return this.sensorUtilEvent;
  }

  public void openSensor()
  {
    this.sensorManager = ((SensorManager)this.context.getSystemService("sensor"));
    Sensor localSensor = this.sensorManager.getDefaultSensor(1);
    this.sensorEventListener = new MySensorEventListener(null);
    this.sensorManager.registerListener(this.sensorEventListener, localSensor, 3);
  }

  public void setSensorCallback(ISensorCallback paramISensorCallback)
  {
    this.mSensorCallback = paramISensorCallback;
  }

  public static abstract interface ISensorCallback
  {
    public abstract void detectShake();

    public abstract void shakeTidyIcon();
  }

  private final class MySensorEventListener
    implements SensorEventListener
  {
    private static final float SHAKE_TIDY_ICON_THRESHOLD = 4.5F;
    private static final int SHAKE_TIME_INTERVAL_MAX = 680;
    private static final int SHAKE_TIME_INTERVAL_MIN = 210;
    private static final int TIDY_TIME_INTERVAL_MAX = 2000;
    long beginTime;
    float changeX;
    long lastTime;
    float lastX;

    private MySensorEventListener()
    {
    }

    private void dealAccelerometer(SensorEvent paramSensorEvent)
    {
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      if (f1 * f1 + f2 * f2 > 200.0F)
        SensorUtil.this.mSensorCallback.detectShake();
      shakeTidyIcon(f1, f2);
    }

    private void shakeTidyIcon(float paramFloat1, float paramFloat2)
    {
      this.changeX = (paramFloat1 - this.lastX);
      this.lastX = paramFloat1;
      long l1;
      long l2;
      if (this.changeX > 4.5F)
      {
        l1 = System.currentTimeMillis();
        l2 = l1 - this.lastTime;
        if (l2 >= 210L)
          break label47;
      }
      label47: 
      do
      {
        return;
        this.lastTime = l1;
      }
      while ((l2 >= 680L) || (l1 - this.beginTime <= 2000L));
      this.beginTime = System.currentTimeMillis();
      SensorUtil.this.mSensorCallback.shakeTidyIcon();
    }

    public void onAccuracyChanged(Sensor paramSensor, int paramInt)
    {
    }

    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      SensorUtil.this.setSensorUtilEvent(paramSensorEvent);
      switch (paramSensorEvent.sensor.getType())
      {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      default:
        return;
      case 1:
      }
      dealAccelerometer(paramSensorEvent);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.sensor.SensorUtil
 * JD-Core Version:    0.6.2
 */