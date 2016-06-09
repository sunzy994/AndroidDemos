package cmcm.com.myapplication.com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flurry.sdk.cy;
import com.flurry.sdk.el;
import com.flurry.sdk.fb;

public final class InstallReceiver extends BroadcastReceiver
{
  static final String a = InstallReceiver.class.getSimpleName();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    el.a(4, a, "Received an Install nofication of " + paramIntent.getAction());
    String str = paramIntent.getExtras().getString("referrer");
    el.a(4, a, "Received an Install referrer of " + str);
    if ((str == null) || (!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())))
    {
      el.a(5, a, "referrer is null");
      return;
    }
    paramIntent = str;
    if (!str.contains("="))
    {
      el.a(4, a, "referrer is before decoding: " + str);
      paramIntent = fb.c(str);
      el.a(4, a, "referrer is: " + paramIntent);
    }
    new cy(paramContext).a(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.android.InstallReceiver
 * JD-Core Version:    0.6.2
 */