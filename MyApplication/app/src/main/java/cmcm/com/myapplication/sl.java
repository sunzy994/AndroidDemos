package cmcm.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public final class sl extends BitmapDrawable
{
  private static final String a = "GameSDK." + sl.class.getSimpleName();
  private int b;
  private int c;
  private boolean d;

  private void a()
  {
    try
    {
      if ((this.b <= 0) && (this.c <= 0) && (this.d) && (b()))
        getBitmap().recycle();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean b()
  {
    try
    {
      Bitmap localBitmap = getBitmap();
      if (localBitmap != null)
      {
        bool = localBitmap.isRecycled();
        if (bool);
      }
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      for (this.b += 1; ; this.b -= 1)
      {
        a();
        return;
      }
    }
    finally
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sl
 * JD-Core Version:    0.6.2
 */