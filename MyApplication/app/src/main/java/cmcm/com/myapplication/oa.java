package cmcm.com.myapplication;

import org.json.JSONObject;

public final class oa extends nr
{
  public com.duapps.ad.a.a c;
  private String d;
  private long e;
  private int f;
  private String g;
  private int h;
  private mz i;
  private String j;
  private int k;
  private boolean l;

  public oa(com.duapps.ad.a.a parama)
  {
    super(parama.m, parama.n, parama.o);
    this.c = parama;
    this.e = parama.a;
    int m = parama.h;
    this.d = parama.c;
    this.f = parama.i;
    this.g = parama.f;
    this.h = parama.p;
    this.j = parama.l;
    this.k = parama.t;
  }

  public oa(com.duapps.ad.b.a parama)
  {
    super(parama.a, parama.b, parama.d);
    this.e = parama.e;
    this.d = null;
    this.f = parama.f;
    this.g = parama.m;
    this.h = parama.g;
    this.j = parama.c;
  }

  public static oa a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("data");
      if ("download".equals(paramJSONObject.optString("channel")))
        return new oa(com.duapps.ad.a.a.a(paramJSONObject));
    }
    while (!"inmobi".equals(paramJSONObject.optString("channel")));
    return new oa(com.duapps.ad.b.a.a(paramJSONObject));
  }

  public static JSONObject a(oa paramoa)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramoa.c != null)
      localJSONObject.put("data", com.duapps.ad.a.a.b(paramoa.c));
    return localJSONObject;
  }

  public final String a()
  {
    return this.d;
  }

  public final void a(mz parammz)
  {
    this.i = parammz;
  }

  public final void a(boolean paramBoolean)
  {
    this.l = true;
  }

  public final long b()
  {
    return this.e;
  }

  public final int c()
  {
    return this.f;
  }

  public final int d()
  {
    return this.h;
  }

  public final mz e()
  {
    return this.i;
  }

  public final boolean f()
  {
    return this.f == 0;
  }

  public final boolean g()
  {
    return this.f == 1;
  }

  public final String h()
  {
    return this.g;
  }

  public final String i()
  {
    return this.j;
  }

  public final int j()
  {
    return this.k;
  }

  public final boolean k()
  {
    return this.l;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     oa
 * JD-Core Version:    0.6.2
 */