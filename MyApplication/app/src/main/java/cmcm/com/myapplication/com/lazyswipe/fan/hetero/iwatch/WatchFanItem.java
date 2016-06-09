package cmcm.com.myapplication.com.lazyswipe.fan.hetero.iwatch;

import ahy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import aqs;
import asq;
import atw;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import yb;
import yf;
import yj;
import yw;
import zq;
import zr;
import zs;
import zw;

public class WatchFanItem extends FanItem
  implements Callback
{
  public static int i;
  public static final zq[][] k;
  private static final String o = "Swipe." + WatchFanItem.class.getSimpleName();
  public zr h;
  public final Rect j = new Rect();
  private yw p;
  private final int q = getResources().getDimensionPixelSize(2131296279);
  private final int r = getResources().getDimensionPixelSize(2131296280);
  private final Paint s = new Paint();
  private Rect t;
  private WatchItemSector u;
  private final Handler v;

  static
  {
    k = new zq[13][];
    k[6] = a(45.0F, 90.0F);
    k[7] = a(75.0F, 90.0F);
    k[8] = a(15.0F, 90.0F);
    k[0] = a(45.0F, 60.0F);
    k[1] = a(65.0F, 60.0F);
    k[2] = a(25.0F, 60.0F);
    k[3] = a(45.0F, 85.0F);
    k[4] = a(62.0F, 85.0F);
    k[5] = a(28.0F, 85.0F);
    k[9] = a(11.0F, 85.0F);
    k[10] = a(79.0F, 85.0F);
    k[11] = { new zq(0, 72), new zq(45, 90), new zq(90, 135), new zq(172, 0), new zq(180, 5), new zq(244, 30), new zq(245, 60), new zq(270, 72) };
    k[12] = { new zq(0, 18), new zq(25, 30), new zq(26, 60), new zq(90, 85), new zq(135, 135), new zq(180, 180), new zq(225, 0), new zq(270, 18) };
  }

  public WatchFanItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i = this.r >> 1;
    this.v = new Handler(this);
  }

  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 < paramFloat2)
      return paramFloat1;
    if (paramFloat5 < paramFloat3)
      return paramFloat1 + (paramFloat5 - paramFloat2) * (paramFloat4 - paramFloat1) / (paramFloat3 - paramFloat2);
    return (paramFloat5 - paramFloat3) * (0.16F - paramFloat4) / (45.0F - paramFloat3) + paramFloat4;
  }

  private float a(zq[] paramArrayOfzq, float paramFloat)
  {
    int m = 0;
    int n = 0;
    if (m < paramArrayOfzq.length)
      if (paramArrayOfzq[m].a < paramFloat);
    while (true)
    {
      if ((paramFloat == paramArrayOfzq[m].a) || (m == 0))
      {
        return paramArrayOfzq[m].b;
        n = m;
        m += 1;
        break;
      }
      float f3 = paramArrayOfzq[(m - 1)].a;
      float f4 = paramArrayOfzq[m].a;
      float f5 = paramArrayOfzq[(m - 1)].b;
      float f2 = paramArrayOfzq[m].b;
      float f1 = f2;
      if (f5 > f2)
        f1 = f2 + 360.0F;
      return (f1 - f5) * (paramFloat - f3) / (f4 - f3) + f5;
      m = n;
    }
  }

  public static WatchFanItem a(yw paramyw, int paramInt1, int paramInt2, boolean paramBoolean, WatchItemSector paramWatchItemSector)
  {
    WatchFanItem localWatchFanItem = (WatchFanItem)LayoutInflater.from(SwipeApplication.c()).inflate(2130968630, paramWatchItemSector, false);
    localWatchFanItem.u = paramWatchItemSector;
    localWatchFanItem.h = new zr(paramInt1, paramInt2, paramBoolean);
    localWatchFanItem.a(paramyw);
    return localWatchFanItem;
  }

  public static zq[] a(float paramFloat1, float paramFloat2)
  {
    return new zq[] { new zq(0.0F, paramFloat1), new zq(90.0F, ahy.a(paramFloat1 + paramFloat2)), new zq(180.0F, ahy.a(360.0F - paramFloat2 + paramFloat1)), new zq(270.0F, paramFloat1) };
  }

  private void b(yw paramyw)
  {
    if ((paramyw != null) && (paramyw.n()))
    {
      setLayerType(1, null);
      return;
    }
    if ((this.h.i == 3) || (this.h.i == 1))
    {
      if ((aqs.C()) || (!aqs.A()))
      {
        setLayerType(1, atw.b);
        return;
      }
      setLayerType(2, null);
      return;
    }
    setLayerType(0, null);
  }

  private void d(float paramFloat)
  {
    paramFloat = a(this.h.l, paramFloat);
    zr.a(this.h, ahy.a(paramFloat));
    zr.a(this.h, ahy.a(this.h.e, zr.a(this.h)));
    double d1 = Math.toRadians(zr.a(this.h));
    this.h.j = ((int)(this.h.h * Math.cos(d1)));
    zr localzr = this.h;
    double d2 = this.h.h;
    localzr.k = ((int)(Math.sin(d1) * d2));
    r();
    d(false);
  }

  private float e(float paramFloat)
  {
    float f = 45.0F;
    if ((paramFloat > 135.0F) && (paramFloat < 225.0F))
      return 0.6F;
    paramFloat = Math.abs(paramFloat - 45.0F);
    if (paramFloat > 45.0F)
      paramFloat = f;
    while (true)
    {
      switch (this.h.i)
      {
      default:
        return 1.0F;
      case 0:
        return a(0.85F, 30.0F, 38.0F, 0.68F, paramFloat);
      case 1:
        return a(1.0F, 29.0F, 32.5F, 0.75F, paramFloat);
      case 2:
        return a(1.0F, 30.0F, 38.0F, 0.8F, paramFloat);
      case 3:
      }
      return a(0.45F, 38.0F, 39.0F, 0.45F, paramFloat);
    }
  }

  private int getBaseScaleFrame()
  {
    int m = k[this.h.g].length;
    if (m < 2);
    while (this.u.g != 1)
      return 0;
    switch (this.h.f)
    {
    case 1:
    default:
      return 0;
    case 0:
      return 1;
    case 2:
    }
    return m - 2;
  }

  private void r()
  {
    float f1 = zr.a(this.h);
    float f3 = ahy.a(this.h.e, f1);
    if ((f3 > 135.0F) && (f3 < 225.0F))
      return;
    float f2 = Math.abs(f3 - 45.0F);
    f1 = f2;
    if (f2 > 45.0F)
      f1 = 45.0F;
    int m = 0;
    switch (this.h.i)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      m = (int)(f1 * m / 45.0F);
      if (f3 <= 45.0F)
        break;
      localzr = this.h;
      localzr.k -= m;
      return;
      m = asq.a(18.0F);
      continue;
      m = asq.a(27.0F);
      continue;
      m = asq.a(26.0F);
    }
    if (this.h.e)
    {
      localzr = this.h;
      localzr.j -= m;
      return;
    }
    zr localzr = this.h;
    localzr.j = (m + localzr.j);
  }

  private void s()
  {
    float f2 = 0.0F;
    if (this.h.i != 3)
      return;
    float f1 = zr.a(this.h);
    float f3 = ahy.a(this.h.e, f1);
    if ((f3 > 70.0F) || (f3 < 20.0F))
    {
      setAlpha(1.0F);
      return;
    }
    if ((f3 > 30.0F) && (f3 < 60.0F))
    {
      setAlpha(0.0F);
      return;
    }
    if ((f3 <= 70.0F) && (f3 >= 60.0F))
      f1 = 70.0F - f3;
    while (true)
    {
      setAlpha(1.0F - f1 / 10.0F);
      return;
      f1 = f2;
      if (f3 <= 30.0F)
      {
        f1 = f2;
        if (f3 >= 20.0F)
          f1 = f3 - 20.0F;
      }
    }
  }

  private void t()
  {
    if (this.h.i != 1)
      return;
    float f = Math.abs(ahy.a(this.h.e, zr.a(this.h)) - 45.0F);
    if (f < 28.0F)
      f = 1.0F;
    while (true)
    {
      setTextColor(Color.argb((int)(f * 255.0F), 255, 255, 255));
      return;
      if (f > 38.0F)
        f = 0.0F;
      else
        f = (38.0F - f) / (38.0F - 28.0F);
    }
  }

  public void a(yw paramyw)
  {
    this.p = paramyw;
    this.v.removeMessages(0);
    b(paramyw);
    if (paramyw == null)
    {
      setIconBackground(null);
      setIcon((Drawable)null);
      setText(null);
      setTag(null);
    }
    while (true)
    {
      if (this.h.i == 3)
        setText("");
      return;
      paramyw.a(this);
    }
  }

  public boolean c(float paramFloat)
  {
    if ((this.h == null) || (this.h.l == null) || (this.h.l.length < 2))
      return false;
    d(ahy.b(paramFloat));
    s();
    p();
    t();
    return true;
  }

  public FrameLayout.LayoutParams d(boolean paramBoolean)
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
      localLayoutParams1 = new FrameLayout.LayoutParams(this.r, -2);
    }
    localLayoutParams1.width = this.r;
    localLayoutParams1.height = -2;
    if (this.h.e);
    for (int m = 3; ; m = 5)
    {
      localLayoutParams1.gravity = (m | 0x50);
      localLayoutParams1.topMargin = 0;
      localLayoutParams1.bottomMargin = (this.h.k - i);
      if (!this.h.e)
        break;
      localLayoutParams1.leftMargin = (this.h.j - i);
      localLayoutParams1.rightMargin = 0;
      return localLayoutParams1;
    }
    localLayoutParams1.leftMargin = 0;
    localLayoutParams1.rightMargin = (-this.h.j - i);
    return localLayoutParams1;
  }

  public float e(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int m = 0; ; m = getBaseScaleFrame())
      return e(k[this.h.g][m].b);
  }

  protected boolean g()
  {
    return !(this.p instanceof zw);
  }

  public float getBaseScale()
  {
    return e(true);
  }

  protected yf getDecor()
  {
    return new zs(this);
  }

  public int getIconSize()
  {
    return this.q;
  }

  public yw getInfo()
  {
    return this.p;
  }

  public Rect getRect()
  {
    int m = this.h.j;
    int n = this.h.k;
    int i1 = (int)(i * getScaleX());
    int i2 = (int)(i * getScaleY());
    if (this.h.e)
      this.j.set(m - i1, this.u.getHeight() - n - i2, m + i1, this.u.getHeight() - n + i2);
    while (true)
    {
      return this.j;
      this.j.set(this.u.getWidth() + m - i1, this.u.getHeight() - n - i2, m + this.u.getWidth() + i1, this.u.getHeight() - n + i2);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 0:
    }
    try
    {
      setLayerType(0, null);
      return false;
    }
    catch (Exception paramMessage)
    {
    }
    return false;
  }

  public void i()
  {
    if (yb.getInstance() == null)
      return;
    Object localObject = yb.getInstance();
    float f = yb.getInstance().getHandTrackRatio();
    f = ((yb)localObject).getHandTracker().a(f);
    localObject = (FrameLayout.LayoutParams)getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.h.k * f - i));
    if (this.h.e)
      ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.h.j * f - i));
    for (((FrameLayout.LayoutParams)localObject).rightMargin = 0; ; ((FrameLayout.LayoutParams)localObject).rightMargin = ((int)(-this.h.j * f - i)))
    {
      setAlpha(b(f));
      f = e(false) * a(f);
      setScaleX(f);
      setScaleY(f);
      return;
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
    }
  }

  public void j()
  {
    setScaleX(e(false));
    setScaleY(e(false));
    setAlpha(1.0F);
    s();
  }

  void o()
  {
    if (getLayerType() != 0)
      this.v.sendEmptyMessageDelayed(0, 100L);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setPivotX(getMeasuredWidth() / 2);
    setPivotY(getMeasuredHeight() / 2);
  }

  protected void p()
  {
    float f = zr.a(this.h);
    f = e(ahy.a(this.h.e, f));
    setScaleX(f);
    setScaleY(f);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.hetero.iwatch.WatchFanItem
 * JD-Core Version:    0.6.2
 */