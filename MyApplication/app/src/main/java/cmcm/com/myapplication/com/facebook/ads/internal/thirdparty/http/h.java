package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

import android.os.AsyncTask;

public class h extends AsyncTask<l, Void, n>
  implements c
{
  private a a;
  private b b;
  private Exception c;

  public h(a parama, b paramb)
  {
    this.a = parama;
    this.b = paramb;
  }

  protected n a(l[] paramArrayOfl)
  {
    if (paramArrayOfl != null);
    try
    {
      if (paramArrayOfl.length > 0)
      {
        paramArrayOfl = paramArrayOfl[0];
        return this.a.a(paramArrayOfl);
      }
      throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }
    catch (Exception paramArrayOfl)
    {
      this.c = paramArrayOfl;
      cancel(true);
    }
    return null;
  }

  public void a(l paraml)
  {
    super.execute(new l[] { paraml });
  }

  protected void a(n paramn)
  {
    this.b.a(paramn);
  }

  protected void onCancelled()
  {
    this.b.a(this.c);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.h
 * JD-Core Version:    0.6.2
 */