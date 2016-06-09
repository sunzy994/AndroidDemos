package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class awe extends LayerDrawable
{
  private ColorFilter a = new LightingColorFilter(-3355444, 1);

  public awe(Context paramContext, int paramInt)
  {
    this(paramContext.getResources().getDrawable(paramInt));
  }

  public awe(Drawable paramDrawable)
  {
    super(new Drawable[] { paramDrawable });
  }

  public boolean isStateful()
  {
    return true;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int k = 0;
    int n = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    if (i < n)
    {
      int i1 = paramArrayOfInt[i];
      int m;
      if (16842910 == i1)
        m = 1;
      while (true)
      {
        i += 1;
        j = m;
        break;
        m = j;
        if (16842919 == i1)
        {
          k = 1;
          m = j;
        }
      }
    }
    try
    {
      mutate();
      label70: if ((j != 0) && (k != 0))
        setColorFilter(this.a);
      while (true)
      {
        invalidateSelf();
        return super.onStateChange(paramArrayOfInt);
        if (j == 0)
        {
          setColorFilter(null);
          setAlpha(100);
        }
        else
        {
          setColorFilter(null);
          setAlpha(255);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awe
 * JD-Core Version:    0.6.2
 */