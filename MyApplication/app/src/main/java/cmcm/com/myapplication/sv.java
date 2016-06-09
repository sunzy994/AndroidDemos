package cmcm.com.myapplication;

import com.hola.channel.sdk.game.widget.TabLayout;
import java.lang.ref.WeakReference;

public class sv
  implements gi
{
  private final WeakReference<TabLayout> a;
  private int b;
  private int c;

  public sv(TabLayout paramTabLayout)
  {
    this.a = new WeakReference(paramTabLayout);
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = true;
    TabLayout localTabLayout = (TabLayout)this.a.get();
    if (localTabLayout != null)
    {
      bool1 = bool2;
      if (this.c != 1)
        if ((this.c != 2) || (this.b != 1))
          break label62;
    }
    label62: for (boolean bool1 = bool2; ; bool1 = false)
    {
      localTabLayout.a(paramInt1, paramFloat, bool1);
      return;
    }
  }

  public void b_(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.a.get();
    su localsu;
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt))
    {
      localsu = localTabLayout.a(paramInt);
      if (this.c != 0)
        break label47;
    }
    label47: for (boolean bool = true; ; bool = false)
    {
      localTabLayout.b(localsu, bool);
      return;
    }
  }

  public void c(int paramInt)
  {
    this.b = this.c;
    this.c = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sv
 * JD-Core Version:    0.6.2
 */