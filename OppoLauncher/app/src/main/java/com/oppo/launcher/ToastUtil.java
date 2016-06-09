package com.oppo.launcher;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class ToastUtil
{
  private static Handler mHandler = new Handler(Looper.getMainLooper());
  private static Object mSynObj = new Object();
  private static Toast mToast = null;

  public static void showMessage(final Context paramContext, int paramInt1, final int paramInt2)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        ToastUtil.mHandler.post(new Runnable()
        {
          public void run()
          {
            synchronized (ToastUtil.mSynObj)
            {
              if (ToastUtil.mToast != null)
              {
                ToastUtil.mToast.cancel();
                ToastUtil.mToast.setText(ToastUtil.2.this.val$msg);
                ToastUtil.mToast.setDuration(ToastUtil.2.this.val$len);
                ToastUtil.mToast.show();
                return;
              }
              ToastUtil.access$102(Toast.makeText(ToastUtil.2.this.val$context, ToastUtil.2.this.val$msg, ToastUtil.2.this.val$len));
            }
          }
        });
      }
    }).start();
  }

  public static void showMessage(Context paramContext, String paramString)
  {
    showMessage(paramContext, paramString, 0);
  }

  public static void showMessage(final Context paramContext, String paramString, final int paramInt)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        ToastUtil.mHandler.post(new Runnable()
        {
          public void run()
          {
            synchronized (ToastUtil.mSynObj)
            {
              if (ToastUtil.mToast != null)
              {
                ToastUtil.mToast.cancel();
                ToastUtil.mToast.setText(ToastUtil.1.this.val$msg);
                ToastUtil.mToast.setDuration(ToastUtil.1.this.val$len);
                ToastUtil.mToast.show();
                return;
              }
              ToastUtil.access$102(Toast.makeText(ToastUtil.1.this.val$context, ToastUtil.1.this.val$msg, ToastUtil.1.this.val$len));
            }
          }
        });
      }
    }).start();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ToastUtil
 * JD-Core Version:    0.6.2
 */