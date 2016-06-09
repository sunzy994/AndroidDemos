package cmcm.com.myapplication.com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request.Method;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
{
  private static final Pattern a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
  private final Context b;

  public a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  public final void a(String paramString1, String paramString2)
  {
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)));
    while (true)
    {
      return;
      String str = "0";
      Matcher localMatcher = a.matcher(paramString2);
      if (localMatcher.matches())
        str = localMatcher.group(1);
      int j = StringUtil.parseInteger(str, 0);
      if (j < 509)
        GDTLogger.i("online plugin version is smaller than asset plugin version" + j + ",509" + ".download give up");
      for (int i = 0; i != 0; i = 1)
      {
        paramString2 = new PlainRequest(paramString2, Request.Method.GET, null);
        NetworkClientImpl.getInstance().submit(paramString2, NetworkClient.Priority.High, new a.a(this, paramString1, j));
        return;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.managers.plugin.a
 * JD-Core Version:    0.6.2
 */