package cmcm.com.myapplication;

import android.util.SparseArray;

public class azi
{
  public cq<azl, ayx> a = new cq();
  public cq<azl, ayx> b = new cq();
  public cq<Long, azl> c = new cq();
  public int d = 0;
  private int e = -1;
  private SparseArray<Object> f;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;

  private void a(cq<Long, azl> paramcq, azl paramazl)
  {
    int m = paramcq.size() - 1;
    while (true)
    {
      if (m >= 0)
      {
        if (paramazl == paramcq.c(m))
          paramcq.d(m);
      }
      else
        return;
      m -= 1;
    }
  }

  public void a(azl paramazl)
  {
    this.a.remove(paramazl);
    this.b.remove(paramazl);
    if (this.c != null)
      a(this.c, paramazl);
  }

  public boolean a()
  {
    return this.j;
  }

  public boolean b()
  {
    return this.l;
  }

  public int c()
  {
    return this.e;
  }

  public boolean d()
  {
    return this.e != -1;
  }

  public int e()
  {
    if (this.j)
      return this.g - this.h;
    return this.d;
  }

  public String toString()
  {
    return "State{mTargetPosition=" + this.e + ", mPreLayoutHolderMap=" + this.a + ", mPostLayoutHolderMap=" + this.b + ", mData=" + this.f + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.g + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.h + ", mStructureChanged=" + this.i + ", mInPreLayout=" + this.j + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azi
 * JD-Core Version:    0.6.2
 */