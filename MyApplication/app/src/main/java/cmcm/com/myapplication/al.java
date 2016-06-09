package cmcm.com.myapplication;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class al
{
  private final int a;
  private final CharSequence b;
  private final PendingIntent c;
  private final Bundle d;
  private ArrayList<br> e;

  public al(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }

  private al(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = ao.e(paramCharSequence);
    this.c = paramPendingIntent;
    this.d = paramBundle;
  }

  public ak a()
  {
    if (this.e != null);
    for (br[] arrayOfbr = (br[])this.e.toArray(new br[this.e.size()]); ; arrayOfbr = null)
      return new ak(this.a, this.b, this.c, this.d, arrayOfbr, null);
  }

  public al a(Bundle paramBundle)
  {
    if (paramBundle != null)
      this.d.putAll(paramBundle);
    return this;
  }

  public al a(br parambr)
  {
    if (this.e == null)
      this.e = new ArrayList();
    this.e.add(parambr);
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     al
 * JD-Core Version:    0.6.2
 */