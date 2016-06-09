package cmcm.com.myapplication;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class px
{
  private ContextWrapper a;
  private ClassLoader b;
  private Class c;
  private Class d;
  private Class e;
  private Class f;
  private pv g;
  private Object h;

  public px(ContextWrapper paramContextWrapper)
  {
    this.a = paramContextWrapper;
    try
    {
      this.b = py.a(this.a);
      this.c = ox.a(this.b, "com.facebook.ads.AdSettings");
      this.d = ox.a(this.b, "com.facebook.ads.NativeAd");
      paramContextWrapper = po.a(this.a, "fb", 4)[1];
      if ((paramContextWrapper == null) || (paramContextWrapper.isEmpty()))
        throw new pi("placementId is null");
    }
    catch (Throwable paramContextWrapper)
    {
      po.a("NativeAd", paramContextWrapper);
      return;
    }
    this.h = ox.a(this.d, new Object[] { this.a, paramContextWrapper }, new Class[] { Context.class, String.class });
    paramContextWrapper = this.h;
    Class localClass = Boolean.TYPE;
    ox.a(paramContextWrapper, "setMediaViewAutoplay", new Object[] { Boolean.valueOf(true) }, new Class[] { localClass });
  }

  private static void b(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    String[] arrayOfString = new String[paramHashMap.size()];
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      arrayOfString[i] = (localEntry.getKey() + ":" + localEntry.getValue());
      i += 1;
    }
    paramHashMap = TextUtils.join("`", arrayOfString);
    qf.a(paramContext, paramString, "[" + paramHashMap + "]");
  }

  public void a()
  {
    if (this.h == null)
      return;
    try
    {
      ox.a(this.h, "loadAd", new Object[0]);
      HashMap localHashMap = new HashMap();
      localHashMap.put("V", "GAME_LIST|NATIVE");
      localHashMap.put("P", "0");
      localHashMap.put("T", "4");
      localHashMap.put("I", "FB");
      b(this.a, "GA9", localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      po.a("loadAd", localThrowable);
    }
  }

  public void a(View paramView)
  {
    try
    {
      ox.a(this.h, "registerViewForInteraction", new Object[] { paramView }, new Class[] { View.class });
      return;
    }
    catch (Throwable paramView)
    {
      po.a("registerViewForInteraction", paramView);
    }
  }

  public void a(pv parampv)
  {
    if (this.h == null)
      return;
    this.g = parampv;
    try
    {
      this.e = ox.a(this.b, "com.facebook.ads.AdListener");
      parampv = ox.a(this.b, this.e, new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            paramAnonymousObject = paramAnonymousMethod.getName();
            if (paramAnonymousObject.equals("onError"))
            {
              paramAnonymousObject = paramAnonymousArrayOfObject[1];
              int i = ((Integer)ox.a(paramAnonymousObject, "getErrorCode", new Object[0])).intValue();
              paramAnonymousObject = (String)ox.a(paramAnonymousObject, "getErrorMessage", new Object[0]);
              px.a(px.this).a(new pu(paramAnonymousObject, i));
              paramAnonymousMethod = new HashMap();
              paramAnonymousMethod.put("V", "GAME_LIST|NATIVE");
              paramAnonymousMethod.put("P", "0");
              paramAnonymousMethod.put("T", "4");
              paramAnonymousMethod.put("I", "FB");
              paramAnonymousMethod.put("C", String.valueOf(i));
              paramAnonymousMethod.put("E", paramAnonymousObject);
              px.a(px.b(px.this), "GAA", paramAnonymousMethod);
            }
            else if (paramAnonymousObject.equals("onAdLoaded"))
            {
              px.a(px.this).a(px.this);
              paramAnonymousObject = new HashMap();
              paramAnonymousObject.put("V", "GAME_LIST|NATIVE");
              paramAnonymousObject.put("P", "0");
              paramAnonymousObject.put("T", "4");
              paramAnonymousObject.put("I", "FB|");
              px.a(px.b(px.this), "GA1", paramAnonymousObject);
            }
          }
          catch (Throwable paramAnonymousObject)
          {
            po.a("setAdListener.invoke", paramAnonymousObject);
          }
          if (paramAnonymousObject.equals("onAdClicked"))
          {
            px.a(px.this).c(px.this);
            paramAnonymousObject = new HashMap();
            paramAnonymousObject.put("V", "GAME_LIST|NATIVE");
            paramAnonymousObject.put("P", "0");
            paramAnonymousObject.put("T", "4");
            paramAnonymousObject.put("I", "FB|");
            px.a(px.b(px.this), "GA3", paramAnonymousObject);
          }
          return null;
        }
      });
      Object localObject = this.h;
      Class localClass = this.e;
      ox.a(localObject, "setAdListener", new Object[] { parampv }, new Class[] { localClass });
      this.f = ox.a(this.b, "com.facebook.ads.ImpressionListener");
      parampv = ox.a(this.b, this.f, new InvocationHandler()
      {
        public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          try
          {
            if (paramAnonymousMethod.getName().equals("onLoggingImpression"))
            {
              px.a(px.this).b(px.this);
              paramAnonymousObject = new HashMap();
              paramAnonymousObject.put("V", "GAME_LIST|NATIVE");
              paramAnonymousObject.put("P", "0");
              paramAnonymousObject.put("T", "4");
              paramAnonymousObject.put("I", "FB|");
              px.a(px.b(px.this), "GA0", paramAnonymousObject);
            }
            return null;
          }
          catch (Throwable paramAnonymousObject)
          {
            while (true)
              po.a("setAdListener.invoke", paramAnonymousObject);
          }
        }
      });
      localObject = this.h;
      localClass = this.f;
      ox.a(localObject, "setImpressionListener", new Object[] { parampv }, new Class[] { localClass });
      return;
    }
    catch (Throwable parampv)
    {
      po.a("setAdListener", parampv);
    }
  }

  public pw b()
  {
    try
    {
      Object localObject = ox.a(this.h, "getAdCoverImage", new Object[0]);
      localObject = new pw((String)ox.a(localObject, "getUrl", new Object[0]), ((Integer)ox.a(localObject, "getWidth", new Object[0])).intValue(), ((Integer)ox.a(localObject, "getHeight", new Object[0])).intValue());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      po.a("getCoverImage", localThrowable);
    }
    return null;
  }

  public String c()
  {
    try
    {
      String str = (String)ox.a(this.h, "getAdTitle", new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
      po.a("getTitle", localThrowable);
    }
    return null;
  }

  public String d()
  {
    try
    {
      String str = (String)ox.a(this.h, "getAdCallToAction", new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
      po.a("getCallToAction", localThrowable);
    }
    return null;
  }

  public void e()
  {
    if (this.h != null);
    try
    {
      ox.a(this.h, "destroy", new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      po.a("destroy", localThrowable);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     px
 * JD-Core Version:    0.6.2
 */