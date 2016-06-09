package cmcm.com.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class atz extends BitmapDrawable
  implements aub
{
  private final WeakReference<aud> a;

  public atz(Resources paramResources, Bitmap paramBitmap, aud paramaud)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramaud);
  }

  public aud a()
  {
    return (aud)this.a.get();
  }

  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = getBitmap();
    if ((localBitmap == null) || (localBitmap.isRecycled()))
      return;
    super.draw(paramCanvas);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atz
 * JD-Core Version:    0.6.2
 */