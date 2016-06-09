package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public abstract class uc extends BroadcastReceiver
{
  private Context a;

  public void a(Context paramContext)
  {
    if (a());
    while ((paramContext == null) || (b() == null))
      return;
    paramContext.registerReceiver(this, b());
    this.a = paramContext;
  }

  public boolean a()
  {
    return this.a != null;
  }

  public IntentFilter b()
  {
    return null;
  }

  public void c()
  {
    if (this.a != null)
    {
      this.a.unregisterReceiver(this);
      this.a = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     uc
 * JD-Core Version:    0.6.2
 */