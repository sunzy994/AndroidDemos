package cmcm.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanLayer;
import com.lazyswipe.fan.SectorArea;

public class apn extends avw
  implements apr
{
  protected static final String c = "Swipe." + apn.class.getSimpleName();
  protected app d;
  protected final boolean e;
  private final Intent f;
  private BroadcastReceiver g = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      apn.this.dismiss();
    }
  };

  public apn(Context paramContext, Intent paramIntent)
  {
    super(paramContext);
    this.f = paramIntent;
    this.e = paramIntent.getBooleanExtra("EXTRA_CHOOSE_APP", true);
  }

  public void b(boolean paramBoolean)
  {
    dismiss();
    yb localyb = yb.getInstance();
    if (localyb != null)
    {
      yw.g = true;
      localyb.getItemLayer().m();
      xv localxv = localyb.getBaseSectorArea();
      if (paramBoolean)
      {
        localxv.getNextTab().a(SwipeApplication.c(), true);
        aao localaao = localxv.getPreviousTab();
        localaao.g();
        if ((localxv instanceof SectorArea))
          ((FanLayer)((SectorArea)localxv).getHiddenItemLayer()).a(localaao, localyb.a(localaao), localyb.getStartPosition(), false, false);
      }
      localxv.c();
      localyb.d(false);
      localyb.getItemLayer().n();
      yw.g = false;
    }
  }

  public void dismiss()
  {
    super.dismiss();
    this.d.i();
    this.d.j();
    this.d.b();
  }

  public void h()
  {
    dismiss();
  }

  public void i()
  {
    dismiss();
  }

  protected void onStart()
  {
    super.onStart();
    try
    {
      ci.a(getContext()).a(this.g, new IntentFilter("BROADCAST_ACTION_HOME_KEY"));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void onStop()
  {
    super.onStop();
    try
    {
      ci.a(getContext()).a(this.g);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void show()
  {
    super.show();
    this.d = ((app)findViewById(2131755053));
    this.d.setMultiChooserCallBack(this);
    this.d.setIntent(this.f);
    this.d.a();
    this.d.f();
    this.d.g();
    this.d.h();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apn
 * JD-Core Version:    0.6.2
 */