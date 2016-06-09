package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class j extends TextView
{
  private int a;
  private float b;
  private float c = 8.0F;

  public j(Context paramContext, int paramInt)
  {
    super(paramContext);
    setMaxLines(paramInt);
    setEllipsize(TextUtils.TruncateAt.END);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setMaxLines(this.a + 1);
    super.setTextSize(this.b);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 0));
    if (getMeasuredHeight() > j)
    {
      float f1 = this.b;
      do
      {
        float f2;
        do
        {
          if (f1 <= this.c)
            break;
          f2 = f1 - 0.5F;
          super.setTextSize(f2);
          measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
          f1 = f2;
        }
        while (getMeasuredHeight() > j);
        f1 = f2;
      }
      while (getLineCount() > this.a);
    }
    super.setMaxLines(this.a);
    setMeasuredDimension(i, j);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setMaxLines(int paramInt)
  {
    this.a = paramInt;
    super.setMaxLines(paramInt);
  }

  public void setMinTextSize(float paramFloat)
  {
    this.c = paramFloat;
  }

  public void setTextSize(float paramFloat)
  {
    this.b = paramFloat;
    super.setTextSize(paramFloat);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.j
 * JD-Core Version:    0.6.2
 */