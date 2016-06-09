package cmcm.com.myapplication.com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.util.g;

public abstract class a
{
  protected final b a;
  private final Context b;
  private boolean c;

  public a(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }

  public final void a()
  {
    if (this.c);
    do
    {
      return;
      if (this.a != null)
        this.a.d();
      b();
      this.c = true;
      g.a(this.b, "Impression logged");
    }
    while (this.a == null);
    this.a.e();
  }

  protected abstract void b();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.adapters.a
 * JD-Core Version:    0.6.2
 */