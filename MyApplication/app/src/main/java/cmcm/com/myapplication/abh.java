package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class abh extends AsyncTask<Boolean, Void, String>
  implements abq, OnClickListener
{
  private static final String a = "Swipe." + abh.class.getSimpleName();
  private final Context b;
  private final int c;
  private final boolean d;
  private abr e;
  private abi f;
  private WeakReference<View> g;

  public abh(Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramInt1;
    if (paramInt2 == 4);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  public abh(Context paramContext, int paramInt1, int paramInt2, abr paramabr)
  {
    this(paramContext, paramInt1, paramInt2);
    a(paramabr);
  }

  private String n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d);
    for (String str = "http://i.haloapps.com/spads?"; ; str = "http://i.haloapps.com/ad?")
    {
      localStringBuilder.append(str).append("a=").append("300105").append("&").append("v=").append(22500).append("&").append("placement=").append(asi.b(abd.d[this.c])).append("&").append("gaid=").append(asi.b(kv.a().t())).append("&").append("imei=").append(asi.b(asl.b(this.b))).append("&").append("androidid=").append(asi.b(aqs.l(this.b))).append("&").append("model=").append(asi.b(Build.MODEL)).append("&").append("brand=").append(asi.b(Build.BRAND)).append("&").append("osv=").append(VERSION.SDK_INT).append("&").append("carrier=").append(asi.b(asl.i(this.b))).append("&").append("network=").append(asi.b(arl.a(this.b))).append("&").append("locale=").append(asi.b(asq.j()));
      return localStringBuilder.toString();
    }
  }

  public int a()
  {
    if (this.d)
      return 4;
    return 3;
  }

  protected String a(Boolean[] paramArrayOfBoolean)
  {
    if ((isCancelled()) || (this.e == null))
      return "Cancelled";
    paramArrayOfBoolean = n();
    paramArrayOfBoolean = ard.a(this.b, paramArrayOfBoolean, 10000, 10000);
    if (isCancelled())
      return "Cancelled";
    if (arr.a == paramArrayOfBoolean.a);
    while (true)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramArrayOfBoolean.c);
        i = ((JSONObject)localObject1).optInt("code");
        if (i != 0)
          return "Result code:" + i;
        localObject1 = ((JSONObject)localObject1).optJSONArray("data");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          int j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            localObject2 = new abi(this, this.b, (JSONObject)localObject2, this.c, null);
            if ((((abi)localObject2).a == null) || (TextUtils.isEmpty(((abi)localObject2).b)) || (TextUtils.isEmpty(((abi)localObject2).e)) || ((this.d) && (asq.c(this.b, ((abi) localObject2).j))))
              break label325;
            this.f = ((abi)localObject2);
            return null;
          }
        }
        else
        {
          return "No data: " + paramArrayOfBoolean.c;
        }
        localObject1 = "Data might be invalid: " + paramArrayOfBoolean.c;
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        return "Could not parse json: " + paramArrayOfBoolean.c + "\n" + localThrowable.getMessage();
      }
      return "Http result code: " + paramArrayOfBoolean.b;
      label325: i += 1;
    }
  }

  public void a(abr paramabr)
  {
    this.e = paramabr;
  }

  public void a(View paramView)
  {
    paramView.setOnClickListener(this);
    try
    {
      paramView.findViewById(2131755096).setOnClickListener(this);
      label16: if (this.g != null)
        this.g.clear();
      this.g = new WeakReference(paramView);
      if ((this.f != null) && (!TextUtils.isEmpty(this.f.c)))
        arj.a(abd.m, new Runnable() {
          public void run() {
            ard.a(abh.a(abh.this), abh.b(abh.this).c);
          }
        });
      return;
    }
    catch (Throwable localThrowable)
    {
      break label16;
    }
  }

  public void a(View paramView, Runnable paramRunnable)
  {
  }

  protected void a(String paramString)
  {
    if (paramString != null)
    {
      asp.b(a, "Could not fetch affiliate native AD for placement " + abd.d[this.c] + " due to error " + paramString);
      if (!paramString.equals("Cancelled"));
    }
    do
    {
      do
      {
        return;
        vy.a(this.c, 1, 0, abd.a[a()]);
      }
      while (this.e == null);
      this.e.a(this, true, 0, paramString);
      return;
      vy.a(this.c, 1, 1, abd.a[a()]);
    }
    while (this.e == null);
    this.e.a(this, true);
  }

  public void a(boolean paramBoolean)
  {
    executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Boolean[] { Boolean.valueOf(paramBoolean) });
  }

  public void b()
  {
    if ((this.g != null) && (this.g.get() != null));
    try
    {
      ((View)this.g.get()).setOnClickListener(null);
      ((View)this.g.get()).findViewById(2131755096).setOnClickListener(null);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public String c()
  {
    if (this.f == null)
      return null;
    return this.f.i;
  }

  public String d()
  {
    if (this.f == null)
      return null;
    return this.f.f;
  }

  public String e()
  {
    if (this.f == null)
      return null;
    return this.f.h;
  }

  public String f()
  {
    if (this.f == null)
      return null;
    return this.f.k;
  }

  public String g()
  {
    if (this.f == null)
      return null;
    return this.f.d;
  }

  public String h()
  {
    if (this.f == null)
      return null;
    return this.f.l;
  }

  public String i()
  {
    if (this.f == null)
      return null;
    return this.f.e;
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
    if (this.d)
      return 9223372036854775807L;
    return 10800000L;
  }

  public void m()
  {
  }

  public void onClick(View paramView)
  {
    if (this.f == null);
    do
    {
      return;
      asq.i(this.b, this.f.b);
    }
    while (this.e == null);
    this.e.a(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     abh
 * JD-Core Version:    0.6.2
 */