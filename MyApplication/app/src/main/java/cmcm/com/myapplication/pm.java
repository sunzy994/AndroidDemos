package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class pm
  implements pj
{
  private static String e;
  protected RelativeLayout a;
  protected Object b;
  protected Object c;
  protected boolean d = false;
  private boolean f = false;
  private String g;
  private String h;
  private ClassLoader i;
  private Class j;
  private Class k;
  private Class l;
  private Class m;
  private Class n;
  private Class o;
  private Class p;
  private Class q;

  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, final int paramInt, String paramString4, RelativeLayout paramRelativeLayout, final pk parampk)
  {
    while (true)
    {
      try
      {
        a(paramActivity);
        this.f = true;
        if (paramString3 != null)
          this.g = paramString3;
        if (paramString4 != null)
          this.h = paramString4;
        po.b("GA9", "[V:" + paramString3 + "|" + paramString4 + "`P:0`T:" + paramInt + "`I:GG" + "]");
        if (paramInt == 1)
        {
          this.b = ox.a(this.q, new Object[] { paramActivity }, new Class[] { Context.class });
          ox.a(this.b, "setAdUnitId", new Object[] { paramString2 });
          paramActivity = ox.a(this.i, this.k, new InvocationHandler()
          {
            public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
            {
              paramAnonymousObject = paramAnonymousMethod.getName();
              if (paramAnonymousObject.equals("onAdClosed"));
              while (true)
              {
                try
                {
                  po.b("GAB", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                  parampk.a(new JSONObject(), true);
                  po.a();
                  return null;
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onAdClosed", paramAnonymousObject);
                  continue;
                }
                if (paramAnonymousObject.equals("onAdFailedToLoad"))
                  try
                  {
                    int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
                    po.b("GAA", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "`C:" + i + "`E:]");
                    parampk.a(new Exception("ad load failed " + i));
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdFailedToLoad", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdLeftApplication"))
                  try
                  {
                    po.b("GA3", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.c(new JSONObject());
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdLeftApplication", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdLoaded"))
                  try
                  {
                    po.b("GA1", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.a(new JSONObject());
                    if (!pm.this.d)
                      continue;
                    ox.a(pm.this.b, "show", new Object[0]);
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdLoaded", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdOpened"))
                  try
                  {
                    po.b("GA0", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.b(new JSONObject());
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdOpened", paramAnonymousObject);
                  }
              }
            }
          });
          paramString1 = this.l;
          paramString2 = this.k;
          paramActivity = ox.a(paramString1, "proxy", new Object[] { paramActivity }, new Class[] { paramString2 });
          paramString1 = this.b;
          paramString2 = this.j;
          ox.a(paramString1, "setAdListener", new Object[] { paramActivity }, new Class[] { paramString2 });
          paramActivity = ox.a(ox.a(this.n, new Object[0]), "build", new Object[0]);
          paramString1 = this.b;
          paramString2 = this.m;
          ox.a(paramString1, "loadAd", new Object[] { paramActivity }, new Class[] { paramString2 });
          return;
          this.c = ox.a(this.p, new Object[] { paramActivity }, new Class[] { Context.class });
          paramActivity = ox.a(this.o, "BANNER");
          paramString1 = this.c;
          paramString3 = this.o;
          ox.a(paramString1, "setAdSize", new Object[] { paramActivity }, new Class[] { paramString3 });
          ox.a(this.c, "setAdUnitId", new Object[] { paramString2 });
          paramActivity = ox.a(this.i, this.k, new InvocationHandler()
          {
            public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
            {
              paramAnonymousObject = paramAnonymousMethod.getName();
              if (paramAnonymousObject.equals("onAdClosed"));
              while (true)
              {
                try
                {
                  po.b("GAB", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                  parampk.a(new JSONObject(), true);
                  return null;
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onAdClosed", paramAnonymousObject);
                  continue;
                }
                if (paramAnonymousObject.equals("onAdFailedToLoad"))
                  try
                  {
                    int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
                    po.b("GAA", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "`C:" + i + "`E:]");
                    parampk.a(new Exception("ad load failed " + i));
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdFailedToLoad", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdLeftApplication"))
                  try
                  {
                    po.b("GA3", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.c(new JSONObject());
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdLeftApplication", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdLoaded"))
                  try
                  {
                    po.b("GA1", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.a(new JSONObject());
                    pm.this.a.addView((View)pm.this.c);
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdLoaded", paramAnonymousObject);
                  }
                else if (paramAnonymousObject.equals("onAdOpened"))
                  try
                  {
                    po.b("GA0", "[V:" + pm.a(pm.this) + "|" + pm.b(pm.this) + "`P:0`T:" + paramInt + "`I:GG|" + "]");
                    parampk.b(new JSONObject());
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdOpened", paramAnonymousObject);
                  }
              }
            }
          });
          paramString1 = this.l;
          paramString2 = this.k;
          paramActivity = ox.a(paramString1, "proxy", new Object[] { paramActivity }, new Class[] { paramString2 });
          paramString1 = this.c;
          paramString2 = this.j;
          ox.a(paramString1, "setAdListener", new Object[] { paramActivity }, new Class[] { paramString2 });
          paramActivity = ox.a(ox.a(this.n, new Object[0]), "build", new Object[0]);
          paramString1 = this.c;
          paramString2 = this.m;
          ox.a(paramString1, "loadAd", new Object[] { paramActivity }, new Class[] { paramString2 });
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        parampk.a(new Exception(paramActivity));
        po.a("GG.loadAd.e", paramActivity);
        return;
      }
      do
      {
        throw new Exception("unknown placementType " + paramInt);
        if (paramInt == 2)
          break;
      }
      while (paramInt != 3);
    }
  }

  public void a(ContextWrapper paramContextWrapper)
  {
    if (e == null)
      e = oy.b(paramContextWrapper, "gg.jar").getAbsolutePath();
    if (this.i == null)
    {
      this.i = ox.a(paramContextWrapper, e);
      ox.a(paramContextWrapper, this.i);
    }
    this.j = ox.a(this.i, "com.google.android.gms.ads.AdListener");
    this.k = ox.a(this.i, "com.hola.jar_pack.AdListener");
    this.l = ox.a(this.i, "com.hola.jar_pack.AdListenerProxy");
    this.m = ox.a(this.i, "com.google.android.gms.ads.AdRequest");
    this.n = ox.a(this.i, "com.google.android.gms.ads.AdRequest$Builder");
    this.o = ox.a(this.i, "com.google.android.gms.ads.AdSize");
    this.p = ox.a(this.i, "com.google.android.gms.ads.AdView");
    this.q = ox.a(this.i, "com.google.android.gms.ads.InterstitialAd");
  }

  public boolean a()
  {
    return this.f;
  }

  public void b()
  {
    if (this.b != null)
      this.b = null;
    if (this.c != null);
    try
    {
      ox.a(this.c, "destroy", new Object[0]);
      this.c = null;
      if (this.a != null)
        this.a.removeAllViews();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        po.a("gg.destroy", localThrowable);
    }
  }

  public void b(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, RelativeLayout paramRelativeLayout, pk parampk)
  {
    try
    {
      this.a = paramRelativeLayout;
      if (paramString3 != null)
        this.g = paramString3;
      if (paramString4 != null)
        this.h = paramString4;
      if (!a())
        a(paramActivity, paramString1, paramString2, paramString3, paramInt, paramString4, paramRelativeLayout, parampk);
      if (paramInt == 1)
      {
        if (((Boolean)ox.a(this.b, "isLoaded", new Object[0])).booleanValue())
        {
          ox.a(this.b, "show", new Object[0]);
          return;
        }
        this.d = true;
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      parampk.a(new Exception(paramActivity));
      po.a("GG.showAd.e", paramActivity);
      return;
    }
    if ((paramInt != 2) && (paramInt != 3))
      throw new Exception("unknown placementType " + paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pm
 * JD-Core Version:    0.6.2
 */