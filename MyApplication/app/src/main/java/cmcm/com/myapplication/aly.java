package cmcm.com.myapplication;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aly
  implements OnSharedPreferenceChangeListener
{
  private static final String a = "Swipe." + aly.class.getSimpleName();
  private static Map<String, aly> b = new HashMap();
  private String c;
  private Set<String> d = new HashSet();

  private aly(String paramString)
  {
    this.c = paramString;
    aru.a(SwipeApplication.c()).registerOnSharedPreferenceChangeListener(this);
    c();
  }

  public static aly a(String paramString)
  {
    if (b.containsKey(paramString))
      return (aly)b.get(paramString);
    aly localaly = new aly(paramString);
    b.put(paramString, localaly);
    return localaly;
  }

  public static void a(String paramString, Set<String> paramSet)
  {
    if (paramSet == null)
      return;
    Object localObject = new HashSet(paramSet);
    paramSet = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (paramSet.length() != 0)
        paramSet.append(",");
      paramSet.append(str);
    }
    aru.b(SwipeApplication.c(), paramString, paramSet.toString());
  }

  public static Set<String> c(String paramString)
  {
    HashSet localHashSet = new HashSet();
    paramString = aru.a(SwipeApplication.c(), paramString, "");
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if (paramString == null);
    }
    try
    {
      localHashSet.addAll(Arrays.asList(paramString));
      return localHashSet;
    }
    catch (Throwable paramString)
    {
    }
    return localHashSet;
  }

  private void c()
  {
    this.d = c(this.c);
  }

  public Set<String> a()
  {
    return this.d;
  }

  public void a(Collection<String> paramCollection)
  {
    this.d = new HashSet(paramCollection);
    a(this.c, this.d);
  }

  public int b()
  {
    return this.d.size();
  }

  public boolean b(String paramString)
  {
    return this.d.contains(paramString);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (!this.c.equals(paramString))
      return;
    c();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aly
 * JD-Core Version:    0.6.2
 */