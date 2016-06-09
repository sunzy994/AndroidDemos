package cmcm.com.myapplication.com.lazyswipe.fan.friend;

import ahr;
import ahw;
import ahx;
import ahy;
import alw;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqo;
import arj;
import asq;
import asw;
import atp;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.fan.TabSectorBg;
import com.lazyswipe.fan.hetero.iwatch.WatchTabSectorBg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vv;
import vy;
import xe;
import xu;
import yb;
import ye;
import yl;
import yn;
import yv;
import zg;

public class FriendSector extends FrameLayout
  implements OnClickListener
{
  private static final String a = "Swipe." + FriendSector.class.getSimpleName();
  private static WeakReference<FriendSector> b;
  private WeakReference<FanItem> c;
  private yv d;
  private boolean e;
  private int f;
  private int g;
  private Paint h;
  private int i;
  private int j;
  private int k;
  private final int[] l = new int[2];
  private final int[] m = new int[2];
  private final List<TextView> n = new ArrayList();
  private ImageView o;
  private ImageView p;
  private int q;
  private int r;
  private boolean s;

  public FriendSector(Context paramContext)
  {
    super(paramContext);
  }

  public FriendSector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private static double a(int paramInt1, int paramInt2)
  {
    return 1.570796326794897D / (paramInt2 * 2) * ((paramInt2 - paramInt1) * 2 - 1);
  }

  public static FriendSector a(FanItem paramFanItem)
  {
    if (a())
      return null;
    if ((paramFanItem == null) || (!(paramFanItem.getTag() instanceof yv)) || (((yv)paramFanItem.getTag()).g() == null))
      return null;
    FriendSector localFriendSector = (FriendSector)LayoutInflater.from(SwipeApplication.c()).inflate(2130968649, null);
    localFriendSector.b(paramFanItem);
    return localFriendSector;
  }

  private static yl a(int paramInt, double paramDouble, boolean paramBoolean)
  {
    int i2 = (int)(paramInt * Math.cos(paramDouble));
    if (paramBoolean);
    for (int i1 = 1; ; i1 = -1)
      return new yl(i1 * i2, (int)(paramInt * Math.sin(paramDouble)));
  }

  private static yl a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt3, a(paramInt1, paramInt2), paramBoolean);
  }

  public static boolean a()
  {
    return (b != null) && (b.get() != null);
  }

  private void b(FanItem paramFanItem)
  {
    yb localyb = yb.getInstance();
    this.c = new WeakReference(paramFanItem);
    this.d = ((yv)paramFanItem.getTag());
    this.s = false;
    paramFanItem.k();
    if ((this.d.c(localyb.getContext()) instanceof aqo))
      this.h.setColor(((aqo)this.d.c(localyb.getContext())).b());
    paramFanItem = new LayoutParams(-1, -1);
    if (this.e);
    for (int i1 = 3; ; i1 = 5)
    {
      paramFanItem.gravity = (i1 | 0x50);
      localyb.addView(this, paramFanItem);
      return;
    }
  }

  public static boolean b()
  {
    if (a())
    {
      ((FriendSector)b.get()).u();
      return true;
    }
    return false;
  }

  private Drawable j()
  {
    if ((yb.getInstance() == null) || (!a()))
      return null;
    Object localObject = (FanItem)this.c.get();
    if (localObject == null)
      return null;
    Drawable localDrawable = ((FanItem)localObject).getIcon();
    localObject = ((FanItem)localObject).getIconRect();
    if (localDrawable == null)
      return null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(((Rect)localObject).width(), ((Rect)localObject).height(), Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = Math.min(((Rect)localObject).width() / localDrawable.getIntrinsicWidth(), ((Rect)localObject).height() / localDrawable.getIntrinsicHeight());
      localCanvas.scale(f1, f1, ((Rect)localObject).width() / 2, ((Rect)localObject).height() / 2);
      localCanvas.translate((((Rect)localObject).width() - localDrawable.getIntrinsicWidth()) / 2, (((Rect)localObject).height() - localDrawable.getIntrinsicHeight()) / 2);
      localDrawable.draw(localCanvas);
      localObject = new BitmapDrawable(getResources(), localBitmap);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return localDrawable;
  }

  private void k()
  {
    if (yb.getInstance() != null)
    {
      l();
      q();
      o();
      n();
      m();
    }
  }

  private void l()
  {
    Object localObject1 = yb.getInstance();
    if ((localObject1 == null) || (!a()));
    do
    {
      return;
      Object localObject2 = ((yb)localObject1).getItemLayer();
      if (localObject2 != null)
        ((xu)localObject2).b(150);
      localObject2 = ((yb)localObject1).getItemSectorBg();
      if (localObject2 != null)
        ((View)localObject2).animate().alpha(0.0F).setDuration(100L).setListener(null);
      localObject1 = ((yb)localObject1).getTabSector();
    }
    while (localObject1 == null);
    ((View)localObject1).animate().alpha(0.0F).setDuration(100L).setListener(null);
  }

  private void m()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    int i1 = this.l[0];
    int i2 = this.o.getWidth() / 2;
    int i3 = this.l[1];
    int i4 = this.o.getHeight() / 2;
    float f1 = this.j / this.o.getWidth();
    this.o.animate().x(i1 - i2).y(i3 - i4).scaleX(f1).scaleY(f1).setDuration(250L).setStartDelay(50L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FriendSector.b(FriendSector.this);
      }
    });
  }

  private void n()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    if (!ahy.d(getContext()))
    {
      this.p.setScaleX(0.0F);
      this.p.setScaleY(0.0F);
      this.p.animate().scaleX(1.0F).scaleY(1.0F).setDuration(500L);
      return;
    }
    int i1 = asq.a(25.0F);
    int i2 = asq.a(8.0F);
    Object localObject = this.p;
    if (this.e)
    {
      f1 = -i1;
      ((ImageView)localObject).setX(f1);
      this.p.setY(getHeight());
      localObject = this.p.animate();
      if (!this.e)
        break label168;
    }
    label168: for (float f1 = i2; ; f1 = getWidth() - i2 - i1)
    {
      ((ViewPropertyAnimator)localObject).x(f1).y(getHeight() - i2 - i1).alpha(1.0F).setDuration(500L);
      return;
      f1 = getWidth();
      break;
    }
  }

  private void o()
  {
    Object localObject = (LayoutParams)this.p.getLayoutParams();
    float f1;
    if (this.e)
    {
      i1 = 3;
      ((LayoutParams)localObject).gravity = (i1 | 0x50);
      localObject = p();
      this.p.setBackgroundDrawable((Drawable)localObject);
      ImageView localImageView = this.p;
      if (!this.e)
        break label108;
      f1 = 0.0F;
      label57: localImageView.setPivotX(f1);
      this.p.setPivotY(((Drawable)localObject).getIntrinsicHeight());
      localObject = this.p;
      if (!ahx.b(getContext()).b())
        break label117;
    }
    label108: label117: for (int i1 = 0; ; i1 = 8)
    {
      ((ImageView)localObject).setVisibility(i1);
      return;
      i1 = 5;
      break;
      f1 = ((Drawable)localObject).getIntrinsicWidth();
      break label57;
    }
  }

  private Drawable p()
  {
    if (!ahy.d(getContext()))
    {
      localObject1 = getResources().getDrawable(2130837649);
      i1 = ahx.b(getContext()).i();
      localObject1 = new yn(0, this.i, yb.getInstance().getCenterOffset(), i1, this.e, (Drawable)localObject1);
      ((yn)localObject1).c = ((int)Math.min(asq.a(20.0F), this.i * 0.35F));
      return localObject1;
    }
    int i1 = asq.a(25.0F);
    Object localObject1 = Bitmap.createBitmap(i1, i1, Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject1);
    Object localObject2 = new Paint(7);
    ((Paint)localObject2).setStyle(Style.STROKE);
    ((Paint)localObject2).setStrokeWidth(2.0F);
    ((Paint)localObject2).setColor(-1);
    int i2 = (i1 - 2) / 2;
    localCanvas.drawCircle(i1 / 2, i1 / 2, i2, (Paint)localObject2);
    localObject2 = atp.d(getContext());
    i2 = (i1 - ((Bitmap)localObject2).getWidth()) / 2;
    localCanvas.drawBitmap((Bitmap)localObject2, null, new Rect(i2, i2, i1 - i2, i1 - i2), null);
    return new BitmapDrawable(getResources(), (Bitmap)localObject1);
  }

  private void q()
  {
    yb localyb = yb.getInstance();
    if ((localyb == null) || (!a()));
    View localView;
    do
    {
      return;
      localView = localyb.getTabSectorBg();
      if ((localView instanceof TabSectorBg))
      {
        int i1 = localyb.getTabSectorOuterSize();
        if ((ahx.b(getContext()) instanceof ahr));
        for (float f1 = 266.70001F; ; f1 = 276.70001F)
        {
          f1 = asq.a(f1);
          ((TabSectorBg)localView).a(f1 / i1, 500);
          return;
        }
      }
    }
    while (!(localView instanceof WatchTabSectorBg));
    ((WatchTabSectorBg)localView).a(0.5F, 500);
  }

  private void r()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { (int)(this.o.getWidth() * 0.49D), asq.a(35.5F) });
    localValueAnimator.setInterpolator(new ye());
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FriendSector.a(FriendSector.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        FriendSector.this.invalidate();
      }
    });
    localValueAnimator.start();
    postDelayed(new Runnable()
    {
      public void run()
      {
        FriendSector.c(FriendSector.this);
        FriendSector.d(FriendSector.this);
      }
    }
    , 200L);
  }

  private void s()
  {
    if ((yb.getInstance() == null) || (!a()));
    while (true)
    {
      return;
      this.o.bringToFront();
      int i2 = this.n.size();
      int i1 = 0;
      while (i1 < i2)
      {
        final TextView localTextView = (TextView)this.n.get(i1);
        Object localObject = (LayoutParams)localTextView.getLayoutParams();
        AnimationSet localAnimationSet = new AnimationSet(false);
        int i3 = this.l[0];
        int i4 = this.k / 2;
        int i5 = ((LayoutParams)localObject).leftMargin;
        int i6 = this.l[1];
        int i7 = this.k / 2;
        int i8 = ((LayoutParams)localObject).topMargin;
        localObject = new TranslateAnimation(i3 - i4 - i5, 0.0F, i6 - i7 - i8, 0.0F);
        ((TranslateAnimation)localObject).setDuration(300L);
        ((TranslateAnimation)localObject).setInterpolator(new ye());
        localAnimationSet.addAnimation((Animation)localObject);
        localObject = new AlphaAnimation(0.8F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(200L);
        localAnimationSet.addAnimation((Animation)localObject);
        localAnimationSet.setStartOffset(i1 * 10);
        localAnimationSet.setAnimationListener(new asw()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (yb.getInstance() == null)
              return;
            paramAnonymousAnimation = ValueAnimator.ofInt(new int[] { 0, 255 });
            paramAnonymousAnimation.setDuration(125L).addUpdateListener(new AnimatorUpdateListener()
            {
              public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                int i = ahx.b(FriendSector.this.getContext()).m();
                i = Color.argb(((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue(), Color.red(i), Color.green(i), Color.blue(i));
                FriendSector.12.this.a.setTextColor(i);
              }
            });
            paramAnonymousAnimation.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                if ((yb.getInstance() != null) && (FriendSector.a()) && (FriendSector.12.this.a != null))
                  FriendSector.12.this.a.requestLayout();
              }
            });
            paramAnonymousAnimation.start();
          }
        });
        localTextView.startAnimation(localAnimationSet);
        i1 += 1;
      }
    }
  }

  private void t()
  {
    Object localObject1 = zg.a(this.d.g(), 5).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((zg)((Iterator)localObject1).next()).j();
      ((TextView)localObject2).setOnClickListener(this);
      this.n.add(localObject2);
    }
    int i2 = this.n.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1 = (TextView)this.n.get(i1);
      localObject2 = a(i1, i2, this.f, this.e);
      LayoutParams localLayoutParams = new LayoutParams(-2, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.leftMargin = (this.m[0] + ((yl)localObject2).a - this.k / 2);
      localLayoutParams.topMargin = (this.m[1] - ((yl)localObject2).b - this.k / 2);
      addView((View)localObject1, localLayoutParams);
      ((TextView)localObject1).setTextColor(0);
      i1 += 1;
    }
  }

  private void u()
  {
    if ((yb.getInstance() == null) || (!a()));
    while (this.s)
      return;
    this.s = true;
    w();
    v();
    postDelayed(new Runnable()
    {
      public void run()
      {
        FriendSector.this.e();
        FriendSector.this.f();
        FriendSector.this.g();
        FriendSector.this.h();
      }
    }
    , 100L);
  }

  private void v()
  {
    if ((yb.getInstance() == null) || (!a()));
    while (true)
    {
      return;
      int i2 = this.n.size();
      int i1 = 0;
      while (i1 < i2)
      {
        final TextView localTextView = (TextView)this.n.get(i1);
        Object localObject = (LayoutParams)localTextView.getLayoutParams();
        AnimationSet localAnimationSet = new AnimationSet(false);
        int i3 = this.l[0];
        int i4 = this.k / 2;
        int i5 = ((LayoutParams)localObject).leftMargin;
        int i6 = this.l[1];
        int i7 = this.k / 2;
        int i8 = ((LayoutParams)localObject).topMargin;
        localObject = new TranslateAnimation(0.0F, i3 - i4 - i5, 0.0F, i6 - i7 - i8);
        ((TranslateAnimation)localObject).setDuration(145L);
        ((TranslateAnimation)localObject).setInterpolator(new ye());
        localAnimationSet.addAnimation((Animation)localObject);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.6F, 1.0F, 0.6F, 1, 0.5F, 1, 0.5F);
        ((TranslateAnimation)localObject).setDuration(145L);
        localAnimationSet.addAnimation(localScaleAnimation);
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(145L);
        localAnimationSet.addAnimation((Animation)localObject);
        localAnimationSet.setStartOffset(i1 * 6);
        localAnimationSet.setAnimationListener(new asw()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if ((yb.getInstance() != null) && (FriendSector.a()) && (localTextView != null))
              localTextView.setVisibility(8);
          }
        });
        localTextView.startAnimation(localAnimationSet);
        i1 += 1;
      }
    }
  }

  private void w()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.g, (int)(this.g * 2.0F) });
    localValueAnimator1.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FriendSector.a(FriendSector.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        FriendSector.this.invalidate();
      }
    });
    localValueAnimator1.setInterpolator(new AccelerateInterpolator());
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 1 });
    localValueAnimator2.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        FriendSector.e(FriendSector.this).setAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FriendSector.a(FriendSector.this, 0);
      }
    });
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator2, localValueAnimator1 });
    localAnimatorSet.start();
  }

  void c()
  {
    FanItem localFanItem = (FanItem)this.c.get();
    if ((localFanItem == null) || (!a()) || (yb.getInstance() == null))
      return;
    Drawable localDrawable = j();
    this.o.setImageDrawable(localDrawable);
    int[] arrayOfInt = localFanItem.getIconPosition();
    this.q = (arrayOfInt[0] - getLeft());
    this.r = (arrayOfInt[1] - getTop());
    this.o.setX(this.q);
    this.o.setY(this.r);
    this.o.setPivotX(localDrawable.getIntrinsicWidth() / 2);
    this.o.setPivotY(localDrawable.getIntrinsicHeight() / 2);
    this.o.setScaleX(localFanItem.getScaleX());
    this.o.setScaleY(localFanItem.getScaleY());
    post(new Runnable()
    {
      public void run()
      {
        FriendSector.a(FriendSector.this);
      }
    });
  }

  public void d()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
      removeView((View)localIterator.next());
    this.n.clear();
    post(new Runnable()
    {
      public void run()
      {
        FriendSector.c(FriendSector.this);
        FriendSector.d(FriendSector.this);
      }
    });
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.g > 0)
      paramCanvas.drawCircle(this.l[0], this.l[1], this.g, this.h);
    super.dispatchDraw(paramCanvas);
  }

  void e()
  {
    if ((yb.getInstance() == null) || (!a()));
    while (this.c.get() == null)
      return;
    float f1 = ((FanItem)this.c.get()).getScaleX();
    this.o.animate().translationX(this.q).translationY(this.r).alpha(0.75F).scaleX(f1).scaleY(f1).setDuration(300L).setStartDelay(50L).setListener(null);
  }

  void f()
  {
    if ((yb.getInstance() == null) || (!a()))
      return;
    if (!ahy.d(getContext()))
    {
      this.p.animate().scaleX(0.0F).scaleY(0.0F).setDuration(300L).setListener(null);
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.p.animate();
    if (this.e);
    for (float f1 = -this.p.getMeasuredWidth(); ; f1 = getWidth())
    {
      localViewPropertyAnimator.x(f1).y(getHeight()).alpha(0.0F).setDuration(300L).setListener(null);
      return;
    }
  }

  void g()
  {
    Object localObject = yb.getInstance();
    if ((localObject == null) || (!a()));
    do
    {
      return;
      localObject = ((yb)localObject).getTabSectorBg();
      if ((localObject instanceof TabSectorBg))
      {
        ((TabSectorBg)localObject).a(300);
        return;
      }
    }
    while (!(localObject instanceof WatchTabSectorBg));
    ((WatchTabSectorBg)localObject).a(300);
  }

  void h()
  {
    Object localObject1 = yb.getInstance();
    if ((localObject1 == null) || (!a()));
    do
    {
      return;
      if (this.c.get() != null)
        ((FanItem)this.c.get()).setAlpha(0.0F);
      Object localObject2 = ((yb)localObject1).getItemLayer();
      if (localObject2 != null)
        ((xu)localObject2).c(300);
      localObject2 = ((yb)localObject1).getItemSectorBg();
      if (localObject2 != null)
        ((View)localObject2).animate().alpha(1.0F).setDuration(300L).setListener(null);
      localObject1 = ((yb)localObject1).getTabSector();
    }
    while (localObject1 == null);
    ((View)localObject1).animate().alpha(1.0F).setDuration(300L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FriendSector.this.post(new Runnable()
        {
          public void run()
          {
            if (FriendSector.f(FriendSector.this).get() != null)
              ((FanItem)FriendSector.f(FriendSector.this).get()).setAlpha(1.0F);
            FriendSector.this.post(new Runnable()
            {
              public void run()
              {
                FriendSector.this.i();
              }
            });
          }
        });
      }
    });
  }

  public void i()
  {
    yb localyb = yb.getInstance();
    if (localyb != null)
      localyb.removeView(this);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b = new WeakReference(this);
    post(new Runnable()
    {
      public void run()
      {
        FriendSector.this.c();
      }
    });
  }

  public void onClick(View paramView)
  {
    if ((paramView == this) || (paramView == this.p))
    {
      u();
      if (paramView == this.p)
        vy.a(getContext(), "CQ", "2");
    }
    while (true)
    {
      return;
      if ((paramView.getTag() instanceof zg))
      {
        paramView = (zg)paramView.getTag();
        String str = paramView.a();
        alw localalw = this.d.g();
        if (str.equals(zg.h.a()))
          vv.a().a("点击添加联系方式");
        while (paramView.a(localalw, new WeakReference(this)))
        {
          yb.p();
          return;
          vy.a(getContext(), "C5", String.valueOf(paramView.i));
          vv.a().a("点击联系方式", "connection", paramView.i);
          arj.a(new Runnable()
          {
            public void run()
            {
              FriendSector.this.getContext().getContentResolver().call(xe.a, "updateContactLog", this.a, null);
            }
          });
        }
      }
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (b != null)
    {
      b.clear();
      b = null;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.o = ((ImageView)findViewById(2131755270));
    this.p = ((ImageView)findViewById(2131755271));
    this.p.setOnClickListener(this);
    setOnClickListener(this);
    yb localyb = yb.getInstance();
    this.e = localyb.n();
    this.f = asq.a(213.3F);
    float f1;
    int i2;
    int[] arrayOfInt;
    if ((ahx.b(getContext()) instanceof ahr))
    {
      f1 = 98.0F;
      i2 = asq.a(f1);
      arrayOfInt = this.l;
      if (!this.e)
        break label268;
      i1 = i2;
      label106: arrayOfInt[0] = i1;
      this.l[1] = (localyb.getHeight() - i2);
      i2 = asq.a(16.700001F);
      arrayOfInt = this.m;
      if (!this.e)
        break label280;
    }
    label268: label280: for (int i1 = i2; ; i1 = localyb.getWidth() - i2)
    {
      arrayOfInt[0] = i1;
      this.m[1] = (localyb.getHeight() - i2);
      this.h = new Paint();
      this.h.setFlags(7);
      this.h.setColor(ahx.b(getContext()).i());
      this.h.setStyle(Style.STROKE);
      this.h.setStrokeWidth(3.0F);
      this.k = asq.a(40.0F);
      this.i = (yb.getInstance().getTabSectorInnerSize() - asq.a(3.3F));
      this.j = asq.a(50.0F);
      return;
      f1 = 90.0F;
      break;
      i1 = localyb.getWidth() - i2;
      break label106;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.friend.FriendSector
 * JD-Core Version:    0.6.2
 */