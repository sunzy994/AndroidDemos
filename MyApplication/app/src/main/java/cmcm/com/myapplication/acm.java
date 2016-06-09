package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.lazyswipe.SwipeApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class acm
{
  private int a = 0;
  private long b;
  private final List<Pair<String, AtomicInteger>> c = new ArrayList();

  public static acm a(Context paramContext)
  {
    int i = 0;
    acm localacm = new acm();
    paramContext = vs.a(paramContext, "pref_fs_clean_info", "");
    if (TextUtils.isEmpty(paramContext));
    while (true)
    {
      return localacm;
      try
      {
        paramContext = new JSONObject(paramContext);
        localacm.a = paramContext.optInt("count");
        localacm.b = paramContext.optLong("time");
        paramContext = paramContext.optJSONArray("list");
        while (i < paramContext.length())
        {
          JSONObject localJSONObject = paramContext.getJSONObject(i);
          String str = localJSONObject.optString("package");
          int j = localJSONObject.optInt("count", 0);
          localacm.c.add(new Pair(str, new AtomicInteger(j)));
          i += 1;
        }
      }
      catch (Exception paramContext)
      {
      }
    }
    return localacm;
  }

  private List<Pair<String, AtomicInteger>> a(Context paramContext, long paramLong)
  {
    paramContext = new HashMap();
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      paramContext.put(((Pair)localObject2).first, localObject2);
    }
    localObject1 = new ArrayList();
    Object localObject2 = SwipeApplication.c().a().a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (wk)((Iterator)localObject2).next();
      String str = ((wk)localObject3).i.getPackageName();
      if (((wk)localObject3).e > paramLong)
      {
        localObject3 = (Pair)paramContext.remove(str);
        if ((localObject3 != null) && (((List)localObject1).contains(localObject3)))
          ((List)localObject1).remove(localObject3);
      }
      else if ((paramContext.containsKey(str)) && (!((List)localObject1).contains(paramContext.get(str))))
      {
        ((List)localObject1).add(paramContext.get(str));
      }
    }
    Collections.sort((List)localObject1, new Comparator()
    {
      public int a(Pair<String, AtomicInteger> paramAnonymousPair1, Pair<String, AtomicInteger> paramAnonymousPair2)
      {
        return ((AtomicInteger)paramAnonymousPair2.second).get() - ((AtomicInteger)paramAnonymousPair1.second).get();
      }
    });
    return localObject1;
  }

  private void b(Context paramContext)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("count", this.a);
      localJSONObject1.put("time", this.b);
      JSONArray localJSONArray = new JSONArray();
      localJSONObject1.put("list", localJSONArray);
      int i = 0;
      while (i < this.c.size())
      {
        Pair localPair = (Pair)this.c.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("package", localPair.first);
        localJSONObject2.put("count", ((AtomicInteger)localPair.second).get());
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      vs.b(paramContext, "pref_fs_clean_info", localJSONObject1.toString());
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public void a(Context paramContext, List<acl> paramList)
  {
    this.a += 1;
    this.b = System.currentTimeMillis();
    paramList = paramList.iterator();
    label156: 
    while (true)
    {
      acl localacl;
      if (paramList.hasNext())
      {
        localacl = (acl)paramList.next();
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if (((String)localPair.first).equals(localacl.a))
            ((AtomicInteger)localPair.second).incrementAndGet();
        }
      }
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          break label156;
        this.c.add(new Pair(localacl.a, new AtomicInteger(1)));
        break;
        b(paramContext);
        return;
      }
    }
  }

  public List<acl> b(Context paramContext, List<acl> paramList)
  {
    if ((this.c == null) || (this.c.size() == 0))
      return new ArrayList();
    Object localObject1 = new ArrayList();
    ((List)localObject1).add("com.holalauncher");
    ((List)localObject1).add("com.qiigame.flocker.global");
    ((List)localObject1).add("com.autumn.privacyace");
    Object localObject2 = a(paramContext, this.b);
    paramContext = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      acl localacl = (acl)paramList.next();
      if (!((List)localObject1).contains(localacl.a))
        paramContext.put(localacl.a, localacl);
    }
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      if (paramContext.containsKey(((Pair)localObject2).first))
        paramList.add(paramContext.remove(((Pair)localObject2).first));
    }
    return paramList;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acm
 * JD-Core Version:    0.6.2
 */