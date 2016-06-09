package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.weather.bean.WeatherCondition;
import com.lazyswipe.widget.HighQualityImageView;
import java.util.Calendar;
import java.util.Date;

public class adb extends ake
  implements ws
{
  private static final String e = "Swipe." + adb.class.getSimpleName();
  private static final Object g = new Object();
  aks a;
  private boolean f;

  public static void a(Context paramContext)
  {
    vs.b(paramContext, "key_weather_shown", Calendar.getInstance().get(6));
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
  }

  public static boolean a()
  {
    int i = Calendar.getInstance().get(11);
    return (i >= 8) && (i < 11);
  }

  public static adb b()
  {
    return null;
  }

  public static void b(Context paramContext)
  {
    a(paramContext, false);
  }

  private void o()
  {
    if ((this.a == null) || (p()) || (!wq.e()));
    while ((abd.a()) && ((abd.g == null) || (abd.g.l() == null)))
      return;
    this.b.post(new Runnable()
    {
      public void run()
      {
        SwipeApplication localSwipeApplication = SwipeApplication.c();
        int i = akc.a(localSwipeApplication, adb.this.a.d, false).intValue();
        HighQualityImageView localHighQualityImageView;
        String str;
        if ((2130837566 == i) || (2130837570 == i) || (2130837568 == i) || (2130837571 == i) || (2130837572 == i) || (2130837574 == i) || (2130837567 == i) || (2130837573 == i))
        {
          localHighQualityImageView = new HighQualityImageView(localSwipeApplication);
          localHighQualityImageView.setScaleType(ScaleType.FIT_CENTER);
          localHighQualityImageView.setImageResource(i);
          adb.a(localSwipeApplication);
          localHighQualityImageView.setTag(adb.this);
          str = adb.this.a.b(localSwipeApplication);
          if (!vs.R(localSwipeApplication))
            break label164;
        }
        label164: for (i = 2131231204; ; i = 2131231205)
        {
          act.a(localHighQualityImageView, String.format("%s%s", new Object[] { str, localSwipeApplication.getString(i) }));
          return;
        }
      }
    });
  }

  private boolean p()
  {
    if (!a())
    {
      d();
      return true;
    }
    return false;
  }

  private void q()
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    long l = System.currentTimeMillis() - this.a.a.getTime();
    if ((l < 7200000L) && (l > 0L))
    {
      abd.b(localSwipeApplication);
      return;
    }
    this.a = null;
  }

  public void a(ComponentName paramComponentName)
  {
    o();
  }

  protected void a(WeatherCondition paramWeatherCondition, int paramInt)
  {
    if (p());
    do
    {
      do
        return;
      while ((paramInt != 0) || (paramWeatherCondition == null));
      this.a = paramWeatherCondition.e();
    }
    while (this.a == null);
    q();
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      o();
  }

  public void b(ComponentName paramComponentName)
  {
  }

  public void c()
  {
    super.c();
    try
    {
      wq.b().a(this);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void d()
  {
    if (this.f)
      return;
    this.f = true;
    try
    {
      wq.b().b(this);
      label20: super.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label20;
    }
  }

  protected void e()
  {
    if ((this.a == null) || (p()))
      return;
    q();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adb
 * JD-Core Version:    0.6.2
 */