package cmcm.com.myapplication;

import android.content.Context;
import java.lang.ref.WeakReference;

public class aua extends tn
  implements aub
{
  private final WeakReference<aud> a;

  public aua(Context paramContext, aud paramaud)
  {
    super(paramContext);
    this.a = new WeakReference(paramaud);
  }

  public aud a()
  {
    return (aud)this.a.get();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aua
 * JD-Core Version:    0.6.2
 */