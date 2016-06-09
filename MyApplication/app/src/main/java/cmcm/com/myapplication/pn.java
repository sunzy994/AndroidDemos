package cmcm.com.myapplication;

import android.app.Activity;
import android.widget.RelativeLayout;

public class pn
{
  public static final boolean a = qj.a;
  public static int b = 3600000;
  protected static Activity c;
  protected static String d;
  protected static RelativeLayout e;
  protected static RelativeLayout f;
  protected static RelativeLayout g;
  protected static pr h;
  protected static pt i;
  protected static pq j;

  public static pq a()
  {
    return j;
  }

  public static void a(Activity paramActivity, String paramString, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3)
  {
    try
    {
      po.a(new Runnable() {
        public void run() {
          ps.a();
        }
      });
      c = paramActivity;
      d = paramString;
      e = paramRelativeLayout1;
      f = paramRelativeLayout2;
      g = paramRelativeLayout3;
      po.a("mAppId", d);
      po.a(paramActivity, new pz() {
        public void a(Object paramAnonymousObject) {
          po.a();
        }
      });
      return;
    }
    catch (Throwable paramActivity)
    {
      po.a("GameAdSdk.init", paramActivity);
    }
  }

  public static void a(pq parampq)
  {
    j = parampq;
  }

  public static void a(pr parampr)
  {
    h = parampr;
  }

  public static void a(pt parampt)
  {
    i = parampt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     pn
 * JD-Core Version:    0.6.2
 */