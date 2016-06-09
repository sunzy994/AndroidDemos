package cmcm.com.myapplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class kr
{
  public static String a(Context paramContext)
  {
    kx.c("DF_HTTP", "sendAppsflyer start .............");
    StringBuilder localStringBuilder;
    HashMap localHashMap;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    Iterator localIterator;
    int j;
    boolean bool;
    while (true)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localHashMap = new HashMap();
        localObject4 = paramContext.getPackageManager().getInstalledPackages(4096);
        localObject1 = "0";
        localObject3 = "0";
        localObject2 = "0";
        localIterator = ((List)localObject4).iterator();
        if (localIterator.hasNext())
        {
          localObject4 = (PackageInfo)localIterator.next();
          if (((PackageInfo)localObject4).packageName.equals("com.google.android.gms"))
          {
            localObject4 = "1";
            localObject1 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
            break label2632;
          }
          if (((PackageInfo)localObject4).packageName.equals("com.android.vending"))
          {
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = "1";
            break label2632;
          }
          if (!((PackageInfo)localObject4).packageName.equals("com.facebook.katana"))
            break label2622;
          localObject4 = "1";
          localObject2 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
          break label2632;
        }
        localHashMap.put("hags", URLEncoder.encode((String)localObject1));
        localStringBuilder.append("?hags=" + URLEncoder.encode((String)localObject1));
        localHashMap.put("hagp", URLEncoder.encode((String)localObject3));
        localStringBuilder.append("&hagp=" + URLEncoder.encode((String)localObject3));
        localHashMap.put("hafb", URLEncoder.encode((String)localObject2));
        localStringBuilder.append("&hafb=" + URLEncoder.encode((String)localObject2));
        localObject1 = paramContext.getPackageName();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("pkg", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&pkg=" + URLEncoder.encode((String)localObject1));
        }
        localObject1 = kv.a().c();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("w", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&w=" + URLEncoder.encode((String)localObject1));
        }
        localObject1 = ky.j(paramContext);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("n", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&n=" + URLEncoder.encode((String)localObject1));
        }
        i = ky.b(ky.a(paramContext)) / 100;
        localObject1 = (String)kn.d.get(i, "UN");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("iso", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&iso=" + URLEncoder.encode((String)localObject1));
        }
        localObject1 = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("lang", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&lang=" + URLEncoder.encode((String)localObject1));
        }
        localObject1 = kv.a().d();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localHashMap.put("pdtid", URLEncoder.encode((String)localObject1));
          localStringBuilder.append("&pdtid=" + URLEncoder.encode((String)localObject1));
          i = 0;
          localObject1 = kv.a().g();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localHashMap.put("pvc", URLEncoder.encode((String)localObject1));
            localStringBuilder.append("&pvc=" + URLEncoder.encode((String)localObject1));
            localObject1 = kv.a().b();
            if (TextUtils.isEmpty((CharSequence)localObject1))
              continue;
            localHashMap.put("u", URLEncoder.encode((String)localObject1));
            localStringBuilder.append("&u=" + URLEncoder.encode((String)localObject1));
            localObject1 = kv.a().h();
            if (TextUtils.isEmpty((CharSequence)localObject1))
              continue;
            localHashMap.put("par1", URLEncoder.encode((String)localObject1));
            localStringBuilder.append("&par1=" + URLEncoder.encode((String)localObject1));
            localObject1 = kv.a().i();
            if (TextUtils.isEmpty((CharSequence)localObject1))
              continue;
            localHashMap.put("par2", URLEncoder.encode((String)localObject1));
            localStringBuilder.append("&par2=" + URLEncoder.encode((String)localObject1));
            localObject1 = ky.d();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("b", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&b=" + URLEncoder.encode((String)localObject1));
            }
            localObject1 = ky.a();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("m", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&m=" + URLEncoder.encode((String)localObject1));
            }
            localObject1 = String.valueOf(ky.b());
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("aos", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&aos=" + URLEncoder.encode((String)localObject1));
            }
            localObject1 = ky.c();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("aon", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&aon=" + URLEncoder.encode((String)localObject1));
            }
            localObject1 = ky.a(paramContext);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("o", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&o=" + URLEncoder.encode((String)localObject1));
            }
            localObject2 = kv.a().f();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localHashMap.put("cid", URLEncoder.encode((String)localObject2));
              localStringBuilder.append("&cid=" + URLEncoder.encode((String)localObject2));
            }
            localObject1 = kv.a().t();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localHashMap.put("gaid", URLEncoder.encode((String)localObject1));
              localStringBuilder.append("&gaid=" + URLEncoder.encode((String)localObject1));
            }
            j = kv.a().u();
            localHashMap.put("ladt", URLEncoder.encode(String.valueOf(j)));
            localStringBuilder.append("&ladt=" + URLEncoder.encode(String.valueOf(j)));
            if (i == 0)
              continue;
            return "notEnoughParameters";
          }
        }
        else
        {
          kx.c("DF_HTTP", "pdtid notEnoughParameters");
          i = 1;
          continue;
        }
        kx.c("DF_HTTP", "pvc notEnoughParameters");
        i = 1;
        continue;
        kx.c("DF_HTTP", "getUseId notEnoughParameters");
        i = 1;
        continue;
        kx.c("DF_HTTP", "par1 notEnoughParameters");
        i = 1;
        continue;
        kx.c("DF_HTTP", "par2 notEnoughParameters");
        i = 1;
        continue;
        localObject1 = kv.a().b(paramContext);
        localObject3 = new kz(paramContext);
        bool = ((kz)localObject3).e();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
          break;
        localObject1 = kv.a().s();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (kv.a().r()))
        {
          localHashMap.put("c", URLEncoder.encode((String)localObject2));
          localStringBuilder.append("&c=" + URLEncoder.encode((String)localObject2));
          localObject2 = ku.a("0zRm7PbpmpBrWXCDkUPkCQXKIMJmaLN0r", kv.a().b() + "tgpPPsiJWz2LF8Vv8" + (String) localObject2);
          localHashMap.put("aq_tranid", URLEncoder.encode((String)localObject2));
          localStringBuilder.append("&aq_tranid=" + URLEncoder.encode((String)localObject2));
        }
        if ((!bool) || (!kv.a().o()))
        {
          if (!kv.a().r())
            break label2650;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
            break label2645;
          localObject2 = "Promotion";
          label1590: localHashMap.put("pid", URLEncoder.encode((String)localObject2));
          localObject4 = new StringBuilder().append("&pid=");
          if (!kv.a().r())
            break label2657;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
            localObject2 = "Promotion";
          label1642: localStringBuilder.append(URLEncoder.encode((String)localObject2));
          localHashMap.put("af_status", URLEncoder.encode("Organic_up"));
          localStringBuilder.append("&af_status=" + URLEncoder.encode("Organic_up"));
          localObject2 = kl.a();
          localObject4 = new StringBuilder().append(URLDecoder.decode((String)localHashMap.get("pid"))).append(",");
          if (!TextUtils.isEmpty((CharSequence)localHashMap.get("c")))
            break label2575;
          localObject1 = "";
          label1769: localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",");
          if (!TextUtils.isEmpty((CharSequence)localHashMap.get("clickid")))
            break label2595;
          localObject1 = "";
          label1806: ((kl)localObject2).a(paramContext, "pid_c", URLEncoder.encode((String)localObject1));
          ((kz)localObject3).a();
          kx.c("DF_HTTP", "sendAppsflyer url:" + "http://stat.haloapps.com/install" + localStringBuilder);
          paramContext = kq.b("http://stat.haloapps.com/install", localHashMap, null);
          kx.c("DF_HTTP", "sendAppsflyer resp code:" + paramContext.getStatusLine().getStatusCode());
          if (paramContext.getStatusLine().getStatusCode() == 200)
            break label2615;
          return "false";
        }
        if (!kv.a().r())
          break label2119;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = "Promotion";
          localHashMap.put("pid", URLEncoder.encode((String)localObject2));
          localObject4 = new StringBuilder().append("&pid=");
          if (!kv.a().r())
            break label2664;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
            localObject2 = "Promotion";
          label2000: localStringBuilder.append(URLEncoder.encode((String)localObject2));
          if (!kv.a().r())
            break label2671;
          localObject1 = "Non-organic";
          label2031: localHashMap.put("af_status", URLEncoder.encode((String)localObject1));
          localObject2 = new StringBuilder().append("&af_status=");
          if (!kv.a().r())
            break label2678;
          localObject1 = "Non-organic";
          label2073: localStringBuilder.append(URLEncoder.encode((String)localObject1));
          continue;
        }
      }
      catch (Exception paramContext)
      {
        if (kn.a)
          Log.w("system.err", paramContext);
        paramContext.printStackTrace();
        return null;
      }
      localObject2 = localObject1;
      continue;
      label2119: localObject2 = "Organic";
    }
    Object localObject4 = ((String)localObject1).split("&");
    int n = localObject4.length;
    int k = 0;
    int m;
    for (int i = 0; ; i = m)
    {
      if (k < n)
      {
        localObject1 = localObject4[k].split("=");
        m = i;
        if (localObject1.length != 2)
          break label2685;
        localIterator = localObject1[0];
        localObject1 = localObject1[1];
        j = i;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(localIterator))
        {
          j = i;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!localIterator.toString().trim().equals("pid".toString().trim()))
              break label2350;
            i = 1;
          }
        }
      }
      label2575: label2595: 
      while (true)
      {
        localHashMap.put(localIterator, URLEncoder.encode((String)localObject1));
        localStringBuilder.append("&" + localIterator + "=" + URLEncoder.encode((String)localObject1));
        localObject2 = localObject1;
        j = i;
        m = j;
        if (!kn.a)
          break label2685;
        kx.c("DF_HTTP", "sendAppsflyer referrers key:" + localIterator + "=" + (String) localObject2);
        m = j;
        break label2685;
        label2350: if (localIterator.toString().trim().equals("aq_tranid".toString().trim()))
        {
          localObject1 = ku.a((String) localObject1, kv.a().b() + "tgpPPsiJWz2LF8Vv8");
          continue;
          if (i == 0)
          {
            localHashMap.put("pid", URLEncoder.encode("unkown"));
            localStringBuilder.append("&pid=" + URLEncoder.encode("unkown"));
          }
          if ((!bool) || (!kv.a().o()))
          {
            localHashMap.put("af_status", URLEncoder.encode("Organic_up"));
            localStringBuilder.append("&af_status=" + URLEncoder.encode("Organic_up"));
            break;
          }
          localHashMap.put("af_status", URLEncoder.encode("Non-organic"));
          localStringBuilder.append("&af_status=" + URLEncoder.encode("Non-organic"));
          break;
          localObject1 = URLDecoder.decode((String)localHashMap.get("c"));
          break label1769;
          localObject1 = URLDecoder.decode((String)localHashMap.get("clickid"));
          break label1806;
          label2615: return "ok";
        }
      }
      label2622: localObject4 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject4;
      label2632: localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      break;
      label2645: localObject2 = localObject1;
      break label1590;
      label2650: localObject2 = "Organic_up";
      break label1590;
      label2657: localObject2 = "Organic_up";
      break label1642;
      label2664: localObject2 = "Organic";
      break label2000;
      label2671: localObject1 = "Organic";
      break label2031;
      label2678: localObject1 = "Organic";
      break label2073;
      label2685: k += 1;
    }
  }

  public static String a(String paramString)
  {
    while (true)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          if (kn.a)
            Log.w("DF_HTTP", "sendErr 无userId.........");
        }
        else
        {
          if (kv.a().a == null)
          {
            if (!kn.a)
              break label271;
            Log.w("DF_HTTP", "sendErr 未获取内部存储路径.........");
            break label271;
          }
          HashMap localHashMap = new HashMap();
          String str2 = kv.a().d();
          String str3 = kv.a().f();
          String str4 = kv.a().g();
          localHashMap.put("uid", paramString);
          localHashMap.put("pid", str2);
          localHashMap.put("cid", str3);
          localHashMap.put("vc", str4);
          if (!kv.a().k())
            break label275;
          str1 = "http://st.lazyswipe.com/r";
          if (kn.a)
            Log.v("DF_HTTP", "sendReal url: " + str1 + "?uid=" + paramString + "&pid=" + str2 + "&cid=" + str3 + "&vc=" + str4);
          if (kq.b(str1, localHashMap, null).getStatusLine().getStatusCode() != 200)
            return "false";
          return "ok";
        }
      }
      catch (Exception paramString)
      {
        if (kn.a)
          Log.w("system.err", paramString);
        paramString.printStackTrace();
        return "";
      }
      return "";
      label271: return "";
      label275: String str1 = "http://st.lazyswipe.cn/r";
    }
  }

  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        if (!kn.a)
          break label192;
        Log.w("DF_HTTP", "requestSendRule 无userId.........");
        return null;
      }
      if (kv.a().a == null)
      {
        if (!kn.a)
          break label192;
        Log.w("DF_HTTP", "requestSendRule 未获取内部存储路径.........");
        return null;
      }
    }
    catch (Exception paramString1)
    {
      if (kn.a)
        Log.w("system.err", paramString1);
      paramString1.printStackTrace();
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", paramString1);
    localHashMap.put("sdk", String.valueOf(3));
    if (!TextUtils.isEmpty(paramString3));
    while (true)
    {
      if (kn.a)
        Log.v("DF_HTTP", "requestSendRule url:" + paramString3);
      paramString1 = kq.a(paramString3, localHashMap, paramString4);
      if (kn.a)
        kx.c("DF_HTTP", "requestSendRule result:" + paramString1);
      return paramString1;
      paramString3 = paramString2;
    }
    label192: return null;
  }

  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        if (kn.a)
          Log.w("DF_HTTP", "sendData 无userId.........");
      }
      else
      {
        if (kv.a().a == null)
        {
          if (!kn.a)
            break label478;
          Log.w("DF_HTTP", "sendData 未获取内部存储路径.........");
          break label478;
        }
        String str1 = paramString2;
        if (paramBoolean)
          str1 = ky.a(paramString1, paramString2);
        long l = str1.getBytes().length;
        paramString2 = ky.a(ky.d(str1), str1.getBytes());
        if (kn.a)
        {
          kx.c("DF_HTTP", "sendData bytes: " + str1);
          kx.c("DF_HTTP", "sendData url:" + paramString3);
        }
        str1 = kv.a().d();
        String str2 = kv.a().g();
        String str3 = kv.a().f();
        HashMap localHashMap = new HashMap();
        localHashMap.put("userId", paramString1);
        localHashMap.put("pid", str1);
        if (paramBoolean)
        {
          localHashMap.put("vc", str2);
          localHashMap.put("cid", str3);
          if (kv.a().w() != null)
            localHashMap.put("net", ky.j(kv.a().w()));
        }
        localHashMap.put("iso", paramString5);
        localHashMap.put("ver", String.valueOf(3));
        localHashMap.put("len", String.valueOf(l));
        if (kn.a)
          kx.c("DF_HTTP", "sendData pa:" + paramString1 + " , " + str1 + " , " + str2 + " , " + str3 + " , " + paramString5 + " , " + String.valueOf(3) + " , " + String.valueOf(l));
        paramString2 = kq.a(paramString3, localHashMap, paramString2, paramString4);
        paramString1 = paramString2;
        if (!kn.a)
          break label476;
        kx.c("DF_HTTP", "sendData result:" + paramString2);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      if (kn.a)
        Log.w("system.err", paramString1);
      paramString1.printStackTrace();
      return null;
    }
    paramString1 = null;
    label476: return paramString1;
    label478: return null;
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("hc", paramString2);
      localHashMap.put("ct", kv.a().c());
      localHashMap.put("op", ky.a(paramContext));
      localHashMap.put("net", ky.j(paramContext));
      localHashMap.put("uid", paramString1);
      localHashMap.put("pid", kv.a().d());
      localHashMap.put("at", paramString3);
      if (kv.a().k());
      for (String str = "http://gbsta.haloall.com/err"; ; str = "http://sta.haloall.com/err")
      {
        if (kn.a)
          Log.v("DF_HTTP", "send360 url:" + str + "?hc=" + paramString2 + "&ct=" + kv.a().c() + "&op=" + ky.a(paramContext) + "&net=" + ky.j(paramContext) + "&uid=" + paramString1 + "&pid=" + kv.a().d() + "&at=" + paramString3);
        paramContext = kq.a(str, localHashMap, null);
        if (!kn.a)
          break;
        kx.c("DF_HTTP", "send360 result:" + paramContext);
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (kn.a)
        Log.w("system.err", paramContext);
      paramContext.printStackTrace();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     kr
 * JD-Core Version:    0.6.2
 */