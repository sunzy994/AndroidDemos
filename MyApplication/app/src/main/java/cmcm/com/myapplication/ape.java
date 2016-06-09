package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ape extends LinearLayout
{
  private static final String a = "Swipe." + ape.class.getSimpleName();
  private View b;
  private View c;

  public ape(Context paramContext)
  {
    super(paramContext);
  }

  public static ape a(Context paramContext)
  {
    paramContext = new ape(paramContext);
    paramContext.setGravity(17);
    paramContext.setOrientation(1);
    paramContext.setClickable(true);
    return paramContext;
  }

  private void a(View paramView)
  {
    int j = getChildCount();
    if (j == 0)
    {
      addView(paramView);
      return;
    }
    int i = 0;
    while (true)
    {
      if (i >= j)
        break label46;
      if (paramView == getChildAt(i))
        break;
      i += 1;
    }
    label46: float f = getContext().getResources().getDisplayMetrics().density;
    i = (int)(36.0F * f + 0.5F);
    j = (int)(24.0F * f + 0.5F);
    int k = getContext().getResources().getColor(2131689561);
    f = f * 2.0F + 0.5F;
    auh localauh = auh.a(k, f);
    LayoutParams localLayoutParams = new LayoutParams(-1, (int)f);
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    localLayoutParams.leftMargin = j;
    localLayoutParams.rightMargin = j;
    View localView = new View(getContext());
    localView.setLayoutParams(localLayoutParams);
    localView.setBackgroundDrawable(localauh);
    addView(localView);
    addView(paramView);
  }

  private void b(View paramView)
  {
    int j = getChildCount();
    int i = 0;
    while (true)
    {
      if (i < j)
      {
        View localView = getChildAt(i);
        if (paramView != localView)
          break label54;
        removeView(localView);
        if (j >= 3)
        {
          if (i != 0)
            break label46;
          removeViewAt(0);
        }
      }
      return;
      label46: removeViewAt(i - 1);
      return;
      label54: i += 1;
    }
  }

  public void a()
  {
    if (this.c != null)
    {
      b(this.c);
      this.c = null;
    }
  }

  public void a(Context paramContext, View paramView)
  {
    if (getBackground() != null)
      return;
    paramContext = atw.b(paramView);
    if (paramContext != null)
    {
      atw.a(paramContext, 40, true);
      setBackgroundDrawable(new BitmapDrawable(getResources(), paramContext));
      return;
    }
    setBackgroundResource(2131689501);
  }

  public void b()
  {
    if (this.b != null)
    {
      b(this.b);
      this.b = null;
    }
  }

  public void b(Context paramContext)
  {
    if (this.c == null)
      this.c = LayoutInflater.from(paramContext).inflate(2130968638, null, false);
    a(this.c);
  }

  public void c(Context paramContext)
  {
    if (this.b == null)
      this.b = LayoutInflater.from(paramContext).inflate(2130968759, null, false);
    a(this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ape
 * JD-Core Version:    0.6.2
 */