package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.net.URISyntaxException;

public class yz extends yv
{
  private final String i;
  private final String j;
  private final String k;
  private final Bitmap l;

  public yz(Context paramContext, alw paramalw)
  {
    super(paramContext, paramalw);
    this.i = paramalw.d;
    this.j = paramalw.g;
    this.k = paramalw.h;
    this.l = paramalw.b();
  }

  public CharSequence a()
  {
    return this.i;
  }

  public Drawable c(Context paramContext)
  {
    if (this.c == null)
      if (this.l == null)
        break label34;
    label34: for (this.c = new BitmapDrawable(this.l); ; this.c = aqn.c(this.b, this.i))
      return this.c;
  }

  public boolean d(Context paramContext)
  {
    vv.a().a("点击shortcut");
    try
    {
      Intent localIntent = Intent.parseUri(this.k, 0);
      arm.a(localIntent, this.j);
      asq.d(paramContext, localIntent);
      return true;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      while (true)
        asq.j(paramContext, this.j);
    }
  }

  public String f()
  {
    return this.j;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yz
 * JD-Core Version:    0.6.2
 */