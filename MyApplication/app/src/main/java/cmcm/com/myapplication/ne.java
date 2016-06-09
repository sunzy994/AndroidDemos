package cmcm.com.myapplication;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

final class ne
  implements Runnable
{
  ne(nb paramnb, String paramString1, DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, String paramString4, ml paramml)
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
        localList.add(new BasicNameValuePair("res", String.valueOf(this.h.heightPixels) + "*" + String.valueOf(this.h.widthPixels)));
        localList.add(new BasicNameValuePair("ps", "20"));
        localList.add(new BasicNameValuePair("pn", String.valueOf(this.i)));
        localList.add(new BasicNameValuePair("sid", String.valueOf(this.b)));
        localList.add(new BasicNameValuePair("sType", this.c));
        localList.add(new BasicNameValuePair("aSize", String.valueOf(this.j)));
        localList.add(new BasicNameValuePair("ua", mw.b));
        localObject = URLEncodedUtils.format(localList, "UTF-8");
        localObject = new URL(this.d + (String)localObject);
        mv.c("ToolboxCacheManager", "getOnlineWall sType :" + this.c + ", Url ->" + ((URL)localObject).toString());
        mj.a((URL)localObject, new nf(this, l), na.e(nb.a(this.g), this.b));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      mv.a("ToolboxCacheManager", "getWall sType :" + this.c + ", parse exception.", localMalformedURLException);
      this.f.a(lb.g.b());
      nr.d(nb.a(this.g), this.b, -102, SystemClock.elapsedRealtime() - l);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ne
 * JD-Core Version:    0.6.2
 */