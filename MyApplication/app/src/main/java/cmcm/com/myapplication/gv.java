package cmcm.com.myapplication;

import android.view.View;
import java.lang.ref.WeakReference;

class gv
  implements Runnable
{
  WeakReference<View> a;
  gt b;

  private gv(gu paramgu, gt paramgt, View paramView)
  {
    this.a = new WeakReference(paramView);
    this.b = paramgt;
  }

  public void run()
  {
    View localView = (View)this.a.get();
    if (localView != null)
      gu.a(this.c, this.b, localView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     gv
 * JD-Core Version:    0.6.2
 */