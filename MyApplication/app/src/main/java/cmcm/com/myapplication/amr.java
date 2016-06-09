package cmcm.com.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class amr extends ans
{
  private final BluetoothAdapter a = BluetoothAdapter.getDefaultAdapter();

  public amr(Context paramContext)
  {
    this(paramContext, null);
  }

  public amr(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 4;
    case 10:
      return 0;
    case 12:
      return 1;
    case 11:
      return 2;
    case 13:
    }
    return 3;
  }

  public int a(Context paramContext)
  {
    if (this.a != null)
      return b(this.a.getState());
    return 4;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837813;
  }

  public String a()
  {
    return "android.bluetooth.adapter.action.STATE_CHANGED";
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
      return;
    a(paramContext, b(paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)));
  }

  public boolean a(Context paramContext, final boolean paramBoolean)
  {
    if (this.a == null);
    new AsyncTask()
    {
      protected Boolean a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          if (paramBoolean);
          for (boolean bool = amr.a(amr.this).enable(); ; bool = amr.a(amr.this).disable())
            return Boolean.valueOf(bool);
        }
        catch (Throwable paramAnonymousArrayOfVoid)
        {
        }
        return Boolean.valueOf(false);
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    return super.a(paramContext, paramBoolean);
  }

  public Intent b(Context paramContext)
  {
    Intent localIntent = a("com.android.settings", "com.android.settings.Settings$BluetoothSettingsActivity");
    if (asq.a(paramContext, localIntent))
      return localIntent;
    localIntent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
    return localIntent;
  }

  public String b()
  {
    return "Bluetooth";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_bluetooth";
  }

  public int c()
  {
    return 1;
  }

  public int d()
  {
    return 2131231113;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amr
 * JD-Core Version:    0.6.2
 */