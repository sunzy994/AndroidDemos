package cmcm.com.myapplication.com.lazyswipe.ui;

import amk;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import aqq;
import aqs;
import com.lazyswipe.SwipeService;
import vs;
import wu;

public class TutorialService extends IntentService
{
  private static volatile boolean a;

  public TutorialService()
  {
    super("TutorialService");
  }

  public static PendingIntent a(Context paramContext, int paramInt)
  {
    return PendingIntent.getService(paramContext, paramInt, new Intent(paramContext, TutorialService.class).setAction("action.HANDLE_NOTIFICATION_APPS_CHOOSER_RESULT").putExtra("extra.APPS_CHOOSER_RESULT_CODE", paramInt), 1073741824);
  }

  private void a(int paramInt)
  {
    if (!amk.b(this))
      return;
    if (-1 == paramInt)
      vs.G(this);
    StartupActivity.a(this);
  }

  public static void a(Context paramContext)
  {
    a = true;
    paramContext.startService(new Intent(paramContext, TutorialService.class).setAction("action.CHECK_FLOAT_WINDOW_PERMISSION"));
  }

  private void a(String paramString)
  {
    int j = 0;
    while (true)
    {
      if ((!a) && (j < 150))
      {
        int i = -1;
        switch (paramString.hashCode())
        {
        default:
        case -281794004:
        case 2006867601:
        }
        while (true)
          switch (i)
          {
          default:
            throw new IllegalArgumentException("Unknown action: " + paramString);
            if (paramString.equals("action.CHECK_FLOAT_WINDOW_PERMISSION"))
            {
              i = 0;
              continue;
              if (paramString.equals("action.CHECK_USAGE_ACCESS"))
                i = 1;
            }
            break;
          case 0:
          case 1:
          }
      }
      for (boolean bool = aqs.b(this); bool; bool = wu.b(this))
      {
        StartupActivity.a(this, true);
        return;
      }
      try
      {
        Thread.sleep(1200L);
        j += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          Thread.currentThread().interrupt();
      }
    }
  }

  public static void b(Context paramContext)
  {
    a = true;
    paramContext.startService(new Intent(paramContext, TutorialService.class).setAction("action.CHECK_USAGE_ACCESS"));
  }

  public static void b(Context paramContext, int paramInt)
  {
    a = true;
    paramContext.startService(new Intent(paramContext, TutorialService.class).setAction("action.HANDLE_NOTIFICATION_APPS_CHOOSER_RESULT").putExtra("extra.APPS_CHOOSER_RESULT_CODE", paramInt));
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    int i = 0;
    a = false;
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      switch (str.hashCode())
      {
      default:
        label52: i = -1;
      case 2006867601:
      case -281794004:
      case 1531260761:
      }
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (!str.equals("action.CHECK_USAGE_ACCESS"))
          break label52;
        continue;
        if (!str.equals("action.CHECK_FLOAT_WINDOW_PERMISSION"))
          break label52;
        i = 1;
        continue;
        if (!str.equals("action.HANDLE_NOTIFICATION_APPS_CHOOSER_RESULT"))
          break label52;
        i = 2;
      case 0:
      case 1:
      case 2:
      }
    a(str);
    return;
    if (!aqs.D())
    {
      a(str);
      return;
    }
    aqq.a(this);
    stopService(new Intent(this, SwipeService.class));
    System.exit(99);
    return;
    a(paramIntent.getIntExtra("extra.APPS_CHOOSER_RESULT_CODE", -1));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.TutorialService
 * JD-Core Version:    0.6.2
 */