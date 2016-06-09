package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class adi
{
  private static final String a = "Swipe." + adi.class.getSimpleName();
  private static adi b;
  private final Context c;
  private final Handler d;
  private List<adj> e = new ArrayList();
  private List<adj> f = new ArrayList();
  private List<adj> g = new ArrayList();

  public adi(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("leap");
    paramContext.start();
    this.d = new Handler(paramContext.getLooper());
  }

  public static adi a(Context paramContext)
  {
    if (b == null)
      b = new adi(paramContext);
    return b;
  }

  public void a()
  {
    if (!arl.h(this.c));
    final long l1;
    long l2;
    do
    {
      do
        return;
      while (!vg.j);
      l1 = System.currentTimeMillis();
      l2 = vs.b();
    }
    while (((l2 > 0L) && (Math.abs(l2 - l1) < 43200000L)) && ((l1 - aru.a(this.c, "LEAP_ICONS_LAST_SUCCEED_TIME", -1L) < 86400000L) || (l1 - aru.a(this.c, "LEAP_ICONS_LAST_TRY_TIME", -1L) < 3600000L)));
    arj.a(wd.a, new we(this.c) {
      public void a() {
        try {
          aru.b(adi.a(adi.this), "LEAP_ICONS_LAST_TRY_TIME", l1);
          Object localObject = asq.b(asq.v(adi.a(adi.this)));
          localObject = "http://a.lazyswipe.cn/pullropes?" + (String) localObject;
          localObject = ard.a(adi.a(adi.this), (String) localObject);
          if (((arq) localObject).a != arr.a)
            return;
          aru.b(adi.a(adi.this), "LEAP_ICONS_LAST_SUCCEED_TIME", l1);
          localObject = new JSONObject(((arq) localObject).c);
          if ((localObject != null) && (((JSONObject) localObject).optInt("statusCode") == 200)) {
            localObject = ((JSONObject) localObject).optJSONArray("results");
            if (localObject != null) {
              localObject = ((JSONArray) localObject).toString();
              aru.b(adi.a(adi.this), "LEAP_ICONS", (String) localObject);
              adi.this.b();
              return;
            }
          }
        } catch (Exception localException) {
          Log.e(adi.c(), "failed in fetchCloudBlackList.", localException);
        }
      }
    });
  }

  void a(Context paramContext, int paramInt)
  {
    vs.b(paramContext, "PREF_KEY_LAST_SHOWN_ID", paramInt);
  }

  public void b()
  {
    ??? = aru.a(this.c, "LEAP_ICONS", "");
    if (TextUtils.isEmpty((CharSequence)???))
      return;
    while (true)
    {
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int i;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        ??? = new JSONArray((String)???);
        int j = ((JSONArray)???).length();
        i = 0;
        if (i < j)
        {
          adj localadj = adj.a(((JSONArray) ? ??).optJSONObject(i));
          localArrayList1.add(localadj);
          if (adj.a(localadj))
            localArrayList2.add(localadj);
          else
            localArrayList3.add(localadj);
        }
      }
      catch (Exception localException)
      {
        Log.i(a, "loadFromLocal failed", localException);
        return;
      }
      synchronized (this.e)
      {
        this.e.clear();
        this.e.addAll(localException);
        this.f.clear();
        this.f.addAll(localArrayList2);
        this.g.clear();
        this.g.addAll(localArrayList3);
        Log.i(a, "loadFromLocal : mAllInfos [ " + asq.b(this.e) + "]");
        Log.i(a, "loadFromLocal : mDownloadedInfos [ " + asq.b(this.f) + "]");
        Log.i(a, "loadFromLocal : mUnDownloadInfos [ " + asq.b(this.g) + "]");
        return;
      }
      i += 1;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adi
 * JD-Core Version:    0.6.2
 */