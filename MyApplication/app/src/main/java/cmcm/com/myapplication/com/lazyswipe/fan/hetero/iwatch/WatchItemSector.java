package cmcm.com.myapplication.com.lazyswipe.fan.hetero.iwatch;

import aao;
import afv;
import ahy;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import aqs;
import aqz;
import asp;
import asq;
import asw;
import auu;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.guide.NewGuide;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wk;
import wm;
import xu;
import xv;
import xy;
import xz;
import yb;
import yd;
import ye;
import yg;
import yj;
import yw;
import zf;
import zr;
import zu;
import zv;
import zw;

public class WatchItemSector extends xu
{
  private static final int[] R = { 11, 12, 9, 4, 3, 5, 10, 1, 0, 2, 7, 6, 8 };
  private static final int[] S = aqz.a(R);
  private static final String q = "Swipe." + WatchFanItem.class.getSimpleName();
  private float A = 0.0F;
  private float B;
  private float C;
  private float D;
  private float E;
  private float F;
  private boolean G;
  private boolean H;
  private float I;
  private float J;
  private final int K;
  private final int L;
  private int M = 0;
  private boolean N;
  private boolean O;
  private int P;
  private int[] Q = new int[39];
  private ValueAnimator T;
  private int U;
  private int V;
  private int W;
  private int aa;
  private float ab;
  private WatchFanItem ac;
  private int[] ad;
  private WeakReference<xz> ae;
  List<WatchFanItem> e;
  List<yw> f;
  int g;
  boolean h;
  float i;
  float j;
  public boolean k;
  boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  final GestureDetector p;
  private final List<WatchFanItem> r = new ArrayList(13);
  private final List<WatchFanItem> s = new ArrayList(13);
  private final List<WatchFanItem> t = new ArrayList(13);
  private final List<yw> u = new ArrayList(13);
  private final List<yw> v = new ArrayList(13);
  private final List<yw> w = new ArrayList(13);
  private WatchFanItem x;
  private yw y;
  private int z;

  public WatchItemSector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.K = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.L = (this.K * 3);
    this.p = new GestureDetector(paramContext, new zu(this), new Handler());
  }

  private WatchFanItem a(int paramInt1, int paramInt2, yw paramyw)
  {
    System.currentTimeMillis();
    Object localObject;
    WatchFanItem localWatchFanItem;
    if (paramInt1 == 1)
    {
      localObject = this.r;
      if (((List)localObject).size() > paramInt2)
        break label138;
      localWatchFanItem = WatchFanItem.a(paramyw, paramInt1, paramInt2, this.c, this);
      ((List)localObject).add(localWatchFanItem);
      localObject = localWatchFanItem;
    }
    while (true)
    {
      ((WatchFanItem)localObject).c(this.A);
      ((WatchFanItem)localObject).setOnClickListener(this);
      ((WatchFanItem)localObject).setNeedSplitEvent(((WatchFanItem)localObject).getInfo() instanceof zf);
      ((WatchFanItem)localObject).setOnLongClickListener(this);
      auu.a("makeOrBindItem  " + paramyw.a());
      return localObject;
      if (paramInt1 == 0)
      {
        localObject = this.t;
        break;
      }
      localObject = this.s;
      break;
      label138: if (((List)localObject).get(paramInt2) == null)
      {
        localWatchFanItem = WatchFanItem.a(paramyw, paramInt1, paramInt2, this.c, this);
        ((List)localObject).set(paramInt2, localWatchFanItem);
        localObject = localWatchFanItem;
      }
      else
      {
        localObject = (WatchFanItem)((List)localObject).get(paramInt2);
        ((WatchFanItem)localObject).a(paramyw);
      }
    }
  }

  private WatchFanItem a(List<WatchFanItem> paramList, int paramInt)
  {
    WatchFanItem localWatchFanItem = (WatchFanItem)paramList.get(paramInt);
    if (localWatchFanItem == null)
      paramList = null;
    do
    {
      return paramList;
      localWatchFanItem.clearAnimation();
      localWatchFanItem.d();
      paramList = localWatchFanItem;
    }
    while (localWatchFanItem.getParent() != null);
    addViewInLayout(localWatchFanItem, -1, localWatchFanItem.d(false));
    return localWatchFanItem;
  }

  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = this.r;
      if (paramInt1 != 1)
        break label104;
      localObject2 = this.u;
    }
    while (true)
    {
      localObject1 = (WatchFanItem)((List)localObject1).get(paramInt2);
      localObject2 = (yw)((List)localObject2).get(paramInt2);
      if (localObject1 != null)
      {
        ((WatchFanItem)localObject1).setTag(localObject2);
        ((WatchFanItem)localObject1).setOnClickListener(this);
        ((WatchFanItem)localObject1).setNeedSplitEvent(localObject2 instanceof zf);
        ((WatchFanItem)localObject1).setOnLongClickListener(this);
        ((WatchFanItem)localObject1).k();
        ((WatchFanItem)localObject1).setIconPressAnimationEnable(true);
      }
      return;
      if (paramInt1 == 0)
      {
        localObject1 = this.t;
        break;
      }
      localObject1 = this.s;
      break;
      label104: if (paramInt1 == 0)
        localObject2 = this.w;
      else
        localObject2 = this.v;
    }
  }

  private void a(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null)
      return;
    this.H = true;
    this.x.clearAnimation();
    this.x.setVisibility(8);
    if ((this.ae != null) && (this.ae.get() != null))
      ((xz)this.ae.get()).a();
    int i1 = b(this.x);
    this.U = i1;
    this.V = i1;
    paramDragEvent = (WatchFanItem)this.e.get(this.U);
    this.W = paramDragEvent.h.j;
    this.aa = paramDragEvent.h.k;
    this.ab = paramDragEvent.e(true);
    x();
  }

  private void a(final WatchFanItem paramWatchFanItem)
  {
    if (paramWatchFanItem == null);
    while (paramWatchFanItem.h.a() > 90.0F)
      return;
    this.P = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(120L);
    ((AlphaAnimation)localObject).setStartOffset(120L);
    localAnimationSet.addAnimation((Animation)localObject);
    float f1 = paramWatchFanItem.h.j;
    float f2 = paramWatchFanItem.h.k;
    localObject = new TranslateAnimation(0.0F, -f1, 0.0F, f2);
    ((TranslateAnimation)localObject).setDuration(240L);
    ((TranslateAnimation)localObject).setInterpolator(new ye(true));
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setStartOffset(paramWatchFanItem.h.i * yd.b());
    localAnimationSet.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramWatchFanItem.o();
        WatchItemSector.c(WatchItemSector.this);
        if (WatchItemSector.d(WatchItemSector.this) == 0)
        {
          WatchItemSector.this.setVisibility(4);
          WatchItemSector.e(WatchItemSector.this).setVisibility(4);
        }
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        WatchItemSector.b(WatchItemSector.this);
      }
    });
    paramWatchFanItem.startAnimation(localAnimationSet);
  }

  private void a(final WatchFanItem paramWatchFanItem, boolean paramBoolean)
  {
    if (paramWatchFanItem.h.a() > 90.0F)
      return;
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(getDuration() * 3 / 4);
    localAnimationSet.addAnimation((Animation)localObject);
    float f1 = paramWatchFanItem.h.j;
    float f2 = paramWatchFanItem.h.k;
    localObject = new TranslateAnimation(-f1, 0.0F, f2, 0.0F);
    ((TranslateAnimation)localObject).setDuration(getDuration());
    ((TranslateAnimation)localObject).setInterpolator(new ye());
    if (paramBoolean)
      ((TranslateAnimation)localObject).setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          WatchItemSector.this.post(new Runnable()
          {
            public void run()
            {
              ((WatchSectorArea)WatchItemSector.a(WatchItemSector.this)).a(false);
            }
          });
        }
      });
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = paramWatchFanItem.getInfo();
        if ((paramAnonymousAnimation != null) && (paramAnonymousAnimation.e() != null) && (paramAnonymousAnimation.e().n))
        {
          paramAnonymousAnimation.e().n = false;
          WatchItemSector.this.postDelayed(new Runnable()
          {
            public void run()
            {
              WatchItemSector.2.this.a.l();
            }
          }
          , 400L);
        }
      }
    });
    paramWatchFanItem.setAnimation(localAnimationSet);
  }

  private void a(final boolean paramBoolean, float paramFloat)
  {
    this.T = ValueAnimator.ofFloat(new float[] { this.A, paramFloat });
    this.T.setDuration(240L);
    this.B = this.A;
    this.T.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        WatchItemSector.c(WatchItemSector.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        WatchItemSector.d(WatchItemSector.this, WatchItemSector.l(WatchItemSector.this) - WatchItemSector.m(WatchItemSector.this));
        WatchItemSector.e(WatchItemSector.this, WatchItemSector.l(WatchItemSector.this));
        WatchItemSector.c(WatchItemSector.this, ahy.d(WatchItemSector.l(WatchItemSector.this)));
        WatchItemSector.n(WatchItemSector.this);
      }
    });
    this.T.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        WatchItemSector.this.m = false;
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ahy.b = true;
        vj.l = false;
        if (!paramBoolean)
        {
          WatchItemSector.this.m = false;
          return;
        }
        WatchItemSector.o(WatchItemSector.this).k();
        WatchItemSector.p(WatchItemSector.this);
        WatchItemSector.this.m = false;
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        ahy.b = false;
        WatchItemSector.this.m = true;
      }
    });
    this.T.start();
  }

  private int b(DragEvent paramDragEvent)
  {
    int i1 = (int)paramDragEvent.getX();
    int i2 = (int)paramDragEvent.getY();
    paramDragEvent = this.e.iterator();
    while (paramDragEvent.hasNext())
    {
      WatchFanItem localWatchFanItem = (WatchFanItem)paramDragEvent.next();
      if ((localWatchFanItem != null) && (localWatchFanItem.getRect().contains(i1, i2)))
        return this.e.indexOf(localWatchFanItem);
    }
    return -1;
  }

  private int b(MotionEvent paramMotionEvent)
  {
    return (int)-asq.a(aqs.ad(), 0.0D, paramMotionEvent.getY(), paramMotionEvent.getX());
  }

  private int b(WatchFanItem paramWatchFanItem)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      WatchFanItem localWatchFanItem = (WatchFanItem)localIterator.next();
      if (localWatchFanItem == paramWatchFanItem)
        return this.e.indexOf(localWatchFanItem);
    }
    return -1;
  }

  private void c(DragEvent paramDragEvent)
  {
    int i1 = b(paramDragEvent);
    if (i1 == -1)
      if ((i1 != this.V) && (this.ac != null))
      {
        this.ac.clearAnimation();
        this.ac = null;
        this.V = -1;
      }
    do
    {
      do
      {
        do
        {
          return;
          paramDragEvent = (WatchFanItem)this.e.get(i1);
          if (c(paramDragEvent))
            break;
        }
        while ((i1 == this.V) || (this.ac == null));
        this.ac.clearAnimation();
        this.ac = null;
        this.V = -1;
        return;
        if (i1 != this.U)
          break;
      }
      while ((i1 == this.V) || (this.ac == null));
      this.ac.clearAnimation();
      this.ac = null;
      this.V = -1;
      return;
    }
    while (i1 == this.V);
    if (this.ac != null)
    {
      this.ac.clearAnimation();
      this.ac = null;
      this.V = -1;
    }
    try
    {
      d(paramDragEvent);
      int i2 = paramDragEvent.h.j;
      int i3 = paramDragEvent.h.k;
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setDuration(380L);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.W - i2, 0.0F, i3 + -this.aa);
      float f1 = paramDragEvent.e(true);
      f1 = this.ab / f1;
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F));
      localAnimationSet.addAnimation(localTranslateAnimation);
      paramDragEvent.startAnimation(localAnimationSet);
      this.ac = paramDragEvent;
      this.V = i1;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        x();
    }
  }

  private boolean c(WatchFanItem paramWatchFanItem)
  {
    if (paramWatchFanItem == null);
    do
    {
      do
        return false;
      while (!l());
      paramWatchFanItem = paramWatchFanItem.getInfo();
    }
    while ((paramWatchFanItem == null) || (!paramWatchFanItem.c()));
    return true;
  }

  private void d(WatchFanItem paramWatchFanItem)
  {
    if ((this.Q == null) || (this.Q.length != 39))
    {
      x();
      return;
    }
    int i3 = e(paramWatchFanItem);
    if (i3 < 0)
    {
      x();
      return;
    }
    x();
    paramWatchFanItem = Arrays.copyOf(this.Q, 39);
    int i2 = i3 / 13;
    int i1 = i2 * 13;
    i2 = (i2 + 1) * 13 - 1;
    if (i1 < i2)
      if (this.Q[i1] != i3);
    while (true)
    {
      if (i1 == -1)
      {
        x();
        return;
        i1 += 1;
        break;
      }
      System.arraycopy(this.Q, i1 + 1, paramWatchFanItem, i1, i2 - i1);
      paramWatchFanItem[i2] = this.Q[i1];
      if (!aqz.b(paramWatchFanItem))
      {
        x();
        return;
      }
      this.ad = paramWatchFanItem;
      return;
      i1 = -1;
    }
  }

  private boolean d(DragEvent paramDragEvent)
  {
    if (this.x != null)
    {
      this.x.setVisibility(0);
      this.x.clearAnimation();
    }
    if (this.ac != null)
      this.ac.clearAnimation();
    int i2 = b(paramDragEvent);
    if (i2 == -1);
    while ((!c((WatchFanItem)this.e.get(i2))) || (i2 == this.U))
      return false;
    Collections.swap(this.f, i2, this.U);
    int i1 = 0;
    while (i1 < this.e.size())
    {
      paramDragEvent = (WatchFanItem)this.e.get(i1);
      if (paramDragEvent != null)
      {
        paramDragEvent.a((yw)this.f.get(i1));
        paramDragEvent.clearAnimation();
      }
      i1 += 1;
    }
    u();
    getTab().a(this.f, this.U, i2, new xy()
    {
      public void a(List<yw> paramAnonymousList)
      {
        WatchItemSector.this.a(true);
        WatchItemSector.this.post(new Runnable()
        {
          public void run()
          {
            WatchItemSector.this.p();
            WatchItemSector.n(WatchItemSector.this);
          }
        });
      }
    });
    return true;
  }

  private int e(WatchFanItem paramWatchFanItem)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (getChildAt(i1) == paramWatchFanItem)
        return i1;
      i1 += 1;
    }
    return -1;
  }

  private void e(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null);
    while (paramDragEvent.getResult())
      return;
    p();
    y();
  }

  private boolean f(WatchFanItem paramWatchFanItem)
  {
    if (paramWatchFanItem == null);
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
        i1 = paramWatchFanItem.h.f;
        if (i1 == 1)
          return true;
        i2 = paramWatchFanItem.h.g;
        if (i1 != 0)
          break;
      }
      while ((i2 != 2) && (i2 != 12));
      return true;
    }
    while ((i1 != 2) || ((i2 != 1) && (i2 != 11)));
    return true;
  }

  public static int getDuration()
  {
    if (NewGuide.i())
      return 900;
    return 400;
  }

  private void s()
  {
    if (getChildCount() != 39)
    {
      this.Q = null;
      setChildrenDrawingOrderEnabled(false);
      return;
    }
    while (true)
    {
      int i2;
      int i1;
      try
      {
        int[] arrayOfInt = new int[39];
        i2 = 0;
        if (i2 >= 39)
          break;
        WatchFanItem localWatchFanItem = (WatchFanItem)getChildAt(i2);
        i1 = localWatchFanItem.h.f;
        int i3 = localWatchFanItem.h.g;
        i3 = S[i3];
        if (i1 == 1)
        {
          i1 = 0;
          i1 += i3;
          if (i1 < 39)
            break label128;
          this.Q = null;
          setChildrenDrawingOrderEnabled(false);
          return;
        }
      }
      catch (Exception localException)
      {
        this.Q = null;
        setChildrenDrawingOrderEnabled(false);
        return;
      }
      if (i1 == 2)
      {
        i1 = 13;
      }
      else
      {
        i1 = 26;
        continue;
        label128: localException[i1] = i2;
        i2 += 1;
      }
    }
    if (!aqz.b(localException))
    {
      this.Q = null;
      setChildrenDrawingOrderEnabled(false);
      return;
    }
    this.Q = localException;
    setChildrenDrawingOrderEnabled(true);
  }

  private void t()
  {
    int i1 = 0;
    zv localzv;
    WatchFanItem localWatchFanItem;
    if (i1 < 13)
    {
      if ((i1 == 2) || (i1 == 12))
      {
        localzv = new zv(i1, true);
        localWatchFanItem = WatchFanItem.a(localzv, 0, i1, this.c, this);
        this.w.add(localzv);
        localWatchFanItem.c(this.A);
        this.t.add(localWatchFanItem);
      }
      while (true)
      {
        i1 += 1;
        break;
        this.w.add(new zv(i1, false));
        this.t.add(null);
      }
    }
    i1 = 0;
    if (i1 < 13)
    {
      if ((i1 == 1) || (i1 == 11))
      {
        localzv = new zv(i1, true);
        localWatchFanItem = WatchFanItem.a(localzv, 2, i1, this.c, this);
        this.v.add(localzv);
        localWatchFanItem.c(this.A);
        this.s.add(localWatchFanItem);
      }
      while (true)
      {
        i1 += 1;
        break;
        this.v.add(new zv(i1, false));
        this.s.add(null);
      }
    }
  }

  private void u()
  {
    Iterator localIterator = this.r.iterator();
    WatchFanItem localWatchFanItem;
    while (localIterator.hasNext())
    {
      localWatchFanItem = (WatchFanItem)localIterator.next();
      if (localWatchFanItem != null)
        localWatchFanItem.c(this.A);
    }
    localIterator = this.s.iterator();
    while (localIterator.hasNext())
    {
      localWatchFanItem = (WatchFanItem)localIterator.next();
      if (localWatchFanItem != null)
        localWatchFanItem.c(this.A);
    }
    localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      localWatchFanItem = (WatchFanItem)localIterator.next();
      if (localWatchFanItem != null)
        localWatchFanItem.c(this.A);
    }
    ((WatchSectorArea)this.b).g.setDegree((int)this.A);
    requestLayout();
  }

  private boolean v()
  {
    return (Math.abs(this.D - this.E) % 90.0F >= 10.0F) || (this.G);
  }

  private void w()
  {
    switch ((int)ahy.b(this.A))
    {
    default:
      return;
    case 0:
      ((WatchSectorArea)this.b).setCurrentTab(this.z);
      this.g = 1;
      this.f = this.u;
      this.e = this.r;
      return;
    case 90:
      ((WatchSectorArea)this.b).setCurrentTab(this.z + 1);
      this.g = 2;
      this.f = this.v;
      this.e = this.s;
      return;
    case 180:
    }
    ((WatchSectorArea)this.b).setCurrentTab(this.z - 1);
    this.g = 0;
    this.f = this.w;
    this.e = this.t;
  }

  private void x()
  {
    this.ad = null;
  }

  private void y()
  {
    Iterator localIterator = getItems().iterator();
    while (localIterator.hasNext())
    {
      FanItem localFanItem = (FanItem)localIterator.next();
      if (localFanItem != null)
        localFanItem.clearAnimation();
    }
  }

  protected void a(int paramInt)
  {
    if ((!"recentlyUsed".equals(getTab().b())) && ("contact".equals(getTab().b())))
      return;
    clearAnimation();
    Object localObject1 = this.e.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WatchFanItem)((Iterator)localObject1).next();
      if (localObject2 != null)
        ((WatchFanItem)localObject2).clearAnimation();
    }
    int i1 = 0;
    int i2 = paramInt;
    if (i1 < paramInt)
    {
      localObject1 = (WatchFanItem)this.e.get(i1);
      if (localObject1 == null);
      while (true)
      {
        i1 += 1;
        break;
        localObject2 = (yw)this.f.get(i1);
        ((WatchFanItem)localObject1).a((yw)localObject2);
        if ((f()) && (((yw)localObject2).d()))
          ((WatchFanItem)localObject1).c();
        else
          ((WatchFanItem)localObject1).d();
      }
    }
    if (i2 < 13)
    {
      localObject1 = new zw(i2);
      this.f.set(i2, localObject1);
      if (this.e.get(i2) == null);
      while (true)
      {
        i2 += 1;
        break;
        ((WatchFanItem)this.e.get(i2)).a((yw)localObject1);
        ((WatchFanItem)this.e.get(i2)).d();
      }
    }
    requestLayout();
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    if (!(paramView instanceof WatchFanItem));
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
    }
    while ((!(localObject instanceof yw)) || (!((yw)localObject).c()) || (this.H) || (((WatchFanItem)paramView).h.f != this.g));
    this.x = ((WatchFanItem)paramView);
    this.y = ((yw)localObject);
    paramView = new xz(SwipeApplication.c());
    this.ae = new WeakReference(paramView);
    paramView.a(this.x);
  }

  protected void a(FanItem paramFanItem)
  {
    int i4 = 0;
    this.f.clear();
    paramFanItem = this.b.getCurrentTab().c(SwipeApplication.c()).iterator();
    int i1 = 0;
    Object localObject;
    int i3;
    while (true)
    {
      if (paramFanItem.hasNext())
      {
        localObject = (yw)paramFanItem.next();
        if (i1 < 13);
      }
      else
      {
        int i2 = i1;
        while (true)
        {
          i3 = i4;
          if (i1 >= 13)
            break;
          paramFanItem = new zw(i2);
          this.f.add(paramFanItem);
          i2 += 1;
          i1 += 1;
        }
      }
      this.f.add(localObject);
      i1 += 1;
    }
    while (i3 < this.e.size())
    {
      paramFanItem = (yw)this.f.get(i3);
      localObject = (WatchFanItem)this.e.get(i3);
      if (localObject == null)
      {
        i3 += 1;
      }
      else
      {
        ((WatchFanItem)localObject).a(paramFanItem);
        if (paramFanItem.d())
          ((WatchFanItem)localObject).c();
        while (true)
        {
          ((WatchFanItem)localObject).setOnClickListener(this);
          ((WatchFanItem)localObject).setNeedSplitEvent(paramFanItem instanceof zf);
          ((WatchFanItem)localObject).setOnLongClickListener(this);
          break;
          ((WatchFanItem)localObject).d();
        }
      }
    }
    requestLayout();
  }

  public void a(List<yw> paramList1, List<yw> paramList2, List<yw> paramList3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    auu.a("WatchItemSector.popItems starts");
    this.A = 10800.0F;
    this.B = 10800.0F;
    Iterator localIterator = this.u.iterator();
    yw localyw;
    while (localIterator.hasNext())
    {
      localyw = (yw)localIterator.next();
      if (localyw != null)
        localyw.l();
    }
    localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      localyw = (yw)localIterator.next();
      if (localyw != null)
        localyw.l();
    }
    localIterator = this.v.iterator();
    while (localIterator.hasNext())
    {
      localyw = (yw)localIterator.next();
      if (localyw != null)
        localyw.l();
    }
    this.z = paramInt;
    this.u.clear();
    this.v.clear();
    this.w.clear();
    this.u.addAll(paramList1);
    while (true)
    {
      paramInt = this.u.size();
      if (paramInt <= 13)
        break;
      this.u.remove(paramInt - 1);
    }
    paramList1 = this.u.iterator();
    paramInt = 0;
    while (paramList1.hasNext())
    {
      a(1, paramInt, (yw)paramList1.next());
      paramInt += 1;
    }
    int i1;
    if ((!SwipeApplication.c().a().c) || (a()))
    {
      i1 = paramInt;
      while (paramInt < 13)
      {
        paramList1 = new zw(i1);
        this.u.add(paramList1);
        a(1, i1, paramList1);
        paramInt += 1;
        i1 += 1;
      }
      if (!paramBoolean2)
      {
        this.v.addAll(paramList3);
        while (true)
        {
          paramInt = this.v.size();
          if (paramInt <= 13)
            break;
          this.v.remove(paramInt - 1);
        }
        paramList1 = this.v.iterator();
        paramInt = 0;
        while (paramList1.hasNext())
        {
          a(2, paramInt, (yw)paramList1.next());
          paramInt += 1;
        }
        i1 = paramInt;
        while (paramInt < 13)
        {
          paramList1 = new zw(i1);
          this.v.add(paramList1);
          a(2, i1, paramList1);
          paramInt += 1;
          i1 += 1;
        }
        this.w.addAll(paramList2);
        while (true)
        {
          paramInt = this.w.size();
          if (paramInt <= 13)
            break;
          this.w.remove(paramInt - 1);
        }
        paramList1 = this.w.iterator();
        paramInt = 0;
        while (paramList1.hasNext())
        {
          a(0, paramInt, (yw)paramList1.next());
          paramInt += 1;
        }
        i1 = paramInt;
        while (paramInt < 13)
        {
          paramList1 = new zw(i1);
          this.w.add(paramList1);
          a(0, i1, paramList1);
          paramInt += 1;
          i1 += 1;
        }
      }
      t();
    }
    auu.a("WatchItemSector.popItems after makeAndBind");
    paramInt = 0;
    if (paramInt < this.r.size())
    {
      paramList1 = a(this.r, paramInt);
      if ((f()) && (((yw)this.u.get(paramInt)).d()))
        paramList1.c();
      while (true)
      {
        paramInt += 1;
        break;
        paramList1.d();
      }
    }
    paramInt = 0;
    while (paramInt < this.s.size())
    {
      a(this.s, paramInt);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < this.t.size())
    {
      a(this.t, paramInt);
      paramInt += 1;
    }
    auu.a("WatchItemSector.popItems after reAttachAllViews");
    if (paramBoolean1)
    {
      paramInt = 0;
      if (paramInt < this.r.size())
      {
        paramList1 = (WatchFanItem)this.r.get(paramInt);
        if ((paramList1 != null) && (!yb.v()))
          if ((!paramBoolean2) || (paramInt != 0))
            break label909;
        label909: for (paramBoolean1 = true; ; paramBoolean1 = false)
        {
          a(paramList1, paramBoolean1);
          paramInt += 1;
          break;
        }
      }
      paramInt = 0;
      while (paramInt < this.t.size())
      {
        paramList1 = (WatchFanItem)this.t.get(paramInt);
        if ((paramList1 != null) && (!yb.v()))
          a(paramList1, false);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < this.s.size())
      {
        paramList1 = (WatchFanItem)this.s.get(paramInt);
        if ((paramList1 != null) && (!yb.v()))
          a(paramList1, false);
        paramInt += 1;
      }
    }
    if (yb.v())
      q();
    auu.a("WatchItemSector.popItems after animatePopItem");
    paramInt = 0;
    while (paramInt < this.u.size())
    {
      a(1, paramInt);
      paramInt += 1;
    }
    if (!paramBoolean2)
    {
      paramInt = 0;
      while (true)
      {
        i1 = i2;
        if (paramInt >= this.w.size())
          break;
        a(0, paramInt);
        paramInt += 1;
      }
      while (i1 < this.v.size())
      {
        a(2, i1);
        i1 += 1;
      }
    }
    auu.a("WatchItemSector.popItems after rebindItem");
    this.g = 1;
    this.f = this.u;
    this.e = this.r;
    ((WatchSectorArea)this.b).g.a();
    auu.a("WatchItemSector.popItems after rePopup");
    ((WatchSectorArea)this.b).g.setDegree((int)this.A);
    requestLayout();
    this.b.setPopupPrepared(true);
    s();
    auu.a("WatchItemSector.popItems finishes");
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      ((WatchSectorArea)getParent()).j();
    while (true)
    {
      return;
      Iterator localIterator = this.r.iterator();
      while (localIterator.hasNext())
      {
        WatchFanItem localWatchFanItem = (WatchFanItem)localIterator.next();
        if (localWatchFanItem != null)
          if (f())
            localWatchFanItem.c();
          else
            localWatchFanItem.d();
      }
    }
  }

  protected void a(boolean paramBoolean, yg paramyg)
  {
    int i1 = 0;
    while (true)
    {
      if (i1 < this.e.size())
      {
        try
        {
          WatchFanItem localWatchFanItem = (WatchFanItem)this.e.get(i1);
          yw localyw = (yw)this.f.get(i1);
          if (paramBoolean)
            localWatchFanItem.a(true, paramyg);
          else
            localWatchFanItem.d();
        }
        catch (Throwable paramyg)
        {
        }
      }
      else
      {
        this.H = false;
        return;
      }
      i1 += 1;
    }
  }

  protected boolean a()
  {
    return this.b.getCurrentTab().b().equals("switcher");
  }

  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if ((this.m) || (!this.n) || (this.H))
      return true;
    float f1 = getMeasuredHeight() - 0.1F;
    float f2 = paramFloat2;
    if (paramFloat2 > f1)
      f2 = f1;
    paramFloat2 = paramFloat4;
    if (paramFloat4 > f1)
      paramFloat2 = f1;
    if (this.c)
      if ((paramFloat5 < 0.0F) && (paramFloat6 < 0.0F))
        bool = false;
    int i1;
    while (this.a.e <= 1)
    {
      return true;
      if ((paramFloat5 > 0.0F) && (paramFloat6 > 0.0F))
      {
        bool = true;
      }
      else
      {
        if ((paramFloat5 > this.K) && (paramFloat6 < -this.K))
        {
          i1 = 1;
          if ((paramFloat1 - paramFloat3 <= this.L) || (f2 - paramFloat2 >= -this.L) || (f()))
            break label214;
        }
        label214: for (i2 = 1; ; i2 = 0)
        {
          if ((this.k) || ((i1 == 0) && (i2 == 0)))
            break label220;
          this.a.c(true);
          return true;
          i1 = 0;
          break;
        }
        label220: return true;
        if ((paramFloat5 > 0.0F) && (paramFloat6 < 0.0F))
        {
          bool = false;
        }
        else if ((paramFloat5 < 0.0F) && (paramFloat6 > 0.0F))
        {
          bool = true;
        }
        else
        {
          if ((paramFloat5 < -this.K) && (paramFloat6 < -this.K))
          {
            i1 = 1;
            if ((paramFloat1 - paramFloat3 >= -this.L) || (f2 - paramFloat2 >= -this.L) || (f()))
              break label359;
          }
          label359: for (i2 = 1; ; i2 = 0)
          {
            if ((this.k) || ((i1 == 0) && (i2 == 0)))
              break label365;
            this.a.c(true);
            return true;
            i1 = 0;
            break;
          }
          label365: return true;
        }
      }
    }
    int i2 = getHeight();
    if (this.c)
    {
      i1 = 0;
      if (this.k)
        break label544;
      this.O = false;
      this.k = true;
      vj.l = true;
      this.l = bool;
      this.C = ((float)-asq.a(i2, i1, f2, paramFloat1));
      this.E = this.C;
      ahy.b = true;
    }
    label544: 
    while (bool == this.l)
    {
      this.D = ((float)-asq.a(i2, i1, paramFloat2, paramFloat3));
      this.F = (this.D - this.C);
      if (!this.c)
        this.F = (-this.F);
      this.C = this.D;
      this.B = this.A;
      this.A += this.F;
      u();
      this.i = paramFloat3;
      this.j = paramFloat2;
      return true;
      i1 = getWidth();
      break;
    }
    if (!this.O);
    for (boolean bool = true; ; bool = false)
    {
      this.O = bool;
      break;
    }
  }

  boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((this.a.e <= 1) || (a(paramMotionEvent, false)))
      bool = true;
    return bool;
  }

  boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return a(paramMotionEvent, paramBoolean, false);
  }

  boolean a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = false;
    this.n = false;
    if ((!this.m) && ((this.k) || (paramBoolean1)))
    {
      afv.b();
      this.k = false;
      this.m = false;
      j();
      this.A = ahy.d(this.A);
      if (!paramBoolean1)
      {
        paramBoolean1 = paramBoolean2;
        if (!v());
      }
      else
      {
        paramBoolean1 = true;
      }
      this.N = paramBoolean1;
      float f1 = this.A;
      if (this.c)
        if (this.D > this.E)
          if (this.N)
            f1 = ((int)this.A / 90 + 1) * 90;
      while (true)
      {
        a(this.N, f1);
        return true;
        f1 = (int)this.A / 90 * 90;
        continue;
        if (this.N)
        {
          f1 = (int)this.A / 90 * 90;
        }
        else
        {
          f1 = ((int)this.A / 90 + 1) * 90;
          continue;
          if (this.D > this.E)
          {
            if (this.N)
              f1 = (int)this.A / 90 * 90;
            else
              f1 = ((int)this.A / 90 + 1) * 90;
          }
          else if (this.N)
            f1 = ((int)this.A / 90 + 1) * 90;
          else
            f1 = (int)this.A / 90 * 90;
        }
      }
    }
    return false;
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof zw;
  }

  public void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      final View localView = getChildAt(i1);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(paramInt);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setAnimationListener(new asw()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          localView.setVisibility(4);
        }
      });
      localView.startAnimation(localAnimationSet);
      i1 += 1;
    }
  }

  void b(boolean paramBoolean)
  {
    clearAnimation();
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(0).clearAnimation();
      i1 -= 1;
    }
    if (paramBoolean)
    {
      removeAllViews();
      Iterator localIterator = this.r.iterator();
      FanItem localFanItem;
      while (localIterator.hasNext())
      {
        localFanItem = (FanItem)localIterator.next();
        if ((localFanItem != null) && ((localFanItem.getTag() instanceof yw)))
          ((yw)localFanItem.getTag()).l();
      }
      this.r.clear();
      localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        localFanItem = (FanItem)localIterator.next();
        if ((localFanItem != null) && ((localFanItem.getTag() instanceof yw)))
          ((yw)localFanItem.getTag()).l();
      }
      this.t.clear();
      localIterator = this.s.iterator();
      while (localIterator.hasNext())
      {
        localFanItem = (FanItem)localIterator.next();
        if ((localFanItem != null) && ((localFanItem.getTag() instanceof yw)))
          ((yw)localFanItem.getTag()).l();
      }
      this.s.clear();
      return;
    }
    detachAllViewsFromParent();
  }

  protected boolean b()
  {
    String str = this.b.getCurrentTab().b();
    return ("recentlyUsed".equals(str)) || ("contact".equals(str));
  }

  public void c(int paramInt)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      final View localView = getChildAt(i1);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(paramInt);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setAnimationListener(new asw()
      {
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          localView.setVisibility(0);
        }
      });
      localView.startAnimation(localAnimationSet);
      i1 += 1;
    }
  }

  protected boolean c()
  {
    return this.b.getCurrentTab().b().equals("mostUsed");
  }

  protected boolean d()
  {
    return this.b.getCurrentTab().b().equals("custom");
  }

  protected void e(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.size())
      try
      {
        WatchFanItem localWatchFanItem = (WatchFanItem)this.e.get(i1);
        yw localyw = (yw)this.f.get(i1);
        if ((localWatchFanItem != null) && (localyw.d()))
          if (paramView == localWatchFanItem)
            break label81;
        label81: for (boolean bool = true; ; bool = false)
        {
          localWatchFanItem.a(bool);
          i1 += 1;
          break;
        }
      }
      catch (Throwable paramView)
      {
      }
  }

  protected boolean e()
  {
    return false;
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 39)
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    if ((this.H) && (this.ad != null))
      return this.ad[paramInt2];
    if (this.Q != null)
      return this.Q[paramInt2];
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }

  public List<? extends FanItem> getItems()
  {
    return this.e;
  }

  public aao getTab()
  {
    return this.b.getCurrentTab();
  }

  void o()
  {
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
      a((WatchFanItem)localIterator.next());
    localIterator = this.t.iterator();
    while (localIterator.hasNext())
      a((WatchFanItem)localIterator.next());
    localIterator = this.s.iterator();
    while (localIterator.hasNext())
      a((WatchFanItem)localIterator.next());
  }

  public boolean onDragEvent(DragEvent paramDragEvent)
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
      a(paramDragEvent);
      return true;
      c(paramDragEvent);
      continue;
      return d(paramDragEvent);
      e(paramDragEvent);
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (isInEditMode());
    float f1;
    float f2;
    do
    {
      return false;
      switch (i1)
      {
      case 1:
      default:
        this.M = 0;
        return false;
      case 0:
        this.I = paramMotionEvent.getX();
        this.J = paramMotionEvent.getY();
        return false;
      case 2:
      }
      if (1 == this.M)
        break;
      f1 = Math.abs(paramMotionEvent.getX() - this.I);
      f2 = Math.abs(paramMotionEvent.getY() - this.J);
    }
    while ((f1 <= this.K) && (f2 <= this.K));
    this.M = 1;
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(0);
    this.p.onTouchEvent(paramMotionEvent);
    return true;
    return true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (this.a.g()));
    while (true)
    {
      return true;
      if (this.M != 0);
      int i1 = paramMotionEvent.getAction();
      try
      {
        this.p.onTouchEvent(paramMotionEvent);
        if ((3 != i1) && (1 != i1))
          continue;
        this.M = 0;
        this.h = false;
        a(paramMotionEvent);
        return true;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          asp.b(q, "Exception in GestureDetector.onTouchEvent: " + localThrowable.getMessage());
      }
    }
  }

  void p()
  {
    this.U = -1;
    this.V = -1;
    if ((this.ae != null) && (this.ae.get() != null))
    {
      ((xz)this.ae.get()).b();
      this.ae.clear();
      this.ae = null;
    }
    if (this.x != null)
    {
      this.x.clearAnimation();
      this.x.setVisibility(0);
      this.x = null;
    }
    if (this.ac != null)
    {
      this.ac.clearAnimation();
      this.ac.setVisibility(0);
      this.ac = null;
    }
    this.H = false;
    x();
  }

  public void q()
  {
    int i3 = 0;
    int i1 = 0;
    WatchFanItem localWatchFanItem;
    while (i1 < this.r.size())
    {
      localWatchFanItem = (WatchFanItem)this.r.get(i1);
      if (f(localWatchFanItem))
        localWatchFanItem.i();
      i1 += 1;
    }
    i1 = 0;
    int i2;
    while (true)
    {
      i2 = i3;
      if (i1 >= this.t.size())
        break;
      localWatchFanItem = (WatchFanItem)this.t.get(i1);
      if (f(localWatchFanItem))
        localWatchFanItem.i();
      i1 += 1;
    }
    while (i2 < this.s.size())
    {
      localWatchFanItem = (WatchFanItem)this.s.get(i2);
      if (f(localWatchFanItem))
        localWatchFanItem.i();
      i2 += 1;
    }
    requestLayout();
  }

  public void r()
  {
    int i1 = 0;
    WatchFanItem localWatchFanItem;
    while (i1 < this.r.size())
    {
      localWatchFanItem = (WatchFanItem)this.r.get(i1);
      if (f(localWatchFanItem))
        localWatchFanItem.j();
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.t.size())
    {
      localWatchFanItem = (WatchFanItem)this.t.get(i1);
      if (f(localWatchFanItem))
        localWatchFanItem.j();
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.s.size())
    {
      localWatchFanItem = (WatchFanItem)this.s.get(i1);
      if (f(localWatchFanItem))
        localWatchFanItem.j();
      i1 += 1;
    }
    if (this.a.getHandTracker().d())
      ((WatchSectorArea)this.b).a(false);
  }

  public void setDirection(boolean paramBoolean)
  {
    super.setDirection(paramBoolean);
    WatchSectorArea.a(this, paramBoolean);
  }

  protected void setHasAddIcon(boolean paramBoolean)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.hetero.iwatch.WatchItemSector
 * JD-Core Version:    0.6.2
 */