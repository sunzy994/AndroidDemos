package cmcm.com.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewDebug.CapturedViewProperty;

public class awr
  implements awp
{
  private final int a;
  private CharSequence b;
  private CharSequence c;
  private Intent d;
  private Drawable e;
  private Drawable f;
  private int g = 0;
  private final awo h;
  private Runnable i;
  private awq j;
  private int k = 16;
  private int l = 0;
  private int m = 0;

  awr(awo paramawo, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    this.h = paramawo;
    this.a = paramInt1;
    this.b = paramCharSequence;
    this.l = paramInt2;
  }

  @ViewDebug.CapturedViewProperty
  public int a()
  {
    return this.a;
  }

  public awp a(awq paramawq)
  {
    this.j = paramawq;
    return this;
  }

  public CharSequence a(awx paramawx)
  {
    if ((paramawx != null) && (paramawx.a()))
      return f();
    return e();
  }

  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
  }

  public void b()
  {
    this.e = null;
  }

  public boolean c()
  {
    if ((this.j != null) && (this.j.a(this)))
      return true;
    if (this.i != null)
    {
      this.i.run();
      return true;
    }
    if (this.d != null)
      try
      {
        this.h.c().startActivity(this.d);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.e("Launcher.MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
      }
    return false;
  }

  public boolean d()
  {
    return (this.k & 0x10) != 0;
  }

  @ViewDebug.CapturedViewProperty
  public CharSequence e()
  {
    return this.b;
  }

  public CharSequence f()
  {
    if (this.c != null)
      return this.c;
    return this.b;
  }

  public Drawable g()
  {
    return this.e;
  }

  public Drawable h()
  {
    if (this.f != null)
      return this.f;
    if (this.g != 0)
      return this.h.c().getResources().getDrawable(this.g);
    return null;
  }

  public boolean i()
  {
    return (this.k & 0x8) == 0;
  }

  public boolean j()
  {
    return (this.k & 0x20) == 32;
  }

  public int k()
  {
    return this.m;
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awr
 * JD-Core Version:    0.6.2
 */