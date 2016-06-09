package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.SparseArray;

class aeq
{
  aes a;
  int b = -1;
  Bitmap c;
  final Paint d = new Paint(1);

  private aeq(aeo paramaeo)
  {
  }

  public void a(Context paramContext, int paramInt)
  {
    if (paramInt == this.b);
    do
    {
      return;
      this.b = paramInt;
      this.c = ((Bitmap)aeo.e(this.e).get(paramInt));
    }
    while (this.c != null);
    paramContext = this.e.a(paramInt);
    aeo.e(this.e).put(paramInt, paramContext);
    this.c = paramContext;
  }

  public void a(Canvas paramCanvas)
  {
    float f = Math.abs(aes.d(this.a));
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (this.c == null)
      if (f < 10.0F)
      {
        localObject1 = aeo.c(this.e);
        f = 0.0F;
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    while (true)
    {
      if (localObject2 != null)
        break label178;
      return;
      localObject1 = aeo.d(this.e);
      break;
      if (f < 15.0F)
      {
        localObject1 = this.c;
        label73: if (f >= 5.0F)
          break label138;
        localObject2 = null;
      }
      while (true)
      {
        if (localObject2 == null)
          break label163;
        f = (f - 5.0F) / 20.0F;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        if (f < 20.0F)
        {
          localObject1 = aeo.c(this.e);
          break label73;
        }
        localObject1 = aeo.d(this.e);
        break label73;
        label138: if (f < 25.0F)
          localObject2 = aeo.c(this.e);
        else
          localObject2 = null;
      }
      label163: f = 0.0F;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    label178: paramCanvas.save();
    paramCanvas.rotate(aes.c(this.a), aes.b(this.a).x, aes.b(this.a).y);
    paramCanvas.drawBitmap((Bitmap)localObject2, aes.b(this.a).x - ((Bitmap)localObject2).getWidth() / 2.0F, aes.b(this.a).y - ((Bitmap)localObject2).getHeight() / 2.0F, null);
    if (localObject1 != null)
    {
      this.d.setAlpha((int)(f * 255.0F));
      paramCanvas.drawBitmap((Bitmap)localObject1, aes.b(this.a).x - ((Bitmap)localObject1).getWidth() / 2.0F, aes.b(this.a).y - ((Bitmap)localObject1).getHeight() / 2.0F, this.d);
    }
    paramCanvas.restore();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aeq
 * JD-Core Version:    0.6.2
 */