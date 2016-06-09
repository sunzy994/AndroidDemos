package cmcm.com.myapplication.com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Iterator;
import java.util.List;

public class es extends BroadcastReceiver
{
  private static es e;
  boolean a;
  Boolean b;
  private final dt<er> c = new dt();
  private boolean d = false;

  public static es a()
  {
    try
    {
      if (e == null)
        e = new es();
      es locales = e;
      return locales;
    }
    finally
    {
    }
  }

  private boolean a(Context paramContext)
  {
    if ((!this.d) || (paramContext == null))
      return true;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }

  private List<er> f()
  {
    try
    {
      List localList = this.c.a();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(er paramer)
  {
    try
    {
      this.c.a(paramer);
      return;
    }
    finally
    {
      paramer = finally;
    }
    throw paramer;
  }

  public void b()
  {
    try
    {
      Context localContext = do.a().b();
      if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
      for (boolean bool = true; ; bool = false)
      {
        this.d = bool;
        this.a = a(localContext);
        if (this.d)
          d();
        return;
      }
    }
    finally
    {
    }
  }

  public boolean c()
  {
    if (this.b != null)
      return this.b.booleanValue();
    return this.a;
  }

  void d()
  {
    Context localContext = do.a().b();
    this.a = a(localContext);
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }

  public es.a e()
  {
    if (!this.d)
      return es.a.a;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)do.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
      return es.a.a;
    switch (localNetworkInfo.getType())
    {
    default:
      return es.a.c;
    case 1:
    case 9:
      return es.a.b;
    case 0:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
      return es.a.c;
    case 8:
    }
    return es.a.a;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = a(paramContext);
    if (this.a != bool)
    {
      this.a = bool;
      paramContext = f().iterator();
      while (paramContext.hasNext())
        ((er)paramContext.next()).a(this.a);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.es
 * JD-Core Version:    0.6.2
 */