package cmcm.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.lang.ref.WeakReference;

class alm extends Handler
{
  private final WeakReference<all> a;

  private alm(all paramall)
  {
    this.a = new WeakReference(paramall);
  }

  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null));
    all localall;
    do
    {
      return;
      localall = (all)this.a.get();
      switch (paramMessage.what)
      {
      default:
        return;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (all.l(localall).get() == null);
    try
    {
      ((View)all.l(localall).get()).invalidate();
      return;
    }
    catch (Throwable paramMessage)
    {
      return;
    }
    all.m(localall);
    return;
    if ((paramMessage.obj instanceof Boolean));
    for (boolean bool = ((Boolean)paramMessage.obj).booleanValue(); ; bool = true)
    {
      all.a(localall, bool);
      return;
    }
    all.d(localall, paramMessage.arg1);
    switch (all.n(localall))
    {
    case 4:
    default:
      return;
    case 2:
      all.o(localall);
      return;
    case 3:
      all.p(localall);
      return;
    case 5:
    }
    all.q(localall);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alm
 * JD-Core Version:    0.6.2
 */