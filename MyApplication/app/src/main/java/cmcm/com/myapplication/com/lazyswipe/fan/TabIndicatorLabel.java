package cmcm.com.myapplication.com.lazyswipe.fan;

import ahw;
import ahx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import asq;

public class TabIndicatorLabel extends TextView
{
  private float a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private float j;
  private boolean k;
  private int l;
  private int m;

  public TabIndicatorLabel(Context paramContext)
  {
    super(paramContext);
  }

  public TabIndicatorLabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void c()
  {
    Context localContext = getContext();
    this.b = ahx.b(localContext).m();
    this.c = ahx.b(localContext).n();
    this.d = Color.red(this.b);
    this.e = Color.red(this.c);
    this.f = Color.green(this.b);
    this.g = Color.green(this.c);
    this.h = Color.blue(this.b);
    this.i = Color.blue(this.c);
    setTextColor(this.b);
    this.l = Math.min(asq.a(5.0F), 25);
    this.m = ahx.b(localContext).u();
    if (this.m != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.k = bool;
      return;
    }
  }

  private void setTextAlpha(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      this.j = 0.0F;
      setTextColor(this.b);
      return;
    }
    if (paramFloat >= 1.0F)
    {
      this.j = 1.0F;
      setTextColor(this.c);
      return;
    }
    this.j = paramFloat;
    float f1 = (1.0F - paramFloat) * (1.0F - paramFloat);
    float f2 = 1.0F - (1.0F - paramFloat) * paramFloat;
    int n = (int)((this.d * f1 + this.e * paramFloat) / f2);
    int i1 = (int)((this.f * f1 + this.g * paramFloat) / f2);
    int i2 = (int)((f1 * this.h + this.i * paramFloat) / f2);
    setTextColor(Color.argb((int)(f2 * 255.0F), n, i1, i2));
  }

  public void a()
  {
    setHighLightRatio(0.0F);
  }

  public boolean b()
  {
    return (this.b != this.c) || (this.k);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.a, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c();
  }

  public void setDegree(float paramFloat)
  {
    this.a = paramFloat;
  }

  public void setHighLightRatio(float paramFloat)
  {
    if (!b());
    do
    {
      do
        return;
      while (this.j == paramFloat);
      if ((!this.k) || (getLayerType() != 2))
        break;
      if ((paramFloat == 1.0F) && (this.j != 1.0F))
      {
        setShadowLayer(this.l, 0.0F, 0.0F, this.m);
        this.j = 1.0F;
        setTextColor(this.c);
        return;
      }
    }
    while ((paramFloat == 1.0F) || (this.j != 1.0F));
    setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.j = 0.0F;
    setTextColor(this.b);
    return;
    if ((paramFloat == 1.0F) && (this.j != 1.0F))
      setShadowLayer(this.l, 0.0F, 0.0F, this.m);
    while (true)
    {
      setTextAlpha(paramFloat);
      return;
      if ((paramFloat != 1.0F) && (this.j == 1.0F))
        setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }

  public void setText(CharSequence paramCharSequence, BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      int n = getResources().getInteger(2131361797);
      localObject = paramCharSequence;
      if (paramCharSequence.length() > n)
        localObject = paramCharSequence.subSequence(0, n - 3) + "...";
    }
    super.setText((CharSequence)localObject, paramBufferType);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.TabIndicatorLabel
 * JD-Core Version:    0.6.2
 */