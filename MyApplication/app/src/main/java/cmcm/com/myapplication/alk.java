package cmcm.com.myapplication;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager.NameNotFoundException;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.FullscreenTipActivity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class alk
{
  private static final String a = "Swipe." + alk.class.getSimpleName();
  private static final Set<String> b = new HashSet();

  static
  {
    String[] arrayOfString = SwipeApplication.c().getString(2131231208).split(",");
    Collections.addAll(b, arrayOfString);
  }

  public static void a(boolean paramBoolean)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (paramBoolean);
    for (int i = 1; i > 7; i = aru.a(localSwipeApplication, "NOTI_GD_NEXT_INTERVAL", 0))
    {
      aru.b(localSwipeApplication, "NOTI_GD_LAST_TIME", -1L);
      return;
    }
    aru.b(localSwipeApplication, "NOTI_GD_LAST_TIME", System.currentTimeMillis() + i * 86400000L);
    aru.b(localSwipeApplication, "NOTI_GD_NEXT_INTERVAL", i + 1);
  }

  private static boolean a()
  {
    long l = aru.a(SwipeApplication.c(), "NOTI_GD_LAST_TIME", -1L);
    return (l > 0L) && (System.currentTimeMillis() > l);
  }

  public static boolean a(String paramString)
  {
    if (!a());
    while ((!c(paramString)) || (e(paramString)) || (alo.d(SwipeApplication.c())))
      return false;
    return true;
  }

  public static void b(String paramString)
  {
    if (!a(paramString))
      return;
    d(paramString);
    a(false);
    g(paramString);
  }

  private static boolean c(String paramString)
  {
    return b.contains(paramString);
  }

  private static void d(String paramString)
  {
    paramString = f(paramString);
    aru.a(SwipeApplication.c(), paramString, true);
  }

  private static boolean e(String paramString)
  {
    paramString = f(paramString);
    return aru.b(SwipeApplication.c(), paramString, false);
  }

  private static String f(String paramString)
  {
    if (paramString == null)
      return "NOTI_GD_SHOW_";
    return "NOTI_GD_SHOW_" + paramString.replace(".", "_");
  }

  private static void g(String paramString)
  {
    Object localObject = null;
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    wk localwk = localSwipeApplication.a().a(paramString);
    String str = "";
    paramString = localObject;
    if (localwk != null)
      str = localwk.b.toString();
    try
    {
      paramString = localwk.a(localSwipeApplication.getPackageManager());
      new auy(localSwipeApplication).a(paramString).b(localSwipeApplication.getString(2131231155, new Object[] { str })).a(localSwipeApplication.getString(17039370), new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          vv.a().a("消息开启引导", "value", "1");
          alo.e(alk.this);
          FullscreenTipActivity.e(alk.this);
        }
      }).b(localSwipeApplication.getString(17039360), new OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          vv.a().a("消息开启引导", "value", "2");
        }
      }).b();
      vv.a().a("消息开启引导", "value", "0");
      return;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      while (true)
        paramString = localObject;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alk
 * JD-Core Version:    0.6.2
 */