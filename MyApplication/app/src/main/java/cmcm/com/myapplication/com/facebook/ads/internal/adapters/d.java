package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;

public class d
{
  private int a = 0;
  private int b = 1000;
  private final Context c;
  private final View d;
  private final int e;
  private final d.a f;
  private final Handler g = new Handler();
  private final Runnable h = new d.b(this);
  private final boolean i;
  private volatile boolean j;

  public d(Context paramContext, View paramView, int paramInt, d.a parama)
  {
    this(paramContext, paramView, paramInt, false, parama);
  }

  public d(Context paramContext, View paramView, int paramInt, boolean paramBoolean, d.a parama)
  {
    this.c = paramContext;
    this.d = paramView;
    this.e = paramInt;
    this.f = parama;
    this.i = paramBoolean;
  }

  public void a()
  {
    if ((!this.i) && (!this.j))
      this.g.postDelayed(this.h, this.a);
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void b()
  {
    this.g.removeCallbacks(this.h);
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.d
 * JD-Core Version:    0.6.2
 */