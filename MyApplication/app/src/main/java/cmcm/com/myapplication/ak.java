package cmcm.com.myapplication;

import android.app.PendingIntent;
import android.os.Bundle;

public class ak extends bh
{
  public static final bi d = new bi()
  {
    public ak a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence, PendingIntent paramAnonymousPendingIntent, Bundle paramAnonymousBundle, bz[] paramAnonymousArrayOfbz)
    {
      return new ak(paramAnonymousInt, paramAnonymousCharSequence, paramAnonymousPendingIntent, paramAnonymousBundle, (br[])paramAnonymousArrayOfbz, null);
    }

    public ak[] a(int paramAnonymousInt)
    {
      return new ak[paramAnonymousInt];
    }
  };
  public int a;
  public CharSequence b;
  public PendingIntent c;
  private final Bundle e;
  private final br[] f;

  private ak(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, br[] paramArrayOfbr)
  {
    this.a = paramInt;
    this.b = ao.e(paramCharSequence);
    this.c = paramPendingIntent;
    if (paramBundle != null);
    while (true)
    {
      this.e = paramBundle;
      this.f = paramArrayOfbr;
      return;
      paramBundle = new Bundle();
    }
  }

  public int a()
  {
    return this.a;
  }

  public CharSequence b()
  {
    return this.b;
  }

  public PendingIntent c()
  {
    return this.c;
  }

  public Bundle d()
  {
    return this.e;
  }

  public br[] e()
  {
    return this.f;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ak
 * JD-Core Version:    0.6.2
 */