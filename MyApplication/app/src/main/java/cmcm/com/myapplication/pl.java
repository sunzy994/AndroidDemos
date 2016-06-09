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

public class pl
  implements pj
{
  private static String f;
  private static String g;
  protected RelativeLayout a;
  protected Object b;
  protected Object c;
  protected boolean d = false;
  protected boolean e = false;
  private String h;
  private String i;
  private ClassLoader j;
  private Class k;
  private Class l;
  private Class m;
  private Class n;
  private Class o;

  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, final int paramInt, String paramString4, RelativeLayout paramRelativeLayout, final pk parampk)
  {
    while (true)
    {
      try
      {
        a(paramActivity);
        this.d = true;
        if (paramString3 != null)
          this.h = paramString3;
        if (paramString4 != null)
          this.i = paramString4;
        po.b("GA9", "[V:" + paramString3 + "|" + paramString4 + "`P:0`T:" + paramInt + "`I:FB]");
        if (paramInt == 1)
        {
          this.c = ox.a(this.k, new Object[] { paramActivity.getApplicationContext(), paramString2 }, new Class[] { Context.class, String.class });
          paramActivity = ox.a(this.j, this.l, new InvocationHandler()
          {
            public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
            {
              paramAnonymousObject = paramAnonymousMethod.getName();
              if (paramAnonymousObject.equals("onInterstitialDisplayed"))
                paramAnonymousObject = paramAnonymousArrayOfObject[0];
              while (true)
              {
                try
                {
                  po.b("GA0", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                  parampk.b(new JSONObject());
                  return null;
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onInterstitialDisplayed", paramAnonymousObject);
                  continue;
                }
                if (paramAnonymousObject.equals("onInterstitialDismissed"))
                {
                  paramAnonymousObject = paramAnonymousArrayOfObject[0];
                  try
                  {
                    po.b("GAB", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                    parampk.a(new JSONObject(), true);
                    po.a();
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onInterstitialDismissed", paramAnonymousObject);
                  }
                }
                else if (paramAnonymousObject.equals("onError"))
                {
                  paramAnonymousObject = paramAnonymousArrayOfObject[0];
                  paramAnonymousMethod = paramAnonymousArrayOfObject[1];
                  try
                  {
                    int i = ((Integer)ox.a(paramAnonymousMethod, "getErrorCode", new Object[0])).intValue();
                    paramAnonymousMethod = (String)ox.a(paramAnonymousMethod, "getErrorMessage", new Object[0]);
                    po.b("GAA", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "`C:" + i + "`E:" + paramAnonymousMethod + "]");
                    parampk.a(new Exception(paramAnonymousMethod));
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onError", paramAnonymousObject);
                  }
                }
                else if (paramAnonymousObject.equals("onAdLoaded"))
                {
                  paramAnonymousObject = paramAnonymousArrayOfObject[0];
                  try
                  {
                    po.b("GA1", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                    parampk.a(new JSONObject());
                    if (!pl.this.e)
                      continue;
                    ox.a(pl.this.c, "show", new Object[0]);
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdLoaded", paramAnonymousObject);
                  }
                }
                else if (paramAnonymousObject.equals("onAdClicked"))
                {
                  paramAnonymousObject = paramAnonymousArrayOfObject[0];
                  try
                  {
                    po.b("GA3", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                    parampk.c(new JSONObject());
                  }
                  catch (Throwable paramAnonymousObject)
                  {
                    po.a("onAdClicked", paramAnonymousObject);
                  }
                }
              }
            }
          });
          paramString1 = this.c;
          paramString2 = this.l;
          ox.a(paramString1, "setAdListener", new Object[] { paramActivity }, new Class[] { paramString2 });
          ox.a(this.c, "loadAd", new Object[0]);
          return;
          paramString1 = ox.a(this.n, "BANNER_HEIGHT_50");
          paramString3 = this.m;
          paramString4 = this.n;
          this.b = ox.a(paramString3, new Object[] { paramActivity, paramString2, paramString1 }, new Class[] { Context.class, String.class, paramString4 });
          paramRelativeLayout.addView((View)this.b);
          paramActivity = ox.a(this.j, this.o, new InvocationHandler()
          {
            private boolean d = true;

            public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
            {
              paramAnonymousObject = paramAnonymousMethod.getName();
              if (paramAnonymousObject.equals("onError"))
              {
                paramAnonymousObject = paramAnonymousArrayOfObject[0];
                paramAnonymousMethod = paramAnonymousArrayOfObject[1];
                try
                {
                  int i = ((Integer)ox.a(paramAnonymousMethod, "getErrorCode", new Object[0])).intValue();
                  paramAnonymousMethod = (String)ox.a(paramAnonymousMethod, "getErrorMessage", new Object[0]);
                  parampk.a(new Exception(paramAnonymousMethod));
                  qq.a("fb_ad_error", "placement_type=" + paramInt + ",placement_id=" + pl.b(pl.this) + ",error=" + i);
                  po.b("GAA", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "`C:" + i + "`E:" + paramAnonymousMethod + "]");
                  if (this.d)
                    this.d = false;
                  else
                    po.b("GA9", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB]");
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onError", paramAnonymousObject);
                }
              }
              else if (paramAnonymousObject.equals("onAdLoaded"))
              {
                paramAnonymousObject = paramAnonymousArrayOfObject[0];
                try
                {
                  parampk.a(new JSONObject());
                  parampk.b(new JSONObject());
                  qq.a("fb_ad_load", "placement_type=" + paramInt + ",placement_id=" + pl.b(pl.this));
                  qq.a("fb_ad_imp", "placement_type=" + paramInt + ",placement_id=" + pl.b(pl.this));
                  po.b("GA1", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                  po.b("GA0", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                  if (this.d)
                    this.d = false;
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onError", paramAnonymousObject);
                }
                po.b("GA9", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB]");
              }
              else if (paramAnonymousObject.equals("onAdClicked"))
              {
                paramAnonymousObject = paramAnonymousArrayOfObject[0];
                try
                {
                  parampk.c(new JSONObject());
                  qq.a("fb_ad_click", "placement_type=" + paramInt + ",placement_id=" + pl.b(pl.this));
                  po.b("GA3", "[V:" + pl.a(pl.this) + "|" + pl.b(pl.this) + "`P:0`T:" + paramInt + "`I:FB|" + paramAnonymousObject.toString() + "]");
                }
                catch (Throwable paramAnonymousObject)
                {
                  po.a("onAdClicked", paramAnonymousObject);
                }
              }
              return null;
            }
          });
          paramString1 = this.b;
          paramString2 = this.o;
          ox.a(paramString1, "setAdListener", new Object[] { paramActivity }, new Class[] { paramString2 });
          ox.a(this.b, "loadAd", new Object[0]);
          paramRelativeLayout.bringToFront();
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        parampk.a(new Exception(paramActivity));
        po.a("FB.loadAd.e", paramActivity);
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
    if (f == null)
      f = oy.b(paramContextWrapper, "gg.jar").getAbsolutePath();
    if (g == null)
      g = oy.b(paramContextWrapper, "fb.jar").getAbsolutePath();
    if (this.j == null)
    {
      this.j = ox.a(paramContextWrapper, f);
      this.j = ox.a(paramContextWrapper, g, this.j);
      ox.a(paramContextWrapper, this.j);
    }
    this.k = ox.a(this.j, "com.facebook.ads.InterstitialAd");
    this.l = ox.a(this.j, "com.facebook.ads.InterstitialAdListener");
    this.m = ox.a(this.j, "com.facebook.ads.AdView");
    this.n = ox.a(this.j, "com.facebook.ads.AdSize");
    this.o = ox.a(this.j, "com.facebook.ads.AdListener");
  }

  public boolean a()
  {
    return this.d;
  }

  public void b()
  {
    if (this.a != null)
      this.a.removeAllViews();
    if (this.b != null);
    try
    {
      ox.a(this.b, "destroy", new Object[0]);
      if (this.c == null);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ox.a(this.c, "destroy", new Object[0]);
        return;
        localThrowable1 = localThrowable1;
        po.a("destroy", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        po.a("destroy", localThrowable2);
      }
    }
  }

  public void b(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, RelativeLayout paramRelativeLayout, pk parampk)
  {
    try
    {
      this.a = paramRelativeLayout;
      if (paramString3 != null)
        this.h = paramString3;
      if (paramString4 != null)
        this.i = paramString4;
      if (!a())
        a(paramActivity, paramString1, paramString2, paramString3, paramInt, paramString4, paramRelativeLayout, parampk);
      if (paramInt == 1)
      {
        if (((Boolean)ox.a(this.c, "isAdLoaded", new Object[0])).booleanValue())
        {
          ox.a(this.c, "show", new Object[0]);
          return;
        }
        this.e = true;
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      parampk.a(new Exception(paramActivity));
      po.a("FB.showAd.e", paramActivity);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pl
 * JD-Core Version:    0.6.2
 */