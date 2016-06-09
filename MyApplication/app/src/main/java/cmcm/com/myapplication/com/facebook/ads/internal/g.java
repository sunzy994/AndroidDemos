package cmcm.com.myapplication.com.facebook.ads.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;

public class g extends View
{
  private Paint a;
  private Paint b;
  private Paint c;
  private int d;
  private boolean e;

  public g(Context paramContext)
  {
    this(paramContext, 60, true);
  }

  public g(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.d = paramInt;
    this.e = paramBoolean;
    if (paramBoolean)
    {
      this.a = new Paint();
      this.a.setColor(-3355444);
      this.a.setStyle(Style.STROKE);
      this.a.setStrokeWidth(3.0F);
      this.a.setAntiAlias(true);
      this.b = new Paint();
      this.b.setColor(-1287371708);
      this.b.setStyle(Style.FILL);
      this.b.setAntiAlias(true);
      this.c = new Paint();
      this.c.setColor(-1);
      this.c.setStyle(Style.STROKE);
      this.c.setStrokeWidth(6.0F);
      this.c.setAntiAlias(true);
    }
    a();
  }

  private void a()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i = (int)(this.d * ((DisplayMetrics)localObject).density);
    float f = this.d;
    localObject = new RelativeLayout.LayoutParams(i, (int)(((DisplayMetrics)localObject).density * f));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.e)
    {
      if ((paramCanvas.isHardwareAccelerated()) && (Build.VERSION.SDK_INT < 17))
        setLayerType(1, null);
      int i = Math.min(paramCanvas.getWidth(), paramCanvas.getHeight());
      int j = i / 2;
      int k = i / 2;
      int m = j * 2 / 3;
      paramCanvas.drawCircle(j, k, m, this.a);
      paramCanvas.drawCircle(j, k, m - 2, this.b);
      j = i / 3;
      i /= 3;
      paramCanvas.drawLine(j, i, j * 2, i * 2, this.c);
      paramCanvas.drawLine(j * 2, i, j, i * 2, this.c);
    }
    super.onDraw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.g
 * JD-Core Version:    0.6.2
 */