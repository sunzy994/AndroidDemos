package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.view.View;

public class auf
{
  private final Context a;
  private final View b;
  private String c;
  private Rect d = new Rect();
  private ShapeDrawable e;
  private Paint f;
  private final int g;
  private final int h;

  public auf(Context paramContext, View paramView)
  {
    this.a = paramContext;
    this.b = paramView;
    int i = asq.a(18.0F);
    this.h = i;
    this.g = i;
  }

  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d == null)
      this.d = new Rect();
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f8;
    if (this.e == null)
    {
      paramInt1 = this.a.getResources().getDimensionPixelSize(2131296375);
      f1 = paramInt1;
      f2 = paramInt1;
      f3 = paramInt1;
      f4 = paramInt1;
      f5 = paramInt1;
      f6 = paramInt1;
      f7 = paramInt1;
      f8 = paramInt1;
      if ((TextUtils.isEmpty(this.c)) || (this.c.length() != 1))
        break label551;
    }
    label551: for (Object localObject = new OvalShape(); ; localObject = new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, null, null))
    {
      this.e = new ShapeDrawable((Shape)localObject);
      localObject = this.e.getPaint();
      ((Paint)localObject).setStyle(Style.FILL);
      ((Paint)localObject).setStrokeWidth(0.0F);
      ((Paint)localObject).setColor(this.a.getResources().getColor(2131689476));
      if (this.f == null)
      {
        this.f = new Paint();
        this.f.setTextSize(this.a.getResources().getDimensionPixelSize(2131296396));
        this.f.setColor(-1);
        this.f.setAntiAlias(true);
        this.f.setFakeBoldText(true);
        this.f.setTextAlign(Align.CENTER);
      }
      this.f.getTextBounds(this.c, 0, this.c.length(), this.d);
      paramInt1 = this.d.top;
      int i = this.d.right;
      int j = this.d.left;
      int k = this.d.bottom - this.d.top;
      paramInt4 = Math.max(this.h, k);
      f1 = (paramInt4 - k) / 2.0F;
      this.f.getTextBounds("0", 0, 1, this.d);
      f2 = (paramInt4 - this.d.bottom + this.d.top) / 2.0F;
      i = (int)Math.max(this.g, i - j + f2 * 2.0F);
      f2 = Math.min(Math.min(i / 2.0F, this.b.getScrollX() + this.b.getWidth() - paramInt3) / i, Math.min(paramInt4 / 2.0F, paramInt2 - this.b.getScrollY()) / paramInt4);
      paramInt3 = (int)(paramInt3 - i * (1.0F - f2));
      paramInt2 = (int)(paramInt2 - f2 * paramInt4);
      this.d.set(this.e.getBounds());
      this.e.setBounds(paramInt3, paramInt2, paramInt3 + i, paramInt4 + paramInt2);
      this.e.draw(paramCanvas);
      this.e.setBounds(this.d);
      f2 = i / 2 + paramInt3;
      f3 = paramInt2;
      f4 = paramInt1;
      paramCanvas.drawText(this.c, f2, f1 + f3 - f4 - 1.0F, this.f);
      return;
    }
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     auf
 * JD-Core Version:    0.6.2
 */