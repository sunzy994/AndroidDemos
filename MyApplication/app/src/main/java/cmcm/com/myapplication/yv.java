package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.lazyswipe.fan.friend.FriendSector;

public class yv extends yw
{
  protected final alw a;
  protected final Context b;
  protected Drawable c;

  public yv(Context paramContext, alw paramalw)
  {
    this.b = paramContext;
    this.a = paramalw;
  }

  public CharSequence a()
  {
    return this.a.d;
  }

  public Drawable c(Context paramContext)
  {
    if (this.c == null)
      this.c = aqn.b(this.b, this.a);
    return this.c;
  }

  public boolean d(Context paramContext)
  {
    vv.a().a("点击联系人");
    FriendSector.a(this.h);
    return false;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public String f()
  {
    return "Contact";
  }

  public alw g()
  {
    return this.a;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yv
 * JD-Core Version:    0.6.2
 */