package cmcm.com.myapplication.com.facebook.ads.internal;

import android.content.Context;
import android.os.Looper;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.g.a;
import com.facebook.ads.internal.util.r;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.reflect.Method;

public class f
{
  public static final String a = f.class.getSimpleName();
  private final String b;
  private final boolean c;
  private final f.c d;

  private f(String paramString, boolean paramBoolean, f.c paramc)
  {
    this.b = paramString;
    this.c = paramBoolean;
    this.d = paramc;
  }

  private static f a(Context paramContext)
  {
    try
    {
      paramContext = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      if (paramContext != null)
      {
        paramContext = new f(paramContext.getId(), paramContext.isLimitAdTrackingEnabled(), f.c.c);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
    }
    return null;
  }

  public static f a(Context paramContext, g.a parama)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("Cannot get advertising info on main thread.");
    Object localObject;
    if ((parama != null) && (!r.a(parama.b)))
      localObject = new f(parama.b, parama.c, f.c.b);
    do
    {
      return localObject;
      localObject = a(paramContext);
      if (localObject != null)
      {
        parama = (g.a)localObject;
        if (!r.a(((f)localObject).a()));
      }
      else
      {
        parama = b(paramContext);
      }
      if (parama == null)
        break;
      localObject = parama;
    }
    while (!r.a(parama.a()));
    return c(paramContext);
  }

  private static f b(Context paramContext)
  {
    Object localObject = g.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
    if (localObject == null)
      return null;
    localObject = g.a(null, (Method)localObject, new Object[] { paramContext });
    if ((localObject == null) || (((Integer)localObject).intValue() != 0))
      return null;
    localObject = g.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
    if (localObject == null)
      return null;
    paramContext = g.a(null, (Method)localObject, new Object[] { paramContext });
    if (paramContext == null)
      return null;
    localObject = g.a(paramContext.getClass(), "getId", new Class[0]);
    Method localMethod = g.a(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
    if ((localObject == null) || (localMethod == null))
      return null;
    return new f((String)g.a(paramContext, (Method)localObject, new Object[0]), ((Boolean)g.a(paramContext, localMethod, new Object[0])).booleanValue(), f.c.d);
  }

  // ERROR //
  private static f c(Context paramContext)
  {
    // Byte code:
    //   0: new 136	com/facebook/ads/internal/f$b
    //   3: dup
    //   4: aconst_null
    //   5: invokespecial 139	com/facebook/ads/internal/f$b:<init>	(Lcom/facebook/ads/internal/f$1;)V
    //   8: astore_1
    //   9: new 141	android/content/Intent
    //   12: dup
    //   13: ldc 143
    //   15: invokespecial 144	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 146
    //   22: invokevirtual 150	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   25: pop
    //   26: aload_0
    //   27: aload_2
    //   28: aload_1
    //   29: iconst_1
    //   30: invokevirtual 154	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   33: ifeq +47 -> 80
    //   36: new 156	com/facebook/ads/internal/f$a
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 159	com/facebook/ads/internal/f$b:a	()Landroid/os/IBinder;
    //   44: invokespecial 162	com/facebook/ads/internal/f$a:<init>	(Landroid/os/IBinder;)V
    //   47: astore_2
    //   48: new 2	com/facebook/ads/internal/f
    //   51: dup
    //   52: aload_2
    //   53: invokevirtual 163	com/facebook/ads/internal/f$a:a	()Ljava/lang/String;
    //   56: aload_2
    //   57: invokevirtual 165	com/facebook/ads/internal/f$a:b	()Z
    //   60: getstatic 168	com/facebook/ads/internal/f$c:e	Lcom/facebook/ads/internal/f$c;
    //   63: invokespecial 58	com/facebook/ads/internal/f:<init>	(Ljava/lang/String;ZLcom/facebook/ads/internal/f$c;)V
    //   66: astore_2
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 172	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 172	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 172	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   88: aload_2
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   36	67	74	java/lang/Exception
    //   36	67	82	finally
  }

  public String a()
  {
    return this.b;
  }

  public boolean b()
  {
    return this.c;
  }

  public f.c c()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.f
 * JD-Core Version:    0.6.2
 */