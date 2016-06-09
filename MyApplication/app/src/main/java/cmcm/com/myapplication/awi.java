package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class awi
  implements awq
{
  private final awo a;
  private awk b;
  private awj c;
  private awq d;
  private final Context e;
  private final Handler f;
  private final View g;

  public awi(Context paramContext, Handler paramHandler, View paramView)
  {
    this.e = paramContext;
    this.f = paramHandler;
    this.g = paramView;
    this.a = new awo(paramContext);
  }

  public awo a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.a.a();
    Object localObject = new PopupMenu(this.e, this.g);
    ((PopupMenu)localObject).inflate(paramInt);
    localObject = ((PopupMenu)localObject).getMenu();
    paramInt = 0;
    int i = ((Menu)localObject).size();
    if (paramInt < i)
    {
      MenuItem localMenuItem = ((Menu)localObject).getItem(paramInt);
      if (!localMenuItem.isVisible());
      while (true)
      {
        paramInt += 1;
        break;
        this.a.a(localMenuItem.getItemId(), localMenuItem.getTitle()).a(this);
      }
    }
  }

  public void a(awq paramawq)
  {
    this.d = paramawq;
  }

  public boolean a(awp paramawp)
  {
    if (this.d != null)
    {
      this.d.a(paramawp);
      return true;
    }
    return false;
  }

  public boolean b()
  {
    return (this.b != null) && (this.b.c());
  }

  public boolean c()
  {
    if ((!b()) && (this.a != null) && (this.c == null))
    {
      this.c = new awj(this, new awk(this, this.e, this.a, this.g, true));
      this.f.postDelayed(this.c, 150L);
      return true;
    }
    return false;
  }

  public boolean d()
  {
    if (this.c != null)
    {
      this.f.removeCallbacks(this.c);
      return true;
    }
    awk localawk = this.b;
    if (localawk != null)
    {
      localawk.b();
      return true;
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awi
 * JD-Core Version:    0.6.2
 */