package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

public class se extends sf
{
  private static final String f = "GameSDK." + se.class.getSimpleName();
  protected int a;
  protected int b;

  public se(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    a(paramInt1, paramInt2);
  }

  private Bitmap a(int paramInt, Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
      i = paramBundle.getInt("ow", this.a);
    for (int j = paramBundle.getInt("oh", this.b); ; j = this.b)
    {
      return sb.a(this.e, paramInt, i, j, this.c, String.valueOf(paramInt));
      i = this.a;
    }
  }

  protected Bitmap a(Object paramObject, Bundle paramBundle)
  {
    return a(Integer.parseInt(String.valueOf(paramObject)), paramBundle);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     se
 * JD-Core Version:    0.6.2
 */