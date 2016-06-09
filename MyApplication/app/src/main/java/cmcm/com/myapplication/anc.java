package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class anc
{
  final Context a;
  Method b;
  Method c;
  private final TelephonyManager d;
  private final ConnectivityManager e;
  private Method f;
  private Object g;
  private Method h;

  anc(Context paramContext)
  {
    this.a = paramContext;
    this.d = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.e = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    try
    {
      this.f = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      this.f.setAccessible(true);
      if ((Build.VERSION.SDK_INT >= 21) && (vs.v(paramContext)))
      {
        arj.a(new and(this));
        return;
      }
      paramContext = ConnectivityManager.class.getDeclaredField("mService");
      paramContext.setAccessible(true);
      this.g = paramContext.get(this.e);
      this.b = this.g.getClass().getDeclaredMethod("setMobileDataEnabled", new Class[] { Boolean.TYPE });
      this.b.setAccessible(true);
      return;
    }
    catch (Exception paramContext)
    {
      if ((this.b == null) && (Build.VERSION.SDK_INT < 21))
        try
        {
          this.c = ConnectivityManager.class.getDeclaredMethod("setMobileDataEnabled", new Class[] { Boolean.TYPE });
          this.c.setAccessible(true);
          return;
        }
        catch (Exception paramContext)
        {
        }
    }
  }

  boolean a()
  {
    return this.d.getSimState() == 1;
  }

  boolean a(boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        Object localObject;
        if ((aqs.S()) && (aqs.A()))
        {
          if (paramBoolean)
          {
            localObject = new Intent("android.intent.action.DATA_DEFAULT_SIM");
            ((Intent)localObject).putExtra("simid", 1L);
            this.a.sendBroadcast((Intent)localObject);
            return true;
          }
          localObject = new Intent("android.intent.action.DATA_DEFAULT_SIM");
          ((Intent)localObject).putExtra("simid", -1L);
          this.a.sendBroadcast((Intent)localObject);
          return true;
        }
        if (this.h != null)
        {
          arp.a(this.d, this.h, new Object[]{Boolean.valueOf(paramBoolean)});
          return true;
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (!vs.v(this.a))
            break;
          yb.p();
          StringBuilder localStringBuilder = new StringBuilder().append("settings put global mobile_data ");
          if (paramBoolean)
          {
            localObject = "1";
            return ase.a((String) localObject, true, false).d;
          }
        }
        else
        {
          if (this.b != null)
          {
            arp.a(this.g, this.b, new Object[]{Boolean.valueOf(paramBoolean)});
            return true;
          }
          if (this.c != null)
          {
            arp.a(this.e, this.c, new Object[]{Boolean.valueOf(paramBoolean)});
            return true;
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      String str = "0";
    }
    return false;
  }

  boolean b()
  {
    boolean bool = false;
    if (this.f != null)
      bool = ((Boolean) arp.a(this.e, this.f)).booleanValue();
    return bool;
  }

  int c()
  {
    if (this.d == null)
      return 0;
    return this.d.getDataState();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     anc
 * JD-Core Version:    0.6.2
 */