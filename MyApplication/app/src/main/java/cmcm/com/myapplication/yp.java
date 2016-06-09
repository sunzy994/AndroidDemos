package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class yp extends Drawable
{
  private Path a;
  private Paint b;
  private boolean c = true;
  private Paint d;
  private final int e;
  private int f;
  private final int g;
  private final boolean h;
  private final Rect i;
  private final Rect j;
  private final Context k;
  private boolean l;

  public yp(Context paramContext)
  {
    Object localObject = yb.getInstance();
    this.k = paramContext;
    this.h = ((yb)localObject).n();
    this.e = paramContext.getResources().getDimensionPixelSize(2131296278);
    int m = yb.getInstance().getCenterOffset();
    int n;
    if (((yb)localObject).i())
    {
      this.g = m;
      this.f = this.e;
      n = ahx.b(paramContext).v();
      if (n == 0)
        break label509;
    }
    label509: for (m = 1; ; m = 0)
    {
      if (m != 0)
        this.f = (asq.a(25.0F) + this.f);
      this.b = new Paint(1);
      this.b.setColor(ahx.b(paramContext).i());
      this.a = new Path();
      this.a.addCircle(this.g, this.f, this.e, Direction.CW);
      this.a.close();
      int i1 = Math.max(this.g, asq.a(6.0F));
      localObject = atp.c(paramContext);
      this.i = new Rect(i1, getIntrinsicHeight() - i1 - ((Bitmap)localObject).getHeight(), ((Bitmap)localObject).getWidth() + i1, getIntrinsicHeight() - i1);
      i1 = Math.max(this.g - asq.a(2.0F), asq.a(4.0F));
      paramContext = atp.d(paramContext);
      this.j = new Rect(i1, getIntrinsicHeight() - i1 - paramContext.getHeight(), paramContext.getWidth() + i1, getIntrinsicHeight() - i1);
      if (m != 0)
      {
        this.d = new Paint(7);
        float f1 = this.g;
        float f2 = this.f;
        float f3 = this.f;
        m = Color.argb(34, Color.red(n), Color.green(n), Color.blue(n));
        float f4 = (this.e - 1) / this.f;
        float f5 = this.e / this.f;
        float f6 = (float)(this.e / this.f + 0.99D) / 2.0F;
        paramContext = Shader.TileMode.CLAMP;
        paramContext = new RadialGradient(f1, f2, f3, new int[] { 0, 0, n, m, 0, 0 }, new float[] { 0.0F, f4, f5, f6, 0.99F, 1.0F }, paramContext);
        this.d.setShader(paramContext);
      }
      return;
      m = Math.max(10, m);
      break;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void draw(Canvas paramCanvas)
  {
    if (!this.c)
      return;
    if (this.d != null)
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
      paramCanvas.drawCircle(this.g, this.f, this.f, this.d);
    }
    paramCanvas.drawPath(this.a, this.b);
    if (this.l)
    {
      paramCanvas.drawBitmap(atp.d(this.k), null, this.j, null);
      return;
    }
    paramCanvas.drawBitmap(atp.c(this.k), null, this.i, null);
  }

  public int getIntrinsicHeight()
  {
    return this.f + this.g;
  }

  public int getIntrinsicWidth()
  {
    return this.f + this.g;
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yp
 * JD-Core Version:    0.6.2
 */