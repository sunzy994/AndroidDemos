package cmcm.com.myapplication.com.flurry.sdk;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public class dn
{
  private static final String a = dn.class.getSimpleName();
  private static dn b;

  public static dn a()
  {
    try
    {
      if (b == null)
        b = new dn();
      dn localdn = b;
      return localdn;
    }
    finally
    {
    }
  }

  public int b()
  {
    int i = ((Integer)dp.a().a("AgentVersion")).intValue();
    el.a(4, a, "getAgentVersion() = " + i);
    return i;
  }

  int c()
  {
    return ((Integer)dp.a().a("ReleaseMajorVersion")).intValue();
  }

  int d()
  {
    return ((Integer)dp.a().a("ReleaseMinorVersion")).intValue();
  }

  int e()
  {
    return ((Integer)dp.a().a("ReleasePatchVersion")).intValue();
  }

  String f()
  {
    return (String)dp.a().a("ReleaseBetaVersion");
  }

  public String g()
  {
    if (f().length() > 0);
    for (String str = "."; ; str = "")
      return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[] { Integer.valueOf(b()), Integer.valueOf(c()), Integer.valueOf(d()), Integer.valueOf(e()), str, f() });
  }

  public String h()
  {
    String str = null;
    dj localdj = dl.a().c();
    if (localdj != null)
      str = localdj.j();
    return str;
  }

  public String i()
  {
    String str = null;
    dj localdj = dl.a().c();
    if (localdj != null)
      str = localdj.k();
    return str;
  }

  public String j()
  {
    String str = null;
    dj localdj = dl.a().c();
    if (localdj != null)
      str = localdj.l();
    return str;
  }

  public boolean k()
  {
    dj localdj = dl.a().c();
    if (localdj != null)
      return localdj.o();
    return true;
  }

  public Map<dr, ByteBuffer> l()
  {
    dj localdj = dl.a().c();
    if (localdj != null)
      return localdj.p();
    return Collections.emptyMap();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.flurry.sdk.dn
 * JD-Core Version:    0.6.2
 */