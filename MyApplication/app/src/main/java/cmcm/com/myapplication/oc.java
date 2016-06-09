package cmcm.com.myapplication;

import android.content.Context;
import android.os.SystemClock;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

final class oc
  implements Runnable
{
  oc(ob paramob)
  {
  }

  public final void run()
  {
    int i = 0;
    long l = SystemClock.elapsedRealtime();
    try
    {
      Object localObject = ob.a(this.a);
      ob.a(this.a);
      localObject = mu.a((Context)localObject, nm.a());
      ArrayList localArrayList = (ArrayList)nm.a(ob.a(this.a)).b();
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < localArrayList.size())
      {
        localStringBuilder.append(localArrayList.get(i));
        localStringBuilder.append(",");
        i += 1;
      }
      ((List)localObject).add(new BasicNameValuePair("sid", localStringBuilder.toString().substring(0, localStringBuilder.length() - 1)));
      ((List)localObject).add(new BasicNameValuePair("res", "1080*460,244*244,170*170,108*108"));
      localObject = URLEncodedUtils.format((List)localObject, "UTF-8");
      localObject = new URL(ob.a() + (String)localObject);
      mv.c("test", "get src priority url: " + localObject);
      mj.a((URL)localObject, new od(this, l), na.e(ob.a(this.a)));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      nr.a(ob.a(this.a), -102, SystemClock.elapsedRealtime() - l);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     oc
 * JD-Core Version:    0.6.2
 */