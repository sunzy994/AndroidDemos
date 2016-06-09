package cmcm.com.myapplication.com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

public class ei<RequestObjectType, ResponseObjectType> extends ek
{
  private ei.a<RequestObjectType, ResponseObjectType> a;
  private RequestObjectType b;
  private ResponseObjectType c;
  private eu<RequestObjectType> d;
  private eu<ResponseObjectType> e;

  private void m()
  {
    a(new ek.c()
    {
      public void a(ek paramAnonymousek)
      {
        ei.d(ei.this);
      }

      public void a(ek paramAnonymousek, InputStream paramAnonymousInputStream)
      {
        if (!paramAnonymousek.d());
        while (ei.c(ei.this) == null)
          return;
        ei.a(ei.this, ei.c(ei.this).a(paramAnonymousInputStream));
      }

      public void a(ek paramAnonymousek, OutputStream paramAnonymousOutputStream)
      {
        if ((ei.a(ei.this) != null) && (ei.b(ei.this) != null))
          ei.b(ei.this).a(paramAnonymousOutputStream, ei.a(ei.this));
      }
    });
  }

  private void n()
  {
    if (this.a == null);
    while (b())
      return;
    this.a.a(this, this.c);
  }

  public void a()
  {
    m();
    super.a();
  }

  public void a(ei.a<RequestObjectType, ResponseObjectType> parama)
  {
    this.a = parama;
  }

  public void a(eu<RequestObjectType> parameu)
  {
    this.d = parameu;
  }

  public void a(RequestObjectType paramRequestObjectType)
  {
    this.b = paramRequestObjectType;
  }

  public void b(eu<ResponseObjectType> parameu)
  {
    this.e = parameu;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.ei
 * JD-Core Version:    0.6.2
 */