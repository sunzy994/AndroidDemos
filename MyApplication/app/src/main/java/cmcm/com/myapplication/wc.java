package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class wc extends wb
{
  wc(String paramString)
  {
    super(paramString);
  }

  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = asq.d(paramContext, paramString);
    return (paramContext == null) || ((paramInt > 0) && (paramContext.versionCode < paramInt));
  }

  public int a()
  {
    try
    {
      int i = getInt("totalPages");
      return i;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return 0;
  }

  public int a(Context paramContext)
  {
    int i = 0;
    try
    {
      JSONArray localJSONArray = getJSONArray("banners");
      int j = localJSONArray.length();
      if (j <= 0)
        return j;
      arrayOfContentValues = new ContentValues[j];
      if (i < j)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        localContentValues = new ContentValues(localJSONObject.length());
        localContentValues.put("code", localJSONObject.optString("code"));
        localContentValues.put("content", localJSONObject.optString("content"));
        localContentValues.put("useTimeZone", Integer.valueOf(0));
        localContentValues.put("link", localJSONObject.optString("link"));
        localContentValues.put("beginTime", localJSONObject.optString("beginTime"));
        localContentValues.put("endTime", localJSONObject.optString("endTime"));
        localContentValues.put("retrospect", Integer.valueOf(localJSONObject.optInt("retrospect", 0)));
        localContentValues.put("duration", Long.valueOf(localJSONObject.optInt("duration", 0) * 1000L));
        String str = localJSONObject.optString("pkg", "");
        localContentValues.put("pkg", str);
        if (!TextUtils.isEmpty(str))
        {
          int k = asi.a(localJSONObject.optString("appVer", ""), 0);
          localContentValues.put("appVer", Integer.valueOf(k));
          if (!a(paramContext, str, k))
            localContentValues.put("seen", Integer.valueOf(-1));
        }
      }
      else
      {
        i = paramContext.getContentResolver().bulkInsert(xa.a, arrayOfContentValues);
        return i;
      }
    }
    catch (JSONException paramContext)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), paramContext);
      return -1;
    }
    catch (Throwable paramContext)
    {
      while (true)
      {
        ContentValues[] arrayOfContentValues;
        ContentValues localContentValues;
        asp.b("Swipe.ApiResult", "Exception occurred when saving banners: " + paramContext.getMessage());
        continue;
        arrayOfContentValues[i] = localContentValues;
        i += 1;
      }
    }
  }

  public String toString()
  {
    return super.toString() + ";" + "totalPages" + "=" + a();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wc
 * JD-Core Version:    0.6.2
 */