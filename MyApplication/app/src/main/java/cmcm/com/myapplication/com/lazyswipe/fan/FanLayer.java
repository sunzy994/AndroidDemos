package cmcm.com.myapplication.com.lazyswipe.fan;

import aal;
import aao;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import asw;
import auu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vs;
import wk;
import xu;
import xx;
import yb;
import yd;
import yj;
import yk;
import yl;
import ys;
import yw;

public class FanLayer extends xu
  implements OnClickListener, OnLongClickListener
{
  private static final String g = "Swipe." + FanLayer.class.getSimpleName();
  boolean e;
  public DeleteZone f;
  private aao h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private final xx m;
  private ArrayList<FanItem> n = new ArrayList();
  private ys o;
  private final HashMap<String, PointF> p = new HashMap();
  private int q;
  private final Runnable r = new Runnable()
  {
    public void run()
    {
      if (yb.getInstance() == null);
      do
      {
        return;
        Log.i("Swipe.DADHandler", "mDragStateChecker ");
      }
      while ((!FanLayer.this.d) || (FanLayer.d(FanLayer.this).d()) || (FanLayer.this.e));
      FanLayer.this.i();
    }
  };

  public FanLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = ys.a(paramContext);
    this.m = new xx(this);
  }

  private FanItem a(yw paramyw, boolean paramBoolean1, boolean paramBoolean2)
  {
    FanItem localFanItem = (FanItem)LayoutInflater.from(getContext()).inflate(2130968629, this, false);
    b(localFanItem, paramyw, paramBoolean2);
    if ((paramBoolean1) && (paramyw != null) && (paramyw != this.o))
      localFanItem.c();
    return localFanItem;
  }

  private void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      if (paramInt1 < paramInt2);
      try
      {
        FanItem localFanItem = (FanItem)this.n.get(paramInt1);
        localArrayList.add(localFanItem);
        localFanItem.clearAnimation();
        if (indexOfChild(localFanItem) > 0)
          detachViewFromParent(localFanItem);
        if ((localFanItem.getTag() instanceof yw))
          ((yw)localFanItem.getTag()).l();
        label77: paramInt1 += 1;
        continue;
        this.n.removeAll(localArrayList);
        return;
      }
      catch (Exception localException)
      {
        break label77;
      }
    }
  }

  private void a(List<yw> paramList)
  {
    this.o.l();
    if ((paramList.isEmpty()) && (e()))
    {
      paramList.add(this.o);
      this.e = true;
      return;
    }
    this.e = false;
  }

  private void a(yl paramyl, boolean paramBoolean1, boolean paramBoolean2, final List<yw> paramList, int paramInt1, int paramInt2, int paramInt3, final AnimationListener paramAnimationListener)
  {
    final yw localyw = (yw)paramList.get(paramInt3);
    boolean bool;
    label45: yl localyl;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt3 >= paramInt2)
    {
      bool = true;
      if (!bool)
        break label238;
      paramList = a(localyw, this.d, this.i);
      if ((localyw instanceof ys))
      {
        this.o = ((ys)localyw);
        if (!c())
          this.o.b(getContext());
        this.e = true;
      }
      if (!paramBoolean1)
        a(localyw);
      localyl = yk.a(paramInt3, paramInt1, this.c);
      localLayoutParams = paramList.a(paramInt3, localyl, bool);
      if (!bool)
        break label267;
      addViewInLayout(paramList, paramInt3, localLayoutParams);
      this.n.add(paramList);
      label147: if (!paramBoolean1)
        paramList.c(false);
      paramList.d = paramyl;
      paramList.e = localyl;
      if (a(paramyl, paramBoolean1, paramBoolean2))
        if (paramBoolean1)
          break label280;
    }
    label267: label280: for (paramBoolean1 = true; ; paramBoolean1 = false)
    {
      paramyl = yd.a(paramInt3, paramyl, localyl, paramBoolean1);
      paramyl.setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (paramAnimationListener != null)
            paramAnimationListener.onAnimationEnd(paramAnonymousAnimation);
          if ((localyw.e() != null) && (localyw.e().n))
          {
            localyw.e().n = false;
            FanLayer.this.postDelayed(new Runnable()
            {
              public void run()
              {
                FanLayer.2.this.c.l();
              }
            }
            , 400L);
          }
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          if (paramAnimationListener != null)
            paramAnimationListener.onAnimationStart(paramAnonymousAnimation);
        }
      });
      paramList.startAnimation(paramyl);
      paramList.setIconPressAnimationEnable(true);
      paramList.k();
      return;
      bool = false;
      break;
      label238: paramList = (FanItem)this.n.get(paramInt3);
      b(paramList, localyw, this.i);
      break label45;
      attachViewToParent(paramList, paramInt3, localLayoutParams);
      break label147;
    }
  }

  private void a(yw paramyw)
  {
    if (!yw.g)
      return;
    PointF localPointF = (PointF)this.p.get(paramyw.i());
    if (localPointF != null)
    {
      paramyw.e = localPointF.x;
      paramyw.f = localPointF.y;
      return;
    }
    paramyw.e = -100.0F;
    paramyw.f = -100.0F;
  }

  private boolean a(yl paramyl, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramBoolean1) && (!paramBoolean2) && (paramyl != null) && (!yb.v());
  }

  private void c(FanItem paramFanItem)
  {
    if ((paramFanItem.getTag() instanceof yw))
      ((yw)paramFanItem.getTag()).l();
    this.n.remove(paramFanItem);
    try
    {
      detachViewFromParent(paramFanItem);
      label34: yw.g = true;
      m();
      i();
      o();
      yw.g = false;
      n();
      ((ItemSector)getParent()).a(this.h.h(), this.n.size());
      if ((this.n != null) && ((this.n.size() == 0) || ((this.n.size() == 1) && (a(((FanItem)this.n.get(0)).getTag())))))
        j();
      return;
    }
    catch (Throwable paramFanItem)
    {
      break label34;
    }
  }

  private void d(FanItem paramFanItem)
  {
    if (!(paramFanItem.getTag() instanceof yw))
      return;
    a((yw)paramFanItem.getTag());
  }

  private void s()
  {
    String str = this.h.b();
    int i1 = -1;
    switch (str.hashCode())
    {
    default:
    case 2095953157:
    case 951526432:
    case -176414240:
    case -85276959:
    }
    while (true)
      switch (i1)
      {
      default:
        this.l = true;
        this.i = false;
        this.k = false;
        this.j = false;
        return;
        if (str.equals("recentlyUsed"))
        {
          i1 = 0;
          continue;
          if (str.equals("contact"))
          {
            i1 = 1;
            continue;
            if (str.equals("mostUsed"))
            {
              i1 = 2;
              continue;
              if (str.equals("switcher"))
                i1 = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    this.j = true;
    this.l = false;
    this.i = false;
    this.k = false;
    return;
    this.k = true;
    this.l = false;
    this.i = false;
    this.j = false;
    return;
    this.i = true;
    this.l = false;
    this.k = false;
    this.j = false;
  }

  protected void a(int paramInt)
  {
    b(false);
    int i2 = Math.min(paramInt, this.n.size());
    int i1 = 0;
    while (i1 < i2)
    {
      FanItem localFanItem = (FanItem)this.n.get(i1);
      d(localFanItem);
      FrameLayout.LayoutParams localLayoutParams = localFanItem.a(i1, yk.a(i1, paramInt, this.c), false);
      localFanItem.c(false);
      attachViewToParent(localFanItem, i1, localLayoutParams);
      i1 += 1;
    }
    requestLayout();
    ((ItemSector)getParent()).a(this.h.h(), paramInt);
  }

  public void a(aao paramaao, List<yw> paramList, yl paramyl, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramaao, paramList, paramyl, paramBoolean1, paramBoolean2, this.d);
  }

  public void a(aao paramaao, List<yw> paramList, yl paramyl, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 0;
    auu.a(System.currentTimeMillis() + ": FanLayer.popItems starts " + this);
    this.d = paramBoolean3;
    this.h = paramaao;
    s();
    paramList = new ArrayList(paramList);
    a(paramList);
    b(paramBoolean2);
    int i2 = paramList.size();
    int i3 = this.n.size();
    this.q = 0;
    if (!a(paramyl, paramBoolean1, paramBoolean2))
      paramaao = null;
    while (i1 < i2)
    {
      a(paramyl, paramBoolean1, paramBoolean2, paramList, i2, i3, i1, paramaao);
      i1 += 1;
      continue;
      paramaao = new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          FanLayer.b(FanLayer.this);
          if (FanLayer.c(FanLayer.this) == 0)
            FanLayer.this.a.a(false);
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          FanLayer.a(FanLayer.this);
        }
      };
    }
    if ((!paramBoolean2) && (i2 < i3))
      a(i2, i3);
    if (yb.v())
      p();
    requestLayout();
    auu.a(System.currentTimeMillis() + ": FanLayer.popItems ends");
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.m.a(paramView);
  }

  protected void a(final FanItem paramFanItem)
  {
    paramFanItem.d();
    if (paramFanItem.getVisibility() == 8)
    {
      c(paramFanItem);
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        FanLayer.this.post(new Runnable()
        {
          public void run()
          {
            FanLayer.a(FanLayer.this, FanLayer.3.this.a);
          }
        });
      }
    });
    setLayerType(0, null);
    paramFanItem.startAnimation(localScaleAnimation);
  }

  void a(yl paramyl)
  {
    if (Build.VERSION.SDK_INT >= 11)
      setLayerType(0, null);
    int i2 = this.n.size();
    Iterator localIterator = this.n.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      ((View)localIterator.next()).startAnimation(yd.a(i1, yk.a(i1, i2, this.c), paramyl));
      i1 += 1;
    }
  }

  public void a(boolean paramBoolean)
  {
    ((ItemSector)getParent()).a(this.h, this.a.a(this.h), true, this.h.h(), true);
    if ((this.n != null) && ((this.n.size() == 0) || ((this.n.size() == 1) && (a(((FanItem)this.n.get(0)).getTag())))))
      j();
  }

  protected boolean a()
  {
    return this.i;
  }

  public boolean a(Object paramObject)
  {
    return paramObject == this.o;
  }

  public void b(int paramInt)
  {
    animate().alpha(0.0F).setDuration(paramInt).setListener(null);
  }

  void b(boolean paramBoolean)
  {
    clearAnimation();
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).clearAnimation();
      i1 -= 1;
    }
    if (paramBoolean)
    {
      removeAllViews();
      Iterator localIterator = this.n.iterator();
      while (localIterator.hasNext())
      {
        FanItem localFanItem = (FanItem)localIterator.next();
        if ((localFanItem.getTag() instanceof yw))
          ((yw)localFanItem.getTag()).l();
      }
      this.n.clear();
      return;
    }
    detachAllViewsFromParent();
  }

  protected boolean b()
  {
    return this.j;
  }

  public void c(int paramInt)
  {
    animate().alpha(1.0F).setDuration(paramInt).setInterpolator(new AccelerateInterpolator()).setListener(null);
  }

  protected boolean c()
  {
    return this.k;
  }

  protected boolean d()
  {
    return this.l;
  }

  protected boolean e()
  {
    return getTab().e();
  }

  public List<FanItem> getItems()
  {
    return this.n;
  }

  public aao getTab()
  {
    return this.h;
  }

  protected void h()
  {
    r();
    postDelayed(this.r, 222L);
  }

  public void i()
  {
    Object localObject2 = getTab();
    if (localObject2 == null);
    Object localObject1;
    int i1;
    do
    {
      do
      {
        return;
        localObject1 = getContext();
        i1 = ((aao)localObject2).i();
        if ((!(localObject2 instanceof aal)) || (i1 <= 0) || (vs.c((Context)localObject1, "key_add_clicked_in_favorites", false)))
          break;
        localObject2 = ((aao)localObject2).a(i1 - 1);
      }
      while (!(localObject2 instanceof ys));
      ((ys)localObject2).b((Context)localObject1);
      return;
      if ((!c()) && (i1 > 0))
      {
        localObject2 = ((aao)localObject2).a(i1 - 1);
        if ((localObject2 instanceof ys))
          ((ys)localObject2).b((Context)localObject1);
      }
    }
    while ((this.e) || (!e()) || (i1 >= aao.b((Context)localObject1)));
    this.o.l();
    if (i1 < getItems().size())
    {
      localObject1 = (FanItem)getItems().get(i1);
      b((FanItem)localObject1, this.o, false);
      ((FanItem)localObject1).d();
      a(i1 + 1);
    }
    for (this.e = true; ; this.e = true)
    {
      ((FanItem)localObject1).c(true);
      return;
      localObject1 = a(this.o, false, false);
      addView((View)localObject1);
      this.n.add(localObject1);
      a(i1 + 1);
    }
  }

  public void j()
  {
    super.j();
    r();
  }

  public void m()
  {
    if (!yw.g);
    while (true)
    {
      return;
      Iterator localIterator = this.n.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FanItem)localIterator.next();
        ((FanItem)localObject).m();
        if ((((FanItem)localObject).getTag() instanceof yw))
        {
          localObject = (yw)((FanItem)localObject).getTag();
          this.p.put(((yw)localObject).i(), new PointF(((yw)localObject).e, ((yw)localObject).f));
        }
      }
    }
  }

  public void n()
  {
    this.p.clear();
  }

  public void o()
  {
    int i2 = this.n.size();
    int i1 = 0;
    while (i1 < i2)
    {
      FanItem localFanItem = (FanItem)this.n.get(i1);
      d(localFanItem);
      localFanItem.clearAnimation();
      localFanItem.a(i1, yk.a(i1, i2, this.c), false);
      localFanItem.c(false);
      i1 += 1;
    }
    requestLayout();
  }

  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (!this.m.a(paramDragEvent))
      return super.onDragEvent(paramDragEvent);
    return this.m.b(paramDragEvent);
  }

  public void p()
  {
    Iterator localIterator = getItems().iterator();
    while (localIterator.hasNext())
      ((FanItem)localIterator.next()).i();
    requestLayout();
  }

  public void q()
  {
    Iterator localIterator = getItems().iterator();
    while (localIterator.hasNext())
      ((FanItem)localIterator.next()).j();
    if (this.a.getHandTracker().d())
      this.a.a(true);
  }

  public void r()
  {
    removeCallbacks(this.r);
  }

  protected void setHasAddIcon(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void setItems(ArrayList<FanItem> paramArrayList)
  {
    this.n = paramArrayList;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.FanLayer
 * JD-Core Version:    0.6.2
 */