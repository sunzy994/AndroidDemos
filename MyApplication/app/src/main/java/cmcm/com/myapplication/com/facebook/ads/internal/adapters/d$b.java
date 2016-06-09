package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;

final class d$b extends t<d>
{
  public d$b(d paramd)
  {
    super(paramd);
  }

  public void run()
  {
    d locald = (d)a();
    if (locald == null);
    View localView;
    d.a locala;
    do
    {
      do
        return;
      while ((!d.a(locald)) && (d.b(locald)));
      localView = d.c(locald);
      locala = d.d(locald);
    }
    while ((localView == null) || (locala == null));
    if (g.a(d.e(locald), localView, d.f(locald)))
    {
      locala.a();
      d.a(locald, true);
      return;
    }
    locala.b();
    d.i(locald).postDelayed(d.g(locald), d.h(locald));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.d.b
 * JD-Core Version:    0.6.2
 */