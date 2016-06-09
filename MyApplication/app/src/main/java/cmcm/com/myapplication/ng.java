package cmcm.com.myapplication;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

final class ng
  implements Runnable
{
  ng(nb paramnb, String paramString1, int paramInt, String paramString2, String paramString3, ml paramml)
  {
  }

  public final void run()
  {
    long l = SystemClock.elapsedRealtime();
    try
    {
      List localList = mu.a(nb.a(this.d), this.a);
      if (np.a(nb.a(this.d), "com.android.vending"));
      for (Object localObject = "1"; ; localObject = "0")
      {
        localList.add(new BasicNameValuePair("play", (String)localObject));
        localList.add(new BasicNameValuePair("res", "1080*460,244*244,170*170,108*108"));
        localList.add(new BasicNameValuePair("ps", "20"));
        localList.add(new BasicNameValuePair("pn", String.valueOf(1)));
        localList.add(new BasicNameValuePair("sid", String.valueOf(this.b)));
        localList.add(new BasicNameValuePair("sType", "native"));
        localList.add(new BasicNameValuePair("or", String.valueOf(mp.j(nb.a(this.d)))));
        localList.add(new BasicNameValuePair("siteId", this.e));
        localList.add(new BasicNameValuePair("aSize", this.f));
        String str = System.getProperty("http.agent");
        localObject = str;
        if (TextUtils.isEmpty(str))
          localObject = "dianxinosdxbs/3.2 (Linux; Android; Tapas OTA) Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.18) Gecko/20110628 Ubuntu/10.04 (lucid) Firefox/3.6.18";
        localList.add(new BasicNameValuePair("ua", (String)localObject));
        localObject = URLEncodedUtils.format(localList, "UTF-8");
        localObject = new URL(nb.b() + (String)localObject);
        mv.c("ToolboxCacheManager", "getInmobiNativeAds sType :native, Url ->" + ((URL)localObject).toString());
        mj.a((URL)localObject, new nh(this, l), na.e(nb.a(this.d), this.b));
        na.b(nb.b() + this.b, nb.a(this.d));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      mv.a("ToolboxCacheManager", "getInmobiNativeAds sType :native, parse exception.", localMalformedURLException);
      this.c.a(lb.g.b());
      nr.c(nb.a(this.d), this.b, -102, SystemClock.elapsedRealtime() - l);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ng
 * JD-Core Version:    0.6.2
 */