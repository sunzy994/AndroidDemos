package cmcm.com.myapplication.com.facebook.ads.internal.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.dto.f;
import com.facebook.ads.internal.thirdparty.http.m;
import com.facebook.ads.internal.thirdparty.http.n;
import com.facebook.ads.internal.thirdparty.http.o;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.p;
import com.facebook.ads.internal.util.r;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

public class a
{
  private static final p g = new p();
  private static final ThreadPoolExecutor h = (ThreadPoolExecutor)Executors.newCachedThreadPool(g);
  Map<String, String> a;
  private final b b = b.a();
  private a.a c;
  private com.facebook.ads.internal.dto.e d;
  private com.facebook.ads.internal.thirdparty.http.a e;
  private final String f;

  public a()
  {
    String str = AdSettings.getUrlPrefix();
    if (AdInternalSettings.shouldUseLiveRailEndpoint())
    {
      if (r.a(str));
      for (str = "https://ad6.liverail.com/"; ; str = String.format("https://ad6.%s.liverail.com/", new Object[] { str }))
      {
        this.f = str;
        return;
      }
    }
    if (r.a(str));
    for (str = "https://graph.facebook.com/network_ads_common/"; ; str = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[] { str }))
    {
      this.f = str;
      return;
    }
  }

  private void a(com.facebook.ads.internal.b paramb)
  {
    if (this.c != null)
      this.c.a(paramb);
    a();
  }

  private void a(d paramd)
  {
    if (this.c != null)
      this.c.a(paramd);
    a();
  }

  private void a(String paramString)
  {
    while (true)
    {
      try
      {
        localObject2 = this.b.a(paramString);
        localObject1 = ((c)localObject2).b();
        if (localObject1 != null)
          com.facebook.ads.internal.util.d.a(((com.facebook.ads.internal.dto.c)localObject1).a().c(), this.d);
        switch (3.a[localObject2.a().ordinal()])
        {
        case 1:
          a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(paramString));
          return;
          localObject2 = (d)localObject2;
          if ((localObject1 != null) && (((com.facebook.ads.internal.dto.c)localObject1).a().d()))
            com.facebook.ads.internal.util.d.a(paramString, this.d);
          a((d)localObject2);
          return;
        case 2:
        }
      }
      catch (Exception paramString)
      {
        a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(paramString.getMessage()));
        return;
      }
      Object localObject2 = (e)localObject2;
      Object localObject1 = ((e)localObject2).c();
      localObject2 = AdErrorType.adErrorTypeFromCode(((e)localObject2).d(), AdErrorType.ERROR_MESSAGE);
      if (localObject1 != null)
        paramString = (String)localObject1;
      a(((AdErrorType)localObject2).getAdErrorWrapper(paramString));
      return;
    }
  }

  private boolean a(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
      return true;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private com.facebook.ads.internal.thirdparty.http.b b()
  {
    return new com.facebook.ads.internal.thirdparty.http.b()
    {
      public void a(m paramAnonymousm)
      {
        com.facebook.ads.internal.util.d.b(a.d(a.this));
        a.a(a.this, null);
        try
        {
          Object localObject1 = paramAnonymousm.a();
          if (localObject1 != null)
          {
            localObject1 = ((n)localObject1).e();
            Object localObject2 = a.e(a.this).a((String)localObject1);
            if (((c)localObject2).a() == c.a.b)
            {
              Object localObject3 = (e)localObject2;
              localObject2 = ((e)localObject3).c();
              localObject3 = AdErrorType.adErrorTypeFromCode(((e)localObject3).d(), AdErrorType.ERROR_MESSAGE);
              a locala = a.this;
              if (localObject2 == null);
              while (true)
              {
                a.a(locala, ((AdErrorType)localObject3).getAdErrorWrapper((String)localObject1));
                return;
                localObject1 = localObject2;
              }
            }
          }
        }
        catch (JSONException localJSONException)
        {
          a.a(a.this, new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, paramAnonymousm.getMessage()));
        }
      }

      public void a(n paramAnonymousn)
      {
        if (paramAnonymousn != null)
        {
          paramAnonymousn = paramAnonymousn.e();
          com.facebook.ads.internal.util.d.b(a.d(a.this));
          a.a(a.this, null);
          a.a(a.this, paramAnonymousn);
        }
      }

      public void a(Exception paramAnonymousException)
      {
        if (m.class.equals(paramAnonymousException.getClass()))
        {
          a((m)paramAnonymousException);
          return;
        }
        a.a(a.this, new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, paramAnonymousException.getMessage()));
      }
    };
  }

  public void a()
  {
    if (this.e != null)
    {
      this.e.c(1);
      this.e.b(1);
      this.e = null;
    }
  }

  public void a(final Context paramContext, final com.facebook.ads.internal.dto.e parame)
  {
    a();
    if (!a(paramContext))
    {
      a(new com.facebook.ads.internal.b(AdErrorType.NETWORK_ERROR, "No network connection"));
      return;
    }
    this.d = parame;
    if (com.facebook.ads.internal.util.d.a(parame))
    {
      paramContext = com.facebook.ads.internal.util.d.c(parame);
      if (paramContext != null)
      {
        a(paramContext);
        return;
      }
      a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
      return;
    }
    h.submit(new Runnable()
    {
      public void run()
      {
        f.b(paramContext);
        a.this.a = parame.e();
        try
        {
          a.a(a.this, new com.facebook.ads.internal.thirdparty.http.a(paramContext, parame.e));
          a.b(a.this).a(a.a(a.this), a.b(a.this).b().a(a.this.a), a.c(a.this));
          return;
        }
        catch (Exception localException)
        {
          a.a(a.this, AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(localException.getMessage()));
        }
      }
    });
  }

  public void a(a.a parama)
  {
    this.c = parama;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.server.a
 * JD-Core Version:    0.6.2
 */