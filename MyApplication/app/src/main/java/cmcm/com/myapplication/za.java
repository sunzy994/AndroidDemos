package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.lazyswipe.SwipeApplication;
import java.io.File;

public class za extends yw
  implements alh
{
  static int a = -1;
  public static boolean c;
  private static boolean j;
  protected final Context b;
  private boolean i;

  public static za a(int paramInt)
  {
    return null;
  }

  public static boolean s()
  {
    return vs.a(2, true);
  }

  public static void t()
  {
    vs.a(2);
  }

  public CharSequence a()
  {
    return this.b.getText(2131231259);
  }

  public Drawable c(Context paramContext)
  {
    if (abd.d())
    {
      paramContext = abd.j.l();
      if (paramContext != null)
      {
        paramContext = paramContext.f();
        if ((!TextUtils.isEmpty(paramContext)) && (new File(paramContext).exists()))
        {
          paramContext = atw.a(paramContext, 0, 0);
          if (paramContext != null)
            return new BitmapDrawable(this.b.getResources(), paramContext);
        }
      }
    }
    return this.b.getResources().getDrawable(2130903040);
  }

  public boolean c()
  {
    return false;
  }

  public boolean d(Context paramContext)
  {
    yb.a(this.h, this);
    c = true;
    return false;
  }

  public boolean e(Context paramContext)
  {
    return false;
  }

  public String f()
  {
    return "Spotlight";
  }

  public void g()
  {
    if (!this.i)
    {
      t();
      this.i = true;
      Object localObject = yb.getInstance();
      if ((localObject != null) && (((yb)localObject).isShown()) && (!((yb)localObject).f()))
      {
        localObject = ((yb)localObject).getItemLayer();
        if (localObject != null)
        {
          ((xu)localObject).getTab().g();
          j = true;
          ((xu)localObject).getTab().a((SwipeApplication)this.b.getApplicationContext());
          j = false;
          ((xu)localObject).a(true);
        }
      }
      return;
    }
    this.i = true;
  }

  public boolean m()
  {
    return true;
  }

  public String p()
  {
    return "...";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     za
 * JD-Core Version:    0.6.2
 */