package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;
import java.util.List;

public abstract class ahw
  implements ahv
{
  protected static final String f = "Swipe." + ahw.class.getSimpleName();
  protected static int j;
  protected static int k;
  protected static int l;
  protected static int m;
  public final String g;
  public final String h;
  protected final Context i;

  ahw(Context paramContext, String paramString1, String paramString2)
  {
    this.i = paramContext.getApplicationContext();
    this.g = paramString1;
    this.h = paramString2;
    x();
  }

  private static void x()
  {
    if (j <= 0)
    {
      j = (int)(vj.e * 0.5D);
      k = (int)(vj.f * 0.5D);
      l = (int)(vj.e * 0.5600000000000001D);
      m = (int)(vj.f * 0.5600000000000001D);
    }
  }

  protected void C()
  {
    ahx.a = this;
  }

  public Drawable F()
  {
    return aid.a(this.i, "icon_bg", true);
  }

  public Drawable G()
  {
    return aid.a(this.i, "icon_fg", true);
  }

  public Drawable H()
  {
    return aid.a(this.i, "icon_mask", true);
  }

  public List<Drawable> I()
  {
    return null;
  }

  public String J()
  {
    return aic.a(this);
  }

  public String K()
  {
    return this.h;
  }

  public boolean L()
  {
    return this.g.equals(ahx.a(this.i));
  }

  public List M()
  {
    return d();
  }

  public String N()
  {
    return this.g;
  }

  public String O()
  {
    return aie.a(this.i).a(this.g);
  }

  public int a(yb paramyb)
  {
    return 0;
  }

  public Bitmap a()
  {
    Object localObject = SwipeApplication.c();
    Bitmap localBitmap = ((BitmapDrawable)((Context)localObject).getResources().getDrawable(2130903040)).getBitmap();
    try
    {
      int n = ((Context)localObject).getResources().getDimensionPixelSize(2131296279);
      localObject = Bitmap.createBitmap(n, n, Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      Paint localPaint = new Paint();
      localPaint.setFlags(7);
      localCanvas.setDrawFilter(atw.a);
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.setSaturation(0.0F);
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      localPaint.setAlpha(75);
      localCanvas.drawBitmap(localBitmap, null, new Rect(0, 0, n, n), localPaint);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return localBitmap;
  }

  public abstract Drawable a(Context paramContext, ans paramans);

  public Drawable a(Context paramContext, yb paramyb)
  {
    return new yn(paramContext.getResources().getDimensionPixelSize(2131296283), paramyb.getItemSectorOuterSize(), yb.getInstance().getCenterOffset(), 0, paramyb.n(), null);
  }

  public abstract Drawable a(Context paramContext, yb paramyb, Drawable paramDrawable);

  protected void a(Runnable paramRunnable)
  {
    ahw localahw = ahx.b(this.i);
    if (!this.g.equals(localahw.g));
    for (int n = 1; ; n = 0)
    {
      Context localContext = this.i;
      ahx.a = null;
      vs.b(localContext, "pref_theme_key", this.g);
      aif.a(localContext);
      aty.a();
      SwipeApplication.c().a().a(true);
      if (n != 0)
      {
        localahw.a(true);
        aji.b(this.i);
      }
      C();
      if (paramRunnable != null)
        paramRunnable.run();
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
  }

  public void a(boolean paramBoolean, final Runnable paramRunnable)
  {
    arj.a(new Runnable() {
      public void run() {
        ahw.this.a(paramRunnable);
      }
    });
  }

  public abstract Drawable b(Context paramContext);

  public Drawable b(Context paramContext, yb paramyb)
  {
    return new yn(paramContext.getResources().getDimensionPixelSize(2131296283), paramyb.getItemSectorInnerSize(), yb.getInstance().getCenterOffset(), 0, paramyb.n(), null);
  }

  public boolean b()
  {
    return true;
  }

  public abstract Bitmap c();

  public abstract Drawable c(Context paramContext);

  public Drawable c(Context paramContext, yb paramyb)
  {
    float f1 = paramContext.getResources().getDimension(2131296345);
    float f2 = paramContext.getResources().getDimension(2131296346);
    paramContext = new yq(paramContext, paramyb.n());
    paramContext.a(paramyb.getTabCount(), false);
    paramContext.a(f1, f2);
    paramContext.a(paramyb.getTabSectorInnerSize() - paramyb.getCenterOffset(), paramyb.getTabSectorOuterSize() - paramyb.getCenterOffset());
    return paramContext;
  }

  public Drawable d(Context paramContext, yb paramyb)
  {
    return new yp(paramContext);
  }

  public abstract List<Bitmap> d();

  public abstract boolean e();

  public abstract long f();

  public boolean g()
  {
    return false;
  }

  public abstract int i();

  public abstract int j();

  public abstract int k();

  public abstract int l();

  public boolean l_()
  {
    return true;
  }

  public abstract int m();

  public abstract int n();

  public abstract int o();

  public abstract int p();

  public abstract int q();

  public abstract int r();

  public abstract int s();

  public abstract int t();

  public String toString()
  {
    return super.toString() + "[key = " + this.g + "]";
  }

  public abstract int u();

  public abstract int v();

  public abstract int w();

  public void y()
  {
    a(null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahw
 * JD-Core Version:    0.6.2
 */