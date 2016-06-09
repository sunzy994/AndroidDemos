package cmcm.com.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.holaverse.charging.view.WaveView;

public final class ve
{
  private float a;
  private vc b;
  private float c;
  private float d;
  private float e;
  private int f = 1;
  private float g = this.f * 1.7F;
  private int h;

  public ve()
  {
    c();
  }

  private void c()
  {
  }

  public void a()
  {
    if (this.b == null);
    do
    {
      return;
      this.e += Math.abs(this.g);
      this.d += this.g;
    }
    while (this.e < vc.b(this.b));
    this.e = 0.0F;
  }

  public void a(float paramFloat)
  {
    this.g = (this.f * paramFloat);
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
    if (paramInt > 0);
    for (float f1 = -vc.b(this.b); ; f1 = 0.0F)
    {
      this.a = f1;
      this.g = (Math.abs(this.g) * paramInt);
      return;
    }
  }

  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    if (this.b != null)
    {
      paramPaint.setColor(this.h);
      paramCanvas.save();
      paramCanvas.translate(this.a + paramFloat1 + this.e * this.f, this.c + paramFloat2);
      paramCanvas.drawPath(vc.e(this.b), paramPaint);
      paramCanvas.restore();
    }
  }

  public void a(vc paramvc)
  {
    float f1 = 0.0F;
    this.b = paramvc;
    this.c = 0.0F;
    this.d = (-vc.b(paramvc));
    if (this.f > 0)
      f1 = -vc.b(this.b);
    this.a = f1;
    if (WaveView.c())
      Log.i("WaveView", b());
  }

  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b != null)
    {
      localStringBuilder.append("wave size(");
      localStringBuilder.append(vc.c(this.b));
      localStringBuilder.append(",");
      localStringBuilder.append(vc.d(this.b));
      localStringBuilder.append(", mWaveWidth=");
      localStringBuilder.append(vc.b(this.b));
      localStringBuilder.append(", mWaveHeight=");
      localStringBuilder.append(vc.a(this.b));
    }
    localStringBuilder.append("), mLevelLine=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("， speed=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", direct=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", color=#");
    localStringBuilder.append(Long.toHexString(this.h));
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ve
 * JD-Core Version:    0.6.2
 */