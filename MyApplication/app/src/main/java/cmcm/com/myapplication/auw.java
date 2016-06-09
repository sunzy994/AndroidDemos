package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public abstract class auw extends View
{
  private CharSequence a;
  private int b;
  private Layout c;
  private final TextPaint d = new TextPaint(1);
  private int e = 1073741823;
  private int f = 2147483647;
  private int g;
  private int h;
  private boolean i = true;
  private boolean j = true;
  private BoringLayout k;
  public Drawable l;
  public float m = 1.0F;
  public TextUtils.TruncateAt n = TextUtils.TruncateAt.END;
  private Metrics o;
  private boolean p;
  private Rect q;

  public auw(Context paramContext)
  {
    this(paramContext, null);
  }

  public auw(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public auw(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, vl.IconView, paramInt, 0);
    this.b = paramContext.getDimensionPixelSize(0, 0);
    paramInt = paramContext.getDimensionPixelSize(1, -1);
    if (paramInt > 0)
      this.d.setTextSize(paramInt);
    paramInt = paramContext.getColor(2, -1);
    this.d.setColor(paramInt);
    paramContext.recycle();
  }

  private void a()
  {
    a(true);
  }

  private void a(boolean paramBoolean)
  {
    if ((this.c instanceof BoringLayout))
      this.k = ((BoringLayout)this.c);
    this.h = 0;
    if (this.a == null)
    {
      this.c = null;
      if (paramBoolean)
        requestLayout();
      invalidate();
      return;
    }
    int i1 = getTextAreaWidth();
    Object localObject = BoringLayout.isBoring(getMeasuredText(), this.d, this.o);
    if (localObject != null)
    {
      this.o = ((Metrics)localObject);
      if (((Metrics)localObject).width <= i1)
        if (this.k == null)
          localObject = BoringLayout.make(this.a, this.d, i1, Alignment.ALIGN_CENTER, 1.0F, 0.0F, (Metrics)localObject, true);
    }
    while (true)
    {
      this.c = ((Layout)localObject);
      break;
      localObject = this.k.replaceOrMake(this.a, this.d, i1, Alignment.ALIGN_CENTER, 1.0F, 0.0F, (Metrics)localObject, true);
      continue;
      if (this.i)
      {
        if (this.n == null)
        {
          if (this.k == null);
          for (localObject = BoringLayout.make(this.a, this.d, i1, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, (Metrics)localObject, true); ; localObject = this.k.replaceOrMake(this.a, this.d, i1, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, (Metrics)localObject, true))
            break;
        }
        if (this.k == null);
        for (localObject = BoringLayout.make(this.a, this.d, i1, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, (Metrics)localObject, true, this.n, i1); ; localObject = this.k.replaceOrMake(this.a, this.d, i1, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, (Metrics)localObject, true, this.n, i1))
          break;
      }
      if (this.n == null)
      {
        localObject = new StaticLayout(this.a, this.d, i1, Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
      }
      else
      {
        localObject = new StaticLayout(this.a, 0, this.a.length(), this.d, i1, Alignment.ALIGN_CENTER, 1.0F, 0.0F, true, this.n, i1);
        continue;
        int i2;
        if (this.i)
        {
          i2 = (int)Math.max(i1, Layout.getDesiredWidth(this.a, this.d));
          label422: if (this.n != null)
            break label518;
          localObject = new StaticLayout(this.a, this.d, i2, Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
        }
        try
        {
          while (true)
          {
            i3 = (int)Math.floor(((Layout)localObject).getLineLeft(0));
            double d1 = Math.ceil(((Layout)localObject).getLineRight(0));
            i2 = (int)d1;
            if (i2 - i3 >= i1)
              break label574;
            this.h = ((i2 + i3) / 2 - i1 / 2);
            break;
            i2 = i1;
            break label422;
            label518: localObject = new StaticLayout(this.a, 0, this.a.length(), this.d, i2, Alignment.ALIGN_CENTER, 1.0F, 0.0F, true, this.n, i1);
          }
        }
        catch (Throwable localThrowable)
        {
          int i3;
          while (true)
          {
            i3 = 0;
            i2 = i1;
          }
          label574: if (((Layout)localObject).getParagraphDirection(0) < 0)
            this.h = (i2 - i1);
          else
            this.h = i3;
        }
      }
    }
  }

  private Rect getRestrictHitRect()
  {
    if (this.q == null)
      this.q = new Rect();
    return this.q;
  }

  private int getTextAreaWidth()
  {
    int i2 = Math.min(this.f, this.e) - this.g * 2;
    int i1 = i2;
    if (i2 < 0)
      i1 = 0;
    return i1;
  }

  public void a(int paramInt, float paramFloat)
  {
    a(paramInt, paramFloat, false);
  }

  public void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    if (paramFloat != this.d.getTextSize())
    {
      this.d.setTextSize(paramFloat);
      if (paramBoolean)
        requestLayout();
      invalidate();
    }
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((q()) && ((paramMotionEvent.getAction() & 0xFF) == 0))
    {
      int i1 = (int)paramMotionEvent.getX();
      int i2 = (int)paramMotionEvent.getY();
      if (!getRestrictHitRect().contains(i1, i2))
        return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public int getBaseline()
  {
    if (this.c == null)
      return super.getBaseline();
    int i2 = getPaddingTop();
    if (this.l == null);
    for (int i1 = 0; ; i1 = getIconSize() + this.b)
      return i1 + i2 + this.c.getLineBaseline(0);
  }

  protected final float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }

  public int getCompoundPaddingLeft()
  {
    return getPaddingLeft();
  }

  public int getCompoundPaddingRight()
  {
    return getPaddingRight();
  }

  public void getHitRect(Rect paramRect)
  {
    super.getHitRect(paramRect);
    if (q())
    {
      Rect localRect = getRestrictHitRect();
      paramRect.inset(localRect.left, 0);
      paramRect.bottom -= getHeight() - localRect.bottom;
    }
  }

  public final int getHorizontalFadingEdgeLength()
  {
    return 0;
  }

  public Drawable getIcon()
  {
    return this.l;
  }

  public int getIconSize()
  {
    return getResources().getDimensionPixelSize(2131296335);
  }

  protected final float getLeftFadingEdgeStrength()
  {
    return 0.0F;
  }

  public CharSequence getMeasuredText()
  {
    return this.a;
  }

  protected final float getRightFadingEdgeStrength()
  {
    return 0.0F;
  }

  public CharSequence getText()
  {
    return this.a;
  }

  protected final float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }

  public final int getVerticalFadingEdgeLength()
  {
    return 0;
  }

  public final boolean isHorizontalFadingEdgeEnabled()
  {
    return false;
  }

  public final boolean isVerticalFadingEdgeEnabled()
  {
    return false;
  }

  public void onDraw(Canvas paramCanvas)
  {
    int i2 = getWidth();
    int i1 = getIconSize();
    int i3;
    int i4;
    if (this.l != null)
    {
      i3 = (i2 - i1) / 2;
      i4 = getPaddingTop();
      paramCanvas.translate(i3, i4);
      paramCanvas.save();
      this.l.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.translate(-i3, -i4);
    }
    if ((this.j) && (this.c != null))
    {
      i3 = getTextAreaWidth();
      i4 = getPaddingTop();
      if (this.l != null)
        break label207;
      i1 = 0;
      i4 += i1;
      if (!this.i)
        break label217;
      i1 = 1;
      label119: if (i1 > this.c.getLineCount())
        break label222;
    }
    label207: label217: label222: for (i1 = this.c.getLineTop(i1) + i4; ; i1 = this.c.getHeight() + i4)
    {
      int i5 = (i2 - i3) / 2;
      i2 = (int)((i2 + i3) / 2.0F + 0.5F);
      paramCanvas.save();
      paramCanvas.clipRect(i5, i4, i2, i1);
      paramCanvas.translate(i5 - this.h, i4);
      this.c.draw(paramCanvas);
      paramCanvas.restore();
      return;
      i1 += this.b;
      break;
      i1 = 2;
      break label119;
    }
  }

  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = MeasureSpec.getMode(paramInt1);
    int i3 = MeasureSpec.getMode(paramInt2);
    if (i1 == 1073741824);
    float f1;
    label113: float f2;
    for (i1 = MeasureSpec.getSize(paramInt1); ; i1 = resolveSize(Math.max(this.e, i1) + (getPaddingLeft() + getPaddingRight()), paramInt1))
    {
      paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
      if (paramInt1 != this.f)
      {
        this.f = paramInt1;
        if (this.c != null)
          a(false);
      }
      if (i3 != 1073741824)
        break;
      paramInt1 = MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(i1, paramInt1);
      if (q())
      {
        Rect localRect = getRestrictHitRect();
        if (this.c != null)
          break label411;
        f1 = getTextAreaWidth();
        if (this.c != null)
          break label430;
        f2 = 0.0F;
        label123: f1 = Math.max(f1 - f2 * 2.0F, getContext().getResources().getDisplayMetrics().density * 60.0F);
        paramInt2 = (int)Math.max((i1 - Math.max(getIconSize(), f1)) / 2.0F, 0.0F);
        localRect.set(paramInt2, 0, i1 - paramInt2, paramInt1);
        f2 = paramInt1 - getIconSize() - getPaddingTop() - this.b;
        if (this.c == null)
          break label464;
        if (!this.i)
          break label447;
        paramInt1 = i2;
        label219: if (paramInt1 > this.c.getLineCount())
          break label452;
        f1 = this.c.getLineTop(paramInt1);
        label240: localRect.bottom = ((int)(localRect.bottom - Math.max(0.0F, f2 - f1)));
      }
      return;
      i1 = getIconSize();
    }
    if (this.l == null)
    {
      paramInt1 = 0;
      label305: i3 = getPaddingTop();
      i3 = getPaddingBottom() + (paramInt1 + i3);
      if (this.c == null)
        break label469;
      if (!this.i)
        break label383;
      paramInt1 = 1;
      label338: if (paramInt1 > this.c.getLineCount())
        break label388;
      paramInt1 = this.c.getLineTop(paramInt1) + i3;
    }
    while (true)
    {
      paramInt1 = resolveSize(paramInt1, paramInt2);
      break;
      paramInt1 = getIconSize() + this.b;
      break label305;
      label383: paramInt1 = 2;
      break label338;
      label388: paramInt1 = this.c.getHeight() + this.d.getFontMetricsInt(null) + i3;
      continue;
      label411: f1 = Math.min(this.c.getWidth(), getTextAreaWidth());
      break label113;
      label430: f2 = Math.max(this.c.getLineLeft(0), 0.0F);
      break label123;
      label447: paramInt1 = 2;
      break label219;
      label452: f1 = this.c.getHeight();
      break label240;
      label464: f1 = 0.0F;
      break label240;
      label469: paramInt1 = i3;
    }
  }

  public boolean q()
  {
    return this.p;
  }

  public void setCompoundDrawablePadding(int paramInt)
  {
    if (paramInt == this.b);
    do
    {
      return;
      this.b = paramInt;
    }
    while (this.c == null);
    requestLayout();
    invalidate();
  }

  protected void setDrawText(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.n != paramTruncateAt)
    {
      this.n = paramTruncateAt;
      if (this.c != null)
        a();
    }
  }

  public void setIconImage(Drawable paramDrawable)
  {
    if (paramDrawable != this.l)
    {
      this.l = paramDrawable;
      if (this.l != null)
      {
        int i1 = getIconSize();
        this.l.setBounds(0, 0, i1, i1);
      }
      requestLayout();
      invalidate();
    }
  }

  public void setMaxLines(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1);
    while (true)
    {
      setSingleLine(bool);
      return;
      bool = false;
    }
  }

  public void setRestrictTouch(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setSingleLine(boolean paramBoolean)
  {
    if ((this.i ^ paramBoolean))
    {
      this.i = paramBoolean;
      if (this.c != null)
        a();
    }
  }

  public void setText(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }

  public void setText(CharSequence paramCharSequence)
  {
    if (((this.a == null) && (paramCharSequence == null)) || ((this.a != null) && (this.a.equals(paramCharSequence))))
      return;
    this.a = paramCharSequence;
    a();
  }

  public void setTextColor(int paramInt)
  {
    if (paramInt == this.d.getColor())
      return;
    this.d.setColor(paramInt);
    invalidate();
  }

  public void setTextExtraPadding(int paramInt)
  {
    if (paramInt == this.g);
    do
    {
      return;
      this.g = paramInt;
    }
    while (this.c == null);
    a();
  }

  public void setTextSize(int paramInt)
  {
    a(2, paramInt);
  }

  public void setTextWidth(int paramInt)
  {
    if (this.e == paramInt);
    do
    {
      return;
      this.e = paramInt;
    }
    while (this.c == null);
    a();
  }

  public void setTypeface(Typeface paramTypeface)
  {
    if (this.d.getTypeface() != paramTypeface)
    {
      this.d.setTypeface(paramTypeface);
      if (this.c != null)
        a();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auw
 * JD-Core Version:    0.6.2
 */