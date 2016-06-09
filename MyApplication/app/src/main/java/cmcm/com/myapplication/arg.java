package cmcm.com.myapplication;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

public class arg
{
  public static bb a(Notification paramNotification)
  {
    bb localbb = new bb(paramNotification);
    paramNotification = aj.a(paramNotification);
    if (paramNotification != null)
    {
      paramNotification = paramNotification.getParcelableArray("android.support.wearable.actions");
      if ((paramNotification != null) && (paramNotification.length > 0))
      {
        localbb.b();
        int j = paramNotification.length;
        int i = 0;
        while (i < j)
        {
          localbb.a(b((Bundle)paramNotification[i]));
          i += 1;
        }
      }
    }
    return localbb;
  }

  private static br a(Bundle paramBundle)
  {
    return new bs(paramBundle.getString("return_key")).a(paramBundle.getString("label")).a(paramBundle.getStringArray("choices")).a(paramBundle.getBoolean("allowFreeFormInput")).a();
  }

  public static Bundle[] a(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.getParcelableArray(paramString);
    if (((localObject instanceof Bundle[])) || (localObject == null))
      return (Bundle[])localObject;
    localObject = (Bundle[])Arrays.copyOf((Object[])localObject, localObject.length, [Landroid.os.Bundle.class);
    paramBundle.putParcelableArray(paramString, (Parcelable[])localObject);
    return localObject;
  }

  private static br[] a(Bundle[] paramArrayOfBundle)
  {
    if (paramArrayOfBundle == null)
      return null;
    br[] arrayOfbr = new br[paramArrayOfBundle.length];
    int i = 0;
    while (i < paramArrayOfBundle.length)
    {
      arrayOfbr[i] = a(paramArrayOfBundle[i]);
      i += 1;
    }
    return arrayOfbr;
  }

  private static ak b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("icon");
    Object localObject = paramBundle.getCharSequence("title");
    PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("action_intent");
    paramBundle = (Bundle)paramBundle.getParcelable("extras");
    localObject = new al(i, (CharSequence)localObject, localPendingIntent);
    if (paramBundle != null)
    {
      ((al)localObject).a(paramBundle);
      paramBundle = a(a(paramBundle, "android.support.wearable.remoteInputs"));
      if (paramBundle != null)
      {
        int j = paramBundle.length;
        i = 0;
        while (i < j)
        {
          ((al)localObject).a(paramBundle[i]);
          i += 1;
        }
      }
    }
    return ((al)localObject).a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arg
 * JD-Core Version:    0.6.2
 */