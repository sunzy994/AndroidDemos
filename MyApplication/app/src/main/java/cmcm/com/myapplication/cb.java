package cmcm.com.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

class cb
{
  static Bundle a(bz parambz)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("resultKey", parambz.a());
    localBundle.putCharSequence("label", parambz.b());
    localBundle.putCharSequenceArray("choices", parambz.c());
    localBundle.putBoolean("allowFreeFormInput", parambz.d());
    localBundle.putBundle("extras", parambz.e());
    return localBundle;
  }

  static bz a(Bundle paramBundle, ca paramca)
  {
    return paramca.b(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), paramBundle.getBundle("extras"));
  }

  static void a(bz[] paramArrayOfbz, Intent paramIntent, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    int j = paramArrayOfbz.length;
    int i = 0;
    while (i < j)
    {
      bz localbz = paramArrayOfbz[i];
      Object localObject = paramBundle.get(localbz.a());
      if ((localObject instanceof CharSequence))
        localBundle.putCharSequence(localbz.a(), (CharSequence)localObject);
      i += 1;
    }
    paramArrayOfbz = new Intent();
    paramArrayOfbz.putExtra("android.remoteinput.resultsData", localBundle);
    paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", paramArrayOfbz));
  }

  static Bundle[] a(bz[] paramArrayOfbz)
  {
    if (paramArrayOfbz == null)
      return null;
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfbz.length];
    int i = 0;
    while (i < paramArrayOfbz.length)
    {
      arrayOfBundle[i] = a(paramArrayOfbz[i]);
      i += 1;
    }
    return arrayOfBundle;
  }

  static bz[] a(Bundle[] paramArrayOfBundle, ca paramca)
  {
    if (paramArrayOfBundle == null)
      return null;
    bz[] arrayOfbz = paramca.b(paramArrayOfBundle.length);
    int i = 0;
    while (i < paramArrayOfBundle.length)
    {
      arrayOfbz[i] = a(paramArrayOfBundle[i], paramca);
      i += 1;
    }
    return arrayOfbz;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cb
 * JD-Core Version:    0.6.2
 */