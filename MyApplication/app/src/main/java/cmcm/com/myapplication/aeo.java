package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import java.util.Random;

public abstract class aeo extends Drawable
{
  protected boolean a = true;
  private final aes b;
  private final aes c;
  private int d = 0;
  private Bitmap e;
  private Bitmap f;
  private final SparseArray<Bitmap> g = new SparseArray();
  private float h;
  private final Random i;
  private final Context j;
  private final aeq k;
  private final aeq l;
  private final aer m = new aer(this, null);
  private aep n;
  private boolean o = true;
  private float p;
  private boolean q;
  private final RectF r = new RectF();

  public aeo(Context paramContext)
  {
    this.j = paramContext;
    float f1 = paramContext.getResources().getDisplayMetrics().density * 40.0F;
    this.b = new aes(6).a(f1);
    this.c = new aes(5).a(f1);
    this.k = new aeq(this, null);
    this.k.a = this.b;
    this.l = new aeq(this, null);
    this.l.a = this.c;
    this.i = new Random();
  }

  static void a(PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    if (Float.compare(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2, 0.0F) == 0)
      return;
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (-paramFloat2 * paramPointF.x + paramPointF.y * paramFloat1 < 0.0F)
    {
      f2 = paramFloat1 * -1.0F;
      f1 = paramFloat2 * -1.0F;
    }
    paramFloat2 = (float)Math.hypot(f2, f1);
    paramFloat1 = f2 / paramFloat2;
    paramFloat2 = f1 / paramFloat2;
    f1 = Math.abs(paramPointF.x * 2.0F * -paramFloat2 + paramPointF.y * 2.0F * paramFloat1);
    paramPointF.set(-paramFloat2 * f1 - paramPointF.x, paramFloat1 * f1 - paramPointF.y);
  }

  private void c()
  {
    this.e = m();
    this.f = l();
    this.k.a(this.j, this.i.nextInt(6) + 1);
    this.l.a(this.j, this.i.nextInt(6) + 1);
    if (this.o)
    {
      this.o = false;
      this.b.b((float)(Math.pow(-1.0D, this.i.nextInt()) * 60));
      this.c.b((float)(Math.pow(-1.0D, this.i.nextInt()) * 60));
      this.b.b(10 - this.i.nextInt(5), this.i.nextInt(10) + 55);
      this.c.b(this.i.nextInt(5) - 15, this.i.nextInt(10) + 50);
    }
    while (true)
    {
      this.d = 1;
      invalidateSelf();
      return;
      float f1 = this.i.nextInt(10) + 25;
      float f2 = (float)Math.toRadians(this.i.nextInt(360));
      this.b.b((float)(Math.pow(-1.0D, this.i.nextInt()) * 60)).b((float)(Math.cos(f2) * f1), (float)(Math.sin(f2) * f1));
      f1 = this.i.nextInt(10) + 25;
      f2 = (float)Math.toRadians(this.i.nextInt(360));
      this.c.b((float)(Math.pow(-1.0D, this.i.nextInt()) * 60)).b((float)(Math.cos(f2) * f1), (float)(Math.sin(f2) * f1));
    }
  }

  private void d()
  {
    int i1 = 1;
    if (this.d == 0);
    label232: label235: 
    while (true)
    {
      return;
      Rect localRect = getBounds();
      if (this.d == 1)
        if ((this.b.a() | this.c.a()))
        {
          invalidateSelf();
          if (this.d != 1)
            break label232;
          boolean bool = this.b.a(localRect.left + this.r.left, localRect.top + this.r.top, localRect.right - this.r.right, localRect.bottom - this.r.bottom);
          if (!(this.c.a(localRect.left + this.r.left, localRect.top + this.r.top, localRect.right - this.r.right, localRect.bottom - this.r.bottom) | bool))
            break label232;
        }
      while (true)
      {
        if ((i1 | aes.a(this.b, this.c)) == 0)
          break label235;
        return;
        this.d = 0;
        f();
        break;
        if (e())
        {
          invalidateSelf();
          break;
        }
        this.d = 0;
        f();
        break;
        i1 = 0;
      }
    }
  }

  private boolean e()
  {
    return this.b.b() | this.c.b();
  }

  private void f()
  {
    if (this.n != null)
      this.n.a();
    this.m.a(this.b, this.c, 500);
    invalidateSelf();
  }

  public abstract Bitmap a(int paramInt);

  public void a(float paramFloat)
  {
    if (paramFloat > this.h)
    {
      this.h = paramFloat;
      invalidateSelf();
    }
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.r.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    this.p = paramFloat;
    this.q = paramBoolean;
    this.m.a(getBounds());
  }

  public void a(aep paramaep)
  {
    b(paramaep);
    j();
  }

  public RectF[] a()
  {
    if ((!b()) || (this.k == null) || (!atw.b(this.k.c)))
      return null;
    int i1 = this.k.c.getWidth() / 2;
    float f1 = this.m.a.x;
    float f2 = i1;
    float f3 = this.m.a.y;
    float f4 = i1;
    float f5 = this.m.a.x;
    float f6 = i1;
    float f7 = this.m.a.y;
    RectF localRectF = new RectF(f1 - f2, f3 - f4, f5 + f6, i1 + f7);
    i1 = this.l.c.getWidth() / 2;
    f1 = this.m.b.x;
    f2 = i1;
    f3 = this.m.b.y;
    f4 = i1;
    f5 = this.m.b.x;
    f6 = i1;
    f7 = this.m.b.y;
    return new RectF[] { localRectF, new RectF(f1 - f2, f3 - f4, f5 + f6, i1 + f7) };
  }

  public void b(aep paramaep)
  {
    this.n = paramaep;
  }

  public boolean b()
  {
    return this.d == 0;
  }

  public void draw(Canvas paramCanvas)
  {
    try
    {
      if ((this.a) && (this.h > 0.0F))
        paramCanvas.drawColor(Color.argb((int)(255.0F * this.h), 0, 0, 0));
      if ((this.d == 0) && (this.m.b()))
        invalidateSelf();
      this.k.a(paramCanvas);
      this.l.a(paramCanvas);
      d();
      return;
    }
    catch (Exception paramCanvas)
    {
    }
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean h()
  {
    return this.d == 1;
  }

  public void i()
  {
    if (this.d != 0)
      return;
    this.m.a();
    c();
  }

  public void j()
  {
    if (this.d != 1)
    {
      if (this.n != null)
        this.n.a();
      return;
    }
    this.d = 2;
  }

  public void k()
  {
    atw.a(this.e);
    atw.a(this.f);
    int i1 = 1;
    while (i1 <= 6)
    {
      atw.a((Bitmap) this.g.get(i1));
      i1 += 1;
    }
  }

  public abstract Bitmap l();

  public abstract Bitmap m();

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.b.a(paramRect.width() * 0.45F, paramRect.top - aes.a(this.b));
    this.c.a(paramRect.width() * 0.75F, paramRect.top - aes.a(this.b));
    this.o = true;
    this.m.a(paramRect);
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aeo
 * JD-Core Version:    0.6.2
 */