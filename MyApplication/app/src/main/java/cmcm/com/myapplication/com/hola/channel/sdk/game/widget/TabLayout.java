package cmcm.com.myapplication.com.hola.channel.sdk.game.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import es;
import ez;
import ii;
import java.util.ArrayList;
import java.util.Iterator;
import ss;
import st;
import su;
import sv;
import sw;
import sx;
import tc;
import th;
import ti;

public class TabLayout extends HorizontalScrollView
{
  public static final Interpolator a = new ii();
  private final ArrayList<su> b = new ArrayList();
  private su c;
  private final st d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private ColorStateList j;
  private float k;
  private float l;
  private final int m;
  private int n = 2147483647;
  private final int o;
  private final int p;
  private final int q;
  private int r;
  private int s;
  private int t;
  private ss u;
  private OnClickListener v;
  private ValueAnimator w;
  private ValueAnimator x;

  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.d = new st(this, paramContext);
    addView(this.d, -2, -1);
    Context localContext = null;
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ti.HolaTabLayout, paramInt, th.Hola_Widget_TabLayout);
      localContext = paramContext;
      this.d.b(paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabIndicatorHeight, 0));
      localContext = paramContext;
      this.d.a(paramContext.getColor(ti.HolaTabLayout_tabIndicatorColor, 0));
      localContext = paramContext;
      paramInt = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabPadding, 0);
      localContext = paramContext;
      this.h = paramInt;
      localContext = paramContext;
      this.g = paramInt;
      localContext = paramContext;
      this.f = paramInt;
      localContext = paramContext;
      this.e = paramInt;
      localContext = paramContext;
      this.e = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabPaddingStart, this.e);
      localContext = paramContext;
      this.f = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabPaddingTop, this.f);
      localContext = paramContext;
      this.g = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabPaddingEnd, this.g);
      localContext = paramContext;
      this.h = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabPaddingBottom, this.h);
      localContext = paramContext;
      this.j = paramContext.getColorStateList(ti.HolaTabLayout_tabTextColor);
      localContext = paramContext;
      paramInt = paramContext.getColor(ti.HolaTabLayout_tabSelectedTextColor, 0);
      localContext = paramContext;
      this.j = a(this.j.getDefaultColor(), paramInt);
      localContext = paramContext;
      this.k = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabTextSize, 0);
      localContext = paramContext;
      this.o = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabMinWidth, -1);
      localContext = paramContext;
      this.p = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabMaxWidth, -1);
      localContext = paramContext;
      this.m = paramContext.getResourceId(ti.HolaTabLayout_tabBackground, 0);
      localContext = paramContext;
      this.r = paramContext.getDimensionPixelSize(ti.HolaTabLayout_tabContentStart, 0);
      localContext = paramContext;
      this.t = paramContext.getInt(ti.HolaTabLayout_tabMode, 1);
      localContext = paramContext;
      this.s = paramContext.getInt(ti.HolaTabLayout_tabGravity, 0);
      localContext = paramContext;
      paramAttributeSet = getResources();
      localContext = paramContext;
      this.l = paramAttributeSet.getDimensionPixelSize(tc.hola_common_tab_text_size_2line);
      localContext = paramContext;
      this.q = paramAttributeSet.getDimensionPixelSize(tc.hola_common_tab_scrollable_min_width);
      if (paramContext != null)
        paramContext.recycle();
      e();
      return;
    }
    finally
    {
      if (localContext != null)
        localContext.recycle();
    }
    throw paramContext;
  }

  private int a(int paramInt, float paramFloat)
  {
    int i1 = 0;
    int i2 = 0;
    View localView2;
    View localView1;
    if (this.t == 0)
    {
      localView2 = this.d.getChildAt(paramInt);
      if (paramInt + 1 >= this.d.getChildCount())
        break label113;
      localView1 = this.d.getChildAt(paramInt + 1);
      if (localView2 == null)
        break label118;
    }
    label113: label118: for (paramInt = localView2.getWidth(); ; paramInt = 0)
    {
      i1 = i2;
      if (localView1 != null)
        i1 = localView1.getWidth();
      i2 = localView2.getLeft();
      i1 = (int)((i1 + paramInt) * paramFloat * 0.5F) + i2 + localView2.getWidth() / 2 - getWidth() / 2;
      return i1;
      localView1 = null;
      break;
    }
  }

  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }

  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }

  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.t == 1) && (this.s == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }

  private void a(su paramsu, int paramInt)
  {
    paramsu.a(paramInt);
    this.b.add(paramInt, paramsu);
    int i1 = this.b.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((su)this.b.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }

  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.d.getChildCount())
    {
      View localView = this.d.getChildAt(i1);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean)
        localView.requestLayout();
      i1 += 1;
    }
  }

  private void b(int paramInt)
  {
    sw localsw = c(paramInt);
    if (localsw != null)
      localsw.a();
  }

  private sw c(int paramInt)
  {
    return (sw)this.d.getChildAt(paramInt);
  }

  private sw c(su paramsu)
  {
    paramsu = new sw(this, getContext(), paramsu);
    paramsu.setFocusable(true);
    paramsu.setMinimumWidth(getTabMinWidth());
    if (this.v == null)
      this.v = new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((sw)paramAnonymousView).b().e();
        }
      };
    paramsu.setOnClickListener(this.v);
    return paramsu;
  }

  private void c()
  {
    int i1 = 0;
    int i2 = this.d.getChildCount();
    while (i1 < i2)
    {
      b(i1);
      i1 += 1;
    }
  }

  private void c(su paramsu, boolean paramBoolean)
  {
    paramsu = c(paramsu);
    this.d.addView(paramsu, d());
    if (paramBoolean)
      paramsu.setSelected(true);
  }

  private int d(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }

  private LinearLayout.LayoutParams d()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }

  private void e()
  {
    if (this.t == 0);
    for (int i1 = Math.max(0, this.r - this.e); ; i1 = 0)
    {
      ez.a(this.d, i1, 0, 0, 0);
      switch (this.t)
      {
      default:
      case 1:
      case 0:
      }
      while (true)
      {
        a(true);
        return;
        this.d.setGravity(1);
        continue;
        this.d.setGravity(8388611);
      }
    }
  }

  private void e(int paramInt)
  {
    if (paramInt == -1)
      return;
    if ((getWindowToken() == null) || (!ez.r(this)) || (this.d.a()))
    {
      a(paramInt, 0.0F, true);
      return;
    }
    int i1 = getScrollX();
    int i2 = a(paramInt, 0.0F);
    if (i1 != i2)
    {
      if (this.w == null)
      {
        this.w = new ValueAnimator();
        this.w.setInterpolator(a);
        this.w.setDuration(300L);
        this.w.addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
          }
        });
      }
      this.w.setIntValues(new int[] { i1, i2 });
      this.w.start();
    }
    this.d.a(paramInt, 300);
  }

  private int getDefaultHeight()
  {
    int i2 = this.b.size();
    int i1 = 0;
    if (i1 < i2)
    {
      su localsu = (su)this.b.get(i1);
      if ((localsu == null) || (localsu.b() == null) || (TextUtils.isEmpty(localsu.d())));
    }
    for (i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        return 72;
        i1 += 1;
        break;
      }
      return 48;
    }
  }

  private float getScrollPosition()
  {
    return this.d.b();
  }

  private int getTabMaxWidth()
  {
    return this.n;
  }

  private int getTabMinWidth()
  {
    if (this.o != -1)
      return this.o;
    if (this.t == 0)
      return this.q;
    return 0;
  }

  private void setSelectedTabView(int paramInt)
  {
    int i2 = this.d.getChildCount();
    if ((paramInt < i2) && (!this.d.getChildAt(paramInt).isSelected()))
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.d.getChildAt(i1);
        if (i1 == paramInt);
        for (boolean bool = true; ; bool = false)
        {
          localView.setSelected(bool);
          i1 += 1;
          break;
        }
      }
    }
  }

  public su a()
  {
    return new su(this);
  }

  public su a(int paramInt)
  {
    return (su)this.b.get(paramInt);
  }

  public void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if ((this.x != null) && (this.x.isRunning()));
    do
    {
      do
        return;
      while ((paramInt < 0) || (paramInt >= this.d.getChildCount()));
      this.d.a(paramInt, paramFloat);
      scrollTo(a(paramInt, paramFloat), 0);
    }
    while (!paramBoolean);
    setSelectedTabView(Math.round(paramInt + paramFloat));
  }

  public void a(su paramsu)
  {
    a(paramsu, this.b.isEmpty());
  }

  public void a(su paramsu, boolean paramBoolean)
  {
    if (su.a(paramsu) != this)
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    c(paramsu, paramBoolean);
    a(paramsu, this.b.size());
    if (paramBoolean)
      paramsu.e();
  }

  public void b()
  {
    this.d.removeAllViews();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ((su)localIterator.next()).a(-1);
      localIterator.remove();
    }
    this.c = null;
  }

  public void b(su paramsu)
  {
    b(paramsu, true);
  }

  public void b(su paramsu, boolean paramBoolean)
  {
    if (this.c == paramsu)
    {
      if (this.c != null)
      {
        if (this.u != null)
          this.u.c(this.c);
        e(paramsu.c());
      }
      return;
    }
    int i1;
    if (paramBoolean)
    {
      if (paramsu == null)
        break label157;
      i1 = paramsu.c();
      label57: if (i1 != -1)
        setSelectedTabView(i1);
      if (((this.c != null) && (this.c.c() != -1)) || (i1 == -1))
        break label162;
      a(i1, 0.0F, true);
    }
    while (true)
    {
      if ((this.c != null) && (this.u != null))
        this.u.b(this.c);
      this.c = paramsu;
      if ((this.c == null) || (this.u == null))
        break;
      this.u.a(this.c);
      return;
      label157: i1 = -1;
      break label57;
      label162: e(i1);
    }
  }

  public int getSelectedTabPosition()
  {
    if (this.c != null)
      return this.c.c();
    return -1;
  }

  public int getTabCount()
  {
    return this.b.size();
  }

  public int getTabGravity()
  {
    return this.s;
  }

  public int getTabMode()
  {
    return this.t;
  }

  public ColorStateList getTabTextColors()
  {
    return this.j;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = d(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label78: View localView;
    switch (MeasureSpec.getMode(paramInt2))
    {
    default:
      i1 = MeasureSpec.getSize(paramInt1);
      if (MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.p > 0)
        {
          i1 = this.p;
          this.n = i1;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == 1)
        {
          localView = getChildAt(0);
          switch (this.t)
          {
          default:
            paramInt1 = 0;
          case 0:
          case 1:
          }
        }
      }
      break;
    case -2147483648:
    case 0:
    }
    while (true)
    {
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
      return;
      paramInt2 = MeasureSpec.makeMeasureSpec(Math.min(i1, MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = MeasureSpec.makeMeasureSpec(i1, 1073741824);
      break;
      i1 -= d(56);
      break label78;
      if (localView.getMeasuredWidth() < getMeasuredWidth())
        paramInt1 = 1;
      else
        paramInt1 = 0;
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth());
    for (paramInt1 = i2; ; paramInt1 = 0)
      break;
  }

  public void setOnTabSelectedListener(ss paramss)
  {
    this.u = paramss;
  }

  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.d.a(paramInt);
  }

  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.d.b(paramInt);
  }

  public void setTabGravity(int paramInt)
  {
    if (this.s != paramInt)
    {
      this.s = paramInt;
      e();
    }
  }

  public void setTabMode(int paramInt)
  {
    if (paramInt != this.t)
    {
      this.t = paramInt;
      e();
    }
  }

  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.j != paramColorStateList)
    {
      this.j = paramColorStateList;
      c();
    }
  }

  public void setTabsFromPagerAdapter(es parames)
  {
    b();
    int i1 = 0;
    int i2 = parames.getCount();
    while (i1 < i2)
    {
      a(a().a(parames.getPageTitle(i1)));
      i1 += 1;
    }
  }

  public void setupWithViewPager(ViewPager paramViewPager)
  {
    es locales = paramViewPager.getAdapter();
    if (locales == null)
      throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
    setTabsFromPagerAdapter(locales);
    paramViewPager.addOnPageChangeListener(new sv(this));
    setOnTabSelectedListener(new sx(paramViewPager));
    if (locales.getCount() > 0)
    {
      int i1 = paramViewPager.getCurrentItem();
      if (getSelectedTabPosition() != i1)
        b(a(i1));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.widget.TabLayout
 * JD-Core Version:    0.6.2
 */