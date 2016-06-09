package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class aqu
{
  public static final Set<String> a = new HashSet();

  public static void a(ClassLoader paramClassLoader)
  {
    arp.a(arp.c(SwipeApplication.c().getBaseContext(), "mPackageInfo"), "mClassLoader", paramClassLoader);
  }

  public static boolean a(final Context paramContext, final aqv paramaqv, final Handler paramHandler, final int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a.contains(paramaqv.b(paramContext)))
      bool1 = true;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      }
      while (!arl.i(paramContext));
      bool1 = bool2;
    }
    while (!paramaqv.a(paramContext));
    if (paramHandler == null);
    for (final Handler localHandler = new Handler(); ; localHandler = paramHandler)
    {
      a.add(paramaqv.b(paramContext));
      final File localFile = paramaqv.f(paramContext);
      new Thread()
      {
        public void run()
        {
          String str1 = new arb(aqu.this).a(paramaqv.c(aqu.this), null);
          Log.d("Swipe.SdkDownloadUtils", "info result:" + str1);
          if (TextUtils.isEmpty(str1))
          {
            aqu.a.remove(paramaqv.b(aqu.this));
            return;
          }
          final String str2;
          final String str3;
          try
          {
            JSONObject localJSONObject = new JSONObject(str1);
            str2 = localJSONObject.optString("url");
            str3 = localJSONObject.optString("checksum");
            int i = localJSONObject.optInt("version", 1);
            if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (i != paramaqv.a()))
            {
              aqu.a.remove(paramaqv.b(aqu.this));
              return;
            }
          }
          catch (Exception localException)
          {
            Log.e("Swipe.SdkDownloadUtils", "Error:" + str1, localException);
            aqu.a.remove(paramaqv.b(aqu.this));
            return;
          }
          localHandler.post(new Runnable()
          {
            public void run()
            {
              atc localatc = new atc(aqu.this, null, aqu.2.this.d, str2, str3, new asz(), aqu.2.this.e);
              localatc.a(true);
              localatc.a();
            }
          });
        }
      }
      .start();
      return true;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqu
 * JD-Core Version:    0.6.2
 */