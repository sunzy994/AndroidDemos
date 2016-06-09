package cmcm.com.myapplication.com.lazyswipe.features.leap.card;

import adp;
import adt;
import aed;
import aee;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import arl;
import aso;
import asr;
import vw;
import vy;
import yb;

public class NewsCard extends adp
  implements OnClickListener
{
  private static final String h = "Swipe." + NewsCard.class.getSimpleName();
  private ImageView i;
  private TextView j;
  private TextView k;
  private ViewStub l;
  private ViewStub m;
  private View n;
  private View o;
  private aee p;

  public NewsCard(Context paramContext)
  {
    super(paramContext);
  }

  public NewsCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NewsCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    if (!(paramObject instanceof aee));
    while (true)
    {
      return;
      try
      {
        this.p = ((aee)paramObject);
        label78: Resources localResources;
        if (!TextUtils.isEmpty(this.p.b))
        {
          if ((this.o != null) && (this.o.getVisibility() == 0))
            this.o.setVisibility(8);
          if (this.n == null)
          {
            this.n = this.l.inflate();
            this.i = ((ImageView)asr.a(this.n, 2131755098));
            paramObject = this.n;
            this.j = ((TextView)asr.a(paramObject, 2131755097));
            this.k = ((TextView)asr.a(paramObject, 2131755102));
            setTag(this.p.c);
            this.k.setText(this.p.a);
            paramObject = this.j;
            localResources = getResources();
            if (!this.p.h)
              break label339;
            i1 = 2131689475;
            label173: paramObject.setTextColor(localResources.getColor(i1));
            paramObject = this.k;
            localResources = getResources();
            if (!this.p.h)
              break label345;
          }
        }
        label339: label345: for (int i1 = 2131689475; ; i1 = 2131689473)
        {
          paramObject.setTextColor(localResources.getColor(i1));
          setTag(2131755008, getBitmapUrl());
          if (this.i == null)
            break;
          this.i.setImageDrawable(null);
          return;
          if (this.n.getVisibility() == 0)
            break label78;
          this.n.setVisibility(0);
          break label78;
          this.i = null;
          if ((this.n != null) && (this.n.getVisibility() == 0))
            this.n.setVisibility(8);
          if (this.o == null)
            this.o = this.m.inflate();
          while (true)
          {
            paramObject = this.o;
            break;
            if (this.o.getVisibility() != 0)
              this.o.setVisibility(0);
          }
          i1 = 2131689474;
          break label173;
        }
      }
      catch (Throwable paramObject)
      {
      }
    }
  }

  public void b()
  {
  }

  protected boolean g()
  {
    return true;
  }

  public int getBitmapReqHeight()
  {
    if (this.p != null)
      return this.p.e;
    return c;
  }

  public int getBitmapReqWidth()
  {
    if (this.p != null)
      return this.p.d;
    return b;
  }

  public String getBitmapUrl()
  {
    if (this.p != null)
      return this.p.b;
    return null;
  }

  public ImageView getBitmapView()
  {
    return this.i;
  }

  public adt getCardHolder()
  {
    return new adt(this);
  }

  public void onClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = this.f;
    int i3 = arrayOfInt[1];
    int i4 = this.g;
    paramView.getId();
    vy.b(getContext(), "B35");
    vw.a(getContext(), "B35");
    if (arl.h(getContext()))
    {
      if (!this.p.h)
      {
        int i5 = getResources().getColor(2131689475);
        this.j.setTextColor(i5);
        this.k.setTextColor(i5);
        aed.a(getContext()).a(getContext(), this.p);
      }
      paramView = yb.getInstance();
      if (paramView != null)
        paramView.a(getContext(), this.p.g, this.p.c, i1 + i2, i3 + i4);
      return;
    }
    aso.a(getContext(), 2131230908);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = ((ViewStub)asr.a(this, 2131755100));
    this.m = ((ViewStub)asr.a(this, 2131755101));
    setOnClickListener(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.leap.card.NewsCard
 * JD-Core Version:    0.6.2
 */