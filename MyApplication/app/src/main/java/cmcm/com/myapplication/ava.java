package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public class ava extends Drawable
  implements Animatable, Runnable
{
  private final Drawable a;
  private boolean b = false;
  private final int c;

  public ava(Context paramContext)
  {
    this(paramContext, paramContext.getResources().getDrawable(2130837609), paramContext.getResources().getDimensionPixelSize(2131296341));
  }

  public ava(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    paramContext.getResources();
    this.c = paramInt;
    this.a = paramDrawable;
    this.a.setBounds(0, 0, this.c, this.c);
  }

  public void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
  }

  public int getIntrinsicHeight()
  {
    return this.c;
  }

  public int getIntrinsicWidth()
  {
    return this.c;
  }

  public int getOpacity()
  {
    return 0;
  }

  public boolean isRunning()
  {
    return this.b;
  }

  public void run()
  {
    int j = this.a.getLevel() + 500;
    int i = j;
    if (j >= 10000)
      i = 0;
    this.a.setLevel(i);
    invalidateSelf();
    scheduleSelf(this, SystemClock.uptimeMillis() + 50L);
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void start()
  {
    if (!this.b)
    {
      this.b = true;
      run();
    }
  }

  public void stop()
  {
    if (this.b)
    {
      this.b = false;
      unscheduleSelf(this);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ava
 * JD-Core Version:    0.6.2
 */