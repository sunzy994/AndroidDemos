package cmcm.com.myapplication;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ul
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }

  public static final Intent a()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setType("vnd.android-dir/mms-sms");
    return localIntent;
  }

  public static Bitmap a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).iterator();
      while (paramIntent.hasNext())
      {
        Drawable localDrawable = ((ResolveInfo)paramIntent.next()).activityInfo.loadIcon(paramContext.getPackageManager());
        if (localDrawable != null)
        {
          paramContext = ((BitmapDrawable)localDrawable).getBitmap();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }

  public static void a(Context paramContext)
  {
    ((KeyguardManager)paramContext.getSystemService("keyguard")).newKeyguardLock("unLock").disableKeyguard();
  }

  public static void a(Context paramContext, int paramInt)
  {
    Log.e("@@@", "wakelock acquire");
    paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435462, "wk" + System.currentTimeMillis());
    paramContext.acquire();
    paramContext.setReferenceCounted(false);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        Log.e("@@@", "wakelock release");
        if ((ul.this != null) && (ul.this.isHeld()))
          ul.this.release();
      }
    }
    , paramInt);
  }

  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }

  public static final Intent b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.CALL_BUTTON");
    return localIntent;
  }

  public static void b(Context paramContext, int paramInt)
  {
    if (c())
    {
      a(paramContext, paramInt);
      a(paramContext);
    }
  }

  public static boolean c()
  {
    int i = Calendar.getInstance().get(11);
    return (i >= 8) && (i <= 22);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ul
 * JD-Core Version:    0.6.2
 */