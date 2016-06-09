package cmcm.com.myapplication;

import android.graphics.Bitmap;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class abb
  implements aut
{
  private static final String a = "Swipe." + abb.class.getSimpleName();
  private final WeakReference<abc> b;
  private String c;
  private String d;
  private int e = 0;
  private int f = 0;
  private final boolean g;
  private final boolean h;
  private boolean i;
  private boolean j;
  private final aup k;

  public abb(abc paramabc, boolean paramBoolean1, boolean paramBoolean2)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    this.b = new WeakReference(paramabc);
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    if (!paramBoolean2)
    {
      paramBoolean2 = true;
      this.i = paramBoolean2;
      if (paramBoolean1)
        break label83;
    }
    label83: for (paramBoolean1 = bool; ; paramBoolean1 = false)
    {
      this.j = paramBoolean1;
      this.k = aup.a(localSwipeApplication, this);
      return;
      paramBoolean2 = false;
      break;
    }
  }

  public abb a(abq paramabq)
  {
    this.d = null;
    this.c = null;
    if (this.h)
    {
      this.d = paramabq.h();
      this.k.a(paramabq.i(), this.d);
    }
    if (this.g)
    {
      this.c = paramabq.f();
      this.k.a(paramabq.g(), this.c);
    }
    return this;
  }

  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (this.b.get() == null)
      this.k.a();
    while (true)
    {
      return;
      boolean bool1 = asq.a(this.d, paramString2);
      boolean bool2 = asq.a(this.c, paramString2);
      if ((bool1) || (bool2))
      {
        if (bool1)
        {
          this.i = true;
          if (new File(paramString2).exists())
          {
            this.e = 1;
            this.f = 1;
          }
        }
        while ((this.i) && (this.j))
        {
          this.k.a();
          try
          {
            if ((this.f <= 0) || (this.e <= 0))
              break label160;
            ((abc)this.b.get()).a(this, this.d, this.c, this.e, this.f);
            return;
          }
          catch (Throwable paramString1)
          {
            return;
          }
          this.j = true;
        }
      }
    }
    label160: ((abc)this.b.get()).a(this, this.d);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abb
 * JD-Core Version:    0.6.2
 */