package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hola.channel.sdk.game.widget.TabLayout;

public class sw extends LinearLayout
  implements OnLongClickListener
{
  private final su b;
  private TextView c;
  private ImageView d;
  private View e;
  private TextView f;
  private ImageView g;
  private int h = 2;

  public sw(TabLayout paramTabLayout, Context paramContext, su paramsu)
  {
    super(paramContext);
    this.b = paramsu;
    ez.a(this, TabLayout.a(paramTabLayout), TabLayout.b(paramTabLayout), TabLayout.c(paramTabLayout), TabLayout.d(paramTabLayout));
    setGravity(17);
    setOrientation(1);
    a();
  }

  private float a(Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }

  private void a(su paramsu, TextView paramTextView, ImageView paramImageView)
  {
    Drawable localDrawable = paramsu.b();
    CharSequence localCharSequence = paramsu.d();
    int i;
    if (paramImageView != null)
    {
      if (localDrawable != null)
      {
        paramImageView.setImageDrawable(localDrawable);
        paramImageView.setVisibility(0);
        setVisibility(0);
        paramImageView.setContentDescription(paramsu.f());
      }
    }
    else
    {
      if (TextUtils.isEmpty(localCharSequence))
        break label178;
      i = 1;
      label56: if (paramTextView != null)
      {
        if (i == 0)
          break label184;
        paramTextView.setText(localCharSequence);
        paramTextView.setContentDescription(paramsu.f());
        paramTextView.setVisibility(0);
        setVisibility(0);
      }
      label89: if (paramImageView != null)
      {
        paramTextView = (MarginLayoutParams)paramImageView.getLayoutParams();
        if ((i == 0) || (paramImageView.getVisibility() != 0))
          break label209;
      }
    }
    label178: label184: label209: for (int j = TabLayout.b(this.a, 8); ; j = 0)
    {
      if (j != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = j;
        paramImageView.requestLayout();
      }
      if ((i == 0) && (!TextUtils.isEmpty(paramsu.f())))
      {
        setOnLongClickListener(this);
        return;
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break;
        i = 0;
        break label56;
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
        break label89;
      }
      setOnLongClickListener(null);
      setLongClickable(false);
      return;
    }
  }

  public final void a()
  {
    su localsu = this.b;
    Object localObject = localsu.a();
    if (localObject != null)
    {
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null)
          ((ViewGroup)localViewParent).removeView((View)localObject);
        addView((View)localObject);
      }
      this.e = ((View)localObject);
      if (this.c != null)
        this.c.setVisibility(8);
      if (this.d != null)
      {
        this.d.setVisibility(8);
        this.d.setImageDrawable(null);
      }
      this.f = ((TextView)((View)localObject).findViewById(16908308));
      if (this.f != null)
        this.h = jc.a(this.f);
      this.g = ((ImageView)((View)localObject).findViewById(16908294));
      if (this.e != null)
        break label273;
      if (this.c == null)
      {
        localObject = (TextView)LayoutInflater.from(getContext()).inflate(tf.hola_game_tab_layout_tab_text, this, false);
        addView((View)localObject);
        this.c = ((TextView)localObject);
        this.h = jc.a(this.c);
      }
      this.c.setTextAppearance(getContext(), TabLayout.j(this.a));
      if (TabLayout.k(this.a) != null)
        this.c.setTextColor(TabLayout.k(this.a));
      a(localsu, this.c, this.d);
    }
    label273: 
    while ((this.f == null) && (this.g == null))
    {
      return;
      if (this.e != null)
      {
        removeView(this.e);
        this.e = null;
      }
      this.f = null;
      this.g = null;
      break;
    }
    a(localsu, this.f, this.g);
  }

  public su b()
  {
    return this.b;
  }

  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }

  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }

  public boolean onLongClick(View paramView)
  {
    paramView = new int[2];
    getLocationOnScreen(paramView);
    Object localObject = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    localObject = Toast.makeText((Context)localObject, this.b.f(), 0);
    ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
    ((Toast)localObject).show();
    return true;
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = MeasureSpec.getSize(paramInt1);
    int m = MeasureSpec.getMode(paramInt1);
    int n = TabLayout.e(this.a);
    int i = paramInt1;
    if (n > 0)
      if (m != 0)
      {
        i = paramInt1;
        if (j <= n);
      }
      else
      {
        i = MeasureSpec.makeMeasureSpec(TabLayout.f(this.a), m);
      }
    super.onMeasure(i, paramInt2);
    float f2;
    float f1;
    if (this.c != null)
    {
      f2 = TabLayout.g(this.a);
      j = this.h;
      if ((this.d == null) || (this.d.getVisibility() != 0))
        break label262;
      paramInt1 = 1;
      f1 = f2;
    }
    while (true)
    {
      f2 = this.c.getTextSize();
      m = this.c.getLineCount();
      j = jc.a(this.c);
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (TabLayout.i(this.a) == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              Layout localLayout = this.c.getLayout();
              if (localLayout != null)
              {
                j = k;
                if (a(localLayout, 0, f1) <= localLayout.getWidth());
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.c.setTextSize(0, f1);
          this.c.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
      return;
      label262: paramInt1 = j;
      f1 = f2;
      if (this.c != null)
      {
        paramInt1 = j;
        f1 = f2;
        if (this.c.getLineCount() > 1)
        {
          f1 = TabLayout.h(this.a);
          paramInt1 = j;
        }
      }
    }
  }

  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean);
    for (int i = 1; ; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean))
      {
        sendAccessibilityEvent(4);
        if (this.c != null)
          this.c.setSelected(paramBoolean);
        if (this.d != null)
          this.d.setSelected(paramBoolean);
      }
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sw
 * JD-Core Version:    0.6.2
 */