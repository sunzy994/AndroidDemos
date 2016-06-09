package cmcm.com.myapplication.com.lazyswipe.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import atw;

public class OverflowImageView extends ImageView
{
  private Drawable a;

  public OverflowImageView(Context paramContext)
  {
    super(paramContext);
  }

  public OverflowImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public OverflowImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public OverflowImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != null)
    {
      int i = this.a.getIntrinsicWidth();
      int j = this.a.getIntrinsicHeight();
      int k = getMeasuredWidth();
      float f = getContext().getResources().getDisplayMetrics().density;
      k = (int)((k >> 1) + 8.0F * f);
      int m = (int)(getPaddingTop() - f * 2.0F);
      this.a.setBounds(k, m, i + k, j + m);
      this.a.draw(paramCanvas);
    }
  }

  public void setUnread(boolean paramBoolean)
  {
    if (paramBoolean)
      if (this.a == null)
      {
        this.a = atw.a(Color.parseColor("#ff5c26"), (int)(4.666667F * getResources().getDisplayMetrics().density));
        invalidate();
      }
    while (this.a == null)
      return;
    this.a = null;
    invalidate();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.OverflowImageView
 * JD-Core Version:    0.6.2
 */