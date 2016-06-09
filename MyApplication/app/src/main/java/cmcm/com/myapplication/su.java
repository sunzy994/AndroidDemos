package cmcm.com.myapplication;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.hola.channel.sdk.game.widget.TabLayout;

public final class su
{
  private Drawable a;
  private CharSequence b;
  private CharSequence c;
  private int d = -1;
  private View e;
  private final TabLayout f;

  public su(TabLayout paramTabLayout)
  {
    this.f = paramTabLayout;
  }

  public View a()
  {
    return this.e;
  }

  public su a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if (this.d >= 0)
      TabLayout.a(this.f, this.d);
    return this;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public Drawable b()
  {
    return this.a;
  }

  public int c()
  {
    return this.d;
  }

  public CharSequence d()
  {
    return this.b;
  }

  public void e()
  {
    this.f.b(this);
  }

  public CharSequence f()
  {
    return this.c;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     su
 * JD-Core Version:    0.6.2
 */