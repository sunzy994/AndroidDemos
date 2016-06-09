package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lazyswipe.features.search.SearchPopupView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class agx extends agj<agy>
  implements OnClickListener
{
  private final atq g;
  private ImageView h;
  private final Random i = new Random(System.currentTimeMillis());
  private final List<View> j = new ArrayList();
  private final Handler k = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage.obj instanceof atv))
      {
        paramAnonymousMessage = (atv)paramAnonymousMessage.obj;
        if (atw.b(paramAnonymousMessage.e))
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(agx.this.getContext().getResources(), paramAnonymousMessage.e);
          if ((paramAnonymousMessage.f().getTag() instanceof agy))
            ((agy)paramAnonymousMessage.f().getTag()).a = localBitmapDrawable;
          ((ImageView)paramAnonymousMessage.f()).setImageDrawable(localBitmapDrawable);
        }
      }
    }
  };
  private final List<agy> l = new LinkedList();
  private final List<agy> m = new LinkedList();
  private final List<agy> n = new LinkedList();

  public agx(Context paramContext, String paramString, atq paramatq)
  {
    super(paramContext, paramString);
    this.g = paramatq;
  }

  private void g()
  {
    this.c = 0;
    this.l.clear();
    this.m.clear();
    this.n.clear();
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      label122: 
      while (localIterator.hasNext())
      {
        agy localagy = (agy)localIterator.next();
        if (localagy.e)
          this.l.add(localagy);
        while (true)
        {
          if (TextUtils.isEmpty(localagy.c))
            break label122;
          this.n.add(localagy);
          break;
          this.m.add(localagy);
        }
      }
    }
    super.f();
  }

  private View getRefershView()
  {
    if (this.h == null)
    {
      this.h = new ImageView(getContext());
      this.h.setImageResource(2130837611);
      this.h.setColorFilter(-13881554, PorterDuff.Mode.SRC_IN);
      int i1 = asq.a(5.0F);
      this.h.setPadding(i1, i1, i1, i1);
      this.h.setBackgroundDrawable(getNormalTransparentDrawable());
      this.h.setOnClickListener(this);
    }
    return this.h;
  }

  protected View a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    Object localObject2;
    int i2;
    int i1;
    label112: agy localagy;
    FrameLayout localFrameLayout;
    Object localObject1;
    Object localObject3;
    if (paramInt == 0)
    {
      localObject2 = new ArrayList();
      paramInt = 0;
      if ((paramInt >= 3) || (this.n.isEmpty()))
      {
        if (((List)localObject2).size() < 3)
          break label564;
        paramInt = asq.a(12.0F);
        i2 = asq.a(4.0F);
        i1 = asq.a(4.0F);
        localLinearLayout.setLayoutParams(new LayoutParams(-1, -2));
        localLinearLayout.setPadding(paramInt, i2, paramInt, i2);
        paramInt = 0;
        if (paramInt >= ((List)localObject2).size())
          break label562;
        localagy = (agy)((List)localObject2).get(paramInt);
        localFrameLayout = new FrameLayout(getContext());
        localObject1 = new LayoutParams(0, asq.a(102.7F));
        ((LayoutParams)localObject1).setMargins(i1, 0, i1, 0);
        ((LayoutParams)localObject1).weight = 1.0F;
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject3 = new ImageView(getContext());
        ((ImageView)localObject3).setScaleType(ScaleType.CENTER_CROP);
        if (localagy.a == null)
          break label484;
        localObject1 = localagy.a;
      }
    }
    label562: label564: label993: 
    while (true)
    {
      if (localObject1 != null)
        ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
      localFrameLayout.addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = new TextView(getContext());
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setEllipsize(TruncateAt.END);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setText(localagy.d());
      ((TextView)localObject1).setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[] { 0, 2130706432 }));
      i2 = asq.a(2.0F);
      ((TextView)localObject1).setPadding(i2, i2, i2, i2);
      localObject3 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 80;
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      this.l.remove(localagy);
      this.m.remove(localagy);
      localFrameLayout.setTag(localagy);
      localFrameLayout.setOnClickListener(this);
      localLinearLayout.addView(localFrameLayout);
      this.j.add(localFrameLayout);
      paramInt += 1;
      break label112;
      localObject1 = this.n;
      localObject1 = (agy)((List)localObject1).get(this.i.nextInt(((List)localObject1).size()));
      this.n.remove(localObject1);
      ((List)localObject2).add(localObject1);
      paramInt += 1;
      break;
      label484: if (!TextUtils.isEmpty(localagy.b))
      {
        localObject1 = new atv((View)localObject3, localagy.b, this.k, 1, ahe.a);
        localObject1 = (atv)this.g.a((atr)localObject1);
        if (localObject1 != null)
        {
          localObject1 = new BitmapDrawable(getContext().getResources(), ((atv)localObject1).e);
          localagy.a = ((Drawable)localObject1);
          continue;
          return localLinearLayout;
          paramInt = asq.a(12.0F);
          i2 = asq.a(4.0F);
          i1 = asq.a(4.0F);
          localLinearLayout.setLayoutParams(new LayoutParams(-1, -2));
          localLinearLayout.setPadding(paramInt, i2, paramInt, i2);
          paramInt = 0;
          if (paramInt < 2)
          {
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setPadding(asq.a(14.0F), 0, asq.a(14.0F), 0);
            ((TextView)localObject2).setTextSize(2, 14.0F);
            ((TextView)localObject2).setTextColor(-13881554);
            ((TextView)localObject2).setBackgroundColor(-1447449);
            ((TextView)localObject2).setGravity(16);
            ((TextView)localObject2).setEllipsize(TruncateAt.END);
            localObject1 = new LayoutParams(0, asq.a(36.700001F));
            ((LayoutParams)localObject1).setMargins(i1, 0, i1, 0);
            ((LayoutParams)localObject1).weight = 1.0F;
            ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            ((TextView)localObject2).setSingleLine();
            if ((!this.l.isEmpty()) || (!this.m.isEmpty()));
          }
          else
          {
            if (localLinearLayout.getChildCount() <= 0)
              break label993;
            return localLinearLayout;
          }
          if (paramInt % 2 == 0)
            if (!this.l.isEmpty())
            {
              localObject1 = this.l;
              localObject1 = (agy)((List)localObject1).get(this.i.nextInt(((List)localObject1).size()));
              ((TextView)localObject2).setText(((agy)localObject1).d());
              if (((agy)localObject1).d != 1)
                break label937;
              ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837665, 0);
            }
          while (true)
          {
            ((TextView)localObject2).setTag(localObject1);
            this.l.remove(localObject1);
            this.m.remove(localObject1);
            this.n.remove(localObject1);
            ((TextView)localObject2).setOnClickListener(this);
            localLinearLayout.addView((View)localObject2);
            this.j.add(localObject2);
            paramInt += 1;
            break;
            localObject1 = this.m;
            break label780;
            if (!this.m.isEmpty())
            {
              localObject1 = this.m;
              break label780;
            }
            localObject1 = this.l;
            break label780;
            if (((agy)localObject1).d == 2)
              ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837667, 0);
            else if (((agy)localObject1).d == 3)
              ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837668, 0);
            else
              ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
          return null;
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }

  protected List<agy> a(String paramString, agk paramagk)
  {
    return ahe.a(getContext(), true);
  }

  protected boolean c()
  {
    return false;
  }

  protected boolean d()
  {
    return false;
  }

  protected boolean e()
  {
    return false;
  }

  protected void f()
  {
    Object localObject;
    int i2;
    if (this.j.size() > 0)
    {
      localObject = this.j.iterator();
      int i1 = 0;
      i2 = i1;
      if (!((Iterator)localObject).hasNext())
        break label123;
      View localView = (View)((Iterator)localObject).next();
      if ((localView.getParent() == null) || (localView.getParent().getParent() == null))
        break label157;
      localView.clearAnimation();
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(300L);
      localAlphaAnimation.setStartOffset(()(300.0F * this.i.nextFloat()));
      localAlphaAnimation.setFillAfter(true);
      localView.startAnimation(localAlphaAnimation);
      i1 = 1;
    }
    label157: 
    while (true)
    {
      break;
      i2 = 0;
      label123: localObject = new Runnable()
      {
        public void run()
        {
          agx.a(agx.this).clear();
          agx.b(agx.this);
          if (agx.a(agx.this).size() > 0)
          {
            Iterator localIterator = agx.a(agx.this).iterator();
            while (localIterator.hasNext())
            {
              View localView = (View)localIterator.next();
              if ((localView.getParent() != null) && (localView.getParent().getParent() != null))
              {
                AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                localAlphaAnimation.setDuration(300L);
                localAlphaAnimation.setStartOffset(()(300.0F * agx.c(agx.this).nextFloat()));
                localView.startAnimation(localAlphaAnimation);
              }
            }
          }
        }
      };
      if (i2 == 0)
      {
        ((Runnable)localObject).run();
        return;
      }
      this.k.postDelayed((Runnable)localObject, 600L);
      return;
    }
  }

  protected String getBottomText()
  {
    agu localagu = ahe.e(getContext().getApplicationContext());
    if ((localagu != null) && (!TextUtils.isEmpty(localagu.b())) && (localagu.b().toLowerCase().contains("mysearch")))
      return "Ads by Mysearch";
    return null;
  }

  protected View getContentBottomEdgeView()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LayoutParams(-1, asq.a(6.0F)));
    return localLinearLayout;
  }

  protected View getContentTopEdgeView()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LayoutParams(-1, asq.a(6.0F)));
    return localLinearLayout;
  }

  protected int getInitPageSize()
  {
    return 4;
  }

  protected int getNextPageSize()
  {
    return 2;
  }

  protected View getTitleActionView()
  {
    return getRefershView();
  }

  protected int getTotalItemCount()
  {
    if ((this.b == null) || (this.b.size() == 0))
      return 0;
    return 4;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
    {
      this.h.clearAnimation();
      paramView = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramView.setDuration(500L);
      paramView.setInterpolator(new AccelerateDecelerateInterpolator());
      this.h.startAnimation(paramView);
      f();
    }
    do
    {
      return;
      paramView = (agy)paramView.getTag();
    }
    while ((paramView == null) || (this.a == null));
    this.a.b(paramView.e());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agx
 * JD-Core Version:    0.6.2
 */