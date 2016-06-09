package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class agt
{
  private static final String a = "Swipe." + agt.class.getSimpleName();

  public static List<ahk> a(Context paramContext, agu paramagu, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = b(paramContext, paramagu, paramString).iterator();
    while (paramContext.hasNext())
      localArrayList.add(new ahk((String)paramContext.next()));
    return localArrayList;
  }

  private static List<String> b(Context paramContext, agu paramagu, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!arl.i(paramContext));
    while (true)
    {
      return localArrayList;
      String str1 = paramString;
      try
      {
        String str2 = URLEncoder.encode(paramString, "UTF-8");
        paramString = str2;
        if (paramagu == null)
        {
          paramagu = null;
          str1 = paramString;
          if (TextUtils.isEmpty(paramagu))
            continue;
          str1 = paramString;
          paramContext = new arb(paramContext).a(paramagu, null);
          str1 = paramString;
          if (TextUtils.isEmpty(paramContext))
            continue;
          str1 = paramString;
          paramContext = new JSONArray(paramContext).getJSONArray(1);
          if (paramContext == null)
            continue;
          int i = 0;
          while (true)
          {
            str1 = paramString;
            if (i >= Math.min(10, paramContext.length()))
              break;
            str1 = paramString;
            localArrayList.add(paramContext.get(i).toString());
            i += 1;
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
        {
          str1 = paramString;
          Log.e(a, localUnsupportedEncodingException.toString());
          str1 = paramString;
          paramString = paramString.replaceAll(" ", "%20");
          continue;
          str1 = paramString;
          paramagu = paramagu.c(paramString);
        }
      }
      catch (Throwable paramContext)
      {
        Log.e(a, "Failed to get the search suggestion for " + str1, paramContext);
      }
    }
    return localArrayList;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agt
 * JD-Core Version:    0.6.2
 */