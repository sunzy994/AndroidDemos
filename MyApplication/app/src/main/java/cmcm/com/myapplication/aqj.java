package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;

public abstract class aqj extends BroadcastReceiver
{
  private final IntentFilter a = new IntentFilter();

  public aqj()
  {
    this.a.addAction("android.intent.action.PACKAGE_ADDED");
    this.a.addAction("android.intent.action.PACKAGE_REMOVED");
    this.a.addAction("android.intent.action.PACKAGE_CHANGED");
    this.a.addDataScheme("package");
  }

  private static String a(Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    if (paramIntent == null)
      return null;
    return paramIntent.getSchemeSpecificPart();
  }

  protected abstract void a(String paramString);

  protected abstract void b(String paramString);

  protected abstract void c(String paramString);

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = a(paramIntent);
    paramIntent = paramIntent.getAction();
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default:
    case 1544582882:
    case 525384130:
    case 172491798:
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (paramIntent.equals("android.intent.action.PACKAGE_ADDED"))
        {
          i = 0;
          continue;
          if (paramIntent.equals("android.intent.action.PACKAGE_REMOVED"))
          {
            i = 1;
            continue;
            if (paramIntent.equals("android.intent.action.PACKAGE_CHANGED"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    a(paramContext);
    return;
    b(paramContext);
    return;
    c(paramContext);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqj
 * JD-Core Version:    0.6.2
 */