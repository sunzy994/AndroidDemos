package cmcm.com.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class wb extends JSONObject
{
  wb(String paramString)
  {
    super(paramString);
  }

  public void a(String paramString1, String paramString2, JSONException paramJSONException)
  {
    asp.b("Swipe.ApiResult", "Execution of " + paramString1 + "." + paramString2 + "() failed: " + paramJSONException.getMessage());
  }

  public boolean d()
  {
    try
    {
      boolean bool = getBoolean("success");
      return bool;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return false;
  }

  public int e()
  {
    try
    {
      int i = getInt("statusCode");
      return i;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return -1;
  }

  public String f()
  {
    try
    {
      String str = getString("message");
      return str;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return null;
  }

  public String toString()
  {
    return "success=" + d() + ";" + "statusCode" + "=" + e() + ";" + "message" + "=" + f();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wb
 * JD-Core Version:    0.6.2
 */