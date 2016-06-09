package cmcm.com.myapplication;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public final class mu
{
  private static final List a = new ArrayList();
  private static boolean b = false;

  private static String a(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      mv.b("HttpParamsHelper", "Failed to get the getAndroidId info.", paramContext);
    }
    return "";
  }

  public static List a(Context paramContext, String paramString)
  {
    ArrayList localArrayList;
    try
    {
      if (b);
      while (true)
      {
        localArrayList = new ArrayList(a);
        localObject = mp.f(paramContext);
        if (!TextUtils.isEmpty((CharSequence)localObject))
          localArrayList.add(new BasicNameValuePair("op", (String)localObject));
        if (Looper.myLooper() != Looper.getMainLooper())
          break;
        throw new IllegalStateException("Cannot get advertising info on main thread.");
        a.add(new BasicNameValuePair("h", mp.b(paramContext)));
        a.add(new BasicNameValuePair("w", mp.c(paramContext)));
        a.add(new BasicNameValuePair("model", mp.b()));
        a.add(new BasicNameValuePair("vendor", mp.a()));
        a.add(new BasicNameValuePair("sdk", mp.c()));
        a.add(new BasicNameValuePair("dpi", mp.g(paramContext)));
        a.add(new BasicNameValuePair("sv", "1.0.4.1"));
        a.add(new BasicNameValuePair("svn", "HW-1.0.4.1"));
        a.add(new BasicNameValuePair("pkg", mp.a(paramContext)));
        int i = mp.e(paramContext);
        a.add(new BasicNameValuePair("v", String.valueOf(i)));
        a.add(new BasicNameValuePair("vn", mp.d(paramContext)));
        localObject = np.a(paramContext);
        if (!TextUtils.isEmpty((CharSequence)localObject))
          a.add(new BasicNameValuePair("tk", (String)localObject));
        b = true;
      }
    }
    finally
    {
    }
    Object localObject = ms.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
    if (localObject == null)
    {
      mv.c("GMS", "isGooglePlayServicesAvailable = null");
      localObject = null;
    }
    while (true)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
        localArrayList.add(new BasicNameValuePair("goid", (String)localObject));
      localArrayList.add(new BasicNameValuePair("locale", mp.h(paramContext)));
      localArrayList.add(new BasicNameValuePair("ntt", mp.i(paramContext)));
      localArrayList.add(new BasicNameValuePair("ls", paramString));
      paramContext = a(paramContext);
      if (!TextUtils.isEmpty(paramContext))
        localArrayList.add(new BasicNameValuePair("aid", paramContext));
      return localArrayList;
      localObject = ms.a(null, (Method)localObject, new Object[] { paramContext });
      if ((localObject == null) || (((Integer)localObject).intValue() != 0))
      {
        mv.c("GMS", "CONNECTION_RESULT_SUCCESS =  " + localObject);
        localObject = null;
      }
      else
      {
        localObject = ms.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
        if (localObject == null)
        {
          mv.c("GMS", "getAdvertisingIdInfo =  null");
          localObject = null;
        }
        else
        {
          localObject = ms.a(null, (Method)localObject, new Object[] { paramContext });
          if (localObject == null)
          {
            mv.c("GMS", "advertisingInfo =  null");
            localObject = null;
          }
          else
          {
            Method localMethod1 = ms.a(localObject.getClass(), "getId", new Class[0]);
            Method localMethod2 = ms.a(localObject.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if ((localMethod1 == null) || (localMethod2 == null))
            {
              mv.c("GMS", "getId =  null or isLimitAdTrackingEnabled = null");
              localObject = null;
            }
            else
            {
              localObject = (String)ms.a(localObject, localMethod1, new Object[0]);
            }
          }
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mu
 * JD-Core Version:    0.6.2
 */