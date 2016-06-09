package cmcm.com.myapplication;

import android.content.Context;
import com.duapps.ad.b.a;

public final class mf
  implements Runnable
{
  private Context a;
  private boolean b;
  private a c;

  public mf(Context paramContext, boolean paramBoolean, a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramBoolean;
    this.c = parama;
  }

  public final void run()
  {
    if (this.b)
    {
      md.a(this.a).b(this.c);
      return;
    }
    md.a(this.a).a(this.c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mf
 * JD-Core Version:    0.6.2
 */