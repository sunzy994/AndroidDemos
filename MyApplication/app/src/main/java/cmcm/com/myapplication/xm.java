package cmcm.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.lazyswipe.SwipeApplication;
import java.util.List;
import java.util.Map;

public class xm
{
  public static final Uri a = Uri.parse("content://com.lazyswipe/public_pref");

  public static int a(Context paramContext, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramUri = paramUri.getPathSegments();
      if (paramUri.size() < 2)
        return 0;
      if ("theme".equals((String)paramUri.get(1)))
      {
        aib.a(paramContext, (String)paramContentValues.get("code"));
        return 1;
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
    }
    return 0;
  }

  public static Cursor a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    while (true)
    {
      try
      {
        paramUri = paramUri.getPathSegments();
        if (paramUri.size() < 2)
          return null;
        paramUri = (String)paramUri.get(1);
        if ("is_lazy_enabled".equals(paramUri))
        {
          if (a(paramString))
          {
            paramContext = "1";
            return new xn(paramContext);
          }
        }
        else
        {
          if ("is_clean_float_enabled".equals(paramUri))
          {
            if (!acw.b(paramContext))
              break label116;
            paramContext = "1";
            return new xn(paramContext);
          }
          if ("theme".equals(paramUri))
          {
            paramContext = new xn("1");
            return paramContext;
          }
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        return null;
      }
      paramContext = "0";
      continue;
      label116: paramContext = "0";
    }
  }

  private static boolean a(String paramString)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (!vs.H(localSwipeApplication));
    int i;
    do
    {
      do
        return false;
      while (vs.d(localSwipeApplication) == 1);
      paramString = (String)asq.h(paramString).get("isLeft");
      if ("0".equals(paramString))
      {
        i = vs.A(localSwipeApplication);
        if ((2 == (i & 0x2)) || (8 == (i & 0x8)));
        for (boolean bool = true; ; bool = false)
          return bool;
      }
      if (!"1".equals(paramString))
        break;
      i = vs.A(localSwipeApplication);
    }
    while ((1 != (i & 0x1)) && (4 != (i & 0x4)));
    return true;
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xm
 * JD-Core Version:    0.6.2
 */