package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class aej extends ars
  implements afb
{
  private static final String a = "Swipe." + aej.class.getSimpleName();
  private static volatile int d = 0;
  private final Context b;
  private final int c;
  private int f;
  private final Set<Object> g = Collections.synchronizedSet(new LinkedHashSet(4));
  private volatile boolean h;
  private final long i;
  private volatile boolean j;
  private aek k;

  public aej(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null);
  }

  public aej(Context paramContext, int paramInt, aek paramaek)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramInt;
    this.k = paramaek;
    this.i = 32000L;
  }

  public int a(Object paramObject)
  {
    if ((paramObject instanceof aem))
      return ((aem)paramObject).a.a;
    return 0;
  }

  public void a()
  {
    d += 1;
  }

  public void a(aek paramaek)
  {
    this.k = paramaek;
  }

  public void a(afa paramafa, Bitmap paramBitmap)
  {
    c(new aem(paramafa, paramBitmap));
  }

  public void a(afa paramafa, String paramString)
  {
    a(new aem(paramafa), -99, paramString);
  }

  protected void a(Object paramObject, int paramInt, String paramString)
  {
    if ((this.h) || (this.j) || (n() >= 1))
    {
      if (!this.h)
        q();
      if ((this.k != null) && ((paramObject == null) || (d == a(paramObject))))
        this.k.a(paramObject, paramInt, paramString);
      d += 1;
      return;
    }
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    this.j = false;
    this.h = false;
    if (paramBoolean)
    {
      this.f = -1;
      m();
    }
    if (o())
    {
      int m = this.g.size();
      if (m > 0)
      {
        Object localObject = this.g.iterator().next();
        if ((localObject instanceof aem))
          ((aem)localObject).a.a = d;
        c(localObject);
        return;
      }
      if (m < 4)
      {
        m = this.f;
        if (this.k != null)
          this.k.a();
        this.f = abd.a(this.c, 0, m);
        a();
      }
    }
    switch (this.f)
    {
    default:
      a(null, -3, "Content is null");
      return;
    case 0:
    }
    aez.a(this.b, this, d);
  }

  public void a(boolean paramBoolean, aek paramaek)
  {
    a(paramaek);
    a(paramBoolean);
  }

  public void b()
  {
    this.j = true;
    a(null);
  }

  public void b(Object paramObject)
  {
    this.g.remove(paramObject);
  }

  protected void c(Object paramObject)
  {
    if (!this.h)
      q();
    if ((this.h) || (this.j) || (a(paramObject) != d))
      this.g.add(paramObject);
    while (this.k == null)
      return;
    this.k.a(paramObject);
  }

  protected long g()
  {
    return this.i;
  }

  public void h()
  {
    this.h = true;
    a(null, -1, "Timeout");
  }

  protected int i()
  {
    return 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aej
 * JD-Core Version:    0.6.2
 */