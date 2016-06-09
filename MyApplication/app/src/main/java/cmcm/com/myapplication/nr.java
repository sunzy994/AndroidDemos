package cmcm.com.myapplication;

import android.content.Context;
import com.duapps.ad.a.a;
import org.json.JSONException;
import org.json.JSONStringer;

public class nr
{
  public int a;
  public String b;

  public nr(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString2;
  }

  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, "dln", Integer.toString(0), paramInt);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    if (3 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("behavior", new JSONStringer().object().key("key").value("fbe").key("sid").value(paramInt1).key("co").value(paramInt2).key("tsi").value(paramLong).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  private static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    if (3 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("behavior", new JSONStringer().object().key("key").value(paramString).key("sid").value(paramInt1).key("co").value(paramInt2).key("tsi").value(paramLong).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    if (3 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("behavior", new JSONStringer().object().key("key").value("srce").key("co").value(paramInt).key("tsi").value(paramLong).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  public static void a(Context paramContext, a parama, int paramInt1, int paramInt2, long paramLong)
  {
    if (1 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("native", new JSONStringer().object().key("key").value("pclick").key("id").value(parama.a).key("logid").value(parama.l).key("sid").value(parama.n).key("ptype").value(paramInt1).key("loop").value(paramInt2).key("tsi").value(paramLong).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (2 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("behavior", new JSONStringer().object().key("key").value("fbgr").key("st").value(paramString).key("sid").value(paramInt).key("ts").value(System.currentTimeMillis()).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (2 > na.h(paramContext))
      return;
    try
    {
      ob.b(paramContext).a("behavior", new JSONStringer().object().key("key").value(paramString1).key("st").value(paramString2).key("sid").value(paramInt).key("ts").value(System.currentTimeMillis()).endObject().toString(), 1);
      return;
    }
    catch (JSONException paramContext)
    {
    }
  }

  private static void a(Context paramContext, String paramString, oa paramoa)
  {
    if (1 > na.h(paramContext))
      return;
    ob localob = ob.b(paramContext);
    JSONStringer localJSONStringer1;
    int i;
    while (true)
    {
      try
      {
        localJSONStringer1 = new JSONStringer().object().key("key").value(paramString).key("ts").value(System.currentTimeMillis());
        localJSONStringer1.key("logid").value(paramoa.i());
        localJSONStringer1.key("id").value(paramoa.b());
        if (paramoa.d() > 0)
        {
          paramContext = paramoa.e();
          if (paramContext != null)
          {
            JSONStringer localJSONStringer2 = localJSONStringer1.key("preclick");
            i = paramContext.c;
            paramContext = "";
            if (i != 0)
              break label249;
            label117: paramContext = "none";
            localJSONStringer2.value(paramContext);
            localJSONStringer1.key("adpkg").value(paramoa.a());
          }
        }
        if (paramoa.b.equals("online"))
          localJSONStringer1.key("adpkg").value(paramoa.a());
        paramContext = mn.a();
        if (("thi".equals(paramString)) && (paramContext != null))
          localJSONStringer1.key("referrer").value(paramContext);
        localJSONStringer1.key("sid").value(paramoa.a);
        localJSONStringer1.endObject();
        localob.a(paramoa.b, localJSONStringer1.toString(), 0);
        return;
      }
      catch (JSONException paramContext)
      {
      }
      if (!mv.a())
        break;
      mv.a("ToolStatsHelper", "create report content failed.", paramContext);
      return;
      label249: if (1 == i)
      {
        paramContext = "tctp";
        continue;
        if (3 == i)
          paramContext = "err";
      }
      else
      {
        if (2 != i)
          break label117;
        paramContext = "tctb";
      }
    }
  }

  public static void a(Context paramContext, oa paramoa)
  {
    a(paramContext, "tctc", paramoa);
  }

  public static void b(Context paramContext, int paramInt)
  {
    a(paramContext, "imn", Integer.toString(0), paramInt);
  }

  public static void b(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    a(paramContext, paramInt1, paramInt2, paramLong, "dle");
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, "dlgr", paramString, paramInt);
  }

  public static void b(Context paramContext, oa paramoa)
  {
    a(paramContext, "tcta", paramoa);
  }

  public static void c(Context paramContext, int paramInt)
  {
    a(paramContext, "oln", Integer.toString(0), paramInt);
  }

  public static void c(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    a(paramContext, paramInt1, paramInt2, paramLong, "ime");
  }

  public static void c(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, "imgr", paramString, paramInt);
  }

  public static void c(Context paramContext, oa paramoa)
  {
    a(paramContext, "tct", paramoa);
  }

  public static void d(Context paramContext, int paramInt)
  {
    if (1 > na.h(paramContext))
      return;
    paramContext = ob.b(paramContext);
    try
    {
      paramContext.a("facebook", new JSONStringer().object().key("key").value("show").key("sid").value(paramInt).key("ts").value(System.currentTimeMillis()).endObject().toString(), 1);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static void d(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    a(paramContext, paramInt1, paramInt2, paramLong, "ole");
  }

  public static void d(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, "olgr", paramString, paramInt);
  }

  public static void d(Context paramContext, oa paramoa)
  {
    nb.a(paramContext).a(paramoa);
    a(paramContext, "tctb", paramoa);
  }

  public static void e(Context paramContext, int paramInt)
  {
    if (1 > na.h(paramContext))
      return;
    paramContext = ob.b(paramContext);
    try
    {
      paramContext.a("facebook", new JSONStringer().object().key("key").value("tctc").key("sid").value(paramInt).key("ts").value(System.currentTimeMillis()).endObject().toString(), 0);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static void e(Context paramContext, oa paramoa)
  {
    nb.a(paramContext).a(paramoa);
    a(paramContext, "tctp", paramoa);
  }

  public static void f(Context paramContext, oa paramoa)
  {
    a(paramContext, "thi", paramoa);
  }

  public static void g(Context paramContext, oa paramoa)
  {
    a(paramContext, "tccu", paramoa);
  }

  public static void h(Context paramContext, oa paramoa)
  {
    if (1 > na.h(paramContext));
    do
    {
      return;
      paramContext = ob.b(paramContext);
      try
      {
        JSONStringer localJSONStringer = new JSONStringer().object().key("key").value("show").key("sid").value(paramoa.a).key("logid").value(paramoa.i()).key("ts").value(System.currentTimeMillis());
        localJSONStringer.key("ids").array().value(paramoa.b()).endArray();
        if (paramoa.b.equals("online"))
          localJSONStringer.key("adpkg").value(paramoa.a());
        localJSONStringer.endObject();
        paramContext.a(paramoa.b, localJSONStringer.toString(), 1);
        return;
      }
      catch (JSONException paramContext)
      {
      }
    }
    while (!mv.a());
    mv.a("ToolStatsHelper", "create report content failed.", paramContext);
  }

  public static void i(Context paramContext, oa paramoa)
  {
    a(paramContext, "tcpp", paramoa);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nr
 * JD-Core Version:    0.6.2
 */