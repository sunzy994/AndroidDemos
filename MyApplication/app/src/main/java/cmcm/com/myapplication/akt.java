package cmcm.com.myapplication;

import android.text.TextUtils;
import android.text.format.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class akt
{
  private Date a;
  private final List<aku> b = new ArrayList();

  public static int a(aku paramaku)
  {
    if (paramaku != null)
      return paramaku.b();
    return -1;
  }

  public static akt a(JSONObject paramJSONObject)
  {
    akt localakt = new akt();
    Object localObject = paramJSONObject.optString("datetime");
    if (TextUtils.isEmpty((CharSequence)localObject))
      localObject = null;
    do
    {
      return localObject;
      localakt.a = new Date(Long.parseLong((String)localObject));
      if (paramJSONObject.optInt("daycode", -1) >= 0)
        localakt.b.add(new aku(akv.b, paramJSONObject.optInt("daycode"), paramJSONObject.optInt("high", 0), paramJSONObject.optString("daytext")));
      localObject = localakt;
    }
    while (paramJSONObject.optInt("nightcode", -1) < 0);
    localakt.b.add(new aku(akv.c, paramJSONObject.optInt("nightcode"), paramJSONObject.optInt("low", 0), paramJSONObject.optString("nighttext")));
    return localakt;
  }

  private List<akv> b(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    akv localakv1 = akv.a(paramInt);
    localArrayList.add(localakv1);
    if (!paramBoolean)
    {
      akv localakv2 = akv.a(Math.max(paramInt - 2, 0));
      if (localakv2 != localakv1)
        localArrayList.add(localakv2);
      localakv2 = akv.a(Math.min(2 + paramInt, 23));
      if (localakv2 != localakv1)
        localArrayList.add(localakv2);
    }
    return localArrayList;
  }

  public aku a(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = b(paramInt, paramBoolean).iterator();
    while (localIterator.hasNext())
    {
      akv localakv = (akv)localIterator.next();
      paramInt = 0;
      while (paramInt < this.b.size())
      {
        aku localaku = (aku)this.b.get(paramInt);
        if (localakv == localaku.a())
          return localaku;
        paramInt += 1;
      }
    }
    if (this.b.size() > 0)
      return (aku)this.b.get(0);
    return null;
  }

  public aku a(boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    return a(localTime.hour, paramBoolean);
  }

  public Date a()
  {
    return this.a;
  }

  public void a(akt paramakt)
  {
    if (asq.a(this.a, paramakt.a()) != 0)
      return;
    paramakt = paramakt.b.iterator();
    label25: label108: 
    while (true)
    {
      aku localaku;
      if (paramakt.hasNext())
      {
        localaku = (aku)paramakt.next();
        Iterator localIterator = this.b.iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (((aku)localIterator.next()).a() != localaku.a());
      }
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          break label108;
        this.b.add(localaku);
        break label25;
        break;
      }
    }
  }

  public aku b(boolean paramBoolean)
  {
    return a(12, paramBoolean);
  }

  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("datetime", this.a.getTime());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      aku localaku = (aku)localIterator.next();
      if (aku.a(localaku) == akv.b)
      {
        localJSONObject.put("daycode", aku.b(localaku));
        localJSONObject.put("high", aku.c(localaku));
        localJSONObject.put("daytext", aku.d(localaku));
      }
      else if (aku.a(localaku) == akv.c)
      {
        localJSONObject.put("nightcode", aku.b(localaku));
        localJSONObject.put("low", aku.c(localaku));
        localJSONObject.put("nighttext", aku.d(localaku));
      }
    }
    return localJSONObject;
  }

  public aku c(boolean paramBoolean)
  {
    return a(22, paramBoolean);
  }

  public int[] c()
  {
    Iterator localIterator = this.b.iterator();
    int i = -2147483648;
    int j = 2147483647;
    while (localIterator.hasNext())
    {
      aku localaku = (aku)localIterator.next();
      j = Math.min(j, aku.c(localaku));
      i = Math.max(i, aku.c(localaku));
    }
    if (j != 2147483647)
      return new int[] { j, i };
    return null;
  }

  public boolean d()
  {
    return asq.a(new Date(), a()) == 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akt
 * JD-Core Version:    0.6.2
 */