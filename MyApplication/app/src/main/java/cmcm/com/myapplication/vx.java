package cmcm.com.myapplication;

import android.content.Context;
import android.location.Criteria;
import com.flurry.android.FlurryAgent;
import java.util.Map;

public final class vx extends vv
{
  public static volatile long b;

  protected vx()
  {
    a(false);
  }

  public static void d(Context paramContext)
  {
    if (a != null)
    {
      a.b(paramContext);
      b = System.currentTimeMillis();
    }
  }

  public void a(long paramLong)
  {
    FlurryAgent.setContinueSessionMillis(paramLong);
  }

  public void a(Context paramContext)
  {
    FlurryAgent.onStartSession(paramContext, "MMKWN2F57QCKGDDCWDHG");
  }

  public void a(Criteria paramCriteria)
  {
    FlurryAgent.setLocationCriteria(paramCriteria);
  }

  public void a(String paramString)
  {
    super.a(paramString);
    FlurryAgent.logEvent(paramString);
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    FlurryAgent.logEvent(paramString, paramMap);
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      FlurryAgent.setReportLocation(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void b(Context paramContext)
  {
    FlurryAgent.onEndSession(paramContext);
  }

  public void c(Context paramContext)
  {
    try
    {
      paramContext = new Criteria();
      paramContext.setAccuracy(2);
      paramContext.setAltitudeRequired(false);
      paramContext.setBearingRequired(false);
      paramContext.setPowerRequirement(1);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vx
 * JD-Core Version:    0.6.2
 */