package cmcm.com.myapplication;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;

class j
{
  public static Bundle[] a(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.getParcelableArray(paramString);
    if (((localObject instanceof Bundle[])) || (localObject == null))
      return (Bundle[])localObject;
    localObject = (Bundle[])Arrays.copyOf((Object[])localObject, localObject.length, [Landroid.os.Bundle.class);
    paramBundle.putParcelableArray(paramString, (Parcelable[])localObject);
    return localObject;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */