package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;

public class afu
{
  public static void a()
  {
    aru.a(SwipeApplication.c(), "POP_TIME_HAS_EVER_MODIFY_BLACK_LIST", true);
  }

  public static void a(String paramString)
  {
    final SwipeApplication localSwipeApplication = SwipeApplication.c();
    if (aru.b(localSwipeApplication, "POP_TIME_HAS_EVER_MODIFY_BLACK_LIST", false));
    while ((c(paramString)) || (!aft.g(paramString)))
      return;
    b(paramString);
    wk localwk = SwipeApplication.c().a().a(paramString);
    paramString = "";
    if (localwk != null)
      paramString = localwk.b.toString();
    new auy(localSwipeApplication).a(localSwipeApplication.getResources().getDrawable(2130903040)).a(2131230901, paramString, new ForegroundColorSpan(-14441234), 33).a(localSwipeApplication.getString(17039370), new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Toast.makeText(afu.this, 2131230903, 1).show();
      }
    }).b(localSwipeApplication.getString(17039360), new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((afu.this != null) && (afu.this.i != null))
          aft.c(afu.this.i.getPackageName());
        afu.a(localSwipeApplication);
        Toast.makeText(localSwipeApplication, 2131230902, 1).show();
      }
    }).b();
  }

  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("operation", 9);
    SwipeService.a(paramContext, localBundle);
  }

  private static void b(String paramString)
  {
    paramString = d(paramString);
    aru.a(SwipeApplication.c(), paramString, true);
  }

  private static boolean c(String paramString)
  {
    paramString = d(paramString);
    return aru.b(SwipeApplication.c(), paramString, false);
  }

  private static String d(String paramString)
  {
    if (paramString == null)
      return "HAS_EVER_SHOWN_TOP_PACKAGE_PREFIX_";
    return "HAS_EVER_SHOWN_TOP_PACKAGE_PREFIX_" + paramString.replace(".", "_");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afu
 * JD-Core Version:    0.6.2
 */