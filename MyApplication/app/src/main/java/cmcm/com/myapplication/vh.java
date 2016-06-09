package cmcm.com.myapplication;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.lazyswipe.SwipeService;
import com.lazyswipe.ui.NotificationSettingsFragment;

public class vh
  implements OnSharedPreferenceChangeListener
{
  private static final String a = "Swipe." + vh.class.getSimpleName();
  private final SwipeService b;
  private boolean c;

  public vh(SwipeService paramSwipeService)
  {
    this.b = paramSwipeService;
    if (!vs.a(this.b).contains("key_notification_style"));
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }

  public void a()
  {
    PreferenceManager.getDefaultSharedPreferences(this.b).registerOnSharedPreferenceChangeListener(this);
    this.b.getSharedPreferences("pop_time_preference", 0).registerOnSharedPreferenceChangeListener(this);
  }

  public void b()
  {
    PreferenceManager.getDefaultSharedPreferences(this.b).unregisterOnSharedPreferenceChangeListener(this);
    this.b.getSharedPreferences("pop_time_preference", 0).unregisterOnSharedPreferenceChangeListener(this);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.b;
        localObject = SwipeService.a();
        int i = -1;
        switch (paramString.hashCode())
        {
        default:
        case -503985843:
        case 727341632:
        case -1191577147:
        case 446637133:
        case -708893724:
        case 1689540046:
        case -1486167235:
        }
        while (true)
          switch (i)
          {
          default:
            return;
          case 0:
          case 1:
            try
            {
              this.b.e.onSharedPreferenceChanged(paramSharedPreferences, paramString);
              return;
            }
            catch (Throwable paramSharedPreferences)
            {
              return;
            }
            if (paramString.equals("key_toucher_type"))
            {
              i = 0;
              continue;
              if (paramString.equals("key_show_over_lockscreen"))
              {
                i = 1;
                continue;
                if (paramString.equals("key_memory_tip_enable"))
                {
                  i = 2;
                  continue;
                  if (paramString.equals("key_memory_tip_on_launcher_only"))
                  {
                    i = 3;
                    continue;
                    if (paramString.equals("POP_TIME_USER_WHITE_LIST"))
                    {
                      i = 4;
                      continue;
                      if (paramString.equals("POP_TIME_USER_BLACK_LIST"))
                      {
                        i = 5;
                        continue;
                        if (paramString.equals("key_notification_style"))
                          i = 6;
                      }
                    }
                  }
                }
              }
            }
            break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          }
      }
      while (localObject == null);
      ((Handler)localObject).postDelayed(new Runnable()
      {
        public void run()
        {
          try
          {
            if (acw.b(vh.a(vh.this)))
            {
              acw.c(vh.a(vh.this), true);
              vp.a(vh.a(vh.this)).a();
              return;
            }
            acw.e(vh.a(vh.this), true);
            vp.a(vh.a(vh.this)).b();
            return;
          }
          catch (Exception localException)
          {
          }
        }
      }
      , 100L);
      return;
    }
    while (localObject == null);
    ((Handler)localObject).postDelayed(new Runnable()
    {
      public void run()
      {
        try
        {
          if (acw.a(vh.a(vh.this)))
          {
            acw.e(vh.a(vh.this), true);
            return;
          }
          acw.c(vh.a(vh.this), true);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
    , 100L);
    return;
    aft.b(paramSharedPreferences.getString(paramString, ""));
    return;
    aft.a(paramSharedPreferences.getString(paramString, ""));
    return;
    if (this.c)
    {
      this.c = false;
      return;
    }
    NotificationSettingsFragment.a(this.b, asi.e(paramSharedPreferences.getString(paramString, null)));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vh
 * JD-Core Version:    0.6.2
 */