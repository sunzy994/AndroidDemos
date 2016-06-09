package com.oppo.statistics.agent;

import android.content.Context;
import com.oppo.statistics.data.CommonBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.util.LogUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class CommonAgent
{
  public static JSONObject getCommonObject(Map<String, String> paramMap)
  {
    Object localObject;
    if ((paramMap == null) || (paramMap.isEmpty()))
      localObject = new JSONObject();
    JSONObject localJSONObject;
    while (true)
    {
      return localObject;
      localJSONObject = new JSONObject();
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (true)
        {
          localObject = localJSONObject;
          if (!localIterator.hasNext())
            break;
          localObject = (String)localIterator.next();
          localJSONObject.put((String)localObject, paramMap.get(localObject));
        }
      }
      catch (Exception paramMap)
      {
        LogUtil.e("NearMeStatistics", paramMap);
      }
    }
    return localJSONObject;
  }

  public static void recordCommon(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    RecordHandler.addTask(paramContext, new CommonBean(paramString, getCommonObject(paramMap).toString()));
  }

  public static void recordCommon(Context paramContext, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    RecordHandler.addTask(paramContext, new CommonBean(paramString, getCommonObject(paramMap).toString(), paramBoolean));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.CommonAgent
 * JD-Core Version:    0.6.2
 */