package cmcm.com.myapplication;

import org.json.JSONException;

public class wa extends wb
{
  wa(String paramString)
  {
    super(paramString);
  }

  public boolean a()
  {
    return e() == 200;
  }

  public String b()
  {
    try
    {
      String str = getString("userId");
      return str;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return null;
  }

  public long c()
  {
    try
    {
      long l = getLong("createTime");
      return l;
    }
    catch (JSONException localJSONException)
    {
      a(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(), localJSONException);
    }
    return -1L;
  }

  public String toString()
  {
    return super.toString() + ";" + "userId" + "=" + b() + ";" + "createTime" + "=" + c();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wa
 * JD-Core Version:    0.6.2
 */