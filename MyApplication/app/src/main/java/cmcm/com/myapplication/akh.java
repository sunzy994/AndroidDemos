package cmcm.com.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.features.weather.bean.City;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import org.json.JSONException;
import org.json.JSONObject;

public class akh extends AsyncTask<String, Void, WeatherCondition>
{
  private final Context a;
  private final boolean b;
  private boolean c = false;
  private final City d;
  private int e;
  private final aki f;

  public akh(Context paramContext, City paramCity, boolean paramBoolean, aki paramaki)
  {
    this.a = paramContext;
    this.d = paramCity;
    this.b = paramBoolean;
    this.f = paramaki;
  }

  private WeatherCondition a(Context paramContext, City paramCity)
  {
    if (paramCity == null)
      return null;
    if (!arl.i(paramContext))
      throw new akg(1);
    return b(paramContext, paramCity);
  }

  private WeatherCondition a(String paramString)
  {
    paramString = new arb(this.a).a(paramString, null);
    if (TextUtils.isEmpty(paramString))
      throw new akg(2);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("statusCode", -1) == 200)
      {
        if (!paramString.optBoolean("success", false))
          return null;
        paramString = WeatherCondition.a(paramString);
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

  private WeatherCondition b(Context paramContext, City paramCity)
  {
    int i = 0;
    paramContext = akc.a(paramContext, paramCity.b(), false);
    while (i < 4)
    {
      i += 1;
      paramCity = a(paramContext);
      if (paramCity != null)
        return paramCity;
      long l = i * 1000;
      try
      {
        Thread.sleep(l);
      }
      catch (InterruptedException paramCity)
      {
      }
    }
    return null;
  }

  protected WeatherCondition a(String[] paramArrayOfString)
  {
    try
    {
      if (this.d == null)
        return null;
      paramArrayOfString = a(this.a, this.d);
      if (paramArrayOfString != null)
      {
        paramArrayOfString = akd.a(this.a, paramArrayOfString.a(), paramArrayOfString);
        akd.a(this.a, paramArrayOfString);
        return paramArrayOfString;
      }
    }
    catch (akg paramArrayOfString)
    {
      this.e = paramArrayOfString.a();
      if (paramArrayOfString.getMessage() != null)
        Log.e("Swipe.WeatherUpdateTask", paramArrayOfString.getMessage());
      this.c = true;
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      while (true)
      {
        this.e = -1;
        Log.e("Swipe.WeatherUpdateTask", "update weather exception", paramArrayOfString);
      }
    }
    return paramArrayOfString;
  }

  public void a()
  {
    super.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }

  protected void a(WeatherCondition paramWeatherCondition)
  {
    int j = 2131230809;
    int i;
    if ((paramWeatherCondition == null) && (this.c))
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
        this.f.a(paramWeatherCondition, this.c, i, this.b);
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
 * Qualified Name:     akh
 * JD-Core Version:    0.6.2
 */