package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.lazyswipe.features.ad.mobvista.PicksActivity;

public class aby
{
  private final Activity a;
  private abz b;
  private Dialog c;
  private int d;
  private boolean e = false;
  private final Handler f = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 1:
      case 2:
      }
      do
      {
        return;
        aby.a(aby.this, tl.a(aby.a(aby.this), 0, 2131230736, true, 2131427344));
        return;
      }
      while ((aby.b(aby.this) == null) || (!aby.b(aby.this).isShowing()));
      aqt.a(aby.b(aby.this));
      if (paramAnonymousMessage.arg1 > 0)
      {
        aso.a(aby.a(aby.this), 2131230908);
        return;
      }
      aby.a(aby.this, true);
      aby.c(aby.this);
    }
  };

  public aby(Activity paramActivity)
  {
    this.a = paramActivity;
    a(false);
  }

  public static void a(Context paramContext)
  {
    if (!vs.c(paramContext, "key_picks_shortcut_sent", false))
    {
      vs.b(paramContext, "key_picks_shortcut_sent", true);
      asq.a(paramContext, new ComponentName(paramContext, PicksActivity.class.getName()), 2131231173, 2130837858);
    }
  }

  private boolean a(boolean paramBoolean)
  {
    return false;
  }

  private void b()
  {
    if (this.b != null)
    {
      vv.a().a("AppWall", "from", String.valueOf(this.d));
      a(this.a);
      this.b.a();
    }
  }

  public void a()
  {
    if (this.b != null)
    {
      this.b.b();
      this.b = null;
    }
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
    if ((!a(true)) && (!arl.i(this.a)))
    {
      aso.a(this.a, 2131230908);
      return;
    }
    b();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aby
 * JD-Core Version:    0.6.2
 */