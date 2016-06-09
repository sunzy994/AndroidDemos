package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import com.lazyswipe.ui.RateView;

public class amy extends amq
{
  private static long b;

  public amy(Context paramContext)
  {
    this(paramContext, null);
  }

  public amy(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
  }

  protected void k()
  {
    Log.i(a, "checkAd");
    b = System.currentTimeMillis();
    amz.h().a(this.e);
  }

  protected void t_()
  {
    long l = 0L;
    Log.i(a, "showAd");
    int i = (int)(ari.a((int) (System.currentTimeMillis() - b), 0L, 3599000L) / 1000L);
    if (i < 5)
      return;
    Object localObject;
    label71: amz localamz;
    View localView;
    if (i < 60)
    {
      localObject = this.e.getString(2131231093, new Object[] { Integer.valueOf(i) });
      localamz = amz.h();
      if (!(yb.getTopChild() instanceof RateView))
        break label207;
      localView = null;
      label86: if (localView == null)
        break label215;
      i = 1;
      label93: localObject = new auz(this.e).a(2131230935).b(this.e.getString(2131230936, new Object[] { localObject })).a(localamz);
      if (i != 0)
        ((auz)localObject).a(localView);
      if (i == 0)
        break label221;
    }
    while (true)
    {
      localObject = ((auz)localObject).a(l);
      if (i == 0)
        break;
      localamz.a((DialogInterface)localObject);
      return;
      localObject = this.e.getString(2131231094, new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      break label71;
      label207: localView = localamz.f();
      break label86;
      label215: i = 0;
      break label93;
      label221: l = 3000L;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amy
 * JD-Core Version:    0.6.2
 */