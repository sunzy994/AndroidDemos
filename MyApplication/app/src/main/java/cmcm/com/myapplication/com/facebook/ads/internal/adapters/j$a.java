package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class j$a
{
  Map<String, List<String>> a = new HashMap();

  j$a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
      return;
    int i = 0;
    label23: Object localObject;
    String str;
    if (i < paramJSONArray.length())
    {
      localObject = paramJSONArray.optJSONObject(i);
      str = ((JSONObject)localObject).optString("type");
      if (!r.a(str))
        break label62;
    }
    while (true)
    {
      i += 1;
      break label23;
      break;
      label62: localObject = ((JSONObject)localObject).optJSONArray("urls");
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList(((JSONArray)localObject).length());
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          localArrayList.add(((JSONArray)localObject).optString(j));
          j += 1;
        }
        this.a.put(str, localArrayList);
      }
    }
  }

  void a(String paramString)
  {
    paramString = (List)this.a.get(paramString);
    if ((paramString == null) || (paramString.isEmpty()));
    while (true)
    {
      return;
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        new o().execute(new String[] { str });
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.j.a
 * JD-Core Version:    0.6.2
 */