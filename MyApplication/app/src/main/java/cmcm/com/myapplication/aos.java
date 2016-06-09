package cmcm.com.myapplication;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.lazyswipe.ui.BaseFragment;
import com.lazyswipe.widget.FragmentTabIndicator;
import java.util.List;

class aos extends x
  implements gi
{
  private final Context b;
  private final List<aor<BaseFragment>> c;
  private SparseArray<k> d = new SparseArray();
  private int e = 0;
  private int f = -1;

  public aos(Context paramContext, s params, List<aor<BaseFragment>> paramList)
  {
    super(paramList);
    this.b = params;
    Object localObject;
    this.c = localObject;
  }

  public k a(int paramInt)
  {
    k localk = ((aor)this.c.get(paramInt)).a(this.b);
    this.d.put(paramInt, localk);
    return localk;
  }

  public void a()
  {
    this.d.clear();
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    this.a.j.a(paramInt1, paramFloat);
  }

  public void b_(int paramInt)
  {
    this.a.j.a(paramInt);
    this.f = paramInt;
  }

  public void c(int paramInt)
  {
    if (this.f != this.e)
    {
      f(this.e);
      e(this.f);
      this.e = this.f;
    }
  }

  public k d(int paramInt)
  {
    return (k)this.d.get(paramInt);
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
  }

  public void e(int paramInt)
  {
    k localk = d(paramInt);
    if ((localk instanceof apg))
      ((apg)localk).L();
  }

  public void f(int paramInt)
  {
    k localk = d(paramInt);
    if ((localk instanceof apg))
      ((apg)localk).M();
  }

  public int getCount()
  {
    return this.c.size();
  }

  public CharSequence getPageTitle(int paramInt)
  {
    return aor.a((aor)this.c.get(paramInt));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aos
 * JD-Core Version:    0.6.2
 */