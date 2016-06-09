package cmcm.com.myapplication;

import android.content.Context;
import java.io.File;
import org.apache.http.client.methods.HttpGet;

public class asz extends asy
{
  public HttpGet a(Context paramContext, ata paramata)
  {
    paramata.j = paramata.f.length();
    return super.a(paramContext, paramata);
  }

  public HttpGet a(Context paramContext, ata paramata, String paramString)
  {
    paramContext = super.a(paramContext, paramata, paramString);
    if (paramata.j > 0L)
    {
      paramContext.addHeader("Range", "bytes=" + paramata.f.length() + "-");
      if (paramata.k.a != null)
        paramContext.addHeader("If-Match", paramata.k.a);
    }
    return paramContext;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     asz
 * JD-Core Version:    0.6.2
 */