package cmcm.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duapps.ad.b.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class mg
  implements li
{
  private static WeakHashMap e = new WeakHashMap();
  private Context a;
  private List b;
  private View c;
  private a d;
  private mh f;
  private ns g;
  private np h;

  public mg(Context paramContext, a parama, np paramnp)
  {
    this.d = parama;
    this.a = paramContext;
    this.h = paramnp;
    this.b = new ArrayList();
  }

  private void a(List paramList, View paramView)
  {
    paramList.add(paramView);
    if (!(paramView instanceof ViewGroup));
    while (true)
    {
      return;
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramList, paramView.getChildAt(i));
        i += 1;
      }
    }
  }

  private boolean i()
  {
    return this.d != null;
  }

  private void j()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setOnClickListener(null);
      localView.setOnTouchListener(null);
    }
    this.b.clear();
  }

  public final void a()
  {
    if (this.c == null)
      return;
    if ((!e.containsKey(this.c)) || (((WeakReference)e.get(this.c)).get() != this))
    {
      mv.b("NativeAdIMWrapper", "unregisterView() -> View not regitered with this NativeAd");
      return;
    }
    e.remove(this.c);
    j();
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
    {
      mv.d("NativeAdIMWrapper", "registerViewForInteraction() -> Must provide a view");
      return;
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      mv.d("NativeAdIMWrapper", "registerViewForInteraction() -> Invalid set of clickable views");
      return;
    }
    if (!i())
    {
      mv.d("NativeAdIMWrapper", "registerViewForInteraction() -> Ad not loaded");
      return;
    }
    if (this.c != null)
    {
      mv.b("NativeAdIMWrapper", "Native Ad was already registered with a View, Auto unregistering and proceeding");
      a();
    }
    if ((e.containsKey(paramView)) && (((WeakReference)e.get(paramView)).get() != null))
      ((mg)((WeakReference)e.get(paramView)).get()).a();
    this.f = new mh(this);
    this.c = paramView;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      View localView = (View)paramList.next();
      this.b.add(localView);
      localView.setOnClickListener(this.f);
      localView.setOnTouchListener(this.f);
    }
    e.put(paramView, new WeakReference(this));
    nr.h(this.a, new oa(this.d));
    mm.a().a(new mf(this.a, false, this.d));
  }

  public final void b()
  {
    j();
    if (this.c != null)
    {
      e.remove(this.c);
      this.c = null;
    }
  }

  public final String c()
  {
    if (!i())
      return null;
    return this.d.l;
  }

  public final String d()
  {
    if (!i())
      return null;
    return this.d.k;
  }

  public final String e()
  {
    if (!i())
      return null;
    return this.d.n;
  }

  public final String f()
  {
    if (!i())
      return null;
    return this.d.i;
  }

  public final String g()
  {
    if (!i())
      return null;
    return this.d.h;
  }

  public final float h()
  {
    if (!i())
      return 0.0F;
    return this.d.j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mg
 * JD-Core Version:    0.6.2
 */