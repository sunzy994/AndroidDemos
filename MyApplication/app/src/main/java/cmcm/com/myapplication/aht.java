package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class aht extends ahq
{
  aht(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, paramString2, paramInt);
  }

  public Drawable a(Context paramContext, yb paramyb)
  {
    int i = ahx.b(paramContext).j();
    return new yn(paramContext.getResources().getDimensionPixelSize(2131296283), paramyb.getItemSectorOuterSize(), yb.getInstance().getCenterOffset(), i, paramyb.n(), null);
  }

  public Drawable b(Context paramContext, yb paramyb)
  {
    int i = ahx.b(paramContext).j();
    return new yn(paramContext.getResources().getDimensionPixelSize(2131296283), paramyb.getItemSectorInnerSize(), yb.getInstance().getCenterOffset(), i, paramyb.n(), null);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aht
 * JD-Core Version:    0.6.2
 */