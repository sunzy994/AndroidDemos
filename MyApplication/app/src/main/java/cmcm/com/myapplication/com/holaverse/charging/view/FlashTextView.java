package cmcm.com.myapplication.com.holaverse.charging.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;
import ua;
import ul;

public class FlashTextView extends TextView
  implements Runnable
{
  private boolean a;
  private Paint b;
  private int c;
  private int d = ul.b(getContext(), 1.0F);
  private int e = ul.b(getContext(), 70.0F);
  private Rect f = new Rect();

  public FlashTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FlashTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FlashTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayerType(1, null);
    this.b = new Paint(7);
    this.b.setStyle(Style.FILL);
    paramInt = a(paramContext, paramAttributeSet, paramInt);
    int i = Color.argb(1, Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
    paramContext = this.b;
    float f1 = this.e;
    paramAttributeSet = Shader.TileMode.CLAMP;
    paramContext.setShader(new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { i, paramInt, paramInt, i }, new float[] { 0.0F, 0.4F, 0.6F, 1.0F }, paramAttributeSet));
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    this.f.set(0, 0, this.e, ul.b(getContext(), 30.0F));
  }

  private int a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ua.FlashTextView, paramInt, 0);
      paramInt = paramContext.getColor(ua.FlashTextView_flashColor, -1);
      paramContext.recycle();
      return paramInt;
    }
    catch (Exception paramContext)
    {
    }
    return -1;
  }

  public void a()
  {
    removeCallbacks(this);
    this.a = true;
    post(this);
  }

  public void b()
  {
    this.a = false;
    removeCallbacks(this);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a = true;
    this.c = (-this.e);
    postDelayed(this, 100L);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.translate(this.c, 0.0F);
    paramCanvas.drawRect(this.f, this.b);
    paramCanvas.translate(-this.c, 0.0F);
  }

  public void run()
  {
    if (!this.a)
      return;
    invalidate();
    this.c += this.d;
    removeCallbacks(this);
    if (this.c < getWidth())
    {
      post(this);
      return;
    }
    this.c = (-this.e);
    postDelayed(this, 400L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.holaverse.charging.view.FlashTextView
 * JD-Core Version:    0.6.2
 */