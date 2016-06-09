package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public final class ScrollIndicator extends LinearLayout
{
  private static final String a = "Swipe." + ScrollIndicator.class.getSimpleName();
  private int b = -1;
  private ImageView[] c;
  private boolean d = false;
  private Drawable e;
  private Drawable f;

  public ScrollIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public ScrollIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ScrollIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(int paramInt)
  {
    a(paramInt, getResources().getDrawable(2130837658), getResources().getDrawable(2130837657));
  }

  public void a(int paramInt, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramInt == getChildCount())
      return;
    a(paramDrawable1, paramDrawable2);
    removeAllViews();
    paramDrawable2 = new LayoutParams(-2, -2);
    this.c = new ImageView[paramInt];
    int j = (int)(getContext().getResources().getDisplayMetrics().density * 2.0F + 0.5F);
    int i = 0;
    if (i < paramInt)
    {
      ImageView localImageView = new ImageView(getContext());
      this.c[i] = localImageView;
      if (this.d);
      for (paramDrawable1 = this.e; ; paramDrawable1 = this.f)
      {
        localImageView.setImageDrawable(paramDrawable1);
        localImageView.setPadding(j, 0, j, 0);
        addView(localImageView, paramDrawable2);
        i += 1;
        break;
      }
    }
    this.b = -1;
  }

  public void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    a(paramDrawable1, paramDrawable2, false);
  }

  public void a(Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    this.e = paramDrawable1;
    this.f = paramDrawable2;
    if (paramBoolean)
    {
      int i;
      label41: ImageView localImageView;
      if (this.d)
      {
        paramDrawable2 = this.f;
        paramDrawable1 = this.e;
        int j = this.c.length;
        i = 0;
        if (i >= j)
          return;
        localImageView = this.c[i];
        if (i != this.b)
          break label98;
      }
      label98: for (Drawable localDrawable = paramDrawable2; ; localDrawable = paramDrawable1)
      {
        localImageView.setImageDrawable(localDrawable);
        i += 1;
        break label41;
        paramDrawable1 = this.f;
        paramDrawable2 = this.e;
        break;
      }
    }
  }

  public void setReverse(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void setSelected(int paramInt)
  {
    if ((paramInt == this.b) || (paramInt < 0) || (this.c == null) || (paramInt >= this.c.length))
      return;
    if (-1 != this.b);
    try
    {
      ImageView localImageView = this.c[this.b];
      Drawable localDrawable;
      if (this.d)
        localDrawable = this.e;
      while (true)
      {
        localImageView.setImageDrawable(localDrawable);
        try
        {
          label64: localImageView = this.c[paramInt];
          if (this.d);
          for (localDrawable = this.f; ; localDrawable = this.e)
          {
            localImageView.setImageDrawable(localDrawable);
            label88: this.b = paramInt;
            return;
            localDrawable = this.f;
            break;
          }
        }
        catch (Throwable localThrowable1)
        {
          break label88;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label64;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.ScrollIndicator
 * JD-Core Version:    0.6.2
 */