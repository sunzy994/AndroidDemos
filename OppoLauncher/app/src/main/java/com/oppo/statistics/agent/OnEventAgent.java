package com.oppo.statistics.agent;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.statistics.data.AppLogBean;
import com.oppo.statistics.data.DynamicEventBean;
import com.oppo.statistics.data.StaticEventBean;
import com.oppo.statistics.record.RecordHandler;
import com.oppo.statistics.storage.PreferenceHandler;
import com.oppo.statistics.util.LogUtil;
import com.oppo.statistics.util.TimeInfoUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class OnEventAgent
{
  public static JSONObject getDynamicEventObject(int paramInt, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("statID", paramInt);
      localJSONObject.put("clientTime", paramString);
      getDynamicInfo(localJSONObject, paramMap1);
      getKVEventInfo(localJSONObject, paramMap2);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      LogUtil.e("NearMeStatistics", paramString);
    }
    return localJSONObject;
  }

  private static void getDynamicInfo(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0));
    while (true)
    {
      return;
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramMap.get(str));
        }
      }
      catch (Exception paramJSONObject)
      {
        LogUtil.e("NearMeStatistics", paramJSONObject);
      }
    }
  }

  public static JSONObject getEventObject(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("eventID", paramString1);
      localJSONObject.put("eventCount", paramInt);
      localJSONObject.put("eventTime", paramString3);
      if (!TextUtils.isEmpty(paramString2))
        localJSONObject.put("eventTag", paramString2);
      if (paramLong != 0L)
        localJSONObject.put("duration", paramLong);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      LogUtil.e("NearMeStatistics", paramString1);
    }
    return localJSONObject;
  }

  private static void getKVEventInfo(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
      return;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
      }
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.e("NearMeStatistics", paramJSONObject);
      return;
    }
    paramMap = localJSONObject.toString().replaceAll("\"", "");
    paramJSONObject.put("eventInfo", paramMap.substring(1, paramMap.length() - 1));
  }

  public static JSONObject getKVEventObject(String paramString1, Map<String, String> paramMap, String paramString2, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("eventID", paramString1);
      localJSONObject.put("eventTime", paramString2);
      if (paramLong > 0L)
        localJSONObject.put("duration", paramLong);
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          localJSONObject.put(paramString2, paramMap.get(paramString2));
        }
      }
    }
    catch (Exception paramString1)
    {
      LogUtil.e("NearMeStatistics", paramString1);
    }
    return localJSONObject;
  }

  public static JSONObject getStaticLogObject(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("statID", paramInt);
      localJSONObject.put("clientTime", paramString1);
      localJSONObject.put("setID", paramString2);
      localJSONObject.put("setValue", paramString3);
      if (!TextUtils.isEmpty(paramString4))
        localJSONObject.put("remark", paramString4);
      getKVEventInfo(localJSONObject, paramMap);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      LogUtil.e("NearMeStatistics", paramString1);
    }
    return localJSONObject;
  }

  public static void onDynamicEvent(Context paramContext, int paramInt1, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    recordDynamicEvent(paramContext, paramInt1, paramInt2, TimeInfoUtil.getFormatTime(), paramMap1, paramMap2);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    recordEvent(paramContext, paramString1, paramString2, paramInt, TimeInfoUtil.getFormatTime(), paramLong);
  }

  public static void onEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    recordEventEnd(paramContext, paramString1, paramString2, TimeInfoUtil.getCurrentTime());
  }

  public static void onEventStart(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceHandler.setEventStart(paramContext, paramString1, paramString2, TimeInfoUtil.getCurrentTime());
  }

  public static void onKVEvent(Context paramContext, String paramString, Map<String, String> paramMap, long paramLong)
  {
    recordKVEvent(paramContext, paramString, paramMap, TimeInfoUtil.getFormatTime(), paramLong);
  }

  public static void onKVEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    recordKVEventEnd(paramContext, paramString1, paramString2, TimeInfoUtil.getCurrentTime());
  }

  public static void onKVEventStart(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    long l = TimeInfoUtil.getCurrentTime();
    PreferenceHandler.setKVEventStart(paramContext, paramString1, getKVEventObject(paramString1, paramMap, TimeInfoUtil.getFormatTime(l), l).toString(), paramString2);
  }

  public static void onStaticEvent(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    recordStaticLog(paramContext, paramInt1, paramInt2, TimeInfoUtil.getFormatTime(), paramString1, paramString2, paramString3, paramMap);
  }

  private static void recordAppLog(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    RecordHandler.addTask(paramContext, new AppLogBean(paramString, paramJSONObject.toString()));
  }

  public static void recordDynamicEvent(Context paramContext, int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    recordDynamicEventLog(paramContext, paramInt1, getDynamicEventObject(paramInt2, paramString, paramMap1, paramMap2));
  }

  private static void recordDynamicEventLog(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    RecordHandler.addTask(paramContext, new DynamicEventBean(paramInt, paramJSONObject.toString()));
  }

  public static void recordEvent(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    recordAppLog(paramContext, "event", getEventObject(paramString1, paramString2, paramInt, paramString3, paramLong));
  }

  public static void recordEventEnd(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l = PreferenceHandler.getEventStart(paramContext, paramString1, paramString2);
      String str = TimeInfoUtil.getFormatTime(l);
      paramLong -= l;
      if ((paramLong > 604800000L) || (paramLong < 0L))
      {
        PreferenceHandler.setEventStart(paramContext, paramString1, paramString2, 0L);
        return;
      }
      recordAppLog(paramContext, "event", getEventObject(paramString1, paramString2, 1, str, paramLong));
      PreferenceHandler.setEventStart(paramContext, paramString1, paramString2, 0L);
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NearMeStatistics", paramContext);
    }
  }

  public static void recordKVEvent(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, long paramLong)
  {
    recordAppLog(paramContext, "ekv", getKVEventObject(paramString1, paramMap, paramString2, paramLong));
  }

  public static void recordKVEventEnd(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      Object localObject = PreferenceHandler.getKVEventStart(paramContext, paramString1, paramString2);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        try
        {
          paramLong -= ((JSONObject)localObject).getLong("duration");
          if ((paramLong > 604800000L) || (paramLong < 0L))
          {
            PreferenceHandler.setKVEventStart(paramContext, paramString1, "", paramString2);
            return;
          }
          ((JSONObject)localObject).put("duration", paramLong);
          recordAppLog(paramContext, "ekv", (JSONObject)localObject);
          PreferenceHandler.setKVEventStart(paramContext, paramString1, "", paramString2);
          return;
        }
        catch (Exception paramContext)
        {
          label87: LogUtil.e("NearMeStatistics", paramContext);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      break label87;
    }
  }

  public static void recordStaticLog(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    recordStaticLog(paramContext, paramInt1, getStaticLogObject(paramInt2, paramString1, paramString2, paramString3, paramString4, paramMap));
  }

  private static void recordStaticLog(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    RecordHandler.addTask(paramContext, new StaticEventBean(paramInt, paramJSONObject.toString()));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.agent.OnEventAgent
 * JD-Core Version:    0.6.2
 */