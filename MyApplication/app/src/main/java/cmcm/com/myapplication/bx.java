package cmcm.com.myapplication;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;

class bx
{
  static void a(bz[] paramArrayOfbz, Intent paramIntent, Bundle paramBundle)
  {
    RemoteInput.addResultsToIntent(a(paramArrayOfbz), paramIntent, paramBundle);
  }

  static RemoteInput[] a(bz[] paramArrayOfbz)
  {
    if (paramArrayOfbz == null)
      return null;
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfbz.length];
    int i = 0;
    while (i < paramArrayOfbz.length)
    {
      bz localbz = paramArrayOfbz[i];
      arrayOfRemoteInput[i] = new Builder(localbz.a()).setLabel(localbz.b()).setChoices(localbz.c()).setAllowFreeFormInput(localbz.d()).addExtras(localbz.e()).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }

  static bz[] a(RemoteInput[] paramArrayOfRemoteInput, ca paramca)
  {
    if (paramArrayOfRemoteInput == null)
      return null;
    bz[] arrayOfbz = paramca.b(paramArrayOfRemoteInput.length);
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
      arrayOfbz[i] = paramca.b(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras());
      i += 1;
    }
    return arrayOfbz;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bx
 * JD-Core Version:    0.6.2
 */