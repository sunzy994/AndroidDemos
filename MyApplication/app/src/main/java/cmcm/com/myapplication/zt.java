package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.hetero.iwatch.WatchTabSector;

public class zt extends ImageView
{
  private static final String d = "Swipe." + zt.class.getSimpleName();
  public float a;
  public int b;
  public int c;
  private final int e = getResources().getDimensionPixelSize(2131296349);
  private final int f = this.e / 2;
  private final int g;
  private String h;
  private float i;
  private boolean j;

  public zt(Context paramContext)
  {
    super(paramContext);
    setScaleType(ScaleType.FIT_START);
    this.g = ((int)(WatchTabSector.a * 0.6800000000000001D));
  }

  public static zt a(String paramString, int paramInt1, int paramInt2, WatchTabSector paramWatchTabSector)
  {
    zt localzt = new zt(SwipeApplication.c());
    localzt.b(paramString, paramInt1, paramInt2, paramWatchTabSector);
    return localzt;
  }

  private void c()
  {
    double d1 = Math.toRadians(ahy.a(this.j, this.a));
    this.b = ((int)(this.g * Math.cos(d1)));
    double d2 = this.g;
    this.c = ((int)(Math.sin(d1) * d2));
    a(false);
  }

  private void d()
  {
    float f1 = getBaseScale();
    setScaleX(f1);
    setScaleY(f1);
  }

  private float getBaseScale()
  {
    if ((this.a > 0.0F) && (this.a < 90.0F))
      return (1.0F - Math.abs(this.a - 45.0F) / 45.0F) * 0.67F + 0.33F;
    return 0.3F;
  }

  private int getTabImage()
  {
    if ("mostUsed".equals(this.h));
    do
    {
      return 2130837708;
      if ("switcher".equals(this.h))
        return 2130837710;
      if ("recentlyUsed".equals(this.h))
        return 2130837709;
      if ("contact".equals(this.h))
        return 2130837706;
    }
    while (!"custom".equals(this.h));
    return 2130837707;
  }

  public FrameLayout.LayoutParams a(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams1;
    if (!paramBoolean)
    {
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 != null);
    }
    else
    {
      localLayoutParams1 = new FrameLayout.LayoutParams(this.e, this.e);
    }
    localLayoutParams1.width = this.e;
    localLayoutParams1.height = this.e;
    if (this.j);
    for (int k = 3; ; k = 5)
    {
      localLayoutParams1.gravity = (k | 0x50);
      localLayoutParams1.topMargin = 0;
      localLayoutParams1.bottomMargin = (this.c - this.f);
      if (!this.j)
        break;
      localLayoutParams1.leftMargin = (this.b - this.f);
      localLayoutParams1.rightMargin = 0;
      return localLayoutParams1;
    }
    localLayoutParams1.leftMargin = 0;
    localLayoutParams1.rightMargin = (-this.b - this.f);
    return localLayoutParams1;
  }

  public void a()
  {
    if (yb.getInstance() == null)
      return;
    float f1 = yb.getInstance().getHandTrackRatio();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = ((int)(this.c * f1 - this.f));
    if (this.j)
      localLayoutParams.leftMargin = ((int)(this.b * f1 - this.f));
    for (localLayoutParams.rightMargin = 0; ; localLayoutParams.rightMargin = ((int)(-this.b * f1 - this.f)))
    {
      setAlpha(FanItem.b(f1));
      f1 = FanItem.a(f1) * getBaseScale();
      setScaleX(f1);
      setScaleY(f1);
      return;
      localLayoutParams.leftMargin = 0;
    }
  }

  public boolean a(float paramFloat)
  {
    int k = (int)ahy.c(paramFloat) / 3;
    paramFloat = this.i;
    this.a = ahy.a(k + paramFloat);
    c();
    d();
    return true;
  }

  public void b()
  {
    setScaleX(getBaseScale());
    setScaleY(getBaseScale());
    setAlpha(1.0F);
  }

  public void b(String paramString, int paramInt1, int paramInt2, WatchTabSector paramWatchTabSector)
  {
    this.h = paramString;
    setImageResource(getTabImage());
    this.j = paramWatchTabSector.c();
    this.a = ahy.a(paramInt1 + paramInt2);
    this.i = this.a;
    c();
    d();
  }

  public String getTab()
  {
    return this.h;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.e, this.e);
    setPivotX(getMeasuredWidth() / 2);
    setPivotY(getMeasuredHeight() / 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zt
 * JD-Core Version:    0.6.2
 */