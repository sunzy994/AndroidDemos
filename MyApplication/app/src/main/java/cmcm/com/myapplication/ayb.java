package cmcm.com.myapplication;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class ayb
{
  final ayd a;
  final ayc b;
  final List<View> c;

  public ayb(ayd paramayd)
  {
    this.a = paramayd;
    this.b = new ayc();
    this.c = new ArrayList();
  }

  private int e(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.a.a();
    int i = paramInt;
    while (true)
    {
      if (i >= j)
        break label72;
      int k = paramInt - (i - this.b.e(i));
      if (k == 0)
        while (true)
        {
          paramInt = i;
          if (!this.b.c(i))
            break;
          i += 1;
        }
      i += k;
    }
    label72: return -1;
  }

  View a(int paramInt1, int paramInt2)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.c.get(i);
      azl localazl = this.a.b(localView);
      if ((localazl.d() == paramInt1) && (!localazl.k()) && ((paramInt2 == -1) || (localazl.f() == paramInt2)))
        return localView;
      i += 1;
    }
    return null;
  }

  public void a()
  {
    this.a.b();
    this.b.a();
    this.c.clear();
  }

  void a(int paramInt)
  {
    paramInt = e(paramInt);
    View localView = this.a.b(paramInt);
    if (localView == null);
    do
    {
      return;
      this.a.a(paramInt);
    }
    while (!this.b.d(paramInt));
    this.c.remove(localView);
  }

  void a(View paramView)
  {
    int i = this.a.a(paramView);
    if (i < 0);
    do
    {
      return;
      this.a.a(i);
    }
    while (!this.b.d(i));
    this.c.remove(paramView);
  }

  void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0);
    for (paramInt = this.a.a(); ; paramInt = e(paramInt))
    {
      this.a.a(paramView, paramInt, paramLayoutParams);
      this.b.a(paramInt, paramBoolean);
      return;
    }
  }

  void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0);
    for (paramInt = this.a.a(); ; paramInt = e(paramInt))
    {
      this.a.a(paramView, paramInt);
      this.b.a(paramInt, paramBoolean);
      if (paramBoolean)
        this.c.add(paramView);
      return;
    }
  }

  public void a(View paramView, boolean paramBoolean)
  {
    a(paramView, -1, paramBoolean);
  }

  public int b()
  {
    return this.a.a() - this.c.size();
  }

  int b(View paramView)
  {
    int i = this.a.a(paramView);
    if (i == -1);
    while (this.b.c(i))
      return -1;
    return i - this.b.e(i);
  }

  public View b(int paramInt)
  {
    paramInt = e(paramInt);
    return this.a.b(paramInt);
  }

  public int c()
  {
    return this.a.a();
  }

  public View c(int paramInt)
  {
    return this.a.b(paramInt);
  }

  boolean c(View paramView)
  {
    return this.c.contains(paramView);
  }

  void d(int paramInt)
  {
    paramInt = e(paramInt);
    this.a.c(paramInt);
    this.b.d(paramInt);
  }

  public void d(View paramView)
  {
    int i = this.a.a(paramView);
    if (i < 0)
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    this.b.a(i);
    this.c.add(paramView);
  }

  public boolean e(View paramView)
  {
    int i = this.a.a(paramView);
    if (i == -1)
      if (!this.c.remove(paramView));
    do
    {
      return true;
      if (!this.b.c(i))
        break;
      this.b.d(i);
      this.a.a(i);
    }
    while (this.c.remove(paramView));
    return true;
    return false;
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayb
 * JD-Core Version:    0.6.2
 */