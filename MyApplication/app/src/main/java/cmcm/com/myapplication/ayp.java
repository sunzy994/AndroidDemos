package cmcm.com.myapplication;

import android.view.ViewGroup;

public abstract class ayp<VH extends azl>
{
  private final ayq a = new ayq();
  private boolean b = false;

  public abstract int a();

  public int a(int paramInt)
  {
    return 0;
  }

  public void a(ayr paramayr)
  {
    this.a.registerObserver(paramayr);
  }

  public void a(VH paramVH)
  {
  }

  public abstract void a(VH paramVH, int paramInt);

  public long b(int paramInt)
  {
    return -1L;
  }

  public abstract VH b(ViewGroup paramViewGroup, int paramInt);

  public void b(ayr paramayr)
  {
    this.a.unregisterObserver(paramayr);
  }

  public void b(VH paramVH)
  {
  }

  public final void b(VH paramVH, int paramInt)
  {
    paramVH.c = paramInt;
    if (b())
      paramVH.e = b(paramInt);
    a(paramVH, paramInt);
    paramVH.a(1, 7);
  }

  public final boolean b()
  {
    return this.b;
  }

  public final VH c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = b(paramViewGroup, paramInt);
    paramViewGroup.f = paramInt;
    return paramViewGroup;
  }

  public final void c()
  {
    this.a.a();
  }

  public void c(VH paramVH)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ayp
 * JD-Core Version:    0.6.2
 */