package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.duapps.ad.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class md
  implements Callback, mc
{
  private static md f;
  private ArrayList a;
  private ArrayList b;
  private ArrayList c;
  private ExecutorService d;
  private Context e;
  private volatile boolean g = false;
  private Handler h;
  private Handler i = new me(this, Looper.getMainLooper());

  private md(Context paramContext)
  {
    this.e = paramContext;
    this.a = new ArrayList();
    this.i.sendEmptyMessage(100);
    a();
    this.d = Executors.newFixedThreadPool(3);
    this.c = new ArrayList();
    paramContext = new HandlerThread("inmobiNative", 10);
    paramContext.start();
    this.h = new Handler(paramContext.getLooper(), this);
    this.h.sendEmptyMessageDelayed(1, 10800000L);
    c();
  }

  private static String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
      return null;
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      int j = 0;
      while (j < paramList.size())
      {
        a locala = (a)paramList.get(j);
        localJSONStringer.object();
        localJSONStringer.key("namespace").value(locala.p);
        localJSONStringer.key("contextCode").value(locala.p);
        localJSONStringer.key("ts").value(locala.q);
        localJSONStringer.endObject();
        j += 1;
      }
      localJSONStringer.endArray();
      return localJSONStringer.toString();
    }
    catch (JSONException paramList)
    {
      mv.c("InMobiDataQueue", "toJson exectpion=" + paramList.toString());
    }
    return null;
  }

  private static ArrayList a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        localArrayList.add(new a(localJSONObject.getString("namespace"), localJSONObject.getString("contextCode"), localJSONObject.getLong("ts")));
        j += 1;
      }
    }
    catch (JSONException paramString)
    {
      mv.c("InMobiDataQueue", "fromJson exectpion=" + paramString.toString());
      return null;
    }
    return localArrayList;
  }

  public static md a(Context paramContext)
  {
    try
    {
      if (f == null)
        f = new md(paramContext.getApplicationContext());
      return f;
    }
    finally
    {
    }
    throw paramContext;
  }

  private void a()
  {
    Object localObject = this.e.getSharedPreferences("im_cache_prefs", 0).getString("im_cache_prefs_array", null);
    this.b = new ArrayList();
    if (localObject != null)
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        mv.c("InMobiDataQueue", "arrayList size:" + ((ArrayList) localObject).size());
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          this.b.add(locala);
        }
      }
    }
  }

  private void a(a parama, lv paramlv)
  {
    label260: 
    while (true)
    {
      try
      {
        int k;
        if ((paramlv == lv.a) && (parama.r))
        {
          k = 1;
          if (k != 0)
            mv.c("InMobiDataQueue", "returning:" + parama.p);
        }
        else
        {
          if ((paramlv == lv.b) && (parama.s))
          {
            k = 1;
            continue;
          }
          localObject = this.c.iterator();
          j = 0;
          k = j;
          if (!((Iterator)localObject).hasNext())
            continue;
          locallz = (lz)((Iterator)localObject).next();
          if ((!locallz.a.p.equals(parama.p)) || (locallz.b != paramlv))
            break label260;
          j = 1;
          break label260;
        }
        lz locallz = null;
        Iterator localIterator = this.a.iterator();
        Object localObject = locallz;
        if (localIterator.hasNext())
        {
          localObject = (mi)localIterator.next();
          if (((mi)localObject).c)
            continue;
        }
        parama = new lz(this.e, (mi)localObject, parama, paramlv, this);
        this.c.add(parama);
        if (localObject != null)
        {
          this.d.execute(parama);
          j = 0;
          if ((j == 0) || (this.c.size() != 1))
            continue;
          this.g = true;
          continue;
        }
      }
      finally
      {
      }
      int j = 1;
    }
  }

  private void b()
  {
    Editor localEditor = this.e.getSharedPreferences("im_cache_prefs", 0).edit();
    String str = a(this.b);
    if (!TextUtils.isEmpty(str))
    {
      localEditor.putString("im_cache_prefs_array", str);
      localEditor.apply();
    }
  }

  private void b(a parama, lv paramlv)
  {
    if (parama != null);
    while (true)
    {
      try
      {
        if ((!TextUtils.isEmpty(parama.p)) && (!TextUtils.isEmpty(parama.o)))
        {
          Object localObject = this.b.iterator();
          if (((Iterator)localObject).hasNext())
          {
            locala = (a)((Iterator)localObject).next();
            if (!locala.p.equals(parama.p))
              continue;
            localObject = locala;
            if (locala == null)
            {
              localObject = new a(parama.p, parama.o, parama.q);
              this.b.add(localObject);
            }
            a((a)localObject, paramlv);
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
      }
      a locala = null;
    }
  }

  private void c()
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (l - locala.q < 10800000L)
        localArrayList.add(locala);
    }
    this.b.clear();
    this.b = null;
    this.b = localArrayList;
    b();
  }

  public final void a(a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.p)) || (TextUtils.isEmpty(parama.o)))
    {
      mv.c("InMobiDataQueue", "IMData is null or namespace is null or contextCode is null !");
      return;
    }
    b(parama, lv.a);
  }

  public final void a(lz paramlz)
  {
    int k = 0;
    this.c.remove(paramlz);
    Iterator localIterator = this.b.iterator();
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (a)localIterator.next();
      if (!paramlz.a.p.equals(((a)localObject).p));
    }
    while (true)
    {
      if (localObject != null)
      {
        if (paramlz.b == lv.a)
        {
          ((a)localObject).r = true;
          label78: this.b.set(j, localObject);
          b();
        }
      }
      else
      {
        localIterator = this.c.iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          localObject = (lz)localIterator.next();
        }
        while ((((lz)localObject).c != null) && (((lz)localObject).c.c));
      }
      while (true)
      {
        if ((localObject != null) && (localObject != paramlz))
        {
          j = k;
          if (System.currentTimeMillis() - ((lz)localObject).a.q < 10800000L)
            j = 1;
          if (j == 0)
            this.c.remove(localObject);
        }
        else
        {
          return;
          j += 1;
          break;
          if (paramlz.b != lv.b)
            break label78;
          ((a)localObject).s = true;
          break label78;
        }
        ((lz)localObject).c = ((mi)this.a.get(paramlz.c.b));
        this.d.execute((Runnable)localObject);
        return;
        localObject = null;
      }
      localObject = null;
    }
  }

  public final void b(a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.p)) || (TextUtils.isEmpty(parama.o)))
    {
      mv.c("InMobiDataQueue", "IMData is null or namespace is null or contextCode is null !");
      return;
    }
    b(parama, lv.b);
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 1:
    }
    this.h.removeMessages(1);
    c();
    this.h.sendEmptyMessageDelayed(1, 10800000L);
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     md
 * JD-Core Version:    0.6.2
 */