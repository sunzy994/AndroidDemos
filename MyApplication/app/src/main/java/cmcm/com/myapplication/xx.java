package cmcm.com.myapplication;

import android.graphics.Point;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.DeleteZone;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.FanLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xx
  implements xw
{
  private int a = -1;
  private int b = -1;
  private FanItem c;
  private yw d;
  private final FanLayer e;
  private int f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private int l = aqr.b;
  private WeakReference<xz> m;

  public xx(FanLayer paramFanLayer)
  {
    this.e = paramFanLayer;
  }

  private TranslateAnimation a(yl paramyl1, yl paramyl2, yl paramyl3)
  {
    int n = paramyl1.a;
    int i1 = paramyl3.a;
    int i2 = paramyl2.a;
    int i3 = paramyl3.a;
    int i4 = -(paramyl1.b - paramyl3.b);
    int i5 = -(paramyl2.b - paramyl3.b);
    paramyl1 = new TranslateAnimation(n - i1, i2 - i3, i4, i5);
    paramyl1.setFillAfter(true);
    paramyl1.setDuration(300L);
    return paramyl1;
  }

  private void a(int paramInt)
  {
    int n;
    if (paramInt > this.b)
    {
      n = this.b + 1;
      while (n <= paramInt)
      {
        b(n, n - 1);
        n += 1;
      }
    }
    if (paramInt < this.b)
    {
      n = this.b - 1;
      while (n >= paramInt)
      {
        b(n, n + 1);
        n -= 1;
      }
    }
  }

  private void a(final int paramInt1, final int paramInt2, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.c.getTouchDownPoint();
    if (this.j);
    for (paramFloat1 = paramFloat1 - ((Point)localObject).x - this.e.getFan().getCenterOffset(); ; paramFloat1 = paramFloat1 - ((Point)localObject).x - this.f + this.e.getFan().getCenterOffset())
    {
      int n = (int)paramFloat1;
      int i1 = (int)(this.g - (paramFloat2 - ((Point)localObject).y) - this.e.getFan().getCenterOffset());
      localObject = a(new yl(n + this.c.getWidth() / 2, i1 - this.c.getHeight() / 2), yk.a(paramInt2, g().size(), this.j), yk.a(this.a, g().size(), this.j));
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          xx.a(xx.this).post(new Runnable()
          {
            public void run()
            {
              yw.g = true;
              xx.a(xx.this).m();
              xx.this.a(xx.2.this.a, xx.2.this.b);
              xx.this.c();
              xx.this.b();
              xx.a(xx.this).n();
              yw.g = false;
            }
          });
        }
      });
      this.c.startAnimation((Animation)localObject);
      return;
    }
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.c == null);
    while (this.b != this.a)
      return false;
    Object localObject = this.c.getTouchDownPoint();
    if (this.j);
    for (paramFloat1 = paramFloat1 - ((Point)localObject).x - this.e.getFan().getCenterOffset(); ; paramFloat1 = paramFloat1 - ((Point)localObject).x - this.f + this.e.getFan().getCenterOffset())
    {
      int n = (int)paramFloat1;
      int i1 = (int)(this.g - (paramFloat2 - ((Point)localObject).y) - this.e.getFan().getCenterOffset());
      localObject = new yl(n + this.c.getWidth() / 2, i1 - this.c.getHeight() / 2);
      yl localyl = yk.a(this.a, g().size(), this.j);
      localObject = a((yl)localObject, localyl, localyl);
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          xx.a(xx.this).post(new Runnable()
          {
            public void run()
            {
              yw.g = true;
              xx.a(xx.this).m();
              xx.this.c();
              xx.this.b();
              xx.a(xx.this).n();
              yw.g = false;
            }
          });
        }
      });
      this.c.startAnimation((Animation)localObject);
      return true;
    }
  }

  private int b(View paramView)
  {
    List localList = g();
    int n = 0;
    while (n < localList.size())
    {
      if (localList.get(n) == paramView)
        return n;
      n += 1;
    }
    return -1;
  }

  private View b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= g().size()))
      return null;
    return (View)g().get(paramInt);
  }

  private void b(int paramInt1, int paramInt2)
  {
    int n;
    if ((paramInt1 >= Math.min(this.b, this.a)) && (paramInt1 <= Math.max(this.b, this.a)))
      if (this.b > this.a)
        n = paramInt1 + 1;
    while (true)
    {
      yl localyl1 = yk.a(paramInt1, g().size(), this.e.c);
      yl localyl2 = yk.a(paramInt2, g().size(), this.e.c);
      yl localyl3 = yk.a(n, g().size(), this.e.c);
      View localView = b(n);
      if (localView == null)
      {
        return;
        if (this.b < this.a)
          n = paramInt1 - 1;
      }
      else
      {
        localView.startAnimation(a(localyl1, localyl2, localyl3));
        return;
        n = paramInt1;
      }
    }
  }

  private void c(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null)
      return;
    this.k = true;
    this.c.clearAnimation();
    this.c.setVisibility(8);
    if ((this.m != null) && (this.m.get() != null))
      ((xz)this.m.get()).a();
    int n = b(this.c);
    this.a = n;
    this.b = n;
    this.e.f = DeleteZone.a(this.e.getFan());
    this.e.r();
    this.l = this.e.getLayerType();
    this.e.setLayerType(0, null);
  }

  private void d(DragEvent paramDragEvent)
  {
    int i1 = 1;
    if (paramDragEvent == null)
      return;
    int i2 = h(paramDragEvent);
    if (this.e.f != null)
    {
      if (i(paramDragEvent))
        this.e.f.a();
    }
    else
    {
      label42: paramDragEvent = b(i2);
      if ((paramDragEvent == null) || (!(paramDragEvent.getTag() instanceof yw)) || (!((yw)paramDragEvent.getTag()).c()))
        break label167;
      n = 1;
      label78: if ((!this.e.l()) || (!this.d.c()) || (n == 0))
        break label172;
    }
    label167: label172: for (int n = i1; ; n = 0)
    {
      if ((this.b != -1) && (i2 != -1) && (this.b != i2) && (n != 0))
        a(i2);
      if ((i2 == -1) || (n == 0))
        break;
      this.b = i2;
      return;
      this.e.f.b();
      break label42;
      n = 0;
      break label78;
    }
  }

  private List<yw> e()
  {
    if (asq.a(g()))
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext())
    {
      FanItem localFanItem = (FanItem)localIterator.next();
      if ((localFanItem != null) && ((localFanItem.getTag() instanceof yw)) && (!(localFanItem.getTag() instanceof ys)))
        localArrayList.add((yw)localFanItem.getTag());
    }
    return localArrayList;
  }

  private void e(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null);
    while (paramDragEvent.getResult())
      return;
    b();
    f();
  }

  private void f()
  {
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext())
      ((FanItem)localIterator.next()).clearAnimation();
    c();
  }

  private boolean f(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null)
      return false;
    if (this.c == null)
      return false;
    int n = this.a;
    int i1 = h(paramDragEvent);
    if (i(paramDragEvent))
    {
      g(paramDragEvent);
      return true;
    }
    View localView = b(i1);
    if ((localView == null) || (!(localView.getTag() instanceof yw)) || (!((yw)localView.getTag()).c()))
      return a(paramDragEvent.getX(), paramDragEvent.getY());
    if (!this.d.c())
      return false;
    if (this.e.l())
    {
      a(n, i1, paramDragEvent.getX(), paramDragEvent.getY());
      return true;
    }
    return false;
  }

  private List<FanItem> g()
  {
    return this.e.getItems();
  }

  private void g(DragEvent paramDragEvent)
  {
    if (this.e.f != null)
      this.e.f.a(paramDragEvent, this);
  }

  private int h(DragEvent paramDragEvent)
  {
    int n;
    if (paramDragEvent == null)
      n = -1;
    int i1;
    do
    {
      return n;
      i1 = yk.a((int)paramDragEvent.getX(), (int)paramDragEvent.getY(), g().size(), this.h, this.i, this.f, this.g, this.j);
      if (i1 < 0)
        break;
      n = i1;
    }
    while (i1 < g().size());
    return -1;
  }

  private boolean i(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null);
    while (paramDragEvent.getY() > this.g)
      return false;
    float f1;
    if (this.j)
    {
      f1 = paramDragEvent.getX();
      float f2 = this.g;
      float f3 = paramDragEvent.getY();
      if ((float)Math.hypot(f1, f2 - f3) >= this.e.getFan().getTabSectorOuterSize() - this.h / 4)
        break label97;
    }
    label97: for (boolean bool = true; ; bool = false)
    {
      return bool;
      f1 = this.f - paramDragEvent.getX();
      break;
    }
  }

  public void a()
  {
    if ((this.c == null) || (!(this.c.getTag() instanceof yw)))
      return;
    final FanItem localFanItem = this.c;
    final int n = this.a;
    this.e.post(new Runnable()
    {
      public void run()
      {
        try
        {
          xx.a(xx.this).a(localFanItem, (yw)localFanItem.getTag(), n);
          return;
        }
        catch (Exception localException)
        {
          asq.b(localException);
        }
      }
    });
    this.a = -1;
    this.b = -1;
    this.c = null;
  }

  void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1));
    while (paramInt1 == paramInt2)
      return;
    while (true)
    {
      try
      {
        Object localObject = new ArrayList(g());
        FanItem localFanItem = (FanItem)((ArrayList)localObject).get(paramInt1);
        if (paramInt1 < paramInt2)
        {
          n = paramInt1;
          if (n < paramInt2)
          {
            ((ArrayList)localObject).set(n, ((ArrayList)localObject).get(n + 1));
            n += 1;
            continue;
            if (n > paramInt2)
            {
              ((ArrayList)localObject).set(n, ((ArrayList)localObject).get(n - 1));
              n -= 1;
              continue;
            }
          }
          ((ArrayList)localObject).set(paramInt2, localFanItem);
          this.e.setItems((ArrayList)localObject);
          this.e.o();
          this.e.m();
          localObject = e();
          this.e.getTab().a((List)localObject, paramInt1, paramInt2, new xy()
          {
            public void a(List<yw> paramAnonymousList)
            {
              xx.a(xx.this).a(xx.a(xx.this).getTab(), paramAnonymousList, null, false, false, xx.a(xx.this).d);
            }
          });
          return;
        }
      }
      catch (Exception localException)
      {
        asp.b("Swipe.DADHandler", "shiftPosition failed, srcIndex = " + paramInt1 + ", targetIndex = " + paramInt2, localException);
        return;
      }
      int n = paramInt1;
    }
  }

  public void a(View paramView)
  {
    if (!this.e.k());
    Object localObject;
    do
    {
      do
        return;
      while (!(paramView instanceof FanItem));
      localObject = paramView.getTag();
    }
    while ((!(localObject instanceof yw)) || (!((yw)localObject).o()));
    this.c = ((FanItem)paramView);
    this.d = ((yw)localObject);
    this.f = this.e.getWidth();
    this.g = this.e.getHeight();
    this.j = this.e.c;
    this.h = this.c.getWidth();
    this.i = this.c.getHeight();
    paramView = new xz(SwipeApplication.c());
    this.m = new WeakReference(paramView);
    paramView.a(this.c);
  }

  public boolean a(DragEvent paramDragEvent)
  {
    if (!this.e.k());
    while ((this.c == null) || (paramDragEvent == null) || (this.c != paramDragEvent.getLocalState()))
      return false;
    return true;
  }

  void b()
  {
    this.k = false;
    this.a = -1;
    this.b = -1;
    if ((this.m != null) && (this.m.get() != null))
    {
      ((xz)this.m.get()).b();
      this.m.clear();
      this.m = null;
    }
    if (this.c != null)
    {
      this.c.setVisibility(0);
      this.c = null;
    }
    if (this.e.f != null)
      this.e.f.b(this.e.getFan());
    this.e.r();
    this.e.setLayerType(this.l, null);
  }

  public boolean b(DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    case 5:
    case 6:
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return false;
      c(paramDragEvent);
      return true;
      d(paramDragEvent);
      continue;
      return f(paramDragEvent);
      e(paramDragEvent);
    }
  }

  protected void c()
  {
    try
    {
      this.e.i();
      return;
    }
    catch (Exception localException)
    {
      asq.b(localException);
    }
  }

  public boolean d()
  {
    return this.k;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xx
 * JD-Core Version:    0.6.2
 */