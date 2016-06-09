package cmcm.com.myapplication.com.lazyswipe.features.boostplus;

import acj;
import acl;
import acu;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqr;
import aqs;
import asq;
import ast;
import asv;
import asw;
import ci;
import com.lazyswipe.view.ShadowView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoostPlusCleaningPanel extends RelativeLayout
  implements OnClickListener, OnTouchListener
{
  private BoostProgressEngine a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private ShadowView e;
  private ImageView f;
  private View g;
  private BoostPlusPlaneLayout h;
  private LinearLayout i;
  private final int[] j = new int[2];
  private boolean k;
  private boolean l;
  private acj m;
  private final int n = 650;
  private List<acl> o;
  private List<acl> p;
  private final Handler q = new Handler();
  private Runnable r;
  private WindowManager.LayoutParams s;
  private boolean t;
  private final List<acu> u = new ArrayList();
  private Point v;
  private boolean w;
  private final Runnable x = new Runnable()
  {
    public void run()
    {
      int i = BoostPlusCleaningPanel.d(BoostPlusCleaningPanel.this).size();
      acu localacu;
      if ((BoostPlusCleaningPanel.e(BoostPlusCleaningPanel.this) != null) && (BoostPlusCleaningPanel.e(BoostPlusCleaningPanel.this).x != 0) && (BoostPlusCleaningPanel.e(BoostPlusCleaningPanel.this).y != 0))
      {
        if (i % 2 == 0)
        {
          localacu = acu.a(BoostPlusCleaningPanel.this.getContext(), BoostPlusCleaningPanel.e(BoostPlusCleaningPanel.this));
          localacu.a(BoostPlusCleaningPanel.this);
          BoostPlusCleaningPanel.d(BoostPlusCleaningPanel.this).add(localacu);
        }
      }
      else if ((BoostPlusCleaningPanel.f(BoostPlusCleaningPanel.this)) && (BoostPlusCleaningPanel.g(BoostPlusCleaningPanel.this)))
        if (i % 4 != 0)
          break label161;
      label161: for (i = 2200; ; i = 500)
      {
        BoostPlusCleaningPanel.h(BoostPlusCleaningPanel.this).postDelayed(this, i);
        return;
        localacu = acu.b(BoostPlusCleaningPanel.this.getContext(), BoostPlusCleaningPanel.e(BoostPlusCleaningPanel.this));
        break;
      }
    }
  };
  private boolean y;
  private final BroadcastReceiver z = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (("BROADCAST_ACTION_HOME_KEY".equals(paramAnonymousIntent.getAction())) && (BoostPlusCleaningPanel.p(BoostPlusCleaningPanel.this)))
        BoostPlusCleaningPanel.this.b();
    }
  };

  public BoostPlusCleaningPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[] { -14236968, -13472312 }));
  }

  private void a(Runnable paramRunnable, acl paramacl)
  {
    this.b.setImageDrawable(paramacl.b);
    paramacl = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, this.b.getWidth() / 2, this.b.getHeight() / 2);
    paramacl.setDuration(500L);
    this.b.startAnimation(paramacl);
    if (paramRunnable != null)
      this.q.postDelayed(paramRunnable, 500L);
  }

  private void c()
  {
    this.c.setVisibility(8);
    e();
    if (this.r != null)
      this.r.run();
  }

  private void d()
  {
    this.c.getLocationOnScreen(this.j);
    int i1 = this.j[1];
    int i2 = this.c.getMeasuredHeight() / 2;
    this.a.getLocationOnScreen(this.j);
    int i3 = this.j[1];
    int i4 = this.a.getMeasuredWidth() / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, this.c.getWidth() / 2, this.c.getHeight() / 2);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(2.0F));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i3 + i4 - (i1 + i2));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(2.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(500L);
    localAnimationSet.setAnimationListener(new asw()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        BoostPlusCleaningPanel.b(BoostPlusCleaningPanel.this).setImageDrawable(BoostPlusCleaningPanel.a(BoostPlusCleaningPanel.this).getDrawable());
        BoostPlusCleaningPanel.b(BoostPlusCleaningPanel.this).clearAnimation();
        BoostPlusCleaningPanel.a(BoostPlusCleaningPanel.this).clearAnimation();
      }
    });
    this.c.startAnimation(localAnimationSet);
  }

  private void e()
  {
    this.t = true;
    this.s.flags = 262144;
    ast.b(getContext(), this, this.s);
    this.f.setVisibility(8);
    this.b.setImageDrawable(null);
    this.q.removeCallbacks(this.x);
    this.k = false;
    postDelayed(new Runnable()
    {
      public void run()
      {
        BoostPlusCleaningPanel.b(BoostPlusCleaningPanel.this, true);
      }
    }
    , 1200L);
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
      ((acu)localIterator.next()).a();
    postDelayed(new Runnable()
    {
      public void run()
      {
        BoostPlusCleaningPanel.c(BoostPlusCleaningPanel.this);
      }
    }
    , getWaitingTime());
    getContext().sendBroadcast(new Intent("memory_refresh"));
  }

  private void f()
  {
    this.h.setPlaneLayoutHeight(getMeasuredHeight());
    int i1 = getMeasuredHeight() - asq.a(125.0F);
    this.h.a(getMeasuredHeight(), getMeasuredHeight() - asq.a(125.0F));
    this.a.animate().scaleX(0.6F).scaleY(0.6F).translationYBy(-i1).setDuration(650L);
    this.g.animate().alpha(0.3F).y(aqs.ad()).setDuration(650L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i1 });
    localValueAnimator.setDuration(650L);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        boolean bool = BoostPlusCleaningPanel.i(BoostPlusCleaningPanel.this).b();
        BoostPlusCleaningPanel.j(BoostPlusCleaningPanel.this).a(bool);
        BoostPlusCleaningPanel.k(BoostPlusCleaningPanel.this).setVisibility(8);
        BoostPlusCleaningPanel.this.findViewById(2131755144).setVisibility(0);
        BoostPlusCleaningPanel.l(BoostPlusCleaningPanel.this);
        if (bool)
        {
          BoostPlusCleaningPanel.m(BoostPlusCleaningPanel.this);
          BoostPlusCleaningPanel.n(BoostPlusCleaningPanel.this);
          BoostPlusCleaningPanel.o(BoostPlusCleaningPanel.this);
        }
      }
    });
    localValueAnimator.start();
  }

  private void g()
  {
    int i2 = 1;
    if ((this.p == null) || (this.p.size() == 0))
    {
      findViewById(2131755146).setVisibility(0);
      ((TextView)findViewById(2131755147)).setText(getContext().getString(2131230785, new Object[] { Long.valueOf(Math.max(1L, this.h.a * 100L * 1024L / aqr.a())) }) + "%");
    }
    int i1;
    do
    {
      return;
      findViewById(2131755145).setVisibility(0);
      int i4 = asq.a(45.0F);
      int i3 = this.i.getMeasuredWidth();
      i1 = i3;
      if (i3 <= 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.i.getLayoutParams();
        i1 = aqs.ac() - ((LinearLayout.LayoutParams)localObject1).leftMargin - ((LinearLayout.LayoutParams)localObject1).rightMargin;
      }
      i3 = i1 / i4;
      if (i1 / i4 > 0);
      for (i1 = i2; ; i1 = 0)
      {
        i2 = 0;
        while ((i2 < i3) && (i2 < this.p.size()))
        {
          localObject1 = (acl)this.p.get(i2);
          localObject2 = new ImageView(getContext());
          int i5 = asq.a(4.0F);
          ((ImageView)localObject2).setPadding(i5, 0, i5, 0);
          ((ImageView)localObject2).setImageDrawable(((acl)localObject1).b);
          this.i.addView((View)localObject2, i4, i4 - i5 * 2);
          i2 += 1;
        }
      }
    }
    while (i1 == 0);
    Object localObject1 = new View(getContext());
    Object localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.i.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }

  private long getWaitingTime()
  {
    Iterator localIterator = this.u.iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      long l2 = ((acu)localIterator.next()).getRequireTime();
      if (l2 <= l1)
        break label50;
      l1 = l2;
    }
    label50: 
    while (true)
    {
      break;
      return l1;
    }
  }

  private void h()
  {
    if (this.m == null);
    View localView;
    do
    {
      return;
      localView = this.m.e();
    }
    while (localView == null);
    localView.setVisibility(0);
  }

  private void i()
  {
    if (this.m == null);
    View localView;
    do
    {
      return;
      localView = this.m.i();
    }
    while (localView == null);
    localView.setVisibility(0);
  }

  private void j()
  {
    if (this.m == null);
    View localView;
    do
    {
      return;
      localView = this.m.g();
    }
    while (localView == null);
    localView.setVisibility(0);
    findViewById(2131755154).setVisibility(0);
  }

  private void k()
  {
    if (this.y)
      return;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("BROADCAST_ACTION_HOME_KEY");
      ci.a(getContext()).a(this.z, localIntentFilter);
      this.y = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void l()
  {
    if (!this.y)
      return;
    try
    {
      ci.a(getContext()).a(this.z);
      this.y = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a()
  {
    ast.a(getContext(), this);
  }

  public void a(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == this.o.size())
      this.d.setText(2131231187);
    for (acl localacl1 = null; ; localacl1 = (acl)this.o.get(paramInt))
    {
      acl localacl2 = (acl)this.o.get(paramInt - 1);
      this.c.setImageDrawable(localacl2.b);
      this.h.a(localacl2.d);
      d();
      if (localacl1 == null)
        break;
      a(paramRunnable, localacl1);
      return;
      this.d.setText(getContext().getString(2131231186, new Object[] { String.valueOf(paramInt + 1), String.valueOf(this.o.size()) }));
      this.d.invalidate();
      this.e.a();
    }
    e();
  }

  public void a(final Runnable paramRunnable1, final List<acl> paramList1, Runnable paramRunnable2, acj paramacj, List<acl> paramList2)
  {
    setLayerType(2, null);
    this.o = new ArrayList(paramList1);
    this.p = paramList2;
    this.r = paramRunnable2;
    this.s = new WindowManager.LayoutParams();
    this.s.type = 2003;
    this.s.flags = 262184;
    this.s.format = -2;
    this.s.width = -1;
    this.s.height = -1;
    this.s.gravity = 17;
    setFocusableInTouchMode(true);
    ast.a(getContext().getApplicationContext(), this, this.s);
    setOnTouchListener(this);
    findViewById(2131755124).setAlpha(0.0F);
    paramList1 = findViewById(2131755124).animate().alpha(1.0F).setDuration(300L);
    asv.b(paramList1, new Runnable()
    {
      public void run()
      {
        BoostPlusCleaningPanel.a(BoostPlusCleaningPanel.this, true);
        BoostPlusCleaningPanel.b(BoostPlusCleaningPanel.this, false);
        asv.b(paramList1, null);
        if (paramRunnable1 != null)
          paramRunnable1.run();
      }
    });
    this.d.setText(getContext().getString(2131231186, new Object[] { Integer.valueOf(1), Integer.valueOf(this.o.size()) }));
    this.c.setImageDrawable(((acl)this.o.get(0)).b);
    this.m = paramacj;
    if (this.m != null)
      this.m.a(this);
  }

  public void a(boolean paramBoolean)
  {
    if (!BoostActivity.h())
      a();
    if (paramBoolean)
      BoostActivity.a(getContext());
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        BoostPlusCleaningPanel.this.a();
      }
    }
    , 1500L);
  }

  public void b()
  {
    a(true);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (this.l) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      b();
    return false;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.w = true;
    this.u.clear();
    this.a.c();
    this.q.postDelayed(this.x, 500L);
    k();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.f)
      c();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.w = false;
    this.q.removeCallbacks(this.x);
    l();
    if (this.m != null)
      this.m.c();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((BoostProgressEngine)findViewById(2131755138));
    this.b = ((ImageView)findViewById(2131755142));
    this.c = ((ImageView)findViewById(2131755143));
    this.d = ((TextView)findViewById(2131755141));
    this.e = ((ShadowView)findViewById(2131755140));
    this.g = findViewById(2131755139);
    this.f = ((ImageView)findViewById(2131755137));
    this.f.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
    this.f.setOnClickListener(this);
    this.h = ((BoostPlusPlaneLayout)findViewById(2131755126));
    this.i = ((LinearLayout)findViewById(2131755092));
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = this.a.getCenter();
    this.a.setPivotX(this.a.getMeasuredWidth() / 2);
    this.a.setPivotY(this.a.getMeasuredHeight() / 2);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.boostplus.BoostPlusCleaningPanel
 * JD-Core Version:    0.6.2
 */