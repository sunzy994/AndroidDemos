package cmcm.com.myapplication.com.lazyswipe.features.leap.dice;

import abg;
import abq;
import aei;
import aeu;
import aew;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqs;
import asq;
import atw;
import vj;

public class DiceAdView extends LinearLayout
  implements OnClickListener
{
  private static final String a = "Swipe." + DiceAdView.class.getSimpleName();
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private View i;
  private FrameLayout j;
  private View k;
  private int l;
  private View m;
  private aew n;
  private aei o;

  public DiceAdView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DiceAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }

  public DiceAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private boolean c()
  {
    return a(null);
  }

  private void d()
  {
    if (this.l == 1);
    for (int i1 = 2130968644; ; i1 = 2130968643)
    {
      if (this.m != null)
        this.m = null;
      this.m = LayoutInflater.from(getContext()).inflate(i1, this, true);
      if (this.l == 1)
      {
        ViewGroup.LayoutParams localLayoutParams = this.m.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = -1;
          localLayoutParams.width = -1;
        }
      }
      e();
      if (this.o == null)
      {
        this.o = new aei();
        this.o.a(this.n);
      }
      this.o.a(this.m);
      return;
    }
  }

  private void e()
  {
    this.i = this.m.findViewById(2131755264);
    this.j = ((FrameLayout)this.m.findViewById(2131755263));
    this.b = ((ImageView)this.m.findViewById(2131755098));
    this.d = ((ImageView)this.m.findViewById(2131755118));
    this.e = ((ImageView)this.m.findViewById(2131755122));
    this.e.setOnClickListener(this);
    this.k = this.m.findViewById(2131755120);
    this.c = ((ImageView)this.m.findViewById(2131755119));
    this.f = ((TextView)this.m.findViewById(2131755097));
    this.g = ((TextView)this.m.findViewById(2131755102));
    this.h = ((TextView)this.m.findViewById(2131755096));
  }

  public void a()
  {
    if (!this.h.isClickable())
      this.h.setClickable(true);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
  }

  public void a(Bitmap paramBitmap, String paramString)
  {
    if (c())
      a(false);
    if (vj.g)
    {
      int i1 = aqs.ae();
      int i2 = this.o.h.getHeight();
      int i3 = asq.a(90.0F);
      this.o.c.setMaxHeight(i1 - i2 - i3);
    }
    this.h.setText(paramString);
    this.b.setImageBitmap(paramBitmap);
  }

  public void a(boolean paramBoolean)
  {
    ((aei)this.n.getAdView().j()).a(paramBoolean, paramBoolean);
    if (paramBoolean)
    {
      this.k.setVisibility(0);
      this.i.setVisibility(8);
      return;
    }
    this.k.setVisibility(8);
    this.i.setVisibility(0);
  }

  public boolean a(abq paramabq)
  {
    int i2 = 2;
    int i1 = i2;
    if (paramabq != null)
    {
      if (paramabq.j() != null)
        break label29;
      i1 = i2;
    }
    while (i1 == this.l)
    {
      return false;
      label29: i1 = i2;
      if (!atw.b(paramabq.j()))
        i1 = 1;
    }
    removeAllViews();
    this.l = i1;
    d();
    return true;
  }

  public boolean b()
  {
    return this.l != 1;
  }

  public abg getAdViewHolder()
  {
    return this.o;
  }

  public ViewGroup getCoverContainer()
  {
    return this.j;
  }

  public View getCoverView()
  {
    return this.b;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.e)
      this.n.d();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = 2;
    d();
  }

  public void setActionOnClickListener(OnClickListener paramOnClickListener)
  {
    this.h.setOnClickListener(paramOnClickListener);
  }

  public void setDiceView(aew paramaew)
  {
    this.n = paramaew;
    if (this.o != null)
      this.o.a(paramaew);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.dice.DiceAdView
 * JD-Core Version:    0.6.2
 */