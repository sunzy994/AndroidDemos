package cmcm.com.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.features.weather.bean.City;
import org.json.JSONException;
import org.json.JSONObject;

public class aka extends AsyncTask<String, Void, aks>
{
  private final Context a;
  private final boolean b;
  private boolean c = false;
  private final City d;
  private int e;
  private final akb f;

  public aka(Context paramContext, City paramCity, boolean paramBoolean, akb paramakb)
  {
    this.a = paramContext;
    this.d = paramCity;
    this.b = paramBoolean;
    this.f = paramakb;
  }

  private aks a(String paramString, City paramCity)
  {
    paramString = new arb(this.a).a(paramString, null);
    if (TextUtils.isEmpty(paramString))
      throw new akg(2);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("statusCode", -1) == 200)
      {
        if (paramString.optJSONObject("liveWeatherInfo") == null)
          return null;
        paramString = b(aks.a(paramString.optJSONObject("liveWeatherInfo")));
        akd.a(this.a, paramCity, paramString.a().toString());
        akd.b(this.a, System.currentTimeMillis());
        return paramString;
      }
    }
    catch (IllegalStateException paramString)
    {
      throw new akg(5);
    }
    catch (JSONException paramString)
    {
      throw new akg(7);
    }
    return null;
  }

  private aks b(aks paramaks)
  {
    try
    {
      aks localaks1 = aks.a(akd.c(this.a, paramaks.b));
      aks localaks2 = paramaks;
      if (localaks1 != null)
      {
        localaks1.a(paramaks);
        localaks2 = localaks1;
      }
      return localaks2;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.w("Swipe.RTWUTask", "get oldRWeatherCondition error" + localException);
        Object localObject = null;
      }
    }
  }

  public aks a(Context paramContext, City paramCity)
  {
    if (paramCity == null);
    while (true)
    {
      return null;
      if (!arl.i(paramContext))
        throw new akg(1);
      paramContext = akc.a(paramContext, paramCity.b(), true);
      int i = 0;
      while (i < 4)
      {
        i += 1;
        aks localaks = a(paramContext, paramCity);
        if (localaks != null)
          return localaks;
        long l = i * 1000;
        try
        {
          Thread.sleep(l);
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
    }
  }

  protected aks a(String[] paramArrayOfString)
  {
    try
    {
      if (this.d == null)
        return null;
      paramArrayOfString = a(this.a, this.d);
      return paramArrayOfString;
    }
    catch (akg paramArrayOfString)
    {
      this.e = paramArrayOfString.a();
      if (paramArrayOfString.getMessage() != null)
        Log.e("Swipe.RTWUTask", paramArrayOfString.getMessage());
      this.c = true;
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      while (true)
      {
        this.e = -1;
        Log.e("Swipe.RTWUTask", "update weather exception", paramArrayOfString);
      }
    }
  }

  public void a()
  {
    super.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }

  protected void a(aks paramaks)
  {
    int j = 2131230809;
    int i;
    if ((paramaks == null) && (this.c))
    {
      i = j;
      switch (this.e)
      {
      default:
        i = j;
      case -1:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
    }
    while (true)
    {
      if (this.f != null)
        this.f.a(paramaks, this.c, i, this.b);
      return;
      i = 2131230800;
      continue;
      i = 2131230806;
      continue;
      i = 2131230807;
      continue;
      i = 2131230801;
      continue;
      i = 2131230805;
      continue;
      i = 2131230803;
      continue;
      i = 2131230802;
      continue;
      i = 2131230804;
      continue;
      i = 0;
    }
  }

  protected void onPreExecute()
  {
    if (this.f != null)
      this.f.a(this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aka
 * JD-Core Version:    0.6.2
 */