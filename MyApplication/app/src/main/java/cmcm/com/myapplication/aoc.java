package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import java.text.DecimalFormat;

public class aoc extends BroadcastReceiver
{
  private static boolean a;

  public static void a(long paramLong)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Intent localIntent = new Intent("ACTION_BOOST_ANIMATE_FINISH");
    localIntent.putExtra("token", paramLong);
    ci.a(localSwipeApplication).a(localIntent);
  }

  public static void b(long paramLong)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    Intent localIntent = new Intent("ACTION_BOOST_LOGIC_FINISH");
    localIntent.putExtra("token", paramLong);
    ci.a(localSwipeApplication).a(localIntent);
  }

  private static void b(Context paramContext)
  {
    asq.b();
    if (SwipeService.a() == null)
      return;
    SwipeService.a().postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          aoc.a(aoc.this);
          return;
        }
        catch (Exception localException)
        {
          Log.w(aoa.b(), "handleBoostResult failed", localException);
        }
      }
    }
    , 120L);
  }

  private static void c(Context paramContext)
  {
    int i = 1;
    aaq localaaq = aaq.b();
    aqr.a();
    long l1 = aqr.c(paramContext);
    long l2 = l1 - aoa.d();
    float f;
    Object localObject1;
    label56: Object localObject2;
    if (l2 >= l1)
    {
      f = 50.0F;
      int j = Math.round(f);
      if (l2 <= 1073741824L)
        break label255;
      localObject1 = asq.b;
      localObject1 = asq.a(l2, (DecimalFormat) localObject1);
      if ((l2 <= 0L) || (j <= 0))
        break label262;
      localObject2 = Html.fromHtml(String.format(paramContext.getString(2131231073), new Object[] { "<b><font color=\"#00aeff\">" + (String)localObject1 + "</font></b>" }));
      localObject1 = paramContext.getString(2131231074, new Object[] { j + "%" });
      label153: View localView = localaaq.f();
      if (localView == null)
        break label279;
      label165: localObject1 = new auz(paramContext).a((CharSequence)localObject2).b((CharSequence)localObject1).a(localaaq);
      if (i == 0)
        break label285;
      localView.setTag(Boolean.TRUE);
      ((auz)localObject1).a(localView);
      label207: if ((i == 0) && (!aoa.e()))
        break label321;
    }
    label262: label279: label285: label321: for (l1 = 0L; ; l1 = 3000L)
    {
      paramContext = ((auz)localObject1).a(l1);
      if (i != 0)
        localaaq.a(paramContext);
      return;
      f = (float)l2 * 100.0F / (float)aoa.d();
      break;
      label255: localObject1 = asq.c;
      break label56;
      localObject2 = paramContext.getString(2131231075);
      localObject1 = paramContext.getString(2131231076);
      break label153;
      i = 0;
      break label165;
      if (!aoa.e())
        break label207;
      ((auz)localObject1).a(aoa.a(paramContext));
      vs.b(paramContext, "boost_time_1", -1L);
      vs.b(paramContext, "boost_time_2", -1L);
      break label207;
    }
  }

  public void a()
  {
    try
    {
      if (a)
        return;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_BOOST_LOGIC_FINISH");
      localIntentFilter.addAction("ACTION_BOOST_ANIMATE_FINISH");
      ci.a(SwipeApplication.c()).a(this, localIntentFilter);
      a = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    try
    {
      if (!a)
        return;
      ci.a(SwipeApplication.c()).a(this);
      a = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    String str;
    long l;
    do
    {
      return;
      str = paramIntent.getAction();
      l = paramIntent.getLongExtra("token", -1L);
      Log.i(aoa.b(), "onReceive: " + str + ", token = " + l + ", this = " + this);
    }
    while (((!"ACTION_BOOST_LOGIC_FINISH".equals(str)) && (!"ACTION_BOOST_ANIMATE_FINISH".equals(str))) || (l <= 0L) || (aoa.c() <= 0L) || (l != aoa.c()) || (asj.b()) || (aoa.a()));
    b(paramContext);
    aoa.a(-1L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoc
 * JD-Core Version:    0.6.2
 */