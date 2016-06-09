package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.preference.MyCheckboxPreference;
import com.lazyswipe.ui.BaseSettingsFragment;
import java.lang.ref.WeakReference;

public class apa extends BroadcastReceiver
{
  private static apa a;
  private WeakReference<BaseSettingsFragment> b;

  private apa(BaseSettingsFragment paramBaseSettingsFragment)
  {
    this.b = new WeakReference(paramBaseSettingsFragment);
  }

  public static void a()
  {
    try
    {
      ci.a(SwipeApplication.c()).a(new Intent("ReOpenNotification"));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private static void b(BaseSettingsFragment paramBaseSettingsFragment)
  {
    if (a != null)
      return;
    try
    {
      SwipeApplication localSwipeApplication = SwipeApplication.c();
      a = new apa(paramBaseSettingsFragment);
      paramBaseSettingsFragment = new IntentFilter("ReOpenNotification");
      ci.a(localSwipeApplication).a(a, paramBaseSettingsFragment);
      return;
    }
    catch (Exception paramBaseSettingsFragment)
    {
    }
  }

  private static void c()
  {
    if (a == null)
      return;
    try
    {
      ci.a(SwipeApplication.c()).a(a);
      a = null;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getAction())))
      return;
    paramIntent = paramIntent.getAction();
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default:
    case 2077502664:
    }
    while (true)
    {
      switch (i)
      {
      default:
        return;
      case 0:
      }
      paramIntent = (BaseSettingsFragment)this.b.get();
      if (paramIntent == null)
        break;
      boolean bool = vs.H(paramContext);
      BaseSettingsFragment.a(paramIntent).setChecked(bool);
      return;
      if (paramIntent.equals("ReOpenNotification"))
        i = 0;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apa
 * JD-Core Version:    0.6.2
 */