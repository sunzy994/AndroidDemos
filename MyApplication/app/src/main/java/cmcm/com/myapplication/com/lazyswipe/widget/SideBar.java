package cmcm.com.myapplication.com.lazyswipe.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import asq;
import atp;
import awa;

public class SideBar extends View
{
  private static final String[] a = { "*", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private int b = -1;
  private final Paint c = new Paint();
  private int d = -1;
  private int e = -1;
  private final ColorFilter f = new PorterDuffColorFilter(1677721600, PorterDuff.Mode.SRC_IN);
  private final ColorFilter g = new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
  private awa h;

  public SideBar(Context paramContext)
  {
    super(paramContext);
  }

  public SideBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SideBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int j = this.b;
    paramMotionEvent = this.h;
    int k = (int)(f1 / getHeight() * a.length);
    switch (i)
    {
    default:
      setBackgroundResource(2130837796);
      if ((j != k) && (k >= 0) && (k < a.length))
      {
        if (paramMotionEvent != null)
          paramMotionEvent.a(a[k]);
        this.b = k;
        this.d = (k - 1);
        this.e = (k + 1);
        invalidate();
      }
      break;
    case 1:
    }
    while (true)
    {
      return true;
      setBackgroundDrawable(new ColorDrawable(0));
      this.b = -1;
      this.d = -1;
      this.e = -1;
      invalidate();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    int k = i / a.length;
    i = 0;
    if (i < a.length)
    {
      this.c.setTypeface(Typeface.DEFAULT_BOLD);
      this.c.setAntiAlias(true);
      this.c.setTextSize(asq.a(10.0F));
      label119: Object localObject;
      if ((i == this.b) || (i == this.d) || (i == this.e))
      {
        this.c.setColor(-16777216);
        this.c.setColorFilter(this.g);
        this.c.setFakeBoldText(true);
        localObject = a[i];
        if (!"*".equals(localObject))
          break label227;
        localObject = atp.e(getContext());
        int m = (j - ((Bitmap)localObject).getWidth()) / 2;
        int n = (k - ((Bitmap)localObject).getHeight()) / 2;
        int i1 = asq.a(2.5F);
        paramCanvas.drawBitmap((Bitmap)localObject, m, n + i1, this.c);
      }
      while (true)
      {
        this.c.reset();
        i += 1;
        break;
        this.c.setColor(1677721600);
        this.c.setColorFilter(this.f);
        break label119;
        label227: paramCanvas.drawText((String)localObject, j / 2 - this.c.measureText(a[i]) / 2.0F, k * i + k, this.c);
      }
    }
  }

  public void setOnTouchingLetterChangedListener(awa paramawa)
  {
    this.h = paramawa;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.SideBar
 * JD-Core Version:    0.6.2
 */