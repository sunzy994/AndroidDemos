package cmcm.com.myapplication.com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private JSONObject a = new JSONObject();

  public c()
  {
  }

  public c(String paramString)
  {
    this();
    GDTLogger.d("Initialize GDTSDKSetting,Json=" + paramString);
    if (!StringUtil.isEmpty(paramString));
    try
    {
      this.a = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      GDTLogger.report("Exception while building GDTSDKSetting from json", paramString);
    }
  }

  final Object a(String paramString)
  {
    return this.a.opt(paramString);
  }

  final void a(String paramString, Object paramObject)
  {
    try
    {
      this.a.putOpt(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      GDTLogger.e("Exception while update setting", paramString);
    }
  }

  public String toString()
  {
    return "GDTSDKSetting[" + this.a.toString() + "]";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.setting.c
 * JD-Core Version:    0.6.2
 */