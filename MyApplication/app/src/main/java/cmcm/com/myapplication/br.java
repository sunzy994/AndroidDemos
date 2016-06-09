package cmcm.com.myapplication;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class br extends bz
{
  public static final ca a;
  private static final bt g;
  private final String b;
  private final CharSequence c;
  private final CharSequence[] d;
  private final boolean e;
  private final Bundle f;

  static
  {
    if (Build.VERSION.SDK_INT >= 20)
      g = new bu();
    while (true)
    {
      a = new ca()
      {
        public br a(String paramAnonymousString, CharSequence paramAnonymousCharSequence, CharSequence[] paramAnonymousArrayOfCharSequence, boolean paramAnonymousBoolean, Bundle paramAnonymousBundle)
        {
          return new br(paramAnonymousString, paramAnonymousCharSequence, paramAnonymousArrayOfCharSequence, paramAnonymousBoolean, paramAnonymousBundle);
        }

        public br[] a(int paramAnonymousInt)
        {
          return new br[paramAnonymousInt];
        }
      };
      return;
      if (Build.VERSION.SDK_INT >= 16)
        g = new bw();
      else
        g = new bv();
    }
  }

  br(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    this.b = paramString;
    this.c = paramCharSequence;
    this.d = paramArrayOfCharSequence;
    this.e = paramBoolean;
    this.f = paramBundle;
  }

  public static void a(br[] paramArrayOfbr, Intent paramIntent, Bundle paramBundle)
  {
    g.a(paramArrayOfbr, paramIntent, paramBundle);
  }

  public String a()
  {
    return this.b;
  }

  public CharSequence b()
  {
    return this.c;
  }

  public CharSequence[] c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.e;
  }

  public Bundle e()
  {
    return this.f;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     br
 * JD-Core Version:    0.6.2
 */