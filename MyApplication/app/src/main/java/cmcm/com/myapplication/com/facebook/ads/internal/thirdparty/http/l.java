package cmcm.com.myapplication.com.facebook.ads.internal.thirdparty.http;

public abstract class l
{
  protected String a = "";
  protected j b;
  protected String c;
  protected byte[] d;

  public l(String paramString, o paramo)
  {
    if (paramString != null)
      this.a = paramString;
    if (paramo != null)
    {
      paramString = paramo.a();
      this.a = (this.a + "?" + paramString);
    }
  }

  public String a()
  {
    return this.a;
  }

  public j b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public byte[] d()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.thirdparty.http.l
 * JD-Core Version:    0.6.2
 */