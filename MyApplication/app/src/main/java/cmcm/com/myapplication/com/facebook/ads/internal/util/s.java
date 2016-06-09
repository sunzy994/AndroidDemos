package cmcm.com.myapplication.com.facebook.ads.internal.util;

import java.util.Iterator;
import java.util.Set;

public class s
{
  public static String a(Set<String> paramSet, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localStringBuilder.append((String)paramSet.next());
      localStringBuilder.append(paramString);
    }
    if (localStringBuilder.length() > 0)
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    return "";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.util.s
 * JD-Core Version:    0.6.2
 */