package cmcm.com.myapplication.com.flurry.sdk;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cz
{
  private static final String a = cz.class.getSimpleName();

  public Map<String, List<String>> a(String paramString)
  {
    el.a(3, a, "Parsing referrer map");
    if (paramString == null)
      return Collections.emptyMap();
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramString.split("&");
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i].split("=");
      if (localObject2.length != 2)
        el.a(5, a, "Invalid referrer Element: " + localObject1[i] + " in referrer tag " + paramString);
      while (true)
      {
        i += 1;
        break;
        String str = URLDecoder.decode(localObject2[0]);
        localObject2 = URLDecoder.decode(localObject2[1]);
        if (localHashMap.get(str) == null)
          localHashMap.put(str, new ArrayList());
        ((List)localHashMap.get(str)).add(localObject2);
      }
    }
    paramString = localHashMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      localObject1 = (Entry)paramString.next();
      el.a(3, a, "entry: " + (String)((Entry)localObject1).getKey() + "=" + ((Entry)localObject1).getValue());
    }
    paramString = new StringBuilder();
    if (localHashMap.get("utm_source") == null)
      paramString.append("Campaign Source is missing.\n");
    if (localHashMap.get("utm_medium") == null)
      paramString.append("Campaign Medium is missing.\n");
    if (localHashMap.get("utm_campaign") == null)
      paramString.append("Campaign Name is missing.\n");
    if (paramString.length() > 0)
      el.a(5, a, "Detected missing referrer keys : " + paramString.toString());
    return localHashMap;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.cz
 * JD-Core Version:    0.6.2
 */