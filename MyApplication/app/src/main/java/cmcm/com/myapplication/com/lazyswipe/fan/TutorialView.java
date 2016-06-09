package cmcm.com.myapplication.com.lazyswipe.fan;

import alo;
import amk;
import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asp;
import asq;
import asr;
import asx;
import aty;
import com.lazyswipe.SwipeService;
import com.lazyswipe.ui.FullscreenTipActivity;
import com.lazyswipe.ui.InitialSettingsFragment;
import com.lazyswipe.ui.NotificationSettingsActivity;
import com.lazyswipe.ui.TutorialService;
import vj;
import vs;
import vv;
import vy;
import yb;

public class TutorialView extends LinearLayout
  implements OnClickListener
{
  private int a;
  private SharedPreferences b;
  private TextView c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private LinearLayout k;
  private LinearLayout l;
  private View m;
  private int n;
  private yb o;
  private String[] p;
  private boolean q;

  public TutorialView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TutorialView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TutorialView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public TutorialView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2131755522:
    case 2131755523:
    case 2131755524:
    case 2131755525:
    case 2131755526:
    case 2131755529:
    case 2131755531:
    case 2131755533:
    default:
      return;
    case 2131755521:
      c();
      return;
    case 2131755528:
    case 2131755530:
      e();
      return;
    case 2131755527:
    case 2131755534:
      f();
      return;
    case 2131755532:
    }
    d();
  }

  private void b()
  {
    this.o.removeView(this);
    amk.c(getContext(), false);
  }

  private void c()
  {
    this.o.removeView(this);
    amk.b(getContext(), false);
    vs.G(getContext());
    if (this.a == 108)
      vs.a(getContext()).edit().putLong("key_booster_start_counting", -1L).apply();
  }

  private void d()
  {
  }

  private void e()
  {
    switch (this.a)
    {
    case 100:
    case 103:
    case 105:
    case 106:
    case 108:
    default:
      return;
    case 107:
    case 109:
      b();
      return;
    case 98:
      vy.b(getContext(), "B12", 2);
      c();
      return;
    case 99:
    case 102:
      this.o.c(false);
      Context localContext = getContext().getApplicationContext();
      NotificationSettingsActivity.a(getContext(), this.p, TutorialService.a(localContext, -1), TutorialService.a(localContext, 0));
      return;
    case 101:
      vs.b(getContext(), -1L);
      b();
      return;
    case 104:
    }
    vs.d(getContext(), false);
    b();
  }

  private void f()
  {
    switch (this.a)
    {
    case 100:
    case 103:
    case 105:
    case 106:
    default:
    case 107:
    case 109:
      do
      {
        int i1;
        do
        {
          return;
          b();
          this.o.c(false);
          i1 = InitialSettingsFragment.b(getContext());
          if (3 == i1)
          {
            FullscreenTipActivity.b(getContext());
            return;
          }
        }
        while (2 != i1);
        FullscreenTipActivity.d(getContext());
        return;
        b();
        this.o.c(false);
      }
      while (3 != InitialSettingsFragment.b(getContext()));
      FullscreenTipActivity.c(getContext());
      return;
    case 99:
      c();
      return;
    case 104:
      if (SwipeService.f())
      {
        b();
        return;
      }
    case 98:
    case 101:
      vy.b(getContext(), "B12", 1);
      this.o.c(false);
      alo.e(getContext());
      FullscreenTipActivity.e(getContext());
      return;
    case 102:
      vs.g(getContext(), false);
      b();
      return;
    case 108:
    }
    this.o.c(false);
    vv.a().a("BoosterHolaGet");
    asq.g(getContext(), "com.hola.launcher&referrer=aq_tranid%3d0RWlnwbEN226OotMDF7l8IWSeoPaxvAeL%26pid%3dha_lazy_int%26c%3dlazyswipe_gp_booster");
    b();
  }

  private void g()
  {
    this.b.edit().putInt("key_tutorial_step", this.a).apply();
  }

  private void h()
  {
    if (this.a < 98)
      this.a = 98;
    if ((98 == this.a) && (alo.d(getContext())))
      this.a = 99;
    g();
  }

  private void i()
  {
    if (this.q)
    {
      ViewPropertyAnimator localViewPropertyAnimator = animate().alpha(0.0F);
      if (Build.VERSION.SDK_INT >= 16)
        localViewPropertyAnimator.withEndAction(new Runnable()
        {
          public void run()
          {
            TutorialView.this.a();
            TutorialView.this.animate().alpha(1.0F).start();
          }
        });
      while (true)
      {
        localViewPropertyAnimator.start();
        return;
        localViewPropertyAnimator.setListener(new asx()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            TutorialView.this.a();
            TutorialView.this.animate().alpha(1.0F).setListener(null).start();
          }
        });
      }
    }
    this.q = true;
    a();
    animate().alpha(1.0F).setStartDelay(400L).start();
  }

  private void j()
  {
    this.k.removeAllViewsInLayout();
    Object localObject = this.b.getString("key_notification_apps_selected", null);
    LayoutParams localLayoutParams;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.p = ((String)localObject).split(",");
      int i3 = Math.min(this.p.length, 4);
      localLayoutParams = new LayoutParams(0, this.n, 1.0F);
      int i1 = 0;
      int i2;
      while (true)
      {
        i2 = i1;
        if (i1 >= i3)
          break;
        localObject = new ImageView(getContext());
        this.k.addView((View)localObject, localLayoutParams);
        FanItem.g.a(getResources(), (View)localObject, this.p[i1]);
        i1 += 1;
      }
      while (i2 < 4)
      {
        localObject = new View(getContext());
        this.k.addView((View)localObject, localLayoutParams);
        i2 += 1;
      }
      if (this.p.length >= 5)
        break label186;
      localObject = new View(getContext());
    }
    while (true)
    {
      this.k.addView((View)localObject, localLayoutParams);
      return;
      label186: if (this.p.length > 5)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setText("...");
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setTextSize(0, getResources().getDimension(2131296406));
        ((TextView)localObject).setTextColor(getResources().getColor(2131689544));
      }
      else
      {
        localObject = new ImageView(getContext());
        FanItem.g.a(getResources(), (View)localObject, this.p[4]);
      }
    }
  }

  void a()
  {
    int i1 = 0;
    if (98 == this.a)
      if (this.m.getVisibility() != 0)
      {
        this.m.setVisibility(0);
        this.l.setVisibility(8);
      }
    while (true)
      switch (this.a)
      {
      case 100:
      case 103:
      case 105:
      case 106:
      default:
        asp.c("Swipe.TutorialView", "Unrecognized step: " + this.a);
        amk.c(getContext(), false);
        c();
        return;
        if (this.l.getVisibility() != 0)
        {
          this.l.setVisibility(0);
          this.m.setVisibility(8);
        }
        break;
      case 107:
      case 109:
      case 98:
      case 99:
      case 102:
      case 101:
      case 104:
      case 108:
      }
    this.h.setText(2131231148);
    this.i.setText(2131231149);
    this.e.setText(2131230900);
    this.f.setText(2131231150);
    this.k.setVisibility(8);
    return;
    this.h.setText(2131231045);
    this.i.setText(2131231030);
    this.e.setText(2131230900);
    this.f.setText(2131231150);
    this.k.setVisibility(8);
    return;
    this.h.setText(2131231159);
    this.i.setText(2131231155);
    j();
    return;
    this.h.setText(2131231158);
    this.i.setText(2131231156);
    this.j.setText(2131231157);
    this.j.setVisibility(0);
    this.e.setText(2131231143);
    this.f.setText(2131231147);
    j();
    return;
    amk.c(getContext(), false);
    this.h.setText(2131231158);
    this.i.setText(2131231156);
    this.j.setText(2131231157);
    this.j.setVisibility(0);
    this.e.setText(2131231143);
    this.f.setText(2131231146);
    j();
    return;
    amk.c(getContext(), false);
    this.h.setText(2131231159);
    this.i.setText(2131230898);
    this.e.setText(2131231096);
    this.f.setText(2131230753);
    this.k.setVisibility(8);
    return;
    amk.c(getContext(), false);
    this.h.setVisibility(8);
    this.e.setText(2131231096);
    if (SwipeService.f())
    {
      this.i.setText(getResources().getString(2131231154, new Object[] { getResources().getString(2131231069) }));
      this.f.setText(2131231145);
    }
    Object localObject2;
    while (true)
    {
      this.k.removeAllViewsInLayout();
      this.k.setGravity(vj.a | 0x10);
      localObject1 = new ImageView(getContext());
      FanItem.g.a(getResources(), (View)localObject1, vs.w(getContext()));
      localObject2 = new LayoutParams(this.n, this.n);
      this.k.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      return;
      this.i.setText(2131231153);
      this.f.setText(2131230753);
    }
    amk.c(getContext(), false);
    this.c.setText(2131231096);
    this.c.setVisibility(0);
    this.k.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setText(2131231264);
    this.h.setText(2131231266);
    this.i.setText(2131231265);
    Object localObject1 = getContext().getResources().getDrawable(2130837664);
    if (localObject1 != null)
    {
      this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      localObject2 = new Rect();
      String str = this.f.getText().toString();
      this.f.getPaint().getTextBounds(str, 0, str.length(), (Rect)localObject2);
      i2 = this.f.getPaddingTop();
      int i3 = this.f.getPaddingBottom();
      int i6 = this.f.getPaddingLeft();
      int i4 = this.f.getPaddingRight();
      int i7 = getResources().getDisplayMetrics().widthPixels;
      int i8 = getResources().getDimensionPixelSize(2131296404);
      int i9 = ((Drawable)localObject1).getIntrinsicWidth();
      int i5 = asq.a(6.0F);
      i6 = (i7 - (i8 << 1) - i9 - i5 - ((Rect)localObject2).width() - i6 - i4 >> 1) + i6;
      this.f.setCompoundDrawablePadding(i5);
      this.f.setGravity(16);
      if (i6 > 0)
        this.f.setPadding(i6, i2, i4, i3);
    }
    vv.a().a("BoosterHolaShow");
    localObject1 = vs.a(getContext());
    int i2 = ((SharedPreferences)localObject1).getInt("key_booster_times", 0);
    long l1 = System.currentTimeMillis();
    if (i2 > 100)
      l1 = -1L;
    while (true)
    {
      ((SharedPreferences)localObject1).edit().putLong("key_booster_start_counting", l1).putInt("key_booster_times", i1).apply();
      return;
      if (i2 > 10)
      {
        l1 = 604800000L + l1;
        i1 = 100;
      }
      else
      {
        l1 = 259200000L + l1;
        i1 = 10;
      }
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.o = ((yb)getParent());
    h();
    i();
  }

  public void onClick(View paramView)
  {
    a(paramView.getId());
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = vs.a(getContext());
    this.a = this.b.getInt("key_tutorial_step", 4);
    this.c = ((TextView)asr.a(this, 2131755521));
    this.d = asr.a(this, 2131755531);
    this.e = ((TextView)asr.a(this, 2131755530));
    this.f = ((TextView)asr.a(this, 2131755534));
    this.g = ((TextView)asr.a(this, 2131755532));
    this.h = ((TextView)asr.a(this, 2131755522));
    this.i = ((TextView)asr.a(this, 2131755523));
    this.j = ((TextView)asr.a(this, 2131755525));
    this.k = ((LinearLayout)asr.a(this, 2131755524));
    this.l = ((LinearLayout)asr.a(this, 2131755529));
    this.m = asr.a(this, 2131755526);
    asr.a(this, 2131755528).setOnClickListener(this);
    asr.a(this, 2131755527).setOnClickListener(this);
    this.n = getResources().getDimensionPixelSize(2131296335);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.q = false;
    setAlpha(0.0F);
    if (amk.b(getContext()))
      setBackgroundResource(2130837527);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.TutorialView
 * JD-Core Version:    0.6.2
 */