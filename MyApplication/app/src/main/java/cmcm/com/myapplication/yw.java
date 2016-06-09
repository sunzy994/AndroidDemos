package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.lazyswipe.fan.FanItem;

public abstract class yw
{
  protected static final String d = "Swipe." + yw.class.getSimpleName();
  public static boolean g;
  public float e = -100.0F;
  public float f = -100.0F;
  protected FanItem h;

  public abstract CharSequence a();

  public void a(Canvas paramCanvas)
  {
  }

  public void a(FanItem paramFanItem)
  {
    l();
    this.h = paramFanItem;
    if (n())
      paramFanItem.setLayerType(1, null);
    k();
  }

  public boolean b()
  {
    return false;
  }

  public abstract Drawable c(Context paramContext);

  public boolean c()
  {
    return true;
  }

  public boolean d()
  {
    return true;
  }

  public abstract boolean d(Context paramContext);

  public wk e()
  {
    return null;
  }

  public abstract boolean e(Context paramContext);

  public int f(Context paramContext)
  {
    return ahx.b(paramContext).k();
  }

  public String f()
  {
    return null;
  }

  public boolean g(Context paramContext)
  {
    return false;
  }

  public int h(Context paramContext)
  {
    return paramContext.getResources().getColor(2131689476);
  }

  public Drawable h()
  {
    return null;
  }

  public String i()
  {
    CharSequence localCharSequence = a();
    if (localCharSequence != null)
      return localCharSequence.toString();
    return Integer.toString(hashCode());
  }

  public FanItem j()
  {
    return this.h;
  }

  public void k()
  {
    Object localObject;
    if (this.h != null)
    {
      if (!b())
        break label93;
      this.h.setPadding(0, 0, 0, 0);
      localObject = e();
      this.h.setText(a());
      this.h.setTextColor(f(this.h.getContext()));
      Drawable localDrawable = h();
      this.h.setIconBackground(localDrawable);
      if (localObject == null)
        break label125;
      this.h.setIcon((wk)localObject);
    }
    while (true)
    {
      this.h.setTag(this);
      return;
      label93: int i = asq.a(5.0F);
      this.h.setPadding(i, this.h.getPaddingTop(), i, this.h.getPaddingBottom());
      break;
      label125: localObject = c(this.h.getContext());
      if ((ahy.d(this.h.getContext())) && (m()))
        this.h.setIcon(ahy.a(this.h.getContext(), (Drawable)localObject));
      else
        this.h.setIcon((Drawable)localObject);
    }
  }

  public void l()
  {
    if (this.h != null)
      this.h.setTag(null);
    this.h = null;
  }

  public boolean m()
  {
    return false;
  }

  public boolean n()
  {
    return false;
  }

  public boolean o()
  {
    return (d()) || (c());
  }

  public String p()
  {
    if (!(this instanceof ali))
      return FanItem.a;
    int i = ((ali)this).s();
    if (i >= 100)
      return "99+";
    if (i > 0)
      return String.valueOf(i);
    if (i == 0)
      return "...";
    return "";
  }

  public int q()
  {
    return -1;
  }

  public boolean r()
  {
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     yw
 * JD-Core Version:    0.6.2
 */