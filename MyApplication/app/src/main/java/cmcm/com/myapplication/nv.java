package cmcm.com.myapplication;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

final class nv
  implements RedirectHandler
{
  private oa a;
  private volatile boolean b = false;

  public nv(ns paramns, oa paramoa)
  {
    this.a = paramoa;
  }

  public final URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    return null;
  }

  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    mv.c("ToolClickHandler", "statusCode " + i);
    if ((i == 303) || (i == 302) || (i == 301) || (i == 307))
    {
      paramHttpResponse = paramHttpResponse.getHeaders("Location")[0].getValue();
      if (paramHttpResponse == null)
      {
        if (mv.a())
          mv.c("ToolClickHandler", "[Http] null URL.");
        this.c.e(this.a, this.a.h());
        this.c.c();
        return false;
      }
      if (nz.a(paramHttpResponse))
      {
        if (mv.a())
          mv.c("ToolClickHandler", "[Http] Market URL: " + paramHttpResponse);
        this.c.a(this.a, paramHttpResponse);
        this.c.f(this.a, paramHttpResponse);
        this.c.c();
        return false;
      }
      this.c.b(this.a, paramHttpResponse);
      return false;
    }
    if (mv.a())
      mv.c("ToolClickHandler", "[Http] non-Market URL: " + this.a.h());
    this.c.e(this.a, this.a.h());
    this.c.c();
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nv
 * JD-Core Version:    0.6.2
 */