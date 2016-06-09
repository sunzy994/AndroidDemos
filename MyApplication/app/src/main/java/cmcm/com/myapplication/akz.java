package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;

public abstract class akz extends View
{
  protected boolean A = true;
  public alb a;
  public alb b;
  public final ArrayList<alb> c = new ArrayList();
  protected alb d;
  public float e = -1000.0F;
  public float f = 1000.0F;
  protected float g = -1000.0F;
  protected float h = 1000.0F;
  public boolean i = true;
  public long j = -1L;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  protected float q;
  protected float r;
  public float s;
  public Paint t;
  public FontMetrics u;
  public int v;
  public alb w;
  public alb x;
  public float y;
  public final ale z = new ald(this).a(500).a(false);

  public akz(Context paramContext)
  {
    this(paramContext, null);
  }

  public akz(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public akz(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  @TargetApi(21)
  public akz(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }

  public static void a(akz paramakz1, akz paramakz2, akz paramakz3)
  {
    float f2 = 1000.0F;
    float f3 = -1000.0F;
    if (paramakz1 == null)
      return;
    float f4 = paramakz1.e;
    label26: label41: float f5;
    label62: label77: float f6;
    if (paramakz2 == null)
    {
      f1 = -1000.0F;
      f4 = Math.max(f4, f1);
      if (paramakz3 != null)
        break label292;
      f1 = -1000.0F;
      f4 = Math.max(f4, f1);
      f5 = paramakz1.f;
      if (paramakz2 != null)
        break label300;
      f1 = 1000.0F;
      f5 = Math.min(f5, f1);
      if (paramakz3 != null)
        break label308;
      f1 = 1000.0F;
      f5 = Math.min(f5, f1);
      f6 = paramakz1.g;
      if (paramakz2 != null)
        break label316;
      f1 = -1000.0F;
      label98: f6 = Math.max(f6, f1);
      if (paramakz3 != null)
        break label324;
      f1 = f3;
      label113: f3 = Math.max(f6, f1);
      f6 = paramakz1.h;
      if (paramakz2 != null)
        break label332;
      f1 = 1000.0F;
      label134: f6 = Math.min(f6, f1);
      if (paramakz3 != null)
        break label340;
    }
    label292: label300: label308: label316: label324: label332: label340: for (float f1 = f2; ; f1 = paramakz3.h)
    {
      f1 = Math.min(f6, f1);
      boolean bool2 = a(f4, f5, f3, f1, paramakz1);
      boolean bool3 = a(f4, f5, f3, f1, paramakz2);
      boolean bool1 = a(f4, f5, f3, f1, paramakz3) | (bool2 | bool3);
      if (paramakz2 != null)
      {
        paramakz1.a(paramakz2.getLastPoint(), true);
        paramakz2.a(paramakz1.getFirstPoint(), false);
        paramakz2.a(null, true);
        if (bool1)
        {
          paramakz1.d();
          paramakz2.d();
        }
      }
      if (paramakz3 == null)
        break;
      paramakz1.a(paramakz3.getFirstPoint(), false);
      paramakz3.a(paramakz1.getLastPoint(), true);
      paramakz3.a(null, false);
      if (!bool1)
        break;
      paramakz1.d();
      paramakz3.d();
      return;
      f1 = paramakz2.e;
      break label26;
      f1 = paramakz3.e;
      break label41;
      f1 = paramakz2.f;
      break label62;
      f1 = paramakz3.f;
      break label77;
      f1 = paramakz2.g;
      break label98;
      f1 = paramakz3.g;
      break label113;
      f1 = paramakz2.h;
      break label134;
    }
  }

  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, akz paramakz)
  {
    if (paramakz == null);
    do
    {
      return false;
      paramakz.e();
    }
    while ((paramakz.k == paramFloat1) && (paramakz.l == paramFloat2) && (paramakz.m == paramFloat3) && (paramakz.n == paramFloat4));
    paramakz.k = paramFloat1;
    paramakz.l = paramFloat2;
    paramakz.m = paramFloat3;
    paramakz.n = paramFloat4;
    paramakz.a();
    paramakz.c();
    paramakz.f();
    paramakz.d();
    return true;
  }

  private alb getFirstPoint()
  {
    if (this.b == null)
      return null;
    return this.b;
  }

  private alb getLastPoint()
  {
    if (this.c.size() == 0)
      return null;
    return (alb)this.c.get(this.c.size() - 1);
  }

  public abstract void a();

  public void a(float paramFloat)
  {
    float f1 = this.q + (this.m - this.q) * paramFloat;
    paramFloat = this.r + (this.n - this.r) * paramFloat;
    if (paramFloat >= f1 - 1.0F)
    {
      this.s = 0.0F;
      return;
    }
    this.s = ((paramFloat - 1.0F - f1) / 2.0F);
  }

  public void a(alb paramalb, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 1;
    if (paramBoolean)
    {
      if (this.w != paramalb);
      while (true)
      {
        this.w = paramalb;
        i2 = i1;
        if (this.w != null)
        {
          paramalb = getFirstPoint();
          i2 = i1;
          if (paramalb != null)
          {
            paramalb.a = this.w;
            this.w.b = paramalb;
            paramalb.c.a = this.w.c;
            this.w.c.b = paramalb.c;
            i2 = i1;
          }
        }
        if (i2 != 0)
          d();
        return;
        i1 = 0;
      }
    }
    if (this.x != paramalb);
    for (i1 = i2; ; i1 = 0)
    {
      this.x = paramalb;
      i2 = i1;
      if (this.x == null)
        break;
      paramalb = getLastPoint();
      i2 = i1;
      if (paramalb == null)
        break;
      paramalb.b = this.x;
      this.x.a = paramalb;
      paramalb.c.b = this.x.c;
      this.x.c.a = paramalb.c;
      i2 = i1;
      break;
    }
  }

  protected void a(Context paramContext)
  {
    this.v = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    this.y = (paramContext.getResources().getDisplayMetrics().density * 5.5F);
    this.t = new Paint(1);
    this.t.setTextAlign(Align.CENTER);
    this.t.setTextSize(paramContext.getResources().getDisplayMetrics().density * 12.0F);
    this.t.setColor(-855638017);
    this.u = this.t.getFontMetrics();
  }

  public abstract void a(boolean paramBoolean);

  protected void b()
  {
    this.k = this.e;
    this.o = this.e;
    this.l = this.f;
    this.p = this.f;
    this.m = this.g;
    this.q = this.g;
    this.n = this.h;
    this.r = this.h;
  }

  protected void c()
  {
    if (this.m >= this.n - 1.0F)
    {
      this.s = 0.0F;
      return;
    }
    this.s = ((this.n - 1.0F - this.m) / 2.0F);
  }

  protected void d()
  {
    this.A = true;
    invalidate();
  }

  protected void e()
  {
    this.p = this.l;
    this.o = this.k;
    this.q = this.m;
    this.r = this.n;
    this.z.f();
    this.z.e();
  }

  protected void f()
  {
    if (this.i)
    {
      e();
      this.z.f();
    }
  }

  public void setData(ArrayList<ala> paramArrayList)
  {
    this.a = null;
    this.b = null;
    this.c.clear();
    this.d = null;
    this.e = -1000.0F;
    this.f = 1000.0F;
    this.g = -1000.0F;
    this.h = 1000.0F;
    b();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i2 = paramArrayList.size();
      alb localalb2 = new alb();
      this.a = localalb2;
      alb localalb1 = new alb();
      this.b = localalb1;
      int i1 = 0;
      if (i1 < i2)
      {
        ala localala = (ala)paramArrayList.get(i1);
        if (localala.a > this.e)
          this.e = localala.a;
        if (localala.b < this.f)
          this.f = localala.b;
        if (localala.a < this.h)
          this.h = localala.a;
        if (localala.b > this.g)
          this.g = localala.b;
        if (i1 == 0)
        {
          localalb2.b(localala.a);
          localalb1.b(localala.b);
          label225: if (localala.e)
            break label310;
          bool = true;
          label236: localalb1.s = bool;
          if (localala.e)
            break label316;
        }
        label310: label316: for (boolean bool = true; ; bool = false)
        {
          localalb1.t = bool;
          localalb1.c = localalb2;
          localalb2.c = localalb1;
          this.c.add(localalb1);
          i1 += 1;
          break;
          localalb2 = localalb2.a(localala.a);
          localalb1 = localalb1.a(localala.b);
          break label225;
          bool = false;
          break label236;
        }
      }
    }
    b();
    c();
    a();
    d();
    this.i = true;
    this.j = -1L;
    a(false);
    invalidate();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     akz
 * JD-Core Version:    0.6.2
 */