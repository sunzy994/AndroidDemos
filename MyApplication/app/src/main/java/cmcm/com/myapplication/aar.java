package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.util.ParcelableSparseIntArray;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class aar
{
  static boolean w;
  final String[] a = new String[abd.e];
  final boolean[] b = new boolean[abd.e];
  final int[][] c = new int[abd.e][];
  final long[] d = new long[abd.e];
  final long[] e = new long[abd.e];
  final long[] f = new long[abd.e];
  final long[] g = new long[abd.e];
  final int[] h = new int[abd.e];
  final SparseIntArray[] i = new SparseIntArray[abd.e];
  final int[] j = new int[abd.e];
  final int[] k = new int[abd.e];
  public final int[] l = new int[abd.e];
  public final String[] m = { "774443062592078_835714899798227", "774443062592078_836557529713964", "774443062592078_841894569180260", "774443062592078_863995743636809", "774443062592078_878341868868863", "", "774443062592078_887583277944722", "774443062592078_841894569180260", "774443062592078_878937405475976", "774443062592078_885784084791308", "774443062592078_885784084791308", "774443062592078_922063601163356", "774443062592078_889727584396958", "774443062592078_927301233972926", "774443062592078_945795168790199", "318456978329294_341745406000451" };
  public final String[] n = { "", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "ca-app-pub-2164674174362877/9045480749", "", "", "", "" };
  final Bundle o = new Bundle(3);
  final Bundle p = new Bundle(4);
  final Bundle[] q = new Bundle[2];
  final Bundle r = new Bundle(2);
  final Bundle s = new Bundle(2);
  final SparseIntArray t = new SparseIntArray(2);
  final Bundle u = new Bundle(1);
  final SparseArray<aau> v = new SparseArray(2);
  String x = "";

  aar()
  {
    this.q[0] = new Bundle(2);
    this.q[1] = new Bundle(2);
    w = vs.r(SwipeApplication.c());
  }

  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configurations:");
    int i1 = 0;
    if (i1 < abd.e)
    {
      localStringBuilder.append("\n\t").append(abd.d[i1]).append(": ").append("enable").append('=').append(this.h[i1]).append(',').append("ttl").append('=').append(this.g[i1]).append(',').append("vendor").append('=').append(asq.a(this.i[i1])).append(',').append("keep").append('=').append(this.k[i1]).append(',').append("step").append('=').append(this.l[i1]);
      if (1 == i1)
        localStringBuilder.append(',').append(this.p);
      while (true)
      {
        i1 += 1;
        break;
        if (2 == i1)
        {
          localStringBuilder.append(',').append(this.o);
        }
        else
        {
          int[] arrayOfInt;
          if (9 == i1)
          {
            localStringBuilder.append(',').append(this.q[0]);
            arrayOfInt = this.u.getIntArray("card1");
            if (arrayOfInt != null)
              localStringBuilder.append(',').append(Arrays.toString(arrayOfInt));
          }
          else if (10 == i1)
          {
            localStringBuilder.append(',').append(this.q[1]);
            arrayOfInt = this.u.getIntArray("card2");
            if (arrayOfInt != null)
              localStringBuilder.append(',').append(Arrays.toString(arrayOfInt));
          }
          else if (13 == i1)
          {
            localStringBuilder.append(',').append(this.r);
          }
          else if (14 == i1)
          {
            localStringBuilder.append(',').append(this.s);
          }
        }
      }
    }
    localStringBuilder.append('\n').append("Global configurations:").append("\n\t").append("cooldown: ").append(this.v.toString()).append("\n\t").append("event").append(": ").append(this.t).append("\n\t").append(this.u).append("hash").append('=').append(this.x);
    return localStringBuilder.toString();
  }

  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    int i1;
    Object localObject2;
    Object localObject3;
    if (this.v.size() <= 0)
    {
      paramContext = vs.a(paramContext);
      i1 = 0;
      if (i1 < abd.a.length)
      {
        localObject2 = paramContext.getStringSet("key_ad_vendor_failure_record_" + i1, null);
        if ((localObject2 == null) || (((Set)localObject2).size() != 2));
        while (true)
        {
          i1 += 1;
          break;
          localObject1 = new aau();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if (((String)localObject3).length() >= 8)
              ((aau)localObject1).d = asi.d((String) localObject3);
            else
              ((aau)localObject1).a = asi.e((String) localObject3);
          }
          this.v.append(i1, localObject1);
        }
      }
    }
    Object localObject1 = this.v.clone();
    this.v.clear();
    paramContext = paramJSONObject.optJSONObject("global");
    if (paramContext == null)
      return;
    paramJSONObject = paramContext.optJSONObject("freeze");
    if (paramJSONObject != null)
    {
      i1 = 0;
      while (i1 < abd.a.length)
      {
        localObject3 = paramJSONObject.optJSONObject(abd.a[i1]);
        if ((localObject3 == null) || (((JSONObject)localObject3).optInt("enable") == 0))
        {
          i1 += 1;
        }
        else
        {
          localObject2 = new aau();
          ((aau)localObject2).b = (((JSONObject)localObject3).optLong("step") * 1000L);
          ((aau)localObject2).c = (((JSONObject)localObject3).optLong("max") * 1000L);
          localObject3 = (aau)((SparseArray)localObject1).get(i1);
          if (localObject3 != null)
            ((aau)localObject2).a = ((aau)localObject3).a;
          for (((aau)localObject2).d = ((aau)localObject3).d; ; ((aau)localObject2).d = 0L)
          {
            this.v.append(i1, localObject2);
            break;
            ((aau)localObject2).a = 0;
          }
        }
      }
    }
    ((SparseArray)localObject1).clear();
    this.t.clear();
    paramJSONObject = paramContext.optJSONObject("debug");
    int i2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("adurl");
      if (paramJSONObject != null)
      {
        i2 = 0;
        if (i2 < abd.a.length)
        {
          localObject1 = paramJSONObject.optJSONObject(abd.a[i2]);
          if ((localObject1 == null) || (((JSONObject)localObject1).optInt("enable") == 0));
          while (true)
          {
            i2 += 1;
            break;
            localObject1 = ((JSONObject)localObject1).optString("event");
            i1 = -1;
            switch (((String)localObject1).hashCode())
            {
            default:
            case 104396:
            case 112798:
            }
            while (true)
              switch (i1)
              {
              default:
                break;
              case 0:
                this.t.append(i2, 2);
                break;
                if (((String)localObject1).equals("imp"))
                {
                  i1 = 0;
                  continue;
                  if (((String)localObject1).equals("req"))
                    i1 = 1;
                }
                break;
              case 1:
              }
            this.t.append(i2, 1);
          }
        }
      }
    }
    this.u.clear();
    paramJSONObject = paramContext.optJSONObject("lucky");
    if (paramJSONObject != null)
      this.u.putInt("layout", paramJSONObject.optInt("layout", 2));
    paramJSONObject = paramContext.optJSONObject("card");
    if (paramJSONObject != null)
    {
      localObject1 = paramJSONObject.optJSONObject("abtest");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("card1");
        if (localObject2 != null)
        {
          i2 = ((JSONArray)localObject2).length();
          localObject3 = new int[i2];
          i1 = 0;
          while (i1 < i2)
          {
            localObject3[i1] = ((JSONArray)localObject2).optInt(i1);
            i1 += 1;
          }
          Arrays.sort((int[])localObject3);
          this.u.putIntArray("card1", (int[])localObject3);
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("card2");
        if (localObject1 != null)
        {
          i2 = ((JSONArray)localObject1).length();
          localObject2 = new int[i2];
          i1 = 0;
          while (i1 < i2)
          {
            localObject2[i1] = ((JSONArray)localObject1).optInt(i1);
            i1 += 1;
          }
          Arrays.sort((int[])localObject2);
          this.u.putIntArray("card2", (int[])localObject2);
        }
      }
      paramJSONObject = paramJSONObject.optJSONObject("olduser");
      if (paramJSONObject != null)
      {
        i1 = paramJSONObject.optInt("skip", 1);
        this.u.putInt("skip", i1);
        i1 = paramJSONObject.optInt("popnew");
        this.u.putInt("popnew", i1);
        i1 = paramJSONObject.optInt("delay", 9999);
        this.u.putLong("delay", i1 * 3600000L);
        i1 = paramJSONObject.optInt("record");
        this.u.putInt("record", i1);
        this.u.putString("seq", paramJSONObject.optString("seq", "0,1,2"));
      }
    }
    this.x = paramContext.optString("hash");
  }

  private void a(JSONObject paramJSONObject)
  {
    this.r.putBoolean("cache_enable", paramJSONObject.optBoolean("cache_enable", true));
    int i1 = paramJSONObject.optInt("delay");
    if (i1 >= 0)
      this.r.putLong("delay", i1 * 3600000L);
  }

  private void a(JSONObject paramJSONObject, int paramInt)
  {
    paramInt -= 9;
    this.q[paramInt].clear();
    int i1 = paramJSONObject.optInt("delay");
    if (i1 >= 0)
      this.q[paramInt].putLong("delay", i1 * 3600000L);
    this.q[paramInt].putLong("gap3g", paramJSONObject.optInt("gap3g") * 1000L);
    i1 = paramJSONObject.optInt("skip");
    this.q[paramInt].putInt("skip", i1);
    i1 = paramJSONObject.optInt("popnew");
    this.q[paramInt].putInt("popnew", i1);
    i1 = paramJSONObject.optInt("record");
    this.q[paramInt].putInt("record", i1);
    this.q[paramInt].putString("seq", paramJSONObject.optString("seq", "0,1,2"));
  }

  private void b(JSONObject paramJSONObject)
  {
    boolean bool = true;
    Bundle localBundle = this.s;
    if (1 == paramJSONObject.optInt("preload", 1));
    while (true)
    {
      localBundle.putBoolean("preload", bool);
      this.s.putLong("duration", 1000L * paramJSONObject.optInt("duration", 20));
      return;
      bool = false;
    }
  }

  private void c(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject.optInt("show_icon") != 0)
    {
      this.o.putBoolean("show_icon", true);
      int i1 = paramJSONObject.optInt("delay");
      if (i1 < 0)
        break label91;
      this.o.putLong("delay", i1 * 3600000L);
      label51: i1 = paramJSONObject.optInt("pre_load", 1);
      paramJSONObject = this.o;
      if (i1 == 0)
        break label104;
    }
    while (true)
    {
      paramJSONObject.putBoolean("pre_load", bool);
      return;
      this.o.remove("show_icon");
      break;
      label91: this.o.remove("delay");
      break label51;
      label104: bool = false;
    }
  }

  private void d(JSONObject paramJSONObject)
  {
    int i3 = 0;
    Object localObject = paramJSONObject.optString("bottle_lang");
    if (!TextUtils.isEmpty((CharSequence)localObject))
      this.p.putString("bottle_lang", (String)localObject);
    int[] arrayOfInt;
    while (true)
    {
      i1 = paramJSONObject.optInt("skip", 1);
      this.p.putInt("skip", i1);
      localObject = paramJSONObject.optJSONObject("ct_percent");
      if (localObject == null)
        break label264;
      arrayOfInt = new int[abd.c];
      i1 = 0;
      while (i1 < abd.c)
      {
        arrayOfInt[i1] = ((JSONObject)localObject).optInt(abd.b[i1]);
        i1 += 1;
      }
      this.p.remove("bottle_lang");
    }
    localObject = new ParcelableSparseIntArray(abd.c);
    int i1 = 0;
    int i2 = 0;
    if (i1 < abd.c)
    {
      if (arrayOfInt[i1] <= 0);
      while (true)
      {
        i1 += 1;
        break;
        i2 += arrayOfInt[i1];
        ((ParcelableSparseIntArray)localObject).append(i1, i2);
      }
    }
    this.p.putParcelable("ct_percent", (Parcelable)localObject);
    localObject = paramJSONObject.optJSONObject("top_percent");
    if (localObject != null)
    {
      paramJSONObject = new int[2];
      paramJSONObject[0] = ((JSONObject)localObject).optInt("ad", 100);
      paramJSONObject[1] = ((JSONObject)localObject).optInt("ct");
      localObject = new ParcelableSparseIntArray(2);
      i2 = 0;
      i1 = i3;
      label242: if (i1 < 2)
      {
        if (paramJSONObject[i1] <= 0);
        while (true)
        {
          i1 += 1;
          break label242;
          localObject = new ParcelableSparseIntArray(1);
          ((ParcelableSparseIntArray)localObject).append(0, 50);
          break;
          i2 += paramJSONObject[i1];
          ((ParcelableSparseIntArray)localObject).append(i1, i2);
        }
      }
      label264: this.p.putParcelable("top_percent", (Parcelable)localObject);
      return;
    }
    this.p.remove("top_percent");
  }

  public void a(Context paramContext, String paramString)
  {
    Arrays.fill(this.a, "http://i.haloapps.com/ads?");
    Arrays.fill(this.b, false);
    Arrays.fill(this.d, 0L);
    Arrays.fill(this.e, 2L);
    Arrays.fill(this.f, 7200000L);
    Arrays.fill(this.c, null);
    Arrays.fill(this.i, null);
    Arrays.fill(this.g, 86400000L);
    Arrays.fill(this.k, 3);
    Arrays.fill(this.j, 0);
    Arrays.fill(this.l, 0);
    Arrays.fill(this.h, 2);
    this.s.putLong("duration", 20000L);
    this.s.putBoolean("preload", true);
    this.p.putInt("skip", 1);
    this.o.putLong("delay", 172800000L);
    this.r.putLong("delay", 86400000L);
    int i1;
    JSONObject localJSONObject1;
    int i3;
    JSONObject localJSONObject2;
    Object localObject1;
    long l1;
    Object localObject2;
    int i2;
    label505: long l2;
    if (!TextUtils.isEmpty(paramString))
    {
      i1 = 0;
      try
      {
        localJSONObject1 = new JSONObject(paramString);
        i3 = 0;
        if (i3 >= abd.e)
          break label862;
        localJSONObject2 = localJSONObject1.optJSONObject(abd.d[i3]);
        if (localJSONObject2 == null)
          break label878;
        localObject1 = localJSONObject2.optString("url");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
          this.a[i3] = localObject1;
        boolean bool = localJSONObject2.optBoolean("random");
        if (bool)
          this.b[i3] = bool;
        l1 = localJSONObject2.optInt("start", 0);
        if (l1 != 0L)
          this.d[i3] = (l1 * 1000L);
        l1 = localJSONObject2.optInt("max", 2);
        if (l1 != 2L)
          this.e[i3] = l1;
        l1 = localJSONObject2.optInt("gap", 7200);
        if (l1 != 7200L)
          this.f[i3] = (l1 * 1000L);
        l1 = localJSONObject2.optInt("ttl", 86400);
        if (l1 != 86400L)
          this.g[i3] = (l1 * 1000L);
        localObject1 = localJSONObject2.optJSONArray("hash");
        if (localObject1 != null)
        {
          i4 = ((JSONArray)localObject1).length();
          localObject2 = new int[i4];
          i2 = 0;
          while (i2 < i4)
          {
            localObject2[i2] = ((JSONArray)localObject1).optInt(i2);
            i2 += 1;
          }
          Arrays.sort((int[])localObject2);
          this.c[i3] = localObject2;
        }
        localObject1 = localJSONObject2.optJSONObject("percent");
        if (localObject1 == null)
          break label871;
        localObject2 = new SparseIntArray(abd.a.length);
        i2 = 0;
        l1 = 0L;
        if (i2 >= abd.a.length)
          break label625;
        int i4 = ((JSONObject)localObject1).optInt(abd.a[i2], -1);
        if (i4 == 0)
        {
          this.j[i3] = i2;
          l2 = l1;
        }
        else
        {
          l2 = l1;
          if (i4 >= 0)
          {
            l2 = l1 + i4;
            ((SparseIntArray)localObject2).append(i2, (int)l2);
          }
        }
      }
      catch (Throwable paramContext)
      {
        asp.a(abd.f, "Could not parse CONFIG string: " + paramString, paramContext);
      }
      label607: aas.a(SwipeApplication.c());
    }
    else
    {
      asp.a(abd.f, a());
      return;
    }
    label625: this.i[i3] = localObject2;
    if ((i1 == 0) && (((SparseIntArray)localObject2).get(1, -1) > 0))
    {
      i2 = 1;
      label652: l1 = localJSONObject2.optInt("keep", 3);
      if (l1 != 3L)
        this.k[i3] = ((int)l1);
      localObject1 = localJSONObject2.optString("fbkey");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
        this.m[i3] = localObject1;
      localObject1 = localJSONObject2.optString("ggkey");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
        this.n[i3] = localObject1;
      this.l[i3] = localJSONObject2.optInt("step");
      this.h[i3] = localJSONObject2.optInt("enable", 2);
      if (2 == i3)
      {
        c(localJSONObject2);
        i1 = i2;
      }
      else
      {
        if (1 != i3)
          break label900;
        d(localJSONObject2);
        i1 = i2;
      }
    }
    label900: 
    while (true)
    {
      label803: a(localJSONObject2, i3);
      i1 = i2;
      label862: label871: label878: 
      do
      {
        if (13 == i3)
        {
          a(localJSONObject2);
          i1 = i2;
        }
        else
        {
          i1 = i2;
          if (14 == i3)
          {
            b(localJSONObject2);
            i1 = i2;
            break label878;
            a(paramContext, localJSONObject1);
            break label607;
            i2 = i1;
            break label652;
          }
        }
        i3 += 1;
        break;
        i2 += 1;
        l1 = l2;
        break label505;
        if (9 == i3)
          break label803;
      }
      while (10 != i3);
    }
  }

  public boolean a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(11);
    long l1 = localCalendar.get(12) + i1 * 60;
    return this.d[paramInt] <= l1 * 60000L;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return (this.l[paramInt1] <= 0) || (paramInt2 >= this.l[paramInt1]);
  }

  public boolean a(int paramInt, long paramLong)
  {
    return this.f[paramInt] < System.currentTimeMillis() - paramLong;
  }

  public boolean a(int paramInt, boolean paramBoolean)
  {
    return (this.h[paramInt] != 0) && ((paramBoolean) || (2 == this.h[paramInt]));
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    return this.e[paramInt1] > paramInt2;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Placement configurations:");
    int i1 = 0;
    if (i1 < abd.e)
    {
      localStringBuilder.append("\n\t").append(abd.d[i1]).append(": ").append("enable").append('=').append(this.h[i1]).append(',').append("url").append('=').append(this.a[i1]).append(',').append("ttl").append('=').append(this.g[i1]).append(',').append("random").append('=').append(this.b[i1]).append(',').append("start").append('=').append(this.d[i1]).append(',').append("max").append('=').append(this.e[i1]).append(',').append("gap").append('=').append(this.f[i1]).append(',').append("hash").append('=').append(Arrays.toString(this.c[i1])).append(',').append("vendor").append('=').append(asq.a(this.i[i1])).append(',').append("keep").append('=').append(this.k[i1]).append(',').append("step").append('=').append(this.l[i1]);
      if (2 == i1)
        localStringBuilder.append(',').append(this.o);
      while (true)
      {
        i1 += 1;
        break;
        if (1 == i1)
        {
          localStringBuilder.append(',').append(this.p);
        }
        else
        {
          int[] arrayOfInt;
          if (9 == i1)
          {
            localStringBuilder.append(',').append(this.q[0]);
            arrayOfInt = this.u.getIntArray("card1");
            if (arrayOfInt != null)
              localStringBuilder.append(',').append(Arrays.toString(arrayOfInt));
          }
          else if (10 == i1)
          {
            localStringBuilder.append(',').append(this.q[1]);
            arrayOfInt = this.u.getIntArray("card2");
            if (arrayOfInt != null)
              localStringBuilder.append(',').append(Arrays.toString(arrayOfInt));
          }
          else if (13 == i1)
          {
            localStringBuilder.append(',').append(this.r);
          }
          else if (14 == i1)
          {
            localStringBuilder.append(',').append(this.s);
          }
        }
      }
    }
    localStringBuilder.append('\n').append("Global configurations:").append("\n\t").append("cooldown: ").append(this.v.toString()).append("\n\t").append("event").append(": ").append(this.t).append("\n\t").append(this.u).append("hash").append('=').append(this.x);
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aar
 * JD-Core Version:    0.6.2
 */