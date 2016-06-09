package cmcm.com.myapplication.com.flurry.sdk;

import android.content.Context;
import android.os.Looper;
import android.telephony.TelephonyManager;
import java.util.Arrays;

public class dy
{
  private static final String a = dy.class.getSimpleName();
  private static byte[] b;

  public static byte[] a()
  {
    try
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread())
        throw new IllegalStateException("Must be called from a background thread!");
    }
    finally
    {
    }
    byte[] arrayOfByte;
    if (b != null)
      arrayOfByte = b;
    while (true)
    {
      return arrayOfByte;
      if (do.a().b().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
      {
        arrayOfByte = null;
      }
      else
      {
        b();
        arrayOfByte = b;
      }
    }
  }

  private static void b()
  {
    Object localObject = (TelephonyManager)do.a().b().getSystemService("phone");
    if (localObject == null);
    do
    {
      return;
      localObject = ((TelephonyManager)localObject).getDeviceId();
    }
    while ((localObject == null) || (((String)localObject).trim().length() <= 0));
    try
    {
      localObject = fb.d((String)localObject);
      if ((localObject != null) && (localObject.length == 20))
      {
        b = (byte[])localObject;
        return;
      }
    }
    catch (Exception localException)
    {
      el.a(6, a, "Exception in generateHashedImei()");
      return;
    }
    el.a(6, a, "sha1 is not " + 20 + " bytes long: " + Arrays.toString(localException));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dy
 * JD-Core Version:    0.6.2
 */