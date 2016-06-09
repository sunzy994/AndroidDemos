package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class zc extends aue
{
  final Random a = new Random();
  final float[] b = new float[3];
  final float c;
  private final PointF d;
  private final float e;
  private final ArrayList<ze> f;
  private final ArrayList<ze> g;
  private final ArrayList<ze> h;
  private final Context i;
  private boolean j = false;
  private float k;
  private boolean l = false;
  private int m = 0;
  private boolean n = false;
  private int o = 2;

  public zc(Context paramContext)
  {
    this.i = paramContext;
    this.d = new PointF();
    this.f = new ArrayList(38);
    this.g = new ArrayList(19);
    this.h = new ArrayList(19);
    this.d.set(getIntrinsicWidth() / 2.0F, getIntrinsicHeight() / 2.0F);
    this.e = (getIntrinsicWidth() / 2.0F);
    this.c = (this.e / 1.5F * 2.0F / 500.0F * 17.0F);
    if (this.f.isEmpty())
    {
      this.g.clear();
      this.h.clear();
      if (i1 < 38)
      {
        paramContext = new ze(this);
        this.f.add(paramContext);
        if (i1 < 19)
          this.g.add(paramContext);
        while (true)
        {
          i1 += 1;
          break;
          this.h.add(paramContext);
        }
      }
    }
    d();
  }

  private void b()
  {
    invalidateSelf();
  }

  private void b(boolean paramBoolean)
  {
    this.l = false;
    if (paramBoolean)
    {
      a(false);
      return;
    }
    d();
  }

  private void c()
  {
    boolean bool;
    if (this.l)
    {
      this.m += 1;
      if (this.m > 117.64706F)
        bool = true;
    }
    while (true)
    {
      Iterator localIterator = this.f.iterator();
      int i1 = 0;
      label41: int i2;
      if (localIterator.hasNext())
      {
        ze localze = (ze)localIterator.next();
        if (!localze.h)
          break label122;
        localze.a(bool);
        if (!localze.b())
        {
          i2 = 1;
          label83: i1 = i2 | i1;
        }
      }
      label122: 
      while (true)
      {
        break label41;
        bool = false;
        break;
        i2 = 0;
        break label83;
        if (bool)
          b(true);
        if (i1 != 0)
          b();
        return;
      }
      bool = true;
    }
  }

  private void d()
  {
    boolean bool;
    zd localzd;
    if (!this.n)
    {
      bool = true;
      this.n = bool;
      localzd = new zd(19);
      this.o = 2;
      this.j = false;
      if (!this.n)
        break label100;
    }
    label100: for (Object localObject = this.g; ; localObject = this.h)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ze localze = (ze)((Iterator)localObject).next();
        localze.a(localzd.a());
        localze.d.set(0.0F, 0.0F);
      }
      bool = false;
      break;
    }
  }

  public void a()
  {
    a(true);
  }

  public void a(boolean paramBoolean)
  {
    if (this.l)
      return;
    this.l = true;
    this.m = 0;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ze localze = (ze)localIterator.next();
      if ((localze.h) && ((paramBoolean) || (localze.b())))
        localze.b(false);
    }
    b();
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.k > 0.0F)
      paramCanvas.drawColor(Color.argb((int)(255.0F * this.k), 0, 0, 0));
    paramCanvas.save();
    Iterator localIterator = this.f.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((ze)localIterator.next()).a(paramCanvas) | bool);
    paramCanvas.restore();
    if (bool)
      b();
    while (true)
    {
      if (this.l)
        c();
      return;
      if (!this.j)
        this.j = true;
    }
  }

  public int getIntrinsicHeight()
  {
    return aqs.ad();
  }

  public int getIntrinsicWidth()
  {
    return aqs.ac();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zc
 * JD-Core Version:    0.6.2
 */