package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class abj
  implements abq, OnClickListener, lc
{
  public static final String a = "Swipe." + abj.class.getSimpleName();
  private static boolean l = false;
  private static Map<Integer, String> m = new HashMap();
  private static Map<Integer, Integer> n;
  private final Context b;
  private final int c;
  private final int d;
  private final ld e;
  private abr f;
  private Handler g = new Handler(Looper.getMainLooper());
  private String h;
  private String i;
  private String j;
  private String k;

  static
  {
    m.put(Integer.valueOf(10536), "318456978329294_341745406000451");
    n = new HashMap();
    n.put(Integer.valueOf(14), Integer.valueOf(10536));
  }

  public abj(Context paramContext, int paramInt, abr paramabr)
  {
    this.b = paramContext.getApplicationContext();
    this.d = paramInt;
    this.c = a(paramInt);
    this.e = new ld(this.b, this.c, 1);
    this.e.a(this);
    a(paramabr);
  }

  private static int a(int paramInt)
  {
    if (n.containsKey(Integer.valueOf(paramInt)))
      return ((Integer)n.get(Integer.valueOf(paramInt))).intValue();
    return 10536;
  }

  public static void a(Context paramContext)
  {
    if (l)
      return;
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator = m.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("pid", "" + localEntry.getKey());
        JSONArray localJSONArray2 = new JSONArray();
        localJSONArray2.put(localEntry.getValue());
        localJSONObject.put("fbids", localJSONArray2);
        localJSONArray1.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
      }
    }
    mn.a(paramContext, localJSONArray1.toString());
    l = true;
  }

  public static boolean n()
  {
    return l;
  }

  public int a()
  {
    return 5;
  }

  public void a(abr paramabr)
  {
    this.f = paramabr;
  }

  public void a(View paramView)
  {
    this.e.a(paramView);
  }

  public void a(View paramView, Runnable paramRunnable)
  {
  }

  public void a(ld paramld)
  {
    this.h = this.e.g();
    this.j = (aro.a(this.b) + arh.a(this.h));
    this.i = this.e.h();
    this.k = (aro.a(this.b) + arh.a(this.i));
    vy.a(this.d, 1, 1, "du");
    if (this.f != null)
      this.g.post(new Runnable()
      {
        public void run()
        {
          abj.a(abj.this).a(abj.this, true);
        }
      });
  }

  public void a(ld paramld, final lb paramlb)
  {
    vy.a(this.d, "du", paramlb.a());
    if (this.f != null)
      this.g.post(new Runnable()
      {
        public void run()
        {
          abj.a(abj.this).a(abj.this, true, paramlb.a(), paramlb.b());
        }
      });
  }

  public void a(boolean paramBoolean)
  {
    this.e.c();
  }

  public void b()
  {
    this.e.b();
  }

  public void b(ld paramld)
  {
    if (this.f != null)
      this.f.a(this);
  }

  public String c()
  {
    return this.e.i();
  }

  public String d()
  {
    return this.e.e();
  }

  public String e()
  {
    return this.e.f();
  }

  public String f()
  {
    return this.j;
  }

  public String g()
  {
    return this.h;
  }

  public String h()
  {
    return this.k;
  }

  public String i()
  {
    return this.i;
  }

  public Drawable j()
  {
    return null;
  }

  public Drawable k()
  {
    return null;
  }

  public long l()
  {
    return 3600000L;
  }

  public void m()
  {
    this.e.d();
  }

  public void onClick(View paramView)
  {
  }

  public String toString()
  {
    return "FacebookNativeAd{title=" + this.e.e() + ";body=" + this.e.f() + ";mDuId=" + this.c + ";mPlacementId=" + this.d + "}";
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abj
 * JD-Core Version:    0.6.2
 */