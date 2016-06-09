package cmcm.com.myapplication.com.lazyswipe.features.allapps;

import acf;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import asq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListScrollDecoratorView extends LinearLayout
{
  private ListView a;
  private acf b;
  private final Map<Integer, View> c = new HashMap();
  private int d;

  public ListScrollDecoratorView(Context paramContext)
  {
    super(paramContext);
  }

  public ListScrollDecoratorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int a(float paramFloat)
  {
    if ((getMeasuredHeight() == 0) || (getChildCount() == 0))
      return -1;
    int j = Math.round((getChildCount() - 1) * paramFloat / getMeasuredHeight());
    int i;
    if (j < 0)
      i = 0;
    while (true)
    {
      return ((Integer)getChildAt(i).getTag()).intValue();
      i = j;
      if (j > getChildCount() - 1)
        i = getChildCount() - 1;
    }
  }

  private int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.d().length))
      return this.b.d()[paramInt];
    return -1;
  }

  private void d(int paramInt)
  {
    paramInt = c(paramInt);
    if (paramInt != -1)
      this.a.setSelectionFromTop(paramInt, -this.d);
  }

  public void a()
  {
    removeAllViews();
    String[] arrayOfString = this.b.b();
    List[] arrayOfList = this.b.c();
    int i = 0;
    if (i < arrayOfList.length)
    {
      Object localObject;
      if (!arrayOfList[i].isEmpty())
      {
        if (i != 0)
          break label137;
        localObject = new ImageView(getContext());
        ((ImageView)localObject).setImageResource(2130837507);
        ((ImageView)localObject).setScaleType(ScaleType.CENTER_INSIDE);
        ((ImageView)localObject).setTag(Integer.valueOf(i));
      }
      while (true)
      {
        LayoutParams localLayoutParams = new LayoutParams(-1, 0);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.gravity = 17;
        addView((View)localObject, localLayoutParams);
        this.c.put(Integer.valueOf(i), localObject);
        i += 1;
        break;
        label137: localObject = new TextView(getContext());
        ((TextView)localObject).setText(arrayOfString[i]);
        ((TextView)localObject).setTextColor(872415231);
        ((TextView)localObject).setTextSize(12.0F);
        ((TextView)localObject).setTag(Integer.valueOf(i));
        ((TextView)localObject).setGravity(17);
      }
    }
  }

  public void a(int paramInt)
  {
    View localView = (View)this.c.get(Integer.valueOf(paramInt));
    if ((localView instanceof TextView))
      ((TextView)localView).setTextColor(-1);
    while (!(localView instanceof ImageView))
      return;
    ((ImageView)localView).setColorFilter(null);
  }

  public void a(ListView paramListView, acf paramacf)
  {
    this.a = paramListView;
    this.b = paramacf;
  }

  public void b(int paramInt)
  {
    View localView = (View)this.c.get(Integer.valueOf(paramInt));
    if ((localView instanceof TextView))
      ((TextView)localView).setTextColor(872415231);
    while (!(localView instanceof ImageView))
      return;
    ((ImageView)localView).setColorFilter(872415231, PorterDuff.Mode.SRC_IN);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = asq.a(1.0F);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getY();
    switch (i)
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      d(a(f));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.allapps.ListScrollDecoratorView
 * JD-Core Version:    0.6.2
 */