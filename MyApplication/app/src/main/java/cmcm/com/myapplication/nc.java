package cmcm.com.myapplication;

import android.os.SystemClock;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

final class nc
  implements Runnable
{
  nc(nb paramnb, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ml paramml)
  {
  }

  public final void run()
  {
    long l = SystemClock.elapsedRealtime();
    try
    {
      List localList = mu.a(nb.a(this.g), this.a);
      if (np.a(nb.a(this.g), "com.android.vending"));
      for (Object localObject = "1"; ; localObject = "0")
      {
        localList.add(new BasicNameValuePair("play", (String)localObject));
        localList.add(new BasicNameValuePair("res", "1080*460,244*244,170*170,108*108"));
        localList.add(new BasicNameValuePair("ps", "20"));
        localList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
        localList.add(new BasicNameValuePair("sid", String.valueOf(this.b)));
        localList.add(new BasicNameValuePair("sType", this.c));
        localObject = URLEncodedUtils.format(localList, "UTF-8");
        localObject = new URL(this.d + (String)localObject);
        mv.c("ToolboxCacheManager", "getWall sType :" + this.c + ", Url ->" + ((URL)localObject).toString());
        mj.a((URL)localObject, new nd(this, l), na.e(nb.a(this.g), this.b));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      mv.a("ToolboxCacheManager", "getWall sType :" + this.c + ", parse exception.", localMalformedURLException);
      this.f.a(lb.g.b());
      nr.b(nb.a(this.g), this.b, -102, SystemClock.elapsedRealtime() - l);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     nc
 * JD-Core Version:    0.6.2
 */