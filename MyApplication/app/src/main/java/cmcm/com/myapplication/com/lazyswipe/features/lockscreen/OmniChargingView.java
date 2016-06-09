package cmcm.com.myapplication.com.lazyswipe.features.lockscreen;

import aat;
import aba;
import abf;
import abg;
import abp;
import abq;
import abt;
import abu;
import alo;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import aou;
import asl;
import asq;
import asr;
import atw;
import awe;
import com.holaverse.charging.view.BubblesView;
import com.holaverse.charging.view.WaveView;
import com.lazyswipe.ui.FragmentContainer.ChargingSettingsActivity;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import uu;
import uw;
import uy;
import vd;
import vj;
import vs;
import vy;

public class OmniChargingView extends uu
  implements abp, uw, vd
{
  private static final String k = "Swipe." + OmniChargingView.class.getSimpleName();
  private static aba l;
  TextView j;
  private BubblesView m;
  private abu n;
  private PowerManager o;
  private abt p;
  private View q;
  private boolean r;
  private View s;
  private boolean t = true;
  private BroadcastReceiver u = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      OmniChargingView.this.j.setText(android.text.format.DateFormat.getMediumDateFormat(OmniChargingView.this.getContext()).format(new Date()));
    }
  };

  public OmniChargingView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OmniChargingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public OmniChargingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a = asq.a(400.0F);
    this.o = ((PowerManager)asq.r(paramContext, "power"));
    if (l == null)
      l = new aba(paramContext, 14);
    setOnMenuItemClickLisener(this);
  }

  private void g()
  {
    Iterator localIterator = alo.e().entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      String str2 = (String)localEntry.getKey();
      String str1 = str2;
      if (str2.length() <= 1)
        str1 = asl.g(getContext());
      a(asq.a(str1), ((Integer)localEntry.getValue()).intValue());
      this.g.getChildAt(this.g.getChildCount() - 1).setTag(str1);
      if (i != 0)
        break label145;
      i = 1;
    }
    label145: 
    while (true)
    {
      break;
      if (i != 0)
        setMessageLayerVisibility(0);
      while (this.g.getVisibility() != 0)
        return;
      setMessageLayerVisibility(4);
      return;
    }
  }

  public void a()
  {
    super.a();
    this.m.b();
  }

  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if (paramFloat > 0.5F);
    for (paramFloat = 1.0F; ; paramFloat = 2.0F * paramFloat)
    {
      this.c.getBackground().setAlpha((int)(paramFloat * 255.0F));
      return;
    }
  }

  public void a(int paramInt)
  {
    if (paramInt == 2131755185)
    {
      asq.d(getContext(), new Intent(getContext(), FragmentContainer.ChargingSettingsActivity.class));
      if ((getContext() instanceof Activity))
        ((Activity)getContext()).finish();
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (alo.d(getContext()))
    {
      g();
      return;
    }
    super.a(paramInt1, paramInt2);
  }

  public void a(abq paramabq)
  {
    l.a(System.currentTimeMillis() - aat.b());
    vy.b(getContext(), "B44");
    if ((getContext() instanceof Activity))
      ((Activity)getContext()).finish();
  }

  public void a(abq paramabq, boolean paramBoolean)
  {
    b(true);
  }

  public void a(abq paramabq, boolean paramBoolean, int paramInt, String paramString)
  {
    b(false);
  }

  public View b(abq paramabq)
  {
    return findViewById(2131755180);
  }

  public void b()
  {
    super.b();
    this.m.a();
  }

  public void b(final float paramFloat)
  {
    if (asq.n())
    {
      this.q.setScaleY(1.0F - (asq.a(20.0F) + paramFloat) / vj.f);
      return;
    }
    post(new Runnable()
    {
      public void run()
      {
        OmniChargingView.this.b(paramFloat);
      }
    });
  }

  public void c()
  {
  }

  public void c(abq paramabq)
  {
    paramabq = (abt)paramabq;
    if (!paramabq.v())
    {
      if (!this.o.isScreenOn())
        break label68;
      paramabq.n();
      if (this.p == null);
    }
    label68: for (this.p = null; ; this.p = paramabq)
    {
      if (this.t)
      {
        this.t = false;
        abf.a(getContext(), 14);
      }
      this.s.setVisibility(0);
      return;
    }
  }

  protected void e()
  {
    if ((!this.r) && (abf.a(getContext(), 14, false)) && (System.currentTimeMillis() > vs.a(getContext(), "never_show_charge_ad_till", -1L)))
    {
      l.a(this);
      l.a(true, false);
      this.r = true;
    }
  }

  public void f()
  {
    if (this.p != null)
      c(this.p);
    if (alo.d(getContext()))
    {
      this.g.removeAllViews();
      g();
    }
  }

  public abg getAdViewHolder()
  {
    return this.n;
  }

  public Drawable getUnLockLayerBg()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[] { 0, -872415232 });
    return new LayerDrawable(new Drawable[] { new GradientDrawable(Orientation.TOP_BOTTOM, new int[] { 8991197, -7786019, -7786019, -7786019, -7786019, -7786019 }), localGradientDrawable });
  }

  public boolean i_()
  {
    return true;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getContext().registerReceiver(this.u, new IntentFilter("android.intent.action.DATE_CHANGED"));
    this.u.onReceive(null, null);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.s)
    {
      this.h.setVisibility(8);
      this.b.setVisibility(8);
      vs.b(getContext(), "never_show_charge_ad_till", System.currentTimeMillis() + 86400000L);
    }
    while (true)
    {
      return;
      if (((paramView instanceof uy)) && ((paramView.getTag() instanceof String)))
        try
        {
          asq.j(getContext(), (String)paramView.getTag());
          vy.b(getContext(), "B43");
          if ((getContext() instanceof Activity))
          {
            ((Activity)getContext()).finish();
            return;
          }
        }
        catch (Throwable localThrowable)
        {
        }
    }
    super.onClick(paramView);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getContext().unregisterReceiver(this.u);
    try
    {
      l.a(null);
      l.e();
      label28: if ((aat.a()) && (abf.a(getContext(), 14, false)))
        l.a(true, false);
      this.n.a();
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.q = findViewById(2131755165);
    this.q.setPivotX(vj.e / 2);
    this.q.setPivotY(0.0F);
    this.q.setBackgroundDrawable(aou.a(new int[] { -6476291, -227334 }));
    this.f.a(2039034333, -7786019);
    this.f.setWaveLevelChangeListener(this);
    this.n = new abu(getContext().getApplicationContext());
    this.n.a(this);
    this.n.h.setBackgroundDrawable(new awe(atw.a(asq.a(2.0F), -13982987)));
    this.c.setBackgroundDrawable(getUnLockLayerBg());
    this.m = ((BubblesView)asr.a(this, 2131755177));
    this.j = ((TextView)asr.a(this, 2131755047));
    asr.a(this, 2131755180).setBackgroundResource(2130837518);
    this.s = asr.a(this, 2131755186);
    this.s.setOnClickListener(this);
  }

  protected void setMessageLayerVisibility(int paramInt)
  {
    super.setMessageLayerVisibility(paramInt);
    MarginLayoutParams localMarginLayoutParams;
    if ((this.d != null) && ((this.d.getLayoutParams() instanceof MarginLayoutParams)))
    {
      localMarginLayoutParams = (MarginLayoutParams)this.d.getLayoutParams();
      if (paramInt != 0)
        break label67;
    }
    label67: for (float f = 270.0F; ; f = 287.20001F)
    {
      paramInt = asq.a(f);
      if (paramInt != localMarginLayoutParams.topMargin)
      {
        localMarginLayoutParams.topMargin = paramInt;
        requestLayout();
      }
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.lockscreen.OmniChargingView
 * JD-Core Version:    0.6.2
 */