package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.FanLayer;
import com.lazyswipe.fan.SectorArea;
import com.lazyswipe.fan.friend.ContactChoosePanel;
import com.lazyswipe.ui.RateView;
import com.lazyswipe.ui.chooser.MultiChooserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class xu extends FrameLayout
  implements OnClickListener, OnLongClickListener, aof
{
  private static final String e = "Swipe." + xu.class.getSimpleName();
  public yb a;
  public xv b;
  public boolean c;
  public boolean d;
  private int f = 0;

  public xu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext)
  {
    try
    {
      vs.g(paramContext, getTab().b());
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  private void a(FanItem paramFanItem, yw paramyw, wm paramwm, boolean paramBoolean, int paramInt)
  {
    paramyw = paramyw.e();
    if (paramyw == null)
      return;
    paramwm.a(paramyw, new Runnable()
    {
      public void run()
      {
        afs.a();
      }
    });
    int i = aao.b(getContext());
    paramyw = ((aal)getTab()).f();
    if ((paramyw != null) && (!ahy.d(getContext())))
    {
      paramFanItem = getTab().c(SwipeApplication.c());
      paramFanItem.add(paramyw);
      while (paramInt < i)
      {
        paramyw = (FanItem)getItems().get(paramInt);
        a(paramyw, (yw)paramFanItem.get(paramInt));
        paramyw.clearAnimation();
        paramyw.setVisibility(0);
        paramInt += 1;
      }
      a(i);
      return;
    }
    a(paramFanItem);
  }

  private void a(yw paramyw)
  {
    if (paramyw.d(getContext()))
      post(new Runnable()
      {
        public void run()
        {
          xu.this.a.c(true);
        }
      });
  }

  private void b(FanItem paramFanItem, yw paramyw, int paramInt)
  {
    Object localObject = getContext();
    paramyw = ((zf)paramyw).t();
    List localList = anu.b(getContext());
    localList.remove(paramyw);
    anu.b((Context)localObject, anu.a(localList));
    boolean bool = "Calculator".equals(paramyw);
    int i = aao.b((Context)localObject);
    if (localList.size() >= i)
    {
      paramFanItem = anu.a((Context)localObject, (String)localList.get(i - 1));
      if (paramFanItem == null)
        return;
      paramFanItem = new zf((Context)localObject, paramFanItem);
      paramyw = getTab().c((Context)localObject);
      paramyw.add(paramFanItem);
      yw.g = true;
      m();
      if (paramInt >= i)
        break label302;
      paramFanItem = (FanItem)getItems().get(paramInt);
      paramyw = (zf)paramyw.get(paramInt);
      a(paramFanItem, paramyw);
      if (!"Calculator".equals(paramyw.t()))
        break label302;
    }
    label294: label296: label302: for (paramInt = 1; ; paramInt = 0)
    {
      a(i);
      yw.g = false;
      n();
      while (true)
      {
        anu.a();
        if ((paramInt == 0) && (!bool))
          break label294;
        paramFanItem = yb.getInstance();
        if (paramFanItem == null)
          break;
        paramyw = paramFanItem.getBaseSectorArea();
        if (paramyw == null)
          break;
        paramyw.getNextTab().a(SwipeApplication.c(), true);
        paramyw = paramyw.getPreviousTab();
        paramyw.g();
        localObject = paramFanItem.getBaseSectorArea();
        if (!(localObject instanceof SectorArea))
          break label296;
        ((FanLayer)((SectorArea)localObject).getHiddenItemLayer()).a(paramyw, paramFanItem.a(paramyw), paramFanItem.getStartPosition(), false, false);
        return;
        a(paramFanItem);
        paramInt = 0;
      }
      break;
      paramFanItem.d(false);
      return;
    }
  }

  private void b(FanItem paramFanItem, final yw paramyw, wm paramwm, boolean paramBoolean, int paramInt)
  {
    paramyw = paramyw.e();
    if (paramyw == null)
      return;
    try
    {
      paramyw.o = 0;
      arj.a(new Runnable()
      {
        public void run()
        {
          try
          {
            wn.d(SwipeApplication.c(), paramyw);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
      label27: a(paramFanItem);
      return;
    }
    catch (Throwable paramyw)
    {
      break label27;
    }
  }

  private void b(yw paramyw)
  {
    if (paramyw.e(getContext()))
    {
      post(new Runnable()
      {
        public void run()
        {
          xu.this.a.c(true);
        }
      });
      return;
    }
    a(paramyw);
  }

  private boolean g(View paramView)
  {
    if ((this.d) || (!(paramView instanceof FanItem)) || (!(paramView.getTag() instanceof yw)) || (a(paramView.getTag())))
      return false;
    FanItem localFanItem = (FanItem)paramView;
    yw localyw = (yw)paramView.getTag();
    if (!((FanItem)paramView).h())
    {
      a(localyw);
      return true;
    }
    if (localFanItem.f())
      b(localyw);
    while (true)
    {
      return true;
      a(localyw);
    }
  }

  private boolean h(final View paramView)
  {
    if ((!ahy.d(getContext())) && (!this.d) && (getTab().i() > 1) && (c()))
    {
      new avx(getContext()).c(2131230946).g(2131230982).d(2131231145).a(new OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          xu.this.d(paramView);
        }
      }).b();
      return true;
    }
    return false;
  }

  private void o()
  {
    Intent localIntent = MultiChooserActivity.c(false);
    localIntent.addFlags(268468224);
    app.a(getContext(), localIntent);
  }

  private void p()
  {
    ArrayList localArrayList = new ArrayList(getItems().size());
    Object localObject1 = getItems().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((FanItem)((Iterator)localObject1).next()).getTag();
      if ((localObject2 != null) && (!a(localObject2)) && ((localObject2 instanceof yw)))
      {
        localObject2 = ((yw)localObject2).e();
        if (localObject2 != null)
          localArrayList.add(((wk)localObject2).i);
      }
    }
    localObject1 = MultiChooserActivity.c(true);
    ((Intent)localObject1).addFlags(268468224);
    ((Intent)localObject1).putExtra("extra.request_type", 1);
    ((Intent)localObject1).putExtra("extra.request_max_count", aao.b(getContext()));
    ((Intent)localObject1).putParcelableArrayListExtra("extra.request_existing_list", localArrayList);
    app.a(getContext(), (Intent)localObject1);
  }

  public abstract void a(int paramInt);

  public void a(View paramView)
  {
    RateView.d();
  }

  public abstract void a(FanItem paramFanItem);

  protected void a(FanItem paramFanItem, yw paramyw)
  {
    b(paramFanItem, paramyw, false);
  }

  public void a(FanItem paramFanItem, yw paramyw, int paramInt)
  {
    a(paramFanItem, paramyw, paramInt, true);
  }

  public void a(FanItem paramFanItem, yw paramyw, int paramInt, boolean paramBoolean)
  {
    RateView.f();
    getTab().c(paramyw);
    if (c())
      a(paramFanItem, paramyw, ((SwipeApplication)getContext()).a(), paramBoolean, paramInt);
    do
    {
      return;
      if (b())
      {
        a(paramFanItem, paramyw, paramBoolean);
        return;
      }
      if (a())
      {
        b(paramFanItem, paramyw, paramInt);
        return;
      }
    }
    while (!d());
    b(paramFanItem, paramyw, ((SwipeApplication)getContext()).a(), paramBoolean, paramInt);
  }

  protected void a(FanItem paramFanItem, yw paramyw, boolean paramBoolean)
  {
    int i;
    if ((paramyw instanceof alh))
    {
      ((alh)paramyw).g();
      paramFanItem.clearAnimation();
      paramFanItem.setVisibility(0);
      if ((!(paramyw instanceof za)) && (!(paramyw instanceof ajo)) && (!(paramyw instanceof yy)) && (!(paramyw instanceof aiu)))
        break label224;
      i = 1;
    }
    while (true)
    {
      if (i != 0)
      {
        if (!(paramyw instanceof za))
        {
          getTab().g();
          getTab().a((SwipeApplication)getContext().getApplicationContext());
        }
        a(true);
        if (paramBoolean)
          i();
      }
      return;
      if ((paramyw instanceof yv))
      {
        SwipeService.a(((yv)paramyw).g());
        paramFanItem.clearAnimation();
        paramFanItem.setVisibility(0);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setDuration(200L);
        localScaleAnimation.setFillAfter(true);
        setLayerType(0, null);
        paramFanItem.startAnimation(localScaleAnimation);
        i = 0;
      }
      else if ((paramyw instanceof yt))
      {
        paramFanItem = paramyw.e();
        if (paramFanItem != null)
        {
          paramFanItem.e = -1L;
          SwipeApplication.c().a().c(paramFanItem);
          i = 1;
        }
      }
      else
      {
        label224: i = 0;
      }
    }
  }

  public void a(yb paramyb, xv paramxv)
  {
    this.a = paramyb;
    this.b = paramxv;
  }

  public abstract void a(boolean paramBoolean);

  public void a(boolean paramBoolean, yg paramyg)
  {
    RateView.f();
    Iterator localIterator = getItems().iterator();
    while (localIterator.hasNext())
    {
      FanItem localFanItem = (FanItem)localIterator.next();
      if (paramBoolean)
        localFanItem.a(true, paramyg);
      else
        localFanItem.d();
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.d)
      return;
    Object localObject2;
    if (!ahy.d(getContext()))
    {
      localObject1 = getTab();
      if ((localObject1 instanceof aal))
      {
        localObject2 = vs.a(getContext());
        if ((!amk.b(getContext())) && (!((SharedPreferences)localObject2).getBoolean("key_add_clicked_in_favorites", false)))
          break label141;
      }
    }
    label65: this.b.e();
    this.d = false;
    if (paramBoolean1)
    {
      this.f = 0;
      if ((!paramBoolean2) || (yw.g))
        break label223;
    }
    label141: label223: for (Object localObject1 = new yg()
    {
      public void a()
      {
        xu.a(xu.this);
      }

      public void b()
      {
        xu.b(xu.this);
        if (xu.c(xu.this) == 0)
        {
          yw.g = true;
          xu.this.m();
          xu.this.a(false);
          yw.g = false;
          xu.this.n();
        }
      }
    }
    ; ; localObject1 = null)
    {
      a(paramBoolean2, (yg)localObject1);
      if ((paramBoolean3) && ((!paramBoolean1) || (!paramBoolean2)))
        a(false);
      if (!a())
        break;
      yb.q();
      return;
      ((SharedPreferences)localObject2).edit().putBoolean("key_add_clicked_in_favorites", true).apply();
      localObject2 = ((aao)localObject1).c(getContext());
      if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        break label65;
      localObject2 = ((aao)localObject1).a(((List)localObject2).size() - 1);
      if (!(localObject2 instanceof ys))
        break label65;
      ((aao)localObject1).c((yw)localObject2);
      break label65;
    }
  }

  public abstract boolean a();

  public boolean a(Canvas paramCanvas)
  {
    try
    {
      draw(paramCanvas);
      return true;
    }
    catch (Exception paramCanvas)
    {
    }
    return false;
  }

  public abstract boolean a(Object paramObject);

  public void b(int paramInt)
  {
  }

  // ERROR //
  void b(View paramView)
  {
    // Byte code:
    //   0: invokestatic 531	afv:b	()V
    //   3: aload_1
    //   4: ifnull +19 -> 23
    //   7: aload_0
    //   8: getfield 474	xu:a	Lyb;
    //   11: invokevirtual 533	yb:g	()Z
    //   14: ifeq +10 -> 24
    //   17: invokestatic 537	com/lazyswipe/features/guide/NewGuide:i	()Z
    //   20: ifne +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: getfield 476	xu:b	Lxv;
    //   28: getfield 539	xv:e	Z
    //   31: ifne -8 -> 23
    //   34: aload_1
    //   35: checkcast 138	com/lazyswipe/fan/FanItem
    //   38: astore 5
    //   40: aload_0
    //   41: invokevirtual 132	xu:getItems	()Ljava/util/List;
    //   44: aload 5
    //   46: invokeinterface 543 2 0
    //   51: istore 6
    //   53: aload_1
    //   54: invokevirtual 278	android/view/View:getTag	()Ljava/lang/Object;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull +138 -> 197
    //   62: aload_0
    //   63: iconst_0
    //   64: invokevirtual 424	xu:a	(Z)V
    //   67: aload_0
    //   68: invokevirtual 132	xu:getItems	()Ljava/util/List;
    //   71: iload 6
    //   73: invokeinterface 136 2 0
    //   78: checkcast 274	android/view/View
    //   81: astore_3
    //   82: aload_3
    //   83: invokevirtual 278	android/view/View:getTag	()Ljava/lang/Object;
    //   86: astore 4
    //   88: aload_3
    //   89: astore_1
    //   90: aload 4
    //   92: astore_2
    //   93: aload_2
    //   94: instanceof 86
    //   97: ifeq -74 -> 23
    //   100: aload_2
    //   101: checkcast 86	yw
    //   104: astore_2
    //   105: aload_2
    //   106: instanceof 545
    //   109: ifne +3 -> 112
    //   112: aload_0
    //   113: aload_1
    //   114: invokespecial 547	xu:g	(Landroid/view/View;)Z
    //   117: ifne -94 -> 23
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 278	android/view/View:getTag	()Ljava/lang/Object;
    //   125: invokevirtual 280	xu:a	(Ljava/lang/Object;)Z
    //   128: ifeq +13 -> 141
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 549	xu:f	(Landroid/view/View;)V
    //   136: return
    //   137: astore_3
    //   138: goto -45 -> 93
    //   141: aload_0
    //   142: getfield 272	xu:d	Z
    //   145: ifeq +21 -> 166
    //   148: aload 5
    //   150: invokevirtual 551	com/lazyswipe/fan/FanItem:e	()Z
    //   153: ifeq -130 -> 23
    //   156: aload_0
    //   157: aload 5
    //   159: aload_2
    //   160: iload 6
    //   162: invokevirtual 553	xu:a	(Lcom/lazyswipe/fan/FanItem;Lyw;I)V
    //   165: return
    //   166: aload_2
    //   167: aload_0
    //   168: invokevirtual 101	xu:getContext	()Landroid/content/Context;
    //   171: invokevirtual 155	yw:d	(Landroid/content/Context;)Z
    //   174: ifeq -151 -> 23
    //   177: aload_0
    //   178: new 12	xu$1
    //   181: dup
    //   182: aload_0
    //   183: invokespecial 554	xu$1:<init>	(Lxu;)V
    //   186: invokevirtual 160	xu:post	(Ljava/lang/Runnable;)Z
    //   189: pop
    //   190: return
    //   191: astore_1
    //   192: aload_3
    //   193: astore_1
    //   194: goto -56 -> 138
    //   197: goto -104 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   62	82	137	java/lang/Throwable
    //   82	88	191	java/lang/Throwable
  }

  public void b(FanItem paramFanItem)
  {
    int i = getItems().indexOf(paramFanItem);
    if (i < 0);
    yw localyw;
    do
    {
      do
        return;
      while (!(paramFanItem.getTag() instanceof yw));
      localyw = (yw)paramFanItem.getTag();
    }
    while (!this.d);
    a(paramFanItem, localyw, i);
  }

  public void b(FanItem paramFanItem, yw paramyw, boolean paramBoolean)
  {
    if (paramyw == null)
    {
      paramFanItem.setIconBackground(null);
      paramFanItem.setIcon((Drawable)null);
      paramFanItem.setText(null);
      paramFanItem.setOnClickListener(null);
      paramFanItem.setTag(null);
      return;
    }
    paramyw.a(paramFanItem);
    paramFanItem.setVisibility(0);
    paramFanItem.setOnClickListener(this);
    paramFanItem.setNeedSplitEvent(paramBoolean);
    paramFanItem.setOnLongClickListener(this);
    if ((this.d) && (!a(paramyw)))
    {
      paramFanItem.c();
      return;
    }
    paramFanItem.d();
  }

  public abstract boolean b();

  public void c(int paramInt)
  {
  }

  public abstract boolean c();

  boolean c(View paramView)
  {
    boolean bool1 = false;
    afv.b();
    Object localObject = paramView.getTag();
    if ((localObject != null) && (!(localObject instanceof yw)));
    boolean bool2;
    do
    {
      do
        return bool1;
      while ((a(localObject)) && (getItems() != null) && (getItems().size() == 1));
      localObject = (yw)paramView.getTag();
      if (!(localObject instanceof ali));
      vy.a(getContext(), "C4", String.valueOf(getTab().c()));
      if ((!this.d) && (localObject != null) && (((yw)localObject).g(getContext())))
        return true;
      bool2 = d(paramView);
      bool1 = bool2;
    }
    while (!k());
    a(paramView);
    return bool2;
  }

  public abstract boolean d();

  public boolean d(View paramView)
  {
    if ((paramView != null) || (this.d))
      return false;
    if (a())
      yb.a(false, null, 0, null, null);
    this.b.d();
    this.d = true;
    setHasAddIcon(false);
    e(paramView);
    if ((e()) && (!k()))
      i();
    h();
    return true;
  }

  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    try
    {
      boolean bool = super.dispatchDragEvent(paramDragEvent);
      return bool;
    }
    catch (Throwable paramDragEvent)
    {
    }
    return false;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
    }
    return false;
  }

  public void e(View paramView)
  {
    RateView.d();
    int j = getTab().i();
    int i = 0;
    while (i < j)
      try
      {
        FanItem localFanItem = (FanItem)getItems().get(i);
        if (paramView != localFanItem);
        for (boolean bool = true; ; bool = false)
        {
          localFanItem.a(bool);
          i += 1;
          break;
        }
      }
      catch (Throwable paramView)
      {
      }
  }

  public abstract boolean e();

  protected void f(View paramView)
  {
    RateView.d();
    if (a())
      o();
    do
    {
      do
      {
        return;
        if (!b())
          break;
      }
      while (!(aap.b(getContext()) instanceof aai));
      if (!this.d)
        d(paramView);
      ContactChoosePanel.a(getContext());
      return;
    }
    while (h(paramView));
    p();
  }

  public boolean f()
  {
    return this.d;
  }

  public boolean g()
  {
    return d(null);
  }

  public yb getFan()
  {
    return this.a;
  }

  public abstract List<? extends FanItem> getItems();

  public abstract aao getTab();

  public void h()
  {
  }

  public void i()
  {
  }

  public void j()
  {
    a(true, false, true);
  }

  protected boolean k()
  {
    return this.a.e();
  }

  public boolean l()
  {
    return (k()) && (getTab().d());
  }

  public void m()
  {
  }

  public void n()
  {
  }

  public void onClick(View paramView)
  {
    a(getContext());
    try
    {
      b(paramView);
      return;
    }
    catch (Exception paramView)
    {
    }
  }

  public boolean onLongClick(View paramView)
  {
    a(getContext());
    boolean bool = c(paramView);
    return (paramView == null) || (paramView.getParent() == null) || (bool);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
      RateView.d();
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3))
        RateView.f();
    }
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (getTab() == null);
    while ((paramInt == 0) || (!this.d))
      return;
    a(true, false, false);
  }

  public void setDirection(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public abstract void setHasAddIcon(boolean paramBoolean);
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     xu
 * JD-Core Version:    0.6.2
 */