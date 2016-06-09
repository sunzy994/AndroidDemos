package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aap
{
  private static final String a = "Swipe." + aap.class.getSimpleName();

  private static aao a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -176414240:
    case 2095953157:
    case 951526432:
    case -85276959:
    case -1349088399:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (paramString.equals("mostUsed"))
        {
          i = 0;
          continue;
          if (paramString.equals("recentlyUsed"))
          {
            i = 1;
            continue;
            if (paramString.equals("contact"))
            {
              i = 2;
              continue;
              if (paramString.equals("switcher"))
              {
                i = 3;
                continue;
                if (paramString.equals("custom"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return new aal();
    return new aam();
    return new aai();
    return new aan();
    return new aaj();
  }

  public static void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (vs.a(paramContext, "key_tab_mode", 1) == 0)
    {
      localArrayList.add(new aai());
      localArrayList.add(new aam());
    }
    while (true)
    {
      localArrayList.add(new aaj());
      a(paramContext, localArrayList);
      return;
      localArrayList.add(new aam());
      localArrayList.add(new aai());
    }
  }

  public static void a(Context paramContext, int paramInt)
  {
    vs.b(paramContext, "key_tab_mode", paramInt);
    List localList = d(paramContext);
    String str;
    Object localObject;
    if (paramInt == 1)
    {
      str = "recentlyUsed";
      Iterator localIterator = localList.iterator();
      localObject = null;
      label32: if (!localIterator.hasNext())
        break label95;
      aao localaao = (aao)localIterator.next();
      if (!str.equals(localaao.b()))
        break label115;
      localIterator.remove();
      localObject = localaao;
    }
    label95: label115: 
    while (true)
    {
      break label32;
      if (paramInt == 0)
      {
        str = "contact";
        break;
      }
      str = "custom";
      break;
      if (localObject != null)
      {
        localList.add(0, localObject);
        a(paramContext, localList);
      }
      return;
    }
  }

  public static void a(Context paramContext, List<aao> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aao localaao = (aao)paramList.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(",");
      localStringBuilder.append(localaao.b());
    }
    vs.b(paramContext, "tab_order", localStringBuilder.toString());
  }

  public static aao b(Context paramContext)
  {
    paramContext = b(paramContext, 1);
    if (paramContext.isEmpty())
      return new aam();
    return (aao)paramContext.get(0);
  }

  private static ArrayList<aao> b(Context paramContext, int paramInt)
  {
    paramContext = vs.a(paramContext, "tab_order", "");
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = aah.a();
      return paramContext;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.split(",");
    int j = arrayOfString.length;
    int i = 0;
    while (true)
    {
      paramContext = localArrayList;
      if (i >= j)
        break;
      String str = arrayOfString[i];
      paramContext = localArrayList;
      if (localArrayList.size() >= paramInt)
        break;
      localArrayList.add(a(str));
      i += 1;
    }
  }

  public static List<aao> c(Context paramContext)
  {
    if (TextUtils.isEmpty(vs.a(paramContext, "tab_order", "")))
      return aah.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b(paramContext));
    localArrayList.add(new aal());
    localArrayList.add(new aan());
    return localArrayList;
  }

  public static List<aao> d(Context paramContext)
  {
    return b(paramContext, 2147483647);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aap
 * JD-Core Version:    0.6.2
 */