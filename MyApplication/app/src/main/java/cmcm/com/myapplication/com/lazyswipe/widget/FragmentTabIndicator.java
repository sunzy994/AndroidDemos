package cmcm.com.myapplication.com.lazyswipe.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asq;
import avi;
import java.util.Iterator;
import java.util.List;
import vj;

public class FragmentTabIndicator extends RelativeLayout
{
  private LinearLayout a;
  private View b;
  private View c;
  private int d;
  private int e = -1;
  private int f = -11250604;
  private int g;
  private int h = 0;
  private boolean i;
  private boolean j;

  public FragmentTabIndicator(Context paramContext)
  {
    super(paramContext);
  }

  public FragmentTabIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(float paramFloat)
  {
    ObjectAnimator.ofFloat(this.b, "translationX", new float[] { (this.b.getLayoutParams().width + this.d * 2) * paramFloat + this.d }).setDuration(0L).start();
  }

  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.getChildCount()));
    while (paramInt == this.e)
      return;
    if (this.e >= 0)
    {
      ((TextView)this.a.getChildAt(this.e)).setTextColor(this.f);
      ((TextView)this.a.getChildAt(this.e)).setSelected(false);
    }
    ((TextView)this.a.getChildAt(paramInt)).setTextColor(this.g);
    ((TextView)this.a.getChildAt(paramInt)).setSelected(true);
    this.e = paramInt;
  }

  public void a(int paramInt, float paramFloat)
  {
    if (this.j)
    {
      if ((paramInt >= this.a.getChildCount()) || (paramInt < 0))
      {
        a(paramInt + paramFloat);
        return;
      }
      View localView = this.a.getChildAt(paramInt);
      ObjectAnimator.ofFloat(this.b, "translationX", new float[] { localView.getLeft() + (localView.getRight() - localView.getLeft()) * paramFloat }).setDuration(0L).start();
      if (paramInt + 1 >= this.a.getChildCount());
      for (paramInt = localView.getMeasuredWidth(); ; paramInt = this.a.getChildAt(paramInt + 1).getMeasuredWidth())
      {
        float f1 = localView.getMeasuredWidth() * 1.0F / this.a.getChildAt(0).getMeasuredWidth();
        float f2 = paramInt * 1.0F / this.a.getChildAt(0).getMeasuredWidth();
        ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { (f2 - f1) * paramFloat + f1 }).setDuration(0L).start();
        return;
      }
    }
    a(paramInt + paramFloat);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.i = true;
    this.g = paramInt1;
    this.f = paramInt2;
    paramInt1 = 0;
    if (paramInt1 < this.a.getChildCount())
    {
      TextView localTextView = (TextView)this.a.getChildAt(paramInt1);
      if (paramInt1 == this.e)
        localTextView.setTextColor(this.g);
      while (true)
      {
        paramInt1 += 1;
        break;
        localTextView.setTextColor(this.f);
      }
    }
  }

  public void a(final avi paramavi, List<CharSequence> paramList)
  {
    this.a.removeAllViews();
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    paramavi = new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = FragmentTabIndicator.a(FragmentTabIndicator.this).indexOfChild(paramAnonymousView);
        paramavi.a(i);
      }
    };
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (CharSequence)localIterator.next();
      TextView localTextView = (TextView)localLayoutInflater.inflate(2130968646, this.a, false);
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(this.f);
      if (this.h > 0)
        localTextView.setTextSize(this.h);
      localTextView.setOnClickListener(paramavi);
      if (this.j)
      {
        localObject = new LinearLayout.LayoutParams(-2, -1);
        localTextView.setPadding(asq.a(10.0F), 0, asq.a(10.0F), 0);
        localTextView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.a.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        localObject = new LinearLayout.LayoutParams(0, -1, 1.0F);
        this.a.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      }
    }
    if (this.j)
    {
      this.d = asq.a(10.0F);
      this.b.getLayoutParams().width = this.a.getChildAt(0).getMeasuredWidth();
      this.a.setPadding(this.d, 0, this.d, 0);
      this.b.setPivotX(0.0F);
    }
    while (true)
    {
      a(0);
      a(0, 0.0F);
      return;
      int k = vj.e / Math.max(3, paramList.size());
      this.d = ((vj.e / paramList.size() - k) / 2);
      this.b.getLayoutParams().width = k;
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.g = getContext().getResources().getColor(2131689548);
    this.a = ((LinearLayout)findViewById(2131755058));
    this.c = findViewById(2131755059);
    this.b = findViewById(2131755060);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.e != -1)
      a(this.e, 0.0F);
  }

  public void setSelectedColor(int paramInt)
  {
    if (this.j)
      setBackgroundColor(paramInt);
    do
    {
      do
      {
        return;
        findViewById(2131755060).setBackgroundColor(paramInt);
      }
      while (this.i);
      this.g = paramInt;
    }
    while ((this.e < 0) || (this.e >= this.a.getChildCount()));
    ((TextView)this.a.getChildAt(this.e)).setTextColor(this.g);
  }

  public void setTextSize(int paramInt)
  {
    this.h = paramInt;
    int k = 0;
    while (k < this.a.getChildCount())
    {
      ((TextView)this.a.getChildAt(k)).setTextSize(paramInt);
      k += 1;
    }
  }

  public void setUnSelectedColor(int paramInt)
  {
    if (this.j);
    while (true)
    {
      return;
      this.f = paramInt;
      paramInt = 0;
      while (paramInt < this.a.getChildCount())
      {
        if (paramInt != this.e)
          ((TextView)this.a.getChildAt(paramInt)).setTextColor(this.f);
        paramInt += 1;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.FragmentTabIndicator
 * JD-Core Version:    0.6.2
 */