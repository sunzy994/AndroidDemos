package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duapps.ad.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class lo
  implements li
{
  private static final String a = lo.class.getSimpleName();
  private static WeakHashMap f = new WeakHashMap();
  private Context b;
  private List c;
  private View d;
  private a e;
  private lq g;
  private ns h;
  private np i;

  public lo(Context paramContext, a parama, np paramnp)
  {
    this.e = parama;
    this.b = paramContext;
    this.i = paramnp;
    this.c = new ArrayList();
  }

  private void a(List paramList, View paramView)
  {
    paramList.add(paramView);
    if (!(paramView instanceof ViewGroup));
    while (true)
    {
      return;
      paramView = (ViewGroup)paramView;
      int k = paramView.getChildCount();
      int j = 0;
      while (j < k)
      {
        a(paramList, paramView.getChildAt(j));
        j += 1;
      }
    }
  }

  private boolean j()
  {
    return this.e != null;
  }

  public final void a()
  {
    if (this.d == null)
      return;
    if ((!f.containsKey(this.d)) || (((WeakReference)f.get(this.d)).get() != this))
    {
      mv.b(a, "unregisterView() -> View not regitered with this NativeAd");
      return;
    }
    f.remove(this.d);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setOnClickListener(null);
      localView.setOnTouchListener(null);
    }
    this.c.clear();
    this.d = null;
  }

  public final void a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramView);
    a(paramView, localArrayList);
  }

  public final void a(View paramView, List paramList)
  {
    if (paramView == null)
      mv.d(a, "registerViewForInteraction() -> Must provide a view");
    while (true)
    {
      return;
      if ((paramList == null) || (paramList.size() == 0))
      {
        mv.d(a, "registerViewForInteraction() -> Invalid set of clickable views");
        return;
      }
      if (!j())
      {
        mv.d(a, "registerViewForInteraction() -> Ad not loaded");
        return;
      }
      if (this.d != null)
      {
        mv.b(a, "Native Ad was already registered with a View, Auto unregistering and proceeding");
        a();
      }
      if ((f.containsKey(paramView)) && (((WeakReference)f.get(paramView)).get() != null))
        ((lo)((WeakReference)f.get(paramView)).get()).a();
      this.g = new lq(this);
      this.d = paramView;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        View localView = (View)paramList.next();
        this.c.add(localView);
        localView.setOnClickListener(this.g);
        localView.setOnTouchListener(this.g);
      }
      f.put(paramView, new WeakReference(this));
      nr.h(this.b, new oa(this.e));
      paramView = this.e.r;
      if ((paramView != null) && (paramView.length > 0))
      {
        int j = 0;
        while (j < paramView.length)
        {
          paramList = paramView[j];
          mm.a().a(new lp(this, paramList));
          j += 1;
        }
      }
    }
  }

  public final void b()
  {
  }

  public final String c()
  {
    if (!j())
      return null;
    return this.e.k;
  }

  public final String d()
  {
    if (!j())
      return null;
    return this.e.e;
  }

  public final String e()
  {
    if (!j())
      return null;
    return this.e.q;
  }

  public final String f()
  {
    if (!j())
      return null;
    return this.e.d;
  }

  public final String g()
  {
    if (!j())
      return null;
    return this.e.b;
  }

  public final float h()
  {
    if (!j())
      return 0.0F;
    return this.e.g;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     lo
 * JD-Core Version:    0.6.2
 */