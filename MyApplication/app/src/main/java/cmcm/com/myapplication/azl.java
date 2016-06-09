package cmcm.com.myapplication;

import android.util.Log;
import android.view.View;

public abstract class azl
{
  private int a;
  public final View b;
  public int c = -1;
  int d = -1;
  long e = -1L;
  int f = -1;
  int g = -1;
  public azl h = null;
  public azl i = null;
  private int j = 0;
  private azd k = null;

  public azl(View paramView)
  {
    if (paramView == null)
      throw new IllegalArgumentException("itemView may not be null");
    this.b = paramView;
  }

  public void a()
  {
    this.d = -1;
    this.g = -1;
  }

  public void a(int paramInt)
  {
    this.a |= paramInt;
  }

  void a(int paramInt1, int paramInt2)
  {
    this.a = (this.a & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(8);
    a(paramInt2, paramBoolean);
    this.c = paramInt1;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.d == -1)
      this.d = this.c;
    if (this.g == -1)
      this.g = this.c;
    if (paramBoolean)
      this.g += paramInt;
    this.c += paramInt;
    if (this.b.getLayoutParams() != null)
      ((ayz)this.b.getLayoutParams()).c = true;
  }

  void a(azd paramazd)
  {
    this.k = paramazd;
  }

  public final void a(boolean paramBoolean)
  {
    int m;
    if (paramBoolean)
    {
      m = this.j - 1;
      this.j = m;
      if (this.j >= 0)
        break label64;
      this.j = 0;
      Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
    }
    label64: 
    do
    {
      return;
      m = this.j + 1;
      break;
      if ((!paramBoolean) && (this.j == 1))
      {
        this.a |= 16;
        return;
      }
    }
    while ((!paramBoolean) || (this.j != 0));
    this.a &= -17;
  }

  public void b()
  {
    if (this.d == -1)
      this.d = this.c;
  }

  public boolean c()
  {
    return (this.a & 0x80) != 0;
  }

  public final int d()
  {
    if (this.g == -1)
      return this.c;
    return this.g;
  }

  public final long e()
  {
    return this.e;
  }

  public final int f()
  {
    return this.f;
  }

  boolean g()
  {
    return this.k != null;
  }

  void h()
  {
    this.k.c(this);
  }

  boolean i()
  {
    return (this.a & 0x20) != 0;
  }

  void j()
  {
    this.a &= -33;
  }

  public boolean k()
  {
    return (this.a & 0x4) != 0;
  }

  public boolean l()
  {
    return (this.a & 0x2) != 0;
  }

  public boolean m()
  {
    return (this.a & 0x40) != 0;
  }

  boolean n()
  {
    return (this.a & 0x1) != 0;
  }

  public boolean o()
  {
    return (this.a & 0x8) != 0;
  }

  void p()
  {
    this.a = 0;
    this.c = -1;
    this.d = -1;
    this.e = -1L;
    this.g = -1;
    this.j = 0;
    this.h = null;
    this.i = null;
  }

  public final boolean q()
  {
    return ((this.a & 0x10) == 0) && (!ez.c(this.b));
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
    if (g())
      localStringBuilder.append(" scrap");
    if (k())
      localStringBuilder.append(" invalid");
    if (!n())
      localStringBuilder.append(" unbound");
    if (l())
      localStringBuilder.append(" update");
    if (o())
      localStringBuilder.append(" removed");
    if (c())
      localStringBuilder.append(" ignored");
    if (m())
      localStringBuilder.append(" changed");
    if (!q())
      localStringBuilder.append(" not recyclable(" + this.j + ")");
    if (this.b.getParent() == null)
      localStringBuilder.append(" no parent");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     azl
 * JD-Core Version:    0.6.2
 */