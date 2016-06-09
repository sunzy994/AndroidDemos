package cmcm.com.myapplication.com.facebook.ads.internal.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.b.a;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.i;
import com.facebook.ads.internal.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a
{
  private static final String a = c.class.getSimpleName();
  private final Context b;
  private final Uri c;

  public c(Context paramContext, Uri paramUri)
  {
    this.b = paramContext;
    this.c = paramUri;
  }

  private Intent a(i parami)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    if ((!r.a(parami.a())) && (!r.a(parami.b())))
      localIntent.setComponent(new ComponentName(parami.a(), parami.b()));
    if (!r.a(parami.c()))
      localIntent.setData(Uri.parse(parami.c()));
    return localIntent;
  }

  private Intent b(i parami)
  {
    if (r.a(parami.a()))
      return null;
    if (!f.a(this.b, parami.a()))
      return null;
    Object localObject1 = parami.c();
    if ((!r.a((String)localObject1)) && ((((String)localObject1).startsWith("tel:")) || (((String)localObject1).startsWith("telprompt:"))))
      return new Intent("android.intent.action.CALL", Uri.parse((String)localObject1));
    Object localObject2 = this.b.getPackageManager();
    if ((r.a(parami.b())) && (r.a((String)localObject1)))
      return ((PackageManager)localObject2).getLaunchIntentForPackage(parami.a());
    localObject1 = a(parami);
    localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 65536);
    if (((Intent)localObject1).getComponent() == null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (localResolveInfo.activityInfo.packageName.equals(parami.a()))
          ((Intent)localObject1).setComponent(new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
      }
    }
    if ((((List)localObject2).isEmpty()) || (((Intent)localObject1).getComponent() == null))
      return null;
    return localObject1;
  }

  private List<i> f()
  {
    Object localObject = this.c.getQueryParameter("appsite_data");
    if ((r.a((String)localObject)) || ("[]".equals(localObject)))
      localObject = null;
    ArrayList localArrayList;
    while (true)
    {
      return localObject;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONObject((String)localObject).optJSONArray("android");
        localObject = localArrayList;
        if (localJSONArray != null)
        {
          int i = 0;
          while (true)
          {
            localObject = localArrayList;
            if (i >= localJSONArray.length())
              break;
            localObject = i.a(localJSONArray.optJSONObject(i));
            if (localObject != null)
              localArrayList.add(localObject);
            i += 1;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.w(a, "Error parsing appsite_data", localJSONException);
      }
    }
    return localArrayList;
  }

  public b.a a()
  {
    return b.a.a;
  }

  public void b()
  {
    a(this.b, this.c);
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Intent localIntent = (Intent)((Iterator)localObject).next();
        try
        {
          this.b.startActivity(localIntent);
          return;
        }
        catch (Exception localException)
        {
          Log.d(a, "Failed to open app intent, falling back", localException);
        }
      }
    }
    e();
  }

  protected Uri c()
  {
    String str = this.c.getQueryParameter("store_url");
    if (!r.a(str))
      return Uri.parse(str);
    return Uri.parse(String.format("market://details?id=%s", new Object[] { this.c.getQueryParameter("store_id") }));
  }

  protected List<Intent> d()
  {
    Object localObject = f();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Intent localIntent = b((i)((Iterator)localObject).next());
        if (localIntent != null)
          localArrayList.add(localIntent);
      }
    }
    return localArrayList;
  }

  public void e()
  {
    Intent localIntent1 = new Intent("android.intent.action.VIEW", c());
    localIntent1.addFlags(268435456);
    try
    {
      this.b.startActivity(localIntent1);
      return;
    }
    catch (Exception localException1)
    {
      String str;
      do
      {
        Log.d(a, "Failed to open market url: " + this.c.toString(), localException1);
        str = this.c.getQueryParameter("store_url_web_fallback");
      }
      while ((str == null) || (str.length() <= 0));
      Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
      localIntent2.addFlags(268435456);
      try
      {
        this.b.startActivity(localIntent2);
        return;
      }
      catch (Exception localException2)
      {
        Log.d(a, "Failed to open fallback url: " + str, localException2);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.internal.action.c
 * JD-Core Version:    0.6.2
 */