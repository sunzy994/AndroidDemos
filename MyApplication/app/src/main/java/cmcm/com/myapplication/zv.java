package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class zv extends yw
{
  private final int a;
  private final boolean b;

  public zv(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }

  public CharSequence a()
  {
    return "";
  }

  public Drawable c(Context paramContext)
  {
    if (this.b)
      return new BitmapDrawable(paramContext.getResources(), ahx.b(paramContext).a());
    return null;
  }

  public boolean d(Context paramContext)
  {
    return false;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     zv
 * JD-Core Version:    0.6.2
 */