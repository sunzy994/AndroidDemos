package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class k extends TextView
{
  private float a;
  private float b = 8.0F;

  public k(Context paramContext)
  {
    super(paramContext);
    super.setSingleLine();
    super.setMaxLines(1);
    this.a = (getTextSize() / paramContext.getResources().getDisplayMetrics().density);
    setEllipsize(TextUtils.TruncateAt.END);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    int j = getMeasuredHeight();
    int k = getMeasuredWidth();
    for (float f = this.a; ; f -= 0.5F)
      if (f >= this.b)
      {
        super.setTextSize(f);
        measure(0, 0);
        if (getMeasuredWidth() > i);
      }
      else
      {
        if (getMeasuredWidth() > i)
          measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
        setMeasuredDimension(k, j);
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
  }

  public void setMaxLines(int paramInt)
  {
  }

  public void setMinTextSize(float paramFloat)
  {
    if (paramFloat <= this.a)
      this.b = paramFloat;
  }

  public void setSingleLine(boolean paramBoolean)
  {
  }

  public void setTextSize(float paramFloat)
  {
    this.a = paramFloat;
    super.setTextSize(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.k
 * JD-Core Version:    0.6.2
 */