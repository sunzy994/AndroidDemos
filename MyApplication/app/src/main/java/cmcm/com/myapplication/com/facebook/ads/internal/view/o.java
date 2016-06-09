package cmcm.com.myapplication.com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class o extends View
{
  private n a;

  public o(Context paramContext, n paramn)
  {
    super(paramContext);
    this.a = paramn;
    setLayoutParams(new ViewGroup.LayoutParams(0, 0));
  }

  public void onWindowVisibilityChanged(int paramInt)
  {
    if (this.a != null)
      this.a.a(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.view.o
 * JD-Core Version:    0.6.2
 */