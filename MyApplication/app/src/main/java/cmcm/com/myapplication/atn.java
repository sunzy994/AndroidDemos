package cmcm.com.myapplication;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class atn
{
  private static final Map<String, Boolean> a = new HashMap();

  private static void a(ato paramato, boolean paramBoolean)
  {
    a.put(paramato.c, Boolean.valueOf(paramBoolean));
  }

  public static boolean a(Context paramContext, ato paramato)
  {
    if (paramato == null);
    while ((!arl.i(paramContext)) || (a(paramato)))
      return false;
    if (paramato.a.exists())
      return true;
    a(paramato, true);
    try
    {
      File localFile = paramato.b;
      if (localFile.exists())
        aqx.e(localFile);
      if ((new arb(paramContext).a(paramato.c, null, localFile)) && ((!paramato.d) || (atw.a(localFile))))
      {
        localFile.renameTo(paramato.a);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      Log.e("Swipe.ResDownloadUtils", "download res file error", paramContext);
      return false;
    }
    finally
    {
      a(paramato, false);
    }
    throw paramContext;
  }

  private static boolean a(ato paramato)
  {
    if (a.containsKey(paramato.c))
      return ((Boolean)a.get(paramato.c)).booleanValue();
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atn
 * JD-Core Version:    0.6.2
 */