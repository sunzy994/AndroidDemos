package cmcm.com.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class sg extends BitmapDrawable
{
  private final WeakReference<sh> a;

  public sg(Resources paramResources, Bitmap paramBitmap, sh paramsh)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramsh);
  }

  public sh a()
  {
    return (sh)this.a.get();
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
 * Qualified Name:     sg
 * JD-Core Version:    0.6.2
 */