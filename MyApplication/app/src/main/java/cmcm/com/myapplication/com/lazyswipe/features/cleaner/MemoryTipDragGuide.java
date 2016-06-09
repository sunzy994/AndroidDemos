package cmcm.com.myapplication.com.lazyswipe.features.cleaner;

import acq;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import aqs;
import ari;
import asq;
import ast;
import atw;

public class MemoryTipDragGuide extends RelativeLayout
{
  private static final int a = asq.a(66.669998F);
  private Paint b;
  private float c = 1.0F;
  private float d = 1.0F;
  private int e;
  private int f;
  private int g;
  private boolean h;

  public MemoryTipDragGuide(Context paramContext)
  {
    super(paramContext);
  }

  public MemoryTipDragGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static MemoryTipDragGuide a(Context paramContext)
  {
    paramContext = (MemoryTipDragGuide)LayoutInflater.from(paramContext).inflate(2130968635, null);
    paramContext.a();
    return paramContext;
  }

  public void a()
  {
    setLayerType(1, null);
    WindowManager.LayoutParams localLayoutParams = ast.a(getContext());
    localLayoutParams.type = 2003;
    ast.a(getContext(), this, localLayoutParams);
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ari.a(paramInt1, paramInt2, this.f, this.g) < this.e)
    {
      paramBoolean = true;
      if (!paramBoolean)
        break label68;
    }
    label68: for (float f1 = this.c; ; f1 = 1.0F)
    {
      this.d = f1;
      if ((this.h ^ paramBoolean))
      {
        invalidate();
        this.h = paramBoolean;
      }
      return;
      paramBoolean = false;
      break;
    }
  }

  public void b()
  {
    ast.a(getContext(), this);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, a * this.d, this.b);
    paramCanvas.restore();
    super.dispatchDraw(paramCanvas);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = new Paint(atw.b);
    this.b.setColor(-1);
    this.b.setStyle(Style.STROKE);
    this.b.setStrokeWidth(asq.a(1.3F));
    DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { asq.a(1.0F), asq.a(2.0F) }, 0.0F);
    this.b.setPathEffect(localDashPathEffect);
    if (acq.a().m_());
    for (float f1 = 93.0F; ; f1 = 33.299999F)
    {
      this.e = asq.a(ari.a(75.0F, f1));
      this.c = (this.e * 0.9F / a);
      this.f = (aqs.ac() / 2);
      this.g = (aqs.ad() / 2);
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setPivotX(getMeasuredWidth() / 2);
    setPivotY(getMeasuredHeight() / 2);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.cleaner.MemoryTipDragGuide
 * JD-Core Version:    0.6.2
 */