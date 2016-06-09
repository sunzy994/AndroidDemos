package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class yt extends yw
{
  public final wk a;

  public yt(wk paramwk)
  {
    this.a = paramwk;
  }

  public CharSequence a()
  {
    return this.a.b;
  }

  public Drawable c(Context paramContext)
  {
    if (this.a.c == null);
    for (paramContext = null; ; paramContext = (Drawable)this.a.c.get())
    {
      Object localObject = paramContext;
      if (paramContext == null)
        localObject = this.a.h;
      return localObject;
    }
  }

  public boolean d(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.a.k == -1)
    {
      aso.a(paramContext, 2131230974);
      bool2 = bool1;
      return bool2;
    }
    if ((yb.getInstance() != null) && ((yb.getInstance().getCurrentTab() instanceof aag)))
    {
      bool1 = true;
      label48: if (this.a.i != null)
        break label119;
    }
    label119: for (String str = ""; ; str = this.a.i.getPackageName())
    {
      vy.a(bool1, str);
      bool1 = bool2;
      if (this.a.a(paramContext) != null)
        bool1 = true;
      asq.t(paramContext);
      bool2 = bool1;
      if (!add.a().equals(this.a.i))
        break;
      vy.a(paramContext, "D4", 1);
      return bool1;
      bool1 = false;
      break label48;
    }
  }

  public wk e()
  {
    return this.a;
  }

  public boolean e(Context paramContext)
  {
    return asq.b(paramContext, this.a.i.getPackageName());
  }

  public String f()
  {
    return this.a.i.getPackageName();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yt
 * JD-Core Version:    0.6.2
 */