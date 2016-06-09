package cmcm.com.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class xv extends FrameLayout
{
  private static final String f = "Swipe." + xv.class.getSimpleName();
  public int a;
  protected int b;
  public boolean c;
  public yb d;
  public boolean e;
  private boolean g;

  public xv(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
    auu.a("Current index: " + this.a);
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 = this.d.e;
    int i = this.d.e;
    this.d.c[((paramInt1 + paramInt2) % i)].a(getContext(), this.d);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, false, paramBoolean);
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
  }

  public void b()
  {
  }

  public boolean c()
  {
    return false;
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public void f()
  {
  }

  public void g()
  {
  }

  public aao getCurrentTab()
  {
    return this.d.c[((this.a + this.d.e) % this.d.e)];
  }

  public float getHandTrackDismissThreshold()
  {
    return 0.35F;
  }

  public xu getItemLayer()
  {
    return null;
  }

  public ViewGroup getItemSector()
  {
    return null;
  }

  public View getItemSectorBg()
  {
    return null;
  }

  public aao getNextTab()
  {
    return this.d.c[((this.a + this.d.e + 1) % this.d.e)];
  }

  public int getOuterSize()
  {
    return this.d.getItemSectorOuterSize();
  }

  public aao getPreviousTab()
  {
    return this.d.c[((this.a + this.d.e - 1) % this.d.e)];
  }

  public ViewGroup getTabSector()
  {
    return null;
  }

  public View getTabSectorBg()
  {
    return null;
  }

  public boolean h()
  {
    return this.g;
  }

  public void i()
  {
  }

  public void setDirection(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void setFan(yb paramyb)
  {
    this.d = paramyb;
  }

  public void setPopupPrepared(boolean paramBoolean)
  {
    boolean bool = this.g;
    this.g = paramBoolean;
    if ((!bool) && (paramBoolean))
      this.d.u();
  }

  public void setTab(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xv
 * JD-Core Version:    0.6.2
 */