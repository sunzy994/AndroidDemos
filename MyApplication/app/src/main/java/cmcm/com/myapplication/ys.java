package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

public final class ys extends yw
{
  private final CharSequence a;
  private Drawable b;

  public ys(String paramString, Drawable paramDrawable)
  {
    this.a = paramString;
    this.b = paramDrawable;
  }

  public static ys a(Context paramContext)
  {
    return a(paramContext, 2130837647);
  }

  public static ys a(Context paramContext, int paramInt)
  {
    return new ys("", paramContext.getResources().getDrawable(paramInt));
  }

  public CharSequence a()
  {
    return this.a;
  }

  public void b(Context paramContext)
  {
    this.b = paramContext.getResources().getDrawable(2130837647);
    k();
  }

  public boolean b()
  {
    return true;
  }

  public Drawable c(Context paramContext)
  {
    return this.b;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return false;
  }

  public boolean d(Context paramContext)
  {
    return false;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public int f(Context paramContext)
  {
    int i = super.f(paramContext);
    return Color.argb(127, Color.red(i), Color.green(i), Color.blue(i));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ys
 * JD-Core Version:    0.6.2
 */