package cmcm.com.myapplication;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class mr
{
  private static boolean a;
  private static String[] b = { "download", "facebook", "inmobi", "online" };

  private static int a(String[] paramArrayOfString, int paramInt, String paramString)
  {
    int i1 = 0;
    int n = 1;
    int i = paramInt;
    if (paramInt <= 0)
      i = 1;
    int k = n;
    int j;
    int m;
    if (i > paramArrayOfString.length - 1)
    {
      j = i;
      if (i > 5)
        j = 5;
      k = 0;
      i = 0;
      paramInt = 0;
      m = i1;
      if (k < paramArrayOfString.length)
      {
        m = i;
        if ("download".equals(paramArrayOfString[k]))
        {
          if (k != 0)
            break label171;
          m = 1;
          paramInt = 1;
        }
      }
    }
    while (true)
    {
      k += 1;
      i = m;
      break;
      do
      {
        m += 1;
        k = n;
        if (m >= paramArrayOfString.length)
          break;
      }
      while (!paramString.equals(paramArrayOfString[m]));
      if ((i == 0) || (m != 1))
      {
        k = n;
        if (i == 0)
        {
          k = n;
          if (m != 0);
        }
      }
      else
      {
        if (paramInt == 0)
          break label163;
        k = j - paramArrayOfString.length + 2;
      }
      return k;
      label163: return j - paramArrayOfString.length + 1;
      label171: paramInt = 1;
      m = i;
    }
  }

  public static ms a(Context paramContext, int paramInt1, int paramInt2, String[] paramArrayOfString, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramContext == null) || (paramArrayOfString == null) || (paramConcurrentHashMap == null))
      return null;
    mv.c("ChannelFactory", "cacheSize==" + paramInt2);
    paramArrayOfString = a(paramArrayOfString, paramContext);
    int i;
    int j;
    if ((a) && (a("facebook", paramArrayOfString)))
    {
      mv.c("ChannelFactory", "create FacebookCacheManager");
      i = a(paramArrayOfString, paramInt2, "facebook");
      mv.c("ChannelFactory", "fbCacheSize==" + i);
      j = na.b(paramContext, paramInt1);
      paramConcurrentHashMap.put("facebook", new lm(paramContext, paramInt1, j, i));
    }
    for (long l2 = j + 0L; ; l2 = 0L)
    {
      long l1 = l2;
      if (a("download", paramArrayOfString))
      {
        mv.c("ChannelFactory", "create DownloadCacheManager");
        i = na.a(paramContext, paramInt1);
        l1 = l2 + i;
        paramConcurrentHashMap.put("download", new nk(paramContext, paramInt1, i));
      }
      l2 = l1;
      if (a("inmobi", paramArrayOfString))
      {
        mv.c("ChannelFactory", "create InMobiCacheManager");
        i = a(paramArrayOfString, paramInt2, "inmobi");
        mv.c("ChannelFactory", "imCacheSize==" + i);
        j = na.c(paramContext, paramInt1);
        l2 = j;
        paramConcurrentHashMap.put("inmobi", new lx(paramContext, paramInt1, j, i));
        l2 = l1 + l2;
      }
      l1 = l2;
      if (a("online", paramArrayOfString))
      {
        mv.c("ChannelFactory", "create ToolboxOLManager");
        paramInt2 = a(paramArrayOfString, paramInt2, "online");
        mv.c("ChannelFactory", "olCacheSize==" + paramInt2);
        i = na.d(paramContext, paramInt1);
        l1 = i;
        paramConcurrentHashMap.put("online", new nn(paramContext, paramInt1, i, paramInt2));
        l1 = l2 + l1;
      }
      return new ms(paramArrayOfString, l1);
    }
  }

  private static boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int i = 0;
    while (true)
    {
      boolean bool1 = bool2;
      if (i < paramArrayOfString.length)
      {
        if (paramString.equals(paramArrayOfString[i]))
          bool1 = true;
      }
      else
        return bool1;
      i += 1;
    }
  }

  private static String[] a(String[] paramArrayOfString, Context paramContext)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = Arrays.asList(b);
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (localList.contains(paramArrayOfString[i]))
      {
        if ((!"facebook".equals(paramArrayOfString[i])) || (!np.a(paramContext, "com.facebook.katana")))
          break label86;
        a = true;
        localArrayList.add(paramArrayOfString[i]);
      }
      while (true)
      {
        i += 1;
        break;
        label86: if (("facebook".equals(paramArrayOfString[i])) && (!np.a(paramContext, "com.facebook.katana")))
          a = false;
        else
          localArrayList.add(paramArrayOfString[i]);
      }
    }
    paramArrayOfString = new String[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramArrayOfString[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    return paramArrayOfString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mr
 * JD-Core Version:    0.6.2
 */