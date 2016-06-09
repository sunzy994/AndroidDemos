package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nm
{
  private static final String a = nm.class.getSimpleName();
  private static nm b;
  private Map c;
  private Context d;

  private nm(Context paramContext)
  {
    this.d = paramContext;
    this.c = new HashMap();
  }

  public static String a()
  {
    return mn.c().b();
  }

  public static nm a(Context paramContext)
  {
    try
    {
      if (b == null)
        b = new nm(paramContext.getApplicationContext());
      paramContext = b;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public final List a(int paramInt)
  {
    return (List)this.c.get(Integer.valueOf(paramInt));
  }

  public final void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
        break label44;
      throw new IllegalArgumentException("pidsJson cannot be null");
    }
    catch (JSONException paramString)
    {
      mv.d(a, "JSON parse Exception :" + paramString.getMessage());
    }
    return;
    label44: paramString = new JSONArray(paramString);
    int k = paramString.length();
    int i = 0;
    label62: Object localObject;
    int m;
    ArrayList localArrayList;
    int n;
    int j;
    if (i < k)
    {
      localObject = paramString.getJSONObject(i);
      m = ((JSONObject)localObject).optInt("pid");
      localArrayList = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("fbids");
      n = ((JSONArray)localObject).length();
      j = 0;
    }
    while (true)
    {
      if (j < n)
      {
        String str = ((JSONArray)localObject).optString(j);
        if (!TextUtils.isEmpty(str))
          localArrayList.add(str);
      }
      else
      {
        this.c.put(Integer.valueOf(m), localArrayList);
        i += 1;
        break label62;
        break;
      }
      j += 1;
    }
  }

  public final List b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.c.keySet());
    return localArrayList;
  }

  public final String c()
  {
    return na.i(this.d);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nm
 * JD-Core Version:    0.6.2
 */