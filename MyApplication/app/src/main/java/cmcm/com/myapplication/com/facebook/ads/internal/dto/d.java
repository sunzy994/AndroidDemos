package cmcm.com.myapplication.com.facebook.ads.internal.dto;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class d
{
  private static final AdPlacementType k = AdPlacementType.UNKNOWN;
  protected AdPlacementType a = k;
  protected int b = 1;
  protected int c;
  protected int d = 0;
  protected int e = 20;
  protected int f = 0;
  protected int g = 1000;
  protected boolean h = false;
  public int i = -1;
  public int j = -1;

  private d(Map<String, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Entry localEntry = (Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      label188: int m;
      switch (str.hashCode())
      {
      default:
        m = -1;
      case 3575610:
      case 700812481:
      case 664421755:
      case 1085444827:
      case -1561601017:
      case -553208868:
      case 2002133996:
      case 1503616961:
      case 1183549815:
      case -856794442:
      }
      while (true)
        switch (m)
        {
        default:
          break;
        case 0:
          this.a = AdPlacementType.fromString((String)localEntry.getValue());
          break;
          if (!str.equals("type"))
            break label188;
          m = 0;
          continue;
          if (!str.equals("min_viewability_percentage"))
            break label188;
          m = 1;
          continue;
          if (!str.equals("min_viewability_duration"))
            break label188;
          m = 2;
          continue;
          if (!str.equals("refresh"))
            break label188;
          m = 3;
          continue;
          if (!str.equals("refresh_threshold"))
            break label188;
          m = 4;
          continue;
          if (!str.equals("cacheable"))
            break label188;
          m = 5;
          continue;
          if (!str.equals("placement_width"))
            break label188;
          m = 6;
          continue;
          if (!str.equals("placement_height"))
            break label188;
          m = 7;
          continue;
          if (!str.equals("viewability_check_initial_delay"))
            break label188;
          m = 8;
          continue;
          if (!str.equals("viewability_check_interval"))
            break label188;
          m = 9;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        }
      this.b = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.c = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.d = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.e = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.h = Boolean.valueOf((String)localEntry.getValue()).booleanValue();
      continue;
      this.i = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.j = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.f = Integer.parseInt((String)localEntry.getValue());
      continue;
      this.g = Integer.parseInt((String)localEntry.getValue());
    }
  }

  public static d a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    Iterator localIterator = paramJSONObject.keys();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, String.valueOf(paramJSONObject.opt(str)));
    }
    return new d(localHashMap);
  }

  public AdPlacementType a()
  {
    return this.a;
  }

  public long b()
  {
    return this.d * 1000;
  }

  public long c()
  {
    return this.e * 1000;
  }

  public boolean d()
  {
    return this.h;
  }

  public int e()
  {
    return this.b;
  }

  public int f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.dto.d
 * JD-Core Version:    0.6.2
 */