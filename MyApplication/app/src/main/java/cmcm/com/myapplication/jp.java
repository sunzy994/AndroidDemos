package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

class jp
  implements Runnable
{
  Map<String, String> a;
  boolean b;
  private String c;
  private WeakReference<Context> d = null;

  private jp(String paramString, Map<String, String> paramMap, Context paramContext, boolean paramBoolean)
  {
    this.c = paramString;
    this.a = paramMap;
    this.d = new WeakReference(paramContext);
    this.b = paramBoolean;
  }

  public void run()
  {
    String str = jl.a(this.a);
    while (true)
    {
      try
      {
        Object localObject1 = (Context)this.d.get();
        if (localObject1 != null)
        {
          localObject2 = jq.a().a((Context)localObject1);
          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (this.a.get("referrer") == null))
            this.a.put("referrer", localObject2);
          boolean bool2 = "true".equals(((Context)localObject1).getSharedPreferences("appsflyer-data", 0).getString("sentSuccessfully", ""));
          localObject2 = (String)this.a.get("eventName");
          Map localMap = this.a;
          if (localObject2 != null)
            break label357;
          bool1 = true;
          localMap.put("counter", Integer.toString(jl.a((Context)localObject1, bool1)));
          bool1 = bool2;
          localObject1 = this.a;
          if (bool1)
            break label363;
          bool1 = true;
          ((Map)localObject1).put("isFirstCall", Boolean.toString(bool1));
          localObject2 = (String)this.a.get("appsflyerKey");
          if ((localObject2 == null) || (((String)localObject2).length() == 0))
          {
            Log.d(str, "Not sending data yet, waiting for dev key");
            return;
          }
          localObject1 = new jv().a(this.a);
          this.a.put("af_v", localObject1);
          localObject1 = jl.b(this.a);
          try
          {
            jl.a(this.c, (String)localObject1, (String)localObject2, this.d, null, str, this.b);
            return;
          }
          catch (IOException localIOException2)
          {
            localObject2 = localObject1;
            localObject1 = localIOException2;
          }
          if ((localObject2 == null) || (this.d == null) || (this.c.contains("&isCachedRequest=true")))
            break label356;
          Log.e(str, ((IOException)localObject1).getMessage(), (Throwable)localObject1);
          jx.a().a(new jy(this.c, (String)localObject2, "1.13"), (Context)this.d.get());
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e(str, localThrowable.getMessage(), localThrowable);
        return;
      }
      catch (IOException localIOException1)
      {
        Object localObject2 = null;
        continue;
        bool1 = false;
        continue;
      }
      label356: return;
      label357: boolean bool1 = false;
      continue;
      label363: bool1 = false;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jp
 * JD-Core Version:    0.6.2
 */