package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ahx
{
  protected static ahw a;
  private static final String b = "Swipe." + ahx.class.getSimpleName();
  private static ahw c;

  public static ahw a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, c(paramContext));
  }

  public static ahw a(Context paramContext, String paramString, ahw paramahw)
  {
    Object localObject = ahq.a(paramContext, paramString);
    if (localObject != null)
      paramahw = (ahw)localObject;
    do
    {
      return paramahw;
      localObject = aia.a(paramContext, paramString);
      if (localObject != null)
        return localObject;
      localObject = aho.a(paramContext, paramString);
      if (localObject != null)
        return localObject;
      paramContext = ahz.a(paramContext, paramString);
    }
    while (paramContext == null);
    return paramContext;
  }

  public static ahw a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    ahq localahq = ahq.a(paramContext, paramString1);
    if (localahq != null)
      return localahq;
    if (paramString1.startsWith("com.hola.launcher.theme."))
      return new aho(paramContext, paramString1, paramString2);
    if (paramString1.startsWith("zip_com.hola.launcher.theme."))
      return new ahz(paramContext, paramString1, paramString2, paramString3);
    if (!TextUtils.isEmpty(paramString3))
      return new aia(paramContext, paramString1, paramString2, paramString3);
    return new aia(paramContext, paramString1, paramString2);
  }

  public static String a(Context paramContext)
  {
    String str = vs.a(paramContext, "pref_theme_key", "");
    if (!TextUtils.isEmpty(str))
      return str;
    a = null;
    vs.b(paramContext, "pref_theme_key", "purple");
    return "purple";
  }

  public static ahw b(Context paramContext)
  {
    String str = a(paramContext);
    if (a == null)
    {
      a = a(paramContext, str);
      return a;
    }
    if (a.g.equals(str))
      return a;
    a = a(paramContext, str);
    return a;
  }

  public static ahw c(Context paramContext)
  {
    if (c == null)
      c = new aht(paramContext, "purple", paramContext.getString(2131230937), 2131427380);
    return c;
  }

  public static void d(Context paramContext)
  {
    String str2 = a(paramContext);
    String str1;
    if (aiu.i(paramContext))
    {
      str1 = "";
      aiu.j(paramContext);
    }
    while (true)
    {
      List localList = e(paramContext);
      while (str1.equals(str2))
        str1 = ((ahw)localList.get(ari.c(0, localList.size()))).g;
      SwipeService.a(paramContext, str1, false);
      return;
      str1 = str2;
    }
  }

  public static List<ahw> e(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ahq.a(paramContext).iterator();
    while (localIterator.hasNext())
      localArrayList.add((ahw)localIterator.next());
    localIterator = aia.a(paramContext).iterator();
    while (localIterator.hasNext())
      localArrayList.add((ahw)localIterator.next());
    localIterator = aho.a(paramContext).iterator();
    while (localIterator.hasNext())
      localArrayList.add((ahw)localIterator.next());
    paramContext = ahz.a(paramContext).iterator();
    while (paramContext.hasNext())
      localArrayList.add((ahw)paramContext.next());
    Collections.sort(localArrayList, new Comparator()
    {
      public int a(ahw paramAnonymousahw1, ahw paramAnonymousahw2)
      {
        if (paramAnonymousahw1.f() > paramAnonymousahw2.f())
          return -1;
        if (paramAnonymousahw1 == paramAnonymousahw2)
          return 0;
        return 1;
      }
    });
    Log.i(b, "initThemes() " + asq.b(localArrayList));
    return localArrayList;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahx
 * JD-Core Version:    0.6.2
 */