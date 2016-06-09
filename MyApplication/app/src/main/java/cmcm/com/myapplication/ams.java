package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import com.lazyswipe.ui.chooser.MultiChooserActivity;

public class ams extends ans
{
  private static final String a = "Swipe." + ams.class.getSimpleName();

  public ams(Context paramContext)
  {
    this(paramContext, null);
  }

  public ams(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  public int a(Context paramContext)
  {
    return 1;
  }

  public int a(boolean paramBoolean)
  {
    return 2130837814;
  }

  public boolean a(int paramInt)
  {
    return true;
  }

  protected Intent b(Context paramContext)
  {
    paramContext = MultiChooserActivity.c(true);
    paramContext.addFlags(268435456);
    paramContext.putExtra("extra.request_type", 0);
    return paramContext;
  }

  public String b()
  {
    return "Booster";
  }

  public String b(boolean paramBoolean)
  {
    return "tile_booster";
  }

  public int c()
  {
    return 2;
  }

  public int d()
  {
    return 2131231114;
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    amk.c(this.e, false);
    if (aoe.b())
      return false;
    aoa.a(this.e, 0, new aob() {
      public void run() {
        aoe.a(ams.this.e, this.b);
      }
    });
    return false;
  }

  public boolean x_()
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ams
 * JD-Core Version:    0.6.2
 */