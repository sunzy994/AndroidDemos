package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.lazyswipe.SettingsService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aup
  implements ServiceConnection
{
  private static final String c = "Swipe." + aup.class.getSimpleName();
  private static final Object d = new Object();
  Handler a;
  volatile aut b;
  private Context e;
  private aum f;
  private Set<String> g;
  private Map<String, String> h;
  private volatile boolean i;
  private auj j = new auk()
  {
    private final Map<String, Object> b = new HashMap(2);

    public void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int[] paramAnonymousArrayOfInt)
    {
    }

    public void a(final String paramAnonymousString1, final String paramAnonymousString2, final Bitmap paramAnonymousBitmap)
    {
      if (aup.this.b != null)
        aup.this.a.post(new Runnable()
        {
          public void run()
          {
            try
            {
              aup.this.b.a(paramAnonymousString1, paramAnonymousString2, paramAnonymousBitmap);
              return;
            }
            catch (Throwable localThrowable)
            {
            }
          }
        });
    }
  };

  public static aup a(Context paramContext, aut paramaut)
  {
    aup localaup = new aup();
    localaup.b(paramContext, paramaut);
    return localaup;
  }

  private Bitmap b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      paramString1 = this.f.a(paramString1, paramString2, paramBoolean, false, paramInt1, paramInt2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
    }
    return null;
  }

  public Bitmap a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }

  public Bitmap a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, (String)null, paramBoolean, 0, 0);
  }

  public Bitmap a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.i)
      return null;
    if ((this.f == null) || (this.e == null))
      synchronized (d)
      {
        if (this.h == null)
          this.h = new HashMap(2);
        this.h.put(paramString1, paramString2);
        if (paramBoolean)
        {
          if (this.g == null)
            this.g = new HashSet(2);
          this.g.add(paramString1);
        }
        return null;
      }
    return b(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
  }

  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, (String)null, paramBoolean);
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	aup:b	Laut;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 123	aup:b	Laut;
    //   12: aload_0
    //   13: getfield 75	aup:f	Laum;
    //   16: ifnull +29 -> 45
    //   19: aload_0
    //   20: getfield 75	aup:f	Laum;
    //   23: aload_0
    //   24: getfield 65	aup:j	Lauj;
    //   27: invokeinterface 126 2 0
    //   32: aload_0
    //   33: getfield 92	aup:e	Landroid/content/Context;
    //   36: aload_0
    //   37: invokevirtual 132	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 75	aup:f	Laum;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 92	aup:e	Landroid/content/Context;
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 75	aup:f	Laum;
    //   57: goto -12 -> 45
    //   60: astore_1
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 75	aup:f	Laum;
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: goto -37 -> 32
    //
    // Exception table:
    //   from	to	target	type
    //   32	40	51	java/lang/Throwable
    //   32	40	60	finally
    //   19	32	68	android/os/RemoteException
  }

  public void a(Context paramContext)
  {
    this.e = paramContext;
    Intent localIntent = new Intent(paramContext, SettingsService.class);
    localIntent.setAction("action.START_IMAGE_DOWNLOADER");
    paramContext.bindService(localIntent, this, 1);
  }

  public void a(String[] paramArrayOfString)
  {
    if (this.f != null);
    try
    {
      this.f.a(paramArrayOfString);
      synchronized (d)
      {
        label17: if (this.h != null)
        {
          if (paramArrayOfString != null)
            break label46;
          this.h.clear();
        }
        label46: int m;
        int k;
        do
        {
          return;
          m = paramArrayOfString.length;
          k = 0;
        }
        while (k >= m);
        String str = paramArrayOfString[k];
        this.h.remove(str);
        k += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }

  public void b()
  {
    a(null);
  }

  public void b(Context paramContext, aut paramaut)
  {
    this.b = paramaut;
    if (this.b != null)
      this.a = new Handler(Looper.getMainLooper());
    a(paramContext);
  }

  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    try
    {
      this.f = aun.a(paramIBinder);
      this.f.a(this.j);
      synchronized (d)
      {
        if ((this.f != null) && (this.h != null))
        {
          paramIBinder = this.h.entrySet().iterator();
          if (paramIBinder.hasNext())
          {
            Object localObject = (Entry)paramIBinder.next();
            String str = (String)((Entry)localObject).getKey();
            localObject = (String)((Entry)localObject).getValue();
            if ((this.g != null) && (this.g.contains(str)))
            {
              bool = true;
              b(str, (String)localObject, bool, 0, 0);
              paramIBinder.remove();
            }
          }
        }
      }
    }
    catch (Throwable )
    {
      while (true)
      {
        Log.w(c, "Could not register weather callback", ???);
        this.f = null;
        continue;
        boolean bool = false;
      }
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aup
 * JD-Core Version:    0.6.2
 */